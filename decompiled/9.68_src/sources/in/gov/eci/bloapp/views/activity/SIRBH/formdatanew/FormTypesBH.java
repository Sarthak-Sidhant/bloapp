package in.gov.eci.bloapp.views.activity.SIRBH.formdatanew;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityFormTypesBhBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.SIRBH.RollBAckNewFormsBH;
import in.gov.eci.bloapp.views.activity.SIRBH.RollBackFromAEROBH;
import in.gov.eci.bloapp.views.activity.SIRBH.ViewFormByAEROListBH;
import in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH;
import in.gov.eci.bloapp.views.activity.SIRBH.pendingElectorsBH;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FormTypesBH extends SuperBaseActivity {
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    ActivityFormTypesBhBinding binding;
    String electorName;
    String partNo;
    String partNoS;
    private String refreshToken;
    private String rtkband;
    String state;
    private String token;
    CommomUtility commomUtility = new CommomUtility();
    ArrayList<String> List8docName = new ArrayList<>();
    ArrayList<String> List8docCode = new ArrayList<>();
    Gson gson = new GsonBuilder().setLenient().create();
    String selectDocumentType = "";
    String selectRelationType = "";
    String SESSION = "";
    ArrayList<String> relationNameSpinnerVal = new ArrayList<>();
    ArrayList<String> relationCodeSpinnerVal = new ArrayList<>();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFormTypesBhBinding activityFormTypesBhBindingInflate = ActivityFormTypesBhBinding.inflate(getLayoutInflater());
        this.binding = activityFormTypesBhBindingInflate;
        setContentView(activityFormTypesBhBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.selectDocumentType = getString(R.string.selectDocumentMsg);
        this.selectRelationType = getString(R.string.selectRelationMsg);
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        if (SharedPref.getInstance(this).getList8Name(Constants.LIST8_NAME).isEmpty() || SharedPref.getInstance(this).getRelativeListName(Constants.RELATIVE_LIST_NAME).isEmpty() || SharedPref.getInstance(this).getList8Code(Constants.LIST8_CODE).isEmpty() || SharedPref.getInstance(this).getRelativeListCode(Constants.RELATIVE_LIST_CODE).isEmpty()) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            getList1("LIST-8");
        }
        this.binding.pendingElectorTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.enumerationForm.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.filledForm.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.filledBLOTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.rollBackTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.uncollectableEFLL.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.viewFormByAero.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.backBtnIv.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$onCreate$7(view, motionEvent);
            }
        });
        this.binding.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FormTypesBH.this.callSirPageCounts();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent((Context) this, (Class<?>) pendingElectorsBH.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        startActivity(new Intent((Context) this, (Class<?>) specialRevisionActivityBH.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        startActivity(new Intent((Context) this, (Class<?>) FormDataNewBH.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        startActivity(new Intent((Context) this, (Class<?>) FormDataForBloModificationListBH.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        startActivity(new Intent((Context) this, (Class<?>) RollBackFromAEROBH.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        startActivity(new Intent((Context) this, (Class<?>) RollBAckNewFormsBH.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        startActivity(new Intent((Context) this, (Class<?>) ViewFormByAEROListBH.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean lambda$onCreate$7(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void showCountDialog(String documentFlagN, String totalElectors, String documentFlagY, String documentFlagD) {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.custom_sir_form_type_page_count, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.txtFullDocumentCount);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.txtPartialDocumentCount);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.txtNoDocumentCount);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.txtTotalElectarCount);
        if (documentFlagY != null) {
            textView.setText(getString(R.string.custom_modal_note3) + documentFlagY);
        } else {
            textView.setText(getString(R.string.custom_modal_note3));
        }
        if (documentFlagN != null) {
            textView3.setText(getString(R.string.custom_modal_note5) + documentFlagN);
        } else {
            textView3.setText(getString(R.string.custom_modal_note5));
        }
        if (documentFlagD != null) {
            textView2.setText(getString(R.string.custom_modal_note4) + documentFlagD);
        } else {
            textView2.setText(getString(R.string.custom_modal_note4));
        }
        if (totalElectors != null) {
            textView4.setText(getString(R.string.total_elector_count) + Integer.parseInt(totalElectors));
        } else {
            textView4.setText(getString(R.string.total_elector_count));
        }
        new AlertDialog.Builder(this).setTitle("").setView(viewInflate).setPositiveButton(getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        }).create().show();
    }

    void callSirPageCounts() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", this.state);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        this.alertDialog.show();
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getSirPageTotalCount(this.state, Integer.parseInt(this.asmblyNO), Integer.parseInt(this.partNo), map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH.3
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    FormTypesBH.this.alertDialog.dismiss();
                    try {
                        JSONObject jSONObject = new JSONObject(FormTypesBH.this.gson.toJson(((JsonObject) response.body()).get("payload")));
                        String strOptString = jSONObject.optString("documentFlagN", null);
                        String strOptString2 = jSONObject.optString("totalElectors", null);
                        String strOptString3 = jSONObject.optString("documentFlagY", null);
                        String strOptString4 = jSONObject.optString("documentFlagD", null);
                        FormTypesBH.this.alertDialog.dismiss();
                        FormTypesBH.this.showCountDialog(strOptString, strOptString2, strOptString3, strOptString4);
                        return;
                    } catch (Exception e) {
                        Logger.d("FormTypes", e.toString());
                        return;
                    }
                }
                if (response.code() == 404) {
                    FormTypesBH.this.alertDialog.dismiss();
                } else {
                    FormTypesBH.this.alertDialog.dismiss();
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                FormTypesBH.this.alertDialog.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getList1(String list) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", this.state);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("lists", list);
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getSpecialRevisionList(map, map2).enqueue(new AnonymousClass4(list));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        final /* synthetic */ String val$list;

        AnonymousClass4(final String val$list) {
            this.val$list = val$list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v8, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH] */
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
                JsonObject jsonObject = (JsonObject) response.body();
                if (jsonObject != null) {
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    int size = asJsonArray.size();
                    FormTypesBH.this.List8docName.clear();
                    FormTypesBH.this.List8docCode.clear();
                    FormTypesBH.this.List8docName.add(FormTypesBH.this.selectDocumentType);
                    FormTypesBH.this.List8docCode.add("");
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = FormTypesBH.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        FormTypesBH.this.List8docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        FormTypesBH.this.List8docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    }
                    SharedPref.getInstance(FormTypesBH.this).saveList8Name(FormTypesBH.this.List8docName, Constants.LIST8_NAME);
                    SharedPref.getInstance(FormTypesBH.this).saveList8Code(FormTypesBH.this.List8docCode, Constants.LIST8_CODE);
                    FormTypesBH.this.getRelationTypeDropdown();
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (FormTypesBH.this.alertDialog != null) {
                    FormTypesBH.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = FormTypesBH.this.commomUtility;
                    ?? r8 = FormTypesBH.this;
                    String str = ((FormTypesBH) r8).refreshToken;
                    final String str2 = this.val$list;
                    commomUtility.getRefreshToken(r8, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$4$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i2, str3, str4);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e("", e.toString());
                    return;
                }
            }
            try {
                if (FormTypesBH.this.alertDialog != null) {
                    FormTypesBH.this.alertDialog.dismiss();
                }
                Logger.e("", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (FormTypesBH.this.alertDialog != null) {
                    FormTypesBH.this.alertDialog.dismiss();
                }
                Logger.e("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            FormTypesBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormTypesBH.this.commomUtility;
                ?? r5 = FormTypesBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormTypesBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(FormTypesBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(FormTypesBH.this.getApplicationContext()).setToken("Bearer " + str2);
                FormTypesBH.this.getList1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormTypesBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormTypesBH.this.getApplicationContext()).setLocaleBool(false);
            FormTypesBH.this.startActivity(new Intent(FormTypesBH.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (FormTypesBH.this.alertDialog != null) {
                FormTypesBH.this.alertDialog.dismiss();
            }
            Logger.d("", "OnFailure" + t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getRelationTypeDropdown() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", "master");
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getRelationDropdown(map).enqueue(new AnonymousClass5());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        AnonymousClass5() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v8, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH] */
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
                if (FormTypesBH.this.alertDialog != null) {
                    FormTypesBH.this.alertDialog.dismiss();
                }
                JsonObject jsonObject = (JsonObject) response.body();
                if (jsonObject != null) {
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    FormTypesBH.this.relationNameSpinnerVal.clear();
                    FormTypesBH.this.relationCodeSpinnerVal.clear();
                    FormTypesBH.this.relationNameSpinnerVal.add(FormTypesBH.this.selectRelationType);
                    FormTypesBH.this.relationCodeSpinnerVal.add("");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = FormTypesBH.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        FormTypesBH.this.relationNameSpinnerVal.add(String.valueOf(asJsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        FormTypesBH.this.relationCodeSpinnerVal.add(String.valueOf(asJsonObject.get("relationCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    }
                    SharedPref.getInstance(FormTypesBH.this).saveRelativeListName(FormTypesBH.this.relationNameSpinnerVal, Constants.RELATIVE_LIST_NAME);
                    SharedPref.getInstance(FormTypesBH.this).saveRelativeListCode(FormTypesBH.this.relationCodeSpinnerVal, Constants.RELATIVE_LIST_CODE);
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (FormTypesBH.this.alertDialog != null) {
                    FormTypesBH.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = FormTypesBH.this.commomUtility;
                    ?? r8 = FormTypesBH.this;
                    commomUtility.getRefreshToken(r8, ((FormTypesBH) r8).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$5$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i2, str, str2);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e("", e.toString());
                    return;
                }
            }
            try {
                if (FormTypesBH.this.alertDialog != null) {
                    FormTypesBH.this.alertDialog.dismiss();
                }
                Logger.e("", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (FormTypesBH.this.alertDialog != null) {
                    FormTypesBH.this.alertDialog.dismiss();
                }
                Logger.e("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH] */
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
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            FormTypesBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormTypesBH.this.commomUtility;
                ?? r5 = FormTypesBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH$5$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormTypesBH.this.token = "Bearer " + str;
                SharedPref.getInstance(FormTypesBH.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(FormTypesBH.this.getApplicationContext()).setToken("Bearer " + str);
                FormTypesBH.this.getRelationTypeDropdown();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormTypesBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormTypesBH.this.getApplicationContext()).setLocaleBool(false);
            FormTypesBH.this.startActivity(new Intent(FormTypesBH.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (FormTypesBH.this.alertDialog != null) {
                FormTypesBH.this.alertDialog.dismiss();
            }
            Logger.d("", "OnFailure" + t.getMessage());
        }
    }
}
