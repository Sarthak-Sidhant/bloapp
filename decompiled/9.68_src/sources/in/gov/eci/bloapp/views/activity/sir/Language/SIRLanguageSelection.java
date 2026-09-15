package in.gov.eci.bloapp.views.activity.sir.Language;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloActivitySirLanguageSelectionBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes;
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
public class SIRLanguageSelection extends SuperBaseActivity {
    public static final String ALERT = "ALERT";
    private static final String TAG = "SIRLanguageSelection";
    AlertDialog alertDialog;
    BloActivitySirLanguageSelectionBinding binding;
    ArrayList<String> listOfLangName;
    Utils utils;
    private String[] langOptions = {"English", "Hindi"};
    String SIRlangCLoad = Constants.COUNTRYNAME2_LANG;
    String langName = "";
    String langName2 = "";
    String token = "";
    String stateCode = "";
    ArrayList<String> grandParentNameSpinnerVal = new ArrayList<>();
    ArrayList<String> grandParentCodeSpinnerVal = new ArrayList<>();
    String SESSION = "";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = BloActivitySirLanguageSelectionBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        String stateCode = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.stateCode = stateCode;
        this.stateCode = stateCode.toUpperCase();
        this.utils = new Utils();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.backBtnIv.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$onCreate$0(view, motionEvent);
            }
        });
        this.binding.textView5.setText("v" + new CommomUtility().appversion);
        this.binding.submit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.singleSelect.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection$$ExternalSyntheticLambda2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$onCreate$2(adapterView, view, i, j);
            }
        });
        if (TextUtils.isEmpty(SharedPref.getInstance(this).getUserRole()) || !SharedPref.getInstance(getApplicationContext()).getUserRole().equalsIgnoreCase("blos")) {
            getGrandParentDropdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean lambda$onCreate$0(View view, MotionEvent motionEvent) {
        SharedPref.getInstance(this).setSIRLangCode(Constants.COUNTRYNAME2_LANG);
        SharedPref.getInstance(this).getSIRLangCode();
        if (motionEvent.getAction() != 0) {
            return false;
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        if (validateLanguage()) {
            startActivity(new Intent((Context) this, (Class<?>) FormTypes.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(AdapterView adapterView, View view, int i, long j) {
        if (adapterView.getItemAtPosition(i).toString().equals("Hindi")) {
            this.SIRlangCLoad = "hi";
        } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("Marathi")) {
            this.SIRlangCLoad = "mr";
        } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("Assamese")) {
            this.SIRlangCLoad = "as";
        } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("Bengali")) {
            this.SIRlangCLoad = "bn";
        } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("Tamil")) {
            this.SIRlangCLoad = "ta";
        } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("Mizoram")) {
            this.SIRlangCLoad = "lus";
        } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("Konkani")) {
            this.SIRlangCLoad = "kok";
        } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("Malayalam")) {
            this.SIRlangCLoad = "ml";
        } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("Telugu")) {
            this.SIRlangCLoad = "te";
        } else if (adapterView.getItemAtPosition(i).toString().equalsIgnoreCase("Punjabi")) {
            this.SIRlangCLoad = "pa";
        } else {
            this.SIRlangCLoad = Constants.COUNTRYNAME2_LANG;
        }
        Log.d("SIRlangCLoad", this.SIRlangCLoad);
        SharedPref.getInstance(this).setSIRLangCode(this.SIRlangCLoad);
        Log.d("default Lang Bas sir", SharedPref.getInstance(this).getSIRLangCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStart() {
        super.onStart();
        this.langName = SharedPref.getInstance(getApplicationContext()).getLanguageName();
        this.langName2 = SharedPref.getInstance(getApplicationContext()).getLanguageName2();
        ArrayList<String> arrayList = new ArrayList<>();
        this.listOfLangName = arrayList;
        arrayList.add("English");
        String str = this.langName;
        if (str != null) {
            this.listOfLangName.add(str);
        }
        String str2 = this.langName2;
        if (str2 != null && !str2.isEmpty()) {
            this.listOfLangName.add(this.langName2);
        }
        this.binding.singleSelect.setAdapter(new ArrayAdapter((Context) this, android.R.layout.simple_spinner_dropdown_item, (List) this.listOfLangName));
    }

    protected void onResume() {
        super.onResume();
        this.binding.singleSelect.setText("");
        this.binding.singleSelect.clearFocus();
    }

    private boolean validateLanguage() {
        if (!this.binding.singleSelect.getText().toString().isEmpty()) {
            return true;
        }
        showdialog(getString(R.string.alertMsg), getString(R.string.please_select_atleast_one_language));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog(String title, String msg) {
        new android.app.AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getGrandParentDropdown() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", "master");
        map.put("currentRole", "blo");
        map.put("atkn_bnd", SharedPref.getInstance(this).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(this).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getGrandParentList(map).enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection] */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection] */
        /* JADX WARN: Type inference failed for: r8v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection] */
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
            if (response.code() == 200) {
                if (SIRLanguageSelection.this.alertDialog != null) {
                    SIRLanguageSelection.this.alertDialog.dismiss();
                }
                JsonObject jsonObject = (JsonObject) response.body();
                if (jsonObject != null) {
                    SIRLanguageSelection.this.grandParentCodeSpinnerVal.clear();
                    SIRLanguageSelection.this.grandParentNameSpinnerVal.clear();
                    SIRLanguageSelection.this.grandParentNameSpinnerVal.add("Please select Relation Type");
                    SIRLanguageSelection.this.grandParentCodeSpinnerVal.add("");
                    for (String str : jsonObject.keySet()) {
                        String asString = jsonObject.get(str).getAsString();
                        SIRLanguageSelection.this.grandParentNameSpinnerVal.add(str);
                        SIRLanguageSelection.this.grandParentCodeSpinnerVal.add(asString);
                        System.out.println("Key: " + str + ", Value: " + asString);
                    }
                    SharedPref.getInstance(SIRLanguageSelection.this).saveGrandParentName(SIRLanguageSelection.this.grandParentNameSpinnerVal, Constants.GRANDPARENT_MAPPING_LIST_NAME);
                    SharedPref.getInstance(SIRLanguageSelection.this).savegrandParentCode(SIRLanguageSelection.this.grandParentCodeSpinnerVal, Constants.GRANDPARENT_MAPPING_LIST_CODE);
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (SIRLanguageSelection.this.alertDialog != null) {
                    SIRLanguageSelection.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = new CommomUtility();
                    ?? r8 = SIRLanguageSelection.this;
                    commomUtility.showMessageOK(r8, r8.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection$1$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e(SIRLanguageSelection.TAG, e.toString());
                    return;
                }
            }
            try {
                if (SIRLanguageSelection.this.alertDialog != null) {
                    SIRLanguageSelection.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                Utils utils = SIRLanguageSelection.this.utils;
                ?? r4 = SIRLanguageSelection.this;
                utils.infoDialog(r4, r4.getResources().getString(R.string.alertMsg), strOptString);
                Logger.e(SIRLanguageSelection.TAG, jSONObject.optString("message"));
            } catch (IOException | JSONException e2) {
                if (SIRLanguageSelection.this.alertDialog != null) {
                    SIRLanguageSelection.this.alertDialog.dismiss();
                }
                Utils utils2 = SIRLanguageSelection.this.utils;
                ?? r1 = SIRLanguageSelection.this;
                utils2.infoDialog(r1, r1.getResources().getString(R.string.alertMsg), SIRLanguageSelection.this.getResources().getString(R.string.something_went_wrong));
                Logger.e(SIRLanguageSelection.TAG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SIRLanguageSelection.this.getApplicationContext()).clear();
            SharedPref.getInstance(SIRLanguageSelection.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SIRLanguageSelection.this.getApplicationContext()).setLocaleBool(false);
            SIRLanguageSelection.this.startActivity(new Intent(SIRLanguageSelection.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection] */
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
        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (SIRLanguageSelection.this.alertDialog != null) {
                SIRLanguageSelection.this.alertDialog.dismiss();
            }
            Utils utils = SIRLanguageSelection.this.utils;
            ?? r0 = SIRLanguageSelection.this;
            utils.infoDialog(r0, r0.getResources().getString(R.string.alertMsg), SIRLanguageSelection.this.getResources().getString(R.string.something_went_wrong));
            Logger.d(SIRLanguageSelection.TAG, "OnFailure" + t.getMessage());
        }
    }
}
