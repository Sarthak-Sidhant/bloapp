package in.gov.eci.bloapp.views.activity.sir.formdatanew;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.AddNotionalListAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityAddNotionalListBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.AddNotinalItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.AddNotionalPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.AddNotionalRoot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AddNotionalListActivity extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private String acNo;
    AddNotionalListAdapter adapter;
    ArrayAdapter<String> adapterSpinner;
    AlertDialog alertDialog;
    private String atkband;
    String barcode;
    ActivityAddNotionalListBinding binding;
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
    ArrayList<AddNotionalPayload> pendingList = new ArrayList<>();
    ArrayList<AddNotionalPayload> searchList = new ArrayList<>();
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
        ActivityAddNotionalListBinding activityAddNotionalListBindingInflate = ActivityAddNotionalListBinding.inflate(getLayoutInflater());
        this.binding = activityAddNotionalListBindingInflate;
        setContentView(activityAddNotionalListBindingInflate.getRoot());
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
        this.adapter = new AddNotionalListAdapter(this.searchList, this, this.token, this.state, this.atkband, this.rtkband, Integer.parseInt(this.acNo), Integer.parseInt(this.partNo), new AddNotinalItemClickCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.AddNotionalListActivity.1
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.AddNotinalItemClickCallback
            public void onClicked(AddNotionalPayload formverificationPayload, String type) {
                AddNotionalListActivity.this.getAllPendingList();
            }
        });
        this.binding.recyclerView.setAdapter(this.adapter);
        getAllPendingList();
        this.searchList.clear();
        this.searchList.addAll(this.pendingList);
        this.adapter.notifyDataSetChanged();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        initClickListener();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.AddNotionalListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        finish();
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
        map.put("partNo", this.partNo);
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getNotionalHNo(map).enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.AddNotionalListActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<AddNotionalRoot> {
        AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.AddNotionalListActivity] */
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
        public void onResponse(Call<AddNotionalRoot> call, Response<AddNotionalRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    if (AddNotionalListActivity.this.alertDialog != null) {
                        AddNotionalListActivity.this.alertDialog.dismiss();
                    }
                    AddNotionalListActivity.this.pendingList = ((AddNotionalRoot) response.body()).getPayload();
                    if (AddNotionalListActivity.this.pendingList != null && !AddNotionalListActivity.this.pendingList.isEmpty()) {
                        AddNotionalListActivity.this.searchList.clear();
                        if (!AddNotionalListActivity.this.pendingList.isEmpty()) {
                            for (int i = 0; i < AddNotionalListActivity.this.pendingList.size(); i++) {
                            }
                            AddNotionalListActivity.this.searchList.addAll(AddNotionalListActivity.this.pendingList);
                            AddNotionalListActivity.this.binding.recyclerView.setAdapter(AddNotionalListActivity.this.adapter);
                        }
                    }
                    AddNotionalListActivity.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.AddNotionalListActivity.2.1
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            String string = editable.toString();
                            ArrayList<AddNotionalPayload> arrayList = new ArrayList<>();
                            for (AddNotionalPayload addNotionalPayload : AddNotionalListActivity.this.pendingList) {
                                if ((!TextUtils.isEmpty(addNotionalPayload.getName()) && addNotionalPayload.getName().toLowerCase().contains(string.toLowerCase())) || ((!TextUtils.isEmpty(addNotionalPayload.getEpicNo()) && addNotionalPayload.getEpicNo().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(addNotionalPayload.getPartSerialNumber())) && String.valueOf(addNotionalPayload.getPartSerialNumber()).toLowerCase().contains(string.toLowerCase())))) {
                                    arrayList.add(addNotionalPayload);
                                }
                            }
                            AddNotionalListActivity.this.adapter.fun(arrayList);
                        }
                    });
                    return;
                } catch (Exception e) {
                    if (AddNotionalListActivity.this.alertDialog != null) {
                        AddNotionalListActivity.this.alertDialog.dismiss();
                    }
                    Logger.d("ScheduleHearingNoticeListActivity", e.toString());
                    return;
                }
            }
            if (response.code() == 400 || response.code() == 401) {
                if (AddNotionalListActivity.this.alertDialog != null) {
                    AddNotionalListActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = AddNotionalListActivity.this.commomUtility;
                ?? r4 = AddNotionalListActivity.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.AddNotionalListActivity$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            try {
                if (AddNotionalListActivity.this.alertDialog != null) {
                    AddNotionalListActivity.this.alertDialog.dismiss();
                }
                AddNotionalListActivity.this.showdialog("Alert", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (AddNotionalListActivity.this.alertDialog != null) {
                    AddNotionalListActivity.this.alertDialog.dismiss();
                }
                Logger.e("efTrackerTAG", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AddNotionalListActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AddNotionalListActivity.this.getApplicationContext()).setLocaleBool(false);
            AddNotionalListActivity.this.startActivity(new Intent(AddNotionalListActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<AddNotionalRoot> call, Throwable t) {
            if (AddNotionalListActivity.this.alertDialog != null) {
                AddNotionalListActivity.this.alertDialog.dismiss();
            }
            Logger.e("efTracker", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.AddNotionalListActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog$1(DialogInterface dialogInterface, int i) {
        finish();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList<AddNotionalPayload> arrayList;
        if (position != 0 || this.adapter == null || (arrayList = this.pendingList) == null || arrayList.size() <= 0) {
            return;
        }
        this.adapter.fun(this.pendingList);
        this.binding.recyclerView.setAdapter(this.adapter);
    }
}
