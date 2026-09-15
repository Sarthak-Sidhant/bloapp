package in.gov.eci.bloapp.views.activity.sir;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.ActivityViewFormByAerodocumentsBinding;
import in.gov.eci.bloapp.pdfDownloadCallback;
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
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ViewFormByAERODocuments extends SuperBaseActivity {
    AlertDialog alertDialog;
    String asmblyNO;
    String atkband;
    ActivityViewFormByAerodocumentsBinding binding;
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
    String preSignedUrl1 = "";
    String preSignedUrl2 = "";
    String preSignedUrl3 = "";
    String preSignedUrl4 = "";
    String preSignedUrl5 = "";
    String preSignedUrl6 = "";
    String preSignedUrl7 = "";
    String preSignedUrl8 = "";
    String preSignedUrl9 = "";
    String preSignedUrl10 = "";
    String preSignedUrl11 = "";
    String preSignedUrl12 = "";
    String preSignedUrl13 = "";
    String preSignedUrl14 = "";
    String preSignedUrl15 = "";
    String preSignedUrl16 = "";
    String preSignedUrl17 = "";
    String preSignedUrl18 = "";
    String preSignedUrl19 = "";
    String preSignedUrl20 = "";
    String preSignedUrl21 = "";
    String preSignedUrl22 = "";
    String preSignedUrl23 = "";
    File file1 = null;
    File file2 = null;
    File file3 = null;
    File file4 = null;
    File file5 = null;
    File file6 = null;
    File file7 = null;
    File file8 = null;
    File file9 = null;
    File file10 = null;
    File file11 = null;
    File file12 = null;
    File file13 = null;
    File file14 = null;
    File file15 = null;
    File file16 = null;
    File file17 = null;
    File file19 = null;
    File file20 = null;
    File file21 = null;
    File file22 = null;
    File file18 = null;
    File file23 = null;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_documents);
        ActivityViewFormByAerodocumentsBinding activityViewFormByAerodocumentsBindingInflate = ActivityViewFormByAerodocumentsBinding.inflate(getLayoutInflater());
        this.binding = activityViewFormByAerodocumentsBindingInflate;
        setContentView(activityViewFormByAerodocumentsBindingInflate.getRoot());
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
            this.binding.relationSupportingDocUrl.setVisibility(0);
        } else {
            this.binding.relationSupportingDocUrl.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relationSupportingPage2Ref)) {
            getFileforSIR23(this.relationSupportingPage2Ref);
            this.binding.relationSupportingDocUrlPg2.setVisibility(0);
        } else {
            this.binding.relationSupportingDocUrlPg2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relationProofPage1Ref)) {
            getFileforSIR20(this.relationProofPage1Ref);
            this.binding.relationProofDocUrl.setVisibility(0);
        } else {
            this.binding.relationProofDocUrl.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relationProofPage2Ref)) {
            getFileforSIR21(this.relationProofPage2Ref);
            this.binding.relationProofDocUrlPg2.setVisibility(0);
        } else {
            this.binding.relationProofDocUrlPg2.setVisibility(8);
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
        this.binding.preRevisionVoterDocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.preRevisionVoterDocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.list6DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.list6docUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.list7DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.list7DocUr2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.list1DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.list1DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.list3DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.list3DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        this.binding.list4DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        this.binding.list4DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.list5DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$12(view);
            }
        });
        this.binding.list5DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.list5DocUrl3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$14(view);
            }
        });
        this.binding.srFormPage1Url.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$15(view);
            }
        });
        this.binding.srFormPage2Url.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$16(view);
            }
        });
        this.binding.photoUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$17(view);
            }
        });
        this.binding.annexureUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$18(view);
            }
        });
        this.binding.relationProofDocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$19(view);
            }
        });
        this.binding.relationProofDocUrlPg2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$20(view);
            }
        });
        this.binding.relationSupportingDocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$21(view);
            }
        });
        this.binding.relationSupportingDocUrlPg2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$22(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        if (!TextUtils.isEmpty(this.IRRef) && this.IRRef.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file1, this.IRRef);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl1)) {
            showImageDialog(this.preSignedUrl1, this.IRRef);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        if (!TextUtils.isEmpty(this.IRRef2) && this.IRRef2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file2, this.IRRef2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl2)) {
            showImageDialog(this.preSignedUrl2, this.IRRef2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        if (!TextUtils.isEmpty(this.list6ref) && this.list6ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file3, this.list6ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl3)) {
            showImageDialog(this.preSignedUrl3, this.list6ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (!TextUtils.isEmpty(this.list6ref2) && this.list6ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file4, this.list6ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl4)) {
            showImageDialog(this.preSignedUrl4, this.list6ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        if (!TextUtils.isEmpty(this.list7ref) && this.list7ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file5, this.list7ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl5)) {
            showImageDialog(this.preSignedUrl5, this.list7ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        if (!TextUtils.isEmpty(this.list7ref2) && this.list7ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file6, this.list7ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl6)) {
            showImageDialog(this.preSignedUrl6, this.list7ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        if (!TextUtils.isEmpty(this.list1ref) && this.list1ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file7, this.list1ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl7)) {
            showImageDialog(this.preSignedUrl7, this.list1ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        if (!TextUtils.isEmpty(this.list1ref2) && this.list1ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file8, this.list1ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl8)) {
            showImageDialog(this.preSignedUrl8, this.list1ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        if (!TextUtils.isEmpty(this.list3Ref) && this.list3Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file9, this.list3Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl9)) {
            showImageDialog(this.preSignedUrl9, this.list3Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        if (!TextUtils.isEmpty(this.list3Ref2) && this.list3Ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file10, this.list3Ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl10)) {
            showImageDialog(this.preSignedUrl10, this.list3Ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$10(View view) {
        if (!TextUtils.isEmpty(this.list4Ref) && this.list4Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file11, this.list4Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl11)) {
            showImageDialog(this.preSignedUrl11, this.list4Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$11(View view) {
        if (!TextUtils.isEmpty(this.list4Ref2) && this.list4Ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file12, this.list4Ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl12)) {
            showImageDialog(this.preSignedUrl12, this.list4Ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$12(View view) {
        if (!TextUtils.isEmpty(this.list5Ref) && this.list5Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file13, this.list5Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl13)) {
            showImageDialog(this.preSignedUrl13, this.list5Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$13(View view) {
        if (!TextUtils.isEmpty(this.list5Ref2) && this.list5Ref2.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file14, this.list5Ref2);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl14)) {
            showImageDialog(this.preSignedUrl14, this.list5Ref2);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$14(View view) {
        if (!TextUtils.isEmpty(this.list5ref3) && this.list5ref3.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file15, this.list5ref3);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl15)) {
            showImageDialog(this.preSignedUrl15, this.list5ref3);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15(View view) {
        if (!TextUtils.isEmpty(this.srFormPage1Ref) && this.srFormPage1Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file16, this.srFormPage1Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl16)) {
            showImageDialog(this.preSignedUrl16, this.srFormPage1Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$16(View view) {
        if (!TextUtils.isEmpty(this.srFormPage2Ref) && this.srFormPage2Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file17, this.srFormPage2Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl17)) {
            showImageDialog(this.preSignedUrl17, this.srFormPage2Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$17(View view) {
        if (!TextUtils.isEmpty(this.photoRef) && this.photoRef.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file18, this.photoRef);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl18)) {
            showImageDialog(this.preSignedUrl18, this.photoRef);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$18(View view) {
        if (!TextUtils.isEmpty(this.annexureRef) && this.annexureRef.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file19, this.annexureRef);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl19)) {
            showImageDialog(this.preSignedUrl19, this.annexureRef);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$19(View view) {
        if (!TextUtils.isEmpty(this.relationProofPage1Ref) && this.relationProofPage1Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file20, this.relationProofPage1Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl20)) {
            showImageDialog(this.preSignedUrl20, this.relationProofPage1Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$20(View view) {
        if (!TextUtils.isEmpty(this.relationProofPage2Ref) && this.relationProofPage2Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file21, this.relationProofPage2Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl21)) {
            showImageDialog(this.preSignedUrl21, this.relationProofPage2Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$21(View view) {
        if (!TextUtils.isEmpty(this.relationSupportingPage1Ref) && this.relationSupportingPage1Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file22, this.relationSupportingPage1Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl22)) {
            showImageDialog(this.preSignedUrl22, this.relationSupportingPage1Ref);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$22(View view) {
        if (!TextUtils.isEmpty(this.relationSupportingPage2Ref) && this.relationSupportingPage2Ref.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file23, this.relationSupportingPage2Ref);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedUrl23)) {
            showImageDialog(this.preSignedUrl23, this.relationSupportingPage2Ref);
        } else {
            showImageDialog("", "");
        }
    }

    public void getFileforSIR1(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass1(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass1(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl1).into(ViewFormByAERODocuments.this.binding.preRevisionVoterDocUrl);
                    ViewFormByAERODocuments.this.binding.preRevisionVoterDocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.preRevisionVoterDocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl1, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.1.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file1 = file;
                            Log.e("GETFILE", "FILE1::" + ViewFormByAERODocuments.this.file1);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$1$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR2(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass2(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass2(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl2).into(ViewFormByAERODocuments.this.binding.preRevisionVoterDocUrl2);
                    ViewFormByAERODocuments.this.binding.preRevisionVoterDocUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.preRevisionVoterDocUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl2, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.2.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file2 = file;
                            Log.e("GETFILE", "FILE2::" + ViewFormByAERODocuments.this.file2);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$2$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR3(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass3(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass3(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl3).into(ViewFormByAERODocuments.this.binding.list6DocUrl);
                    ViewFormByAERODocuments.this.binding.list6DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list6DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl3, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.3.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file3 = file;
                            Log.e("GETFILE", "FILE3::" + ViewFormByAERODocuments.this.file3);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl3)) {
                    ViewFormByAERODocuments.this.binding.list6DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$3$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$3$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR4(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass4(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass4(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl4 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl4).into(ViewFormByAERODocuments.this.binding.list6docUrl2);
                    ViewFormByAERODocuments.this.binding.list6docUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list6docUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl4, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.4.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file4 = file;
                            Log.e("GETFILE", "FILE4::" + ViewFormByAERODocuments.this.file4);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl4)) {
                    ViewFormByAERODocuments.this.binding.list6docUrl2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$4$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR5(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass5(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass5(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl5 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl5).into(ViewFormByAERODocuments.this.binding.list7DocUrl);
                    ViewFormByAERODocuments.this.binding.list7DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list7DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl5, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.5.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file5 = file;
                            Log.e("GETFILE", "FILE5::" + ViewFormByAERODocuments.this.file5);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl5)) {
                    ViewFormByAERODocuments.this.binding.list7DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$5$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$5$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR5(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR6(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass6(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass6(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl6 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl6).into(ViewFormByAERODocuments.this.binding.list7DocUr2);
                    ViewFormByAERODocuments.this.binding.list7DocUr2.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list7DocUr2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl6, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.6.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file6 = file;
                            Log.e("GETFILE", "FILE6::" + ViewFormByAERODocuments.this.file6);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl6)) {
                    ViewFormByAERODocuments.this.binding.list7DocUr2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$6$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR6(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR7(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass7(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass7(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl7 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl7).into(ViewFormByAERODocuments.this.binding.list1DocUrl);
                    ViewFormByAERODocuments.this.binding.list1DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list1DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl7, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.7.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file7 = file;
                            Log.e("GETFILE", "FILE7::" + ViewFormByAERODocuments.this.file7);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl7)) {
                    ViewFormByAERODocuments.this.binding.list1DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$7$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR7(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR8(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass8(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass8(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl8 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl8).into(ViewFormByAERODocuments.this.binding.list1DocUrl2);
                    ViewFormByAERODocuments.this.binding.list1DocUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list1DocUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl8, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.8.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file8 = file;
                            Log.e("GETFILE", "FILE8::" + ViewFormByAERODocuments.this.file8);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl8)) {
                    ViewFormByAERODocuments.this.binding.list1DocUrl2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$8$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$8$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR8(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR9(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass9(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$9, reason: invalid class name */
    class AnonymousClass9 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass9(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl9 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl9).into(ViewFormByAERODocuments.this.binding.list3DocUrl);
                    ViewFormByAERODocuments.this.binding.list3DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list3DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl9, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.9.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file9 = file;
                            Log.e("GETFILE", "FILE9::" + ViewFormByAERODocuments.this.file9);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl9)) {
                    ViewFormByAERODocuments.this.binding.list3DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$9$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$9$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR9(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR10(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass10(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$10, reason: invalid class name */
    class AnonymousClass10 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass10(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl10 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl10).into(ViewFormByAERODocuments.this.binding.list3DocUrl2);
                    ViewFormByAERODocuments.this.binding.list3DocUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list3DocUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl10, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.10.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file10 = file;
                            Log.e("GETFILE", "FILE10::" + ViewFormByAERODocuments.this.file10);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl10)) {
                    ViewFormByAERODocuments.this.binding.list3DocUrl2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$10$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$10$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR10(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR11(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass11(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$11, reason: invalid class name */
    class AnonymousClass11 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass11(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl11 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl11).into(ViewFormByAERODocuments.this.binding.list4DocUrl);
                    ViewFormByAERODocuments.this.binding.list4DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list4DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl11, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.11.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file11 = file;
                            Log.e("GETFILE", "FILE11::" + ViewFormByAERODocuments.this.file11);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl11)) {
                    ViewFormByAERODocuments.this.binding.list4DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$11$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$11$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR11(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR12(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass12(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$12, reason: invalid class name */
    class AnonymousClass12 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass12(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl12 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl12).into(ViewFormByAERODocuments.this.binding.list4DocUrl2);
                    ViewFormByAERODocuments.this.binding.list4DocUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list4DocUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl12, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.12.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file12 = file;
                            Log.e("GETFILE", "FILE12::" + ViewFormByAERODocuments.this.file12);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl12)) {
                    ViewFormByAERODocuments.this.binding.list4DocUrl2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$12$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$12$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR12(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR13(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass13(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$13, reason: invalid class name */
    class AnonymousClass13 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass13(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl13 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl13).into(ViewFormByAERODocuments.this.binding.list5DocUrl);
                    ViewFormByAERODocuments.this.binding.list5DocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list5DocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl13, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.13.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file13 = file;
                            Log.e("GETFILE", "FILE13::" + ViewFormByAERODocuments.this.file13);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl13)) {
                    ViewFormByAERODocuments.this.binding.list5DocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$13$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$13$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR13(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR14(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass14(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$14, reason: invalid class name */
    class AnonymousClass14 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass14(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl14 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl14).into(ViewFormByAERODocuments.this.binding.list5DocUrl2);
                    ViewFormByAERODocuments.this.binding.list5DocUrl2.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list5DocUrl2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl14, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.14.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file14 = file;
                            Log.e("GETFILE", "FILE14::" + ViewFormByAERODocuments.this.file14);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl14)) {
                    ViewFormByAERODocuments.this.binding.list5DocUrl2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$14$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$14$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR14(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR15(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass15(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$15, reason: invalid class name */
    class AnonymousClass15 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass15(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl15 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl15).into(ViewFormByAERODocuments.this.binding.list5DocUrl3);
                    ViewFormByAERODocuments.this.binding.list5DocUrl3.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.list5DocUrl3.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl15, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.15.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file15 = file;
                            Log.e("GETFILE", "FILE15::" + ViewFormByAERODocuments.this.file15);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl15)) {
                    ViewFormByAERODocuments.this.binding.list5DocUrl3.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$15$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$15$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR15(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR16(String fileref) {
        Log.d("photoRef= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass16(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$16, reason: invalid class name */
    class AnonymousClass16 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass16(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl16 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl16).into(ViewFormByAERODocuments.this.binding.srFormPage1Url);
                    ViewFormByAERODocuments.this.binding.srFormPage1Url.setVisibility(0);
                } else {
                    Log.d("photoRef= ", "2222222222");
                    ViewFormByAERODocuments.this.binding.srFormPage1Url.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl16, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.16.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file16 = file;
                            Log.e("GETFILE", "FILE16::" + ViewFormByAERODocuments.this.file16);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl16)) {
                    ViewFormByAERODocuments.this.binding.srFormPage1Url.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$16$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$16$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR16(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR17(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass17(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$17, reason: invalid class name */
    class AnonymousClass17 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass17(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl17 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl17).into(ViewFormByAERODocuments.this.binding.srFormPage2Url);
                    ViewFormByAERODocuments.this.binding.srFormPage2Url.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.srFormPage2Url.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl17, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.17.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file17 = file;
                            Log.e("GETFILE", "FILE17::" + ViewFormByAERODocuments.this.file17);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl17)) {
                    ViewFormByAERODocuments.this.binding.srFormPage2Url.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$17$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$17$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR17(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR18(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass18(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$18, reason: invalid class name */
    class AnonymousClass18 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass18(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl18 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl18).into(ViewFormByAERODocuments.this.binding.photoUrl);
                    ViewFormByAERODocuments.this.binding.photoUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.photoUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl18, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.18.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file18 = file;
                            Log.e("GETFILE", "FILE18::" + ViewFormByAERODocuments.this.file18);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl18)) {
                    ViewFormByAERODocuments.this.binding.photoUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r5 = ViewFormByAERODocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$18$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$18$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR18(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR19(String fileref) {
        Log.d("File Ref 19= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass19(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$19, reason: invalid class name */
    class AnonymousClass19 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass19(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl19 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl19).into(ViewFormByAERODocuments.this.binding.annexureUrl);
                    ViewFormByAERODocuments.this.binding.annexureUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.annexureUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl19, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.19.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file19 = file;
                            Log.e("GETFILE", "FILE19::" + ViewFormByAERODocuments.this.file19);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl19)) {
                    ViewFormByAERODocuments.this.binding.annexureUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 404) {
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocuments.this.binding.annexureUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r6 = ViewFormByAERODocuments.this;
                    String str = r6.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$19$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$19$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR19(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR20(String fileref) {
        Log.d("File Ref 20= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass20(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$20, reason: invalid class name */
    class AnonymousClass20 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass20(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl20 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl20).into(ViewFormByAERODocuments.this.binding.relationProofDocUrl);
                    ViewFormByAERODocuments.this.binding.relationProofDocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.relationProofDocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl20, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.20.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file20 = file;
                            Log.e("GETFILE", "FILE20::" + ViewFormByAERODocuments.this.file20);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl20)) {
                    ViewFormByAERODocuments.this.binding.relationProofDocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 404) {
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocuments.this.binding.relationProofDocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r6 = ViewFormByAERODocuments.this;
                    String str = r6.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$20$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$20$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR20(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR21(String fileref) {
        Log.d("File Ref 21= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass21(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$21, reason: invalid class name */
    class AnonymousClass21 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass21(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl21 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl21).into(ViewFormByAERODocuments.this.binding.relationProofDocUrlPg2);
                    ViewFormByAERODocuments.this.binding.relationProofDocUrlPg2.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.relationProofDocUrlPg2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl21, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.21.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file21 = file;
                            Log.e("GETFILE", "FILE21::" + ViewFormByAERODocuments.this.file21);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl21)) {
                    ViewFormByAERODocuments.this.binding.relationProofDocUrlPg2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 404) {
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocuments.this.binding.relationProofDocUrlPg2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r6 = ViewFormByAERODocuments.this;
                    String str = r6.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$21$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$21$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR21(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR22(String fileref) {
        Log.d("File Ref 22= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass22(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$22, reason: invalid class name */
    class AnonymousClass22 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass22(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl22 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl22).into(ViewFormByAERODocuments.this.binding.relationSupportingDocUrl);
                    ViewFormByAERODocuments.this.binding.relationSupportingDocUrl.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.relationSupportingDocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl22, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.22.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file22 = file;
                            Log.e("GETFILE", "FILE22::" + ViewFormByAERODocuments.this.file22);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl22)) {
                    ViewFormByAERODocuments.this.binding.relationSupportingDocUrl.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 404) {
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocuments.this.binding.relationSupportingDocUrl.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r6 = ViewFormByAERODocuments.this;
                    String str = r6.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$22$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$22$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR22(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR23(String fileref) {
        Log.d("File Ref 22= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass23(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$23, reason: invalid class name */
    class AnonymousClass23 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass23(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
                if (ViewFormByAERODocuments.this.alertDialog != null) {
                    ViewFormByAERODocuments.this.alertDialog.dismiss();
                }
                ViewFormByAERODocuments.this.preSignedUrl23 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAERODocuments.this).load(ViewFormByAERODocuments.this.preSignedUrl23).into(ViewFormByAERODocuments.this.binding.relationSupportingDocUrlPg2);
                    ViewFormByAERODocuments.this.binding.relationSupportingDocUrlPg2.setVisibility(0);
                } else {
                    ViewFormByAERODocuments.this.binding.relationSupportingDocUrlPg2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
                    viewFormByAERODocuments.downloadPdfToCache(viewFormByAERODocuments.preSignedUrl23, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments.23.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAERODocuments.this.file23 = file;
                            Log.e("GETFILE", "FILE1::" + ViewFormByAERODocuments.this.file23);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAERODocuments.this.preSignedUrl23)) {
                    ViewFormByAERODocuments.this.binding.relationSupportingDocUrlPg2.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAERODocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 404) {
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewFormByAERODocuments.this.binding.relationSupportingDocUrlPg2.setImageDrawable(ContextCompat.getDrawable(ViewFormByAERODocuments.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                    ?? r6 = ViewFormByAERODocuments.this;
                    String str = r6.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$23$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAERODocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAERODocuments.this.alertDialog != null) {
                        ViewFormByAERODocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAERODocuments.this.TAG, e.getMessage());
                }
            }
            ViewFormByAERODocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments] */
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
            ViewFormByAERODocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAERODocuments.this.commomUtility;
                ?? r5 = ViewFormByAERODocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$23$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAERODocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAERODocuments.this.getFileforSIR23(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAERODocuments.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAERODocuments.this.startActivity(new Intent((Context) ViewFormByAERODocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAERODocuments.this.TAG, ViewFormByAERODocuments.this.comingTag + t.getMessage());
            if (ViewFormByAERODocuments.this.alertDialog != null) {
                ViewFormByAERODocuments.this.alertDialog.dismiss();
            }
            ViewFormByAERODocuments viewFormByAERODocuments = ViewFormByAERODocuments.this;
            viewFormByAERODocuments.showDialog1(viewFormByAERODocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda22
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

    private void showPersonPdfDialog(File preSignedUrl, String pdfNameFromObjectStorage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        pDFViewFindViewById.fromFile(preSignedUrl).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(0).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda20
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
    private void showImageDialog(String preSignedUrlP, String name) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        AppCompatImageView appCompatImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        Glide.with(this).load(preSignedUrlP).placeholder(R.drawable.blo_dummy_image).error(R.drawable.blo_dummy_image).into(appCompatImageView);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda19
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

    public void downloadPdfToCache(final String preSignedUrl, final pdfDownloadCallback callback) {
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAERODocuments$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache$28(preSignedUrl, callback);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache$28(String str, pdfDownloadCallback pdfdownloadcallback) {
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
}
