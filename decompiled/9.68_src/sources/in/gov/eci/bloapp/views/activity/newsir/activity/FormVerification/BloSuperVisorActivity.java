package in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
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
import in.gov.eci.bloapp.views.activity.newsir.adapter.BloSuperVisorAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.BLOSupervisorModel;
import in.gov.eci.bloapp.views.activity.newsir.utils.CallUtils;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BloSuperVisorActivity extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private static String SESSION = "";
    ImageView IvScanCode;
    ArrayList<FormDataVariables> al;
    private ImageView back_btn_iv;
    String barcode;
    BloSuperVisorAdapter bloSuperVisorAdapter;
    Button btScanCode;
    private ActivityResultLauncher<String> callPermissionLauncher;
    TextView noteOpen;
    RecyclerView recyclerView;
    ConstraintLayout scanCode;
    EditText search;
    Spinner spinner;
    TextView textView3;
    TextView textView5;
    Utils utils;
    String alertText = "";
    String TAG = "FormDataNewTAG";
    CommomUtility commomUtility = new CommomUtility();
    Gson gson = new GsonBuilder().setLenient().create();
    String pendingNumber = null;
    List<BLOSupervisorModel> formlist = new ArrayList();

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
        this.scanCode = findViewById(R.id.scanCode);
        this.btScanCode = (Button) findViewById(R.id.btScanCode);
        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.textView3 = (TextView) findViewById(R.id.textView3);
        this.IvScanCode = (ImageView) findViewById(R.id.IvScanCode);
        this.btScanCode.setVisibility(8);
        this.IvScanCode.setVisibility(8);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.al = new ArrayList<>();
        this.alertText = getString(R.string.alertMsg);
        this.utils = new Utils();
        this.search.setHint("Search By BLO Name/Part Name");
        initClickListener();
        this.textView3.setText(getResources().getString(R.string.blo_details));
        String supervisorData = SharedPref.getInstance(this).getSupervisorData();
        if (!supervisorData.isEmpty()) {
            getListAndSetAdapter(supervisorData);
        } else {
            getElectorEfList();
        }
        this.callPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity$$ExternalSyntheticLambda1
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$onCreate$0((Boolean) obj);
            }
        });
        this.textView5.setText("v" + this.commomUtility.appversion);
        this.noteOpen.setVisibility(0);
        this.spinner.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(Boolean bool) {
        if (bool.booleanValue()) {
            String str = this.pendingNumber;
            if (str != null) {
                CallUtils.callNowOrDial(this, str);
                this.pendingNumber = null;
                return;
            }
            return;
        }
        String str2 = this.pendingNumber;
        if (str2 != null) {
            CallUtils.openDialer(this, str2);
            this.pendingNumber = null;
        }
        Toast.makeText((Context) this, (CharSequence) "Call permission denied. Opening dialer.", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity$1] */
    public void getListAndSetAdapter(String jsonString) {
        this.formlist = (List) new Gson().fromJson(jsonString, new TypeToken<ArrayList<BLOSupervisorModel>>() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity.1
        }.getType());
        BloSuperVisorAdapter bloSuperVisorAdapter = new BloSuperVisorAdapter(this.formlist, this, new BloSuperVisorAdapter.OnItemMobileListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.BloSuperVisorAdapter.OnItemMobileListener
            public void onItemMobile(final String mobileNumber) {
                Utils utils = BloSuperVisorActivity.this.utils;
                ?? r2 = BloSuperVisorActivity.this;
                utils.decisionDialog(r2, r2.getResources().getString(R.string.info), "BLO mobile number is " + mobileNumber, "call", "cancel", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity.2.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onNegativeButtonClicked() {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onPositiveButtonClicked() {
                        BloSuperVisorActivity.this.startDirectCall(mobileNumber);
                    }
                });
            }
        });
        this.bloSuperVisorAdapter = bloSuperVisorAdapter;
        this.recyclerView.setAdapter(bloSuperVisorAdapter);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void startDirectCall(String phoneNumber) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.CALL_PHONE") == 0) {
            CallUtils.callNowOrDial(this, phoneNumber);
        } else {
            this.pendingNumber = phoneNumber;
            this.callPermissionLauncher.launch("android.permission.CALL_PHONE");
        }
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

    private void initClickListener() {
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
        this.scanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BloSuperVisorActivity.this.cameraPermission();
            }
        });
        this.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BloSuperVisorActivity.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getElectorEfList() {
        try {
            UserClient userClient = (UserClient) ApiClient.getClient(this).create(UserClient.class);
            HashMap<String, String> map = new HashMap<>();
            map.put("Authorization", SharedPref.getInstance(this).getToken());
            map.put("currentRole", "blos");
            map.put("state", SharedPref.getInstance(this).getStateCode());
            map.put("Content-Type", "application/json");
            map.put("atkn_bnd", SharedPref.getInstance(this).getAtknBnd());
            map.put("rtkn_bnd", SharedPref.getInstance(this).getRtknBnd());
            map.put("channelidobo", "BLOAPP");
            userClient.getBloSupervisorData(map, new HashMap()).enqueue(new AnonymousClass5());
        } catch (Exception unused) {
            Toast.makeText((Context) this, (CharSequence) "API failure", 1).show();
        }
        this.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String string = editable.toString();
                ArrayList<BLOSupervisorModel> arrayList = new ArrayList<>();
                for (BLOSupervisorModel bLOSupervisorModel : BloSuperVisorActivity.this.formlist) {
                    if ((!TextUtils.isEmpty(bLOSupervisorModel.getPartName()) && bLOSupervisorModel.getPartName().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(bLOSupervisorModel.getName())) && String.valueOf(bLOSupervisorModel.getName()).toLowerCase().contains(string.toLowerCase()))) {
                        arrayList.add(bLOSupervisorModel);
                    }
                }
                BloSuperVisorActivity.this.bloSuperVisorAdapter.fun(arrayList);
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

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
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (response.body() != null) {
                    String json = BloSuperVisorActivity.this.gson.toJson(((JsonObject) response.body()).get("data"));
                    SharedPref.getInstance(BloSuperVisorActivity.this).setSupervisorData(json);
                    SharedPref.getInstance(BloSuperVisorActivity.this).setAssemblyName(((JsonObject) response.body()).get("assemblyName").isJsonNull() ? "" : ((JsonObject) response.body()).get("assemblyName").getAsString());
                    SharedPref.getInstance(BloSuperVisorActivity.this).setLanguageName(((JsonObject) response.body()).get("acL1").isJsonNull() ? "" : ((JsonObject) response.body()).get("acL1").getAsString());
                    SharedPref.getInstance(BloSuperVisorActivity.this).setLanguageName2(((JsonObject) response.body()).get("acL2").isJsonNull() ? "" : ((JsonObject) response.body()).get("acL2").getAsString());
                    BloSuperVisorActivity.this.getListAndSetAdapter(json);
                    return;
                }
                return;
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                if (response.code() == 401) {
                    BloSuperVisorActivity.this.commomUtility.showMessageOK(BloSuperVisorActivity.this, strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity$5$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                } else if (response.code() == 417) {
                    BloSuperVisorActivity.this.commomUtility.showMessageOK(BloSuperVisorActivity.this, strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity$5$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$1(dialogInterface, i);
                        }
                    });
                } else {
                    BloSuperVisorActivity.this.showdialog1("Alert", strOptString);
                }
            } catch (IOException | JSONException e) {
                Toast.makeText((Context) BloSuperVisorActivity.this, (CharSequence) "Error", 1).show();
                Logger.d("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(BloSuperVisorActivity.this).clear();
            SharedPref.getInstance(BloSuperVisorActivity.this).setIsLoggedIn(false);
            SharedPref.getInstance(BloSuperVisorActivity.this).setLocaleBool(false);
            BloSuperVisorActivity.this.startActivity(new Intent((Context) BloSuperVisorActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(BloSuperVisorActivity.this).clear();
            SharedPref.getInstance(BloSuperVisorActivity.this).setIsLoggedIn(false);
            SharedPref.getInstance(BloSuperVisorActivity.this).setLocaleBool(false);
            BloSuperVisorActivity.this.startActivity(new Intent((Context) BloSuperVisorActivity.this, (Class<?>) LoginActivity.class));
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("restart", false)) {
            recreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showdialog1(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.BloSuperVisorActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }
}
