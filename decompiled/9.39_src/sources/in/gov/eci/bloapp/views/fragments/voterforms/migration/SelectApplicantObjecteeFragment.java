package in.gov.eci.bloapp.views.fragments.voterforms.migration;

import android.app.Dialog;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloBottomSheetMigrationSecondBinding;
import in.gov.eci.bloapp.databinding.BloFragmentSelectApplicantObjecteeBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SelectApplicantObjecteeFragment extends Fragment {
    private static final String AGE = "age";
    private static final String ALERT = "Alert";
    private static final String APPLICANT_DOESN_T_BELONG_TO_YOUR_Assembly = "Applicant doesn’t belong to your Assembly";
    private static final String APPLICANT_DOESN_T_BELONG_TO_YOUR_PART = "Applicant doesn’t belong to your part";
    private static final String APPLICANT_DOESN_T_BELONG_TO_YOUR_STATE = "Applicant doesn’t belong to your state";
    private static final String APPLICANT_FIRST_NAME = "applicantFirstName";
    private static final String APPLICANT_LAST_NAME = "applicantLastName";
    private static final String APPLICANT_NAME_L_R = "applicantNameL1";
    private static final String ASSEMBLY = "assembly";
    private static final String ASSEMBLY_NUMBER = "assemblyNumber";
    private static final String DISTRICT_CODE = "districtCode";
    private static final String DISTRICT_NAME = "districtName";
    private static final String DOB = "dob";
    private static final String DVOTER_STATUS_TYPE = "dvoterStatusType";
    private static final String EMAIL_ID = "emailId";
    private static final String EPIC_NUMBER = "epicNumber";
    private static final String GENDER = "gender";
    private static final String GENDERL_R = "genderl1";
    private static final String HOUSE_NUMBER = "houseNumber";
    private static final String HOUSE_NUMBER_L_R = "houseNumberL1";
    private static final String LOCALITY_STREET = "localityStreet";
    private static final String MOBILE_NUMBER = "mobileNumber";
    private static final String PART_NUMBER = "partNumber";
    private static final String PART_SERIAL_NUMBER = "PartSerialNumber";
    private static final String RELATIONTYPE = "relationtype";
    private static final String RELATION_NAME = "relationName";
    private static final String RELATION_NAME_L_1 = "relationNameL1";
    private static final String SECTIONERROR = "Section Error - ";
    private static final String SECTION_NAME = "sectionName";
    private static final String SECTIO_NO = "sectioNo";
    private static final String SELECT_SECTION_NO_NAME = "Select Section No. & Name";
    private static final String STATE = "state";
    private static final String STATE_NAME = "stateName";
    private static final String TOWN_VILLAGE = "townVillage";
    private String FlagKey;
    private GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface adapterInterface;
    HashMap<String, Object> applicantMap;
    private String asmblyNO;
    private String asseblytype;
    BloFragmentSelectApplicantObjecteeBinding binding;
    Retrofit.Builder builder;
    private String epicProceedingDetails;
    private String epicdetails;
    private boolean isOtherState;
    private boolean isdeclarationEnabled;
    HashMap<String, Object> objecteeMap;
    private String partNo;
    Retrofit retrofit;
    private String sectionFlag;
    private String sectionNumber;
    private String selectedEntry;
    private String selectedSection;
    private String stateCode;
    private final String[] tabs = {"APPLICANT", "OBJECTEE"};
    private String token = "";
    private String blopartnumber = "";
    private String bloassemcode = "";
    private String appfor = "";
    private final Bundle bundle1 = new Bundle();
    ArrayList<String> sectionNolist = new ArrayList<>();
    CommomUtility commonUtilClass = new CommomUtility();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();

    public SelectApplicantObjecteeFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.sectionFlag = "1";
        this.selectedEntry = "";
        this.isOtherState = false;
        this.isdeclarationEnabled = false;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentSelectApplicantObjecteeBinding.inflate(inflater);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.blopartnumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.bloassemcode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.binding.textView3.setText("Select Applicant or Objectee  v" + new CommomUtility().appversion);
        HashMap map = new HashMap();
        map.put(STATE, "");
        map.put(ASSEMBLY, "");
        map.put(ASSEMBLY_NUMBER, "");
        map.put(EPIC_NUMBER, "");
        map.put(PART_NUMBER, "");
        map.put(DVOTER_STATUS_TYPE, "");
        map.put(PART_SERIAL_NUMBER, "");
        map.put(STATE_NAME, "");
        map.put(DISTRICT_NAME, "");
        map.put(APPLICANT_FIRST_NAME, "");
        map.put(APPLICANT_LAST_NAME, "");
        map.put(MOBILE_NUMBER, "");
        map.put("emailId", "");
        map.put(DISTRICT_CODE, "");
        map.put(GENDER, "");
        map.put(RELATION_NAME, "");
        map.put(RELATION_NAME_L_1, "");
        map.put(GENDERL_R, "");
        map.put(DOB, "");
        map.put(HOUSE_NUMBER, "");
        map.put(LOCALITY_STREET, "");
        map.put(TOWN_VILLAGE, "");
        map.put(HOUSE_NUMBER_L_R, "");
        map.put(APPLICANT_NAME_L_R, "");
        map.put(AGE, "");
        map.put(SECTIO_NO, "");
        map.put(RELATIONTYPE, "");
        map.put("shiftingImage", "");
        map.put("position", "");
        map.put("houseNoRegional", "");
        map.put("underJo", "");
        String json = new Gson().toJson(map);
        SharedPref.getInstance(getContext()).setApplicantEpicDetails(json);
        SharedPref.getInstance(getContext()).setObjecteeEpicDetails(json);
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        try {
            requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment.1
                public void handleOnBackPressed() {
                    if (SelectApplicantObjecteeFragment.this.getFragmentManager().getBackStackEntryCount() != 0) {
                        SelectApplicantObjecteeFragment.this.getFragmentManager().popBackStack();
                    }
                }
            });
        } catch (Exception unused) {
            openFragment(new VoterFormsFragment(), "Voter forms FRAGMENT");
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.epicdetails = arguments.getString("epicDetails");
            this.appfor = arguments.getString("appfor");
            this.epicProceedingDetails = arguments.getString("epicProceedingDetails");
            this.FlagKey = arguments.getString("FlagKey");
        }
        this.bundle1.putString("epicdetails", this.epicdetails);
        this.bundle1.putString("appfor", this.appfor);
        this.bundle1.putString("epicProceedingDetails", this.epicProceedingDetails);
        this.binding.saveNextTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        setUpViewPager();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        if (getFragmentManager().getBackStackEntryCount() != 0) {
            getFragmentManager().popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v0, types: [in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$2] */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        Gson gson = new Gson();
        String applicantEpicDeatils = SharedPref.getInstance(getContext()).getApplicantEpicDeatils();
        String objecteeEpicDetails = SharedPref.getInstance(getContext()).getObjecteeEpicDetails();
        Type type = new TypeToken<HashMap<String, Object>>() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment.2
        }.getType();
        this.applicantMap = (HashMap) gson.fromJson(applicantEpicDeatils, type);
        HashMap<String, Object> map = (HashMap) gson.fromJson(objecteeEpicDetails, type);
        this.objecteeMap = map;
        final String strValueOf = String.valueOf(map.get(PART_NUMBER));
        final String strValueOf2 = String.valueOf(this.objecteeMap.get(PART_SERIAL_NUMBER));
        final String strValueOf3 = String.valueOf(this.objecteeMap.get(ASSEMBLY_NUMBER));
        if (isApplicantValidated()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateView$2(strValueOf, strValueOf2, strValueOf3);
                }
            }, 500L);
        }
    }

    private boolean isApplicantValidated() {
        if (String.valueOf(this.applicantMap.get(EPIC_NUMBER)).isEmpty()) {
            showdialog12("Alert", "Please select an applicant");
            setCurrentItem(0, true);
            return false;
        }
        if (String.valueOf(this.objecteeMap.get(EPIC_NUMBER)).isEmpty()) {
            showdialog12("Alert", "Please select an Objectee");
            setCurrentItem(1, true);
            return false;
        }
        if (String.valueOf(this.applicantMap.get(DVOTER_STATUS_TYPE)).equals("H") || String.valueOf(this.applicantMap.get(DVOTER_STATUS_TYPE)).equals("Y") || String.valueOf(this.applicantMap.get(DVOTER_STATUS_TYPE)).equals("1")) {
            showdialog12("Alert", "The EPIC is already marked as D-Voter hence you can't fill this form");
            setCurrentItem(0, true);
            return false;
        }
        if (String.valueOf(this.objecteeMap.get(DVOTER_STATUS_TYPE)).equals("H") || String.valueOf(this.objecteeMap.get(DVOTER_STATUS_TYPE)).equals("Y") || String.valueOf(this.objecteeMap.get(DVOTER_STATUS_TYPE)).equals("1")) {
            showdialog12("Alert", "The EPIC is already marked as D-Voter hence you can't fill this form");
            setCurrentItem(1, true);
            return false;
        }
        if (!String.valueOf(this.applicantMap.get(PART_NUMBER)).equals(String.valueOf(this.objecteeMap.get(PART_NUMBER)))) {
            showdialog12("Alert", "Both Applicant and Objectee should have same Part Number");
            setCurrentItem(1, true);
            return false;
        }
        if (!String.valueOf(this.applicantMap.get(ASSEMBLY_NUMBER)).equals(String.valueOf(this.objecteeMap.get(ASSEMBLY_NUMBER)))) {
            showdialog12("Alert", "Both Applicant and Objectee  should belong to Same Assembly Constituency");
            setCurrentItem(1, true);
            return false;
        }
        if (!String.valueOf(this.applicantMap.get(STATE)).equals(String.valueOf(this.objecteeMap.get(STATE)))) {
            showdialog12("Alert", "Both Applicant and Objectee  should belong to Same State");
            setCurrentItem(1, true);
            return false;
        }
        if (!String.valueOf(this.applicantMap.get("underJo")).equalsIgnoreCase("1") && !String.valueOf(this.objecteeMap.get("underJo")).equalsIgnoreCase("1")) {
            return true;
        }
        showdialog12("Alert", "The applicant is under Adjudication.");
        return false;
    }

    private void setUpViewPager() {
        this.adapterInterface = new GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment.3
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public int getCount() {
                return 2;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public Fragment getItem(int position) {
                if (position == 0) {
                    ApplicantDetails2Fragment applicantDetails2Fragment = new ApplicantDetails2Fragment();
                    applicantDetails2Fragment.setArguments(SelectApplicantObjecteeFragment.this.bundle1);
                    return applicantDetails2Fragment;
                }
                ObjecteeDetailsFragment objecteeDetailsFragment = new ObjecteeDetailsFragment();
                objecteeDetailsFragment.setArguments(SelectApplicantObjecteeFragment.this.bundle1);
                return objecteeDetailsFragment;
            }
        };
        initViewPagerAndTagLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showMigrationBottomsheet2, reason: merged with bridge method [inline-methods] */
    public void lambda$onCreateView$2(final String part, String serial, final String aslyNO) {
        this.sectionNolist.clear();
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        final BloBottomSheetMigrationSecondBinding bloBottomSheetMigrationSecondBindingInflate = BloBottomSheetMigrationSecondBinding.inflate(getLayoutInflater());
        dialog.setContentView((View) bloBottomSheetMigrationSecondBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        bloBottomSheetMigrationSecondBindingInflate.partNumberET.setText(part);
        bloBottomSheetMigrationSecondBindingInflate.serialnumberET.setText(serial);
        if (this.FlagKey.equals("1")) {
            bloBottomSheetMigrationSecondBindingInflate.ROM.setEnabled(false);
            bloBottomSheetMigrationSecondBindingInflate.SOR.setEnabled(false);
            bloBottomSheetMigrationSecondBindingInflate.IOR.setEnabled(false);
            bloBottomSheetMigrationSecondBindingInflate.COR.setEnabled(true);
        }
        bloBottomSheetMigrationSecondBindingInflate.AcNOET.setText(aslyNO);
        bloBottomSheetMigrationSecondBindingInflate.btnProceed.setEnabled(false);
        bloBottomSheetMigrationSecondBindingInflate.constituencytypeLayout.setVisibility(8);
        bloBottomSheetMigrationSecondBindingInflate.sectionNoShift.setVisibility(8);
        if (!SharedPref.getInstance(requireContext()).getSectionData().equals("")) {
            try {
                this.sectionNolist.add(SELECT_SECTION_NO_NAME);
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getSectionData());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.size(); i++) {
                    JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                    if (asJsonObject.get(SECTION_NAME) != null) {
                        this.sectionNumber = asJsonObject.get("sectionNo").getAsInt() + " - " + asJsonObject.get(SECTION_NAME).getAsString();
                    } else {
                        this.sectionNumber = asJsonObject.get("sectionNo").getAsInt() + " - ";
                    }
                    arrayList.add(this.sectionNumber);
                }
                Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return SelectApplicantObjecteeFragment.lambda$showMigrationBottomsheet2$4((String) obj, (String) obj2);
                    }
                });
                this.sectionNolist.addAll(arrayList);
            } catch (ParseException unused) {
                Logger.d("Exception", "Exception");
            }
        } else {
            getSection(this.stateCode, this.token, this.asmblyNO, this.partNo);
        }
        bloBottomSheetMigrationSecondBindingInflate.radiogroupSubmitApplication.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$$ExternalSyntheticLambda2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                this.f$0.lambda$showMigrationBottomsheet2$5(bloBottomSheetMigrationSecondBindingInflate, aslyNO, part, radioGroup, i2);
            }
        });
        bloBottomSheetMigrationSecondBindingInflate.constType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$$ExternalSyntheticLambda3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                this.f$0.lambda$showMigrationBottomsheet2$6(bloBottomSheetMigrationSecondBindingInflate, aslyNO, radioGroup, i2);
            }
        });
        bloBottomSheetMigrationSecondBindingInflate.btnProceed.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showMigrationBottomsheet2$7(bloBottomSheetMigrationSecondBindingInflate, dialog, view);
            }
        });
        dialog.show();
    }

    static /* synthetic */ int lambda$showMigrationBottomsheet2$4(String str, String str2) {
        return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMigrationBottomsheet2$5(BloBottomSheetMigrationSecondBinding bloBottomSheetMigrationSecondBinding, String str, String str2, RadioGroup radioGroup, int i) {
        switch (bloBottomSheetMigrationSecondBinding.radiogroupSubmitApplication.getCheckedRadioButtonId()) {
            case R.id.COR /* 2131361814 */:
                this.sectionFlag = "1";
                bloBottomSheetMigrationSecondBinding.constituencytypeLayout.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.sectionNoShift.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.constType.clearCheck();
                if (this.stateCode.equalsIgnoreCase(String.valueOf(this.objecteeMap.get(STATE)))) {
                    if (this.bloassemcode.equals(str)) {
                        if (this.blopartnumber.equals(str2)) {
                            this.selectedEntry = "COR";
                            bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(true);
                        } else {
                            showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_PART);
                            bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                        }
                    } else {
                        showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_Assembly);
                        bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                    }
                } else {
                    showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_STATE);
                    bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                }
                break;
            case R.id.IOR /* 2131361905 */:
                this.sectionFlag = "1";
                bloBottomSheetMigrationSecondBinding.constituencytypeLayout.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.sectionNoShift.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.constType.clearCheck();
                if (this.stateCode.equalsIgnoreCase(String.valueOf(this.objecteeMap.get(STATE)))) {
                    if (this.bloassemcode.equals(str)) {
                        if (this.blopartnumber.equals(str2)) {
                            this.selectedEntry = "IOR";
                            bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(true);
                        } else {
                            showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_PART);
                            bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                        }
                    } else {
                        showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_Assembly);
                        bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                    }
                } else {
                    showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_STATE);
                    bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                }
                break;
            case R.id.ROM /* 2131361940 */:
                this.sectionFlag = "1";
                bloBottomSheetMigrationSecondBinding.constituencytypeLayout.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.sectionNoShift.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.constType.clearCheck();
                if (this.stateCode.equalsIgnoreCase(String.valueOf(this.objecteeMap.get(STATE)))) {
                    if (this.bloassemcode.equals(str)) {
                        if (this.blopartnumber.equals(str2)) {
                            this.selectedEntry = "ROM";
                            bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(true);
                        } else {
                            showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_PART);
                            bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                        }
                    } else {
                        showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_Assembly);
                        bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                    }
                } else {
                    showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_STATE);
                    bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                }
                break;
            case R.id.SOR /* 2131362018 */:
                this.sectionFlag = "2";
                bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                bloBottomSheetMigrationSecondBinding.constituencytypeLayout.setVisibility(0);
                bloBottomSheetMigrationSecondBinding.sectionNoShift.setVisibility(0);
                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.sectionNolist);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bloBottomSheetMigrationSecondBinding.sectionNo.setAdapter((SpinnerAdapter) arrayAdapter);
                bloBottomSheetMigrationSecondBinding.sectionNo.setSelection(0);
                this.selectedSection = bloBottomSheetMigrationSecondBinding.sectionNo.getSelectedItem().toString();
                bloBottomSheetMigrationSecondBinding.sectionNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment.4
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        SelectApplicantObjecteeFragment.this.selectedSection = String.valueOf(parent.getItemAtPosition(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Logger.d("onNothing selected", SelectApplicantObjecteeFragment.this.selectedSection);
                    }
                });
                this.selectedEntry = "SOR";
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMigrationBottomsheet2$6(BloBottomSheetMigrationSecondBinding bloBottomSheetMigrationSecondBinding, String str, RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = bloBottomSheetMigrationSecondBinding.constType.getCheckedRadioButtonId();
        if (checkedRadioButtonId != 2131364991) {
            if (checkedRadioButtonId != 2131366723) {
                return;
            }
            if (this.stateCode.equalsIgnoreCase(String.valueOf(this.objecteeMap.get(STATE)))) {
                this.asseblytype = "WITHIN ASSEMBLY";
                if (!this.bloassemcode.equals(str)) {
                    bloBottomSheetMigrationSecondBinding.constType.clearCheck();
                    bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                    showDialog("Applicant does not belong to your AC, please select Outside AC");
                    return;
                }
                bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(true);
                return;
            }
            showDialog("Applicant does not belong to your AC, please select Outside AC");
            return;
        }
        if (this.stateCode.equalsIgnoreCase(String.valueOf(this.objecteeMap.get(STATE)))) {
            this.asseblytype = "OUTSIDE ASSEMBLY";
            if (this.bloassemcode.equals(str)) {
                bloBottomSheetMigrationSecondBinding.constType.clearCheck();
                bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                showDialog("Applicant belongs to your AC, please select Within AC");
                return;
            }
            bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(true);
            return;
        }
        this.asseblytype = "OUTSIDE ASSEMBLY";
        if (this.stateCode.equalsIgnoreCase("S04")) {
            if (this.stateCode.equalsIgnoreCase(String.valueOf(this.objecteeMap.get(STATE)))) {
                this.isOtherState = false;
            } else {
                this.isOtherState = true;
            }
        } else if (isValideSIRState()) {
            if (this.stateCode.equalsIgnoreCase(String.valueOf(this.objecteeMap.get(STATE))) || isValideEpicSIRState(String.valueOf(this.objecteeMap.get(STATE)))) {
                this.isdeclarationEnabled = false;
            } else {
                this.isdeclarationEnabled = true;
            }
        }
        bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMigrationBottomsheet2$7(BloBottomSheetMigrationSecondBinding bloBottomSheetMigrationSecondBinding, Dialog dialog, View view) {
        if (bloBottomSheetMigrationSecondBinding.constType.getCheckedRadioButtonId() != -1) {
            if (this.selectedSection.equals(SELECT_SECTION_NO_NAME)) {
                showdialog12("Alert", SELECT_SECTION_NO_NAME);
                return;
            } else {
                openFragment1(new MigrationCorrection(), "Migration Form");
                dialog.dismiss();
                return;
            }
        }
        openFragment1(new MigrationCorrection(), "Migration Form");
        dialog.dismiss();
    }

    public void getSection(String stateCode, String token, String asmblyNo, String partNo) {
        try {
            this.sectionNolist.clear();
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getSection("ANDROIDMOB", token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode, "application/json", asmblyNo, partNo).enqueue(new AnonymousClass5());
        } catch (Exception e) {
            Logger.d("Content", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JSONArray> {
        AnonymousClass5() {
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() != 200) {
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    SharedPref.getInstance(SelectApplicantObjecteeFragment.this.getContext()).setSectionData("");
                    String strOptString = jSONObject.optString("message");
                    Logger.d("Form_6_FVR_FORM_SUBMITTION_Error", strOptString);
                    SelectApplicantObjecteeFragment.this.commonUtilClass.showMessageWithTitleOK(SelectApplicantObjecteeFragment.this.requireContext(), SelectApplicantObjecteeFragment.SECTIONERROR + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$5$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                } catch (IOException | JSONException e) {
                    SharedPref.getInstance(SelectApplicantObjecteeFragment.this.getContext()).setSectionData("");
                    if (response.code() == 401) {
                        SelectApplicantObjecteeFragment.this.commonUtilClass.showMessageWithTitleOK(SelectApplicantObjecteeFragment.this.requireContext(), "Alert", "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$5$$ExternalSyntheticLambda2
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f$0.lambda$onResponse$2(dialogInterface, i);
                            }
                        });
                    } else {
                        SelectApplicantObjecteeFragment.this.commonUtilClass.showMessageWithTitleOK(SelectApplicantObjecteeFragment.this.requireContext(), SelectApplicantObjecteeFragment.SECTIONERROR + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$5$$ExternalSyntheticLambda3
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                    }
                    Logger.d("", e.getMessage());
                    return;
                }
            }
            JSONArray jSONArray = (JSONArray) response.body();
            SharedPref.getInstance(SelectApplicantObjecteeFragment.this.getContext()).setSectionData(jSONArray.toString());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.size(); i++) {
                JsonObject asJsonObject = SelectApplicantObjecteeFragment.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                if (asJsonObject.get(SelectApplicantObjecteeFragment.SECTION_NAME) == null) {
                    SelectApplicantObjecteeFragment.this.sectionNumber = asJsonObject.get("sectionNo").getAsInt() + " - ";
                } else {
                    SelectApplicantObjecteeFragment.this.sectionNumber = asJsonObject.get("sectionNo").getAsInt() + " - " + asJsonObject.get(SelectApplicantObjecteeFragment.SECTION_NAME).getAsString();
                }
                arrayList.add(SelectApplicantObjecteeFragment.this.sectionNumber);
            }
            Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$5$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return SelectApplicantObjecteeFragment.AnonymousClass5.lambda$onResponse$0((String) obj, (String) obj2);
                }
            });
            SelectApplicantObjecteeFragment.this.sectionNolist.addAll(arrayList);
        }

        static /* synthetic */ int lambda$onResponse$0(String str, String str2) {
            return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SelectApplicantObjecteeFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SelectApplicantObjecteeFragment.this.getContext()).setLocaleBool(false);
            SelectApplicantObjecteeFragment.this.startActivity(new Intent((Context) SelectApplicantObjecteeFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            SharedPref.getInstance(SelectApplicantObjecteeFragment.this.getContext()).setSectionData("");
            Logger.d("coming in onFailure ", t.getMessage());
            SelectApplicantObjecteeFragment.this.commonUtilClass.showMessageWithTitleOK(SelectApplicantObjecteeFragment.this.requireContext(), SelectApplicantObjecteeFragment.SECTIONERROR, "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$5$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    private void openFragment1(Fragment fragment, String selectedFragment) {
        String strValueOf;
        String str;
        String strValueOf2 = String.valueOf(this.objecteeMap.get("shiftingImage"));
        String str2 = (String.valueOf(this.objecteeMap.get(HOUSE_NUMBER)).equals("null") && String.valueOf(this.objecteeMap.get(LOCALITY_STREET)).equals("null") && String.valueOf(this.objecteeMap.get(TOWN_VILLAGE)).equals("null")) ? "" : String.valueOf(this.objecteeMap.get(HOUSE_NUMBER)) + this.objecteeMap.get(LOCALITY_STREET) + this.objecteeMap.get(TOWN_VILLAGE);
        String strValueOf3 = String.valueOf(this.objecteeMap.get(MOBILE_NUMBER)).equals("null") ? "" : String.valueOf(this.objecteeMap.get(MOBILE_NUMBER));
        if (String.valueOf(this.objecteeMap.get(MOBILE_NUMBER)).contains("+91")) {
            strValueOf3 = String.valueOf(this.objecteeMap.get(MOBILE_NUMBER)).substring(3);
        }
        String strValueOf4 = String.valueOf(this.objecteeMap.get(SECTIO_NO));
        if (this.sectionFlag.equals("2")) {
            strValueOf4 = this.selectedSection.split("-")[0].trim();
        }
        Bundle bundle = new Bundle();
        bundle.putString("Flag", "NEW FORM");
        bundle.putString("0", String.valueOf(this.objecteeMap.get(EPIC_NUMBER)).equals("null") ? "" : String.valueOf(this.objecteeMap.get(EPIC_NUMBER)));
        bundle.putString("1", String.valueOf(this.objecteeMap.get(STATE_NAME)).equals("null") ? "" : String.valueOf(this.objecteeMap.get(STATE_NAME)));
        bundle.putString("2", String.valueOf(this.objecteeMap.get(DISTRICT_NAME)).equals("null") ? "" : String.valueOf(this.objecteeMap.get(DISTRICT_NAME)));
        bundle.putString("3", String.valueOf(this.objecteeMap.get(ASSEMBLY)).equals("null") ? "" : String.valueOf(this.objecteeMap.get(ASSEMBLY)));
        bundle.putString("4", String.valueOf(this.objecteeMap.get(ASSEMBLY_NUMBER)).equals("null") ? "" : String.valueOf(this.objecteeMap.get(ASSEMBLY_NUMBER)));
        bundle.putString("5", (String.valueOf(this.objecteeMap.get(APPLICANT_FIRST_NAME)).equals("null") ? "" : String.valueOf(this.objecteeMap.get(APPLICANT_FIRST_NAME))) + " " + (String.valueOf(this.objecteeMap.get(APPLICANT_LAST_NAME)).equals("null") ? "" : String.valueOf(this.objecteeMap.get(APPLICANT_LAST_NAME))));
        bundle.putString("6", "");
        bundle.putString("7", strValueOf3);
        bundle.putString("8", String.valueOf(this.objecteeMap.get("emailId")).equals("null") ? "" : String.valueOf(this.objecteeMap.get("emailId")));
        bundle.putString("9", this.selectedEntry);
        bundle.putString("10", this.appfor);
        bundle.putString("11", String.valueOf(this.objecteeMap.get(PART_NUMBER)).equals("null") ? "" : String.valueOf(this.objecteeMap.get(PART_NUMBER)));
        if (String.valueOf(this.objecteeMap.get(PART_SERIAL_NUMBER)).equals("null")) {
            strValueOf = "";
            str = strValueOf;
        } else {
            strValueOf = String.valueOf(this.objecteeMap.get(PART_SERIAL_NUMBER));
            str = "";
        }
        bundle.putString("12", strValueOf);
        bundle.putString("13", String.valueOf(this.objecteeMap.get(STATE)).equals("null") ? str : String.valueOf(this.objecteeMap.get(STATE)));
        bundle.putString("14", String.valueOf(this.objecteeMap.get(DISTRICT_CODE)).equals("null") ? str : String.valueOf(this.objecteeMap.get(DISTRICT_CODE)));
        bundle.putString("15", String.valueOf(this.objecteeMap.get(GENDER)).equals("null") ? str : String.valueOf(this.objecteeMap.get(GENDER)));
        bundle.putString("16", this.asseblytype);
        bundle.putString("17", String.valueOf(this.objecteeMap.get(RELATION_NAME)).equals("null") ? str : String.valueOf(this.objecteeMap.get(RELATION_NAME)));
        bundle.putString("18", String.valueOf(this.objecteeMap.get(RELATION_NAME_L_1)).equals("null") ? str : String.valueOf(this.objecteeMap.get(RELATION_NAME_L_1)));
        bundle.putString("19", String.valueOf(this.objecteeMap.get(GENDERL_R)).equals("null") ? str : String.valueOf(this.objecteeMap.get(GENDERL_R)));
        bundle.putString("20", String.valueOf(this.objecteeMap.get(DOB)).equals("null") ? str : String.valueOf(this.objecteeMap.get(DOB)));
        bundle.putString("21", str2);
        bundle.putString("22", String.valueOf(this.objecteeMap.get(HOUSE_NUMBER_L_R)).equals("null") ? str : String.valueOf(this.objecteeMap.get(HOUSE_NUMBER_L_R)));
        bundle.putString("23", String.valueOf(this.objecteeMap.get(APPLICANT_NAME_L_R)).equals("null") ? str : String.valueOf(this.objecteeMap.get(APPLICANT_NAME_L_R)));
        bundle.putString("24", String.valueOf(this.objecteeMap.get(APPLICANT_FIRST_NAME)).equals("null") ? str : String.valueOf(this.objecteeMap.get(APPLICANT_FIRST_NAME)));
        bundle.putString("25", String.valueOf(this.objecteeMap.get(APPLICANT_LAST_NAME)).equals("null") ? str : String.valueOf(this.objecteeMap.get(APPLICANT_LAST_NAME)));
        bundle.putString("26", String.valueOf(this.objecteeMap.get(HOUSE_NUMBER)).equals("null") ? str : String.valueOf(this.objecteeMap.get(HOUSE_NUMBER)));
        bundle.putString("27", String.valueOf(this.objecteeMap.get(LOCALITY_STREET)).equals("null") ? str : String.valueOf(this.objecteeMap.get(LOCALITY_STREET)));
        bundle.putString("28", String.valueOf(this.objecteeMap.get(TOWN_VILLAGE)).equals("null") ? str : String.valueOf(this.objecteeMap.get(TOWN_VILLAGE)));
        bundle.putString("29", String.valueOf(this.objecteeMap.get(AGE)).equals("null") ? str : String.valueOf(this.objecteeMap.get(AGE)));
        bundle.putString("30", "NO");
        bundle.putString("31", strValueOf4);
        bundle.putString("32", String.valueOf(this.objecteeMap.get(PART_NUMBER)).equals("null") ? str : String.valueOf(this.objecteeMap.get(PART_NUMBER)));
        bundle.putString("33", String.valueOf(this.objecteeMap.get(STATE)).equals("null") ? str : String.valueOf(this.objecteeMap.get(STATE)));
        bundle.putString("34", String.valueOf(this.objecteeMap.get(ASSEMBLY_NUMBER)).equals("null") ? str : String.valueOf(this.objecteeMap.get(ASSEMBLY_NUMBER)));
        bundle.putString("35", String.valueOf(this.objecteeMap.get(PART_SERIAL_NUMBER)).equals("null") ? str : String.valueOf(this.objecteeMap.get(PART_SERIAL_NUMBER)));
        bundle.putString("36", strValueOf2);
        bundle.putString("37", String.valueOf(this.objecteeMap.get(RELATIONTYPE)).equals("null") ? str : String.valueOf(this.objecteeMap.get(RELATIONTYPE)));
        bundle.putString("38", String.valueOf(this.objecteeMap.get("position")));
        bundle.putString("39", String.valueOf(this.objecteeMap.get("houseNoRegional")));
        bundle.putBoolean("isOtherState", this.isOtherState);
        bundle.putBoolean("isdeclarationEnabled", this.isdeclarationEnabled);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        if (this.FlagKey.equals("1")) {
            fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        } else {
            fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        }
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    private void showdialog12(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    private void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    private void showDialog(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    private void initViewPagerAndTagLayout() {
        this.binding.viewPager.setAdapter(new GenericFragmentPagerAdapter(getChildFragmentManager(), getLifecycle(), this.adapterInterface));
        new TabLayoutMediator(this.binding.tabLayout, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment$$ExternalSyntheticLambda10
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                this.f$0.lambda$initViewPagerAndTagLayout$10(tab, i);
            }
        }).attach();
        getResources().getColor(R.color.blo_black);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViewPagerAndTagLayout$10(TabLayout.Tab tab, int i) {
        tab.setText(this.tabs[i]);
    }

    public void setCurrentItem(int item, boolean smoothScroll) {
        this.binding.viewPager.setCurrentItem(item, smoothScroll);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public boolean isValideSIRState() {
        return this.stateCode.equalsIgnoreCase("U01") || this.stateCode.equalsIgnoreCase("S05") || this.stateCode.equalsIgnoreCase("U07") || this.stateCode.equalsIgnoreCase("S26") || this.stateCode.equalsIgnoreCase("S06") || this.stateCode.equalsIgnoreCase("S11") || this.stateCode.equalsIgnoreCase("S12") || this.stateCode.equalsIgnoreCase("S24") || this.stateCode.equalsIgnoreCase("S20") || this.stateCode.equalsIgnoreCase("S25") || this.stateCode.equalsIgnoreCase("S22") || this.stateCode.equalsIgnoreCase("U06");
    }

    public boolean isValideEpicSIRState(String epicStateCode) {
        return epicStateCode.equalsIgnoreCase("U01") || epicStateCode.equalsIgnoreCase("S05") || epicStateCode.equalsIgnoreCase("S04") || epicStateCode.equalsIgnoreCase("U07") || epicStateCode.equalsIgnoreCase("S26") || epicStateCode.equalsIgnoreCase("S06") || epicStateCode.equalsIgnoreCase("S11") || epicStateCode.equalsIgnoreCase("S12") || epicStateCode.equalsIgnoreCase("S24") || epicStateCode.equalsIgnoreCase("S20") || epicStateCode.equalsIgnoreCase("S25") || epicStateCode.equalsIgnoreCase("S22") || epicStateCode.equalsIgnoreCase("U06");
    }
}
