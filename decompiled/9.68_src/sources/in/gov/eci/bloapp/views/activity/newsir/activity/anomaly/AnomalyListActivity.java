package in.gov.eci.bloapp.views.activity.newsir.activity.anomaly;

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
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.AnomalyDetailsDialogBinding;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.AnomalyListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.AnomalyItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.AnomalyListCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.AnomalyDetailsPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.AnomalyDetailsRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.AnomalyListPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.AsdActionrRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.DocTypeRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.DocumentPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.Payload;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.network.UploadCaller;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import kotlin.UByte;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlValidationError;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AnomalyListActivity extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private static String SESSION = "";
    private String acNo;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<AnomalyListPayload> al;
    AlertDialog alertDialog;
    ArrayList<AnomalyDetailsPayload> anomalydetailsList;
    private String atkband;
    private ImageView back_btn_iv;
    String barcode;
    AnomalyDetailsDialogBinding binding;
    Button btScanCode;
    List<String> efOptionList;
    String epic;
    protected long filesize;
    List<VerifyPayload> formlist;
    String[] listArray;
    String mime;
    TextView noteOpen;
    private String partNo;
    private byte[] pdfbyteArray;
    RecyclerView recyclerView;
    String referenceNo;
    private String refreshToken;
    private String rtkband;
    protected String saveImageFileName;
    ConstraintLayout scanCode;
    EditText search;
    UserClient service;
    Spinner spinner;
    private String state;
    String temp;
    TextView textView3;
    TextView textView5;
    private String token;
    Utils utils;
    AnomalyListAdapter verifyCitizenListAdapter;
    int docIdParent = 0;
    int docIdGrandParent = 0;
    int docIdParent1 = 0;
    int docIdGrandParent1 = 0;
    int docIdParent2 = 0;
    int docIdParent3 = 0;
    int doc3IdGranprent = 0;
    int doc4IdGrandParent = 0;
    String alertText = "";
    String TAG = "FormDataNewTAG";
    CommomUtility commomUtility = new CommomUtility();
    int deceasedCount = 0;
    int eightyFivePlusCount = 0;
    String cancel = "";
    String doc5Page1str = "Doc5Page1";
    String doc5Page2str = "Doc5Page2";
    String doc6Page1str = "Doc6Page1";
    String doc6Page2str = "Doc6Page2";
    String doc5Page1Url = "";
    String doc5Page2URL = "";
    String doc6Page1Url = "";
    String doc6Page2URL = "";
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    String takephoto = "";
    String photo1strNew = "EnumerationFormPage1";
    String photo2strNew = "EnumerationFormPage2";
    String photo3strNew = "SupportingDocumentPage1";
    String photo4strNew = "SupportingDocumentPage2";
    String parentSpinner2Image = "parentSpinner2Image";
    String parentSpinner2Image2 = "parentSpinner2Image2";
    String grandParentspinner1Page1 = "grandParentspinner1Page1";
    String grandParentspinner1Page2 = "grandParentspinner1Page2";
    String parentDoc3Page1Tag = "parentDoc3Page1Tag";
    String parentDoc3Page2Tag = "parentDoc3Page2Tag";
    String parentDoc4Page1Tag = "parentDoc4Page1Tag";
    String parentDoc4Page2Tag = "parentDoc4Page2Tag";
    String grandparentDoc3Page1Tag = "grandparentDoc3Page1Tag";
    String grandparentDoc3Page2Tag = "grandparentDoc3Page2Tag";
    String grandparentDoc4Page1Tag = "grandparentDoc4Page1Tag";
    String grandparentDoc4Page2Tag = "grandparentDoc4Page2Tag";
    String relativeDocument1UrlS = "";
    String relativeDocument2UrlS = "";
    String relativeSupportingDocumentPage1UrlS = "";
    String relativeSupportingDocumentPage2UrlS = "";
    int photo1countNew = 0;
    int photo2countNew = 0;
    int photo3countNew = 0;
    int photo4countNew = 0;
    String parentSpinner2ImageUrl = "";
    String parentSpinner2ImageUrl1 = "";
    String parentDoc3Page1ImageUrl = "";
    String parentDoc3Page2ImageUrl = "";
    String parentDoc4Page1ImageUrl = "";
    String parentDoc4Page2ImageUrl = "";
    String grandParentSpinner2ImageUrl = "";
    String grandParentSpinner2ImageUrl1 = "";
    String grandParentDoc3Page1Url = "";
    String grandParentDoc3Page2Url = "";
    String grandParentDoc4Page1Url = "";
    String grandParentDoc4Page2Url = "";
    String whitecolor = "#000000";
    String greycolor = "#99000000";
    String blackColor = "#000000";
    String objectStorageString = "objectstorage";
    int getImage1Count = 0;
    int getImage2Count = 0;
    int getImage3Count = 0;
    int getImage4Count = 0;
    int blolettercount = 0;
    int doc5page1count = 0;
    int doc5page2count = 0;
    int doc6page1count = 0;
    int doc6page2count = 0;
    int parentSpinner2ImageCount = 0;
    int parentSpinner2Image2Count = 0;
    int grandParentSpinner2ImageCount = 0;
    int grandParentSpinner2Image2Count = 0;
    int parentDoc3Page1Count = 0;
    int parentDoc3Page2Count = 0;
    int parentDoc4Page1Count = 0;
    int parentDoc4Page2Count = 0;
    int grandparentDoc3Page1Count = 0;
    int grandparentDoc3Page2Count = 0;
    int grandparentDoc4Page1Count = 0;
    int grandparentDoc4Page2Count = 0;
    String preSignedurl1 = "";
    String preSignedurl2 = "";
    String preSignedurl3 = "";
    String preSignedurl4 = "";
    String comingTag = "coming in onFailure";
    String messageString = "message";
    String bloletter = "";
    String fileNotFoundMessage = "Something went wrong.";
    String functionNameForLogBaseActivity = "";
    String jpgTextBaseActivity = ".jpg";
    String garudaTextBaseActivity = "GARUDA";
    String imageTextBaseActivity = "image";
    String fileNameTextBaseActivity = "fileName";
    String pdfTextBaseActivity = ".pdf";
    String imgmsg = "";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    ArrayList<String> docnameList = new ArrayList<>();
    ArrayList<Integer> docCodeist = new ArrayList<>();
    ArrayList<DocumentPayload> documenttypeList = new ArrayList<>();
    boolean isUserSelected = false;

    public interface DownloadCallback {
        void onError(String message, Throwable cause);

        void onSuccess(File pdfFile);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_data_new);
        SESSION = getString(R.string.sessionMsg);
        this.recyclerView = findViewById(R.id.recyclerView);
        this.search = (EditText) findViewById(R.id.search);
        this.noteOpen = (TextView) findViewById(R.id.noteOpen);
        this.back_btn_iv = (ImageView) findViewById(R.id.back_btn_iv);
        this.textView5 = (TextView) findViewById(R.id.textView5);
        this.textView3 = (TextView) findViewById(R.id.textView3);
        this.scanCode = findViewById(R.id.scanCode);
        this.btScanCode = (Button) findViewById(R.id.btScanCode);
        this.noteOpen = (TextView) findViewById(R.id.noteOpen);
        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.al = new ArrayList<>();
        this.alertText = getString(R.string.alertMsg);
        this.utils = new Utils();
        initClickListener();
        this.service = (UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class);
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        getVerifyCitizenFormList();
        this.alertDialog.show();
        this.noteOpen.setVisibility(8);
        this.spinner.setVisibility(8);
        this.noteOpen.setText("Click here to view ASD/85+ count ");
        this.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View viewInflate2 = LayoutInflater.from(AnomalyListActivity.this).inflate(R.layout.category_count_dialog_layout, (ViewGroup) null);
                TextView textView = (TextView) viewInflate2.findViewById(R.id.txtSelfCount);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.txtProgeny);
                TextView textView3 = (TextView) viewInflate2.findViewById(R.id.txtNeither);
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.noteTotal);
                textView.setText(AnomalyListActivity.this.getString(R.string.deceased) + " - " + AnomalyListActivity.this.deceasedCount);
                textView2.setText(AnomalyListActivity.this.getString(R.string.eightyFivePlus) + " - " + AnomalyListActivity.this.eightyFivePlusCount);
                textView3.setVisibility(8);
                textView4.setText(AnomalyListActivity.this.getString(R.string.total_document_upload_count) + StringUtils.SPACE + (AnomalyListActivity.this.deceasedCount + AnomalyListActivity.this.eightyFivePlusCount));
                new AlertDialog.Builder(AnomalyListActivity.this).setTitle(AnomalyListActivity.this.getString(R.string.asd_count)).setView(viewInflate2).setPositiveButton(AnomalyListActivity.this.getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });
        this.textView5.setText("v" + this.commomUtility.appversion);
        this.textView3.setText(getResources().getString(R.string.anomaly));
        this.listArray = getResources().getStringArray(R.array.asd_options);
        this.efOptionList = new ArrayList(Arrays.asList(this.listArray));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, android.R.layout.simple_spinner_item, this.efOptionList);
        this.adapterSpinner = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter((SpinnerAdapter) this.adapterSpinner);
        this.spinner.setSelection(0);
        this.spinner.setOnItemSelectedListener(this);
        if (this.deceasedCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(1));
            String str = getString(R.string.deceased) + " - " + this.deceasedCount;
            this.efOptionList.add(1, str);
            this.efOptionList.set(1, str);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.eightyFivePlusCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(2));
            this.efOptionList.add(2, getString(R.string.eightyFivePlus) + " -" + this.eightyFivePlusCount);
            this.adapterSpinner.notifyDataSetChanged();
        }
        this.takephoto = getString(R.string.takePhotoMsg);
        this.cancel = getString(R.string.cancelMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void cameraPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.CAMERA") == 0) {
            initScanner();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, REQUEST_CODE_CAMERA_PORTRAIT);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initScanner() {
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(CaptureActivityPortrait.class);
        intentIntegrator.initiateScan();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            showToast("Camera permission cancelled!");
        } else if (requestCode == REQUEST_CODE_CAMERA_PORTRAIT) {
            initScanner();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$0(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$0(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    private void initClickListener() {
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
        this.scanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnomalyListActivity.this.cameraPermission();
            }
        });
        this.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnomalyListActivity.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getVerifyCitizenFormList() {
        this.commomUtility.getAnomalyList(this, this.token, this.atkband, this.rtkband, this.state, this.acNo, this.partNo, "", new AnomalyListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.4
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.AnomalyListCallback
            public void onCallBack(int code, List<VerifyPayload> datalist, String message) {
                if (code == 200) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                    if (datalist != null && datalist.size() > 0) {
                        if (AnomalyListActivity.this.formlist != null && AnomalyListActivity.this.formlist.size() > 0) {
                            AnomalyListActivity.this.formlist.clear();
                        }
                        AnomalyListActivity.this.formlist = datalist;
                        AnomalyListActivity.this.verifyCitizenListAdapter = new AnomalyListAdapter(AnomalyListActivity.this.formlist, AnomalyListActivity.this, new AnomalyItemClickCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.4.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.AnomalyItemClickCallback
                            public void onClicked(VerifyPayload formverificationPayload, String type) {
                                AnomalyListActivity.this.getAnomalyDetails(formverificationPayload, Integer.parseInt(type));
                            }
                        });
                        AnomalyListActivity.this.recyclerView.setAdapter(AnomalyListActivity.this.verifyCitizenListAdapter);
                        AnomalyListActivity.this.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.4.2
                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                String string = editable.toString();
                                ArrayList<VerifyPayload> arrayList = new ArrayList<>();
                                for (VerifyPayload verifyPayload : AnomalyListActivity.this.formlist) {
                                    if (!TextUtils.isEmpty(String.valueOf(verifyPayload.getPartSerialNo())) && String.valueOf(verifyPayload.getPartSerialNo()).toLowerCase().equals(string.toLowerCase())) {
                                        if (arrayList.size() > 0) {
                                            arrayList.clear();
                                        }
                                        arrayList.add(verifyPayload);
                                        break;
                                    } else if ((!TextUtils.isEmpty(verifyPayload.getEpicNo()) && verifyPayload.getEpicNo().toLowerCase().contains(string.toLowerCase())) || ((!TextUtils.isEmpty(String.valueOf(verifyPayload.getPartSerialNo())) && String.valueOf(verifyPayload.getPartSerialNo()).toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(verifyPayload.getEpicName())) && String.valueOf(verifyPayload.getEpicName()).toLowerCase().contains(string.toLowerCase())))) {
                                        arrayList.add(verifyPayload);
                                    }
                                }
                                AnomalyListActivity.this.verifyCitizenListAdapter.fun(arrayList);
                            }
                        });
                        return;
                    }
                    AnomalyListActivity.this.alertDialog.dismiss();
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    Utils utils = AnomalyListActivity.this.utils;
                    ?? r4 = AnomalyListActivity.this;
                    utils.infoDialog(r4, r4.getResources().getString(R.string.alertMsg), message);
                    return;
                }
                AnomalyListActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = AnomalyListActivity.this.utils;
                ?? r5 = AnomalyListActivity.this;
                utils2.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("restart", false)) {
            recreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$2(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$2(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$3(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$3(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) FormTypes.class);
        intent.setFlags(603979776);
        intent.putExtra("restart", true);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void noActionRequired(VerifyPayload efPayload, final int pos, final Dialog dialog) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        map2.put("epicId", efPayload.getEpicId());
        map2.put("state", this.state);
        map2.put("epicNo", efPayload.getEpicNo());
        Call<AsdActionrRoot> callUpdateAnomalyNoAction = this.service.updateAnomalyNoAction(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        callUpdateAnomalyNoAction.enqueue(new Callback<AsdActionrRoot>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.5
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    try {
                        Utils utils = AnomalyListActivity.this.utils;
                        ?? r0 = AnomalyListActivity.this;
                        utils.infoDialogAction(r0, r0.getResources().getString(R.string.info), TextUtils.isEmpty(((AsdActionrRoot) response.body()).getMessage()) ? "" : ((AsdActionrRoot) response.body()).getMessage(), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.5.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                if (dialog != null) {
                                    dialog.dismiss();
                                }
                                AnomalyListActivity.this.formlist.remove(pos);
                                AnomalyListActivity.this.verifyCitizenListAdapter.notifyItemRemoved(pos);
                            }
                        });
                        return;
                    } catch (Exception unused) {
                        if (AnomalyListActivity.this.alertDialog != null) {
                            AnomalyListActivity.this.alertDialog.dismiss();
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    AnomalyListActivity.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException unused2) {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<AsdActionrRoot> call, Throwable t) {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                Logger.e("efCount", t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAnomalyDetails(VerifyPayload verifyPayload, int pos) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("acNo", this.acNo);
        map2.put("partNo", this.partNo);
        map2.put("state", this.state);
        map2.put("epicId", verifyPayload.getEpicId());
        map2.put("epicNo", verifyPayload.getEpicNo());
        Call<AnomalyDetailsRoot> anomalyByEpicIdV2 = this.service.getAnomalyByEpicIdV2(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        anomalyByEpicIdV2.enqueue(new AnonymousClass6(verifyPayload, pos));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<AnomalyDetailsRoot> {
        final /* synthetic */ int val$pos;
        final /* synthetic */ VerifyPayload val$verifyPayload;

        AnonymousClass6(final VerifyPayload val$verifyPayload, final int val$pos) {
            this.val$verifyPayload = val$verifyPayload;
            this.val$pos = val$pos;
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
        public void onResponse(Call<AnomalyDetailsRoot> call, Response<AnomalyDetailsRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    AnomalyListActivity.this.alertDialog.dismiss();
                    if (((AnomalyDetailsRoot) response.body()).getPayload().size() > 0) {
                        if (AnomalyListActivity.this.anomalydetailsList != null && AnomalyListActivity.this.anomalydetailsList.size() > 0) {
                            AnomalyListActivity.this.anomalydetailsList.clear();
                        }
                        AnomalyListActivity.this.anomalydetailsList = ((AnomalyDetailsRoot) response.body()).getPayload();
                        AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                        anomalyListActivity.AnomalyDetailsDialog(anomalyListActivity.anomalydetailsList, this.val$verifyPayload, this.val$pos);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    Logger.d("Exception in getAnomalyDetails", e.toString());
                    AnomalyListActivity.this.alertDialog.dismiss();
                    return;
                }
            }
            if (response.code() == 401) {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                AnomalyListActivity.this.commomUtility.showMessageOK(AnomalyListActivity.this, AnomalyListActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                AnomalyListActivity.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                Logger.e(AnomalyListActivity.this.TAG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setLocaleBool(false);
            AnomalyListActivity.this.startActivity(new Intent(AnomalyListActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<AnomalyDetailsRoot> call, Throwable t) {
            if (AnomalyListActivity.this.alertDialog != null) {
                AnomalyListActivity.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void AnomalyDetailsDialog(ArrayList<AnomalyDetailsPayload> clusterDetails, final VerifyPayload verifyPayload, final int pos) {
        this.relativeDocument1UrlS = "";
        this.relativeDocument2UrlS = "";
        this.relativeSupportingDocumentPage1UrlS = "";
        this.relativeSupportingDocumentPage2UrlS = "";
        this.bloletter = "";
        this.doc5Page1Url = "";
        this.doc5Page2URL = "";
        this.parentSpinner2ImageUrl = "";
        this.parentSpinner2ImageUrl1 = "";
        this.grandParentSpinner2ImageUrl = "";
        this.grandParentSpinner2ImageUrl1 = "";
        this.docIdParent = 0;
        this.docIdParent1 = 0;
        this.docIdParent2 = 0;
        this.docIdParent3 = 0;
        this.docIdGrandParent = 0;
        this.docIdGrandParent1 = 0;
        this.doc3IdGranprent = 0;
        this.doc4IdGrandParent = 0;
        this.parentDoc3Page1ImageUrl = null;
        this.parentDoc3Page2ImageUrl = null;
        this.parentDoc4Page1ImageUrl = null;
        this.parentDoc4Page2ImageUrl = null;
        this.grandParentDoc3Page1Url = null;
        this.grandParentDoc3Page2Url = null;
        this.grandParentDoc4Page1Url = null;
        this.grandParentDoc4Page2Url = null;
        this.StateList = SharedPref.getInstance(this).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateNameList = SharedPref.getInstance(this).getAcListName(Constants.STATE_LIST_NAME);
        this.epic = verifyPayload.getEpicNo();
        SharedPref.getInstance(this).setepicid("");
        SharedPref.getInstance(this).setepicid(this.epic);
        AnomalyDetailsPayload anomalyDetailsPayload = clusterDetails.get(0);
        final Dialog dialog = new Dialog(this);
        AnomalyDetailsDialogBinding anomalyDetailsDialogBindingInflate = AnomalyDetailsDialogBinding.inflate(getLayoutInflater());
        this.binding = anomalyDetailsDialogBindingInflate;
        dialog.setContentView(anomalyDetailsDialogBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        if (!TextUtils.isEmpty(anomalyDetailsPayload.getRelationOldStateCd()) && !TextUtils.isEmpty(anomalyDetailsPayload.getRelationOldAcNo()) && !TextUtils.isEmpty(anomalyDetailsPayload.getRelationOldPartNo())) {
            searchDetails(anomalyDetailsPayload.getRelationOldStateCd(), anomalyDetailsPayload.getRelationOldAcNo(), anomalyDetailsPayload.getRelationOldPartNo(), anomalyDetailsPayload.getRelationOldPslNo());
        } else {
            this.binding.cardDetails.setVisibility(8);
        }
        if (verifyPayload.getCategoryType().equalsIgnoreCase("Self")) {
            this.binding.grandparent.grandparentLablel.setText(getResources().getString(R.string.grandparent_nonmandatory));
        } else if ((!verifyPayload.getCategoryType().equalsIgnoreCase("Progeny") || TextUtils.isEmpty(verifyPayload.getRelationType()) || (!verifyPayload.getRelationType().equalsIgnoreCase("FTHR") && !verifyPayload.getRelationType().equalsIgnoreCase("MTHR"))) && verifyPayload.getCategoryType().equalsIgnoreCase("Progeny") && !TextUtils.isEmpty(verifyPayload.getRelationType()) && (verifyPayload.getRelationType().equalsIgnoreCase("GFTH") || verifyPayload.getRelationType().equalsIgnoreCase("GMTH"))) {
            String string = getString(R.string.grandparent_mandatory_plain);
            SpannableString spannableString = new SpannableString(string);
            int iLastIndexOf = string.lastIndexOf(42);
            if (iLastIndexOf != -1) {
                spannableString.setSpan(new ForegroundColorSpan(-65536), iLastIndexOf, iLastIndexOf + 1, 33);
            }
            this.binding.grandparent.grandparentLablel.setText(spannableString);
        } else {
            this.binding.grandparent.grandparentLablel.setText(getResources().getString(R.string.grandparent_nonmandatory));
        }
        if (!TextUtils.isEmpty(anomalyDetailsPayload.getWrongCate()) && anomalyDetailsPayload.getWrongCate().equalsIgnoreCase("N") && !TextUtils.isEmpty(anomalyDetailsPayload.getRelativeAgeIssue()) && anomalyDetailsPayload.getRelativeAgeIssue().equalsIgnoreCase("N") && !TextUtils.isEmpty(anomalyDetailsPayload.getParentNameMismatch()) && anomalyDetailsPayload.getParentNameMismatch().equalsIgnoreCase("N") && !TextUtils.isEmpty(anomalyDetailsPayload.getProgLimitExceed()) && anomalyDetailsPayload.getProgLimitExceed().equalsIgnoreCase("N") && !TextUtils.isEmpty(anomalyDetailsPayload.getMappedMultiGender()) && anomalyDetailsPayload.getMappedMultiGender().equalsIgnoreCase("N") && !TextUtils.isEmpty(anomalyDetailsPayload.getSelfNameVariation()) && anomalyDetailsPayload.getSelfNameVariation().equalsIgnoreCase("N") && !TextUtils.isEmpty(anomalyDetailsPayload.getSirParentWithAnomaly()) && anomalyDetailsPayload.getSirParentWithAnomaly().equalsIgnoreCase("N") && !TextUtils.isEmpty(anomalyDetailsPayload.getSelfFNameAnomaly()) && anomalyDetailsPayload.getSelfFNameAnomaly().equalsIgnoreCase("N") && !TextUtils.isEmpty(anomalyDetailsPayload.getProgenyAge9M()) && anomalyDetailsPayload.getProgenyAge9M().equalsIgnoreCase("N")) {
            this.binding.lvWrongCate.setVisibility(8);
            this.binding.lvSelfname.setVisibility(8);
            this.binding.lvRelativeAgeIssue.setVisibility(8);
            this.binding.lvParentNameMismatch.setVisibility(8);
            this.binding.lvMappedMultiGender.setVisibility(8);
            this.binding.lvProgenyexist.setVisibility(8);
            this.binding.updateImage.setVisibility(8);
            this.binding.verifiedCheckBox.setVisibility(8);
            this.binding.lvUploaddoc.setVisibility(8);
            this.binding.lvParent.setVisibility(8);
            this.binding.grandparent.lvGrandparent.setVisibility(8);
            this.binding.lvBloletter.setVisibility(8);
            this.binding.lvSirparentWithAnomaly.setVisibility(8);
            this.binding.lvSelfnameanomaly.setVisibility(8);
            this.binding.lvProgenyAge9m.setVisibility(8);
        } else {
            this.binding.lvParent.setVisibility(0);
            this.binding.grandparent.lvGrandparent.setVisibility(0);
            this.binding.updateImage.setVisibility(0);
            this.binding.verifiedCheckBox.setVisibility(0);
            this.binding.lvUploaddoc.setVisibility(0);
            this.binding.lvBloletter.setVisibility(0);
            if (!TextUtils.isEmpty(anomalyDetailsPayload.getWrongCate()) && anomalyDetailsPayload.getWrongCate().equalsIgnoreCase("N")) {
                this.binding.lvWrongCate.setVisibility(8);
            } else {
                this.binding.lvWrongCate.setVisibility(0);
                this.binding.tvWrongCate.setText("• " + anomalyDetailsPayload.getWrongCate());
            }
            if (!TextUtils.isEmpty(anomalyDetailsPayload.getRelativeAgeIssue()) && anomalyDetailsPayload.getRelativeAgeIssue().equalsIgnoreCase("N")) {
                this.binding.lvRelativeAgeIssue.setVisibility(8);
            } else {
                this.binding.lvRelativeAgeIssue.setVisibility(0);
                this.binding.tvRelativeAgeIssue.setText("• " + anomalyDetailsPayload.getRelativeAgeIssue());
            }
            if (!TextUtils.isEmpty(anomalyDetailsPayload.getParentNameMismatch()) && anomalyDetailsPayload.getParentNameMismatch().equalsIgnoreCase("N")) {
                this.binding.lvParentNameMismatch.setVisibility(8);
            } else {
                this.binding.lvParentNameMismatch.setVisibility(0);
                this.binding.tvParentNameMismatch.setText("• " + anomalyDetailsPayload.getParentNameMismatch());
            }
            if (!TextUtils.isEmpty(anomalyDetailsPayload.getMappedMultiGender()) && anomalyDetailsPayload.getMappedMultiGender().equalsIgnoreCase("N")) {
                this.binding.lvMappedMultiGender.setVisibility(8);
            } else {
                this.binding.lvMappedMultiGender.setVisibility(0);
                this.binding.tvMappedMultiGender.setText("• " + anomalyDetailsPayload.getMappedMultiGender());
            }
            if (!TextUtils.isEmpty(anomalyDetailsPayload.getProgLimitExceed()) && anomalyDetailsPayload.getProgLimitExceed().equalsIgnoreCase("N")) {
                this.binding.lvProgenyexist.setVisibility(8);
            } else {
                this.binding.lvProgenyexist.setVisibility(0);
                this.binding.tvProgenyexist.setText("• " + anomalyDetailsPayload.getProgLimitExceed());
            }
            if (!TextUtils.isEmpty(anomalyDetailsPayload.getSelfNameVariation()) && anomalyDetailsPayload.getSelfNameVariation().equalsIgnoreCase("N")) {
                this.binding.lvSelfname.setVisibility(8);
            } else {
                this.binding.lvSelfname.setVisibility(0);
                this.binding.tvSelfname.setText("• " + anomalyDetailsPayload.getSelfNameVariation());
            }
            if (!TextUtils.isEmpty(anomalyDetailsPayload.getSirParentWithAnomaly()) && anomalyDetailsPayload.getSirParentWithAnomaly().equalsIgnoreCase("N")) {
                this.binding.lvSirparentWithAnomaly.setVisibility(8);
            } else {
                this.binding.lvSirparentWithAnomaly.setVisibility(0);
                this.binding.tvSirparentWithAnomaly.setText("• " + anomalyDetailsPayload.getSirParentWithAnomaly());
            }
            if (!TextUtils.isEmpty(anomalyDetailsPayload.getSelfFNameAnomaly()) && anomalyDetailsPayload.getSelfFNameAnomaly().equalsIgnoreCase("N")) {
                this.binding.lvSelfnameanomaly.setVisibility(8);
            } else {
                this.binding.lvSelfnameanomaly.setVisibility(0);
                this.binding.tvSelfnameanomaly.setText("• " + anomalyDetailsPayload.getSelfFNameAnomaly());
            }
            if (!TextUtils.isEmpty(anomalyDetailsPayload.getProgenyAge9M()) && anomalyDetailsPayload.getProgenyAge9M().equalsIgnoreCase("N")) {
                this.binding.lvProgenyAge9m.setVisibility(8);
            } else {
                this.binding.lvProgenyAge9m.setVisibility(0);
                this.binding.tvProgenyAge9m.setText("• " + anomalyDetailsPayload.getProgenyAge9M());
            }
        }
        if (verifyPayload.getCategoryType().equalsIgnoreCase("Self")) {
            this.binding.grandparent.grandparentLablel.setText(getResources().getString(R.string.grandparent_nonmandatory));
            this.binding.lvParent.setVisibility(8);
            this.binding.grandparent.lvGrandparent.setVisibility(8);
            this.binding.lvUploaddoc.setVisibility(0);
            this.binding.lvBloletter.setVisibility(0);
        } else if ((!verifyPayload.getCategoryType().equalsIgnoreCase("Progeny") || TextUtils.isEmpty(verifyPayload.getRelationType()) || (!verifyPayload.getRelationType().equalsIgnoreCase("FTHR") && !verifyPayload.getRelationType().equalsIgnoreCase("MTHR"))) && verifyPayload.getCategoryType().equalsIgnoreCase("Progeny") && !TextUtils.isEmpty(verifyPayload.getRelationType()) && (verifyPayload.getRelationType().equalsIgnoreCase("GFTH") || verifyPayload.getRelationType().equalsIgnoreCase("GMTH"))) {
            String string2 = getString(R.string.grandparent_mandatory_plain);
            SpannableString spannableString2 = new SpannableString(string2);
            int iLastIndexOf2 = string2.lastIndexOf(42);
            if (iLastIndexOf2 != -1) {
                spannableString2.setSpan(new ForegroundColorSpan(-65536), iLastIndexOf2, iLastIndexOf2 + 1, 33);
            }
            this.binding.grandparent.grandparentLablel.setText(spannableString2);
        } else {
            this.binding.grandparent.grandparentLablel.setText(getResources().getString(R.string.grandparent_nonmandatory));
        }
        initializeSpinnerTouch();
        getDocType();
        this.binding.documentSpinnerParent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.7
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (AnomalyListActivity.this.isUserSelected && position == 0) {
                    AnomalyListActivity.this.isUserSelected = false;
                    AnomalyListActivity.this.docIdParent = 0;
                    AnomalyListActivity.this.deletePhoto(101);
                    AnomalyListActivity.this.deletePhoto(102);
                    return;
                }
                if (AnomalyListActivity.this.isUserSelected) {
                    AnomalyListActivity.this.docIdParent = 0;
                    AnomalyListActivity.this.deletePhoto(101);
                    AnomalyListActivity.this.deletePhoto(102);
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.docIdParent = anomalyListActivity.docCodeist.get(position).intValue();
                    AnomalyListActivity.this.isUserSelected = false;
                }
            }
        });
        this.binding.documentSpinner2Parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (AnomalyListActivity.this.isUserSelected && position == 0) {
                    AnomalyListActivity.this.isUserSelected = false;
                    AnomalyListActivity.this.docIdParent1 = 0;
                    AnomalyListActivity.this.deletePhoto(113);
                    AnomalyListActivity.this.deletePhoto(114);
                    return;
                }
                if (AnomalyListActivity.this.isUserSelected) {
                    AnomalyListActivity.this.docIdParent1 = 0;
                    AnomalyListActivity.this.deletePhoto(113);
                    AnomalyListActivity.this.deletePhoto(114);
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.docIdParent1 = anomalyListActivity.docCodeist.get(position).intValue();
                    AnomalyListActivity.this.isUserSelected = false;
                }
            }
        });
        this.binding.documentSpinner3Parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (AnomalyListActivity.this.isUserSelected && position == 0) {
                    AnomalyListActivity.this.isUserSelected = false;
                    AnomalyListActivity.this.docIdParent2 = 0;
                    AnomalyListActivity.this.deletePhoto(133);
                    AnomalyListActivity.this.deletePhoto(134);
                    AnomalyListActivity.this.binding.documentSpinner3Parent.setSelection(0);
                    return;
                }
                if (AnomalyListActivity.this.isUserSelected) {
                    AnomalyListActivity.this.docIdParent2 = 0;
                    AnomalyListActivity.this.deletePhoto(133);
                    AnomalyListActivity.this.deletePhoto(134);
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.docIdParent2 = anomalyListActivity.docCodeist.get(position).intValue();
                    AnomalyListActivity.this.isUserSelected = false;
                }
            }
        });
        this.binding.documentSpinner4Parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (AnomalyListActivity.this.isUserSelected && position == 0) {
                    AnomalyListActivity.this.isUserSelected = false;
                    AnomalyListActivity.this.docIdParent3 = 0;
                    AnomalyListActivity.this.deletePhoto(135);
                    AnomalyListActivity.this.deletePhoto(136);
                    AnomalyListActivity.this.binding.documentSpinner4Parent.setSelection(0);
                    return;
                }
                if (AnomalyListActivity.this.isUserSelected) {
                    AnomalyListActivity.this.docIdParent3 = 0;
                    AnomalyListActivity.this.deletePhoto(135);
                    AnomalyListActivity.this.deletePhoto(136);
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.docIdParent3 = anomalyListActivity.docCodeist.get(position).intValue();
                    AnomalyListActivity.this.isUserSelected = false;
                }
            }
        });
        this.binding.grandparent.documentSpinnerGrandParent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.11
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (AnomalyListActivity.this.isUserSelected && position == 0) {
                    AnomalyListActivity.this.docIdGrandParent = 0;
                    AnomalyListActivity.this.deletePhoto(103);
                    AnomalyListActivity.this.deletePhoto(104);
                    AnomalyListActivity.this.isUserSelected = false;
                    return;
                }
                if (AnomalyListActivity.this.isUserSelected) {
                    AnomalyListActivity.this.docIdGrandParent = 0;
                    AnomalyListActivity.this.deletePhoto(103);
                    AnomalyListActivity.this.deletePhoto(104);
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.docIdGrandParent = anomalyListActivity.docCodeist.get(position).intValue();
                    AnomalyListActivity.this.isUserSelected = false;
                }
            }
        });
        this.binding.grandparent.documentSpinner2GrandParent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.12
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (AnomalyListActivity.this.isUserSelected && position == 0) {
                    AnomalyListActivity.this.isUserSelected = false;
                    AnomalyListActivity.this.docIdGrandParent1 = 0;
                    AnomalyListActivity.this.deletePhoto(115);
                    AnomalyListActivity.this.deletePhoto(116);
                    return;
                }
                if (AnomalyListActivity.this.isUserSelected) {
                    AnomalyListActivity.this.docIdGrandParent1 = 0;
                    AnomalyListActivity.this.deletePhoto(115);
                    AnomalyListActivity.this.deletePhoto(116);
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.docIdGrandParent1 = anomalyListActivity.docCodeist.get(position).intValue();
                    AnomalyListActivity.this.isUserSelected = false;
                }
            }
        });
        this.binding.grandparent.doc3documentSpinner2GrandParent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.13
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (AnomalyListActivity.this.isUserSelected && position == 0) {
                    AnomalyListActivity.this.isUserSelected = false;
                    AnomalyListActivity.this.doc3IdGranprent = 0;
                    AnomalyListActivity.this.deletePhoto(137);
                    AnomalyListActivity.this.deletePhoto(138);
                    return;
                }
                if (AnomalyListActivity.this.isUserSelected) {
                    AnomalyListActivity.this.doc3IdGranprent = 0;
                    AnomalyListActivity.this.deletePhoto(137);
                    AnomalyListActivity.this.deletePhoto(138);
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.doc3IdGranprent = anomalyListActivity.docCodeist.get(position).intValue();
                    AnomalyListActivity.this.isUserSelected = false;
                }
            }
        });
        this.binding.grandparent.doc4documentSpinner2GrandParent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.14
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (AnomalyListActivity.this.isUserSelected && position == 0) {
                    AnomalyListActivity.this.isUserSelected = false;
                    AnomalyListActivity.this.doc4IdGrandParent = 0;
                    AnomalyListActivity.this.deletePhoto(139);
                    AnomalyListActivity.this.deletePhoto(140);
                    return;
                }
                if (AnomalyListActivity.this.isUserSelected) {
                    AnomalyListActivity.this.doc4IdGrandParent = 0;
                    AnomalyListActivity.this.deletePhoto(139);
                    AnomalyListActivity.this.deletePhoto(140);
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.doc4IdGrandParent = anomalyListActivity.docCodeist.get(position).intValue();
                    AnomalyListActivity.this.isUserSelected = false;
                }
            }
        });
        this.binding.uncollectablePendingSir.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SharedPref.getInstance(AnomalyListActivity.this).setepicid("");
                dialog.dismiss();
                Intent intent = new Intent((Context) AnomalyListActivity.this, (Class<?>) VerifyEditActivity.class);
                intent.putExtra("data", verifyPayload);
                intent.putExtra("from", "anomalylist");
                AnomalyListActivity.this.startActivity(intent);
            }
        });
        this.binding.fillPendingSir.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.16
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnomalyListActivity.this.utils.decisionDialog(AnomalyListActivity.this, "Confirmation", "Are you sure do you want to verify ?", "Yes", "No", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.16.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onNegativeButtonClicked() {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onPositiveButtonClicked() {
                        AnomalyListActivity.this.noActionRequired(verifyPayload, pos, dialog);
                    }
                });
            }
        });
        this.binding.ivCancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnomalyListActivity.this.bloletter = "";
                AnomalyListActivity.this.relativeDocument1UrlS = "";
                AnomalyListActivity.this.relativeDocument2UrlS = "";
                AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS = "";
                AnomalyListActivity.this.relativeSupportingDocumentPage2UrlS = "";
                AnomalyListActivity.this.doc5Page1Url = "";
                AnomalyListActivity.this.doc5Page2URL = "";
                SharedPref.getInstance(AnomalyListActivity.this).setepicid("");
                dialog.dismiss();
            }
        });
        this.binding.uploadEnumerationFormPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.docIdParent == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else {
                    AnomalyListActivity.this.pickPhoto(101, "enFormPage1", verifyPayload.epicNo);
                }
            }
        });
        this.binding.grandparent.uploadGpSpinner1Page1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.docIdGrandParent1 == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else {
                    AnomalyListActivity.this.pickPhoto(115, "grandParentspinner1Page1", verifyPayload.epicNo);
                }
            }
        });
        this.binding.uploadEnumerationFormPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.docIdParent == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else if (TextUtils.isEmpty(AnomalyListActivity.this.relativeDocument1UrlS)) {
                    AnomalyListActivity anomalyListActivity2 = AnomalyListActivity.this;
                    anomalyListActivity2.showDialog1(anomalyListActivity2.alertText, "Please Upload front Page ");
                } else {
                    AnomalyListActivity.this.pickPhoto(102, "enFormPage2", verifyPayload.epicNo);
                }
            }
        });
        this.binding.grandparent.doc3uploadGpSpinner1Page1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.doc3IdGranprent == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else {
                    AnomalyListActivity.this.pickPhoto(137, "grandParentDoc3Page1", verifyPayload.epicNo);
                }
            }
        });
        this.binding.grandparent.doc3uploadGPSpinner1Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.doc3IdGranprent == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else if (TextUtils.isEmpty(AnomalyListActivity.this.grandParentDoc3Page1Url)) {
                    AnomalyListActivity anomalyListActivity2 = AnomalyListActivity.this;
                    anomalyListActivity2.showDialog1(anomalyListActivity2.alertText, "Please Upload front Page ");
                } else {
                    AnomalyListActivity.this.pickPhoto(138, "grandParentDoc3Page2", verifyPayload.epicNo);
                }
            }
        });
        this.binding.grandparent.doc4uploadGpSpinner1Page1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.doc4IdGrandParent == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else {
                    AnomalyListActivity.this.pickPhoto(139, "grandParentDoc4Page1", verifyPayload.epicNo);
                }
            }
        });
        this.binding.grandparent.doc4uploadGPSpinner1Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.doc4IdGrandParent == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else if (TextUtils.isEmpty(AnomalyListActivity.this.grandParentDoc4Page1Url)) {
                    AnomalyListActivity anomalyListActivity2 = AnomalyListActivity.this;
                    anomalyListActivity2.showDialog1(anomalyListActivity2.alertText, "Please Upload front Page ");
                } else {
                    AnomalyListActivity.this.pickPhoto(140, "grandParentDoc4Page2", verifyPayload.epicNo);
                }
            }
        });
        this.binding.uploadspinner1Page1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.docIdParent1 == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else {
                    AnomalyListActivity.this.pickPhoto(113, "parentspinner1Page1", verifyPayload.epicNo);
                }
            }
        });
        this.binding.uploadspinner1Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.docIdParent1 == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else if (TextUtils.isEmpty(AnomalyListActivity.this.parentSpinner2ImageUrl)) {
                    AnomalyListActivity anomalyListActivity2 = AnomalyListActivity.this;
                    anomalyListActivity2.showDialog1(anomalyListActivity2.alertText, "Please Upload front Page ");
                } else {
                    AnomalyListActivity.this.pickPhoto(114, "parentspinner1Page2", verifyPayload.epicNo);
                }
            }
        });
        this.binding.uploadspinner1Doc3Page1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.docIdParent2 == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else {
                    AnomalyListActivity.this.pickPhoto(133, "parentDoc3Page1ImageUrl", verifyPayload.epicNo);
                }
            }
        });
        this.binding.Doc3uploadspinner1Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.docIdParent2 == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else if (TextUtils.isEmpty(AnomalyListActivity.this.parentDoc3Page1ImageUrl)) {
                    AnomalyListActivity anomalyListActivity2 = AnomalyListActivity.this;
                    anomalyListActivity2.showDialog1(anomalyListActivity2.alertText, "Please Upload front Page ");
                } else {
                    AnomalyListActivity.this.pickPhoto(134, "parentDoc3Page2ImageUrl", verifyPayload.epicNo);
                }
            }
        });
        this.binding.uploadspinner1Doc4Page1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.docIdParent3 == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else {
                    AnomalyListActivity.this.pickPhoto(135, "parentDoc4Page1ImageUrl", verifyPayload.epicNo);
                }
            }
        });
        this.binding.Doc4uploadspinner1Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.docIdParent3 == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else if (TextUtils.isEmpty(AnomalyListActivity.this.parentDoc4Page1ImageUrl)) {
                    AnomalyListActivity anomalyListActivity2 = AnomalyListActivity.this;
                    anomalyListActivity2.showDialog1(anomalyListActivity2.alertText, "Please Upload front Page ");
                } else {
                    AnomalyListActivity.this.pickPhoto(136, "parentDoc4Page2ImageUrl", verifyPayload.epicNo);
                }
            }
        });
        this.binding.grandparent.uploadGPSpinner1Page2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AnomalyListActivity.this.docIdGrandParent1 == 0) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please select document type");
                } else if (TextUtils.isEmpty(AnomalyListActivity.this.grandParentSpinner2ImageUrl)) {
                    AnomalyListActivity anomalyListActivity2 = AnomalyListActivity.this;
                    anomalyListActivity2.showDialog1(anomalyListActivity2.alertText, "Please Upload front Page ");
                } else {
                    AnomalyListActivity.this.pickPhoto(116, "grandParentspinner1Page2", verifyPayload.epicNo);
                }
            }
        });
        this.binding.grandparent.uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AnomalyListActivity.this.pickPhoto(103, "sDPage1", verifyPayload.epicNo);
            }
        });
        this.binding.grandparent.uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS)) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please Upload front Page ");
                } else {
                    AnomalyListActivity.this.pickPhoto(104, "sDPage2", verifyPayload.epicNo);
                }
            }
        });
        this.binding.doc5uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnomalyListActivity.this.pickPhoto(109, "doc5Page1", verifyPayload.getEpicNo());
            }
        });
        this.binding.doc5uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.35
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(AnomalyListActivity.this.doc5Page1Url)) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please upload front side of the selected document");
                } else {
                    AnomalyListActivity.this.pickPhoto(110, "doc5Page2", verifyPayload.getEpicNo());
                }
            }
        });
        this.binding.doc6uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnomalyListActivity.this.pickPhoto(111, "doc6Page1", verifyPayload.getEpicNo());
            }
        });
        this.binding.doc6uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.37
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(AnomalyListActivity.this.doc6Page1Url)) {
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.showDialog1(anomalyListActivity.alertText, "Please upload front side of the Any other Document (Relationship proof with parents/Grandparents etc.)");
                } else {
                    AnomalyListActivity.this.pickPhoto(112, "doc6Page2", verifyPayload.getEpicNo());
                }
            }
        });
        this.binding.yesSelectLayout.setVisibility(0);
        this.binding.updateImage.setEnabled(false);
        this.binding.layoutCapturePhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnomalyListActivity.this.pickPhoto(105, "bloletter", verifyPayload.epicNo);
            }
        });
        this.binding.ivdelete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnomalyListActivity.this.deletePhoto(105);
            }
        });
        this.binding.cancelEnumerationFormPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$4(view);
            }
        });
        this.binding.cancelEnumerationFormPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$5(view);
            }
        });
        this.binding.grandparent.cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$6(view);
            }
        });
        this.binding.grandparent.cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$7(view);
            }
        });
        this.binding.doc5cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$8(view);
            }
        });
        this.binding.doc5cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$9(view);
            }
        });
        this.binding.doc6cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$10(view);
            }
        });
        this.binding.doc6cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$11(view);
            }
        });
        this.binding.cancelparentSpinner1Page1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$12(view);
            }
        });
        this.binding.cancelparentSpinner1Page2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$13(view);
            }
        });
        this.binding.grandparent.cancelgrandParentSpinner1Page1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$14(view);
            }
        });
        this.binding.grandparent.cancelgrandParentSpinner1Page2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$15(view);
            }
        });
        this.binding.cancelDoc3parentSpinner1Page1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$16(view);
            }
        });
        this.binding.cancelparentDoc3Spinner1Page2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$17(view);
            }
        });
        this.binding.cancelDoc4parentSpinner1Page1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$18(view);
            }
        });
        this.binding.cancelparentDoc4Spinner1Page2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$19(view);
            }
        });
        this.binding.grandparent.doc3cancelgrandParentSpinner1Page1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$20(view);
            }
        });
        this.binding.grandparent.doc3cancelgrandParentSpinner1Page2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$21(view);
            }
        });
        this.binding.grandparent.doc4cancelgrandParentSpinner1Page1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$22(view);
            }
        });
        this.binding.grandparent.doc4cancelgrandParentSpinner1Page2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$AnomalyDetailsDialog$23(view);
            }
        });
        this.binding.updateImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.40
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                boolean z;
                if (verifyPayload.getCategoryType().equalsIgnoreCase("Self")) {
                    if (TextUtils.isEmpty(AnomalyListActivity.this.doc5Page1Url)) {
                        AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please Upload extract of last SIR as per the mapping done below");
                        return;
                    }
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    VerifyPayload verifyPayload2 = verifyPayload;
                    anomalyListActivity.uploadDocuments(verifyPayload2, pos, dialog, verifyPayload2.getCategoryType(), AnomalyListActivity.this.relativeDocument1UrlS, AnomalyListActivity.this.relativeDocument2UrlS, AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS, AnomalyListActivity.this.relativeSupportingDocumentPage2UrlS, verifyPayload.getRelationType());
                    return;
                }
                boolean z2 = false;
                String[] strArr = {String.valueOf(AnomalyListActivity.this.docIdParent), String.valueOf(AnomalyListActivity.this.docIdParent1), String.valueOf(AnomalyListActivity.this.docIdParent2), String.valueOf(AnomalyListActivity.this.docIdParent3)};
                int i = 0;
                while (true) {
                    if (i >= 4) {
                        z = false;
                        break;
                    }
                    String str = strArr[i];
                    if (!"0".equals(str) && !"12".equals(str)) {
                        z = true;
                        break;
                    }
                    i++;
                }
                String[] strArr2 = {String.valueOf(AnomalyListActivity.this.docIdGrandParent), String.valueOf(AnomalyListActivity.this.docIdGrandParent1), String.valueOf(AnomalyListActivity.this.doc3IdGranprent), String.valueOf(AnomalyListActivity.this.doc4IdGrandParent)};
                for (int i2 = 0; i2 < 4; i2++) {
                    String str2 = strArr2[i2];
                    if (!"0".equals(str2) && !"12".equals(str2)) {
                        z2 = true;
                        break;
                    }
                }
                if (TextUtils.isEmpty(AnomalyListActivity.this.doc5Page1Url)) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please Upload extract of last SIR as per the mapping done below");
                    return;
                }
                if (AnomalyListActivity.this.docIdParent == 0) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please select parent document type");
                    return;
                }
                if (TextUtils.isEmpty(AnomalyListActivity.this.relativeDocument1UrlS)) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (parents)");
                    return;
                }
                if (!z) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "At least one document type should be other than Aadhaar");
                    return;
                }
                if (AnomalyListActivity.this.docIdParent1 != 0 && TextUtils.isEmpty(AnomalyListActivity.this.parentSpinner2ImageUrl)) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (parents)");
                    return;
                }
                if (AnomalyListActivity.this.docIdParent2 != 0 && TextUtils.isEmpty(AnomalyListActivity.this.parentDoc3Page1ImageUrl)) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (parents)");
                    return;
                }
                if (AnomalyListActivity.this.docIdParent3 != 0 && TextUtils.isEmpty(AnomalyListActivity.this.parentDoc4Page1ImageUrl)) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (parents)");
                    return;
                }
                if (verifyPayload.getCategoryType().equalsIgnoreCase("Progeny") && !TextUtils.isEmpty(verifyPayload.getRelationType()) && ((verifyPayload.getRelationType().equalsIgnoreCase("GFTH") || verifyPayload.getRelationType().equalsIgnoreCase("GMTH")) && AnomalyListActivity.this.docIdGrandParent == 0)) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please select GrandParent document type");
                    return;
                }
                if (verifyPayload.getCategoryType().equalsIgnoreCase("Progeny") && !TextUtils.isEmpty(verifyPayload.getRelationType()) && ((verifyPayload.getRelationType().equalsIgnoreCase("GFTH") || verifyPayload.getRelationType().equalsIgnoreCase("GMTH")) && TextUtils.isEmpty(AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS))) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (Grand parents)");
                    return;
                }
                if (verifyPayload.getCategoryType().equalsIgnoreCase("Progeny") && !TextUtils.isEmpty(verifyPayload.getRelationType()) && ((verifyPayload.getRelationType().equalsIgnoreCase("GFTH") || verifyPayload.getRelationType().equalsIgnoreCase("GMTH")) && !z2)) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "At least one document type should be other than Aadhaar");
                    return;
                }
                if (verifyPayload.getCategoryType().equalsIgnoreCase("Progeny") && !TextUtils.isEmpty(verifyPayload.getRelationType()) && ((verifyPayload.getRelationType().equalsIgnoreCase("GFTH") || verifyPayload.getRelationType().equalsIgnoreCase("GMTH")) && AnomalyListActivity.this.docIdGrandParent1 != 0 && TextUtils.isEmpty(AnomalyListActivity.this.grandParentSpinner2ImageUrl))) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (Grand parents)");
                    return;
                }
                if (verifyPayload.getCategoryType().equalsIgnoreCase("Progeny") && !TextUtils.isEmpty(verifyPayload.getRelationType()) && ((verifyPayload.getRelationType().equalsIgnoreCase("GFTH") || verifyPayload.getRelationType().equalsIgnoreCase("GMTH")) && AnomalyListActivity.this.doc3IdGranprent != 0 && TextUtils.isEmpty(AnomalyListActivity.this.grandParentDoc3Page1Url))) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (Grand parents)");
                    return;
                }
                if (verifyPayload.getCategoryType().equalsIgnoreCase("Progeny") && !TextUtils.isEmpty(verifyPayload.getRelationType()) && ((verifyPayload.getRelationType().equalsIgnoreCase("GFTH") || verifyPayload.getRelationType().equalsIgnoreCase("GMTH")) && AnomalyListActivity.this.doc4IdGrandParent != 0 && TextUtils.isEmpty(AnomalyListActivity.this.grandParentDoc4Page1Url))) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (Grand parents)");
                    return;
                }
                if (AnomalyListActivity.this.docIdGrandParent != 0 && TextUtils.isEmpty(AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS)) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (Grand parents)");
                    return;
                }
                if (AnomalyListActivity.this.docIdGrandParent != 0 && TextUtils.isEmpty(AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS) && !z2) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "At least one document type should be other than Aadhaar");
                    return;
                }
                if (AnomalyListActivity.this.docIdGrandParent1 != 0 && TextUtils.isEmpty(AnomalyListActivity.this.grandParentSpinner2ImageUrl)) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (Grand parents)");
                    return;
                }
                if (AnomalyListActivity.this.doc3IdGranprent != 0 && TextUtils.isEmpty(AnomalyListActivity.this.grandParentDoc3Page1Url)) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (Grand parents)");
                    return;
                }
                if (AnomalyListActivity.this.doc4IdGrandParent != 0 && TextUtils.isEmpty(AnomalyListActivity.this.grandParentDoc4Page1Url)) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "Please upload proof of relationship (Grand parents)");
                    return;
                }
                if ((AnomalyListActivity.this.docIdGrandParent != 0 || AnomalyListActivity.this.docIdGrandParent1 != 0 || AnomalyListActivity.this.doc3IdGranprent != 0 || AnomalyListActivity.this.doc4IdGrandParent != 0) && !z2) {
                    AnomalyListActivity.this.utils.infoDialog(AnomalyListActivity.this, "Alert", "At least one document type should be other than Aadhaar");
                    return;
                }
                AnomalyListActivity anomalyListActivity2 = AnomalyListActivity.this;
                VerifyPayload verifyPayload3 = verifyPayload;
                anomalyListActivity2.uploadDocuments(verifyPayload3, pos, dialog, verifyPayload3.getCategoryType(), AnomalyListActivity.this.relativeDocument1UrlS, AnomalyListActivity.this.relativeDocument2UrlS, AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS, AnomalyListActivity.this.relativeSupportingDocumentPage2UrlS, verifyPayload.getRelationType());
            }
        });
        this.binding.verifiedCheckBox.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AnomalyListActivity.this.binding.verifiedCheckBox.isChecked()) {
                    AnomalyListActivity.this.binding.updateImage.setEnabled(true);
                } else {
                    AnomalyListActivity.this.binding.updateImage.setEnabled(false);
                }
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$4(View view) {
        deletePhoto(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$5(View view) {
        deletePhoto(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$6(View view) {
        deletePhoto(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$7(View view) {
        deletePhoto(104);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$8(View view) {
        deletePhoto(109);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$9(View view) {
        deletePhoto(110);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$10(View view) {
        deletePhoto(111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$11(View view) {
        deletePhoto(112);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$12(View view) {
        deletePhoto(113);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$13(View view) {
        deletePhoto(114);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$14(View view) {
        deletePhoto(115);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$15(View view) {
        deletePhoto(116);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$16(View view) {
        deletePhoto(133);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$17(View view) {
        deletePhoto(134);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$18(View view) {
        deletePhoto(135);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$19(View view) {
        deletePhoto(136);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$20(View view) {
        deletePhoto(137);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$21(View view) {
        deletePhoto(138);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$22(View view) {
        deletePhoto(139);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$AnomalyDetailsDialog$23(View view) {
        deletePhoto(140);
    }

    private void setImages() {
        if (TextUtils.isEmpty(this.relativeDocument1UrlS) && TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            this.binding.enumerationFormLayout.setVisibility(0);
            this.binding.fbImageLL.setVisibility(8);
            this.binding.lvPage1EnumrationChoose.setVisibility(0);
            this.binding.lvPage2EnumrationChoose.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            this.binding.lvPage1EnumrationChoose.setVisibility(0);
            this.binding.firstLL.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            this.binding.lvPage2EnumrationChoose.setVisibility(0);
            this.binding.secondLL.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            getFile1(this.relativeDocument1UrlS);
            this.binding.lvPage1EnumrationChoose.setVisibility(8);
            this.binding.fbImageLL.setVisibility(0);
            this.binding.firstLL.setVisibility(0);
            if (!TextUtils.isEmpty(this.relativeDocument2UrlS)) {
                this.binding.lvPage2EnumrationChoose.setVisibility(8);
                this.binding.secondLL.setVisibility(0);
            } else {
                this.binding.lvPage2EnumrationChoose.setVisibility(0);
                this.binding.secondLL.setVisibility(8);
            }
            if (this.relativeDocument1UrlS.endsWith(".pdf")) {
                this.binding.frontImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (!TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            getFile2(this.relativeDocument2UrlS);
            this.binding.secondLL.setVisibility(0);
            this.binding.fbImageLL.setVisibility(0);
            this.binding.lvPage2EnumrationChoose.setVisibility(8);
            if (!TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                this.binding.lvPage1EnumrationChoose.setVisibility(8);
                this.binding.firstLL.setVisibility(0);
            } else {
                this.binding.lvPage1EnumrationChoose.setVisibility(0);
                this.binding.firstLL.setVisibility(8);
            }
            if (this.relativeDocument2UrlS.endsWith(".pdf")) {
                this.binding.backImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (!TextUtils.isEmpty(this.relativeDocument1UrlS) && !TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            this.binding.enumerationFormLayout.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            this.binding.grandparent.supprtingDocumentsLayout.setVisibility(0);
            this.binding.grandparent.fbImageLL1.setVisibility(8);
            this.binding.grandparent.uploadSupportingDocumentsPage1.setVisibility(0);
            this.binding.grandparent.uploadSupportingDocumentsPage2.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            this.binding.grandparent.uploadSupportingDocumentsPage1.setVisibility(0);
            this.binding.grandparent.firstLL1.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            this.binding.grandparent.uploadSupportingDocumentsPage2.setVisibility(0);
            this.binding.grandparent.secondLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            getFile3(this.relativeSupportingDocumentPage1UrlS);
            this.binding.grandparent.fbImageLL1.setVisibility(0);
            this.binding.grandparent.firstLL1.setVisibility(0);
            this.binding.grandparent.lvSupportChoose1.setVisibility(8);
            if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
                this.binding.grandparent.secondLL1.setVisibility(0);
                this.binding.grandparent.lvSupportChoose2.setVisibility(8);
            } else {
                this.binding.grandparent.secondLL1.setVisibility(8);
                this.binding.grandparent.lvSupportChoose2.setVisibility(0);
            }
            if (this.relativeSupportingDocumentPage1UrlS.endsWith(".pdf")) {
                this.binding.grandparent.frontImage1.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            return;
        }
        getFile4(this.relativeSupportingDocumentPage2UrlS);
        this.binding.grandparent.fbImageLL1.setVisibility(0);
        this.binding.grandparent.secondLL1.setVisibility(0);
        this.binding.grandparent.lvSupportChoose2.setVisibility(8);
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            this.binding.grandparent.firstLL1.setVisibility(0);
            this.binding.grandparent.lvSupportChoose1.setVisibility(8);
        } else {
            this.binding.grandparent.firstLL1.setVisibility(8);
            this.binding.grandparent.lvSupportChoose1.setVisibility(0);
        }
        if (this.relativeSupportingDocumentPage2UrlS.endsWith(".pdf")) {
            this.binding.grandparent.backImage1.setImageResource(R.drawable.blo_pfd_thumbnail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void pickPhoto(final int code, final String listCode, String epic) {
        final String strReplaceAll = epic.replaceAll("/", "_");
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$24(charSequenceArr, strReplaceAll, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$24(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.temp = str + "_" + str2;
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).maxResultSize(1028, 1028).cameraOnly().start(i);
        } else if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    public void resetImage(String imageType, String error) {
        if (imageType.equals(this.photo1strNew)) {
            this.relativeDocument1UrlS = "";
            this.binding.lvPage1EnumrationChoose.setVisibility(0);
            this.binding.enumerationFormPage1.setVisibility(8);
            this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage1.setEnabled(true);
        }
        if (imageType.equals(this.photo2strNew)) {
            this.binding.lvPage2EnumrationChoose.setVisibility(0);
            this.binding.enumerationFormPage2.setVisibility(8);
            this.relativeDocument2UrlS = "";
            this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage2.setEnabled(true);
        }
        if (imageType.equals(this.photo3strNew)) {
            this.relativeSupportingDocumentPage1UrlS = "";
            this.binding.grandparent.supprtingDocumentsLayout.setVisibility(0);
            this.binding.grandparent.supportingDocumentsPage1.setVisibility(8);
            this.binding.grandparent.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.uploadSupportingDocumentsPage1.setEnabled(true);
        }
        if (imageType.equals(this.photo4strNew)) {
            this.relativeSupportingDocumentPage2UrlS = "";
            this.binding.grandparent.supprtingDocumentsLayout.setVisibility(0);
            this.binding.grandparent.supportingDocumentsPage2.setVisibility(8);
            this.binding.grandparent.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.uploadSupportingDocumentsPage2.setEnabled(true);
        }
        if (imageType.equalsIgnoreCase("bloletter")) {
            this.bloletter = "";
            this.binding.bloletterLayout.setVisibility(0);
            this.binding.viewlayoutpage1.setVisibility(8);
            this.binding.ivdelete.setVisibility(8);
            this.binding.layoutCapturePhoto.setEnabled(true);
        }
        if (imageType.equals(this.doc5Page1str)) {
            this.doc5Page1Url = "";
            this.binding.doc5DocumentsLayout.setVisibility(0);
            this.binding.doc5DocumentsPage1.setVisibility(8);
            this.binding.doc5uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc5uploadSupportingDocumentsPage1.setEnabled(true);
        }
        if (imageType.equals(this.doc5Page2str)) {
            this.doc5Page2URL = "";
            this.binding.doc5DocumentsLayout.setVisibility(0);
            this.binding.doc5supportingDocumentsPage2.setVisibility(8);
            this.binding.doc5uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc5uploadSupportingDocumentsPage2.setEnabled(true);
        }
        if (imageType.equals(this.doc6Page1str)) {
            this.doc6Page1Url = "";
            this.binding.doc6DocumentsLayout.setVisibility(0);
            this.binding.doc6DocumentsPage1.setVisibility(8);
            this.binding.doc6uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc6uploadSupportingDocumentsPage1.setEnabled(true);
        }
        if (imageType.equals(this.doc6Page2str)) {
            this.doc6Page2URL = "";
            this.binding.doc6DocumentsLayout.setVisibility(0);
            this.binding.doc6supportingDocumentsPage2.setVisibility(8);
            this.binding.doc6uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc6uploadSupportingDocumentsPage2.setEnabled(true);
        }
        if (imageType.equals(this.parentSpinner2Image)) {
            this.parentSpinner2ImageUrl = "";
            this.binding.lvPage1SpinnerDocumentChoose.setVisibility(0);
            this.binding.parentSpinner1Page1.setVisibility(8);
            this.binding.uploadspinner1Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadspinner1Page1.setEnabled(true);
        }
        if (imageType.equals(this.parentSpinner2Image2)) {
            this.binding.lvPage2Spinner1Choose.setVisibility(0);
            this.binding.parentSpinner1Page2.setVisibility(8);
            this.parentSpinner2ImageUrl1 = "";
            this.binding.uploadSpinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSpinner1Page2.setEnabled(true);
        }
        if (imageType.equals(this.parentDoc3Page1Tag)) {
            this.parentDoc3Page1ImageUrl = "";
            this.binding.lvDoc3page1SpinnerDocumentChoose.setVisibility(0);
            this.binding.parentDoc3Spinner1Page1.setVisibility(8);
            this.binding.uploadspinner1Doc3Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadspinner1Doc3Page1.setEnabled(true);
        }
        if (imageType.equals(this.parentDoc3Page2Tag)) {
            this.binding.lvPage2Doc3spinner1Choose.setVisibility(0);
            this.binding.parentDoc3Spinner1Page2.setVisibility(8);
            this.binding.Doc3uploadspinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.Doc3uploadspinner1Page2.setEnabled(true);
            this.parentDoc3Page2ImageUrl = "";
        }
        if (imageType.equals(this.parentDoc4Page1Tag)) {
            this.parentDoc4Page1ImageUrl = "";
            this.binding.lvDoc4page1SpinnerDocumentChoose.setVisibility(0);
            this.binding.parentDoc4Spinner1Page1.setVisibility(8);
            this.binding.uploadspinner1Doc4Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadspinner1Doc4Page1.setEnabled(true);
        }
        if (imageType.equals(this.parentDoc4Page2Tag)) {
            this.binding.lvPage2Doc4spinner1Choose.setVisibility(0);
            this.binding.parentDoc4Spinner1Page2.setVisibility(8);
            this.binding.Doc4uploadspinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.Doc4uploadspinner1Page2.setEnabled(true);
            this.parentDoc4Page2ImageUrl = "";
        }
        if (imageType.equals(this.grandParentspinner1Page1)) {
            this.grandParentSpinner2ImageUrl = "";
            this.binding.grandparent.lvPage1GpspinnerDocumentChoose.setVisibility(0);
            this.binding.grandparent.grandParentSpinner1Page1.setVisibility(8);
            this.binding.grandparent.uploadGpSpinner1Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.uploadGpSpinner1Page1.setEnabled(true);
        }
        if (imageType.equals(this.grandParentspinner1Page2)) {
            this.binding.grandparent.lvPage2GpSpinner1Choose.setVisibility(0);
            this.binding.grandparent.grandParentSpinner1Page2.setVisibility(8);
            this.grandParentSpinner2ImageUrl1 = "";
            this.binding.grandparent.uploadGPSpinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.uploadGPSpinner1Page2.setEnabled(true);
        }
        if (imageType.equals(this.grandparentDoc3Page1Tag)) {
            this.grandParentDoc3Page1Url = "";
            this.binding.grandparent.doc3lvPage1GpspinnerDocumentChoose.setVisibility(0);
            this.binding.grandparent.doc3grandParentSpinner1Page1.setVisibility(8);
            this.binding.grandparent.doc3uploadGpSpinner1Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.doc3uploadGpSpinner1Page1.setEnabled(true);
        }
        if (imageType.equals(this.grandparentDoc3Page2Tag)) {
            this.binding.grandparent.doc3lvPage2GpSpinner1Choose.setVisibility(0);
            this.binding.grandparent.doc3grandParentSpinner1Page2.setVisibility(8);
            this.grandParentDoc3Page2Url = "";
            this.binding.grandparent.doc3uploadGPSpinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.doc3uploadGPSpinner1Page2.setEnabled(true);
        }
        if (imageType.equals(this.grandparentDoc4Page1Tag)) {
            this.grandParentDoc4Page1Url = "";
            this.binding.grandparent.doc4lvPage1GpspinnerDocumentChoose.setVisibility(0);
            this.binding.grandparent.doc4grandParentSpinner1Page1.setVisibility(8);
            this.binding.grandparent.doc4uploadGpSpinner1Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.doc4uploadGpSpinner1Page1.setEnabled(true);
        }
        if (imageType.equals(this.grandparentDoc4Page2Tag)) {
            this.binding.grandparent.doc4lvPage2GpSpinner1Choose.setVisibility(0);
            this.binding.grandparent.doc4grandParentSpinner1Page2.setVisibility(8);
            this.grandParentDoc4Page2Url = "";
            this.binding.grandparent.doc4uploadGPSpinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.doc4uploadGPSpinner1Page2.setEnabled(true);
        }
        showDialog1(this.alertText, error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayFile(final String fileref, final String uploadType) {
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    final String strReplace = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    AnomalyListActivity.this.binding.updateImage.setVisibility(0);
                    if (uploadType.equals(AnomalyListActivity.this.photo1strNew)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.enumerationFormPage1.setVisibility(0);
                                AnomalyListActivity.this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.enumerationFormPage1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.enumerationFormPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.photo2strNew)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.enumerationFormPage2.setVisibility(0);
                                AnomalyListActivity.this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.enumerationFormPage2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.enumerationFormPage2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.photo3strNew)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.3
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage1.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage1ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage1ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.grandparent.uploadSupportingDocumentsPage1.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equalsIgnoreCase(AnomalyListActivity.this.photo4strNew)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.4
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage2.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage2ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage2ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage2Image.setImageBitmap(BitmapFactory.decodeByteArray(AnomalyListActivity.this.pdfbyteArray, 0, AnomalyListActivity.this.pdfbyteArray.length));
                                AnomalyListActivity.this.binding.grandparent.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.grandparent.uploadSupportingDocumentsPage2.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equalsIgnoreCase("bloletter")) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.5
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.bloletterLayout.setVisibility(8);
                                AnomalyListActivity.this.binding.viewlayoutpage1.setVisibility(0);
                                AnomalyListActivity.this.binding.ivdelete.setVisibility(0);
                                AnomalyListActivity.this.binding.letterpage1.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.layoutCapturePhoto.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.ivviewlayoutpage1);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.doc5Page1str)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.6
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.doc5DocumentsPage1.setVisibility(0);
                                AnomalyListActivity.this.binding.doc5cancelSupportingDocumentsPage1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.doc5DocumentsPage1ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.doc5DocumentsPage1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.doc5DocumentsPage1ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.doc5cancelSupportingDocumentsPage1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.doc5uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.doc5uploadSupportingDocumentsPage1.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.doc5DocumentsPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.doc5Page2str)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.7
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.doc5supportingDocumentsPage2.setVisibility(0);
                                AnomalyListActivity.this.binding.doc5cancelSupportingDocumentsPage2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.doc5supportingDocumentsPage2ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.doc5supportingDocumentsPage2ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.doc5supportingDocumentsPage2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.doc5uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.doc5uploadSupportingDocumentsPage2.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.doc5supportingDocumentsPage2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.doc6Page1str)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.8
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.doc6DocumentsPage1.setVisibility(0);
                                AnomalyListActivity.this.binding.doc6cancelSupportingDocumentsPage1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.doc6DocumentsPage1ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.doc6DocumentsPage1ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.doc6cancelSupportingDocumentsPage1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.doc6uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.doc6uploadSupportingDocumentsPage1.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.doc6DocumentsPage1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.doc6Page2str)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.9
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.doc6supportingDocumentsPage2.setVisibility(0);
                                AnomalyListActivity.this.binding.doc6cancelSupportingDocumentsPage2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.doc6supportingDocumentsPage2ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.doc6supportingDocumentsPage2ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.doc6supportingDocumentsPage2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.doc6uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.doc6uploadSupportingDocumentsPage2.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.doc6supportingDocumentsPage2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.parentSpinner2Image)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.10
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.parentSpinner1Page1.setVisibility(0);
                                AnomalyListActivity.this.binding.cancelparentSpinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.parentSpinner1Page1ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.parentSpinner1Page1ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.parentSpinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.uploadspinner1Page1.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.uploadspinner1Page1.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.parentSpinner1Page1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.parentSpinner2Image2)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.11
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.parentSpinner1Page2.setVisibility(0);
                                AnomalyListActivity.this.binding.cancelparentSpinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.parentSpinner1Page2ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.parentSpinner1Page2ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.parentSpinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.uploadSpinner1Page2.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.uploadSpinner1Page2.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.parentSpinner1Page2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.parentDoc3Page1Tag)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.12
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.parentDoc3Spinner1Page1.setVisibility(0);
                                AnomalyListActivity.this.binding.cancelDoc3parentSpinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc3Spinner1Page1ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc3Spinner1Page1ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc3Spinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.uploadspinner1Doc3Page1.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.uploadspinner1Doc3Page1.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.parentDoc3Spinner1Page1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.parentDoc3Page2Tag)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.13
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.parentDoc3Spinner1Page2.setVisibility(0);
                                AnomalyListActivity.this.binding.cancelparentDoc3Spinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc3Spinner1Page2ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc3Spinner1Page2ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc3Spinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.Doc3uploadspinner1Page2.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.Doc3uploadspinner1Page2.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.parentDoc3Spinner1Page2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.parentDoc4Page1Tag)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.14
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.parentDoc4Spinner1Page1.setVisibility(0);
                                AnomalyListActivity.this.binding.cancelDoc4parentSpinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc4Spinner1Page1ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc4Spinner1Page1ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc4Spinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.uploadspinner1Doc4Page1.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.uploadspinner1Doc4Page1.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.parentDoc4Spinner1Page1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.parentDoc4Page2Tag)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.15
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.parentDoc4Spinner1Page2.setVisibility(0);
                                AnomalyListActivity.this.binding.cancelparentDoc4Spinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc4Spinner1Page2ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc4Spinner1Page2ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.parentDoc4Spinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.Doc4uploadspinner1Page2.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.Doc4uploadspinner1Page2.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.parentDoc4Spinner1Page2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.grandParentspinner1Page1)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.16
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.grandparent.grandParentSpinner1Page1.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.cancelgrandParentSpinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.grandParentSpinner1Page1ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.grandParentSpinner1Page1ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.grandParentSpinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.uploadGpSpinner1Page1.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.grandparent.uploadGpSpinner1Page1.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.grandparent.grandParentSpinner1Page1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.grandParentspinner1Page2)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.17
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.grandparent.grandParentSpinner1Page2.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.cancelgrandParentSpinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.grandParentSpinner1Page2ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.grandParentSpinner1Page2ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.grandParentSpinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.uploadGPSpinner1Page2.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.grandparent.uploadGPSpinner1Page2.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.grandparent.grandParentSpinner1Page2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.grandparentDoc3Page1Tag)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.18
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.grandparent.doc3grandParentSpinner1Page1.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc3cancelgrandParentSpinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc3grandParentSpinner1Page1ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc3grandParentSpinner1Page1ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc3grandParentSpinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc3uploadGpSpinner1Page1.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.grandparent.doc3uploadGpSpinner1Page1.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.grandparent.doc3grandParentSpinner1Page1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.grandparentDoc3Page2Tag)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.19
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.grandparent.doc3grandParentSpinner1Page2.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc3cancelgrandParentSpinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc3grandParentSpinner1Page2ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc3grandParentSpinner1Page2ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc3grandParentSpinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc3uploadGPSpinner1Page2.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.grandparent.doc3uploadGPSpinner1Page2.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.grandparent.doc3grandParentSpinner1Page2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.grandparentDoc4Page1Tag)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.20
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.grandparent.doc4grandParentSpinner1Page1.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc4cancelgrandParentSpinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc4grandParentSpinner1Page1ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc4grandParentSpinner1Page1ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc4grandParentSpinner1Page1Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc4uploadGpSpinner1Page1.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.grandparent.doc4uploadGpSpinner1Page1.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.grandparent.doc4grandParentSpinner1Page1Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                    }
                    if (uploadType.equals(AnomalyListActivity.this.grandparentDoc4Page2Tag)) {
                        AnomalyListActivity.this.checkImageFromURL(strReplace, new DownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.42.21
                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onSuccess(File pdfFile) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.binding.grandparent.doc4grandParentSpinner1Page2.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc4cancelgrandParentSpinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc4grandParentSpinner1Page2ImageName.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc4grandParentSpinner1Page2ImageSize.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc4grandParentSpinner1Page2Image.setVisibility(0);
                                AnomalyListActivity.this.binding.grandparent.doc4uploadGPSpinner1Page2.setTextColor(Color.parseColor(AnomalyListActivity.this.greycolor));
                                AnomalyListActivity.this.binding.grandparent.doc4uploadGPSpinner1Page2.setEnabled(false);
                                Glide.with(AnomalyListActivity.this).load(strReplace).into(AnomalyListActivity.this.binding.grandparent.doc4grandParentSpinner1Page2Image);
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.DownloadCallback
                            public void onError(String message, Throwable cause) {
                                if (AnomalyListActivity.this.alertDialog != null) {
                                    AnomalyListActivity.this.alertDialog.dismiss();
                                }
                                AnomalyListActivity.this.resetImage(uploadType, message);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (response.code() == 401) {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    AnomalyListActivity.this.resetImage(uploadType, Constants.somethingWentWrong);
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(AnomalyListActivity.this.messageString);
                    Logger.e(AnomalyListActivity.this.TAG, strOptString);
                    AnomalyListActivity.this.retryAPI(fileref, uploadType, strOptString);
                } catch (Exception e) {
                    Logger.e(AnomalyListActivity.this.TAG, e.getMessage());
                    AnomalyListActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                AnomalyListActivity.this.retryAPI(fileref, uploadType, Constants.somethingWentWrong);
            }
        });
    }

    public void retryAPI(String fileref, String uploadType, String error) {
        if (uploadType.equalsIgnoreCase(this.photo1strNew)) {
            int i = this.getImage1Count;
            if (i < 2) {
                this.getImage1Count = i + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                this.getImage1Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.photo2strNew)) {
            int i2 = this.getImage2Count;
            if (i2 < 2) {
                this.getImage2Count = i2 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog2 = this.alertDialog;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                }
                this.getImage2Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.photo3strNew)) {
            int i3 = this.getImage3Count;
            if (i3 < 2) {
                this.getImage3Count = i3 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog3 = this.alertDialog;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                }
                this.getImage3Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.photo4strNew)) {
            int i4 = this.getImage4Count;
            if (i4 < 2) {
                this.getImage4Count = i4 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog4 = this.alertDialog;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                }
                this.getImage4Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase("bloletter")) {
            int i5 = this.blolettercount;
            if (i5 < 2) {
                this.blolettercount = i5 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog5 = this.alertDialog;
                if (alertDialog5 != null) {
                    alertDialog5.dismiss();
                }
                this.blolettercount = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.doc5Page1str)) {
            int i6 = this.doc5page1count;
            if (i6 < 2) {
                this.doc5page1count = i6 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog6 = this.alertDialog;
                if (alertDialog6 != null) {
                    alertDialog6.dismiss();
                }
                this.doc5page1count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.doc5Page2str)) {
            int i7 = this.doc5page2count;
            if (i7 < 2) {
                this.doc5page2count = i7 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog7 = this.alertDialog;
                if (alertDialog7 != null) {
                    alertDialog7.dismiss();
                }
                this.doc5page2count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.doc6Page1str)) {
            int i8 = this.doc6page1count;
            if (i8 < 2) {
                this.doc6page1count = i8 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog8 = this.alertDialog;
                if (alertDialog8 != null) {
                    alertDialog8.dismiss();
                }
                this.doc6page1count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.doc6Page2str)) {
            int i9 = this.doc6page2count;
            if (i9 < 2) {
                this.doc6page2count = i9 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog9 = this.alertDialog;
                if (alertDialog9 != null) {
                    alertDialog9.dismiss();
                }
                this.doc6page2count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.parentSpinner2Image)) {
            int i10 = this.parentSpinner2ImageCount;
            if (i10 < 2) {
                this.parentSpinner2ImageCount = i10 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog10 = this.alertDialog;
                if (alertDialog10 != null) {
                    alertDialog10.dismiss();
                }
                this.parentSpinner2ImageCount = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.parentSpinner2Image2)) {
            int i11 = this.parentSpinner2Image2Count;
            if (i11 < 2) {
                this.parentSpinner2Image2Count = i11 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog11 = this.alertDialog;
                if (alertDialog11 != null) {
                    alertDialog11.dismiss();
                }
                this.parentSpinner2Image2Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.parentDoc3Page1Tag)) {
            int i12 = this.parentDoc3Page1Count;
            if (i12 < 2) {
                this.parentDoc3Page1Count = i12 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog12 = this.alertDialog;
                if (alertDialog12 != null) {
                    alertDialog12.dismiss();
                }
                this.parentDoc3Page1Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.parentDoc3Page2Tag)) {
            int i13 = this.parentDoc3Page2Count;
            if (i13 < 2) {
                this.parentDoc3Page2Count = i13 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog13 = this.alertDialog;
                if (alertDialog13 != null) {
                    alertDialog13.dismiss();
                }
                this.parentDoc3Page2Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.parentDoc4Page1Tag)) {
            int i14 = this.parentDoc4Page1Count;
            if (i14 < 2) {
                this.parentDoc4Page1Count = i14 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog14 = this.alertDialog;
                if (alertDialog14 != null) {
                    alertDialog14.dismiss();
                }
                this.parentDoc4Page1Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.parentDoc4Page2Tag)) {
            int i15 = this.parentDoc4Page2Count;
            if (i15 < 2) {
                this.parentDoc4Page2Count = i15 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog15 = this.alertDialog;
                if (alertDialog15 != null) {
                    alertDialog15.dismiss();
                }
                this.parentDoc4Page2Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.grandParentspinner1Page1)) {
            int i16 = this.grandParentSpinner2ImageCount;
            if (i16 < 2) {
                this.grandParentSpinner2ImageCount = i16 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog16 = this.alertDialog;
                if (alertDialog16 != null) {
                    alertDialog16.dismiss();
                }
                this.grandParentSpinner2ImageCount = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.grandParentspinner1Page2)) {
            int i17 = this.grandParentSpinner2Image2Count;
            if (i17 < 2) {
                this.grandParentSpinner2Image2Count = i17 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog17 = this.alertDialog;
                if (alertDialog17 != null) {
                    alertDialog17.dismiss();
                }
                this.grandParentSpinner2Image2Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.grandparentDoc3Page1Tag)) {
            int i18 = this.grandparentDoc3Page1Count;
            if (i18 < 2) {
                this.grandparentDoc3Page1Count = i18 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog18 = this.alertDialog;
                if (alertDialog18 != null) {
                    alertDialog18.dismiss();
                }
                this.grandparentDoc3Page1Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.grandparentDoc3Page2Tag)) {
            int i19 = this.grandparentDoc3Page2Count;
            if (i19 < 2) {
                this.grandparentDoc3Page2Count = i19 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog19 = this.alertDialog;
                if (alertDialog19 != null) {
                    alertDialog19.dismiss();
                }
                this.grandparentDoc3Page2Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.grandparentDoc4Page1Tag)) {
            int i20 = this.grandparentDoc4Page1Count;
            if (i20 < 2) {
                this.grandparentDoc4Page1Count = i20 + 1;
                displayFile(fileref, uploadType);
            } else {
                AlertDialog alertDialog20 = this.alertDialog;
                if (alertDialog20 != null) {
                    alertDialog20.dismiss();
                }
                this.grandparentDoc4Page1Count = 0;
                resetImage(uploadType, error);
            }
        }
        if (uploadType.equalsIgnoreCase(this.grandparentDoc4Page2Tag)) {
            int i21 = this.grandparentDoc4Page2Count;
            if (i21 < 2) {
                this.grandparentDoc4Page2Count = i21 + 1;
                displayFile(fileref, uploadType);
                return;
            }
            AlertDialog alertDialog21 = this.alertDialog;
            if (alertDialog21 != null) {
                alertDialog21.dismiss();
            }
            this.grandparentDoc4Page2Count = 0;
            resetImage(uploadType, error);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadImageons3(String presignedurl, String flename, final String uploadtype, final String filereference) {
        new UploadCaller().uploadFileInBackground(this, presignedurl, new File(flename), new ValidationEFCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.43
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback
            public void onResult(boolean isValidate, String error) {
                if (!isValidate) {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    AnomalyListActivity.this.resetImage(uploadtype, error);
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.43.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uploadtype.equals(AnomalyListActivity.this.photo1strNew)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(AnomalyListActivity.this.photo2strNew)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(AnomalyListActivity.this.photo3strNew)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(AnomalyListActivity.this.photo4strNew)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equalsIgnoreCase("bloletter")) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(AnomalyListActivity.this.doc5Page1str)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(AnomalyListActivity.this.doc5Page2str)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(AnomalyListActivity.this.doc6Page1str)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(AnomalyListActivity.this.doc6Page2str)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(AnomalyListActivity.this.parentSpinner2Image)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(AnomalyListActivity.this.parentSpinner2Image2)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equalsIgnoreCase(AnomalyListActivity.this.parentDoc3Page1Tag)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equalsIgnoreCase(AnomalyListActivity.this.parentDoc3Page2Tag)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equalsIgnoreCase(AnomalyListActivity.this.parentDoc4Page1Tag)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equalsIgnoreCase(AnomalyListActivity.this.parentDoc4Page2Tag)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(AnomalyListActivity.this.grandParentspinner1Page1)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equals(AnomalyListActivity.this.grandParentspinner1Page2)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equalsIgnoreCase(AnomalyListActivity.this.grandparentDoc3Page1Tag)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equalsIgnoreCase(AnomalyListActivity.this.grandparentDoc3Page2Tag)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equalsIgnoreCase(AnomalyListActivity.this.grandparentDoc4Page1Tag)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                        if (uploadtype.equalsIgnoreCase(AnomalyListActivity.this.grandparentDoc4Page2Tag)) {
                            AnomalyListActivity.this.displayFile(filereference, uploadtype);
                        }
                    }
                }, 1000L);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass44(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$44, reason: invalid class name */
    class AnonymousClass44 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass44(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                AnomalyListActivity.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(AnomalyListActivity.this).load(AnomalyListActivity.this.preSignedurl1).into(AnomalyListActivity.this.binding.frontImage);
                }
                if (TextUtils.isEmpty(AnomalyListActivity.this.preSignedurl1)) {
                    AnomalyListActivity.this.binding.frontImage.setImageBitmap(BitmapFactory.decodeResource(AnomalyListActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = AnomalyListActivity.this.commomUtility;
                    ?? r5 = AnomalyListActivity.this;
                    String str = ((AnomalyListActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$44$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(AnomalyListActivity.this.TAG, AnomalyListActivity.this.comingTag);
                }
            } else {
                try {
                    AnomalyListActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$44$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(AnomalyListActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(AnomalyListActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(AnomalyListActivity.this.TAG, e.getMessage());
                }
            }
            AnomalyListActivity.this.alertDialog.dismiss();
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
            AnomalyListActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                AnomalyListActivity.this.commomUtility.showMessageOK(AnomalyListActivity.this, AnomalyListActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$44$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            AnomalyListActivity.this.token = "Bearer " + str2;
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setRefreshToken(str3);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setToken("Bearer " + str2);
            AnomalyListActivity.this.getFile1(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setLocaleBool(false);
            AnomalyListActivity.this.startActivity(new Intent((Context) AnomalyListActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (AnomalyListActivity.this.alertDialog != null) {
                AnomalyListActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(AnomalyListActivity.this.TAG, AnomalyListActivity.this.comingTag + t.getMessage());
            if (AnomalyListActivity.this.alertDialog != null) {
                AnomalyListActivity.this.alertDialog.dismiss();
            }
            AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
            anomalyListActivity.showDialog1(anomalyListActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile2(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass45(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$45, reason: invalid class name */
    class AnonymousClass45 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass45(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                AnomalyListActivity.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(AnomalyListActivity.this).load(AnomalyListActivity.this.preSignedurl2).into(AnomalyListActivity.this.binding.backImage);
                }
                if (TextUtils.isEmpty(AnomalyListActivity.this.preSignedurl2)) {
                    AnomalyListActivity.this.binding.backImage.setImageBitmap(BitmapFactory.decodeResource(AnomalyListActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = AnomalyListActivity.this.commomUtility;
                    ?? r5 = AnomalyListActivity.this;
                    String str = ((AnomalyListActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$45$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(AnomalyListActivity.this.TAG, AnomalyListActivity.this.comingTag);
                }
            } else {
                try {
                    AnomalyListActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$45$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(AnomalyListActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(AnomalyListActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(AnomalyListActivity.this.TAG, e.getMessage());
                }
            }
            AnomalyListActivity.this.alertDialog.dismiss();
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
            AnomalyListActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                AnomalyListActivity.this.commomUtility.showMessageOK(AnomalyListActivity.this, AnomalyListActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$45$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            AnomalyListActivity.this.token = "Bearer " + str2;
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setRefreshToken(str3);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setToken("Bearer " + str2);
            AnomalyListActivity.this.getFile2(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setLocaleBool(false);
            AnomalyListActivity.this.startActivity(new Intent((Context) AnomalyListActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (AnomalyListActivity.this.alertDialog != null) {
                AnomalyListActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(AnomalyListActivity.this.TAG, AnomalyListActivity.this.comingTag + t.getMessage());
            if (AnomalyListActivity.this.alertDialog != null) {
                AnomalyListActivity.this.alertDialog.dismiss();
            }
            AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
            anomalyListActivity.showDialog1(anomalyListActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile3(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass46(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$46, reason: invalid class name */
    class AnonymousClass46 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass46(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                AnomalyListActivity.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(AnomalyListActivity.this).load(AnomalyListActivity.this.preSignedurl3).into(AnomalyListActivity.this.binding.grandparent.frontImage1);
                }
                if (TextUtils.isEmpty(AnomalyListActivity.this.preSignedurl3)) {
                    AnomalyListActivity.this.binding.grandparent.frontImage1.setImageBitmap(BitmapFactory.decodeResource(AnomalyListActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = AnomalyListActivity.this.commomUtility;
                    ?? r5 = AnomalyListActivity.this;
                    String str = ((AnomalyListActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$46$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(AnomalyListActivity.this.TAG, AnomalyListActivity.this.comingTag);
                }
            } else {
                try {
                    AnomalyListActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$46$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(AnomalyListActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(AnomalyListActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(AnomalyListActivity.this.TAG, e.getMessage());
                }
            }
            AnomalyListActivity.this.alertDialog.dismiss();
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
            AnomalyListActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                AnomalyListActivity.this.commomUtility.showMessageOK(AnomalyListActivity.this, AnomalyListActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$46$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            AnomalyListActivity.this.token = "Bearer " + str2;
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setRefreshToken(str3);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setToken("Bearer " + str2);
            AnomalyListActivity.this.getFile3(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setLocaleBool(false);
            AnomalyListActivity.this.startActivity(new Intent((Context) AnomalyListActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (AnomalyListActivity.this.alertDialog != null) {
                AnomalyListActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(AnomalyListActivity.this.TAG, AnomalyListActivity.this.comingTag + t.getMessage());
            if (AnomalyListActivity.this.alertDialog != null) {
                AnomalyListActivity.this.alertDialog.dismiss();
            }
            AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
            anomalyListActivity.showDialog1(anomalyListActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile4(String fileref) {
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass47(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$47, reason: invalid class name */
    class AnonymousClass47 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass47(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                AnomalyListActivity.this.preSignedurl4 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(AnomalyListActivity.this).load(AnomalyListActivity.this.preSignedurl4).into(AnomalyListActivity.this.binding.grandparent.backImage1);
                }
                if (TextUtils.isEmpty(AnomalyListActivity.this.preSignedurl4)) {
                    AnomalyListActivity.this.binding.grandparent.backImage1.setImageBitmap(BitmapFactory.decodeResource(AnomalyListActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = AnomalyListActivity.this.commomUtility;
                    ?? r5 = AnomalyListActivity.this;
                    String str = ((AnomalyListActivity) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$47$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(AnomalyListActivity.this.TAG, AnomalyListActivity.this.comingTag);
                }
            } else {
                try {
                    AnomalyListActivity.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$47$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(AnomalyListActivity.this.TAG, new JSONObject(response.errorBody().string()).optString(AnomalyListActivity.this.messageString));
                } catch (IOException | JSONException e) {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    Logger.e(AnomalyListActivity.this.TAG, e.getMessage());
                }
            }
            AnomalyListActivity.this.alertDialog.dismiss();
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
            AnomalyListActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                AnomalyListActivity.this.commomUtility.showMessageOK(AnomalyListActivity.this, AnomalyListActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$47$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            AnomalyListActivity.this.token = "Bearer " + str2;
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setRefreshToken(str3);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setToken("Bearer " + str2);
            AnomalyListActivity.this.getFile4(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setLocaleBool(false);
            AnomalyListActivity.this.startActivity(new Intent((Context) AnomalyListActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (AnomalyListActivity.this.alertDialog != null) {
                AnomalyListActivity.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(AnomalyListActivity.this.TAG, AnomalyListActivity.this.comingTag + t.getMessage());
            if (AnomalyListActivity.this.alertDialog != null) {
                AnomalyListActivity.this.alertDialog.dismiss();
            }
            AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
            anomalyListActivity.showDialog1(anomalyListActivity.getString(R.string.alertMsg), Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
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
            if (TextUtils.isEmpty(this.epic)) {
                map2.put("epicNo", SharedPref.getInstance(this).getepicid("epic"));
            } else {
                map2.put("epicNo", this.epic);
            }
            map2.put("state", this.state);
            map2.put("acNo", this.acNo);
            map2.put("partNo", this.partNo);
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", null);
            map2.put("fileName", captureFileName);
            map2.put("ext", strSubstring);
            Logger.d(this.TAG, map2.toString());
            ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).requestSirUploadUrlphoto(map, map2).enqueue(new AnonymousClass48(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$48, reason: invalid class name */
    class AnonymousClass48 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass48(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v25, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
                CommomUtility commomUtility = AnomalyListActivity.this.commomUtility;
                ?? r13 = AnomalyListActivity.this;
                String str = ((AnomalyListActivity) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$48$$ExternalSyntheticLambda0
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
                        AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                        anomalyListActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, anomalyListActivity.token, this.val$reference, this.val$uploadtype);
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    String strDecryptUrl = AnomalyListActivity.this.decryptUrl(String.valueOf(jSONObject.get("presignedUrl")));
                    String strValueOf = String.valueOf(jSONObject.get("fileName"));
                    if (this.val$uploadtype.equals(AnomalyListActivity.this.photo1strNew)) {
                        AnomalyListActivity.this.relativeDocument1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.relativeDocument1UrlS);
                    }
                    if (this.val$uploadtype.equals(AnomalyListActivity.this.photo2strNew)) {
                        AnomalyListActivity.this.relativeDocument2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.relativeDocument2UrlS);
                    }
                    if (this.val$uploadtype.equals(AnomalyListActivity.this.photo3strNew)) {
                        AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS);
                    }
                    if (this.val$uploadtype.equals(AnomalyListActivity.this.photo4strNew)) {
                        AnomalyListActivity.this.relativeSupportingDocumentPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.relativeSupportingDocumentPage2UrlS);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase("bloletter")) {
                        AnomalyListActivity.this.bloletter = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.bloletter);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.doc5Page1str)) {
                        AnomalyListActivity.this.doc5Page1Url = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.doc5Page1Url);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.doc5Page2str)) {
                        AnomalyListActivity.this.doc5Page2URL = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.doc5Page2URL);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.doc6Page1str)) {
                        AnomalyListActivity.this.doc6Page1Url = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.doc6Page1Url);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.doc6Page2str)) {
                        AnomalyListActivity.this.doc6Page2URL = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.doc6Page2URL);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.parentSpinner2Image)) {
                        AnomalyListActivity.this.parentSpinner2ImageUrl = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.parentSpinner2ImageUrl);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.parentSpinner2Image2)) {
                        AnomalyListActivity.this.parentSpinner2ImageUrl1 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.parentSpinner2ImageUrl1);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.parentDoc3Page1Tag)) {
                        AnomalyListActivity.this.parentDoc3Page1ImageUrl = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.parentDoc3Page1ImageUrl);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.parentDoc3Page2Tag)) {
                        AnomalyListActivity.this.parentDoc3Page2ImageUrl = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.parentDoc3Page2ImageUrl);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.parentDoc4Page1Tag)) {
                        AnomalyListActivity.this.parentDoc4Page1ImageUrl = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.parentDoc4Page1ImageUrl);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.parentDoc4Page2Tag)) {
                        AnomalyListActivity.this.parentDoc4Page2ImageUrl = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.parentDoc4Page2ImageUrl);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.grandParentspinner1Page1)) {
                        AnomalyListActivity.this.grandParentSpinner2ImageUrl = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.grandParentSpinner2ImageUrl);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.grandParentspinner1Page2)) {
                        AnomalyListActivity.this.grandParentSpinner2ImageUrl1 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.grandParentSpinner2ImageUrl1);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.grandparentDoc3Page1Tag)) {
                        AnomalyListActivity.this.grandParentDoc3Page1Url = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.grandParentDoc3Page1Url);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.grandparentDoc3Page2Tag)) {
                        AnomalyListActivity.this.grandParentDoc3Page2Url = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.grandParentDoc3Page2Url);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.grandparentDoc4Page1Tag)) {
                        AnomalyListActivity.this.grandParentDoc4Page1Url = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.grandParentDoc4Page1Url);
                    }
                    if (this.val$uploadtype.equalsIgnoreCase(AnomalyListActivity.this.grandparentDoc4Page2Tag)) {
                        AnomalyListActivity.this.grandParentDoc4Page2Url = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        AnomalyListActivity.this.uploadImageons3(strDecryptUrl, this.val$filepath + this.val$captureFileName, this.val$uploadtype, AnomalyListActivity.this.grandParentDoc4Page2Url);
                    }
                    System.out.println("Presigned URL : " + strDecryptUrl);
                    return;
                } catch (Exception e) {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    AnomalyListActivity.this.resetImage(this.val$uploadtype, e.getMessage());
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            if (this.val$uploadtype.equals(AnomalyListActivity.this.photo1strNew)) {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                AnomalyListActivity.this.photo1countNew = 0;
                AnomalyListActivity.this.binding.enumerationFormPage1.setVisibility(8);
                AnomalyListActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(AnomalyListActivity.this.whitecolor));
                AnomalyListActivity.this.binding.uploadEnumerationFormPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(AnomalyListActivity.this.photo2strNew)) {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                AnomalyListActivity.this.photo2countNew = 0;
                AnomalyListActivity.this.binding.enumerationFormPage2.setVisibility(8);
                AnomalyListActivity.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(AnomalyListActivity.this.whitecolor));
                AnomalyListActivity.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
            if (this.val$uploadtype.equals(AnomalyListActivity.this.photo3strNew)) {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                AnomalyListActivity.this.photo3countNew = 0;
                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage1.setVisibility(8);
                AnomalyListActivity.this.binding.grandparent.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(AnomalyListActivity.this.whitecolor));
                AnomalyListActivity.this.binding.grandparent.uploadSupportingDocumentsPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(AnomalyListActivity.this.photo4strNew)) {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                AnomalyListActivity.this.photo4countNew = 0;
                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage2.setVisibility(8);
                AnomalyListActivity.this.binding.grandparent.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(AnomalyListActivity.this.whitecolor));
                AnomalyListActivity.this.binding.grandparent.uploadSupportingDocumentsPage2.setEnabled(true);
            }
            AnomalyListActivity.this.alertDialog.dismiss();
            try {
                JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                String string = jSONObject2.getString("message");
                AnomalyListActivity anomalyListActivity2 = AnomalyListActivity.this;
                anomalyListActivity2.showDialog1(anomalyListActivity2.alertText, string);
                Logger.d("", jSONObject2.toString());
            } catch (IOException | JSONException e2) {
                Logger.d("", e2.getMessage());
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
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9) {
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str8 + StringUtils.SPACE + str9);
            if (i == 401 || i == 400) {
                AnomalyListActivity.this.commomUtility.showMessageOK(AnomalyListActivity.this, AnomalyListActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$48$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            AnomalyListActivity.this.token = "Bearer " + str8;
            AnomalyListActivity.this.refreshToken = str9;
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setToken("Bearer " + str8);
            AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
            anomalyListActivity.uploadPhoto(str, str2, str3, str4, str5, anomalyListActivity.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setLocaleBool(false);
            AnomalyListActivity.this.startActivity(new Intent((Context) AnomalyListActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(AnomalyListActivity.this.photo1strNew)) {
                if (AnomalyListActivity.this.photo1countNew < 2 && TextUtils.isEmpty(AnomalyListActivity.this.relativeDocument1UrlS)) {
                    AnomalyListActivity.this.photo1countNew++;
                    AnomalyListActivity anomalyListActivity = AnomalyListActivity.this;
                    anomalyListActivity.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, anomalyListActivity.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    AnomalyListActivity.this.photo1countNew = 0;
                    AnomalyListActivity.this.binding.enumerationFormPage1.setVisibility(8);
                    AnomalyListActivity anomalyListActivity2 = AnomalyListActivity.this;
                    anomalyListActivity2.showDialog1(anomalyListActivity2.alertText, AnomalyListActivity.this.fileNotFoundMessage);
                    AnomalyListActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(AnomalyListActivity.this.whitecolor));
                    AnomalyListActivity.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(AnomalyListActivity.this.photo2strNew)) {
                if (AnomalyListActivity.this.photo2countNew < 2 && TextUtils.isEmpty(AnomalyListActivity.this.relativeDocument2UrlS)) {
                    AnomalyListActivity.this.photo2countNew++;
                    AnomalyListActivity anomalyListActivity3 = AnomalyListActivity.this;
                    anomalyListActivity3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, anomalyListActivity3.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    AnomalyListActivity.this.photo2countNew = 0;
                    AnomalyListActivity.this.binding.enumerationFormPage2.setVisibility(8);
                    AnomalyListActivity anomalyListActivity4 = AnomalyListActivity.this;
                    anomalyListActivity4.showDialog1(anomalyListActivity4.alertText, AnomalyListActivity.this.fileNotFoundMessage);
                    AnomalyListActivity.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(AnomalyListActivity.this.whitecolor));
                    AnomalyListActivity.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(AnomalyListActivity.this.photo3strNew)) {
                if (AnomalyListActivity.this.photo3countNew < 2 && TextUtils.isEmpty(AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS)) {
                    AnomalyListActivity.this.photo3countNew++;
                    AnomalyListActivity anomalyListActivity5 = AnomalyListActivity.this;
                    anomalyListActivity5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, anomalyListActivity5.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    AnomalyListActivity.this.photo3countNew = 0;
                    AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage1.setVisibility(8);
                    AnomalyListActivity anomalyListActivity6 = AnomalyListActivity.this;
                    anomalyListActivity6.showDialog1(anomalyListActivity6.alertText, AnomalyListActivity.this.fileNotFoundMessage);
                    AnomalyListActivity.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(AnomalyListActivity.this.whitecolor));
                    AnomalyListActivity.this.binding.uploadEnumerationFormPage1.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(AnomalyListActivity.this.photo4strNew)) {
                if (AnomalyListActivity.this.photo4countNew < 2 && TextUtils.isEmpty(AnomalyListActivity.this.relativeSupportingDocumentPage2UrlS)) {
                    AnomalyListActivity.this.photo4countNew++;
                    AnomalyListActivity anomalyListActivity7 = AnomalyListActivity.this;
                    anomalyListActivity7.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, anomalyListActivity7.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                AnomalyListActivity.this.photo4countNew = 0;
                AnomalyListActivity.this.binding.grandparent.supportingDocumentsPage2.setVisibility(8);
                AnomalyListActivity anomalyListActivity8 = AnomalyListActivity.this;
                anomalyListActivity8.showDialog1(anomalyListActivity8.alertText, AnomalyListActivity.this.fileNotFoundMessage);
                AnomalyListActivity.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(AnomalyListActivity.this.whitecolor));
                AnomalyListActivity.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
        }
    }

    public static String getMD5Checksum(File file) {
        String strEncodeToString;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                if (Build.VERSION.SDK_INT >= 33) {
                    strEncodeToString = Base64.getEncoder().encodeToString(messageDigest.digest(fileInputStream.readAllBytes()));
                } else {
                    strEncodeToString = Base64.getEncoder().encodeToString(messageDigest.digest(toByteArray(fileInputStream)));
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
        byte[] bArrDecode = Base64.getDecoder().decode(encodedKey);
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
            return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
        } catch (Exception unused) {
            return null;
        }
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
        byte[] bArrDecode = android.util.Base64.decode(fileNameBase64, 0);
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
    public void deletePhoto(int code) {
        if (code == 101) {
            this.relativeDocument1UrlS = null;
            this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage1.setEnabled(true);
            this.binding.enumerationFormPage1Image.setVisibility(8);
            this.binding.enumerationFormPage1.setVisibility(8);
            this.binding.enumerationFormPage1ImageSize.setText("");
            this.binding.enumerationFormPage1ImageName.setText("");
            this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeDocument2UrlS) && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                this.binding.enumerationFormPage1.setVisibility(8);
                this.binding.enumerationFormPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 102) {
            this.relativeDocument2UrlS = null;
            this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage2.setEnabled(true);
            this.binding.enumerationFormPage2Image.setVisibility(8);
            this.binding.enumerationFormPage2.setVisibility(8);
            this.binding.enumerationFormPage2ImageSize.setText("");
            this.binding.enumerationFormPage2ImageName.setText("");
            this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeDocument2UrlS) && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                this.binding.enumerationFormPage1.setVisibility(8);
                this.binding.enumerationFormPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 103) {
            this.relativeSupportingDocumentPage1UrlS = null;
            this.binding.grandparent.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.uploadSupportingDocumentsPage1.setEnabled(true);
            this.binding.grandparent.supportingDocumentsPage1Image.setVisibility(8);
            this.binding.grandparent.supportingDocumentsPage1.setVisibility(8);
            this.binding.grandparent.supportingDocumentsPage1ImageName.setText("");
            this.binding.grandparent.supportingDocumentsPage1ImageSize.setText("");
            this.binding.grandparent.cancelSupportingDocumentsPage1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
                this.binding.grandparent.supportingDocumentsPage1.setVisibility(8);
                this.binding.grandparent.supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 104) {
            this.relativeSupportingDocumentPage2UrlS = null;
            this.binding.grandparent.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.uploadSupportingDocumentsPage2.setEnabled(true);
            this.binding.grandparent.supportingDocumentsPage2Image.setVisibility(8);
            this.binding.grandparent.supportingDocumentsPage2.setVisibility(8);
            this.binding.grandparent.supportingDocumentsPage2ImageName.setText("");
            this.binding.grandparent.supportingDocumentsPage2ImageSize.setText("");
            this.binding.grandparent.cancelSupportingDocumentsPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
                this.binding.grandparent.supportingDocumentsPage1.setVisibility(8);
                this.binding.grandparent.supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 105) {
            this.bloletter = "";
            this.binding.bloletterLayout.setVisibility(0);
            this.binding.viewlayoutpage1.setVisibility(8);
            this.binding.ivdelete.setVisibility(8);
            this.binding.layoutCapturePhoto.setEnabled(true);
            return;
        }
        if (code == 109) {
            this.doc5Page1Url = null;
            this.binding.doc5uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc5uploadSupportingDocumentsPage1.setEnabled(true);
            this.binding.doc5DocumentsPage1.setVisibility(8);
            this.binding.doc5DocumentsPage1Image.setVisibility(8);
            this.binding.doc5DocumentsPage1ImageSize.setText("");
            this.binding.doc5DocumentsPage1ImageName.setText("");
            this.binding.doc5cancelSupportingDocumentsPage1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.doc5Page1Url) && TextUtils.isEmpty(this.doc5Page2URL)) {
                this.binding.doc5DocumentsPage1.setVisibility(8);
                this.binding.doc5supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 110) {
            this.doc5Page2URL = null;
            this.binding.doc5uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc5uploadSupportingDocumentsPage2.setEnabled(true);
            this.binding.doc5supportingDocumentsPage2.setVisibility(8);
            this.binding.doc5supportingDocumentsPage2Image.setVisibility(8);
            this.binding.doc5supportingDocumentsPage2ImageSize.setText("");
            this.binding.doc5supportingDocumentsPage2ImageName.setText("");
            this.binding.doc5cancelSupportingDocumentsPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.doc5Page1Url) && TextUtils.isEmpty(this.doc5Page2URL)) {
                this.binding.doc5DocumentsPage1.setVisibility(8);
                this.binding.doc5supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 111) {
            this.doc6Page1Url = null;
            this.binding.doc6uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc6uploadSupportingDocumentsPage2.setEnabled(true);
            this.binding.doc6supportingDocumentsPage2.setVisibility(8);
            this.binding.doc6supportingDocumentsPage2Image.setVisibility(8);
            this.binding.doc6supportingDocumentsPage2ImageSize.setText("");
            this.binding.doc6supportingDocumentsPage2ImageName.setText("");
            this.binding.doc6cancelSupportingDocumentsPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.doc6Page1Url) && TextUtils.isEmpty(this.doc6Page2URL)) {
                this.binding.doc6DocumentsPage1.setVisibility(8);
                this.binding.doc6supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 112) {
            this.doc6Page2URL = null;
            this.binding.doc6uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.doc6uploadSupportingDocumentsPage2.setEnabled(true);
            this.binding.doc6supportingDocumentsPage2.setVisibility(8);
            this.binding.doc6supportingDocumentsPage2Image.setVisibility(8);
            this.binding.doc6supportingDocumentsPage2ImageSize.setText("");
            this.binding.doc6supportingDocumentsPage2ImageName.setText("");
            this.binding.doc6cancelSupportingDocumentsPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.doc6Page1Url) && TextUtils.isEmpty(this.doc6Page2URL)) {
                this.binding.doc6DocumentsPage1.setVisibility(8);
                this.binding.doc6supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 113) {
            this.parentSpinner2ImageUrl = null;
            this.binding.uploadspinner1Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadspinner1Page1.setEnabled(true);
            this.binding.parentSpinner1Page1Image.setVisibility(8);
            this.binding.parentSpinner1Page1.setVisibility(8);
            this.binding.parentSpinner1Page1ImageSize.setText("");
            this.binding.parentSpinner1Page1ImageName.setText("");
            this.binding.cancelparentSpinner1Page1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.parentSpinner2ImageUrl1) && TextUtils.isEmpty(this.parentSpinner2ImageUrl)) {
                this.binding.parentSpinner1Page1.setVisibility(8);
                this.binding.parentSpinner1Page2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 114) {
            this.parentSpinner2ImageUrl1 = null;
            this.binding.uploadSpinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSpinner1Page2.setEnabled(true);
            this.binding.parentSpinner1Page2Image.setVisibility(8);
            this.binding.parentSpinner1Page2.setVisibility(8);
            this.binding.parentSpinner1Page2ImageSize.setText("");
            this.binding.parentSpinner1Page2ImageName.setText("");
            this.binding.cancelparentSpinner1Page2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.parentSpinner2ImageUrl1) && TextUtils.isEmpty(this.parentSpinner2ImageUrl)) {
                this.binding.parentSpinner1Page1.setVisibility(8);
                this.binding.parentSpinner1Page2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 115) {
            this.grandParentSpinner2ImageUrl = null;
            this.binding.grandparent.uploadGpSpinner1Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.uploadGpSpinner1Page1.setEnabled(true);
            this.binding.grandparent.grandParentSpinner1Page1Image.setVisibility(8);
            this.binding.grandparent.grandParentSpinner1Page1.setVisibility(8);
            this.binding.grandparent.grandParentSpinner1Page1ImageSize.setText("");
            this.binding.grandparent.grandParentSpinner1Page1ImageName.setText("");
            this.binding.grandparent.cancelgrandParentSpinner1Page1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.grandParentSpinner2ImageUrl1) && TextUtils.isEmpty(this.grandParentSpinner2ImageUrl)) {
                this.binding.grandparent.grandParentSpinner1Page1.setVisibility(8);
                this.binding.grandparent.grandParentSpinner1Page2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 116) {
            this.grandParentSpinner2ImageUrl1 = null;
            this.binding.grandparent.uploadGPSpinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.uploadGPSpinner1Page2.setEnabled(true);
            this.binding.grandparent.grandParentSpinner1Page2Image.setVisibility(8);
            this.binding.grandparent.grandParentSpinner1Page2.setVisibility(8);
            this.binding.grandparent.grandParentSpinner1Page2ImageSize.setText("");
            this.binding.grandparent.grandParentSpinner1Page2ImageName.setText("");
            this.binding.grandparent.cancelgrandParentSpinner1Page2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.grandParentSpinner2ImageUrl1) && TextUtils.isEmpty(this.grandParentSpinner2ImageUrl)) {
                this.binding.grandparent.grandParentSpinner1Page1.setVisibility(8);
                this.binding.grandparent.grandParentSpinner1Page2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 133) {
            this.parentDoc3Page1ImageUrl = null;
            this.binding.uploadspinner1Doc3Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadspinner1Doc3Page1.setEnabled(true);
            this.binding.parentDoc3Spinner1Page1Image.setVisibility(8);
            this.binding.parentDoc3Spinner1Page1.setVisibility(8);
            this.binding.parentDoc3Spinner1Page1ImageSize.setText("");
            this.binding.parentDoc3Spinner1Page1ImageName.setText("");
            this.binding.cancelDoc3parentSpinner1Page1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.parentDoc3Page2ImageUrl) && TextUtils.isEmpty(this.parentDoc3Page1ImageUrl)) {
                this.binding.parentDoc3Spinner1Page1.setVisibility(8);
                this.binding.parentDoc3Spinner1Page2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 134) {
            this.parentDoc3Page2ImageUrl = null;
            this.binding.Doc3uploadspinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.Doc3uploadspinner1Page2.setEnabled(true);
            this.binding.parentDoc3Spinner1Page2Image.setVisibility(8);
            this.binding.parentDoc3Spinner1Page2.setVisibility(8);
            this.binding.parentDoc3Spinner1Page2ImageSize.setText("");
            this.binding.parentDoc3Spinner1Page2ImageName.setText("");
            this.binding.cancelparentDoc3Spinner1Page2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.parentDoc3Page2ImageUrl) && TextUtils.isEmpty(this.parentDoc3Page1ImageUrl)) {
                this.binding.parentDoc3Spinner1Page1.setVisibility(8);
                this.binding.parentDoc3Spinner1Page2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 135) {
            this.parentDoc4Page1ImageUrl = null;
            this.binding.uploadspinner1Doc4Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadspinner1Doc4Page1.setEnabled(true);
            this.binding.parentDoc4Spinner1Page1Image.setVisibility(8);
            this.binding.parentDoc4Spinner1Page1.setVisibility(8);
            this.binding.parentDoc4Spinner1Page1ImageSize.setText("");
            this.binding.parentDoc4Spinner1Page1ImageName.setText("");
            this.binding.cancelDoc4parentSpinner1Page1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.parentDoc4Page2ImageUrl) && TextUtils.isEmpty(this.parentDoc4Page1ImageUrl)) {
                this.binding.parentDoc4Spinner1Page1.setVisibility(8);
                this.binding.parentDoc4Spinner1Page2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 136) {
            this.parentDoc4Page2ImageUrl = null;
            this.binding.Doc4uploadspinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.Doc4uploadspinner1Page2.setEnabled(true);
            this.binding.parentDoc4Spinner1Page2Image.setVisibility(8);
            this.binding.parentDoc4Spinner1Page2.setVisibility(8);
            this.binding.parentDoc4Spinner1Page2ImageSize.setText("");
            this.binding.parentDoc4Spinner1Page2ImageName.setText("");
            this.binding.cancelparentDoc4Spinner1Page2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.parentDoc4Page2ImageUrl) && TextUtils.isEmpty(this.parentDoc4Page1ImageUrl)) {
                this.binding.parentDoc4Spinner1Page1.setVisibility(8);
                this.binding.parentDoc4Spinner1Page2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 137) {
            this.grandParentDoc3Page1Url = null;
            this.binding.grandparent.doc3uploadGpSpinner1Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.doc3uploadGpSpinner1Page1.setEnabled(true);
            this.binding.grandparent.doc3grandParentSpinner1Page1Image.setVisibility(8);
            this.binding.grandparent.doc3grandParentSpinner1Page1.setVisibility(8);
            this.binding.grandparent.doc3grandParentSpinner1Page1ImageSize.setText("");
            this.binding.grandparent.doc3grandParentSpinner1Page1ImageName.setText("");
            this.binding.grandparent.doc3cancelgrandParentSpinner1Page1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.grandParentDoc3Page1Url) && TextUtils.isEmpty(this.grandParentDoc3Page2Url)) {
                this.binding.grandparent.doc3grandParentSpinner1Page1.setVisibility(8);
                this.binding.grandparent.doc3grandParentSpinner1Page2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 138) {
            this.grandParentDoc3Page2Url = null;
            this.binding.grandparent.doc3uploadGPSpinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.doc3uploadGPSpinner1Page2.setEnabled(true);
            this.binding.grandparent.doc3grandParentSpinner1Page2Image.setVisibility(8);
            this.binding.grandparent.doc3grandParentSpinner1Page2.setVisibility(8);
            this.binding.grandparent.doc3grandParentSpinner1Page2ImageSize.setText("");
            this.binding.grandparent.doc3grandParentSpinner1Page2ImageName.setText("");
            this.binding.grandparent.doc3cancelgrandParentSpinner1Page2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.grandParentDoc3Page1Url) && TextUtils.isEmpty(this.grandParentDoc3Page2Url)) {
                this.binding.grandparent.doc3grandParentSpinner1Page1.setVisibility(8);
                this.binding.grandparent.doc3grandParentSpinner1Page2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 139) {
            this.grandParentDoc4Page1Url = null;
            this.binding.grandparent.doc4uploadGpSpinner1Page1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.doc4uploadGpSpinner1Page1.setEnabled(true);
            this.binding.grandparent.doc4grandParentSpinner1Page1Image.setVisibility(8);
            this.binding.grandparent.doc4grandParentSpinner1Page1.setVisibility(8);
            this.binding.grandparent.doc4grandParentSpinner1Page1ImageSize.setText("");
            this.binding.grandparent.doc4grandParentSpinner1Page1ImageName.setText("");
            this.binding.grandparent.doc4cancelgrandParentSpinner1Page1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.grandParentDoc4Page1Url) && TextUtils.isEmpty(this.grandParentDoc4Page2Url)) {
                this.binding.grandparent.doc4grandParentSpinner1Page1.setVisibility(8);
                this.binding.grandparent.doc4grandParentSpinner1Page2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 140) {
            this.grandParentDoc4Page2Url = null;
            this.binding.grandparent.doc4uploadGPSpinner1Page2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.grandparent.doc4uploadGPSpinner1Page2.setEnabled(true);
            this.binding.grandparent.doc4grandParentSpinner1Page2Image.setVisibility(8);
            this.binding.grandparent.doc4grandParentSpinner1Page2.setVisibility(8);
            this.binding.grandparent.doc4grandParentSpinner1Page2ImageSize.setText("");
            this.binding.grandparent.doc4grandParentSpinner1Page2ImageName.setText("");
            this.binding.grandparent.doc4cancelgrandParentSpinner1Page2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.grandParentDoc4Page2Url) && TextUtils.isEmpty(this.grandParentDoc4Page1Url)) {
                this.binding.grandparent.doc4grandParentSpinner1Page1.setVisibility(8);
                this.binding.grandparent.doc4grandParentSpinner1Page2.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Exception exc;
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult activityResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (activityResult != null) {
            if (activityResult.getContents() == null) {
                Toast.makeText((Context) this, (CharSequence) "Scanning cancelled!", 1).show();
                return;
            }
            String contents = activityResult.getContents();
            try {
                this.barcode = new JSONObject(AESDecryptor.decrypt(contents)).getString("epic_no");
            } catch (Exception unused) {
                this.barcode = contents;
            }
            String strReplace = this.barcode.replace(StringUtils.SPACE, "");
            this.barcode = strReplace;
            this.search.setText(strReplace);
            return;
        }
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
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
            this.pdfbyteArray = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        try {
            Uri saveImagePath = getSaveImagePath(android.util.Base64.encodeToString(this.pdfbyteArray, 0), "image", this.temp);
            Cursor cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
            try {
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery.moveToFirst();
                String[] strArrSplit = saveImagePath.getPath().split("/");
                try {
                    if (requestCode == 101) {
                        long j = this.filesize;
                        if (j < 1024) {
                            uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                            this.binding.enumerationFormPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                            this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                        } else if (j > 2048) {
                            this.binding.enumerationFormPage1.setVisibility(8);
                            this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                            this.binding.enumerationFormPage1ImageName.setVisibility(8);
                            this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                            this.binding.enumerationFormPage1Image.setVisibility(8);
                            this.binding.uploadEnumerationFormPage1.setEnabled(true);
                            this.binding.uploadEnumerationFormPage1.setVisibility(0);
                            this.binding.uploadEnumerationFormPage2.setVisibility(0);
                            showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                        } else {
                            long j2 = j / 1024;
                            this.filesize = j2;
                            double dRound = Math.round(j2 * 100.0d) / 100.0d;
                            if (dRound > 2.0d) {
                                this.binding.enumerationFormPage1.setVisibility(8);
                                this.binding.uploadEnumerationFormPage1.setEnabled(true);
                                showDialog1(this.alertText, this.imgmsg);
                            } else {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                this.binding.enumerationFormPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.enumerationFormPage1ImageSize.setText(dRound + getString(R.string.mbMsg));
                            }
                        }
                    } else if (requestCode == 102) {
                        long j3 = this.filesize;
                        if (j3 < 1024) {
                            uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                            this.binding.enumerationFormPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                            this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                        } else if (j3 > 2048) {
                            this.binding.enumerationFormPage2.setVisibility(8);
                            this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                            this.binding.enumerationFormPage2ImageName.setVisibility(8);
                            this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                            this.binding.enumerationFormPage2Image.setVisibility(8);
                            this.binding.uploadEnumerationFormPage2.setEnabled(true);
                            this.binding.uploadEnumerationFormPage1.setVisibility(0);
                            this.binding.uploadEnumerationFormPage2.setVisibility(0);
                            showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                        } else {
                            long j4 = j3 / 1024;
                            this.filesize = j4;
                            double dRound2 = Math.round(j4 * 100.0d) / 100.0d;
                            if (dRound2 > 2.0d) {
                                this.binding.enumerationFormPage2Image.setVisibility(8);
                                this.binding.uploadEnumerationFormPage2.setEnabled(true);
                                showDialog1(this.alertText, this.imgmsg);
                            } else {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                this.binding.enumerationFormPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.enumerationFormPage2ImageSize.setText(dRound2 + getString(R.string.mbMsg));
                            }
                        }
                    } else {
                        if (requestCode == 103) {
                            long j5 = this.filesize;
                            if (j5 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                this.binding.grandparent.supportingDocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.grandparent.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j5 > 2048) {
                                this.binding.grandparent.supportingDocumentsPage1.setVisibility(8);
                                this.binding.grandparent.cancelSupportingDocumentsPage1Image.setVisibility(8);
                                this.binding.grandparent.supportingDocumentsPage1ImageName.setVisibility(8);
                                this.binding.grandparent.supportingDocumentsPage1ImageSize.setVisibility(8);
                                this.binding.grandparent.supportingDocumentsPage1Image.setVisibility(8);
                                this.binding.grandparent.uploadSupportingDocumentsPage1.setEnabled(true);
                                this.binding.grandparent.uploadSupportingDocumentsPage1.setVisibility(0);
                                this.binding.grandparent.uploadSupportingDocumentsPage2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j6 = j5 / 1024;
                                this.filesize = j6;
                                double dRound3 = Math.round(j6 * 100.0d) / 100.0d;
                                if (dRound3 > 2.0d) {
                                    this.binding.grandparent.supportingDocumentsPage1.setVisibility(8);
                                    this.binding.grandparent.uploadSupportingDocumentsPage1.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                    this.binding.grandparent.supportingDocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.grandparent.supportingDocumentsPage1ImageSize.setText(dRound3 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 105) {
                            long j7 = this.filesize;
                            if (j7 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, "bloletter");
                                this.binding.ivname.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.ivsize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j7 > 2048) {
                                this.binding.bloletterLayout.setVisibility(0);
                                this.binding.viewlayoutpage1.setVisibility(8);
                                this.binding.ivdelete.setVisibility(8);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j8 = j7 / 1024;
                                this.filesize = j8;
                                double dRound4 = Math.round(j8 * 100.0d) / 100.0d;
                                if (dRound4 > 2.0d) {
                                    this.binding.viewlayoutpage1.setVisibility(8);
                                    this.binding.ivdelete.setVisibility(8);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, "bloletter");
                                    this.binding.bloletterLayout.setVisibility(8);
                                    this.binding.viewlayoutpage1.setVisibility(0);
                                    this.binding.ivdelete.setVisibility(0);
                                    ImageView imageView = this.binding.ivviewlayoutpage1;
                                    byte[] bArr = this.pdfbyteArray;
                                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                                    this.binding.letterpage1.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.layoutCapturePhoto.setEnabled(false);
                                    this.binding.ivname.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.ivsize.setText(dRound4 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 104) {
                            long j9 = this.filesize;
                            if (j9 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                this.binding.grandparent.supportingDocumentsPage2.setVisibility(0);
                                this.binding.grandparent.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                this.binding.grandparent.supportingDocumentsPage2ImageName.setVisibility(0);
                                this.binding.grandparent.supportingDocumentsPage2ImageSize.setVisibility(0);
                                this.binding.grandparent.supportingDocumentsPage2Image.setVisibility(0);
                                ImageView imageView2 = this.binding.grandparent.supportingDocumentsPage2Image;
                                byte[] bArr2 = this.pdfbyteArray;
                                imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                                this.binding.grandparent.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.grandparent.uploadSupportingDocumentsPage2.setEnabled(false);
                                this.binding.grandparent.supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.grandparent.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j9 > 2048) {
                                this.binding.grandparent.supportingDocumentsPage2.setVisibility(8);
                                this.binding.grandparent.cancelSupportingDocumentsPage2Image.setVisibility(8);
                                this.binding.grandparent.supportingDocumentsPage2ImageName.setVisibility(8);
                                this.binding.grandparent.supportingDocumentsPage2ImageSize.setVisibility(8);
                                this.binding.grandparent.supportingDocumentsPage2Image.setVisibility(8);
                                this.binding.grandparent.uploadSupportingDocumentsPage2.setEnabled(true);
                                this.binding.grandparent.uploadSupportingDocumentsPage2.setVisibility(0);
                                this.binding.grandparent.uploadSupportingDocumentsPage1.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j10 = j9 / 1024;
                                this.filesize = j10;
                                double dRound5 = Math.round(j10 * 100.0d) / 100.0d;
                                if (dRound5 > 2.0d) {
                                    this.binding.grandparent.supportingDocumentsPage1.setVisibility(8);
                                    this.binding.grandparent.uploadSupportingDocumentsPage2.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                    this.binding.grandparent.supportingDocumentsPage2.setVisibility(0);
                                    this.binding.grandparent.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                    this.binding.grandparent.supportingDocumentsPage2ImageName.setVisibility(0);
                                    this.binding.grandparent.supportingDocumentsPage2ImageSize.setVisibility(0);
                                    this.binding.grandparent.supportingDocumentsPage2Image.setVisibility(0);
                                    ImageView imageView3 = this.binding.grandparent.supportingDocumentsPage2Image;
                                    byte[] bArr3 = this.pdfbyteArray;
                                    imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                                    this.binding.grandparent.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.grandparent.uploadSupportingDocumentsPage2.setEnabled(false);
                                    this.binding.grandparent.supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.grandparent.supportingDocumentsPage2ImageSize.setText(dRound5 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 109) {
                            long j11 = this.filesize;
                            if (j11 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc5Page1str);
                                this.binding.doc5DocumentsPage1.setVisibility(0);
                                this.binding.doc5cancelSupportingDocumentsPage1Image.setVisibility(0);
                                this.binding.doc5DocumentsPage1ImageName.setVisibility(0);
                                this.binding.doc5DocumentsPage1ImageSize.setVisibility(0);
                                this.binding.doc5cancelSupportingDocumentsPage1Image.setVisibility(0);
                                this.binding.doc5uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.doc5uploadSupportingDocumentsPage1.setEnabled(false);
                                this.binding.doc5DocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.doc5DocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j11 > 2048) {
                                this.binding.doc5DocumentsPage1.setVisibility(8);
                                this.binding.doc5cancelSupportingDocumentsPage1Image.setVisibility(8);
                                this.binding.doc5DocumentsPage1ImageName.setVisibility(8);
                                this.binding.doc5DocumentsPage1ImageSize.setVisibility(8);
                                this.binding.doc5cancelSupportingDocumentsPage1Image.setVisibility(8);
                                this.binding.doc5uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.blackColor));
                                this.binding.doc5uploadSupportingDocumentsPage1.setEnabled(true);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j12 = j11 / 1024;
                                this.filesize = j12;
                                double dRound6 = Math.round(j12 * 100.0d) / 100.0d;
                                if (dRound6 > 2.0d) {
                                    this.binding.doc5DocumentsPage1.setVisibility(8);
                                    this.binding.doc5uploadSupportingDocumentsPage1.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc5Page1str);
                                    this.binding.doc5DocumentsPage1.setVisibility(0);
                                    this.binding.doc5cancelSupportingDocumentsPage1Image.setVisibility(0);
                                    this.binding.doc5DocumentsPage1ImageName.setVisibility(0);
                                    this.binding.doc5DocumentsPage1ImageSize.setVisibility(0);
                                    this.binding.doc5cancelSupportingDocumentsPage1Image.setVisibility(0);
                                    this.binding.doc5uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.doc5uploadSupportingDocumentsPage1.setEnabled(false);
                                    this.binding.doc5DocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.doc5DocumentsPage1ImageSize.setText(dRound6 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 110) {
                            long j13 = this.filesize;
                            if (j13 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc5Page2str);
                                this.binding.doc5supportingDocumentsPage2.setVisibility(0);
                                this.binding.doc5cancelSupportingDocumentsPage2Image.setVisibility(0);
                                this.binding.doc5supportingDocumentsPage2ImageName.setVisibility(0);
                                this.binding.doc5supportingDocumentsPage2ImageSize.setVisibility(0);
                                this.binding.doc5supportingDocumentsPage2Image.setVisibility(0);
                                ImageView imageView4 = this.binding.doc5supportingDocumentsPage2Image;
                                byte[] bArr4 = this.pdfbyteArray;
                                imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                                this.binding.doc5uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.doc5uploadSupportingDocumentsPage2.setEnabled(false);
                                this.binding.doc5supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.doc5supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j13 > 2048) {
                                this.binding.doc5supportingDocumentsPage2.setVisibility(8);
                                this.binding.doc5cancelSupportingDocumentsPage2Image.setVisibility(8);
                                this.binding.doc5supportingDocumentsPage2ImageName.setVisibility(8);
                                this.binding.doc5supportingDocumentsPage2ImageSize.setVisibility(8);
                                this.binding.doc5supportingDocumentsPage2Image.setVisibility(8);
                                this.binding.doc5uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.blackColor));
                                this.binding.doc5uploadSupportingDocumentsPage2.setEnabled(true);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j14 = j13 / 1024;
                                this.filesize = j14;
                                double dRound7 = Math.round(j14 * 100.0d) / 100.0d;
                                if (dRound7 > 2.0d) {
                                    this.binding.doc5supportingDocumentsPage2.setVisibility(8);
                                    this.binding.doc5uploadSupportingDocumentsPage2.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc5Page2str);
                                    this.binding.doc5supportingDocumentsPage2.setVisibility(0);
                                    this.binding.doc5cancelSupportingDocumentsPage2Image.setVisibility(0);
                                    this.binding.doc5supportingDocumentsPage2ImageName.setVisibility(0);
                                    this.binding.doc5supportingDocumentsPage2ImageSize.setVisibility(0);
                                    this.binding.doc5supportingDocumentsPage2Image.setVisibility(0);
                                    ImageView imageView5 = this.binding.doc5supportingDocumentsPage2Image;
                                    byte[] bArr5 = this.pdfbyteArray;
                                    imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                                    this.binding.doc5uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.doc5uploadSupportingDocumentsPage2.setEnabled(false);
                                    this.binding.doc5supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.doc5supportingDocumentsPage2ImageSize.setText(dRound7 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 111) {
                            long j15 = this.filesize;
                            if (j15 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc6Page1str);
                                this.binding.doc6DocumentsPage1.setVisibility(0);
                                this.binding.doc6cancelSupportingDocumentsPage1Image.setVisibility(0);
                                this.binding.doc6DocumentsPage1ImageName.setVisibility(0);
                                this.binding.doc6DocumentsPage1ImageSize.setVisibility(0);
                                this.binding.doc6cancelSupportingDocumentsPage1Image.setVisibility(0);
                                this.binding.doc6uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.doc6uploadSupportingDocumentsPage1.setEnabled(false);
                                this.binding.doc6DocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.doc6DocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j15 > 2048) {
                                this.binding.doc6DocumentsPage1.setVisibility(8);
                                this.binding.doc6cancelSupportingDocumentsPage1Image.setVisibility(8);
                                this.binding.doc6DocumentsPage1ImageName.setVisibility(8);
                                this.binding.doc6DocumentsPage1ImageSize.setVisibility(8);
                                this.binding.doc6cancelSupportingDocumentsPage1Image.setVisibility(8);
                                this.binding.doc6uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.blackColor));
                                this.binding.doc6uploadSupportingDocumentsPage1.setEnabled(true);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j16 = j15 / 1024;
                                this.filesize = j16;
                                double dRound8 = Math.round(j16 * 100.0d) / 100.0d;
                                if (dRound8 > 2.0d) {
                                    this.binding.doc6DocumentsPage1.setVisibility(8);
                                    this.binding.doc6uploadSupportingDocumentsPage1.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc6Page1str);
                                    this.binding.doc6DocumentsPage1.setVisibility(0);
                                    this.binding.doc6cancelSupportingDocumentsPage1Image.setVisibility(0);
                                    this.binding.doc6DocumentsPage1ImageName.setVisibility(0);
                                    this.binding.doc6DocumentsPage1ImageSize.setVisibility(0);
                                    this.binding.doc6cancelSupportingDocumentsPage1Image.setVisibility(0);
                                    this.binding.doc6uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.doc6uploadSupportingDocumentsPage1.setEnabled(false);
                                    this.binding.doc6DocumentsPage1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.doc6DocumentsPage1ImageSize.setText(dRound8 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 112) {
                            long j17 = this.filesize;
                            if (j17 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc6Page2str);
                                this.binding.doc6supportingDocumentsPage2.setVisibility(0);
                                this.binding.doc6cancelSupportingDocumentsPage2Image.setVisibility(0);
                                this.binding.doc6supportingDocumentsPage2ImageName.setVisibility(0);
                                this.binding.doc6supportingDocumentsPage2ImageSize.setVisibility(0);
                                this.binding.doc6supportingDocumentsPage2Image.setVisibility(0);
                                ImageView imageView6 = this.binding.doc6supportingDocumentsPage2Image;
                                byte[] bArr6 = this.pdfbyteArray;
                                imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                                this.binding.doc6uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.doc6uploadSupportingDocumentsPage2.setEnabled(false);
                                this.binding.doc6supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.doc6supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j17 > 2048) {
                                this.binding.doc6supportingDocumentsPage2.setVisibility(8);
                                this.binding.doc6cancelSupportingDocumentsPage2Image.setVisibility(8);
                                this.binding.doc6supportingDocumentsPage2ImageName.setVisibility(8);
                                this.binding.doc6supportingDocumentsPage2ImageSize.setVisibility(8);
                                this.binding.doc6supportingDocumentsPage2Image.setVisibility(8);
                                this.binding.doc6uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.blackColor));
                                this.binding.doc6uploadSupportingDocumentsPage2.setEnabled(true);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j18 = j17 / 1024;
                                this.filesize = j18;
                                double dRound9 = Math.round(j18 * 100.0d) / 100.0d;
                                if (dRound9 > 2.0d) {
                                    this.binding.doc6supportingDocumentsPage2.setVisibility(8);
                                    this.binding.doc6uploadSupportingDocumentsPage2.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.doc6Page2str);
                                    this.binding.doc6supportingDocumentsPage2.setVisibility(0);
                                    this.binding.doc6cancelSupportingDocumentsPage2Image.setVisibility(0);
                                    this.binding.doc6supportingDocumentsPage2ImageName.setVisibility(0);
                                    this.binding.doc6supportingDocumentsPage2ImageSize.setVisibility(0);
                                    this.binding.doc6supportingDocumentsPage2Image.setVisibility(0);
                                    ImageView imageView7 = this.binding.doc6supportingDocumentsPage2Image;
                                    byte[] bArr7 = this.pdfbyteArray;
                                    imageView7.setImageBitmap(BitmapFactory.decodeByteArray(bArr7, 0, bArr7.length));
                                    this.binding.doc6uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.doc6uploadSupportingDocumentsPage2.setEnabled(false);
                                    this.binding.doc6supportingDocumentsPage2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.doc6supportingDocumentsPage2ImageSize.setText(dRound9 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 113) {
                            long j19 = this.filesize;
                            if (j19 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentSpinner2Image);
                                this.binding.parentSpinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.parentSpinner1Page1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j19 > 2048) {
                                this.binding.parentSpinner1Page1.setVisibility(8);
                                this.binding.cancelparentSpinner1Page1Image.setVisibility(8);
                                this.binding.parentSpinner1Page1ImageName.setVisibility(8);
                                this.binding.parentSpinner1Page1ImageSize.setVisibility(8);
                                this.binding.parentSpinner1Page1Image.setVisibility(8);
                                this.binding.uploadspinner1Page1.setEnabled(true);
                                this.binding.uploadspinner1Page1.setVisibility(0);
                                this.binding.uploadspinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j20 = j19 / 1024;
                                this.filesize = j20;
                                double dRound10 = Math.round(j20 * 100.0d) / 100.0d;
                                if (dRound10 > 2.0d) {
                                    this.binding.parentSpinner1Page1.setVisibility(8);
                                    this.binding.uploadspinner1Page1.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentSpinner2Image);
                                    this.binding.parentSpinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.parentSpinner1Page1ImageSize.setText(dRound10 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 114) {
                            long j21 = this.filesize;
                            if (j21 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentSpinner2Image2);
                                this.binding.parentSpinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.parentSpinner1Page2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j21 > 2048) {
                                this.binding.parentSpinner1Page2.setVisibility(8);
                                this.binding.cancelparentSpinner1Page2Image.setVisibility(8);
                                this.binding.parentSpinner1Page2ImageName.setVisibility(8);
                                this.binding.parentSpinner1Page2ImageSize.setVisibility(8);
                                this.binding.parentSpinner1Page2Image.setVisibility(8);
                                this.binding.uploadspinner1Page2.setEnabled(true);
                                this.binding.uploadSpinner1Page2.setVisibility(0);
                                this.binding.uploadSpinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j22 = j21 / 1024;
                                this.filesize = j22;
                                double dRound11 = Math.round(j22 * 100.0d) / 100.0d;
                                if (dRound11 > 2.0d) {
                                    this.binding.parentSpinner1Page2Image.setVisibility(8);
                                    this.binding.uploadSpinner1Page2.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentSpinner2Image2);
                                    this.binding.parentSpinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.parentSpinner1Page2ImageSize.setText(dRound11 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 115) {
                            long j23 = this.filesize;
                            if (j23 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandParentspinner1Page1);
                                this.binding.grandparent.grandParentSpinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.grandparent.grandParentSpinner1Page1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j23 > 2048) {
                                this.binding.grandparent.grandParentSpinner1Page1.setVisibility(8);
                                this.binding.grandparent.cancelgrandParentSpinner1Page1Image.setVisibility(8);
                                this.binding.grandparent.grandParentSpinner1Page1ImageName.setVisibility(8);
                                this.binding.grandparent.grandParentSpinner1Page1ImageSize.setVisibility(8);
                                this.binding.grandparent.grandParentSpinner1Page1Image.setVisibility(8);
                                this.binding.grandparent.uploadGpSpinner1Page1.setEnabled(true);
                                this.binding.grandparent.uploadGpSpinner1Page1.setVisibility(0);
                                this.binding.grandparent.uploadGPSpinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j24 = j23 / 1024;
                                this.filesize = j24;
                                double dRound12 = Math.round(j24 * 100.0d) / 100.0d;
                                if (dRound12 > 2.0d) {
                                    this.binding.grandparent.grandParentSpinner1Page1.setVisibility(8);
                                    this.binding.grandparent.uploadGpSpinner1Page1.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandParentspinner1Page1);
                                    this.binding.grandparent.grandParentSpinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.grandparent.grandParentSpinner1Page1ImageSize.setText(dRound12 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 116) {
                            long j25 = this.filesize;
                            if (j25 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandParentspinner1Page2);
                                this.binding.grandparent.grandParentSpinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.grandparent.grandParentSpinner1Page2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j25 > 2048) {
                                this.binding.grandparent.grandParentSpinner1Page2.setVisibility(8);
                                this.binding.grandparent.cancelgrandParentSpinner1Page2Image.setVisibility(8);
                                this.binding.grandparent.grandParentSpinner1Page2ImageName.setVisibility(8);
                                this.binding.grandparent.grandParentSpinner1Page2ImageSize.setVisibility(8);
                                this.binding.grandparent.grandParentSpinner1Page2Image.setVisibility(8);
                                this.binding.grandparent.uploadGPSpinner1Page2.setEnabled(true);
                                this.binding.grandparent.uploadGPSpinner1Page2.setVisibility(0);
                                this.binding.grandparent.uploadGPSpinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j26 = j25 / 1024;
                                this.filesize = j26;
                                double dRound13 = Math.round(j26 * 100.0d) / 100.0d;
                                if (dRound13 > 2.0d) {
                                    this.binding.grandparent.grandParentSpinner1Page2Image.setVisibility(8);
                                    this.binding.grandparent.uploadGPSpinner1Page2.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandParentspinner1Page2);
                                    this.binding.grandparent.grandParentSpinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.grandparent.grandParentSpinner1Page2ImageSize.setText(dRound13 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 133) {
                            long j27 = this.filesize;
                            if (j27 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentDoc3Page1Tag);
                                this.binding.parentDoc3Spinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.parentDoc3Spinner1Page1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j27 > 2048) {
                                this.binding.parentDoc3Spinner1Page1.setVisibility(8);
                                this.binding.cancelDoc3parentSpinner1Page1Image.setVisibility(8);
                                this.binding.parentDoc3Spinner1Page1ImageName.setVisibility(8);
                                this.binding.parentDoc3Spinner1Page1ImageSize.setVisibility(8);
                                this.binding.parentDoc3Spinner1Page1Image.setVisibility(8);
                                this.binding.uploadspinner1Doc3Page1.setEnabled(true);
                                this.binding.uploadspinner1Doc3Page1.setVisibility(0);
                                this.binding.Doc3uploadspinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j28 = j27 / 1024;
                                this.filesize = j28;
                                double dRound14 = Math.round(j28 * 100.0d) / 100.0d;
                                if (dRound14 > 2.0d) {
                                    this.binding.parentDoc3Spinner1Page1.setVisibility(8);
                                    this.binding.uploadspinner1Doc3Page1.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentDoc3Page1Tag);
                                    this.binding.parentDoc3Spinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.parentDoc3Spinner1Page1ImageSize.setText(dRound14 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 134) {
                            long j29 = this.filesize;
                            if (j29 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentDoc3Page2Tag);
                                this.binding.parentDoc3Spinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.parentDoc3Spinner1Page2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j29 > 2048) {
                                this.binding.parentDoc3Spinner1Page2.setVisibility(8);
                                this.binding.cancelparentDoc3Spinner1Page2Image.setVisibility(8);
                                this.binding.parentDoc3Spinner1Page2ImageName.setVisibility(8);
                                this.binding.parentDoc3Spinner1Page2ImageSize.setVisibility(8);
                                this.binding.parentDoc3Spinner1Page2Image.setVisibility(8);
                                this.binding.Doc3uploadspinner1Page2.setEnabled(true);
                                this.binding.Doc3uploadspinner1Page2.setVisibility(0);
                                this.binding.Doc3uploadspinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j30 = j29 / 1024;
                                this.filesize = j30;
                                double dRound15 = Math.round(j30 * 100.0d) / 100.0d;
                                if (dRound15 > 2.0d) {
                                    this.binding.parentDoc3Spinner1Page2Image.setVisibility(8);
                                    this.binding.Doc3uploadspinner1Page2.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentDoc3Page2Tag);
                                    this.binding.parentDoc3Spinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.parentDoc3Spinner1Page2ImageSize.setText(dRound15 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 135) {
                            long j31 = this.filesize;
                            if (j31 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentDoc4Page1Tag);
                                this.binding.parentDoc4Spinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.parentDoc4Spinner1Page1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j31 > 2048) {
                                this.binding.parentDoc4Spinner1Page1.setVisibility(8);
                                this.binding.cancelDoc4parentSpinner1Page1Image.setVisibility(8);
                                this.binding.parentDoc4Spinner1Page1ImageName.setVisibility(8);
                                this.binding.parentDoc4Spinner1Page1ImageSize.setVisibility(8);
                                this.binding.parentDoc4Spinner1Page1Image.setVisibility(8);
                                this.binding.uploadspinner1Doc4Page1.setEnabled(true);
                                this.binding.uploadspinner1Doc4Page1.setVisibility(0);
                                this.binding.Doc4uploadspinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j32 = j31 / 1024;
                                this.filesize = j32;
                                double dRound16 = Math.round(j32 * 100.0d) / 100.0d;
                                if (dRound16 > 2.0d) {
                                    this.binding.parentDoc4Spinner1Page1.setVisibility(8);
                                    this.binding.uploadspinner1Doc4Page1.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentDoc4Page1Tag);
                                    this.binding.parentDoc4Spinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.parentDoc4Spinner1Page1ImageSize.setText(dRound16 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 136) {
                            long j33 = this.filesize;
                            if (j33 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentDoc4Page2Tag);
                                this.binding.parentDoc4Spinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.parentDoc4Spinner1Page2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j33 > 2048) {
                                this.binding.parentDoc4Spinner1Page2.setVisibility(8);
                                this.binding.cancelparentDoc4Spinner1Page2Image.setVisibility(8);
                                this.binding.parentDoc4Spinner1Page2ImageName.setVisibility(8);
                                this.binding.parentDoc4Spinner1Page2ImageSize.setVisibility(8);
                                this.binding.parentDoc4Spinner1Page2Image.setVisibility(8);
                                this.binding.Doc4uploadspinner1Page2.setEnabled(true);
                                this.binding.Doc4uploadspinner1Page2.setVisibility(0);
                                this.binding.Doc4uploadspinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j34 = j33 / 1024;
                                this.filesize = j34;
                                double dRound17 = Math.round(j34 * 100.0d) / 100.0d;
                                if (dRound17 > 2.0d) {
                                    this.binding.parentDoc4Spinner1Page2Image.setVisibility(8);
                                    this.binding.Doc4uploadspinner1Page2.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.parentDoc4Page2Tag);
                                    this.binding.parentDoc4Spinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.parentDoc4Spinner1Page2ImageSize.setText(dRound17 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 137) {
                            long j35 = this.filesize;
                            if (j35 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandparentDoc3Page1Tag);
                                this.binding.grandparent.doc3grandParentSpinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.grandparent.doc3grandParentSpinner1Page1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j35 > 2048) {
                                this.binding.grandparent.doc3grandParentSpinner1Page1.setVisibility(8);
                                this.binding.grandparent.doc3cancelgrandParentSpinner1Page1Image.setVisibility(8);
                                this.binding.grandparent.doc3grandParentSpinner1Page1ImageName.setVisibility(8);
                                this.binding.grandparent.doc3grandParentSpinner1Page1ImageSize.setVisibility(8);
                                this.binding.grandparent.doc3grandParentSpinner1Page1Image.setVisibility(8);
                                this.binding.grandparent.doc3uploadGpSpinner1Page1.setEnabled(true);
                                this.binding.grandparent.doc3uploadGpSpinner1Page1.setVisibility(0);
                                this.binding.grandparent.doc3uploadGPSpinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j36 = j35 / 1024;
                                this.filesize = j36;
                                double dRound18 = Math.round(j36 * 100.0d) / 100.0d;
                                if (dRound18 > 2.0d) {
                                    this.binding.grandparent.doc3grandParentSpinner1Page1.setVisibility(8);
                                    this.binding.grandparent.doc3uploadGpSpinner1Page1.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandparentDoc3Page1Tag);
                                    this.binding.grandparent.doc3grandParentSpinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.grandparent.doc3grandParentSpinner1Page1ImageSize.setText(dRound18 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 138) {
                            long j37 = this.filesize;
                            if (j37 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandparentDoc3Page2Tag);
                                this.binding.grandparent.doc3grandParentSpinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.grandparent.doc3grandParentSpinner1Page2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j37 > 2048) {
                                this.binding.grandparent.doc3grandParentSpinner1Page2.setVisibility(8);
                                this.binding.grandparent.doc3cancelgrandParentSpinner1Page2Image.setVisibility(8);
                                this.binding.grandparent.doc3grandParentSpinner1Page2ImageName.setVisibility(8);
                                this.binding.grandparent.doc3grandParentSpinner1Page2ImageSize.setVisibility(8);
                                this.binding.grandparent.doc3grandParentSpinner1Page2Image.setVisibility(8);
                                this.binding.grandparent.doc3uploadGPSpinner1Page2.setEnabled(true);
                                this.binding.grandparent.doc3uploadGPSpinner1Page2.setVisibility(0);
                                this.binding.grandparent.doc3uploadGPSpinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j38 = j37 / 1024;
                                this.filesize = j38;
                                double dRound19 = Math.round(j38 * 100.0d) / 100.0d;
                                if (dRound19 > 2.0d) {
                                    this.binding.grandparent.doc3grandParentSpinner1Page2Image.setVisibility(8);
                                    this.binding.grandparent.doc3uploadGPSpinner1Page2.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandparentDoc3Page2Tag);
                                    this.binding.grandparent.doc3grandParentSpinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.grandparent.doc3grandParentSpinner1Page2ImageSize.setText(dRound19 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 139) {
                            long j39 = this.filesize;
                            if (j39 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandparentDoc4Page1Tag);
                                this.binding.grandparent.doc4grandParentSpinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.grandparent.doc4grandParentSpinner1Page1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j39 > 2048) {
                                this.binding.grandparent.doc4grandParentSpinner1Page1.setVisibility(8);
                                this.binding.grandparent.doc4cancelgrandParentSpinner1Page1Image.setVisibility(8);
                                this.binding.grandparent.doc4grandParentSpinner1Page1ImageName.setVisibility(8);
                                this.binding.grandparent.doc4grandParentSpinner1Page1ImageSize.setVisibility(8);
                                this.binding.grandparent.doc4grandParentSpinner1Page1Image.setVisibility(8);
                                this.binding.grandparent.doc4uploadGpSpinner1Page1.setEnabled(true);
                                this.binding.grandparent.doc4uploadGpSpinner1Page1.setVisibility(0);
                                this.binding.grandparent.doc4uploadGPSpinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j40 = j39 / 1024;
                                this.filesize = j40;
                                double dRound20 = Math.round(j40 * 100.0d) / 100.0d;
                                if (dRound20 > 2.0d) {
                                    this.binding.grandparent.doc4grandParentSpinner1Page1.setVisibility(8);
                                    this.binding.grandparent.doc4uploadGpSpinner1Page1.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandparentDoc4Page1Tag);
                                    this.binding.grandparent.doc4grandParentSpinner1Page1ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.grandparent.doc4grandParentSpinner1Page1ImageSize.setText(dRound20 + getString(R.string.mbMsg));
                                }
                            }
                        } else if (requestCode == 140) {
                            long j41 = this.filesize;
                            if (j41 < 1024) {
                                uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandparentDoc4Page2Tag);
                                this.binding.grandparent.doc4grandParentSpinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                this.binding.grandparent.doc4grandParentSpinner1Page2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                            } else if (j41 > 2048) {
                                this.binding.grandparent.doc4grandParentSpinner1Page2.setVisibility(8);
                                this.binding.grandparent.doc4cancelgrandParentSpinner1Page2Image.setVisibility(8);
                                this.binding.grandparent.doc4grandParentSpinner1Page2ImageName.setVisibility(8);
                                this.binding.grandparent.doc4grandParentSpinner1Page2ImageSize.setVisibility(8);
                                this.binding.grandparent.doc4grandParentSpinner1Page2Image.setVisibility(8);
                                this.binding.grandparent.doc4uploadGPSpinner1Page2.setEnabled(true);
                                this.binding.grandparent.doc4uploadGPSpinner1Page2.setVisibility(0);
                                this.binding.grandparent.doc4uploadGPSpinner1Page2.setVisibility(0);
                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                            } else {
                                long j42 = j41 / 1024;
                                this.filesize = j42;
                                double dRound21 = Math.round(j42 * 100.0d) / 100.0d;
                                if (dRound21 > 2.0d) {
                                    this.binding.grandparent.doc4grandParentSpinner1Page2Image.setVisibility(8);
                                    this.binding.grandparent.doc4uploadGPSpinner1Page2.setEnabled(true);
                                    showDialog1(this.alertText, this.imgmsg);
                                } else {
                                    uploadPhoto(this.state, this.acNo, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.grandparentDoc4Page2Tag);
                                    this.binding.grandparent.doc4grandParentSpinner1Page2ImageName.setText(strArrSplit[strArrSplit.length - 1]);
                                    this.binding.grandparent.doc4grandParentSpinner1Page2ImageSize.setText(dRound21 + getString(R.string.mbMsg));
                                }
                            }
                        }
                        cursorQuery.close();
                        return;
                    }
                    cursorQuery.close();
                    return;
                } catch (Exception e2) {
                    exc = e2;
                }
            } catch (Exception e3) {
                e = e3;
                exc = e;
            }
        } catch (Exception e4) {
            e = e4;
        }
        exc = e;
        Logger.d("", exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadDocuments(VerifyPayload efPayload, int pos, final Dialog dialog, String category, String parentDoc1, String parentDoc2, String progenyDoc1, String progenyDoc2, String relationType) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        map2.put("epicId", efPayload.getEpicId());
        map2.put("epicNo", efPayload.getEpicNo());
        map2.put("state", this.state);
        map2.put("category", category.toLowerCase());
        map2.put("parentDoc1", parentDoc1);
        map2.put("parentDoc2", parentDoc2);
        map2.put("progenyDoc1", progenyDoc1);
        map2.put("progenyDoc2", progenyDoc2);
        map2.put("relationType", relationType);
        map2.put("bloLetterUrl", this.bloletter);
        map2.put("lastSirDoc1", this.doc5Page1Url);
        map2.put("lastSirDoc2", this.doc5Page2URL);
        map2.put("parentDocType1", Integer.valueOf(this.docIdParent));
        map2.put("parentDocType2", Integer.valueOf(this.docIdParent1));
        map2.put("progenyDocType1", Integer.valueOf(this.docIdGrandParent));
        map2.put("progenyDocType2", Integer.valueOf(this.docIdGrandParent1));
        map2.put("parentDoc3", this.parentSpinner2ImageUrl);
        map2.put("parentDoc4", this.parentSpinner2ImageUrl1);
        map2.put("progenyDoc3", this.grandParentSpinner2ImageUrl);
        map2.put("progenyDoc4", this.grandParentSpinner2ImageUrl1);
        map2.put("parentDocType3", Integer.valueOf(this.docIdParent2));
        map2.put("parentDocType4", Integer.valueOf(this.docIdParent3));
        map2.put("progenyDocType3", Integer.valueOf(this.doc3IdGranprent));
        map2.put("progenyDocType4", Integer.valueOf(this.doc4IdGrandParent));
        map2.put("parentDoc5", this.parentDoc3Page1ImageUrl);
        map2.put("parentDoc6", this.parentDoc3Page2ImageUrl);
        map2.put("parentDoc7", this.parentDoc4Page1ImageUrl);
        map2.put("parentDoc8", this.parentDoc4Page2ImageUrl);
        map2.put("progenyDoc5", this.grandParentDoc3Page1Url);
        map2.put("progenyDoc6", this.grandParentDoc3Page2Url);
        map2.put("progenyDoc7", this.grandParentDoc4Page1Url);
        map2.put("progenyDoc8", this.grandParentDoc4Page2Url);
        String lowerCase = this.state.toLowerCase();
        Log.d("uploadDocuments request", map2.toString());
        Call<AsdActionrRoot> anomalyDocument = this.service.setAnomalyDocument(lowerCase, map, map2);
        this.alertDialog.show();
        anomalyDocument.enqueue(new Callback<AsdActionrRoot>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.49
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
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
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    try {
                        Utils utils = AnomalyListActivity.this.utils;
                        ?? r0 = AnomalyListActivity.this;
                        utils.infoDialogAction(r0, r0.getResources().getString(R.string.info), TextUtils.isEmpty(((AsdActionrRoot) response.body()).getMessage()) ? "" : ((AsdActionrRoot) response.body()).getMessage(), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.49.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                SharedPref.getInstance(AnomalyListActivity.this).setepicid("");
                                dialog.dismiss();
                                AnomalyListActivity.this.relativeDocument1UrlS = "";
                                AnomalyListActivity.this.relativeDocument2UrlS = "";
                                AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS = "";
                                AnomalyListActivity.this.relativeSupportingDocumentPage2UrlS = "";
                                AnomalyListActivity.this.bloletter = "";
                                AnomalyListActivity.this.docIdParent = 0;
                                AnomalyListActivity.this.docIdParent1 = 0;
                                AnomalyListActivity.this.docIdGrandParent = 0;
                                AnomalyListActivity.this.docIdGrandParent1 = 0;
                                AnomalyListActivity.this.parentSpinner2ImageUrl = "";
                                AnomalyListActivity.this.parentSpinner2ImageUrl1 = "";
                                AnomalyListActivity.this.grandParentSpinner2ImageUrl = "";
                                AnomalyListActivity.this.grandParentSpinner2ImageUrl1 = "";
                                AnomalyListActivity.this.getVerifyCitizenFormList();
                            }
                        });
                        return;
                    } catch (Exception unused) {
                        if (AnomalyListActivity.this.alertDialog != null) {
                            AnomalyListActivity.this.alertDialog.dismiss();
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                    AnomalyListActivity.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException unused2) {
                    if (AnomalyListActivity.this.alertDialog != null) {
                        AnomalyListActivity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<AsdActionrRoot> call, Throwable t) {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                Logger.e("efCount", t.getMessage());
            }
        });
    }

    private void handledeleteClick() {
        this.binding.deleteFrontImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.50
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AnomalyListActivity.this.binding.firstLL.setVisibility(8);
                AnomalyListActivity.this.binding.lvPage1EnumrationChoose.setVisibility(0);
                AnomalyListActivity.this.binding.enumerationFormLayout.setVisibility(0);
                AnomalyListActivity.this.relativeDocument1UrlS = "";
                if (TextUtils.isEmpty(AnomalyListActivity.this.relativeDocument1UrlS) && TextUtils.isEmpty(AnomalyListActivity.this.relativeDocument2UrlS)) {
                    AnomalyListActivity.this.binding.lvPage2EnumrationChoose.setVisibility(0);
                    AnomalyListActivity.this.binding.fbImageLL.setVisibility(8);
                }
                if (AnomalyListActivity.this.binding.secondLL.getVisibility() != 8 || TextUtils.isEmpty(AnomalyListActivity.this.relativeDocument2UrlS)) {
                    return;
                }
                AnomalyListActivity.this.binding.fbImageLL.setVisibility(8);
            }
        });
        this.binding.deleteBackImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.51
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AnomalyListActivity.this.binding.secondLL.setVisibility(8);
                AnomalyListActivity.this.binding.lvPage2EnumrationChoose.setVisibility(0);
                AnomalyListActivity.this.relativeDocument2UrlS = "";
                if (TextUtils.isEmpty(AnomalyListActivity.this.relativeDocument1UrlS) && TextUtils.isEmpty(AnomalyListActivity.this.relativeDocument2UrlS)) {
                    AnomalyListActivity.this.binding.lvPage1EnumrationChoose.setVisibility(0);
                    AnomalyListActivity.this.binding.fbImageLL.setVisibility(8);
                }
                if (AnomalyListActivity.this.binding.firstLL.getVisibility() == 8 && !TextUtils.isEmpty(AnomalyListActivity.this.relativeDocument1UrlS)) {
                    AnomalyListActivity.this.binding.fbImageLL.setVisibility(8);
                }
                AnomalyListActivity.this.binding.enumerationFormLayout.setVisibility(0);
            }
        });
        this.binding.grandparent.deleteFrontImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.52
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AnomalyListActivity.this.binding.grandparent.firstLL1.setVisibility(8);
                AnomalyListActivity.this.binding.grandparent.lvSupportChoose1.setVisibility(0);
                AnomalyListActivity.this.binding.grandparent.supprtingDocumentsLayout.setVisibility(0);
                AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS = "";
                if (TextUtils.isEmpty(AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(AnomalyListActivity.this.relativeSupportingDocumentPage2UrlS)) {
                    AnomalyListActivity.this.binding.grandparent.lvSupportChoose2.setVisibility(0);
                }
            }
        });
        this.binding.grandparent.deleteBackImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.53
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AnomalyListActivity.this.binding.grandparent.secondLL1.setVisibility(8);
                AnomalyListActivity.this.binding.grandparent.lvSupportChoose2.setVisibility(0);
                AnomalyListActivity.this.relativeSupportingDocumentPage2UrlS = "";
                if (TextUtils.isEmpty(AnomalyListActivity.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(AnomalyListActivity.this.relativeSupportingDocumentPage2UrlS)) {
                    AnomalyListActivity.this.binding.grandparent.lvSupportChoose1.setVisibility(0);
                }
                AnomalyListActivity.this.binding.grandparent.supprtingDocumentsLayout.setVisibility(0);
            }
        });
    }

    public void checkImageFromURL(final String preSignedUrl, final DownloadCallback callback) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$checkImageFromURL$27(preSignedUrl, callback);
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
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
    public /* synthetic */ void lambda$checkImageFromURL$27(String str, final DownloadCallback downloadCallback) throws Throwable {
        String str2;
        ?? r4 = 0;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                try {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
                    try {
                        httpsURLConnection2.setSSLSocketFactory(SSLFactoryHelper.getSSLParams((Context) this, new int[]{getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", getPackageName()), getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", getPackageName())}).sslSocketFactory);
                        httpsURLConnection2.setConnectTimeout(XmlValidationError.UNDEFINED);
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
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda0
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
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$$ExternalSyntheticLambda11
                            @Override // java.lang.Runnable
                            public final void run() {
                                AnomalyListActivity.DownloadCallback downloadCallback2 = downloadCallback;
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
        if (length >= 3 && (head[0] & UByte.MAX_VALUE) == 255 && (head[1] & UByte.MAX_VALUE) == 216 && (head[2] & UByte.MAX_VALUE) == 255) {
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

    /* JADX WARN: Multi-variable type inference failed */
    private void searchDetails(String oldState, String oldAc, String OldPart, String oldPslNo) {
        this.commomUtility.callVerifyRelativeApi(this, this.token, this.atkband, this.rtkband, oldState, oldAc, OldPart, oldPslNo, new SearchByAcPartCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.54
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
            /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback
            public void onCallBack(int code, List<Payload> datalist, String message) {
                if (code == 200) {
                    if (datalist != null && datalist.size() > 0) {
                        Payload payload = datalist.get(0);
                        AnomalyListActivity.this.binding.tvStateName.setText(payload.getOldStateName());
                        AnomalyListActivity.this.binding.tvDistrictName.setText(String.valueOf(payload.getOldDistNo()) + " - " + (TextUtils.isEmpty(payload.getOldDistName()) ? "" : payload.getOldDistName()));
                        AnomalyListActivity.this.binding.tvAcName.setText(String.valueOf(payload.getOldAcNo()) + "  -  " + (TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName()));
                        AnomalyListActivity.this.binding.tvPartName.setText(String.valueOf(payload.getOldPartNumber()) + "  -  " + (TextUtils.isEmpty(payload.getOldPartName()) ? "" : payload.getOldPartName()));
                        AnomalyListActivity.this.binding.tvSerialName.setText(String.valueOf(payload.getOldPartSerialNo()));
                        AnomalyListActivity.this.binding.tvSectionNo.setText("");
                        AnomalyListActivity.this.binding.tvOldAge.setText(String.valueOf(payload.getAge()));
                        AnomalyListActivity.this.binding.tvOldEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                        if (!TextUtils.isEmpty(payload.getRelationType())) {
                            String relationType = payload.getRelationType();
                            if (relationType.equalsIgnoreCase("F") || relationType.equalsIgnoreCase("FATHER") || relationType.equalsIgnoreCase("FTHR")) {
                                AnomalyListActivity.this.binding.tvRelativeType.setText("Father");
                            } else if (relationType.equalsIgnoreCase("M") || relationType.equalsIgnoreCase("MOTHER") || relationType.equalsIgnoreCase("MTHR")) {
                                AnomalyListActivity.this.binding.tvRelativeType.setText("Mother");
                            } else if (relationType.equalsIgnoreCase("H") || relationType.equalsIgnoreCase("HUSBAND") || relationType.equalsIgnoreCase("HSBN")) {
                                AnomalyListActivity.this.binding.tvRelativeType.setText("Husband");
                            } else if (relationType.equalsIgnoreCase("W") || relationType.equalsIgnoreCase("WIFE")) {
                                AnomalyListActivity.this.binding.tvRelativeType.setText("Wife");
                            } else if (relationType.equalsIgnoreCase("L") || relationType.equalsIgnoreCase("OTHER") || relationType.equalsIgnoreCase("O")) {
                                AnomalyListActivity.this.binding.tvRelativeType.setText("Other");
                            } else if (relationType.equalsIgnoreCase("GMTH")) {
                                AnomalyListActivity.this.binding.tvRelativeType.setText("Grand Mother");
                            } else if (relationType.equalsIgnoreCase("GFTH")) {
                                AnomalyListActivity.this.binding.tvRelativeType.setText("Grand Father");
                            } else {
                                AnomalyListActivity.this.binding.tvRelativeType.setText(relationType);
                            }
                        }
                        if (TextUtils.isEmpty(payload.getOldFullName()) && !TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            AnomalyListActivity.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                            AnomalyListActivity.this.binding.lvVernacularName.setVisibility(8);
                        } else if (TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            AnomalyListActivity.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            AnomalyListActivity.this.binding.lvVernacularName.setVisibility(8);
                        } else if (payload.getOldFullName().equalsIgnoreCase(payload.getOldFullNameL1())) {
                            AnomalyListActivity.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            AnomalyListActivity.this.binding.lvVernacularName.setVisibility(8);
                        } else {
                            AnomalyListActivity.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            AnomalyListActivity.this.binding.tvElectorNamev1.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                        }
                        if (TextUtils.isEmpty(payload.getOldRelativeFullName()) && !TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            AnomalyListActivity.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            AnomalyListActivity.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else if (TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            AnomalyListActivity.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            AnomalyListActivity.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else if (payload.getOldRelativeFullName().equalsIgnoreCase(payload.getOldRelativeFullNameL1())) {
                            AnomalyListActivity.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            AnomalyListActivity.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else {
                            AnomalyListActivity.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            AnomalyListActivity.this.binding.tvRelativeNamev1.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    Utils utils = AnomalyListActivity.this.utils;
                    ?? r5 = AnomalyListActivity.this;
                    utils.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = AnomalyListActivity.this.utils;
                ?? r6 = AnomalyListActivity.this;
                utils2.infoDialog(r6, r6.getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getDocType() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", "master");
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getDocType(map).enqueue(new AnonymousClass55());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$55, reason: invalid class name */
    class AnonymousClass55 implements Callback<DocTypeRoot> {
        AnonymousClass55() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
        /* JADX WARN: Type inference failed for: r1v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
        /* JADX WARN: Type inference failed for: r7v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
        /* JADX WARN: Type inference failed for: r7v23, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<DocTypeRoot> call, Response<DocTypeRoot> response) {
            if (response.code() == 200) {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                String string = AnomalyListActivity.this.getString(R.string.relative_2003_documentSpinner);
                if (((DocTypeRoot) response.body()).getPayload().isEmpty()) {
                    return;
                }
                AnomalyListActivity.this.documenttypeList.clear();
                AnomalyListActivity.this.documenttypeList = (ArrayList) ((DocTypeRoot) response.body()).getPayload();
                AnomalyListActivity.this.docnameList.clear();
                AnomalyListActivity.this.docCodeist.clear();
                AnomalyListActivity.this.docnameList.add(string);
                AnomalyListActivity.this.docCodeist.add(0);
                for (int i = 0; i < AnomalyListActivity.this.documenttypeList.size(); i++) {
                    AnomalyListActivity.this.docnameList.add(AnomalyListActivity.this.documenttypeList.get(i).getDocName());
                    AnomalyListActivity.this.docCodeist.add(Integer.valueOf(AnomalyListActivity.this.documenttypeList.get(i).getDocId()));
                }
                ?? r7 = AnomalyListActivity.this;
                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r7, R.layout.blo_spinner_dropdown, r7.docnameList);
                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                AnomalyListActivity.this.binding.documentSpinnerParent.setAdapter((SpinnerAdapter) arrayAdapter);
                AnomalyListActivity.this.binding.grandparent.documentSpinnerGrandParent.setAdapter((SpinnerAdapter) arrayAdapter);
                AnomalyListActivity.this.binding.documentSpinner2Parent.setAdapter((SpinnerAdapter) arrayAdapter);
                AnomalyListActivity.this.binding.grandparent.documentSpinner2GrandParent.setAdapter((SpinnerAdapter) arrayAdapter);
                AnomalyListActivity.this.binding.grandparent.doc3documentSpinner2GrandParent.setAdapter((SpinnerAdapter) arrayAdapter);
                AnomalyListActivity.this.binding.grandparent.doc4documentSpinner2GrandParent.setAdapter((SpinnerAdapter) arrayAdapter);
                AnomalyListActivity.this.binding.documentSpinner3Parent.setAdapter((SpinnerAdapter) arrayAdapter);
                AnomalyListActivity.this.binding.documentSpinner4Parent.setAdapter((SpinnerAdapter) arrayAdapter);
                return;
            }
            if (response.code() == 401) {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = AnomalyListActivity.this.commomUtility;
                    ?? r8 = AnomalyListActivity.this;
                    commomUtility.getRefreshToken(r8, ((AnomalyListActivity) r8).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$55$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i2, str, str2);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e("", e.toString());
                    return;
                }
            }
            try {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                Logger.e("", jSONObject.optString("message"));
                Utils utils = AnomalyListActivity.this.utils;
                ?? r1 = AnomalyListActivity.this;
                utils.infoDialog(r1, r1.getResources().getString(R.string.alertMsg), strOptString);
            } catch (IOException | JSONException e2) {
                if (AnomalyListActivity.this.alertDialog != null) {
                    AnomalyListActivity.this.alertDialog.dismiss();
                }
                Utils utils2 = AnomalyListActivity.this.utils;
                ?? r2 = AnomalyListActivity.this;
                utils2.infoDialog(r2, r2.getResources().getString(R.string.alertMsg), AnomalyListActivity.this.getResources().getString(R.string.something_went_wrong));
                Logger.e("", e2.getMessage());
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
            AnomalyListActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                AnomalyListActivity.this.commomUtility.showMessageOK(AnomalyListActivity.this, AnomalyListActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity$55$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            AnomalyListActivity.this.token = "Bearer " + str;
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setRefreshToken(str2);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setToken("Bearer " + str);
            AnomalyListActivity.this.getDocType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AnomalyListActivity.this.getApplicationContext()).setLocaleBool(false);
            AnomalyListActivity.this.startActivity(new Intent(AnomalyListActivity.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onFailure(Call<DocTypeRoot> call, Throwable t) {
            if (AnomalyListActivity.this.alertDialog != null) {
                AnomalyListActivity.this.alertDialog.dismiss();
            }
            Utils utils = AnomalyListActivity.this.utils;
            ?? r0 = AnomalyListActivity.this;
            utils.infoDialog(r0, r0.getResources().getString(R.string.alertMsg), AnomalyListActivity.this.getResources().getString(R.string.something_went_wrong));
            Logger.d("", "OnFailure" + t.getMessage());
        }
    }

    private void initializeSpinnerTouch() {
        this.binding.documentSpinnerParent.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.56
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                AnomalyListActivity.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.documentSpinner3Parent.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.57
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                AnomalyListActivity.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.documentSpinner4Parent.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.58
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                AnomalyListActivity.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.grandparent.documentSpinnerGrandParent.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.59
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                AnomalyListActivity.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.documentSpinner2Parent.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.60
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                AnomalyListActivity.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.grandparent.documentSpinner2GrandParent.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.61
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                AnomalyListActivity.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.grandparent.doc3documentSpinner2GrandParent.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.62
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                AnomalyListActivity.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.grandparent.doc4documentSpinner2GrandParent.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity.63
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                AnomalyListActivity.this.isUserSelected = true;
                return false;
            }
        });
    }
}
