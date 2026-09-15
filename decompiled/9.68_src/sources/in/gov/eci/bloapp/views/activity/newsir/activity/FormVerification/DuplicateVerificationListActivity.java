package in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.entity.FormDataVariables;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.ClusterDetailsListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.adapter.DuplicateVerificationListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallbackNew;
import in.gov.eci.bloapp.views.activity.newsir.model.AsdActionrRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.ClusterDetailsPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.ClusterDetailsRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DuplicateVerificationListActivity extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private static String SESSION = "";
    private String acNo;
    private Call<JsonObject> activeCall;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<FormDataVariables> al;
    AlertDialog alertDialog;
    private String atkband;
    private ImageView back_btn_iv;
    String barcode;
    Button btScanCode;
    ArrayList<ClusterDetailsPayload> clusterlist;
    CommomUtility commonUtilClass;
    List<String> efOptionList;
    List<VerifyPayload> formlist;
    String[] listArray;
    TextView noteOpen;
    private String partNo;
    private ProgressBar progressBar;
    RecyclerView recyclerView;
    private String refreshToken;
    private String rtkband;
    ConstraintLayout scanCode;
    EditText search;
    UserClient service;
    Spinner spinner;
    private String state;
    TextView textView3;
    TextView textView5;
    private String token;
    Utils utils;
    DuplicateVerificationListAdapter verifyCitizenListAdapter;
    String alertText = "";
    String TAG = "FormDataNewTAG";
    CommomUtility commomUtility = new CommomUtility();
    int deceasedCount = 0;
    int eightyFivePlusCount = 0;
    private int currentIndex = 0;
    private final AtomicBoolean cancelled = new AtomicBoolean(false);

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
        this.service = (UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.al = new ArrayList<>();
        this.alertText = getString(R.string.alertMsg);
        this.utils = new Utils();
        initClickListener();
        this.noteOpen.setVisibility(8);
        this.spinner.setVisibility(8);
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
        this.commonUtilClass = new CommomUtility();
        this.noteOpen.setText("Click here to view PSE/DSE count ");
        this.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View viewInflate2 = LayoutInflater.from(DuplicateVerificationListActivity.this).inflate(R.layout.category_count_dialog_layout, (ViewGroup) null);
                TextView textView = (TextView) viewInflate2.findViewById(R.id.txtSelfCount);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.txtProgeny);
                TextView textView3 = (TextView) viewInflate2.findViewById(R.id.txtNeither);
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.noteTotal);
                textView.setText(DuplicateVerificationListActivity.this.getString(R.string.pse) + " - " + DuplicateVerificationListActivity.this.deceasedCount);
                textView2.setText(DuplicateVerificationListActivity.this.getString(R.string.dse) + " - " + DuplicateVerificationListActivity.this.eightyFivePlusCount);
                textView3.setVisibility(8);
                textView4.setText(DuplicateVerificationListActivity.this.getString(R.string.total_document_upload_count) + StringUtils.SPACE + (DuplicateVerificationListActivity.this.deceasedCount + DuplicateVerificationListActivity.this.eightyFivePlusCount));
                new AlertDialog.Builder(DuplicateVerificationListActivity.this).setTitle(DuplicateVerificationListActivity.this.getString(R.string.pse_dse_count)).setView(viewInflate2).setPositiveButton(DuplicateVerificationListActivity.this.getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });
        this.textView5.setText("v" + this.commomUtility.appversion);
        this.textView3.setText(getResources().getString(R.string.duplicate_verification));
        this.listArray = getResources().getStringArray(R.array.pase_dse_options);
        this.efOptionList = new ArrayList(Arrays.asList(this.listArray));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, android.R.layout.simple_spinner_item, this.efOptionList);
        this.adapterSpinner = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter((SpinnerAdapter) this.adapterSpinner);
        this.spinner.setSelection(0);
        this.spinner.setOnItemSelectedListener(this);
        if (this.deceasedCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(1));
            String str = getString(R.string.pse) + " - " + this.deceasedCount;
            this.efOptionList.add(1, str);
            this.efOptionList.set(1, str);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.eightyFivePlusCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(2));
            this.efOptionList.add(2, getString(R.string.dse) + " -" + this.eightyFivePlusCount);
            this.adapterSpinner.notifyDataSetChanged();
        }
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity$$ExternalSyntheticLambda1
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
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
        this.scanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DuplicateVerificationListActivity.this.cameraPermission();
            }
        });
        this.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DuplicateVerificationListActivity.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        onBackPressed();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity$4, reason: invalid class name */
    class AnonymousClass4 implements VerifyCitizenListCallbackNew {
        AnonymousClass4() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity] */
        /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity] */
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
                DuplicateVerificationListActivity.this.alertDialog.dismiss();
                if (datalist != null && datalist.size() > 0) {
                    if (DuplicateVerificationListActivity.this.formlist != null && DuplicateVerificationListActivity.this.formlist.size() > 0) {
                        DuplicateVerificationListActivity.this.formlist.clear();
                    }
                    DuplicateVerificationListActivity.this.formlist = datalist;
                    DuplicateVerificationListActivity.this.verifyCitizenListAdapter = new DuplicateVerificationListAdapter(DuplicateVerificationListActivity.this.formlist, DuplicateVerificationListActivity.this, new ItemClickCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.4.1
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
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback
                        public void onClicked(final VerifyPayload formverificationPayload, final String type) {
                            if (type.equalsIgnoreCase("viewdetails")) {
                                DuplicateVerificationListActivity.this.getDetailByClusterId(formverificationPayload);
                            } else {
                                DuplicateVerificationListActivity.this.utils.decisionDialog(DuplicateVerificationListActivity.this, "Confirmation", "Are you sure do you want to verify ?", "Yes", "No", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.4.1.1
                                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                                    public void onNegativeButtonClicked() {
                                    }

                                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                                    public void onPositiveButtonClicked() {
                                        DuplicateVerificationListActivity.this.noActionRequired(formverificationPayload, Integer.parseInt(type));
                                    }
                                });
                            }
                        }
                    });
                    DuplicateVerificationListActivity.this.recyclerView.setAdapter(DuplicateVerificationListActivity.this.verifyCitizenListAdapter);
                    DuplicateVerificationListActivity.this.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.4.2
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
                            for (VerifyPayload verifyPayload : DuplicateVerificationListActivity.this.formlist) {
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
                            DuplicateVerificationListActivity.this.verifyCitizenListAdapter.fun(arrayList);
                        }
                    });
                    return;
                }
                DuplicateVerificationListActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils = DuplicateVerificationListActivity.this.utils;
                ?? r4 = DuplicateVerificationListActivity.this;
                utils.infoDialog(r4, r4.getResources().getString(R.string.alertMsg), message);
                return;
            }
            DuplicateVerificationListActivity.this.alertDialog.dismiss();
            if (TextUtils.isEmpty(message)) {
                return;
            }
            Utils utils2 = DuplicateVerificationListActivity.this.utils;
            ?? r5 = DuplicateVerificationListActivity.this;
            utils2.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getVerifyCitizenFormList() {
        this.commomUtility.getDsepseList(this, this.token, this.atkband, this.rtkband, this.state, this.acNo, this.partNo, "", new AnonymousClass4());
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity$$ExternalSyntheticLambda0
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity$$ExternalSyntheticLambda2
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
    public void noActionRequired(VerifyPayload efPayload, final int pos) {
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
        Call<AsdActionrRoot> callUpdateAsdAction = this.service.updateAsdAction(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        callUpdateAsdAction.enqueue(new Callback<AsdActionrRoot>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.5
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity] */
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
                    if (DuplicateVerificationListActivity.this.alertDialog != null) {
                        DuplicateVerificationListActivity.this.alertDialog.dismiss();
                    }
                    try {
                        Utils utils = DuplicateVerificationListActivity.this.utils;
                        ?? r0 = DuplicateVerificationListActivity.this;
                        utils.infoDialogAction(r0, r0.getResources().getString(R.string.info), TextUtils.isEmpty(((AsdActionrRoot) response.body()).getMessage()) ? "" : ((AsdActionrRoot) response.body()).getMessage(), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.5.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                DuplicateVerificationListActivity.this.formlist.remove(pos);
                                DuplicateVerificationListActivity.this.verifyCitizenListAdapter.notifyItemRemoved(pos);
                            }
                        });
                        return;
                    } catch (Exception unused) {
                        if (DuplicateVerificationListActivity.this.alertDialog != null) {
                            DuplicateVerificationListActivity.this.alertDialog.dismiss();
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (DuplicateVerificationListActivity.this.alertDialog != null) {
                        DuplicateVerificationListActivity.this.alertDialog.dismiss();
                    }
                    DuplicateVerificationListActivity.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException unused2) {
                    if (DuplicateVerificationListActivity.this.alertDialog != null) {
                        DuplicateVerificationListActivity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<AsdActionrRoot> call, Throwable t) {
                if (DuplicateVerificationListActivity.this.alertDialog != null) {
                    DuplicateVerificationListActivity.this.alertDialog.dismiss();
                }
                Logger.e("efCount", t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDetailByClusterId(VerifyPayload verifyPayload) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("acNo", this.acNo);
        map2.put("partNo", this.partNo);
        map2.put("state", this.state);
        map2.put("clusterId", verifyPayload.getDseClusterId());
        Call<ClusterDetailsRoot> detailByClusterId = this.service.getDetailByClusterId(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        detailByClusterId.enqueue(new AnonymousClass6());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<ClusterDetailsRoot> {
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
        public void onResponse(Call<ClusterDetailsRoot> call, Response<ClusterDetailsRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    if (((ClusterDetailsRoot) response.body()).getPayload().size() > 0) {
                        if (DuplicateVerificationListActivity.this.clusterlist != null && DuplicateVerificationListActivity.this.clusterlist.size() > 0) {
                            DuplicateVerificationListActivity.this.clusterlist.clear();
                        }
                        DuplicateVerificationListActivity.this.clusterlist = ((ClusterDetailsRoot) response.body()).getPayload();
                        DuplicateVerificationListActivity duplicateVerificationListActivity = DuplicateVerificationListActivity.this;
                        duplicateVerificationListActivity.startSequentialFetchAsync(duplicateVerificationListActivity.clusterlist);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    DuplicateVerificationListActivity.this.alertDialog.dismiss();
                    return;
                }
            }
            if (response.code() == 400 || response.code() == 401) {
                if (DuplicateVerificationListActivity.this.alertDialog != null) {
                    DuplicateVerificationListActivity.this.alertDialog.dismiss();
                }
                DuplicateVerificationListActivity.this.commomUtility.showMessageOK(DuplicateVerificationListActivity.this, DuplicateVerificationListActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (DuplicateVerificationListActivity.this.alertDialog != null) {
                    DuplicateVerificationListActivity.this.alertDialog.dismiss();
                }
                DuplicateVerificationListActivity.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e) {
                if (DuplicateVerificationListActivity.this.alertDialog != null) {
                    DuplicateVerificationListActivity.this.alertDialog.dismiss();
                }
                Logger.e(DuplicateVerificationListActivity.this.TAG, e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DuplicateVerificationListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(DuplicateVerificationListActivity.this.getApplicationContext()).setLocaleBool(false);
            DuplicateVerificationListActivity.this.startActivity(new Intent(DuplicateVerificationListActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<ClusterDetailsRoot> call, Throwable t) {
            if (DuplicateVerificationListActivity.this.alertDialog != null) {
                DuplicateVerificationListActivity.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void clusterDetsailsDialog(ArrayList<ClusterDetailsPayload> clusterDetails) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.cluster_details_dialog);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        TextView textView = (TextView) dialog.findViewById(R.id.electorName_pending_sir);
        TextView textView2 = (TextView) dialog.findViewById(R.id.relativeName_pending_sir);
        TextView textView3 = (TextView) dialog.findViewById(R.id.gender);
        TextView textView4 = (TextView) dialog.findViewById(R.id.age_pending_sir);
        RecyclerView recyclerViewFindViewById = dialog.findViewById(R.id.recyclerView_cluser);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.iv_cancel);
        String firstName = TextUtils.isEmpty(clusterDetails.get(0).getFirstName()) ? "" : clusterDetails.get(0).getFirstName();
        String lastName = TextUtils.isEmpty(clusterDetails.get(0).getLastName()) ? "" : clusterDetails.get(0).getLastName();
        String rlnFirstName = TextUtils.isEmpty(clusterDetails.get(0).getRlnFirstName()) ? "" : clusterDetails.get(0).getRlnFirstName();
        String rlnLastName = TextUtils.isEmpty(clusterDetails.get(0).getRlnLastName()) ? "" : clusterDetails.get(0).getRlnLastName();
        String str = firstName + StringUtils.SPACE + lastName;
        String str2 = rlnFirstName + StringUtils.SPACE + rlnLastName;
        textView.setText(str);
        textView2.setText(str2);
        if (!TextUtils.isEmpty(clusterDetails.get(0).getGender())) {
            if (clusterDetails.get(0).getGender().equalsIgnoreCase("M")) {
                textView3.setText(TextUtils.isEmpty(clusterDetails.get(0).getGender()) ? "" : "Male");
            } else if (clusterDetails.get(0).getGender().equalsIgnoreCase("F")) {
                textView3.setText(TextUtils.isEmpty(clusterDetails.get(0).getGender()) ? "" : "Female");
            } else {
                textView3.setText(TextUtils.isEmpty(clusterDetails.get(0).getGender()) ? "" : clusterDetails.get(0).getGender());
            }
        }
        textView4.setText(clusterDetails.get(0).getAge() != 0 ? String.valueOf(clusterDetails.get(0).getAge()) : "");
        recyclerViewFindViewById.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFindViewById.setAdapter(new ClusterDetailsListAdapter(clusterDetails, this, new ItemClickCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.7
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback
            public void onClicked(VerifyPayload formverificationPayload, String type) {
            }
        }));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSequentialFetchAsync(ArrayList<ClusterDetailsPayload> clutsterdetails) {
        this.cancelled.set(false);
        this.currentIndex = 0;
        fetchNext(clutsterdetails);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void fetchNext(final ArrayList<ClusterDetailsPayload> items) {
        if (this.cancelled.get() || this.currentIndex >= items.size()) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            clusterDetsailsDialog(items);
            return;
        }
        int i = this.currentIndex;
        this.currentIndex = i + 1;
        final ClusterDetailsPayload clusterDetailsPayload = items.get(i);
        String photo = clusterDetailsPayload.getPhoto();
        if (TextUtils.isEmpty(photo)) {
            fetchNext(items);
            return;
        }
        Call<JsonObject> file = this.commonUtilClass.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFile("objectstorage", photo, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB");
        this.activeCall = file;
        file.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity.9
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (!DuplicateVerificationListActivity.this.cancelled.get() && response.isSuccessful() && response.body() != null) {
                    try {
                        String asString = ((JsonObject) response.body()).get("file").getAsString();
                        if (!TextUtils.isEmpty(asString)) {
                            clusterDetailsPayload.setImageBytes(Base64.decode(asString, 0));
                        }
                    } catch (Exception unused) {
                    }
                }
                DuplicateVerificationListActivity.this.fetchNext(items);
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                DuplicateVerificationListActivity.this.cancelled.get();
                DuplicateVerificationListActivity.this.fetchNext(items);
            }
        });
    }

    private void cancelChain() {
        this.cancelled.set(true);
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        Call<JsonObject> call = this.activeCall;
        if (call == null || call.isCanceled()) {
            return;
        }
        try {
            this.activeCall.cancel();
        } catch (Exception unused) {
        }
    }

    protected void onStop() {
        super.onStop();
        cancelChain();
    }

    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    public void onDestroy() {
        cancelChain();
        super.onDestroy();
    }
}
