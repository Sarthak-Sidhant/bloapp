package in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
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
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloBloMomBinding;
import in.gov.eci.bloapp.model.SIR.unCollectableModel;
import in.gov.eci.bloapp.model.SIR.unCollectableStatus;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.BloBlaMoMRoot;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCallerNewPdf;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlValidationError;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UpdateBloBlaMomActivity extends SuperBaseActivity {
    private int acNo;
    AlertDialog alertDialog;
    String alreadyEpic;
    String asmblyNO;
    private String atkband;
    BloBloMomBinding binding;
    unCollectableModel bodyModel;
    byte[] byteArray;
    String currentDate;
    private String epic;
    private Long epicId;
    protected long filesize;
    String flag;
    String from;
    String mime;
    private int partNo;
    String partNoS;
    private int partSerialNo;
    private byte[] pdfbyteArray;
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
    private String unCollectReason;
    Utils utils;
    String img = "image";
    String whitecolor = "#000000";
    String greycolor = "#99000000";
    String blackColor = "#000000";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    ArrayList<unCollectableModel> bodyList = new ArrayList<>();
    ArrayList<unCollectableStatus> status = new ArrayList<>();
    String validEpicFlag = "N";
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
    String photo1strNew = "EnumerationFormPage1";
    String photo2strNew = "EnumerationFormPage2";
    String photo3strNew = "SupportingDocumentPage1";
    String photo4strNew = "SupportingDocumentPage2";
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
    String comingTag = "coming in onFailure";
    String objectStorageString = "objectstorage";
    String messageString = "message";
    int getImage1Count = 0;
    int getImage2Count = 0;
    int getImage3Count = 0;
    int getImage4Count = 0;
    ActivityResultLauncher<Intent> activityResultLauncher3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity.7
        /* JADX WARN: Code duplicated, block: B:33:0x0094 A[Catch: Exception -> 0x01db, TryCatch #2 {Exception -> 0x01db, blocks: (B:31:0x0067, B:33:0x0094, B:35:0x00af, B:40:0x01ca, B:36:0x012e, B:38:0x0147, B:39:0x015c, B:41:0x01ce, B:42:0x01da), top: B:50:0x0067 }] */
        /* JADX WARN: Code duplicated, block: B:35:0x00af A[Catch: Exception -> 0x01db, TryCatch #2 {Exception -> 0x01db, blocks: (B:31:0x0067, B:33:0x0094, B:35:0x00af, B:40:0x01ca, B:36:0x012e, B:38:0x0147, B:39:0x015c, B:41:0x01ce, B:42:0x01da), top: B:50:0x0067 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x012e A[Catch: Exception -> 0x01db, TryCatch #2 {Exception -> 0x01db, blocks: (B:31:0x0067, B:33:0x0094, B:35:0x00af, B:40:0x01ca, B:36:0x012e, B:38:0x0147, B:39:0x015c, B:41:0x01ce, B:42:0x01da), top: B:50:0x0067 }] */
        /* JADX WARN: Code duplicated, block: B:38:0x0147 A[Catch: Exception -> 0x01db, TryCatch #2 {Exception -> 0x01db, blocks: (B:31:0x0067, B:33:0x0094, B:35:0x00af, B:40:0x01ca, B:36:0x012e, B:38:0x0147, B:39:0x015c, B:41:0x01ce, B:42:0x01da), top: B:50:0x0067 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x015c A[Catch: Exception -> 0x01db, TryCatch #2 {Exception -> 0x01db, blocks: (B:31:0x0067, B:33:0x0094, B:35:0x00af, B:40:0x01ca, B:36:0x012e, B:38:0x0147, B:39:0x015c, B:41:0x01ce, B:42:0x01da), top: B:50:0x0067 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x01ce A[Catch: Exception -> 0x01db, TryCatch #2 {Exception -> 0x01db, blocks: (B:31:0x0067, B:33:0x0094, B:35:0x00af, B:40:0x01ca, B:36:0x012e, B:38:0x0147, B:39:0x015c, B:41:0x01ce, B:42:0x01da), top: B:50:0x0067 }] */
        public void onActivityResult(ActivityResult result) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            Uri saveImagePath;
            Cursor cursorQuery;
            String[] strArrSplit;
            double dRound;
            Throwable th;
            if (result.getResultCode() != -1) {
                return;
            }
            Uri data = result.getData().getData();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                try {
                    InputStream inputStreamOpenInputStream = UpdateBloBlaMomActivity.this.getApplicationContext().getContentResolver().openInputStream(data);
                    try {
                        byte[] bArr = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int i = inputStreamOpenInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream.write(bArr, 0, i);
                                }
                                UpdateBloBlaMomActivity.this.pdfbyteArray = byteArrayOutputStream.toByteArray();
                                String strEncodeToString = Base64.encodeToString(UpdateBloBlaMomActivity.this.pdfbyteArray, 0);
                                UpdateBloBlaMomActivity updateBloBlaMomActivity = UpdateBloBlaMomActivity.this;
                                saveImagePath = updateBloBlaMomActivity.getSaveImagePath(strEncodeToString, ".pdf", updateBloBlaMomActivity.temp);
                                cursorQuery = UpdateBloBlaMomActivity.this.getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                                if (cursorQuery.getCount() > 0) {
                                    cursorQuery.close();
                                    throw new IllegalArgumentException(UpdateBloBlaMomActivity.this.imgmsg);
                                }
                                cursorQuery.moveToFirst();
                                strArrSplit = saveImagePath.getPath().split("/");
                                if (UpdateBloBlaMomActivity.this.filesize < 1024) {
                                    double dRound2 = Math.round(UpdateBloBlaMomActivity.this.filesize * 100.0d) / 100.0d;
                                    cursorQuery.close();
                                    UpdateBloBlaMomActivity.this.alertDialog.show();
                                    UpdateBloBlaMomActivity updateBloBlaMomActivity2 = UpdateBloBlaMomActivity.this;
                                    updateBloBlaMomActivity2.uploadPhoto(updateBloBlaMomActivity2.stateCode, UpdateBloBlaMomActivity.this.asmblyNO, String.valueOf(UpdateBloBlaMomActivity.this.partNo), UpdateBloBlaMomActivity.this.filepathimg, UpdateBloBlaMomActivity.this.saveImageFileName, UpdateBloBlaMomActivity.this.token, UpdateBloBlaMomActivity.this.referenceNo, "DOB");
                                    UpdateBloBlaMomActivity.this.binding.photoname.setText(strArrSplit[strArrSplit.length - 1]);
                                    UpdateBloBlaMomActivity.this.binding.size.setText(dRound2 + "KB");
                                    UpdateBloBlaMomActivity.this.binding.photoname.setVisibility(8);
                                    UpdateBloBlaMomActivity.this.binding.size.setVisibility(8);
                                } else {
                                    dRound = Math.round(((double) (UpdateBloBlaMomActivity.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                    cursorQuery.close();
                                    if (dRound > 11.0d) {
                                        UpdateBloBlaMomActivity.this.binding.deathCerti.setVisibility(8);
                                        UpdateBloBlaMomActivity updateBloBlaMomActivity3 = UpdateBloBlaMomActivity.this;
                                        updateBloBlaMomActivity3.showdialog(updateBloBlaMomActivity3.alert, UpdateBloBlaMomActivity.this.pdf3);
                                    } else {
                                        UpdateBloBlaMomActivity.this.alertDialog.show();
                                        UpdateBloBlaMomActivity updateBloBlaMomActivity4 = UpdateBloBlaMomActivity.this;
                                        updateBloBlaMomActivity4.uploadPhoto(updateBloBlaMomActivity4.stateCode, UpdateBloBlaMomActivity.this.asmblyNO, String.valueOf(UpdateBloBlaMomActivity.this.partNo), UpdateBloBlaMomActivity.this.filepathimg, UpdateBloBlaMomActivity.this.saveImageFileName, UpdateBloBlaMomActivity.this.token, UpdateBloBlaMomActivity.this.referenceNo, "DOB");
                                        UpdateBloBlaMomActivity.this.binding.photoname.setText(strArrSplit[strArrSplit.length - 1]);
                                        UpdateBloBlaMomActivity.this.binding.size.setText(dRound + "MB");
                                        UpdateBloBlaMomActivity.this.binding.photoname.setVisibility(8);
                                        UpdateBloBlaMomActivity.this.binding.size.setVisibility(8);
                                    }
                                }
                                cursorQuery.close();
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                if (inputStreamOpenInputStream == null) {
                                    throw th;
                                }
                                try {
                                    inputStreamOpenInputStream.close();
                                    throw th;
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                    throw th;
                                }
                            }
                            Logger.d("", e.getMessage());
                            byteArrayOutputStream = byteArrayOutputStream2;
                        }
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Exception e) {
                                e = e;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                Logger.d("", e.getMessage());
                                byteArrayOutputStream = byteArrayOutputStream2;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                String strEncodeToString2 = Base64.encodeToString(UpdateBloBlaMomActivity.this.pdfbyteArray, 0);
                UpdateBloBlaMomActivity updateBloBlaMomActivity5 = UpdateBloBlaMomActivity.this;
                saveImagePath = updateBloBlaMomActivity5.getSaveImagePath(strEncodeToString2, ".pdf", updateBloBlaMomActivity5.temp);
                cursorQuery = UpdateBloBlaMomActivity.this.getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException(UpdateBloBlaMomActivity.this.imgmsg);
                }
                cursorQuery.moveToFirst();
                strArrSplit = saveImagePath.getPath().split("/");
                if (UpdateBloBlaMomActivity.this.filesize < 1024) {
                    double dRound3 = Math.round(UpdateBloBlaMomActivity.this.filesize * 100.0d) / 100.0d;
                    cursorQuery.close();
                    UpdateBloBlaMomActivity.this.alertDialog.show();
                    UpdateBloBlaMomActivity updateBloBlaMomActivity6 = UpdateBloBlaMomActivity.this;
                    updateBloBlaMomActivity6.uploadPhoto(updateBloBlaMomActivity6.stateCode, UpdateBloBlaMomActivity.this.asmblyNO, String.valueOf(UpdateBloBlaMomActivity.this.partNo), UpdateBloBlaMomActivity.this.filepathimg, UpdateBloBlaMomActivity.this.saveImageFileName, UpdateBloBlaMomActivity.this.token, UpdateBloBlaMomActivity.this.referenceNo, "DOB");
                    UpdateBloBlaMomActivity.this.binding.photoname.setText(strArrSplit[strArrSplit.length - 1]);
                    UpdateBloBlaMomActivity.this.binding.size.setText(dRound3 + "KB");
                    UpdateBloBlaMomActivity.this.binding.photoname.setVisibility(8);
                    UpdateBloBlaMomActivity.this.binding.size.setVisibility(8);
                } else {
                    dRound = Math.round(((double) (UpdateBloBlaMomActivity.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                    cursorQuery.close();
                    if (dRound > 11.0d) {
                        UpdateBloBlaMomActivity.this.binding.deathCerti.setVisibility(8);
                        UpdateBloBlaMomActivity updateBloBlaMomActivity7 = UpdateBloBlaMomActivity.this;
                        updateBloBlaMomActivity7.showdialog(updateBloBlaMomActivity7.alert, UpdateBloBlaMomActivity.this.pdf3);
                    } else {
                        UpdateBloBlaMomActivity.this.alertDialog.show();
                        UpdateBloBlaMomActivity updateBloBlaMomActivity8 = UpdateBloBlaMomActivity.this;
                        updateBloBlaMomActivity8.uploadPhoto(updateBloBlaMomActivity8.stateCode, UpdateBloBlaMomActivity.this.asmblyNO, String.valueOf(UpdateBloBlaMomActivity.this.partNo), UpdateBloBlaMomActivity.this.filepathimg, UpdateBloBlaMomActivity.this.saveImageFileName, UpdateBloBlaMomActivity.this.token, UpdateBloBlaMomActivity.this.referenceNo, "DOB");
                        UpdateBloBlaMomActivity.this.binding.photoname.setText(strArrSplit[strArrSplit.length - 1]);
                        UpdateBloBlaMomActivity.this.binding.size.setText(dRound + "MB");
                        UpdateBloBlaMomActivity.this.binding.photoname.setVisibility(8);
                        UpdateBloBlaMomActivity.this.binding.size.setVisibility(8);
                    }
                }
                cursorQuery.close();
                return;
            } catch (Exception e3) {
                Logger.d("", e3.getMessage());
                return;
            }
            UpdateBloBlaMomActivity.this.pdfbyteArray = byteArrayOutputStream.toByteArray();
        }
    });

    public interface DownloadCallback {
        void onError(String message, Throwable cause);

        void onSuccess(File pdfFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = BloBloMomBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
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
        this.cancel = getString(R.string.cancelMsg);
        this.takephoto = getString(R.string.takePhotoMsg);
        this.alertText = getString(R.string.alertMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        String str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        this.currentDate = str;
        Logger.d("UncollectableTAG", str);
        getMomDetails();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.submitSIR1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.textView5.setText("v" + new CommomUtility().appversion);
        this.binding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.photo.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        validate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        selectPDF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        this.relativeDocument1UrlS = "";
        this.binding.photoname.setText("");
        this.binding.size.setText("");
        this.binding.chooseFile.setEnabled(true);
        this.binding.deathCerti.setVisibility(8);
        this.binding.chooseFile.setTextColor(Color.parseColor(this.whitecolor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (this.relativeDocument1UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file1, this.relativeDocument1UrlS);
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
            }
        }
    }

    private void validate() {
        if (TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            showDialog1(getString(R.string.alertMsg), "Please Upload PDF");
        } else {
            submit();
        }
    }

    private void submit() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        map.put("appname", "BLOAPP");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("momDoc1", this.relativeDocument1UrlS);
        this.service.saveMomDetails(map, map2).enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
            if (response.isSuccessful() && response.body() != null) {
                if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                    UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                }
                UpdateBloBlaMomActivity.this.showDialog2("", ((JsonObject) response.body()).get("message").toString());
                return;
            }
            if (response.code() == 401) {
                if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                    UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = UpdateBloBlaMomActivity.this.commomUtility;
                ?? r5 = UpdateBloBlaMomActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                    UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                }
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                UpdateBloBlaMomActivity updateBloBlaMomActivity = UpdateBloBlaMomActivity.this;
                updateBloBlaMomActivity.showDialog1(updateBloBlaMomActivity.alertText, strOptString);
                Logger.e("UncollectableTAG", strOptString);
            } catch (IOException | JSONException e) {
                if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                    UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                }
                Logger.e("UncollectableTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UpdateBloBlaMomActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UpdateBloBlaMomActivity.this.getApplicationContext()).setLocaleBool(false);
            UpdateBloBlaMomActivity.this.startActivity(new Intent(UpdateBloBlaMomActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                UpdateBloBlaMomActivity.this.alertDialog.dismiss();
            }
            Logger.e("UncollectableTAG", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$4(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$4(DialogInterface dialogInterface, int i) {
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
        new AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$5(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog2$5(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) FormTypes.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$6(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$6(View view) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pickPhoto(final int code, final String listCode) {
        final String str = this.state + this.acNo + this.partNo;
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$7(charSequenceArr, str, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$7(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.temp = str + str2;
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
        } else if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected, String code) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d("UncollectableTAG", "getSaveImagePath ");
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            String str2 = "img_" + code + str + this.jpgTextBaseActivity;
            this.saveImageFileName = str2;
            Logger.d("UncollectableTAG", str2);
            Logger.d("UncollectableTAG", this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + code + str + this.pdfTextBaseActivity;
            Logger.d("UncollectableTAG", this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
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
            Logger.d("UncollectableTAG", this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d("UncollectableTAG", "filesize " + this.filesize);
        Logger.d("UncollectableTAG", this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }

    public static String getMD5Checksum(File file) {
        String strEncodeToString;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                if (Build.VERSION.SDK_INT >= 33) {
                    strEncodeToString = java.util.Base64.getEncoder().encodeToString(messageDigest.digest(fileInputStream.readAllBytes()));
                } else {
                    strEncodeToString = java.util.Base64.getEncoder().encodeToString(messageDigest.digest(toByteArray(fileInputStream)));
                }
                fileInputStream.close();
                return strEncodeToString;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = input.read(bArr, 0, 1024);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static SecretKey convertStringToSecretKey(String encodedKey) {
        byte[] bArrDecode = java.util.Base64.getDecoder().decode(encodedKey);
        return new SecretKeySpec(bArrDecode, 0, bArrDecode.length, "AES");
    }

    private static GCMParameterSpec generateGcm() {
        return new GCMParameterSpec(128, new byte[16]);
    }

    public String decryptUrl(String cipherText) {
        try {
            String strDecrypt = decrypt("AES/GCM/NoPadding", cipherText, convertStringToSecretKey("P79vtNtk/WZaAXsQKCHClA=="), generateGcm());
            if (strDecrypt.length() < 20 || strDecrypt == null) {
                return null;
            }
            return strDecrypt.substring(14, strDecrypt.length() - 6);
        } catch (Exception unused) {
            System.out.println("decryption failed");
            return null;
        }
    }

    private static String decrypt(String algorithm, String cipherText, SecretKey key, GCMParameterSpec gcmParameterSpec) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(2, key, gcmParameterSpec);
            return new String(cipher.doFinal(java.util.Base64.getDecoder().decode(cipherText)));
        } catch (Exception unused) {
            return null;
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
            String mD5Checksum = getMD5Checksum(new File(filepath + captureFileName));
            HashMap map2 = new HashMap();
            map2.put("epicNo", this.temp);
            map2.put("state", this.state);
            map2.put("acNo", this.asmblyNO);
            map2.put("partNo", Integer.valueOf(this.partNo));
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", null);
            map2.put("fileName", captureFileName);
            map2.put("ext", strSubstring);
            Logger.d("UncollectableTAG", map2.toString());
            ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass2(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass2(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v25, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
                CommomUtility commomUtility = UpdateBloBlaMomActivity.this.commomUtility;
                ?? r13 = UpdateBloBlaMomActivity.this;
                String str = ((UpdateBloBlaMomActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$2$$ExternalSyntheticLambda1
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
                        UpdateBloBlaMomActivity updateBloBlaMomActivity = UpdateBloBlaMomActivity.this;
                        updateBloBlaMomActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, updateBloBlaMomActivity.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = UpdateBloBlaMomActivity.this.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equalsIgnoreCase("DOB")) {
                        UpdateBloBlaMomActivity.this.relativeDocument1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        UpdateBloBlaMomActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, UpdateBloBlaMomActivity.this.relativeDocument1UrlS);
                    }
                    System.out.println("Presigned URL : " + strDecryptUrl);
                    Logger.d("UncollectableTAG", strValueOf);
                    return;
                } catch (Exception e) {
                    if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                        UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                    }
                    UpdateBloBlaMomActivity.this.resetImage(this.val$uploadtype, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equalsIgnoreCase("DOB")) {
                if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                    UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                }
                UpdateBloBlaMomActivity.this.photo1countNew = 0;
                UpdateBloBlaMomActivity.this.binding.photo.setVisibility(8);
            }
            UpdateBloBlaMomActivity.this.alertDialog.dismiss();
            try {
                JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                String string = jSONObject2.getString("message");
                UpdateBloBlaMomActivity updateBloBlaMomActivity2 = UpdateBloBlaMomActivity.this;
                updateBloBlaMomActivity2.showDialog1(updateBloBlaMomActivity2.alertText, string);
                Logger.d("", jSONObject2.toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
                CommomUtility commomUtility = UpdateBloBlaMomActivity.this.commomUtility;
                ?? r2 = UpdateBloBlaMomActivity.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            UpdateBloBlaMomActivity.this.token = "Bearer " + str8;
            UpdateBloBlaMomActivity.this.refreshToken = str9;
            SharedPref.getInstance(UpdateBloBlaMomActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(UpdateBloBlaMomActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            UpdateBloBlaMomActivity updateBloBlaMomActivity = UpdateBloBlaMomActivity.this;
            updateBloBlaMomActivity.uploadPhoto(str, str2, str3, str4, str5, updateBloBlaMomActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UpdateBloBlaMomActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UpdateBloBlaMomActivity.this.getApplicationContext()).setLocaleBool(false);
            UpdateBloBlaMomActivity.this.startActivity(new Intent((Context) UpdateBloBlaMomActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equalsIgnoreCase("DOB")) {
                if (UpdateBloBlaMomActivity.this.photo1countNew < 2 && TextUtils.isEmpty(UpdateBloBlaMomActivity.this.relativeDocument1UrlS)) {
                    UpdateBloBlaMomActivity.this.photo1countNew++;
                    UpdateBloBlaMomActivity updateBloBlaMomActivity = UpdateBloBlaMomActivity.this;
                    updateBloBlaMomActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, updateBloBlaMomActivity.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                    UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                }
                UpdateBloBlaMomActivity.this.photo1countNew = 0;
                UpdateBloBlaMomActivity.this.binding.photo.setVisibility(8);
                UpdateBloBlaMomActivity updateBloBlaMomActivity2 = UpdateBloBlaMomActivity.this;
                updateBloBlaMomActivity2.showDialog1(updateBloBlaMomActivity2.alertText, UpdateBloBlaMomActivity.this.fileNotFoundMessage);
            }
        }
    }

    public void setValue() {
        setImages();
    }

    private void setImages() {
        if (TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            this.binding.chooseFile.setEnabled(true);
            this.binding.deathCerti.setVisibility(8);
            this.binding.chooseFile.setTextColor(Color.parseColor(this.whitecolor));
        }
        if (!TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            getFile1(this.relativeDocument1UrlS);
            if (this.relativeDocument1UrlS.endsWith(".pdf")) {
                this.binding.photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                return;
            }
            return;
        }
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        if (!this.alertDialog.isShowing()) {
            this.alertDialog.show();
        }
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass3(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass3(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
                UpdateBloBlaMomActivity.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                UpdateBloBlaMomActivity updateBloBlaMomActivity = UpdateBloBlaMomActivity.this;
                updateBloBlaMomActivity.downloadPdfToCache(updateBloBlaMomActivity.preSignedurl1, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity.3.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity.DownloadCallback
                    public void onSuccess(File pdfFile) {
                        if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                            UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                        }
                        UpdateBloBlaMomActivity.this.file1 = pdfFile;
                        Log.e("GETFILE", "FILE1::" + UpdateBloBlaMomActivity.this.file1);
                        UpdateBloBlaMomActivity.this.binding.photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                        UpdateBloBlaMomActivity.this.binding.deathCerti.setVisibility(0);
                        if (TextUtils.isEmpty(UpdateBloBlaMomActivity.this.preSignedurl1)) {
                            UpdateBloBlaMomActivity.this.binding.photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                            UpdateBloBlaMomActivity.this.binding.deathCerti.setVisibility(0);
                            if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                                UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                            }
                        }
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity.DownloadCallback
                    public void onError(String message, Throwable cause) {
                        if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                            UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                        }
                        UpdateBloBlaMomActivity.this.resetImage("DOB", message);
                    }
                });
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = UpdateBloBlaMomActivity.this.commomUtility;
                    ?? r6 = UpdateBloBlaMomActivity.this;
                    String str = ((UpdateBloBlaMomActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$3$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e("UncollectableTAG", UpdateBloBlaMomActivity.this.comingTag);
                }
            } else {
                try {
                    UpdateBloBlaMomActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$3$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    String strOptString = new JSONObject(response.errorBody().string()).optString(UpdateBloBlaMomActivity.this.messageString);
                    Logger.e("UncollectableTAG", strOptString);
                    UpdateBloBlaMomActivity.this.resetImage("DOB", strOptString);
                } catch (IOException | JSONException e) {
                    if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                        UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectableTAG", e.getMessage());
                }
            }
            UpdateBloBlaMomActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
            UpdateBloBlaMomActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = UpdateBloBlaMomActivity.this.commomUtility;
                ?? r5 = UpdateBloBlaMomActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$3$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                UpdateBloBlaMomActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(UpdateBloBlaMomActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(UpdateBloBlaMomActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                UpdateBloBlaMomActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UpdateBloBlaMomActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UpdateBloBlaMomActivity.this.getApplicationContext()).setLocaleBool(false);
            UpdateBloBlaMomActivity.this.startActivity(new Intent((Context) UpdateBloBlaMomActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                UpdateBloBlaMomActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("UncollectableTAG", UpdateBloBlaMomActivity.this.comingTag + t.getMessage());
            if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                UpdateBloBlaMomActivity.this.alertDialog.dismiss();
            }
            UpdateBloBlaMomActivity updateBloBlaMomActivity = UpdateBloBlaMomActivity.this;
            updateBloBlaMomActivity.showDialog1(updateBloBlaMomActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showImageDialog(String preSignedUrlP, String name) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        AppCompatImageView appCompatImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        textView.setVisibility(8);
        Glide.with(this).load(preSignedUrlP).placeholder(R.drawable.blo_dummy_image).error(R.drawable.blo_dummy_image).into(appCompatImageView);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda10
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
            this.binding.photoname.setText("");
            this.binding.size.setText("");
            this.binding.chooseFile.setEnabled(true);
            this.binding.deathCerti.setVisibility(8);
            this.binding.chooseFile.setTextColor(Color.parseColor(this.whitecolor));
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity.4
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("preSignedurl1", strReplace);
                    UpdateBloBlaMomActivity.this.downloadPdfToCache(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity.4.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity.DownloadCallback
                        public void onSuccess(File pdfFile) {
                            if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                                UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                            }
                            UpdateBloBlaMomActivity.this.file1 = pdfFile;
                            Log.e("GETFILE", "FILE1::" + UpdateBloBlaMomActivity.this.file1);
                            UpdateBloBlaMomActivity.this.binding.photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                            UpdateBloBlaMomActivity.this.binding.deathCerti.setVisibility(0);
                            UpdateBloBlaMomActivity.this.binding.chooseFile.setTextColor(Color.parseColor(UpdateBloBlaMomActivity.this.greycolor));
                            UpdateBloBlaMomActivity.this.binding.photoname.setVisibility(0);
                            UpdateBloBlaMomActivity.this.binding.size.setVisibility(0);
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity.DownloadCallback
                        public void onError(String message, Throwable cause) {
                            if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                                UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                            }
                            UpdateBloBlaMomActivity.this.resetImage(uploadType, message);
                        }
                    });
                } else {
                    if (response.code() == 401) {
                        if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                            UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                        }
                        UpdateBloBlaMomActivity.this.resetImage(uploadType, Constants.somethingWentWrong);
                        return;
                    }
                    try {
                        String strOptString = new JSONObject(response.errorBody().string()).optString(UpdateBloBlaMomActivity.this.messageString);
                        Logger.e("UncollectableTAG", strOptString);
                        UpdateBloBlaMomActivity.this.retryAPI(fileref, uploadType, strOptString);
                    } catch (Exception e) {
                        Logger.e("UncollectableTAG", e.getMessage());
                        UpdateBloBlaMomActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                UpdateBloBlaMomActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
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
        new UploadCallerNewPdf().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity.5
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                        UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                    }
                    UpdateBloBlaMomActivity.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uploadtype.equalsIgnoreCase("DOB")) {
                            UpdateBloBlaMomActivity.this.displayFile(filereference, uploadtype);
                        }
                    }
                }, 1000L);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getMomDetails() {
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
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getMomDetails(map).enqueue(new AnonymousClass6());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<BloBlaMoMRoot> {
        AnonymousClass6() {
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
        public void onResponse(Call<BloBlaMoMRoot> call, Response<BloBlaMoMRoot> response) {
            if (response.code() != 200) {
                if (response.code() == 401) {
                    if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                        UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.d("UncollectableTAG", "GetDistrict1 errorResponse --> " + strOptString);
                    UpdateBloBlaMomActivity.this.commomUtility.showMessageWithTitleOK(UpdateBloBlaMomActivity.this, "Alert", strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$6$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } catch (IOException | JSONException e) {
                    UpdateBloBlaMomActivity.this.commomUtility.showMessageWithTitleOK(UpdateBloBlaMomActivity.this, "alert", "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$6$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    Logger.d("UncollectableTAG", "getDistrict1 exception --> " + e.getMessage());
                }
                if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                    UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (((BloBlaMoMRoot) response.body()).getPayload() == null) {
                UpdateBloBlaMomActivity.this.binding.chooseFile.setEnabled(true);
                UpdateBloBlaMomActivity.this.binding.deathCerti.setVisibility(8);
                UpdateBloBlaMomActivity.this.binding.chooseFile.setTextColor(Color.parseColor(UpdateBloBlaMomActivity.this.whitecolor));
                if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                    UpdateBloBlaMomActivity.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            UpdateBloBlaMomActivity.this.relativeDocument1UrlS = ((BloBlaMoMRoot) response.body()).getPayload().getMomDoc1();
            if (UpdateBloBlaMomActivity.this.relativeDocument1UrlS.endsWith(".jpg")) {
                UpdateBloBlaMomActivity.this.relativeDocument1UrlS = "";
            }
            if (TextUtils.isEmpty(UpdateBloBlaMomActivity.this.relativeDocument1UrlS)) {
                UpdateBloBlaMomActivity.this.binding.chooseFile.setTextColor(Color.parseColor(UpdateBloBlaMomActivity.this.greycolor));
                UpdateBloBlaMomActivity.this.binding.chooseFile.setEnabled(false);
            }
            UpdateBloBlaMomActivity.this.setValue();
        }

        public void onFailure(Call<BloBlaMoMRoot> call, Throwable t) {
            if (UpdateBloBlaMomActivity.this.alertDialog != null) {
                UpdateBloBlaMomActivity.this.alertDialog.dismiss();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void selectPDF() {
        final CharSequence[] charSequenceArr = {this.choosepdf, this.cancel};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(this.addPdf);
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectPDF$9(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectPDF$9(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.choosepdf)) {
            openfile3();
        } else if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    public void openfile3() {
        String[] strArr = {this.applicationpdf};
        this.temp = (this.state + this.acNo + this.partNo) + "pdf1";
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        this.activityResultLauncher3.launch(Intent.createChooser(intent, this.chooseFile));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog$10(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog$10(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    public Uri getSaveImagePath1(String fileNameBase64, String documentTypeSelected) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d(this.logTagBaseActivity, "getSaveImagePath ");
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            this.saveImageFileName = "img_" + str + this.jpgTextBaseActivity;
            Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
            Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
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
            Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d(this.logTagBaseActivity, "filesize " + this.filesize);
        Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }

    private void showPersonPdfDialog(File preSignedUrl, String pdfNameFromObjectStorage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        pDFViewFindViewById.fromFile(preSignedUrl).enableSwipe(true).enableDoubletap(true).defaultPage(0).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void downloadPdfToCache(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$downloadPdfToCache$14(preSignedUrl, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$downloadPdfToCache$14(String str, final DownloadCallback downloadCallback) throws Throwable {
        String str2;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    httpsURLConnection2.setConnectTimeout(XmlValidationError.UNDEFINED);
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
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda0
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
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            UpdateBloBlaMomActivity.DownloadCallback downloadCallback2 = downloadCallback;
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
}
