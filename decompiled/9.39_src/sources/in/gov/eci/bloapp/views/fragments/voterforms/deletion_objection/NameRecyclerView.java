package in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentNameRecyclerViewBinding;
import in.gov.eci.bloapp.databinding.BloNameRvItemBinding;
import in.gov.eci.bloapp.model.app_model.EpicRecylerViewDataModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.MainActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.simple.JSONArray;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class NameRecyclerView extends Fragment implements View.OnClickListener {
    String acNo;
    private GenericRecyclerView adapter;
    AlertDialog alertDialog;
    JSONArray allNames;
    private List<EpicRecylerViewDataModel> allnamesList;
    String applicantEpicDetailsArray;
    private String assembly;
    private String assemblyno;
    private BloFragmentNameRecyclerViewBinding binding;
    Retrofit.Builder builder;
    private String dbfetchepic;
    private String dbfetchepic2;
    String deletionObjection;
    String districtCdOfPersonToBeDeleted;
    String districtCode;
    private String districtfill;
    private String dvoterStatusType;
    String epicId;
    private String firstnamefill;
    String flag;
    String partNo;
    private String request;
    Retrofit retrofit;
    private String serialNumberOfPersonToBeDeleted;
    String stateCode;
    private String statefill;
    private String surnamefill;
    private String underJo;
    UserClient userClient;
    String alert = "Alert";
    CommomUtility commonUtilClass = new CommomUtility();
    private RadioButton lastCheckedRB = null;
    private String epicno = "";
    private String partfill = "";
    JSONArray payloadnames = null;
    String token = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    CommomUtility commomUtility = new CommomUtility();

    public NameRecyclerView() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        Retrofit retrofitBuild = builderClient.build();
        this.retrofit = retrofitBuild;
        this.userClient = (UserClient) retrofitBuild.create(UserClient.class);
        this.allNames = null;
        this.deletionObjection = "Deletion Objection";
        this.dvoterStatusType = "";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentNameRecyclerViewBinding.inflate(getLayoutInflater());
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
        Logger.d("token_Device_comp", this.token);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("flag");
            this.flag = string;
            this.flag = nullChecker(string);
            String string2 = arguments.getString("epicId");
            this.epicId = string2;
            this.epicId = nullChecker(string2);
            String string3 = arguments.getString("request");
            this.request = string3;
            this.request = nullChecker(string3);
            String string4 = arguments.getString("voterId");
            this.dbfetchepic = string4;
            this.dbfetchepic = nullChecker(string4);
            String string5 = arguments.getString("voterId2");
            this.dbfetchepic2 = string5;
            this.dbfetchepic2 = nullChecker(string5);
            nullChecker(arguments.getString("firstnamefromdb"));
            nullChecker(arguments.getString("lastnamefromdb"));
            String string6 = arguments.getString("state");
            this.statefill = string6;
            this.statefill = nullChecker(string6);
            String string7 = arguments.getString("district");
            this.districtfill = string7;
            this.districtfill = nullChecker(string7);
            String string8 = arguments.getString("assembly");
            this.assembly = string8;
            this.assembly = nullChecker(string8);
            String string9 = arguments.getString("assemblyNo");
            this.assemblyno = string9;
            this.assemblyno = nullChecker(string9);
            String string10 = arguments.getString("districtCdOfPersonToBeDeleted");
            this.districtCdOfPersonToBeDeleted = string10;
            this.districtCdOfPersonToBeDeleted = nullChecker(string10);
            this.applicantEpicDetailsArray = arguments.getString("applicantEpicDetailsArray");
        }
        if (this.request.equals("same")) {
            this.allNames = getByEpicForForm((JsonArray) new JsonParser().parse(this.applicantEpicDetailsArray));
        }
        initializingClicks();
        return this.binding.getRoot();
    }

    private String nullChecker(String bundleObject) {
        return (Objects.equals(bundleObject, null) || bundleObject.equals("null")) ? "" : bundleObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String nullCheckerRecycler(String object) {
        return (object == null || object.equals("null") || object.isEmpty()) ? "" : object;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.NameRecyclerView$1, reason: invalid class name */
    class AnonymousClass1 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass1() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloNameRvItemBinding.inflate(NameRecyclerView.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
            String str;
            ((BloNameRvItemBinding) holder.binding).epiclayout.setVisibility(0);
            String state = ((EpicRecylerViewDataModel) NameRecyclerView.this.allnamesList.get(position)).getState();
            String assembly = ((EpicRecylerViewDataModel) NameRecyclerView.this.allnamesList.get(position)).getAssembly();
            String partNumber = ((EpicRecylerViewDataModel) NameRecyclerView.this.allnamesList.get(position)).getPartNumber();
            String serialNumber = ((EpicRecylerViewDataModel) NameRecyclerView.this.allnamesList.get(position)).getSerialNumber();
            String name = ((EpicRecylerViewDataModel) NameRecyclerView.this.allnamesList.get(position)).getName();
            String surname = ((EpicRecylerViewDataModel) NameRecyclerView.this.allnamesList.get(position)).getSurname();
            String relativeName = ((EpicRecylerViewDataModel) NameRecyclerView.this.allnamesList.get(position)).getRelativeName();
            String relativeSurname = ((EpicRecylerViewDataModel) NameRecyclerView.this.allnamesList.get(position)).getRelativeSurname();
            String gender = ((EpicRecylerViewDataModel) NameRecyclerView.this.allnamesList.get(position)).getGender();
            String strNullCheckerRecycler = NameRecyclerView.this.nullCheckerRecycler(state);
            String strNullCheckerRecycler2 = NameRecyclerView.this.nullCheckerRecycler(assembly);
            String strNullCheckerRecycler3 = NameRecyclerView.this.nullCheckerRecycler(name);
            String strNullCheckerRecycler4 = NameRecyclerView.this.nullCheckerRecycler(surname);
            String strNullCheckerRecycler5 = NameRecyclerView.this.nullCheckerRecycler(partNumber);
            String strNullCheckerRecycler6 = NameRecyclerView.this.nullCheckerRecycler(serialNumber);
            String strNullCheckerRecycler7 = NameRecyclerView.this.nullCheckerRecycler(relativeName);
            String strNullCheckerRecycler8 = NameRecyclerView.this.nullCheckerRecycler(relativeSurname);
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
            ((BloNameRvItemBinding) holder.binding).applicantNameRb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.NameRecyclerView$1$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f$0.lambda$onBindViewHolder$0(position, compoundButton, z);
                }
            });
            ((BloNameRvItemBinding) holder.binding).epiclayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.NameRecyclerView$1$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(holder, position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, CompoundButton compoundButton, boolean z) {
            RadioButton radioButton = (RadioButton) compoundButton;
            if (NameRecyclerView.this.lastCheckedRB != null) {
                NameRecyclerView.this.lastCheckedRB.setChecked(false);
            }
            NameRecyclerView.this.lastCheckedRB = radioButton;
            NameRecyclerView nameRecyclerView = NameRecyclerView.this;
            nameRecyclerView.epicno = ((EpicRecylerViewDataModel) nameRecyclerView.allnamesList.get(i)).epic;
            NameRecyclerView nameRecyclerView2 = NameRecyclerView.this;
            nameRecyclerView2.firstnamefill = ((EpicRecylerViewDataModel) nameRecyclerView2.allnamesList.get(i)).getName();
            NameRecyclerView nameRecyclerView3 = NameRecyclerView.this;
            nameRecyclerView3.surnamefill = ((EpicRecylerViewDataModel) nameRecyclerView3.allnamesList.get(i)).getSurname();
            NameRecyclerView nameRecyclerView4 = NameRecyclerView.this;
            nameRecyclerView4.serialNumberOfPersonToBeDeleted = ((EpicRecylerViewDataModel) nameRecyclerView4.allnamesList.get(i)).getSerialNumber();
            NameRecyclerView nameRecyclerView5 = NameRecyclerView.this;
            nameRecyclerView5.partfill = ((EpicRecylerViewDataModel) nameRecyclerView5.allnamesList.get(i)).getPartNumber();
            NameRecyclerView nameRecyclerView6 = NameRecyclerView.this;
            nameRecyclerView6.districtCdOfPersonToBeDeleted = ((EpicRecylerViewDataModel) nameRecyclerView6.allnamesList.get(i)).getDistrictCd();
            NameRecyclerView nameRecyclerView7 = NameRecyclerView.this;
            nameRecyclerView7.dvoterStatusType = ((EpicRecylerViewDataModel) nameRecyclerView7.allnamesList.get(i)).getdVoterStatusType();
            NameRecyclerView nameRecyclerView8 = NameRecyclerView.this;
            nameRecyclerView8.underJo = ((EpicRecylerViewDataModel) nameRecyclerView8.allnamesList.get(i)).getUnderJo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(RecyclerViewHolder recyclerViewHolder, int i, View view) {
            ((BloNameRvItemBinding) recyclerViewHolder.binding).applicantNameRb2.setChecked(true);
            NameRecyclerView nameRecyclerView = NameRecyclerView.this;
            nameRecyclerView.epicno = ((EpicRecylerViewDataModel) nameRecyclerView.allnamesList.get(i)).epic;
            NameRecyclerView nameRecyclerView2 = NameRecyclerView.this;
            nameRecyclerView2.firstnamefill = ((EpicRecylerViewDataModel) nameRecyclerView2.allnamesList.get(i)).getName();
            NameRecyclerView nameRecyclerView3 = NameRecyclerView.this;
            nameRecyclerView3.surnamefill = ((EpicRecylerViewDataModel) nameRecyclerView3.allnamesList.get(i)).getSurname();
            NameRecyclerView nameRecyclerView4 = NameRecyclerView.this;
            nameRecyclerView4.serialNumberOfPersonToBeDeleted = ((EpicRecylerViewDataModel) nameRecyclerView4.allnamesList.get(i)).getSerialNumber();
            NameRecyclerView nameRecyclerView5 = NameRecyclerView.this;
            nameRecyclerView5.partfill = ((EpicRecylerViewDataModel) nameRecyclerView5.allnamesList.get(i)).getPartNumber();
            NameRecyclerView nameRecyclerView6 = NameRecyclerView.this;
            nameRecyclerView6.districtCdOfPersonToBeDeleted = ((EpicRecylerViewDataModel) nameRecyclerView6.allnamesList.get(i)).getDistrictCd();
            NameRecyclerView nameRecyclerView7 = NameRecyclerView.this;
            nameRecyclerView7.dvoterStatusType = ((EpicRecylerViewDataModel) nameRecyclerView7.allnamesList.get(i)).getdVoterStatusType();
            NameRecyclerView nameRecyclerView8 = NameRecyclerView.this;
            nameRecyclerView8.underJo = ((EpicRecylerViewDataModel) nameRecyclerView8.allnamesList.get(i)).getUnderJo();
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return NameRecyclerView.this.allnamesList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass1());
        this.binding.nameRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.nameRv.setAdapter(this.adapter);
    }

    public JSONArray getByEpicForForm(JsonArray applicantEpicDetailsArray) {
        Logger.d(this.deletionObjection, "in getForm7ByEpic..............................");
        for (int i = 0; i < applicantEpicDetailsArray.size(); i++) {
            JsonObject jsonObject = applicantEpicDetailsArray.get(i).get("content");
            String strReplace = String.valueOf(jsonObject.get("stateName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace2 = String.valueOf(jsonObject.get("districtValue")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace3 = String.valueOf(jsonObject.get("asmblyName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace4 = String.valueOf(jsonObject.get("acNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace5 = String.valueOf(jsonObject.get("partNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace6 = String.valueOf(jsonObject.get("partSerialNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace7 = String.valueOf(jsonObject.get("applicantFirstName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace8 = String.valueOf(jsonObject.get("applicantLastName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace9 = String.valueOf(jsonObject.get("epicNumber")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace10 = String.valueOf(jsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace11 = String.valueOf(jsonObject.get("relationLName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace12 = String.valueOf(jsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace13 = String.valueOf(jsonObject.get("districtCd")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace14 = String.valueOf(jsonObject.get("dvoterStatusType")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            String strReplace15 = String.valueOf(jsonObject.get("underJo")).replace(RegexMatcher.JSON_STRING_REGEX, "");
            if (this.acNo.equals(strReplace4) && this.partNo.equals(strReplace5)) {
                this.allnamesList.add(new EpicRecylerViewDataModel(strReplace, strReplace2, "", strReplace13, strReplace3, strReplace4, strReplace7, strReplace8, strReplace9, strReplace10, strReplace11, strReplace12, strReplace5, strReplace6, strReplace14, "", "", null, strReplace15));
            }
        }
        initRecyclerViewAdapter();
        this.binding.nameRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.nameRv.setAdapter(this.adapter);
        this.alertDialog.dismiss();
        return this.payloadnames;
    }

    private void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    private void initializingClicks() {
        this.binding.backBtnIv.setOnClickListener(this);
        this.binding.homeBtnIv.setOnClickListener(this);
        this.binding.nextTv.setOnClickListener(this);
    }

    private boolean isApplicantValidated() {
        if (this.epicno.isEmpty()) {
            showdialog(this.alert, "Please select an Elector");
            return false;
        }
        if (this.dvoterStatusType.equals("H") || this.dvoterStatusType.equals("Y") || this.dvoterStatusType.equals("1")) {
            showdialog(this.alert, "The EPIC is already marked as D-Voter hence you can't fill this form");
            return false;
        }
        if (!this.partNo.equals(this.partfill)) {
            showdialog(this.alert, "Applicant doesn't belong to your Part");
            return false;
        }
        if (!this.underJo.equalsIgnoreCase("1")) {
            return true;
        }
        showdialog(this.alert, "The applicant is under Adjudication.");
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == 2131364833 && isApplicantValidated()) {
            this.alertDialog.show();
            Bundle bundle = new Bundle();
            bundle.putString("flag", this.flag);
            bundle.putString("epicId", this.epicId);
            bundle.putString("request", this.request);
            bundle.putString("voterId", this.dbfetchepic);
            bundle.putString("state", this.statefill);
            bundle.putString("district", this.districtfill);
            bundle.putString("assembly", this.assembly);
            bundle.putString("assemblyNo", this.assemblyno);
            bundle.putString("firstnamefromdb", this.firstnamefill);
            bundle.putString("lastnamefromdb", this.surnamefill);
            bundle.putString("epic", this.epicno);
            bundle.putString("partNumberApplicant", this.partfill);
            bundle.putString("partNumberOfPersonToBeDeleted", this.partfill);
            bundle.putString("serialNumberOfPersonToBeDeleted", this.serialNumberOfPersonToBeDeleted);
            bundle.putString("districtCdOfPersonToBeDeleted", this.districtCdOfPersonToBeDeleted);
            bundle.putString("applicantEpicDetailsArray", this.applicantEpicDetailsArray);
            Logger.d("name recycler", this.epicId);
            DeletionObjectionForm deletionObjectionForm = new DeletionObjectionForm();
            deletionObjectionForm.setArguments(bundle);
            openFragment(deletionObjectionForm, "Deletion Objection From Name RecyclerView");
            this.alertDialog.dismiss();
        }
        if (v.getId() == 2131362458) {
            requireActivity().getSupportFragmentManager().popBackStackImmediate();
        }
        if (v.getId() == 2131364065) {
            Intent intent = new Intent(requireContext(), (Class<?>) MainActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
        }
    }

    private void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.NameRecyclerView$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    private void showdialog1(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.NameRecyclerView$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog1$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog1$1(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
