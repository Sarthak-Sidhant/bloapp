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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.MarkVIpListAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityMarkVipListBinding;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.MarkVipItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.MarkVipPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.MarkVipRoot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class MarkVipListActivity extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private String acNo;
    MarkVIpListAdapter adapter;
    ArrayAdapter<String> adapterSpinner;
    AlertDialog alertDialog;
    private String atkband;
    String barcode;
    ActivityMarkVipListBinding binding;
    List<String> efOptionList;
    String[] listArray;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    EditText search;
    UserClient service;
    private String state;
    private String token;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "Session Expired. Please Login again..";
    ArrayList<MarkVipPayload> pendingList = new ArrayList<>();
    ArrayList<MarkVipPayload> searchList = new ArrayList<>();
    private final String TAG = "efTrackerTAG";
    int pendingCount = 0;
    int completedCount = 0;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMarkVipListBinding activityMarkVipListBindingInflate = ActivityMarkVipListBinding.inflate(getLayoutInflater());
        this.binding = activityMarkVipListBindingInflate;
        setContentView(activityMarkVipListBindingInflate.getRoot());
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
        this.binding.spinner.setVisibility(8);
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new MarkVIpListAdapter(this.searchList, this, this.token, this.state, this.atkband, this.rtkband, Integer.parseInt(this.acNo), new MarkVipItemClickCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.MarkVipListActivity.1
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.MarkVipItemClickCallback
            public void onClicked(MarkVipPayload formverificationPayload, String type) {
                MarkVipListActivity.this.getAllPendingList();
            }
        });
        this.binding.recyclerView.setAdapter(this.adapter);
        getAllPendingList();
        this.searchList.clear();
        this.searchList.addAll(this.pendingList);
        this.adapter.notifyDataSetChanged();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.listArray = getResources().getStringArray(R.array.notice_options);
        this.efOptionList = new ArrayList(Arrays.asList(this.listArray));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, android.R.layout.simple_spinner_item, this.efOptionList);
        this.adapterSpinner = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.spinner.setAdapter((SpinnerAdapter) this.adapterSpinner);
        this.binding.spinner.setSelection(0);
        this.binding.spinner.setOnItemSelectedListener(this);
        initClickListener();
        if (this.pendingCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(1));
            String str = getString(R.string.pending_text_dash) + " - " + this.pendingCount;
            this.efOptionList.add(1, str);
            this.efOptionList.set(1, str);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.completedCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(2));
            this.efOptionList.add(2, getString(R.string.completed_text_dash) + " - " + this.completedCount);
            this.adapterSpinner.notifyDataSetChanged();
        }
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.MarkVipListActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
        this.binding.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.MarkVipListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MarkVipListActivity.this.cameraPermission();
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getAllPendingList() {
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
        HashMap map2 = new HashMap();
        map2.put("assemblyNo", this.acNo);
        map2.put("partNumber", this.partNo);
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getVipElector(map, map2).enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.MarkVipListActivity$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<MarkVipRoot> {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.MarkVipListActivity] */
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
        public void onResponse(Call<MarkVipRoot> call, Response<MarkVipRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    if (MarkVipListActivity.this.alertDialog != null) {
                        MarkVipListActivity.this.alertDialog.dismiss();
                    }
                    MarkVipListActivity.this.pendingList = ((MarkVipRoot) response.body()).getPayload();
                    if (MarkVipListActivity.this.pendingList != null && !MarkVipListActivity.this.pendingList.isEmpty()) {
                        MarkVipListActivity.this.searchList.clear();
                        if (!MarkVipListActivity.this.pendingList.isEmpty()) {
                            for (int i = 0; i < MarkVipListActivity.this.pendingList.size(); i++) {
                            }
                            MarkVipListActivity.this.searchList.addAll(MarkVipListActivity.this.pendingList);
                            MarkVipListActivity.this.binding.recyclerView.setAdapter(MarkVipListActivity.this.adapter);
                        }
                    }
                    MarkVipListActivity.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.MarkVipListActivity.3.1
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            String string = editable.toString();
                            ArrayList<MarkVipPayload> arrayList = new ArrayList<>();
                            for (MarkVipPayload markVipPayload : MarkVipListActivity.this.pendingList) {
                                if ((!TextUtils.isEmpty(markVipPayload.getElectorName()) && markVipPayload.getElectorName().toLowerCase().contains(string.toLowerCase())) || ((!TextUtils.isEmpty(markVipPayload.getEpicNumber()) && markVipPayload.getEpicNumber().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(markVipPayload.getPartSerialNumber())) && String.valueOf(markVipPayload.getPartSerialNumber()).toLowerCase().contains(string.toLowerCase())))) {
                                    arrayList.add(markVipPayload);
                                }
                            }
                            MarkVipListActivity.this.adapter.fun(arrayList);
                        }
                    });
                    return;
                } catch (Exception e) {
                    if (MarkVipListActivity.this.alertDialog != null) {
                        MarkVipListActivity.this.alertDialog.dismiss();
                    }
                    Logger.d("ScheduleHearingNoticeListActivity", e.toString());
                    return;
                }
            }
            if (response.code() == 400 || response.code() == 401) {
                if (MarkVipListActivity.this.alertDialog != null) {
                    MarkVipListActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = MarkVipListActivity.this.commomUtility;
                ?? r4 = MarkVipListActivity.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.MarkVipListActivity$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            try {
                if (MarkVipListActivity.this.alertDialog != null) {
                    MarkVipListActivity.this.alertDialog.dismiss();
                }
                Logger.e("efTrackerTAG", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (MarkVipListActivity.this.alertDialog != null) {
                    MarkVipListActivity.this.alertDialog.dismiss();
                }
                Logger.e("efTrackerTAG", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(MarkVipListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(MarkVipListActivity.this.getApplicationContext()).setLocaleBool(false);
            MarkVipListActivity.this.startActivity(new Intent(MarkVipListActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<MarkVipRoot> call, Throwable t) {
            if (MarkVipListActivity.this.alertDialog != null) {
                MarkVipListActivity.this.alertDialog.dismiss();
            }
            Logger.e("efTracker", t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.MarkVipListActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList<MarkVipPayload> arrayList;
        if (position != 0 || this.adapter == null || (arrayList = this.pendingList) == null || arrayList.size() <= 0) {
            return;
        }
        this.adapter.fun(this.pendingList);
        this.binding.recyclerView.setAdapter(this.adapter);
    }
}
