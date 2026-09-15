package in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter;
import in.gov.eci.bloapp.databinding.BloActivityDeletionObjectionTabLayoutBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.MainActivity;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DeletionObjectionTabLayoutActivity extends Hilt_DeletionObjectionTabLayoutActivity {
    String acNo;
    private GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface adapterInterface;
    AlertDialog alertDialog;
    String applicantEpicDetailsArray;
    HashMap<String, Object> applicantMap;
    Bundle bundle;
    String districtCode;
    String epicid;
    private String fromH2h;
    HashMap<String, Object> objecteeMap;
    String partNo;
    private String request;
    String stateCode;
    BloActivityDeletionObjectionTabLayoutBinding tabLayoutBinding;
    private final String[] tabs = {"APPLICANT", "OBJECTEE"};
    String token = "";
    String alert = "Alert";
    String stateString = "state";
    String districtString = "district";
    String assemblyString = "assembly";
    String epicNumberString = "epicNumber";
    String districtCdString = "districtCd";
    String partNumberString = "partNumber";
    String serialNumberString = "serialNumber";
    String dvoterStatusTypeString = "dvoterStatusType";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.tabLayoutBinding = BloActivityDeletionObjectionTabLayoutBinding.inflate(getLayoutInflater());
        Bundle extras = getIntent().getExtras();
        this.bundle = extras;
        if (extras != null) {
            String string = extras.getString("epicId");
            this.epicid = string;
            if (Objects.equals(string, null)) {
                this.epicid = "";
            }
            String string2 = this.bundle.getString("request");
            this.request = string2;
            if (Objects.equals(string2, null)) {
                this.request = "";
            }
            String string3 = this.bundle.getString("fromH2h");
            this.fromH2h = string3;
            if (Objects.equals(string3, null)) {
                this.fromH2h = "";
            }
            this.applicantEpicDetailsArray = this.bundle.getString("applicantEpicDetailsArray");
            System.out.println(this.applicantEpicDetailsArray);
        }
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.token = SharedPref.getInstance(this).getToken();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.districtCode = SharedPref.getInstance(this).getDistrictCode();
        this.acNo = SharedPref.getInstance(this).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(this).getPartNumber();
        this.tabLayoutBinding.textView3.setText("Select Applicant &amp; Objectee  v" + new CommomUtility().appversion);
        HashMap map = new HashMap();
        map.put(this.stateString, "");
        map.put(this.districtString, "");
        map.put(this.assemblyString, "");
        map.put("assemblyNumber", "");
        map.put(this.epicNumberString, "");
        map.put(Constants.FIRST_NAME, "");
        map.put("surname", "");
        map.put(this.serialNumberString, "");
        map.put(this.partNumberString, "");
        map.put(this.districtCdString, "");
        map.put(this.dvoterStatusTypeString, "");
        map.put("processMasterId", "");
        map.put("underJo", "");
        String json = new Gson().toJson(map);
        SharedPref.getInstance(this).setApplicantEpicDetails(json);
        SharedPref.getInstance(this).setObjecteeEpicDetails(json);
        setContentView((View) this.tabLayoutBinding.getRoot());
        setUpViewPager();
        initViewPagerAndTagLayout();
        this.tabLayoutBinding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.tabLayoutBinding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.tabLayoutBinding.nextBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
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
        Intent intent = new Intent((Context) this, (Class<?>) MainActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v0, types: [in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity$1] */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        Gson gson = new Gson();
        String applicantEpicDeatils = SharedPref.getInstance(getApplicationContext()).getApplicantEpicDeatils();
        String objecteeEpicDetails = SharedPref.getInstance(getApplicationContext()).getObjecteeEpicDetails();
        Type type = new TypeToken<HashMap<String, Object>>() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity.1
        }.getType();
        this.applicantMap = (HashMap) gson.fromJson(applicantEpicDeatils, type);
        this.objecteeMap = (HashMap) gson.fromJson(objecteeEpicDetails, type);
        if (isApplicantValidated()) {
            this.alertDialog.show();
            Bundle bundle = new Bundle();
            bundle.putString("fromH2h", this.fromH2h);
            bundle.putString("request", this.request);
            bundle.putString("voterId", String.valueOf(this.applicantMap.get(this.epicNumberString)));
            String str = this.stateString;
            bundle.putString(str, String.valueOf(this.applicantMap.get(str)));
            String str2 = this.districtString;
            bundle.putString(str2, String.valueOf(this.applicantMap.get(str2)));
            String str3 = this.assemblyString;
            bundle.putString(str3, String.valueOf(this.applicantMap.get(str3)));
            bundle.putString("assemblyNo", String.valueOf(this.applicantMap.get("assemblyNumber")));
            bundle.putString("partNumberApplicant", String.valueOf(this.applicantMap.get(this.partNumberString)));
            bundle.putString("serialNumberApplicant", String.valueOf(this.applicantMap.get(this.serialNumberString)));
            bundle.putString("firstnamefromdb", String.valueOf(this.objecteeMap.get(Constants.FIRST_NAME)));
            bundle.putString("lastnamefromdb", String.valueOf(this.objecteeMap.get("surname")));
            if (this.request.equals("objection")) {
                bundle.putString("fdreferenceNumber", String.valueOf(this.objecteeMap.get(this.epicNumberString)));
                bundle.putString("objectToInclFormType", String.valueOf(this.objecteeMap.get("processMasterId")));
            } else {
                bundle.putString("epic", String.valueOf(this.objecteeMap.get(this.epicNumberString)));
            }
            bundle.putString("partNumberOfPersonToBeDeleted", String.valueOf(this.objecteeMap.get(this.partNumberString)));
            bundle.putString("serialNumberOfPersonToBeDeleted", String.valueOf(this.objecteeMap.get(this.serialNumberString)));
            bundle.putString("districtCdOfPersonToBeDeleted", String.valueOf(this.objecteeMap.get(this.districtCdString)));
            bundle.putString("applicantEpicDetailsArray", this.applicantEpicDetailsArray);
            DeletionObjectionForm deletionObjectionForm = new DeletionObjectionForm();
            deletionObjectionForm.setArguments(bundle);
            openFragment(deletionObjectionForm, "Deletion Objection From Name RecyclerView");
            this.alertDialog.dismiss();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreate$2();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2() {
        this.tabLayoutBinding.mainLayout.setVisibility(8);
    }

    private void setUpViewPager() {
        this.adapterInterface = new GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity.2
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public int getCount() {
                return 2;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new ApplicantRecyclerViewForm7(DeletionObjectionTabLayoutActivity.this.bundle);
                }
                return new ObjecteeRecylerViewForm7(DeletionObjectionTabLayoutActivity.this.bundle);
            }
        };
    }

    private void initViewPagerAndTagLayout() {
        this.tabLayoutBinding.viewpager.setAdapter(new GenericFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle(), this.adapterInterface));
        new TabLayoutMediator(this.tabLayoutBinding.tabLayout, this.tabLayoutBinding.viewpager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity$$ExternalSyntheticLambda0
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                this.f$0.lambda$initViewPagerAndTagLayout$4(tab, i);
            }
        }).attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViewPagerAndTagLayout$4(TabLayout.Tab tab, int i) {
        tab.setText(this.tabs[i]);
    }

    private boolean isApplicantValidated() {
        if (String.valueOf(this.applicantMap.get(this.epicNumberString)).isEmpty()) {
            showdialog(this.alert, "Please select an Applicant");
            setCurrentItem(0, true);
            return false;
        }
        if (String.valueOf(this.objecteeMap.get(this.epicNumberString)).isEmpty()) {
            showdialog(this.alert, "Please select an Objectee");
            setCurrentItem(1, true);
            return false;
        }
        if (String.valueOf(this.applicantMap.get(this.epicNumberString)).equals(String.valueOf(this.objecteeMap.get(this.epicNumberString)))) {
            showdialog(this.alert, "Applicant's EPIC Number and Objectee's EPIC Number cannot be same. Please select different Electors");
            setCurrentItem(0, true);
            return false;
        }
        if (String.valueOf(this.applicantMap.get(this.dvoterStatusTypeString)).equals("H") || String.valueOf(this.applicantMap.get(this.dvoterStatusTypeString)).equals("Y") || String.valueOf(this.applicantMap.get(this.dvoterStatusTypeString)).equals("1")) {
            showdialog(this.alert, "The Applicant EPIC is already marked as D-Voter hence you can't fill this form");
            setCurrentItem(0, true);
            return false;
        }
        if (String.valueOf(this.objecteeMap.get(this.dvoterStatusTypeString)).equals("H") || String.valueOf(this.objecteeMap.get(this.dvoterStatusTypeString)).equals("Y") || String.valueOf(this.objecteeMap.get(this.dvoterStatusTypeString)).equals("1")) {
            showdialog(this.alert, "The Objectee EPIC is already marked as D-Voter hence you can't fill this form");
            setCurrentItem(1, true);
            return false;
        }
        if (!this.request.equals("objection") && !this.partNo.equals(String.valueOf(this.objecteeMap.get(this.partNumberString)))) {
            showdialog(this.alert, "Objectee doesn't belong to your Part");
            setCurrentItem(1, true);
            return false;
        }
        if (!String.valueOf(this.applicantMap.get("underJo")).equalsIgnoreCase("1") && !String.valueOf(this.objecteeMap.get("underJo")).equalsIgnoreCase("1")) {
            return true;
        }
        showdialog(this.alert, "The applicant is under Adjudication.");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    public void setCurrentItem(int item, boolean smoothScroll) {
        this.tabLayoutBinding.viewpager.setCurrentItem(item, smoothScroll);
    }

    private void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    public void onDestroy() {
        super.onDestroy();
    }
}
