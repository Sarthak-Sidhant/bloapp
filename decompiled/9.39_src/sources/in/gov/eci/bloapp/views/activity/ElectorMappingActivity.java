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
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.ElectorMappedAdapter;
import in.gov.eci.bloapp.adapter.ElectorUnmappedMappingAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityElectorMappingBinding;
import in.gov.eci.bloapp.model.SIR.ElectorMappingListModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ElectorMappingActivity extends BaseActivity {
    private String acNo;
    ElectorMappedAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    ActivityElectorMappingBinding binding;
    String modifiedBy;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    private String state;
    private String token;
    ElectorUnmappedMappingAdapter unmappedadapter;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    private final String TAG = "ElectorMappingTAG";
    ArrayList<ElectorMappingListModel> electorList = new ArrayList<>();
    ArrayList<ElectorMappingListModel> searchList = new ArrayList<>();
    ArrayList<ElectorMappingListModel> mappedList = new ArrayList<>();
    ArrayList<ElectorMappingListModel> unmappedList = new ArrayList<>();
    String selectedTab = "unmapped";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityElectorMappingBinding activityElectorMappingBindingInflate = ActivityElectorMappingBinding.inflate(getLayoutInflater());
        this.binding = activityElectorMappingBindingInflate;
        setContentView(activityElectorMappingBindingInflate.getRoot());
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
        this.adapter = new ElectorMappedAdapter(this.mappedList, this, this.token, this.state, this.atkband, this.rtkband, new MultipleString() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingActivity.1
            @Override // in.gov.eci.bloapp.MultipleString
            public void onCallBack(String status, String message) {
                ElectorMappingActivity.this.binding.search.setText("");
                ElectorMappingActivity electorMappingActivity = ElectorMappingActivity.this;
                electorMappingActivity.selecttab(electorMappingActivity.binding.searchmapped, ElectorMappingActivity.this.binding.searchUnmapped);
                ElectorMappingActivity.this.getAllElectorList();
            }
        });
        this.unmappedadapter = new ElectorUnmappedMappingAdapter(this.unmappedList, this, this.token, this.state, this.atkband, this.rtkband);
        this.binding.recyclerView.setAdapter(this.adapter);
        this.binding.recyclerViewUnmapped.setAdapter(this.unmappedadapter);
        selecttab(this.binding.searchUnmapped, this.binding.searchmapped);
        handleSearchTabClcicks();
        getAllElectorList();
        this.searchList.clear();
        this.searchList.addAll(this.electorList);
        this.adapter.notifyDataSetChanged();
        initClickListener();
        this.binding.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorMappingActivity.this.showDialogColor();
            }
        });
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingActivity$$ExternalSyntheticLambda1
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
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        Call<JsonObject> allMarkedElectorList = ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getAllMarkedElectorList(map, map2);
        this.alertDialog.show();
        allMarkedElectorList.enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.ElectorMappingActivity$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMappingActivity] */
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
            AnonymousClass3 anonymousClass3;
            final AnonymousClass3 anonymousClass4 = this;
            if (response.isSuccessful() && response.body() != null) {
                try {
                    JSONArray jSONArray = new JSONArray(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    if (ElectorMappingActivity.this.electorList.size() > 0) {
                        ElectorMappingActivity.this.electorList.clear();
                    }
                    if (ElectorMappingActivity.this.mappedList.size() > 0) {
                        ElectorMappingActivity.this.mappedList.clear();
                    }
                    if (ElectorMappingActivity.this.unmappedList.size() > 0) {
                        ElectorMappingActivity.this.unmappedList.clear();
                    }
                    int i = 0;
                    while (i < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String strOptString = jSONObject.optString("currentEpicNo", null);
                        String strOptString2 = jSONObject.optString("applicantFirstName", null);
                        String strOptString3 = jSONObject.optString("applicantLastName", null);
                        String strOptString4 = jSONObject.optString(Constants.FIRST_NAME, null);
                        String strOptString5 = jSONObject.optString(Constants.LAST_NAME, null);
                        int iOptInt = jSONObject.optInt("currentSerialNo");
                        int iOptInt2 = jSONObject.optInt("currentAcNo");
                        int iOptInt3 = jSONObject.optInt("currentPartNo");
                        int iOptInt4 = jSONObject.optInt("id");
                        String strOptString6 = jSONObject.optString("currentStateCd", null);
                        int iOptInt5 = jSONObject.optInt("acNo");
                        int iOptInt6 = jSONObject.optInt("partNo");
                        int iOptInt7 = jSONObject.optInt("partSerialNo");
                        int iOptInt8 = jSONObject.optInt("progencyCount");
                        int iOptInt9 = jSONObject.optInt("verifyStatus");
                        int iOptInt10 = jSONObject.optInt("currentAge");
                        String strOptString7 = jSONObject.optString("relativeFname", null);
                        String strOptString8 = jSONObject.optString("relativeLname", null);
                        String strOptString9 = jSONObject.optString("relationName", null);
                        JSONArray jSONArray2 = jSONArray;
                        String strOptString10 = jSONObject.optString("relationLName", null);
                        int i2 = i;
                        String strOptString11 = jSONObject.optString("erollRelationType", null);
                        String strOptString12 = jSONObject.optString("remark", null);
                        String strOptString13 = jSONObject.optString("epicNo", null);
                        try {
                            ElectorMappingActivity.this.modifiedBy = jSONObject.optString("modifiedByN", null);
                            String strOptString14 = jSONObject.optString("discrepancyFlag", null);
                            Logger.d("ElectorMappingTAG", "discrepancyFlag" + strOptString14);
                            if (TextUtils.isEmpty(strOptString11)) {
                                strOptString11 = "";
                            }
                            if (TextUtils.isEmpty(strOptString2)) {
                                strOptString2 = "";
                            }
                            if (TextUtils.isEmpty(strOptString3)) {
                                strOptString3 = "";
                            }
                            if (TextUtils.isEmpty(strOptString4)) {
                                strOptString4 = "";
                            }
                            if (TextUtils.isEmpty(strOptString5)) {
                                strOptString5 = "";
                            }
                            String str = strOptString2 + " " + strOptString3;
                            String str2 = strOptString4 + " " + strOptString5;
                            if (TextUtils.isEmpty(strOptString7)) {
                                strOptString7 = "";
                            }
                            if (TextUtils.isEmpty(strOptString8)) {
                                strOptString8 = "";
                            }
                            String str3 = strOptString7 + " " + strOptString8;
                            if (TextUtils.isEmpty(strOptString9)) {
                                strOptString9 = "";
                            }
                            if (TextUtils.isEmpty(strOptString10)) {
                                strOptString10 = "";
                            }
                            String str4 = strOptString9 + " " + strOptString10;
                            anonymousClass3 = this;
                            try {
                                ElectorMappingActivity.this.electorList.add(new ElectorMappingListModel(iOptInt4, str, str2, str3, str4, strOptString11, strOptString, iOptInt5, iOptInt6, iOptInt7, strOptString13, iOptInt2, iOptInt3, iOptInt, strOptString6, ElectorMappingActivity.this.modifiedBy, iOptInt8, iOptInt9, iOptInt10, strOptString14, strOptString12));
                                i = i2 + 1;
                                anonymousClass4 = anonymousClass3;
                                jSONArray = jSONArray2;
                            } catch (JSONException unused) {
                            }
                        } catch (JSONException unused2) {
                            anonymousClass3 = this;
                        }
                    }
                    anonymousClass3 = anonymousClass4;
                    for (ElectorMappingListModel electorMappingListModel : ElectorMappingActivity.this.electorList) {
                        if (electorMappingListModel.getAc() != 0 && electorMappingListModel.getPart() != 0 && electorMappingListModel.getSerialNo() != 0 && !TextUtils.isEmpty(electorMappingListModel.getModifiedBy()) && !electorMappingListModel.getModifiedBy().equalsIgnoreCase("System") && !electorMappingListModel.getModifiedBy().equalsIgnoreCase("BLO")) {
                            ElectorMappingActivity.this.mappedList.add(electorMappingListModel);
                        } else if (electorMappingListModel.getAc() != 0 && electorMappingListModel.getPart() != 0 && electorMappingListModel.getSerialNo() != 0 && !TextUtils.isEmpty(electorMappingListModel.getModifiedBy()) && (electorMappingListModel.getModifiedBy().equalsIgnoreCase("System") || electorMappingListModel.getModifiedBy().equalsIgnoreCase("BLO"))) {
                            ElectorMappingActivity.this.mappedList.add(electorMappingListModel);
                        } else {
                            ElectorMappingActivity.this.unmappedList.add(electorMappingListModel);
                        }
                    }
                } catch (JSONException unused3) {
                    anonymousClass3 = anonymousClass4;
                }
                if (ElectorMappingActivity.this.selectedTab.equalsIgnoreCase("mapped")) {
                    ElectorMappingActivity.this.binding.recordCount.setText("Total Records - " + ElectorMappingActivity.this.mappedList.size());
                } else {
                    ElectorMappingActivity.this.binding.recordCount.setText("Total Records - " + ElectorMappingActivity.this.unmappedList.size());
                }
                ElectorMappingActivity.this.adapter.fun(ElectorMappingActivity.this.mappedList);
                ElectorMappingActivity.this.binding.recyclerView.setAdapter(ElectorMappingActivity.this.adapter);
                ElectorMappingActivity.this.binding.recyclerViewUnmapped.setAdapter(ElectorMappingActivity.this.unmappedadapter);
                ElectorMappingActivity.this.adapter.notifyDataSetChanged();
                ElectorMappingActivity.this.unmappedadapter.notifyDataSetChanged();
                ElectorMappingActivity.this.alertDialog.dismiss();
                ElectorMappingActivity.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingActivity.3.1
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i3, int i1, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i3, int i1, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        String string = editable.toString();
                        ArrayList<ElectorMappingListModel> arrayList = new ArrayList<>();
                        if (ElectorMappingActivity.this.selectedTab.equalsIgnoreCase("mapped")) {
                            for (ElectorMappingListModel electorMappingListModel2 : ElectorMappingActivity.this.mappedList) {
                                if ((!TextUtils.isEmpty(electorMappingListModel2.getEpicNo()) && electorMappingListModel2.getEpicNo().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(electorMappingListModel2.getName()) && electorMappingListModel2.getName().toLowerCase().contains(string.toLowerCase()))) {
                                    arrayList.add(electorMappingListModel2);
                                }
                            }
                            ElectorMappingActivity.this.adapter.fun(arrayList);
                            return;
                        }
                        if (ElectorMappingActivity.this.selectedTab.equalsIgnoreCase("unmapped")) {
                            for (ElectorMappingListModel electorMappingListModel3 : ElectorMappingActivity.this.unmappedList) {
                                if ((!TextUtils.isEmpty(electorMappingListModel3.getEpicNo()) && electorMappingListModel3.getEpicNo().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(electorMappingListModel3.getName()) && electorMappingListModel3.getName().toLowerCase().contains(string.toLowerCase()))) {
                                    arrayList.add(electorMappingListModel3);
                                }
                            }
                            ElectorMappingActivity.this.unmappedadapter.fun(arrayList);
                            return;
                        }
                        for (ElectorMappingListModel electorMappingListModel4 : ElectorMappingActivity.this.electorList) {
                            if ((!TextUtils.isEmpty(electorMappingListModel4.getEpicNo()) && electorMappingListModel4.getEpicNo().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(electorMappingListModel4.getName()) && electorMappingListModel4.getName().toLowerCase().contains(string.toLowerCase()))) {
                                arrayList.add(electorMappingListModel4);
                            }
                        }
                        ElectorMappingActivity.this.adapter.fun(arrayList);
                    }
                });
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (ElectorMappingActivity.this.alertDialog != null) {
                    ElectorMappingActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = ElectorMappingActivity.this.commomUtility;
                ?? r1 = ElectorMappingActivity.this;
                commomUtility.showMessageOK(r1, r1.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingActivity$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i3);
                    }
                });
                return;
            }
            try {
                if (ElectorMappingActivity.this.alertDialog != null) {
                    ElectorMappingActivity.this.alertDialog.dismiss();
                }
                String strOptString15 = new JSONObject(response.errorBody().string()).optString("message");
                Toast.makeText((Context) ElectorMappingActivity.this, (CharSequence) strOptString15, 1).show();
                Logger.e("ElectorMappingTAG", strOptString15);
                if (ElectorMappingActivity.this.alertDialog != null) {
                    ElectorMappingActivity.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (ElectorMappingActivity.this.alertDialog != null) {
                    ElectorMappingActivity.this.alertDialog.dismiss();
                }
                Logger.e("ElectorMappingTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ElectorMappingActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ElectorMappingActivity.this.getApplicationContext()).setLocaleBool(false);
            ElectorMappingActivity.this.startActivity(new Intent(ElectorMappingActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ElectorMappingActivity.this.alertDialog != null) {
                ElectorMappingActivity.this.alertDialog.dismiss();
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
        new AlertDialog.Builder(this).setTitle("").setView(LayoutInflater.from(this).inflate(R.layout.custom_note_elector_mapping, (ViewGroup) null)).setPositiveButton(getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingActivity.4
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
        this.binding.searchmapped.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$2(view);
            }
        });
        this.binding.searchUnmapped.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$2(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleSearchTabClcicks$1();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$1() {
        this.binding.searchTabLayout.setVisibility(0);
        this.binding.search.setText("");
        this.binding.recyclerView.setVisibility(0);
        this.binding.recyclerViewUnmapped.setVisibility(8);
        selecttab(this.binding.searchmapped, this.binding.searchUnmapped);
        getAllElectorList();
        this.selectedTab = "mapped";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$4(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingActivity$$ExternalSyntheticLambda2
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
