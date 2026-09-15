package in.gov.eci.bloapp.views.activity.newsir.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.LazyLoadable;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.SharedViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment;
import in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment;
import in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingModel;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingRoot;
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
public class EFTabActivity extends AppCompatActivity {
    int ac;
    private String acNo;
    int age;
    AlertDialog alertDialog;
    private String atkband;
    ImageView back_btn_iv;
    List<MappingModel> blomapped;
    String dob;
    String electorname;
    Long epicId;
    String epicNumber;
    String from;
    String gender;
    String listState;
    MappingRoot mappingModel;
    int part;
    private String partNo;
    private String refreshToken;
    String relationType;
    String relativeFullName;
    private String rtkband;
    String serial;
    SharedViewModel sharedViewModel;
    private String state;
    List<MappingModel> systemMapped;
    TabLayout tabLayout;
    TextView textView5;
    private String token;
    ViewPager2 viewPager;
    String SESSION = "";
    Fragment[] fragments = {new BLOMappedFragment(), new SystemMappedFragment(), new SearchFragment()};
    Fragment[] fragmentssamemap = {new SystemMappedFragment(), new SearchFragment()};
    CommomUtility commomUtility = new CommomUtility();
    boolean isSame = false;

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tab_ef);
        this.SESSION = getString(R.string.sessionMsg);
        this.viewPager = findViewById(R.id.viewPager);
        this.tabLayout = findViewById(R.id.tabLayout);
        this.back_btn_iv = (ImageView) findViewById(R.id.back_btn_iv);
        this.textView5 = (TextView) findViewById(R.id.textView5);
        this.sharedViewModel = (SharedViewModel) new ViewModelProvider(this).get(SharedViewModel.class);
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
        this.blomapped = new ArrayList();
        this.systemMapped = new ArrayList();
        getIntentValue();
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EFTabActivity.this.onBackPressed();
            }
        });
        this.textView5.setText("v" + this.commomUtility.appversion);
    }

    private void getIntentValue() {
        String str;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.epicNumber = extras.getString("epic");
            this.epicId = Long.valueOf(extras.getLong("epicId"));
            this.serial = extras.getString("psl");
            this.electorname = extras.getString("electorname");
            this.dob = extras.getString("dob");
            this.listState = extras.getString("state");
            this.age = extras.getInt("age");
            this.gender = extras.getString("gender");
            this.relativeFullName = extras.getString("relativefullname");
            this.relationType = extras.getString("relatiiontype");
            this.gender = extras.getString("gender");
            this.ac = extras.getInt("ac");
            this.part = extras.getInt("part");
            this.from = extras.getString("from");
            if (TextUtils.isEmpty(this.relationType)) {
                str = "";
            } else if (this.relationType.equals("GMTH")) {
                str = "Grand Mother";
            } else if (this.relationType.equals("GFTH")) {
                str = "Grand Father";
            } else if (this.relationType.equals("MTHR")) {
                str = "Mother";
            } else if (this.relationType.equals("FTHR") || this.relationType.equals("F")) {
                str = "Father";
            } else if (this.relationType.equals("HSBN") || this.relationType.equals("H")) {
                str = "Husband";
            } else if (this.relationType.equals("OTHR") || this.relationType.equals("O")) {
                str = "Other";
            } else {
                str = this.relationType;
            }
            this.sharedViewModel.setEpicNumber(this.epicNumber);
            this.sharedViewModel.setEpicId(this.epicId);
            this.sharedViewModel.setSerial(this.serial);
            this.sharedViewModel.setElectorname(this.electorname);
            this.sharedViewModel.setDob(this.dob);
            this.sharedViewModel.setRelativeName(this.relativeFullName);
            this.sharedViewModel.setRelationType(str);
            this.sharedViewModel.setAge(this.age);
            this.sharedViewModel.setGender(this.gender);
            this.sharedViewModel.setState(this.listState);
            this.sharedViewModel.setAcno(String.valueOf(this.ac));
            this.sharedViewModel.setPartno(String.valueOf(this.part));
            this.sharedViewModel.setFrom(this.from);
        }
        getMappingDetails();
    }

    public void setupViewPager() {
        if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty() && this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().isEmpty()) {
            this.viewPager.setAdapter(new FragmentStateAdapter(this) { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity.2
                public int getItemCount() {
                    return EFTabActivity.this.fragmentssamemap.length;
                }

                public Fragment createFragment(int position) {
                    return EFTabActivity.this.fragmentssamemap[position];
                }
            });
            final String[] strArr = {getString(R.string.system_suggested), getString(R.string.search)};
            new TabLayoutMediator(this.tabLayout, this.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity$$ExternalSyntheticLambda0
                public final void onConfigureTab(TabLayout.Tab tab, int i) {
                    tab.setText(strArr[i]);
                }
            }).attach();
            this.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity.3
                public void onPageSelected(int position) {
                    if (EFTabActivity.this.fragmentssamemap[position] instanceof LazyLoadable) {
                        EFTabActivity.this.fragmentssamemap[position].onVisible(EFTabActivity.this);
                    }
                }
            });
            return;
        }
        this.viewPager.setAdapter(new FragmentStateAdapter(this) { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity.4
            public int getItemCount() {
                return EFTabActivity.this.fragments.length;
            }

            public Fragment createFragment(int position) {
                return EFTabActivity.this.fragments[position];
            }
        });
        final String[] strArr2 = {getString(R.string.blo_mapped), getString(R.string.system_suggested), getString(R.string.search)};
        new TabLayoutMediator(this.tabLayout, this.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity$$ExternalSyntheticLambda1
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                tab.setText(strArr2[i]);
            }
        }).attach();
        this.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity.5
            public void onPageSelected(int position) {
                if (EFTabActivity.this.fragments[position] instanceof LazyLoadable) {
                    EFTabActivity.this.fragments[position].onVisible(EFTabActivity.this);
                }
            }
        });
    }

    public void getMappingDetails() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("epicNumber", this.epicNumber);
        map2.put("applicantName", this.electorname);
        map2.put("relativeName", this.relativeFullName);
        map2.put("relationType", this.relationType);
        map2.put("stateCd", this.state);
        map2.put("age", Integer.valueOf(this.age));
        map2.put("gender", this.gender);
        Call<MappingRoot> mappingdetails = ((UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class)).getMappingdetails(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        mappingdetails.enqueue(new AnonymousClass6());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<MappingRoot> {
        AnonymousClass6() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity] */
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
        public void onResponse(Call<MappingRoot> call, Response<MappingRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    EFTabActivity.this.mappingModel = (MappingRoot) response.body();
                    EFTabActivity.this.sharedViewModel.setData(EFTabActivity.this.mappingModel);
                    EFTabActivity.this.setupViewPager();
                } catch (Exception unused) {
                }
                EFTabActivity.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (EFTabActivity.this.alertDialog != null) {
                    EFTabActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = EFTabActivity.this.commomUtility;
                ?? r4 = EFTabActivity.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (EFTabActivity.this.alertDialog != null) {
                    EFTabActivity.this.alertDialog.dismiss();
                }
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                Toast.makeText((Context) EFTabActivity.this, (CharSequence) strOptString, 1).show();
                Logger.e("TAG", strOptString);
                if (EFTabActivity.this.alertDialog != null) {
                    EFTabActivity.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (EFTabActivity.this.alertDialog != null) {
                    EFTabActivity.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(EFTabActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(EFTabActivity.this.getApplicationContext()).setLocaleBool(false);
            EFTabActivity.this.startActivity(new Intent(EFTabActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<MappingRoot> call, Throwable t) {
            if (EFTabActivity.this.alertDialog != null) {
                EFTabActivity.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }
}
