package in.gov.eci.bloapp.views.fragments.voterforms.migration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloActivityPreviewBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.PreviewViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.newsir.model.DeclarationFormPayload;
import in.gov.eci.bloapp.views.fragments.FormsResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class PreviewActivity extends Hilt_PreviewActivity {
    private static final String SESSION_TOKEN_EXPIRED_PLEASE_LOGIN = "Session token expired please Login";
    private String addresscor;
    private String addresscorreg;
    private String addresssor;
    private String addresssorreg;
    private AlertDialog alertDialog;
    private String appdate;
    BloActivityPreviewBinding binding;
    String blostatecode;
    Retrofit.Builder builder;
    String category;
    private String coedistrict;
    private String cordob;
    private String corgender;
    private String corgendereg;
    private String corname;
    private String cornamereg;
    private String correlname;
    private String correlnamereg;
    private String draftcreatedon;
    private String draftname;
    String epicId;
    private String epicNumber;
    String flagid;
    DeclarationFormPayload formverificationPayload;
    Boolean isdeclarationEnabled;
    private String location;
    private String msg;
    private String orgaddress;
    private String orgaddressreg;
    private String orgdob;
    private String orggender;
    private String orggenderreg;
    private String orghouseno;
    private String orghousenoreg;
    private String orgrelatname;
    private String orgrelatnamereg;
    private String orgstreet;
    private String ornamereg;
    private String referenceNumber;
    private String relationType;
    Retrofit retrofit;
    private String sectionNumber;
    private String shiftingImage;
    private String sordistrict;
    String token;
    UserClient userClient;
    PreviewViewModel viewModel;
    CommomUtility commonUtilClass = new CommomUtility();
    Serializable submitFinalMap = new HashMap();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public PreviewActivity() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        Retrofit retrofitBuild = builderClient.build();
        this.retrofit = retrofitBuild;
        this.userClient = (UserClient) retrofitBuild.create(UserClient.class);
        this.shiftingImage = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blo_activity_preview);
        this.binding = BloActivityPreviewBinding.inflate(getLayoutInflater());
        this.viewModel = (PreviewViewModel) new ViewModelProvider(this).get(PreviewViewModel.class);
        this.blostatecode = SharedPref.getInstance(this).getStateCode();
        this.token = SharedPref.getInstance(this).getToken();
        View viewInflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.formverificationPayload = new DeclarationFormPayload();
        Bundle bundleExtra = getIntent().getBundleExtra("bundle");
        this.binding.hideit.setVisibility(0);
        if (bundleExtra != null) {
            this.submitFinalMap = bundleExtra.getSerializable("FinalMap");
            this.epicNumber = bundleExtra.getString("Epicnumber");
            this.referenceNumber = bundleExtra.getString("Referenceno");
            this.draftname = bundleExtra.getString("Draftname");
            this.draftcreatedon = bundleExtra.getString("Draftcreatedon");
            this.location = bundleExtra.getString(Constants.LOCATION);
            this.ornamereg = bundleExtra.getString("originalnameregional");
            this.corname = bundleExtra.getString("CorrectName");
            this.cornamereg = bundleExtra.getString("CorrectNameRegional");
            this.correlname = bundleExtra.getString("CorrectRelativeName");
            this.correlnamereg = bundleExtra.getString("CorrectRelativeNameRegional");
            this.orgrelatname = bundleExtra.getString("Originalrelativename");
            this.orgrelatnamereg = bundleExtra.getString("Originalrelativenameregional");
            this.orggender = bundleExtra.getString("Originalgender");
            this.orggenderreg = bundleExtra.getString("Originalgenderregional");
            this.corgender = bundleExtra.getString("Correctgender");
            this.corgendereg = bundleExtra.getString("Correctgenderregional");
            this.orgdob = bundleExtra.getString("Originaldob");
            this.cordob = bundleExtra.getString("CorrectDOB");
            this.orgaddress = bundleExtra.getString("Originaladdress");
            this.orgaddressreg = bundleExtra.getString("Originaladdressregional");
            this.addresssor = bundleExtra.getString("CorrectedaddressSOR");
            this.addresssorreg = bundleExtra.getString("CorrectedaddressregionalSOR");
            this.addresscor = bundleExtra.getString("CorrectedaddressCOR");
            this.addresscorreg = bundleExtra.getString("CorrectedaddressregionalCOR");
            this.appdate = bundleExtra.getString("Applicationdate");
            this.relationType = bundleExtra.getString("RelationType");
            this.sordistrict = bundleExtra.getString("SORDistrict");
            this.coedistrict = bundleExtra.getString("COEDistrict");
            this.orgstreet = bundleExtra.getString("orgstreet");
            this.orghouseno = bundleExtra.getString("orghouseno");
            this.orghousenoreg = bundleExtra.getString("orghousenoreg");
            this.sectionNumber = bundleExtra.getString("SectionNumber");
            this.shiftingImage = bundleExtra.getString("shiftingImage");
            this.isdeclarationEnabled = Boolean.valueOf(bundleExtra.getBoolean("isdeclarationEnabled"));
            String string = bundleExtra.getString("flagid");
            this.flagid = string;
            if (!TextUtils.isEmpty(string) && this.flagid.equalsIgnoreCase("selectPhoto")) {
                this.epicId = bundleExtra.getString("epicId");
                this.category = bundleExtra.getString("category");
            }
            getIntent();
            this.formverificationPayload = (DeclarationFormPayload) bundleExtra.getParcelable("declarationForm");
        }
        setContentView(this.binding.getRoot());
        this.binding.viewpager.setAdapter(new ViewStateAdapter(this, this.blostatecode, this.draftname, this.draftcreatedon, this.location, this.epicNumber, this.ornamereg, this.corname, this.cornamereg, this.correlname, this.correlnamereg, this.orgrelatname, this.orgrelatnamereg, this.orggender, this.orggenderreg, this.corgender, this.corgendereg, this.orgdob, this.cordob, this.orgaddress, this.orgaddressreg, this.addresssor, this.addresssorreg, this.addresscor, this.addresscorreg, this.appdate, this.relationType, this.sordistrict, this.coedistrict, this.orgstreet, this.orghouseno, this.orghousenoreg, this.sectionNumber, this.shiftingImage, this.formverificationPayload, this.isdeclarationEnabled));
        this.binding.viewpager.setUserInputEnabled(false);
        this.binding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.previousTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.saveNextTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        new TabLayoutMediator(this.binding.tabs, this.binding.viewpager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$$ExternalSyntheticLambda1
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                PreviewActivity.lambda$onCreate$8(tab, i);
            }
        }).attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        if (this.epicNumber.length() < 10) {
            showdialog("Alert", "Wrong Epic no.");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do You want to Proceed to submit this form ?");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$onCreate$6(dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(DialogInterface dialogInterface, int i) {
        Logger.d("SUBMITTING THIS MAP IN API", String.valueOf(this.submitFinalMap));
        this.commonUtilClass.form8Submit(getApplicationContext(), this.token, SharedPref.getInstance(getApplicationContext()).getAtknBnd(), SharedPref.getInstance(getApplicationContext()).getRtknBnd(), "blo", this.blostatecode, (Map) this.submitFinalMap, new FormsResponse() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$$ExternalSyntheticLambda4
            @Override // in.gov.eci.bloapp.views.fragments.FormsResponse
            public final void onCallback(int i2, String str) {
                this.f$0.lambda$onCreate$5(i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$5(int i, String str) {
        this.msg = str;
        if (i == 200) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(this.msg + " " + this.referenceNumber);
            builder.setCancelable(false);
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onCreate$4(dialogInterface, i2);
                }
            });
            builder.show();
            return;
        }
        showDialog2(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$4(DialogInterface dialogInterface, int i) {
        this.viewModel.DeletedraftData(this.epicNumber, this.referenceNumber, this.draftcreatedon);
        if (!TextUtils.isEmpty(this.flagid) && this.flagid.equalsIgnoreCase("selectPhoto")) {
            submit(dialogInterface);
        } else {
            startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
            dialogInterface.dismiss();
        }
    }

    static /* synthetic */ void lambda$onCreate$8(TabLayout.Tab tab, int i) {
        if (i == 0) {
            tab.setText("FORM");
        } else {
            tab.setText("EPIC");
        }
    }

    public void setCurrentItem(int item, boolean smoothScroll) {
        this.binding.viewpager.setCurrentItem(item, smoothScroll);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog(String title, String msg) {
        new android.app.AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void submit(DialogInterface dialog1) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.blostatecode);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", SharedPref.getInstance(getApplicationContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(getApplicationContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("appname", "BLOAPP");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("state", this.blostatecode);
        map2.put("acNo", SharedPref.getInstance(getApplicationContext()).getAssemblyNumber());
        map2.put("partNo", SharedPref.getInstance(getApplicationContext()).getPartNumber());
        map2.put("epicId", this.epicId);
        map2.put("epicNo", this.epicNumber);
        map2.put("flag", this.category);
        this.blostatecode.toLowerCase();
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).updatePhotoFlagInEnum1(map, map2).enqueue(new AnonymousClass1(dialog1));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        final /* synthetic */ DialogInterface val$dialog1;

        AnonymousClass1(final DialogInterface val$dialog1) {
            this.val$dialog1 = val$dialog1;
        }

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
                if (PreviewActivity.this.alertDialog != null) {
                    PreviewActivity.this.alertDialog.dismiss();
                }
                ((JsonObject) response.body()).get("message").toString();
                PreviewActivity.this.startActivity(new Intent((Context) PreviewActivity.this, (Class<?>) MainActivity.class));
                this.val$dialog1.dismiss();
                return;
            }
            if (response.code() == 401) {
                if (PreviewActivity.this.alertDialog != null) {
                    PreviewActivity.this.alertDialog.dismiss();
                }
                PreviewActivity.this.commomUtility.showMessageOK(PreviewActivity.this, PreviewActivity.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (PreviewActivity.this.alertDialog != null) {
                    PreviewActivity.this.alertDialog.dismiss();
                }
                new JSONObject(response.errorBody().string()).optString("message");
            } catch (IOException | JSONException unused) {
                if (PreviewActivity.this.alertDialog != null) {
                    PreviewActivity.this.alertDialog.dismiss();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PreviewActivity.this).setIsLoggedIn(false);
            SharedPref.getInstance(PreviewActivity.this).setLocaleBool(false);
            PreviewActivity.this.startActivity(new Intent((Context) PreviewActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (PreviewActivity.this.alertDialog != null) {
                PreviewActivity.this.alertDialog.dismiss();
            }
        }
    }
}
