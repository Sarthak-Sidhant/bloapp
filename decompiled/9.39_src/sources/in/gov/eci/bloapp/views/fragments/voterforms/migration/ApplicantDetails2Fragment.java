package in.gov.eci.bloapp.views.fragments.voterforms.migration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentApplicantDetails2Binding;
import in.gov.eci.bloapp.databinding.BloSelectApplicantLayoutBinding;
import in.gov.eci.bloapp.model.app_model.form8EpicDetailsModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ApplicantDetails2Fragment extends Fragment {
    BloFragmentApplicantDetails2Binding binding;
    Retrofit.Builder builder;
    private String dVoterStatusType;
    private String epicdetails;
    private ArrayList<form8EpicDetailsModel> form8epicDetailsList;
    Retrofit retrofit;
    BloSelectApplicantLayoutBinding selectApplicantLayoutBinding;
    UserClient userClient;
    JsonArray epicdetailsArray = null;
    private RadioButton lastCheckedRB = null;
    private final String[] pe = new String[50];
    CommomUtility commonUtilClass = new CommomUtility();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();

    public ApplicantDetails2Fragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        Retrofit retrofitBuild = builderClient.build();
        this.retrofit = retrofitBuild;
        this.userClient = (UserClient) retrofitBuild.create(UserClient.class);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentApplicantDetails2Binding.inflate(inflater);
        this.form8epicDetailsList = new ArrayList<>();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.epicdetails = arguments.getString("epicdetails");
        }
        this.epicdetailsArray = new JsonParser().parse(this.epicdetails);
        for (int i = 0; i < this.epicdetailsArray.size(); i++) {
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
            String str = (strReplace9 == null || strReplace9.equals("null")) ? "" : strReplace9;
            String strReplace10 = String.valueOf(jsonObject.get("applicantLastName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String str2 = (strReplace10 == null || strReplace10.equals("null")) ? "" : strReplace10;
            this.form8epicDetailsList.add(new form8EpicDetailsModel(strReplace, strReplace2, strReplace3, strReplace4, strReplace5, strReplace6, strReplace7, strReplace8, str, str2, String.valueOf(jsonObject.get("epicNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("mobileNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get(Constants.EMAIL_ID)).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("districtCd")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationLName")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "") + " " + String.valueOf(jsonObject.get("relationLNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("genderL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("applicantFirstNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "") + " " + String.valueOf(jsonObject.get("applicantLastNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("sectionNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("photo")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("dob")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("houseNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("houseNumberL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("localityStreet")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("localityStreetL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("townVillage")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("townVillageL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("tehsil")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("tehsilL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationType")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("applicantFirstNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("applicantLastNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("underJo")).replace(RegexMatcher.JSON_STRING_REGEX, "")));
        }
        initRecyclerViewAdapter();
        return this.binding.getRoot();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.ApplicantDetails2Fragment$1, reason: invalid class name */
    class AnonymousClass1 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass1() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ApplicantDetails2Fragment applicantDetails2Fragment = ApplicantDetails2Fragment.this;
            applicantDetails2Fragment.selectApplicantLayoutBinding = BloSelectApplicantLayoutBinding.inflate(applicantDetails2Fragment.getLayoutInflater());
            return new RecyclerViewHolder(ApplicantDetails2Fragment.this.selectApplicantLayoutBinding);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
            ((BloSelectApplicantLayoutBinding) holder.binding).stateET.setText(((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(position)).getStateName());
            ((BloSelectApplicantLayoutBinding) holder.binding).partNumberET.setText(((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(position)).getPartNumber());
            ((BloSelectApplicantLayoutBinding) holder.binding).ApplicantNameEt.setText(((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(position)).getApplicantFirstname());
            ((BloSelectApplicantLayoutBinding) holder.binding).relativeNameET.setText(((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(position)).getRelationFirstName());
            ((BloSelectApplicantLayoutBinding) holder.binding).AcEt.setText(((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(position)).getAcNumber());
            ((BloSelectApplicantLayoutBinding) holder.binding).serialNoEt.setText(((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(position)).getPartSerialNumber());
            ((BloSelectApplicantLayoutBinding) holder.binding).ApplicantSurnameEt.setText(((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(position)).getApplicantLastname());
            ((BloSelectApplicantLayoutBinding) holder.binding).relativeSurnameET.setText(((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(position)).getRelationSurname());
            ((BloSelectApplicantLayoutBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.ApplicantDetails2Fragment$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(holder, position, view);
                }
            });
            ((BloSelectApplicantLayoutBinding) holder.binding).radioButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.ApplicantDetails2Fragment$1$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(holder, position, view);
                }
            });
            ((BloSelectApplicantLayoutBinding) holder.binding).radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.ApplicantDetails2Fragment$1$$ExternalSyntheticLambda2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f$0.lambda$onBindViewHolder$2(compoundButton, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(RecyclerViewHolder recyclerViewHolder, int i, View view) {
            ((BloSelectApplicantLayoutBinding) recyclerViewHolder.binding).radioButton.setChecked(true);
            ApplicantDetails2Fragment applicantDetails2Fragment = ApplicantDetails2Fragment.this;
            applicantDetails2Fragment.dVoterStatusType = ((form8EpicDetailsModel) applicantDetails2Fragment.form8epicDetailsList.get(i)).getdVoterStatusType();
            if (ApplicantDetails2Fragment.this.dVoterStatusType == null || ApplicantDetails2Fragment.this.dVoterStatusType.equals("null")) {
                ApplicantDetails2Fragment.this.dVoterStatusType = "";
            }
            ApplicantDetails2Fragment.this.pe[0] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getPartNumber();
            ApplicantDetails2Fragment.this.pe[1] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getStateCode();
            ApplicantDetails2Fragment.this.pe[2] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getAcNumber();
            ApplicantDetails2Fragment.this.pe[3] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getPartSerialNumber();
            ApplicantDetails2Fragment.this.pe[4] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getStateName();
            ApplicantDetails2Fragment.this.pe[5] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getDistrictName();
            ApplicantDetails2Fragment.this.pe[6] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getAssemblyName();
            ApplicantDetails2Fragment.this.pe[7] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getApplicantFirstname();
            ApplicantDetails2Fragment.this.pe[14] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getApplicantLastname();
            ApplicantDetails2Fragment.this.pe[8] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getEpicNumber();
            ApplicantDetails2Fragment.this.pe[9] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getMobileNumber();
            ApplicantDetails2Fragment.this.pe[10] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getEmailId();
            ApplicantDetails2Fragment.this.pe[11] = " ";
            ApplicantDetails2Fragment.this.pe[12] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getDistrictCode();
            ApplicantDetails2Fragment.this.pe[13] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getGender();
            ApplicantDetails2Fragment.this.pe[15] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getRelationFirstName() + " " + ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getRelationSurname();
            ApplicantDetails2Fragment.this.pe[16] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getRelationNameL1();
            ApplicantDetails2Fragment.this.pe[17] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getGenderL1();
            ApplicantDetails2Fragment.this.pe[18] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getDob();
            ApplicantDetails2Fragment.this.pe[19] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getHouseNumber();
            ApplicantDetails2Fragment.this.pe[22] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getLocalityStreet();
            ApplicantDetails2Fragment.this.pe[23] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getTownVillage();
            ApplicantDetails2Fragment.this.pe[20] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getHouseNumberL1() + " " + ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getLocalityStreetL1() + " " + ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getTownVillageL1() + " " + ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getTehsilL1();
            ApplicantDetails2Fragment.this.pe[21] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getApplicantNameL1();
            ApplicantDetails2Fragment.this.pe[24] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getAge();
            ApplicantDetails2Fragment.this.pe[25] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getSectionNo();
            ApplicantDetails2Fragment.this.pe[26] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getRelationType();
            HashMap map = new HashMap();
            map.put("state", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getStateCode());
            map.put("assembly", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getAssemblyName());
            map.put("assemblyNumber", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getAcNumber());
            map.put("epicNumber", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getEpicNumber());
            map.put("partNumber", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getPartNumber());
            map.put("dvoterStatusType", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getdVoterStatusType());
            map.put("detailsArray", ApplicantDetails2Fragment.this.pe);
            map.put("position", Integer.valueOf(i));
            map.put("underJo", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getUnderJo());
            SharedPref.getInstance(ApplicantDetails2Fragment.this.requireContext()).setApplicantEpicDetails(new Gson().toJson(map));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(RecyclerViewHolder recyclerViewHolder, int i, View view) {
            ((BloSelectApplicantLayoutBinding) recyclerViewHolder.binding).radioButton.setChecked(true);
            ApplicantDetails2Fragment applicantDetails2Fragment = ApplicantDetails2Fragment.this;
            applicantDetails2Fragment.dVoterStatusType = ((form8EpicDetailsModel) applicantDetails2Fragment.form8epicDetailsList.get(i)).getdVoterStatusType();
            if (ApplicantDetails2Fragment.this.dVoterStatusType == null || ApplicantDetails2Fragment.this.dVoterStatusType.equals("null")) {
                ApplicantDetails2Fragment.this.dVoterStatusType = "";
            }
            ApplicantDetails2Fragment.this.pe[0] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getPartNumber();
            ApplicantDetails2Fragment.this.pe[1] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getStateCode();
            ApplicantDetails2Fragment.this.pe[2] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getAcNumber();
            ApplicantDetails2Fragment.this.pe[3] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getPartSerialNumber();
            ApplicantDetails2Fragment.this.pe[4] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getStateName();
            ApplicantDetails2Fragment.this.pe[5] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getDistrictName();
            ApplicantDetails2Fragment.this.pe[6] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getAssemblyName();
            ApplicantDetails2Fragment.this.pe[7] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getApplicantFirstname();
            ApplicantDetails2Fragment.this.pe[14] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getApplicantLastname();
            ApplicantDetails2Fragment.this.pe[8] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getEpicNumber();
            ApplicantDetails2Fragment.this.pe[9] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getMobileNumber();
            ApplicantDetails2Fragment.this.pe[10] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getEmailId();
            ApplicantDetails2Fragment.this.pe[11] = " ";
            ApplicantDetails2Fragment.this.pe[12] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getDistrictCode();
            ApplicantDetails2Fragment.this.pe[13] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getGender();
            ApplicantDetails2Fragment.this.pe[15] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getRelationFirstName() + " " + ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getRelationSurname();
            ApplicantDetails2Fragment.this.pe[16] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getRelationNameL1();
            ApplicantDetails2Fragment.this.pe[17] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getGenderL1();
            ApplicantDetails2Fragment.this.pe[18] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getDob();
            ApplicantDetails2Fragment.this.pe[19] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getHouseNumber();
            ApplicantDetails2Fragment.this.pe[22] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getLocalityStreet();
            ApplicantDetails2Fragment.this.pe[23] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getTownVillage();
            ApplicantDetails2Fragment.this.pe[20] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getHouseNumberL1() + " " + ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getLocalityStreetL1() + " " + ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getTownVillageL1() + " " + ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getTehsilL1();
            ApplicantDetails2Fragment.this.pe[21] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getApplicantNameL1();
            ApplicantDetails2Fragment.this.pe[24] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getAge();
            ApplicantDetails2Fragment.this.pe[25] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getSectionNo();
            ApplicantDetails2Fragment.this.pe[26] = ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getRelationType();
            HashMap map = new HashMap();
            map.put("state", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getStateCode());
            map.put("assembly", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getAssemblyName());
            map.put("assemblyNumber", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getAcNumber());
            map.put("epicNumber", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getEpicNumber());
            map.put("partNumber", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getPartNumber());
            map.put("dvoterStatusType", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getdVoterStatusType());
            map.put("detailsArray", ApplicantDetails2Fragment.this.pe);
            map.put("position", Integer.valueOf(i));
            map.put("underJo", ((form8EpicDetailsModel) ApplicantDetails2Fragment.this.form8epicDetailsList.get(i)).getUnderJo());
            SharedPref.getInstance(ApplicantDetails2Fragment.this.requireContext()).setApplicantEpicDetails(new Gson().toJson(map));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(CompoundButton compoundButton, boolean z) {
            RadioButton radioButton = (RadioButton) compoundButton;
            if (ApplicantDetails2Fragment.this.lastCheckedRB != null) {
                ApplicantDetails2Fragment.this.lastCheckedRB.setChecked(false);
            }
            ApplicantDetails2Fragment.this.lastCheckedRB = radioButton;
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return ApplicantDetails2Fragment.this.form8epicDetailsList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        GenericRecyclerView genericRecyclerView = new GenericRecyclerView(new AnonymousClass1());
        this.binding.applicantDetails2.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.applicantDetails2.setAdapter(genericRecyclerView);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
