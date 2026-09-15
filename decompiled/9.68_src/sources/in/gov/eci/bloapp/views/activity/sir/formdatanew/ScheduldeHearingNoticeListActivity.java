package in.gov.eci.bloapp.views.activity.sir.formdatanew;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.ScheduleHearingNoticeListAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityScheduldeHearingNoticeListBinding;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.model.HearingElectorRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.HearingPayload;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ScheduldeHearingNoticeListActivity extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private String acNo;
    ScheduleHearingNoticeListAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    String barcode;
    ActivityScheduldeHearingNoticeListBinding binding;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    EditText search;
    UserClient service;
    private String state;
    private String token;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "Session Expired. Please Login again..";
    ArrayList<HearingPayload> pendingList = new ArrayList<>();
    ArrayList<HearingPayload> searchList = new ArrayList<>();
    private final String TAG = "efTrackerTAG";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityScheduldeHearingNoticeListBinding activityScheduldeHearingNoticeListBindingInflate = ActivityScheduldeHearingNoticeListBinding.inflate(getLayoutInflater());
        this.binding = activityScheduldeHearingNoticeListBindingInflate;
        setContentView(activityScheduldeHearingNoticeListBindingInflate.getRoot());
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
        this.adapter = new ScheduleHearingNoticeListAdapter(this.searchList, this, this.token, this.state, this.atkband, this.rtkband, Integer.parseInt(this.acNo));
        this.binding.recyclerView.setAdapter(this.adapter);
        getAllPendingList();
        this.searchList.clear();
        this.searchList.addAll(this.pendingList);
        this.adapter.notifyDataSetChanged();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        initClickListener();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ScheduldeHearingNoticeListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
        this.binding.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ScheduldeHearingNoticeListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ScheduldeHearingNoticeListActivity.this.cameraPermission();
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
                String string = new JSONObject(AESDecryptor.decrypt(contents)).getString("epic_no");
                this.barcode = string;
                Log.d("efTrackerTAG", string);
            } catch (Exception unused) {
                this.barcode = contents;
                Log.d("efTrackerTAG", contents);
            }
            this.barcode = this.barcode.replace(StringUtils.SPACE, "");
            this.binding.search.setText(this.barcode);
            Log.d("efTrackerTAG", this.barcode);
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
        this.service.getDeliveryScheduledHearingNoticeList(this.state.toLowerCase(), map, Integer.valueOf(this.partNo), this.state, Integer.valueOf(this.acNo)).enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.ScheduldeHearingNoticeListActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<HearingElectorRoot> {
        AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ScheduldeHearingNoticeListActivity] */
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
        public void onResponse(Call<HearingElectorRoot> call, Response<HearingElectorRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    if (ScheduldeHearingNoticeListActivity.this.alertDialog != null) {
                        ScheduldeHearingNoticeListActivity.this.alertDialog.dismiss();
                    }
                    ScheduldeHearingNoticeListActivity.this.pendingList = ((HearingElectorRoot) response.body()).getPayload();
                    if (ScheduldeHearingNoticeListActivity.this.pendingList != null && !ScheduldeHearingNoticeListActivity.this.pendingList.isEmpty()) {
                        ScheduldeHearingNoticeListActivity.this.searchList.clear();
                        if (!ScheduldeHearingNoticeListActivity.this.pendingList.isEmpty()) {
                            ScheduldeHearingNoticeListActivity.this.searchList.addAll(ScheduldeHearingNoticeListActivity.this.pendingList);
                            ScheduldeHearingNoticeListActivity.this.binding.recyclerView.setAdapter(ScheduldeHearingNoticeListActivity.this.adapter);
                        } else {
                            ScheduldeHearingNoticeListActivity.this.showdialog("Alert", ((HearingElectorRoot) response.body()).getMessage());
                        }
                    } else {
                        ScheduldeHearingNoticeListActivity.this.showdialog("Alert", ((HearingElectorRoot) response.body()).getMessage());
                    }
                    ScheduldeHearingNoticeListActivity.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ScheduldeHearingNoticeListActivity.2.1
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            String string = editable.toString();
                            ArrayList<HearingPayload> arrayList = new ArrayList<>();
                            for (HearingPayload hearingPayload : ScheduldeHearingNoticeListActivity.this.pendingList) {
                                if ((!TextUtils.isEmpty(hearingPayload.getEpicNo()) && hearingPayload.getEpicNo().toLowerCase().contains(string.toLowerCase())) || ((!TextUtils.isEmpty(hearingPayload.getName()) && hearingPayload.getName().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(hearingPayload.getPartSerialNo())) && String.valueOf(hearingPayload.getPartSerialNo()).toLowerCase().contains(string.toLowerCase())))) {
                                    arrayList.add(hearingPayload);
                                }
                            }
                            ScheduldeHearingNoticeListActivity.this.adapter.fun(arrayList);
                        }
                    });
                    return;
                } catch (Exception e) {
                    if (ScheduldeHearingNoticeListActivity.this.alertDialog != null) {
                        ScheduldeHearingNoticeListActivity.this.alertDialog.dismiss();
                    }
                    Logger.d("ScheduleHearingNoticeListActivity", e.toString());
                    return;
                }
            }
            if (response.code() == 400 || response.code() == 401) {
                if (ScheduldeHearingNoticeListActivity.this.alertDialog != null) {
                    ScheduldeHearingNoticeListActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = ScheduldeHearingNoticeListActivity.this.commomUtility;
                ?? r4 = ScheduldeHearingNoticeListActivity.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ScheduldeHearingNoticeListActivity$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (ScheduldeHearingNoticeListActivity.this.alertDialog != null) {
                    ScheduldeHearingNoticeListActivity.this.alertDialog.dismiss();
                }
                Logger.e("efTrackerTAG", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (ScheduldeHearingNoticeListActivity.this.alertDialog != null) {
                    ScheduldeHearingNoticeListActivity.this.alertDialog.dismiss();
                }
                Logger.e("efTrackerTAG", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ScheduldeHearingNoticeListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ScheduldeHearingNoticeListActivity.this.getApplicationContext()).setLocaleBool(false);
            ScheduldeHearingNoticeListActivity.this.startActivity(new Intent(ScheduldeHearingNoticeListActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<HearingElectorRoot> call, Throwable t) {
            if (ScheduldeHearingNoticeListActivity.this.alertDialog != null) {
                ScheduldeHearingNoticeListActivity.this.alertDialog.dismiss();
            }
            Logger.e("efTracker", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ScheduldeHearingNoticeListActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }
}
