package in.gov.eci.bloapp.views.fragments.electors_list;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloElectorsFilterBinding;
import in.gov.eci.bloapp.databinding.BloElectorsListRvItemsBinding;
import in.gov.eci.bloapp.databinding.BloFragmentElectorsListBinding;
import in.gov.eci.bloapp.model.electors_list.ElectorsListModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ElectorsListFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {
    public static final String ALERT = "Alert";
    private static final String ERROR = "Error";
    private static final String TAG = "ElectorsListFragment";
    List<ElectorsListModel.getEpicList.Root> aadhaarNotReceivedArrayList;
    List<ElectorsListModel.getEpicList.Root> aadhaarReceivedArrayList;
    FilterableRecyclerView adapter;
    List<ElectorsListModel.getEpicList.Root> ageArrayList;
    AlertDialog alertDialog;
    List<ElectorsListModel.getEpicList.Root> allArrayList;
    BloFragmentElectorsListBinding binding;
    BloElectorsFilterBinding electorsFilterBinding;
    List<ElectorsListModel.getEpicList.Root> femaleArrayList;
    List<ElectorsListModel.getEpicList.Root> femaleWithAgeArrayList;
    List<ElectorsListModel.getEpicList.Root> femaleWithRelationAgeArrayList;
    List<ElectorsListModel.getEpicList.Root> femaleWithRelationTypeArrayList;
    GridLayoutManager gridLayoutManager;
    List<ElectorsListModel.getEpicList.Root> mSearchList;
    List<ElectorsListModel.getEpicList.Root> maleArrayList;
    List<ElectorsListModel.getEpicList.Root> maleWithRelationAgeArrayList;
    List<ElectorsListModel.getEpicList.Root> maleWithRelationTypeArrayList;
    List<ElectorsListModel.getEpicList.Root> mobileArrayList;
    List<ElectorsListModel.getEpicList.Root> noMobileArrayList;
    List<ElectorsListModel.getEpicList.Root> pwdArrayList;
    private ArrayAdapter<String> relationadapter;
    List<ElectorsListModel.getEpicList.Root> searchList;
    List<ElectorsListModel.getEpicList.Root> thirdArrayList;
    List<ElectorsListModel.getEpicList.Root> thirdWithRelationAgeArrayList;
    List<ElectorsListModel.getEpicList.Root> thirdWithRelationTypeArrayList;
    ArrayList<String> relationList = new ArrayList<>();
    String token = "";
    String refreshToken = "";
    String sessionTokenExpiredPleaseLogin = "Session token expired please Login";
    String refreshTokenApiCalled = "Refresh token Api Called";
    String currentRole = "";
    String state = "";
    String acNo = "";
    String partNumber = "";
    String noDataPresentForTheGivenFilter = "No Data present for the given filter";
    String genderAll = "All";
    String genderSelected = "Male";
    String genderFemale = "Female";
    String genderThirdGender = "Third Gender";
    String ageSelected = "";
    String genderRadioButtonSelected = "All";
    String aadhaarReceived = "Aadhaar Received";
    String aadhaarNotReceived = "Aadhaar Not Received";
    String pwd = "Pwd";
    String age = "Age >";
    String mobile = "Have Mobile No";
    String noMobile = "Do not have mobile no";
    String mobileNumber = "";
    CommomUtility commomUtility = new CommomUtility();
    String newMmobileNumber = "";
    String fthr = "FTHR";
    String mthr = "MTHR";
    String hsbn = "HSBN";
    String wifeCode = "WIFE";
    String otherCode = "OTHR";
    String father = "Father";
    String mother = "Mother";
    String wife = "Wife";
    String husband = "Husband";
    String other = "Other";
    String selectRelationType = "Select Relation Type";
    String f = "F";
    String m = "M";
    String h = "H";
    String w = "W";
    String o = "O";
    String y = "Y";
    String t = "T";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentElectorsListBinding.inflate(getLayoutInflater());
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.homeButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.currentRole = "blo";
        this.state = SharedPref.getInstance(requireContext()).getStateCode();
        this.acNo = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        Log.d(TAG, "token ---> " + this.token);
        Log.d(TAG, "currentRole ---> " + this.currentRole);
        Log.d(TAG, "state ---> " + this.state);
        Log.d(TAG, "acNo ---> " + this.acNo);
        Log.d(TAG, "partNumber ---> " + this.partNumber);
        this.searchList = new ArrayList();
        this.mSearchList = new ArrayList();
        this.allArrayList = new ArrayList();
        this.maleArrayList = new ArrayList();
        this.femaleArrayList = new ArrayList();
        this.thirdArrayList = new ArrayList();
        this.maleWithRelationTypeArrayList = new ArrayList();
        this.femaleWithRelationTypeArrayList = new ArrayList();
        this.thirdWithRelationTypeArrayList = new ArrayList();
        this.femaleWithAgeArrayList = new ArrayList();
        this.maleWithRelationAgeArrayList = new ArrayList();
        this.femaleWithRelationAgeArrayList = new ArrayList();
        this.thirdWithRelationAgeArrayList = new ArrayList();
        this.aadhaarReceivedArrayList = new ArrayList();
        this.aadhaarNotReceivedArrayList = new ArrayList();
        this.pwdArrayList = new ArrayList();
        this.ageArrayList = new ArrayList();
        this.mobileArrayList = new ArrayList();
        this.noMobileArrayList = new ArrayList();
        initViewModel();
        initClickListener();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    private void initViewModel() {
        this.alertDialog.show();
        Log.d(TAG, "token ---> " + this.token);
        Log.d(TAG, "currentRole ---> " + this.currentRole);
        Log.d(TAG, "state ---> " + this.state);
        Log.d(TAG, "acNo ---> " + this.acNo);
        Log.d(TAG, "partNumber ---> " + this.partNumber);
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", this.currentRole);
        map.put("state", this.state);
        map.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getEpicList(this.state, this.acNo, this.partNumber, map).enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<List<ElectorsListModel.getEpicList.Root>> {
        AnonymousClass1() {
        }

        public void onResponse(Call<List<ElectorsListModel.getEpicList.Root>> call, Response<List<ElectorsListModel.getEpicList.Root>> jsonObject) {
            if (jsonObject.code() == 200) {
                ElectorsListFragment.this.searchList.clear();
                ElectorsListFragment.this.mSearchList.clear();
                ElectorsListFragment.this.allArrayList.clear();
                ElectorsListFragment.this.maleArrayList.clear();
                ElectorsListFragment.this.femaleArrayList.clear();
                ElectorsListFragment.this.thirdArrayList.clear();
                ElectorsListFragment.this.aadhaarReceivedArrayList.clear();
                ElectorsListFragment.this.aadhaarNotReceivedArrayList.clear();
                ElectorsListFragment.this.pwdArrayList.clear();
                ElectorsListFragment.this.ageArrayList.clear();
                ElectorsListFragment.this.mobileArrayList.clear();
                ElectorsListFragment.this.noMobileArrayList.clear();
                for (int i = 0; i < ((List) jsonObject.body()).size(); i++) {
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getAadharStatus() == null) {
                        ((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).setAadharStatus("N");
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getGender() == null) {
                        ((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).setGender("");
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getPwd() == null) {
                        ((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).setPwd("N");
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getMobile() == null) {
                        ((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).setMobile("");
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getEpic() == null) {
                        ((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).setEpic("");
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getAge() == null) {
                        ((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).setAge("");
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getApplicantName() == null) {
                        ((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).setApplicantName("");
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getRelationType() == null) {
                        ((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).setRelationType("");
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getGender().equalsIgnoreCase(ElectorsListFragment.this.m)) {
                        ElectorsListFragment.this.maleArrayList.add((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i));
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getGender().equalsIgnoreCase(ElectorsListFragment.this.f)) {
                        ElectorsListFragment.this.femaleArrayList.add((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i));
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getGender().equalsIgnoreCase(ElectorsListFragment.this.t)) {
                        ElectorsListFragment.this.thirdArrayList.add((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i));
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getAadharStatus().equalsIgnoreCase(ElectorsListFragment.this.y)) {
                        ElectorsListFragment.this.aadhaarReceivedArrayList.add((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i));
                    }
                    if (!((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getAadharStatus().equalsIgnoreCase(ElectorsListFragment.this.y)) {
                        ElectorsListFragment.this.aadhaarNotReceivedArrayList.add((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i));
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getPwd().equalsIgnoreCase(ElectorsListFragment.this.y)) {
                        ElectorsListFragment.this.pwdArrayList.add((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i));
                    }
                    if (((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getMobile().equalsIgnoreCase("")) {
                        ElectorsListFragment.this.noMobileArrayList.add((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i));
                    }
                    if (!((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i)).getMobile().equalsIgnoreCase("")) {
                        ElectorsListFragment.this.mobileArrayList.add((ElectorsListModel.getEpicList.Root) ((List) jsonObject.body()).get(i));
                    }
                }
                ElectorsListFragment.this.searchList.addAll((Collection) jsonObject.body());
                ElectorsListFragment.this.binding.selectedFilter.setText("All");
                ElectorsListFragment.this.binding.totalElectors.setText("" + ElectorsListFragment.this.searchList.size());
                ElectorsListFragment.this.allArrayList.addAll((Collection) jsonObject.body());
                ElectorsListFragment.this.allArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                ElectorsListFragment.this.searchList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                ElectorsListFragment.this.maleArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                ElectorsListFragment.this.femaleArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                ElectorsListFragment.this.thirdArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                ElectorsListFragment.this.aadhaarReceivedArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                ElectorsListFragment.this.aadhaarNotReceivedArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                ElectorsListFragment.this.pwdArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                ElectorsListFragment.this.mobileArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                ElectorsListFragment.this.noMobileArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                ElectorsListFragment.this.initRecyclerViewAdapter();
                return;
            }
            if (jsonObject.code() == 401) {
                ElectorsListFragment.this.commomUtility.getRefreshToken(ElectorsListFragment.this.requireContext(), ElectorsListFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$1$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str, String str2) {
                        this.f$0.lambda$onResponse$3(i2, str, str2);
                    }
                });
                return;
            }
            try {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$1$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$4();
                    }
                }, 2000L);
                String strOptString = new JSONObject(jsonObject.errorBody().string()).optString("message");
                Logger.d(ElectorsListFragment.TAG, "eroPasswordFlow errorResponse --> " + strOptString);
                ElectorsListFragment.this.commomUtility.showMessageWithTitleOK(ElectorsListFragment.this.requireContext(), "Get EpicList Api Error - " + jsonObject.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$1$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$5(dialogInterface, i2);
                    }
                });
            } catch (IOException | JSONException e) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$1$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$6();
                    }
                }, 2000L);
                ElectorsListFragment.this.commomUtility.showMessageWithTitleOK(ElectorsListFragment.this.requireContext(), "Get EpicList Error Catch - " + jsonObject.code(), e.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$1$$ExternalSyntheticLambda7
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$7(dialogInterface, i2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(int i, String str, String str2) {
            ElectorsListFragment.this.alertDialog.dismiss();
            System.out.println(ElectorsListFragment.this.refreshTokenApiCalled + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ElectorsListFragment.this.commomUtility.showMessageOK(ElectorsListFragment.this.getContext(), ElectorsListFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ElectorsListFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ElectorsListFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ElectorsListFragment.this.requireContext()).setToken("Bearer " + str);
            ElectorsListFragment.this.commomUtility.showMessageWithTitleOK(ElectorsListFragment.this.requireContext(), "Alert", "Page refreshed due to the token expiry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$1$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onResponse$2(dialogInterface, i2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ElectorsListFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ElectorsListFragment.this.requireContext()).setLocaleBool(false);
            ElectorsListFragment.this.startActivity(new Intent((Context) ElectorsListFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            ElectorsListFragment.this.alertDialog.show();
            ((FragmentActivity) Objects.requireNonNull(ElectorsListFragment.this.getActivity())).getSupportFragmentManager().beginTransaction().replace(ElectorsListFragment.this.getId(), new ElectorsListFragment()).commit();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$1();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            ElectorsListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4() {
            ElectorsListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5(DialogInterface dialogInterface, int i) {
            ElectorsListFragment.this.startActivity(new Intent((Context) ElectorsListFragment.this.getActivity(), (Class<?>) MainActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$6() {
            ElectorsListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$7(DialogInterface dialogInterface, int i) {
            ElectorsListFragment.this.startActivity(new Intent((Context) ElectorsListFragment.this.getActivity(), (Class<?>) MainActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$8() {
            ElectorsListFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<List<ElectorsListModel.getEpicList.Root>> call, Throwable t) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$1$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$8();
                }
            }, 2000L);
            ElectorsListFragment.this.commomUtility.showMessageWithTitleOK(ElectorsListFragment.this.requireContext(), "Get EpicList Error On Failure - ", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$1$$ExternalSyntheticLambda9
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onFailure$9(dialogInterface, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$9(DialogInterface dialogInterface, int i) {
            ElectorsListFragment.this.startActivity(new Intent((Context) ElectorsListFragment.this.getActivity(), (Class<?>) MainActivity.class));
        }
    }

    private void showFilter() {
        this.binding.mainLayout.setVisibility(8);
        this.electorsFilterBinding = BloElectorsFilterBinding.inflate(getLayoutInflater());
        final Dialog dialog = new Dialog(requireActivity());
        dialog.requestWindowFeature(1);
        dialog.setContentView((View) this.electorsFilterBinding.getRoot());
        dialog.setCancelable(false);
        dialog.show();
        ((Window) Objects.requireNonNull(dialog.getWindow())).setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        this.electorsFilterBinding.filterRadioGroup.setOnCheckedChangeListener(this);
        this.electorsFilterBinding.ralationTypeCheckBox.setOnCheckedChangeListener(this);
        this.electorsFilterBinding.ageCheckBox.setOnCheckedChangeListener(this);
        this.electorsFilterBinding.maleRadioButton.setOnCheckedChangeListener(this);
        this.electorsFilterBinding.femaleRadioButton.setOnCheckedChangeListener(this);
        this.electorsFilterBinding.thirdGenderRadioButton.setOnCheckedChangeListener(this);
        if (Objects.equals(this.genderRadioButtonSelected, this.genderAll)) {
            this.electorsFilterBinding.filterRadioGroup.check(R.id.allGenderRadioButton);
            this.ageSelected = "";
            this.electorsFilterBinding.ageEdit.setText(this.ageSelected);
            this.ageArrayList.clear();
        } else if (Objects.equals(this.genderRadioButtonSelected, this.genderSelected)) {
            this.electorsFilterBinding.filterRadioGroup.check(R.id.genderRadioButton);
            this.ageSelected = "";
            this.electorsFilterBinding.ageEdit.setText(this.ageSelected);
            this.ageArrayList.clear();
        } else if (Objects.equals(this.genderRadioButtonSelected, this.aadhaarReceived)) {
            this.electorsFilterBinding.filterRadioGroup.check(R.id.receivedRadioButton);
            this.ageSelected = "";
            this.electorsFilterBinding.ageEdit.setText(this.ageSelected);
            this.ageArrayList.clear();
        } else if (Objects.equals(this.genderRadioButtonSelected, this.aadhaarNotReceived)) {
            this.electorsFilterBinding.filterRadioGroup.check(R.id.notReceivedRadioButton);
            this.ageSelected = "";
            this.electorsFilterBinding.ageEdit.setText(this.ageSelected);
            this.ageArrayList.clear();
        } else if (Objects.equals(this.genderRadioButtonSelected, this.pwd)) {
            this.electorsFilterBinding.filterRadioGroup.check(R.id.pwdRadioButton);
            this.ageSelected = "";
            this.electorsFilterBinding.ageEdit.setText(this.ageSelected);
            this.ageArrayList.clear();
        } else if (Objects.equals(this.genderRadioButtonSelected, this.age)) {
            this.electorsFilterBinding.filterRadioGroup.check(R.id.ageRadioButton);
        } else if (Objects.equals(this.genderRadioButtonSelected, this.mobile)) {
            this.electorsFilterBinding.filterRadioGroup.check(R.id.mobileRadioButton);
            this.ageSelected = "";
            this.electorsFilterBinding.ageEdit.setText(this.ageSelected);
            this.ageArrayList.clear();
        } else if (Objects.equals(this.genderRadioButtonSelected, this.noMobile)) {
            this.electorsFilterBinding.filterRadioGroup.check(R.id.noMobileRadioButton);
            this.ageSelected = "";
            this.electorsFilterBinding.ageEdit.setText(this.ageSelected);
            this.ageArrayList.clear();
        }
        this.electorsFilterBinding.femaleFilterImageAdd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showFilter$1(view);
            }
        });
        this.electorsFilterBinding.femaleFilterImageRemove.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showFilter$2(view);
            }
        });
        this.electorsFilterBinding.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showFilter$3(dialog, view);
            }
        });
        this.electorsFilterBinding.filterButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showFilter$17(dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFilter$1(View view) {
        this.electorsFilterBinding.ralationTypeCheckBox.setChecked(false);
        this.electorsFilterBinding.ageCheckBox.setChecked(false);
        if (this.electorsFilterBinding.maleRadioButton.isChecked()) {
            this.relationList.clear();
            this.relationList.add(this.selectRelationType);
            this.relationList.add(this.father);
            this.relationList.add(this.mother);
            this.relationList.add(this.wife);
            this.relationList.add(this.other);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
            this.relationadapter = arrayAdapter;
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
            this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
        } else if (this.electorsFilterBinding.femaleRadioButton.isChecked()) {
            this.relationList.clear();
            this.relationList.add(this.selectRelationType);
            this.relationList.add(this.father);
            this.relationList.add(this.mother);
            this.relationList.add(this.husband);
            this.relationList.add(this.other);
            ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
            this.relationadapter = arrayAdapter2;
            arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
            this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
        } else if (this.electorsFilterBinding.thirdGenderRadioButton.isChecked()) {
            this.relationList.clear();
            this.relationList.add(this.selectRelationType);
            this.relationList.add(this.father);
            this.relationList.add(this.mother);
            this.relationList.add(this.husband);
            this.relationList.add(this.wife);
            this.relationList.add(this.other);
            ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
            this.relationadapter = arrayAdapter3;
            arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
            this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
        }
        this.electorsFilterBinding.femaleFilterImageAdd.setVisibility(8);
        this.electorsFilterBinding.femaleFilterImageRemove.setVisibility(0);
        this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFilter$2(View view) {
        this.electorsFilterBinding.ralationTypeCheckBox.setChecked(false);
        this.electorsFilterBinding.ageCheckBox.setChecked(false);
        if (this.electorsFilterBinding.maleRadioButton.isChecked()) {
            this.relationList.clear();
            this.relationList.add(this.selectRelationType);
            this.relationList.add(this.father);
            this.relationList.add(this.mother);
            this.relationList.add(this.wife);
            this.relationList.add(this.other);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
            this.relationadapter = arrayAdapter;
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
            this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
        } else if (this.electorsFilterBinding.femaleRadioButton.isChecked()) {
            this.relationList.clear();
            this.relationList.add(this.selectRelationType);
            this.relationList.add(this.father);
            this.relationList.add(this.mother);
            this.relationList.add(this.husband);
            this.relationList.add(this.other);
            ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
            this.relationadapter = arrayAdapter2;
            arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
            this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
        } else if (this.electorsFilterBinding.thirdGenderRadioButton.isChecked()) {
            this.relationList.clear();
            this.relationList.add(this.selectRelationType);
            this.relationList.add(this.father);
            this.relationList.add(this.mother);
            this.relationList.add(this.husband);
            this.relationList.add(this.wife);
            this.relationList.add(this.other);
            ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
            this.relationadapter = arrayAdapter3;
            arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
            this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
        }
        this.electorsFilterBinding.femaleFilterImageAdd.setVisibility(0);
        this.electorsFilterBinding.femaleFilterImageRemove.setVisibility(8);
        this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFilter$3(Dialog dialog, View view) {
        this.searchList.clear();
        this.searchList.addAll(this.allArrayList);
        this.genderRadioButtonSelected = this.genderAll;
        this.binding.selectedFilter.setText("All");
        this.binding.totalElectors.setText("" + this.allArrayList.size());
        this.electorsFilterBinding.filterRadioGroup.check(R.id.allGenderRadioButton);
        applyFilter();
        dialog.dismiss();
        this.alertDialog.show();
        this.binding.mainLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFilter$17(Dialog dialog, View view) {
        if (this.electorsFilterBinding.ageRadioButton.isChecked()) {
            if (validation()) {
                this.searchList.clear();
                this.ageArrayList.clear();
                this.ageSelected = this.electorsFilterBinding.ageEdit.getText().toString();
                for (int i = 0; i < this.allArrayList.size(); i++) {
                    if (Integer.parseInt(this.allArrayList.get(i).getAge()) >= Integer.parseInt(this.electorsFilterBinding.ageEdit.getText().toString())) {
                        this.ageArrayList.add(this.allArrayList.get(i));
                    }
                }
                this.ageArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                List<ElectorsListModel.getEpicList.Root> list = this.ageArrayList;
                if (list != null && !list.isEmpty()) {
                    this.searchList.addAll(this.ageArrayList);
                    this.genderRadioButtonSelected = this.age;
                    this.binding.selectedFilter.setText("Age");
                    this.binding.totalElectors.setText("" + this.ageArrayList.size());
                    applyFilter();
                    dialog.dismiss();
                    this.alertDialog.show();
                    this.binding.mainLayout.setVisibility(0);
                    return;
                }
                this.genderRadioButtonSelected = this.genderAll;
                this.electorsFilterBinding.filterRadioGroup.check(R.id.allGenderRadioButton);
                this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, "No Data present for the given age", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda17
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            }
            return;
        }
        if (this.electorsFilterBinding.genderRadioButton.isChecked()) {
            if (genderValidation()) {
                if (this.electorsFilterBinding.maleRadioButton.isChecked() && !this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && !this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    this.electorsFilterBinding.ageEdit.setVisibility(8);
                    this.searchList.clear();
                    List<ElectorsListModel.getEpicList.Root> list2 = this.maleArrayList;
                    if (list2 != null && !list2.isEmpty()) {
                        this.searchList.addAll(this.maleArrayList);
                        this.binding.selectedFilter.setText("Male");
                        this.binding.totalElectors.setText("" + this.maleArrayList.size());
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, "No Data present for female gender", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda20
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                if (this.electorsFilterBinding.femaleRadioButton.isChecked() && !this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && !this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    this.electorsFilterBinding.ageEdit.setVisibility(8);
                    this.searchList.clear();
                    List<ElectorsListModel.getEpicList.Root> list3 = this.femaleArrayList;
                    if (list3 != null && !list3.isEmpty()) {
                        this.searchList.addAll(this.femaleArrayList);
                        this.binding.selectedFilter.setText("Female");
                        this.binding.totalElectors.setText("" + this.femaleArrayList.size());
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, "No Data present for female gender", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda21
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                if (this.electorsFilterBinding.thirdGenderRadioButton.isChecked() && !this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && !this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    this.electorsFilterBinding.ageEdit.setVisibility(8);
                    this.searchList.clear();
                    List<ElectorsListModel.getEpicList.Root> list4 = this.thirdArrayList;
                    if (list4 != null && !list4.isEmpty()) {
                        this.searchList.addAll(this.thirdArrayList);
                        this.genderRadioButtonSelected = this.genderThirdGender;
                        this.binding.selectedFilter.setText(this.genderThirdGender);
                        this.binding.totalElectors.setText("" + this.thirdArrayList.size());
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, "No Data present for third gender", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda23
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                if (this.electorsFilterBinding.maleRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && !this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    String string = this.electorsFilterBinding.relationTypeSpinner.getSelectedItem().toString();
                    this.searchList.clear();
                    this.maleWithRelationTypeArrayList.clear();
                    for (int i2 = 0; i2 < this.allArrayList.size(); i2++) {
                        if (string.equals(this.father)) {
                            if (this.allArrayList.get(i2).getGender().equalsIgnoreCase(this.m) && (this.allArrayList.get(i2).getRelationType().equalsIgnoreCase(this.f) || this.allArrayList.get(i2).getRelationType().equalsIgnoreCase(this.fthr))) {
                                this.maleWithRelationTypeArrayList.add(this.allArrayList.get(i2));
                            }
                        } else if (string.equals(this.mother)) {
                            if (this.allArrayList.get(i2).getGender().equalsIgnoreCase(this.m) && (this.allArrayList.get(i2).getRelationType().equalsIgnoreCase(this.m) || this.allArrayList.get(i2).getRelationType().equalsIgnoreCase(this.mthr))) {
                                this.maleWithRelationTypeArrayList.add(this.allArrayList.get(i2));
                            }
                        } else if (string.equals(this.husband)) {
                            if (this.allArrayList.get(i2).getGender().equalsIgnoreCase(this.m) && (this.allArrayList.get(i2).getRelationType().equalsIgnoreCase(this.h) || this.allArrayList.get(i2).getRelationType().equalsIgnoreCase(this.hsbn))) {
                                this.maleWithRelationTypeArrayList.add(this.allArrayList.get(i2));
                            }
                        } else if (string.equals(this.wife)) {
                            if (this.allArrayList.get(i2).getGender().equalsIgnoreCase(this.m) && (this.allArrayList.get(i2).getRelationType().equalsIgnoreCase(this.w) || this.allArrayList.get(i2).getRelationType().equalsIgnoreCase(this.wifeCode))) {
                                this.maleWithRelationTypeArrayList.add(this.allArrayList.get(i2));
                            }
                        } else if (string.equals(this.other) && this.allArrayList.get(i2).getGender().equalsIgnoreCase(this.m) && (this.allArrayList.get(i2).getRelationType().equalsIgnoreCase(this.o) || this.allArrayList.get(i2).getRelationType().equalsIgnoreCase(this.otherCode))) {
                            this.maleWithRelationTypeArrayList.add(this.allArrayList.get(i2));
                        }
                    }
                    this.maleWithRelationTypeArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                    List<ElectorsListModel.getEpicList.Root> list5 = this.maleWithRelationTypeArrayList;
                    if (list5 != null && !list5.isEmpty()) {
                        this.searchList.addAll(this.maleWithRelationTypeArrayList);
                        this.binding.totalElectors.setText("(" + this.maleWithRelationTypeArrayList.size() + ")");
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, this.noDataPresentForTheGivenFilter, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda24
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                if (this.electorsFilterBinding.femaleRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && !this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    String string2 = this.electorsFilterBinding.relationTypeSpinner.getSelectedItem().toString();
                    this.searchList.clear();
                    this.femaleWithRelationTypeArrayList.clear();
                    for (int i3 = 0; i3 < this.allArrayList.size(); i3++) {
                        if (string2.equals(this.father)) {
                            if (this.allArrayList.get(i3).getGender().equalsIgnoreCase(this.f) && (this.allArrayList.get(i3).getRelationType().equalsIgnoreCase(this.f) || this.allArrayList.get(i3).getRelationType().equalsIgnoreCase(this.fthr))) {
                                this.femaleWithRelationTypeArrayList.add(this.allArrayList.get(i3));
                            }
                        } else if (string2.equals(this.mother)) {
                            if (this.allArrayList.get(i3).getGender().equalsIgnoreCase(this.f) && (this.allArrayList.get(i3).getRelationType().equalsIgnoreCase(this.m) || this.allArrayList.get(i3).getRelationType().equalsIgnoreCase(this.mthr))) {
                                this.femaleWithRelationTypeArrayList.add(this.allArrayList.get(i3));
                            }
                        } else if (string2.equals(this.husband)) {
                            if (this.allArrayList.get(i3).getGender().equalsIgnoreCase(this.f) && (this.allArrayList.get(i3).getRelationType().equalsIgnoreCase(this.h) || this.allArrayList.get(i3).getRelationType().equalsIgnoreCase(this.hsbn))) {
                                this.femaleWithRelationTypeArrayList.add(this.allArrayList.get(i3));
                            }
                        } else if (string2.equals(this.wife)) {
                            if (this.allArrayList.get(i3).getGender().equalsIgnoreCase(this.f) && (this.allArrayList.get(i3).getRelationType().equalsIgnoreCase(this.w) || this.allArrayList.get(i3).getRelationType().equalsIgnoreCase(this.wifeCode))) {
                                this.femaleWithRelationTypeArrayList.add(this.allArrayList.get(i3));
                            }
                        } else if (string2.equals(this.other) && this.allArrayList.get(i3).getGender().equalsIgnoreCase(this.f) && (this.allArrayList.get(i3).getRelationType().equalsIgnoreCase(this.o) || this.allArrayList.get(i3).getRelationType().equalsIgnoreCase(this.otherCode))) {
                            this.femaleWithRelationTypeArrayList.add(this.allArrayList.get(i3));
                        }
                    }
                    this.femaleWithRelationTypeArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                    List<ElectorsListModel.getEpicList.Root> list6 = this.femaleWithRelationTypeArrayList;
                    if (list6 != null && !list6.isEmpty()) {
                        this.searchList.addAll(this.femaleWithRelationTypeArrayList);
                        this.binding.selectedFilter.setText("Female with Relation Type " + string2);
                        this.binding.totalElectors.setText("" + this.femaleWithRelationTypeArrayList.size());
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, this.noDataPresentForTheGivenFilter, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda25
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                if (this.electorsFilterBinding.thirdGenderRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && !this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    String string3 = this.electorsFilterBinding.relationTypeSpinner.getSelectedItem().toString();
                    this.searchList.clear();
                    this.thirdWithRelationTypeArrayList.clear();
                    for (int i4 = 0; i4 < this.allArrayList.size(); i4++) {
                        if (string3.equals(this.father)) {
                            if (this.allArrayList.get(i4).getGender().equalsIgnoreCase(this.t) && (this.allArrayList.get(i4).getRelationType().equalsIgnoreCase(this.f) || this.allArrayList.get(i4).getRelationType().equalsIgnoreCase(this.fthr))) {
                                this.thirdWithRelationTypeArrayList.add(this.allArrayList.get(i4));
                            }
                        } else if (string3.equals(this.mother)) {
                            if (this.allArrayList.get(i4).getGender().equalsIgnoreCase(this.t) && (this.allArrayList.get(i4).getRelationType().equalsIgnoreCase(this.m) || this.allArrayList.get(i4).getRelationType().equalsIgnoreCase(this.mthr))) {
                                this.thirdWithRelationTypeArrayList.add(this.allArrayList.get(i4));
                            }
                        } else if (string3.equals(this.husband)) {
                            if (this.allArrayList.get(i4).getGender().equalsIgnoreCase(this.t) && (this.allArrayList.get(i4).getRelationType().equalsIgnoreCase(this.h) || this.allArrayList.get(i4).getRelationType().equalsIgnoreCase(this.hsbn))) {
                                this.thirdWithRelationTypeArrayList.add(this.allArrayList.get(i4));
                            }
                        } else if (string3.equals(this.wife)) {
                            if (this.allArrayList.get(i4).getGender().equalsIgnoreCase(this.t) && (this.allArrayList.get(i4).getRelationType().equalsIgnoreCase(this.w) || this.allArrayList.get(i4).getRelationType().equalsIgnoreCase(this.wifeCode))) {
                                this.thirdWithRelationTypeArrayList.add(this.allArrayList.get(i4));
                            }
                        } else if (string3.equals(this.other) && this.allArrayList.get(i4).getGender().equalsIgnoreCase(this.t) && (this.allArrayList.get(i4).getRelationType().equalsIgnoreCase(this.o) || this.allArrayList.get(i4).getRelationType().equalsIgnoreCase(this.otherCode))) {
                            this.thirdWithRelationTypeArrayList.add(this.allArrayList.get(i4));
                        }
                    }
                    this.thirdWithRelationTypeArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                    List<ElectorsListModel.getEpicList.Root> list7 = this.thirdWithRelationTypeArrayList;
                    if (list7 != null && !list7.isEmpty()) {
                        this.searchList.addAll(this.thirdWithRelationTypeArrayList);
                        this.binding.totalElectors.setText("(" + this.thirdWithRelationTypeArrayList.size() + ")");
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, this.noDataPresentForTheGivenFilter, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda12
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i5) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                if (this.electorsFilterBinding.maleRadioButton.isChecked() && !this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    this.searchList.clear();
                    this.maleWithRelationAgeArrayList.clear();
                    for (int i5 = 0; i5 < this.allArrayList.size(); i5++) {
                        if (this.allArrayList.get(i5).getGender().equalsIgnoreCase(this.m) && Integer.parseInt(this.allArrayList.get(i5).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString())) {
                            this.maleWithRelationAgeArrayList.add(this.allArrayList.get(i5));
                        }
                    }
                    this.maleWithRelationAgeArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                    List<ElectorsListModel.getEpicList.Root> list8 = this.maleWithRelationAgeArrayList;
                    if (list8 != null && !list8.isEmpty()) {
                        this.searchList.addAll(this.maleWithRelationAgeArrayList);
                        this.binding.totalElectors.setText("(" + this.maleWithRelationAgeArrayList.size() + ")");
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, this.noDataPresentForTheGivenFilter, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda13
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i6) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                if (this.electorsFilterBinding.femaleRadioButton.isChecked() && !this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    this.searchList.clear();
                    this.femaleWithAgeArrayList.clear();
                    for (int i6 = 0; i6 < this.allArrayList.size(); i6++) {
                        if (this.allArrayList.get(i6).getGender().equalsIgnoreCase(this.f) && Integer.parseInt(this.allArrayList.get(i6).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString())) {
                            this.femaleWithAgeArrayList.add(this.allArrayList.get(i6));
                        }
                    }
                    this.femaleWithAgeArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                    List<ElectorsListModel.getEpicList.Root> list9 = this.femaleWithAgeArrayList;
                    if (list9 != null && !list9.isEmpty()) {
                        this.searchList.addAll(this.femaleWithAgeArrayList);
                        this.binding.selectedFilter.setText("Female with Age >= " + this.electorsFilterBinding.genderAgeEdit.getText().toString());
                        this.binding.totalElectors.setText("" + this.femaleWithAgeArrayList.size());
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, this.noDataPresentForTheGivenFilter, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda14
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i7) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                if (this.electorsFilterBinding.thirdGenderRadioButton.isChecked() && !this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    this.searchList.clear();
                    this.thirdWithRelationAgeArrayList.clear();
                    for (int i7 = 0; i7 < this.allArrayList.size(); i7++) {
                        if (this.allArrayList.get(i7).getGender().equalsIgnoreCase(this.t) && Integer.parseInt(this.allArrayList.get(i7).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString())) {
                            this.thirdWithRelationAgeArrayList.add(this.allArrayList.get(i7));
                        }
                    }
                    this.thirdWithRelationAgeArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                    List<ElectorsListModel.getEpicList.Root> list10 = this.thirdWithRelationAgeArrayList;
                    if (list10 != null && !list10.isEmpty()) {
                        this.searchList.addAll(this.thirdWithRelationAgeArrayList);
                        this.binding.totalElectors.setText("(" + this.thirdWithRelationAgeArrayList.size() + ")");
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, this.noDataPresentForTheGivenFilter, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda15
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i8) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                if (this.electorsFilterBinding.maleRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    String string4 = this.electorsFilterBinding.relationTypeSpinner.getSelectedItem().toString();
                    this.searchList.clear();
                    this.maleWithRelationAgeArrayList.clear();
                    for (int i8 = 0; i8 < this.allArrayList.size(); i8++) {
                        if (string4.equals(this.father)) {
                            if (this.allArrayList.get(i8).getGender().equalsIgnoreCase(this.m) && Integer.parseInt(this.allArrayList.get(i8).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i8).getRelationType().equalsIgnoreCase(this.f) || this.allArrayList.get(i8).getRelationType().equalsIgnoreCase(this.fthr))) {
                                this.maleWithRelationAgeArrayList.add(this.allArrayList.get(i8));
                            }
                        } else if (string4.equals(this.mother)) {
                            if (this.allArrayList.get(i8).getGender().equalsIgnoreCase(this.m) && Integer.parseInt(this.allArrayList.get(i8).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i8).getRelationType().equalsIgnoreCase(this.m) || this.allArrayList.get(i8).getRelationType().equalsIgnoreCase(this.mthr))) {
                                this.maleWithRelationAgeArrayList.add(this.allArrayList.get(i8));
                            }
                        } else if (string4.equals(this.husband)) {
                            if (this.allArrayList.get(i8).getGender().equalsIgnoreCase(this.m) && Integer.parseInt(this.allArrayList.get(i8).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i8).getRelationType().equalsIgnoreCase(this.h) || this.allArrayList.get(i8).getRelationType().equalsIgnoreCase(this.hsbn))) {
                                this.maleWithRelationAgeArrayList.add(this.allArrayList.get(i8));
                            }
                        } else if (string4.equals(this.wife)) {
                            if (this.allArrayList.get(i8).getGender().equalsIgnoreCase(this.m) && Integer.parseInt(this.allArrayList.get(i8).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i8).getRelationType().equalsIgnoreCase(this.w) || this.allArrayList.get(i8).getRelationType().equalsIgnoreCase(this.wifeCode))) {
                                this.maleWithRelationAgeArrayList.add(this.allArrayList.get(i8));
                            }
                        } else if (string4.equals(this.other) && this.allArrayList.get(i8).getGender().equalsIgnoreCase(this.m) && Integer.parseInt(this.allArrayList.get(i8).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i8).getRelationType().equalsIgnoreCase(this.o) || this.allArrayList.get(i8).getRelationType().equalsIgnoreCase(this.otherCode))) {
                            this.maleWithRelationAgeArrayList.add(this.allArrayList.get(i8));
                        }
                    }
                    this.maleWithRelationAgeArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                    List<ElectorsListModel.getEpicList.Root> list11 = this.maleWithRelationAgeArrayList;
                    if (list11 != null && !list11.isEmpty()) {
                        this.searchList.addAll(this.maleWithRelationAgeArrayList);
                        this.binding.totalElectors.setText("(" + this.maleWithRelationAgeArrayList.size() + ")");
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, this.noDataPresentForTheGivenFilter, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda16
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i9) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                if (this.electorsFilterBinding.femaleRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    String string5 = this.electorsFilterBinding.relationTypeSpinner.getSelectedItem().toString();
                    this.searchList.clear();
                    this.femaleWithRelationAgeArrayList.clear();
                    for (int i9 = 0; i9 < this.allArrayList.size(); i9++) {
                        if (string5.equals(this.father)) {
                            if (this.allArrayList.get(i9).getGender().equalsIgnoreCase(this.f) && Integer.parseInt(this.allArrayList.get(i9).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i9).getRelationType().equalsIgnoreCase(this.f) || this.allArrayList.get(i9).getRelationType().equalsIgnoreCase(this.fthr))) {
                                this.femaleWithRelationAgeArrayList.add(this.allArrayList.get(i9));
                            }
                        } else if (string5.equals(this.mother)) {
                            if (this.allArrayList.get(i9).getGender().equalsIgnoreCase(this.f) && Integer.parseInt(this.allArrayList.get(i9).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i9).getRelationType().equalsIgnoreCase(this.m) || this.allArrayList.get(i9).getRelationType().equalsIgnoreCase(this.mthr))) {
                                this.femaleWithRelationAgeArrayList.add(this.allArrayList.get(i9));
                            }
                        } else if (string5.equals(this.husband)) {
                            if (this.allArrayList.get(i9).getGender().equalsIgnoreCase(this.f) && Integer.parseInt(this.allArrayList.get(i9).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i9).getRelationType().equalsIgnoreCase(this.h) || this.allArrayList.get(i9).getRelationType().equalsIgnoreCase(this.hsbn))) {
                                this.femaleWithRelationAgeArrayList.add(this.allArrayList.get(i9));
                            }
                        } else if (string5.equals(this.wife)) {
                            if (this.allArrayList.get(i9).getGender().equalsIgnoreCase(this.f) && Integer.parseInt(this.allArrayList.get(i9).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i9).getRelationType().equalsIgnoreCase(this.w) || this.allArrayList.get(i9).getRelationType().equalsIgnoreCase(this.wifeCode))) {
                                this.femaleWithRelationAgeArrayList.add(this.allArrayList.get(i9));
                            }
                        } else if (string5.equals(this.other) && this.allArrayList.get(i9).getGender().equalsIgnoreCase(this.f) && Integer.parseInt(this.allArrayList.get(i9).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i9).getRelationType().equalsIgnoreCase(this.o) || this.allArrayList.get(i9).getRelationType().equalsIgnoreCase(this.otherCode))) {
                            this.femaleWithRelationAgeArrayList.add(this.allArrayList.get(i9));
                        }
                    }
                    this.femaleWithRelationAgeArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                    List<ElectorsListModel.getEpicList.Root> list12 = this.femaleWithRelationAgeArrayList;
                    if (list12 != null && !list12.isEmpty()) {
                        this.searchList.addAll(this.femaleWithRelationAgeArrayList);
                        this.binding.selectedFilter.setText("Female with Relation Type " + string5 + " and  Age >= " + this.electorsFilterBinding.genderAgeEdit.getText().toString());
                        this.binding.totalElectors.setText("" + this.femaleWithRelationAgeArrayList.size());
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, this.noDataPresentForTheGivenFilter, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda18
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i10) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                if (this.electorsFilterBinding.thirdGenderRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
                    String string6 = this.electorsFilterBinding.relationTypeSpinner.getSelectedItem().toString();
                    this.searchList.clear();
                    this.thirdWithRelationAgeArrayList.clear();
                    for (int i10 = 0; i10 < this.allArrayList.size(); i10++) {
                        if (string6.equals(this.father)) {
                            if (this.allArrayList.get(i10).getGender().equalsIgnoreCase(this.t) && Integer.parseInt(this.allArrayList.get(i10).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i10).getRelationType().equalsIgnoreCase(this.f) || this.allArrayList.get(i10).getRelationType().equalsIgnoreCase(this.fthr))) {
                                this.thirdWithRelationAgeArrayList.add(this.allArrayList.get(i10));
                            }
                        } else if (string6.equals(this.mother)) {
                            if (this.allArrayList.get(i10).getGender().equalsIgnoreCase(this.t) && Integer.parseInt(this.allArrayList.get(i10).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i10).getRelationType().equalsIgnoreCase(this.m) || this.allArrayList.get(i10).getRelationType().equalsIgnoreCase(this.mthr))) {
                                this.thirdWithRelationAgeArrayList.add(this.allArrayList.get(i10));
                            }
                        } else if (string6.equals(this.husband)) {
                            if (this.allArrayList.get(i10).getGender().equalsIgnoreCase(this.t) && Integer.parseInt(this.allArrayList.get(i10).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i10).getRelationType().equalsIgnoreCase(this.h) || this.allArrayList.get(i10).getRelationType().equalsIgnoreCase(this.hsbn))) {
                                this.thirdWithRelationAgeArrayList.add(this.allArrayList.get(i10));
                            }
                        } else if (string6.equals(this.wife)) {
                            if (this.allArrayList.get(i10).getGender().equalsIgnoreCase(this.t) && Integer.parseInt(this.allArrayList.get(i10).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i10).getRelationType().equalsIgnoreCase(this.w) || this.allArrayList.get(i10).getRelationType().equalsIgnoreCase(this.wifeCode))) {
                                this.thirdWithRelationAgeArrayList.add(this.allArrayList.get(i10));
                            }
                        } else if (string6.equals(this.other) && this.allArrayList.get(i10).getGender().equalsIgnoreCase(this.t) && Integer.parseInt(this.allArrayList.get(i10).getAge()) >= Integer.parseInt(this.electorsFilterBinding.genderAgeEdit.getText().toString()) && (this.allArrayList.get(i10).getRelationType().equalsIgnoreCase(this.o) || this.allArrayList.get(i10).getRelationType().equalsIgnoreCase(this.otherCode))) {
                            this.thirdWithRelationAgeArrayList.add(this.allArrayList.get(i10));
                        }
                    }
                    this.thirdWithRelationAgeArrayList.sort(Comparator.comparingInt(new ElectorsListFragment$$ExternalSyntheticLambda10()));
                    List<ElectorsListModel.getEpicList.Root> list13 = this.thirdWithRelationAgeArrayList;
                    if (list13 != null && !list13.isEmpty()) {
                        this.searchList.addAll(this.thirdWithRelationAgeArrayList);
                        this.binding.totalElectors.setText("(" + this.thirdWithRelationAgeArrayList.size() + ")");
                        applyFilter();
                        dialog.dismiss();
                        this.alertDialog.show();
                        this.binding.mainLayout.setVisibility(0);
                        return;
                    }
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, this.noDataPresentForTheGivenFilter, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda19
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i11) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        applyFilter();
        dialog.dismiss();
        this.alertDialog.show();
        this.binding.mainLayout.setVisibility(0);
    }

    private boolean validation() {
        if (this.electorsFilterBinding.ageEdit.length() != 0) {
            return true;
        }
        this.commomUtility.showMessageWithTitleOK(requireContext(), "Alert", "Age cann't remain empty", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        return false;
    }

    private boolean genderValidation() {
        if (this.electorsFilterBinding.genderRadioButton.isChecked() && !this.electorsFilterBinding.maleRadioButton.isChecked() && !this.electorsFilterBinding.femaleRadioButton.isChecked() && !this.electorsFilterBinding.thirdGenderRadioButton.isChecked()) {
            this.commomUtility.showMessageWithTitleOK(requireContext(), "Alert", "Kindly select the gender type", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda11
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            return false;
        }
        if (this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && this.electorsFilterBinding.relationTypeSpinner.getSelectedItem().toString().equals("Select Relation Type")) {
            this.commomUtility.showMessageWithTitleOK(requireContext(), "Alert", "Kindly select relation type", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda22
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            return false;
        }
        if (!this.electorsFilterBinding.ageCheckBox.isChecked() || this.electorsFilterBinding.genderAgeEdit.length() != 0) {
            return true;
        }
        this.commomUtility.showMessageWithTitleOK(requireContext(), "Alert", "Age cann't remain empty", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda29
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        return false;
    }

    private void initClickListener() {
        this.binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment.2
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            public boolean onQueryTextChange(String newText) {
                ElectorsListFragment.this.adapter.getFilter().filter(newText);
                return false;
            }
        });
        this.binding.filter.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$22(view);
            }
        });
        this.binding.sync.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$24(view);
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$25(view);
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment.3
            public void handleOnBackPressed() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$22(View view) {
        showFilter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$24(View view) {
        this.alertDialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initClickListener$23();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$23() {
        this.searchList.clear();
        this.mSearchList.clear();
        this.allArrayList.clear();
        this.maleArrayList.clear();
        this.femaleArrayList.clear();
        this.thirdArrayList.clear();
        this.aadhaarReceivedArrayList.clear();
        this.aadhaarNotReceivedArrayList.clear();
        this.pwdArrayList.clear();
        this.ageArrayList.clear();
        this.mobileArrayList.clear();
        this.noMobileArrayList.clear();
        if (this.binding.search.getQuery().length() == 0) {
            this.binding.search.setIconified(true);
        } else {
            this.binding.search.setQuery("", false);
        }
        this.binding.verifiedRv.getRecycledViewPool().clear();
        this.genderRadioButtonSelected = this.genderAll;
        this.binding.mainLayout.setVisibility(8);
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$25(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    private void applyFilter() {
        initRecyclerViewAdapter();
    }

    public void onPause() {
        super.onPause();
        final ClipboardManager clipboardManager = (ClipboardManager) requireActivity().getSystemService("clipboard");
        ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda30
            @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
            public final void onPrimaryClipChanged() {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
            }
        };
        clipboardManager.addPrimaryClipChangedListener(onPrimaryClipChangedListener);
        clipboardManager.removePrimaryClipChangedListener(onPrimaryClipChangedListener);
    }

    public void onDestroy() {
        super.onDestroy();
        final ClipboardManager clipboardManager = (ClipboardManager) requireActivity().getSystemService("clipboard");
        ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda8
            @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
            public final void onPrimaryClipChanged() {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
            }
        };
        clipboardManager.addPrimaryClipChangedListener(onPrimaryClipChangedListener);
        clipboardManager.removePrimaryClipChangedListener(onPrimaryClipChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecyclerViewAdapter() {
        if (!this.searchList.isEmpty()) {
            this.mSearchList = this.searchList;
            this.adapter = new FilterableRecyclerView(new AnonymousClass4());
            this.gridLayoutManager = new GridLayoutManager(requireActivity(), 1, 1, false);
            this.binding.verifiedRv.setLayoutManager(this.gridLayoutManager);
            this.binding.verifiedRv.setAdapter(this.adapter);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$initRecyclerViewAdapter$28();
                }
            }, 2000L);
            this.binding.mainLayout.setVisibility(0);
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initRecyclerViewAdapter$29();
            }
        }, 2000L);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$4, reason: invalid class name */
    class AnonymousClass4 implements FilterableRecyclerView.FilterGenericRecyclerAdapterInterface {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemViewType(int position) {
            return 0;
        }

        AnonymousClass4() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloElectorsListRvItemsBinding.inflate(ElectorsListFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
            final ElectorsListModel.getEpicList.Root root = ElectorsListFragment.this.mSearchList.get(position);
            if (root.getAadharStatus() == null) {
                root.setAadharStatus("N");
            }
            if (root.getGender() == null) {
                root.setGender("");
            }
            if (root.getPwd() == null) {
                root.setPwd("N");
            }
            if (root.getMobile() == null) {
                root.setMobile("");
            }
            if (root.getEpic() == null) {
                root.setEpic("");
            }
            if (root.getAge() == null) {
                root.setAge("");
            }
            if (root.getApplicantName() == null) {
                root.setApplicantName("");
            }
            if (root.getRelationType() == null) {
                root.setRelationType("");
            }
            Log.d(ElectorsListFragment.TAG, "getSerialNo ---> " + root.getSerialNo());
            Log.d(ElectorsListFragment.TAG, "getSerialNo ---> " + root.getApplicantName());
            Log.d(ElectorsListFragment.TAG, "getAadharStatus ---> " + root.getAadharStatus().trim());
            final Bundle bundle = new Bundle();
            if (root.getAadharStatus().trim().equalsIgnoreCase(ElectorsListFragment.this.y)) {
                ((BloElectorsListRvItemsBinding) holder.binding).aadhaarStatus.setText(R.string.blo_aadhaarReceived);
                ((BloElectorsListRvItemsBinding) holder.binding).aadhaarStatus.setTextColor(Color.parseColor("#039F00"));
            } else {
                ((BloElectorsListRvItemsBinding) holder.binding).aadhaarStatus.setText(R.string.blo_addAadhaar);
                ((BloElectorsListRvItemsBinding) holder.binding).aadhaarStatus.setTextColor(Color.parseColor("#1C77FF"));
            }
            ((BloElectorsListRvItemsBinding) holder.binding).gender.setText(root.getGender());
            if (root.getGender().trim().equalsIgnoreCase(ElectorsListFragment.this.m)) {
                ((BloElectorsListRvItemsBinding) holder.binding).gender.setText(ElectorsListFragment.this.genderSelected);
            } else if (root.getGender().trim().equalsIgnoreCase(ElectorsListFragment.this.f)) {
                ((BloElectorsListRvItemsBinding) holder.binding).gender.setText(ElectorsListFragment.this.genderFemale);
            } else if (root.getGender().trim().equalsIgnoreCase(ElectorsListFragment.this.t)) {
                ((BloElectorsListRvItemsBinding) holder.binding).gender.setText(ElectorsListFragment.this.genderThirdGender);
            }
            if (root.getRelationType().trim().equalsIgnoreCase(ElectorsListFragment.this.f) || root.getRelationType().trim().equalsIgnoreCase(ElectorsListFragment.this.fthr)) {
                ((BloElectorsListRvItemsBinding) holder.binding).relationType.setText(ElectorsListFragment.this.father);
            } else if (root.getRelationType().trim().equalsIgnoreCase(ElectorsListFragment.this.m) || root.getRelationType().trim().equalsIgnoreCase(ElectorsListFragment.this.mthr)) {
                ((BloElectorsListRvItemsBinding) holder.binding).relationType.setText(ElectorsListFragment.this.mother);
            } else if (root.getRelationType().trim().equalsIgnoreCase(ElectorsListFragment.this.h) || root.getRelationType().trim().equalsIgnoreCase(ElectorsListFragment.this.hsbn)) {
                ((BloElectorsListRvItemsBinding) holder.binding).relationType.setText(ElectorsListFragment.this.husband);
            } else if (root.getRelationType().trim().equalsIgnoreCase(ElectorsListFragment.this.w) || root.getRelationType().trim().equalsIgnoreCase(ElectorsListFragment.this.wifeCode)) {
                ((BloElectorsListRvItemsBinding) holder.binding).relationType.setText(ElectorsListFragment.this.wife);
            } else if (root.getRelationType().trim().equalsIgnoreCase(ElectorsListFragment.this.o) || root.getRelationType().trim().equalsIgnoreCase(ElectorsListFragment.this.otherCode)) {
                ((BloElectorsListRvItemsBinding) holder.binding).relationType.setText(ElectorsListFragment.this.other);
            }
            ElectorsListFragment.this.mobileNumber = "";
            ElectorsListFragment.this.newMmobileNumber = "";
            if (root.getMobile().trim().length() >= 10) {
                if (root.getMobile().trim().startsWith("+91-")) {
                    ElectorsListFragment.this.mobileNumber = root.getMobile().trim().substring(4);
                    ElectorsListFragment.this.newMmobileNumber = ElectorsListFragment.this.mobileNumber.substring(0, 3) + "-" + ElectorsListFragment.this.mobileNumber.substring(3, 6) + "-" + ElectorsListFragment.this.mobileNumber.substring(6, 10);
                } else if (root.getMobile().trim().startsWith("+91")) {
                    ElectorsListFragment.this.mobileNumber = root.getMobile().trim().substring(3);
                    ElectorsListFragment.this.newMmobileNumber = ElectorsListFragment.this.mobileNumber.substring(0, 3) + "-" + ElectorsListFragment.this.mobileNumber.substring(3, 6) + "-" + ElectorsListFragment.this.mobileNumber.substring(6, 10);
                } else {
                    ElectorsListFragment.this.newMmobileNumber = root.getMobile().trim().substring(0, 3) + "-" + root.getMobile().trim().substring(3, 6) + "-" + root.getMobile().trim().substring(6, 10);
                }
            }
            ((BloElectorsListRvItemsBinding) holder.binding).mobileNumber.setText(ElectorsListFragment.this.newMmobileNumber);
            ((BloElectorsListRvItemsBinding) holder.binding).serielNumber.setText(String.valueOf(root.getSerialNo()));
            ((BloElectorsListRvItemsBinding) holder.binding).candidateName.setText(root.getApplicantName());
            ((BloElectorsListRvItemsBinding) holder.binding).relativeName.setText(root.getRelationName());
            ((BloElectorsListRvItemsBinding) holder.binding).epicNumber.setText(root.getEpic());
            ((BloElectorsListRvItemsBinding) holder.binding).age.setText(root.getAge());
            ((BloElectorsListRvItemsBinding) holder.binding).epicNumber.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$4$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(holder, view);
                }
            });
            ((BloElectorsListRvItemsBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$4$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(root, bundle, view);
                }
            });
            ((BloElectorsListRvItemsBinding) holder.binding).aadhaarStatus.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$4$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$2(root, bundle, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(RecyclerViewHolder recyclerViewHolder, View view) {
            ((ClipboardManager) ElectorsListFragment.this.requireActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("PhoneNumber", ((BloElectorsListRvItemsBinding) recyclerViewHolder.binding).epicNumber.getText()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(ElectorsListModel.getEpicList.Root root, Bundle bundle, View view) {
            Log.d(ElectorsListFragment.TAG, "getAadharStatus_ElectoralList ---> " + root.getAadharStatus().trim());
            bundle.putString("epicNo", root.getEpic().trim());
            bundle.putString("aadhaar_Status", root.getAadharStatus().trim());
            bundle.putString("applicantName", root.getApplicantName().trim());
            ElectorsCandidateProfileFragment electorsCandidateProfileFragment = new ElectorsCandidateProfileFragment();
            electorsCandidateProfileFragment.setArguments(bundle);
            ElectorsListFragment.this.openFragment(electorsCandidateProfileFragment);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(ElectorsListModel.getEpicList.Root root, Bundle bundle, View view) {
            Log.d(ElectorsListFragment.TAG, "getAadharStatus_ElectoralList ---> " + root.getAadharStatus().trim());
            bundle.putString("epicNo", root.getEpic().trim());
            bundle.putString("aadhaar_Status", root.getAadharStatus().trim());
            bundle.putString("applicantName", root.getApplicantName().trim());
            ElectorsCandidateProfileFragment electorsCandidateProfileFragment = new ElectorsCandidateProfileFragment();
            electorsCandidateProfileFragment.setArguments(bundle);
            ElectorsListFragment.this.openFragment(electorsCandidateProfileFragment);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemCount() {
            return ElectorsListFragment.this.mSearchList.size();
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public Filter getFilter() {
            return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment.4.1
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    String strValueOf = String.valueOf(charSequence);
                    if (strValueOf.length() == 0) {
                        ElectorsListFragment.this.mSearchList = ElectorsListFragment.this.searchList;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (ElectorsListModel.getEpicList.Root root : ElectorsListFragment.this.mSearchList) {
                            if (root.getApplicantName().toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(root);
                            } else if (root.getGender().toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(root);
                            } else if (root.getEpic().toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(root);
                            } else if (root.getRelationName().toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(root);
                            } else if (root.getMobile().toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(root);
                            }
                        }
                        ElectorsListFragment.this.mSearchList = arrayList;
                    }
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.values = ElectorsListFragment.this.mSearchList;
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    ElectorsListFragment.this.adapter.notifyDataSetChanged();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initRecyclerViewAdapter$28() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initRecyclerViewAdapter$29() {
        this.alertDialog.dismiss();
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        if (radioGroup == this.electorsFilterBinding.filterRadioGroup) {
            if (checkedId == 2131362332) {
                this.electorsFilterBinding.maleRadioButton.setChecked(false);
                this.electorsFilterBinding.femaleRadioButton.setChecked(false);
                this.electorsFilterBinding.thirdGenderRadioButton.setChecked(false);
                this.electorsFilterBinding.femaleFilterImageAdd.setVisibility(8);
                this.electorsFilterBinding.femaleFilterImageRemove.setVisibility(8);
                this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
                this.electorsFilterBinding.genderRadioGroup.setVisibility(8);
                this.electorsFilterBinding.ageEdit.setVisibility(8);
                this.searchList.clear();
                this.searchList.addAll(this.allArrayList);
                this.genderRadioButtonSelected = this.genderAll;
                this.binding.selectedFilter.setText("All");
                this.binding.totalElectors.setText("" + this.allArrayList.size());
                return;
            }
            if (checkedId == 2131364003) {
                this.electorsFilterBinding.genderAgeEdit.setText("");
                this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
                this.electorsFilterBinding.ralationTypeCheckBox.setChecked(false);
                this.electorsFilterBinding.ageCheckBox.setChecked(false);
                this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
                this.electorsFilterBinding.genderRadioGroup.setVisibility(0);
                this.electorsFilterBinding.femaleFilterImageAdd.setVisibility(8);
                this.electorsFilterBinding.femaleFilterImageRemove.setVisibility(8);
                this.electorsFilterBinding.ageEdit.setVisibility(8);
                return;
            }
            if (checkedId == 2131365322) {
                this.electorsFilterBinding.maleRadioButton.setChecked(false);
                this.electorsFilterBinding.femaleRadioButton.setChecked(false);
                this.electorsFilterBinding.thirdGenderRadioButton.setChecked(false);
                this.electorsFilterBinding.femaleFilterImageAdd.setVisibility(8);
                this.electorsFilterBinding.femaleFilterImageRemove.setVisibility(8);
                this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
                this.electorsFilterBinding.genderRadioGroup.setVisibility(8);
                this.electorsFilterBinding.ageEdit.setVisibility(8);
                this.searchList.clear();
                List<ElectorsListModel.getEpicList.Root> list = this.aadhaarReceivedArrayList;
                if (list == null || list.isEmpty()) {
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, "No Data present for aadhaar received", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    this.genderRadioButtonSelected = this.genderAll;
                    this.electorsFilterBinding.filterRadioGroup.check(R.id.allGenderRadioButton);
                    return;
                } else {
                    this.searchList.addAll(this.aadhaarReceivedArrayList);
                    this.genderRadioButtonSelected = this.aadhaarReceived;
                    this.binding.selectedFilter.setText("Aadhaar Received");
                    this.binding.totalElectors.setText("" + this.aadhaarReceivedArrayList.size());
                    return;
                }
            }
            if (checkedId == 2131364868) {
                this.electorsFilterBinding.maleRadioButton.setChecked(false);
                this.electorsFilterBinding.femaleRadioButton.setChecked(false);
                this.electorsFilterBinding.thirdGenderRadioButton.setChecked(false);
                this.electorsFilterBinding.femaleFilterImageAdd.setVisibility(8);
                this.electorsFilterBinding.femaleFilterImageRemove.setVisibility(8);
                this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
                this.electorsFilterBinding.ageEdit.setVisibility(8);
                this.searchList.clear();
                List<ElectorsListModel.getEpicList.Root> list2 = this.aadhaarNotReceivedArrayList;
                if (list2 == null || list2.isEmpty()) {
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, "No Data present for aadhaar not  received", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    this.genderRadioButtonSelected = this.genderAll;
                    this.electorsFilterBinding.filterRadioGroup.check(R.id.allGenderRadioButton);
                    return;
                } else {
                    this.searchList.addAll(this.aadhaarNotReceivedArrayList);
                    this.genderRadioButtonSelected = this.aadhaarNotReceived;
                    this.binding.selectedFilter.setText("Aadhaar Not Received");
                    this.binding.totalElectors.setText("" + this.aadhaarNotReceivedArrayList.size());
                    return;
                }
            }
            if (checkedId == 2131365285) {
                this.electorsFilterBinding.maleRadioButton.setChecked(false);
                this.electorsFilterBinding.femaleRadioButton.setChecked(false);
                this.electorsFilterBinding.thirdGenderRadioButton.setChecked(false);
                this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
                this.electorsFilterBinding.genderRadioGroup.setVisibility(8);
                this.electorsFilterBinding.ageEdit.setVisibility(8);
                this.searchList.clear();
                List<ElectorsListModel.getEpicList.Root> list3 = this.pwdArrayList;
                if (list3 == null || list3.isEmpty()) {
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, "No Data present for PwD", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    this.genderRadioButtonSelected = this.genderAll;
                    this.electorsFilterBinding.filterRadioGroup.check(R.id.allGenderRadioButton);
                    return;
                } else {
                    this.searchList.addAll(this.pwdArrayList);
                    this.genderRadioButtonSelected = this.pwd;
                    this.binding.selectedFilter.setText("PwD");
                    this.binding.totalElectors.setText("" + this.pwdArrayList.size());
                    return;
                }
            }
            if (checkedId == 2131362272) {
                this.electorsFilterBinding.maleRadioButton.setChecked(false);
                this.electorsFilterBinding.femaleRadioButton.setChecked(false);
                this.electorsFilterBinding.thirdGenderRadioButton.setChecked(false);
                this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
                this.electorsFilterBinding.ageEdit.setVisibility(0);
                this.electorsFilterBinding.genderRadioGroup.setVisibility(8);
                this.searchList.clear();
                List<ElectorsListModel.getEpicList.Root> list4 = this.ageArrayList;
                if (list4 == null || list4.isEmpty()) {
                    return;
                }
                this.searchList.addAll(this.ageArrayList);
                this.genderRadioButtonSelected = this.age;
                Log.d(TAG, "ageSelected ---> " + this.ageSelected);
                this.electorsFilterBinding.ageEdit.setText(this.ageSelected);
                this.binding.selectedFilter.setText("Age");
                this.binding.totalElectors.setText("" + this.ageArrayList.size());
                return;
            }
            if (checkedId == 2131364631) {
                this.electorsFilterBinding.maleRadioButton.setChecked(false);
                this.electorsFilterBinding.femaleRadioButton.setChecked(false);
                this.electorsFilterBinding.thirdGenderRadioButton.setChecked(false);
                this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
                this.electorsFilterBinding.genderRadioGroup.setVisibility(8);
                this.electorsFilterBinding.ageEdit.setVisibility(8);
                this.searchList.clear();
                List<ElectorsListModel.getEpicList.Root> list5 = this.mobileArrayList;
                if (list5 == null || list5.isEmpty()) {
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, "No Data present for Have Mobile No", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda4
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    this.genderRadioButtonSelected = this.genderAll;
                    this.electorsFilterBinding.filterRadioGroup.check(R.id.allGenderRadioButton);
                    return;
                } else {
                    this.searchList.addAll(this.mobileArrayList);
                    this.genderRadioButtonSelected = this.mobile;
                    this.binding.selectedFilter.setText("Have Mobile No");
                    this.binding.totalElectors.setText("" + this.mobileArrayList.size());
                    return;
                }
            }
            if (checkedId == 2131364840) {
                this.electorsFilterBinding.maleRadioButton.setChecked(false);
                this.electorsFilterBinding.femaleRadioButton.setChecked(false);
                this.electorsFilterBinding.thirdGenderRadioButton.setChecked(false);
                this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
                this.electorsFilterBinding.genderRadioGroup.setVisibility(8);
                this.electorsFilterBinding.ageEdit.setVisibility(8);
                this.searchList.clear();
                List<ElectorsListModel.getEpicList.Root> list6 = this.noMobileArrayList;
                if (list6 == null || list6.isEmpty()) {
                    this.commomUtility.showMessageWithTitleOK(requireContext(), ERROR, "No Data present for Do not have Mobile No", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment$$ExternalSyntheticLambda5
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    this.genderRadioButtonSelected = this.genderAll;
                    this.electorsFilterBinding.filterRadioGroup.check(R.id.allGenderRadioButton);
                } else {
                    this.searchList.addAll(this.noMobileArrayList);
                    this.genderRadioButtonSelected = this.noMobile;
                    this.binding.selectedFilter.setText("Do not have Mobile No");
                    this.binding.totalElectors.setText("" + this.noMobileArrayList.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.electorsListFrame, fragment, "Application Fragment");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton.getId() == 2131364572) {
            if (this.electorsFilterBinding.maleRadioButton.isChecked()) {
                this.relationList.clear();
                this.relationList.add(this.selectRelationType);
                this.relationList.add(this.father);
                this.relationList.add(this.mother);
                this.relationList.add(this.wife);
                this.relationList.add(this.other);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
                this.relationadapter = arrayAdapter;
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
                this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
                this.electorsFilterBinding.genderAgeEdit.setText("");
                this.electorsFilterBinding.femaleFilterImageAdd.setVisibility(8);
                this.electorsFilterBinding.femaleFilterImageRemove.setVisibility(8);
                this.genderRadioButtonSelected = this.genderSelected;
                this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
                this.electorsFilterBinding.maleRadioButton.setChecked(true);
                this.electorsFilterBinding.femaleRadioButton.setChecked(false);
                this.electorsFilterBinding.thirdGenderRadioButton.setChecked(false);
                Log.d(TAG, "Male Checked");
            }
        } else if (compoundButton.getId() == 2131363820) {
            if (this.electorsFilterBinding.femaleRadioButton.isChecked()) {
                this.relationList.clear();
                this.relationList.add(this.selectRelationType);
                this.relationList.add(this.father);
                this.relationList.add(this.mother);
                this.relationList.add(this.husband);
                this.relationList.add(this.other);
                ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
                this.relationadapter = arrayAdapter2;
                arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
                this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
                this.electorsFilterBinding.genderAgeEdit.setText("");
                this.electorsFilterBinding.femaleFilterImageAdd.setVisibility(0);
                this.electorsFilterBinding.femaleFilterImageRemove.setVisibility(8);
                this.genderRadioButtonSelected = this.genderSelected;
                this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
                this.electorsFilterBinding.femaleRadioButton.setChecked(true);
                this.electorsFilterBinding.maleRadioButton.setChecked(false);
                this.electorsFilterBinding.thirdGenderRadioButton.setChecked(false);
            }
        } else if (compoundButton.getId() == 2131366187 && this.electorsFilterBinding.thirdGenderRadioButton.isChecked()) {
            this.relationList.clear();
            this.relationList.add(this.selectRelationType);
            this.relationList.add(this.father);
            this.relationList.add(this.mother);
            this.relationList.add(this.husband);
            this.relationList.add(this.wife);
            this.relationList.add(this.other);
            ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
            this.relationadapter = arrayAdapter3;
            arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
            this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
            this.electorsFilterBinding.genderAgeEdit.setText("");
            this.electorsFilterBinding.femaleFilterImageAdd.setVisibility(8);
            this.electorsFilterBinding.femaleFilterImageRemove.setVisibility(8);
            this.genderRadioButtonSelected = this.genderSelected;
            this.electorsFilterBinding.showExtraFemaleFilterLayout.setVisibility(8);
            this.electorsFilterBinding.thirdGenderRadioButton.setChecked(true);
            this.electorsFilterBinding.maleRadioButton.setChecked(false);
            this.electorsFilterBinding.femaleRadioButton.setChecked(false);
        }
        if (this.electorsFilterBinding.ralationTypeCheckBox.isChecked()) {
            this.electorsFilterBinding.relationTypeSpinner.setVisibility(0);
            this.electorsFilterBinding.viewStateOutsideSpinner1.setVisibility(0);
        } else {
            if (this.electorsFilterBinding.maleRadioButton.isChecked()) {
                this.relationList.clear();
                this.relationList.add(this.selectRelationType);
                this.relationList.add(this.father);
                this.relationList.add(this.mother);
                this.relationList.add(this.wife);
                this.relationList.add(this.other);
                ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
                this.relationadapter = arrayAdapter4;
                arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
                this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
            } else if (this.electorsFilterBinding.femaleRadioButton.isChecked()) {
                this.relationList.clear();
                this.relationList.add(this.selectRelationType);
                this.relationList.add(this.father);
                this.relationList.add(this.mother);
                this.relationList.add(this.husband);
                this.relationList.add(this.other);
                ArrayAdapter<String> arrayAdapter5 = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
                this.relationadapter = arrayAdapter5;
                arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
                this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
            } else if (this.electorsFilterBinding.thirdGenderRadioButton.isChecked()) {
                this.relationList.clear();
                this.relationList.add(this.selectRelationType);
                this.relationList.add(this.father);
                this.relationList.add(this.mother);
                this.relationList.add(this.husband);
                this.relationList.add(this.wife);
                this.relationList.add(this.other);
                ArrayAdapter<String> arrayAdapter6 = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, this.relationList);
                this.relationadapter = arrayAdapter6;
                arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                this.electorsFilterBinding.relationTypeSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
                this.electorsFilterBinding.relationTypeSpinner.setSelection(0);
            }
            this.electorsFilterBinding.relationTypeSpinner.setVisibility(8);
            this.electorsFilterBinding.viewStateOutsideSpinner1.setVisibility(8);
        }
        if (this.electorsFilterBinding.ageCheckBox.isChecked()) {
            this.electorsFilterBinding.genderAgeEdit.setVisibility(0);
        } else {
            this.electorsFilterBinding.genderAgeEdit.setText("");
            this.electorsFilterBinding.genderAgeEdit.setVisibility(8);
        }
        if (this.electorsFilterBinding.maleRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked()) {
            Log.d(TAG, "Male Relation Checked");
        } else {
            Log.d(TAG, "Male Relation UnChecked");
        }
        if (this.electorsFilterBinding.maleRadioButton.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
            Log.d(TAG, "Male Age Checked");
        } else {
            Log.d(TAG, "Male Age UnChecked");
        }
        if (this.electorsFilterBinding.maleRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
            Log.d(TAG, "Male Age Relation Checked");
        } else {
            Log.d(TAG, "Male Age Relation UnChecked");
        }
        if (this.electorsFilterBinding.femaleRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked()) {
            Log.d(TAG, "Female Relation Checked");
        } else {
            Log.d(TAG, "Female Relation UnChecked");
        }
        if (this.electorsFilterBinding.femaleRadioButton.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
            Log.d(TAG, "Female Age Checked");
        } else {
            Log.d(TAG, "Female Age UnChecked");
        }
        if (this.electorsFilterBinding.femaleRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
            Log.d(TAG, "Female Age Relation Checked");
        } else {
            Log.d(TAG, "Female Age Relation UnChecked");
        }
        if (this.electorsFilterBinding.thirdGenderRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked()) {
            Log.d(TAG, "Third Relation Checked");
        } else {
            Log.d(TAG, "Third Relation UnChecked");
        }
        if (this.electorsFilterBinding.thirdGenderRadioButton.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
            Log.d(TAG, "Third Age Checked");
        } else {
            Log.d(TAG, "Third Age UnChecked");
        }
        if (this.electorsFilterBinding.thirdGenderRadioButton.isChecked() && this.electorsFilterBinding.ralationTypeCheckBox.isChecked() && this.electorsFilterBinding.ageCheckBox.isChecked()) {
            Log.d(TAG, "Third Age Relation Checked");
        } else {
            Log.d(TAG, "Third Age Relation UnChecked");
        }
    }
}
