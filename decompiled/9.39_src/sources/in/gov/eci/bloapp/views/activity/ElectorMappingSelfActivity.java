package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.ElectorMappingAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityElectorSelfMappingBinding;
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
public class ElectorMappingSelfActivity extends BaseActivity {
    private String acNo;
    ElectorMappingAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    ActivityElectorSelfMappingBinding binding;
    String modifiedBy;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    private String state;
    private String token;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    private final String TAG = "ElectorMappingTAG";
    ArrayList<ElectorMappingListModel> electorList = new ArrayList<>();
    ArrayList<ElectorMappingListModel> searchList = new ArrayList<>();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityElectorSelfMappingBinding activityElectorSelfMappingBindingInflate = ActivityElectorSelfMappingBinding.inflate(getLayoutInflater());
        this.binding = activityElectorSelfMappingBindingInflate;
        setContentView(activityElectorSelfMappingBindingInflate.getRoot());
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
        this.adapter = new ElectorMappingAdapter(this.searchList, this, this.token, this.state, this.atkband, this.rtkband);
        this.binding.recyclerView.setAdapter(this.adapter);
        getAllElectorList();
        this.searchList.clear();
        this.searchList.addAll(this.electorList);
        this.adapter.notifyDataSetChanged();
        initClickListener();
        this.binding.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingSelfActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorMappingSelfActivity.this.showDialogColor();
            }
        });
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingSelfActivity$$ExternalSyntheticLambda0
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
        erollDataListForSelf.enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.ElectorMappingSelfActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMappingSelfActivity] */
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
            AnonymousClass2 anonymousClass2;
            final AnonymousClass2 anonymousClass3 = this;
            if (response.isSuccessful() && response.body() != null) {
                try {
                    JSONArray jSONArray = new JSONArray(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    int i = 0;
                    while (i < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String strOptString = jSONObject.optString("epicNumber", null);
                        String strOptString2 = jSONObject.optString("applicantFirstName", null);
                        String strOptString3 = jSONObject.optString("applicantLastName", null);
                        String strOptString4 = jSONObject.optString(Constants.FIRST_NAME, null);
                        String strOptString5 = jSONObject.optString(Constants.LAST_NAME, null);
                        int iOptInt = jSONObject.optInt("currentSerialNo");
                        int iOptInt2 = jSONObject.optInt("currentAcNo");
                        int iOptInt3 = jSONObject.optInt("partSerialNumber");
                        int iOptInt4 = jSONObject.optInt("id");
                        String strOptString6 = jSONObject.optString("currentStateCd", null);
                        int iOptInt5 = jSONObject.optInt("acNo");
                        int iOptInt6 = jSONObject.optInt("partNo");
                        int iOptInt7 = jSONObject.optInt("partSerialNo");
                        int iOptInt8 = jSONObject.optInt("progencyCount");
                        int iOptInt9 = jSONObject.optInt("verifyStatus");
                        String strOptString7 = jSONObject.optString("relativeFname", null);
                        String strOptString8 = jSONObject.optString("relativeLname", null);
                        String strOptString9 = jSONObject.optString("relationName", null);
                        JSONArray jSONArray2 = jSONArray;
                        String strOptString10 = jSONObject.optString("relationLName", null);
                        int i2 = i;
                        String strOptString11 = jSONObject.optString("erollRelationType", null);
                        String strOptString12 = jSONObject.optString("epicNo", null);
                        try {
                            ElectorMappingSelfActivity.this.modifiedBy = jSONObject.optString("modifiedByN", null);
                            String strOptString13 = jSONObject.optString("discrepancyFlag", null);
                            String strOptString14 = jSONObject.optString("remark", null);
                            Logger.d("ElectorMappingTAG", "discrepancyFlag" + strOptString13);
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
                            anonymousClass2 = this;
                            try {
                                ElectorMappingSelfActivity.this.electorList.add(new ElectorMappingListModel(iOptInt4, str, str2, str3, str4, strOptString11, strOptString, iOptInt5, iOptInt6, iOptInt7, strOptString12, iOptInt2, iOptInt3, iOptInt, strOptString6, ElectorMappingSelfActivity.this.modifiedBy, iOptInt8, iOptInt9, 0, strOptString13, strOptString14));
                                ElectorMappingSelfActivity.this.adapter.notifyDataSetChanged();
                                i = i2 + 1;
                                anonymousClass3 = anonymousClass2;
                                jSONArray = jSONArray2;
                            } catch (JSONException unused) {
                            }
                        } catch (JSONException unused2) {
                            anonymousClass2 = this;
                        }
                    }
                } catch (JSONException unused3) {
                }
                anonymousClass2 = anonymousClass3;
                ElectorMappingSelfActivity.this.searchList.addAll(ElectorMappingSelfActivity.this.electorList);
                ElectorMappingSelfActivity.this.binding.recyclerView.setAdapter(ElectorMappingSelfActivity.this.adapter);
                ElectorMappingSelfActivity.this.alertDialog.dismiss();
                ElectorMappingSelfActivity.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingSelfActivity.2.1
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
                        for (ElectorMappingListModel electorMappingListModel : ElectorMappingSelfActivity.this.electorList) {
                            if ((!TextUtils.isEmpty(electorMappingListModel.getEpicNo()) && electorMappingListModel.getEpicNo().toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(electorMappingListModel.getName()) && electorMappingListModel.getName().toLowerCase().contains(string.toLowerCase()))) {
                                arrayList.add(electorMappingListModel);
                            }
                        }
                        ElectorMappingSelfActivity.this.adapter.fun(arrayList);
                    }
                });
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (ElectorMappingSelfActivity.this.alertDialog != null) {
                    ElectorMappingSelfActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = ElectorMappingSelfActivity.this.commomUtility;
                ?? r1 = ElectorMappingSelfActivity.this;
                commomUtility.showMessageOK(r1, r1.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingSelfActivity$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i3);
                    }
                });
                return;
            }
            try {
                if (ElectorMappingSelfActivity.this.alertDialog != null) {
                    ElectorMappingSelfActivity.this.alertDialog.dismiss();
                }
                String strOptString15 = new JSONObject(response.errorBody().string()).optString("message");
                Toast.makeText((Context) ElectorMappingSelfActivity.this, (CharSequence) strOptString15, 1).show();
                Logger.e("ElectorMappingTAG", strOptString15);
                if (ElectorMappingSelfActivity.this.alertDialog != null) {
                    ElectorMappingSelfActivity.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (ElectorMappingSelfActivity.this.alertDialog != null) {
                    ElectorMappingSelfActivity.this.alertDialog.dismiss();
                }
                Logger.e("ElectorMappingTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ElectorMappingSelfActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ElectorMappingSelfActivity.this.getApplicationContext()).setLocaleBool(false);
            ElectorMappingSelfActivity.this.startActivity(new Intent(ElectorMappingSelfActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ElectorMappingSelfActivity.this.alertDialog != null) {
                ElectorMappingSelfActivity.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("restart", false)) {
            recreate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void showDialogColor() {
        new AlertDialog.Builder(this).setTitle("").setView(LayoutInflater.from(this).inflate(R.layout.custom_note_elector_mapping, (ViewGroup) null)).setPositiveButton(getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMappingSelfActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        }).create().show();
    }
}
