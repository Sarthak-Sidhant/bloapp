package in.gov.eci.bloapp.views.fragments.voterforms.migration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentMigrationPreviewFormBinding;
import in.gov.eci.bloapp.model.app_model.FormsinDraftMigrationModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.PreviewViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.newsir.model.DeclarationFormPayload;
import io.reactivex.annotations.SchedulerSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Migration_preview_Form extends Hilt_Migration_preview_Form {
    private static final String ALERT = "Alert";
    private static final String BLOAPP = "BLOAPP";
    private static final String FAILURE = "coming in onFailure ";
    private static final String MESSAGE = "message";
    private static final String MIGRATION_CATCH_MSG = "migration preview form";
    private static final String OBJECTSTORAGE = "objectstorage";
    private static final String SESSION = "Session Expired. Please Login again.";
    private static final String SESSION_TOKEN = "Session token expired please Login";
    ArrayList<String> List1docCode;
    ArrayList<String> List1docName;
    ArrayList<String> List2docCode;
    ArrayList<String> List2docName;
    ArrayList<String> List3docCode;
    ArrayList<String> List3docName;
    ArrayList<String> List4docCode;
    ArrayList<String> List4docName;
    ArrayList<String> List5docCode;
    ArrayList<String> List5docName;
    ArrayList<String> List6docCode;
    ArrayList<String> List6docName;
    ArrayList<String> List7docCode;
    ArrayList<String> List7docName;
    ArrayList<String> List8docCode;
    ArrayList<String> List8docName;
    String aadharType;
    String after2004FatherFileName;
    String after2004FatherFileSize;
    String after2004MotherFileName;
    String after2004MotherFileSize;
    String after2004ParentNameNotindian;
    String after2004docURLFather;
    String after2004docURLMother;
    String after2004doctypeFather;
    String after2004doctypeMother;
    String after2004isParentIndian;
    AlertDialog alertDialog;
    String anexSignFileName;
    String anexSignFileSize;
    String anxDSign;
    String anxDSignUrl;
    String appfor;
    private String atkband;
    String base64element;
    String before2004ParentType;
    String before2004docFileName;
    String before2004docFileSize;
    private BloFragmentMigrationPreviewFormBinding binding;
    String blostatecode;
    String bornOutofIndiaFileName;
    String bornOutofIndiaFileSize;
    String bornOutofIndiadocURL;
    String bornOutofIndiadoctype;
    Retrofit.Builder builder;
    String cat;
    String choice;
    String citizenAquuiredFileName;
    String citizenAquuiredFileSize;
    String citizenAquuireddocURL;
    String citizenAquuireddoctype;
    String delimeter;
    String docURLFather;
    String docURLMother;
    String doctypeFather;
    String doctypeMother;
    String doctypeselFileSize;
    String doctypeself;
    String doctypeselfFileName;
    String doctypeselfURL;
    String emailType;
    SimpleDateFormat format;
    DeclarationFormPayload formverificationPayload;
    private Boolean isdeclarationEnabled;
    String jpeg;
    String list1;
    String list1Code;
    String list1CodeName;
    String list2;
    String list2code;
    String list2codeName;
    String list3;
    String list3code;
    String list3codeName;
    String list4;
    String list4code;
    String list4codeName;
    String list5;
    String list5code;
    String list5codeName;
    String list6;
    String list6code;
    String list6codeName;
    String list7;
    String list7code;
    String list7codeName;
    String list8code;
    String list8codeName;
    String location;
    String mobileType;
    private JsonObject payloadData1;
    String referenceNumber;
    private String referencelinkFIR;
    private String referencelinkSOR;
    private String referencelinkdisability;
    private String referencerlinkcoe1;
    private String referencerlinkcoe2;
    private String referencerlinkcoe3;
    private String referencerlinkcoe4;
    private String referencerlinkcoe5;
    private String referencerlinkcoe6;
    private String referencerlinkcoe8;
    private String refreshToken;
    Retrofit retrofit;
    private String rtkband;
    String selectDocumentType;
    String submitdate;
    String token;
    PreviewViewModel viewModel;
    Date subdate = new Date();
    CommomUtility commonUtilClass = new CommomUtility();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();

    public Migration_preview_Form() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.format = simpleDateFormat;
        this.submitdate = simpleDateFormat.format(this.subdate);
        this.delimeter = "‡";
        this.token = "";
        this.referencelinkSOR = "";
        this.referencelinkdisability = "";
        this.referencelinkFIR = "";
        this.doctypeselfURL = "";
        this.doctypeselfFileName = "";
        this.doctypeselFileSize = "";
        this.before2004ParentType = "";
        this.doctypeFather = "";
        this.doctypeMother = "";
        this.docURLFather = "";
        this.docURLMother = "";
        this.before2004docFileName = "";
        this.before2004docFileSize = "";
        this.after2004isParentIndian = "";
        this.after2004ParentNameNotindian = "";
        this.after2004doctypeFather = "";
        this.after2004doctypeMother = "";
        this.after2004docURLFather = "";
        this.after2004docURLMother = "";
        this.after2004MotherFileName = "";
        this.after2004MotherFileSize = "";
        this.after2004FatherFileName = "";
        this.after2004FatherFileSize = "";
        this.bornOutofIndiadoctype = "";
        this.bornOutofIndiadocURL = "";
        this.bornOutofIndiaFileName = "";
        this.bornOutofIndiaFileSize = "";
        this.citizenAquuireddoctype = "";
        this.citizenAquuireddocURL = "";
        this.citizenAquuiredFileName = "";
        this.citizenAquuiredFileSize = "";
        this.anexSignFileName = "";
        this.anexSignFileSize = "";
        this.choice = "";
        this.anxDSignUrl = "";
        this.cat = "";
        this.doctypeself = "";
        this.jpeg = ".jpeg";
        this.List1docName = new ArrayList<>();
        this.List1docCode = new ArrayList<>();
        this.List2docName = new ArrayList<>();
        this.List2docCode = new ArrayList<>();
        this.List3docName = new ArrayList<>();
        this.List3docCode = new ArrayList<>();
        this.List4docName = new ArrayList<>();
        this.List4docCode = new ArrayList<>();
        this.List5docName = new ArrayList<>();
        this.List5docCode = new ArrayList<>();
        this.List6docName = new ArrayList<>();
        this.List6docCode = new ArrayList<>();
        this.List7docName = new ArrayList<>();
        this.List7docCode = new ArrayList<>();
        this.List8docName = new ArrayList<>();
        this.List8docCode = new ArrayList<>();
        this.selectDocumentType = "Please Select Document Type";
        this.anxDSign = "BLO Sign";
        this.list1 = "LIST-1";
        this.list2 = "LIST-2";
        this.list3 = "LIST-3";
        this.list4 = "LIST-4";
        this.list5 = "LIST-5";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentMigrationPreviewFormBinding.inflate(getLayoutInflater());
        this.viewModel = (PreviewViewModel) new ViewModelProvider(this).get(PreviewViewModel.class);
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.atkband = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.formverificationPayload = new DeclarationFormPayload();
        View viewInflate = inflater.inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.isdeclarationEnabled = Boolean.valueOf(arguments.getBoolean("isdeclarationEnabled"));
            this.location = arguments.getString(Constants.LOCATION);
            dataoneditbutton(arguments.getString("draftname"), arguments.getString("date"), "Form 8");
            this.formverificationPayload = (DeclarationFormPayload) arguments.getParcelable("declarationForm");
        }
        this.binding.AadhaarNumber.setEnabled(false);
        this.binding.notFurnish.setEnabled(false);
        this.binding.SelfNumber.setEnabled(false);
        this.binding.fatherNumber.setEnabled(false);
        this.binding.selfemail.setEnabled(false);
        this.binding.fatherEmail.setEnabled(false);
        this.binding.SOR.setEnabled(false);
        this.binding.COR.setEnabled(false);
        this.binding.IOR.setEnabled(false);
        this.binding.ROM.setEnabled(false);
        this.binding.Locomotive.setEnabled(false);
        this.binding.Visual.setEnabled(false);
        this.binding.DeafDumb.setEnabled(false);
        this.binding.lost.setEnabled(false);
        this.binding.destroyed.setEnabled(false);
        this.binding.Multi.setEnabled(false);
        this.binding.Other.setEnabled(false);
        this.binding.cb1.setEnabled(false);
        this.binding.cb2.setEnabled(false);
        this.binding.cb3.setEnabled(false);
        this.binding.cb4.setEnabled(false);
        this.binding.cb5.setEnabled(false);
        this.binding.cb6.setEnabled(false);
        this.binding.cb7.setEnabled(false);
        this.binding.cb8.setEnabled(false);
        this.binding.yes.setEnabled(false);
        this.binding.No.setEnabled(false);
        this.binding.OtherAddProof.setVisibility(8);
        this.binding.OtherAddProofTv.setVisibility(8);
        this.binding.SORLayout.setVisibility(8);
        this.binding.COELayout.setVisibility(8);
        this.binding.IORTitle.setVisibility(8);
        this.binding.IORLayout.setVisibility(8);
        this.binding.otherET.setVisibility(8);
        this.binding.linearLayout22.setVisibility(8);
        this.binding.linearLayout23.setVisibility(8);
        this.binding.PersondisabilityTitle.setVisibility(8);
        this.binding.PersonDisabilityLayout.setVisibility(8);
        this.binding.CorrectEntryNameLayout.setVisibility(8);
        this.binding.CorrectGenderLayout.setVisibility(8);
        this.binding.CorrectDOBAGELayout.setVisibility(8);
        this.binding.CorrectRelationNameLayout.setVisibility(8);
        this.binding.CorrectRelationTypeLayout.setVisibility(8);
        this.binding.CorrectAddressLayout.setVisibility(8);
        this.binding.CorrectMobileLayout.setVisibility(8);
        this.binding.CorrectPhotoLayout.setVisibility(8);
        this.binding.CorrectNameDocumentLayout.setVisibility(8);
        this.binding.CorrectGenderDocumentLayout.setVisibility(8);
        this.binding.CorrectDobageDocumentLayout.setVisibility(8);
        this.binding.CorrectRelationNameDocumentLayout.setVisibility(8);
        this.binding.CorrectRelationTypeDocumentLayout.setVisibility(8);
        this.binding.CorrectAddressDocumentLayout.setVisibility(8);
        this.binding.PlaceET.setText(this.location);
        if (this.isdeclarationEnabled.booleanValue()) {
            this.binding.declarationFormLayout.declarationFormLayout.setVisibility(0);
            declarationForm();
        } else {
            this.binding.declarationFormLayout.declarationFormLayout.setVisibility(8);
        }
        return this.binding.getRoot();
    }

    private void dataoneditbutton(String name, String date, String formtype) {
        this.viewModel.dataoneditbutton(name, date, formtype).observe(getViewLifecycleOwner(), new Observer() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$$ExternalSyntheticLambda1
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
        String state = ((FormsinDraftMigrationModel) list.get(0)).getState();
        String personal = ((FormsinDraftMigrationModel) list.get(0)).getPersonal();
        String application = ((FormsinDraftMigrationModel) list.get(0)).getApplication();
        this.referenceNumber = ((FormsinDraftMigrationModel) list.get(0)).getReference();
        this.referencelinkSOR = ((FormsinDraftMigrationModel) list.get(0)).getPhotoSOR();
        this.referencerlinkcoe1 = ((FormsinDraftMigrationModel) list.get(0)).getPhoto1();
        this.referencerlinkcoe2 = ((FormsinDraftMigrationModel) list.get(0)).getPhoto2();
        this.referencerlinkcoe3 = ((FormsinDraftMigrationModel) list.get(0)).getPhoto3();
        this.referencerlinkcoe4 = ((FormsinDraftMigrationModel) list.get(0)).getPhoto4();
        this.referencerlinkcoe5 = ((FormsinDraftMigrationModel) list.get(0)).getPhoto5();
        this.referencerlinkcoe6 = ((FormsinDraftMigrationModel) list.get(0)).getPhoto6();
        this.referencerlinkcoe8 = ((FormsinDraftMigrationModel) list.get(0)).getPhoto8();
        this.referencelinkFIR = ((FormsinDraftMigrationModel) list.get(0)).getPhotoLOST();
        this.referencelinkdisability = ((FormsinDraftMigrationModel) list.get(0)).getPhotoDISABILITY();
        this.choice = ((FormsinDraftMigrationModel) list.get(0)).getCitizenshipType();
        this.cat = ((FormsinDraftMigrationModel) list.get(0)).getCitizenshipTypeCat();
        this.doctypeself = ((FormsinDraftMigrationModel) list.get(0)).getCtDocTypeForSelf();
        this.doctypeselfURL = ((FormsinDraftMigrationModel) list.get(0)).getCtDocOfSelfUrl();
        this.doctypeselFileSize = ((FormsinDraftMigrationModel) list.get(0)).getDoctypeselFileSize();
        this.doctypeselfFileName = ((FormsinDraftMigrationModel) list.get(0)).getDoctypeselfFileName();
        this.before2004ParentType = ((FormsinDraftMigrationModel) list.get(0)).getBefore2004ParentType();
        this.doctypeFather = ((FormsinDraftMigrationModel) list.get(0)).getDoctypeFather();
        this.doctypeMother = ((FormsinDraftMigrationModel) list.get(0)).getDoctypeMother();
        this.docURLFather = ((FormsinDraftMigrationModel) list.get(0)).getDocURLFather();
        this.docURLMother = ((FormsinDraftMigrationModel) list.get(0)).getDocURLMother();
        this.before2004docFileName = ((FormsinDraftMigrationModel) list.get(0)).getBefore2004docFileName();
        this.before2004docFileSize = ((FormsinDraftMigrationModel) list.get(0)).getBefore2004docFileSize();
        this.after2004isParentIndian = ((FormsinDraftMigrationModel) list.get(0)).getAfter2004isParentIndian();
        this.after2004ParentNameNotindian = ((FormsinDraftMigrationModel) list.get(0)).getAfter2004ParentNameNotindian();
        this.after2004doctypeFather = ((FormsinDraftMigrationModel) list.get(0)).getAfter2004doctypeFather();
        this.after2004doctypeMother = ((FormsinDraftMigrationModel) list.get(0)).getAfter2004doctypeMother();
        this.after2004docURLFather = ((FormsinDraftMigrationModel) list.get(0)).getAfter2004docURLFather();
        this.after2004docURLMother = ((FormsinDraftMigrationModel) list.get(0)).getAfter2004docURLMother();
        this.after2004MotherFileName = ((FormsinDraftMigrationModel) list.get(0)).getAfter2004MotherFileName();
        this.after2004MotherFileSize = ((FormsinDraftMigrationModel) list.get(0)).getAfter2004MotherFileSize();
        this.after2004FatherFileName = ((FormsinDraftMigrationModel) list.get(0)).getAfter2004FatherFileName();
        this.after2004FatherFileSize = ((FormsinDraftMigrationModel) list.get(0)).getAfter2004FatherFileSize();
        this.bornOutofIndiadoctype = ((FormsinDraftMigrationModel) list.get(0)).getBornOutofIndiadoctype();
        this.bornOutofIndiadocURL = ((FormsinDraftMigrationModel) list.get(0)).getBornOutofIndiadocURL();
        this.bornOutofIndiaFileName = ((FormsinDraftMigrationModel) list.get(0)).getBornOutofIndiaFileName();
        this.bornOutofIndiaFileSize = ((FormsinDraftMigrationModel) list.get(0)).getBornOutofIndiaFileSize();
        this.citizenAquuireddoctype = ((FormsinDraftMigrationModel) list.get(0)).getCitizenAquuireddoctype();
        this.citizenAquuireddocURL = ((FormsinDraftMigrationModel) list.get(0)).getCitizenAquuireddocURL();
        this.citizenAquuiredFileName = ((FormsinDraftMigrationModel) list.get(0)).getCitizenAquuiredFileName();
        this.citizenAquuiredFileSize = ((FormsinDraftMigrationModel) list.get(0)).getCitizenAquuiredFileSize();
        this.anxDSignUrl = ((FormsinDraftMigrationModel) list.get(0)).getAnnexureSignURL();
        this.anexSignFileSize = ((FormsinDraftMigrationModel) list.get(0)).getAnexSignFileSize();
        this.anexSignFileName = ((FormsinDraftMigrationModel) list.get(0)).getAnexSignFileName();
        edit(state, personal, application, this.referencelinkSOR, this.referencerlinkcoe1, this.referencerlinkcoe2, this.referencerlinkcoe3, this.referencerlinkcoe4, this.referencerlinkcoe5, this.referencerlinkcoe6, this.referencerlinkcoe8, this.referencelinkFIR, this.referencelinkdisability);
    }

    private void edit(String statedata, String personaldata, String applicationdata, String imgSOR, String img1, String img2, String img3, String img4, String img5, String img6, String img8, String imgLOSTFIR, String imgDISABILITY) {
        try {
            String[] strArrSplit = statedata.split(this.delimeter);
            this.binding.stateET.setText(strArrSplit[0]);
            this.binding.districtET.setText(strArrSplit[1]);
            this.binding.assemblyET.setText(strArrSplit[2]);
            this.binding.constNO.setText(strArrSplit[3]);
            this.appfor = strArrSplit[4];
            String[] strArrSplit2 = personaldata.split(this.delimeter);
            this.binding.nameApplicantET.setText(strArrSplit2[0]);
            this.binding.epicNumberET.setText(strArrSplit2[1]);
            String str = strArrSplit2[2];
            this.aadharType = str;
            if (str.equals("AADHAR")) {
                this.binding.AadhaarNumber.setChecked(true);
            }
            if (this.aadharType.equals("NOT FURNISH")) {
                this.binding.notFurnish.setChecked(true);
            }
            if (strArrSplit2[3].length() > 10) {
                this.binding.aadharNumberTv.setVisibility(0);
                this.binding.aadharNumberET.setVisibility(0);
                this.binding.aadharNumberET.setEms(14);
                this.binding.aadharNumberET.setText(strArrSplit2[19]);
            } else {
                this.binding.aadharNumberTv.setVisibility(8);
                this.binding.aadharNumberET.setVisibility(8);
            }
            String str2 = strArrSplit2[4];
            this.mobileType = str2;
            if (str2.equals("SELF")) {
                this.binding.SelfNumber.setChecked(true);
            }
            if (this.mobileType.equals("OTHER")) {
                this.binding.fatherNumber.setChecked(true);
            }
            this.binding.numberET.setText(strArrSplit2[5]);
            String str3 = strArrSplit2[6];
            this.emailType = str3;
            if (str3.equals("SELF")) {
                this.binding.selfemail.setChecked(true);
            }
            if (this.emailType.equals("OTHER")) {
                this.binding.fatherEmail.setChecked(true);
            }
            if (strArrSplit2[7].equals(SchedulerSupport.NONE)) {
                this.binding.emailET.setText("");
            } else {
                this.binding.emailET.setText(strArrSplit2[7]);
            }
            String[] strArrSplit3 = applicationdata.split(this.delimeter);
            if (strArrSplit3[0].equals("Shifting of Residence")) {
                this.binding.SOR.setChecked(true);
                this.binding.linearLayout22.setVisibility(0);
                this.binding.houseET.setText(strArrSplit3[1]);
                this.binding.streetET.setText(strArrSplit3[2]);
                this.binding.villageET.setText(strArrSplit3[3]);
                this.binding.postofficeET.setText(strArrSplit3[4]);
                this.binding.pincodeET.setText(strArrSplit3[5]);
                this.binding.tehsilET.setText(strArrSplit3[6]);
                this.binding.addProofSpinner.setText(strArrSplit3[13]);
                if (!strArrSplit3[8].equals("")) {
                    this.binding.OtherAddProof.setVisibility(0);
                    this.binding.OtherAddProofTv.setVisibility(0);
                    this.binding.OtherAddProof.setText(strArrSplit3[8]);
                }
                this.binding.DistrictSOREt.setText(strArrSplit3[19]);
                this.binding.StateSOREt.setText(strArrSplit3[10]);
                this.binding.chooseFileName.setText(strArrSplit3[11]);
                if (strArrSplit3[11].contains(".pdf")) {
                    this.binding.preview.setImageResource(R.drawable.blo_pfd_thumbnail);
                } else if (imgSOR != null && !imgSOR.isEmpty() && !imgSOR.equals("null")) {
                    getFileSOR(imgSOR);
                }
                this.binding.houseOfficialET.setText(strArrSplit3[14]);
                this.binding.streetOfficialET.setText(strArrSplit3[15]);
                this.binding.villageOfficialET.setText(strArrSplit3[16]);
                this.binding.postofficeOfficialET.setText(strArrSplit3[17]);
                this.binding.tehsilOfficialET.setText(strArrSplit3[18]);
                this.binding.preview.setVisibility(0);
                this.binding.chooseFileName.setVisibility(0);
                this.binding.SORLayout.setVisibility(0);
            } else if (strArrSplit3[0].equals("Correction of Entries in Existing Electoral Roll")) {
                this.binding.COR.setChecked(true);
                this.binding.linearLayout23.setVisibility(0);
                this.binding.COELayout.setVisibility(0);
                if (strArrSplit3[1].equals("NAME")) {
                    this.binding.cb1.setChecked(true);
                    this.binding.CorrectEntryNameLayout.setVisibility(0);
                    this.binding.CorrectNameDocumentLayout.setVisibility(0);
                    this.binding.CorrectNameET.setText(strArrSplit3[9]);
                    this.binding.CorrectSurnameET.setText(strArrSplit3[10]);
                    this.binding.CorrectNameOfficialET.setText(strArrSplit3[54]);
                    this.binding.CorrectSurnameOfficialET.setText(strArrSplit3[55]);
                    this.binding.docNameSpinner.setText(strArrSplit3[46]);
                    this.binding.chooseFileName3.setText(strArrSplit3[12]);
                    if (strArrSplit3[12].contains(".pdf")) {
                        this.binding.preview3.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else if (img1 != null || !img1.equals("") || !img1.equals("null")) {
                        getFileCOR1(img1);
                    }
                    this.binding.preview3.setVisibility(0);
                    this.binding.chooseFileName3.setVisibility(0);
                }
                if (strArrSplit3[2].equals("GENDER")) {
                    this.binding.cb2.setChecked(true);
                    this.binding.CorrectGenderLayout.setVisibility(0);
                    this.binding.CorrectGenderDocumentLayout.setVisibility(0);
                    this.binding.genderSpinnerMig.setText(strArrSplit3[47]);
                    this.binding.docGenderSpinner.setText(strArrSplit3[48]);
                    this.binding.chooseFileName2.setText(strArrSplit3[16]);
                    this.binding.preview2.setVisibility(0);
                    if (strArrSplit3[16].contains(".pdf")) {
                        this.binding.preview2.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else if (img2 != null || !img2.equals("") || !img2.equals("null")) {
                        getFileCOR2(img2);
                    }
                    this.binding.chooseFileName2.setVisibility(0);
                }
                if (strArrSplit3[3].equals("DOB/AGE")) {
                    this.binding.cb3.setChecked(true);
                    this.binding.CorrectDOBAGELayout.setVisibility(0);
                    this.binding.CorrectDobageDocumentLayout.setVisibility(0);
                    this.binding.CorrectDobageET.setText(strArrSplit3[18]);
                    this.binding.docDobageSpinner.setText(strArrSplit3[49]);
                    this.binding.chooseFileName4.setText(strArrSplit3[20]);
                    this.binding.preview4.setVisibility(0);
                    if (strArrSplit3[20].contains(".pdf")) {
                        this.binding.preview4.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else if (img3 != null || !img3.equals("") || !img3.equals("null")) {
                        getFileCOR3(img3);
                    }
                    this.binding.chooseFileName4.setVisibility(0);
                }
                if (strArrSplit3[4].equals("RELATION TYPE")) {
                    this.binding.cb4.setChecked(true);
                    this.binding.CorrectRelationTypeLayout.setVisibility(0);
                    this.binding.CorrectRelationTypeDocumentLayout.setVisibility(0);
                    this.binding.RelationTypeSpinner.setText(strArrSplit3[50]);
                    this.binding.docRelationTypeSpinner.setText(strArrSplit3[51]);
                    this.binding.chooseFileName5.setText(strArrSplit3[24]);
                    if (strArrSplit3[24].contains(".pdf")) {
                        this.binding.preview5.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else if (img4 != null && !img4.equals("") && !img4.equals("null")) {
                        getFileCOR4(img4);
                    }
                    this.binding.preview5.setVisibility(0);
                    this.binding.chooseFileName5.setVisibility(0);
                }
                if (strArrSplit3[5].equals("RELATION NAME")) {
                    this.binding.cb5.setChecked(true);
                    this.binding.CorrectRelationNameLayout.setVisibility(0);
                    this.binding.CorrectRelationNameDocumentLayout.setVisibility(0);
                    this.binding.CorrectRelationFirstNameET.setText(strArrSplit3[26]);
                    this.binding.CorrectRelationSurNameET.setText(strArrSplit3[27]);
                    this.binding.CorrectRelationFirstOfficialNameET.setText(strArrSplit3[58]);
                    this.binding.CorrectRelationOfficialSurNameET.setText(strArrSplit3[59]);
                    this.binding.docRelationNameSpinner.setText(strArrSplit3[52]);
                    this.binding.chooseFileName6.setText(strArrSplit3[29]);
                    if (strArrSplit3[29].contains(".pdf")) {
                        this.binding.preview6.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else {
                        getFileCOR5(img5);
                    }
                    this.binding.preview6.setVisibility(0);
                    this.binding.chooseFileName6.setVisibility(0);
                }
                if (strArrSplit3[6].equals("ADDRESS")) {
                    this.binding.cb6.setChecked(true);
                    this.binding.CorrectAddressLayout.setVisibility(0);
                    this.binding.CorrectAddressDocumentLayout.setVisibility(0);
                    this.binding.CorrectHouseET.setText(strArrSplit3[31]);
                    this.binding.CorrectStreetETCoe.setText(strArrSplit3[32]);
                    this.binding.CorrectVillageETCoe.setText(strArrSplit3[33]);
                    this.binding.CorrectPostofficeETCoe.setText(strArrSplit3[34]);
                    this.binding.CorrectPincodeETCoe.setText(strArrSplit3[35]);
                    this.binding.CorrectTehsilETCoe.setText(strArrSplit3[36]);
                    this.binding.CorrectDistrictEtCoe.setText(strArrSplit3[65]);
                    this.binding.CorrectStateEtCoe.setText(strArrSplit3[38]);
                    this.binding.CorrectHouseOfficialET.setText(strArrSplit3[60]);
                    this.binding.CorrectStreetOfficialETCoe.setText(strArrSplit3[61]);
                    this.binding.CorrectVillageOfficialETCoe.setText(strArrSplit3[62]);
                    this.binding.CorrectPostofficeOfficialETCoe.setText(strArrSplit3[63]);
                    this.binding.CorrectTehsilOfficialETCoe.setText(strArrSplit3[64]);
                    this.binding.docAddressSpinner.setText(strArrSplit3[53]);
                    this.binding.chooseFileName7.setText(strArrSplit3[40]);
                    this.binding.preview7.setVisibility(0);
                    if (strArrSplit3[40].contains(".pdf")) {
                        this.binding.preview7.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else if (img6 != null && !img6.equals("") && !img6.equals("null")) {
                        getFileCOR6(img6);
                    }
                    this.binding.chooseFileName7.setVisibility(0);
                }
                if (strArrSplit3[7].equals("MOBILE NUMBER")) {
                    this.binding.cb7.setChecked(true);
                    this.binding.CorrectMobileLayout.setVisibility(0);
                    this.binding.CorrectMobileET.setText(strArrSplit3[42]);
                }
                if (strArrSplit3[8].equals("PHOTO")) {
                    this.binding.cb8.setChecked(true);
                    this.binding.CorrectPhotoLayout.setVisibility(0);
                    this.binding.chooseCorrectPhotoName.setText(strArrSplit3[44]);
                    this.binding.previewPhoto.setVisibility(0);
                    if (strArrSplit3[44].contains(".pdf")) {
                        this.binding.previewPhoto.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else if (img8 != null && !img8.equals("") && !img8.equals("null")) {
                        getFileCORphoto(img8);
                    }
                    this.binding.chooseCorrectPhotoName.setVisibility(0);
                }
            } else if (strArrSplit3[0].equals("Issue of Replacement EPIC without correction")) {
                this.binding.IOR.setChecked(true);
                if (strArrSplit3[1].equals("Lost")) {
                    this.binding.lost.setChecked(true);
                    this.binding.documentTv17.setVisibility(0);
                    this.binding.chooseFileName11.setText(strArrSplit3[2]);
                    this.binding.preview11.setVisibility(0);
                    if (strArrSplit3[2].contains(".pdf")) {
                        this.binding.preview11.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else if (imgLOSTFIR != null || !imgLOSTFIR.equals("") || !imgLOSTFIR.equals("null")) {
                        getFileFIR(imgLOSTFIR);
                    }
                    this.binding.chooseFileName11.setVisibility(0);
                } else if (strArrSplit3[1].equals("Destroyed due to reason beyond control like floods, fire, other natural disaster etc.")) {
                    this.binding.destroyed.setChecked(true);
                    this.binding.documentTv17.setVisibility(8);
                    this.binding.preview11.setVisibility(8);
                    this.binding.chooseFileName11.setVisibility(8);
                } else if (strArrSplit3[1].equals("Multilated")) {
                    this.binding.Multi.setChecked(true);
                    this.binding.preview11.setVisibility(8);
                    this.binding.documentTv17.setVisibility(8);
                    this.binding.chooseFileName11.setVisibility(8);
                } else {
                    this.binding.IORradio.clearCheck();
                }
                this.binding.IORTitle.setVisibility(0);
                this.binding.IORLayout.setVisibility(0);
            } else if (strArrSplit3[0].equals("Request for marking as Person with Disability")) {
                this.binding.ROM.setChecked(true);
                if (strArrSplit3[1].equals("Locomotive")) {
                    this.binding.Locomotive.setChecked(true);
                }
                if (strArrSplit3[2].equals("Visual")) {
                    this.binding.Visual.setChecked(true);
                }
                if (strArrSplit3[3].equals("Deaf & Dumb")) {
                    this.binding.DeafDumb.setChecked(true);
                }
                if (strArrSplit3[4].equals("Other")) {
                    this.binding.Other.setChecked(true);
                }
                if (strArrSplit3[5].length() != 0) {
                    this.binding.otherET.setVisibility(0);
                }
                this.binding.otherET.setText(strArrSplit3[5]);
                this.binding.percentageET.setText(strArrSplit3[6]);
                if (strArrSplit3[7].equals("Yes")) {
                    this.binding.yes.setChecked(true);
                    this.binding.chooseFileName10.setText(strArrSplit3[8]);
                    this.binding.preview9.setVisibility(0);
                    if (strArrSplit3[8].contains(".pdf")) {
                        this.binding.preview9.setImageResource(R.drawable.blo_pfd_thumbnail);
                    } else if (imgDISABILITY != null || !imgDISABILITY.equals("") || !imgDISABILITY.equals("null")) {
                        getFileDisability(imgDISABILITY);
                    }
                    this.binding.chooseFileName10.setVisibility(0);
                } else {
                    this.binding.No.setChecked(true);
                    this.binding.textview21.setVisibility(8);
                    this.binding.preview9.setVisibility(8);
                    this.binding.chooseFileName10.setVisibility(8);
                }
                this.binding.PersondisabilityTitle.setVisibility(0);
                this.binding.PersonDisabilityLayout.setVisibility(0);
            }
            this.binding.decDateET.setText(this.submitdate);
            setSAnnexureDbData();
        } catch (Exception e) {
            Logger.d("Migration Correction : ", e.getMessage());
        }
    }

    private void showDialog(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass1(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                Migration_preview_Form.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(Migration_preview_Form.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (Migration_preview_Form.this.base64element == null || Migration_preview_Form.this.base64element.equals("null") || Migration_preview_Form.this.base64element.equals("")) {
                    Migration_preview_Form.this.binding.preview.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    Migration_preview_Form.this.binding.preview.setImageBitmap(bitmapDecodeByteArray);
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Migration_preview_Form.this.commonUtilClass;
                Context context = Migration_preview_Form.this.getContext();
                String str = Migration_preview_Form.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$1$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse1", jSONObject.optString(Migration_preview_Form.MESSAGE));
            } catch (Exception e2) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            Migration_preview_Form.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Form.this.commonUtilClass.showMessageOK(Migration_preview_Form.this.requireContext(), Migration_preview_Form.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Form.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setToken("Bearer " + str2);
            Migration_preview_Form.this.getFileSOR(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setLocaleBool(false);
            Migration_preview_Form.this.startActivity(new Intent((Context) Migration_preview_Form.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Migration_preview_Form.FAILURE, t.getMessage());
        }
    }

    public void getFileSOR(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(OBJECTSTORAGE, fileref, this.token, this.atkband, this.rtkband, BLOAPP, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass1(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass2(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                Migration_preview_Form.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(Migration_preview_Form.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (Migration_preview_Form.this.base64element == null || Migration_preview_Form.this.base64element.equals("null") || Migration_preview_Form.this.base64element.equals("")) {
                    Migration_preview_Form.this.binding.preview3.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    Migration_preview_Form.this.binding.preview3.setImageBitmap(bitmapDecodeByteArray);
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Migration_preview_Form.this.commonUtilClass;
                Context context = Migration_preview_Form.this.getContext();
                String str = Migration_preview_Form.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$2$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse2", jSONObject.optString(Migration_preview_Form.MESSAGE));
            } catch (Exception e2) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            Migration_preview_Form.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Form.this.commonUtilClass.showMessageOK(Migration_preview_Form.this.requireContext(), Migration_preview_Form.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Form.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setToken("Bearer " + str2);
            Migration_preview_Form.this.getFileCOR1(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setLocaleBool(false);
            Migration_preview_Form.this.startActivity(new Intent((Context) Migration_preview_Form.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Migration_preview_Form.FAILURE, t.getMessage());
        }
    }

    public void getFileCOR1(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(OBJECTSTORAGE, fileref, this.token, this.atkband, this.rtkband, BLOAPP, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass2(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass3(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                Migration_preview_Form.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(Migration_preview_Form.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (Migration_preview_Form.this.base64element == null || Migration_preview_Form.this.base64element.equals("null") || Migration_preview_Form.this.base64element.equals("")) {
                    Migration_preview_Form.this.binding.preview2.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    Migration_preview_Form.this.binding.preview2.setImageBitmap(bitmapDecodeByteArray);
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Migration_preview_Form.this.commonUtilClass;
                Context context = Migration_preview_Form.this.getContext();
                String str = Migration_preview_Form.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$3$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse3", jSONObject.optString(Migration_preview_Form.MESSAGE));
            } catch (Exception e2) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            Migration_preview_Form.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Form.this.commonUtilClass.showMessageOK(Migration_preview_Form.this.requireContext(), Migration_preview_Form.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Form.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setToken("Bearer " + str2);
            Migration_preview_Form.this.getFileCOR2(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setLocaleBool(false);
            Migration_preview_Form.this.startActivity(new Intent((Context) Migration_preview_Form.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Migration_preview_Form.FAILURE, t.getMessage());
        }
    }

    public void getFileCOR2(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(OBJECTSTORAGE, fileref, this.token, this.atkband, this.rtkband, BLOAPP, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass3(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass4(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                Migration_preview_Form.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(Migration_preview_Form.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (Migration_preview_Form.this.base64element == null || Migration_preview_Form.this.base64element.equals("null") || Migration_preview_Form.this.base64element.equals("")) {
                    Migration_preview_Form.this.binding.preview4.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    Migration_preview_Form.this.binding.preview4.setImageBitmap(bitmapDecodeByteArray);
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Migration_preview_Form.this.commonUtilClass;
                Context context = Migration_preview_Form.this.getContext();
                String str = Migration_preview_Form.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$4$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse4", jSONObject.optString(Migration_preview_Form.MESSAGE));
            } catch (Exception e2) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            Migration_preview_Form.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Form.this.commonUtilClass.showMessageOK(Migration_preview_Form.this.requireContext(), Migration_preview_Form.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$4$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Form.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setToken("Bearer " + str2);
            Migration_preview_Form.this.getFileCOR3(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setLocaleBool(false);
            Migration_preview_Form.this.startActivity(new Intent((Context) Migration_preview_Form.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Migration_preview_Form.FAILURE, t.getMessage());
        }
    }

    public void getFileCOR3(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(OBJECTSTORAGE, fileref, this.token, this.atkband, this.rtkband, BLOAPP, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass4(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass5(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                Migration_preview_Form.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(Migration_preview_Form.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (Migration_preview_Form.this.base64element == null || Migration_preview_Form.this.base64element.equals("null") || Migration_preview_Form.this.base64element.equals("")) {
                    Migration_preview_Form.this.binding.preview5.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    Migration_preview_Form.this.binding.preview5.setImageBitmap(bitmapDecodeByteArray);
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Migration_preview_Form.this.commonUtilClass;
                Context context = Migration_preview_Form.this.getContext();
                String str = Migration_preview_Form.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$5$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse5", jSONObject.optString(Migration_preview_Form.MESSAGE));
            } catch (Exception e2) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            Migration_preview_Form.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Form.this.commonUtilClass.showMessageOK(Migration_preview_Form.this.requireContext(), Migration_preview_Form.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$5$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Form.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setToken("Bearer " + str2);
            Migration_preview_Form.this.getFileCOR4(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setLocaleBool(false);
            Migration_preview_Form.this.startActivity(new Intent((Context) Migration_preview_Form.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Migration_preview_Form.FAILURE, t.getMessage());
        }
    }

    public void getFileCOR4(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(OBJECTSTORAGE, fileref, this.token, this.atkband, this.rtkband, BLOAPP, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass5(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass6(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                Migration_preview_Form.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(Migration_preview_Form.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (Migration_preview_Form.this.base64element == null || Migration_preview_Form.this.base64element.equals("null") || Migration_preview_Form.this.base64element.equals("")) {
                    Migration_preview_Form.this.binding.preview6.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    Migration_preview_Form.this.binding.preview6.setImageBitmap(bitmapDecodeByteArray);
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Migration_preview_Form.this.commonUtilClass;
                Context context = Migration_preview_Form.this.getContext();
                String str = Migration_preview_Form.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$6$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse6", jSONObject.optString(Migration_preview_Form.MESSAGE));
            } catch (Exception e2) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            Migration_preview_Form.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Form.this.commonUtilClass.showMessageOK(Migration_preview_Form.this.requireContext(), Migration_preview_Form.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$6$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Form.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setToken("Bearer " + str2);
            Migration_preview_Form.this.getFileCOR5(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setLocaleBool(false);
            Migration_preview_Form.this.startActivity(new Intent((Context) Migration_preview_Form.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Migration_preview_Form.FAILURE, t.getMessage());
        }
    }

    public void getFileCOR5(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(OBJECTSTORAGE, fileref, this.token, this.atkband, this.rtkband, BLOAPP, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass6(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass7(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                Migration_preview_Form.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(Migration_preview_Form.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (Migration_preview_Form.this.base64element == null || Migration_preview_Form.this.base64element.equals("null") || Migration_preview_Form.this.base64element.equals("")) {
                    Migration_preview_Form.this.binding.preview7.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    Migration_preview_Form.this.binding.preview7.setImageBitmap(bitmapDecodeByteArray);
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Migration_preview_Form.this.commonUtilClass;
                Context context = Migration_preview_Form.this.getContext();
                String str = Migration_preview_Form.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$7$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse7", jSONObject.optString(Migration_preview_Form.MESSAGE));
            } catch (Exception e2) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            Migration_preview_Form.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Form.this.commonUtilClass.showMessageOK(Migration_preview_Form.this.requireContext(), Migration_preview_Form.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Form.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setToken("Bearer " + str2);
            Migration_preview_Form.this.getFileCOR6(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setLocaleBool(false);
            Migration_preview_Form.this.startActivity(new Intent((Context) Migration_preview_Form.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Migration_preview_Form.FAILURE, t.getMessage());
        }
    }

    public void getFileCOR6(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(OBJECTSTORAGE, fileref, this.token, this.atkband, this.rtkband, BLOAPP, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass7(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass8(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                Migration_preview_Form.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(Migration_preview_Form.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (Migration_preview_Form.this.base64element == null || Migration_preview_Form.this.base64element.equals("null") || Migration_preview_Form.this.base64element.equals("")) {
                    Migration_preview_Form.this.binding.previewPhoto.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    Migration_preview_Form.this.binding.previewPhoto.setImageBitmap(bitmapDecodeByteArray);
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Migration_preview_Form.this.commonUtilClass;
                Context context = Migration_preview_Form.this.getContext();
                String str = Migration_preview_Form.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$8$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse8", jSONObject.optString(Migration_preview_Form.MESSAGE));
            } catch (Exception e2) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            Migration_preview_Form.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Form.this.commonUtilClass.showMessageOK(Migration_preview_Form.this.requireContext(), Migration_preview_Form.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$8$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Form.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setToken("Bearer " + str2);
            Migration_preview_Form.this.getFileCORphoto(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setLocaleBool(false);
            Migration_preview_Form.this.startActivity(new Intent((Context) Migration_preview_Form.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Migration_preview_Form.FAILURE, t.getMessage());
        }
    }

    public void getFileCORphoto(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(OBJECTSTORAGE, fileref, this.token, this.atkband, this.rtkband, BLOAPP, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass8(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$9, reason: invalid class name */
    class AnonymousClass9 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass9(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                Migration_preview_Form.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(Migration_preview_Form.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (Migration_preview_Form.this.base64element == null || Migration_preview_Form.this.base64element.equals("null") || Migration_preview_Form.this.base64element.equals("")) {
                    Migration_preview_Form.this.binding.preview11.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    Migration_preview_Form.this.binding.preview11.setImageBitmap(bitmapDecodeByteArray);
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Migration_preview_Form.this.commonUtilClass;
                Context context = Migration_preview_Form.this.getContext();
                String str = Migration_preview_Form.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$9$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse9", jSONObject.optString(Migration_preview_Form.MESSAGE));
            } catch (Exception e2) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            Migration_preview_Form.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Form.this.commonUtilClass.showMessageOK(Migration_preview_Form.this.requireContext(), Migration_preview_Form.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$9$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Form.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setToken("Bearer " + str2);
            Migration_preview_Form.this.getFileFIR(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setLocaleBool(false);
            Migration_preview_Form.this.startActivity(new Intent((Context) Migration_preview_Form.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Migration_preview_Form.FAILURE, t.getMessage());
        }
    }

    public void getFileFIR(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(OBJECTSTORAGE, fileref, this.token, this.atkband, this.rtkband, BLOAPP, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass9(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$10, reason: invalid class name */
    class AnonymousClass10 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass10(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                Migration_preview_Form.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(Migration_preview_Form.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (Migration_preview_Form.this.base64element == null || Migration_preview_Form.this.base64element.equals("null") || Migration_preview_Form.this.base64element.equals("")) {
                    Migration_preview_Form.this.binding.preview9.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    if (bitmapDecodeByteArray != null) {
                        Log.d("decodedByte", bitmapDecodeByteArray.toString());
                        Migration_preview_Form.this.binding.preview9.setImageBitmap(bitmapDecodeByteArray);
                        return;
                    }
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Migration_preview_Form.this.commonUtilClass;
                Context context = Migration_preview_Form.this.getContext();
                String str = Migration_preview_Form.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$10$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse10", jSONObject.optString(Migration_preview_Form.MESSAGE));
            } catch (Exception e2) {
                Logger.d(Migration_preview_Form.MIGRATION_CATCH_MSG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            Migration_preview_Form.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Form.this.commonUtilClass.showMessageOK(Migration_preview_Form.this.requireContext(), Migration_preview_Form.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$10$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Form.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setToken("Bearer " + str2);
            Migration_preview_Form.this.getFileDisability(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Form.this.requireContext()).setLocaleBool(false);
            Migration_preview_Form.this.startActivity(new Intent((Context) Migration_preview_Form.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Migration_preview_Form.FAILURE, t.getMessage());
        }
    }

    public void getFileDisability(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(OBJECTSTORAGE, fileref, this.token, this.atkband, this.rtkband, BLOAPP, "blo", BLOAPP, "ANDROIDMOB").enqueue(new AnonymousClass10(fileref));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    private void setSAnnexureDbData() {
        if (this.choice.equalsIgnoreCase("") && this.choice == null) {
            return;
        }
        this.binding.annexureDIncludedLayout.annexureD.setVisibility(0);
        if (this.choice.equalsIgnoreCase(getString(R.string.born_india))) {
            this.binding.annexureDIncludedLayout.formAnnxBornIndia.setChecked(true);
            this.list1 = "LIST-1";
            getList1("LIST-1");
            if (this.cat.equalsIgnoreCase("CAT-2")) {
                this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(0);
                this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAcquired.setVisibility(8);
                if (this.doctypeselfURL != null) {
                    this.binding.annexureDIncludedLayout.viewLayoutList1.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList1.setVisibility(0);
                    DisplayImage(this.doctypeselfURL, this.doctypeselfFileName, this.doctypeselFileSize, this.binding.annexureDIncludedLayout.imageList1, this.binding.annexureDIncludedLayout.list1Name, this.binding.annexureDIncludedLayout.list1Size);
                }
            } else if (this.cat.equalsIgnoreCase("CAT-3")) {
                this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(8);
                this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(0);
                this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAcquired.setVisibility(8);
                if (this.doctypeselfURL != null) {
                    this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageBefore2004Self.setVisibility(0);
                    DisplayImage(this.doctypeselfURL, this.doctypeselfFileName, this.doctypeselFileSize, this.binding.annexureDIncludedLayout.imageBefore2004Self, this.binding.annexureDIncludedLayout.before2004SelfName, this.binding.annexureDIncludedLayout.before2004SelfSize);
                    this.binding.annexureDIncludedLayout.viewLayoutList2.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList2.setVisibility(0);
                    if (this.before2004ParentType.equalsIgnoreCase("Father")) {
                        this.binding.annexureDIncludedLayout.betweenParentFatherRb.setChecked(true);
                        getList1(this.list3);
                        DisplayImage(this.docURLFather, this.before2004docFileName, this.before2004docFileSize, this.binding.annexureDIncludedLayout.imageList2, this.binding.annexureDIncludedLayout.list2Name, this.binding.annexureDIncludedLayout.list2Size);
                    } else if (this.before2004ParentType.equalsIgnoreCase("Mother")) {
                        this.binding.annexureDIncludedLayout.betweenParentMotherRb.setChecked(true);
                        getList1(this.list4);
                        DisplayImage(this.docURLMother, this.before2004docFileName, this.before2004docFileSize, this.binding.annexureDIncludedLayout.imageList2, this.binding.annexureDIncludedLayout.list2Name, this.binding.annexureDIncludedLayout.list2Size);
                    }
                }
            } else if (this.cat.equalsIgnoreCase("CAT-4")) {
                this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(8);
                this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(8);
                this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(0);
                this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAcquired.setVisibility(8);
                if (this.doctypeselfURL != null) {
                    this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageAfter2004self.setVisibility(0);
                    DisplayImage(this.doctypeselfURL, this.doctypeselfFileName, this.doctypeselFileSize, this.binding.annexureDIncludedLayout.imageAfter2004self, this.binding.annexureDIncludedLayout.after2004selfName, this.binding.annexureDIncludedLayout.after2004selfSize);
                }
                if (this.after2004isParentIndian.equalsIgnoreCase("Y")) {
                    this.binding.annexureDIncludedLayout.parentYesRb.setChecked(true);
                    this.binding.annexureDIncludedLayout.viewFatherOldLayout.setVisibility(8);
                    this.binding.annexureDIncludedLayout.viewMotherOldLayout.setVisibility(8);
                    this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(0);
                    this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(0);
                    this.binding.annexureDIncludedLayout.motherLayout.setVisibility(0);
                    this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(8);
                    this.binding.annexureDIncludedLayout.selectParentLayout.setVisibility(8);
                    this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(8);
                    this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(8);
                    this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                    getList1(this.list3);
                    getList1(this.list4);
                    DisplayImage(this.after2004docURLFather, this.after2004FatherFileName, this.after2004FatherFileSize, this.binding.annexureDIncludedLayout.imageList3, this.binding.annexureDIncludedLayout.list3Name, this.binding.annexureDIncludedLayout.list3Size);
                    this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                    this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                    DisplayImage(this.after2004docURLMother, this.after2004MotherFileName, this.after2004MotherFileSize, this.binding.annexureDIncludedLayout.imageList4, this.binding.annexureDIncludedLayout.list4Name, this.binding.annexureDIncludedLayout.list4Size);
                } else if (this.after2004isParentIndian.equalsIgnoreCase("N")) {
                    this.binding.annexureDIncludedLayout.parentNoRb.setChecked(true);
                    this.binding.annexureDIncludedLayout.selectParentLayout.setVisibility(0);
                    this.binding.annexureDIncludedLayout.llParentLayout.setVisibility(0);
                    this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(8);
                    this.binding.annexureDIncludedLayout.motherLayout.setVisibility(8);
                    this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(8);
                    this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(8);
                    this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(8);
                    if (this.after2004ParentNameNotindian.equalsIgnoreCase("Father")) {
                        this.binding.annexureDIncludedLayout.parentFatherRb.setChecked(false);
                        this.binding.annexureDIncludedLayout.parentMotherRb.setChecked(true);
                        this.binding.annexureDIncludedLayout.motherLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.indianParentTv2.setText(R.string.mother_sr);
                        this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.nonIndianParentTv2.setText(R.string.father_sr);
                        this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(0);
                        getList1(this.list4);
                        getList1(this.list5);
                        this.binding.annexureDIncludedLayout.viewList4.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageList4.setVisibility(0);
                        DisplayImage(this.after2004docURLMother, this.after2004MotherFileName, this.after2004MotherFileSize, this.binding.annexureDIncludedLayout.imageList4, this.binding.annexureDIncludedLayout.list4Name, this.binding.annexureDIncludedLayout.list4Size);
                        this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                        DisplayImage(this.after2004docURLFather, this.after2004FatherFileName, this.after2004FatherFileSize, this.binding.annexureDIncludedLayout.imageList5, this.binding.annexureDIncludedLayout.list5Name, this.binding.annexureDIncludedLayout.list5Size);
                    } else if (this.after2004ParentNameNotindian.equalsIgnoreCase("Mother")) {
                        this.binding.annexureDIncludedLayout.parentFatherRb.setChecked(true);
                        this.binding.annexureDIncludedLayout.parentMotherRb.setChecked(false);
                        this.binding.annexureDIncludedLayout.fatherLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.motherLayout.setVisibility(8);
                        this.binding.annexureDIncludedLayout.forIndianParentLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.indianParentTv2.setText(getString(R.string.father_sr));
                        this.binding.annexureDIncludedLayout.llNotIndianLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.nonIndianParentTv2.setText(R.string.mother_sr);
                        this.binding.annexureDIncludedLayout.forNonIndianParentLayout.setVisibility(0);
                        this.binding.annexureDIncludedLayout.viewList3.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageList3.setVisibility(0);
                        getList1(this.list3);
                        getList1(this.list5);
                        DisplayImage(this.after2004docURLFather, this.after2004FatherFileName, this.after2004FatherFileSize, this.binding.annexureDIncludedLayout.imageList3, this.binding.annexureDIncludedLayout.list3Name, this.binding.annexureDIncludedLayout.list3Size);
                        this.binding.annexureDIncludedLayout.viewList5.setVisibility(0);
                        this.binding.annexureDIncludedLayout.imageList5.setVisibility(0);
                        DisplayImage(this.after2004docURLMother, this.after2004MotherFileName, this.after2004MotherFileSize, this.binding.annexureDIncludedLayout.imageList5, this.binding.annexureDIncludedLayout.list5Name, this.binding.annexureDIncludedLayout.list5Size);
                    }
                }
            }
        } else if (this.choice.equalsIgnoreCase(getString(R.string.not_born))) {
            this.binding.annexureDIncludedLayout.formAnnxNotBorn.setChecked(true);
            this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(8);
            this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
            this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(8);
            this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(0);
            this.binding.annexureDIncludedLayout.llAcquired.setVisibility(8);
            if (this.bornOutofIndiadoctype != null) {
                this.list6 = "LIST-6";
                getList1("LIST-6");
                this.binding.annexureDIncludedLayout.viewList6.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList6.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList6.setVisibility(0);
                DisplayImage(this.bornOutofIndiadocURL, this.bornOutofIndiaFileName, this.bornOutofIndiaFileSize, this.binding.annexureDIncludedLayout.imageList6, this.binding.annexureDIncludedLayout.list6Name, this.binding.annexureDIncludedLayout.list6Size);
            }
        } else if (this.choice.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
            this.binding.annexureDIncludedLayout.formAnnxIndiaCitize.setChecked(true);
            if (this.citizenAquuireddoctype != null) {
                this.binding.annexureDIncludedLayout.llBefore1987.setVisibility(8);
                this.binding.annexureDIncludedLayout.llBefore2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAfter2004.setVisibility(8);
                this.binding.annexureDIncludedLayout.llBornOutOfIndia.setVisibility(8);
                this.binding.annexureDIncludedLayout.llAcquired.setVisibility(0);
                this.list7 = "LIST-7";
                getList1("LIST-7");
                this.binding.annexureDIncludedLayout.viewList7.setVisibility(0);
                this.binding.annexureDIncludedLayout.imageList7.setVisibility(0);
                this.binding.annexureDIncludedLayout.cancelList7.setVisibility(0);
                DisplayImage(this.citizenAquuireddocURL, this.citizenAquuiredFileName, this.citizenAquuiredFileSize, this.binding.annexureDIncludedLayout.imageList7, this.binding.annexureDIncludedLayout.list7Name, this.binding.annexureDIncludedLayout.list7Size);
            }
        }
        if (this.anxDSignUrl != null) {
            this.binding.annexureDIncludedLayout.annexureDSign.setVisibility(0);
            this.binding.annexureDIncludedLayout.signName.setVisibility(0);
            this.binding.annexureDIncludedLayout.imageSign.setVisibility(0);
            this.binding.annexureDIncludedLayout.viewLayoutSign.setVisibility(0);
            DisplayImage(this.anxDSignUrl, this.anexSignFileName, this.anexSignFileSize, this.binding.annexureDIncludedLayout.imageSign, this.binding.annexureDIncludedLayout.signName, this.binding.annexureDIncludedLayout.signSize);
        }
        disbleView();
    }

    private void DisplayImage(String url, final String filename, final String fileSize, final ImageView imageView, final TextView Filename, final TextView FileSize) {
        if (url == null && url.equals("") && url.equals("null")) {
            return;
        }
        if (url.contains(".jpg") || url.contains(this.jpeg) || url.contains(".png")) {
            this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), url, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$$ExternalSyntheticLambda2
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i, String str) {
                    Migration_preview_Form.lambda$DisplayImage$2(imageView, Filename, FileSize, filename, fileSize, i, str);
                }
            });
            return;
        }
        imageView.setImageResource(R.drawable.blo_pfd_thumbnail);
        if (Filename == null || FileSize == null) {
            return;
        }
        Filename.setText(filename);
        FileSize.setText(fileSize);
    }

    static /* synthetic */ void lambda$DisplayImage$2(ImageView imageView, TextView textView, TextView textView2, String str, String str2, int i, String str3) {
        byte[] bArrDecode = Base64.decode(str3, 0);
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        if (textView == null || textView2 == null) {
            return;
        }
        textView.setText(str);
        textView2.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getList1(String list) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", this.blostatecode);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", BLOAPP);
        HashMap map2 = new HashMap();
        map2.put("lists", list);
        ((UserClient) ApiClient.getClient(getActivity()).create(UserClient.class)).getSpecialRevisionList(map, map2).enqueue(new AnonymousClass11(list));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$11, reason: invalid class name */
    class AnonymousClass11 implements Callback<JsonObject> {
        final /* synthetic */ String val$list;

        AnonymousClass11(final String val$list) {
            this.val$list = val$list;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                Migration_preview_Form.this.payloadData1 = (JsonObject) response.body();
                if (Migration_preview_Form.this.payloadData1 != null) {
                    JsonArray asJsonArray = Migration_preview_Form.this.payloadData1.getAsJsonArray("payload");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = Migration_preview_Form.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        if (this.val$list.equalsIgnoreCase("LIST-1")) {
                            Migration_preview_Form.this.List1docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Migration_preview_Form.this.List1docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Migration_preview_Form.this.List1docName.contains(Migration_preview_Form.this.selectDocumentType)) {
                                Migration_preview_Form.this.List1docName.add(0, Migration_preview_Form.this.selectDocumentType);
                                Migration_preview_Form.this.List1docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) Migration_preview_Form.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Migration_preview_Form.this.List1docName);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setAdapter((SpinnerAdapter) arrayAdapter);
                        } else if (this.val$list.equalsIgnoreCase("LIST-2")) {
                            Migration_preview_Form.this.List2docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Migration_preview_Form.this.List2docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Migration_preview_Form.this.List2docName.contains(Migration_preview_Form.this.selectDocumentType)) {
                                Migration_preview_Form.this.List2docName.add(0, Migration_preview_Form.this.selectDocumentType);
                                Migration_preview_Form.this.List2docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) Migration_preview_Form.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Migration_preview_Form.this.List2docName);
                            arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter2);
                        } else if (this.val$list.equalsIgnoreCase("LIST-3")) {
                            Migration_preview_Form.this.List3docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Migration_preview_Form.this.List3docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Migration_preview_Form.this.List3docName.contains(Migration_preview_Form.this.selectDocumentType)) {
                                Migration_preview_Form.this.List3docName.add(0, Migration_preview_Form.this.selectDocumentType);
                                Migration_preview_Form.this.List3docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter3 = new ArrayAdapter((Context) Migration_preview_Form.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Migration_preview_Form.this.List3docName);
                            arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter3);
                        } else if (this.val$list.equalsIgnoreCase("LIST-4")) {
                            Migration_preview_Form.this.List4docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Migration_preview_Form.this.List4docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Migration_preview_Form.this.List4docName.contains(Migration_preview_Form.this.selectDocumentType)) {
                                Migration_preview_Form.this.List4docName.add(0, Migration_preview_Form.this.selectDocumentType);
                                Migration_preview_Form.this.List4docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter4 = new ArrayAdapter((Context) Migration_preview_Form.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Migration_preview_Form.this.List4docName);
                            arrayAdapter4.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setAdapter((SpinnerAdapter) arrayAdapter4);
                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setAdapter((SpinnerAdapter) arrayAdapter4);
                        } else if (this.val$list.equalsIgnoreCase("LIST-5")) {
                            Migration_preview_Form.this.List5docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Migration_preview_Form.this.List5docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Migration_preview_Form.this.List5docName.contains(Migration_preview_Form.this.selectDocumentType)) {
                                Migration_preview_Form.this.List5docName.add(0, Migration_preview_Form.this.selectDocumentType);
                                Migration_preview_Form.this.List5docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter5 = new ArrayAdapter((Context) Migration_preview_Form.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Migration_preview_Form.this.List5docName);
                            arrayAdapter5.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setAdapter((SpinnerAdapter) arrayAdapter5);
                        } else if (this.val$list.equalsIgnoreCase("LIST-6")) {
                            Migration_preview_Form.this.List6docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Migration_preview_Form.this.List6docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Migration_preview_Form.this.List6docName.contains(Migration_preview_Form.this.selectDocumentType)) {
                                Migration_preview_Form.this.List6docName.add(0, Migration_preview_Form.this.selectDocumentType);
                                Migration_preview_Form.this.List6docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter6 = new ArrayAdapter((Context) Migration_preview_Form.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Migration_preview_Form.this.List6docName);
                            arrayAdapter6.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setAdapter((SpinnerAdapter) arrayAdapter6);
                        } else if (this.val$list.equalsIgnoreCase("LIST-7")) {
                            Migration_preview_Form.this.List7docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Migration_preview_Form.this.List7docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Migration_preview_Form.this.List7docName.contains(Migration_preview_Form.this.selectDocumentType)) {
                                Migration_preview_Form.this.List7docName.add(0, Migration_preview_Form.this.selectDocumentType);
                                Migration_preview_Form.this.List7docCode.add(0, null);
                            }
                            ArrayAdapter arrayAdapter7 = new ArrayAdapter((Context) Migration_preview_Form.this.getActivity(), R.layout.blo_spinner_dropdown, (List) Migration_preview_Form.this.List7docName);
                            arrayAdapter7.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAcquired.setAdapter((SpinnerAdapter) arrayAdapter7);
                        } else if (this.val$list.equalsIgnoreCase("LIST-8")) {
                            Migration_preview_Form.this.List8docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            Migration_preview_Form.this.List8docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!Migration_preview_Form.this.List8docName.contains(Migration_preview_Form.this.selectDocumentType)) {
                                Migration_preview_Form.this.List8docName.add(0, Migration_preview_Form.this.selectDocumentType);
                                Migration_preview_Form.this.List8docCode.add(0, null);
                            }
                        }
                    }
                    if (Migration_preview_Form.this.doctypeself != null && !Migration_preview_Form.this.doctypeself.equalsIgnoreCase("")) {
                        for (int i2 = 0; i2 < Migration_preview_Form.this.List1docCode.size(); i2++) {
                            try {
                                if (Migration_preview_Form.this.List1docCode.get(i2) != null && Migration_preview_Form.this.List1docCode.get(i2).equalsIgnoreCase(Migration_preview_Form.this.doctypeself)) {
                                    Migration_preview_Form migration_preview_Form = Migration_preview_Form.this;
                                    migration_preview_Form.list1Code = migration_preview_Form.doctypeself;
                                    Migration_preview_Form migration_preview_Form2 = Migration_preview_Form.this;
                                    migration_preview_Form2.list1CodeName = migration_preview_Form2.List1docName.get(i2);
                                    Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setSelection(i2);
                                    Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setSelection(i2);
                                    Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setSelection(i2);
                                }
                            } catch (Exception e) {
                                Log.e("errror@spinner", e.toString());
                            }
                        }
                    }
                    if (Migration_preview_Form.this.before2004ParentType != null && !Migration_preview_Form.this.before2004ParentType.equalsIgnoreCase("")) {
                        if (Migration_preview_Form.this.before2004ParentType.equalsIgnoreCase("Father") && !TextUtils.isEmpty(Migration_preview_Form.this.doctypeFather)) {
                            for (int i3 = 0; i3 < Migration_preview_Form.this.List3docCode.size(); i3++) {
                                try {
                                    if (Migration_preview_Form.this.List3docCode.get(i3) != null && Migration_preview_Form.this.List3docCode.get(i3).equalsIgnoreCase(Migration_preview_Form.this.doctypeFather)) {
                                        Migration_preview_Form migration_preview_Form3 = Migration_preview_Form.this;
                                        migration_preview_Form3.list3code = migration_preview_Form3.doctypeFather;
                                        Migration_preview_Form migration_preview_Form4 = Migration_preview_Form.this;
                                        migration_preview_Form4.list3codeName = migration_preview_Form4.List3docName.get(i3);
                                        Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setSelection(i3);
                                        break;
                                    }
                                } catch (Exception e2) {
                                    Log.e("errror@spinner", e2.toString());
                                }
                            }
                        } else if (Migration_preview_Form.this.before2004ParentType.equalsIgnoreCase("Mother") && !TextUtils.isEmpty(Migration_preview_Form.this.doctypeMother)) {
                            for (int i4 = 0; i4 < Migration_preview_Form.this.List4docCode.size(); i4++) {
                                try {
                                    if (Migration_preview_Form.this.List4docCode.get(i4) != null && Migration_preview_Form.this.List4docCode.get(i4).equalsIgnoreCase(Migration_preview_Form.this.doctypeMother)) {
                                        Migration_preview_Form migration_preview_Form5 = Migration_preview_Form.this;
                                        migration_preview_Form5.list4code = migration_preview_Form5.doctypeMother;
                                        Migration_preview_Form migration_preview_Form6 = Migration_preview_Form.this;
                                        migration_preview_Form6.list4codeName = migration_preview_Form6.List4docName.get(i4);
                                        Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setSelection(i4);
                                        break;
                                    }
                                } catch (Exception e3) {
                                    Log.e("errror@spinner", e3.toString());
                                }
                            }
                        }
                    }
                    if (Migration_preview_Form.this.after2004isParentIndian != null && Migration_preview_Form.this.after2004isParentIndian.equalsIgnoreCase("Y")) {
                        if (!Migration_preview_Form.this.after2004doctypeFather.equalsIgnoreCase("") && !Migration_preview_Form.this.after2004doctypeFather.equalsIgnoreCase("")) {
                            for (int i5 = 0; i5 < Migration_preview_Form.this.List3docCode.size(); i5++) {
                                try {
                                    if (Migration_preview_Form.this.List3docCode.get(i5) != null && Migration_preview_Form.this.List3docCode.get(i5).equalsIgnoreCase(Migration_preview_Form.this.after2004doctypeFather)) {
                                        Migration_preview_Form migration_preview_Form7 = Migration_preview_Form.this;
                                        migration_preview_Form7.list3code = migration_preview_Form7.after2004doctypeFather;
                                        Migration_preview_Form migration_preview_Form8 = Migration_preview_Form.this;
                                        migration_preview_Form8.list3codeName = migration_preview_Form8.List3docName.get(i5);
                                        Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setSelection(i5);
                                        break;
                                    }
                                } catch (Exception e4) {
                                    Log.e("errror@spinner", e4.toString());
                                }
                            }
                        }
                        if (!Migration_preview_Form.this.after2004doctypeMother.equalsIgnoreCase("") && !Migration_preview_Form.this.after2004doctypeMother.equalsIgnoreCase("")) {
                            for (int i6 = 0; i6 < Migration_preview_Form.this.List4docCode.size(); i6++) {
                                try {
                                    if (Migration_preview_Form.this.List4docCode.get(i6) != null && Migration_preview_Form.this.List4docCode.get(i6).equalsIgnoreCase(Migration_preview_Form.this.after2004doctypeMother)) {
                                        Migration_preview_Form migration_preview_Form9 = Migration_preview_Form.this;
                                        migration_preview_Form9.list4code = migration_preview_Form9.after2004doctypeMother;
                                        Migration_preview_Form migration_preview_Form10 = Migration_preview_Form.this;
                                        migration_preview_Form10.list4codeName = migration_preview_Form10.List4docName.get(i6);
                                        Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setSelection(i6);
                                        break;
                                    }
                                } catch (Exception e5) {
                                    Log.e("errror@spinner", e5.toString());
                                }
                            }
                        }
                    } else if (Migration_preview_Form.this.after2004isParentIndian != null && Migration_preview_Form.this.after2004isParentIndian.equalsIgnoreCase("N")) {
                        if (Migration_preview_Form.this.after2004ParentNameNotindian.equalsIgnoreCase("Father")) {
                            if (!Migration_preview_Form.this.after2004doctypeFather.equalsIgnoreCase("")) {
                                for (int i7 = 0; i7 < Migration_preview_Form.this.List5docCode.size(); i7++) {
                                    try {
                                        if (Migration_preview_Form.this.List5docCode.get(i7) != null && Migration_preview_Form.this.List5docCode.get(i7).equalsIgnoreCase(Migration_preview_Form.this.after2004doctypeFather)) {
                                            Migration_preview_Form migration_preview_Form11 = Migration_preview_Form.this;
                                            migration_preview_Form11.list5code = migration_preview_Form11.after2004doctypeFather;
                                            Migration_preview_Form migration_preview_Form12 = Migration_preview_Form.this;
                                            migration_preview_Form12.list5codeName = migration_preview_Form12.List5docName.get(i7);
                                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setSelection(i7);
                                            break;
                                        }
                                    } catch (Exception e6) {
                                        Log.e("errror@spinner", e6.toString());
                                    }
                                }
                            }
                            if (!Migration_preview_Form.this.after2004doctypeMother.equalsIgnoreCase("")) {
                                for (int i8 = 0; i8 < Migration_preview_Form.this.List4docCode.size(); i8++) {
                                    try {
                                        if (Migration_preview_Form.this.List4docCode.get(i8) != null && Migration_preview_Form.this.List4docCode.get(i8).equalsIgnoreCase(Migration_preview_Form.this.after2004doctypeMother)) {
                                            Migration_preview_Form migration_preview_Form13 = Migration_preview_Form.this;
                                            migration_preview_Form13.list4code = migration_preview_Form13.after2004doctypeMother;
                                            Migration_preview_Form migration_preview_Form14 = Migration_preview_Form.this;
                                            migration_preview_Form14.list4codeName = migration_preview_Form14.List4docName.get(i8);
                                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setSelection(i8);
                                            break;
                                        }
                                    } catch (Exception e7) {
                                        Log.e("errror@spinner", e7.toString());
                                    }
                                }
                            }
                        }
                        if (Migration_preview_Form.this.after2004ParentNameNotindian.equalsIgnoreCase("Mother")) {
                            if (!Migration_preview_Form.this.after2004doctypeFather.equalsIgnoreCase("")) {
                                for (int i9 = 0; i9 < Migration_preview_Form.this.List3docCode.size(); i9++) {
                                    try {
                                        if (Migration_preview_Form.this.List3docCode.get(i9) != null && Migration_preview_Form.this.List3docCode.get(i9).equalsIgnoreCase(Migration_preview_Form.this.after2004doctypeFather)) {
                                            Migration_preview_Form migration_preview_Form15 = Migration_preview_Form.this;
                                            migration_preview_Form15.list3code = migration_preview_Form15.after2004doctypeFather;
                                            Migration_preview_Form migration_preview_Form16 = Migration_preview_Form.this;
                                            migration_preview_Form16.list3codeName = migration_preview_Form16.List3docName.get(i9);
                                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setSelection(i9);
                                            break;
                                        }
                                    } catch (Exception e8) {
                                        Log.e("errror@spinner", e8.toString());
                                    }
                                }
                            }
                            if (!Migration_preview_Form.this.after2004doctypeMother.equalsIgnoreCase("")) {
                                for (int i10 = 0; i10 < Migration_preview_Form.this.List5docCode.size(); i10++) {
                                    try {
                                        if (Migration_preview_Form.this.List5docCode.get(i10) != null && Migration_preview_Form.this.List5docCode.get(i10).equalsIgnoreCase(Migration_preview_Form.this.after2004doctypeMother)) {
                                            Migration_preview_Form migration_preview_Form17 = Migration_preview_Form.this;
                                            migration_preview_Form17.list5code = migration_preview_Form17.after2004doctypeMother;
                                            Migration_preview_Form migration_preview_Form18 = Migration_preview_Form.this;
                                            migration_preview_Form18.list5codeName = migration_preview_Form18.List5docName.get(i10);
                                            Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setSelection(i10);
                                            break;
                                        }
                                    } catch (Exception e9) {
                                        Log.e("errror@spinner", e9.toString());
                                    }
                                }
                            }
                        }
                    }
                    if (Migration_preview_Form.this.bornOutofIndiadoctype != null && !Migration_preview_Form.this.bornOutofIndiadoctype.equalsIgnoreCase("")) {
                        for (int i11 = 0; i11 < Migration_preview_Form.this.List6docCode.size(); i11++) {
                            try {
                                if (Migration_preview_Form.this.List6docCode.get(i11) != null && Migration_preview_Form.this.List6docCode.get(i11).equalsIgnoreCase(Migration_preview_Form.this.bornOutofIndiadoctype)) {
                                    Migration_preview_Form migration_preview_Form19 = Migration_preview_Form.this;
                                    migration_preview_Form19.list6code = migration_preview_Form19.bornOutofIndiadoctype;
                                    Migration_preview_Form migration_preview_Form20 = Migration_preview_Form.this;
                                    migration_preview_Form20.list6codeName = migration_preview_Form20.List6docName.get(i11);
                                    Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setSelection(i11);
                                }
                            } catch (Exception e10) {
                                Log.e("errror@spinner", e10.toString());
                            }
                        }
                    }
                    if (Migration_preview_Form.this.citizenAquuireddoctype == null || Migration_preview_Form.this.citizenAquuireddoctype.equalsIgnoreCase("")) {
                        return;
                    }
                    for (int i12 = 0; i12 < Migration_preview_Form.this.List7docCode.size(); i12++) {
                        try {
                            if (Migration_preview_Form.this.List7docCode.get(i12) != null && Migration_preview_Form.this.List7docCode.get(i12).equalsIgnoreCase(Migration_preview_Form.this.citizenAquuireddoctype)) {
                                Migration_preview_Form migration_preview_Form21 = Migration_preview_Form.this;
                                migration_preview_Form21.list7code = migration_preview_Form21.citizenAquuireddoctype;
                                Migration_preview_Form migration_preview_Form22 = Migration_preview_Form.this;
                                migration_preview_Form22.list7codeName = migration_preview_Form22.List7docName.get(i12);
                                Migration_preview_Form.this.binding.annexureDIncludedLayout.spinnerAcquired.setSelection(i12);
                            }
                        } catch (Exception e11) {
                            Log.e("errror@spinner", e11.toString());
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = Migration_preview_Form.this.commonUtilClass;
                    FragmentActivity activity = Migration_preview_Form.this.getActivity();
                    String str = Migration_preview_Form.this.refreshToken;
                    final String str2 = this.val$list;
                    commomUtility.getRefreshToken(activity, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$11$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i13, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i13, str3, str4);
                        }
                    });
                    return;
                } catch (Exception e12) {
                    Logger.e("TAG", e12.toString());
                    return;
                }
            }
            try {
                if (Migration_preview_Form.this.alertDialog != null) {
                    Migration_preview_Form.this.alertDialog.dismiss();
                }
                Logger.e("TAG", new JSONObject(response.errorBody().string()).optString(Migration_preview_Form.MESSAGE));
            } catch (IOException | JSONException e13) {
                if (Migration_preview_Form.this.alertDialog != null) {
                    Migration_preview_Form.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e13.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            if (Migration_preview_Form.this.alertDialog != null) {
                Migration_preview_Form.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Form.this.commonUtilClass.showMessageOK(Migration_preview_Form.this.getActivity(), Migration_preview_Form.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form$11$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Form.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Form.this.getActivity()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Form.this.getActivity()).setToken("Bearer " + str2);
            Migration_preview_Form.this.getList1(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Form.this.getActivity()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Form.this.getActivity()).setLocaleBool(false);
            Migration_preview_Form.this.startActivity(new Intent((Context) Migration_preview_Form.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d("TAG", "OnFailure" + t.getMessage());
        }
    }

    private void disbleView() {
        this.binding.annexureDIncludedLayout.formAnnxBornIndia.setEnabled(false);
        this.binding.annexureDIncludedLayout.formAnnxNotBorn.setEnabled(false);
        this.binding.annexureDIncludedLayout.formAnnxIndiaCitize.setEnabled(false);
        this.binding.annexureDIncludedLayout.llBefore1987.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerBefore1987Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileBefore1987.setEnabled(false);
        this.binding.annexureDIncludedLayout.viewLayoutList1.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelList1.setEnabled(false);
        this.binding.annexureDIncludedLayout.llBefore2004.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerBefore2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.viewLayoutBefore2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelBefore2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.betweenSelectParentLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.betweenParentFatherRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.betweenParentMotherRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerBefore2004Father.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setEnabled(false);
        this.binding.annexureDIncludedLayout.viewLayoutList2.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelList2.setEnabled(false);
        this.binding.annexureDIncludedLayout.viewFather1OldLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.father1OldAcNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.father1OldPartNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.father1OldPslNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.llAfter2004.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerAfter2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setEnabled(false);
        this.binding.annexureDIncludedLayout.viewLayoutAfter2004self.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelAfter2004self.setEnabled(false);
        this.binding.annexureDIncludedLayout.parentYesRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.parentNoRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.llParentLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.selectParentLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.parentFatherRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.parentMotherRb.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerAfter2004Father.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelList3.setEnabled(false);
        this.binding.annexureDIncludedLayout.viewFatherOldLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.fatherOldAcNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.fatherOldPartNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.fatherOldPslNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerAfter2004Mother.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelList4.setEnabled(false);
        this.binding.annexureDIncludedLayout.viewMotherOldLayout.setEnabled(false);
        this.binding.annexureDIncludedLayout.motherOldAcNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.motherOldPartNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.motherOldPslNo.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerAfter2004NotIndian.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelList5.setEnabled(false);
        this.binding.annexureDIncludedLayout.llBornOutOfIndia.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerBornOutOfIndia.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelList6.setEnabled(false);
        this.binding.annexureDIncludedLayout.llAcquired.setEnabled(false);
        this.binding.annexureDIncludedLayout.spinnerAcquired.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileAcquired.setEnabled(false);
        this.binding.annexureDIncludedLayout.cancelList7.setEnabled(false);
        this.binding.annexureDIncludedLayout.annexureDSign.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileSign.setEnabled(false);
        this.binding.annexureDIncludedLayout.viewLayoutSign.setEnabled(false);
        this.binding.annexureDIncludedLayout.signDeleteList1.setEnabled(false);
        this.binding.annexureDIncludedLayout.chooseFileBefore1987.setVisibility(8);
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Self.setVisibility(8);
        this.binding.annexureDIncludedLayout.chooseFileBefore2004Father.setVisibility(8);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Self.setVisibility(8);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Father.setVisibility(8);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004Mother.setVisibility(8);
        this.binding.annexureDIncludedLayout.chooseFileAfter2004NotIndian.setVisibility(8);
        this.binding.annexureDIncludedLayout.chooseFileAcquired.setVisibility(8);
        this.binding.annexureDIncludedLayout.chooseFileSign.setVisibility(8);
    }

    private void declarationForm() {
        this.binding.declarationFormLayout.dfETfatherEpicNumber.setText(this.formverificationPayload.fatherOrGuardianName);
        this.binding.declarationFormLayout.dfETmotherName.setText(this.formverificationPayload.mothersName);
        if (!this.formverificationPayload.spouseName.equals("")) {
            this.binding.declarationFormLayout.dfETspouseName.setText(this.formverificationPayload.spouseName);
        } else {
            this.binding.declarationFormLayout.llSpouseName.setVisibility(8);
        }
        if (!this.formverificationPayload.spouseEpicNo.equals("")) {
            this.binding.declarationFormLayout.dfETspouseEpicNumber.setText(this.formverificationPayload.spouseEpicNo);
        } else {
            this.binding.declarationFormLayout.llSpouseEpicNo.setVisibility(8);
        }
        if (!this.formverificationPayload.fatherOrGuardianEpicNo.equals("")) {
            this.binding.declarationFormLayout.dfETfatherEpicNumber.setText(this.formverificationPayload.fatherOrGuardianEpicNo);
        } else {
            this.binding.declarationFormLayout.llFatherEpicNo.setVisibility(8);
        }
        if (!this.formverificationPayload.fatherOrGuardianName.equals("")) {
            this.binding.declarationFormLayout.dfETfatherName.setText(this.formverificationPayload.fatherOrGuardianName);
        }
        if (!this.formverificationPayload.mothersEpicNo.equals("")) {
            this.binding.declarationFormLayout.dfETmotherEpicNumber.setText(this.formverificationPayload.mothersEpicNo);
        } else {
            this.binding.declarationFormLayout.llMotherEpic.setVisibility(8);
        }
        if (!this.formverificationPayload.mothersName.equals("")) {
            this.binding.declarationFormLayout.dfETmotherEpicNumber.setText(this.formverificationPayload.mothersEpicNo);
        }
        this.binding.declarationFormLayout.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{SharedPref.getInstance(requireContext()).getlastSIRYear()}));
        this.binding.declarationFormLayout.dfRBselfRb.setText(getString(R.string.ef_was_elector_2003_text, new Object[]{SharedPref.getInstance(requireContext()).getlastSIRYear()}));
        this.binding.declarationFormLayout.dfRBprogenyRb.setText(getString(R.string.ef_progeny_2003_text, new Object[]{SharedPref.getInstance(requireContext()).getlastSIRYear()}));
        this.binding.declarationFormLayout.dfRBneitherRb.setText(getString(R.string.ef_neither_self_nor_progeny_text, new Object[]{SharedPref.getInstance(requireContext()).getlastSIRYear()}));
        this.binding.declarationFormLayout.dfRgsearchRG.setEnabled(false);
        this.binding.declarationFormLayout.dfRBselfRb.setEnabled(false);
        this.binding.declarationFormLayout.dfRBprogenyRb.setEnabled(false);
        this.binding.declarationFormLayout.dfRBneitherRb.setEnabled(false);
        this.binding.declarationFormLayout.chooseFileName.setText(this.formverificationPayload.getImageName());
        this.binding.declarationFormLayout.chooseFileNameSize.setText(this.formverificationPayload.getImageSize());
        if (this.formverificationPayload.getIsSir03().equalsIgnoreCase("Y")) {
            this.binding.declarationFormLayout.dfRB2003.setChecked(true);
            this.binding.declarationFormLayout.dfRB2003.setEnabled(false);
            this.binding.declarationFormLayout.dfLlElectorPresent.setVisibility(0);
        } else if (this.formverificationPayload.getIsSir2526().equalsIgnoreCase("Y")) {
            this.binding.declarationFormLayout.dfRB2025.setChecked(true);
            this.binding.declarationFormLayout.dfRB2025.setEnabled(false);
            this.binding.declarationFormLayout.dfRBprogenyRb.setText(getString(R.string.ef_progeny_2003_text, new Object[]{"2025/2026"}));
            this.binding.declarationFormLayout.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{"2025/2026"}));
            this.binding.declarationFormLayout.dfRBselfRb.setText(getString(R.string.ef_was_elector_2003_text, new Object[]{"2025/2026"}));
            this.binding.declarationFormLayout.dfLlElectorPresent.setVisibility(0);
        }
        if (this.formverificationPayload.categoryType.equalsIgnoreCase("self")) {
            this.binding.declarationFormLayout.dfRBselfRb.setChecked(true);
            this.binding.declarationFormLayout.dfRBselfRb.setEnabled(false);
            SetSelfChecked();
            SetProgenyChecked();
        } else if (this.formverificationPayload.categoryType.equalsIgnoreCase("progeny")) {
            this.binding.declarationFormLayout.dfRBprogenyRb.setChecked(true);
            this.binding.declarationFormLayout.dfRBprogenyRb.setEnabled(false);
            SetProgenyChecked();
        } else {
            this.binding.declarationFormLayout.dfRBneitherRb.setChecked(true);
            this.binding.declarationFormLayout.dfRBneitherRb.setEnabled(false);
        }
        if (this.formverificationPayload.relationTypeValue != null) {
            this.binding.declarationFormLayout.dfCdrelationtypecardview.setVisibility(0);
            new ArrayList();
            new ArrayAdapter(requireContext(), R.layout.blo_spinner_dropdown, SharedPref.getInstance(requireContext()).getRelativeListName(Constants.RELATIVE_LIST_NAME)).setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
            this.binding.declarationFormLayout.dfprogenyRelationSpinner.setEnabled(false);
        }
        DisplayImage(this.formverificationPayload.imageURL, "", "", this.binding.declarationFormLayout.preview, null, null);
    }

    private void SetProgenyChecked() {
        if (checkProgenyEmpty()) {
            return;
        }
        this.binding.declarationFormLayout.cdDfRelativeCardView.setVisibility(0);
        this.binding.declarationFormLayout.dfTvtvRlName.setText(this.formverificationPayload.getRlnPrgyName());
        this.binding.declarationFormLayout.dfTvtvRlEpic.setText(this.formverificationPayload.getRlnPrgyEpic());
        this.binding.declarationFormLayout.dfTvtvRlName1.setText(this.formverificationPayload.getRlnPrgyRlnName());
        setRelativeType(this.formverificationPayload.getRlnPrgyRlnType(), this.binding.declarationFormLayout.dfTvtvRlRelation);
        setRelativeType(this.formverificationPayload.getRelationSpinnerType(), this.binding.declarationFormLayout.dfprogenyRelationSpinner);
        this.binding.declarationFormLayout.dfCdrelationtypecardview.setVisibility(0);
        this.binding.declarationFormLayout.dfTvtvRlState.setText(this.formverificationPayload.getProgenySearchedStateName());
        this.binding.declarationFormLayout.dfTvtvRlAcName.setText(this.formverificationPayload.getProgenyAcName());
        this.binding.declarationFormLayout.dfTvtvRlAcNo.setText(String.valueOf(this.formverificationPayload.getRelationOldAcNo()));
        this.binding.declarationFormLayout.dfTvtvRlPartNo.setText(String.valueOf(this.formverificationPayload.getRelationOldPartNo()));
        this.binding.declarationFormLayout.dfTvtvRlSrNo.setText(String.valueOf(this.formverificationPayload.getRelationOldPslNo()));
    }

    private void SetSelfChecked() {
        if (checkSelfEmpty()) {
            return;
        }
        this.binding.declarationFormLayout.cdDfSelfCardView.setVisibility(0);
        this.binding.declarationFormLayout.dfTvtvName.setText(this.formverificationPayload.getSelfOldName());
        this.binding.declarationFormLayout.dfTvtvEpic.setText(this.formverificationPayload.getSelfOldEpic());
        this.binding.declarationFormLayout.dfTvtvName1.setText(this.formverificationPayload.getSelfOldRlnName());
        setRelativeType(this.formverificationPayload.getSelfOldRlnType(), this.binding.declarationFormLayout.dfTvtvRelation);
        this.binding.declarationFormLayout.dfTvtvState.setText(this.formverificationPayload.getSelfSearchedStateName());
        this.binding.declarationFormLayout.dfTvtvAcName.setText(this.formverificationPayload.getOldAcName());
        this.binding.declarationFormLayout.dfTvtvAcNo.setText(String.valueOf(this.formverificationPayload.getOldAcNo()));
        this.binding.declarationFormLayout.dfTvtvPartNo.setText(String.valueOf(this.formverificationPayload.getOldPartNo()));
        this.binding.declarationFormLayout.dfTvtvSrNo.setText(String.valueOf(this.formverificationPayload.getOldPslNo()));
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

    private boolean checkSelfEmpty() {
        return this.formverificationPayload.getOldAcNo() == 0 && this.formverificationPayload.getOldPartNo() == 0 && this.formverificationPayload.getOldPslNo() == 0 && TextUtils.isEmpty(this.formverificationPayload.getOldStateCd()) && TextUtils.isEmpty(this.formverificationPayload.getSelfOldEpic()) && TextUtils.isEmpty(this.formverificationPayload.getSelfOldName()) && TextUtils.isEmpty(this.formverificationPayload.getSelfOldRlnName()) && TextUtils.isEmpty(this.formverificationPayload.getSelfOldRlnType());
    }

    private boolean checkProgenyEmpty() {
        return this.formverificationPayload.getRelationOldAcNo() == 0 && this.formverificationPayload.getRelationOldPartNo() == 0 && this.formverificationPayload.getRelationOldPslNo() == 0 && TextUtils.isEmpty(this.formverificationPayload.getRelationOldStateCd()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyEpic()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyName()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyRlnName()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyRlnType());
    }
}
