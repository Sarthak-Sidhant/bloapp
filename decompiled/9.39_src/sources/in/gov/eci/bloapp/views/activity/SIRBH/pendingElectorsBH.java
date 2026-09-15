package in.gov.eci.bloapp.views.activity.SIRBH;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.jsonAdapterBH;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityPendingElectorsBhBinding;
import in.gov.eci.bloapp.model.SIR.pendingListModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
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
public class pendingElectorsBH extends SuperBaseActivity {
    private String acNo;
    jsonAdapterBH adapter;
    AlertDialog alertDialog;
    private String atkband;
    ActivityPendingElectorsBhBinding binding;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    UserClient service;
    private String state;
    private String token;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    ArrayList<pendingListModel> pendingList = new ArrayList<>();
    ArrayList<pendingListModel> searchList = new ArrayList<>();
    private final String TAG = "pendingElectorsTAG";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPendingElectorsBhBinding activityPendingElectorsBhBindingInflate = ActivityPendingElectorsBhBinding.inflate(getLayoutInflater());
        this.binding = activityPendingElectorsBhBindingInflate;
        setContentView(activityPendingElectorsBhBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.service = (UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class);
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
        this.adapter = new jsonAdapterBH(this.searchList, this);
        this.binding.recyclerView.setAdapter(this.adapter);
        getAllPendingList();
        this.searchList.clear();
        this.searchList.addAll(this.pendingList);
        this.adapter.notifyDataSetChanged();
        this.binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.pendingElectorsBH.1
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            public boolean onQueryTextChange(String newText) {
                pendingElectorsBH.this.searchList(newText);
                return true;
            }
        });
        initClickListener();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.pendingElectorsBH$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        startActivity(new Intent((Context) this, (Class<?>) FormTypesBH.class));
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
        Call<JsonObject> pendingElectorsList = this.service.getPendingElectorsList(map, map2);
        this.alertDialog.show();
        pendingElectorsList.enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.pendingElectorsBH$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.pendingElectorsBH] */
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
                    int i = 0;
                    int i2 = 0;
                    while (i2 < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        String strOptString = jSONObject.optString("epicNo", "");
                        String strOptString2 = jSONObject.optString("name", null);
                        Long lValueOf = Long.valueOf(jSONObject.optLong("epicId", 0L));
                        int iOptInt = jSONObject.optInt("age", i);
                        String strOptString3 = jSONObject.optString("stateCd", null);
                        String strOptString4 = jSONObject.optString("gender", null);
                        String strOptString5 = jSONObject.optString("dob", "");
                        int iOptInt2 = jSONObject.optInt("acNo");
                        int iOptInt3 = jSONObject.optInt("partNo");
                        int iOptInt4 = jSONObject.optInt("partSerialNo");
                        String strOptString6 = jSONObject.optString("relativeFullName", null);
                        String strOptString7 = jSONObject.optString("relationType", null);
                        String str = TextUtils.isEmpty(strOptString7) ? "" : strOptString7;
                        if (TextUtils.isEmpty(strOptString2)) {
                            strOptString2 = "";
                        }
                        pendingElectorsBH.this.pendingList.add(new pendingListModel(strOptString2, strOptString, String.valueOf(iOptInt4), lValueOf, strOptString5, iOptInt, strOptString3, iOptInt2, iOptInt3, strOptString4, TextUtils.isEmpty(strOptString6) ? "" : strOptString6, str, 0));
                        i2++;
                        i = 0;
                    }
                } catch (JSONException unused) {
                }
                pendingElectorsBH.this.searchList.addAll(pendingElectorsBH.this.pendingList);
                pendingElectorsBH.this.binding.recyclerView.setAdapter(pendingElectorsBH.this.adapter);
                pendingElectorsBH.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (pendingElectorsBH.this.alertDialog != null) {
                    pendingElectorsBH.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = pendingElectorsBH.this.commomUtility;
                ?? r2 = pendingElectorsBH.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.pendingElectorsBH$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i3);
                    }
                });
                return;
            }
            try {
                if (pendingElectorsBH.this.alertDialog != null) {
                    pendingElectorsBH.this.alertDialog.dismiss();
                }
                Logger.e("pendingElectorsTAG", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e) {
                if (pendingElectorsBH.this.alertDialog != null) {
                    pendingElectorsBH.this.alertDialog.dismiss();
                }
                Logger.e("pendingElectorsTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(pendingElectorsBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(pendingElectorsBH.this.getApplicationContext()).setLocaleBool(false);
            pendingElectorsBH.this.startActivity(new Intent(pendingElectorsBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (pendingElectorsBH.this.alertDialog != null) {
                pendingElectorsBH.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectorsBH", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchList(String query) {
        this.searchList.clear();
        for (pendingListModel pendinglistmodel : this.pendingList) {
            try {
                if (pendinglistmodel.getEpicNo().toLowerCase().contains(query.toLowerCase())) {
                    this.searchList.add(pendinglistmodel);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Logger.d("search", "queryResult count" + this.searchList.size());
        this.adapter.notifyDataSetChanged();
    }
}
