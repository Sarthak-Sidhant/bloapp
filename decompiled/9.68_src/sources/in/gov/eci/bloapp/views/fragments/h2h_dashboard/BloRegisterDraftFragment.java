package in.gov.eci.bloapp.views.fragments.h2h_dashboard;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.databinding.BloFragmentBloRegisterDraftBinding;
import in.gov.eci.bloapp.databinding.BloH2hFilterBinding;
import in.gov.eci.bloapp.databinding.BloRegisterDraftListRvItemBinding;
import in.gov.eci.bloapp.model.ElectroleDeatils.H2HElectorDetailModel;
import in.gov.eci.bloapp.model.ElectroleDeatils.HouseSurveyModel;
import in.gov.eci.bloapp.model.app_model.BloRegisterDraftListModel;
import in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import in.gov.eci.bloapp.views.fragments.h2h.H2HOfflineDraft;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
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
public class BloRegisterDraftFragment extends BaseFragment {
    String aadharNo;
    String acNo;
    GenericRecyclerView adapter;
    String address;
    String addressAttachment;
    String age;
    String alertText;
    String allDetailsVerified;
    String applicantName;
    String applicantNameRegional;
    List<BloRegisterDraftListModel> bloRegisterDraftList;
    Retrofit.Builder builder;
    Date c = Calendar.getInstance().getTime();
    CommomUtility commomUtility;
    String coordinate;
    String[] currencies;
    String dateOfVerification;
    String disabilityType;
    String dob;
    String dobAttachment;
    ElectorDetailsDatabaseHelper electorDetailsDatabaseHelper;
    String email;
    String epicNo;
    String formattedDate;
    BloFragmentBloRegisterDraftBinding fragmentBloRegisterDraftBinding;
    String gender;
    Gson gson;
    BloH2hFilterBinding h2hFilterBinding;
    String houseApplicantFound;
    String houseNo;
    String inserted;
    String isAadharVerified;
    String isAddressRecordSame;
    String isDeaf;
    String isDobRecordSame;
    String isElectorRecordSame;
    String isLocomotive;
    int isMetElector;
    String isPwd;
    String isVisual;
    String localitySreet;
    String misDocument;
    String mobileNo;
    OkHttpClient okHttpClient;
    String otherDisability;
    JSONParser parser;
    String partNo;
    String partSerialNumber;
    String phoneNumberVerified;
    String photo;
    String photographEleIsCorrect;
    String pinCode;
    String pinCodeOld;
    String postOffice;
    String pwdPercentage;
    String relativeName;
    String relativeNameRegional;
    String relativeType;
    String remarks;
    String residingPeriod;
    Retrofit retrofit;
    String sectionName;
    String sectionNameString;
    String sectionNo;
    String sectionNoString;
    ArrayList<String> sectionNolist;
    private String sectionNumber;
    String selectAllString;
    private String selectedSection;
    String stateCode;
    String stateCode1;
    String tag;
    String tehsil;
    SimpleDateFormat todayDate;
    String token;
    String village;

    public BloRegisterDraftFragment() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.getDefault());
        this.todayDate = simpleDateFormat;
        this.formattedDate = simpleDateFormat.format(this.c);
        this.epicNo = "";
        this.tehsil = "";
        this.partSerialNumber = "";
        this.pinCodeOld = "";
        this.applicantName = "";
        this.mobileNo = "";
        this.gender = "";
        this.email = "";
        this.aadharNo = "";
        this.dob = "";
        this.age = "";
        this.relativeName = "";
        this.relativeType = "";
        this.houseNo = "";
        this.village = "";
        this.postOffice = "";
        this.acNo = "";
        this.localitySreet = "";
        this.address = "";
        this.pinCode = "";
        this.partNo = "";
        this.stateCode = "";
        this.coordinate = "";
        this.residingPeriod = "";
        this.houseApplicantFound = "";
        this.isAadharVerified = "";
        this.phoneNumberVerified = "";
        this.inserted = "INSERTED";
        this.isElectorRecordSame = "";
        this.allDetailsVerified = "";
        this.isAddressRecordSame = "";
        this.isDobRecordSame = "";
        this.photographEleIsCorrect = "";
        this.disabilityType = "";
        this.isVisual = "";
        this.sectionNo = "";
        this.isPwd = "";
        this.isDeaf = "";
        this.pwdPercentage = "";
        this.isLocomotive = "";
        this.otherDisability = "";
        this.dateOfVerification = "";
        this.addressAttachment = "";
        this.dobAttachment = "";
        this.misDocument = "";
        this.remarks = "";
        this.sectionName = "";
        this.applicantNameRegional = "";
        this.relativeNameRegional = "";
        this.photo = "";
        this.sectionNolist = new ArrayList<>();
        this.tag = "BloRegisterDraftFragment";
        this.alertText = "Alert";
        this.selectAllString = "Select All";
        this.sectionNameString = "sectionName";
        this.sectionNoString = "sectionNo";
        this.gson = new GsonBuilder().setLenient().create();
        this.token = "";
        this.commomUtility = new CommomUtility();
        this.okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).build();
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.fragmentBloRegisterDraftBinding = BloFragmentBloRegisterDraftBinding.inflate(getLayoutInflater());
        this.electorDetailsDatabaseHelper = ElectorDetailsDatabaseHelper.getDB(requireContext());
        this.bloRegisterDraftList = new ArrayList();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.fragmentBloRegisterDraftBinding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.fragmentBloRegisterDraftBinding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment.1
            public void handleOnBackPressed() {
                BloRegisterDraftFragment.this.openFragment(new H2HDashboardFragment());
            }
        });
        getDraftData();
        this.fragmentBloRegisterDraftBinding.filter.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        return this.fragmentBloRegisterDraftBinding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent(getContext(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        openFragment(new H2HDashboardFragment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        if (!SharedPref.getInstance(requireContext()).getSectionData().equals("")) {
            try {
                this.sectionNolist.clear();
                this.sectionNolist.add("Select Section No. & Name");
                this.sectionNolist.add(this.selectAllString);
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getSectionData());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.size(); i++) {
                    JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                    JsonElement jsonElement = asJsonObject.get(this.sectionNameString);
                    if (jsonElement == null || String.valueOf(jsonElement).equals("null")) {
                        this.sectionNumber = asJsonObject.get(this.sectionNoString).getAsInt() + " - ";
                    } else {
                        this.sectionNumber = asJsonObject.get(this.sectionNoString).getAsInt() + " - " + asJsonObject.get(this.sectionNameString).getAsString();
                    }
                    arrayList.add(this.sectionNumber);
                }
                Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$$ExternalSyntheticLambda3
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return BloRegisterDraftFragment.lambda$onCreateView$2((String) obj, (String) obj2);
                    }
                });
                this.sectionNolist.addAll(arrayList);
            } catch (ParseException e) {
                Logger.d("", e.getMessage());
            }
        }
        showFilter();
    }

    static /* synthetic */ int lambda$onCreateView$2(String str, String str2) {
        return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
    }

    private void showFilter() {
        this.h2hFilterBinding = BloH2hFilterBinding.inflate(getLayoutInflater());
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        dialog.setContentView((View) this.h2hFilterBinding.getRoot());
        dialog.show();
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.sectionNolist);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.h2hFilterBinding.sectionNo.setAdapter((SpinnerAdapter) arrayAdapter);
        this.h2hFilterBinding.sectionNo.setSelection(0);
        this.h2hFilterBinding.sectionNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BloRegisterDraftFragment.this.selectedSection = String.valueOf(parent.getItemAtPosition(position));
                Logger.d(BloRegisterDraftFragment.this.tag, "selectedSection" + BloRegisterDraftFragment.this.selectedSection);
            }
        });
        this.h2hFilterBinding.filterButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showFilter$4(dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFilter$4(Dialog dialog, View view) {
        if (!this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals("Select Section No. & Name")) {
            if (this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals(this.selectAllString)) {
                getDraftData();
                dialog.dismiss();
                return;
            } else {
                String[] strArrSplit = this.h2hFilterBinding.sectionNo.getSelectedItem().toString().split(StringUtils.SPACE);
                this.currencies = strArrSplit;
                fetchElectorDataAsPerSection(strArrSplit[0]);
                dialog.dismiss();
                return;
            }
        }
        showDialog("Please select section number.");
    }

    private void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void fetchElectorDataAsPerSection(String sectionNumber) {
        ArrayList arrayList = (ArrayList) this.electorDetailsDatabaseHelper.h2HElectorDetailModelDao().getH2HAllElectorDetails(SharedPref.getInstance(requireContext()).getPartNumber());
        if (!arrayList.isEmpty()) {
            this.bloRegisterDraftList.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                Logger.d(this.tag, "epicNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getEpicNo());
                Logger.d(this.tag, "applicantName ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getApplicantName());
                Logger.d(this.tag, "mobileNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getMobileNo());
                Logger.d(this.tag, "gender ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getGender());
                Logger.d(this.tag, "email ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getEmail());
                Logger.d(this.tag, "aadharNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAadharNo());
                Logger.d(this.tag, "dob ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getDob());
                Logger.d(this.tag, "age ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAge());
                Logger.d(this.tag, "relativeName ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getRelativeName());
                Logger.d(this.tag, "relativeType ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getRelativeType());
                Logger.d(this.tag, "houseNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getHouseNo());
                Logger.d(this.tag, "village ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getVillage());
                Logger.d(this.tag, "postOffice ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPostOffice());
                Logger.d(this.tag, "acNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAcNo());
                Logger.d(this.tag, "localitySreet ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getLocalitySreet());
                Logger.d(this.tag, "address ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAddress());
                Logger.d(this.tag, "pinCode ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPinCode());
                Logger.d(this.tag, "partNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPartNo());
                Logger.d(this.tag, "stateCode ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getStateCode());
                Logger.d(this.tag, "coordinate ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getCoordinate());
                Logger.d(this.tag, "residingPeriod ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getResidingPeriod());
                Logger.d(this.tag, "houseApplicantFound ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getHouseApplicantFound());
                Logger.d(this.tag, "isAadharVerified ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsAadharVerified());
                Logger.d(this.tag, "isElectorRecordSame ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsElectorRecordSame());
                Logger.d(this.tag, "allDetailsVerified ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAllDetailsVerified());
                Logger.d(this.tag, "isAddressRecordSame ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsAddressRecordSame());
                Logger.d(this.tag, "isDobRecordSame ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsDobRecordSame());
                Logger.d(this.tag, "photographEleIsCorrect ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPhotographEleIsCorrect());
                Logger.d(this.tag, "disabilityType ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getDisabilityType());
                Logger.d(this.tag, "isVisual ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsVisual());
                Logger.d(this.tag, "sectionNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getSectionNo());
                Logger.d(this.tag, "isPwd ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsPwd());
                Logger.d(this.tag, "isDeaf ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsDeaf());
                Logger.d(this.tag, "pwdPercentage ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPwdPercentage());
                Logger.d(this.tag, "isLocomotive ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsLocomotive());
                Logger.d(this.tag, "otherDisability ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getOtherDisability());
                Logger.d(this.tag, "isMetElector ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsMetElector());
                Logger.d(this.tag, "otherDisability ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPhoneNumberVerified());
                Logger.d(this.tag, "dateOfVerification ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getDateOfVerification());
                Logger.d(this.tag, "addressAttachment ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAddressAttachment());
                Logger.d(this.tag, "dobAttachment ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getDobAttachment());
                Logger.d(this.tag, "misDocument ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getMisDocument());
                Logger.d(this.tag, "remarks ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getRemarks());
                Logger.d(this.tag, "partSerialNumber ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPartSerialNumber());
                if (sectionNumber.equals(((H2HElectorDetailModel) arrayList.get(i)).getSectionNo())) {
                    this.bloRegisterDraftList.add(new BloRegisterDraftListModel(((H2HElectorDetailModel) arrayList.get(i)).getEpicNo(), ((H2HElectorDetailModel) arrayList.get(i)).getApplicantName(), ((H2HElectorDetailModel) arrayList.get(i)).getMobileNo(), ((H2HElectorDetailModel) arrayList.get(i)).getGender(), ((H2HElectorDetailModel) arrayList.get(i)).getEmail(), ((H2HElectorDetailModel) arrayList.get(i)).getAadharNo(), ((H2HElectorDetailModel) arrayList.get(i)).getDob(), ((H2HElectorDetailModel) arrayList.get(i)).getAge(), ((H2HElectorDetailModel) arrayList.get(i)).getRelativeName(), ((H2HElectorDetailModel) arrayList.get(i)).getRelativeType(), ((H2HElectorDetailModel) arrayList.get(i)).getHouseNo(), ((H2HElectorDetailModel) arrayList.get(i)).getVillage(), ((H2HElectorDetailModel) arrayList.get(i)).getPostOffice(), ((H2HElectorDetailModel) arrayList.get(i)).getAcNo(), ((H2HElectorDetailModel) arrayList.get(i)).getLocalitySreet(), ((H2HElectorDetailModel) arrayList.get(i)).getAddress(), ((H2HElectorDetailModel) arrayList.get(i)).getPinCode(), ((H2HElectorDetailModel) arrayList.get(i)).getPartNo(), ((H2HElectorDetailModel) arrayList.get(i)).getStateCode(), ((H2HElectorDetailModel) arrayList.get(i)).getCoordinate(), ((H2HElectorDetailModel) arrayList.get(i)).getResidingPeriod(), ((H2HElectorDetailModel) arrayList.get(i)).getHouseApplicantFound(), ((H2HElectorDetailModel) arrayList.get(i)).getIsAadharVerified(), ((H2HElectorDetailModel) arrayList.get(i)).getIsElectorRecordSame(), ((H2HElectorDetailModel) arrayList.get(i)).getAllDetailsVerified(), ((H2HElectorDetailModel) arrayList.get(i)).getIsAddressRecordSame(), ((H2HElectorDetailModel) arrayList.get(i)).getIsDobRecordSame(), ((H2HElectorDetailModel) arrayList.get(i)).getPhotographEleIsCorrect(), ((H2HElectorDetailModel) arrayList.get(i)).getDisabilityType(), ((H2HElectorDetailModel) arrayList.get(i)).getIsVisual(), ((H2HElectorDetailModel) arrayList.get(i)).getSectionNo(), ((H2HElectorDetailModel) arrayList.get(i)).getIsPwd(), ((H2HElectorDetailModel) arrayList.get(i)).getIsDeaf(), ((H2HElectorDetailModel) arrayList.get(i)).getPwdPercentage(), ((H2HElectorDetailModel) arrayList.get(i)).getIsLocomotive(), ((H2HElectorDetailModel) arrayList.get(i)).getOtherDisability(), ((H2HElectorDetailModel) arrayList.get(i)).getIsMetElector(), ((H2HElectorDetailModel) arrayList.get(i)).getPhoneNumberVerified(), ((H2HElectorDetailModel) arrayList.get(i)).getDateOfVerification(), ((H2HElectorDetailModel) arrayList.get(i)).getAddressAttachment(), ((H2HElectorDetailModel) arrayList.get(i)).getDobAttachment(), ((H2HElectorDetailModel) arrayList.get(i)).getMisDocument(), ((H2HElectorDetailModel) arrayList.get(i)).getRemarks(), ((H2HElectorDetailModel) arrayList.get(i)).getSectionName(), ((H2HElectorDetailModel) arrayList.get(i)).getApplicantNameRegional(), ((H2HElectorDetailModel) arrayList.get(i)).getRelativeNameRegional(), ((H2HElectorDetailModel) arrayList.get(i)).getPhoto(), ((H2HElectorDetailModel) arrayList.get(i)).getPartSerialNumber()));
                }
            }
            initRecyclerViewAdapter();
            this.fragmentBloRegisterDraftBinding.bloRegisterListRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
            this.fragmentBloRegisterDraftBinding.bloRegisterListRv.setAdapter(this.adapter);
            return;
        }
        Toast.makeText(getContext(), "Draft entries does not exist.", 0).show();
        openFragment(new H2HDashboardFragment());
    }

    public void getDraftData() {
        ArrayList arrayList = (ArrayList) this.electorDetailsDatabaseHelper.h2HElectorDetailModelDao().getH2HAllElectorDetails(SharedPref.getInstance(requireContext()).getPartNumber());
        if (!arrayList.isEmpty()) {
            this.bloRegisterDraftList.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                Logger.d(this.tag, "epicNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getEpicNo());
                Logger.d(this.tag, "applicantName ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getApplicantName());
                Logger.d(this.tag, "mobileNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getMobileNo());
                Logger.d(this.tag, "gender ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getGender());
                Logger.d(this.tag, "email ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getEmail());
                Logger.d(this.tag, "aadharNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAadharNo());
                Logger.d(this.tag, "dob ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getDob());
                Logger.d(this.tag, "age ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAge());
                Logger.d(this.tag, "relativeName ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getRelativeName());
                Logger.d(this.tag, "relativeType ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getRelativeType());
                Log.d(this.tag, "houseNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getHouseNo());
                Log.d(this.tag, "village ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getVillage());
                Log.d(this.tag, "postOffice ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPostOffice());
                Log.d(this.tag, "acNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAcNo());
                Log.d(this.tag, "localitySreet ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getLocalitySreet());
                Log.d(this.tag, "address ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAddress());
                Log.d(this.tag, "pinCode ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPinCode());
                Log.d(this.tag, "partNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPartNo());
                Log.d(this.tag, "stateCode ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getStateCode());
                Log.d(this.tag, "coordinate ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getCoordinate());
                Log.d(this.tag, "residingPeriod ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getResidingPeriod());
                Log.d(this.tag, "houseApplicantFound ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getHouseApplicantFound());
                Log.d(this.tag, "isAadharVerified ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsAadharVerified());
                Log.d(this.tag, "isElectorRecordSame ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsElectorRecordSame());
                Log.d(this.tag, "allDetailsVerified ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAllDetailsVerified());
                Log.d(this.tag, "isAddressRecordSame ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsAddressRecordSame());
                Log.d(this.tag, "isDobRecordSame ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsDobRecordSame());
                Log.d(this.tag, "photographEleIsCorrect ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPhotographEleIsCorrect());
                Log.d(this.tag, "disabilityType ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getDisabilityType());
                Log.d(this.tag, "isVisual ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsVisual());
                Log.d(this.tag, "sectionNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getSectionNo());
                Log.d(this.tag, "isPwd ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsPwd());
                Log.d(this.tag, "isDeaf ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsDeaf());
                Log.d(this.tag, "pwdPercentage ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPwdPercentage());
                Log.d(this.tag, "isLocomotive ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsLocomotive());
                Log.d(this.tag, "otherDisability ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getOtherDisability());
                Log.d(this.tag, "dateOfVerification ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getDateOfVerification());
                Log.d(this.tag, "isMetElector ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getIsMetElector());
                Log.d(this.tag, "PhoneNumberVerified ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPhoneNumberVerified());
                Log.d(this.tag, "addressAttachment ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getAddressAttachment());
                Log.d(this.tag, "dobAttachment ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getDobAttachment());
                Log.d(this.tag, "misDocument ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getMisDocument());
                Log.d(this.tag, "remarks ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getRemarks());
                Log.d(this.tag, "partSerialNumber ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getPartSerialNumber());
                this.bloRegisterDraftList.add(new BloRegisterDraftListModel(((H2HElectorDetailModel) arrayList.get(i)).getEpicNo(), ((H2HElectorDetailModel) arrayList.get(i)).getApplicantName(), ((H2HElectorDetailModel) arrayList.get(i)).getMobileNo(), ((H2HElectorDetailModel) arrayList.get(i)).getGender(), ((H2HElectorDetailModel) arrayList.get(i)).getEmail(), ((H2HElectorDetailModel) arrayList.get(i)).getAadharNo(), ((H2HElectorDetailModel) arrayList.get(i)).getDob(), ((H2HElectorDetailModel) arrayList.get(i)).getAge(), ((H2HElectorDetailModel) arrayList.get(i)).getRelativeName(), ((H2HElectorDetailModel) arrayList.get(i)).getRelativeType(), ((H2HElectorDetailModel) arrayList.get(i)).getHouseNo(), ((H2HElectorDetailModel) arrayList.get(i)).getVillage(), ((H2HElectorDetailModel) arrayList.get(i)).getPostOffice(), ((H2HElectorDetailModel) arrayList.get(i)).getAcNo(), ((H2HElectorDetailModel) arrayList.get(i)).getLocalitySreet(), ((H2HElectorDetailModel) arrayList.get(i)).getAddress(), ((H2HElectorDetailModel) arrayList.get(i)).getPinCode(), ((H2HElectorDetailModel) arrayList.get(i)).getPartNo(), ((H2HElectorDetailModel) arrayList.get(i)).getStateCode(), ((H2HElectorDetailModel) arrayList.get(i)).getCoordinate(), ((H2HElectorDetailModel) arrayList.get(i)).getResidingPeriod(), ((H2HElectorDetailModel) arrayList.get(i)).getHouseApplicantFound(), ((H2HElectorDetailModel) arrayList.get(i)).getIsAadharVerified(), ((H2HElectorDetailModel) arrayList.get(i)).getIsElectorRecordSame(), ((H2HElectorDetailModel) arrayList.get(i)).getAllDetailsVerified(), ((H2HElectorDetailModel) arrayList.get(i)).getIsAddressRecordSame(), ((H2HElectorDetailModel) arrayList.get(i)).getIsDobRecordSame(), ((H2HElectorDetailModel) arrayList.get(i)).getPhotographEleIsCorrect(), ((H2HElectorDetailModel) arrayList.get(i)).getDisabilityType(), ((H2HElectorDetailModel) arrayList.get(i)).getIsVisual(), ((H2HElectorDetailModel) arrayList.get(i)).getSectionNo(), ((H2HElectorDetailModel) arrayList.get(i)).getIsPwd(), ((H2HElectorDetailModel) arrayList.get(i)).getIsDeaf(), ((H2HElectorDetailModel) arrayList.get(i)).getPwdPercentage(), ((H2HElectorDetailModel) arrayList.get(i)).getIsLocomotive(), ((H2HElectorDetailModel) arrayList.get(i)).getOtherDisability(), ((H2HElectorDetailModel) arrayList.get(i)).getIsMetElector(), ((H2HElectorDetailModel) arrayList.get(i)).getPhoneNumberVerified(), ((H2HElectorDetailModel) arrayList.get(i)).getDateOfVerification(), ((H2HElectorDetailModel) arrayList.get(i)).getAddressAttachment(), ((H2HElectorDetailModel) arrayList.get(i)).getDobAttachment(), ((H2HElectorDetailModel) arrayList.get(i)).getMisDocument(), ((H2HElectorDetailModel) arrayList.get(i)).getRemarks(), ((H2HElectorDetailModel) arrayList.get(i)).getSectionName(), ((H2HElectorDetailModel) arrayList.get(i)).getApplicantNameRegional(), ((H2HElectorDetailModel) arrayList.get(i)).getRelativeNameRegional(), ((H2HElectorDetailModel) arrayList.get(i)).getPhoto(), ((H2HElectorDetailModel) arrayList.get(i)).getPartSerialNumber()));
            }
            initRecyclerViewAdapter();
            this.fragmentBloRegisterDraftBinding.bloRegisterListRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
            this.fragmentBloRegisterDraftBinding.bloRegisterListRv.setAdapter(this.adapter);
            return;
        }
        Toast.makeText(getContext(), "Draft entries does not exist.", 0).show();
        openFragment(new H2HDashboardFragment());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$3, reason: invalid class name */
    class AnonymousClass3 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass3() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloRegisterDraftListRvItemBinding.inflate(BloRegisterDraftFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
            ((BloRegisterDraftListRvItemBinding) holder.binding).serialNo.setText("S. No. " + (position + 1));
            ((BloRegisterDraftListRvItemBinding) holder.binding).applicantNameValue.setText(BloRegisterDraftFragment.this.bloRegisterDraftList.get(position).getApplicantName());
            ((BloRegisterDraftListRvItemBinding) holder.binding).epicNumberValue.setText(BloRegisterDraftFragment.this.bloRegisterDraftList.get(position).getEpicNo());
            ((BloRegisterDraftListRvItemBinding) holder.binding).relativeNameValue.setText(BloRegisterDraftFragment.this.bloRegisterDraftList.get(position).getRelativeName());
            ((BloRegisterDraftListRvItemBinding) holder.binding).sectionNoValue.setText(BloRegisterDraftFragment.this.bloRegisterDraftList.get(position).getSectionName());
            ((BloRegisterDraftListRvItemBinding) holder.binding).ageValue.setText(BloRegisterDraftFragment.this.bloRegisterDraftList.get(position).getAge());
            ((BloRegisterDraftListRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$3$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(position, view);
                }
            });
            ((BloRegisterDraftListRvItemBinding) holder.binding).deletionLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$3$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$3(position, view);
                }
            });
            ((BloRegisterDraftListRvItemBinding) holder.binding).submissionLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$3$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$6(position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, View view) {
            H2HOfflineDraft h2HOfflineDraft = new H2HOfflineDraft();
            Bundle bundle = new Bundle();
            bundle.putString("epicNo", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getEpicNo());
            bundle.putString("applicantName", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getApplicantName());
            bundle.putString("mobileNo", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getMobileNo());
            bundle.putString("gender", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getGender());
            bundle.putString("email", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getEmail());
            bundle.putString("aadharNo", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getAadharNo());
            bundle.putString("dob", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getDob());
            bundle.putString("age", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getAge());
            bundle.putString("relativeName", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getRelativeName());
            bundle.putString("relativeType", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getRelativeType());
            bundle.putString("houseNo", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getHouseNo());
            bundle.putString("village", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getVillage());
            bundle.putString("postOffice", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getPostOffice());
            bundle.putString("acNo", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getAcNo());
            bundle.putString("localitySreet", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getLocalitySreet());
            bundle.putString("address", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getAddress());
            bundle.putString("pinCode", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getPinCode());
            bundle.putString("partNo", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getPartNo());
            bundle.putString("stateCode", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getStateCode());
            BloRegisterDraftFragment bloRegisterDraftFragment = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment.stateCode1 = bloRegisterDraftFragment.bloRegisterDraftList.get(i).getStateCode();
            bundle.putString("coordinate", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getCoordinate());
            bundle.putString("residingPeriod", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getResidingPeriod());
            bundle.putString("houseApplicantFound", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getHouseApplicantFound());
            bundle.putString("isAadharVerified", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getIsAadharVerified());
            bundle.putString("isElectorRecordSame", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getIsElectorRecordSame());
            bundle.putString("allDetailsVerified", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getAllDetailsVerified());
            bundle.putString("isAddressRecordSame", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getIsAddressRecordSame());
            bundle.putString("isDobRecordSame", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getIsDobRecordSame());
            bundle.putString("photographEleIsCorrect", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getPhotographEleIsCorrect());
            bundle.putString("disabilityType", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getDisabilityType());
            bundle.putString("isVisual", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getIsVisual());
            bundle.putString(BloRegisterDraftFragment.this.sectionNoString, BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getSectionNo());
            bundle.putString("isPwd", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getIsPwd());
            bundle.putString("isDeaf", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getIsDeaf());
            bundle.putString("pwdPercentage", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getPwdPercentage());
            bundle.putString("isLocomotive", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getIsLocomotive());
            bundle.putString("otherDisability", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getOtherDisability());
            bundle.putString("dateOfVerification", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getDateOfVerification());
            bundle.putInt("metElector", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getIsMetElector());
            bundle.putString("PhoneNumberVerified", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getPhoneNumberVerified());
            bundle.putString("addressAttachment", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getAddressAttachment());
            bundle.putString("dobAttachment", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getDobAttachment());
            bundle.putString("misDocument", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getMisDocument());
            bundle.putString("remarks", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getRemarks());
            bundle.putString(BloRegisterDraftFragment.this.sectionNameString, BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getSectionName());
            bundle.putString("applicantNameRegional", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getApplicantNameRegional());
            bundle.putString("relativeNameRegional", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getRelativeNameRegional());
            bundle.putString("photo", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getPhoto());
            bundle.putString("partSerialNumber", BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getPartSerialNumber());
            h2HOfflineDraft.setArguments(bundle);
            BloRegisterDraftFragment.this.openFragment(h2HOfflineDraft);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$3(final int i, View view) {
            Logger.d(BloRegisterDraftFragment.this.tag, "Deleting Records for \nApplicant Name : " + BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getApplicantName() + " At Position : " + (i + 1));
            AlertDialog alertDialogCreate = new AlertDialog.Builder(BloRegisterDraftFragment.this.getContext()).setTitle(BloRegisterDraftFragment.this.alertText).setMessage("Do You Want to Delete this Record ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$3$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onBindViewHolder$1(i, dialogInterface, i2);
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$3$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                }
            }).create();
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(int i, DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            BloRegisterDraftFragment.this.electorDetailsDatabaseHelper.h2HElectorDetailModelDao().deleteH2HRecord(BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getEpicNo());
            if (BloRegisterDraftFragment.this.h2hFilterBinding != null) {
                if (BloRegisterDraftFragment.this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals(BloRegisterDraftFragment.this.selectAllString)) {
                    BloRegisterDraftFragment.this.getDraftData();
                    return;
                }
                BloRegisterDraftFragment bloRegisterDraftFragment = BloRegisterDraftFragment.this;
                bloRegisterDraftFragment.currencies = bloRegisterDraftFragment.h2hFilterBinding.sectionNo.getSelectedItem().toString().split(StringUtils.SPACE);
                BloRegisterDraftFragment bloRegisterDraftFragment2 = BloRegisterDraftFragment.this;
                bloRegisterDraftFragment2.fetchElectorDataAsPerSection(bloRegisterDraftFragment2.currencies[0]);
                return;
            }
            BloRegisterDraftFragment.this.getDraftData();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$6(final int i, View view) {
            Logger.d(BloRegisterDraftFragment.this.tag, "Submitting Records for \nApplicant Name : " + BloRegisterDraftFragment.this.bloRegisterDraftList.get(i).getApplicantName() + " At Position : " + (i + 1));
            AlertDialog alertDialogCreate = new AlertDialog.Builder(BloRegisterDraftFragment.this.getContext()).setTitle(BloRegisterDraftFragment.this.alertText).setMessage("Do You Want to Submit this Record ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$3$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onBindViewHolder$4(i, dialogInterface, i2);
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$3$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                }
            }).create();
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$4(int i, DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            BloRegisterDraftFragment bloRegisterDraftFragment = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment.epicNo = bloRegisterDraftFragment.bloRegisterDraftList.get(i).getEpicNo();
            BloRegisterDraftFragment bloRegisterDraftFragment2 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment2.applicantName = bloRegisterDraftFragment2.bloRegisterDraftList.get(i).getApplicantName();
            BloRegisterDraftFragment bloRegisterDraftFragment3 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment3.mobileNo = bloRegisterDraftFragment3.bloRegisterDraftList.get(i).getMobileNo();
            BloRegisterDraftFragment bloRegisterDraftFragment4 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment4.gender = bloRegisterDraftFragment4.bloRegisterDraftList.get(i).getGender();
            BloRegisterDraftFragment bloRegisterDraftFragment5 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment5.email = bloRegisterDraftFragment5.bloRegisterDraftList.get(i).getEmail();
            BloRegisterDraftFragment bloRegisterDraftFragment6 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment6.aadharNo = bloRegisterDraftFragment6.bloRegisterDraftList.get(i).getAadharNo();
            BloRegisterDraftFragment bloRegisterDraftFragment7 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment7.dob = bloRegisterDraftFragment7.bloRegisterDraftList.get(i).getDob();
            BloRegisterDraftFragment bloRegisterDraftFragment8 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment8.age = bloRegisterDraftFragment8.bloRegisterDraftList.get(i).getAge();
            BloRegisterDraftFragment bloRegisterDraftFragment9 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment9.relativeName = bloRegisterDraftFragment9.bloRegisterDraftList.get(i).getRelativeName();
            BloRegisterDraftFragment bloRegisterDraftFragment10 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment10.relativeType = bloRegisterDraftFragment10.bloRegisterDraftList.get(i).getRelativeType();
            BloRegisterDraftFragment bloRegisterDraftFragment11 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment11.houseNo = bloRegisterDraftFragment11.bloRegisterDraftList.get(i).getHouseNo();
            BloRegisterDraftFragment bloRegisterDraftFragment12 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment12.village = bloRegisterDraftFragment12.bloRegisterDraftList.get(i).getVillage();
            BloRegisterDraftFragment bloRegisterDraftFragment13 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment13.postOffice = bloRegisterDraftFragment13.bloRegisterDraftList.get(i).getPostOffice();
            BloRegisterDraftFragment bloRegisterDraftFragment14 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment14.acNo = bloRegisterDraftFragment14.bloRegisterDraftList.get(i).getAcNo();
            BloRegisterDraftFragment bloRegisterDraftFragment15 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment15.localitySreet = bloRegisterDraftFragment15.bloRegisterDraftList.get(i).getLocalitySreet();
            BloRegisterDraftFragment bloRegisterDraftFragment16 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment16.address = bloRegisterDraftFragment16.bloRegisterDraftList.get(i).getAddress();
            BloRegisterDraftFragment bloRegisterDraftFragment17 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment17.pinCodeOld = bloRegisterDraftFragment17.bloRegisterDraftList.get(i).getPinCode();
            if (BloRegisterDraftFragment.this.pinCode != null && !BloRegisterDraftFragment.this.pinCode.equals("")) {
                BloRegisterDraftFragment bloRegisterDraftFragment18 = BloRegisterDraftFragment.this;
                bloRegisterDraftFragment18.pinCode = bloRegisterDraftFragment18.pinCodeOld.substring(0, 6);
                BloRegisterDraftFragment bloRegisterDraftFragment19 = BloRegisterDraftFragment.this;
                bloRegisterDraftFragment19.tehsil = bloRegisterDraftFragment19.pinCodeOld.substring(7);
            }
            BloRegisterDraftFragment bloRegisterDraftFragment20 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment20.partNo = bloRegisterDraftFragment20.bloRegisterDraftList.get(i).getPartNo();
            BloRegisterDraftFragment bloRegisterDraftFragment21 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment21.stateCode = bloRegisterDraftFragment21.bloRegisterDraftList.get(i).getStateCode();
            BloRegisterDraftFragment bloRegisterDraftFragment22 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment22.coordinate = bloRegisterDraftFragment22.bloRegisterDraftList.get(i).getCoordinate();
            BloRegisterDraftFragment bloRegisterDraftFragment23 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment23.residingPeriod = bloRegisterDraftFragment23.bloRegisterDraftList.get(i).getResidingPeriod();
            BloRegisterDraftFragment bloRegisterDraftFragment24 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment24.houseApplicantFound = bloRegisterDraftFragment24.bloRegisterDraftList.get(i).getHouseApplicantFound();
            BloRegisterDraftFragment bloRegisterDraftFragment25 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment25.isAadharVerified = bloRegisterDraftFragment25.bloRegisterDraftList.get(i).getIsAadharVerified();
            BloRegisterDraftFragment bloRegisterDraftFragment26 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment26.isElectorRecordSame = bloRegisterDraftFragment26.bloRegisterDraftList.get(i).getIsElectorRecordSame();
            BloRegisterDraftFragment bloRegisterDraftFragment27 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment27.allDetailsVerified = bloRegisterDraftFragment27.bloRegisterDraftList.get(i).getAllDetailsVerified();
            BloRegisterDraftFragment bloRegisterDraftFragment28 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment28.isAddressRecordSame = bloRegisterDraftFragment28.bloRegisterDraftList.get(i).getIsAddressRecordSame();
            BloRegisterDraftFragment bloRegisterDraftFragment29 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment29.isDobRecordSame = bloRegisterDraftFragment29.bloRegisterDraftList.get(i).getIsDobRecordSame();
            BloRegisterDraftFragment bloRegisterDraftFragment30 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment30.photographEleIsCorrect = bloRegisterDraftFragment30.bloRegisterDraftList.get(i).getPhotographEleIsCorrect();
            BloRegisterDraftFragment bloRegisterDraftFragment31 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment31.disabilityType = bloRegisterDraftFragment31.bloRegisterDraftList.get(i).getDisabilityType();
            BloRegisterDraftFragment bloRegisterDraftFragment32 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment32.isVisual = bloRegisterDraftFragment32.bloRegisterDraftList.get(i).getIsVisual();
            BloRegisterDraftFragment bloRegisterDraftFragment33 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment33.sectionNo = bloRegisterDraftFragment33.bloRegisterDraftList.get(i).getSectionNo();
            BloRegisterDraftFragment bloRegisterDraftFragment34 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment34.isPwd = bloRegisterDraftFragment34.bloRegisterDraftList.get(i).getIsPwd();
            BloRegisterDraftFragment bloRegisterDraftFragment35 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment35.isDeaf = bloRegisterDraftFragment35.bloRegisterDraftList.get(i).getIsDeaf();
            BloRegisterDraftFragment bloRegisterDraftFragment36 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment36.pwdPercentage = bloRegisterDraftFragment36.bloRegisterDraftList.get(i).getPwdPercentage();
            BloRegisterDraftFragment bloRegisterDraftFragment37 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment37.isLocomotive = bloRegisterDraftFragment37.bloRegisterDraftList.get(i).getIsLocomotive();
            BloRegisterDraftFragment bloRegisterDraftFragment38 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment38.otherDisability = bloRegisterDraftFragment38.bloRegisterDraftList.get(i).getOtherDisability();
            BloRegisterDraftFragment bloRegisterDraftFragment39 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment39.isMetElector = bloRegisterDraftFragment39.bloRegisterDraftList.get(i).getIsMetElector();
            BloRegisterDraftFragment bloRegisterDraftFragment40 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment40.phoneNumberVerified = bloRegisterDraftFragment40.bloRegisterDraftList.get(i).getPhoneNumberVerified();
            BloRegisterDraftFragment bloRegisterDraftFragment41 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment41.dateOfVerification = bloRegisterDraftFragment41.bloRegisterDraftList.get(i).getDateOfVerification();
            BloRegisterDraftFragment bloRegisterDraftFragment42 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment42.addressAttachment = bloRegisterDraftFragment42.bloRegisterDraftList.get(i).getAddressAttachment();
            BloRegisterDraftFragment bloRegisterDraftFragment43 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment43.dobAttachment = bloRegisterDraftFragment43.bloRegisterDraftList.get(i).getDobAttachment();
            BloRegisterDraftFragment bloRegisterDraftFragment44 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment44.misDocument = bloRegisterDraftFragment44.bloRegisterDraftList.get(i).getMisDocument();
            BloRegisterDraftFragment bloRegisterDraftFragment45 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment45.remarks = bloRegisterDraftFragment45.bloRegisterDraftList.get(i).getRemarks();
            BloRegisterDraftFragment bloRegisterDraftFragment46 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment46.sectionName = bloRegisterDraftFragment46.bloRegisterDraftList.get(i).getSectionName();
            BloRegisterDraftFragment bloRegisterDraftFragment47 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment47.applicantNameRegional = bloRegisterDraftFragment47.bloRegisterDraftList.get(i).getApplicantNameRegional();
            BloRegisterDraftFragment bloRegisterDraftFragment48 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment48.relativeNameRegional = bloRegisterDraftFragment48.bloRegisterDraftList.get(i).getRelativeNameRegional();
            BloRegisterDraftFragment bloRegisterDraftFragment49 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment49.photo = bloRegisterDraftFragment49.bloRegisterDraftList.get(i).getPhoto();
            BloRegisterDraftFragment bloRegisterDraftFragment50 = BloRegisterDraftFragment.this;
            bloRegisterDraftFragment50.partSerialNumber = bloRegisterDraftFragment50.bloRegisterDraftList.get(i).getPartSerialNumber();
            BloRegisterDraftFragment.this.houseSurveySubmit();
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return BloRegisterDraftFragment.this.bloRegisterDraftList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4097);
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void houseSurveySubmit() {
        showProgressVisible();
        HashMap map = new HashMap();
        map.put("acNo", this.acNo);
        map.put("address", this.address);
        map.put("pwdPercentage", this.pwdPercentage);
        map.put("addressAttachment", this.addressAttachment);
        map.put("allDetailsVerified", this.allDetailsVerified);
        map.put("applicantName", this.applicantName);
        map.put("coordinate", this.coordinate);
        map.put("isPwd", this.isPwd);
        map.put("aadharNo", this.aadharNo);
        map.put("isAadharVerified", this.isAadharVerified);
        map.put("residingPeriod", this.residingPeriod);
        map.put("isLocomotive", this.isLocomotive);
        map.put("isVisual", this.isVisual);
        map.put("isDeaf", this.isDeaf);
        map.put("disabilityType", this.disabilityType);
        map.put("otherDisability", this.otherDisability);
        map.put("metInPerson", Integer.valueOf(this.isMetElector));
        map.put("phoneNumberVerified", this.phoneNumberVerified);
        map.put(this.sectionNoString, this.sectionNo);
        map.put("dateOfVerification", this.dateOfVerification);
        map.put("dob", this.dob);
        map.put("dobAttachment", this.dobAttachment);
        map.put("email", this.email);
        map.put("epicNo", this.epicNo);
        map.put("gender", this.gender);
        map.put("houseApplicantFound", this.houseApplicantFound);
        map.put("houseNo", this.houseNo);
        map.put("isAddressRecordSame", this.isAddressRecordSame);
        map.put("isDobRecordSame", this.isDobRecordSame);
        map.put("photographEleIsCorrect", this.photographEleIsCorrect);
        map.put("isElectorRecordSame", this.isElectorRecordSame);
        map.put("localitySreet", this.localitySreet);
        map.put("misDocument", this.misDocument);
        map.put("mobileNo", this.mobileNo);
        map.put("partNo", this.partNo);
        map.put("relativeName", this.relativeName);
        map.put("relativeType", this.relativeType);
        map.put("remarks", this.remarks);
        map.put("stateCode", this.stateCode);
        map.put("age", this.age);
        map.put("village", this.village);
        map.put("postOffice", this.postOffice);
        map.put("pinCode", this.pinCode);
        map.put("tehsilTalukaMandal", this.tehsil);
        map.put("partSerialNumber", this.partSerialNumber);
        Logger.d("", "House survey submit json " + new JSONObject(map));
        if (isNetworkAvailable(requireContext())) {
            this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).eroSurveySubmit(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass4());
        } else {
            showProgressInVisible();
            Toast.makeText(requireContext(), "Please check network", 1).show();
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        AnonymousClass4() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() == null || response.code() != 200) {
                BloRegisterDraftFragment.this.showProgressInVisible();
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.d("", strOptString);
                    BloRegisterDraftFragment bloRegisterDraftFragment = BloRegisterDraftFragment.this;
                    bloRegisterDraftFragment.showdialog1(bloRegisterDraftFragment.alertText, strOptString);
                    return;
                } catch (Exception e) {
                    Logger.e("H2HDETAILS", e.getMessage());
                    Logger.e("H2HDETAILS", e.getMessage());
                    if (response.code() == 401) {
                        BloRegisterDraftFragment.this.commomUtility.showMessageWithTitleOK(BloRegisterDraftFragment.this.requireContext(), BloRegisterDraftFragment.this.alertText, "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$4$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f$0.lambda$onResponse$0(dialogInterface, i);
                            }
                        });
                        return;
                    } else if (response.message() != null) {
                        BloRegisterDraftFragment bloRegisterDraftFragment2 = BloRegisterDraftFragment.this;
                        bloRegisterDraftFragment2.showdialogFinal(bloRegisterDraftFragment2.alertText, response.message());
                        return;
                    } else {
                        BloRegisterDraftFragment bloRegisterDraftFragment3 = BloRegisterDraftFragment.this;
                        bloRegisterDraftFragment3.showdialogFinal(bloRegisterDraftFragment3.alertText, "No Data Found");
                        return;
                    }
                }
            }
            BloRegisterDraftFragment.this.showProgressInVisible();
            BloRegisterDraftFragment.this.electorDetailsDatabaseHelper.h2HElectorDetailModelDao().deleteH2HElecorDetails(new H2HElectorDetailModel(BloRegisterDraftFragment.this.epicNo, BloRegisterDraftFragment.this.applicantName, BloRegisterDraftFragment.this.mobileNo, BloRegisterDraftFragment.this.gender, BloRegisterDraftFragment.this.email, BloRegisterDraftFragment.this.aadharNo, BloRegisterDraftFragment.this.dob, BloRegisterDraftFragment.this.age, BloRegisterDraftFragment.this.relativeName, BloRegisterDraftFragment.this.relativeType, BloRegisterDraftFragment.this.houseNo, BloRegisterDraftFragment.this.village, BloRegisterDraftFragment.this.postOffice, BloRegisterDraftFragment.this.acNo, BloRegisterDraftFragment.this.localitySreet, BloRegisterDraftFragment.this.address, BloRegisterDraftFragment.this.pinCode, BloRegisterDraftFragment.this.partNo, BloRegisterDraftFragment.this.stateCode, BloRegisterDraftFragment.this.coordinate, BloRegisterDraftFragment.this.residingPeriod, BloRegisterDraftFragment.this.houseApplicantFound, BloRegisterDraftFragment.this.isAadharVerified, BloRegisterDraftFragment.this.isElectorRecordSame, BloRegisterDraftFragment.this.allDetailsVerified, BloRegisterDraftFragment.this.isAddressRecordSame, BloRegisterDraftFragment.this.isDobRecordSame, BloRegisterDraftFragment.this.photographEleIsCorrect, BloRegisterDraftFragment.this.disabilityType, BloRegisterDraftFragment.this.isVisual, BloRegisterDraftFragment.this.sectionNo, BloRegisterDraftFragment.this.isPwd, BloRegisterDraftFragment.this.isDeaf, BloRegisterDraftFragment.this.pwdPercentage, BloRegisterDraftFragment.this.isLocomotive, BloRegisterDraftFragment.this.otherDisability, BloRegisterDraftFragment.this.isMetElector, BloRegisterDraftFragment.this.phoneNumberVerified, BloRegisterDraftFragment.this.dateOfVerification, BloRegisterDraftFragment.this.addressAttachment, BloRegisterDraftFragment.this.dobAttachment, BloRegisterDraftFragment.this.misDocument, BloRegisterDraftFragment.this.remarks, BloRegisterDraftFragment.this.sectionName, BloRegisterDraftFragment.this.applicantNameRegional, BloRegisterDraftFragment.this.relativeNameRegional, BloRegisterDraftFragment.this.photo, BloRegisterDraftFragment.this.partSerialNumber));
            BloRegisterDraftFragment.this.electorDetailsDatabaseHelper.houseSurveyModelDao().addHouseSurveyDetails(new HouseSurveyModel.Payload(BloRegisterDraftFragment.this.epicNo, BloRegisterDraftFragment.this.houseNo, BloRegisterDraftFragment.this.sectionNo, BloRegisterDraftFragment.this.partNo, SharedPref.getInstance(BloRegisterDraftFragment.this.requireContext()).getPreferredUsername(), BloRegisterDraftFragment.this.formattedDate, BloRegisterDraftFragment.this.inserted));
            Logger.d("", "data delete Successfully");
            if (BloRegisterDraftFragment.this.h2hFilterBinding == null || BloRegisterDraftFragment.this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals(BloRegisterDraftFragment.this.selectAllString)) {
                BloRegisterDraftFragment.this.getDraftData();
            } else {
                BloRegisterDraftFragment bloRegisterDraftFragment4 = BloRegisterDraftFragment.this;
                bloRegisterDraftFragment4.currencies = bloRegisterDraftFragment4.h2hFilterBinding.sectionNo.getSelectedItem().toString().split(StringUtils.SPACE);
                BloRegisterDraftFragment bloRegisterDraftFragment5 = BloRegisterDraftFragment.this;
                bloRegisterDraftFragment5.fetchElectorDataAsPerSection(bloRegisterDraftFragment5.currencies[0]);
            }
            Logger.d("", "Inside submit.........House Survey Submitted Successfully");
            BloRegisterDraftFragment.this.showdialogFinal("Success", "Verified Successfully");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(BloRegisterDraftFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(BloRegisterDraftFragment.this.getContext()).setLocaleBool(false);
            BloRegisterDraftFragment.this.startActivity(new Intent((Context) BloRegisterDraftFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            BloRegisterDraftFragment.this.showProgressInVisible();
            Logger.e("on Failure............", t.getMessage());
            BloRegisterDraftFragment.this.showdialog1("Error", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialogFinal(String title, String msg) {
        new androidx.appcompat.app.AlertDialog.Builder(requireContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogFinal$6(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogFinal$6(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        requireActivity();
        this.parser = new JSONParser();
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
        showProgressInVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog1(String title, String msg) {
        new androidx.appcompat.app.AlertDialog.Builder(requireContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.BloRegisterDraftFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.fragmentBloRegisterDraftBinding = null;
    }
}
