package in.gov.eci.bloapp.views.activity.sir.formdatanew;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityFormDocumentsBinding;
import in.gov.eci.bloapp.pdfDownloadCallback;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FormDocuments extends SuperBaseActivity {
    AlertDialog alertDialog;
    String asmblyNO;
    String atkband;
    ActivityFormDocumentsBinding binding;
    Bundle bundle;
    Long epicId;
    String erollAge;
    protected long filesize;
    String partNo;
    File pdffile;
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
    CommomUtility commomUtility = new CommomUtility();
    String notRecommendedClicked = "";
    String comingTag = "coming in onFailure";
    String messageString = "message";
    String TAG = "SpecialRevisionDocumentsTAG";
    String SESSION = "";
    String objectStorageString = "objectstorage";
    String imageTextBaseActivity = "image";
    String garudaTextBaseActivity = "GARUDA";
    String functionNameForLogBaseActivity = "";
    String pdfTextBaseActivity = ".pdf";
    String fileNameTextBaseActivity = "fileName";
    String jpgTextBaseActivity = ".jpg";
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
    String preSignedurl18 = "";
    String preSignedurl19 = "";
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
    File file18 = null;
    File file19 = null;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_documents);
        ActivityFormDocumentsBinding activityFormDocumentsBindingInflate = ActivityFormDocumentsBinding.inflate(getLayoutInflater());
        this.binding = activityFormDocumentsBindingInflate;
        setContentView(activityFormDocumentsBindingInflate.getRoot());
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
        this.list6ref = extras.getString("list6DocUrl");
        this.epicId = Long.valueOf(this.bundle.getLong("epicId"));
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
        this.erollAge = this.bundle.getString("erollAge");
        if (TextUtils.isEmpty(this.list6ref) && TextUtils.isEmpty(this.list6ref2) && TextUtils.isEmpty(this.list7ref) && TextUtils.isEmpty(this.list7ref2) && TextUtils.isEmpty(this.IRRef) && TextUtils.isEmpty(this.IRRef2) && TextUtils.isEmpty(this.list1ref) && TextUtils.isEmpty(this.list1ref2) && TextUtils.isEmpty(this.list3Ref) && TextUtils.isEmpty(this.list3Ref2) && TextUtils.isEmpty(this.list4Ref) && TextUtils.isEmpty(this.list4Ref2) && TextUtils.isEmpty(this.list5Ref) && TextUtils.isEmpty(this.list5Ref2) && TextUtils.isEmpty(this.list5ref3) && TextUtils.isEmpty(this.srFormPage1Ref) && TextUtils.isEmpty(this.srFormPage2Ref) && TextUtils.isEmpty(this.photoRef) && TextUtils.isEmpty(this.annexureRef)) {
            this.binding.noDocumentsAvailable.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.IRRef)) {
            getFileforSIR1(this.IRRef);
            this.binding.preRevisionVoterDocUrl.setVisibility(0);
        } else {
            this.binding.preRevisionVoterDocUrl.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.IRRef2)) {
            getFileforSIR2(this.IRRef2);
            this.binding.preRevisionVoterDocUrl2.setVisibility(0);
        } else {
            this.binding.preRevisionVoterDocUrl2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list6ref)) {
            getFileforSIR3(this.list6ref);
            this.binding.list6DocUrl.setVisibility(0);
        } else {
            this.binding.list6DocUrl.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list6ref2)) {
            getFileforSIR4(this.list6ref2);
            this.binding.list6docUrl2.setVisibility(0);
        } else {
            this.binding.list6docUrl2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list7ref)) {
            getFileforSIR5(this.list7ref);
            this.binding.list7DocUrl.setVisibility(0);
        } else {
            this.binding.list7DocUrl.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list7ref2)) {
            getFileforSIR6(this.list7ref2);
            this.binding.list7DocUr2.setVisibility(0);
        } else {
            this.binding.list7DocUr2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list1ref)) {
            getFileforSIR7(this.list1ref);
            this.binding.list1DocUrl.setVisibility(0);
        } else {
            this.binding.list1DocUrl.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list1ref2)) {
            getFileforSIR8(this.list1ref2);
            this.binding.list1DocUrl2.setVisibility(0);
        } else {
            this.binding.list1DocUrl2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list3Ref)) {
            getFileforSIR9(this.list3Ref);
            this.binding.list3DocUrl.setVisibility(0);
        } else {
            this.binding.list3DocUrl.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list3Ref2)) {
            getFileforSIR10(this.list3Ref2);
            this.binding.list3DocUrl2.setVisibility(0);
        } else {
            this.binding.list3DocUrl2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list4Ref)) {
            getFileforSIR11(this.list4Ref);
            this.binding.list4DocUrl.setVisibility(0);
        } else {
            this.binding.list4DocUrl.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list4Ref2)) {
            getFileforSIR12(this.list4Ref2);
            this.binding.list4DocUrl2.setVisibility(0);
        } else {
            this.binding.list4DocUrl2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list5Ref)) {
            getFileforSIR13(this.list5Ref);
            this.binding.list5DocUrl.setVisibility(0);
        } else {
            this.binding.list5DocUrl.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list5Ref2)) {
            getFileforSIR14(this.list5Ref2);
            this.binding.list5DocUrl2.setVisibility(0);
        } else {
            this.binding.list5DocUrl2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.list5ref3)) {
            getFileforSIR15(this.list5ref3);
            this.binding.list5DocUrl3.setVisibility(0);
        } else {
            this.binding.list5DocUrl3.setVisibility(8);
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
        this.binding.preRevisionVoterDocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.preRevisionVoterDocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.list6DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.list6docUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.list7DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.list7DocUr2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.list1DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.list1DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.list3DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.list3DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        this.binding.list4DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        this.binding.list4DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.list5DocUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$12(view);
            }
        });
        this.binding.list5DocUrl2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.list5DocUrl3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$14(view);
            }
        });
        this.binding.srFormPage1Url.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$15(view);
            }
        });
        this.binding.srFormPage2Url.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$16(view);
            }
        });
        this.binding.photoUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$17(view);
            }
        });
        this.binding.annexureUrl.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$18(view);
            }
        });
        this.binding.submitButtonRec.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$19(view);
            }
        });
        this.binding.notRecommended.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$20(view);
            }
        });
        this.binding.updateData.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$21(view);
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
        if (!TextUtils.isEmpty(this.preSignedurl1)) {
            showImageDialog(this.preSignedurl1, this.IRRef);
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
        if (!TextUtils.isEmpty(this.preSignedurl2)) {
            showImageDialog(this.preSignedurl2, this.IRRef2);
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
        if (!TextUtils.isEmpty(this.preSignedurl3)) {
            showImageDialog(this.preSignedurl3, this.list6ref);
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
        if (!TextUtils.isEmpty(this.preSignedurl4)) {
            showImageDialog(this.preSignedurl4, this.list6ref2);
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
        if (!TextUtils.isEmpty(this.preSignedurl5)) {
            showImageDialog(this.preSignedurl5, this.list7ref);
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
        if (!TextUtils.isEmpty(this.preSignedurl6)) {
            showImageDialog(this.preSignedurl6, this.list7ref2);
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
        if (!TextUtils.isEmpty(this.preSignedurl7)) {
            showImageDialog(this.preSignedurl7, this.list1ref);
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
        if (!TextUtils.isEmpty(this.preSignedurl8)) {
            showImageDialog(this.preSignedurl8, this.list1ref2);
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
        if (!TextUtils.isEmpty(this.preSignedurl9)) {
            showImageDialog(this.preSignedurl9, this.list3Ref);
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
        if (!TextUtils.isEmpty(this.preSignedurl10)) {
            showImageDialog(this.preSignedurl10, this.list3Ref2);
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
        if (!TextUtils.isEmpty(this.preSignedurl11)) {
            showImageDialog(this.preSignedurl11, this.list4Ref);
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
        if (!TextUtils.isEmpty(this.preSignedurl12)) {
            showImageDialog(this.preSignedurl12, this.list4Ref2);
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
        if (!TextUtils.isEmpty(this.preSignedurl13)) {
            showImageDialog(this.preSignedurl13, this.list5Ref);
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
        if (!TextUtils.isEmpty(this.preSignedurl14)) {
            showImageDialog(this.preSignedurl13, this.list5Ref2);
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
        if (!TextUtils.isEmpty(this.preSignedurl15)) {
            showImageDialog(this.preSignedurl15, this.list5ref3);
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
        if (!TextUtils.isEmpty(this.preSignedurl16)) {
            showImageDialog(this.preSignedurl16, this.srFormPage1Ref);
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
        if (!TextUtils.isEmpty(this.preSignedurl17)) {
            showImageDialog(this.preSignedurl17, this.srFormPage2Ref);
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
        if (!TextUtils.isEmpty(this.preSignedurl18)) {
            showImageDialog(this.preSignedurl18, this.photoRef);
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
        if (!TextUtils.isEmpty(this.preSignedurl19)) {
            showImageDialog(this.preSignedurl19, this.annexureRef);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$19(View view) {
        this.notRecommendedClicked = "Y";
        submit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$20(View view) {
        this.notRecommendedClicked = "N";
        submit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$21(View view) {
        Intent intent = new Intent((Context) this, (Class<?>) FormDataPage1.class);
        intent.putExtra("dob", this.bundle.getString("dob"));
        intent.putExtra("epic", this.bundle.getString("epic"));
        intent.putExtra("epicId", this.bundle.getLong("epicId"));
        intent.putExtra("serialNo", this.bundle.getString("serialNo"));
        intent.putExtra("houseNo", this.bundle.getString("houseNo"));
        intent.putExtra("aadharNo", this.bundle.getString("aadharNo"));
        intent.putExtra("mobileNo", this.bundle.getString("mobileNo"));
        intent.putExtra("fatherName", this.bundle.getString("fatherName"));
        intent.putExtra("fatherEpic", this.bundle.getString("fatherEpic"));
        intent.putExtra("motherName", this.bundle.getString("motherName"));
        intent.putExtra("motherEpic", this.bundle.getString("motherEpic"));
        intent.putExtra("spouseName", this.bundle.getString("spouseName"));
        intent.putExtra("spouseEpic", this.bundle.getString("spouseEpic"));
        intent.putExtra("photoUrl", this.bundle.getString("photoUrl"));
        intent.putExtra("srFormPage1Url", this.bundle.getString("srFormPage1Url"));
        intent.putExtra("srFormPage2Url", this.bundle.getString("srFormPage2Url"));
        intent.putExtra("citizenshipType", this.bundle.getString("citizenshipType"));
        intent.putExtra("relationProofDocUrlPg1", this.bundle.getString("relationProofDocUrlPg1"));
        intent.putExtra("relationProofDocUrlPg2", this.bundle.getString("relationProofDocUrlPg2"));
        intent.putExtra("relationType", this.bundle.getString("relationType"));
        intent.putExtra("oldAcNo", this.bundle.getString("oldAcNo"));
        intent.putExtra("oldPartNo", this.bundle.getString("oldPartNo"));
        intent.putExtra("oldPslNo", this.bundle.getString("oldPslNo"));
        intent.putExtra("list8Doc", this.bundle.getString("list8Doc"));
        intent.putExtra("preRevisionVoterFlg", this.bundle.getString("preRevisionVoterFlg"));
        intent.putExtra("preRevisionVoterDocUrl", this.bundle.getString("preRevisionVoterDocUrl"));
        intent.putExtra("peRevisionVoterDocUrlPg2", this.bundle.getString("peRevisionVoterDocUrlPg2"));
        intent.putExtra("list6Doc", this.bundle.getString("list6Doc"));
        intent.putExtra("list6DocUrl", this.bundle.getString("list6DocUrl"));
        intent.putExtra("list6DocUrlPg2", this.bundle.getString("list6DocUrlPg2"));
        intent.putExtra("list7Doc", this.bundle.getString("list7Doc"));
        intent.putExtra("list7DocUrl", this.bundle.getString("list7DocUrl"));
        intent.putExtra("list7DocUrlPg2", this.bundle.getString("list7DocUrlPg2"));
        intent.putExtra("list1Doc", this.bundle.getString("list1Doc"));
        intent.putExtra("list1DocUrl", this.bundle.getString("list1DocUrl"));
        intent.putExtra("list1DocUrlPg2", this.bundle.getString("list1DocUrlPg2"));
        intent.putExtra("list3Doc", this.bundle.getString("list3Doc"));
        intent.putExtra("list3DocUrl", this.bundle.getString("list3DocUrl"));
        intent.putExtra("list3DocUrlPg2", this.bundle.getString("list3DocUrlPg2"));
        intent.putExtra("list4Doc", this.bundle.getString("list4Doc"));
        intent.putExtra("list4DocUrl", this.bundle.getString("list4DocUrl"));
        intent.putExtra("list4DocUrlPg2", this.bundle.getString("list4DocUrlPg2"));
        intent.putExtra("list5Doc", this.bundle.getString("list5Doc"));
        intent.putExtra("list5DocUrl", this.bundle.getString("list5DocUrl"));
        intent.putExtra("list5DocUrlPg2", this.bundle.getString("list5DocUrlPg2"));
        intent.putExtra("list5DocUrlPg3", this.bundle.getString("list5DocUrlPg3"));
        intent.putExtra("fathersNationality", this.bundle.getString("fathersNationality"));
        intent.putExtra("mothersNationality", this.bundle.getString("mothersNationality"));
        intent.putExtra("createdBy", this.bundle.getString("createdBy"));
        intent.putExtra("citizenshipTypeCat", this.bundle.getString("citizenshipTypeCat"));
        intent.putExtra("documentUploadedFlg", this.bundle.getString("documentUploadedFlg"));
        intent.putExtra("annexureCUrl", this.bundle.getString("annexureCUrl"));
        intent.putExtra("surveyChannel", this.bundle.getString("surveyChannel"));
        intent.putExtra("electorName", this.bundle.getString("electorName"));
        intent.putExtra("relationOldAcNo", this.bundle.getString("relationOldAcNo"));
        intent.putExtra("relationOldPartNo", this.bundle.getString("relationOldPartNo"));
        intent.putExtra("relationOldPartSerialNo", this.bundle.getString("relationOldPartSerialNo"));
        intent.putExtra("relationList8DocsPage1", this.bundle.getString("relationList8DocsPage1"));
        intent.putExtra("relationList8DocsPage2", this.bundle.getString("relationList8DocsPage2"));
        intent.putExtra("relationListList8DocCode", this.bundle.getString("relationListList8DocCode"));
        intent.putExtra("relation2003YesOrNo", this.bundle.getString("relation2003YesOrNo"));
        intent.putExtra("relationProofDocUrlPg1", this.bundle.getString("relationProofDocUrlPg1"));
        intent.putExtra("relationProofDocUrlPg2", this.bundle.getString("relationProofDocUrlPg2"));
        intent.putExtra("relationType", this.bundle.getString("relationType"));
        intent.putExtra("relativeEpic", this.bundle.getString("relativeEpic"));
        intent.putExtra("oldStateCd", this.bundle.getString("oldStateCd"));
        intent.putExtra("relationOldStateCd", this.bundle.getString("relationOldStateCd"));
        intent.putExtra("erollAge", this.bundle.getString("erollAge"));
        startActivity(intent);
    }

    public void getFileforSIR1(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass1(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass1(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.preRevisionVoterDocUrl.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl1).into(FormDocuments.this.binding.preRevisionVoterDocUrl);
                } else {
                    FormDocuments.this.binding.preRevisionVoterDocUrl.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl1, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.1.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file1 = file;
                            Log.e("GETFILE", "FILE1::" + FormDocuments.this.file1);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl1)) {
                    FormDocuments.this.binding.preRevisionVoterDocUrl.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$1$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR2(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass2(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass2(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.preRevisionVoterDocUrl2.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl2).into(FormDocuments.this.binding.preRevisionVoterDocUrl2);
                } else {
                    FormDocuments.this.binding.preRevisionVoterDocUrl2.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl2, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.2.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file2 = file;
                            Log.e("GETFILE", "FILE2::" + FormDocuments.this.file2);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl2)) {
                    FormDocuments.this.binding.preRevisionVoterDocUrl2.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$2$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR3(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass3(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass3(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list6DocUrl.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl3).into(FormDocuments.this.binding.list6DocUrl);
                } else {
                    FormDocuments.this.binding.list6DocUrl.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl3, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.3.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file3 = file;
                            Log.e("GETFILE", "FILE3::" + FormDocuments.this.file3);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl3)) {
                    FormDocuments.this.binding.list6DocUrl.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$3$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$3$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR4(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass4(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass4(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl4 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list6docUrl2.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl4).into(FormDocuments.this.binding.list6docUrl2);
                } else {
                    FormDocuments.this.binding.list6docUrl2.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl4, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.4.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file4 = file;
                            Log.e("GETFILE", "FILE4::" + FormDocuments.this.file4);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl4)) {
                    FormDocuments.this.binding.list6docUrl2.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$4$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR5(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass5(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass5(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl5 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list7DocUrl.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl5).into(FormDocuments.this.binding.list7DocUrl);
                } else {
                    FormDocuments.this.binding.list7DocUrl.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl5, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.5.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file5 = file;
                            Log.e("GETFILE", "FILE5::" + FormDocuments.this.file5);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl5)) {
                    FormDocuments.this.binding.list7DocUrl.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$5$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$5$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR5(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR6(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass6(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass6(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl6 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list7DocUr2.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl6).into(FormDocuments.this.binding.list7DocUr2);
                } else {
                    FormDocuments.this.binding.list7DocUr2.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl6, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.6.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file6 = file;
                            Log.e("GETFILE", "FILE6::" + FormDocuments.this.file6);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl6)) {
                    FormDocuments.this.binding.list7DocUr2.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$6$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR6(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR7(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass7(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass7(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl7 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list1DocUrl.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl7).into(FormDocuments.this.binding.list1DocUrl);
                } else {
                    FormDocuments.this.binding.list1DocUrl.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl7, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.7.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file7 = file;
                            Log.e("GETFILE", "FILE7::" + FormDocuments.this.file7);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl7)) {
                    FormDocuments.this.binding.list1DocUrl.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$7$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR7(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR8(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass8(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass8(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl8 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list1DocUrl2.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl8).into(FormDocuments.this.binding.list1DocUrl2);
                } else {
                    FormDocuments.this.binding.list1DocUrl2.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl8, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.8.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file8 = file;
                            Log.e("GETFILE", "FILE8::" + FormDocuments.this.file8);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl8)) {
                    FormDocuments.this.binding.list1DocUrl2.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$8$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$8$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR8(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR9(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass9(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$9, reason: invalid class name */
    class AnonymousClass9 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass9(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl9 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list3DocUrl.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl9).into(FormDocuments.this.binding.list3DocUrl);
                } else {
                    FormDocuments.this.binding.list3DocUrl.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl9, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.9.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file9 = file;
                            Log.e("GETFILE", "FILE9::" + FormDocuments.this.file9);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl9)) {
                    FormDocuments.this.binding.list3DocUrl.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$9$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$9$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR9(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR10(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass10(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$10, reason: invalid class name */
    class AnonymousClass10 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass10(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl10 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list3DocUrl2.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl10).into(FormDocuments.this.binding.list3DocUrl2);
                } else {
                    FormDocuments.this.binding.list3DocUrl2.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl10, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.10.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file10 = file;
                            Log.e("GETFILE", "FILE10::" + FormDocuments.this.file10);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl10)) {
                    FormDocuments.this.binding.list3DocUrl2.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$10$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$10$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR10(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR11(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass11(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$11, reason: invalid class name */
    class AnonymousClass11 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass11(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl11 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list4DocUrl.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl11).into(FormDocuments.this.binding.list4DocUrl);
                } else {
                    FormDocuments.this.binding.list4DocUrl.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl11, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.11.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file11 = file;
                            Log.e("GETFILE", "FILE11::" + FormDocuments.this.file11);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl11)) {
                    FormDocuments.this.binding.list4DocUrl.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$11$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$11$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR11(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR12(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass12(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$12, reason: invalid class name */
    class AnonymousClass12 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass12(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl12 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list4DocUrl2.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl12).into(FormDocuments.this.binding.list4DocUrl2);
                } else {
                    FormDocuments.this.binding.list4DocUrl2.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl12, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.12.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file12 = file;
                            Log.e("GETFILE", "FILE12::" + FormDocuments.this.file12);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl12)) {
                    FormDocuments.this.binding.list4DocUrl2.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$12$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$12$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR12(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR13(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass13(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$13, reason: invalid class name */
    class AnonymousClass13 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass13(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl13 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list5DocUrl.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl13).into(FormDocuments.this.binding.list5DocUrl);
                } else {
                    FormDocuments.this.binding.list5DocUrl.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl13, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.13.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file13 = file;
                            Log.e("GETFILE", "FILE13::" + FormDocuments.this.file13);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl13)) {
                    FormDocuments.this.binding.list5DocUrl.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$13$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$13$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR13(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR14(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass14(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$14, reason: invalid class name */
    class AnonymousClass14 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass14(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl14 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list5DocUrl2.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl14).into(FormDocuments.this.binding.list5DocUrl2);
                } else {
                    FormDocuments.this.binding.list5DocUrl2.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl14, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.14.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file14 = file;
                            Log.e("GETFILE", "FILE14::" + FormDocuments.this.file14);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl14)) {
                    FormDocuments.this.binding.list5DocUrl2.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$14$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$14$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR14(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR15(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass15(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$15, reason: invalid class name */
    class AnonymousClass15 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass15(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl15 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.list5DocUrl3.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl15).into(FormDocuments.this.binding.list5DocUrl3);
                } else {
                    FormDocuments.this.binding.list5DocUrl3.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl15, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.15.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file15 = file;
                            Log.e("GETFILE", "FILE15::" + FormDocuments.this.file15);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl15)) {
                    FormDocuments.this.binding.list5DocUrl3.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$15$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$15$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR15(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR16(String fileref) {
        Log.d("photoRef= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass16(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$16, reason: invalid class name */
    class AnonymousClass16 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass16(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl16 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.srFormPage1Url.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl16).into(FormDocuments.this.binding.srFormPage1Url);
                } else {
                    FormDocuments.this.binding.srFormPage1Url.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl16, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.16.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file16 = file;
                            Log.e("GETFILE", "FILE16::" + FormDocuments.this.file16);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl16)) {
                    FormDocuments.this.binding.srFormPage1Url.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$16$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$16$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR16(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR17(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass17(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$17, reason: invalid class name */
    class AnonymousClass17 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass17(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl17 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.srFormPage2Url.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl17).into(FormDocuments.this.binding.srFormPage2Url);
                } else {
                    FormDocuments.this.binding.srFormPage2Url.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl17, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.17.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file17 = file;
                            Log.e("GETFILE", "FILE17::" + FormDocuments.this.file17);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl17)) {
                    FormDocuments.this.binding.srFormPage2Url.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$17$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$17$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR17(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR18(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass18(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$18, reason: invalid class name */
    class AnonymousClass18 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass18(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
                FormDocuments.this.preSignedurl18 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.photoUrl.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl18).into(FormDocuments.this.binding.photoUrl);
                } else {
                    FormDocuments.this.binding.photoUrl.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl18, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.18.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file18 = file;
                            Log.e("GETFILE", "FILE18::" + FormDocuments.this.file18);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl18)) {
                    FormDocuments.this.binding.photoUrl.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r5 = FormDocuments.this;
                    String str = r5.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$18$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$18$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR18(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void getFileforSIR19(String fileref) {
        Log.d("File Ref 19= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass19(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$19, reason: invalid class name */
    class AnonymousClass19 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass19(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
                FormDocuments.this.preSignedurl19 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.annexureUrl.setVisibility(0);
                    Glide.with(FormDocuments.this).load(FormDocuments.this.preSignedurl19).into(FormDocuments.this.binding.annexureUrl);
                } else {
                    FormDocuments.this.binding.annexureUrl.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.downloadPdfToCache(formDocuments.preSignedurl19, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments.19.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            FormDocuments.this.file19 = file;
                            Log.e("GETFILE", "FILE19::" + FormDocuments.this.file19);
                        }
                    });
                }
                if (TextUtils.isEmpty(FormDocuments.this.preSignedurl19)) {
                    FormDocuments.this.binding.annexureUrl.setImageBitmap(BitmapFactory.decodeResource(FormDocuments.this.getResources(), R.drawable.blo_dummy_image));
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                }
                if (FormDocuments.this.alertDialog != null) {
                    FormDocuments.this.alertDialog.dismiss();
                }
            } else if (response.code() == 404) {
                if (this.val$fileref.endsWith(".pdf")) {
                    FormDocuments.this.binding.annexureUrl.setImageDrawable(ContextCompat.getDrawable(FormDocuments.this, R.drawable.blo_pdf_thumbnail));
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FormDocuments.this.commomUtility;
                    ?? r6 = FormDocuments.this;
                    String str = r6.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$19$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag);
                }
            } else {
                try {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, new JSONObject(response.errorBody().string()).optString(FormDocuments.this.messageString));
                } catch (IOException | JSONException e) {
                    if (FormDocuments.this.alertDialog != null) {
                        FormDocuments.this.alertDialog.dismiss();
                    }
                    Logger.e(FormDocuments.this.TAG, e.getMessage());
                }
            }
            FormDocuments.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments] */
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
            FormDocuments.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDocuments.this.commomUtility;
                ?? r5 = FormDocuments.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$19$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDocuments.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setToken("Bearer " + str2);
                FormDocuments.this.getFileforSIR19(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDocuments.this.getApplicationContext()).setLocaleBool(false);
            FormDocuments.this.startActivity(new Intent((Context) FormDocuments.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FormDocuments.this.TAG, FormDocuments.this.comingTag + t.getMessage());
            if (FormDocuments.this.alertDialog != null) {
                FormDocuments.this.alertDialog.dismiss();
            }
            FormDocuments formDocuments = FormDocuments.this;
            formDocuments.showDialog1(formDocuments.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda39
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$22(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$22(DialogInterface dialogInterface, int i) {
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void submit() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        HashMap map2 = new HashMap();
        map2.put("bloOverridenFlg", "N");
        map2.put("submittedForRecommendation", TextUtils.isEmpty(this.notRecommendedClicked) ? "" : this.notRecommendedClicked);
        map2.put("modifiedBy", "BLO");
        map2.put("epicNo", this.bundle.getString("epic"));
        map2.put("epicId", Long.valueOf(this.bundle.getLong("epicId")));
        map2.put("acNo", this.bundle.getString("acNo"));
        map2.put("partNo", this.bundle.getString("partNo"));
        map2.put("partSerialNo", this.bundle.getString("serialNo"));
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).updateSpecialRevisionSIR(map, map2).enqueue(new AnonymousClass20());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$20, reason: invalid class name */
    class AnonymousClass20 implements Callback<JsonObject> {
        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass20() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            try {
                if (!response.isSuccessful()) {
                    String string = new JSONObject(response.errorBody().string()).getString("message");
                    FormDocuments formDocuments = FormDocuments.this;
                    formDocuments.showDialog2(formDocuments.getString(R.string.alertMsg), string);
                } else {
                    FormDocuments formDocuments2 = FormDocuments.this;
                    formDocuments2.showDialog2("", formDocuments2.getString(R.string.formSubmittedMsg));
                }
            } catch (Exception e) {
                Logger.d("FormDocuments", e.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$20$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            FormDocuments.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda24
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$24(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog2$24(DialogInterface dialogInterface, int i) {
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$26(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$26(View view) {
        onBackPressed();
    }

    public void downloadPdfToCache1(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache1$27(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache1$27(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file1 = this.pdffile;
                    Log.e("GETFILE", "File1:::" + this.file1);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache2(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda38
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache2$28(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache2$28(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file2 = this.pdffile;
                    Log.e("GETFILE", "File2:::" + this.file2);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache3(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache3$29(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache3$29(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file3 = this.pdffile;
                    Log.e("GETFILE", "File3:::" + this.file3);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache4(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache4$30(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache4$30(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file4 = this.pdffile;
                    Log.e("GETFILE", "File4:::" + this.file4);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache5(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache5$31(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache5$31(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file5 = this.pdffile;
                    Log.e("GETFILE", "File5:::" + this.file5);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache6(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda35
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache6$32(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache6$32(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file6 = this.pdffile;
                    Log.e("GETFILE", "File6:::" + this.file6);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache7(final String preSignedUrl) {
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache7$33(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache7$33(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            File fileCreateTempFile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file7 = fileCreateTempFile;
                    Log.e("GETFILE", "File7:::" + this.file7);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache8(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache8$34(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache8$34(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file8 = this.pdffile;
                    Log.e("GETFILE", "File8:::" + this.file8);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache9(final String preSignedUrl) {
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache9$35(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache9$35(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            File fileCreateTempFile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file9 = fileCreateTempFile;
                    Log.e("GETFILE", "File9:::" + this.file9);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache10(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache10$36(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache10$36(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file10 = this.pdffile;
                    Log.e("GETFILE", "File10:::" + this.file10);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache11(final String preSignedUrl) {
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache11$37(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache11$37(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            File fileCreateTempFile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file11 = fileCreateTempFile;
                    Log.e("GETFILE", "File11:::" + this.file11);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache12(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache12$38(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache12$38(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file12 = this.pdffile;
                    Log.e("GETFILE", "File12:::" + this.file12);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache13(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache13$39(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache13$39(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file13 = this.pdffile;
                    Log.e("GETFILE", "File13:::" + this.file13);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache14(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache14$40(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache14$40(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file14 = this.pdffile;
                    Log.e("GETFILE", "File14:::" + this.file14);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache15(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache15$41(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache15$41(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file15 = this.pdffile;
                    Log.e("GETFILE", "File15:::" + this.file15);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache16(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache16$42(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache16$42(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file16 = this.pdffile;
                    Log.e("GETFILE", "File16:::" + this.file16);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache17(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda36
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache17$43(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache17$43(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file17 = this.pdffile;
                    Log.e("GETFILE", "File17:::" + this.file17);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache18(final String preSignedUrl) {
        this.pdffile = null;
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache18$44(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache18$44(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            this.pdffile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(this.pdffile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file18 = this.pdffile;
                    Log.e("GETFILE", "File18:::" + this.file18);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache19(final String preSignedUrl) {
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache19$45(preSignedUrl);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache19$45(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            File fileCreateTempFile = File.createTempFile("temp_pdf_" + System.currentTimeMillis(), ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    this.file19 = fileCreateTempFile;
                    Log.e("GETFILE", "File19:::" + this.file19);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }

    public void downloadPdfToCache(final String preSignedUrl, final pdfDownloadCallback callback) {
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDocuments$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache$46(preSignedUrl, callback);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache$46(String str, pdfDownloadCallback pdfdownloadcallback) {
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
