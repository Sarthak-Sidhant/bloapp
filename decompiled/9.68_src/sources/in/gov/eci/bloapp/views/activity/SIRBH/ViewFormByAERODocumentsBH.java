package in.gov.eci.bloapp.views.activity.SIRBH;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.ActivityViewFormByAerodocumentsBhBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataNew;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ViewFormByAERODocumentsBH extends SuperBaseActivity {
    AlertDialog alertDialog;
    String asmblyNO;
    String atkband;
    ActivityViewFormByAerodocumentsBhBinding binding;
    Bundle bundle;
    protected long filesize;
    String partNo;
    String refreshToken;
    String rtkband;
    protected String saveImageFileName;
    String state;
    String token;
    String list3Ref = null;
    String list4Ref = null;
    String list5Ref = null;
    String list6ref = null;
    String list7ref = null;
    String IRRef = null;
    String IRRef2 = null;
    String list1ref = null;
    String list1ref2 = null;
    String list3Ref2 = null;
    String list4Ref2 = null;
    String list5Ref2 = null;
    String list6ref2 = null;
    String list7ref2 = null;
    String list5ref3 = null;
    String list2Ref2 = null;
    String photoRef = null;
    String srFormPage1Ref = null;
    String srFormPage2Ref = null;
    String annexureRef = null;
    String relationProofPage1Ref = null;
    String relationProofPage2Ref = null;
    String relationSupportingPage1Ref = null;
    String relationSupportingPage2Ref = null;
    CommomUtility commomUtility = new CommomUtility();
    String notRecommendedClicked = "";
    String comingTag = "coming in onFailure";
    String messageString = "message";
    String TAG = "ViewFormByAERODocumentsTAG";
    String SESSION = "";
    String objectStorageString = "objectstorage";
    String imageTextBaseActivity = "image";
    String garudaTextBaseActivity = "GARUDA";
    String functionNameForLogBaseActivity = "";
    String pdfTextBaseActivity = ".pdf";
    String fileNameTextBaseActivity = "fileName";
    String jpgTextBaseActivity = ".jpg";
    String citizenCat = "";
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
    String base64element18 = "";
    String base64element19 = "";
    String base64element20 = "";
    String base64element21 = "";
    String base64element22 = "";
    String base64element23 = "";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_documents);
        ActivityViewFormByAerodocumentsBhBinding activityViewFormByAerodocumentsBhBindingInflate = ActivityViewFormByAerodocumentsBhBinding.inflate(getLayoutInflater());
        this.binding = activityViewFormByAerodocumentsBhBindingInflate;
        setContentView(activityViewFormByAerodocumentsBhBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
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
        initClickListener();
        Bundle extras = getIntent().getExtras();
        this.bundle = extras;
        this.citizenCat = extras.getString("citizenshipCat");
        this.list6ref = this.bundle.getString("list6DocUrl");
        this.list6ref2 = this.bundle.getString("list6DocUrlPg2");
        this.list7ref = this.bundle.getString("list7DocUrl");
        this.list7ref2 = this.bundle.getString("list7DocUrlPg2");
        this.IRRef = this.bundle.getString("preRevisionVoterDocUrl");
        this.IRRef2 = this.bundle.getString("peRevisionVoterDocUrlPg2");
        this.list1ref = this.bundle.getString("list1DocUrl");
        this.list1ref2 = this.bundle.getString("list1DocUrlPg2");
        this.list3Ref = this.bundle.getString("list3DocUrl");
        this.list3Ref2 = this.bundle.getString("list3DocUrlPg2");
        this.list4Ref = this.bundle.getString("list4DocUrl");
        this.list4Ref2 = this.bundle.getString("list4DocUrlPg2");
        this.list5Ref = this.bundle.getString("list5DocUrl");
        this.list5Ref2 = this.bundle.getString("list5DocUrlPg2");
        this.list5ref3 = this.bundle.getString("list5DocUrlPg3");
        this.srFormPage1Ref = this.bundle.getString("srFormPage1Url");
        this.srFormPage2Ref = this.bundle.getString("srFormPage2Url");
        this.photoRef = this.bundle.getString("photoUrl");
        this.annexureRef = this.bundle.getString("annexureCUrl");
        this.relationSupportingPage1Ref = this.bundle.getString("relationList8DocsPage1");
        this.relationSupportingPage2Ref = this.bundle.getString("relationList8DocsPage2");
        this.relationProofPage1Ref = this.bundle.getString("relationProofDocUrlPg1");
        this.relationProofPage2Ref = this.bundle.getString("relationProofDocUrlPg2");
        if (TextUtils.isEmpty(this.list6ref) && TextUtils.isEmpty(this.list6ref2) && TextUtils.isEmpty(this.list7ref) && TextUtils.isEmpty(this.list7ref2) && TextUtils.isEmpty(this.IRRef) && TextUtils.isEmpty(this.IRRef2) && TextUtils.isEmpty(this.list1ref) && TextUtils.isEmpty(this.list1ref2) && TextUtils.isEmpty(this.list3Ref) && TextUtils.isEmpty(this.list3Ref2) && TextUtils.isEmpty(this.list4Ref) && TextUtils.isEmpty(this.list4Ref2) && TextUtils.isEmpty(this.list5Ref) && TextUtils.isEmpty(this.list5Ref2) && TextUtils.isEmpty(this.list5ref3) && TextUtils.isEmpty(this.srFormPage1Ref) && TextUtils.isEmpty(this.srFormPage2Ref) && TextUtils.isEmpty(this.photoRef) && TextUtils.isEmpty(this.annexureRef) && TextUtils.isEmpty(this.relationSupportingPage1Ref) && TextUtils.isEmpty(this.relationSupportingPage2Ref) && TextUtils.isEmpty(this.relationProofPage1Ref) && TextUtils.isEmpty(this.relationProofPage2Ref)) {
            this.binding.noDocumentsAvailable.setVisibility(0);
        }
        if (this.citizenCat.equalsIgnoreCase("CAT-1")) {
            this.binding.selfLL.setVisibility(8);
            this.binding.fatherLL.setVisibility(8);
            this.binding.motherLL.setVisibility(8);
            this.binding.list5LL.setVisibility(8);
            this.binding.notBornLL.setVisibility(8);
            this.binding.indianCitizenLL.setVisibility(8);
            if (!TextUtils.isEmpty(this.IRRef)) {
                getFileforSIR1(this.IRRef);
                this.binding.preRevisionLL.setVisibility(0);
                this.binding.preRevisionVoterDocUrl.setVisibility(0);
            } else {
                this.binding.preRevisionVoterDocUrl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.IRRef2)) {
                getFileforSIR2(this.IRRef2);
                this.binding.preRevisionLL.setVisibility(0);
                this.binding.preRevisionVoterDocUrl2.setVisibility(0);
            } else {
                this.binding.preRevisionVoterDocUrl2.setVisibility(8);
            }
        } else if (this.citizenCat.equalsIgnoreCase("CAT-5")) {
            this.binding.preRevisionLL.setVisibility(8);
            this.binding.selfLL.setVisibility(8);
            this.binding.fatherLL.setVisibility(8);
            this.binding.motherLL.setVisibility(8);
            this.binding.list5LL.setVisibility(8);
            this.binding.indianCitizenLL.setVisibility(8);
            if (!TextUtils.isEmpty(this.list6ref)) {
                getFileforSIR3(this.list6ref);
                this.binding.notBornLL.setVisibility(0);
                this.binding.list6DocUrl.setVisibility(0);
            } else {
                this.binding.list6DocUrl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list6ref2)) {
                getFileforSIR4(this.list6ref2);
                this.binding.notBornLL.setVisibility(0);
                this.binding.list6docUrl2.setVisibility(0);
            } else {
                this.binding.list6docUrl2.setVisibility(8);
            }
        } else if (this.citizenCat.equalsIgnoreCase("CAT-6")) {
            this.binding.preRevisionLL.setVisibility(8);
            this.binding.selfLL.setVisibility(8);
            this.binding.fatherLL.setVisibility(8);
            this.binding.motherLL.setVisibility(8);
            this.binding.list5LL.setVisibility(8);
            this.binding.notBornLL.setVisibility(8);
            if (!TextUtils.isEmpty(this.list7ref)) {
                getFileforSIR5(this.list7ref);
                this.binding.indianCitizenLL.setVisibility(0);
                this.binding.list7DocUrl.setVisibility(0);
            } else {
                this.binding.list7DocUrl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list7ref2)) {
                getFileforSIR6(this.list7ref2);
                this.binding.indianCitizenLL.setVisibility(0);
                this.binding.list7DocUr2.setVisibility(0);
            } else {
                this.binding.list7DocUr2.setVisibility(8);
            }
        } else if (this.citizenCat.equalsIgnoreCase("CAT-2")) {
            this.binding.preRevisionLL.setVisibility(8);
            this.binding.fatherLL.setVisibility(8);
            this.binding.motherLL.setVisibility(8);
            this.binding.list5LL.setVisibility(8);
            this.binding.notBornLL.setVisibility(8);
            this.binding.indianCitizenLL.setVisibility(8);
            if (!TextUtils.isEmpty(this.list1ref)) {
                getFileforSIR7(this.list1ref);
                this.binding.selfLL.setVisibility(0);
                this.binding.list1DocUrl.setVisibility(0);
            } else {
                this.binding.list1DocUrl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list1ref2)) {
                getFileforSIR8(this.list1ref2);
                this.binding.selfLL.setVisibility(0);
                this.binding.list1DocUrl2.setVisibility(0);
            } else {
                this.binding.list1DocUrl2.setVisibility(8);
            }
        } else if (this.citizenCat.equalsIgnoreCase("CAT-3")) {
            this.binding.preRevisionLL.setVisibility(8);
            this.binding.list5LL.setVisibility(8);
            this.binding.notBornLL.setVisibility(8);
            this.binding.indianCitizenLL.setVisibility(8);
            if (!TextUtils.isEmpty(this.list1ref)) {
                getFileforSIR7(this.list1ref);
                this.binding.selfLL.setVisibility(0);
                this.binding.list1DocUrl.setVisibility(0);
            } else {
                this.binding.list1DocUrl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list1ref2)) {
                getFileforSIR8(this.list1ref2);
                this.binding.selfLL.setVisibility(0);
                this.binding.list1DocUrl2.setVisibility(0);
            } else {
                this.binding.list1DocUrl2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list3Ref)) {
                getFileforSIR9(this.list3Ref);
                this.binding.fatherLL.setVisibility(0);
                this.binding.list3DocUrl.setVisibility(0);
            } else {
                this.binding.list3DocUrl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list3Ref2)) {
                getFileforSIR10(this.list3Ref2);
                this.binding.fatherLL.setVisibility(0);
                this.binding.list3DocUrl2.setVisibility(0);
            } else {
                this.binding.list3DocUrl2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list4Ref)) {
                getFileforSIR11(this.list4Ref);
                this.binding.motherLL.setVisibility(0);
                this.binding.list4DocUrl.setVisibility(0);
            } else {
                this.binding.list4DocUrl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list4Ref2)) {
                getFileforSIR12(this.list4Ref2);
                this.binding.motherLL.setVisibility(0);
                this.binding.list4DocUrl2.setVisibility(0);
            } else {
                this.binding.list4DocUrl2.setVisibility(8);
            }
        } else if (this.citizenCat.equalsIgnoreCase("CAT-4")) {
            this.binding.preRevisionLL.setVisibility(8);
            this.binding.notBornLL.setVisibility(8);
            this.binding.indianCitizenLL.setVisibility(8);
            if (!TextUtils.isEmpty(this.list1ref)) {
                getFileforSIR7(this.list1ref);
                this.binding.selfLL.setVisibility(0);
                this.binding.list1DocUrl.setVisibility(0);
            } else {
                this.binding.list1DocUrl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list1ref2)) {
                getFileforSIR8(this.list1ref2);
                this.binding.selfLL.setVisibility(0);
                this.binding.list1DocUrl2.setVisibility(0);
            } else {
                this.binding.list1DocUrl2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list3Ref)) {
                getFileforSIR9(this.list3Ref);
                this.binding.fatherLL.setVisibility(0);
                this.binding.list3DocUrl.setVisibility(0);
            } else {
                this.binding.list3DocUrl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list3Ref2)) {
                getFileforSIR10(this.list3Ref2);
                this.binding.fatherLL.setVisibility(0);
                this.binding.list3DocUrl2.setVisibility(0);
            } else {
                this.binding.list3DocUrl2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list4Ref)) {
                getFileforSIR11(this.list4Ref);
                this.binding.motherLL.setVisibility(0);
                this.binding.list4DocUrl.setVisibility(0);
            } else {
                this.binding.list4DocUrl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list4Ref2)) {
                getFileforSIR12(this.list4Ref2);
                this.binding.motherLL.setVisibility(0);
                this.binding.list4DocUrl2.setVisibility(0);
            } else {
                this.binding.list4DocUrl2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list5Ref)) {
                getFileforSIR13(this.list5Ref);
                this.binding.list5LL.setVisibility(0);
                this.binding.list5DocUrl.setVisibility(0);
            } else {
                this.binding.list5DocUrl.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list5Ref2)) {
                getFileforSIR14(this.list5Ref2);
                this.binding.list5LL.setVisibility(0);
                this.binding.list5DocUrl2.setVisibility(0);
            } else {
                this.binding.list5DocUrl2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.list5ref3)) {
                getFileforSIR15(this.list5ref3);
                this.binding.list5LL.setVisibility(0);
                this.binding.list5DocUrl3.setVisibility(0);
            } else {
                this.binding.list5DocUrl3.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(this.photoRef)) {
            getFileforSIR18(this.photoRef);
            Log.d("photoRef= ", "photoRef");
            this.binding.photoUrl.setVisibility(0);
        } else {
            this.binding.photoUrl.setVisibility(8);
            this.binding.electorPhoto.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.srFormPage1Ref)) {
            getFileforSIR16(this.srFormPage1Ref);
            this.binding.srFormPage1Url.setVisibility(0);
        } else {
            this.binding.srFormPage1Url.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.srFormPage2Ref)) {
            getFileforSIR17(this.srFormPage2Ref);
            this.binding.srFormPage2Url.setVisibility(0);
        } else {
            this.binding.srFormPage2Url.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.annexureRef)) {
            getFileforSIR19(this.annexureRef);
            this.binding.annexureUrl.setVisibility(0);
        } else {
            this.binding.annexureUrl.setVisibility(8);
            this.binding.annexure.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relationSupportingPage1Ref)) {
            getFileforSIR22(this.relationSupportingPage1Ref);
            this.binding.relationProofDocUrl.setVisibility(0);
        } else {
            this.binding.relationProofDocUrl.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relationSupportingPage2Ref)) {
            getFileforSIR23(this.relationSupportingPage2Ref);
            this.binding.relationProofDocUrlPg2.setVisibility(0);
        } else {
            this.binding.relationProofDocUrlPg2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relationProofPage1Ref)) {
            getFileforSIR20(this.relationProofPage1Ref);
            this.binding.relationSupportingDocUrl.setVisibility(0);
        } else {
            this.binding.relationSupportingDocUrl.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relationProofPage2Ref)) {
            getFileforSIR21(this.relationProofPage2Ref);
            this.binding.relationSupportingDocUrlPg2.setVisibility(0);
        } else {
            this.binding.relationSupportingDocUrlPg2.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.srFormPage1Ref) && TextUtils.isEmpty(this.srFormPage2Ref)) {
            this.binding.enumeration.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.list1ref) && TextUtils.isEmpty(this.list1ref2)) {
            this.binding.self.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.list3Ref) && TextUtils.isEmpty(this.list3Ref2)) {
            this.binding.father.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.list4Ref) && TextUtils.isEmpty(this.list4Ref2)) {
            this.binding.mother.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.IRRef) && TextUtils.isEmpty(this.IRRef2)) {
            this.binding.preRevision.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.list5Ref) && TextUtils.isEmpty(this.list5Ref2) && TextUtils.isEmpty(this.list5ref3)) {
            this.binding.list5.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.list6ref) && TextUtils.isEmpty(this.list6ref2)) {
            this.binding.notBorn.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.list7ref) && TextUtils.isEmpty(this.list7ref2)) {
            this.binding.indianCitizen.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relationProofPage1Ref) && TextUtils.isEmpty(this.relationProofPage2Ref)) {
            this.binding.relationProofText.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relationSupportingPage1Ref) && TextUtils.isEmpty(this.relationSupportingPage2Ref)) {
            this.binding.relationSuppText.setVisibility(8);
        }
        this.binding.preRevisionVoterDocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.preRevisionVoterDocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.list6DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.list6docUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.list7DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.list7DocUr2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.list1DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.list1DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.list3DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.list3DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        this.binding.list4DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        this.binding.list4DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.list5DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$12(view);
            }
        });
        this.binding.list5DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.list5DocUrl3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$14(view);
            }
        });
        this.binding.srFormPage1Url.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$15(view);
            }
        });
        this.binding.srFormPage2Url.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$16(view);
            }
        });
        this.binding.photoUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$17(view);
            }
        });
        this.binding.annexureUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$18(view);
            }
        });
        this.binding.relationProofDocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$19(view);
            }
        });
        this.binding.relationProofDocUrlPg2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$20(view);
            }
        });
        this.binding.relationSupportingDocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$21(view);
            }
        });
        this.binding.relationSupportingDocUrlPg2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$22(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        String str;
        if (!TextUtils.isEmpty(this.IRRef) && this.IRRef.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element1, this.IRRef);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element1;
        if (str2 != null && !str2.isEmpty() && !this.base64element1.equals("null") && (str = this.base64element1) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.IRRef);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        String str;
        if (!TextUtils.isEmpty(this.IRRef2) && this.IRRef2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element2, this.IRRef2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element2;
        if (str2 != null && !str2.isEmpty() && !this.base64element2.equals("null") && (str = this.base64element2) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.IRRef2);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list6ref) && this.list6ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element3, this.list6ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element3;
        if (str2 != null && !str2.isEmpty() && !this.base64element3.equals("null") && (str = this.base64element3) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list6ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list6ref2) && this.list6ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element4, this.list6ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element4;
        if (str2 != null && !str2.isEmpty() && !this.base64element4.equals("null") && (str = this.base64element4) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list6ref2);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list7ref) && this.list7ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element5, this.list7ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element5;
        if (str2 != null && !str2.isEmpty() && !this.base64element5.equals("null") && (str = this.base64element5) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list7ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list7ref2) && this.list7ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element6, this.list7ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element6;
        if (str2 != null && !str2.isEmpty() && !this.base64element6.equals("null") && (str = this.base64element6) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list7ref2);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list1ref) && this.list1ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element7, this.list1ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element7;
        if (str2 != null && !str2.isEmpty() && !this.base64element7.equals("null") && (str = this.base64element7) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list1ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list1ref2) && this.list1ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element8, this.list1ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element8;
        if (str2 != null && !str2.isEmpty() && !this.base64element8.equals("null") && (str = this.base64element8) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list1ref2);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list3Ref) && this.list3Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element9, this.list3Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element9;
        if (str2 != null && !str2.isEmpty() && !this.base64element9.equals("null") && (str = this.base64element9) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list3Ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list3Ref2) && this.list3Ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element10, this.list3Ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element10;
        if (str2 != null && !str2.isEmpty() && !this.base64element10.equals("null") && (str = this.base64element10) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list3Ref2);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$10(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list4Ref) && this.list4Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element11, this.list4Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element11;
        if (str2 != null && !str2.isEmpty() && !this.base64element11.equals("null") && (str = this.base64element11) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list4Ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$11(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list4Ref2) && this.list4Ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element12, this.list4Ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element12;
        if (str2 != null && !str2.isEmpty() && !this.base64element12.equals("null") && (str = this.base64element12) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list4Ref2);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$12(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list5Ref) && this.list5Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element13, this.list5Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element13;
        if (str2 != null && !str2.isEmpty() && !this.base64element13.equals("null") && (str = this.base64element13) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list5Ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$13(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list5Ref2) && this.list5Ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element14, this.list5Ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element14;
        if (str2 != null && !str2.isEmpty() && !this.base64element14.equals("null") && (str = this.base64element14) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list5Ref2);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$14(View view) {
        String str;
        if (!TextUtils.isEmpty(this.list5ref3) && this.list5ref3.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element15, this.list5ref3);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element15;
        if (str2 != null && !str2.isEmpty() && !this.base64element15.equals("null") && (str = this.base64element15) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.list5ref3);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15(View view) {
        String str;
        if (!TextUtils.isEmpty(this.srFormPage1Ref) && this.srFormPage1Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element16, this.srFormPage1Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element16;
        if (str2 != null && !str2.isEmpty() && !this.base64element16.equals("null") && (str = this.base64element16) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.srFormPage1Ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$16(View view) {
        String str;
        if (!TextUtils.isEmpty(this.srFormPage2Ref) && this.srFormPage2Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element17, this.srFormPage2Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element17;
        if (str2 != null && !str2.isEmpty() && !this.base64element17.equals("null") && (str = this.base64element17) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.srFormPage2Ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$17(View view) {
        String str;
        if (!TextUtils.isEmpty(this.photoRef) && this.photoRef.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element18, this.photoRef);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element18;
        if (str2 != null && !str2.isEmpty() && !this.base64element18.equals("null") && (str = this.base64element18) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.photoRef);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$18(View view) {
        String str;
        if (!TextUtils.isEmpty(this.annexureRef) && this.annexureRef.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element19, this.annexureRef);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element19;
        if (str2 != null && !str2.isEmpty() && !this.base64element19.equals("null") && (str = this.base64element19) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.annexureRef);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$19(View view) {
        String str;
        if (!TextUtils.isEmpty(this.relationProofPage1Ref) && this.relationProofPage1Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element20, this.relationProofPage1Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element20;
        if (str2 != null && !str2.isEmpty() && !this.base64element20.equals("null") && (str = this.base64element20) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.relationProofPage1Ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$20(View view) {
        String str;
        if (!TextUtils.isEmpty(this.relationProofPage2Ref) && this.relationProofPage2Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element21, this.relationProofPage2Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element21;
        if (str2 != null && !str2.isEmpty() && !this.base64element21.equals("null") && (str = this.base64element21) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.relationProofPage2Ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$21(View view) {
        String str;
        if (!TextUtils.isEmpty(this.relationSupportingPage1Ref) && this.relationSupportingPage1Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element22, this.relationSupportingPage1Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element22;
        if (str2 != null && !str2.isEmpty() && !this.base64element22.equals("null") && (str = this.base64element22) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.relationSupportingPage1Ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$22(View view) {
        String str;
        if (!TextUtils.isEmpty(this.relationSupportingPage2Ref) && this.relationSupportingPage2Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.base64element23, this.relationSupportingPage2Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        String str2 = this.base64element23;
        if (str2 != null && !str2.isEmpty() && !this.base64element23.equals("null") && (str = this.base64element23) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.relationSupportingPage2Ref);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    public void getFileforSIR1(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass1(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass1(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element1, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.preRevisionVoterDocUrl.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.preRevisionVoterDocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.preRevisionVoterDocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$1$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR2(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass2(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass2(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element2 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element2, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.preRevisionVoterDocUrl2.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.preRevisionVoterDocUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.preRevisionVoterDocUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$2$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR3(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass3(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass3(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element3 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element3, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list6DocUrl.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list6DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list6DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element3.isEmpty() || ViewFormByAERODocumentsBH.this.base64element3.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list6DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$3$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$3$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR4(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass4(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass4(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element4 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element4, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list6docUrl2.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list6docUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list6docUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element4.isEmpty() || ViewFormByAERODocumentsBH.this.base64element4.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list6docUrl2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$4$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR5(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass5(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass5(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element5 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element5, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list7DocUrl.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list7DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list7DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element5.isEmpty() || ViewFormByAERODocumentsBH.this.base64element5.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list7DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$5$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$5$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR5(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR6(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass6(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass6(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element6 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element6, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list7DocUr2.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list7DocUr2.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list7DocUr2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element6.isEmpty() || ViewFormByAERODocumentsBH.this.base64element6.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list7DocUr2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$6$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR6(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR7(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass7(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass7(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element7 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element7, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list1DocUrl.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list1DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list1DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element7.isEmpty() || ViewFormByAERODocumentsBH.this.base64element7.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list1DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$7$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR7(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR8(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass8(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass8(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element8 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element8, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list1DocUrl2.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list1DocUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list1DocUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element8.isEmpty() || ViewFormByAERODocumentsBH.this.base64element8.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list1DocUrl2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$8$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$8$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR8(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR9(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass9(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$9, reason: invalid class name */
    class AnonymousClass9 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass9(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element9 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element9, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list3DocUrl.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list3DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list3DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element9.isEmpty() || ViewFormByAERODocumentsBH.this.base64element9.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list3DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$9$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$9$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR9(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR10(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass10(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$10, reason: invalid class name */
    class AnonymousClass10 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass10(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element10 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element10, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list3DocUrl2.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list3DocUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list3DocUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element10.isEmpty() || ViewFormByAERODocumentsBH.this.base64element10.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list3DocUrl2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$10$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$10$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR10(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR11(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass11(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$11, reason: invalid class name */
    class AnonymousClass11 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass11(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element11 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element11, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list4DocUrl.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list4DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list4DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element11.isEmpty() || ViewFormByAERODocumentsBH.this.base64element11.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list4DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$11$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$11$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR11(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR12(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass12(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$12, reason: invalid class name */
    class AnonymousClass12 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass12(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element12 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element12, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list4DocUrl2.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list4DocUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list4DocUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element12.isEmpty() || ViewFormByAERODocumentsBH.this.base64element12.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list4DocUrl2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$12$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$12$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR12(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR13(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass13(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$13, reason: invalid class name */
    class AnonymousClass13 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass13(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element13 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element13, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element13.isEmpty() || ViewFormByAERODocumentsBH.this.base64element13.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$13$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$13$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR13(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR14(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass14(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$14, reason: invalid class name */
    class AnonymousClass14 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass14(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element14 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element14, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl2.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element14.isEmpty() || ViewFormByAERODocumentsBH.this.base64element14.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$14$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$14$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR14(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR15(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass15(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$15, reason: invalid class name */
    class AnonymousClass15 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass15(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element15 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element15, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl3.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl3.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl3.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element15.isEmpty() || ViewFormByAERODocumentsBH.this.base64element15.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.list5DocUrl3.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$15$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$15$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR15(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR16(String fileref) {
        Log.d("photoRef= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass16(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$16, reason: invalid class name */
    class AnonymousClass16 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass16(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element16 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element16, 0);
                Log.d("base64element16= ", ViewFormByAERODocumentsBH.this.base64element16);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    Log.d("photoRef= ", "1111111111");
                    ViewFormByAERODocumentsBH.this.binding.srFormPage1Url.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.srFormPage1Url.setVisibility(0);
                } else {
                    Log.d("photoRef= ", "2222222222");
                    ViewFormByAERODocumentsBH.this.binding.srFormPage1Url.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element16.isEmpty() || ViewFormByAERODocumentsBH.this.base64element16.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.srFormPage1Url.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$16$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$16$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR16(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR17(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass17(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$17, reason: invalid class name */
    class AnonymousClass17 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass17(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element17 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element17, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.srFormPage2Url.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.srFormPage2Url.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.srFormPage2Url.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element17.isEmpty() || ViewFormByAERODocumentsBH.this.base64element17.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.srFormPage2Url.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$17$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$17$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR17(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR18(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass18(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$18, reason: invalid class name */
    class AnonymousClass18 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass18(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element18 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element18, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.photoUrl.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.photoUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.photoUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element18.isEmpty() || ViewFormByAERODocumentsBH.this.base64element18.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.photoUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r5 = ViewFormByAERODocumentsBH.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$18$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$18$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR18(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR19(String fileref) {
        Log.d("File Ref 19= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass19(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$19, reason: invalid class name */
    class AnonymousClass19 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass19(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element19 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element19, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.annexureUrl.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.annexureUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.annexureUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element19.isEmpty() || ViewFormByAERODocumentsBH.this.base64element19.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.annexureUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 404) {
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.annexureUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r6 = ViewFormByAERODocumentsBH.this;
                    String str = r6.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$19$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$19$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR19(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR20(String fileref) {
        Log.d("File Ref 20= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass20(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$20, reason: invalid class name */
    class AnonymousClass20 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass20(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element20 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element20, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.relationProofDocUrl.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.relationProofDocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.relationProofDocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element20.isEmpty() || ViewFormByAERODocumentsBH.this.base64element20.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.relationProofDocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 404) {
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.relationProofDocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r6 = ViewFormByAERODocumentsBH.this;
                    String str = r6.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$20$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$20$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR20(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR21(String fileref) {
        Log.d("File Ref 21= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass21(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$21, reason: invalid class name */
    class AnonymousClass21 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass21(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element21 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element21, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.relationProofDocUrlPg2.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.relationProofDocUrlPg2.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.relationProofDocUrlPg2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element21.isEmpty() || ViewFormByAERODocumentsBH.this.base64element21.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.relationProofDocUrlPg2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 404) {
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.relationProofDocUrlPg2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r6 = ViewFormByAERODocumentsBH.this;
                    String str = r6.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$21$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$21$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR21(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR22(String fileref) {
        Log.d("File Ref 22= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass22(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$22, reason: invalid class name */
    class AnonymousClass22 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass22(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element22 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element22, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.relationSupportingDocUrl.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.relationSupportingDocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.relationSupportingDocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element22.isEmpty() || ViewFormByAERODocumentsBH.this.base64element22.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.relationSupportingDocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 404) {
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.relationSupportingDocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r6 = ViewFormByAERODocumentsBH.this;
                    String str = r6.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$22$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$22$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR22(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    public void getFileforSIR23(String fileref) {
        Log.d("File Ref 22= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass23(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$23, reason: invalid class name */
    class AnonymousClass23 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass23(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
                if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                    ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                }
                ViewFormByAERODocumentsBH.this.base64element23 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ViewFormByAERODocumentsBH.this.base64element23, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (!this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.relationSupportingDocUrlPg2.setImageBitmap(bitmapDecodeByteArray);
                    ViewFormByAERODocumentsBH.this.binding.relationSupportingDocUrlPg2.setVisibility(0);
                } else {
                    ViewFormByAERODocumentsBH.this.binding.relationSupportingDocUrlPg2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
                if (ViewFormByAERODocumentsBH.this.base64element23.isEmpty() || ViewFormByAERODocumentsBH.this.base64element23.equals("null")) {
                    ViewFormByAERODocumentsBH.this.binding.relationSupportingDocUrlPg2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocumentsBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 404) {
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocumentsBH.this.binding.relationSupportingDocUrlPg2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocumentsBH.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                    ?? r6 = ViewFormByAERODocumentsBH.this;
                    String str = r6.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$23$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocumentsBH.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                        ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocumentsBH.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH] */
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
            ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocumentsBH.this.commomUtility;
                ?? r5 = ViewFormByAERODocumentsBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$23$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocumentsBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocumentsBH.this.getFileforSIR23(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocumentsBH.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocumentsBH.this.startActivity(new Intent((Context) ViewFormByAERODocumentsBH.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocumentsBH.this.TAG, ViewFormByAERODocumentsBH.this.comingTag + t.getMessage());
            if (ViewFormByAERODocumentsBH.this.alertDialog != null) {
                ViewFormByAERODocumentsBH.this.alertDialog.dismiss();
            }
            ViewFormByAERODocumentsBH viewFormByAERODocumentsBH = ViewFormByAERODocumentsBH.this;
            viewFormByAERODocumentsBH.showDialog1(viewFormByAERODocumentsBH.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda19
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$23(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$23(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    private void showPersonPdfDialog(String base64elementValue, String pdfNameFromObjectStorage) throws IOException {
        Log.d("Param1= ", base64elementValue);
        Log.d("Param2= ", pdfNameFromObjectStorage);
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        Uri saveImagePath = getSaveImagePath(base64elementValue, ".pdf");
        File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + this.saveImageFileName);
        Log.d("Param3= ", saveImagePath.getPath());
        new File((String) Objects.requireNonNull(saveImagePath.getPath()));
        Log.d("File Exis= ", "" + file.exists());
        pDFViewFindViewById.fromFile(file).load();
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$25(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog2$25(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) FormDataNew.class);
        intent.setFlags(603979776);
        intent.putExtra("restart", true);
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected) throws IOException {
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

    /* JADX WARN: Multi-variable type inference failed */
    private void showImageDialog(Bitmap img, String name) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        touchImageView.setImageBitmap(img);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAERODocumentsBH$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$27(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$27(View view) {
        onBackPressed();
    }
}
