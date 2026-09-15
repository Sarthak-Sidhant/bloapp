package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityElectorMappingMainLayoutBinding;
import in.gov.eci.bloapp.model.SIR.ElectorMappingListModel;
import in.gov.eci.bloapp.model.SIR.SelfProgenyModel;
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
public class ElectorMappingMainLayout extends BaseActivity {
    private String acNo;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    ActivityElectorMappingMainLayoutBinding binding;
    String partNo;
    private String refreshToken;
    private String rtkband;
    String state;
    private String token;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    ArrayList<ElectorMappingListModel> electorList = new ArrayList<>();
    ArrayList<ElectorMappingListModel> mappedList = new ArrayList<>();
    ArrayList<ElectorMappingListModel> unmappedList = new ArrayList<>();
    ArrayList<SelfProgenyModel> electorList2 = new ArrayList<>();
    ArrayList<SelfProgenyModel> mappedList2 = new ArrayList<>();
    ArrayList<SelfProgenyModel> unmappedList2 = new ArrayList<>();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityElectorMappingMainLayoutBinding activityElectorMappingMainLayoutBindingInflate = ActivityElectorMappingMainLayoutBinding.inflate(getLayoutInflater());
        this.binding = activityElectorMappingMainLayoutBindingInflate;
        setContentView(activityElectorMappingMainLayoutBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingMainLayout$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.llMapPrevious.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingMainLayout$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.llMapSelf.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingMainLayout$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        startActivity(new Intent((Context) this, (Class<?>) ElectorMappingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        startActivity(new Intent((Context) this, (Class<?>) ElectorProgenyActivity.class));
    }

    protected void onResume() {
        super.onResume();
        getAllElectorList();
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
        allMarkedElectorList.enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.ElectorMappingMainLayout$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMappingMainLayout] */
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
                    if (!ElectorMappingMainLayout.this.electorList.isEmpty()) {
                        ElectorMappingMainLayout.this.electorList.clear();
                    }
                    if (!ElectorMappingMainLayout.this.mappedList.isEmpty()) {
                        ElectorMappingMainLayout.this.mappedList.clear();
                    }
                    if (!ElectorMappingMainLayout.this.unmappedList.isEmpty()) {
                        ElectorMappingMainLayout.this.unmappedList.clear();
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
                        String strOptString12 = jSONObject.optString("epicNo", null);
                        String strOptString13 = jSONObject.optString("modifiedByN", null);
                        String strOptString14 = jSONObject.optString("discrepancyFlag", null);
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
                        ElectorMappingMainLayout.this.electorList.add(new ElectorMappingListModel(iOptInt4, str, str2, str3, strOptString9 + " " + strOptString10, strOptString11, strOptString, iOptInt5, iOptInt6, iOptInt7, strOptString12, iOptInt2, iOptInt3, iOptInt, strOptString6, strOptString13, iOptInt8, iOptInt9, iOptInt10, strOptString14, null));
                        i = i2 + 1;
                        jSONArray = jSONArray2;
                    }
                    for (ElectorMappingListModel electorMappingListModel : ElectorMappingMainLayout.this.electorList) {
                        if (electorMappingListModel.getAc() != 0 && electorMappingListModel.getPart() != 0 && electorMappingListModel.getSerialNo() != 0 && !TextUtils.isEmpty(electorMappingListModel.getModifiedBy()) && !electorMappingListModel.getModifiedBy().equalsIgnoreCase("System") && !electorMappingListModel.getModifiedBy().equalsIgnoreCase("BLO")) {
                            ElectorMappingMainLayout.this.mappedList.add(electorMappingListModel);
                        } else if (electorMappingListModel.getAc() != 0 && electorMappingListModel.getPart() != 0 && electorMappingListModel.getSerialNo() != 0 && !TextUtils.isEmpty(electorMappingListModel.getModifiedBy()) && (electorMappingListModel.getModifiedBy().equalsIgnoreCase("System") || electorMappingListModel.getModifiedBy().equalsIgnoreCase("BLO"))) {
                            ElectorMappingMainLayout.this.mappedList.add(electorMappingListModel);
                        } else {
                            ElectorMappingMainLayout.this.unmappedList.add(electorMappingListModel);
                        }
                    }
                    if (ElectorMappingMainLayout.this.mappedList.size() > 0) {
                        ElectorMappingMainLayout.this.binding.tvMappedCount.setText("Mapped Electors - " + ElectorMappingMainLayout.this.mappedList.size());
                    } else {
                        ElectorMappingMainLayout.this.binding.tvMappedCount.setText("Mapped Electors - 0");
                    }
                    if (ElectorMappingMainLayout.this.unmappedList.size() > 0) {
                        ElectorMappingMainLayout.this.binding.tvUnmappedCount.setText("Unmapped Electors - " + ElectorMappingMainLayout.this.unmappedList.size());
                    } else {
                        ElectorMappingMainLayout.this.binding.tvUnmappedCount.setText("Unmapped Electors - 0");
                    }
                    ElectorMappingMainLayout.this.getAllElectorList2();
                    return;
                } catch (JSONException unused) {
                    return;
                }
            }
            if (response.code() == 400 || response.code() == 401) {
                if (ElectorMappingMainLayout.this.alertDialog != null) {
                    ElectorMappingMainLayout.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = ElectorMappingMainLayout.this.commomUtility;
                ?? r2 = ElectorMappingMainLayout.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingMainLayout$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i3);
                    }
                });
                return;
            }
            try {
                if (ElectorMappingMainLayout.this.alertDialog != null) {
                    ElectorMappingMainLayout.this.alertDialog.dismiss();
                }
                Toast.makeText((Context) ElectorMappingMainLayout.this, (CharSequence) new JSONObject(response.errorBody().string()).optString("message"), 1).show();
                if (ElectorMappingMainLayout.this.alertDialog != null) {
                    ElectorMappingMainLayout.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException unused2) {
                if (ElectorMappingMainLayout.this.alertDialog != null) {
                    ElectorMappingMainLayout.this.alertDialog.dismiss();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ElectorMappingMainLayout.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ElectorMappingMainLayout.this.getApplicationContext()).setLocaleBool(false);
            ElectorMappingMainLayout.this.startActivity(new Intent(ElectorMappingMainLayout.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ElectorMappingMainLayout.this.alertDialog != null) {
                ElectorMappingMainLayout.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    public void getAllElectorList2() {
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
        erollDataListForSelf.enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.ElectorMappingMainLayout$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMappingMainLayout] */
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
                    if (!ElectorMappingMainLayout.this.electorList2.isEmpty()) {
                        ElectorMappingMainLayout.this.electorList2.clear();
                    }
                    if (!ElectorMappingMainLayout.this.mappedList2.isEmpty()) {
                        ElectorMappingMainLayout.this.mappedList2.clear();
                    }
                    if (!ElectorMappingMainLayout.this.unmappedList2.isEmpty()) {
                        ElectorMappingMainLayout.this.unmappedList2.clear();
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
                        if (TextUtils.isEmpty(strOptString2)) {
                            strOptString2 = "";
                        }
                        if (TextUtils.isEmpty(strOptString3)) {
                            strOptString3 = "";
                        }
                        ElectorMappingMainLayout.this.electorList2.add(new SelfProgenyModel(iOptInt, strOptString2 + " " + strOptString3, strOptString, iOptInt2, iOptInt3, TextUtils.isEmpty(strOptString5) ? "" : strOptString5, "", iOptInt4, strOptString6, strOptString7, iOptInt5, strOptString4, strOptString8, strOptString9, strOptString10, strOptString11, strOptString12, null));
                    }
                } catch (JSONException unused) {
                }
                for (SelfProgenyModel selfProgenyModel : ElectorMappingMainLayout.this.electorList2) {
                    if (!TextUtils.isEmpty(selfProgenyModel.getProgenyEpicNo()) && !TextUtils.isEmpty(selfProgenyModel.getCurrentEpicNo())) {
                        ElectorMappingMainLayout.this.mappedList2.add(selfProgenyModel);
                    } else if (!TextUtils.isEmpty(selfProgenyModel.getProgenyEpicNo()) && TextUtils.isEmpty(selfProgenyModel.getCurrentEpicNo())) {
                        ElectorMappingMainLayout.this.mappedList2.add(selfProgenyModel);
                    } else {
                        ElectorMappingMainLayout.this.unmappedList2.add(selfProgenyModel);
                    }
                }
                if (ElectorMappingMainLayout.this.mappedList2.size() > 0) {
                    ElectorMappingMainLayout.this.binding.tvMappedSelfCount.setText("Mapped Electors - " + ElectorMappingMainLayout.this.mappedList2.size());
                } else {
                    ElectorMappingMainLayout.this.binding.tvMappedSelfCount.setText("Mapped Electors - 0");
                }
                if (ElectorMappingMainLayout.this.unmappedList2.size() > 0) {
                    ElectorMappingMainLayout.this.binding.tvUnmappedSelfCount.setText("Unmapped Electors - " + ElectorMappingMainLayout.this.unmappedList2.size());
                } else {
                    ElectorMappingMainLayout.this.binding.tvUnmappedSelfCount.setText("Unmapped Electors - 0");
                }
                ElectorMappingMainLayout.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (ElectorMappingMainLayout.this.alertDialog != null) {
                    ElectorMappingMainLayout.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = ElectorMappingMainLayout.this.commomUtility;
                ?? r2 = ElectorMappingMainLayout.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingMainLayout$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            try {
                if (ElectorMappingMainLayout.this.alertDialog != null) {
                    ElectorMappingMainLayout.this.alertDialog.dismiss();
                }
                Toast.makeText((Context) ElectorMappingMainLayout.this, (CharSequence) new JSONObject(response.errorBody().string()).optString("message"), 1).show();
                if (ElectorMappingMainLayout.this.alertDialog != null) {
                    ElectorMappingMainLayout.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException unused2) {
                if (ElectorMappingMainLayout.this.alertDialog != null) {
                    ElectorMappingMainLayout.this.alertDialog.dismiss();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ElectorMappingMainLayout.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ElectorMappingMainLayout.this.getApplicationContext()).setLocaleBool(false);
            ElectorMappingMainLayout.this.startActivity(new Intent(ElectorMappingMainLayout.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ElectorMappingMainLayout.this.alertDialog != null) {
                ElectorMappingMainLayout.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }
}
