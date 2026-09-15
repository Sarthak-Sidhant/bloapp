package in.gov.eci.bloapp.views.activity;

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
import in.gov.eci.bloapp.views.activity.newsir.adapter.PSEVerifiedClusterDetailsListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.adapter.PseListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallbackPse;
import in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallbackPse;
import in.gov.eci.bloapp.views.activity.newsir.model.AsdActionrRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.DSEVerifiedClusterDetailsPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.DseVerifiedClusterDetailsRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.PseVerifyPayload;
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
public class PseVerifiedListActivity extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
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
    ArrayList<DSEVerifiedClusterDetailsPayload> clusterlist;
    CommomUtility commonUtilClass;
    List<String> efOptionList;
    List<PseVerifyPayload> formlist;
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
    PseListAdapter verifyCitizenListAdapter;
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
        setContentView(R.layout.activity_dse_verified_list);
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
        this.textView5.setText("v" + this.commomUtility.appversion);
        this.textView3.setText(getResources().getString(R.string.pseActivity_homeIcon));
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity$$ExternalSyntheticLambda1
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
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
        this.scanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PseVerifiedListActivity.this.cameraPermission();
            }
        });
        this.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PseVerifiedListActivity.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        onBackPressed();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity$3, reason: invalid class name */
    class AnonymousClass3 implements VerifyCitizenListCallbackPse {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.PseVerifiedListActivity] */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.PseVerifiedListActivity] */
        /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.PseVerifiedListActivity] */
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
        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallbackPse
        public void onCallBack(int code, List<PseVerifyPayload> datalist, String message) {
            if (code == 200) {
                PseVerifiedListActivity.this.alertDialog.dismiss();
                if (datalist != null && datalist.size() > 0) {
                    if (PseVerifiedListActivity.this.formlist != null && PseVerifiedListActivity.this.formlist.size() > 0) {
                        PseVerifiedListActivity.this.formlist.clear();
                    }
                    PseVerifiedListActivity.this.formlist = datalist;
                    PseVerifiedListActivity pseVerifiedListActivity = PseVerifiedListActivity.this;
                    List<PseVerifyPayload> list = PseVerifiedListActivity.this.formlist;
                    ?? r0 = PseVerifiedListActivity.this;
                    pseVerifiedListActivity.verifyCitizenListAdapter = new PseListAdapter(list, r0, r0.getSupportFragmentManager(), new ItemClickCallbackPse() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity.3.1
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
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallbackPse
                        public void onClicked(final PseVerifyPayload formverificationPayload, final String type) {
                            if (type.equalsIgnoreCase("viewdetails")) {
                                PseVerifiedListActivity.this.getDetailByClusterId(formverificationPayload);
                            } else {
                                if (type.equalsIgnoreCase("form7")) {
                                    return;
                                }
                                PseVerifiedListActivity.this.utils.decisionDialog(PseVerifiedListActivity.this, "Confirmation", "Are you sure you want to verify ?", "Yes", "No", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity.3.1.1
                                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                                    public void onNegativeButtonClicked() {
                                    }

                                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                                    public void onPositiveButtonClicked() {
                                        PseVerifiedListActivity.this.noActionRequired(formverificationPayload, Integer.parseInt(type));
                                    }
                                });
                            }
                        }
                    });
                    PseVerifiedListActivity.this.recyclerView.setAdapter(PseVerifiedListActivity.this.verifyCitizenListAdapter);
                    PseVerifiedListActivity.this.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity.3.2
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            String string = editable.toString();
                            ArrayList<PseVerifyPayload> arrayList = new ArrayList<>();
                            for (PseVerifyPayload pseVerifyPayload : PseVerifiedListActivity.this.formlist) {
                                if (!TextUtils.isEmpty(String.valueOf(pseVerifyPayload.getPartSerialNo())) && String.valueOf(pseVerifyPayload.getPartSerialNo()).toLowerCase().equals(string.toLowerCase())) {
                                    if (arrayList.size() > 0) {
                                        arrayList.clear();
                                    }
                                    arrayList.add(pseVerifyPayload);
                                    break;
                                } else if ((!TextUtils.isEmpty(pseVerifyPayload.getEpicNo()) && pseVerifyPayload.getEpicNo().toLowerCase().contains(string.toLowerCase())) || ((!TextUtils.isEmpty(String.valueOf(pseVerifyPayload.getPartSerialNo())) && String.valueOf(pseVerifyPayload.getPartSerialNo()).toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(pseVerifyPayload.getEpicName())) && String.valueOf(pseVerifyPayload.getEpicName()).toLowerCase().contains(string.toLowerCase())))) {
                                    arrayList.add(pseVerifyPayload);
                                }
                            }
                            PseVerifiedListActivity.this.verifyCitizenListAdapter.fun(arrayList);
                        }
                    });
                    return;
                }
                PseVerifiedListActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils = PseVerifiedListActivity.this.utils;
                ?? r5 = PseVerifiedListActivity.this;
                utils.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
                return;
            }
            PseVerifiedListActivity.this.alertDialog.dismiss();
            if (TextUtils.isEmpty(message)) {
                return;
            }
            Utils utils2 = PseVerifiedListActivity.this.utils;
            ?? r6 = PseVerifiedListActivity.this;
            utils2.infoDialog(r6, r6.getResources().getString(R.string.alertMsg), message);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getVerifyCitizenFormList() {
        this.commomUtility.getPseVerifiedList(this, this.token, this.atkband, this.rtkband, this.state, this.acNo, this.partNo, "", new AnonymousClass3());
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity$$ExternalSyntheticLambda2
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity$$ExternalSyntheticLambda0
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
    public void noActionRequired(PseVerifyPayload efPayload, final int pos) {
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
        map2.put("pseId", efPayload.getPseId());
        map2.put("bloActionTaken", "noAction");
        map2.put("state", this.state);
        Call<AsdActionrRoot> callUpdateBloPseAction = this.service.updateBloPseAction(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        callUpdateBloPseAction.enqueue(new Callback<AsdActionrRoot>() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity.4
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.PseVerifiedListActivity] */
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
                    if (PseVerifiedListActivity.this.alertDialog != null) {
                        PseVerifiedListActivity.this.alertDialog.dismiss();
                    }
                    try {
                        Utils utils = PseVerifiedListActivity.this.utils;
                        ?? r0 = PseVerifiedListActivity.this;
                        utils.infoDialogAction(r0, r0.getResources().getString(R.string.info), TextUtils.isEmpty(((AsdActionrRoot) response.body()).getMessage()) ? "" : ((AsdActionrRoot) response.body()).getMessage(), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity.4.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                                PseVerifiedListActivity.this.formlist.remove(pos);
                                PseVerifiedListActivity.this.verifyCitizenListAdapter.notifyItemRemoved(pos);
                            }
                        });
                        return;
                    } catch (Exception unused) {
                        if (PseVerifiedListActivity.this.alertDialog != null) {
                            PseVerifiedListActivity.this.alertDialog.dismiss();
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (PseVerifiedListActivity.this.alertDialog != null) {
                        PseVerifiedListActivity.this.alertDialog.dismiss();
                    }
                    PseVerifiedListActivity.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException unused2) {
                    if (PseVerifiedListActivity.this.alertDialog != null) {
                        PseVerifiedListActivity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<AsdActionrRoot> call, Throwable t) {
                if (PseVerifiedListActivity.this.alertDialog != null) {
                    PseVerifiedListActivity.this.alertDialog.dismiss();
                }
                Logger.e("efCount", t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDetailByClusterId(PseVerifyPayload verifyPayload) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", this.acNo);
        map2.put("partNo", this.partNo);
        map2.put("state", this.state);
        map2.put("clusterId", String.valueOf(verifyPayload.getPseClusterId()));
        Call<DseVerifiedClusterDetailsRoot> pseBloActionByClusterId = this.service.getPseBloActionByClusterId(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        pseBloActionByClusterId.enqueue(new AnonymousClass5());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<DseVerifiedClusterDetailsRoot> {
        AnonymousClass5() {
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
        public void onResponse(Call<DseVerifiedClusterDetailsRoot> call, Response<DseVerifiedClusterDetailsRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    if (((DseVerifiedClusterDetailsRoot) response.body()).getPayload().size() > 0) {
                        if (PseVerifiedListActivity.this.clusterlist != null && PseVerifiedListActivity.this.clusterlist.size() > 0) {
                            PseVerifiedListActivity.this.clusterlist.clear();
                        }
                        PseVerifiedListActivity.this.clusterlist = ((DseVerifiedClusterDetailsRoot) response.body()).getPayload();
                        PseVerifiedListActivity pseVerifiedListActivity = PseVerifiedListActivity.this;
                        pseVerifiedListActivity.startSequentialFetchAsync(pseVerifiedListActivity.clusterlist);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    PseVerifiedListActivity.this.alertDialog.dismiss();
                    return;
                }
            }
            if (response.code() == 400 || response.code() == 401) {
                if (PseVerifiedListActivity.this.alertDialog != null) {
                    PseVerifiedListActivity.this.alertDialog.dismiss();
                }
                PseVerifiedListActivity.this.commomUtility.showMessageOK(PseVerifiedListActivity.this, PseVerifiedListActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity$5$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (PseVerifiedListActivity.this.alertDialog != null) {
                    PseVerifiedListActivity.this.alertDialog.dismiss();
                }
                PseVerifiedListActivity.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e) {
                if (PseVerifiedListActivity.this.alertDialog != null) {
                    PseVerifiedListActivity.this.alertDialog.dismiss();
                }
                Logger.e(PseVerifiedListActivity.this.TAG, e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseVerifiedListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseVerifiedListActivity.this.getApplicationContext()).setLocaleBool(false);
            PseVerifiedListActivity.this.startActivity(new Intent(PseVerifiedListActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<DseVerifiedClusterDetailsRoot> call, Throwable t) {
            if (PseVerifiedListActivity.this.alertDialog != null) {
                PseVerifiedListActivity.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void clusterDetsailsDialog(ArrayList<DSEVerifiedClusterDetailsPayload> clusterDetails) {
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
        recyclerViewFindViewById.setAdapter(new PSEVerifiedClusterDetailsListAdapter(clusterDetails, this, new ItemClickCallbackPse() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity.6
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallbackPse
            public void onClicked(PseVerifyPayload formverificationPayload, String type) {
            }
        }));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSequentialFetchAsync(ArrayList<DSEVerifiedClusterDetailsPayload> clutsterdetails) {
        this.cancelled.set(false);
        this.currentIndex = 0;
        fetchNext(clutsterdetails);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void fetchNext(final ArrayList<DSEVerifiedClusterDetailsPayload> items) {
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
        final DSEVerifiedClusterDetailsPayload dSEVerifiedClusterDetailsPayload = items.get(i);
        String photo = dSEVerifiedClusterDetailsPayload.getPhoto();
        if (TextUtils.isEmpty(photo)) {
            fetchNext(items);
            return;
        }
        Call<JsonObject> file = this.commonUtilClass.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFile("objectstorage", photo, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB");
        this.activeCall = file;
        file.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.PseVerifiedListActivity.8
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (!PseVerifiedListActivity.this.cancelled.get() && response.isSuccessful() && response.body() != null) {
                    try {
                        String asString = ((JsonObject) response.body()).get("file").getAsString();
                        if (!TextUtils.isEmpty(asString)) {
                            dSEVerifiedClusterDetailsPayload.setImageBytes(Base64.decode(asString, 0));
                        }
                    } catch (Exception unused) {
                    }
                }
                PseVerifiedListActivity.this.fetchNext(items);
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                PseVerifiedListActivity.this.cancelled.get();
                PseVerifiedListActivity.this.fetchNext(items);
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
