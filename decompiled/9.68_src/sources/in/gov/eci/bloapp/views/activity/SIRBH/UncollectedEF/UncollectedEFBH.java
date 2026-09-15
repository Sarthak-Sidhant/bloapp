package in.gov.eci.bloapp.views.activity.SIRBH.UncollectedEF;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityUncollectedEfBhBinding;
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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UncollectedEFBH extends SuperBaseActivity {
    private String acNo;
    UncollectedEFAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    ActivityUncollectedEfBhBinding binding;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    UserClient service;
    private String state;
    private String token;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    ArrayList<UncollectedEFModel> pendingList = new ArrayList<>();
    ArrayList<UncollectedEFModel> searchList = new ArrayList<>();
    private final String TAG = "UncollectedEFTAG";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUncollectedEfBhBinding activityUncollectedEfBhBindingInflate = ActivityUncollectedEfBhBinding.inflate(getLayoutInflater());
        this.binding = activityUncollectedEfBhBindingInflate;
        setContentView(activityUncollectedEfBhBindingInflate.getRoot());
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
        this.adapter = new UncollectedEFAdapter(this.searchList, this);
        this.binding.recyclerView.setAdapter(this.adapter);
        getAllPendingList();
        this.searchList.clear();
        this.searchList.addAll(this.pendingList);
        this.adapter.notifyDataSetChanged();
        this.binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectedEF.UncollectedEFBH.1
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            public boolean onQueryTextChange(String newText) {
                UncollectedEFBH.this.searchList(newText);
                return true;
            }
        });
        this.SESSION = getString(R.string.sessionMsg);
        initClickListener();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectedEF.UncollectedEFBH$$ExternalSyntheticLambda0
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
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("acNo", this.acNo);
        map2.put("partNo", this.partNo);
        map2.put("stCode", this.state);
        Call<JsonObject> uncollectedEfList = this.service.getUncollectedEfList(map, map2);
        this.alertDialog.show();
        uncollectedEfList.enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.UncollectedEF.UncollectedEFBH$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.UncollectedEF.UncollectedEFBH] */
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
            Logger.d("UNEFPayloadRespose", response.code() + "" + response.body());
            try {
                if (response.isSuccessful() && response.body() != null) {
                    JSONArray jSONArray = new JSONArray(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        UncollectedEFBH.this.pendingList.add(new UncollectedEFModel(jSONObject.optString("electorName", null), jSONObject.optString("epicNo", null), jSONObject.optString("partSerialNo", null), jSONObject.optString("uncollectableReason", null), jSONObject.optString("acNo", null), jSONObject.optString("partNo", null), jSONObject.optString("enrolledEpicNo", null)));
                    }
                    UncollectedEFBH.this.searchList.addAll(UncollectedEFBH.this.pendingList);
                    UncollectedEFBH.this.binding.recyclerView.setAdapter(UncollectedEFBH.this.adapter);
                    UncollectedEFBH.this.alertDialog.dismiss();
                    return;
                }
                if (response.code() == 400 || response.code() == 401) {
                    if (UncollectedEFBH.this.alertDialog != null) {
                        UncollectedEFBH.this.alertDialog.dismiss();
                    }
                    CommomUtility commomUtility = UncollectedEFBH.this.commomUtility;
                    ?? r13 = UncollectedEFBH.this;
                    commomUtility.showMessageOK(r13, r13.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectedEF.UncollectedEFBH$2$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                        }
                    });
                    return;
                }
                try {
                    if (UncollectedEFBH.this.alertDialog != null) {
                        UncollectedEFBH.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectedEFTAG", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException e) {
                    if (UncollectedEFBH.this.alertDialog != null) {
                        UncollectedEFBH.this.alertDialog.dismiss();
                    }
                    Logger.e("UncollectedEFTAG", e.getMessage());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(UncollectedEFBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(UncollectedEFBH.this.getApplicationContext()).setLocaleBool(false);
            UncollectedEFBH.this.startActivity(new Intent(UncollectedEFBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (UncollectedEFBH.this.alertDialog != null) {
                UncollectedEFBH.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectorsBH", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchList(String query) {
        this.searchList.clear();
        for (UncollectedEFModel uncollectedEFModel : this.pendingList) {
            try {
                if (uncollectedEFModel.getEpicNo().toLowerCase().contains(query.toLowerCase())) {
                    this.searchList.add(uncollectedEFModel);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Logger.d("search", "queryResult count" + this.searchList.size());
        this.adapter.notifyDataSetChanged();
    }
}
