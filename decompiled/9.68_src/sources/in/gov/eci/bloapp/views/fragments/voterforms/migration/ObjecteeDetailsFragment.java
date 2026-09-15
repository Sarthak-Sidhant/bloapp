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
import in.gov.eci.bloapp.databinding.BloFragmentObjecteeDetailsBinding;
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
public class ObjecteeDetailsFragment extends Fragment {
    private String Correction;
    BloFragmentObjecteeDetailsBinding binding;
    Retrofit.Builder builder;
    private String dVoterStatusType;
    private String epicProceedingdetails;
    private ArrayList<form8EpicDetailsModel> form8epicProceedingDetailsList;
    Retrofit retrofit;
    BloSelectApplicantLayoutBinding selectApplicantLayoutBinding;
    UserClient userClient;
    JsonArray epicProceedingdetailsArray = null;
    private RadioButton lastCheckedRB = null;
    int position = 0;
    CommomUtility commonUtilClass = new CommomUtility();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();

    public ObjecteeDetailsFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        Retrofit retrofitBuild = builderClient.build();
        this.retrofit = retrofitBuild;
        this.userClient = (UserClient) retrofitBuild.create(UserClient.class);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentObjecteeDetailsBinding.inflate(inflater);
        this.form8epicProceedingDetailsList = new ArrayList<>();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.epicProceedingdetails = arguments.getString("epicProceedingDetails");
        }
        this.epicProceedingdetailsArray = new JsonParser().parse(this.epicProceedingdetails);
        int i = 0;
        while (i < this.epicProceedingdetailsArray.size()) {
            JsonObject jsonObject = this.epicProceedingdetailsArray.get(i).getAsJsonObject().get("content");
            this.form8epicProceedingDetailsList.add(new form8EpicDetailsModel(String.valueOf(jsonObject.get("dVoterStatusType")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("partNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("stateCd")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("acNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("partSerialNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("stateName")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("districtValue")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("asmblyName")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("applicantFirstName")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("applicantLastName")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("epicNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("mobileNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get(Constants.EMAIL_ID)).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("districtCd")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationLName")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "") + StringUtils.SPACE + String.valueOf(jsonObject.get("relationLNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("genderL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("applicantFirstNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "") + StringUtils.SPACE + String.valueOf(jsonObject.get("applicantLastNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("age")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("sectionNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("photo")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("dob")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("houseNumber")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("houseNumberL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("localityStreet")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("localityStreetL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("townVillage")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("townVillageL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("tehsil")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("tehsilL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("relationType")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("applicantFirstNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("applicantLastNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(jsonObject.get("underJo")).replace(RegexMatcher.JSON_STRING_REGEX, "")));
            i++;
            arguments = arguments;
        }
        Bundle bundle = arguments;
        initRecyclerViewAdapter();
        if (!TextUtils.isEmpty(bundle.getString("Correction")) && bundle.getString("Correction").equals("Y")) {
            this.Correction = "Y";
            ObjecteeDetails(this.position);
        }
        return this.binding.getRoot();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.ObjecteeDetailsFragment$1, reason: invalid class name */
    class AnonymousClass1 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass1() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ObjecteeDetailsFragment objecteeDetailsFragment = ObjecteeDetailsFragment.this;
            objecteeDetailsFragment.selectApplicantLayoutBinding = BloSelectApplicantLayoutBinding.inflate(objecteeDetailsFragment.getLayoutInflater());
            return new RecyclerViewHolder(ObjecteeDetailsFragment.this.selectApplicantLayoutBinding);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
            ((BloSelectApplicantLayoutBinding) holder.binding).stateET.setText(((form8EpicDetailsModel) ObjecteeDetailsFragment.this.form8epicProceedingDetailsList.get(position)).getStateName());
            ((BloSelectApplicantLayoutBinding) holder.binding).partNumberET.setText(((form8EpicDetailsModel) ObjecteeDetailsFragment.this.form8epicProceedingDetailsList.get(position)).getPartNumber());
            ((BloSelectApplicantLayoutBinding) holder.binding).ApplicantNameEt.setText(((form8EpicDetailsModel) ObjecteeDetailsFragment.this.form8epicProceedingDetailsList.get(position)).getApplicantFirstname());
            ((BloSelectApplicantLayoutBinding) holder.binding).relativeNameET.setText(((form8EpicDetailsModel) ObjecteeDetailsFragment.this.form8epicProceedingDetailsList.get(position)).getRelationFirstName());
            ((BloSelectApplicantLayoutBinding) holder.binding).AcEt.setText(((form8EpicDetailsModel) ObjecteeDetailsFragment.this.form8epicProceedingDetailsList.get(position)).getAcNumber());
            ((BloSelectApplicantLayoutBinding) holder.binding).serialNoEt.setText(((form8EpicDetailsModel) ObjecteeDetailsFragment.this.form8epicProceedingDetailsList.get(position)).getPartSerialNumber());
            ((BloSelectApplicantLayoutBinding) holder.binding).ApplicantSurnameEt.setText(((form8EpicDetailsModel) ObjecteeDetailsFragment.this.form8epicProceedingDetailsList.get(position)).getApplicantLastname());
            ((BloSelectApplicantLayoutBinding) holder.binding).relativeSurnameET.setText(((form8EpicDetailsModel) ObjecteeDetailsFragment.this.form8epicProceedingDetailsList.get(position)).getRelationSurname());
            if (!TextUtils.isEmpty(ObjecteeDetailsFragment.this.Correction) && ObjecteeDetailsFragment.this.Correction.equals("Y")) {
                ((BloSelectApplicantLayoutBinding) holder.binding).radioButton.setChecked(true);
            }
            ((BloSelectApplicantLayoutBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.ObjecteeDetailsFragment$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(holder, position, view);
                }
            });
            ((BloSelectApplicantLayoutBinding) holder.binding).radioButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.ObjecteeDetailsFragment$1$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(holder, position, view);
                }
            });
            ((BloSelectApplicantLayoutBinding) holder.binding).radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.ObjecteeDetailsFragment$1$$ExternalSyntheticLambda2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f$0.lambda$onBindViewHolder$2(compoundButton, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(RecyclerViewHolder recyclerViewHolder, int i, View view) {
            ((BloSelectApplicantLayoutBinding) recyclerViewHolder.binding).radioButton.setChecked(true);
            ObjecteeDetailsFragment objecteeDetailsFragment = ObjecteeDetailsFragment.this;
            objecteeDetailsFragment.dVoterStatusType = ((form8EpicDetailsModel) objecteeDetailsFragment.form8epicProceedingDetailsList.get(i)).getdVoterStatusType();
            if (ObjecteeDetailsFragment.this.dVoterStatusType == null || ObjecteeDetailsFragment.this.dVoterStatusType.equals("null")) {
                ObjecteeDetailsFragment.this.dVoterStatusType = "";
            }
            ObjecteeDetailsFragment.this.ObjecteeDetails(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(RecyclerViewHolder recyclerViewHolder, int i, View view) {
            ((BloSelectApplicantLayoutBinding) recyclerViewHolder.binding).radioButton.setChecked(true);
            ObjecteeDetailsFragment objecteeDetailsFragment = ObjecteeDetailsFragment.this;
            objecteeDetailsFragment.dVoterStatusType = ((form8EpicDetailsModel) objecteeDetailsFragment.form8epicProceedingDetailsList.get(i)).getdVoterStatusType();
            if (ObjecteeDetailsFragment.this.dVoterStatusType == null || ObjecteeDetailsFragment.this.dVoterStatusType.equals("null")) {
                ObjecteeDetailsFragment.this.dVoterStatusType = "";
            }
            ObjecteeDetailsFragment.this.ObjecteeDetails(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(CompoundButton compoundButton, boolean z) {
            RadioButton radioButton = (RadioButton) compoundButton;
            if (ObjecteeDetailsFragment.this.lastCheckedRB != null) {
                ObjecteeDetailsFragment.this.lastCheckedRB.setChecked(false);
            }
            ObjecteeDetailsFragment.this.lastCheckedRB = radioButton;
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return ObjecteeDetailsFragment.this.form8epicProceedingDetailsList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        GenericRecyclerView genericRecyclerView = new GenericRecyclerView(new AnonymousClass1());
        this.binding.objecteeDetails.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.objecteeDetails.setAdapter(genericRecyclerView);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public void ObjecteeDetails(int position) {
        HashMap map = new HashMap();
        map.put("state", this.form8epicProceedingDetailsList.get(position).getStateCode());
        map.put("assembly", this.form8epicProceedingDetailsList.get(position).getAssemblyName());
        map.put("assemblyNumber", this.form8epicProceedingDetailsList.get(position).getAcNumber());
        map.put("epicNumber", this.form8epicProceedingDetailsList.get(position).getEpicNumber());
        map.put("partNumber", this.form8epicProceedingDetailsList.get(position).getPartNumber());
        map.put("dvoterStatusType", this.form8epicProceedingDetailsList.get(position).getdVoterStatusType());
        map.put("PartSerialNumber", this.form8epicProceedingDetailsList.get(position).getPartSerialNumber());
        map.put("stateName", this.form8epicProceedingDetailsList.get(position).getStateName());
        map.put("districtName", this.form8epicProceedingDetailsList.get(position).getDistrictName());
        map.put("applicantFirstName", this.form8epicProceedingDetailsList.get(position).getApplicantFirstname());
        map.put("applicantLastName", this.form8epicProceedingDetailsList.get(position).getApplicantLastname());
        map.put("mobileNumber", this.form8epicProceedingDetailsList.get(position).getMobileNumber());
        map.put(Constants.EMAIL_ID, this.form8epicProceedingDetailsList.get(position).getEmailId());
        map.put("districtCode", this.form8epicProceedingDetailsList.get(position).getDistrictCode());
        map.put("gender", this.form8epicProceedingDetailsList.get(position).getGender());
        map.put("relationName", this.form8epicProceedingDetailsList.get(position).getRelationFirstName() + StringUtils.SPACE + this.form8epicProceedingDetailsList.get(position).getRelationSurname());
        map.put("relationNameL1", this.form8epicProceedingDetailsList.get(position).getRelationNameL1());
        map.put("genderl1", this.form8epicProceedingDetailsList.get(position).getGenderL1());
        map.put("dob", this.form8epicProceedingDetailsList.get(position).getDob());
        map.put("houseNumber", this.form8epicProceedingDetailsList.get(position).getHouseNumber());
        map.put("localityStreet", this.form8epicProceedingDetailsList.get(position).getLocalityStreet());
        map.put("townVillage", this.form8epicProceedingDetailsList.get(position).getTownVillage());
        map.put("houseNumberL1", this.form8epicProceedingDetailsList.get(position).getHouseNumberL1() + StringUtils.SPACE + this.form8epicProceedingDetailsList.get(position).getLocalityStreetL1() + StringUtils.SPACE + this.form8epicProceedingDetailsList.get(position).getTownVillageL1() + StringUtils.SPACE + this.form8epicProceedingDetailsList.get(position).getTehsilL1());
        map.put("applicantNameL1", this.form8epicProceedingDetailsList.get(position).getApplicantNameL1());
        map.put("age", this.form8epicProceedingDetailsList.get(position).getAge());
        map.put("sectioNo", this.form8epicProceedingDetailsList.get(position).getSectionNo());
        map.put("relationtype", this.form8epicProceedingDetailsList.get(position).getRelationType());
        map.put("shiftingImage", this.form8epicProceedingDetailsList.get(position).getShiftingImage());
        map.put("houseNoRegional", this.form8epicProceedingDetailsList.get(position).getHouseNumberL1());
        map.put("position", Integer.valueOf(position));
        map.put("underJo", this.form8epicProceedingDetailsList.get(position).getUnderJo());
        SharedPref.getInstance(requireContext()).setObjecteeEpicDetails(new Gson().toJson(map));
    }
}
