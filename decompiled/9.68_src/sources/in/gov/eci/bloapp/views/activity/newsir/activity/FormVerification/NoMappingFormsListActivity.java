package in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.entity.FormDataVariables;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.NomappingListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallbackNew;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class NoMappingFormsListActivity extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private static String SESSION = "";
    private String acNo;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<FormDataVariables> al;
    AlertDialog alertDialog;
    private String atkband;
    private ImageView back_btn_iv;
    String barcode;
    Button btScanCode;
    List<String> efOptionList;
    List<VerifyPayload> formlist;
    String[] listArray;
    TextView noteOpen;
    private String partNo;
    RecyclerView recyclerView;
    private String refreshToken;
    private String rtkband;
    ConstraintLayout scanCode;
    EditText search;
    Spinner spinner;
    private String state;
    TextView textView3;
    TextView textView5;
    private String token;
    Utils utils;
    NomappingListAdapter verifyCitizenListAdapter;
    String alertText = "";
    String TAG = "FormDataNewTAG";
    CommomUtility commomUtility = new CommomUtility();
    int selfCount = 0;
    int progenyCount = 0;
    int neitherCount = 0;

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
        this.noteOpen.setVisibility(0);
        this.spinner.setVisibility(8);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.al = new ArrayList<>();
        this.alertText = getString(R.string.alertMsg);
        this.utils = new Utils();
        initClickListener();
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
        getListOfNaCategory();
        this.alertDialog.show();
        this.textView5.setText("v" + this.commomUtility.appversion);
        this.textView3.setText(getResources().getString(R.string.no_mapping));
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

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
        super.onActivityResult(requestCode, resultCode, data);
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity$$ExternalSyntheticLambda1
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
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
        this.scanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                NoMappingFormsListActivity.this.cameraPermission();
            }
        });
        this.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                NoMappingFormsListActivity.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getListOfNaCategory() {
        this.commomUtility.getListOfNaCategory(this, this.token, this.atkband, this.rtkband, this.state, this.acNo, this.partNo, "", new VerifyCitizenListCallbackNew() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity.3
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallbackNew
            public void onCallBack(int code, List<VerifyPayload> datalist, String message) {
                if (code == 200) {
                    NoMappingFormsListActivity.this.alertDialog.dismiss();
                    if (datalist != null && datalist.size() > 0) {
                        NoMappingFormsListActivity.this.noteOpen.setText("Total Records - " + datalist.size());
                        NoMappingFormsListActivity.this.formlist = datalist;
                        NoMappingFormsListActivity.this.verifyCitizenListAdapter = new NomappingListAdapter(datalist, NoMappingFormsListActivity.this);
                        NoMappingFormsListActivity.this.recyclerView.setAdapter(NoMappingFormsListActivity.this.verifyCitizenListAdapter);
                        NoMappingFormsListActivity.this.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity.3.1
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
                                for (VerifyPayload verifyPayload : NoMappingFormsListActivity.this.formlist) {
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
                                NoMappingFormsListActivity.this.verifyCitizenListAdapter.fun(arrayList);
                            }
                        });
                        return;
                    }
                    NoMappingFormsListActivity.this.alertDialog.dismiss();
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    Utils utils = NoMappingFormsListActivity.this.utils;
                    ?? r4 = NoMappingFormsListActivity.this;
                    utils.infoDialog(r4, r4.getResources().getString(R.string.alertMsg), message);
                    return;
                }
                NoMappingFormsListActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = NoMappingFormsListActivity.this.utils;
                ?? r5 = NoMappingFormsListActivity.this;
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

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity$$ExternalSyntheticLambda3
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity$$ExternalSyntheticLambda0
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
}
