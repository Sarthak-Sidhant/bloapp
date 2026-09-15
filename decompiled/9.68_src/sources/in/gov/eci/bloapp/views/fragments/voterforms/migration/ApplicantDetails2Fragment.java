package in.gov.eci.bloapp.views.fragments.voterforms.migration;

import android.os.Bundle;
import android.text.TextUtils;
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
import org.apache.commons.lang3.StringUtils;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class ApplicantDetails2Fragment extends Fragment {
    private String Correction;
    BloFragmentApplicantDetails2Binding binding;
    Retrofit.Builder builder;
    private String dVoterStatusType;
    private String epicdetails;
    private ArrayList<form8EpicDetailsModel> form8epicDetailsList;
    int position;
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
        this.position = 0;
        this.userClient = (UserClient) retrofitBuild.create(UserClient.class);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentApplicantDetails2Binding.inflate(inflater);
        this.form8epicDetailsList = new ArrayList<>();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.epicdetails = arguments.getString("epicDetails");
        }
        this.epicdetailsArray = new JsonParser().parse(this.epicdetails);
        int i = 0;
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
            String str = (strReplace9 == null || strReplace9.equals("null")) ? "" : strReplace9;
            String strReplace10 = String.valueOf(jsonObject.get("applicantLastName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String str2 = (strReplace10 == null || strReplace10.equals("null")) ? "" : strReplace10;
            this.form8epicDetailsList.add(new form8EpicDetailsModel(strReplace, strReplace2, strReplace3, strReplace4, strReplace5, strReplace6, strReplace7, strReplace8, str, str2, String.valueOf(jsonObject.get("epicNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("mobileNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get(Constants.EMAIL_ID)).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("districtCd")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationLName")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "") + StringUtils.SPACE + String.valueOf(jsonObject.get("relationLNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("genderL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("applicantFirstNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "") + StringUtils.SPACE + String.valueOf(jsonObject.get("applicantLastNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("sectionNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("photo")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("dob")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("houseNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("houseNumberL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("localityStreet")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("localityStreetL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("townVillage")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("townVillageL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("tehsil")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("tehsilL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationType")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("applicantFirstNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("applicantLastNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("underJo")).replace(RegexMatcher.JSON_STRING_REGEX, "")));
            i++;
            arguments = arguments;
        }
        Bundle bundle = arguments;
        if (!TextUtils.isEmpty(bundle.getString("Correction")) && bundle.getString("Correction").equals("Y")) {
            this.Correction = "Y";
            ObjecteeDetails(this.position);
        }
        initRecyclerViewAdapter();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ObjecteeDetails(int position) {
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
        HashMap map = new HashMap();
        map.put("state", this.form8epicDetailsList.get(position).getStateCode());
        map.put("assembly", this.form8epicDetailsList.get(position).getAssemblyName());
        map.put("assemblyNumber", this.form8epicDetailsList.get(position).getAcNumber());
        map.put("epicNumber", this.form8epicDetailsList.get(position).getEpicNumber());
        map.put("partNumber", this.form8epicDetailsList.get(position).getPartNumber());
        map.put("dvoterStatusType", this.form8epicDetailsList.get(position).getdVoterStatusType());
        map.put("detailsArray", this.pe);
        map.put("position", Integer.valueOf(position));
        map.put("underJo", this.form8epicDetailsList.get(position).getUnderJo());
        SharedPref.getInstance(requireContext()).setApplicantEpicDetails(new Gson().toJson(map));
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
            if (!TextUtils.isEmpty(ApplicantDetails2Fragment.this.Correction) && ApplicantDetails2Fragment.this.Correction.equals("Y")) {
                ((BloSelectApplicantLayoutBinding) holder.binding).radioButton.setChecked(true);
            }
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
            ApplicantDetails2Fragment.this.ObjecteeDetails(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(RecyclerViewHolder recyclerViewHolder, int i, View view) {
            ((BloSelectApplicantLayoutBinding) recyclerViewHolder.binding).radioButton.setChecked(true);
            ApplicantDetails2Fragment applicantDetails2Fragment = ApplicantDetails2Fragment.this;
            applicantDetails2Fragment.dVoterStatusType = ((form8EpicDetailsModel) applicantDetails2Fragment.form8epicDetailsList.get(i)).getdVoterStatusType();
            if (ApplicantDetails2Fragment.this.dVoterStatusType == null || ApplicantDetails2Fragment.this.dVoterStatusType.equals("null")) {
                ApplicantDetails2Fragment.this.dVoterStatusType = "";
            }
            ApplicantDetails2Fragment.this.ObjecteeDetails(i);
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
