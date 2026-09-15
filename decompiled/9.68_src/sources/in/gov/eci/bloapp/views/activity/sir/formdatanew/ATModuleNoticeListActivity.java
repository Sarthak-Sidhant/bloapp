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
import in.gov.eci.bloapp.adapter.ATListAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityScheduldeHearingNoticeListBinding;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.model.ATModuleRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.ATPayload;
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
public class ATModuleNoticeListActivity extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private String acNo;
    ATListAdapter adapter;
    ArrayAdapter<String> adapterSpinner;
    AlertDialog alertDialog;
    private String atkband;
    String barcode;
    ActivityScheduldeHearingNoticeListBinding binding;
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
    ArrayList<ATPayload> pendingList = new ArrayList<>();
    ArrayList<ATPayload> searchList = new ArrayList<>();
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
        this.binding.spinner.setVisibility(0);
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new ATListAdapter(this.searchList, this);
        this.binding.recyclerView.setAdapter(this.adapter);
        getAllPendingList();
        this.searchList.clear();
        this.searchList.addAll(this.pendingList);
        this.adapter.notifyDataSetChanged();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.textView3.setText("AT Notice Delivery");
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
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ATModuleNoticeListActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
        this.binding.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ATModuleNoticeListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ATModuleNoticeListActivity.this.cameraPermission();
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

    /* JADX WARN: Multi-variable type inference failed */
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
        HashMap map2 = new HashMap();
        map2.put("acCd", this.acNo);
        map2.put("partNo", this.partNo);
        map2.put("stateCd", this.state);
        map2.put("limit", "2000");
        map2.put("pageNo", 0);
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getATNoticeList(map, map2).enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.ATModuleNoticeListActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<ATModuleRoot> {
        AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.ATModuleNoticeListActivity] */
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
        public void onResponse(Call<ATModuleRoot> call, Response<ATModuleRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    if (ATModuleNoticeListActivity.this.alertDialog != null) {
                        ATModuleNoticeListActivity.this.alertDialog.dismiss();
                    }
                    ATModuleNoticeListActivity.this.pendingList = ((ATModuleRoot) response.body()).getPayload();
                    if (ATModuleNoticeListActivity.this.pendingList != null && !ATModuleNoticeListActivity.this.pendingList.isEmpty()) {
                        ATModuleNoticeListActivity.this.searchList.clear();
                        if (!ATModuleNoticeListActivity.this.pendingList.isEmpty()) {
                            for (int i = 0; i < ATModuleNoticeListActivity.this.pendingList.size(); i++) {
                                if (TextUtils.isEmpty(ATModuleNoticeListActivity.this.pendingList.get(i).getBloNoticeDelivered())) {
                                    ATModuleNoticeListActivity.this.pendingCount++;
                                    ATModuleNoticeListActivity.this.efOptionList.remove(ATModuleNoticeListActivity.this.adapterSpinner.getItem(1));
                                    String str = ATModuleNoticeListActivity.this.getString(R.string.pending_text_dash) + "  - " + ATModuleNoticeListActivity.this.pendingCount;
                                    ATModuleNoticeListActivity.this.efOptionList.add(1, str);
                                    ATModuleNoticeListActivity.this.efOptionList.set(1, str);
                                    ATModuleNoticeListActivity.this.adapterSpinner.notifyDataSetChanged();
                                } else {
                                    ATModuleNoticeListActivity.this.completedCount++;
                                    ATModuleNoticeListActivity.this.efOptionList.remove(ATModuleNoticeListActivity.this.adapterSpinner.getItem(2));
                                    ATModuleNoticeListActivity.this.efOptionList.add(2, ATModuleNoticeListActivity.this.getString(R.string.completed_text_dash) + " - " + ATModuleNoticeListActivity.this.completedCount);
                                    ATModuleNoticeListActivity.this.adapterSpinner.notifyDataSetChanged();
                                }
                            }
                            ATModuleNoticeListActivity.this.searchList.addAll(ATModuleNoticeListActivity.this.pendingList);
                            ATModuleNoticeListActivity.this.binding.recyclerView.setAdapter(ATModuleNoticeListActivity.this.adapter);
                        }
                    }
                    ATModuleNoticeListActivity.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ATModuleNoticeListActivity.2.1
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            String string = editable.toString();
                            ArrayList<ATPayload> arrayList = new ArrayList<>();
                            for (ATPayload aTPayload : ATModuleNoticeListActivity.this.pendingList) {
                                if ((!TextUtils.isEmpty(aTPayload.getUserEpic()) && aTPayload.getUserEpic().toLowerCase().contains(string.toLowerCase())) || ((!TextUtils.isEmpty(aTPayload.getComplainantName()) && aTPayload.getComplainantName().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(aTPayload.getPartSerialNo())) && String.valueOf(aTPayload.getPartSerialNo()).toLowerCase().contains(string.toLowerCase())))) {
                                    arrayList.add(aTPayload);
                                }
                            }
                            ATModuleNoticeListActivity.this.adapter.fun(arrayList);
                        }
                    });
                    return;
                } catch (Exception e) {
                    if (ATModuleNoticeListActivity.this.alertDialog != null) {
                        ATModuleNoticeListActivity.this.alertDialog.dismiss();
                    }
                    Logger.d("ScheduleHearingNoticeListActivity", e.toString());
                    return;
                }
            }
            if (response.code() == 400 || response.code() == 401) {
                if (ATModuleNoticeListActivity.this.alertDialog != null) {
                    ATModuleNoticeListActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = ATModuleNoticeListActivity.this.commomUtility;
                ?? r5 = ATModuleNoticeListActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ATModuleNoticeListActivity$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            try {
                if (ATModuleNoticeListActivity.this.alertDialog != null) {
                    ATModuleNoticeListActivity.this.alertDialog.dismiss();
                }
                Logger.e("efTrackerTAG", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (ATModuleNoticeListActivity.this.alertDialog != null) {
                    ATModuleNoticeListActivity.this.alertDialog.dismiss();
                }
                Logger.e("efTrackerTAG", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ATModuleNoticeListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ATModuleNoticeListActivity.this.getApplicationContext()).setLocaleBool(false);
            ATModuleNoticeListActivity.this.startActivity(new Intent(ATModuleNoticeListActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<ATModuleRoot> call, Throwable t) {
            if (ATModuleNoticeListActivity.this.alertDialog != null) {
                ATModuleNoticeListActivity.this.alertDialog.dismiss();
            }
            Logger.e("efTracker", t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.ATModuleNoticeListActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList<ATPayload> arrayList;
        if (position == 0 && this.adapter != null && (arrayList = this.pendingList) != null && arrayList.size() > 0) {
            this.adapter.fun(this.pendingList);
            this.binding.recyclerView.setAdapter(this.adapter);
        }
        if (position == 1) {
            ArrayList<ATPayload> arrayList2 = new ArrayList<>();
            for (ATPayload aTPayload : this.pendingList) {
                if (TextUtils.isEmpty(aTPayload.getBloNoticeDelivered())) {
                    arrayList2.add(aTPayload);
                }
            }
            ATListAdapter aTListAdapter = this.adapter;
            if (aTListAdapter != null) {
                aTListAdapter.fun(arrayList2);
            }
        }
        if (position == 2) {
            ArrayList<ATPayload> arrayList3 = new ArrayList<>();
            for (ATPayload aTPayload2 : this.pendingList) {
                if (!TextUtils.isEmpty(aTPayload2.getBloNoticeDelivered()) && aTPayload2.getBloNoticeDelivered().equalsIgnoreCase("1")) {
                    arrayList3.add(aTPayload2);
                }
            }
            ATListAdapter aTListAdapter2 = this.adapter;
            if (aTListAdapter2 != null) {
                aTListAdapter2.fun(arrayList3);
            }
        }
    }
}
