package in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloActivityPreviewForm7Binding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.DeletionObjectionViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.AsdActionrRoot;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlErrorCodes;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class PreviewForm7Activity extends Hilt_PreviewForm7Activity implements View.OnClickListener {
    String acNo;
    String age;
    AlertDialog alertDialog;
    String applicantEpic;
    String assembly;
    String assemblyno;
    private BloActivityPreviewForm7Binding binding;
    Retrofit.Builder builder2;
    String certificateAttached;
    String certificateName;
    String certificateSize;
    CommomUtility commonUtilClass;
    private String createdOn;
    private String date;
    String deletionObjection;
    String district;
    String districtCdOfPersonToBeDeleted;
    String districtCode;
    String docref;
    String epic;
    private String epicId;
    private String epicNumberId;
    String firstNameApplicant;
    private String flag;
    String gender;
    String house;
    String houseRegional;
    private String isSelfMobile;
    String lastNameApplicant;
    String mobileType;
    String mobilenum;
    private String name;
    String objectToInclFormRefNum;
    private String objectToInclFormType;
    String partNo;
    String partNumberApplicant;
    String partNumberOfPersonToBeDeleted;
    String pincode;
    String place;
    String postoffice;
    String postofficeRegional;
    private int pseId;
    String reasonForDeletion;
    String referenceNumber;
    private String refreshToken;
    String rejectionOption;
    String rejectionOptionSubcategory;
    private String request;
    Retrofit retrofit;
    String sectionNoApplicant;
    private String serialNumberApplicant;
    String serialNumberOfPersonToBeDeleted;
    UserClient service;
    String state;
    String stateCode;
    String street;
    String streetRegional;
    String surname;
    String tehsil;
    String tehsilRegional;
    String token;
    String uploadDoc1Photoname;
    String uploadDoc1Size;
    String uploadDoc2Photoname;
    String uploadDoc2Size;
    String uploadForm6Page1Url;
    String uploadForm6Page2Url;
    UserClient userClient;
    Utils utils;
    private DeletionObjectionViewModel viewModel;
    String village;
    String villageRegional;
    String districtCdOfPersonToBeDeletedString = "districtCdOfPersonToBeDeleted";
    String objectionString = "objection";
    String alert = "Alert";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    CommomUtility commomUtility = new CommomUtility();

    public PreviewForm7Activity() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder2 = builderClient;
        this.retrofit = builderClient.build();
        this.deletionObjection = "Deletion Objection";
        this.commonUtilClass = new CommomUtility();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityPreviewForm7Binding bloActivityPreviewForm7BindingInflate = BloActivityPreviewForm7Binding.inflate(getLayoutInflater());
        this.binding = bloActivityPreviewForm7BindingInflate;
        setContentView((View) bloActivityPreviewForm7BindingInflate.getRoot());
        this.viewModel = (DeletionObjectionViewModel) new ViewModelProvider(this).get(DeletionObjectionViewModel.class);
        this.token = SharedPref.getInstance(this).getToken();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.districtCode = SharedPref.getInstance(this).getDistrictCode();
        this.acNo = SharedPref.getInstance(this).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(this).getPartNumber();
        this.refreshToken = SharedPref.getInstance(this).getRefreshToken();
        this.userClient = (UserClient) ApiClient.getClient1(getApplicationContext()).create(UserClient.class);
        this.service = (UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class);
        Logger.d("token Deletion/Objecion", this.token);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("flag");
            this.flag = string;
            this.flag = nullChecker(string);
            String string2 = extras.getString("epicId");
            this.epicId = string2;
            this.epicId = nullChecker(string2);
            String string3 = extras.getString("epicNumberId");
            this.epicNumberId = string3;
            this.epicNumberId = nullChecker(string3);
            String string4 = extras.getString("request");
            this.request = string4;
            this.request = nullChecker(string4);
            String string5 = extras.getString("REFERENCE_NUMBER");
            this.referenceNumber = string5;
            this.referenceNumber = nullChecker(string5);
            String string6 = extras.getString("serialNumberApplicant");
            this.serialNumberApplicant = string6;
            this.serialNumberApplicant = nullChecker(string6);
            String string7 = extras.getString("serialNumberOfPersonToBeDeleted");
            this.serialNumberOfPersonToBeDeleted = string7;
            this.serialNumberOfPersonToBeDeleted = nullChecker(string7);
            String string8 = extras.getString("sectionNoApplicant");
            this.sectionNoApplicant = string8;
            this.sectionNoApplicant = nullChecker(string8);
            String string9 = extras.getString("partNumberApplicant");
            this.partNumberApplicant = string9;
            this.partNumberApplicant = nullCheckerPartNumber(string9);
            String string10 = extras.getString("partNumberOfPersonToBeDeleted");
            this.partNumberOfPersonToBeDeleted = string10;
            this.partNumberOfPersonToBeDeleted = nullCheckerPartNumber(string10);
            this.age = extras.getString("age");
            this.gender = extras.getString("gender");
            String string11 = extras.getString("state");
            this.state = string11;
            this.state = nullChecker(string11);
            String string12 = extras.getString("district");
            this.district = string12;
            this.district = nullChecker(string12);
            String string13 = extras.getString("assemblyno");
            this.assemblyno = string13;
            this.assemblyno = nullChecker(string13);
            String string14 = extras.getString("assembly");
            this.assembly = string14;
            this.assembly = nullChecker(string14);
            String string15 = extras.getString("firstNameApplicant");
            this.firstNameApplicant = string15;
            this.firstNameApplicant = nullChecker(string15);
            String string16 = extras.getString("lastNameApplicant");
            this.lastNameApplicant = string16;
            this.lastNameApplicant = nullChecker(string16);
            String string17 = extras.getString("applicantEpic");
            this.applicantEpic = string17;
            this.applicantEpic = nullChecker(string17);
            String string18 = extras.getString("mobileType");
            this.mobileType = string18;
            this.mobileType = nullChecker(string18);
            String string19 = extras.getString("mobilenum");
            this.mobilenum = string19;
            this.mobilenum = nullChecker(string19);
            String string20 = extras.getString("rejection");
            this.rejectionOption = string20;
            this.rejectionOption = nullChecker(string20);
            String string21 = extras.getString("subrejection");
            this.rejectionOptionSubcategory = string21;
            this.rejectionOptionSubcategory = nullChecker(string21);
            String string22 = extras.getString("reasonForDeletion");
            this.reasonForDeletion = string22;
            this.reasonForDeletion = nullChecker(string22);
            String string23 = extras.getString("certificateAttached");
            this.certificateAttached = string23;
            this.certificateAttached = nullChecker(string23);
            String string24 = extras.getString("certificateName");
            this.certificateName = string24;
            this.certificateName = nullChecker(string24);
            String string25 = extras.getString("certificateSize");
            this.certificateSize = string25;
            this.certificateSize = nullChecker(string25);
            String string26 = extras.getString("docref");
            this.docref = string26;
            this.docref = nullChecker(string26);
            String string27 = extras.getString("name");
            this.name = string27;
            this.name = nullChecker(string27);
            String string28 = extras.getString("surname");
            this.surname = string28;
            this.surname = nullChecker(string28);
            String string29 = extras.getString("epic");
            this.epic = string29;
            this.epic = nullChecker(string29);
            String string30 = extras.getString("house");
            this.house = string30;
            this.house = nullChecker(string30);
            String string31 = extras.getString("houseRegional");
            this.houseRegional = string31;
            this.houseRegional = nullChecker(string31);
            String string32 = extras.getString("street");
            this.street = string32;
            this.street = nullChecker(string32);
            String string33 = extras.getString("streetRegional");
            this.streetRegional = string33;
            this.streetRegional = nullChecker(string33);
            String string34 = extras.getString("village");
            this.village = string34;
            this.village = nullChecker(string34);
            String string35 = extras.getString("villageRegional");
            this.villageRegional = string35;
            this.villageRegional = nullChecker(string35);
            String string36 = extras.getString("postoffice");
            this.postoffice = string36;
            this.postoffice = nullChecker(string36);
            String string37 = extras.getString("postofficeRegional");
            this.postofficeRegional = string37;
            this.postofficeRegional = nullChecker(string37);
            String string38 = extras.getString("pincode");
            this.pincode = string38;
            this.pincode = nullChecker(string38);
            String string39 = extras.getString("tehsil");
            this.tehsil = string39;
            this.tehsil = nullChecker(string39);
            String string40 = extras.getString("tehsilRegional");
            this.tehsilRegional = string40;
            this.tehsilRegional = nullChecker(string40);
            String string41 = extras.getString(this.districtCdOfPersonToBeDeletedString);
            this.districtCdOfPersonToBeDeleted = string41;
            this.districtCdOfPersonToBeDeleted = nullChecker(string41);
            String string42 = extras.getString(XmlErrorCodes.DATE);
            this.date = string42;
            this.date = nullChecker(string42);
            String string43 = extras.getString("objectToInclFormRefNum");
            this.objectToInclFormRefNum = string43;
            this.objectToInclFormRefNum = nullChecker(string43);
            String string44 = extras.getString("objectToInclFormType");
            this.objectToInclFormType = string44;
            this.objectToInclFormType = nullChecker(string44);
            String string45 = extras.getString("place");
            this.place = string45;
            this.place = nullChecker(string45);
            this.uploadForm6Page1Url = extras.getString("offlineSignedPage1Url");
            this.uploadForm6Page2Url = extras.getString("offlineSignedPage2Url");
            this.uploadDoc1Photoname = extras.getString("addDoc1ImageName");
            this.uploadDoc1Size = extras.getString("addDoc1ImageSize");
            this.uploadDoc2Photoname = extras.getString("addDoc2ImageName");
            this.uploadDoc2Size = extras.getString("addDoc2ImageSize");
            extras.clear();
        }
        this.alertDialog.show();
        imageLoader(this.docref, this.token);
        if (!TextUtils.isEmpty(this.flag)) {
            Logger.d("flag preview", this.flag);
        }
        this.createdOn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().getTime());
        starMarkerAndRemover();
        fieldupdater();
        initializingClicks();
        page1ImageLoader(this.uploadForm6Page1Url, this.token);
        page2ImageLoader(this.uploadForm6Page2Url, this.token);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void imageLoader(String docref, String Token) {
        this.commomUtility.getRetrofitClient(this, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd()).getFile("objectstorage", docref, Token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass1(docref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        final /* synthetic */ String val$docref;

        AnonymousClass1(final String val$docref) {
            this.val$docref = val$docref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context, in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity] */
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
                Logger.d(PreviewForm7Activity.this.deletionObjection, String.valueOf(((JsonObject) response.body()).get("message")));
                String strReplace = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!strReplace.isEmpty() && !strReplace.equals("null") && strReplace != null) {
                    if (PreviewForm7Activity.this.certificateName.contains(".pdf")) {
                        PreviewForm7Activity.this.binding.previewImage.setImageResource(R.drawable.blo_pfd_thumbnail);
                        PreviewForm7Activity.this.binding.uploadName.setText(PreviewForm7Activity.this.certificateName);
                    } else {
                        byte[] bArrDecode = Base64.decode(strReplace, 0);
                        PreviewForm7Activity.this.binding.previewImage.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                        PreviewForm7Activity.this.binding.uploadName.setText(PreviewForm7Activity.this.certificateName);
                    }
                }
                PreviewForm7Activity.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = PreviewForm7Activity.this.commomUtility;
                ?? r5 = PreviewForm7Activity.this;
                String str = ((PreviewForm7Activity) r5).refreshToken;
                final String str2 = this.val$docref;
                commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$1$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
                return;
            }
            PreviewForm7Activity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
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
            PreviewForm7Activity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                PreviewForm7Activity.this.commomUtility.showMessageOK(PreviewForm7Activity.this, DeletionObjectionForm.sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PreviewForm7Activity.this.token = "Bearer " + str2;
            SharedPref.getInstance(PreviewForm7Activity.this).setRefreshToken(str3);
            SharedPref.getInstance(PreviewForm7Activity.this).setToken("Bearer " + str2);
            PreviewForm7Activity previewForm7Activity = PreviewForm7Activity.this;
            previewForm7Activity.imageLoader(str, previewForm7Activity.token);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PreviewForm7Activity.this).setIsLoggedIn(false);
            SharedPref.getInstance(PreviewForm7Activity.this).setLocaleBool(false);
            PreviewForm7Activity.this.startActivity(new Intent((Context) PreviewForm7Activity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            PreviewForm7Activity.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void page1ImageLoader(String docref, String Token) {
        this.commomUtility.getRetrofitClient(this, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd()).getFile("objectstorage", docref, Token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass2(docref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        final /* synthetic */ String val$docref;

        AnonymousClass2(final String val$docref) {
            this.val$docref = val$docref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context, in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity] */
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
                Logger.d(PreviewForm7Activity.this.deletionObjection, String.valueOf(((JsonObject) response.body()).get("message")));
                String strReplace = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!strReplace.isEmpty() && !strReplace.equals("null") && strReplace != null) {
                    if (PreviewForm7Activity.this.certificateName.contains(".pdf")) {
                        PreviewForm7Activity.this.binding.addDoc1Img.setImageResource(R.drawable.blo_pfd_thumbnail);
                        PreviewForm7Activity.this.binding.addDoc1Filename.setText(PreviewForm7Activity.this.uploadDoc1Photoname);
                    } else {
                        byte[] bArrDecode = Base64.decode(strReplace, 0);
                        PreviewForm7Activity.this.binding.addDoc1Img.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                        PreviewForm7Activity.this.binding.addDoc1Filename.setText(PreviewForm7Activity.this.uploadDoc1Photoname);
                    }
                }
                PreviewForm7Activity.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = PreviewForm7Activity.this.commomUtility;
                ?? r5 = PreviewForm7Activity.this;
                String str = ((PreviewForm7Activity) r5).refreshToken;
                final String str2 = this.val$docref;
                commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
                return;
            }
            PreviewForm7Activity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
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
            PreviewForm7Activity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                PreviewForm7Activity.this.commomUtility.showMessageOK(PreviewForm7Activity.this, DeletionObjectionForm.sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PreviewForm7Activity.this.token = "Bearer " + str2;
            SharedPref.getInstance(PreviewForm7Activity.this).setRefreshToken(str3);
            SharedPref.getInstance(PreviewForm7Activity.this).setToken("Bearer " + str2);
            PreviewForm7Activity previewForm7Activity = PreviewForm7Activity.this;
            previewForm7Activity.page1ImageLoader(str, previewForm7Activity.token);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PreviewForm7Activity.this).setIsLoggedIn(false);
            SharedPref.getInstance(PreviewForm7Activity.this).setLocaleBool(false);
            PreviewForm7Activity.this.startActivity(new Intent((Context) PreviewForm7Activity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            PreviewForm7Activity.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void page2ImageLoader(String docref, String Token) {
        this.commomUtility.getRetrofitClient(this, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd()).getFile("objectstorage", docref, Token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass3(docref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        final /* synthetic */ String val$docref;

        AnonymousClass3(final String val$docref) {
            this.val$docref = val$docref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context, in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity] */
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
                Logger.d(PreviewForm7Activity.this.deletionObjection, String.valueOf(((JsonObject) response.body()).get("message")));
                String strReplace = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!strReplace.isEmpty() && !strReplace.equals("null") && strReplace != null) {
                    if (PreviewForm7Activity.this.certificateName.contains(".pdf")) {
                        PreviewForm7Activity.this.binding.addDoc2Img.setImageResource(R.drawable.blo_pfd_thumbnail);
                        PreviewForm7Activity.this.binding.addDoc1Filename.setText(PreviewForm7Activity.this.uploadDoc2Photoname);
                    } else {
                        byte[] bArrDecode = Base64.decode(strReplace, 0);
                        PreviewForm7Activity.this.binding.addDoc2Img.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                        PreviewForm7Activity.this.binding.addDoc2Filename.setText(PreviewForm7Activity.this.uploadDoc2Photoname);
                    }
                }
                PreviewForm7Activity.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = PreviewForm7Activity.this.commomUtility;
                ?? r5 = PreviewForm7Activity.this;
                String str = ((PreviewForm7Activity) r5).refreshToken;
                final String str2 = this.val$docref;
                commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$3$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
                return;
            }
            PreviewForm7Activity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
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
            PreviewForm7Activity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                PreviewForm7Activity.this.commomUtility.showMessageOK(PreviewForm7Activity.this, DeletionObjectionForm.sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$3$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PreviewForm7Activity.this.token = "Bearer " + str2;
            SharedPref.getInstance(PreviewForm7Activity.this).setRefreshToken(str3);
            SharedPref.getInstance(PreviewForm7Activity.this).setToken("Bearer " + str2);
            PreviewForm7Activity previewForm7Activity = PreviewForm7Activity.this;
            previewForm7Activity.page2ImageLoader(str, previewForm7Activity.token);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PreviewForm7Activity.this).setIsLoggedIn(false);
            SharedPref.getInstance(PreviewForm7Activity.this).setLocaleBool(false);
            PreviewForm7Activity.this.startActivity(new Intent((Context) PreviewForm7Activity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            PreviewForm7Activity.this.alertDialog.dismiss();
        }
    }

    private String nullChecker(String bundleObject) {
        return (Objects.equals(bundleObject, null) || bundleObject.equals("null")) ? "" : bundleObject;
    }

    private String nullCheckerPartNumber(String bundleObject) {
        return (Objects.equals(bundleObject, null) || bundleObject.equals("null") || bundleObject.isEmpty()) ? this.partNo : bundleObject;
    }

    private void starMarkerAndRemover() {
        this.binding.textView1.setText(mandatoryremover(this.binding.textView1.getText().toString()));
        this.binding.textView2.setText(mandatoryremover(this.binding.textView2.getText().toString()));
        this.binding.constituencyTv.setText(mandatoryremover(this.binding.constituencyTv.getText().toString()));
        this.binding.textView9.setText(mandatoryremover(this.binding.textView9.getText().toString()));
        this.binding.textView12.setText(mandatoryremover(this.binding.textView12.getText().toString()));
        this.binding.textView13.setText(mandatoryremover(this.binding.textView13.getText().toString()));
        this.binding.mobNumTv.setText(mandatoryremover(this.binding.mobNumTv.getText().toString()));
        this.binding.textView15.setText(mandatoryremover(this.binding.textView15.getText().toString()));
        this.binding.textView17.setText(mandatoryremover(this.binding.textView17.getText().toString()));
        this.binding.textView18.setText(mandatoryremover(this.binding.textView18.getText().toString()));
        this.binding.textView19.setText(mandatoryremover(this.binding.textView19.getText().toString()));
        this.binding.textView21.setText(mandatoryremover(this.binding.textView21.getText().toString()));
        this.binding.textView22.setText(mandatoryremover(this.binding.textView22.getText().toString()));
        this.binding.villageTv.setText(mandatoryremover(this.binding.villageTv.getText().toString()));
        this.binding.postofficeTv.setText(mandatoryremover(this.binding.postofficeTv.getText().toString()));
        this.binding.textView25.setText(mandatoryremover(this.binding.textView25.getText().toString()));
        this.binding.tehsilTv.setText(mandatoryremover(this.binding.tehsilTv.getText().toString()));
        this.binding.stateTv1.setText(mandatoryremover(this.binding.stateTv1.getText().toString()));
        this.binding.districtTv1.setText(mandatoryremover(this.binding.districtTv1.getText().toString()));
        this.binding.textView31.setText(mandatoryremover(this.binding.textView31.getText().toString()));
        this.binding.textView32.setText(mandatoryremover(this.binding.textView32.getText().toString()));
    }

    private void fieldupdater() {
        this.binding.stateTv.setText(this.state);
        this.binding.districtTv.setText(this.district);
        this.binding.constituencynoEd.setText(this.assemblyno);
        this.binding.constituencyEd.setText(this.assembly);
        if (this.lastNameApplicant.equals("null") || this.lastNameApplicant.isEmpty()) {
            this.binding.firstnameEd.setText(this.firstNameApplicant);
        } else {
            this.binding.firstnameEd.setText(this.firstNameApplicant + StringUtils.SPACE + this.lastNameApplicant);
        }
        this.binding.epicEd.setText(this.applicantEpic);
        if (this.mobileType.equals("Self")) {
            this.binding.self.setChecked(true);
            this.binding.self.setEnabled(true);
            this.binding.relative.setEnabled(false);
            this.isSelfMobile = "Y";
        } else {
            this.binding.self.setEnabled(false);
            this.binding.relative.setEnabled(true);
            this.binding.relative.setChecked(true);
            this.isSelfMobile = "N";
        }
        this.binding.mobnumEd.setText(this.mobilenum);
        this.binding.deathLayout.setVisibility(8);
        if (this.rejectionOptionSubcategory.equals("Death")) {
            this.binding.deathLayout.setVisibility(0);
        }
        if (this.rejectionOption.equals("I request to delete name of the person mentioned below already included in the current roll due to any one of the following reasons,")) {
            this.request = "other";
            SpannableString spannableString = new SpannableString("I request to delete name of the person mentioned below already included in the current roll due to any one of the following reasons, " + this.rejectionOptionSubcategory);
            spannableString.setSpan(new StyleSpan(1), 132, this.rejectionOptionSubcategory.length() + 133, 33);
            Logger.d(this.deletionObjection, String.valueOf(spannableString));
            this.binding.optionRb1.setChecked(true);
            this.binding.optionRb1.setText(spannableString);
            this.binding.optionRb2.setEnabled(false);
            this.binding.optionRb3.setEnabled(false);
        } else if (this.rejectionOption.equals("I object to proposed inclusion of name of the person mentioned below due to any one of the following reasons,")) {
            this.request = this.objectionString;
            SpannableString spannableString2 = new SpannableString("I object to proposed inclusion of name of the person mentioned below due to any one of the following reasons, " + this.rejectionOptionSubcategory);
            spannableString2.setSpan(new StyleSpan(1), 109, this.rejectionOptionSubcategory.length() + 110, 33);
            Logger.d(this.deletionObjection, String.valueOf(spannableString2));
            this.binding.optionRb1.setEnabled(false);
            this.binding.optionRb2.setChecked(true);
            this.binding.optionRb2.setText(spannableString2);
            this.binding.optionRb3.setEnabled(false);
        } else if (this.rejectionOption.equals("I request to delete my name from electoral roll due to any one of the following reasons,")) {
            this.request = "same";
            SpannableString spannableString3 = new SpannableString("I request to delete my name from electoral roll due to any one of the following reasons, " + this.rejectionOptionSubcategory);
            spannableString3.setSpan(new StyleSpan(1), 88, this.rejectionOptionSubcategory.length() + 89, 33);
            Logger.d(this.deletionObjection, String.valueOf(spannableString3));
            this.binding.optionRb1.setEnabled(false);
            this.binding.optionRb2.setEnabled(false);
            this.binding.optionRb3.setChecked(true);
            this.binding.optionRb3.setText(spannableString3);
        }
        if (this.certificateAttached.equals("Yes")) {
            this.binding.yesRg.setChecked(true);
            this.binding.noRg.setEnabled(false);
        } else {
            this.binding.noRg.setChecked(true);
            this.binding.yesRg.setEnabled(false);
            this.binding.upload.setVisibility(8);
            this.binding.uploadName.setVisibility(8);
            this.binding.previewImage.setVisibility(8);
        }
        this.binding.nameEd.setText(this.name);
        this.binding.surnameEd2.setText(this.surname);
        this.binding.epicEd2.setText(this.epic);
        this.binding.houseEd.setText(this.house);
        this.binding.houseEd2.setText(this.houseRegional);
        this.binding.streetEd.setText(this.street);
        this.binding.streetEd2.setText(this.streetRegional);
        this.binding.villageEd.setText(this.village);
        this.binding.villageEd2.setText(this.villageRegional);
        this.binding.postofficeEd.setText(this.postoffice);
        this.binding.postofficeEd2.setText(this.postofficeRegional);
        this.binding.pincodeEd.setText(this.pincode);
        this.binding.tehsilEd.setText(this.tehsil);
        this.binding.tehsilEd2.setText(this.tehsilRegional);
        this.binding.stateEd2.setText(this.state);
        this.binding.districtEd2.setText(this.district);
        this.binding.issueDateEd.setText(this.date);
        this.binding.placeEd.setText(this.place);
    }

    private void initializingClicks() {
        this.binding.backBtnIv.setOnClickListener(this);
        this.binding.homeBtnIv.setOnClickListener(this);
        this.binding.keepEditingTv.setOnClickListener(this);
        this.binding.submitTv.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == 2131362490) {
            finish();
        }
        if (v.getId() == 2131364196) {
            Intent intent = new Intent((Context) this, (Class<?>) MainActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
        }
        if (v.getId() == 2131364410) {
            finish();
        }
        if (v.getId() == 2131366158) {
            submitForm7(this.token);
        }
    }

    public String mandatoryremover(String simple) {
        return simple.endsWith("*") ? simple.substring(0, simple.length() - 1) : simple;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void submitForm7(String Token) {
        String str;
        String str2;
        String string;
        String str3;
        String str4;
        this.alertDialog.show();
        Logger.d(this.deletionObjection, "in submitForm7..............................");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        if (this.request.equals("same")) {
            string = this.binding.epicEd.getText().toString();
            str2 = "N";
            str3 = str2;
            str4 = "SELF";
            str = "Y";
        } else if (this.request.equals("other")) {
            string = this.binding.epicEd2.getText().toString();
            str2 = "Y";
            str3 = "N";
            str4 = "OTHER";
            str = str3;
        } else if (!this.request.equals(this.objectionString)) {
            str = "";
            str2 = str;
            string = str2;
            str3 = string;
            str4 = str3;
        } else {
            string = "NA";
            str3 = "Y";
            str2 = "N";
            str4 = "INCLUSION";
            str = str2;
        }
        HashMap map = new HashMap();
        map.put("applicantPlace", this.binding.placeEd.getText().toString());
        map.put("asemblyNo", this.acNo);
        map.put("createdBy", "operator");
        try {
            map.put("createdDttm", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.issueDateEd.getText().toString())));
        } catch (ParseException e) {
            Logger.e(this.deletionObjection, e.getMessage());
        }
        try {
            map.put("formSubmissionDate", simpleDateFormat2.format(simpleDateFormat.parse(this.binding.issueDateEd.getText().toString())));
        } catch (ParseException e2) {
            Logger.e(this.deletionObjection, e2.getMessage());
        }
        if (this.docref.isEmpty() || this.docref.equals("null")) {
            map.put("deathCertificateDln", null);
        } else {
            map.put("deathCertificateDln", this.docref);
        }
        map.put("deletionOfEpicNumberFor", str4);
        map.put("deletionOfOther", str2);
        map.put("deletionOfSelf", str);
        map.put("districtCode", this.districtCode);
        map.put("emailApplicant", null);
        map.put("epicNumberApplicant", this.binding.epicEd.getText().toString());
        if (string.equals(StringUtils.SPACE) || string.isEmpty()) {
            map.put("epicNumberOfPersonToBeDeleted", null);
        } else {
            map.put("epicNumberOfPersonToBeDeleted", string);
        }
        map.put("firstNameApplicant", this.firstNameApplicant);
        map.put("firstNameOfPersonToBeDeleted", this.binding.nameEd.getText().toString());
        map.put("formSubmissionChannel", "GARUDA");
        map.put("formSubmissionMode", "ONLINE");
        map.put("isSelfMobile", this.isSelfMobile);
        map.put("formSubmissionPlace", this.binding.placeEd.getText().toString());
        if (!this.binding.surnameEd2.getText().toString().equals(StringUtils.SPACE) && !this.binding.surnameEd2.getText().toString().isEmpty()) {
            map.put("lastNameOfPersonToBeDeleted", this.binding.surnameEd2.getText().toString());
        }
        if (!this.lastNameApplicant.equals(StringUtils.SPACE) && !this.lastNameApplicant.isEmpty()) {
            map.put("lastnameApplicant", this.lastNameApplicant);
        }
        if (this.binding.mobnumEd.getText().toString().equals(StringUtils.SPACE) || this.binding.mobnumEd.getText().toString().isEmpty()) {
            map.put("mobileNumberSelf", null);
            map.put("mobileNumberOfRelative", null);
            map.put("mobileNumberApplicant", null);
        } else {
            map.put("mobileNumberApplicant", this.binding.mobnumEd.getText().toString());
            if (this.isSelfMobile.equals("Y")) {
                map.put("mobileNumberSelf", this.binding.mobnumEd.getText().toString());
            } else {
                map.put("mobileNumberOfRelative", this.binding.mobnumEd.getText().toString());
            }
        }
        map.put("objectionOnInclusionOrDeletion", str3);
        map.put("partNumberApplicant", this.partNumberApplicant);
        map.put("partNumberOfPersonToBeDeleted", this.partNumberOfPersonToBeDeleted);
        map.put("serialNumberApplicant", this.serialNumberApplicant);
        map.put("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
        map.put("stateCode", this.stateCode);
        map.put("isDraft", "N");
        map.put("sectionNoApplicant", this.sectionNoApplicant);
        map.put("sectionNo", this.sectionNoApplicant);
        map.put("reasonForDeletion", this.reasonForDeletion);
        map.put("formSubmissionReferenceNumber", this.referenceNumber);
        map.put("townVillage", this.binding.villageEd.getText().toString());
        map.put("tehsilTalukaMandal", this.binding.tehsilEd.getText().toString());
        map.put("postOffice", this.binding.postofficeEd.getText().toString());
        map.put("localityStreet", this.binding.streetEd.getText().toString());
        map.put("houseNumber", this.binding.houseEd.getText().toString());
        map.put("pinCode", this.binding.pincodeEd.getText().toString());
        map.put("pinCodeV1", this.binding.pincodeEd.getText().toString());
        map.put("houseNumberV1", this.binding.houseEd2.getText().toString());
        map.put("localityStreetV1", this.binding.streetEd2.getText().toString());
        if (this.request.equals(this.objectionString)) {
            map.put("objectToInclFormRefNum", this.objectToInclFormRefNum);
            map.put("objectToInclFormType", this.objectToInclFormType);
        }
        if (this.districtCdOfPersonToBeDeleted.isEmpty()) {
            map.put(this.districtCdOfPersonToBeDeletedString, this.districtCode);
        } else {
            map.put(this.districtCdOfPersonToBeDeletedString, this.districtCdOfPersonToBeDeleted);
        }
        map.put("postOfficeV1", this.binding.postofficeEd2.getText().toString());
        map.put("tehsilTalukaMandalV1", this.binding.tehsilEd2.getText().toString());
        map.put("townVillageV1", this.binding.villageEd2.getText().toString());
        map.put("age", this.age);
        map.put("gender", this.gender);
        map.put("form7Id", 0);
        map.put("isReinitiate", "N");
        map.put("offlineSignedPage1Url", this.uploadForm6Page1Url);
        map.put("offlineSignedPage2Url", this.uploadForm6Page2Url);
        Logger.d(this.deletionObjection, "Form 7 json" + new Gson().toJson(map));
        this.commomUtility.getRetrofitClient(this, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd()).submitForm7(Token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", this.stateCode, map).enqueue(new AnonymousClass4(map));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        final /* synthetic */ HashMap val$map;

        AnonymousClass4(final HashMap val$map) {
            this.val$map = val$map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v12, types: [android.content.Context, in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity] */
        /* JADX WARN: Type inference failed for: r6v3, types: [android.content.Context, in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity] */
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
            Logger.d(PreviewForm7Activity.this.deletionObjection, String.valueOf(this.val$map));
            Logger.d("form 7 response string", response.toString());
            if (response.isSuccessful()) {
                PreviewForm7Activity.this.alertDialog.dismiss();
                Logger.d(PreviewForm7Activity.this.deletionObjection, "Form 7 submitted successfully");
                PreviewForm7Activity.this.showdialog1("Success", "Form 7 submitted successfully\nReference Number:  " + PreviewForm7Activity.this.referenceNumber);
                if (!TextUtils.isEmpty(PreviewForm7Activity.this.flag) && PreviewForm7Activity.this.flag.equalsIgnoreCase("dseVerified")) {
                    PreviewForm7Activity.this.callDseVerified();
                    return;
                } else {
                    if (TextUtils.isEmpty(PreviewForm7Activity.this.flag) || !PreviewForm7Activity.this.flag.equalsIgnoreCase("PseVerified")) {
                        return;
                    }
                    PreviewForm7Activity.this.callPseVerified();
                    return;
                }
            }
            try {
                if (response.code() == 401) {
                    CommomUtility commomUtility = PreviewForm7Activity.this.commomUtility;
                    ?? r1 = PreviewForm7Activity.this;
                    commomUtility.getRefreshToken(r1, ((PreviewForm7Activity) r1).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$4$$ExternalSyntheticLambda2
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i, str, str2);
                        }
                    });
                    return;
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                if (strOptString.equals("null")) {
                    strOptString = jSONObject.optString("cause");
                }
                Logger.d(PreviewForm7Activity.this.deletionObjection, strOptString);
                PreviewForm7Activity.this.alertDialog.dismiss();
                PreviewForm7Activity previewForm7Activity = PreviewForm7Activity.this;
                previewForm7Activity.showdialog(previewForm7Activity.alert, strOptString);
            } catch (Exception e) {
                PreviewForm7Activity.this.alertDialog.dismiss();
                Logger.e(PreviewForm7Activity.this.deletionObjection, e.getMessage());
                if (response.code() == 401) {
                    CommomUtility commomUtility2 = PreviewForm7Activity.this.commomUtility;
                    ?? r6 = PreviewForm7Activity.this;
                    commomUtility2.getRefreshToken(r6, ((PreviewForm7Activity) r6).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$4$$ExternalSyntheticLambda3
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$onResponse$3(i, str, str2);
                        }
                    });
                } else if (response != null && response.message() != null) {
                    PreviewForm7Activity previewForm7Activity2 = PreviewForm7Activity.this;
                    previewForm7Activity2.showdialog(previewForm7Activity2.alert, response.message());
                } else {
                    PreviewForm7Activity previewForm7Activity3 = PreviewForm7Activity.this;
                    previewForm7Activity3.showdialog(previewForm7Activity3.alert, "Please submit again");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
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
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PreviewForm7Activity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PreviewForm7Activity.this.commomUtility.showMessageOK(PreviewForm7Activity.this, DeletionObjectionForm.sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$4$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PreviewForm7Activity.this.token = "Bearer " + str;
            SharedPref.getInstance(PreviewForm7Activity.this).setRefreshToken(str2);
            SharedPref.getInstance(PreviewForm7Activity.this).setToken("Bearer " + str);
            PreviewForm7Activity previewForm7Activity = PreviewForm7Activity.this;
            previewForm7Activity.submitForm7(previewForm7Activity.token);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PreviewForm7Activity.this).setIsLoggedIn(false);
            SharedPref.getInstance(PreviewForm7Activity.this).setLocaleBool(false);
            PreviewForm7Activity.this.startActivity(new Intent((Context) PreviewForm7Activity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
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
        public /* synthetic */ void lambda$onResponse$3(int i, String str, String str2) {
            PreviewForm7Activity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PreviewForm7Activity.this.commomUtility.showMessageOK(PreviewForm7Activity.this, DeletionObjectionForm.sessionExpiredString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i2);
                    }
                });
                return;
            }
            PreviewForm7Activity.this.token = "Bearer " + str;
            SharedPref.getInstance(PreviewForm7Activity.this).setRefreshToken(str2);
            SharedPref.getInstance(PreviewForm7Activity.this).setToken("Bearer " + str);
            PreviewForm7Activity previewForm7Activity = PreviewForm7Activity.this;
            previewForm7Activity.submitForm7(previewForm7Activity.token);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PreviewForm7Activity.this).setIsLoggedIn(false);
            SharedPref.getInstance(PreviewForm7Activity.this).setLocaleBool(false);
            PreviewForm7Activity.this.startActivity(new Intent((Context) PreviewForm7Activity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(PreviewForm7Activity.this.deletionObjection, "coming in onFailure " + t.getMessage());
            PreviewForm7Activity.this.alertDialog.dismiss();
            PreviewForm7Activity previewForm7Activity = PreviewForm7Activity.this;
            previewForm7Activity.showdialog(previewForm7Activity.alert, "Please submit again");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callDseVerified() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.stateCode);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", SharedPref.getInstance(getApplicationContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(getApplicationContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        map2.put("epicId", Integer.valueOf(this.epicId));
        map2.put("epicNo", this.epicNumberId);
        map2.put("state", this.stateCode);
        map2.put("bloActionTaken", "form7");
        Call<AsdActionrRoot> callUpdateBloAction = this.userClient.updateBloAction(map, map2);
        this.alertDialog.show();
        callUpdateBloAction.enqueue(new Callback<AsdActionrRoot>() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity.5
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity] */
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
            public void onResponse(Call<AsdActionrRoot> call, Response<AsdActionrRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (PreviewForm7Activity.this.alertDialog != null) {
                        PreviewForm7Activity.this.alertDialog.dismiss();
                    }
                    try {
                        Utils utils = PreviewForm7Activity.this.utils;
                        ?? r0 = PreviewForm7Activity.this;
                        utils.infoDialogAction(r0, r0.getResources().getString(R.string.info), TextUtils.isEmpty(((AsdActionrRoot) response.body()).getMessage()) ? "" : ((AsdActionrRoot) response.body()).getMessage(), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity.5.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                            }
                        });
                        return;
                    } catch (Exception unused) {
                        if (PreviewForm7Activity.this.alertDialog != null) {
                            PreviewForm7Activity.this.alertDialog.dismiss();
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (PreviewForm7Activity.this.alertDialog != null) {
                        PreviewForm7Activity.this.alertDialog.dismiss();
                    }
                    PreviewForm7Activity.this.showdialog("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException unused2) {
                    if (PreviewForm7Activity.this.alertDialog != null) {
                        PreviewForm7Activity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<AsdActionrRoot> call, Throwable t) {
                if (PreviewForm7Activity.this.alertDialog != null) {
                    PreviewForm7Activity.this.alertDialog.dismiss();
                }
                Logger.e("efCount", t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callPseVerified() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.stateCode);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", SharedPref.getInstance(getApplicationContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(getApplicationContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        map2.put("pseId", Integer.valueOf(this.epicId));
        map2.put("state", this.stateCode);
        map2.put("bloActionTaken", "form7");
        Call<AsdActionrRoot> callUpdateBloPseAction = this.service.updateBloPseAction(this.stateCode.toLowerCase(), map, map2);
        this.alertDialog.show();
        callUpdateBloPseAction.enqueue(new Callback<AsdActionrRoot>() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity.6
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity] */
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
            public void onResponse(Call<AsdActionrRoot> call, Response<AsdActionrRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (PreviewForm7Activity.this.alertDialog != null) {
                        PreviewForm7Activity.this.alertDialog.dismiss();
                    }
                    try {
                        Utils utils = PreviewForm7Activity.this.utils;
                        ?? r0 = PreviewForm7Activity.this;
                        utils.infoDialogAction(r0, r0.getResources().getString(R.string.info), TextUtils.isEmpty(((AsdActionrRoot) response.body()).getMessage()) ? "" : ((AsdActionrRoot) response.body()).getMessage(), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity.6.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                            }
                        });
                        return;
                    } catch (Exception unused) {
                        if (PreviewForm7Activity.this.alertDialog != null) {
                            PreviewForm7Activity.this.alertDialog.dismiss();
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (PreviewForm7Activity.this.alertDialog != null) {
                        PreviewForm7Activity.this.alertDialog.dismiss();
                    }
                    PreviewForm7Activity.this.showdialog("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException unused2) {
                    if (PreviewForm7Activity.this.alertDialog != null) {
                        PreviewForm7Activity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<AsdActionrRoot> call, Throwable t) {
                if (PreviewForm7Activity.this.alertDialog != null) {
                    PreviewForm7Activity.this.alertDialog.dismiss();
                }
                Logger.e("efCount", t.getMessage());
            }
        });
    }

    public void updateData() {
        this.viewModel.updateData(this.rejectionOption, this.rejectionOptionSubcategory, this.applicantEpic, this.binding.issueDateEd.getText().toString(), this.binding.placeEd.getText().toString(), null, this.referenceNumber, this.createdOn, "Opened", "Form 7");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showdialog1(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog1$0(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showdialog1$0(DialogInterface dialogInterface, int i) {
        updateData();
        Intent intent = new Intent((Context) this, (Class<?>) MainActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    public void onDestroy() {
        super.onDestroy();
    }
}
