package in.gov.eci.bloapp.views.fragments.voterforms.migration;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloBottomSheetMigrationSecondBinding;
import in.gov.eci.bloapp.databinding.BloFragmentSelectApplicantBinding;
import in.gov.eci.bloapp.databinding.BloSelectApplicantLayoutBinding;
import in.gov.eci.bloapp.model.app_model.form8EpicDetailsModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Utils;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class SelectApplicantFragment extends Fragment {
    private static final String ALERT = "Alert";
    private static final String APPLICANT_DOESN_T_BELONG_TO_YOUR_Assembly = "Applicant doesn’t belong to your Assembly";
    private static final String APPLICANT_DOESN_T_BELONG_TO_YOUR_PART = "Applicant doesn’t belong to your part";
    private static final String APPLICANT_DOESN_T_BELONG_TO_YOUR_STATE = "Applicant doesn’t belong to your state";
    private static final String SECTIONAME = "sectionName";
    private static final String SECTIONERROR = "Section Error - ";
    private static final String SECTION_NO = "sectionNo";
    private static final String SELECT_SECTION_NO_NAME = "Select Section No. & Name";
    private String FlagKey;
    private String appfor;
    private String asmblyNO;
    private String asseblytype;
    BloFragmentSelectApplicantBinding binding;
    private String bloassemcode;
    private String blopartnumber;
    Retrofit.Builder builder;
    private String category;
    private String dVoterStatusType;
    private String efPhotoFile;
    private String efbase64image;
    private final String elastic;
    private String epicId;
    private String epicNo;
    private String epicdetails;
    private String flag;
    private ArrayList<form8EpicDetailsModel> form8epicDetailsList;
    private boolean isOtherState;
    private boolean isdeclarationEnabled;
    private String partno;
    private String penameregionalFirst;
    private String penameregionalLast;
    private String position;
    Retrofit retrofit;
    private String sectionFlag;
    private String sectionNumber;
    BloSelectApplicantLayoutBinding selectApplicantLayoutBinding;
    private String selectedEntry;
    private String selectedSection;
    private String serialno;
    private String shiftingImage;
    private String stateCode;
    private String token;
    private String underJo;
    JsonArray epicdetailsArray = null;
    private RadioButton lastCheckedRB = null;
    private final String[] pe = new String[50];
    private int count = 0;
    ArrayList<String> sectionNolist = new ArrayList<>();
    CommomUtility commonUtilClass = new CommomUtility();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();

    public SelectApplicantFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.token = "";
        this.blopartnumber = "";
        this.bloassemcode = "";
        this.sectionFlag = "1";
        this.selectedEntry = "";
        this.appfor = "";
        this.shiftingImage = "";
        this.elastic = "NO";
        this.isOtherState = false;
        this.isdeclarationEnabled = false;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentSelectApplicantBinding.inflate(inflater);
        this.form8epicDetailsList = new ArrayList<>();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.blopartnumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.bloassemcode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.binding.textView3.setText("Select Applicant  v" + new CommomUtility().appversion);
        final Bundle arguments = getArguments();
        if (arguments != null) {
            this.epicdetails = arguments.getString("epicDetails");
            this.appfor = arguments.getString("appfor");
            this.FlagKey = arguments.getString("FlagKey");
            String string = arguments.getString("flag");
            this.flag = string;
            if (!TextUtils.isEmpty(string) && this.flag.equalsIgnoreCase("selectPhoto")) {
                this.epicNo = arguments.getString("epic");
                this.epicId = arguments.getString("epicId");
                this.efPhotoFile = arguments.getString("efPhoto");
                this.efbase64image = arguments.getString("efbase64image");
                this.category = arguments.getString("category");
            }
            if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("newvoter")) {
                this.epicNo = arguments.getString("epic");
                this.epicId = arguments.getString("epicId");
                this.category = arguments.getString("category");
            }
        }
        this.epicdetailsArray = JsonParser.parseString(this.epicdetails).getAsJsonArray();
        String str = "relationLNameL1";
        int i = 0;
        if (!TextUtils.isEmpty(arguments.getString("Correction"))) {
            if (arguments.getString("Correction").equals("Y")) {
                this.position = arguments.getString("radioPosition");
                this.appfor = arguments.getString("10");
                while (i < this.epicdetailsArray.size()) {
                    JsonObject asJsonObject = this.epicdetailsArray.get(i).getAsJsonObject();
                    this.form8epicDetailsList.add(new form8EpicDetailsModel(String.valueOf(asJsonObject.get("D_VOTER")).replace("null", StringUtils.SPACE), String.valueOf(asJsonObject.get("PART_NUMBER")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("STATE_CODE")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("AC_NUMBER")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("PART_SERIAL_NUMBER")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("STATE_NAME")).replace(RegexMatcher.JSON_STRING_REGEX, ""), "", String.valueOf(asJsonObject.get("ASSEMBLY_NAME")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("FIRST_NAME")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("LAST_NAME")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("EPIC_NUMBER")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("MOBILE_NUMBER")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("EMAIL_ID")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("DISTRICT_CODE")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("GENDER")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("RELATION_FIRST_NAME")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("RELATION_SURNAME")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("RELATION_NAME_L1")).replace(RegexMatcher.JSON_STRING_REGEX, "") + StringUtils.SPACE + String.valueOf(asJsonObject.get("relationLNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("GENDER_L1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("APPLICANT_NAME_L1")).replace(RegexMatcher.JSON_STRING_REGEX, "") + StringUtils.SPACE + String.valueOf(asJsonObject.get("applicantLastNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("AGE")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("SECTION_NUMBER")).replace(RegexMatcher.JSON_STRING_REGEX, ""), "", String.valueOf(asJsonObject.get("DOB")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("HOUSE_NUMBER")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("HOUSE_NUMBER_L1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("LOCALITY_STREET")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("LOCALITY_STREET_L1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("TOWN_VILLAGE")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("TOWN_VILLAGE_L1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("TEHSIL")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("TEHSIL_L1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("RELATION_TYPE")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("penameregionalFirst")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("penameregionalLast")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("underJo")).replace(RegexMatcher.JSON_STRING_REGEX, "")));
                    i++;
                }
            }
        } else {
            while (i < this.epicdetailsArray.size()) {
                JsonObject jsonObject = this.epicdetailsArray.get(i).getAsJsonObject().get("content");
                String strReplace = String.valueOf(jsonObject.get("dVoterStatusType")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace2 = String.valueOf(jsonObject.get("partNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace3 = String.valueOf(jsonObject.get("stateCd")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace4 = String.valueOf(jsonObject.get("acNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace5 = String.valueOf(jsonObject.get("partSerialNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace6 = String.valueOf(jsonObject.get("stateName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace7 = String.valueOf(jsonObject.get("districtValue")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace8 = String.valueOf(jsonObject.get("asmblyName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace9 = String.valueOf(jsonObject.get("applicantFirstName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace10 = String.valueOf(jsonObject.get("applicantLastName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace11 = String.valueOf(jsonObject.get("epicNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace12 = String.valueOf(jsonObject.get("mobileNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace13 = String.valueOf(jsonObject.get(Constants.EMAIL_ID)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace14 = String.valueOf(jsonObject.get("districtCd")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace15 = String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace16 = String.valueOf(jsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace17 = String.valueOf(jsonObject.get("relationLName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String str2 = String.valueOf(jsonObject.get("relationNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "") + StringUtils.SPACE + String.valueOf(jsonObject.get(str)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace18 = String.valueOf(jsonObject.get("genderL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String str3 = String.valueOf(jsonObject.get("applicantFirstNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "") + StringUtils.SPACE + String.valueOf(jsonObject.get("applicantLastNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace19 = String.valueOf(jsonObject.get("applicantFirstNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace20 = String.valueOf(jsonObject.get("applicantLastNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                this.form8epicDetailsList.add(new form8EpicDetailsModel(strReplace, strReplace2, strReplace3, strReplace4, strReplace5, strReplace6, strReplace7, strReplace8, strReplace9, strReplace10, strReplace11, strReplace12, strReplace13, strReplace14, strReplace15, strReplace16, strReplace17, str2, strReplace18, str3, String.valueOf(jsonObject.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get(SECTION_NO)).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("photo")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("dob")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("houseNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("houseNumberL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("localityStreet")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("localityStreetL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("townVillage")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("townVillageL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("tehsil")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("tehsilL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationType")).replace(RegexMatcher.JSON_STRING_REGEX, ""), strReplace19, strReplace20, String.valueOf(jsonObject.get("underJo")).replace(RegexMatcher.JSON_STRING_REGEX, "")));
                i++;
                str = str;
            }
        }
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        try {
            requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment.1
                public void handleOnBackPressed() {
                    if (SelectApplicantFragment.this.getFragmentManager().getBackStackEntryCount() != 0) {
                        SelectApplicantFragment.this.getFragmentManager().popBackStack();
                    }
                }
            });
        } catch (Exception unused) {
            openFragment(new VoterFormsFragment(), "Voter forms FRAGMENT");
        }
        initRecyclerViewAdapter();
        if (!TextUtils.isEmpty(arguments.getString("Correction")) && arguments.getString("Correction").equals("Y")) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateView$2(arguments);
                }
            }, 500L);
        }
        this.binding.saveNextTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$4(view);
            }
        });
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
    public /* synthetic */ void lambda$onCreateView$2(Bundle bundle) {
        String string = bundle.getString("11");
        String string2 = bundle.getString("12");
        String string3 = bundle.getString("4");
        this.selectApplicantLayoutBinding.radioButton.setChecked(true);
        showMigrationBottomsheet2(string, string2, string3, "Y");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(View view) {
        if (isShftingDataOk()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateView$3();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3() {
        String[] strArr = this.pe;
        showMigrationBottomsheet2(strArr[0], strArr[3], strArr[2], "");
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            SelectApplicantFragment selectApplicantFragment = SelectApplicantFragment.this;
            selectApplicantFragment.selectApplicantLayoutBinding = BloSelectApplicantLayoutBinding.inflate(selectApplicantFragment.getLayoutInflater());
            return new RecyclerViewHolder(SelectApplicantFragment.this.selectApplicantLayoutBinding);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
            ((BloSelectApplicantLayoutBinding) holder.binding).stateET.setText(((form8EpicDetailsModel) SelectApplicantFragment.this.form8epicDetailsList.get(position)).getStateName());
            ((BloSelectApplicantLayoutBinding) holder.binding).partNumberET.setText(((form8EpicDetailsModel) SelectApplicantFragment.this.form8epicDetailsList.get(position)).getPartNumber());
            ((BloSelectApplicantLayoutBinding) holder.binding).ApplicantNameEt.setText(((form8EpicDetailsModel) SelectApplicantFragment.this.form8epicDetailsList.get(position)).getApplicantFirstname());
            ((BloSelectApplicantLayoutBinding) holder.binding).relativeNameET.setText(((form8EpicDetailsModel) SelectApplicantFragment.this.form8epicDetailsList.get(position)).getRelationFirstName());
            ((BloSelectApplicantLayoutBinding) holder.binding).AcEt.setText(((form8EpicDetailsModel) SelectApplicantFragment.this.form8epicDetailsList.get(position)).getAcNumber());
            ((BloSelectApplicantLayoutBinding) holder.binding).serialNoEt.setText(((form8EpicDetailsModel) SelectApplicantFragment.this.form8epicDetailsList.get(position)).getPartSerialNumber());
            ((BloSelectApplicantLayoutBinding) holder.binding).ApplicantSurnameEt.setText(((form8EpicDetailsModel) SelectApplicantFragment.this.form8epicDetailsList.get(position)).getApplicantLastname());
            ((BloSelectApplicantLayoutBinding) holder.binding).relativeSurnameET.setText(((form8EpicDetailsModel) SelectApplicantFragment.this.form8epicDetailsList.get(position)).getRelationSurname());
            ((BloSelectApplicantLayoutBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(holder, position, view);
                }
            });
            ((BloSelectApplicantLayoutBinding) holder.binding).radioButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ((BloSelectApplicantLayoutBinding) holder.binding).radioButton.setChecked(true);
                    SelectApplicantFragment.this.radioButtonSelectedDetails(position);
                }
            });
            ((BloSelectApplicantLayoutBinding) holder.binding).radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$2$$ExternalSyntheticLambda1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f$0.lambda$onBindViewHolder$1(compoundButton, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(RecyclerViewHolder recyclerViewHolder, int i, View view) {
            ((BloSelectApplicantLayoutBinding) recyclerViewHolder.binding).radioButton.setChecked(true);
            SelectApplicantFragment.this.radioButtonSelectedDetails(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(CompoundButton compoundButton, boolean z) {
            RadioButton radioButton = (RadioButton) compoundButton;
            if (SelectApplicantFragment.this.lastCheckedRB != null) {
                SelectApplicantFragment.this.lastCheckedRB.setChecked(false);
            }
            SelectApplicantFragment.this.lastCheckedRB = radioButton;
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return SelectApplicantFragment.this.form8epicDetailsList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        GenericRecyclerView genericRecyclerView = new GenericRecyclerView(new AnonymousClass2());
        this.binding.selectApplicantrv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.selectApplicantrv.setAdapter(genericRecyclerView);
    }

    private void showMigrationBottomsheet2(String part, String serial, String aslyNO, String Correction) {
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
        bloBottomSheetMigrationSecondBindingInflate.AcNOET.setText(aslyNO);
        this.partno = bloBottomSheetMigrationSecondBindingInflate.partNumberET.getText().toString();
        this.serialno = bloBottomSheetMigrationSecondBindingInflate.serialnumberET.getText().toString();
        if (!TextUtils.isEmpty(this.FlagKey) && this.FlagKey.equals("1")) {
            bloBottomSheetMigrationSecondBindingInflate.ROM.setEnabled(false);
            bloBottomSheetMigrationSecondBindingInflate.SOR.setEnabled(false);
            bloBottomSheetMigrationSecondBindingInflate.IOR.setEnabled(false);
            bloBottomSheetMigrationSecondBindingInflate.COR.setEnabled(true);
        }
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
                    if (asJsonObject.get(SECTIONAME) != null) {
                        this.sectionNumber = asJsonObject.get(SECTION_NO).getAsInt() + " - " + asJsonObject.get(SECTIONAME).getAsString();
                    } else {
                        this.sectionNumber = asJsonObject.get(SECTION_NO).getAsInt() + " - ";
                    }
                    arrayList.add(this.sectionNumber);
                }
                Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda5
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return SelectApplicantFragment.lambda$showMigrationBottomsheet2$5((String) obj, (String) obj2);
                    }
                });
                this.sectionNolist.addAll(arrayList);
            } catch (ParseException unused) {
                Logger.d("Exception", "Exception");
            }
        } else {
            getSection(this.stateCode, this.token, this.asmblyNO, this.blopartnumber);
        }
        if (!TextUtils.isEmpty(Correction) && Correction.equals("Y")) {
            bloBottomSheetMigrationSecondBindingInflate.ROM.setEnabled(true);
            bloBottomSheetMigrationSecondBindingInflate.SOR.setEnabled(true);
            bloBottomSheetMigrationSecondBindingInflate.IOR.setEnabled(true);
            bloBottomSheetMigrationSecondBindingInflate.COR.setEnabled(true);
            bloBottomSheetMigrationSecondBindingInflate.SOR.setChecked(true);
            radioButtonSelectedDetails(Integer.parseInt(this.position));
            bloBottomSheetMigrationSecondBindingInflate.constituencytypeLayout.setVisibility(0);
            bloBottomSheetMigrationSecondBindingInflate.sectionNoShift.setVisibility(0);
            this.sectionFlag = "2";
            bloBottomSheetMigrationSecondBindingInflate.btnProceed.setEnabled(false);
            bloBottomSheetMigrationSecondBindingInflate.constituencytypeLayout.setVisibility(0);
            bloBottomSheetMigrationSecondBindingInflate.sectionNoShift.setVisibility(0);
            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.sectionNolist);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            bloBottomSheetMigrationSecondBindingInflate.sectionNo.setAdapter((SpinnerAdapter) arrayAdapter);
            bloBottomSheetMigrationSecondBindingInflate.sectionNo.setSelection(0);
            this.selectedSection = bloBottomSheetMigrationSecondBindingInflate.sectionNo.getSelectedItem().toString();
            bloBottomSheetMigrationSecondBindingInflate.sectionNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SelectApplicantFragment.this.selectedSection = String.valueOf(parent.getItemAtPosition(position));
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                    Logger.d("Nothing Selected", SelectApplicantFragment.this.selectedSection);
                }
            });
            this.selectedEntry = "SOR";
        }
        bloBottomSheetMigrationSecondBindingInflate.radiogroupSubmitApplication.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda6
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                this.f$0.lambda$showMigrationBottomsheet2$6(bloBottomSheetMigrationSecondBindingInflate, radioGroup, i2);
            }
        });
        bloBottomSheetMigrationSecondBindingInflate.constType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda7
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                this.f$0.lambda$showMigrationBottomsheet2$7(bloBottomSheetMigrationSecondBindingInflate, radioGroup, i2);
            }
        });
        bloBottomSheetMigrationSecondBindingInflate.btnProceed.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showMigrationBottomsheet2$8(bloBottomSheetMigrationSecondBindingInflate, dialog, view);
            }
        });
        if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("selectPhoto")) {
            bloBottomSheetMigrationSecondBindingInflate.ROM.setEnabled(false);
            bloBottomSheetMigrationSecondBindingInflate.SOR.setEnabled(false);
            bloBottomSheetMigrationSecondBindingInflate.IOR.setEnabled(false);
            bloBottomSheetMigrationSecondBindingInflate.COR.setEnabled(false);
            bloBottomSheetMigrationSecondBindingInflate.COR.setChecked(true);
            enableCOR(bloBottomSheetMigrationSecondBindingInflate);
            bloBottomSheetMigrationSecondBindingInflate.btnProceed.setEnabled(true);
        }
        dialog.show();
    }

    static /* synthetic */ int lambda$showMigrationBottomsheet2$5(String str, String str2) {
        return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMigrationBottomsheet2$6(BloBottomSheetMigrationSecondBinding bloBottomSheetMigrationSecondBinding, RadioGroup radioGroup, int i) {
        switch (bloBottomSheetMigrationSecondBinding.radiogroupSubmitApplication.getCheckedRadioButtonId()) {
            case R.id.COR /* 2131361817 */:
                this.sectionFlag = "1";
                bloBottomSheetMigrationSecondBinding.constituencytypeLayout.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.sectionNoShift.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.constType.clearCheck();
                if (this.stateCode.equalsIgnoreCase(this.form8epicDetailsList.get(Integer.parseInt(this.position)).stateCode)) {
                    if (this.bloassemcode.equals(this.pe[2])) {
                        if (this.blopartnumber.equals(this.pe[0])) {
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
            case R.id.IOR /* 2131361913 */:
                this.sectionFlag = "1";
                bloBottomSheetMigrationSecondBinding.constituencytypeLayout.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.sectionNoShift.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.constType.clearCheck();
                if (this.stateCode.equalsIgnoreCase(this.form8epicDetailsList.get(Integer.parseInt(this.position)).stateCode)) {
                    if (this.bloassemcode.equals(this.pe[2])) {
                        if (this.blopartnumber.equals(this.pe[0])) {
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
            case R.id.ROM /* 2131361949 */:
                this.sectionFlag = "1";
                bloBottomSheetMigrationSecondBinding.constituencytypeLayout.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.sectionNoShift.setVisibility(8);
                bloBottomSheetMigrationSecondBinding.constType.clearCheck();
                if (this.stateCode.equalsIgnoreCase(this.form8epicDetailsList.get(Integer.parseInt(this.position)).stateCode)) {
                    if (this.bloassemcode.equals(this.pe[2])) {
                        if (this.blopartnumber.equals(this.pe[0])) {
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
            case R.id.SOR /* 2131362027 */:
                this.sectionFlag = "2";
                bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                bloBottomSheetMigrationSecondBinding.constituencytypeLayout.setVisibility(0);
                bloBottomSheetMigrationSecondBinding.sectionNoShift.setVisibility(0);
                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.sectionNolist);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bloBottomSheetMigrationSecondBinding.sectionNo.setAdapter((SpinnerAdapter) arrayAdapter);
                bloBottomSheetMigrationSecondBinding.sectionNo.setSelection(0);
                this.selectedSection = bloBottomSheetMigrationSecondBinding.sectionNo.getSelectedItem().toString();
                bloBottomSheetMigrationSecondBinding.sectionNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment.4
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        SelectApplicantFragment.this.selectedSection = String.valueOf(parent.getItemAtPosition(position));
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> parent) {
                        Logger.d("Nothing Selected", SelectApplicantFragment.this.selectedSection);
                    }
                });
                this.selectedEntry = "SOR";
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMigrationBottomsheet2$7(BloBottomSheetMigrationSecondBinding bloBottomSheetMigrationSecondBinding, RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = bloBottomSheetMigrationSecondBinding.constType.getCheckedRadioButtonId();
        if (checkedRadioButtonId != 2131365161) {
            if (checkedRadioButtonId != 2131366999) {
                return;
            }
            if (this.stateCode.equalsIgnoreCase(this.form8epicDetailsList.get(Integer.parseInt(this.position)).stateCode)) {
                this.asseblytype = "WITHIN ASSEMBLY";
                if (!this.bloassemcode.equals(this.pe[2])) {
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
        if (this.stateCode.equalsIgnoreCase(this.form8epicDetailsList.get(Integer.parseInt(this.position)).stateCode)) {
            this.asseblytype = "OUTSIDE ASSEMBLY";
            if (this.bloassemcode.equals(this.pe[2])) {
                bloBottomSheetMigrationSecondBinding.constType.clearCheck();
                bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(false);
                showDialog("Applicant belongs to your AC, please select Within AC");
                return;
            }
            bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(true);
            return;
        }
        bloBottomSheetMigrationSecondBinding.btnProceed.setEnabled(true);
        this.asseblytype = "OUTSIDE ASSEMBLY";
        if (this.stateCode.equalsIgnoreCase("S04")) {
            if (this.stateCode.equalsIgnoreCase(this.form8epicDetailsList.get(Integer.parseInt(this.position)).stateCode)) {
                this.isOtherState = false;
                return;
            } else {
                this.isOtherState = true;
                return;
            }
        }
        if (Utils.isValideSIRState(this.stateCode) || Utils.isValide19SIRState(this.stateCode)) {
            if (this.stateCode.equalsIgnoreCase(this.form8epicDetailsList.get(Integer.parseInt(this.position)).stateCode)) {
                this.isdeclarationEnabled = false;
            } else if (isValideEpicSIRState(this.form8epicDetailsList.get(Integer.parseInt(this.position)).stateCode)) {
                this.isdeclarationEnabled = false;
            } else {
                this.isdeclarationEnabled = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMigrationBottomsheet2$8(BloBottomSheetMigrationSecondBinding bloBottomSheetMigrationSecondBinding, Dialog dialog, View view) {
        if (bloBottomSheetMigrationSecondBinding.constType.getCheckedRadioButtonId() != -1) {
            if (this.selectedSection.equals(SELECT_SECTION_NO_NAME)) {
                showdialog2("Alert", SELECT_SECTION_NO_NAME);
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

    private void enableCOR(BloBottomSheetMigrationSecondBinding dialogBinding) {
        this.sectionFlag = "1";
        dialogBinding.constituencytypeLayout.setVisibility(8);
        dialogBinding.sectionNoShift.setVisibility(8);
        dialogBinding.constType.clearCheck();
        if (this.stateCode.equalsIgnoreCase(this.form8epicDetailsList.get(Integer.parseInt(this.position)).stateCode)) {
            if (this.bloassemcode.equals(this.pe[2])) {
                if (this.blopartnumber.equals(this.pe[0])) {
                    this.selectedEntry = "COR";
                    dialogBinding.btnProceed.setEnabled(true);
                    return;
                } else {
                    showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_PART);
                    dialogBinding.btnProceed.setEnabled(false);
                    return;
                }
            }
            showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_Assembly);
            dialogBinding.btnProceed.setEnabled(false);
            return;
        }
        showDialog(APPLICANT_DOESN_T_BELONG_TO_YOUR_STATE);
        dialogBinding.btnProceed.setEnabled(false);
    }

    public void getSection(String stateCode, String token1, String asmblyNo, String partNo) {
        try {
            this.sectionNolist.clear();
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getSection("ANDROIDMOB", token1, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode, "application/json", asmblyNo, partNo).enqueue(new AnonymousClass5());
        } catch (Exception e) {
            Logger.d("Content", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JSONArray> {
        AnonymousClass5() {
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() != 200) {
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    SharedPref.getInstance(SelectApplicantFragment.this.getContext()).setSectionData("");
                    String strOptString = jSONObject.optString("message");
                    Logger.d("Form_6_FVR_FORM_SUBMITTION_Error", strOptString);
                    SelectApplicantFragment.this.commonUtilClass.showMessageWithTitleOK(SelectApplicantFragment.this.requireContext(), SelectApplicantFragment.SECTIONERROR + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$5$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                } catch (IOException | JSONException e) {
                    SharedPref.getInstance(SelectApplicantFragment.this.getContext()).setSectionData("");
                    if (response.code() == 401) {
                        SelectApplicantFragment.this.commonUtilClass.showMessageWithTitleOK(SelectApplicantFragment.this.requireContext(), "Alert", "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$5$$ExternalSyntheticLambda2
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f$0.lambda$onResponse$2(dialogInterface, i);
                            }
                        });
                    } else {
                        SelectApplicantFragment.this.commonUtilClass.showMessageWithTitleOK(SelectApplicantFragment.this.requireContext(), SelectApplicantFragment.SECTIONERROR + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$5$$ExternalSyntheticLambda3
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
            SharedPref.getInstance(SelectApplicantFragment.this.getContext()).setSectionData(jSONArray.toString());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.size(); i++) {
                JsonObject asJsonObject = SelectApplicantFragment.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                if (asJsonObject.get(SelectApplicantFragment.SECTIONAME) == null) {
                    SelectApplicantFragment.this.sectionNumber = asJsonObject.get(SelectApplicantFragment.SECTION_NO).getAsInt() + " - ";
                } else {
                    SelectApplicantFragment.this.sectionNumber = asJsonObject.get(SelectApplicantFragment.SECTION_NO).getAsInt() + " - " + asJsonObject.get(SelectApplicantFragment.SECTIONAME).getAsString();
                }
                arrayList.add(SelectApplicantFragment.this.sectionNumber);
            }
            Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$5$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return SelectApplicantFragment.AnonymousClass5.lambda$onResponse$0((String) obj, (String) obj2);
                }
            });
            SelectApplicantFragment.this.sectionNolist.addAll(arrayList);
        }

        static /* synthetic */ int lambda$onResponse$0(String str, String str2) {
            return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SelectApplicantFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SelectApplicantFragment.this.getContext()).setLocaleBool(false);
            SelectApplicantFragment.this.startActivity(new Intent((Context) SelectApplicantFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            SharedPref.getInstance(SelectApplicantFragment.this.getContext()).setSectionData("");
            Logger.d("coming in onFailure ", t.getMessage());
            SelectApplicantFragment.this.commonUtilClass.showMessageWithTitleOK(SelectApplicantFragment.this.requireContext(), SelectApplicantFragment.SECTIONERROR, "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$5$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    private void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    private void showDialog1(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Alert");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    private void showdialog2(String title, String msg) {
        new androidx.appcompat.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    private boolean isShftingDataOk() {
        if (this.count == 0) {
            showDialog1("Select a record");
            return false;
        }
        if (this.dVoterStatusType.equals("H") || this.dVoterStatusType.equals("Y") || this.dVoterStatusType.equals("1")) {
            showDialog1("The EPIC is already marked as D-Voter hence you can't fill this form");
            return false;
        }
        if (!this.underJo.equalsIgnoreCase("1")) {
            return true;
        }
        showDialog1("The applicant is under Adjudication.");
        return false;
    }

    private void openFragment1(Fragment fragment, String selectedFragment) {
        String str;
        String str2;
        String str3 = this.pe[8].equals("null") ? "" : this.pe[8];
        String str4 = this.pe[4].equals("null") ? "" : this.pe[4];
        String str5 = this.pe[5].equals("null") ? "" : this.pe[5];
        String str6 = this.pe[6].equals("null") ? "" : this.pe[6];
        String str7 = this.pe[2].equals("null") ? "" : this.pe[2];
        String str8 = this.pe[7].equals("null") ? "" : this.pe[7];
        String str9 = this.pe[14].equals("null") ? "" : this.pe[14];
        String str10 = this.pe[11].equals("null") ? "" : this.pe[11];
        String strSubstring = this.pe[9].equals("null") ? "" : this.pe[9];
        if (strSubstring.contains("+91")) {
            strSubstring = strSubstring.substring(3);
        }
        String str11 = this.pe[10].equals("null") ? "" : this.pe[10];
        if (this.pe[1].equals("null")) {
            str = "";
            str2 = str;
        } else {
            str = this.pe[1];
            str2 = "";
        }
        String str12 = this.pe[12].equals("null") ? str2 : this.pe[12];
        String str13 = this.pe[13].equals("null") ? str2 : this.pe[13];
        String str14 = this.pe[15].equals("null") ? str2 : this.pe[15];
        String str15 = this.pe[16].equals("null") ? str2 : this.pe[16];
        String str16 = this.pe[17].equals("null") ? str2 : this.pe[17];
        String str17 = this.pe[18].equals("null") ? str2 : this.pe[18];
        String str18 = (this.pe[19].equals("null") && this.pe[22].equals("null") && this.pe[23].equals("null")) ? str2 : this.pe[19] + this.pe[22] + this.pe[23];
        String str19 = this.pe[20].equals("null") ? str2 : this.pe[20];
        String str20 = this.pe[21].equals("null") ? str2 : this.pe[21];
        if (this.sectionFlag.equals("2")) {
            this.pe[25] = this.selectedSection.split("-")[0].trim();
        }
        Bundle bundle = new Bundle();
        bundle.putString("Flag", "NEW FORM");
        bundle.putString("0", str3);
        bundle.putString("1", str4);
        bundle.putString("2", str5);
        bundle.putString("3", str6);
        bundle.putString("4", str7);
        bundle.putString("5", str8 + StringUtils.SPACE + str9);
        bundle.putString("6", str10);
        bundle.putString("7", strSubstring);
        bundle.putString("8", str11);
        bundle.putString("9", this.selectedEntry);
        bundle.putString("10", this.appfor);
        bundle.putString("11", this.partno);
        bundle.putString("12", this.serialno);
        bundle.putString("13", str);
        bundle.putString("14", str12);
        bundle.putString("15", str13);
        bundle.putString("16", this.asseblytype);
        bundle.putString("17", str14);
        bundle.putString("18", str15);
        bundle.putString("19", str16);
        bundle.putString("20", str17);
        bundle.putString("21", str18);
        bundle.putString("22", str19);
        bundle.putString("23", str20);
        bundle.putString("24", str8);
        bundle.putString("25", str9);
        bundle.putString("26", this.pe[19]);
        bundle.putString("27", this.pe[22]);
        bundle.putString("28", this.pe[23]);
        bundle.putString("29", this.pe[24]);
        bundle.putString("30", "NO");
        bundle.putString("31", this.pe[25]);
        bundle.putString("32", this.pe[0]);
        bundle.putString("33", this.pe[1]);
        bundle.putString("34", this.pe[2]);
        bundle.putString("35", this.pe[3]);
        bundle.putString("36", this.shiftingImage);
        bundle.putString("37", this.pe[26]);
        bundle.putString("38", this.position);
        bundle.putString("39", this.pe[27]);
        bundle.putString("relationType", this.pe[28]);
        bundle.putBoolean("isOtherState", this.isOtherState);
        bundle.putBoolean("isdeclarationEnabled", this.isdeclarationEnabled);
        bundle.putString("penameregionalFirst", this.penameregionalFirst);
        bundle.putString("penameregionalLast", this.penameregionalLast);
        if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("selectPhoto")) {
            bundle.putString("epic", this.epicNo);
            bundle.putString("epicId", this.epicId);
            bundle.putString("efPhoto", this.efPhotoFile);
            bundle.putString("efbase64image", this.efbase64image);
            bundle.putString("flag", this.flag);
            bundle.putString("category", this.category);
        }
        if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("newvoter")) {
            bundle.putString("epic", this.epicNo);
            bundle.putString("epicId", this.epicId);
            bundle.putString("flag", this.flag);
            bundle.putString("category", this.category);
        }
        String json = new Gson().toJson(this.form8epicDetailsList);
        this.epicdetails = json;
        bundle.putString("epicDetails", json);
        bundle.putString("radioPosition", this.position);
        bundle.putString("module", "SelectApplicant");
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

    private void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public boolean isValideEpicSIRState(String stateCode) {
        return stateCode.equalsIgnoreCase("U01") || stateCode.equalsIgnoreCase("S05") || stateCode.equalsIgnoreCase("U07") || stateCode.equalsIgnoreCase("S26") || stateCode.equalsIgnoreCase("S06") || stateCode.equalsIgnoreCase("S11") || stateCode.equalsIgnoreCase("S12") || stateCode.equalsIgnoreCase("S24") || stateCode.equalsIgnoreCase("S20") || stateCode.equalsIgnoreCase("S25") || stateCode.equalsIgnoreCase("S22") || stateCode.equalsIgnoreCase("U06");
    }

    public boolean isValideEpic19SIRState(String stateCode) {
        return stateCode.equalsIgnoreCase("S01") || stateCode.equalsIgnoreCase("S02") || stateCode.equalsIgnoreCase("S07") || stateCode.equalsIgnoreCase("S10") || stateCode.equalsIgnoreCase("S13") || stateCode.equalsIgnoreCase("S14") || stateCode.equalsIgnoreCase("S15") || stateCode.equalsIgnoreCase("S16") || stateCode.equalsIgnoreCase("S17") || stateCode.equalsIgnoreCase("S18") || stateCode.equalsIgnoreCase("S19") || stateCode.equalsIgnoreCase("U21") || stateCode.equalsIgnoreCase("S23") || stateCode.equalsIgnoreCase("U27") || stateCode.equalsIgnoreCase("S28") || stateCode.equalsIgnoreCase("S29") || stateCode.equalsIgnoreCase("U02") || stateCode.equalsIgnoreCase("U03") || stateCode.equalsIgnoreCase("U05");
    }

    public void radioButtonSelectedDetails(int position) {
        this.count++;
        this.dVoterStatusType = this.form8epicDetailsList.get(position).getdVoterStatusType();
        this.underJo = this.form8epicDetailsList.get(position).getUnderJo();
        String str = this.dVoterStatusType;
        if (str == null || str.equals("null")) {
            this.dVoterStatusType = "";
        }
        this.pe[0] = this.form8epicDetailsList.get(position).getPartNumber();
        this.pe[1] = this.form8epicDetailsList.get(position).getStateCode();
        this.pe[2] = this.form8epicDetailsList.get(position).getAcNumber();
        this.pe[3] = this.form8epicDetailsList.get(position).getPartSerialNumber();
        this.pe[4] = this.form8epicDetailsList.get(position).getStateName();
        this.pe[5] = this.form8epicDetailsList.get(position).getDistrictName();
        this.pe[6] = this.form8epicDetailsList.get(position).getAssemblyName();
        this.pe[7] = this.form8epicDetailsList.get(position).getApplicantFirstname();
        this.pe[14] = this.form8epicDetailsList.get(position).getApplicantLastname();
        this.pe[8] = this.form8epicDetailsList.get(position).getEpicNumber();
        this.pe[9] = this.form8epicDetailsList.get(position).getMobileNumber();
        this.pe[10] = this.form8epicDetailsList.get(position).getEmailId();
        String[] strArr = this.pe;
        strArr[11] = StringUtils.SPACE;
        strArr[12] = this.form8epicDetailsList.get(position).getDistrictCode();
        this.pe[13] = this.form8epicDetailsList.get(position).getGender();
        this.pe[15] = this.form8epicDetailsList.get(position).getRelationFirstName() + StringUtils.SPACE + this.form8epicDetailsList.get(position).getRelationSurname();
        this.pe[16] = this.form8epicDetailsList.get(position).getRelationNameL1();
        this.pe[17] = this.form8epicDetailsList.get(position).getGenderL1();
        this.pe[18] = this.form8epicDetailsList.get(position).getDob();
        this.pe[19] = this.form8epicDetailsList.get(position).getHouseNumber();
        this.pe[22] = this.form8epicDetailsList.get(position).getLocalityStreet();
        this.pe[23] = this.form8epicDetailsList.get(position).getTownVillage();
        this.pe[20] = this.form8epicDetailsList.get(position).getHouseNumberL1() + StringUtils.SPACE + this.form8epicDetailsList.get(position).getLocalityStreetL1() + StringUtils.SPACE + this.form8epicDetailsList.get(position).getTownVillageL1() + StringUtils.SPACE + this.form8epicDetailsList.get(position).getTehsilL1();
        this.pe[21] = this.form8epicDetailsList.get(position).getApplicantNameL1();
        this.pe[24] = this.form8epicDetailsList.get(position).getAge();
        this.pe[25] = this.form8epicDetailsList.get(position).getSectionNo();
        this.pe[26] = this.form8epicDetailsList.get(position).getRelationType();
        this.pe[27] = this.form8epicDetailsList.get(position).getHouseNumberL1();
        this.penameregionalFirst = this.form8epicDetailsList.get(position).getPenameregionalFirst();
        this.penameregionalLast = this.form8epicDetailsList.get(position).getPenameregionalLast();
        this.shiftingImage = this.form8epicDetailsList.get(position).getShiftingImage();
        this.position = String.valueOf(position);
    }
}
