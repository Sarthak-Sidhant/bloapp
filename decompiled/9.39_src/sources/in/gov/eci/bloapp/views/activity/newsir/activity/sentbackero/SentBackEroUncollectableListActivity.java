package in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero;

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
import in.gov.eci.bloapp.views.activity.newsir.adapter.MarkUncollectableListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.EpicCallBack;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.UnCollectableCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.Content;
import in.gov.eci.bloapp.views.activity.newsir.model.FormVerifyRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.UncollectableDetailsPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.UncollectableSIR;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SentBackEroUncollectableListActivity extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private String acNo;
    MarkUncollectableListAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    String barcode;
    ActivityPendingElectorsBinding binding;
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
    ArrayList<VerifyPayload> pendingList = new ArrayList<>();
    ArrayList<VerifyPayload> searchList = new ArrayList<>();
    private final String TAG = "pendingElectorsTAG";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityPendingElectorsBinding activityPendingElectorsBindingInflate = ActivityPendingElectorsBinding.inflate(getLayoutInflater());
        this.binding = activityPendingElectorsBindingInflate;
        setContentView(activityPendingElectorsBindingInflate.getRoot());
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
        this.adapter = new MarkUncollectableListAdapter(this.searchList, this, new ItemClickCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity.1
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback
            public void onClicked(VerifyPayload formverificationPayload, String type) {
                if (!TextUtils.isEmpty(type) && type.equalsIgnoreCase("filForm")) {
                    SentBackEroUncollectableListActivity.this.checkEpicNumber(formverificationPayload);
                } else {
                    if (TextUtils.isEmpty(type) || !type.equalsIgnoreCase("editDetais")) {
                        return;
                    }
                    SentBackEroUncollectableListActivity.this.getDetailsofUncollectableForms(formverificationPayload);
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
        this.binding.textView3.setText(getResources().getString(R.string.rollback_1));
        this.binding.textView3.setTextSize(13.0f);
        this.binding.tvDisclamierSir.setVisibility(8);
        initClickListener();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
        this.binding.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SentBackEroUncollectableListActivity.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
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
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("acNo", this.acNo);
        map2.put("partNo", this.partNo);
        map2.put("stCode", this.state);
        Call<FormVerifyRoot> listUncollectableRollBackForms = this.service.getListUncollectableRollBackForms(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        listUncollectableRollBackForms.enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<FormVerifyRoot> {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity] */
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
        public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                    if (((FormVerifyRoot) response.body()).getPayload().size() > 0) {
                        SentBackEroUncollectableListActivity.this.pendingList = (ArrayList) ((FormVerifyRoot) response.body()).getPayload();
                    }
                } catch (Exception unused) {
                    SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                }
                SentBackEroUncollectableListActivity.this.searchList.addAll(SentBackEroUncollectableListActivity.this.pendingList);
                SentBackEroUncollectableListActivity.this.binding.recyclerView.setAdapter(SentBackEroUncollectableListActivity.this.adapter);
                SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                SentBackEroUncollectableListActivity.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity.3.1
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
                        for (VerifyPayload verifyPayload : SentBackEroUncollectableListActivity.this.pendingList) {
                            if (!TextUtils.isEmpty(String.valueOf(verifyPayload.getPartSerialNo())) && String.valueOf(verifyPayload.getPartSerialNo()).toLowerCase().equals(string.toLowerCase())) {
                                if (arrayList.size() > 0) {
                                    arrayList.clear();
                                }
                                arrayList.add(verifyPayload);
                                break;
                            } else if ((!TextUtils.isEmpty(verifyPayload.getEpicNo()) && verifyPayload.getEpicNo().toLowerCase().contains(string.toLowerCase())) || ((!TextUtils.isEmpty(verifyPayload.getEpicName()) && verifyPayload.getEpicName().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(verifyPayload.getPartSerialNo())) && String.valueOf(verifyPayload.getPartSerialNo()).toLowerCase().contains(string.toLowerCase())))) {
                                arrayList.add(verifyPayload);
                            }
                        }
                        SentBackEroUncollectableListActivity.this.adapter.fun(arrayList);
                    }
                });
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (SentBackEroUncollectableListActivity.this.alertDialog != null) {
                    SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = SentBackEroUncollectableListActivity.this.commomUtility;
                ?? r4 = SentBackEroUncollectableListActivity.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (SentBackEroUncollectableListActivity.this.alertDialog != null) {
                    SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                }
                SentBackEroUncollectableListActivity.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e) {
                if (SentBackEroUncollectableListActivity.this.alertDialog != null) {
                    SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                }
                Logger.e("pendingElectorsTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SentBackEroUncollectableListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SentBackEroUncollectableListActivity.this.getApplicationContext()).setLocaleBool(false);
            SentBackEroUncollectableListActivity.this.startActivity(new Intent(SentBackEroUncollectableListActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
            if (SentBackEroUncollectableListActivity.this.alertDialog != null) {
                SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$1(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void checkEpicNumber(final VerifyPayload efPayload) {
        this.alertDialog.show();
        new CommomUtility().checkEpic(this, efPayload.getEpicNo(), this.token, this.atkband, this.rtkband, this.state, new EpicCallBack() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity.4
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity] */
            /* JADX WARN: Type inference failed for: r5v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity] */
            /* JADX WARN: Type inference failed for: r5v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity] */
            /* JADX WARN: Type inference failed for: r5v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity] */
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
                        if (SentBackEroUncollectableListActivity.this.alertDialog != null) {
                            SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                            return;
                        }
                        return;
                    } else {
                        if (code == 400) {
                            if (SentBackEroUncollectableListActivity.this.alertDialog != null) {
                                SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                            }
                            Utils utils = SentBackEroUncollectableListActivity.this.utils;
                            ?? r5 = SentBackEroUncollectableListActivity.this;
                            utils.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
                            return;
                        }
                        if (SentBackEroUncollectableListActivity.this.alertDialog != null) {
                            SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                        }
                        Utils utils2 = SentBackEroUncollectableListActivity.this.utils;
                        ?? r6 = SentBackEroUncollectableListActivity.this;
                        utils2.infoDialog(r6, r6.getResources().getString(R.string.alertMsg), SentBackEroUncollectableListActivity.this.getResources().getString(R.string.something_went_wrong));
                        return;
                    }
                }
                if (SentBackEroUncollectableListActivity.this.alertDialog != null) {
                    SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                }
                if (content != null) {
                    Intent intent = new Intent((Context) SentBackEroUncollectableListActivity.this, (Class<?>) EFTabActivity.class);
                    intent.putExtra("epic", efPayload.getEpicNo());
                    intent.putExtra("psl", String.valueOf(efPayload.getPartSerialNo()));
                    intent.putExtra("epicId", efPayload.getEpicId());
                    intent.putExtra("electorname", efPayload.getEpicName());
                    intent.putExtra("relativefullname", TextUtils.isEmpty(content.getRelativeFullName()) ? "" : content.getRelativeFullName());
                    intent.putExtra("relatiiontype", TextUtils.isEmpty(content.getRelationType()) ? "" : content.getRelationType());
                    intent.putExtra("age", content.getAge());
                    intent.putExtra("ac", content.getAcNumber());
                    intent.putExtra("part", content.getPartNumber());
                    intent.putExtra("gender", TextUtils.isEmpty(content.getGender()) ? "" : content.getGender());
                    intent.putExtra("dob", TextUtils.isEmpty(content.getDob()) ? "" : content.getDob());
                    intent.putExtra("state", TextUtils.isEmpty(content.getStateCd()) ? "" : content.getStateCd());
                    intent.putExtra("from", "SentBackEroUncollectableListActivity");
                    SentBackEroUncollectableListActivity.this.startActivity(intent);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    Utils utils3 = SentBackEroUncollectableListActivity.this.utils;
                    ?? r7 = SentBackEroUncollectableListActivity.this;
                    utils3.infoDialog(r7, r7.getResources().getString(R.string.alertMsg), SentBackEroUncollectableListActivity.this.getResources().getString(R.string.something_went_wrong));
                } else {
                    Utils utils4 = SentBackEroUncollectableListActivity.this.utils;
                    ?? r8 = SentBackEroUncollectableListActivity.this;
                    utils4.infoDialog(r8, r8.getResources().getString(R.string.alertMsg), message);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getDetailsofUncollectableForms(final VerifyPayload efPayload) {
        this.commomUtility.getUncollectableRollBackFormsByEpicId(this, this.token, efPayload.getEpicId(), this.atkband, this.rtkband, this.state, this.acNo, this.partNo, new UnCollectableCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity.5
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity] */
            /* JADX WARN: Type inference failed for: r4v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity] */
            /* JADX WARN: Type inference failed for: r4v4, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.UnCollectableCallback
            public void onCallBack(int code, List<UncollectableDetailsPayload> formlist, String message) {
                if (code == 200) {
                    if (SentBackEroUncollectableListActivity.this.alertDialog != null) {
                        SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                    }
                    if (formlist != null && formlist.size() > 0) {
                        UncollectableDetailsPayload uncollectableDetailsPayload = formlist.get(0);
                        Intent intent = new Intent((Context) SentBackEroUncollectableListActivity.this, (Class<?>) UncollectableSIR.class);
                        intent.putExtra("epic", efPayload.getEpicNo());
                        intent.putExtra("epicId", efPayload.getEpicId());
                        intent.putExtra("psl", efPayload.getPartSerialNo());
                        intent.putExtra("flag", "ERO");
                        intent.putExtra("photoUrl1", uncollectableDetailsPayload.getEfFrontUrl());
                        intent.putExtra("photoUrl2", uncollectableDetailsPayload.getEfBackUrl());
                        intent.putExtra("photoUrl3", uncollectableDetailsPayload.getSuppDoc1Url());
                        intent.putExtra("photoUrl4", uncollectableDetailsPayload.getSuppDoc2Url());
                        intent.putExtra("reason", uncollectableDetailsPayload.getUncollectableReason());
                        intent.putExtra("enrolledEpicNo", uncollectableDetailsPayload.getEnrolledEpicNo());
                        intent.putExtra("uncollectableRemarks", uncollectableDetailsPayload.getUncollectableRemarks());
                        SentBackEroUncollectableListActivity.this.startActivity(intent);
                        return;
                    }
                    if (SentBackEroUncollectableListActivity.this.alertDialog != null) {
                        SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                    }
                    if (!TextUtils.isEmpty(message)) {
                        Utils utils = SentBackEroUncollectableListActivity.this.utils;
                        ?? r4 = SentBackEroUncollectableListActivity.this;
                        utils.infoDialogAction(r4, r4.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity.5.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                            }
                        });
                        return;
                    } else {
                        Utils utils2 = SentBackEroUncollectableListActivity.this.utils;
                        ?? r5 = SentBackEroUncollectableListActivity.this;
                        utils2.infoDialogAction(r5, r5.getResources().getString(R.string.alertMsg), SentBackEroUncollectableListActivity.this.getResources().getString(R.string.no_data_found), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity.5.2
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onNegativeButtonClicked() {
                            }

                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                            public void onPositiveButtonClicked() {
                            }
                        });
                        return;
                    }
                }
                if (SentBackEroUncollectableListActivity.this.alertDialog != null) {
                    SentBackEroUncollectableListActivity.this.alertDialog.dismiss();
                }
                if (!TextUtils.isEmpty(message)) {
                    Utils utils3 = SentBackEroUncollectableListActivity.this.utils;
                    ?? r6 = SentBackEroUncollectableListActivity.this;
                    utils3.infoDialogAction(r6, r6.getResources().getString(R.string.alertMsg), message, new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity.5.3
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                        }
                    });
                } else {
                    Utils utils4 = SentBackEroUncollectableListActivity.this.utils;
                    ?? r7 = SentBackEroUncollectableListActivity.this;
                    utils4.infoDialogAction(r7, r7.getResources().getString(R.string.alertMsg), SentBackEroUncollectableListActivity.this.getResources().getString(R.string.something_went_wrong), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity.5.4
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                        }
                    });
                }
            }
        });
    }
}
