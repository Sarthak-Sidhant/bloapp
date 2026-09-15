package in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.google.gson.JsonObject;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.crypto.BadPasswordException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.shockwave.pdfium.PdfPasswordException;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityViewDocumentsBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.ViewDocumentPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.ViewDocumentRoot;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCallerNewPdf;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ViewDocumentsActivity extends SuperBaseActivity {
    private int acNo;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    ActivityViewDocumentsBinding binding;
    String currentDate;
    private Long epicId;
    protected long filesize;
    String flag;
    String from;
    String image2;
    String mime;
    private int partNo;
    String partNoS;
    private int partSerialNo;
    private byte[] pdfbyteArray;
    Dialog pdfdialog;
    String reason;
    String referenceNo;
    private String refreshToken;
    private String rtkband;
    protected String saveImageFileName;
    UserClient service;
    private String state;
    String stateCode;
    String temp;
    private String token;
    Utils utils;
    VerifyPayload verifyPayload;
    String img = "image";
    CommomUtility commomUtility = new CommomUtility();
    private final String TAG = "UncollectableTAG";
    String SESSION = "";
    String cancel = "";
    String takephoto = "";
    String imgmsg = "";
    String fileNotFoundMessage = "Something went wrong.";
    String alertText = "";
    String functionNameForLogBaseActivity = "";
    String pdfTextBaseActivity = ".pdf";
    String fileNameTextBaseActivity = "fileName";
    String jpgTextBaseActivity = ".jpg";
    String garudaTextBaseActivity = "GARUDA";
    String imageTextBaseActivity = "image";
    String relativeDocument1UrlS = "";
    int photo1countNew = 0;
    int photo2countNew = 0;
    int photo3countNew = 0;
    int photo4countNew = 0;
    String reasonTrans = "";
    String choosepdf = "Choose PDF from Gallery";
    String addPdf = "Add PDF!";
    String applicationpdf = "application/pdf";
    String chooseFile = "Choose File";
    String alert = "Alert";
    String pdf3 = "PDF size exceeded 10MB limit.";
    String logTagBaseActivity = "UpdateBloBlaMomActivity";
    File file1 = null;
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
    String comingTag = "coming in onFailure";
    String objectStorageString = "objectstorage";
    String messageString = "message";
    File pdfDocument1File = null;
    File pdfDocument2File = null;
    File pdfDocument3File = null;
    File pdfDocument4File = null;
    File pdfDocument5File = null;
    File pdfDocument6File = null;
    File pdfDocument7File = null;
    File pdfDocument8File = null;
    File pdfDocument9File = null;
    File pdfDocument10File = null;
    File pdfDocument11File = null;
    File pdfDocument12File = null;
    File pdfDocument13File = null;
    File pdfDocument14File = null;
    File pdfDocument15File = null;
    File pdfDocument16File = null;
    File pdfDocument17File = null;
    File pdfDocument18File = null;
    int getImage1Count = 0;
    int getImage2Count = 0;
    int getImage3Count = 0;
    int getImage4Count = 0;
    String erollPhoto = "";
    String surveyPhoto = "";

    public interface DownloadCallback {
        void onError(String message, Throwable cause);

        void onSuccess(File pdfFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityViewDocumentsBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            this.verifyPayload = (VerifyPayload) intent.getParcelableExtra("data");
        }
        this.epicId = this.verifyPayload.getEpicId();
        this.SESSION = getString(R.string.sessionMsg);
        this.service = (UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class);
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.acNo = Integer.parseInt(SharedPref.getInstance(getApplicationContext()).getAssemblyNumber());
        this.partNo = Integer.parseInt(SharedPref.getInstance(getApplicationContext()).getPartNumber());
        this.partNoS = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.stateCode = SharedPref.getInstance(getApplicationContext()).getStateCode();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        initClickListener();
        this.utils = new Utils();
        this.alertText = getString(R.string.alertMsg);
        String str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        this.currentDate = str;
        Logger.d("UncollectableTAG", str);
        getPhotoDetails();
        this.binding.textView3.setText(getResources().getString(R.string.view_documents_new));
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        finish();
    }

    public void setValue(final String document1, final String document2, final String document3, final String document4, final String document5, final String document6, final String document7, final String document8, final String document9, final String document10, final String document11, final String document12, final String document13, final String document14, final String document15, final String document16, final String document17, final String document18) {
        int i;
        if (!TextUtils.isEmpty(document1)) {
            getFile1(document1);
            this.binding.document1FirstImageLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document1.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument1File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl1, null);
                    }
                }
            });
        } else {
            this.binding.document1FirstImageLayout.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document2)) {
            getFile2(document2);
            this.binding.document1SecondImageLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document2.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument2File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl2, null);
                    }
                }
            });
        } else {
            this.binding.document1SecondImageLayout.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document3)) {
            getFile3(document3);
            this.binding.documents2FirstImageLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document3.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument3File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl3, null);
                    }
                }
            });
        } else {
            this.binding.documents2FirstImageLayout.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document4)) {
            getFile4(document4);
            this.binding.documents2SecondImageLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document4.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument4File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl4, null);
                    }
                }
            });
        } else {
            this.binding.documents2SecondImageLayout.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document5)) {
            getFile5(document5);
            this.binding.viewDocument3FirstImageLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document5.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument5File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl5, null);
                    }
                }
            });
        } else {
            this.binding.viewDocument3FirstImageLayout.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document6)) {
            getFile6(document6);
            this.binding.viewDocument3SecondImageLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document6.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument6File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl6, null);
                    }
                }
            });
        } else {
            this.binding.viewDocument3SecondImageLayout.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document7)) {
            getFile7(document7);
            this.binding.doc4firstLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document7.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument7File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl7, null);
                    }
                }
            });
        } else {
            this.binding.doc4firstLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document8)) {
            getFile8(document8);
            this.binding.doc4secondLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document8.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument8File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl8, null);
                    }
                }
            });
        } else {
            this.binding.doc4secondLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document9)) {
            getFile9(document9);
            this.binding.doc5firstLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document9.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument9File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl9, null);
                    }
                }
            });
        } else {
            this.binding.doc5firstLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document10)) {
            getFile10(document10);
            this.binding.doc5secondLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document10.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument10File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl10, null);
                    }
                }
            });
        } else {
            this.binding.doc5secondLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document11)) {
            getFile11(document11);
            this.binding.doc6firstLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document11.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument11File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl11, null);
                    }
                }
            });
        } else {
            this.binding.doc6firstLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document12)) {
            getFile12(document12);
            this.binding.doc6secondLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document12.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument12File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl12, null);
                    }
                }
            });
        } else {
            this.binding.doc6secondLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document13)) {
            getFile13(document13);
            this.binding.doc7firstLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document13.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument13File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl13, null);
                    }
                }
            });
        } else {
            this.binding.doc7firstLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document14)) {
            getFile14(document14);
            this.binding.doc7secondLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document14.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument14File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl14, null);
                    }
                }
            });
        } else {
            this.binding.doc7secondLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document15)) {
            getFile15(document15);
            this.binding.doc8firstLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document15.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument15File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl15, null);
                    }
                }
            });
        } else {
            this.binding.doc8firstLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document16)) {
            getFile16(document16);
            this.binding.doc8secondLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document16.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument16File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl16, null);
                    }
                }
            });
        } else {
            this.binding.doc8secondLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document17)) {
            getFile17(document17);
            this.binding.doc9firstLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document17.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument17File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl17, null);
                    }
                }
            });
        } else {
            this.binding.doc9firstLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(document18)) {
            getFile18(document18);
            this.binding.doc9secondLL1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (document18.endsWith(".pdf")) {
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showPersonPdfDialog(viewDocumentsActivity.pdfDocument18File, null);
                    } else {
                        ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                        viewDocumentsActivity2.showImageDialog(viewDocumentsActivity2.preSignedurl18, null);
                    }
                }
            });
            i = 8;
        } else {
            i = 8;
            this.binding.doc9secondLL1.setVisibility(8);
        }
        if (TextUtils.isEmpty(document1) && TextUtils.isEmpty(document2)) {
            this.binding.cardDoc1.setVisibility(i);
        }
        if (TextUtils.isEmpty(document3) && TextUtils.isEmpty(document4)) {
            this.binding.cardDoc2.setVisibility(i);
        }
        if (TextUtils.isEmpty(document5) && TextUtils.isEmpty(document6)) {
            this.binding.cardDoc3.setVisibility(i);
        }
        if (TextUtils.isEmpty(document7) && TextUtils.isEmpty(document8)) {
            this.binding.cardDoc4.setVisibility(i);
        }
        if (TextUtils.isEmpty(document9) && TextUtils.isEmpty(document10)) {
            this.binding.cardDoc5.setVisibility(i);
        }
        if (TextUtils.isEmpty(document11) && TextUtils.isEmpty(document12)) {
            this.binding.cardDoc6.setVisibility(i);
        }
        if (TextUtils.isEmpty(document13) && TextUtils.isEmpty(document14)) {
            this.binding.cardDoc7.setVisibility(i);
        }
        if (TextUtils.isEmpty(document15) && TextUtils.isEmpty(document16)) {
            this.binding.cardDoc8.setVisibility(i);
        }
        if (TextUtils.isEmpty(document17) && TextUtils.isEmpty(document18)) {
            this.binding.cardDoc9.setVisibility(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass19(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$19, reason: invalid class name */
    class AnonymousClass19 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass19(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl1, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.19.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument1File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.frontImage);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.document1FirstImageLayout.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl1, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.19.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl1).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.frontImage);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.document1FirstImageLayout.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$19$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$19$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$19$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile2(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass20(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$20, reason: invalid class name */
    class AnonymousClass20 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass20(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl2, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.20.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument2File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.backImage);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.document1SecondImageLayout.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl2, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.20.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl2).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.backImage);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.document1SecondImageLayout.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$20$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$20$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$20$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile3(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass21(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$21, reason: invalid class name */
    class AnonymousClass21 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass21(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl3, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.21.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument3File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.documents2FirstImageLayout.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl3, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.21.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl3).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.documents2FirstImageLayout.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$21$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$21$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$21$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile4(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass22(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$22, reason: invalid class name */
    class AnonymousClass22 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass22(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl4 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl4, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.22.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument4File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.documents2SecondImageLayout.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl4, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.22.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl4).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.documents2SecondImageLayout.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$22$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$22$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$22$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile5(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass23(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$23, reason: invalid class name */
    class AnonymousClass23 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass23(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl5 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl5, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.23.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument5File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc3frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.viewDocument3FirstImageLayout.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl5, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.23.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl5).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc3frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.viewDocument3FirstImageLayout.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$23$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$23$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$23$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile6(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass24(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$24, reason: invalid class name */
    class AnonymousClass24 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass24(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl6 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl6, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.24.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument6File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc3backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.viewDocument3SecondImageLayout.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl6, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.24.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl6).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc3backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.viewDocument3SecondImageLayout.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$24$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$24$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$24$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile7(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass25(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$25, reason: invalid class name */
    class AnonymousClass25 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass25(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl7 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl7, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.25.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument7File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc4frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc4firstLL1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl7, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.25.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl7).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc4frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc4firstLL1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$25$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$25$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$25$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile8(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass26(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$26, reason: invalid class name */
    class AnonymousClass26 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass26(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl8 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl8, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.26.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument8File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc4backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc4secondLL1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl8, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.26.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl8).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc4backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc4secondLL1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$26$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$26$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$26$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile9(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass27(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$27, reason: invalid class name */
    class AnonymousClass27 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass27(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl9 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl9, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.27.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument9File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc5frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc5firstLL1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl9, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.27.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl9).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc5frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc5firstLL1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$27$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$27$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$27$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile10(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass28(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$28, reason: invalid class name */
    class AnonymousClass28 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass28(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl10 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl10, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.28.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument10File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc5backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc5secondLL1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl10, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.28.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl10).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc5backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc5secondLL1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$28$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$28$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$28$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile11(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass29(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$29, reason: invalid class name */
    class AnonymousClass29 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass29(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl11 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl11, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.29.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument11File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc6frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc6frontImage1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl11, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.29.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl11).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc6frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc6frontImage1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$29$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$29$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$29$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile12(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass30(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$30, reason: invalid class name */
    class AnonymousClass30 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass30(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl12 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl12, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.30.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument12File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc6backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc6backImage1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl12, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.30.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl12).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc6backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc6backImage1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$30$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$30$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$30$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile13(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass31(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$31, reason: invalid class name */
    class AnonymousClass31 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass31(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl13 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl13, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.31.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument13File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc7frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc7frontImage1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl13, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.31.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl13).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc7frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc7frontImage1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$31$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$31$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$31$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile14(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass32(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$32, reason: invalid class name */
    class AnonymousClass32 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass32(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl14 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl14, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.32.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument14File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc7backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc7backImage1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl14, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.32.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl14).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc7backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc7backImage1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$32$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$32$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$32$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile15(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass33(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$33, reason: invalid class name */
    class AnonymousClass33 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass33(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl15 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl15, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.33.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument15File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc8frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc8frontImage1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl15, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.33.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl15).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc8frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc8frontImage1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$33$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$33$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$33$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile16(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass34(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$34, reason: invalid class name */
    class AnonymousClass34 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass34(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl16 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl16, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.34.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument16File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc8backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc8backImage1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl16, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.34.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl16).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc8backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc8backImage1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$34$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$34$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$34$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile17(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass35(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$35, reason: invalid class name */
    class AnonymousClass35 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass35(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl17 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl17, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.35.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument17File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc9frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc9frontImage1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl17, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.35.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl17).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc9frontImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc9frontImage1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$35$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$35$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$35$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile18(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass36(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$36, reason: invalid class name */
    class AnonymousClass36 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass36(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
                ViewDocumentsActivity.this.preSignedurl18 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                }
                if (this.val$fileref.endsWith(".pdf")) {
                    ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                    viewDocumentsActivity.downloadPdfToCache(viewDocumentsActivity.preSignedurl18, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.36.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.pdfDocument18File = pdfFile;
                            Glide.with(ViewDocumentsActivity.this).load(Integer.valueOf(R.drawable.blo_pdf_thumbnail)).error(R.drawable.blo_pdf_thumbnail).into(ViewDocumentsActivity.this.binding.doc9backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc9backImage1.setVisibility(8);
                        }
                    });
                } else {
                    ViewDocumentsActivity viewDocumentsActivity2 = ViewDocumentsActivity.this;
                    viewDocumentsActivity2.checkImageFromURL(viewDocumentsActivity2.preSignedurl18, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.36.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(ViewDocumentsActivity.this);
                            circularProgressDrawable.setStrokeWidth(6.0f);
                            circularProgressDrawable.setCenterRadius(24.0f);
                            circularProgressDrawable.setColorSchemeColors(new int[]{ContextCompat.getColor(ViewDocumentsActivity.this, R.color.blo_blue)});
                            circularProgressDrawable.start();
                            Glide.with(ViewDocumentsActivity.this).load(ViewDocumentsActivity.this.preSignedurl18).placeholder(circularProgressDrawable).error(R.drawable.blo_dummy_image).into(ViewDocumentsActivity.this.binding.doc9backImage1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.binding.doc9backImage1.setVisibility(8);
                        }
                    });
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                    ?? r6 = ViewDocumentsActivity.this;
                    String str = ((ViewDocumentsActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$36$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag);
                }
            } else {
                try {
                    ViewDocumentsActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$36$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    ViewDocumentsActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            ViewDocumentsActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
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
            ViewDocumentsActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewDocumentsActivity.this.commomUtility;
                ?? r5 = ViewDocumentsActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$36$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewDocumentsActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewDocumentsActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewDocumentsActivity.this.getApplicationContext()).setLocaleBool(false);
            ViewDocumentsActivity.this.startActivity(new Intent((Context) ViewDocumentsActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", ViewDocumentsActivity.this.comingTag + t.getMessage());
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
            viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void resetImage(String imageType, String error) {
        if (imageType.equalsIgnoreCase("DOB")) {
            this.relativeDocument1UrlS = "";
            this.surveyPhoto = null;
            this.binding.frontImage.setImageResource(R.drawable.new_dummy);
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.37
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("preSignedurl1", strReplace);
                    ViewDocumentsActivity.this.downloadPdfToCache(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.37.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.file1 = pdfFile;
                            Log.e("GETFILE", "FILE1::" + ViewDocumentsActivity.this.file1);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (ViewDocumentsActivity.this.alertDialog != null) {
                                ViewDocumentsActivity.this.alertDialog.dismiss();
                            }
                            ViewDocumentsActivity.this.resetImage(uploadType, message);
                        }
                    });
                } else {
                    if (response.code() == 401) {
                        if (ViewDocumentsActivity.this.alertDialog != null) {
                            ViewDocumentsActivity.this.alertDialog.dismiss();
                        }
                        ViewDocumentsActivity viewDocumentsActivity = ViewDocumentsActivity.this;
                        viewDocumentsActivity.showDialog1(viewDocumentsActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
                        return;
                    }
                    try {
                        String strOptString = new JSONObject(response.errorBody().string()).optString(ViewDocumentsActivity.this.messageString);
                        Logger.e("UncollectableTAG", strOptString);
                        ViewDocumentsActivity.this.retryAPI(fileref, uploadType, strOptString);
                    } catch (Exception e) {
                        Logger.e("UncollectableTAG", e.getMessage());
                        ViewDocumentsActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                ViewDocumentsActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
            }
        });
    }

    public void retryAPI(String fileref, String uploadType, String error) {
        if (uploadType.equalsIgnoreCase("DOB")) {
            int i = this.getImage1Count;
            if (i < 2) {
                this.getImage1Count = i + 1;
                displayFile(fileref, uploadType);
                return;
            }
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            this.getImage1Count = 0;
            resetImage(uploadType, error);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadImageons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCallerNewPdf().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.38
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                    }
                    ViewDocumentsActivity.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity.38.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uploadtype.equalsIgnoreCase("DOB")) {
                            ViewDocumentsActivity.this.displayFile(filereference, uploadtype);
                        }
                    }
                }, 1000L);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getPhotoDetails() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("CurrentRole", "blo");
        map.put("state", this.state);
        map.put("atkn_bnd", SharedPref.getInstance(this).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(this).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        HashMap map2 = new HashMap();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        map2.put("epicId", this.epicId);
        map2.put("state", this.state);
        map2.put("epicNo", this.verifyPayload.getEpicNo());
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getOfHearingScheduleEfByEpic(this.state.toLowerCase(), map, map2).enqueue(new AnonymousClass39());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$39, reason: invalid class name */
    class AnonymousClass39 implements Callback<ViewDocumentRoot> {
        AnonymousClass39() {
        }

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
        public void onResponse(Call<ViewDocumentRoot> call, Response<ViewDocumentRoot> response) {
            if (response.code() != 200) {
                if (response.code() == 401) {
                    if (ViewDocumentsActivity.this.alertDialog != null) {
                        ViewDocumentsActivity.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.d("UncollectableTAG", "GetDistrict1 errorResponse --> " + strOptString);
                    ViewDocumentsActivity.this.commomUtility.showMessageWithTitleOK(ViewDocumentsActivity.this, "Alert", strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$39$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } catch (IOException | JSONException e) {
                    ViewDocumentsActivity.this.commomUtility.showMessageWithTitleOK(ViewDocumentsActivity.this, "alert", "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$39$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    Logger.d("UncollectableTAG", "getDistrict1 exception --> " + e.getMessage());
                }
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (((ViewDocumentRoot) response.body()).getPayload() == null) {
                if (ViewDocumentsActivity.this.alertDialog != null) {
                    ViewDocumentsActivity.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
            ViewDocumentPayload payload = ((ViewDocumentRoot) response.body()).getPayload();
            ViewDocumentsActivity.this.binding.electorNamePendingSir.setText(TextUtils.isEmpty(ViewDocumentsActivity.this.verifyPayload.getEpicName()) ? "" : ViewDocumentsActivity.this.verifyPayload.getEpicName());
            ViewDocumentsActivity.this.binding.epicPendingSir.setText(TextUtils.isEmpty(ViewDocumentsActivity.this.verifyPayload.getEpicNo()) ? "" : ViewDocumentsActivity.this.verifyPayload.getEpicNo());
            ViewDocumentsActivity.this.binding.serialNoPendingSir.setText(ViewDocumentsActivity.this.verifyPayload.getPartSerialNo() == 0 ? "" : String.valueOf(ViewDocumentsActivity.this.verifyPayload.getPartSerialNo()));
            ViewDocumentsActivity.this.binding.tvDocumentName1Title.setText(TextUtils.isEmpty(payload.getDoc1TypevalueCitizen()) ? "" : payload.getDoc1TypevalueCitizen());
            ViewDocumentsActivity.this.binding.tvDocumentName2Title.setText(TextUtils.isEmpty(payload.getDoc2TypevalueCitizen()) ? "" : payload.getDoc2TypevalueCitizen());
            ViewDocumentsActivity.this.binding.tvDocumentName3Title.setText(TextUtils.isEmpty(payload.getDoc3TypevalueCitizen()) ? "" : payload.getDoc3TypevalueCitizen());
            ViewDocumentsActivity.this.binding.tvDocumentName4Title.setText(TextUtils.isEmpty(payload.getDoc4TypevalueCitizen()) ? "" : payload.getDoc4TypevalueCitizen());
            ViewDocumentsActivity.this.binding.tvDocumentName5Title.setText(TextUtils.isEmpty(payload.getDoc5TypevalueCitizen()) ? "" : payload.getDoc5TypevalueCitizen());
            ViewDocumentsActivity.this.binding.tvDocumentName6Title.setText(TextUtils.isEmpty(payload.getDoc6TypevalueCitizen()) ? "" : payload.getDoc6TypevalueCitizen());
            ViewDocumentsActivity.this.binding.tvDocumentName1.setVisibility(8);
            ViewDocumentsActivity.this.binding.tvDocumentName2.setVisibility(8);
            ViewDocumentsActivity.this.binding.tvDocumentName3.setVisibility(8);
            ViewDocumentsActivity.this.binding.tvDocumentName4.setVisibility(8);
            ViewDocumentsActivity.this.binding.tvDocumentName5.setVisibility(8);
            ViewDocumentsActivity.this.binding.tvDocumentName6.setVisibility(8);
            ViewDocumentsActivity.this.binding.tvDocumentName7.setVisibility(8);
            ViewDocumentsActivity.this.binding.tvDocumentName8.setVisibility(8);
            ViewDocumentsActivity.this.binding.tvDocumentName9.setVisibility(8);
            if (payload.getCategoryType().equalsIgnoreCase("NA")) {
                ViewDocumentsActivity.this.setValue(payload.getDoc1FrontCitizen(), payload.getDoc1BackCitizen(), payload.getDoc2FrontCitizen(), payload.getDoc2BackCitizen(), payload.getDoc3FrontCitizen(), payload.getDoc3BackCitizen(), payload.getDoc4FrontCitizen(), payload.getDoc4BackCitizen(), payload.getDoc5FrontCitizen(), payload.getDoc5BackCitizen(), payload.getDoc6FrontCitizen(), payload.getDoc6BackCitizen(), null, null, null, null, null, null);
            }
            if (payload.getCategoryType().equalsIgnoreCase("Progeny")) {
                ViewDocumentsActivity.this.setValue(null, null, null, null, null, null, null, null, null, null, null, null, payload.getLastSirFrontCitizen(), payload.getLastSirBackCitizen(), payload.getDoc1FrontCitizenParent(), payload.getDoc1BackCitizenParent(), payload.getDoc1FrontCitizenGrandParent(), payload.getDoc1BackCitizenGrandParent());
            }
        }

        public void onFailure(Call<ViewDocumentRoot> call, Throwable t) {
            if (ViewDocumentsActivity.this.alertDialog != null) {
                ViewDocumentsActivity.this.alertDialog.dismiss();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog$2(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog$2(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    private void showPasswordPdfDialog(final File preSignedUrl, String pdfNameFromObjectStorage, String password) {
        try {
            final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
            dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
            ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
            PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
            TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
            pDFViewFindViewById.fromFile(preSignedUrl).enableSwipe(true).enableDoubletap(true).defaultPage(0).enableAnnotationRendering(false).onError(new OnErrorListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda15
                public final void onError(Throwable th) {
                    this.f$0.lambda$showPasswordPdfDialog$3(preSignedUrl, th);
                }
            }).password(password).load();
            textView.setText(pdfNameFromObjectStorage);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPasswordPdfDialog$3(File file, Throwable th) {
        if (th instanceof PdfPasswordException) {
            showPasswordDialog(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPersonPdfDialog(File preSignedUrl, String pdfNameFromObjectStorage) {
        Dialog dialog;
        try {
            Dialog dialog2 = new Dialog((Context) Objects.requireNonNull(this));
            this.pdfdialog = dialog2;
            dialog2.setContentView(R.layout.blo_person_pdf_dialog_layout);
            ImageView imageView = (ImageView) this.pdfdialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
            PDFView pDFView = (PDFView) this.pdfdialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
            TextView textView = (TextView) this.pdfdialog.findViewById(R.id.person_dialog_pdf_name);
            textView.setVisibility(8);
            flattenPdf(preSignedUrl, pDFView, null, this.pdfdialog);
            textView.setText(pdfNameFromObjectStorage);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$showPersonPdfDialog$5(view);
                }
            });
            this.pdfdialog.show();
        } catch (Exception e) {
            if (!(e instanceof BadPasswordException) || (dialog = this.pdfdialog) == null) {
                return;
            }
            dialog.dismiss();
            showPasswordDialog(preSignedUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPersonPdfDialog$5(View view) {
        this.pdfdialog.dismiss();
    }

    private void flattenPdf(File inputFile, PDFView pdfView, String password, Dialog pdfdialog) throws Exception {
        try {
            final File file = new File(getCacheDir(), "flattened.pdf");
            PdfDocument pdfDocument = new PdfDocument(new PdfReader(inputFile.getAbsolutePath()), new PdfWriter(file.getAbsolutePath()));
            PdfAcroForm acroForm = PdfAcroForm.getAcroForm(pdfDocument, false);
            if (acroForm != null) {
                acroForm.flattenFields();
            }
            pdfDocument.close();
            pdfView.fromFile(file).enableSwipe(true).swipeHorizontal(true).enableAnnotationRendering(true).onError(new OnErrorListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda12
                public final void onError(Throwable th) {
                    this.f$0.lambda$flattenPdf$6(file, th);
                }
            }).password(password).load();
        } catch (Exception e) {
            if (e instanceof BadPasswordException) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$flattenPdf$6(File file, Throwable th) {
        if (th instanceof PdfPasswordException) {
            showPasswordDialog(file);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showPasswordDialog(final File file) {
        final EditText editText = new EditText(this);
        editText.setInputType(129);
        editText.setHint("Enter PDF password");
        new AlertDialog.Builder(this).setTitle("Password Required").setMessage("This PDF is protected. Please enter the password.").setView(editText).setCancelable(true).setPositiveButton("Open", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPasswordDialog$7(editText, file, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showPasswordDialog$7(EditText editText, File file, DialogInterface dialogInterface, int i) {
        String string = editText.getText().toString();
        if (string == null || string.trim().isEmpty()) {
            Toast.makeText((Context) this, (CharSequence) "Password cannot be empty.", 0).show();
        } else {
            showPasswordPdfDialog(file, null, string.trim());
        }
    }

    public void downloadPdfToCache(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$downloadPdfToCache$11(preSignedUrl, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$downloadPdfToCache$11(String str, final DownloadCallback downloadCallback) throws Throwable {
        String str2;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    httpsURLConnection2.setConnectTimeout(10000);
                    httpsURLConnection2.setReadTimeout(20000);
                    httpsURLConnection2.setInstanceFollowRedirects(true);
                    httpsURLConnection2.setRequestMethod("GET");
                    httpsURLConnection2.setRequestProperty("Accept", "application/pdf,*/*;q=0.8");
                    httpsURLConnection2.setSSLSocketFactory(SSLFactoryHelper.getSSLParams((Context) this, new int[]{getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", getPackageName()), getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", getPackageName())}).sslSocketFactory);
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
                    int contentLength = httpsURLConnection2.getContentLength();
                    if (contentLength == 0) {
                        throw new IOException("Content-Length is zero. The PDF appears empty.");
                    }
                    InputStream inputStream = httpsURLConnection2.getInputStream();
                    if (inputStream == null) {
                        throw new IOException("Empty response body.");
                    }
                    final File fileCreateTempFile = File.createTempFile("temp_pdf", ".pdf", getCacheDir());
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                        try {
                            byte[] bArr = new byte[8192];
                            bufferedInputStream.mark(16);
                            byte[] bArr2 = new byte[8];
                            int i = bufferedInputStream.read(bArr2);
                            bufferedInputStream.reset();
                            if (i <= 0) {
                                throw new IOException("No data received; PDF appears empty.");
                            }
                            if (!new String(bArr2, 0, i, StandardCharsets.US_ASCII).startsWith("%PDF")) {
                                throw new IOException("Not a valid PDF (missing %PDF header).");
                            }
                            int i2 = 0;
                            while (true) {
                                int i3 = bufferedInputStream.read(bArr);
                                if (i3 == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i3);
                                i2 += i3;
                            }
                            fileOutputStream.flush();
                            if (contentLength > 0 && i2 != contentLength) {
                                throw new IOException("Download truncated. Expected " + contentLength + " bytes, got " + i2 + ".");
                            }
                            if (fileCreateTempFile.length() == 0) {
                                throw new IOException("Downloaded file size is zero.");
                            }
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda8
                                @Override // java.lang.Runnable
                                public final void run() {
                                    downloadCallback.onSuccess(fileCreateTempFile);
                                }
                            });
                            fileOutputStream.close();
                            bufferedInputStream.close();
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (Exception e) {
                    e = e;
                    httpsURLConnection = httpsURLConnection2;
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda9
                        @Override // java.lang.Runnable
                        public final void run() {
                            ViewDocumentsActivity.DownloadCallback downloadCallback2 = downloadCallback;
                            Exception exc = e;
                            downloadCallback2.onError(exc.getMessage(), exc);
                        }
                    });
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    httpsURLConnection = httpsURLConnection2;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th6) {
            th = th6;
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
        if (length >= 3 && (head[0] & 255) == 255 && (head[1] & 255) == 216 && (head[2] & 255) == 255) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$12(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$12(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    public void checkImageFromURL(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$checkImageFromURL$15(preSignedUrl, callback);
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
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity] */
    public /* synthetic */ void lambda$checkImageFromURL$15(String str, final DownloadCallback downloadCallback) throws Throwable {
        String str2;
        ?? r4 = 0;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                try {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
                    try {
                        httpsURLConnection2.setSSLSocketFactory(SSLFactoryHelper.getSSLParams((Context) this, new int[]{getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", getPackageName()), getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", getPackageName())}).sslSocketFactory);
                        httpsURLConnection2.setConnectTimeout(10000);
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
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda0
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
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDocumentsActivity$$ExternalSyntheticLambda7
                            @Override // java.lang.Runnable
                            public final void run() {
                                ViewDocumentsActivity.DownloadCallback downloadCallback2 = downloadCallback;
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
}
