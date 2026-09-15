package in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentApplicantRecyclerViewForm7Binding;
import in.gov.eci.bloapp.databinding.BloNameRvItemBinding;
import in.gov.eci.bloapp.model.app_model.EpicRecylerViewDataModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.simple.JSONArray;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class ApplicantRecyclerViewForm7 extends Fragment {
    private static final String ALERT = "Alert";
    String acNo;
    private GenericRecyclerView adapter;
    AlertDialog alertDialog;
    JSONArray allNames;
    private List<EpicRecylerViewDataModel> allnamesList;
    String applicantEpicDetailsArray;
    String assembly;
    String assemblyString;
    String assemblyno;
    String atknBand;
    private BloFragmentApplicantRecyclerViewForm7Binding binding;
    Retrofit.Builder builder;
    private final Bundle bundleViewPager;
    String dbfetchepic;
    String dbfetchepic2;
    String deletionobjection;
    String districtCdOfPersonToBeDeleted;
    String districtCdString;
    String districtCode;
    String districtString;
    String districtfill;
    String dvoterStatusType;
    String dvoterStatusTypeString;
    String epicNumberString;
    String firstname;
    String firstnamefill;
    String lastname;
    String partNo;
    String partNumberString;
    String request;
    Retrofit retrofit;
    String rtknBnd;
    String serialNumberOfPersonToBeDeleted;
    String stateCode;
    String stateString;
    String statefill;
    String subRequest;
    String surnamefill;
    UserClient userClient;
    CommomUtility commonUtilClass = new CommomUtility();
    RadioButton lastCheckedRB = null;
    String epicno = "";
    String partfill = "";
    JSONArray payloadnames = null;
    String token = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    CommomUtility commomUtility = new CommomUtility();

    public ApplicantRecyclerViewForm7(Bundle bundleViewPager) {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        Retrofit retrofitBuild = builderClient.build();
        this.retrofit = retrofitBuild;
        this.userClient = (UserClient) retrofitBuild.create(UserClient.class);
        this.allNames = null;
        this.deletionobjection = "Deletion Objection";
        this.dvoterStatusType = "";
        this.dvoterStatusTypeString = "dvoterStatusType";
        this.stateString = "state";
        this.districtString = "district";
        this.assemblyString = "assembly";
        this.epicNumberString = "epicNumber";
        this.districtCdString = "districtCd";
        this.partNumberString = "partNumber";
        this.bundleViewPager = bundleViewPager;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentApplicantRecyclerViewForm7Binding.inflate(getLayoutInflater());
        this.allnamesList = new ArrayList();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.alertDialog.show();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.acNo = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.atknBand = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtknBnd = SharedPref.getInstance(requireContext()).getRtknBnd();
        Logger.d("token_Device_comp", this.token);
        Bundle bundle = this.bundleViewPager;
        if (bundle != null) {
            String string = bundle.getString("request");
            this.request = string;
            this.request = nullChecker(string);
            String string2 = this.bundleViewPager.getString("subRequest");
            this.subRequest = string2;
            this.subRequest = nullChecker(string2);
            String string3 = this.bundleViewPager.getString("voterId");
            this.dbfetchepic = string3;
            this.dbfetchepic = nullChecker(string3);
            String string4 = this.bundleViewPager.getString("voterId2");
            this.dbfetchepic2 = string4;
            this.dbfetchepic2 = nullChecker(string4);
            String string5 = this.bundleViewPager.getString("firstnamefromdb");
            this.firstname = string5;
            this.firstname = nullChecker(string5);
            String string6 = this.bundleViewPager.getString("lastnamefromdb");
            this.lastname = string6;
            this.lastname = nullChecker(string6);
            String string7 = this.bundleViewPager.getString(this.stateString);
            this.statefill = string7;
            this.statefill = nullChecker(string7);
            String string8 = this.bundleViewPager.getString(this.districtString);
            this.districtfill = string8;
            this.districtfill = nullChecker(string8);
            String string9 = this.bundleViewPager.getString(this.assemblyString);
            this.assembly = string9;
            this.assembly = nullChecker(string9);
            String string10 = this.bundleViewPager.getString("assemblyNo");
            this.assemblyno = string10;
            this.assemblyno = nullChecker(string10);
            String string11 = this.bundleViewPager.getString("districtCdOfPersonToBeDeleted");
            this.districtCdOfPersonToBeDeleted = string11;
            this.districtCdOfPersonToBeDeleted = nullChecker(string11);
            this.applicantEpicDetailsArray = this.bundleViewPager.getString("applicantEpicDetailsArray");
        }
        this.allNames = getByEpicForForm((JsonArray) new JsonParser().parse(this.applicantEpicDetailsArray));
        return this.binding.getRoot();
    }

    private String nullChecker(String bundleObject) {
        return (Objects.equals(bundleObject, null) || bundleObject.equals("null")) ? "" : bundleObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String nullCheckerRecycler(String object) {
        return (object == null || object.equals("null") || object.isEmpty()) ? "" : object;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ApplicantRecyclerViewForm7$1, reason: invalid class name */
    class AnonymousClass1 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass1() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloNameRvItemBinding.inflate(ApplicantRecyclerViewForm7.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
            String str;
            ((BloNameRvItemBinding) holder.binding).epiclayout.setVisibility(0);
            String state = ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(position)).getState();
            String assembly = ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(position)).getAssembly();
            String partNumber = ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(position)).getPartNumber();
            String serialNumber = ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(position)).getSerialNumber();
            String name = ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(position)).getName();
            String surname = ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(position)).getSurname();
            String relativeName = ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(position)).getRelativeName();
            String relativeSurname = ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(position)).getRelativeSurname();
            String gender = ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(position)).getGender();
            String strNullCheckerRecycler = ApplicantRecyclerViewForm7.this.nullCheckerRecycler(state);
            String strNullCheckerRecycler2 = ApplicantRecyclerViewForm7.this.nullCheckerRecycler(assembly);
            String strNullCheckerRecycler3 = ApplicantRecyclerViewForm7.this.nullCheckerRecycler(name);
            String strNullCheckerRecycler4 = ApplicantRecyclerViewForm7.this.nullCheckerRecycler(surname);
            String strNullCheckerRecycler5 = ApplicantRecyclerViewForm7.this.nullCheckerRecycler(partNumber);
            String strNullCheckerRecycler6 = ApplicantRecyclerViewForm7.this.nullCheckerRecycler(serialNumber);
            String strNullCheckerRecycler7 = ApplicantRecyclerViewForm7.this.nullCheckerRecycler(relativeName);
            String strNullCheckerRecycler8 = ApplicantRecyclerViewForm7.this.nullCheckerRecycler(relativeSurname);
            if (gender == null || gender.equals("null") || gender.isEmpty()) {
                str = "";
            } else if (gender.equals("M")) {
                str = "Male";
            } else if (gender.equals("F")) {
                str = "Female";
            } else {
                str = "Third Gender";
            }
            ((BloNameRvItemBinding) holder.binding).state.setText(strNullCheckerRecycler);
            ((BloNameRvItemBinding) holder.binding).ac.setText(strNullCheckerRecycler2);
            ((BloNameRvItemBinding) holder.binding).partNumber.setText(strNullCheckerRecycler5);
            ((BloNameRvItemBinding) holder.binding).serialNumber.setText(strNullCheckerRecycler6);
            ((BloNameRvItemBinding) holder.binding).applicantName.setText(strNullCheckerRecycler3);
            ((BloNameRvItemBinding) holder.binding).applicantSurname.setText(strNullCheckerRecycler4);
            ((BloNameRvItemBinding) holder.binding).relativeName.setText(strNullCheckerRecycler7);
            ((BloNameRvItemBinding) holder.binding).relativeSurname.setText(strNullCheckerRecycler8);
            ((BloNameRvItemBinding) holder.binding).gender.setText(str);
            ((BloNameRvItemBinding) holder.binding).applicantNameRb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ApplicantRecyclerViewForm7$1$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f$0.lambda$onBindViewHolder$0(position, compoundButton, z);
                }
            });
            ((BloNameRvItemBinding) holder.binding).epiclayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ApplicantRecyclerViewForm7$1$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(holder, position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, CompoundButton compoundButton, boolean z) {
            RadioButton radioButton = (RadioButton) compoundButton;
            if (ApplicantRecyclerViewForm7.this.lastCheckedRB != null) {
                ApplicantRecyclerViewForm7.this.lastCheckedRB.setChecked(false);
            }
            ApplicantRecyclerViewForm7.this.lastCheckedRB = radioButton;
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm7 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm7.epicno = ((EpicRecylerViewDataModel) applicantRecyclerViewForm7.allnamesList.get(i)).epic;
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm8 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm8.firstnamefill = ((EpicRecylerViewDataModel) applicantRecyclerViewForm8.allnamesList.get(i)).getName();
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm9 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm9.surnamefill = ((EpicRecylerViewDataModel) applicantRecyclerViewForm9.allnamesList.get(i)).getSurname();
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm10 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm10.serialNumberOfPersonToBeDeleted = ((EpicRecylerViewDataModel) applicantRecyclerViewForm10.allnamesList.get(i)).getSerialNumber();
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm11 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm11.partfill = ((EpicRecylerViewDataModel) applicantRecyclerViewForm11.allnamesList.get(i)).getPartNumber();
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm12 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm12.districtCdOfPersonToBeDeleted = ((EpicRecylerViewDataModel) applicantRecyclerViewForm12.allnamesList.get(i)).getDistrictCd();
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm13 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm13.dvoterStatusType = ((EpicRecylerViewDataModel) applicantRecyclerViewForm13.allnamesList.get(i)).getdVoterStatusType();
            HashMap map = new HashMap();
            map.put(ApplicantRecyclerViewForm7.this.stateString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getState());
            map.put(ApplicantRecyclerViewForm7.this.districtString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getDistrict());
            map.put(ApplicantRecyclerViewForm7.this.assemblyString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getAssembly());
            map.put("assemblyNumber", ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getAssemblyNumber());
            map.put(ApplicantRecyclerViewForm7.this.epicNumberString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).epic);
            map.put(Constants.FIRST_NAME, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getName());
            map.put("surname", ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getSurname());
            map.put("serialNumber", ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getSerialNumber());
            map.put(ApplicantRecyclerViewForm7.this.partNumberString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getPartNumber());
            map.put(ApplicantRecyclerViewForm7.this.districtCdString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getDistrictCd());
            map.put(ApplicantRecyclerViewForm7.this.dvoterStatusTypeString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getdVoterStatusType());
            map.put("underJo", ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getUnderJo());
            SharedPref.getInstance(ApplicantRecyclerViewForm7.this.requireContext()).setApplicantEpicDetails(new Gson().toJson(map));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(RecyclerViewHolder recyclerViewHolder, int i, View view) {
            ((BloNameRvItemBinding) recyclerViewHolder.binding).applicantNameRb2.setChecked(true);
            HashMap map = new HashMap();
            map.put(ApplicantRecyclerViewForm7.this.stateString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getState());
            map.put(ApplicantRecyclerViewForm7.this.districtString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getDistrict());
            map.put(ApplicantRecyclerViewForm7.this.assemblyString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getAssembly());
            map.put("assemblyNumber", ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getAssemblyNumber());
            map.put(ApplicantRecyclerViewForm7.this.epicNumberString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).epic);
            map.put(Constants.FIRST_NAME, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getName());
            map.put("surname", ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getSurname());
            map.put("serialNumber", ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getSerialNumber());
            map.put(ApplicantRecyclerViewForm7.this.partNumberString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getPartNumber());
            map.put(ApplicantRecyclerViewForm7.this.districtCdString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getDistrictCd());
            map.put(ApplicantRecyclerViewForm7.this.dvoterStatusTypeString, ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getdVoterStatusType());
            map.put("underJo", ((EpicRecylerViewDataModel) ApplicantRecyclerViewForm7.this.allnamesList.get(i)).getUnderJo());
            SharedPref.getInstance(ApplicantRecyclerViewForm7.this.requireContext()).setApplicantEpicDetails(new Gson().toJson(map));
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm7 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm7.epicno = ((EpicRecylerViewDataModel) applicantRecyclerViewForm7.allnamesList.get(i)).epic;
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm8 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm8.firstnamefill = ((EpicRecylerViewDataModel) applicantRecyclerViewForm8.allnamesList.get(i)).getName();
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm9 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm9.surnamefill = ((EpicRecylerViewDataModel) applicantRecyclerViewForm9.allnamesList.get(i)).getSurname();
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm10 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm10.serialNumberOfPersonToBeDeleted = ((EpicRecylerViewDataModel) applicantRecyclerViewForm10.allnamesList.get(i)).getSerialNumber();
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm11 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm11.partfill = ((EpicRecylerViewDataModel) applicantRecyclerViewForm11.allnamesList.get(i)).getPartNumber();
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm12 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm12.districtCdOfPersonToBeDeleted = ((EpicRecylerViewDataModel) applicantRecyclerViewForm12.allnamesList.get(i)).getDistrictCd();
            ApplicantRecyclerViewForm7 applicantRecyclerViewForm13 = ApplicantRecyclerViewForm7.this;
            applicantRecyclerViewForm13.dvoterStatusType = ((EpicRecylerViewDataModel) applicantRecyclerViewForm13.allnamesList.get(i)).getdVoterStatusType();
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return ApplicantRecyclerViewForm7.this.allnamesList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass1());
        this.binding.nameRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.nameRv.setAdapter(this.adapter);
    }

    public JSONArray getByEpicForForm(JsonArray applicantEpicDetailsArray) {
        Logger.d(this.deletionobjection, "in getForm7ByEpic..............................");
        for (int i = 0; i < applicantEpicDetailsArray.size(); i++) {
            JsonObject jsonObject = applicantEpicDetailsArray.get(i).get("content");
            String strReplace = String.valueOf(jsonObject.get("stateName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace2 = String.valueOf(jsonObject.get("districtValue")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace3 = String.valueOf(jsonObject.get("asmblyName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace4 = String.valueOf(jsonObject.get("acNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace5 = String.valueOf(jsonObject.get(this.partNumberString)).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace6 = String.valueOf(jsonObject.get("partSerialNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace7 = String.valueOf(jsonObject.get("applicantFirstName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace8 = String.valueOf(jsonObject.get("applicantLastName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace9 = String.valueOf(jsonObject.get(this.epicNumberString)).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace10 = String.valueOf(jsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace11 = String.valueOf(jsonObject.get("relationLName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace12 = String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace13 = String.valueOf(jsonObject.get(this.districtCdString)).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace14 = String.valueOf(jsonObject.get(this.dvoterStatusTypeString)).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace15 = String.valueOf(jsonObject.get("underJo")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            if (this.acNo.equals(strReplace4)) {
                this.allnamesList.add(new EpicRecylerViewDataModel(strReplace, strReplace2, "", strReplace13, strReplace3, strReplace4, strReplace7, strReplace8, strReplace9, strReplace10, strReplace11, strReplace12, strReplace5, strReplace6, strReplace14, "", "", null, strReplace15));
            }
        }
        initRecyclerViewAdapter();
        this.binding.nameRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.nameRv.setAdapter(this.adapter);
        this.alertDialog.dismiss();
        return this.payloadnames;
    }

    private void showdialog1(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ApplicantRecyclerViewForm7$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog1$0(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog1$0(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
