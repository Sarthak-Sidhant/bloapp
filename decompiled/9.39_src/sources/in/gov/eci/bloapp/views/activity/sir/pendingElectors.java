package in.gov.eci.bloapp.views.activity.sir;

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
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityPendingElectorsBinding;
import in.gov.eci.bloapp.room.database.SIRDatabaseHelper;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.EFListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.EpicCallBack;
import in.gov.eci.bloapp.views.activity.newsir.callback.fillEFCallBack;
import in.gov.eci.bloapp.views.activity.newsir.model.Content;
import in.gov.eci.bloapp.views.activity.newsir.model.EFPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.EFRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.MobileNumberRoot;
import in.gov.eci.bloapp.views.activity.newsir.utils.CallUtils;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class pendingElectors extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private String acNo;
    EFListAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    String barcode;
    ActivityPendingElectorsBinding binding;
    private ActivityResultLauncher<String> callPermissionLauncher;
    SIRDatabaseHelper db;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    EditText search;
    UserClient service;
    private String state;
    private String token;
    Utils utils;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    ArrayList<EFPayload> pendingList = new ArrayList<>();
    ArrayList<EFPayload> searchList = new ArrayList<>();
    private final String TAG = "pendingElectorsTAG";
    String pendingNumber = null;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityPendingElectorsBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.service = (UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class);
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new EFListAdapter(this.searchList, this, new fillEFCallBack() { // from class: in.gov.eci.bloapp.views.activity.sir.pendingElectors.1
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.fillEFCallBack
            public void onFillEFClicked(EFPayload efPayload, String type) {
                if (type.equalsIgnoreCase("fill")) {
                    pendingElectors.this.checkEpicNumber(efPayload);
                }
                if (type.equalsIgnoreCase("call")) {
                    pendingElectors.this.pendingNumber = null;
                    pendingElectors.this.getMobileNumber(efPayload);
                }
            }
        });
        this.utils = new Utils();
        this.binding.recyclerView.setAdapter(this.adapter);
        getAllPendingList();
        this.searchList.clear();
        this.searchList.addAll(this.pendingList);
        this.adapter.notifyDataSetChanged();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.tvDisclamierSir.setVisibility(8);
        initClickListener();
        this.callPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.pendingElectors$$ExternalSyntheticLambda1
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$onCreate$0((Boolean) obj);
            }
        });
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

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.pendingElectors$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
        this.binding.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.pendingElectors.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                pendingElectors.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        finish();
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
            this.barcode = this.barcode.replace(" ", "");
            this.binding.search.setText(this.barcode);
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

    private void getAllPendingList() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        Call<EFRoot> eFListSIR = this.service.getEFListSIR(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        eFListSIR.enqueue(new Callback<EFRoot>() { // from class: in.gov.eci.bloapp.views.activity.sir.pendingElectors.3
            public void onResponse(Call<EFRoot> call, Response<EFRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        pendingElectors.this.alertDialog.dismiss();
                        if (((EFRoot) response.body()).getPayload().size() > 0) {
                            pendingElectors.this.pendingList = ((EFRoot) response.body()).getPayload();
                        }
                    } catch (Exception unused) {
                        pendingElectors.this.alertDialog.dismiss();
                    }
                    pendingElectors.this.searchList.addAll(pendingElectors.this.pendingList);
                    pendingElectors.this.binding.recyclerView.setAdapter(pendingElectors.this.adapter);
                    pendingElectors.this.alertDialog.dismiss();
                    pendingElectors.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.pendingElectors.3.1
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            String string = editable.toString();
                            ArrayList<EFPayload> arrayList = new ArrayList<>();
                            for (EFPayload eFPayload : pendingElectors.this.pendingList) {
                                if (!TextUtils.isEmpty(String.valueOf(eFPayload.getPartSerialNo())) && String.valueOf(eFPayload.getPartSerialNo()).toLowerCase().equals(string.toLowerCase())) {
                                    if (arrayList.size() > 0) {
                                        arrayList.clear();
                                    }
                                    arrayList.add(eFPayload);
                                    break;
                                } else if ((!TextUtils.isEmpty(eFPayload.getEpicNo()) && eFPayload.getEpicNo().toLowerCase().contains(string.toLowerCase())) || ((!TextUtils.isEmpty(eFPayload.getName()) && eFPayload.getName().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(eFPayload.getPartSerialNo())) && String.valueOf(eFPayload.getPartSerialNo()).toLowerCase().contains(string.toLowerCase())))) {
                                    arrayList.add(eFPayload);
                                }
                            }
                            pendingElectors.this.adapter.fun(arrayList);
                        }
                    });
                    return;
                }
                if (response.code() == 400 || response.code() == 401) {
                    if (pendingElectors.this.alertDialog != null) {
                        pendingElectors.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                try {
                    if (pendingElectors.this.alertDialog != null) {
                        pendingElectors.this.alertDialog.dismiss();
                    }
                    pendingElectors.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException e) {
                    if (pendingElectors.this.alertDialog != null) {
                        pendingElectors.this.alertDialog.dismiss();
                    }
                    Logger.e("pendingElectorsTAG", e.getMessage());
                }
            }

            public void onFailure(Call<EFRoot> call, Throwable t) {
                if (pendingElectors.this.alertDialog != null) {
                    pendingElectors.this.alertDialog.dismiss();
                }
                Logger.e("pendingElectors", t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.pendingElectors$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$2(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$2(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void checkEpicNumber(EFPayload efPayload) {
        this.alertDialog.show();
        CommomUtility commomUtility = new CommomUtility();
        commomUtility.checkEpic(this, efPayload.getEpicNo(), this.token, this.atkband, this.rtkband, this.state, new AnonymousClass4(efPayload, commomUtility));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.pendingElectors$4, reason: invalid class name */
    class AnonymousClass4 implements EpicCallBack {
        final /* synthetic */ CommomUtility val$commonUtilClass;
        final /* synthetic */ EFPayload val$efPayload;

        AnonymousClass4(final EFPayload val$efPayload, final CommomUtility val$commonUtilClass) {
            this.val$efPayload = val$efPayload;
            this.val$commonUtilClass = val$commonUtilClass;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.pendingElectors] */
        /* JADX WARN: Type inference failed for: r5v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.pendingElectors] */
        /* JADX WARN: Type inference failed for: r5v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.pendingElectors] */
        /* JADX WARN: Type inference failed for: r5v7, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.pendingElectors] */
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
        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.EpicCallBack
        public void onCallBack(int code, Content content, String message) {
            if (code != 200) {
                if (code == 401) {
                    if (pendingElectors.this.alertDialog != null) {
                        pendingElectors.this.alertDialog.dismiss();
                    }
                    this.val$commonUtilClass.showMessageOK(pendingElectors.this, "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.pendingElectors$4$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onCallBack$0(dialogInterface, i);
                        }
                    });
                    return;
                } else {
                    if (code == 400) {
                        if (pendingElectors.this.alertDialog != null) {
                            pendingElectors.this.alertDialog.dismiss();
                        }
                        Utils utils = pendingElectors.this.utils;
                        ?? r5 = pendingElectors.this;
                        utils.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
                        return;
                    }
                    if (pendingElectors.this.alertDialog != null) {
                        pendingElectors.this.alertDialog.dismiss();
                    }
                    Utils utils2 = pendingElectors.this.utils;
                    ?? r6 = pendingElectors.this;
                    utils2.infoDialog(r6, r6.getResources().getString(R.string.alertMsg), pendingElectors.this.getResources().getString(R.string.something_went_wrong));
                    return;
                }
            }
            if (pendingElectors.this.alertDialog != null) {
                pendingElectors.this.alertDialog.dismiss();
            }
            if (content != null) {
                Intent intent = new Intent((Context) pendingElectors.this, (Class<?>) EFTabActivity.class);
                intent.putExtra("epic", this.val$efPayload.getEpicNo());
                intent.putExtra("psl", String.valueOf(this.val$efPayload.getPartSerialNo()));
                intent.putExtra("epicId", this.val$efPayload.getEpicId());
                intent.putExtra("electorname", this.val$efPayload.getName());
                intent.putExtra("relativefullname", TextUtils.isEmpty(content.getRelativeFullName()) ? "" : content.getRelativeFullName());
                intent.putExtra("relatiiontype", TextUtils.isEmpty(content.getRelationType()) ? "" : content.getRelationType());
                intent.putExtra("age", content.getAge());
                intent.putExtra("ac", content.getAcNumber());
                intent.putExtra("part", content.getPartNumber());
                intent.putExtra("gender", TextUtils.isEmpty(content.getGender()) ? "" : content.getGender());
                intent.putExtra("dob", TextUtils.isEmpty(content.getDob()) ? "" : content.getDob());
                intent.putExtra("state", TextUtils.isEmpty(content.getStateCd()) ? "" : content.getStateCd());
                intent.putExtra("from", "pendingelector");
                pendingElectors.this.startActivity(intent);
                return;
            }
            if (TextUtils.isEmpty(message)) {
                Utils utils3 = pendingElectors.this.utils;
                ?? r7 = pendingElectors.this;
                utils3.infoDialog(r7, r7.getResources().getString(R.string.alertMsg), pendingElectors.this.getResources().getString(R.string.something_went_wrong));
            } else {
                Utils utils4 = pendingElectors.this.utils;
                ?? r8 = pendingElectors.this;
                utils4.infoDialog(r8, r8.getResources().getString(R.string.alertMsg), message);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCallBack$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(pendingElectors.this).setIsLoggedIn(false);
            SharedPref.getInstance(pendingElectors.this).setLocaleBool(false);
            pendingElectors.this.startActivity(new Intent((Context) pendingElectors.this, (Class<?>) LoginActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMobileNumber(final EFPayload efPayload) {
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
        map2.put("epicNumber", efPayload.getEpicNo());
        map2.put("flag", "EROLL");
        map2.put("state", this.state);
        Call<MobileNumberRoot> mobileNumber = this.service.getMobileNumber(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        mobileNumber.enqueue(new Callback<MobileNumberRoot>() { // from class: in.gov.eci.bloapp.views.activity.sir.pendingElectors.5
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.pendingElectors] */
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
            public void onResponse(Call<MobileNumberRoot> call, final Response<MobileNumberRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (pendingElectors.this.alertDialog != null) {
                        pendingElectors.this.alertDialog.dismiss();
                    }
                    try {
                        if (TextUtils.isEmpty(((MobileNumberRoot) response.body()).getPayload())) {
                            pendingElectors.this.showDialog1("Alert", ((MobileNumberRoot) response.body()).getMessage());
                        } else {
                            String str = efPayload.getName() + " mobile number is " + ((MobileNumberRoot) response.body()).getPayload();
                            Utils utils = pendingElectors.this.utils;
                            ?? r1 = pendingElectors.this;
                            utils.decisionDialog(r1, r1.getResources().getString(R.string.info), str, "call", "cancel", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.pendingElectors.5.1
                                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                                public void onNegativeButtonClicked() {
                                }

                                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                                public void onPositiveButtonClicked() {
                                    pendingElectors.this.startDirectCall(((MobileNumberRoot) response.body()).getPayload());
                                }
                            });
                        }
                        return;
                    } catch (Exception unused) {
                        if (pendingElectors.this.alertDialog != null) {
                            pendingElectors.this.alertDialog.dismiss();
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (pendingElectors.this.alertDialog != null) {
                        pendingElectors.this.alertDialog.dismiss();
                    }
                    pendingElectors.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException unused2) {
                    if (pendingElectors.this.alertDialog != null) {
                        pendingElectors.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<MobileNumberRoot> call, Throwable t) {
                if (pendingElectors.this.alertDialog != null) {
                    pendingElectors.this.alertDialog.dismiss();
                }
                Logger.e("efCount", t.getMessage());
            }
        });
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
}
