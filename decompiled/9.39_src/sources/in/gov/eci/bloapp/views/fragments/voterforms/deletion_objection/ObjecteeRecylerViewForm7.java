package in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentObjecteeRecylerViewForm7Binding;
import in.gov.eci.bloapp.databinding.BloNameRvItemBinding;
import in.gov.eci.bloapp.model.app_model.EpicRecylerViewDataModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ObjecteeRecylerViewForm7 extends Fragment {
    String acNo;
    private GenericRecyclerView adapter;
    String alert;
    AlertDialog alertDialog;
    JSONArray allNames;
    private List<EpicRecylerViewDataModel> allnamesList;
    String appName;
    private String base64element;
    private BloFragmentObjecteeRecylerViewForm7Binding binding;
    String bucketName;
    Retrofit.Builder builder;
    private final Bundle bundleViewPager;
    String dataNotAvailable;
    String dbfetchepic;
    String dbfetchepic2;
    String deletionObjection;
    String districtCdOfPersonToBeDeleted;
    String districtCdString;
    String districtCode;
    String dvoterStatusTypeString;
    String epicNumberString;
    String errorOccuredTryAgain;
    String failedToRead;
    private String filerefphoto;
    String firstNameString;
    String firstname;
    String inOnFailure;
    String lastname;
    String objecteeEpicDetailsArray;
    String otherString;
    String partNo;
    String partNumberString;
    String processMasterIdString;
    String refreshToken;
    String request;
    Retrofit retrofit;
    String serialNumberString;
    String sessionTokenExpiredPleaseLogin;
    String stateCode;
    String subRequest;
    String surnameString;
    UserClient userClient;
    private final String messageString = "message";
    CommomUtility commonUtilClass = new CommomUtility();
    private RadioButton lastCheckedRB = null;
    String epicno = "";
    JSONArray payloadnames = null;
    String token = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public ObjecteeRecylerViewForm7(Bundle bundleViewPager) {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        Retrofit retrofitBuild = builderClient.build();
        this.retrofit = retrofitBuild;
        this.userClient = (UserClient) retrofitBuild.create(UserClient.class);
        this.allNames = null;
        this.deletionObjection = "Deletion Objection";
        this.alert = "Alert";
        this.sessionTokenExpiredPleaseLogin = "Session token expired please Login";
        this.errorOccuredTryAgain = "Error Occured please try again...";
        this.inOnFailure = "coming in onFailure ";
        this.bucketName = "objectstorage";
        this.appName = "BLOAPP";
        this.failedToRead = "Failed to read";
        this.otherString = "other";
        this.epicNumberString = "epicNumber";
        this.firstNameString = Constants.FIRST_NAME;
        this.surnameString = "surname";
        this.serialNumberString = "serialNumber";
        this.partNumberString = "partNumber";
        this.districtCdString = "districtCd";
        this.dvoterStatusTypeString = "dvoterStatusType";
        this.processMasterIdString = "processMasterId";
        this.dataNotAvailable = "Data not Available";
        this.bundleViewPager = bundleViewPager;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentObjecteeRecylerViewForm7Binding.inflate(getLayoutInflater());
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
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
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
            String string7 = this.bundleViewPager.getString("districtCdOfPersonToBeDeleted");
            this.districtCdOfPersonToBeDeleted = string7;
            this.districtCdOfPersonToBeDeleted = nullChecker(string7);
            this.objecteeEpicDetailsArray = this.bundleViewPager.getString("objecteeEpicDetailsArray");
        }
        if (this.request.equals(this.otherString) && this.subRequest.equals("epic")) {
            this.allNames = getByEpicForForm((JsonArray) new JsonParser().parse(this.objecteeEpicDetailsArray));
        } else if (this.request.equals(this.otherString) && this.subRequest.equals("name")) {
            this.allNames = getForm7byApplicantFirstNameOthers((JsonArray) new JsonParser().parse(this.objecteeEpicDetailsArray));
        } else {
            this.allNames = getForm7byfirstNameAndlastNameObjection((JsonArray) new JsonParser().parse(this.objecteeEpicDetailsArray));
        }
        return this.binding.getRoot();
    }

    private String nullChecker(String bundleObject) {
        return (Objects.equals(bundleObject, null) || bundleObject.equals("null")) ? "" : bundleObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String nullCheckerRecycler(String object) {
        return (object == null || object.equals("null") || object.isEmpty()) ? "" : object;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$1, reason: invalid class name */
    class AnonymousClass1 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass1() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloNameRvItemBinding.inflate(ObjecteeRecylerViewForm7.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
            String str;
            if (ObjecteeRecylerViewForm7.this.request.equals(ObjecteeRecylerViewForm7.this.otherString) && ObjecteeRecylerViewForm7.this.subRequest.equals("epic")) {
                ((BloNameRvItemBinding) holder.binding).epiclayout.setVisibility(0);
            } else if (ObjecteeRecylerViewForm7.this.request.equals(ObjecteeRecylerViewForm7.this.otherString) && ObjecteeRecylerViewForm7.this.subRequest.equals("name")) {
                ((BloNameRvItemBinding) holder.binding).nameLayout.setVisibility(0);
            } else {
                ((BloNameRvItemBinding) holder.binding).nameLayout.setVisibility(0);
                ((BloNameRvItemBinding) holder.binding).epicNumberTv.setText("Reference No.");
                ((BloNameRvItemBinding) holder.binding).partSerialLayout.setVisibility(8);
            }
            if (((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getPhoto() != null) {
                ((BloNameRvItemBinding) holder.binding).personImage.setImageBitmap(BitmapFactory.decodeByteArray(((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getPhoto(), 0, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getPhoto().length));
            } else {
                ((BloNameRvItemBinding) holder.binding).personImage.setImageBitmap(BitmapFactory.decodeResource(ObjecteeRecylerViewForm7.this.getResources(), R.drawable.blo_dummy_image));
            }
            if ((ObjecteeRecylerViewForm7.this.request.equals(ObjecteeRecylerViewForm7.this.otherString) && ObjecteeRecylerViewForm7.this.subRequest.equals("name")) || ObjecteeRecylerViewForm7.this.request.equals("objection")) {
                ((BloNameRvItemBinding) holder.binding).serialNoTv.setText("S. No. " + (position + 1));
                String name = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getName();
                String surname = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getSurname();
                String partNumber = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getPartNumber();
                String serialNumber = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getSerialNumber();
                String strNullCheckerRecycler = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(name);
                String strNullCheckerRecycler2 = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(surname);
                String strNullCheckerRecycler3 = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(partNumber);
                String strNullCheckerRecycler4 = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(serialNumber);
                ((BloNameRvItemBinding) holder.binding).applicantNameTv.setText(strNullCheckerRecycler + " " + strNullCheckerRecycler2);
                ((BloNameRvItemBinding) holder.binding).epicNumberTv1.setText(((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getEpic());
                ((BloNameRvItemBinding) holder.binding).partTv1.setText(strNullCheckerRecycler3);
                ((BloNameRvItemBinding) holder.binding).serialTv1.setText(strNullCheckerRecycler4);
                ((BloNameRvItemBinding) holder.binding).applicantNameRb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$1$$ExternalSyntheticLambda0
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        this.f$0.lambda$onBindViewHolder$0(position, compoundButton, z);
                    }
                });
                ((BloNameRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$1$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onBindViewHolder$1(holder, position, view);
                    }
                });
                return;
            }
            String state = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getState();
            String assembly = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getAssembly();
            String partNumber2 = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getPartNumber();
            String serialNumber2 = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getSerialNumber();
            String name2 = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getName();
            String surname2 = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getSurname();
            String relativeName = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getRelativeName();
            String relativeSurname = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getRelativeSurname();
            String gender = ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(position)).getGender();
            String strNullCheckerRecycler5 = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(state);
            String strNullCheckerRecycler6 = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(assembly);
            String strNullCheckerRecycler7 = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(name2);
            String strNullCheckerRecycler8 = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(surname2);
            String strNullCheckerRecycler9 = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(partNumber2);
            String strNullCheckerRecycler10 = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(serialNumber2);
            String strNullCheckerRecycler11 = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(relativeName);
            String strNullCheckerRecycler12 = ObjecteeRecylerViewForm7.this.nullCheckerRecycler(relativeSurname);
            if (gender == null || gender.equals("null") || gender.isEmpty()) {
                str = "";
            } else if (gender.equals("M")) {
                str = "Male";
            } else if (gender.equals("F")) {
                str = "Female";
            } else {
                str = "Third Gender";
            }
            ((BloNameRvItemBinding) holder.binding).state.setText(strNullCheckerRecycler5);
            ((BloNameRvItemBinding) holder.binding).ac.setText(strNullCheckerRecycler6);
            ((BloNameRvItemBinding) holder.binding).partNumber.setText(strNullCheckerRecycler9);
            ((BloNameRvItemBinding) holder.binding).serialNumber.setText(strNullCheckerRecycler10);
            ((BloNameRvItemBinding) holder.binding).applicantName.setText(strNullCheckerRecycler7);
            ((BloNameRvItemBinding) holder.binding).applicantSurname.setText(strNullCheckerRecycler8);
            ((BloNameRvItemBinding) holder.binding).relativeName.setText(strNullCheckerRecycler11);
            ((BloNameRvItemBinding) holder.binding).relativeSurname.setText(strNullCheckerRecycler12);
            ((BloNameRvItemBinding) holder.binding).gender.setText(str);
            ((BloNameRvItemBinding) holder.binding).applicantNameRb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$1$$ExternalSyntheticLambda2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f$0.lambda$onBindViewHolder$2(position, compoundButton, z);
                }
            });
            ((BloNameRvItemBinding) holder.binding).epiclayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$1$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$3(holder, position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, CompoundButton compoundButton, boolean z) {
            RadioButton radioButton = (RadioButton) compoundButton;
            if (ObjecteeRecylerViewForm7.this.lastCheckedRB != null) {
                ObjecteeRecylerViewForm7.this.lastCheckedRB.setChecked(false);
            }
            ObjecteeRecylerViewForm7.this.lastCheckedRB = radioButton;
            ObjecteeRecylerViewForm7 objecteeRecylerViewForm7 = ObjecteeRecylerViewForm7.this;
            objecteeRecylerViewForm7.epicno = ((EpicRecylerViewDataModel) objecteeRecylerViewForm7.allnamesList.get(i)).epic;
            HashMap map = new HashMap();
            map.put(ObjecteeRecylerViewForm7.this.epicNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).epic);
            map.put(ObjecteeRecylerViewForm7.this.firstNameString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getName());
            map.put(ObjecteeRecylerViewForm7.this.surnameString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getSurname());
            map.put(ObjecteeRecylerViewForm7.this.serialNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getSerialNumber());
            map.put(ObjecteeRecylerViewForm7.this.partNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getPartNumber());
            map.put(ObjecteeRecylerViewForm7.this.districtCdString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getDistrictCd());
            map.put(ObjecteeRecylerViewForm7.this.dvoterStatusTypeString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getdVoterStatusType());
            map.put(ObjecteeRecylerViewForm7.this.processMasterIdString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getProcessMasterId());
            map.put("underJo", ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getUnderJo());
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setObjecteeEpicDetails(new Gson().toJson(map));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(RecyclerViewHolder recyclerViewHolder, int i, View view) {
            ((BloNameRvItemBinding) recyclerViewHolder.binding).applicantNameRb.setChecked(true);
            ObjecteeRecylerViewForm7 objecteeRecylerViewForm7 = ObjecteeRecylerViewForm7.this;
            objecteeRecylerViewForm7.epicno = ((EpicRecylerViewDataModel) objecteeRecylerViewForm7.allnamesList.get(i)).epic;
            HashMap map = new HashMap();
            map.put(ObjecteeRecylerViewForm7.this.epicNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).epic);
            map.put(ObjecteeRecylerViewForm7.this.firstNameString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getName());
            map.put(ObjecteeRecylerViewForm7.this.surnameString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getSurname());
            map.put(ObjecteeRecylerViewForm7.this.serialNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getSerialNumber());
            map.put(ObjecteeRecylerViewForm7.this.partNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getPartNumber());
            map.put(ObjecteeRecylerViewForm7.this.districtCdString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getDistrictCd());
            map.put(ObjecteeRecylerViewForm7.this.dvoterStatusTypeString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getdVoterStatusType());
            map.put(ObjecteeRecylerViewForm7.this.processMasterIdString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getProcessMasterId());
            map.put("underJo", ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getUnderJo());
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setObjecteeEpicDetails(new Gson().toJson(map));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(int i, CompoundButton compoundButton, boolean z) {
            RadioButton radioButton = (RadioButton) compoundButton;
            if (ObjecteeRecylerViewForm7.this.lastCheckedRB != null) {
                ObjecteeRecylerViewForm7.this.lastCheckedRB.setChecked(false);
            }
            ObjecteeRecylerViewForm7.this.lastCheckedRB = radioButton;
            ObjecteeRecylerViewForm7 objecteeRecylerViewForm7 = ObjecteeRecylerViewForm7.this;
            objecteeRecylerViewForm7.epicno = ((EpicRecylerViewDataModel) objecteeRecylerViewForm7.allnamesList.get(i)).epic;
            HashMap map = new HashMap();
            map.put(ObjecteeRecylerViewForm7.this.epicNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).epic);
            map.put(ObjecteeRecylerViewForm7.this.firstNameString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getName());
            map.put(ObjecteeRecylerViewForm7.this.surnameString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getSurname());
            map.put(ObjecteeRecylerViewForm7.this.serialNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getSerialNumber());
            map.put(ObjecteeRecylerViewForm7.this.partNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getPartNumber());
            map.put(ObjecteeRecylerViewForm7.this.districtCdString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getDistrictCd());
            map.put(ObjecteeRecylerViewForm7.this.dvoterStatusTypeString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getdVoterStatusType());
            map.put("underJo", ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getUnderJo());
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setObjecteeEpicDetails(new Gson().toJson(map));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$3(RecyclerViewHolder recyclerViewHolder, int i, View view) {
            ((BloNameRvItemBinding) recyclerViewHolder.binding).applicantNameRb2.setChecked(true);
            ObjecteeRecylerViewForm7 objecteeRecylerViewForm7 = ObjecteeRecylerViewForm7.this;
            objecteeRecylerViewForm7.epicno = ((EpicRecylerViewDataModel) objecteeRecylerViewForm7.allnamesList.get(i)).epic;
            ObjecteeRecylerViewForm7 objecteeRecylerViewForm8 = ObjecteeRecylerViewForm7.this;
            objecteeRecylerViewForm8.districtCdOfPersonToBeDeleted = ((EpicRecylerViewDataModel) objecteeRecylerViewForm8.allnamesList.get(i)).getDistrictCd();
            HashMap map = new HashMap();
            map.put(ObjecteeRecylerViewForm7.this.epicNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).epic);
            map.put(ObjecteeRecylerViewForm7.this.firstNameString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getName());
            map.put(ObjecteeRecylerViewForm7.this.surnameString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getSurname());
            map.put(ObjecteeRecylerViewForm7.this.serialNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getSerialNumber());
            map.put(ObjecteeRecylerViewForm7.this.partNumberString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getPartNumber());
            map.put(ObjecteeRecylerViewForm7.this.districtCdString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getDistrictCd());
            map.put(ObjecteeRecylerViewForm7.this.dvoterStatusTypeString, ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getdVoterStatusType());
            map.put("underJo", ((EpicRecylerViewDataModel) ObjecteeRecylerViewForm7.this.allnamesList.get(i)).getUnderJo());
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setObjecteeEpicDetails(new Gson().toJson(map));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return ObjecteeRecylerViewForm7.this.allnamesList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass1());
        this.binding.nameRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.nameRv.setAdapter(this.adapter);
    }

    public JSONArray getByEpicForForm(JsonArray objecteeEpicDetailsArray) {
        Logger.d(this.deletionObjection, "in getForm7ByEpic..............................");
        for (int i = 0; i < objecteeEpicDetailsArray.size(); i++) {
            JsonObject jsonObject = objecteeEpicDetailsArray.get(i).get("content");
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

    public JSONArray getForm7byApplicantFirstNameOthers(JsonArray objecteeEpicDetailsArray) {
        Logger.d(this.deletionObjection, "in getForm7byApplicantFirstName..............................");
        if (objecteeEpicDetailsArray.size() > 0) {
            renderingdataForOthers(objecteeEpicDetailsArray);
        } else {
            this.alertDialog.dismiss();
            Logger.d(this.deletionObjection, "payload is 0 in getForm7byApplicantFirstNameOthers() ");
            showdialog1(this.alert, this.dataNotAvailable);
        }
        return this.payloadnames;
    }

    public void renderingdataForOthers(JsonArray allNames) {
        int i;
        String str = "";
        this.allnamesList.clear();
        int i2 = 0;
        while (i2 < allNames.size()) {
            try {
                JsonObject jsonObject = allNames.get(i2);
                String strTrim = String.valueOf(jsonObject.get("applicantFirstName")).replace(RegexMatcher.JSON_STRING_REGEX, str).trim();
                String strTrim2 = String.valueOf(jsonObject.get("applicantLastName")).replace(RegexMatcher.JSON_STRING_REGEX, str).trim();
                String strTrim3 = String.valueOf(jsonObject.get(this.epicNumberString)).replace(RegexMatcher.JSON_STRING_REGEX, str).trim();
                String strTrim4 = String.valueOf(jsonObject.get(this.districtCdString)).replace(RegexMatcher.JSON_STRING_REGEX, str).trim();
                String strTrim5 = String.valueOf(jsonObject.get(this.dvoterStatusTypeString)).replace(RegexMatcher.JSON_STRING_REGEX, str).trim();
                String strTrim6 = String.valueOf(jsonObject.get(this.partNumberString)).replace(RegexMatcher.JSON_STRING_REGEX, str).trim();
                String strTrim7 = String.valueOf(jsonObject.get("partSerialNumber")).replace(RegexMatcher.JSON_STRING_REGEX, str).trim();
                String strReplace = String.valueOf(jsonObject.get("underJo")).replace(RegexMatcher.JSON_STRING_REGEX, str);
                byte[][] bArr = {null};
                try {
                    this.filerefphoto = String.valueOf(jsonObject.get("photo")).replace(RegexMatcher.JSON_STRING_REGEX, str).trim();
                } catch (Exception e) {
                    Logger.e(this.deletionObjection, e.getMessage());
                }
                if (this.partNo.equals(strTrim6)) {
                    i = i2;
                    this.userClient.getFile(this.bucketName, this.filerefphoto, this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB").enqueue(new AnonymousClass2(bArr, strTrim4, strTrim, strTrim2, strTrim3, strTrim6, strTrim7, strTrim5, strReplace, allNames));
                } else {
                    i = i2;
                }
                i2 = i + 1;
                str = str;
            } catch (Exception e2) {
                Logger.e(this.deletionObjection, e2.getMessage());
                Logger.d("error", this.failedToRead);
                this.alertDialog.dismiss();
                showdialog1(this.alert, this.failedToRead);
                return;
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$renderingdataForOthers$0();
            }
        }, 6000L);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        final /* synthetic */ JsonArray val$allNames;
        final /* synthetic */ String val$districtCd;
        final /* synthetic */ String val$dvoterStatusType;
        final /* synthetic */ String val$epicNumber;
        final /* synthetic */ String val$name;
        final /* synthetic */ String val$partNoOther;
        final /* synthetic */ byte[][] val$photo;
        final /* synthetic */ String val$serialNo;
        final /* synthetic */ String val$surname;
        final /* synthetic */ String val$underJo;

        AnonymousClass2(final byte[][] val$photo, final String val$districtCd, final String val$name, final String val$surname, final String val$epicNumber, final String val$partNoOther, final String val$serialNo, final String val$dvoterStatusType, final String val$underJo, final JsonArray val$allNames) {
            this.val$photo = val$photo;
            this.val$districtCd = val$districtCd;
            this.val$name = val$name;
            this.val$surname = val$surname;
            this.val$epicNumber = val$epicNumber;
            this.val$partNoOther = val$partNoOther;
            this.val$serialNo = val$serialNo;
            this.val$dvoterStatusType = val$dvoterStatusType;
            this.val$underJo = val$underJo;
            this.val$allNames = val$allNames;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                Logger.d(ObjecteeRecylerViewForm7.this.deletionObjection, String.valueOf(((JsonObject) response.body()).get("message")));
                ObjecteeRecylerViewForm7.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                this.val$photo[0] = Base64.decode(ObjecteeRecylerViewForm7.this.base64element, 0);
                ObjecteeRecylerViewForm7.this.allnamesList.add(new EpicRecylerViewDataModel("", "", "", this.val$districtCd, "", "", this.val$name, this.val$surname, this.val$epicNumber, "", "", "", this.val$partNoOther, this.val$serialNo, this.val$dvoterStatusType, "", ObjecteeRecylerViewForm7.this.filerefphoto, this.val$photo[0], this.val$underJo));
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = ObjecteeRecylerViewForm7.this.commonUtilClass;
                Context contextRequireContext = ObjecteeRecylerViewForm7.this.requireContext();
                String str = ObjecteeRecylerViewForm7.this.refreshToken;
                final JsonArray jsonArray = this.val$allNames;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str2, String str3) {
                        this.f$0.lambda$onResponse$1(jsonArray, i, str2, str3);
                    }
                });
            }
            ObjecteeRecylerViewForm7.this.allnamesList.add(new EpicRecylerViewDataModel("", "", "", this.val$districtCd, "", "", this.val$name, this.val$surname, this.val$epicNumber, "", "", "", this.val$partNoOther, this.val$serialNo, this.val$dvoterStatusType, "", ObjecteeRecylerViewForm7.this.filerefphoto, this.val$photo[0], this.val$underJo));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(JsonArray jsonArray, int i, String str, String str2) {
            ObjecteeRecylerViewForm7.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ObjecteeRecylerViewForm7.this.commonUtilClass.showMessageOK(ObjecteeRecylerViewForm7.this.getContext(), ObjecteeRecylerViewForm7.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ObjecteeRecylerViewForm7.this.token = "Bearer " + str;
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setToken("Bearer " + str);
            ObjecteeRecylerViewForm7.this.renderingdataForOthers(jsonArray);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setLocaleBool(false);
            ObjecteeRecylerViewForm7.this.startActivity(new Intent((Context) ObjecteeRecylerViewForm7.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(ObjecteeRecylerViewForm7.this.deletionObjection, ObjecteeRecylerViewForm7.this.inOnFailure + t.getMessage());
            ObjecteeRecylerViewForm7 objecteeRecylerViewForm7 = ObjecteeRecylerViewForm7.this;
            objecteeRecylerViewForm7.showdialog(objecteeRecylerViewForm7.alert, t.getMessage());
            ObjecteeRecylerViewForm7.this.allnamesList.add(new EpicRecylerViewDataModel("", "", "", this.val$districtCd, "", "", this.val$name, this.val$surname, this.val$epicNumber, "", "", "", this.val$partNoOther, this.val$serialNo, this.val$dvoterStatusType, "", ObjecteeRecylerViewForm7.this.filerefphoto, this.val$photo[0], this.val$underJo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renderingdataForOthers$0() {
        this.alertDialog.dismiss();
        if (this.allnamesList.size() == 0) {
            showdialog1(this.alert, this.dataNotAvailable);
            return;
        }
        initRecyclerViewAdapter();
        this.binding.nameRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.nameRv.setAdapter(this.adapter);
    }

    public JSONArray getForm7byfirstNameAndlastNameObjection(JsonArray objecteeEpicDetailsArray) {
        Logger.d(this.deletionObjection, "in getForm7byfirstNameAndlastNameObjection..............................");
        if (objecteeEpicDetailsArray.size() > 0) {
            renderingdataForObjection(objecteeEpicDetailsArray);
        } else {
            this.alertDialog.dismiss();
            Logger.d(this.deletionObjection, "payload is 0 in getForm7byfirstNameAndlastNameObjection() ");
            showdialog1(this.alert, this.dataNotAvailable);
        }
        return this.payloadnames;
    }

    public void renderingdataForObjection(JsonArray allNames) {
        this.allnamesList.clear();
        try {
            Logger.d(this.deletionObjection, "in reading..........................." + allNames);
            for (int i = 0; i < allNames.size(); i++) {
                JsonObject jsonObject = allNames.get(i);
                String strReplace = String.valueOf(jsonObject.get("firstname")).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace2 = String.valueOf(jsonObject.get("lastname")).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace3 = String.valueOf(jsonObject.get("fdreferenceNumber")).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace4 = String.valueOf(jsonObject.get(this.processMasterIdString)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace5 = String.valueOf(jsonObject.get("underJo")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[][] bArr = {null};
                try {
                    this.filerefphoto = jsonObject.get("photo").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                } catch (Exception e) {
                    Logger.e(this.deletionObjection, e.getMessage());
                }
                this.userClient.getFile(this.bucketName, this.filerefphoto, this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB").enqueue(new AnonymousClass3(bArr, strReplace, strReplace2, strReplace3, strReplace4, strReplace5, allNames));
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$renderingdataForObjection$1();
                }
            }, 6000L);
        } catch (Exception e2) {
            Logger.e(this.deletionObjection, e2.getMessage());
            this.alertDialog.dismiss();
            showdialog1(this.alert, this.failedToRead);
            Logger.d("error", this.failedToRead);
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        final /* synthetic */ JsonArray val$allNames;
        final /* synthetic */ String val$fdreferenceNumber;
        final /* synthetic */ String val$lastname;
        final /* synthetic */ String val$name;
        final /* synthetic */ byte[][] val$photo;
        final /* synthetic */ String val$processMasterId;
        final /* synthetic */ String val$underJo;

        AnonymousClass3(final byte[][] val$photo, final String val$name, final String val$lastname, final String val$fdreferenceNumber, final String val$processMasterId, final String val$underJo, final JsonArray val$allNames) {
            this.val$photo = val$photo;
            this.val$name = val$name;
            this.val$lastname = val$lastname;
            this.val$fdreferenceNumber = val$fdreferenceNumber;
            this.val$processMasterId = val$processMasterId;
            this.val$underJo = val$underJo;
            this.val$allNames = val$allNames;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                Logger.d(ObjecteeRecylerViewForm7.this.deletionObjection, String.valueOf(((JsonObject) response.body()).get("message")));
                ObjecteeRecylerViewForm7.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                this.val$photo[0] = Base64.decode(ObjecteeRecylerViewForm7.this.base64element, 0);
                ObjecteeRecylerViewForm7.this.allnamesList.add(new EpicRecylerViewDataModel("", "", "", "", "", "", this.val$name, this.val$lastname, this.val$fdreferenceNumber, "", "", "", "", "", "", this.val$processMasterId, "", this.val$photo[0], this.val$underJo));
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = ObjecteeRecylerViewForm7.this.commonUtilClass;
                Context contextRequireContext = ObjecteeRecylerViewForm7.this.requireContext();
                String str = ObjecteeRecylerViewForm7.this.refreshToken;
                final JsonArray jsonArray = this.val$allNames;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$3$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str2, String str3) {
                        this.f$0.lambda$onResponse$1(jsonArray, i, str2, str3);
                    }
                });
            }
            ObjecteeRecylerViewForm7.this.allnamesList.add(new EpicRecylerViewDataModel("", "", "", "", "", "", this.val$name, this.val$lastname, this.val$fdreferenceNumber, "", "", "", "", "", "", this.val$processMasterId, "", this.val$photo[0], this.val$underJo));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(JsonArray jsonArray, int i, String str, String str2) {
            ObjecteeRecylerViewForm7.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ObjecteeRecylerViewForm7.this.commonUtilClass.showMessageOK(ObjecteeRecylerViewForm7.this.getContext(), ObjecteeRecylerViewForm7.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ObjecteeRecylerViewForm7.this.token = "Bearer " + str;
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setToken("Bearer " + str);
            ObjecteeRecylerViewForm7.this.renderingdataForObjection(jsonArray);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setLocaleBool(false);
            ObjecteeRecylerViewForm7.this.startActivity(new Intent((Context) ObjecteeRecylerViewForm7.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(ObjecteeRecylerViewForm7.this.deletionObjection, ObjecteeRecylerViewForm7.this.inOnFailure + t.getMessage());
            ObjecteeRecylerViewForm7.this.allnamesList.add(new EpicRecylerViewDataModel("", "", "", "", "", "", this.val$name, this.val$lastname, this.val$fdreferenceNumber, "", "", "", "", "", "", this.val$processMasterId, "", this.val$photo[0], this.val$underJo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renderingdataForObjection$1() {
        Logger.d(this.deletionObjection, "befire initrecycler");
        initRecyclerViewAdapter();
        this.binding.nameRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.nameRv.setAdapter(this.adapter);
        this.alertDialog.dismiss();
    }

    public void getFile(String fileref) {
        Logger.d(this.deletionObjection, "in getFile..............................");
        this.userClient.getFile(this.bucketName, fileref, this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", "blo", this.appName, "ANDROIDMOB").enqueue(new AnonymousClass4(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass4(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                Logger.d(ObjecteeRecylerViewForm7.this.deletionObjection, String.valueOf(((JsonObject) response.body()).get("message")));
                ObjecteeRecylerViewForm7.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
            } else if (response.code() == 401) {
                CommomUtility commomUtility = ObjecteeRecylerViewForm7.this.commonUtilClass;
                Context contextRequireContext = ObjecteeRecylerViewForm7.this.requireContext();
                String str = ObjecteeRecylerViewForm7.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$4$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            ObjecteeRecylerViewForm7.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                ObjecteeRecylerViewForm7.this.commonUtilClass.showMessageOK(ObjecteeRecylerViewForm7.this.getContext(), ObjecteeRecylerViewForm7.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$4$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ObjecteeRecylerViewForm7.this.token = "Bearer " + str2;
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setToken("Bearer " + str2);
            ObjecteeRecylerViewForm7.this.getFile(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ObjecteeRecylerViewForm7.this.requireContext()).setLocaleBool(false);
            ObjecteeRecylerViewForm7.this.startActivity(new Intent((Context) ObjecteeRecylerViewForm7.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(ObjecteeRecylerViewForm7.this.deletionObjection, ObjecteeRecylerViewForm7.this.inOnFailure + t.getMessage());
            ObjecteeRecylerViewForm7 objecteeRecylerViewForm7 = ObjecteeRecylerViewForm7.this;
            objecteeRecylerViewForm7.showdialog(objecteeRecylerViewForm7.alert, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    private void showdialog1(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.ObjecteeRecylerViewForm7$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog1$3(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog1$3(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
