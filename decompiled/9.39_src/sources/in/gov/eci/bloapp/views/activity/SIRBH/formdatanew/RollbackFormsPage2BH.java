package in.gov.eci.bloapp.views.activity.SIRBH.formdatanew;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityRollbackFormsPage2BhBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class RollbackFormsPage2BH extends SuperBaseActivity {
    Date DoB;
    String aadharNo;
    String actualDateOfBirthS;
    AlertDialog alertDialog;
    String annexref;
    private String asmblyNO;
    private String atkband;
    ActivityRollbackFormsPage2BhBinding binding;
    Bundle bundle;
    String choice;
    String citizenshipTypeCatTemp;
    Date dateAfter;
    Date dateBefore;
    Date dateRange;
    String dob;
    Date dobElector;
    String dobTemp;
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
    String list1;
    String list1Code;
    String list2;
    String list2code;
    String list3code;
    String list4code;
    String list5code;
    String list6;
    String list6code;
    String list7;
    String list7code;
    String list8code;
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
    String spouseEpic;
    String spouseName;
    private String state;
    String surveyChannel;
    String temp;
    private String token;
    CommomUtility commomUtility = new CommomUtility();
    String TAG = "RollbackFormsPage2BH";
    String takephoto = "";
    String oldAcS = "";
    String OldPartS = "";
    String OldPslS = "";
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
    private String submitFlag = null;
    String list3 = "LIST-3";
    String list4 = "LIST-4";
    String list5 = "LIST-5";
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
    String supportingDocumentPage1UrlS = "";
    String supportingDocumentPage2UrlS = "";
    String selectRelationType = "";
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
    String comingTag = "coming in onFailure";
    String messageString = "message";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        Date date;
        super.onCreate(savedInstanceState);
        ActivityRollbackFormsPage2BhBinding activityRollbackFormsPage2BhBindingInflate = ActivityRollbackFormsPage2BhBinding.inflate(getLayoutInflater());
        this.binding = activityRollbackFormsPage2BhBindingInflate;
        setContentView(activityRollbackFormsPage2BhBindingInflate.getRoot());
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
        this.binding.textView3.setSelected(true);
        try {
            this.dateBefore = this.simple1.parse("01/07/1987");
            this.dateAfter = this.simple1.parse("02/12/2004");
        } catch (Exception e) {
            Logger.d("RollbackFormsPage2BH dob parse", e.toString());
        }
        clearLists();
        Bundle extras = getIntent().getExtras();
        this.bundle = extras;
        if (extras != null) {
            this.choice = extras.getString("radio_choice");
            this.dob = this.bundle.getString("dobverified");
            this.citizenshipTypeCatTemp = this.bundle.getString("citizenshipTypeCat");
            this.actualDateOfBirthS = this.bundle.getString("ActualDateOfBirth");
            String str = this.choice;
            if (str != null) {
                if (str.equalsIgnoreCase(getString(R.string.indian_citizen_by))) {
                    this.List8docName.clear();
                    this.List8docCode.clear();
                    this.IRFlag = "Y";
                    this.cat = "CAT-1";
                    AlertDialog alertDialog = this.alertDialog;
                    if (alertDialog != null) {
                        alertDialog.show();
                        getList1("LIST-8");
                    }
                    callIRFields();
                    this.binding.radioLayout.setVisibility(8);
                    this.binding.intensiveRevisionLayout.setVisibility(0);
                    this.binding.llBefore1987.setVisibility(8);
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.born_india))) {
                    this.simple.setLenient(false);
                    this.binding.layoutVerifyDetails.setVisibility(8);
                    if (this.dob == null && this.actualDateOfBirthS == null) {
                        this.binding.radioLayout.setVisibility(0);
                        this.binding.llBefore1987.setVisibility(8);
                        this.binding.intensiveRevisionLayout.setVisibility(8);
                        this.binding.llBefore1987.setVisibility(8);
                        this.binding.llBefore2004.setVisibility(8);
                        this.binding.llAfter2004.setVisibility(8);
                        this.binding.llBornOutOfIndia.setVisibility(8);
                        this.binding.llAcquired.setVisibility(8);
                        this.binding.radioLayout.setVisibility(0);
                        if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-2")) {
                            this.cat = "CAT-2";
                            this.list1 = "LIST-1";
                            AlertDialog alertDialog2 = this.alertDialog;
                            if (alertDialog2 != null) {
                                alertDialog2.show();
                                getList1(this.list1);
                            }
                            this.binding.bornBefore1987rb.setChecked(true);
                            this.binding.intensiveRevisionLayout.setVisibility(8);
                            this.binding.llBefore1987.setVisibility(0);
                            this.binding.llBefore2004.setVisibility(8);
                            this.binding.llAfter2004.setVisibility(8);
                            this.binding.llBornOutOfIndia.setVisibility(8);
                            this.binding.llAcquired.setVisibility(8);
                        } else if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-3")) {
                            this.cat = "CAT-3";
                            this.list1 = "LIST-1";
                            AlertDialog alertDialog3 = this.alertDialog;
                            if (alertDialog3 != null) {
                                alertDialog3.show();
                                getList1(this.list1);
                            }
                            this.binding.bornBefore2004rb.setChecked(true);
                            this.binding.intensiveRevisionLayout.setVisibility(8);
                            this.binding.llBefore1987.setVisibility(8);
                            this.binding.llBefore2004.setVisibility(0);
                            this.binding.llAfter2004.setVisibility(8);
                            this.binding.llBornOutOfIndia.setVisibility(8);
                            this.binding.llAcquired.setVisibility(8);
                        } else if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-4")) {
                            this.cat = "CAT-4";
                            this.list1 = "LIST-1";
                            AlertDialog alertDialog4 = this.alertDialog;
                            if (alertDialog4 != null) {
                                alertDialog4.show();
                                getList1(this.list1);
                            }
                            this.binding.bornAfter2004rb.setChecked(true);
                            this.binding.intensiveRevisionLayout.setVisibility(8);
                            this.binding.llBefore1987.setVisibility(8);
                            this.binding.llBefore2004.setVisibility(8);
                            this.binding.llAfter2004.setVisibility(0);
                            this.binding.llBornOutOfIndia.setVisibility(8);
                            this.binding.llAcquired.setVisibility(8);
                        }
                    } else if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-2") && this.dob.equals(this.actualDateOfBirthS)) {
                        this.binding.radioLayout.setVisibility(8);
                        this.cat = "CAT-2";
                        this.list1 = "LIST-1";
                        this.binding.intensiveRevisionLayout.setVisibility(8);
                        this.binding.llBefore1987.setVisibility(0);
                        AlertDialog alertDialog5 = this.alertDialog;
                        if (alertDialog5 != null) {
                            alertDialog5.show();
                            getList1(this.list1);
                        }
                        this.binding.llBefore2004.setVisibility(8);
                        this.binding.llAfter2004.setVisibility(8);
                        this.binding.llBornOutOfIndia.setVisibility(8);
                        this.binding.llAcquired.setVisibility(8);
                    } else if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-3") && this.dob.equals(this.actualDateOfBirthS)) {
                        this.binding.radioLayout.setVisibility(8);
                        this.cat = "CAT-3";
                        this.list1 = "LIST-1";
                        this.binding.intensiveRevisionLayout.setVisibility(8);
                        this.binding.llBefore1987.setVisibility(8);
                        AlertDialog alertDialog6 = this.alertDialog;
                        if (alertDialog6 != null) {
                            alertDialog6.show();
                            getList1(this.list1);
                        }
                        this.binding.llBefore2004.setVisibility(0);
                        this.binding.llAfter2004.setVisibility(8);
                        this.binding.llBornOutOfIndia.setVisibility(8);
                        this.binding.llAcquired.setVisibility(8);
                    } else if (!TextUtils.isEmpty(this.citizenshipTypeCatTemp) && this.citizenshipTypeCatTemp.equals("CAT-4") && this.dob.equals(this.actualDateOfBirthS)) {
                        this.binding.radioLayout.setVisibility(8);
                        this.cat = "CAT-4";
                        this.list1 = "LIST-1";
                        this.binding.intensiveRevisionLayout.setVisibility(8);
                        this.binding.llBefore1987.setVisibility(8);
                        AlertDialog alertDialog7 = this.alertDialog;
                        if (alertDialog7 != null) {
                            alertDialog7.show();
                            getList1(this.list1);
                        }
                        this.binding.llParentLayout.setVisibility(8);
                        this.binding.llBefore2004.setVisibility(8);
                        this.binding.llBefore2004.setVisibility(8);
                        this.binding.llAfter2004.setVisibility(0);
                        this.binding.llBornOutOfIndia.setVisibility(8);
                        this.binding.llAcquired.setVisibility(8);
                    } else {
                        String str2 = this.dob;
                        if (str2 != null && !str2.isEmpty()) {
                            this.binding.radioLayout.setVisibility(8);
                            try {
                                this.DoB = this.simple.parse(this.dob.trim());
                            } catch (ParseException e2) {
                                Logger.d("RollbackFormsPage2BH", e2.toString());
                            }
                            Date date2 = this.DoB;
                            if (date2 != null && (date = this.dateBefore) != null) {
                                if (date2.before(date)) {
                                    this.cat = "CAT-2";
                                    this.list1 = "LIST-1";
                                    this.binding.intensiveRevisionLayout.setVisibility(8);
                                    this.binding.llBefore1987.setVisibility(0);
                                    AlertDialog alertDialog8 = this.alertDialog;
                                    if (alertDialog8 != null) {
                                        alertDialog8.show();
                                        getList1(this.list1);
                                    }
                                    this.binding.llBefore2004.setVisibility(8);
                                    this.binding.llAfter2004.setVisibility(8);
                                    this.binding.llBornOutOfIndia.setVisibility(8);
                                    this.binding.llAcquired.setVisibility(8);
                                } else if (this.DoB.before(this.dateAfter) && this.DoB.after(this.dateBefore)) {
                                    this.cat = "CAT-3";
                                    this.list1 = "LIST-1";
                                    this.binding.intensiveRevisionLayout.setVisibility(8);
                                    this.binding.llBefore1987.setVisibility(8);
                                    AlertDialog alertDialog9 = this.alertDialog;
                                    if (alertDialog9 != null) {
                                        alertDialog9.show();
                                        getList1(this.list1);
                                    }
                                    this.binding.llBefore2004.setVisibility(0);
                                    this.binding.llAfter2004.setVisibility(8);
                                    this.binding.llBornOutOfIndia.setVisibility(8);
                                    this.binding.llAcquired.setVisibility(8);
                                } else if (this.DoB.after(this.dateAfter)) {
                                    this.cat = "CAT-4";
                                    this.list1 = "LIST-1";
                                    this.binding.intensiveRevisionLayout.setVisibility(8);
                                    this.binding.llBefore1987.setVisibility(8);
                                    AlertDialog alertDialog10 = this.alertDialog;
                                    if (alertDialog10 != null) {
                                        alertDialog10.show();
                                        getList1(this.list1);
                                    }
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
                    }
                } else if (this.choice.equalsIgnoreCase(getString(R.string.not_born))) {
                    this.binding.layoutVerifyDetails.setVisibility(8);
                    this.List6docName.clear();
                    this.List6docCode.clear();
                    this.binding.radioLayout.setVisibility(8);
                    this.cat = "CAT-5";
                    this.list6 = "LIST-6";
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore1987.setVisibility(8);
                    AlertDialog alertDialog11 = this.alertDialog;
                    if (alertDialog11 != null) {
                        alertDialog11.show();
                        getList1(this.list6);
                    }
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(0);
                    this.binding.llAcquired.setVisibility(8);
                } else if (this.choice.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
                    this.binding.layoutVerifyDetails.setVisibility(8);
                    this.List7docName.clear();
                    this.List7docCode.clear();
                    this.binding.radioLayout.setVisibility(8);
                    this.cat = "CAT-6";
                    this.list7 = "LIST-7";
                    this.binding.intensiveRevisionLayout.setVisibility(8);
                    this.binding.llBefore1987.setVisibility(8);
                    AlertDialog alertDialog12 = this.alertDialog;
                    if (alertDialog12 != null) {
                        alertDialog12.show();
                        getList1(this.list7);
                    }
                    this.binding.llBefore2004.setVisibility(8);
                    this.binding.llAfter2004.setVisibility(8);
                    this.binding.llBornOutOfIndia.setVisibility(8);
                    this.binding.llAcquired.setVisibility(0);
                }
            }
            this.binding.selectDetails.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.1
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (RollbackFormsPage2BH.this.binding.bornBefore1987rb.isChecked()) {
                        RollbackFormsPage2BH.this.cat = "CAT-2";
                        RollbackFormsPage2BH.this.list1 = "LIST-1";
                        RollbackFormsPage2BH.this.binding.intensiveRevisionLayout.setVisibility(8);
                        RollbackFormsPage2BH.this.binding.llBefore1987.setVisibility(0);
                        if (RollbackFormsPage2BH.this.alertDialog != null) {
                            RollbackFormsPage2BH.this.alertDialog.show();
                            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                            rollbackFormsPage2BH.getList1(rollbackFormsPage2BH.list1);
                        }
                        RollbackFormsPage2BH.this.binding.llBefore2004.setVisibility(8);
                        RollbackFormsPage2BH.this.binding.llAfter2004.setVisibility(8);
                        RollbackFormsPage2BH.this.binding.llBornOutOfIndia.setVisibility(8);
                        RollbackFormsPage2BH.this.binding.llAcquired.setVisibility(8);
                    }
                    if (RollbackFormsPage2BH.this.binding.bornBefore2004rb.isChecked()) {
                        RollbackFormsPage2BH.this.cat = "CAT-3";
                        RollbackFormsPage2BH.this.list1 = "LIST-1";
                        RollbackFormsPage2BH.this.binding.intensiveRevisionLayout.setVisibility(8);
                        RollbackFormsPage2BH.this.binding.llBefore1987.setVisibility(8);
                        if (RollbackFormsPage2BH.this.alertDialog != null) {
                            RollbackFormsPage2BH.this.alertDialog.show();
                            RollbackFormsPage2BH rollbackFormsPage2BH2 = RollbackFormsPage2BH.this;
                            rollbackFormsPage2BH2.getList1(rollbackFormsPage2BH2.list1);
                        }
                        RollbackFormsPage2BH.this.binding.llBefore2004.setVisibility(0);
                        RollbackFormsPage2BH.this.binding.llAfter2004.setVisibility(8);
                        RollbackFormsPage2BH.this.binding.llBornOutOfIndia.setVisibility(8);
                        RollbackFormsPage2BH.this.binding.llAcquired.setVisibility(8);
                    }
                    if (RollbackFormsPage2BH.this.binding.bornAfter2004rb.isChecked()) {
                        RollbackFormsPage2BH.this.cat = "CAT-4";
                        RollbackFormsPage2BH.this.list1 = "LIST-1";
                        RollbackFormsPage2BH.this.binding.intensiveRevisionLayout.setVisibility(8);
                        RollbackFormsPage2BH.this.binding.llBefore1987.setVisibility(8);
                        RollbackFormsPage2BH rollbackFormsPage2BH3 = RollbackFormsPage2BH.this;
                        rollbackFormsPage2BH3.getList1(rollbackFormsPage2BH3.list1);
                        RollbackFormsPage2BH.this.binding.llParentLayout.setVisibility(8);
                        RollbackFormsPage2BH.this.binding.llBefore2004.setVisibility(8);
                        RollbackFormsPage2BH.this.binding.llAfter2004.setVisibility(0);
                        RollbackFormsPage2BH.this.binding.llBornOutOfIndia.setVisibility(8);
                        RollbackFormsPage2BH.this.binding.llAcquired.setVisibility(8);
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
        }
        this.binding.chooseFileIR2003.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda66
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.chooseFileIR2003Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.chooseFileBefore1987.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.chooseFileBefore1987Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.chooseFileBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.chooseFileBefore2004SelfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda57
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.chooseFileBefore2004Father.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda69
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.chooseFileBefore2004FatherPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.chooseFileAfter2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda71
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.chooseFileAfter2004SelfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        this.binding.chooseFileAfter2004Father.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        this.binding.chooseFileAfter2004FatherPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda76
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.chooseFileAfter2004Mother.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda77
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$12(view);
            }
        });
        this.binding.chooseFileAfter2004MotherPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.chooseFileAfter2004NotIndian.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$14(view);
            }
        });
        this.binding.chooseFileAfter2004NotIndianPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$15(view);
            }
        });
        this.binding.chooseFileBornOutOfIndia.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$16(view);
            }
        });
        this.binding.chooseFileBornOutOfIndiaPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$17(view);
            }
        });
        this.binding.chooseFileAcquired.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$18(view);
            }
        });
        this.binding.chooseFileAcquiredPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$19(view);
            }
        });
        this.binding.chooseFileAfter2004NotIndianPage3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$20(view);
            }
        });
        this.binding.cancelIR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$21(view);
            }
        });
        this.binding.cancelList1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$22(view);
            }
        });
        this.binding.cancelBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$23(view);
            }
        });
        this.binding.cancelList2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$24(view);
            }
        });
        this.binding.cancelAfter2004self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$25(view);
            }
        });
        this.binding.cancelList3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$26(view);
            }
        });
        this.binding.cancelList4.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$27(view);
            }
        });
        this.binding.cancelList5.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$28(view);
            }
        });
        this.binding.cancelList6.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$29(view);
            }
        });
        this.binding.cancelList7.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$30(view);
            }
        });
        this.binding.cancelIRPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$31(view);
            }
        });
        this.binding.cancelList1Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$32(view);
            }
        });
        this.binding.cancelBefore2004SelfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$33(view);
            }
        });
        this.binding.cancelList2Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$34(view);
            }
        });
        this.binding.cancelAfter2004selfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$35(view);
            }
        });
        this.binding.cancelList3Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$36(view);
            }
        });
        this.binding.cancelList4Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$37(view);
            }
        });
        this.binding.cancelList5Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$38(view);
            }
        });
        this.binding.cancelList6Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$39(view);
            }
        });
        this.binding.cancelList7Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$40(view);
            }
        });
        this.binding.cancelList5Page3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$41(view);
            }
        });
        this.binding.spinnerIR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < RollbackFormsPage2BH.this.List8docName.size()) {
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.list8code = rollbackFormsPage2BH.List8docCode.get(i);
                    Logger.d(Constants.LIST8_CODE, RollbackFormsPage2BH.this.list8code);
                }
            }
        });
        this.binding.spinnerBefore1987Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < RollbackFormsPage2BH.this.List1docName.size()) {
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.list1Code = rollbackFormsPage2BH.List1docCode.get(i);
                    Logger.d("list1Code", RollbackFormsPage2BH.this.list1Code);
                }
            }
        });
        this.binding.spinnerBefore2004Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < RollbackFormsPage2BH.this.List1docName.size()) {
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.list1Code = rollbackFormsPage2BH.List1docCode.get(i);
                    Logger.d("list1Code", RollbackFormsPage2BH.this.list1Code);
                }
            }
        });
        this.binding.spinnerAfter2004Self.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.5
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < RollbackFormsPage2BH.this.List1docName.size()) {
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.list1Code = rollbackFormsPage2BH.List1docCode.get(i);
                    Logger.d("list1Code", RollbackFormsPage2BH.this.list1Code);
                }
            }
        });
        this.binding.spinnerBefore2004Father.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.6
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                if (i == 1) {
                    RollbackFormsPage2BH.this.binding.viewFather1OldLayout.setVisibility(0);
                    return;
                }
                RollbackFormsPage2BH.this.binding.viewFather1OldLayout.setVisibility(8);
                int i2 = i - 1;
                if (i2 >= 0 && i2 < RollbackFormsPage2BH.this.List3docName.size() && RollbackFormsPage2BH.this.flagcat3scenerio1.equalsIgnoreCase("Y")) {
                    if (i == 1) {
                        RollbackFormsPage2BH.this.binding.viewFather1OldLayout.setVisibility(0);
                    } else {
                        RollbackFormsPage2BH.this.binding.viewFather1OldLayout.setVisibility(8);
                    }
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.list3code = rollbackFormsPage2BH.List3docCode.get(i);
                    Logger.d("list3code", RollbackFormsPage2BH.this.list3code);
                }
                if (i2 < 0 || i2 >= RollbackFormsPage2BH.this.List4docName.size() || !RollbackFormsPage2BH.this.flagcat3scenerio2.equalsIgnoreCase("Y")) {
                    return;
                }
                if (i == 1) {
                    RollbackFormsPage2BH.this.binding.viewFather1OldLayout.setVisibility(0);
                } else {
                    RollbackFormsPage2BH.this.binding.viewFather1OldLayout.setVisibility(8);
                }
                RollbackFormsPage2BH rollbackFormsPage2BH2 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH2.list4code = rollbackFormsPage2BH2.List4docCode.get(i);
                Logger.d("list4code", RollbackFormsPage2BH.this.list4code);
            }
        });
        this.binding.spinnerAfter2004Father.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.7
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0 && i >= 0 && i < RollbackFormsPage2BH.this.List3docName.size()) {
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.list3code = rollbackFormsPage2BH.List3docCode.get(i);
                    if (RollbackFormsPage2BH.this.binding.parentYesRb.isChecked()) {
                        if (i == 1) {
                            RollbackFormsPage2BH rollbackFormsPage2BH2 = RollbackFormsPage2BH.this;
                            rollbackFormsPage2BH2.list3code = rollbackFormsPage2BH2.List3docCode.get(i);
                            Logger.d("list3code", RollbackFormsPage2BH.this.list3code);
                            RollbackFormsPage2BH.this.binding.viewFatherOldLayout.setVisibility(0);
                            return;
                        }
                        RollbackFormsPage2BH.this.binding.viewFatherOldLayout.setVisibility(8);
                        return;
                    }
                    if (RollbackFormsPage2BH.this.binding.parentNoRb.isChecked() && RollbackFormsPage2BH.this.binding.parentFatherRb.isChecked()) {
                        if (i == 1) {
                            RollbackFormsPage2BH rollbackFormsPage2BH3 = RollbackFormsPage2BH.this;
                            rollbackFormsPage2BH3.list3code = rollbackFormsPage2BH3.List3docCode.get(i);
                            Logger.d("list3code", RollbackFormsPage2BH.this.list3code);
                            RollbackFormsPage2BH.this.flagYes = "Y";
                            RollbackFormsPage2BH.this.binding.viewFatherOldLayout.setVisibility(0);
                            return;
                        }
                        RollbackFormsPage2BH.this.binding.viewFatherOldLayout.setVisibility(8);
                    }
                }
            }
        });
        this.binding.spinnerAfter2004Mother.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < RollbackFormsPage2BH.this.List4docName.size()) {
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.list4code = rollbackFormsPage2BH.List4docCode.get(i);
                    if (RollbackFormsPage2BH.this.binding.parentYesRb.isChecked()) {
                        if (i == 1) {
                            RollbackFormsPage2BH rollbackFormsPage2BH2 = RollbackFormsPage2BH.this;
                            rollbackFormsPage2BH2.list4code = rollbackFormsPage2BH2.List4docCode.get(i);
                            Logger.d("list4code", RollbackFormsPage2BH.this.list4code);
                            RollbackFormsPage2BH.this.binding.viewMotherOldLayout.setVisibility(0);
                            return;
                        }
                        RollbackFormsPage2BH.this.binding.viewMotherOldLayout.setVisibility(8);
                        return;
                    }
                    if (RollbackFormsPage2BH.this.binding.parentNoRb.isChecked() && RollbackFormsPage2BH.this.binding.parentMotherRb.isChecked()) {
                        if (i == 1) {
                            RollbackFormsPage2BH rollbackFormsPage2BH3 = RollbackFormsPage2BH.this;
                            rollbackFormsPage2BH3.list4code = rollbackFormsPage2BH3.List4docCode.get(i);
                            Logger.d("list4code", RollbackFormsPage2BH.this.list4code);
                            RollbackFormsPage2BH.this.flagYes = "Y";
                            RollbackFormsPage2BH.this.binding.viewMotherOldLayout.setVisibility(0);
                            return;
                        }
                        RollbackFormsPage2BH.this.binding.viewMotherOldLayout.setVisibility(8);
                    }
                }
            }
        });
        this.binding.spinnerAfter2004NotIndian.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < RollbackFormsPage2BH.this.List5docName.size()) {
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.list5code = rollbackFormsPage2BH.List5docCode.get(i);
                    Logger.d("list5code", RollbackFormsPage2BH.this.list5code);
                }
            }
        });
        this.binding.spinnerBornOutOfIndia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < RollbackFormsPage2BH.this.List6docName.size()) {
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.list6code = rollbackFormsPage2BH.List6docCode.get(i);
                    Logger.d("list6code", RollbackFormsPage2BH.this.list6code);
                }
            }
        });
        this.binding.spinnerAcquired.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.11
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int i2;
                if (i != 0 && (i2 = i - 1) >= 0 && i2 < RollbackFormsPage2BH.this.List7docName.size()) {
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.list7code = rollbackFormsPage2BH.List7docCode.get(i);
                    Logger.d("list7code", RollbackFormsPage2BH.this.list7code);
                }
            }
        });
        this.binding.submitButtonDoc.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$42(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$43(view);
            }
        });
        this.binding.betweenParentFatherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$44(view);
            }
        });
        this.binding.betweenParentMotherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$45(view);
            }
        });
        this.binding.parentYesRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$47(view);
            }
        });
        this.binding.parentNoRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$48(view);
            }
        });
        this.binding.parentFatherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$49(view);
            }
        });
        this.binding.parentMotherRb.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$50(view);
            }
        });
        initClickListener();
        setInitialDataFromAPI();
        this.binding.imageList6Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$51(view);
            }
        });
        this.binding.imageList7.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$52(view);
            }
        });
        this.binding.imageList7Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$53(view);
            }
        });
        this.binding.imageIR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$54(view);
            }
        });
        this.binding.imageIRPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$55(view);
            }
        });
        this.binding.imageList1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$56(view);
            }
        });
        this.binding.imageBefore2004Self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$57(view);
            }
        });
        this.binding.imageAfter2004self.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$58(view);
            }
        });
        this.binding.imageList1Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda54
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$59(view);
            }
        });
        this.binding.imageBefore2004SelfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda56
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$60(view);
            }
        });
        this.binding.imageAfter2004selfPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda58
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$61(view);
            }
        });
        this.binding.imageList2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda59
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$62(view);
            }
        });
        this.binding.imageList2Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$63(view);
            }
        });
        this.binding.imageList3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda61
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$64(view);
            }
        });
        this.binding.imageList3Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$65(view);
            }
        });
        this.binding.imageList4.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$66(view);
            }
        });
        this.binding.imageList4Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda64
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$67(view);
            }
        });
        this.binding.imageList5.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda65
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$68(view);
            }
        });
        this.binding.imageList5Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda67
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$69(view);
            }
        });
        this.binding.imageList5Page3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda68
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$70(view);
            }
        });
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RollbackFormsPage2BH.this.binding.IROldAcNo.getText().toString().trim().length() <= 0 || RollbackFormsPage2BH.this.binding.IROldPartNo.getText().toString().trim().length() <= 0 || RollbackFormsPage2BH.this.binding.IROldPslNo.getText().toString().trim().length() <= 0) {
                    return;
                }
                RollbackFormsPage2BH.this.callVerifyRelativeApi();
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
        pickFileIntensiveRevision(201, this.list8code + "_page2_");
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
        pickFileIntensiveRevision(202, this.list1Code + "_page2_");
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
        pickFileIntensiveRevision(203, this.list1Code + "_page2_");
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
            pickFileIntensiveRevision(204, this.list3code + "_page2_");
        } else if (this.binding.betweenParentMotherRb.isChecked()) {
            pickFileIntensiveRevision(211, this.list4code + "_page2_");
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
        pickFileIntensiveRevision(205, this.list1Code + "_page2_");
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
        pickFileIntensiveRevision(206, this.list3code + "_page2_");
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
        pickFileIntensiveRevision(207, this.list4code + "_page2_");
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
        pickFileIntensiveRevision(208, this.list5code + "_page2_");
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
        pickFileIntensiveRevision(209, this.list6code + "_page2_");
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
        pickFileIntensiveRevision(210, this.list7code + "_page2_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$20(View view) {
        pickFileIntensiveRevision(212, this.list5code + "_page3_");
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
        if ((this.cat.equals("CAT-3") || this.cat.equals("CAT-4")) && validate2() && validate3()) {
            submit();
        } else if (this.cat.equals("CAT-2") || this.cat.equals("CAT-5") || (this.cat.equals("CAT-6") && validate3())) {
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
        if ((this.cat.equals("CAT-3") || this.cat.equals("CAT-4")) && validate2() && validate3()) {
            submit();
        } else if ((this.cat.equals("CAT-2") || this.cat.equals("CAT-5") || this.cat.equals("CAT-6")) && validate3()) {
            submit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$44(View view) {
        this.flagcat3scenerio1 = "Y";
        this.List3docName.clear();
        this.List3docCode.clear();
        getList1(this.list3);
        this.list3code = "";
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
        getList1(this.list4);
        this.list3code = "";
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
    public /* synthetic */ void lambda$onCreate$47(View view) {
        this.binding.parentYesRb.post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$46();
            }
        });
        this.flagcat4scenerio1 = "Y";
        this.motherNationality = "Indian";
        this.fatherNationality = "Indian";
        getList1(this.list3);
        getList1(this.list4);
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
        getList1(this.list5);
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
        if (TextUtils.isEmpty(this.list6ref2) || !this.list6ref2.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element2, this.list6ref2);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$52(View view) {
        if (TextUtils.isEmpty(this.list7ref) || !this.list7ref.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element3, this.list7ref);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$53(View view) {
        if (this.list7ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element4, this.list7ref2);
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$54(View view) {
        if (TextUtils.isEmpty(this.IRRef) || !this.IRRef.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element5, this.IRRef);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$55(View view) {
        if (TextUtils.isEmpty(this.IRRef2) || !this.IRRef2.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element6, this.IRRef2);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$56(View view) {
        if (TextUtils.isEmpty(this.list1ref) || !this.list1ref.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element7, this.list1ref);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$57(View view) {
        if (TextUtils.isEmpty(this.list1ref) || !this.list1ref.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element7, this.list1ref);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$58(View view) {
        if (TextUtils.isEmpty(this.list1ref) || !this.list1ref.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element7, this.list1ref);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$59(View view) {
        if (TextUtils.isEmpty(this.list1ref2) || !this.list1ref2.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element8, this.list1ref2);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$60(View view) {
        if (TextUtils.isEmpty(this.list1ref2) || !this.list1ref2.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element8, this.list1ref2);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$61(View view) {
        if (TextUtils.isEmpty(this.list1ref2) || !this.list1ref2.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element8, this.list1ref2);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$62(View view) {
        if (TextUtils.isEmpty(this.list3Ref) || !this.list3Ref.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element9, this.list3Ref);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$63(View view) {
        if (TextUtils.isEmpty(this.list3Ref2) || !this.list3Ref2.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element10, this.list3Ref2);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$64(View view) {
        if (TextUtils.isEmpty(this.list3Ref) || !this.list3Ref.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element11, this.list3Ref);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$65(View view) {
        if (TextUtils.isEmpty(this.list3Ref2) || !this.list3Ref2.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element12, this.list3Ref2);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$66(View view) {
        if (TextUtils.isEmpty(this.list4Ref) || !this.list4Ref.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element13, this.list4Ref);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$67(View view) {
        if (TextUtils.isEmpty(this.list4Ref2) || !this.list4Ref2.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element14, this.list4Ref2);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$68(View view) {
        if (TextUtils.isEmpty(this.list5Ref) || !this.list5Ref.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element15, this.list5Ref);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$69(View view) {
        if (TextUtils.isEmpty(this.list5Ref2) || !this.list5Ref2.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element16, this.list5Ref2);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$70(View view) {
        if (TextUtils.isEmpty(this.list5ref3) || !this.list5ref3.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.base64element17, this.list5ref3);
        } catch (IOException e) {
            Log.d("Exception in displaying pdf= ", e.getMessage());
        }
    }

    private boolean validate() {
        if (!this.cat.equalsIgnoreCase("CAT-1")) {
            return true;
        }
        if (TextUtils.isEmpty(this.oldAc)) {
            showDialog1(this.alertText, getString(R.string.please_enter_old_ac));
            return false;
        }
        if (TextUtils.isEmpty(this.OldPart)) {
            showDialog1(this.alertText, getString(R.string.Please_enter_old_Part));
            return false;
        }
        if (TextUtils.isEmpty(this.OldPsl)) {
            showDialog1(this.alertText, getString(R.string.please_enter_old_part_serial_no));
            return false;
        }
        if (this.isThisYou || !TextUtils.isEmpty(this.IRRef)) {
            return true;
        }
        showDialog1(this.alertText, getString(R.string.please_upload_document));
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
            showDialog1(this.alertText, "Please enter mother old AC");
            return false;
        }
        if (TextUtils.isEmpty(this.motherOldPart)) {
            showDialog1(this.alertText, "Please enter mother old Part");
            return false;
        }
        if (!TextUtils.isEmpty(this.motherOldPsl)) {
            return true;
        }
        showDialog1(this.alertText, "Please enter mother old Part serial no");
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
        if (!this.cat.equals("CAT-4")) {
            return true;
        }
        if ((!TextUtils.isEmpty(this.list1ref) || !TextUtils.isEmpty(this.list1ref2) || !this.binding.parentYesRb.isChecked() || !TextUtils.isEmpty(this.list3Ref) || !TextUtils.isEmpty(this.list3Ref2) || !TextUtils.isEmpty(this.list4Ref) || !TextUtils.isEmpty(this.list4Ref2)) && (!this.binding.parentNoRb.isChecked() || !TextUtils.isEmpty(this.list3Ref) || !TextUtils.isEmpty(this.list3Ref2) || !TextUtils.isEmpty(this.list4Ref) || !TextUtils.isEmpty(this.list4Ref2) || !TextUtils.isEmpty(this.list5Ref) || !TextUtils.isEmpty(this.list5Ref2))) {
            return true;
        }
        showDialog1(this.alertText, getString(R.string.please_upload_document));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void callVerifyRelativeApi() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getDetailsByEroll(Integer.parseInt(this.binding.IROldAcNo.getText().toString().trim()), Integer.parseInt(this.binding.IROldPartNo.getText().toString().trim()), Integer.parseInt(this.binding.IROldPslNo.getText().toString().trim()), map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.13
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                    try {
                        JSONObject jSONObject = new JSONArray(RollbackFormsPage2BH.this.gson.toJson(((JsonObject) response.body()).get("payload"))).getJSONObject(0);
                        String strOptString = jSONObject.optString("epic", null);
                        String strOptString2 = jSONObject.optString(Constants.FIRST_NAME, null);
                        String strOptString3 = jSONObject.optString(Constants.LAST_NAME, null);
                        String strOptString4 = jSONObject.optString("relativeFName", null);
                        String strOptString5 = jSONObject.optString("relativeLName", null);
                        RollbackFormsPage2BH.this.showVerifyDetailsDialog(strOptString2 + " " + strOptString3, strOptString4 + " " + strOptString5, jSONObject.optString("relationType", null), strOptString);
                        return;
                    } catch (JSONException e) {
                        Logger.d("RollbackFormsPage2BH", e.toString());
                        return;
                    }
                }
                if (response.code() == 404) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                    RollbackFormsPage2BH.this.isThisYou = false;
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.alertText, RollbackFormsPage2BH.this.getString(R.string.no_record_found));
                    return;
                }
                RollbackFormsPage2BH.this.isThisYou = false;
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    void showVerifyDetailsDialog(String name, String relativeName, String typeRelation, String epic) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_verify_elector);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(true);
        Button button = (Button) dialog.findViewById(R.id.btnYes);
        Button button2 = (Button) dialog.findViewById(R.id.btnNo);
        TextView textView = (TextView) dialog.findViewById(R.id.txtName);
        TextView textView2 = (TextView) dialog.findViewById(R.id.txtRelativeName);
        TextView textView3 = (TextView) dialog.findViewById(R.id.txtTypeRelation);
        TextView textView4 = (TextView) dialog.findViewById(R.id.txtEpic);
        textView.setText(name);
        textView2.setText(relativeName);
        if (!TextUtils.isEmpty(typeRelation)) {
            if (typeRelation.equals("GMTH")) {
                textView3.setText("Grand Mother");
            } else if (typeRelation.equals("GFTH")) {
                textView3.setText("Grand Father");
            } else if (typeRelation.equals("MTHR")) {
                textView3.setText("Mother");
            } else if (typeRelation.equals("FTHR") || typeRelation.equals("F")) {
                textView3.setText("Father");
            } else if (typeRelation.equals("HSBN") || typeRelation.equals("H")) {
                textView3.setText("Husband");
            } else if (typeRelation.equals("OTHR")) {
                textView3.setText("Other");
            } else {
                textView3.setText(typeRelation);
            }
        }
        textView4.setText(epic);
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.cancel();
                RollbackFormsPage2BH.this.isThisYou = true;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.cancel();
                RollbackFormsPage2BH.this.isThisYou = false;
            }
        });
        dialog.show();
    }

    private void callIRFields() {
        if (!this.binding.IROldAcNo.getText().toString().isEmpty()) {
            this.oldAc = this.binding.IROldAcNo.getText().toString();
        }
        if (!this.binding.IROldPartNo.getText().toString().isEmpty()) {
            this.OldPart = this.binding.IROldPartNo.getText().toString();
        }
        if (this.binding.IROldPslNo.getText().toString().isEmpty()) {
            return;
        }
        this.OldPsl = this.binding.IROldPslNo.getText().toString();
    }

    private void callParentFields() {
        if (this.binding.parentYesRb.isChecked()) {
            if (!this.binding.fatherOldAcNo.getText().toString().isEmpty()) {
                this.fatherOldAc = this.binding.fatherOldAcNo.getText().toString();
            }
            if (!this.binding.fatherOldPartNo.getText().toString().isEmpty()) {
                this.fatherOldPart = this.binding.fatherOldPartNo.getText().toString();
            }
            if (!this.binding.fatherOldPslNo.getText().toString().isEmpty()) {
                this.fatherOldPsl = this.binding.fatherOldPslNo.getText().toString();
            }
            if (!this.binding.motherOldAcNo.getText().toString().isEmpty()) {
                this.motherOldAc = this.binding.motherOldAcNo.getText().toString();
            }
            if (!this.binding.motherOldPartNo.getText().toString().isEmpty()) {
                this.motherOldPart = this.binding.motherOldPartNo.getText().toString();
            }
            if (this.binding.motherOldPslNo.getText().toString().isEmpty()) {
                return;
            }
            this.motherOldPsl = this.binding.motherOldPslNo.getText().toString();
            return;
        }
        if (this.binding.parentNoRb.isChecked()) {
            if (this.binding.parentMotherRb.isChecked()) {
                if (!this.binding.motherOldAcNo.getText().toString().isEmpty()) {
                    this.motherOldAc = this.binding.motherOldAcNo.getText().toString();
                }
                if (!this.binding.motherOldPartNo.getText().toString().isEmpty()) {
                    this.motherOldPart = this.binding.motherOldPartNo.getText().toString();
                }
                if (this.binding.motherOldPslNo.getText().toString().isEmpty()) {
                    return;
                }
                this.motherOldPsl = this.binding.motherOldPslNo.getText().toString();
                return;
            }
            if (this.binding.parentFatherRb.isChecked()) {
                if (!this.binding.fatherOldAcNo.getText().toString().isEmpty()) {
                    this.fatherOldAc = this.binding.fatherOldAcNo.getText().toString();
                }
                if (!this.binding.fatherOldPartNo.getText().toString().isEmpty()) {
                    this.fatherOldPart = this.binding.fatherOldPartNo.getText().toString();
                }
                if (this.binding.fatherOldPslNo.getText().toString().isEmpty()) {
                    return;
                }
                this.fatherOldPsl = this.binding.fatherOldPslNo.getText().toString();
                return;
            }
            return;
        }
        if (this.binding.betweenParentMotherRb.isChecked()) {
            if (!this.binding.father1OldAcNo.getText().toString().isEmpty()) {
                this.motherOldAc = this.binding.father1OldAcNo.getText().toString();
            }
            if (!this.binding.father1OldPartNo.getText().toString().isEmpty()) {
                this.motherOldPart = this.binding.father1OldPartNo.getText().toString();
            }
            if (this.binding.father1OldPslNo.getText().toString().isEmpty()) {
                return;
            }
            this.motherOldPsl = this.binding.father1OldPslNo.getText().toString();
            return;
        }
        if (this.binding.betweenParentFatherRb.isChecked()) {
            if (!this.binding.father1OldAcNo.getText().toString().isEmpty()) {
                this.fatherOldAc = this.binding.father1OldAcNo.getText().toString();
            }
            if (!this.binding.father1OldPartNo.getText().toString().isEmpty()) {
                this.fatherOldPart = this.binding.father1OldPartNo.getText().toString();
            }
            if (this.binding.father1OldPslNo.getText().toString().isEmpty()) {
                return;
            }
            this.fatherOldPsl = this.binding.father1OldPslNo.getText().toString();
        }
    }

    private void deletePhoto(int code) {
        if (code == 101) {
            this.IRRef = null;
            this.binding.chooseFileIR2003.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.chooseFileIR2003.setEnabled(true);
            this.binding.imageIR.setVisibility(8);
            this.binding.IRSize.setText("");
            this.binding.IRName.setText("");
            this.binding.cancelIR.setVisibility(8);
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
        String[] strArr;
        int i;
        Object obj;
        callIRFields();
        callParentFields();
        try {
            str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(this.dob));
            while (true) {
                if (i >= 17) {
                    obj = "N";
                    break;
                } else {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        obj = "Y";
                        break;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            String str2 = this.dob;
            Logger.d("Date replace", e.toString());
            str = str2;
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
        i = 0;
        strArr = new String[]{this.list1ref, this.list1ref2, this.list2Ref, this.list2Ref2, this.list3Ref, this.list3Ref2, this.list4Ref, this.list4Ref2, this.list5Ref, this.list5Ref2, this.list5ref3, this.list6ref, this.list6ref2, this.list7ref, this.list7ref2, this.IRRef, this.IRRef2};
        map2.put("documentUploadedFlg", obj);
        map2.put("bloOverridenFlg", this.bundle.getString("bloOverridenFlg"));
        map2.put("relationOldAcNo", TextUtils.isEmpty(this.bundle.getString("relationOldAcNo")) ? null : this.bundle.getString("relationOldAcNo"));
        map2.put("relationOldPartNo", TextUtils.isEmpty(this.bundle.getString("relationOldPartNo")) ? null : this.bundle.getString("relationOldPartNo"));
        map2.put("relationOldPslNo", TextUtils.isEmpty(this.bundle.getString("relationOldPSLNo")) ? null : this.bundle.getString("relationOldPSLNo"));
        map2.put("relationDocType", TextUtils.isEmpty(this.bundle.getString("relationList8Code")) ? "" : this.bundle.getString("relationList8Code"));
        map2.put("relationDocUrlPg1", TextUtils.isEmpty(this.bundle.getString("relationList8DocPage1")) ? "" : this.bundle.getString("relationList8DocPage1"));
        map2.put("relationDocUrlPg2", TextUtils.isEmpty(this.bundle.getString("relationList8DocPage2")) ? "" : this.bundle.getString("relationList8DocPage2"));
        map2.put("isRelativePreVoterFlg", TextUtils.isEmpty(this.bundle.getString("isRelative2003")) ? "" : this.bundle.getString("isRelative2003"));
        map2.put("relationProofDocUrlPg1", TextUtils.isEmpty(this.bundle.getString("relationProofDocPage1")) ? "" : this.bundle.getString("relationProofDocPage1"));
        map2.put("relationProofDocUrlPg2", TextUtils.isEmpty(this.bundle.getString("relationProofDocPage2")) ? "" : this.bundle.getString("relationProofDocPage2"));
        map2.put("relationType", TextUtils.isEmpty(this.bundle.getString("relationCode")) ? "" : this.bundle.getString("relationCode"));
        map2.put("isThisYouRel", this.isThisYouRel);
        map2.put("isThisYou", this.isThisYou ? "Y" : "N");
        map2.put("relationEpicNo", TextUtils.isEmpty(this.bundle.getString("relativeEpic")) ? "" : this.bundle.getString("relativeEpic"));
        Logger.d(this.TAG, map2.toString());
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).updateSpecialRevision2(map, map2).enqueue(new AnonymousClass16());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$16, reason: invalid class name */
    class AnonymousClass16 implements Callback<JsonObject> {
        AnonymousClass16() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            try {
                if (!response.isSuccessful()) {
                    String string = new JSONObject(response.errorBody().string()).getString("message");
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.showDialog2(rollbackFormsPage2BH.alertText, string);
                } else {
                    RollbackFormsPage2BH rollbackFormsPage2BH2 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH2.showDialog2("", rollbackFormsPage2BH2.getString(R.string.formSubmittedMsg));
                }
            } catch (Exception e) {
                Logger.d("RollbackFormsPage2BH", e.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$16$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, t.getMessage());
        }
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
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getSpecialRevisionList(map, map2).enqueue(new AnonymousClass17(list));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$17, reason: invalid class name */
    class AnonymousClass17 implements Callback<JsonObject> {
        final /* synthetic */ String val$list;

        AnonymousClass17(final String val$list) {
            this.val$list = val$list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v13, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
        /* JADX WARN: Type inference failed for: r3v119, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
        /* JADX WARN: Type inference failed for: r3v140, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
        /* JADX WARN: Type inference failed for: r3v158, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
        /* JADX WARN: Type inference failed for: r3v26, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
        /* JADX WARN: Type inference failed for: r3v44, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
        /* JADX WARN: Type inference failed for: r3v62, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
        /* JADX WARN: Type inference failed for: r3v80, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
        /* JADX WARN: Type inference failed for: r3v98, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.payloadData1 = (JsonObject) response.body();
                if (RollbackFormsPage2BH.this.payloadData1 != null) {
                    JsonArray asJsonArray = RollbackFormsPage2BH.this.payloadData1.getAsJsonArray("payload");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = RollbackFormsPage2BH.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        if (this.val$list.equalsIgnoreCase("LIST-1") && RollbackFormsPage2BH.this.List1docName.size() != size + 1) {
                            RollbackFormsPage2BH.this.List1docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            RollbackFormsPage2BH.this.List1docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!RollbackFormsPage2BH.this.List1docName.contains(RollbackFormsPage2BH.this.selectDocumentType)) {
                                RollbackFormsPage2BH.this.List1docName.add(0, RollbackFormsPage2BH.this.selectDocumentType);
                                RollbackFormsPage2BH.this.List1docCode.add(0, null);
                            }
                            ?? r3 = RollbackFormsPage2BH.this;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.List1docName);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            RollbackFormsPage2BH.this.binding.spinnerBefore1987Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            RollbackFormsPage2BH.this.binding.spinnerBefore2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            RollbackFormsPage2BH.this.binding.spinnerAfter2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            if (RollbackFormsPage2BH.this.bundle.getString("list1Doc") == null || RollbackFormsPage2BH.this.bundle.getString("list1Doc").equals("")) {
                                RollbackFormsPage2BH.this.binding.spinnerBefore1987Self.setSelection(0);
                                RollbackFormsPage2BH.this.binding.spinnerBefore2004Self.setSelection(0);
                                RollbackFormsPage2BH.this.binding.spinnerAfter2004Self.setSelection(0);
                            } else {
                                RollbackFormsPage2BH.this.binding.spinnerBefore1987Self.setSelection(RollbackFormsPage2BH.this.List1docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list1Doc")));
                                RollbackFormsPage2BH.this.binding.spinnerBefore2004Self.setSelection(RollbackFormsPage2BH.this.List1docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list1Doc")));
                                RollbackFormsPage2BH.this.binding.spinnerAfter2004Self.setSelection(RollbackFormsPage2BH.this.List1docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list1Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-2") && RollbackFormsPage2BH.this.List2docName.size() != size + 1) {
                            RollbackFormsPage2BH.this.List2docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            RollbackFormsPage2BH.this.List2docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!RollbackFormsPage2BH.this.List2docName.contains(RollbackFormsPage2BH.this.selectDocumentType)) {
                                RollbackFormsPage2BH.this.List2docName.add(0, RollbackFormsPage2BH.this.selectDocumentType);
                                RollbackFormsPage2BH.this.List2docCode.add(0, null);
                            }
                            ?? r4 = RollbackFormsPage2BH.this;
                            ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) r4, R.layout.blo_spinner_dropdown, r4.List2docName);
                            arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            RollbackFormsPage2BH.this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter2);
                            if (RollbackFormsPage2BH.this.bundle.getString("list2Doc") == null || RollbackFormsPage2BH.this.bundle.getString("list2Doc").equals("")) {
                                RollbackFormsPage2BH.this.binding.spinnerBefore2004Father.setSelection(0);
                            } else {
                                RollbackFormsPage2BH.this.binding.spinnerBefore2004Father.setSelection(RollbackFormsPage2BH.this.List2docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list2Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-3") && RollbackFormsPage2BH.this.List3docName.size() != size + 1) {
                            RollbackFormsPage2BH.this.List3docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            RollbackFormsPage2BH.this.List3docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!RollbackFormsPage2BH.this.List3docName.contains(RollbackFormsPage2BH.this.selectDocumentType)) {
                                RollbackFormsPage2BH.this.List3docName.add(0, RollbackFormsPage2BH.this.selectDocumentType);
                                RollbackFormsPage2BH.this.List3docCode.add(0, null);
                            }
                            ?? r5 = RollbackFormsPage2BH.this;
                            ArrayAdapter arrayAdapter3 = new ArrayAdapter((Context) r5, R.layout.blo_spinner_dropdown, r5.List3docName);
                            arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            RollbackFormsPage2BH.this.binding.spinnerAfter2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                            RollbackFormsPage2BH.this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                            if (RollbackFormsPage2BH.this.bundle.getString("list3Doc") == null || RollbackFormsPage2BH.this.bundle.getString("list3Doc").equals("")) {
                                RollbackFormsPage2BH.this.binding.spinnerAfter2004Father.setSelection(0);
                                RollbackFormsPage2BH.this.binding.spinnerBefore2004Father.setSelection(0);
                            } else {
                                RollbackFormsPage2BH.this.binding.spinnerAfter2004Father.setSelection(RollbackFormsPage2BH.this.List3docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list3Doc")));
                                RollbackFormsPage2BH.this.binding.spinnerBefore2004Father.setSelection(RollbackFormsPage2BH.this.List3docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list3Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-4") && RollbackFormsPage2BH.this.List4docName.size() != size + 1) {
                            RollbackFormsPage2BH.this.List4docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            RollbackFormsPage2BH.this.List4docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!RollbackFormsPage2BH.this.List4docName.contains(RollbackFormsPage2BH.this.selectDocumentType)) {
                                RollbackFormsPage2BH.this.List4docName.add(0, RollbackFormsPage2BH.this.selectDocumentType);
                                RollbackFormsPage2BH.this.List4docCode.add(0, null);
                            }
                            ?? r6 = RollbackFormsPage2BH.this;
                            ArrayAdapter arrayAdapter4 = new ArrayAdapter((Context) r6, R.layout.blo_spinner_dropdown, r6.List4docName);
                            arrayAdapter4.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            RollbackFormsPage2BH.this.binding.spinnerAfter2004Mother.setAdapter((SpinnerAdapter) arrayAdapter4);
                            RollbackFormsPage2BH.this.binding.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter4);
                            if (RollbackFormsPage2BH.this.bundle.getString("list4Doc") == null || RollbackFormsPage2BH.this.bundle.getString("list4Doc").equals("")) {
                                RollbackFormsPage2BH.this.binding.spinnerAfter2004Mother.setSelection(0);
                                RollbackFormsPage2BH.this.binding.spinnerBefore2004Father.setSelection(0);
                            } else {
                                RollbackFormsPage2BH.this.binding.spinnerAfter2004Mother.setSelection(RollbackFormsPage2BH.this.List4docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list4Doc")));
                                RollbackFormsPage2BH.this.binding.spinnerBefore2004Father.setSelection(RollbackFormsPage2BH.this.List4docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list4Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-5") && RollbackFormsPage2BH.this.List5docName.size() != size + 1) {
                            RollbackFormsPage2BH.this.List5docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            RollbackFormsPage2BH.this.List5docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!RollbackFormsPage2BH.this.List5docName.contains(RollbackFormsPage2BH.this.selectDocumentType)) {
                                RollbackFormsPage2BH.this.List5docName.add(0, RollbackFormsPage2BH.this.selectDocumentType);
                                RollbackFormsPage2BH.this.List5docCode.add(0, null);
                            }
                            ?? r7 = RollbackFormsPage2BH.this;
                            ArrayAdapter arrayAdapter5 = new ArrayAdapter((Context) r7, R.layout.blo_spinner_dropdown, r7.List5docName);
                            arrayAdapter5.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            RollbackFormsPage2BH.this.binding.spinnerAfter2004NotIndian.setAdapter((SpinnerAdapter) arrayAdapter5);
                            if (RollbackFormsPage2BH.this.bundle.getString("list5Doc") == null || RollbackFormsPage2BH.this.bundle.getString("list5Doc").equals("")) {
                                RollbackFormsPage2BH.this.binding.spinnerAfter2004NotIndian.setSelection(0);
                            } else {
                                RollbackFormsPage2BH.this.binding.spinnerAfter2004NotIndian.setSelection(RollbackFormsPage2BH.this.List5docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list5Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-6") && RollbackFormsPage2BH.this.List6docName.size() != size + 1) {
                            RollbackFormsPage2BH.this.List6docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            RollbackFormsPage2BH.this.List6docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!RollbackFormsPage2BH.this.List6docName.contains(RollbackFormsPage2BH.this.selectDocumentType)) {
                                RollbackFormsPage2BH.this.List6docName.add(0, RollbackFormsPage2BH.this.selectDocumentType);
                                RollbackFormsPage2BH.this.List6docCode.add(0, null);
                            }
                            ?? r8 = RollbackFormsPage2BH.this;
                            ArrayAdapter arrayAdapter6 = new ArrayAdapter((Context) r8, R.layout.blo_spinner_dropdown, r8.List6docName);
                            arrayAdapter6.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            RollbackFormsPage2BH.this.binding.spinnerBornOutOfIndia.setAdapter((SpinnerAdapter) arrayAdapter6);
                            if (RollbackFormsPage2BH.this.bundle.getString("list6Doc") == null || RollbackFormsPage2BH.this.bundle.getString("list6Doc").equals("")) {
                                RollbackFormsPage2BH.this.binding.spinnerBornOutOfIndia.setSelection(0);
                            } else {
                                RollbackFormsPage2BH.this.binding.spinnerBornOutOfIndia.setSelection(RollbackFormsPage2BH.this.List6docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list6Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-7") && RollbackFormsPage2BH.this.List7docName.size() != size + 1) {
                            RollbackFormsPage2BH.this.List7docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            RollbackFormsPage2BH.this.List7docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!RollbackFormsPage2BH.this.List7docName.contains(RollbackFormsPage2BH.this.selectDocumentType)) {
                                RollbackFormsPage2BH.this.List7docName.add(0, RollbackFormsPage2BH.this.selectDocumentType);
                                RollbackFormsPage2BH.this.List7docCode.add(0, null);
                            }
                            ?? r9 = RollbackFormsPage2BH.this;
                            ArrayAdapter arrayAdapter7 = new ArrayAdapter((Context) r9, R.layout.blo_spinner_dropdown, r9.List7docName);
                            arrayAdapter7.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            RollbackFormsPage2BH.this.binding.spinnerAcquired.setAdapter((SpinnerAdapter) arrayAdapter7);
                            if (RollbackFormsPage2BH.this.bundle.getString("list7Doc") == null || RollbackFormsPage2BH.this.bundle.getString("list7Doc").equals("")) {
                                RollbackFormsPage2BH.this.binding.spinnerAcquired.setSelection(0);
                            } else {
                                RollbackFormsPage2BH.this.binding.spinnerAcquired.setSelection(RollbackFormsPage2BH.this.List7docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list7Doc")));
                            }
                        } else if (this.val$list.equalsIgnoreCase("LIST-8") && RollbackFormsPage2BH.this.List8docName.size() != size + 1) {
                            RollbackFormsPage2BH.this.List8docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            RollbackFormsPage2BH.this.List8docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!RollbackFormsPage2BH.this.List8docName.contains(RollbackFormsPage2BH.this.selectDocumentType)) {
                                RollbackFormsPage2BH.this.List8docName.add(0, RollbackFormsPage2BH.this.selectDocumentType);
                                RollbackFormsPage2BH.this.List8docCode.add(0, null);
                            }
                            ?? r10 = RollbackFormsPage2BH.this;
                            ArrayAdapter arrayAdapter8 = new ArrayAdapter((Context) r10, R.layout.blo_spinner_dropdown, r10.List8docName);
                            arrayAdapter8.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            RollbackFormsPage2BH.this.binding.spinnerIR.setAdapter((SpinnerAdapter) arrayAdapter8);
                            if (RollbackFormsPage2BH.this.bundle.getString("list8Doc") == null || RollbackFormsPage2BH.this.bundle.getString("list8Doc").equals("")) {
                                RollbackFormsPage2BH.this.binding.spinnerIR.setSelection(0);
                            } else {
                                RollbackFormsPage2BH.this.binding.spinnerIR.setSelection(RollbackFormsPage2BH.this.List8docCode.indexOf(RollbackFormsPage2BH.this.bundle.getString("list8Doc")));
                            }
                        }
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r14 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r14).refreshToken;
                    final String str2 = this.val$list;
                    commomUtility.getRefreshToken(r14, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$17$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i2, str3, str4);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.toString());
                    return;
                }
            }
            try {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                Logger.e(RollbackFormsPage2BH.this.TAG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$17$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getList1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent(RollbackFormsPage2BH.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            Logger.d(RollbackFormsPage2BH.this.TAG, "OnFailure" + t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickFileIntensiveRevision(final int code, final String listCode) {
        final String strReplaceAll = this.epicNumber.replaceAll("/", "_");
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addDocumentMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda74
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFileIntensiveRevision$71(charSequenceArr, strReplaceAll, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFileIntensiveRevision$71(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
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
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFileIntensiveRevision$72(charSequenceArr, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFileIntensiveRevision$72(CharSequence[] charSequenceArr, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.pdf = false;
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
        } else if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$73(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$73(View view) {
        onBackPressed();
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
            this.saveImageFileName = "img_" + code + str + this.jpgTextBaseActivity;
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
            Logger.d(this.TAG, this.TAG + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d(this.TAG, "filesize " + this.filesize);
        Logger.d(this.TAG, this.TAG + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadPhoto(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        restClient.uploadImageWithSIR(Token, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create(MediaType.parse("bucketName"), "objectstorage"), RequestBody.create(MediaType.parse("fileType"), "application/pdf"), RequestBody.create(MediaType.parse("fileName"), captureFileName), RequestBody.create(statecode, MediaType.parse("stateCode")), RequestBody.create(asmblyNo, MediaType.parse("acNo")), RequestBody.create(partno, MediaType.parse("partNo")), RequestBody.create("SR_FORM", MediaType.parse("type")), RequestBody.create("BLOAPP", MediaType.parse("appName"))).enqueue(new AnonymousClass18(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$18, reason: invalid class name */
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

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v155, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r13 = RollbackFormsPage2BH.this;
                String str = ((RollbackFormsPage2BH) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$18$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                String strValueOf = String.valueOf(((JsonObject) response.body()).get("refId"));
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.IRStr)) {
                    RollbackFormsPage2BH.this.IRRef = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("IRRef", RollbackFormsPage2BH.this.IRRef);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before1987Str)) {
                    RollbackFormsPage2BH.this.list1ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("List1ref1987", RollbackFormsPage2BH.this.list1ref);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before2004Str)) {
                    RollbackFormsPage2BH.this.list1ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("List1ref2004", RollbackFormsPage2BH.this.list1ref);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list2Str)) {
                    RollbackFormsPage2BH.this.list2Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("list2ref", RollbackFormsPage2BH.this.list2Ref);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.after2004Str)) {
                    RollbackFormsPage2BH.this.list1ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("List1refafter2004", RollbackFormsPage2BH.this.list1ref);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list3Str)) {
                    RollbackFormsPage2BH.this.list3Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("list3Ref", RollbackFormsPage2BH.this.list3Ref);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list4Str)) {
                    RollbackFormsPage2BH.this.list4Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("list4Ref", RollbackFormsPage2BH.this.list4Ref);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list5Str)) {
                    RollbackFormsPage2BH.this.list5Ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("List5ref", RollbackFormsPage2BH.this.list5Ref);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list6Str)) {
                    RollbackFormsPage2BH.this.list6ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("List6ref", RollbackFormsPage2BH.this.list6ref);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list7Str)) {
                    RollbackFormsPage2BH.this.list7ref = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("list7ref", RollbackFormsPage2BH.this.list7ref);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.IRStr2)) {
                    RollbackFormsPage2BH.this.IRRef2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("IRRef2", RollbackFormsPage2BH.this.IRRef2);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before1987Str2)) {
                    RollbackFormsPage2BH.this.list1ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("List1ref21987", RollbackFormsPage2BH.this.list1ref2);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before2004Str2)) {
                    RollbackFormsPage2BH.this.list1ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("List1ref22004", RollbackFormsPage2BH.this.list1ref2);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list2Str2)) {
                    RollbackFormsPage2BH.this.list2Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("list2ref2", RollbackFormsPage2BH.this.list2Ref2);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.after2004Str2)) {
                    RollbackFormsPage2BH.this.list1ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("List1ref2after2004", RollbackFormsPage2BH.this.list1ref2);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list3Str2)) {
                    RollbackFormsPage2BH.this.list3Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("list3Ref2", RollbackFormsPage2BH.this.list3Ref2);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list4Str2)) {
                    RollbackFormsPage2BH.this.list4Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("list4Ref2", RollbackFormsPage2BH.this.list4Ref2);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list5Str2)) {
                    RollbackFormsPage2BH.this.list5Ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("List5ref", RollbackFormsPage2BH.this.list5Ref2);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list5Str3)) {
                    RollbackFormsPage2BH.this.list5ref3 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("List5ref3", RollbackFormsPage2BH.this.list5ref3);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list6Str2)) {
                    RollbackFormsPage2BH.this.list6ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("List6ref2", RollbackFormsPage2BH.this.list6ref2);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list7Str2)) {
                    RollbackFormsPage2BH.this.list7ref2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("list7ref2", RollbackFormsPage2BH.this.list7ref2);
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                Logger.d("referenceNumber ", strValueOf);
                return;
            }
            Logger.d("Response= ", "" + response.code());
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.IRStr)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.imageIR.setVisibility(8);
                RollbackFormsPage2BH.this.binding.viewLayoutIR.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileIR2003.setEnabled(true);
                RollbackFormsPage2BH.this.binding.chooseFileIR2003.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.IRcount = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before1987Str)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewLayoutList1.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList1.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileBefore1987.setEnabled(true);
                RollbackFormsPage2BH.this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.before1987count = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH2 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH2.showDialog1(rollbackFormsPage2BH2.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before2004Str)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewLayoutBefore2004Self.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageBefore2004Self.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileBefore2004Self.setEnabled(true);
                RollbackFormsPage2BH.this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.before1987count = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH3 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH3.showDialog1(rollbackFormsPage2BH3.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list2Str)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewLayoutList2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileBefore2004Father.setEnabled(true);
                RollbackFormsPage2BH.this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.list2count = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH4 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH4.showDialog1(rollbackFormsPage2BH4.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.after2004Str)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewLayoutAfter2004self.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageAfter2004self.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004Self.setEnabled(true);
                RollbackFormsPage2BH.this.after2004count = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH5 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH5.showDialog1(rollbackFormsPage2BH5.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list3Str)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList3.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList3.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004Father.setEnabled(true);
                RollbackFormsPage2BH.this.list3count = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH6 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH6.showDialog1(rollbackFormsPage2BH6.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list4Str)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList4.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList4.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004Mother.setEnabled(true);
                RollbackFormsPage2BH.this.list4coumt = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH7 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH7.showDialog1(rollbackFormsPage2BH7.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list5Str)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList5.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList5.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndian.setEnabled(true);
                RollbackFormsPage2BH.this.list5count = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH8 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH8.showDialog1(rollbackFormsPage2BH8.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list6Str)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList6.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList6.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileBornOutOfIndia.setEnabled(true);
                RollbackFormsPage2BH.this.list6count = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH9 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH9.showDialog1(rollbackFormsPage2BH9.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list7Str)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList7.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList7.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAcquired.setEnabled(true);
                RollbackFormsPage2BH.this.list7count = 0;
                RollbackFormsPage2BH.this.binding.chooseFileAcquired.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH rollbackFormsPage2BH10 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH10.showDialog1(rollbackFormsPage2BH10.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.IRStr2)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewLayoutIRPage2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageIRPage2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileIR2003Page2.setEnabled(true);
                RollbackFormsPage2BH.this.IRcount2 = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH11 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH11.showDialog1(rollbackFormsPage2BH11.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before1987Str2)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewLayoutList1Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList1Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileBefore1987Page2.setEnabled(true);
                RollbackFormsPage2BH.this.before1987count2 = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH12 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH12.showDialog1(rollbackFormsPage2BH12.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before2004Str2)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewLayoutBefore2004SelfPage2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageBefore2004SelfPage2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileBefore2004SelfPage2.setEnabled(true);
                RollbackFormsPage2BH.this.before1987count2 = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH13 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH13.showDialog1(rollbackFormsPage2BH13.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list2Str2)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewLayoutList2Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList2Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileBefore2004FatherPage2.setEnabled(true);
                RollbackFormsPage2BH.this.list2count2 = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH14 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH14.showDialog1(rollbackFormsPage2BH14.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.after2004Str2)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewLayoutAfter2004selfPage2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageAfter2004selfPage2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004SelfPage2.setEnabled(true);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.after2004count2 = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH15 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH15.showDialog1(rollbackFormsPage2BH15.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list3Str2)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList3Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList3Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004FatherPage2.setEnabled(true);
                RollbackFormsPage2BH.this.list3count2 = 0;
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH rollbackFormsPage2BH16 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH16.showDialog1(rollbackFormsPage2BH16.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list4Str2)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList4Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList4Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004MotherPage2.setEnabled(true);
                RollbackFormsPage2BH.this.list4coumt2 = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH17 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH17.showDialog1(rollbackFormsPage2BH17.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list5Str2)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList5Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList5Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(true);
                RollbackFormsPage2BH.this.list5count2 = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH18 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH18.showDialog1(rollbackFormsPage2BH18.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list5Str3)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList5Page3.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList5Page3.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(true);
                RollbackFormsPage2BH.this.list5count3 = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH19 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH19.showDialog1(rollbackFormsPage2BH19.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list6Str2)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList6Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList6Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(true);
                RollbackFormsPage2BH.this.list6count2 = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH20 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH20.showDialog1(rollbackFormsPage2BH20.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list7Str2)) {
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList7Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList7Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAcquiredPage2.setEnabled(true);
                RollbackFormsPage2BH.this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.list7count2 = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH21 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH21.showDialog1(rollbackFormsPage2BH21.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                RollbackFormsPage2BH rollbackFormsPage2BH22 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH22.showDialog1(rollbackFormsPage2BH22.getString(R.string.alertMsg), jSONObject.toString());
                Logger.d("Response Error", jSONObject.toString());
            } catch (IOException | JSONException e) {
                Logger.d("Response Exception", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r2 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$18$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            RollbackFormsPage2BH.this.token = "Bearer " + str8;
            RollbackFormsPage2BH.this.refreshToken = str9;
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str8);
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.uploadPhoto(str, str2, str3, str4, str5, rollbackFormsPage2BH.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.IRStr)) {
                if (RollbackFormsPage2BH.this.IRcount < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.IRRef)) {
                    RollbackFormsPage2BH.this.IRcount++;
                    RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.imageIR.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.viewLayoutIR.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileIR2003.setEnabled(true);
                    RollbackFormsPage2BH.this.binding.chooseFileIR2003.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.IRcount = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH2 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH2.showDialog1(rollbackFormsPage2BH2.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before1987Str)) {
                if (RollbackFormsPage2BH.this.before1987count < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list1ref)) {
                    RollbackFormsPage2BH.this.before1987count++;
                    RollbackFormsPage2BH rollbackFormsPage2BH3 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH3.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewLayoutList1.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList1.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987.setEnabled(true);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.before1987count = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH4 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH4.showDialog1(rollbackFormsPage2BH4.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before2004Str)) {
                if (RollbackFormsPage2BH.this.before2004count < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list1ref)) {
                    RollbackFormsPage2BH.this.before2004count++;
                    RollbackFormsPage2BH rollbackFormsPage2BH5 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH5.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewLayoutBefore2004Self.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageBefore2004Self.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004Self.setEnabled(true);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.before1987count = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH6 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH6.showDialog1(rollbackFormsPage2BH6.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list2Str)) {
                if (RollbackFormsPage2BH.this.list2count < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list2Ref)) {
                    RollbackFormsPage2BH.this.list2count++;
                    RollbackFormsPage2BH rollbackFormsPage2BH7 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH7.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH7.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewLayoutList2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004Father.setEnabled(true);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.list2count = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH8 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH8.showDialog1(rollbackFormsPage2BH8.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.after2004Str)) {
                if (RollbackFormsPage2BH.this.after2004count < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list1ref)) {
                    RollbackFormsPage2BH.this.after2004count++;
                    RollbackFormsPage2BH rollbackFormsPage2BH9 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH9.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH9.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewLayoutAfter2004self.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageAfter2004self.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004Self.setEnabled(true);
                    RollbackFormsPage2BH.this.after2004count = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH10 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH10.showDialog1(rollbackFormsPage2BH10.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list3Str)) {
                if (RollbackFormsPage2BH.this.list3count < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list3Ref)) {
                    RollbackFormsPage2BH.this.list3count++;
                    RollbackFormsPage2BH rollbackFormsPage2BH11 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH11.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH11.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewList3.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList3.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004Father.setEnabled(true);
                    RollbackFormsPage2BH.this.list3count = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH12 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH12.showDialog1(rollbackFormsPage2BH12.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list4Str)) {
                if (RollbackFormsPage2BH.this.list4coumt < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list4Ref)) {
                    RollbackFormsPage2BH.this.list4coumt++;
                    RollbackFormsPage2BH rollbackFormsPage2BH13 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH13.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH13.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewList4.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList4.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004Mother.setEnabled(true);
                    RollbackFormsPage2BH.this.list4coumt = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH14 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH14.showDialog1(rollbackFormsPage2BH14.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list5Str)) {
                if (RollbackFormsPage2BH.this.list5count < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list5Ref)) {
                    RollbackFormsPage2BH.this.list5count++;
                    RollbackFormsPage2BH rollbackFormsPage2BH15 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH15.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH15.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewList5.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList5.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndian.setEnabled(true);
                    RollbackFormsPage2BH.this.list5count = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH16 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH16.showDialog1(rollbackFormsPage2BH16.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list6Str)) {
                if (RollbackFormsPage2BH.this.list6count < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list6ref)) {
                    RollbackFormsPage2BH.this.list6count++;
                    RollbackFormsPage2BH rollbackFormsPage2BH17 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH17.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH17.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewList6.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList6.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileBornOutOfIndia.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileBornOutOfIndia.setEnabled(true);
                    RollbackFormsPage2BH.this.list6count = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH18 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH18.showDialog1(rollbackFormsPage2BH18.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list7Str)) {
                if (RollbackFormsPage2BH.this.list7count < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list7ref)) {
                    RollbackFormsPage2BH.this.list7count++;
                    RollbackFormsPage2BH rollbackFormsPage2BH19 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH19.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH19.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewList7.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList7.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileAcquired.setEnabled(true);
                    RollbackFormsPage2BH.this.list7count = 0;
                    RollbackFormsPage2BH.this.binding.chooseFileAcquired.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH rollbackFormsPage2BH20 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH20.showDialog1(rollbackFormsPage2BH20.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.IRStr2)) {
                if (RollbackFormsPage2BH.this.IRcount2 < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.IRRef2)) {
                    RollbackFormsPage2BH.this.IRcount2++;
                    RollbackFormsPage2BH rollbackFormsPage2BH21 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH21.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH21.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewLayoutIRPage2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageIRPage2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileIR2003Page2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileIR2003Page2.setEnabled(true);
                    RollbackFormsPage2BH.this.IRcount2 = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH22 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH22.showDialog1(rollbackFormsPage2BH22.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before1987Str2)) {
                if (RollbackFormsPage2BH.this.before1987count2 < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list1ref2)) {
                    RollbackFormsPage2BH.this.before1987count2++;
                    RollbackFormsPage2BH rollbackFormsPage2BH23 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH23.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH23.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewLayoutList1Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList1Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987Page2.setEnabled(true);
                    RollbackFormsPage2BH.this.before1987count2 = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH24 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH24.showDialog1(rollbackFormsPage2BH24.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.before2004Str2)) {
                if (RollbackFormsPage2BH.this.before2004count2 < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list1ref2)) {
                    RollbackFormsPage2BH.this.before2004count2++;
                    RollbackFormsPage2BH rollbackFormsPage2BH25 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH25.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH25.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewLayoutBefore2004SelfPage2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageBefore2004SelfPage2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004SelfPage2.setEnabled(true);
                    RollbackFormsPage2BH.this.before1987count2 = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH26 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH26.showDialog1(rollbackFormsPage2BH26.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list2Str2)) {
                if (RollbackFormsPage2BH.this.list2count2 < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list2Ref2)) {
                    RollbackFormsPage2BH.this.list2count2++;
                    RollbackFormsPage2BH rollbackFormsPage2BH27 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH27.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH27.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewLayoutList2Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList2Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004FatherPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004FatherPage2.setEnabled(true);
                    RollbackFormsPage2BH.this.list2count2 = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH28 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH28.showDialog1(rollbackFormsPage2BH28.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.after2004Str2)) {
                if (RollbackFormsPage2BH.this.after2004count2 < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list1ref2)) {
                    RollbackFormsPage2BH.this.after2004count2++;
                    RollbackFormsPage2BH rollbackFormsPage2BH29 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH29.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH29.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewLayoutAfter2004selfPage2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageAfter2004selfPage2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004SelfPage2.setEnabled(true);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.after2004count2 = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH30 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH30.showDialog1(rollbackFormsPage2BH30.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list3Str2)) {
                if (RollbackFormsPage2BH.this.list3count2 < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list3Ref2)) {
                    RollbackFormsPage2BH.this.list3count2++;
                    RollbackFormsPage2BH rollbackFormsPage2BH31 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH31.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH31.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewList3Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList3Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004FatherPage2.setEnabled(true);
                    RollbackFormsPage2BH.this.list3count2 = 0;
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH rollbackFormsPage2BH32 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH32.showDialog1(rollbackFormsPage2BH32.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list4Str2)) {
                if (RollbackFormsPage2BH.this.list4coumt2 < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list4Ref2)) {
                    RollbackFormsPage2BH.this.list4coumt2++;
                    RollbackFormsPage2BH rollbackFormsPage2BH33 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH33.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH33.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewList4Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList4Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004MotherPage2.setEnabled(true);
                    RollbackFormsPage2BH.this.list4coumt2 = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH34 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH34.showDialog1(rollbackFormsPage2BH34.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list5Str2)) {
                if (RollbackFormsPage2BH.this.list5count2 < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list5Ref2)) {
                    RollbackFormsPage2BH.this.list5count2++;
                    RollbackFormsPage2BH rollbackFormsPage2BH35 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH35.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH35.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewList5Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList5Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(true);
                    RollbackFormsPage2BH.this.list5count2 = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH36 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH36.showDialog1(rollbackFormsPage2BH36.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list5Str3)) {
                if (RollbackFormsPage2BH.this.list5count3 < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list5ref3)) {
                    RollbackFormsPage2BH.this.list5count3++;
                    RollbackFormsPage2BH rollbackFormsPage2BH37 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH37.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH37.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewList5Page3.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList5Page3.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(true);
                    RollbackFormsPage2BH.this.list5count3 = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH38 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH38.showDialog1(rollbackFormsPage2BH38.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list6Str2)) {
                if (RollbackFormsPage2BH.this.list6count2 < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list6ref2)) {
                    RollbackFormsPage2BH.this.list6count2++;
                    RollbackFormsPage2BH rollbackFormsPage2BH39 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH39.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH39.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    RollbackFormsPage2BH.this.binding.viewList6Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.imageList6Page2.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.chooseFileBornOutOfIndiaPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                    RollbackFormsPage2BH.this.binding.chooseFileBornOutOfIndiaPage2.setEnabled(true);
                    RollbackFormsPage2BH.this.list6count2 = 0;
                    RollbackFormsPage2BH rollbackFormsPage2BH40 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH40.showDialog1(rollbackFormsPage2BH40.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
                }
            }
            if (this.val$uploadtype.equals(RollbackFormsPage2BH.this.list7Str2)) {
                if (RollbackFormsPage2BH.this.list7count2 < 1 && TextUtils.isEmpty(RollbackFormsPage2BH.this.list7ref2)) {
                    RollbackFormsPage2BH.this.list7count2++;
                    RollbackFormsPage2BH rollbackFormsPage2BH41 = RollbackFormsPage2BH.this;
                    rollbackFormsPage2BH41.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, rollbackFormsPage2BH41.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.binding.viewList7Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.imageList7Page2.setVisibility(8);
                RollbackFormsPage2BH.this.binding.chooseFileAcquiredPage2.setEnabled(true);
                RollbackFormsPage2BH.this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.whitecolor));
                RollbackFormsPage2BH.this.list7count2 = 0;
                RollbackFormsPage2BH rollbackFormsPage2BH42 = RollbackFormsPage2BH.this;
                rollbackFormsPage2BH42.showDialog1(rollbackFormsPage2BH42.alertText, RollbackFormsPage2BH.this.fileNotFoundMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda55
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$74(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$74(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda33
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$75(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog2$75(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) RollbackFormsListBH.class);
        intent.setFlags(603979776);
        intent.putExtra("restart", true);
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialogref(String title, String msg, final String type, final String filepathimg, final String captureFileName) {
        new android.app.AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton(getString(R.string.retryMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda73
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogref$76(filepathimg, captureFileName, type, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogref$76(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
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
            Logger.d(this.TAG, Arrays.toString(strArrSplit));
            if (requestCode == 101) {
                long j = this.filesize;
                if (j < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                    this.binding.viewLayoutList2.setVisibility(0);
                    this.binding.cancelList2.setVisibility(0);
                    this.binding.list2Name.setVisibility(0);
                    this.binding.list2Size.setVisibility(0);
                    this.binding.imageList2.setVisibility(0);
                    ImageView imageView5 = this.binding.imageList2;
                    byte[] bArr5 = this.pdfbyteArray;
                    imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                    this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.imageList2.setVisibility(0);
                ImageView imageView6 = this.binding.imageList2;
                byte[] bArr6 = this.pdfbyteArray;
                imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list2Size.setText(dRound3 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 111) {
                long j7 = this.filesize;
                if (j7 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                    this.binding.viewLayoutList2.setVisibility(0);
                    this.binding.cancelList2.setVisibility(0);
                    this.binding.list2Name.setVisibility(0);
                    this.binding.list2Size.setVisibility(0);
                    this.binding.imageList2.setVisibility(0);
                    ImageView imageView7 = this.binding.imageList2;
                    byte[] bArr7 = this.pdfbyteArray;
                    imageView7.setImageBitmap(BitmapFactory.decodeByteArray(bArr7, 0, bArr7.length));
                    this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.imageList2.setVisibility(0);
                ImageView imageView8 = this.binding.imageList2;
                byte[] bArr8 = this.pdfbyteArray;
                imageView8.setImageBitmap(BitmapFactory.decodeByteArray(bArr8, 0, bArr8.length));
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.list2Name.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list2Size.setText(dRound4 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 103) {
                long j9 = this.filesize;
                if (j9 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr2);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.IRStr2);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str2);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before1987Str2);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str2);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.before2004Str2);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str2);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.after2004Str2);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list3Str2);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list4Str2);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str2);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str2);
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
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str2);
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
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list6Str2);
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
            if (requestCode == 210) {
                long j43 = this.filesize;
                if (j43 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str2);
                    this.binding.viewList7Page2.setVisibility(0);
                    this.binding.cancelList7Page2.setVisibility(0);
                    this.binding.list7NamePage2.setVisibility(0);
                    this.binding.list7SizePage2.setVisibility(0);
                    this.binding.imageList7Page2.setVisibility(0);
                    ImageView imageView43 = this.binding.imageList7Page2;
                    byte[] bArr43 = this.pdfbyteArray;
                    imageView43.setImageBitmap(BitmapFactory.decodeByteArray(bArr43, 0, bArr43.length));
                    this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAcquiredPage2.setEnabled(false);
                    this.binding.list7NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list7SizePage2.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j43 > 2048) {
                    this.binding.viewList7Page2.setVisibility(8);
                    this.binding.cancelList7Page2.setVisibility(8);
                    this.binding.list7NamePage2.setVisibility(8);
                    this.binding.list7SizePage2.setVisibility(8);
                    this.binding.imageList7Page2.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j44 = j43 / 1024;
                this.filesize = j44;
                double dRound22 = Math.round(j44 * 100.0d) / 100.0d;
                if (dRound22 > 2.0d) {
                    this.binding.viewList7Page2.setVisibility(8);
                    showDialog1(this.alertText, this.imgmsg);
                    return;
                }
                uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list7Str2);
                this.binding.viewList7Page2.setVisibility(0);
                this.binding.cancelList7Page2.setVisibility(0);
                this.binding.list7NamePage2.setVisibility(0);
                this.binding.list7SizePage2.setVisibility(0);
                this.binding.imageList7Page2.setVisibility(0);
                ImageView imageView44 = this.binding.imageList7Page2;
                byte[] bArr44 = this.pdfbyteArray;
                imageView44.setImageBitmap(BitmapFactory.decodeByteArray(bArr44, 0, bArr44.length));
                this.binding.chooseFileAcquiredPage2.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAcquiredPage2.setEnabled(false);
                this.binding.list7NamePage2.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list7SizePage2.setText(dRound22 + getString(R.string.mbMsg));
                return;
            }
            if (requestCode == 212) {
                long j45 = this.filesize;
                if (j45 < 1024) {
                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.list5Str3);
                    this.binding.viewList5Page3.setVisibility(0);
                    this.binding.cancelList5Page3.setVisibility(0);
                    this.binding.list5NamePage3.setVisibility(0);
                    this.binding.list5SizePage3.setVisibility(0);
                    this.binding.imageList5Page3.setVisibility(0);
                    ImageView imageView45 = this.binding.imageList5Page3;
                    byte[] bArr45 = this.pdfbyteArray;
                    imageView45.setImageBitmap(BitmapFactory.decodeByteArray(bArr45, 0, bArr45.length));
                    this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(false);
                    this.binding.list5NamePage3.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.list5SizePage3.setText(this.filesize + getString(R.string.kbMsg));
                    return;
                }
                if (j45 > 2048) {
                    this.binding.viewList5Page3.setVisibility(8);
                    this.binding.cancelList5Page3.setVisibility(8);
                    this.binding.list5NamePage3.setVisibility(8);
                    this.binding.list5SizePage3.setVisibility(8);
                    this.binding.imageList5Page3.setVisibility(8);
                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                    return;
                }
                long j46 = j45 / 1024;
                this.filesize = j46;
                double dRound23 = Math.round(j46 * 100.0d) / 100.0d;
                if (dRound23 > 2.0d) {
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
                ImageView imageView46 = this.binding.imageList5Page3;
                byte[] bArr46 = this.pdfbyteArray;
                imageView46.setImageBitmap(BitmapFactory.decodeByteArray(bArr46, 0, bArr46.length));
                this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(this.greycolor));
                this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(false);
                this.binding.list5NamePage3.setText(strArrSplit[strArrSplit.length - 1]);
                this.binding.list5SizePage3.setText(dRound23 + getString(R.string.mbMsg));
            }
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
        this.oldAcS = this.bundle.getString("oldAcNo");
        this.OldPartS = this.bundle.getString("oldPartNo");
        this.OldPslS = this.bundle.getString("oldPslNo");
        this.IRFlag = this.bundle.getString("preRevisionVoterFlg");
        if (this.choice.equalsIgnoreCase(getString(R.string.indian_citizen_by))) {
            this.IRFlag = "Y";
        } else {
            this.IRFlag = "N";
        }
        this.IRRef = this.bundle.getString("preRevisionVoterDocUrl");
        this.IRRef2 = this.bundle.getString("peRevisionVoterDocUrlPg2");
        this.surveyChannel = this.bundle.getString("surveyChannel");
        this.binding.IROldAcNo.setText(this.oldAcS);
        this.binding.IROldPartNo.setText(this.OldPartS);
        this.binding.IROldPslNo.setText(this.OldPslS);
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
        this.isThisYouRel = this.bundle.getString("isThisYouRel");
        String string = this.bundle.getString("citizenshipTypeCat");
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
        if (this.choice.equalsIgnoreCase(getString(R.string.born_india)) && this.citizenshipTypeCatTemp.equals("CAT-4")) {
            getList1("LIST-1");
            getList1("LIST-3");
            getList1("LIST-4");
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
                    String str8 = this.dobTemp;
                    if (str8 != null) {
                        this.DoB = this.simple.parse(str8.trim());
                    }
                } catch (ParseException e) {
                    Logger.d("RollbackFormsPage2BH", e.toString());
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
        String str9 = this.list1ref2;
        if (str9 != null && !str9.equals("")) {
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
                    Logger.d("RollbackFormsPage2BH", e2.toString());
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
        String str10 = this.list3Ref;
        if (str10 != null && !str10.equals("") && string.equals("CAT-3")) {
            if (!this.list3Ref.endsWith(".pdf")) {
                getFileforSIR9(this.list3Ref);
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.imageList2.setVisibility(0);
                this.binding.list2Name.setText(this.list3Ref);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
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
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
            }
        }
        String str11 = this.list3Ref2;
        if (str11 != null && !str11.equals("") && string.equals("CAT-3")) {
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
        String str12 = this.list4Ref;
        if (str12 != null && !str12.equals("") && string.equals("CAT-3")) {
            if (!this.list4Ref.endsWith(".pdf")) {
                getFileforSIR9(this.list4Ref);
                this.binding.viewLayoutList2.setVisibility(0);
                this.binding.imageList2.setVisibility(0);
                this.binding.list2Name.setText(this.list4Ref);
                this.binding.list2Name.setVisibility(0);
                this.binding.list2Size.setVisibility(0);
                this.binding.cancelList2.setVisibility(0);
                this.binding.chooseFileBefore2004Father.setEnabled(false);
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
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
                this.binding.chooseFileBefore2004Father.setTextColor(Color.parseColor(this.greycolor));
            }
        }
        String str13 = this.list4Ref2;
        if (str13 != null && !str13.equals("") && string.equals("CAT-3")) {
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
        }
        if (!TextUtils.isEmpty(this.list4code)) {
            this.binding.betweenParentMotherRb.setChecked(true);
        }
        if (!TextUtils.isEmpty(this.list5code)) {
            getList1("LIST-5");
        }
        if (!TextUtils.isEmpty(this.fatherNationality) && !TextUtils.isEmpty(this.motherNationality) && this.fatherNationality.equalsIgnoreCase(this.motherNationality)) {
            this.binding.parentYesRb.setChecked(true);
            getList1("LIST-3");
            getList1("LIST-4");
            this.binding.viewFatherOldLayout.setVisibility(8);
            this.binding.viewMotherOldLayout.setVisibility(8);
            this.binding.llParentLayout.setVisibility(0);
            this.binding.fatherLayout.setVisibility(0);
            this.binding.motherLayout.setVisibility(0);
            this.binding.forIndianParentLayout.setVisibility(8);
            this.binding.selectParentLayout.setVisibility(8);
            this.binding.llNotIndianLayout.setVisibility(8);
            this.binding.forNonIndianParentLayout.setVisibility(8);
            String str14 = this.list3Ref;
            if (str14 != null && !str14.equals("")) {
                getFileforSIR11(this.list3Ref);
            }
            String str15 = this.list3Ref2;
            if (str15 != null && !str15.equals("")) {
                getFileforSIR12(this.list3Ref2);
            }
            String str16 = this.list4Ref;
            if (str16 != null && !str16.equals("")) {
                getFileforSIR13(this.list4Ref);
            }
            String str17 = this.list4Ref2;
            if (str17 != null && !str17.equals("")) {
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
            getList1("LIST-5");
            if (this.fatherNationality.equalsIgnoreCase("Indian")) {
                getList1("LIST-3");
                this.binding.parentFatherRb.setChecked(true);
                String str18 = this.list3Ref;
                if (str18 != null && !str18.equals("")) {
                    getFileforSIR11(this.list3Ref);
                }
                String str19 = this.list3Ref2;
                if (str19 != null && !str19.equals("")) {
                    getFileforSIR12(this.list3Ref2);
                }
                String str20 = this.list5Ref;
                if (str20 != null && !str20.equals("")) {
                    getFileforSIR15(this.list5Ref);
                }
                String str21 = this.list5Ref2;
                if (str21 != null && !str21.equals("")) {
                    getFileforSIR16(this.list5Ref2);
                }
                String str22 = this.list5ref3;
                if (str22 != null && !str22.equals("")) {
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
                getList1("LIST-4");
                this.binding.parentMotherRb.setChecked(true);
                String str23 = this.list4Ref;
                if (str23 != null && !str23.equals("")) {
                    getFileforSIR13(this.list4Ref);
                }
                String str24 = this.list4Ref2;
                if (str24 != null && !str24.equals("")) {
                    getFileforSIR14(this.list4Ref2);
                }
                String str25 = this.list5Ref;
                if (str25 != null && !str25.equals("")) {
                    getFileforSIR15(this.list5Ref);
                }
                String str26 = this.list5Ref2;
                if (str26 != null && !str26.equals("")) {
                    getFileforSIR16(this.list5Ref2);
                }
                String str27 = this.list5ref3;
                if (str27 != null && !str27.equals("")) {
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
        this.binding.parentRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.19
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (RollbackFormsPage2BH.this.binding.parentYesRb.isChecked()) {
                    RollbackFormsPage2BH.this.binding.viewFatherOldLayout.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.viewMotherOldLayout.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.llParentLayout.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.fatherLayout.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.motherLayout.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.forIndianParentLayout.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.selectParentLayout.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.llNotIndianLayout.setVisibility(8);
                    RollbackFormsPage2BH.this.binding.forNonIndianParentLayout.setVisibility(8);
                }
            }
        });
        this.binding.indianparentRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH.20
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
            }
        });
    }

    public void getFileforSIR1(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass21(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$21, reason: invalid class name */
    class AnonymousClass21 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass21(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element1, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList6.setImageBitmap(bitmapDecodeByteArray);
                }
                if (RollbackFormsPage2BH.this.base64element1.isEmpty() || RollbackFormsPage2BH.this.base64element1.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList6.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$21$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$21$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR2(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass22(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$22, reason: invalid class name */
    class AnonymousClass22 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass22(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element2 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element2, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList6Page2.setImageBitmap(bitmapDecodeByteArray);
                }
                if (RollbackFormsPage2BH.this.base64element2.isEmpty() || RollbackFormsPage2BH.this.base64element2.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList6Page2.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$22$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$22$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR3(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass23(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$23, reason: invalid class name */
    class AnonymousClass23 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass23(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element3 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element3, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList7.setImageBitmap(bitmapDecodeByteArray);
                }
                if (RollbackFormsPage2BH.this.base64element3.isEmpty() || RollbackFormsPage2BH.this.base64element3.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList7.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$23$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$23$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR4(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass24(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$24, reason: invalid class name */
    class AnonymousClass24 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass24(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element4 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element4, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList7Page2.setImageBitmap(bitmapDecodeByteArray);
                }
                if (RollbackFormsPage2BH.this.base64element4.isEmpty() || RollbackFormsPage2BH.this.base64element4.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList7Page2.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$24$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$24$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR5(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass25(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$25, reason: invalid class name */
    class AnonymousClass25 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass25(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element5 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element5, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageIR.setImageBitmap(bitmapDecodeByteArray);
                }
                if (RollbackFormsPage2BH.this.base64element5.isEmpty() || RollbackFormsPage2BH.this.base64element5.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageIR.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$25$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$25$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR5(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR6(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass26(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$26, reason: invalid class name */
    class AnonymousClass26 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass26(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element6 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element6, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageIRPage2.setImageBitmap(bitmapDecodeByteArray);
                }
                if (RollbackFormsPage2BH.this.base64element6.isEmpty() || RollbackFormsPage2BH.this.base64element6.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageIRPage2.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$26$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$26$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR6(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR7(String fileref, String category) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass27(fileref, category));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$27, reason: invalid class name */
    class AnonymousClass27 implements Callback<JsonObject> {
        final /* synthetic */ String val$category;
        final /* synthetic */ String val$fileref;

        AnonymousClass27(final String val$fileref, final String val$category) {
            this.val$fileref = val$fileref;
            this.val$category = val$category;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element7 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element7, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-2")) {
                    RollbackFormsPage2BH.this.binding.imageList1.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageBefore2004Self.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageAfter2004self.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.viewLayoutList1.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageList1.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list1Name.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.list1Name.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list1Size.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelList1.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-2")) {
                    RollbackFormsPage2BH.this.binding.viewLayoutList1.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageList1.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list1Name.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.list1Name.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list1Size.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelList1.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                    RollbackFormsPage2BH.this.binding.imageList1.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-3")) {
                    RollbackFormsPage2BH.this.binding.imageList1.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageBefore2004Self.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageAfter2004self.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.viewLayoutBefore2004Self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageBefore2004Self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.before2004SelfName.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.before2004SelfName.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.before2004SelfSize.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelBefore2004Self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004Self.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-3")) {
                    RollbackFormsPage2BH.this.binding.viewLayoutBefore2004Self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageBefore2004Self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.before2004SelfName.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.before2004SelfName.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.before2004SelfSize.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelBefore2004Self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004Self.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004Self.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                    RollbackFormsPage2BH.this.binding.imageBefore2004Self.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-4")) {
                    RollbackFormsPage2BH.this.binding.imageList1.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageBefore2004Self.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageAfter2004self.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.viewLayoutAfter2004self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageAfter2004self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.after2004selfName.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.after2004selfName.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.after2004selfSize.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelAfter2004self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004Self.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-4")) {
                    RollbackFormsPage2BH.this.binding.viewLayoutAfter2004self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageAfter2004self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.after2004selfName.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.after2004selfName.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.after2004selfSize.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelAfter2004self.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004Self.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004Self.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                    RollbackFormsPage2BH.this.binding.imageAfter2004self.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (RollbackFormsPage2BH.this.base64element7.isEmpty() || RollbackFormsPage2BH.this.base64element7.equals("null")) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image);
                    RollbackFormsPage2BH.this.binding.imageList1.setImageBitmap(bitmapDecodeResource);
                    RollbackFormsPage2BH.this.binding.imageBefore2004Self.setImageBitmap(bitmapDecodeResource);
                    RollbackFormsPage2BH.this.binding.imageAfter2004self.setImageBitmap(bitmapDecodeResource);
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r6 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    final String str3 = this.val$category;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$27$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str4, String str5) {
                            this.f$0.lambda$onResponse$1(str2, str3, i, str4, str5);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str3 + " " + str4);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$27$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str3;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str4);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str3);
                RollbackFormsPage2BH.this.getFileforSIR7(str, str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR8(String fileref, String category) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass28(fileref, category));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$28, reason: invalid class name */
    class AnonymousClass28 implements Callback<JsonObject> {
        final /* synthetic */ String val$category;
        final /* synthetic */ String val$fileref;

        AnonymousClass28(final String val$fileref, final String val$category) {
            this.val$fileref = val$fileref;
            this.val$category = val$category;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element8 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element8, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-2")) {
                    RollbackFormsPage2BH.this.binding.imageList1Page2.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageBefore2004SelfPage2.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageAfter2004selfPage2.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.viewLayoutList1Page2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageList1Page2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list1NamePage2.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.list1NamePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list1SizePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelList1Page2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987Page2.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-2")) {
                    RollbackFormsPage2BH.this.binding.viewLayoutList1Page2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageList1Page2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list1NamePage2.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.list1NamePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list1SizePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelList1Page2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987Page2.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore1987Page2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                    RollbackFormsPage2BH.this.binding.imageList1Page2.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-3")) {
                    RollbackFormsPage2BH.this.binding.imageList1Page2.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageBefore2004SelfPage2.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageAfter2004selfPage2.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.viewLayoutBefore2004SelfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageBefore2004SelfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.before2004SelfNamePage2.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.before2004SelfNamePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.before2004SelfSizePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelBefore2004SelfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004SelfPage2.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-3")) {
                    RollbackFormsPage2BH.this.binding.viewLayoutBefore2004SelfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageBefore2004SelfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.before2004SelfNamePage2.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.before2004SelfNamePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.before2004SelfSizePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelBefore2004SelfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004SelfPage2.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileBefore2004SelfPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                    RollbackFormsPage2BH.this.binding.imageBefore2004SelfPage2.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (!this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-4")) {
                    RollbackFormsPage2BH.this.binding.imageList1Page2.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageBefore2004SelfPage2.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.imageAfter2004selfPage2.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.viewLayoutAfter2004selfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageAfter2004selfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.after2004selfNamePage2.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.after2004selfNamePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.after2004selfSizePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelAfter2004selfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004SelfPage2.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                } else if (this.val$fileref.endsWith(".pdf") && this.val$category.equals("CAT-4")) {
                    RollbackFormsPage2BH.this.binding.viewLayoutAfter2004selfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageAfter2004selfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.after2004selfNamePage2.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.after2004selfNamePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.after2004selfSizePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelAfter2004selfPage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004SelfPage2.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004SelfPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                    RollbackFormsPage2BH.this.binding.imageAfter2004selfPage2.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (RollbackFormsPage2BH.this.base64element8.isEmpty() || RollbackFormsPage2BH.this.base64element8.equals("null")) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image);
                    RollbackFormsPage2BH.this.binding.imageList1Page2.setImageBitmap(bitmapDecodeResource);
                    RollbackFormsPage2BH.this.binding.imageBefore2004SelfPage2.setImageBitmap(bitmapDecodeResource);
                    RollbackFormsPage2BH.this.binding.imageAfter2004selfPage2.setImageBitmap(bitmapDecodeResource);
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r6 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    final String str3 = this.val$category;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$28$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str4, String str5) {
                            this.f$0.lambda$onResponse$1(str2, str3, i, str4, str5);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str3 + " " + str4);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$28$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str3;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str4);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str3);
                RollbackFormsPage2BH.this.getFileforSIR8(str, str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR9(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass29(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$29, reason: invalid class name */
    class AnonymousClass29 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass29(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element9 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element9, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList2.setImageBitmap(bitmapDecodeByteArray);
                }
                if (RollbackFormsPage2BH.this.base64element9.isEmpty() || RollbackFormsPage2BH.this.base64element9.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList2.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$29$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$29$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR9(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR10(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass30(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$30, reason: invalid class name */
    class AnonymousClass30 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass30(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element10 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element10, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList2Page2.setImageBitmap(bitmapDecodeByteArray);
                }
                if (RollbackFormsPage2BH.this.base64element10.isEmpty() || RollbackFormsPage2BH.this.base64element10.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList2Page2.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$30$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$30$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR10(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR11(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass31(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$31, reason: invalid class name */
    class AnonymousClass31 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass31(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element11 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element11, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                RollbackFormsPage2BH.this.binding.viewList3.setVisibility(0);
                RollbackFormsPage2BH.this.binding.imageList3.setVisibility(0);
                RollbackFormsPage2BH.this.binding.list3Name.setText(this.val$fileref);
                RollbackFormsPage2BH.this.binding.list3Name.setVisibility(0);
                RollbackFormsPage2BH.this.binding.list3Size.setVisibility(0);
                RollbackFormsPage2BH.this.binding.cancelList3.setVisibility(0);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004Father.setEnabled(false);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004Father.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList3.setImageBitmap(bitmapDecodeByteArray);
                } else {
                    RollbackFormsPage2BH.this.binding.imageList3.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (RollbackFormsPage2BH.this.base64element11.isEmpty() || RollbackFormsPage2BH.this.base64element11.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList3.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$31$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$31$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR11(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR12(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass32(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$32, reason: invalid class name */
    class AnonymousClass32 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass32(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element12 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element12, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                RollbackFormsPage2BH.this.binding.viewList3Page2.setVisibility(0);
                RollbackFormsPage2BH.this.binding.imageList3Page2.setVisibility(0);
                RollbackFormsPage2BH.this.binding.list3NamePage2.setText(this.val$fileref);
                RollbackFormsPage2BH.this.binding.list3NamePage2.setVisibility(0);
                RollbackFormsPage2BH.this.binding.list3SizePage2.setVisibility(0);
                RollbackFormsPage2BH.this.binding.cancelList3Page2.setVisibility(0);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004FatherPage2.setEnabled(false);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004FatherPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList3Page2.setImageBitmap(bitmapDecodeByteArray);
                } else {
                    RollbackFormsPage2BH.this.binding.imageList3Page2.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (RollbackFormsPage2BH.this.base64element12.isEmpty() || RollbackFormsPage2BH.this.base64element12.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList3Page2.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$32$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$32$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR12(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR13(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass33(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$33, reason: invalid class name */
    class AnonymousClass33 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass33(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element13 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element13, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                RollbackFormsPage2BH.this.binding.viewList4.setVisibility(0);
                RollbackFormsPage2BH.this.binding.imageList4.setVisibility(0);
                RollbackFormsPage2BH.this.binding.list4Name.setText(this.val$fileref);
                RollbackFormsPage2BH.this.binding.list4Name.setVisibility(0);
                RollbackFormsPage2BH.this.binding.list4Size.setVisibility(0);
                RollbackFormsPage2BH.this.binding.cancelList4.setVisibility(0);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004Mother.setEnabled(false);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004Mother.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList4.setImageBitmap(bitmapDecodeByteArray);
                } else {
                    RollbackFormsPage2BH.this.binding.imageList4.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (RollbackFormsPage2BH.this.base64element13.isEmpty() || RollbackFormsPage2BH.this.base64element13.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList4.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$33$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$33$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR13(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR14(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass34(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$34, reason: invalid class name */
    class AnonymousClass34 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass34(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element14 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element14, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                RollbackFormsPage2BH.this.binding.viewList4Page2.setVisibility(0);
                RollbackFormsPage2BH.this.binding.imageList4Page2.setVisibility(0);
                RollbackFormsPage2BH.this.binding.list4NamePage2.setText(this.val$fileref);
                RollbackFormsPage2BH.this.binding.list4NamePage2.setVisibility(0);
                RollbackFormsPage2BH.this.binding.list4SizePage2.setVisibility(0);
                RollbackFormsPage2BH.this.binding.cancelList4Page2.setVisibility(0);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004MotherPage2.setEnabled(false);
                RollbackFormsPage2BH.this.binding.chooseFileAfter2004MotherPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList4Page2.setImageBitmap(bitmapDecodeByteArray);
                } else {
                    RollbackFormsPage2BH.this.binding.imageList4Page2.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (RollbackFormsPage2BH.this.base64element14.isEmpty() || RollbackFormsPage2BH.this.base64element14.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList4Page2.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$34$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$34$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR14(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR15(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass35(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$35, reason: invalid class name */
    class AnonymousClass35 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass35(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element15 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element15, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList5.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.viewList5.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageList5.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list5Name.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.list5Name.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list5Size.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelList5.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndian.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndian.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                } else {
                    RollbackFormsPage2BH.this.binding.imageList5.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (RollbackFormsPage2BH.this.base64element15.isEmpty() || RollbackFormsPage2BH.this.base64element15.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList5.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$35$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$35$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR15(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR16(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass36(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$36, reason: invalid class name */
    class AnonymousClass36 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass36(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element16 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element16, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList5Page2.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.viewList5Page2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageList5Page2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list5NamePage2.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.list5NamePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list5SizePage2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelList5Page2.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage2.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage2.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                } else {
                    RollbackFormsPage2BH.this.binding.imageList5Page2.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (RollbackFormsPage2BH.this.base64element16.isEmpty() || RollbackFormsPage2BH.this.base64element16.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList5Page2.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$36$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$36$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR16(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR17(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass37(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$37, reason: invalid class name */
    class AnonymousClass37 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass37(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
                if (RollbackFormsPage2BH.this.alertDialog != null) {
                    RollbackFormsPage2BH.this.alertDialog.dismiss();
                }
                RollbackFormsPage2BH.this.base64element17 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(RollbackFormsPage2BH.this.base64element17, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    RollbackFormsPage2BH.this.binding.imageList5Page3.setImageBitmap(bitmapDecodeByteArray);
                    RollbackFormsPage2BH.this.binding.viewList5Page3.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.imageList5Page3.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list5NamePage3.setText(this.val$fileref);
                    RollbackFormsPage2BH.this.binding.list5NamePage3.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.list5SizePage3.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.cancelList5Page3.setVisibility(0);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage3.setEnabled(false);
                    RollbackFormsPage2BH.this.binding.chooseFileAfter2004NotIndianPage3.setTextColor(Color.parseColor(RollbackFormsPage2BH.this.greycolor));
                } else {
                    RollbackFormsPage2BH.this.binding.imageList5Page3.setImageDrawable(ContextCompat.getDrawable(RollbackFormsPage2BH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (RollbackFormsPage2BH.this.base64element17.isEmpty() || RollbackFormsPage2BH.this.base64element17.equals("null")) {
                    RollbackFormsPage2BH.this.binding.imageList5Page3.setImageBitmap(BitmapFactory.decodeResource(RollbackFormsPage2BH.this.getResources(), R.drawable.blo_dummy_image));
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                    ?? r5 = RollbackFormsPage2BH.this;
                    String str = ((RollbackFormsPage2BH) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$37$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag);
                }
            } else {
                try {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, new JSONObject(response.errorBody().string()).optString(RollbackFormsPage2BH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (RollbackFormsPage2BH.this.alertDialog != null) {
                        RollbackFormsPage2BH.this.alertDialog.dismiss();
                    }
                    Logger.e(RollbackFormsPage2BH.this.TAG, e.getMessage());
                }
            }
            RollbackFormsPage2BH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH] */
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
            RollbackFormsPage2BH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsPage2BH.this.commomUtility;
                ?? r5 = RollbackFormsPage2BH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$37$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsPage2BH.this.token = "Bearer " + str2;
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setToken("Bearer " + str2);
                RollbackFormsPage2BH.this.getFileforSIR17(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsPage2BH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsPage2BH.this.startActivity(new Intent((Context) RollbackFormsPage2BH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(RollbackFormsPage2BH.this.TAG, RollbackFormsPage2BH.this.comingTag + t.getMessage());
            if (RollbackFormsPage2BH.this.alertDialog != null) {
                RollbackFormsPage2BH.this.alertDialog.dismiss();
            }
            RollbackFormsPage2BH rollbackFormsPage2BH = RollbackFormsPage2BH.this;
            rollbackFormsPage2BH.showDialog1(rollbackFormsPage2BH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    private void showPersonPdfDialog(String base64elementValue, String pdfNameFromObjectStorage) throws IOException {
        Log.d("Param1= ", base64elementValue);
        Log.d("Param2= ", pdfNameFromObjectStorage);
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        Uri saveImagePath2 = getSaveImagePath2(base64elementValue, ".pdf");
        File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + this.saveImageFileName);
        Log.d("Param3= ", saveImagePath2.getPath());
        new File((String) Objects.requireNonNull(saveImagePath2.getPath()));
        pDFViewFindViewById.fromFile(file).load();
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsPage2BH$$ExternalSyntheticLambda0
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
}
