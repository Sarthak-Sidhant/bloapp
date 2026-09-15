package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MultipleString;
import in.gov.eci.bloapp.ProgenyAdapter;
import in.gov.eci.bloapp.ProgenyunmappedAdapter;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityProgenyMappingBinding;
import in.gov.eci.bloapp.model.SIR.SelfProgenyModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ElectorProgenyActivity extends BaseActivity {
    private String acNo;
    ProgenyAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    ActivityProgenyMappingBinding binding;
    String modifiedBy;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    private String state;
    private String token;
    ProgenyunmappedAdapter unmappedadapter;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    private final String TAG = "ElectorMappingTAG";
    ArrayList<SelfProgenyModel> electorList = new ArrayList<>();
    ArrayList<SelfProgenyModel> searchList = new ArrayList<>();
    ArrayList<SelfProgenyModel> mappedList = new ArrayList<>();
    ArrayList<SelfProgenyModel> unmappedList = new ArrayList<>();
    String selectedTab = "unmapped";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProgenyMappingBinding activityProgenyMappingBindingInflate = ActivityProgenyMappingBinding.inflate(getLayoutInflater());
        this.binding = activityProgenyMappingBindingInflate;
        setContentView(activityProgenyMappingBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
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
        this.binding.recyclerViewUnmapped.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new ProgenyAdapter(this.mappedList, this, this.token, this.state, this.atkband, this.rtkband, new MultipleString() { // from class: in.gov.eci.bloapp.views.activity.ElectorProgenyActivity.1
            @Override // in.gov.eci.bloapp.MultipleString
            public void onCallBack(String status, String message) {
                ElectorProgenyActivity.this.binding.search.setText("");
                ElectorProgenyActivity electorProgenyActivity = ElectorProgenyActivity.this;
                electorProgenyActivity.selecttab(electorProgenyActivity.binding.searchmapped, ElectorProgenyActivity.this.binding.searchUnmapped);
                ElectorProgenyActivity.this.getAllElectorList();
            }
        });
        this.unmappedadapter = new ProgenyunmappedAdapter(this.unmappedList, this, this.token, this.state, this.atkband, this.rtkband);
        this.binding.recyclerView.setAdapter(this.adapter);
        this.binding.recyclerViewUnmapped.setAdapter(this.adapter);
        selecttab(this.binding.searchUnmapped, this.binding.searchmapped);
        handleSearchTabClcicks();
        getAllElectorList();
        this.searchList.clear();
        this.searchList.addAll(this.electorList);
        this.adapter.notifyDataSetChanged();
        initClickListener();
        this.binding.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorProgenyActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorProgenyActivity.this.showDialogColor();
            }
        });
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorProgenyActivity$$ExternalSyntheticLambda0
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

    public void getAllElectorList() {
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
        Call<JsonObject> erollDataListForSelf = ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getErollDataListForSelf(map, map2);
        this.alertDialog.show();
        erollDataListForSelf.enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.ElectorProgenyActivity$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorProgenyActivity] */
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
            if (response.isSuccessful() && response.body() != null) {
                try {
                    JSONArray jSONArray = new JSONArray(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    if (ElectorProgenyActivity.this.electorList.size() > 0) {
                        ElectorProgenyActivity.this.electorList.clear();
                    }
                    if (ElectorProgenyActivity.this.mappedList.size() > 0) {
                        ElectorProgenyActivity.this.mappedList.clear();
                    }
                    if (ElectorProgenyActivity.this.unmappedList.size() > 0) {
                        ElectorProgenyActivity.this.unmappedList.clear();
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String strOptString = jSONObject.optString("epicNumber", null);
                        String strOptString2 = jSONObject.optString("applicantFirstName", null);
                        String strOptString3 = jSONObject.optString("applicantLastName", null);
                        int iOptInt = jSONObject.optInt("id");
                        jSONObject.optString("stateCd", null);
                        int iOptInt2 = jSONObject.optInt("acNo");
                        int iOptInt3 = jSONObject.optInt("partNumber");
                        int iOptInt4 = jSONObject.optInt("partSerialNumber");
                        int iOptInt5 = jSONObject.optInt("age", 0);
                        String strOptString4 = jSONObject.optString("discrepancyFlag", null);
                        String strOptString5 = jSONObject.optString("relationName", null);
                        String strOptString6 = jSONObject.optString("progenyEpicNo", null);
                        String strOptString7 = jSONObject.optString("currentEpic", null);
                        String strOptString8 = jSONObject.optString("currentstate", null);
                        String strOptString9 = jSONObject.optString("currentacNo", null);
                        String strOptString10 = jSONObject.optString("currentpartNo", null);
                        String strOptString11 = jSONObject.optString("currentpartSerialNo", null);
                        String strOptString12 = jSONObject.optString("currentEpicNo", null);
                        String strOptString13 = jSONObject.optString("remark", null);
                        if (TextUtils.isEmpty(strOptString2)) {
                            strOptString2 = "";
                        }
                        if (TextUtils.isEmpty(strOptString3)) {
                            strOptString3 = "";
                        }
                        ElectorProgenyActivity.this.electorList.add(new SelfProgenyModel(iOptInt, strOptString2 + StringUtils.SPACE + strOptString3, strOptString, iOptInt2, iOptInt3, TextUtils.isEmpty(strOptString5) ? "" : strOptString5, "", iOptInt4, strOptString6, strOptString7, iOptInt5, strOptString4, strOptString8, strOptString9, strOptString10, strOptString11, strOptString12, strOptString13));
                    }
                } catch (JSONException unused) {
                }
                for (SelfProgenyModel selfProgenyModel : ElectorProgenyActivity.this.electorList) {
                    if (!TextUtils.isEmpty(selfProgenyModel.getProgenyEpicNo()) && !TextUtils.isEmpty(selfProgenyModel.getCurrentEpic())) {
                        ElectorProgenyActivity.this.mappedList.add(selfProgenyModel);
                    } else if (!TextUtils.isEmpty(selfProgenyModel.getProgenyEpicNo()) && TextUtils.isEmpty(selfProgenyModel.getCurrentEpic())) {
                        ElectorProgenyActivity.this.mappedList.add(selfProgenyModel);
                    } else {
                        ElectorProgenyActivity.this.unmappedList.add(selfProgenyModel);
                    }
                }
                ElectorProgenyActivity.this.searchList.addAll(ElectorProgenyActivity.this.electorList);
                if (ElectorProgenyActivity.this.selectedTab.equalsIgnoreCase("mapped")) {
                    ElectorProgenyActivity.this.binding.recordCount.setText("Total Records - " + ElectorProgenyActivity.this.mappedList.size());
                } else {
                    ElectorProgenyActivity.this.binding.recordCount.setText("Total Records - " + ElectorProgenyActivity.this.unmappedList.size());
                }
                ElectorProgenyActivity.this.adapter.fun(ElectorProgenyActivity.this.mappedList);
                ElectorProgenyActivity.this.binding.recyclerView.setAdapter(ElectorProgenyActivity.this.adapter);
                ElectorProgenyActivity.this.binding.recyclerViewUnmapped.setAdapter(ElectorProgenyActivity.this.unmappedadapter);
                ElectorProgenyActivity.this.adapter.notifyDataSetChanged();
                ElectorProgenyActivity.this.unmappedadapter.notifyDataSetChanged();
                ElectorProgenyActivity.this.alertDialog.dismiss();
                ElectorProgenyActivity.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.ElectorProgenyActivity.3.1
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        String string = editable.toString();
                        ArrayList<SelfProgenyModel> arrayList = new ArrayList<>();
                        if (ElectorProgenyActivity.this.selectedTab.equalsIgnoreCase("mapped")) {
                            for (SelfProgenyModel selfProgenyModel2 : ElectorProgenyActivity.this.mappedList) {
                                if ((!TextUtils.isEmpty(selfProgenyModel2.getEpicNo()) && selfProgenyModel2.getEpicNo().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(selfProgenyModel2.getElectorName()) && selfProgenyModel2.getElectorName().toLowerCase().contains(string.toLowerCase()))) {
                                    arrayList.add(selfProgenyModel2);
                                }
                            }
                            ElectorProgenyActivity.this.adapter.fun(arrayList);
                            return;
                        }
                        if (ElectorProgenyActivity.this.selectedTab.equalsIgnoreCase("unmapped")) {
                            for (SelfProgenyModel selfProgenyModel3 : ElectorProgenyActivity.this.unmappedList) {
                                if ((!TextUtils.isEmpty(selfProgenyModel3.getEpicNo()) && selfProgenyModel3.getEpicNo().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(selfProgenyModel3.getElectorName()) && selfProgenyModel3.getElectorName().toLowerCase().contains(string.toLowerCase()))) {
                                    arrayList.add(selfProgenyModel3);
                                }
                            }
                            ElectorProgenyActivity.this.unmappedadapter.fun(arrayList);
                            return;
                        }
                        for (SelfProgenyModel selfProgenyModel4 : ElectorProgenyActivity.this.electorList) {
                            if ((!TextUtils.isEmpty(selfProgenyModel4.getEpicNo()) && selfProgenyModel4.getEpicNo().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(selfProgenyModel4.getElectorName()) && selfProgenyModel4.getElectorName().toLowerCase().contains(string.toLowerCase()))) {
                                arrayList.add(selfProgenyModel4);
                            }
                        }
                        ElectorProgenyActivity.this.adapter.fun(arrayList);
                    }
                });
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (ElectorProgenyActivity.this.alertDialog != null) {
                    ElectorProgenyActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = ElectorProgenyActivity.this.commomUtility;
                ?? r2 = ElectorProgenyActivity.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorProgenyActivity$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            try {
                if (ElectorProgenyActivity.this.alertDialog != null) {
                    ElectorProgenyActivity.this.alertDialog.dismiss();
                }
                String strOptString14 = new JSONObject(response.errorBody().string()).optString("message");
                Toast.makeText((Context) ElectorProgenyActivity.this, (CharSequence) strOptString14, 1).show();
                Logger.e("ElectorMappingTAG", strOptString14);
                if (ElectorProgenyActivity.this.alertDialog != null) {
                    ElectorProgenyActivity.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (ElectorProgenyActivity.this.alertDialog != null) {
                    ElectorProgenyActivity.this.alertDialog.dismiss();
                }
                Logger.e("ElectorMappingTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ElectorProgenyActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ElectorProgenyActivity.this.getApplicationContext()).setLocaleBool(false);
            ElectorProgenyActivity.this.startActivity(new Intent(ElectorProgenyActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ElectorProgenyActivity.this.alertDialog != null) {
                ElectorProgenyActivity.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("restart", false)) {
            this.binding.search.setText("");
            recreate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void showDialogColor() {
        new AlertDialog.Builder(this).setTitle("").setView(LayoutInflater.from(this).inflate(R.layout.custom_note_elector_mapping, (ViewGroup) null)).setPositiveButton(getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorProgenyActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void selecttab(MaterialButton selected, MaterialButton other) {
        selected.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.new_tab_color));
        selected.setTextColor(ContextCompat.getColor(this, R.color.blo_white));
        other.setBackgroundTintList(ContextCompat.getColorStateList(this, android.R.color.transparent));
        other.setTextColor(ContextCompat.getColor(this, R.color.blo_black));
        other.setStrokeWidth(2);
        other.setStrokeColor(ContextCompat.getColorStateList(this, R.color.blo_light_grey));
        if (selected.getId() == this.binding.searchmapped.getId()) {
            this.binding.recyclerView.setVisibility(0);
            this.binding.recyclerViewUnmapped.setVisibility(8);
        } else {
            this.binding.recyclerView.setVisibility(8);
            this.binding.recyclerViewUnmapped.setVisibility(0);
        }
    }

    private void handleSearchTabClcicks() {
        this.binding.searchmapped.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorProgenyActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$2(view);
            }
        });
        this.binding.searchUnmapped.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorProgenyActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$2(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.ElectorProgenyActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleSearchTabClcicks$1();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$1() {
        this.binding.search.setText("");
        this.binding.searchTabLayout.setVisibility(0);
        this.binding.recyclerView.setVisibility(0);
        this.binding.recyclerViewUnmapped.setVisibility(8);
        selecttab(this.binding.searchmapped, this.binding.searchUnmapped);
        getAllElectorList();
        this.selectedTab = "mapped";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$4(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.ElectorProgenyActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleSearchTabClcicks$3();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$3() {
        this.binding.search.setText("");
        this.binding.searchTabLayout.setVisibility(0);
        this.binding.recyclerView.setVisibility(8);
        this.binding.recyclerViewUnmapped.setVisibility(0);
        selecttab(this.binding.searchUnmapped, this.binding.searchmapped);
        getAllElectorList();
        this.selectedTab = "unmapped";
    }
}
