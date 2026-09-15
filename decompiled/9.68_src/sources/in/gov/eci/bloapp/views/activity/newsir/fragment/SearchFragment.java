package in.gov.eci.bloapp.views.activity.newsir.fragment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import in.gov.eci.bloapp.ArraylistReturn;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.LazyLoadable;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.FragmentTabThreeBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.NameMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.SharedViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.SearchLocationAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ErollDataCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.OkCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.LocationRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingList;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingModel;
import in.gov.eci.bloapp.views.activity.newsir.model.Payload;
import in.gov.eci.bloapp.views.activity.newsir.model.PayloadNewMapping;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SearchFragment extends Fragment implements LazyLoadable {
    private static final int REQUEST_RECORD_AUDIO = 1;
    private static final String SESSION = "Your session has expired or your account was accessed from another device. Please sign in again to continue.";
    private String acNo;
    SearchLocationAdapter adapter;
    AlertDialog alertDialog;
    private FragmentTabThreeBinding binding;
    private ArrayAdapter<String> districtadapter;
    boolean isOldAcNoEntered;
    boolean isOldPartNoEntered;
    boolean isOldPartSerialNoEntered;
    boolean isoldStateEntered;
    String lastSIRYear;
    String mappingType;
    List<MappingList> newbloMappedList;
    private String partNo;
    private String refreshToken;
    SharedViewModel sharedViewModel;
    private String state;
    List<MappingModel> systemMappedList;
    private String token;
    UserClient userClient;
    Utils utils;
    private boolean hasLoaded = false;
    private final String TAG = "SearchFragmentTAG";
    Gson gson = new GsonBuilder().setLenient().create();
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateList25_26 = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    ArrayList<String> StateNameList25_26 = new ArrayList<>();
    List<Integer> ACList = new ArrayList();
    List<String> ACNameList = new ArrayList();
    List<String> partNameList = new ArrayList();
    List<Integer> partList = new ArrayList();
    private ArrayList<String> district = new ArrayList<>();
    private ArrayList<String> districtcode = new ArrayList<>();
    CommomUtility commomUtility = new CommomUtility();
    String categoryType = "";
    String oldState = null;
    String efState = null;
    String efPart = null;
    Boolean isThisYou = false;
    String oldAc = null;
    String OldPart = null;
    String oldDistrict = null;
    String efAc = null;
    String efDistrict = null;
    List<Payload> payloads = new ArrayList();
    String Is2003Selected = "Y";
    List<PayloadNewMapping> erollPayloads = new ArrayList();
    String oldStateName = "";

    private void fetchDataFromApi(Context context) {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentTabThreeBinding fragmentTabThreeBindingInflate = FragmentTabThreeBinding.inflate(getLayoutInflater());
        this.binding = fragmentTabThreeBindingInflate;
        return fragmentTabThreeBindingInflate.getRoot();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.token = SharedPref.getInstance(getContext()).getToken();
        this.refreshToken = SharedPref.getInstance(getContext()).getRefreshToken();
        this.userClient = (UserClient) ApiClient.getClient2(getContext()).create(UserClient.class);
        this.state = SharedPref.getInstance(requireActivity()).getStateCode();
        this.acNo = SharedPref.getInstance(requireActivity()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireActivity()).getPartNumber();
        SharedViewModel sharedViewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        this.sharedViewModel = sharedViewModel;
        this.systemMappedList = sharedViewModel.getBloMappedList();
        this.newbloMappedList = new ArrayList();
        this.lastSIRYear = SharedPref.getInstance(requireActivity()).getlastSIRYear();
        this.utils = new Utils();
        this.binding.includeCurrentDetails.electorNamePendingSir.setText(this.sharedViewModel.getElectorname());
        this.binding.includeCurrentDetails.serialNoPendingSir.setText(this.sharedViewModel.getSerial());
        this.binding.includeCurrentDetails.epicPendingSir.setText(this.sharedViewModel.getEpicNumber());
        this.binding.includeCurrentDetails.agePendingSir.setText(String.valueOf(this.sharedViewModel.getAge()));
        this.binding.includeCurrentDetails.relativeNamePendingSir.setText(this.sharedViewModel.getRelativeName());
        this.binding.includeCurrentDetails.relativeTypePendingSir.setText(this.sharedViewModel.getRelationType());
        this.binding.searchTitle.setText(getString(R.string.ef_search_tab_title, new Object[]{this.lastSIRYear}));
        this.binding.wasElector2003RB.setText(getString(R.string.ef_was_elector_2003_text, new Object[]{this.lastSIRYear}));
        this.binding.tvNoteSelf.setText(getString(R.string.self_disclaimer, new Object[]{this.lastSIRYear}));
        this.binding.progenyElector2003RB.setText(getString(R.string.ef_progeny_2003_text, new Object[]{this.lastSIRYear}));
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.StateList = SharedPref.getInstance(getContext()).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateList25_26 = SharedPref.getInstance(getContext()).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateNameList = SharedPref.getInstance(getContext()).getAcListName(Constants.STATE_LIST_NAME);
        this.StateNameList25_26 = SharedPref.getInstance(getContext()).getAcListName(Constants.STATE_LIST_NAME);
        filteredStateList();
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.blo_spinner_dropdown_new, this.StateNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldStateSpinner.setAdapter(arrayAdapter);
        this.binding.oldStateSpinner.setThreshold(1);
        this.binding.efStateSpinner.setAdapter(arrayAdapter);
        this.binding.efStateSpinner.setThreshold(1);
        HashMap map = new HashMap();
        for (int i = 0; i < this.StateList.size() && i < this.StateNameList.size(); i++) {
            map.put(this.StateList.get(i), this.StateNameList.get(i));
        }
        Log.d("HashMap: ", map.keySet().toString() + "" + map.values().toString());
        if (!this.sharedViewModel.getMappingModel().getPayload().applicantEligibleInPrevSir) {
            this.binding.wasElector2003RB.setFocusable(false);
            this.binding.wasElector2003RB.setClickable(false);
            this.binding.tvNoteSelf.setVisibility(8);
        } else {
            this.binding.wasElector2003RB.setEnabled(true);
            this.binding.wasElector2003RB.setFocusable(true);
            this.binding.wasElector2003RB.setClickable(true);
            this.binding.tvNoteSelf.setVisibility(8);
        }
        this.binding.oldStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SearchFragment.this.binding.oldStateSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SearchFragment.this.binding.efStateSpinner.showDropDown();
                return false;
            }
        });
        this.binding.oldDistrictSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SearchFragment.this.binding.oldDistrictSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efDistrictSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SearchFragment.this.binding.efDistrictSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efAcSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SearchFragment.this.binding.efAcSpinner.showDropDown();
                return false;
            }
        });
        this.binding.oldAcNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SearchFragment.this.binding.oldAcNo.showDropDown();
                return false;
            }
        });
        this.binding.oldPartNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SearchFragment.this.binding.oldPartNo.showDropDown();
                return false;
            }
        });
        this.binding.efPartSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SearchFragment.this.binding.efPartSpinner.showDropDown();
                return false;
            }
        });
        this.binding.oldStateSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view2, int i2, long id) {
                Log.d("AutoCorrect", parent.getItemAtPosition(i2).toString());
                SearchFragment.this.binding.lvVerifyDetails.setVisibility(8);
                SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i2).toString().equalsIgnoreCase("Select State")) {
                    SearchFragment.this.oldState = null;
                    SearchFragment.this.oldAc = null;
                    SearchFragment.this.OldPart = null;
                    SearchFragment.this.oldDistrict = null;
                    SearchFragment.this.partList.clear();
                    SearchFragment.this.partNameList.clear();
                    SearchFragment.this.ACNameList.clear();
                    SearchFragment.this.ACList.clear();
                    SearchFragment.this.ACNameList.add(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    SearchFragment.this.ACList.add(0);
                    SearchFragment.this.partNameList.add(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    SearchFragment.this.partList.add(0);
                    SearchFragment.this.district.clear();
                    SearchFragment.this.districtcode.clear();
                    SearchFragment.this.district.add("Select District");
                    SearchFragment.this.districtcode.add("0");
                    SearchFragment.this.binding.oldStateSpinner.setText("");
                    SearchFragment.this.binding.oldAcNo.setText("");
                    SearchFragment.this.binding.oldDistrictSpinner.setText("");
                    SearchFragment.this.binding.oldPartNo.setText("");
                    SearchFragment.this.binding.oldStateSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.blo_select_state));
                    SearchFragment.this.binding.oldAcNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    SearchFragment.this.binding.oldDistrictSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.blo_select_district));
                    SearchFragment.this.binding.oldPartNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    SearchFragment.this.binding.oldPslNo.setText("");
                    return;
                }
                SearchFragment.this.oldAc = null;
                SearchFragment.this.OldPart = null;
                SearchFragment.this.oldDistrict = null;
                SearchFragment.this.binding.oldPslNo.setText("");
                SearchFragment.this.isoldStateEntered = true;
                String string = parent.getItemAtPosition(i2).toString();
                if (SearchFragment.this.Is2003Selected.equalsIgnoreCase("N")) {
                    SearchFragment searchFragment = SearchFragment.this;
                    searchFragment.oldState = searchFragment.StateList25_26.get(SearchFragment.this.StateNameList25_26.indexOf(string));
                    SearchFragment searchFragment2 = SearchFragment.this;
                    searchFragment2.oldStateName = searchFragment2.StateNameList25_26.get(SearchFragment.this.StateNameList25_26.indexOf(string));
                } else {
                    SearchFragment searchFragment3 = SearchFragment.this;
                    searchFragment3.oldState = searchFragment3.StateList.get(SearchFragment.this.StateNameList.indexOf(string));
                }
                SearchFragment.this.binding.oldAcNo.setText("");
                SearchFragment.this.binding.oldDistrictSpinner.setText("");
                SearchFragment.this.binding.oldPartNo.setText("");
                SearchFragment.this.binding.oldAcNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                SearchFragment.this.binding.oldDistrictSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.blo_select_district));
                SearchFragment.this.binding.oldPartNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                SearchFragment.this.binding.oldPslNo.setText("");
                Log.d("SearchFragmentTAG", "AClist " + SearchFragment.this.StateList);
                Log.d("SearchFragmentTAG", "Spinner value " + SearchFragment.this.oldState);
                SearchFragment searchFragment4 = SearchFragment.this;
                searchFragment4.getAllDistrict(searchFragment4.oldState);
                if (SearchFragment.this.Is2003Selected.equalsIgnoreCase("N")) {
                    SearchFragment searchFragment5 = SearchFragment.this;
                    searchFragment5.getAllOldAc2025(searchFragment5.oldState);
                } else {
                    SearchFragment searchFragment6 = SearchFragment.this;
                    searchFragment6.getAllAC(searchFragment6.oldState);
                }
            }
        });
        this.binding.oldDistrictSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view2, int i2, long id) {
                int i3;
                SearchFragment.this.binding.lvVerifyDetails.setVisibility(8);
                SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i2).toString().equalsIgnoreCase("Select District")) {
                    SearchFragment.this.oldAc = null;
                    SearchFragment.this.OldPart = null;
                    SearchFragment.this.oldDistrict = null;
                    SearchFragment.this.partList.clear();
                    SearchFragment.this.partNameList.clear();
                    SearchFragment.this.partNameList.add(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    SearchFragment.this.binding.oldAcNo.setText("");
                    SearchFragment.this.binding.oldDistrictSpinner.setText("");
                    SearchFragment.this.binding.oldPartNo.setText("");
                    SearchFragment.this.binding.oldDistrictSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.blo_select_district));
                    SearchFragment.this.binding.oldAcNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    SearchFragment.this.binding.oldPartNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    SearchFragment.this.partList.add(0);
                    SearchFragment.this.binding.oldPslNo.setText("");
                    if (SearchFragment.this.ACList.size() > 0) {
                        SearchFragment.this.ACList.clear();
                        SearchFragment.this.ACNameList.clear();
                    }
                    if (SearchFragment.this.Is2003Selected.equalsIgnoreCase("N")) {
                        SearchFragment searchFragment = SearchFragment.this;
                        searchFragment.getAllOldAc2025(searchFragment.oldState);
                        return;
                    } else {
                        SearchFragment searchFragment2 = SearchFragment.this;
                        searchFragment2.getAllAC(searchFragment2.oldState);
                        return;
                    }
                }
                SearchFragment.this.oldAc = null;
                SearchFragment.this.OldPart = null;
                SearchFragment.this.binding.oldPslNo.setText("");
                if (!TextUtils.isEmpty(SearchFragment.this.oldState) && SearchFragment.this.oldState.equalsIgnoreCase("S02")) {
                    SearchFragment searchFragment3 = SearchFragment.this;
                    searchFragment3.oldDistrict = (String) searchFragment3.district.get(i2);
                    i3 = Integer.parseInt((String) SearchFragment.this.districtcode.get(i2));
                } else {
                    int iIndexOf = SearchFragment.this.district.indexOf((String) SearchFragment.this.district.get(SearchFragment.this.district.indexOf(parent.getItemAtPosition(i2).toString())));
                    SearchFragment searchFragment4 = SearchFragment.this;
                    searchFragment4.oldDistrict = (String) searchFragment4.district.get(iIndexOf);
                    i3 = Integer.parseInt((String) SearchFragment.this.districtcode.get(iIndexOf));
                }
                SearchFragment.this.binding.oldAcNo.setText("");
                SearchFragment.this.binding.oldPartNo.setText("");
                SearchFragment.this.binding.oldAcNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                SearchFragment.this.binding.oldPartNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                SearchFragment.this.binding.oldPslNo.setText("");
                if (!SearchFragment.this.Is2003Selected.equalsIgnoreCase("N")) {
                    SearchFragment searchFragment5 = SearchFragment.this;
                    searchFragment5.getACByDistrict(i3, searchFragment5.oldState);
                }
                if (SearchFragment.this.partList.size() <= 0 || SearchFragment.this.partNameList.size() <= 0) {
                    return;
                }
                SearchFragment.this.partList.clear();
                SearchFragment.this.partNameList.clear();
            }
        });
        this.binding.oldAcNo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view2, int i2, long l) {
                SearchFragment.this.binding.lvVerifyDetails.setVisibility(8);
                SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i2).toString().equalsIgnoreCase("Select Assembly Constituency")) {
                    SearchFragment.this.oldAc = null;
                    SearchFragment.this.OldPart = null;
                    SearchFragment.this.partList.clear();
                    SearchFragment.this.partNameList.clear();
                    SearchFragment.this.partNameList.add(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    SearchFragment.this.partList.add(0);
                    SearchFragment.this.binding.oldAcNo.setText("");
                    SearchFragment.this.binding.oldPartNo.setText("");
                    SearchFragment.this.binding.oldAcNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    SearchFragment.this.binding.oldPartNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    SearchFragment.this.binding.oldPslNo.setText("");
                    return;
                }
                SearchFragment.this.OldPart = null;
                SearchFragment.this.binding.oldPslNo.setText("");
                SearchFragment.this.isOldAcNoEntered = true;
                SearchFragment.this.binding.oldPartNo.setText("");
                SearchFragment.this.binding.oldPartNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                String string = parent.getItemAtPosition(i2).toString();
                SearchFragment searchFragment = SearchFragment.this;
                searchFragment.oldAc = String.valueOf(searchFragment.ACList.get(SearchFragment.this.ACNameList.indexOf(string)));
                Log.d("OldAC : ", SearchFragment.this.oldAc + "  " + SearchFragment.this.ACList.get(i2).toString());
                SearchFragment.this.binding.oldPslNo.setText("");
                if (SearchFragment.this.Is2003Selected.equalsIgnoreCase("N")) {
                    SearchFragment.this.commomUtility.getPartByAc2025(SearchFragment.this.requireActivity(), Integer.parseInt(SearchFragment.this.oldAc), SearchFragment.this.oldState, SearchFragment.this.token, SharedPref.getInstance(SearchFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(SearchFragment.this.getContext()).getRtknBnd(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.11.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                        public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                            if (code == 200) {
                                SearchFragment.this.partList.clear();
                                SearchFragment.this.partNameList.clear();
                                SearchFragment.this.partList = acList;
                                SearchFragment.this.partNameList = acNameList;
                                ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) SearchFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) SearchFragment.this.partNameList);
                                arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                                SearchFragment.this.binding.oldPartNo.setAdapter(arrayAdapter2);
                                SearchFragment.this.binding.oldPartNo.setThreshold(1);
                            }
                        }
                    });
                } else {
                    SearchFragment.this.getPartByAc();
                }
            }
        });
        this.binding.oldPartNo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view2, int i2, long l) {
                SearchFragment.this.binding.lvVerifyDetails.setVisibility(8);
                SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i2).toString().equalsIgnoreCase("Select Part")) {
                    SearchFragment.this.OldPart = null;
                    SearchFragment.this.binding.oldPartNo.setText("");
                    SearchFragment.this.binding.oldPartNo.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    SearchFragment.this.binding.oldPslNo.setText("");
                    return;
                }
                SearchFragment.this.isOldPartNoEntered = true;
                SearchFragment.this.binding.oldPslNo.setText("");
                String string = parent.getItemAtPosition(i2).toString();
                SearchFragment searchFragment = SearchFragment.this;
                searchFragment.OldPart = String.valueOf(searchFragment.partList.get(SearchFragment.this.partNameList.indexOf(string)));
                Log.d("OldAC : ", SearchFragment.this.OldPart + "  " + SearchFragment.this.partNameList.get(i2).toString());
            }
        });
        this.binding.efPartSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.13
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view2, int i2, long l) {
                SearchFragment.this.binding.rvMapping.setVisibility(8);
                SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i2).toString().equalsIgnoreCase("Select Part")) {
                    SearchFragment.this.efPart = null;
                    SearchFragment.this.binding.efPartSpinner.setText("");
                    SearchFragment.this.binding.efPartSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                } else {
                    String string = parent.getItemAtPosition(i2).toString();
                    SearchFragment searchFragment = SearchFragment.this;
                    searchFragment.efPart = String.valueOf(searchFragment.partList.get(SearchFragment.this.partNameList.indexOf(string)));
                }
            }
        });
        this.binding.efStateSpinner.setOnItemClickListener(new AnonymousClass14());
        this.binding.efDistrictSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view2, int i2, long id) {
                SearchFragment.this.binding.rvMapping.setVisibility(8);
                SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i2).toString().equalsIgnoreCase("Select District")) {
                    SearchFragment.this.efDistrict = null;
                    SearchFragment.this.efAc = null;
                    SearchFragment.this.partList.clear();
                    SearchFragment.this.partNameList.clear();
                    SearchFragment.this.partNameList.add(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    SearchFragment.this.partList.add(0);
                    SearchFragment.this.binding.efAcSpinner.setText("");
                    SearchFragment.this.binding.efPartSpinner.setText("");
                    SearchFragment.this.binding.efDistrictSpinner.setText("");
                    SearchFragment.this.binding.efAcSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    SearchFragment.this.binding.efPartSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    SearchFragment.this.binding.efDistrictSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.blo_select_district));
                    if (SearchFragment.this.ACList.size() > 0) {
                        SearchFragment.this.ACList.clear();
                        SearchFragment.this.ACNameList.clear();
                    }
                    SearchFragment searchFragment = SearchFragment.this;
                    searchFragment.getAllAC(searchFragment.efState);
                    return;
                }
                SearchFragment.this.efAc = null;
                SearchFragment.this.efPart = null;
                if (!TextUtils.isEmpty(SearchFragment.this.efState) && SearchFragment.this.efState.equalsIgnoreCase("S02")) {
                    SearchFragment.this.district.indexOf(Integer.valueOf(i2));
                    SearchFragment searchFragment2 = SearchFragment.this;
                    searchFragment2.efDistrict = (String) searchFragment2.districtcode.get(i2);
                } else {
                    int iIndexOf = SearchFragment.this.district.indexOf((String) SearchFragment.this.district.get(SearchFragment.this.district.indexOf(parent.getItemAtPosition(i2).toString())));
                    SearchFragment searchFragment3 = SearchFragment.this;
                    searchFragment3.efDistrict = (String) searchFragment3.districtcode.get(iIndexOf);
                }
                SearchFragment searchFragment4 = SearchFragment.this;
                searchFragment4.getACByDistrict(Integer.parseInt(searchFragment4.efDistrict), SearchFragment.this.efState);
                SearchFragment.this.binding.efAcSpinner.setText("");
                SearchFragment.this.binding.efPartSpinner.setText("");
                SearchFragment.this.binding.efAcSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                SearchFragment.this.binding.efPartSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                SearchFragment.this.binding.selfName.setText("");
                SearchFragment.this.binding.parentName.setText("");
                SearchFragment.this.binding.grandparentName.setText("");
                if (SearchFragment.this.partList.size() <= 0 || SearchFragment.this.partNameList.size() <= 0) {
                    return;
                }
                SearchFragment.this.partList.clear();
                SearchFragment.this.partNameList.clear();
            }
        });
        this.binding.efAcSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.16
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view2, int i2, long id) {
                SearchFragment.this.binding.rvMapping.setVisibility(8);
                SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i2).toString().equalsIgnoreCase("Select Assembly Constituency")) {
                    SearchFragment.this.efAc = null;
                    SearchFragment.this.efPart = null;
                    SearchFragment.this.partList.clear();
                    SearchFragment.this.partNameList.clear();
                    SearchFragment.this.partNameList.add(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    SearchFragment.this.partList.add(0);
                    SearchFragment.this.binding.efAcSpinner.setText("");
                    SearchFragment.this.binding.efPartSpinner.setText("");
                    SearchFragment.this.binding.selfName.setText("");
                    SearchFragment.this.binding.parentName.setText("");
                    SearchFragment.this.binding.grandparentName.setText("");
                    SearchFragment.this.binding.efPartSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    SearchFragment.this.binding.efAcSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    return;
                }
                SearchFragment.this.efPart = null;
                String string = parent.getItemAtPosition(i2).toString();
                SearchFragment searchFragment = SearchFragment.this;
                searchFragment.efAc = String.valueOf(searchFragment.ACList.get(SearchFragment.this.ACNameList.indexOf(string)));
                Log.d("OldAC : ", SearchFragment.this.oldAc + "  " + SearchFragment.this.ACList.get(i2).toString());
                SearchFragment.this.binding.efPartSpinner.setText("");
                SearchFragment.this.binding.efPartSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                SearchFragment.this.binding.selfName.setText("");
                SearchFragment.this.binding.parentName.setText("");
                SearchFragment.this.binding.grandparentName.setText("");
                SearchFragment.this.getPartByEfAc();
            }
        });
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TextUtils.isEmpty(SearchFragment.this.oldState)) {
                    SearchFragment.this.showDialog1("Alert", "Please select State");
                    return;
                }
                if (TextUtils.isEmpty(SearchFragment.this.oldAc)) {
                    SearchFragment.this.showDialog1("Alert", "Please select Assembly");
                    return;
                }
                if (TextUtils.isEmpty(SearchFragment.this.OldPart)) {
                    SearchFragment.this.showDialog1("Alert", "Please select Part");
                    return;
                }
                if (TextUtils.isEmpty(SearchFragment.this.binding.oldPslNo.getText().toString().trim())) {
                    SearchFragment.this.showDialog1("Alert", "Please enter part serial number");
                    return;
                }
                if (SearchFragment.this.Is2003Selected.equalsIgnoreCase("Y")) {
                    if (SearchFragment.this.payloads.size() > 0) {
                        SearchFragment.this.payloads.clear();
                    }
                    SearchFragment.this.searchDetails();
                } else {
                    if (SearchFragment.this.erollPayloads.size() > 0) {
                        SearchFragment.this.erollPayloads.clear();
                    }
                    SearchFragment.this.ErollDataDetails();
                }
            }
        });
        this.binding.searchRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.18
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (SearchFragment.this.binding.searchRG.getCheckedRadioButtonId() == -1) {
                    SearchFragment.this.binding.searchCV.setVisibility(8);
                    SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
                }
                if (SearchFragment.this.binding.wasElector2003RB.isChecked()) {
                    SearchFragment.this.Is2003Selected = "Y";
                    SearchFragment.this.categoryType = "self";
                    SearchFragment.this.clearACVariables();
                    SearchFragment.this.clearLocationVariables();
                    SearchFragment.this.binding.searchCV.setVisibility(0);
                    SearchFragment.this.binding.searchTabLayout.setVisibility(0);
                    SearchFragment.this.binding.searchByAcDetailsLl.setVisibility(0);
                    SearchFragment.this.binding.searchLocationMB.setVisibility(0);
                    SearchFragment.this.binding.searchByLocationDetailsLl.setVisibility(8);
                    SearchFragment searchFragment = SearchFragment.this;
                    searchFragment.selecttab(searchFragment.binding.searchAcPartPslMB, SearchFragment.this.binding.searchLocationMB);
                    if (SearchFragment.this.categoryType.equalsIgnoreCase("self")) {
                        SearchFragment.this.binding.grandparentNameLayout.setVisibility(8);
                        SearchFragment.this.binding.electorNameLayout.setVisibility(0);
                        SearchFragment.this.binding.parentNameLayout.setVisibility(0);
                        SearchFragment.this.binding.titleParentname.setText(SearchFragment.this.requireActivity().getResources().getString(R.string.blo_Relative_Name));
                    }
                    if (SearchFragment.this.categoryType.equalsIgnoreCase("progeny")) {
                        SearchFragment.this.binding.electorNameLayout.setVisibility(8);
                        SearchFragment.this.binding.grandparentNameLayout.setVisibility(0);
                        SearchFragment.this.binding.parentNameLayout.setVisibility(0);
                        SearchFragment.this.binding.titleParentname.setText(SearchFragment.this.requireActivity().getResources().getString(R.string.parent_name));
                    }
                    ArrayAdapter arrayAdapter2 = new ArrayAdapter(SearchFragment.this.getContext(), R.layout.blo_spinner_dropdown_new, SearchFragment.this.StateNameList);
                    arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    SearchFragment.this.binding.oldStateSpinner.setAdapter(arrayAdapter2);
                    SearchFragment.this.binding.oldStateSpinner.setThreshold(1);
                    return;
                }
                if (SearchFragment.this.binding.progenyElector2003RB.isChecked()) {
                    SearchFragment.this.Is2003Selected = "Y";
                    SearchFragment.this.categoryType = "progeny";
                    SearchFragment.this.clearACVariables();
                    SearchFragment.this.clearLocationVariables();
                    SearchFragment.this.binding.searchCV.setVisibility(0);
                    SearchFragment.this.binding.searchTabLayout.setVisibility(0);
                    SearchFragment.this.binding.searchLocationMB.setVisibility(0);
                    SearchFragment searchFragment2 = SearchFragment.this;
                    searchFragment2.selecttab(searchFragment2.binding.searchLocationMB, SearchFragment.this.binding.searchAcPartPslMB);
                    SearchFragment.this.binding.searchByAcDetailsLl.setVisibility(8);
                    SearchFragment.this.binding.searchByLocationDetailsLl.setVisibility(0);
                    if (SearchFragment.this.categoryType.equalsIgnoreCase("self")) {
                        SearchFragment.this.binding.grandparentNameLayout.setVisibility(8);
                        SearchFragment.this.binding.electorNameLayout.setVisibility(0);
                        SearchFragment.this.binding.parentNameLayout.setVisibility(0);
                        SearchFragment.this.binding.titleParentname.setText(SearchFragment.this.requireActivity().getResources().getString(R.string.blo_Relative_Name));
                    }
                    if (SearchFragment.this.categoryType.equalsIgnoreCase("progeny")) {
                        SearchFragment.this.binding.electorNameLayout.setVisibility(8);
                        SearchFragment.this.binding.grandparentNameLayout.setVisibility(0);
                        SearchFragment.this.binding.parentNameLayout.setVisibility(0);
                        SearchFragment.this.binding.titleParentname.setText(SearchFragment.this.requireActivity().getResources().getString(R.string.parent_name));
                    }
                    ArrayAdapter arrayAdapter3 = new ArrayAdapter(SearchFragment.this.getContext(), R.layout.blo_spinner_dropdown_new, SearchFragment.this.StateNameList);
                    arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    SearchFragment.this.binding.oldStateSpinner.setAdapter(arrayAdapter3);
                    SearchFragment.this.binding.oldStateSpinner.setThreshold(1);
                    return;
                }
                if (SearchFragment.this.binding.neitherElector2003RB.isChecked()) {
                    SearchFragment.this.Is2003Selected = "Y";
                    SearchFragment.this.categoryType = "";
                    SearchFragment.this.binding.searchTabLayout.setVisibility(8);
                    SearchFragment.this.binding.searchByAcDetailsLl.setVisibility(8);
                    SearchFragment.this.binding.searchByLocationDetailsLl.setVisibility(8);
                    SearchFragment.this.binding.layoutVerifyButton.setVisibility(0);
                    return;
                }
                if (SearchFragment.this.binding.progenyElector2005RB.isChecked()) {
                    SearchFragment.this.Is2003Selected = "N";
                    SearchFragment.this.categoryType = "progeny";
                    SearchFragment.this.clearACVariables();
                    SearchFragment.this.clearLocationVariables();
                    SearchFragment.this.binding.searchCV.setVisibility(0);
                    SearchFragment.this.binding.searchTabLayout.setVisibility(0);
                    ArrayAdapter arrayAdapter4 = new ArrayAdapter(SearchFragment.this.getContext(), R.layout.blo_spinner_dropdown_new, SearchFragment.this.StateNameList25_26);
                    arrayAdapter4.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    SearchFragment.this.binding.oldStateSpinner.setAdapter(arrayAdapter4);
                    SearchFragment.this.binding.oldStateSpinner.setThreshold(1);
                    SearchFragment.this.binding.searchLocationMB.setVisibility(8);
                    SearchFragment searchFragment3 = SearchFragment.this;
                    searchFragment3.selecttab(searchFragment3.binding.searchAcPartPslMB, SearchFragment.this.binding.searchLocationMB);
                    SearchFragment.this.binding.searchTabLayout.setVisibility(0);
                    SearchFragment.this.binding.searchByAcDetailsLl.setVisibility(0);
                    SearchFragment.this.binding.searchByLocationDetailsLl.setVisibility(8);
                    return;
                }
                SearchFragment.this.binding.searchTabLayout.setVisibility(8);
            }
        });
        this.binding.searchAcPartPslMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$1(view2);
            }
        });
        this.binding.searchLocationMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$3(view2);
            }
        });
        this.binding.searchButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$4(view2);
            }
        });
        this.binding.txtVerifyContinueButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$5(view2);
            }
        });
        this.binding.selfName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.21
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SearchFragment.this.binding.rvMapping.setVisibility(8);
                SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
                SearchFragment.this.binding.tvRecordCount.setVisibility(8);
            }
        });
        this.binding.parentName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.22
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SearchFragment.this.binding.rvMapping.setVisibility(8);
                SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
                SearchFragment.this.binding.tvRecordCount.setVisibility(8);
            }
        });
        this.binding.grandparentName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.23
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SearchFragment.this.binding.rvMapping.setVisibility(8);
                SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
                SearchFragment.this.binding.tvRecordCount.setVisibility(8);
            }
        });
        this.binding.oldPslNo.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.24
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SearchFragment.this.binding.lvVerifyDetails.setVisibility(8);
                SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
            }
        });
        this.binding.speak.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SearchFragment.this.utils.showVoicePopup(SearchFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.25.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        SearchFragment.this.binding.oldPslNo.setText(result);
                    }
                });
            }
        });
        this.binding.speakSelf.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SearchFragment.this.utils.showVoicePopup(SearchFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.26.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        SearchFragment.this.binding.selfName.setText(result);
                    }
                });
            }
        });
        this.binding.speakParent.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SearchFragment.this.utils.showVoicePopup(SearchFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.27.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        SearchFragment.this.binding.parentName.setText(result);
                    }
                });
            }
        });
        this.binding.speakGrandparent.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SearchFragment.this.utils.showVoicePopup(SearchFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.28.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        SearchFragment.this.binding.grandparentName.setText(result);
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$14, reason: invalid class name */
    class AnonymousClass14 implements AdapterView.OnItemClickListener {
        AnonymousClass14() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            SearchFragment.this.binding.rvMapping.setVisibility(8);
            SearchFragment.this.binding.layoutVerifyButton.setVisibility(8);
            if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select State")) {
                SearchFragment.this.efState = null;
                SearchFragment.this.efDistrict = null;
                SearchFragment.this.efAc = null;
                SearchFragment.this.efPart = null;
                SearchFragment.this.ACNameList.clear();
                SearchFragment.this.ACList.clear();
                SearchFragment.this.ACNameList.add(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                SearchFragment.this.ACList.add(0);
                SearchFragment.this.partList.clear();
                SearchFragment.this.partNameList.clear();
                SearchFragment.this.partNameList.add(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                SearchFragment.this.partList.add(0);
                SearchFragment.this.district.clear();
                SearchFragment.this.districtcode.clear();
                SearchFragment.this.district.add("Select District");
                SearchFragment.this.districtcode.add("0");
                SearchFragment.this.binding.efAcSpinner.setText("");
                SearchFragment.this.binding.efDistrictSpinner.setText("");
                SearchFragment.this.binding.efPartSpinner.setText("");
                SearchFragment.this.binding.efStateSpinner.setText("");
                SearchFragment.this.binding.efStateSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.blo_select_state));
                SearchFragment.this.binding.efAcSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                SearchFragment.this.binding.efDistrictSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.blo_select_district));
                SearchFragment.this.binding.efPartSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
                return;
            }
            SearchFragment.this.efDistrict = null;
            SearchFragment.this.efAc = null;
            SearchFragment.this.efPart = null;
            SearchFragment.this.binding.efAcSpinner.setText("");
            SearchFragment.this.binding.efDistrictSpinner.setText("");
            SearchFragment.this.binding.efPartSpinner.setText("");
            SearchFragment.this.binding.efAcSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
            SearchFragment.this.binding.efDistrictSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.blo_select_district));
            SearchFragment.this.binding.efPartSpinner.setHint(SearchFragment.this.requireActivity().getResources().getString(R.string.select_part));
            String string = parent.getItemAtPosition(i).toString();
            SearchFragment searchFragment = SearchFragment.this;
            searchFragment.efState = searchFragment.StateList.get(SearchFragment.this.StateNameList.indexOf(string));
            Log.d("efState : ", SearchFragment.this.efState);
            SearchFragment.this.binding.selfName.setText("");
            SearchFragment.this.binding.parentName.setText("");
            SearchFragment.this.binding.grandparentName.setText("");
            SearchFragment searchFragment2 = SearchFragment.this;
            searchFragment2.getAllDistrict(searchFragment2.efState);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$14$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            SearchFragment searchFragment = SearchFragment.this;
            searchFragment.getAllAC(searchFragment.efState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onViewCreated$0();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0() {
        this.binding.searchTabLayout.setVisibility(0);
        this.binding.searchByAcDetailsLl.setVisibility(0);
        this.binding.searchByLocationDetailsLl.setVisibility(8);
        this.binding.efStateSpinner.setText("");
        this.binding.efStateSpinner.setHint(requireActivity().getResources().getString(R.string.blo_select_state));
        if (this.ACList.size() > 0 && this.ACNameList.size() > 0) {
            this.binding.efAcSpinner.setText("");
            this.binding.efAcSpinner.setHint(requireActivity().getResources().getString(R.string.select_assembly_constituency));
        }
        if (this.district.size() > 0 && this.districtcode.size() > 0) {
            this.binding.efDistrictSpinner.setText("");
            this.binding.efDistrictSpinner.setHint(requireActivity().getResources().getString(R.string.blo_select_district));
        }
        if (this.partList.size() > 0 && this.partNameList.size() > 0) {
            this.binding.efPartSpinner.setText("");
            this.binding.efPartSpinner.setHint(requireActivity().getResources().getString(R.string.select_part));
        }
        this.binding.selfName.setText("");
        this.binding.parentName.setText("");
        this.binding.grandparentName.setText("");
        this.binding.rvMapping.setVisibility(8);
        this.binding.tvRecordCount.setVisibility(8);
        this.binding.layoutVerifyButton.setVisibility(8);
        selecttab(this.binding.searchAcPartPslMB, this.binding.searchLocationMB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$3(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onViewCreated$2();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2() {
        this.binding.searchTabLayout.setVisibility(0);
        selecttab(this.binding.searchLocationMB, this.binding.searchAcPartPslMB);
        this.binding.searchByLocationDetailsLl.setVisibility(0);
        if (this.categoryType.equalsIgnoreCase("self")) {
            this.binding.grandparentNameLayout.setVisibility(8);
            this.binding.electorNameLayout.setVisibility(0);
            this.binding.parentNameLayout.setVisibility(0);
        }
        if (this.categoryType.equalsIgnoreCase("progeny")) {
            this.binding.electorNameLayout.setVisibility(8);
            this.binding.grandparentNameLayout.setVisibility(0);
            this.binding.parentNameLayout.setVisibility(0);
        }
        this.binding.oldStateSpinner.setText("");
        this.binding.oldStateSpinner.setHint(requireActivity().getResources().getString(R.string.blo_select_state));
        if (this.ACList.size() > 0 && this.ACNameList.size() > 0) {
            this.binding.oldAcNo.setText("");
            this.binding.oldAcNo.setHint(requireActivity().getResources().getString(R.string.select_assembly_constituency));
        }
        if (this.district.size() > 0 && this.districtcode.size() > 0) {
            this.binding.oldDistrictSpinner.setText("");
            this.binding.oldDistrictSpinner.setHint(requireActivity().getResources().getString(R.string.blo_select_district));
        }
        if (this.partList.size() > 0 && this.partNameList.size() > 0) {
            this.binding.oldPartNo.setText("");
            this.binding.oldPartNo.setHint(requireActivity().getResources().getString(R.string.select_part));
        }
        this.binding.oldPslNo.setText("");
        this.binding.lvVerifyDetails.setVisibility(8);
        this.binding.searchByAcDetailsLl.setVisibility(8);
        this.binding.layoutVerifyButton.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$4(View view) {
        if (TextUtils.isEmpty(this.efState)) {
            showDialog1("Alert", "Please select State");
            return;
        }
        if (this.categoryType.equalsIgnoreCase("self") && TextUtils.isEmpty(this.binding.selfName.getText().toString())) {
            showDialog1("Alert", "Please enter elector name ");
            return;
        }
        if (this.categoryType.equalsIgnoreCase("self") && TextUtils.isEmpty(this.binding.parentName.getText().toString())) {
            showDialog1("Alert", "Please enter relative name ");
            return;
        }
        if (this.categoryType.equalsIgnoreCase("progeny") && TextUtils.isEmpty(this.binding.parentName.getText().toString())) {
            showDialog1("Alert", "Please enter parent name");
        } else if (this.categoryType.equalsIgnoreCase("progeny") && TextUtils.isEmpty(this.binding.grandparentName.getText().toString())) {
            showDialog1("Alert", "Please enter parent relative's name");
        } else {
            callLocationApi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$5(View view) {
        String oldStateCd;
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        String str;
        String str2;
        String str3;
        String strValueOf4;
        String strValueOf5;
        String str4;
        String str5;
        String str6;
        int age;
        String str7;
        if (this.binding.wasElector2003RB.isChecked()) {
            if (this.binding.searchByAcDetailsLl.getVisibility() == 0) {
                if (this.payloads.size() > 0) {
                    String oldStateCd2 = this.payloads.get(0).getOldStateCd();
                    String strValueOf6 = String.valueOf(this.payloads.get(0).getOldAcNo());
                    String strValueOf7 = String.valueOf(this.payloads.get(0).getOldPartNumber());
                    strValueOf5 = String.valueOf(this.payloads.get(0).getOldPartSerialNo());
                    str4 = strValueOf6;
                    str5 = oldStateCd2;
                    age = this.payloads.get(0).getAge();
                    str6 = strValueOf7;
                    str7 = strValueOf5;
                } else {
                    str5 = null;
                    str4 = null;
                    str6 = null;
                    str7 = null;
                    age = 0;
                }
            } else {
                if (this.binding.searchByLocationDetailsLl.getVisibility() == 0 && this.newbloMappedList.size() > 0) {
                    Iterator<MappingList> it = this.newbloMappedList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            MappingList next = it.next();
                            if (next.isSelected()) {
                                String oldStateCd3 = next.getOldStateCd();
                                String strValueOf8 = String.valueOf(next.getOldAcNo());
                                String strValueOf9 = String.valueOf(next.getOldPartNumber());
                                strValueOf5 = String.valueOf(next.getOldPartSerialNo());
                                str4 = strValueOf8;
                                str5 = oldStateCd3;
                                str6 = strValueOf9;
                                age = next.getAge();
                                str7 = strValueOf5;
                            }
                        }
                    }
                }
                str5 = null;
                str4 = null;
                str6 = null;
                str7 = null;
                age = 0;
            }
            this.commomUtility.validateSirMapping(requireActivity(), this.token, this.state, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), str5, str4, str6, str7, this.acNo, this.partNo, this.sharedViewModel.getState(), this.sharedViewModel.getAge(), age, new AnonymousClass19(str5, str4, str6, str7));
            return;
        }
        if (this.binding.neitherElector2003RB.isChecked()) {
            sendDataToNext(null, null, this.binding.searchByAcDetailsLl.getVisibility() == 0 ? "searchByAc" : "SearchByLocation", "progeny", "", null);
            return;
        }
        if (this.binding.searchByAcDetailsLl.getVisibility() == 0) {
            if (this.Is2003Selected.equalsIgnoreCase("Y")) {
                if (this.payloads.size() > 0) {
                    oldStateCd = this.payloads.get(0).getOldStateCd();
                    strValueOf = String.valueOf(this.payloads.get(0).getOldAcNo());
                    strValueOf2 = String.valueOf(this.payloads.get(0).getOldPartNumber());
                    strValueOf3 = String.valueOf(this.payloads.get(0).getOldPartSerialNo());
                    this.payloads.get(0).getOldFullName();
                    str2 = strValueOf;
                    str = oldStateCd;
                    str3 = strValueOf2;
                    strValueOf4 = strValueOf3;
                }
            } else if (this.erollPayloads.size() > 0) {
                String stateCd = this.erollPayloads.get(0).getStateCd();
                String strValueOf10 = String.valueOf(this.erollPayloads.get(0).getAcNo());
                String strValueOf11 = String.valueOf(this.erollPayloads.get(0).getPartNo());
                str2 = strValueOf10;
                str = stateCd;
                strValueOf4 = String.valueOf(this.erollPayloads.get(0).getSerialNo());
                str3 = strValueOf11;
            }
            str = null;
            str2 = null;
            str3 = null;
            strValueOf4 = null;
        } else {
            if (this.binding.searchByLocationDetailsLl.getVisibility() == 0 && this.newbloMappedList.size() > 0) {
                Iterator<MappingList> it2 = this.newbloMappedList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        MappingList next2 = it2.next();
                        if (next2.isSelected()) {
                            oldStateCd = next2.getOldStateCd();
                            strValueOf = String.valueOf(next2.getOldAcNo());
                            strValueOf2 = String.valueOf(next2.getOldPartNumber());
                            strValueOf3 = String.valueOf(next2.getOldPartSerialNo());
                            next2.getOldFullName();
                            str2 = strValueOf;
                            str = oldStateCd;
                            str3 = strValueOf2;
                            strValueOf4 = strValueOf3;
                        }
                    }
                }
            }
            str = null;
            str2 = null;
            str3 = null;
            strValueOf4 = null;
        }
        this.utils.validateProgenyDetails(requireActivity(), str, str2, str3, strValueOf4, this.sharedViewModel.getElectorname(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.20
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
            public void onResult(boolean isValidate) {
                if (isValidate) {
                    SearchFragment searchFragment = SearchFragment.this;
                    searchFragment.sendDataToNext(null, null, searchFragment.binding.searchByAcDetailsLl.getVisibility() == 0 ? "searchByAc" : "SearchByLocation", "progeny", "", SearchFragment.this.Is2003Selected);
                }
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$19, reason: invalid class name */
    class AnonymousClass19 implements ValidateMapCallback {
        final /* synthetic */ String val$finalOldAC;
        final /* synthetic */ String val$finalOldPart;
        final /* synthetic */ String val$finalOldSerial;
        final /* synthetic */ String val$finalOldState;

        AnonymousClass19(final String val$finalOldState, final String val$finalOldAC, final String val$finalOldPart, final String val$finalOldSerial) {
            this.val$finalOldState = val$finalOldState;
            this.val$finalOldAC = val$finalOldAC;
            this.val$finalOldPart = val$finalOldPart;
            this.val$finalOldSerial = val$finalOldSerial;
        }

        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback
        public void onCallBack(String statusCode, String message, final String bloNumber, final String bloName) {
            if (statusCode.equalsIgnoreCase("200")) {
                SearchFragment.this.nextAction();
                return;
            }
            if (statusCode.equalsIgnoreCase("409")) {
                if (TextUtils.isEmpty(bloNumber) || bloNumber.equalsIgnoreCase("null")) {
                    bloNumber = "";
                }
                if (TextUtils.isEmpty(bloName) || bloName.equalsIgnoreCase("null")) {
                    bloName = "";
                }
                final String strTrim = message.split(":-")[1].trim();
                SearchFragment.this.utils.decisionDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message, SearchFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), "Ok", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.19.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onNegativeButtonClicked() {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onPositiveButtonClicked() {
                        SearchFragment.this.utils.infoDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), SearchFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping_des), new OkCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.19.1.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.OkCallback
                            public void onPositiveButtonClicked() {
                                SearchFragment.this.commomUtility.checkSelfMappingConflict(SearchFragment.this.requireActivity(), SearchFragment.this.token, SearchFragment.this.state, SharedPref.getInstance(SearchFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(SearchFragment.this.getContext()).getRtknBnd(), AnonymousClass19.this.val$finalOldState, AnonymousClass19.this.val$finalOldAC, AnonymousClass19.this.val$finalOldPart, AnonymousClass19.this.val$finalOldSerial, SearchFragment.this.acNo, SearchFragment.this.partNo, SearchFragment.this.sharedViewModel.getState(), SearchFragment.this.sharedViewModel.getAge(), 0, SearchFragment.this.sharedViewModel.getEpicNumber(), String.valueOf(SearchFragment.this.sharedViewModel.getEpicId()), bloName, bloNumber, strTrim, SearchFragment.this.sharedViewModel.getSerial());
                            }
                        });
                    }
                });
                return;
            }
            if (statusCode.equalsIgnoreCase("0")) {
                SearchFragment.this.utils.infoDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            } else {
                SearchFragment.this.utils.infoDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        }
    }

    private void filteredStateList() {
        final ArrayList arrayList = new ArrayList();
        arrayList.add("Andaman & Nicobar Islands");
        arrayList.add("Bihar");
        arrayList.add("Chhattisgarh");
        arrayList.add("Chattisgarh");
        arrayList.add("Goa");
        arrayList.add("Gujarat");
        arrayList.add("Kerala");
        arrayList.add("Lakshadweep");
        arrayList.add("Madhya Pradesh");
        arrayList.add("Puducherry");
        arrayList.add("Rajasthan");
        arrayList.add("Tamil Nadu");
        arrayList.add("West Bengal");
        arrayList.add("Uttar Pradesh");
        this.StateNameList25_26.removeIf(new Predicate() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda10
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SearchFragment.lambda$filteredStateList$6(arrayList, (String) obj);
            }
        });
        final ArrayList arrayList2 = new ArrayList();
        arrayList2.add("U01");
        arrayList2.add("S04");
        arrayList2.add("S26");
        arrayList2.add("S05");
        arrayList2.add("S06");
        arrayList2.add("S11");
        arrayList2.add("U06");
        arrayList2.add("S12");
        arrayList2.add("U07");
        arrayList2.add("S20");
        arrayList2.add("S22");
        arrayList2.add("S25");
        arrayList2.add("S24");
        this.StateList25_26.removeIf(new Predicate() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda11
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SearchFragment.lambda$filteredStateList$7(arrayList2, (String) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$filteredStateList$6(ArrayList arrayList, String str) {
        return !arrayList.contains(str);
    }

    static /* synthetic */ boolean lambda$filteredStateList$7(ArrayList arrayList, String str) {
        return !arrayList.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextAction() {
        if (this.binding.searchByAcDetailsLl.getVisibility() == 0) {
            showDialog2(requireActivity().getResources().getString(R.string.alertMsg), requireActivity().getResources().getString(R.string.alert_message_relative), "searchByAc", "self");
        } else if (this.binding.searchByLocationDetailsLl.getVisibility() == 0) {
            showDialog2(requireActivity().getResources().getString(R.string.alertMsg), requireActivity().getResources().getString(R.string.alert_message_relative), "SearchByLocation", "self");
        }
    }

    public void callLocationApi() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        if (this.categoryType.equalsIgnoreCase("self")) {
            map2.put("applicantName", this.binding.selfName.getText().toString());
            map2.put("relativeName", this.binding.parentName.getText().toString());
        }
        if (this.categoryType.equalsIgnoreCase("progeny")) {
            map2.put("relativeName", this.binding.parentName.getText().toString());
            map2.put("grandParentName", this.binding.grandparentName.getText().toString());
        }
        map2.put("stateCd", this.efState);
        map2.put("mappingType", this.categoryType);
        map2.put("districtNo", this.efDistrict);
        map2.put("acNo", this.efAc);
        map2.put("partNo", this.efPart);
        map2.put("efEpicNumber", this.sharedViewModel.getEpicNumber());
        map2.put("efApplicantName", this.sharedViewModel.getElectorname());
        map2.put("efRelativeName", this.sharedViewModel.getRelativeName());
        map2.put("efStateCd", this.sharedViewModel.getState());
        map2.put("efRelationType", this.sharedViewModel.getRelationType());
        map2.put("efAge", Integer.valueOf(this.sharedViewModel.getAge()));
        map2.put("efAcNo", this.sharedViewModel.getAcno());
        map2.put("efPartNo", this.sharedViewModel.getPartno());
        map2.put("efPartSerialNo", this.sharedViewModel.getSerial());
        Call<LocationRoot> searchLocationFamily = ((UserClient) ApiClient.getClient2(requireContext()).create(UserClient.class)).getSearchLocationFamily(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        searchLocationFamily.enqueue(new AnonymousClass29());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$29, reason: invalid class name */
    class AnonymousClass29 implements Callback<LocationRoot> {
        AnonymousClass29() {
        }

        public void onResponse(Call<LocationRoot> call, Response<LocationRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    SearchFragment.this.newbloMappedList = ((LocationRoot) response.body()).payload.mappingList;
                    if (SearchFragment.this.newbloMappedList.size() > 0) {
                        Logger.d("blo list size", "" + SearchFragment.this.newbloMappedList.size());
                        SearchFragment.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(SearchFragment.this.requireActivity()));
                        if (SearchFragment.this.newbloMappedList != null && !SearchFragment.this.newbloMappedList.isEmpty()) {
                            SearchFragment.this.binding.rvMapping.setVisibility(0);
                            SearchFragment.this.binding.tvRecordCount.setVisibility(0);
                            SearchFragment.this.binding.tvRecordCount.setText(SearchFragment.this.requireActivity().getResources().getString(R.string.total_record) + StringUtils.SPACE + SearchFragment.this.newbloMappedList.size());
                            SearchFragment.this.adapter = new SearchLocationAdapter(SearchFragment.this.requireActivity(), SearchFragment.this.newbloMappedList, new SearchLocationAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$29$$ExternalSyntheticLambda0
                                @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.SearchLocationAdapter.OnItemSelectedListener
                                public final void onItemSelected() {
                                    this.f$0.lambda$onResponse$0();
                                }
                            });
                            SearchFragment.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(SearchFragment.this.getContext()));
                            SearchFragment.this.binding.rvMapping.setNestedScrollingEnabled(false);
                            SearchFragment.this.binding.rvMapping.setAdapter(SearchFragment.this.adapter);
                        }
                    } else {
                        new Utils().infoDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.alertMsg), SearchFragment.this.requireActivity().getResources().getString(R.string.no_data_found));
                    }
                } catch (Exception unused) {
                }
                SearchFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                if (SearchFragment.this.alertDialog != null) {
                    SearchFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            try {
                if (SearchFragment.this.alertDialog != null) {
                    SearchFragment.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                if (TextUtils.isEmpty(strOptString)) {
                    new Utils().infoDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.alertMsg), jSONObject.optString("error"));
                } else {
                    new Utils().infoDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.alertMsg), strOptString);
                }
                Logger.e("TAG", strOptString);
                if (SearchFragment.this.alertDialog != null) {
                    SearchFragment.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (SearchFragment.this.alertDialog != null) {
                    SearchFragment.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            SearchFragment.this.binding.layoutVerifyButton.setVisibility(0);
        }

        public void onFailure(Call<LocationRoot> call, Throwable t) {
            if (SearchFragment.this.alertDialog != null) {
                SearchFragment.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    @Override // in.gov.eci.bloapp.LazyLoadable
    public void onVisible(Context context) {
        if (this.hasLoaded) {
            return;
        }
        this.hasLoaded = true;
        fetchDataFromApi(context);
    }

    private void showDialog2(String alertText, String message, final String activeTab, final String mappingtype) {
        new android.app.AlertDialog.Builder(requireActivity()).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(requireActivity().getResources().getString(R.string.blo_yes), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$9(activeTab, mappingtype, dialogInterface, i);
            }
        }).setNegativeButton(requireActivity().getResources().getString(R.string.blo_No), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$10(activeTab, mappingtype, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$9(final String str, final String str2, DialogInterface dialogInterface, int i) {
        CentralDialogFragment centralDialogFragment = new CentralDialogFragment();
        centralDialogFragment.setArguments(getBundle(this.Is2003Selected));
        centralDialogFragment.setOnDataReceivedListener(new CentralDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda14
            @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.OnDataReceivedListener
            public final void onDataReceived(Payload payload, MappingList mappingList, String str3) {
                this.f$0.lambda$showDialog2$8(str, str2, payload, mappingList, str3);
            }
        });
        centralDialogFragment.show(getParentFragmentManager(), "CentralDialog");
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$8(String str, String str2, Payload payload, MappingList mappingList, String str3) {
        sendDataToNext(payload, mappingList, str, str2, (payload == null && mappingList == null) ? "N" : "", str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$10(String str, String str2, DialogInterface dialogInterface, int i) {
        sendDataToNext(null, null, str, str2, "N", null);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:113:0x04df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0460 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:? A[LOOP:0: B:56:0x044e->B:115:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x035b  */
    /* JADX WARN: Code duplicated, block: B:50:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:52:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:55:0x0448  */
    /* JADX WARN: Code duplicated, block: B:58:0x0454  */
    /* JADX WARN: Code duplicated, block: B:61:0x04df A[EDGE_INSN: B:61:0x04df->B:63:0x04e9 BREAK  A[LOOP:0: B:56:0x044e->B:115:?]] */
    /* JADX WARN: Code duplicated, block: B:83:0x055a  */
    /* JADX WARN: Code duplicated, block: B:85:0x0562  */
    /* JADX WARN: Code duplicated, block: B:86:0x0666  */
    /* JADX WARN: Code duplicated, block: B:87:0x0676  */
    /* JADX WARN: Code duplicated, block: B:89:0x068c  */
    public void sendDataToNext(Payload searchModel, MappingList mappingList, String activeTab, String mappingtype, String no, String is2003Selected) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        SearchFragment searchFragment;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        Iterator<MappingList> it;
        MappingList next;
        String str29;
        String str30;
        Intent intent = new Intent((Context) requireActivity(), (Class<?>) EnumrationFormActivity.class);
        intent.putExtra("dob", this.sharedViewModel.getDob());
        intent.putExtra("mappingType", "Search");
        String str31 = "N";
        String str32 = "sirYearSelf";
        String str33 = "";
        String str34 = "sirYearProgeny";
        if (this.binding.neitherElector2003RB.isChecked()) {
            intent.putExtra("submittedForRecommendation", "N");
            intent.putExtra("self_categoryType", "na");
            intent.putExtra("isselected2003", this.Is2003Selected);
            intent.putExtra("sirYearSelf", "");
            intent.putExtra("sirYearProgeny", "");
            searchFragment = this;
        } else {
            boolean zEqualsIgnoreCase = activeTab.equalsIgnoreCase("searchByAc");
            String str35 = Constants.SIR_YEAR_PROGENY;
            String str36 = "Y";
            String str37 = Constants.SIR_YEAR_SELF;
            if (zEqualsIgnoreCase && mappingtype.equalsIgnoreCase("self")) {
                intent.putExtra("sirYearSelf", Constants.SIR_YEAR_SELF);
                if (!TextUtils.isEmpty(is2003Selected) && is2003Selected.equalsIgnoreCase("Y")) {
                    intent.putExtra("sirYearProgeny", Constants.SIR_YEAR_SELF);
                } else if (!TextUtils.isEmpty(is2003Selected) && is2003Selected.equalsIgnoreCase("N")) {
                    intent.putExtra("sirYearProgeny", Constants.SIR_YEAR_PROGENY);
                } else {
                    intent.putExtra("sirYearProgeny", "");
                }
                if (searchModel != null) {
                    intent.putExtra("father_epicNumber", searchModel.getEpicNumber());
                    intent.putExtra("father_oldPartNumber", searchModel.getOldPartNumber());
                    intent.putExtra("father_oldPartName", searchModel.getOldPartName());
                    intent.putExtra("father_oldPartSerialNo", searchModel.getOldPartSerialNo());
                    str2 = "father_oldAcName";
                    intent.putExtra(str2, searchModel.getOldAcName());
                    str3 = "father_oldAcNo";
                    intent.putExtra(str3, searchModel.getOldAcNo());
                    str4 = "father_oldDistName";
                    intent.putExtra(str4, searchModel.getOldDistName());
                    str5 = "father_oldDistNo";
                    intent.putExtra(str5, searchModel.getOldDistNo());
                    str6 = "father_oldStateName";
                    intent.putExtra(str6, searchModel.getOldStateName());
                    str = "father_oldStateCd";
                    intent.putExtra(str, searchModel.getOldStateCd());
                    str30 = "father_relationType";
                    intent.putExtra(str30, searchModel.getRelationType());
                    str7 = "father_oldFullName";
                    intent.putExtra(str7, searchModel.getOldFullName());
                    str8 = "father_oldRelativeFullName";
                    intent.putExtra(str8, searchModel.getOldRelativeFullName());
                    intent.putExtra("father_markedByBlo", searchModel.getMarkedByBlo());
                    str29 = "rlnprgnyoldage";
                    intent.putExtra(str29, searchModel.getAge());
                } else {
                    str29 = "rlnprgnyoldage";
                    str = "father_oldStateCd";
                    str2 = "father_oldAcName";
                    str30 = "father_relationType";
                    str3 = "father_oldAcNo";
                    str7 = "father_oldFullName";
                    str4 = "father_oldDistName";
                    str8 = "father_oldRelativeFullName";
                    str5 = "father_oldDistNo";
                    str6 = "father_oldStateName";
                }
                if (mappingList != null) {
                    intent.putExtra("father_epicNumber", mappingList.getOldEpicNumber());
                    intent.putExtra("father_oldPartNumber", mappingList.getOldPartNumber());
                    intent.putExtra("father_oldPartName", mappingList.getOldPartName());
                    intent.putExtra("father_oldPartSerialNo", mappingList.getOldPartSerialNo());
                    intent.putExtra(str2, mappingList.getOldAcName());
                    intent.putExtra(str3, mappingList.getOldAcNo());
                    intent.putExtra(str4, mappingList.getOldDistName());
                    intent.putExtra(str5, mappingList.getOldDistNo());
                    intent.putExtra(str6, mappingList.getOldStateName());
                    intent.putExtra(str, mappingList.getOldStateCd());
                    intent.putExtra(str30, mappingList.getRelationType());
                    intent.putExtra(str7, mappingList.getOldFullName());
                    intent.putExtra(str8, mappingList.getOldRelativeFullName());
                    intent.putExtra(str29, mappingList.getAge());
                }
                str10 = str30;
                if (this.payloads.size() > 0) {
                    str9 = str29;
                    intent.putExtra("self_selfOldName", this.payloads.get(0).getOldFullName());
                    intent.putExtra("self_selfOldEpic", this.payloads.get(0).getEpicNumber());
                    intent.putExtra("self_selfOldRlnName", this.payloads.get(0).getOldRelativeFullName());
                    intent.putExtra("self_selfOldRlnType", this.payloads.get(0).getRelationType());
                    intent.putExtra("self_OldStateCd", this.payloads.get(0).getOldStateCd());
                    intent.putExtra("self_oldStateName", this.payloads.get(0).getOldStateName());
                    intent.putExtra("self_oldStateName", this.payloads.get(0).getOldStateName());
                    intent.putExtra("self_oldAcName", this.payloads.get(0).getOldAcName());
                    intent.putExtra("self_oldAcNo", this.payloads.get(0).getOldAcNo());
                    intent.putExtra("self_oldPartNumber", this.payloads.get(0).getOldPartNumber());
                    intent.putExtra("self_oldPartName", this.payloads.get(0).getOldPartName());
                    intent.putExtra("self_oldPartSerialNo", this.payloads.get(0).getOldPartSerialNo());
                    intent.putExtra("selfoldage", this.payloads.get(0).getAge());
                } else {
                    str9 = str29;
                }
            } else {
                str = "father_oldStateCd";
                str2 = "father_oldAcName";
                str33 = "";
                str36 = "Y";
                str3 = "father_oldAcNo";
                str35 = Constants.SIR_YEAR_PROGENY;
                str4 = "father_oldDistName";
                str31 = "N";
                str5 = "father_oldDistNo";
                str34 = "sirYearProgeny";
                str6 = "father_oldStateName";
                str32 = "sirYearSelf";
                str7 = "father_oldFullName";
                str37 = Constants.SIR_YEAR_SELF;
                str8 = "father_oldRelativeFullName";
                str9 = "rlnprgnyoldage";
                str10 = "father_relationType";
            }
            String str38 = str10;
            if (activeTab.equalsIgnoreCase("SearchByLocation") && mappingtype.equalsIgnoreCase("self")) {
                String str39 = str37;
                intent.putExtra(str32, str39);
                if (!TextUtils.isEmpty(is2003Selected)) {
                    str24 = str8;
                    str25 = is2003Selected;
                    str34 = str34;
                    if (str25.equalsIgnoreCase(str36)) {
                        intent.putExtra(str34, str39);
                        str37 = str39;
                        str31 = str31;
                        str26 = str35;
                    }
                    str35 = str26;
                    if (searchModel != null) {
                        intent.putExtra("father_epicNumber", searchModel.getEpicNumber());
                        intent.putExtra("father_oldPartNumber", searchModel.getOldPartNumber());
                        intent.putExtra("father_oldPartName", searchModel.getOldPartName());
                        intent.putExtra("father_oldPartSerialNo", searchModel.getOldPartSerialNo());
                        intent.putExtra(str2, searchModel.getOldAcName());
                        intent.putExtra(str3, searchModel.getOldAcNo());
                        intent.putExtra(str4, searchModel.getOldDistName());
                        intent.putExtra(str5, searchModel.getOldDistNo());
                        intent.putExtra(str6, searchModel.getOldStateName());
                        intent.putExtra(str, searchModel.getOldStateCd());
                        intent.putExtra(str38, searchModel.getRelationType());
                        intent.putExtra(str7, searchModel.getOldFullName());
                        str27 = str24;
                        intent.putExtra(str27, searchModel.getOldRelativeFullName());
                        intent.putExtra("father_markedByBlo", searchModel.getMarkedByBlo());
                        str28 = str9;
                        intent.putExtra(str28, searchModel.getAge());
                    } else {
                        str27 = str24;
                        str28 = str9;
                    }
                    if (mappingList != null) {
                        intent.putExtra("father_epicNumber", mappingList.getOldEpicNumber());
                        intent.putExtra("father_oldPartNumber", mappingList.getOldPartNumber());
                        intent.putExtra("father_oldPartName", mappingList.getOldPartName());
                        intent.putExtra("father_oldPartSerialNo", mappingList.getOldPartSerialNo());
                        intent.putExtra(str2, mappingList.getOldAcName());
                        intent.putExtra(str3, mappingList.getOldAcNo());
                        intent.putExtra(str4, mappingList.getOldDistName());
                        intent.putExtra(str5, mappingList.getOldDistNo());
                        intent.putExtra(str6, mappingList.getOldStateName());
                        intent.putExtra(str, mappingList.getOldStateCd());
                        intent.putExtra(str38, mappingList.getRelationType());
                        intent.putExtra(str7, mappingList.getOldFullName());
                        intent.putExtra(str27, mappingList.getOldRelativeFullName());
                        intent.putExtra(str28, mappingList.getAge());
                    }
                    str11 = str38;
                    str13 = str28;
                    searchFragment = this;
                    if (searchFragment.newbloMappedList.size() <= 0) {
                        str12 = str27;
                        break;
                    }
                    it = searchFragment.newbloMappedList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str12 = str27;
                            break;
                        }
                        next = it.next();
                        if (next.isSelected()) {
                            str12 = str27;
                            intent.putExtra("self_selfOldName", next.getOldFullName());
                            intent.putExtra("self_selfOldEpic", next.getOldEpicNumber());
                            intent.putExtra("self_selfOldRlnName", next.getOldRelativeFullName());
                            intent.putExtra("self_selfOldRlnType", next.getRelationType());
                            intent.putExtra("self_categoryType", searchFragment.categoryType);
                            intent.putExtra("self_OldStateCd", next.getOldStateCd());
                            intent.putExtra("self_oldStateName", next.getOldStateName());
                            intent.putExtra("self_oldStateName", next.getOldStateName());
                            intent.putExtra("self_oldAcName", next.getOldAcName());
                            intent.putExtra("self_oldAcNo", next.getOldAcNo());
                            intent.putExtra("self_oldPartNumber", next.getOldPartNumber());
                            intent.putExtra("self_oldPartName", next.getOldPartName());
                            intent.putExtra("self_oldPartSerialNo", next.getOldPartSerialNo());
                            intent.putExtra("selfoldage", next.getAge());
                            break;
                        }
                    }
                } else {
                    str24 = str8;
                    str34 = str34;
                    str25 = is2003Selected;
                }
                if (!TextUtils.isEmpty(is2003Selected)) {
                    str37 = str39;
                    str31 = str31;
                    if (str25.equalsIgnoreCase(str31)) {
                        str26 = str35;
                        intent.putExtra(str34, str26);
                    }
                    str35 = str26;
                    if (searchModel != null) {
                        intent.putExtra("father_epicNumber", searchModel.getEpicNumber());
                        intent.putExtra("father_oldPartNumber", searchModel.getOldPartNumber());
                        intent.putExtra("father_oldPartName", searchModel.getOldPartName());
                        intent.putExtra("father_oldPartSerialNo", searchModel.getOldPartSerialNo());
                        intent.putExtra(str2, searchModel.getOldAcName());
                        intent.putExtra(str3, searchModel.getOldAcNo());
                        intent.putExtra(str4, searchModel.getOldDistName());
                        intent.putExtra(str5, searchModel.getOldDistNo());
                        intent.putExtra(str6, searchModel.getOldStateName());
                        intent.putExtra(str, searchModel.getOldStateCd());
                        intent.putExtra(str38, searchModel.getRelationType());
                        intent.putExtra(str7, searchModel.getOldFullName());
                        str27 = str24;
                        intent.putExtra(str27, searchModel.getOldRelativeFullName());
                        intent.putExtra("father_markedByBlo", searchModel.getMarkedByBlo());
                        str28 = str9;
                        intent.putExtra(str28, searchModel.getAge());
                    } else {
                        str27 = str24;
                        str28 = str9;
                    }
                    if (mappingList != null) {
                        intent.putExtra("father_epicNumber", mappingList.getOldEpicNumber());
                        intent.putExtra("father_oldPartNumber", mappingList.getOldPartNumber());
                        intent.putExtra("father_oldPartName", mappingList.getOldPartName());
                        intent.putExtra("father_oldPartSerialNo", mappingList.getOldPartSerialNo());
                        intent.putExtra(str2, mappingList.getOldAcName());
                        intent.putExtra(str3, mappingList.getOldAcNo());
                        intent.putExtra(str4, mappingList.getOldDistName());
                        intent.putExtra(str5, mappingList.getOldDistNo());
                        intent.putExtra(str6, mappingList.getOldStateName());
                        intent.putExtra(str, mappingList.getOldStateCd());
                        intent.putExtra(str38, mappingList.getRelationType());
                        intent.putExtra(str7, mappingList.getOldFullName());
                        intent.putExtra(str27, mappingList.getOldRelativeFullName());
                        intent.putExtra(str28, mappingList.getAge());
                    }
                    str11 = str38;
                    str13 = str28;
                    searchFragment = this;
                    if (searchFragment.newbloMappedList.size() <= 0) {
                        str12 = str27;
                        break;
                    }
                    it = searchFragment.newbloMappedList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str12 = str27;
                            break;
                        }
                        next = it.next();
                        if (next.isSelected()) {
                            str12 = str27;
                            intent.putExtra("self_selfOldName", next.getOldFullName());
                            intent.putExtra("self_selfOldEpic", next.getOldEpicNumber());
                            intent.putExtra("self_selfOldRlnName", next.getOldRelativeFullName());
                            intent.putExtra("self_selfOldRlnType", next.getRelationType());
                            intent.putExtra("self_categoryType", searchFragment.categoryType);
                            intent.putExtra("self_OldStateCd", next.getOldStateCd());
                            intent.putExtra("self_oldStateName", next.getOldStateName());
                            intent.putExtra("self_oldStateName", next.getOldStateName());
                            intent.putExtra("self_oldAcName", next.getOldAcName());
                            intent.putExtra("self_oldAcNo", next.getOldAcNo());
                            intent.putExtra("self_oldPartNumber", next.getOldPartNumber());
                            intent.putExtra("self_oldPartName", next.getOldPartName());
                            intent.putExtra("self_oldPartSerialNo", next.getOldPartSerialNo());
                            intent.putExtra("selfoldage", next.getAge());
                            break;
                        }
                    }
                } else {
                    str37 = str39;
                    str31 = str31;
                }
                str26 = str35;
                intent.putExtra(str34, str26);
                str35 = str26;
                if (searchModel != null) {
                    intent.putExtra("father_epicNumber", searchModel.getEpicNumber());
                    intent.putExtra("father_oldPartNumber", searchModel.getOldPartNumber());
                    intent.putExtra("father_oldPartName", searchModel.getOldPartName());
                    intent.putExtra("father_oldPartSerialNo", searchModel.getOldPartSerialNo());
                    intent.putExtra(str2, searchModel.getOldAcName());
                    intent.putExtra(str3, searchModel.getOldAcNo());
                    intent.putExtra(str4, searchModel.getOldDistName());
                    intent.putExtra(str5, searchModel.getOldDistNo());
                    intent.putExtra(str6, searchModel.getOldStateName());
                    intent.putExtra(str, searchModel.getOldStateCd());
                    intent.putExtra(str38, searchModel.getRelationType());
                    intent.putExtra(str7, searchModel.getOldFullName());
                    str27 = str24;
                    intent.putExtra(str27, searchModel.getOldRelativeFullName());
                    intent.putExtra("father_markedByBlo", searchModel.getMarkedByBlo());
                    str28 = str9;
                    intent.putExtra(str28, searchModel.getAge());
                } else {
                    str27 = str24;
                    str28 = str9;
                }
                if (mappingList != null) {
                    intent.putExtra("father_epicNumber", mappingList.getOldEpicNumber());
                    intent.putExtra("father_oldPartNumber", mappingList.getOldPartNumber());
                    intent.putExtra("father_oldPartName", mappingList.getOldPartName());
                    intent.putExtra("father_oldPartSerialNo", mappingList.getOldPartSerialNo());
                    intent.putExtra(str2, mappingList.getOldAcName());
                    intent.putExtra(str3, mappingList.getOldAcNo());
                    intent.putExtra(str4, mappingList.getOldDistName());
                    intent.putExtra(str5, mappingList.getOldDistNo());
                    intent.putExtra(str6, mappingList.getOldStateName());
                    intent.putExtra(str, mappingList.getOldStateCd());
                    intent.putExtra(str38, mappingList.getRelationType());
                    intent.putExtra(str7, mappingList.getOldFullName());
                    intent.putExtra(str27, mappingList.getOldRelativeFullName());
                    intent.putExtra(str28, mappingList.getAge());
                }
                str11 = str38;
                str13 = str28;
                searchFragment = this;
                if (searchFragment.newbloMappedList.size() <= 0) {
                    str12 = str27;
                    break;
                }
                it = searchFragment.newbloMappedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str12 = str27;
                        break;
                    }
                    next = it.next();
                    if (next.isSelected()) {
                        str12 = str27;
                        intent.putExtra("self_selfOldName", next.getOldFullName());
                        intent.putExtra("self_selfOldEpic", next.getOldEpicNumber());
                        intent.putExtra("self_selfOldRlnName", next.getOldRelativeFullName());
                        intent.putExtra("self_selfOldRlnType", next.getRelationType());
                        intent.putExtra("self_categoryType", searchFragment.categoryType);
                        intent.putExtra("self_OldStateCd", next.getOldStateCd());
                        intent.putExtra("self_oldStateName", next.getOldStateName());
                        intent.putExtra("self_oldStateName", next.getOldStateName());
                        intent.putExtra("self_oldAcName", next.getOldAcName());
                        intent.putExtra("self_oldAcNo", next.getOldAcNo());
                        intent.putExtra("self_oldPartNumber", next.getOldPartNumber());
                        intent.putExtra("self_oldPartName", next.getOldPartName());
                        intent.putExtra("self_oldPartSerialNo", next.getOldPartSerialNo());
                        intent.putExtra("selfoldage", next.getAge());
                        break;
                    }
                }
            } else {
                str11 = str38;
                str12 = str8;
                str13 = str9;
                searchFragment = this;
            }
            String str40 = str7;
            if (activeTab.equalsIgnoreCase("searchByAc") && mappingtype.equalsIgnoreCase("progeny")) {
                String str41 = str33;
                intent.putExtra(str32, str41);
                if (TextUtils.isEmpty(searchFragment.Is2003Selected)) {
                    str20 = str36;
                } else {
                    str20 = str36;
                    if (searchFragment.Is2003Selected.equalsIgnoreCase(str20)) {
                        String str42 = str37;
                        str21 = str11;
                        str22 = str34;
                        intent.putExtra(str22, str42);
                        str23 = str;
                        str18 = str42;
                    }
                    if (searchFragment.Is2003Selected.equalsIgnoreCase(str20)) {
                        if (searchFragment.payloads.size() > 0) {
                            intent.putExtra("father_epicNumber", searchFragment.payloads.get(0).getEpicNumber());
                            intent.putExtra("father_oldPartNumber", searchFragment.payloads.get(0).getOldPartNumber());
                            intent.putExtra("father_oldPartName", searchFragment.payloads.get(0).getOldPartName());
                            intent.putExtra("father_oldPartSerialNo", searchFragment.payloads.get(0).getOldPartSerialNo());
                            intent.putExtra(str2, searchFragment.payloads.get(0).getOldAcName());
                            intent.putExtra(str3, searchFragment.payloads.get(0).getOldAcNo());
                            intent.putExtra(str4, searchFragment.payloads.get(0).getOldDistName());
                            intent.putExtra(str5, searchFragment.payloads.get(0).getOldDistNo());
                            intent.putExtra(str6, searchFragment.payloads.get(0).getOldStateName());
                            str14 = str23;
                            intent.putExtra(str14, searchFragment.payloads.get(0).getOldStateCd());
                            str33 = str41;
                            str15 = str21;
                            intent.putExtra(str15, searchFragment.payloads.get(0).getRelationType());
                            str19 = str20;
                            str16 = str40;
                            intent.putExtra(str16, searchFragment.payloads.get(0).getOldFullName());
                            str34 = str22;
                            String str43 = str12;
                            intent.putExtra(str43, searchFragment.payloads.get(0).getOldRelativeFullName());
                            str17 = str43;
                            intent.putExtra("father_markedByBlo", searchFragment.payloads.get(0).getMarkedByBlo());
                            intent.putExtra(str13, searchFragment.payloads.get(0).getAge());
                            intent.putExtra("isselected2003", searchFragment.Is2003Selected);
                        } else {
                            str33 = str41;
                            str15 = str21;
                            str14 = str23;
                            str34 = str22;
                            str19 = str20;
                            str16 = str40;
                            str17 = str12;
                        }
                    } else {
                        str33 = str41;
                        str15 = str21;
                        str14 = str23;
                        str34 = str22;
                        str19 = str20;
                        str16 = str40;
                        str17 = str12;
                        if (searchFragment.erollPayloads.size() > 0) {
                            intent.putExtra("father_epicNumber", searchFragment.erollPayloads.get(0).getEpicNumber());
                            intent.putExtra("father_oldPartNumber", searchFragment.erollPayloads.get(0).getPartNo());
                            intent.putExtra("father_oldPartName", searchFragment.erollPayloads.get(0).getPartName());
                            intent.putExtra("father_oldPartSerialNo", searchFragment.erollPayloads.get(0).getSerialNo());
                            intent.putExtra(str2, searchFragment.erollPayloads.get(0).getAcName());
                            intent.putExtra(str3, searchFragment.erollPayloads.get(0).getAcNo());
                            intent.putExtra(str4, searchFragment.erollPayloads.get(0).getDistrictName());
                            intent.putExtra(str5, searchFragment.erollPayloads.get(0).getDistrictNo());
                            intent.putExtra(str6, searchFragment.erollPayloads.get(0).getStateName());
                            intent.putExtra(str14, searchFragment.erollPayloads.get(0).getStateCd());
                            intent.putExtra(str15, searchFragment.erollPayloads.get(0).getRelationType());
                            intent.putExtra(str16, searchFragment.erollPayloads.get(0).getFullName());
                            intent.putExtra(str17, searchFragment.erollPayloads.get(0).getFullRelativeName());
                            intent.putExtra(str13, searchFragment.erollPayloads.get(0).getAge());
                            intent.putExtra("isselected2003", searchFragment.Is2003Selected);
                        }
                    }
                }
                str21 = str11;
                str22 = str34;
                str18 = str37;
                if (TextUtils.isEmpty(searchFragment.Is2003Selected)) {
                    str23 = str;
                } else {
                    str23 = str;
                    if (searchFragment.Is2003Selected.equalsIgnoreCase(str31)) {
                        intent.putExtra(str22, str35);
                    }
                    if (searchFragment.Is2003Selected.equalsIgnoreCase(str20)) {
                        if (searchFragment.payloads.size() > 0) {
                            intent.putExtra("father_epicNumber", searchFragment.payloads.get(0).getEpicNumber());
                            intent.putExtra("father_oldPartNumber", searchFragment.payloads.get(0).getOldPartNumber());
                            intent.putExtra("father_oldPartName", searchFragment.payloads.get(0).getOldPartName());
                            intent.putExtra("father_oldPartSerialNo", searchFragment.payloads.get(0).getOldPartSerialNo());
                            intent.putExtra(str2, searchFragment.payloads.get(0).getOldAcName());
                            intent.putExtra(str3, searchFragment.payloads.get(0).getOldAcNo());
                            intent.putExtra(str4, searchFragment.payloads.get(0).getOldDistName());
                            intent.putExtra(str5, searchFragment.payloads.get(0).getOldDistNo());
                            intent.putExtra(str6, searchFragment.payloads.get(0).getOldStateName());
                            str14 = str23;
                            intent.putExtra(str14, searchFragment.payloads.get(0).getOldStateCd());
                            str33 = str41;
                            str15 = str21;
                            intent.putExtra(str15, searchFragment.payloads.get(0).getRelationType());
                            str19 = str20;
                            str16 = str40;
                            intent.putExtra(str16, searchFragment.payloads.get(0).getOldFullName());
                            str34 = str22;
                            String str44 = str12;
                            intent.putExtra(str44, searchFragment.payloads.get(0).getOldRelativeFullName());
                            str17 = str44;
                            intent.putExtra("father_markedByBlo", searchFragment.payloads.get(0).getMarkedByBlo());
                            intent.putExtra(str13, searchFragment.payloads.get(0).getAge());
                            intent.putExtra("isselected2003", searchFragment.Is2003Selected);
                        } else {
                            str33 = str41;
                            str15 = str21;
                            str14 = str23;
                            str34 = str22;
                            str19 = str20;
                            str16 = str40;
                            str17 = str12;
                        }
                    } else {
                        str33 = str41;
                        str15 = str21;
                        str14 = str23;
                        str34 = str22;
                        str19 = str20;
                        str16 = str40;
                        str17 = str12;
                        if (searchFragment.erollPayloads.size() > 0) {
                            intent.putExtra("father_epicNumber", searchFragment.erollPayloads.get(0).getEpicNumber());
                            intent.putExtra("father_oldPartNumber", searchFragment.erollPayloads.get(0).getPartNo());
                            intent.putExtra("father_oldPartName", searchFragment.erollPayloads.get(0).getPartName());
                            intent.putExtra("father_oldPartSerialNo", searchFragment.erollPayloads.get(0).getSerialNo());
                            intent.putExtra(str2, searchFragment.erollPayloads.get(0).getAcName());
                            intent.putExtra(str3, searchFragment.erollPayloads.get(0).getAcNo());
                            intent.putExtra(str4, searchFragment.erollPayloads.get(0).getDistrictName());
                            intent.putExtra(str5, searchFragment.erollPayloads.get(0).getDistrictNo());
                            intent.putExtra(str6, searchFragment.erollPayloads.get(0).getStateName());
                            intent.putExtra(str14, searchFragment.erollPayloads.get(0).getStateCd());
                            intent.putExtra(str15, searchFragment.erollPayloads.get(0).getRelationType());
                            intent.putExtra(str16, searchFragment.erollPayloads.get(0).getFullName());
                            intent.putExtra(str17, searchFragment.erollPayloads.get(0).getFullRelativeName());
                            intent.putExtra(str13, searchFragment.erollPayloads.get(0).getAge());
                            intent.putExtra("isselected2003", searchFragment.Is2003Selected);
                        }
                    }
                }
                intent.putExtra(str22, str41);
                if (searchFragment.Is2003Selected.equalsIgnoreCase(str20)) {
                    if (searchFragment.payloads.size() > 0) {
                        intent.putExtra("father_epicNumber", searchFragment.payloads.get(0).getEpicNumber());
                        intent.putExtra("father_oldPartNumber", searchFragment.payloads.get(0).getOldPartNumber());
                        intent.putExtra("father_oldPartName", searchFragment.payloads.get(0).getOldPartName());
                        intent.putExtra("father_oldPartSerialNo", searchFragment.payloads.get(0).getOldPartSerialNo());
                        intent.putExtra(str2, searchFragment.payloads.get(0).getOldAcName());
                        intent.putExtra(str3, searchFragment.payloads.get(0).getOldAcNo());
                        intent.putExtra(str4, searchFragment.payloads.get(0).getOldDistName());
                        intent.putExtra(str5, searchFragment.payloads.get(0).getOldDistNo());
                        intent.putExtra(str6, searchFragment.payloads.get(0).getOldStateName());
                        str14 = str23;
                        intent.putExtra(str14, searchFragment.payloads.get(0).getOldStateCd());
                        str33 = str41;
                        str15 = str21;
                        intent.putExtra(str15, searchFragment.payloads.get(0).getRelationType());
                        str19 = str20;
                        str16 = str40;
                        intent.putExtra(str16, searchFragment.payloads.get(0).getOldFullName());
                        str34 = str22;
                        String str45 = str12;
                        intent.putExtra(str45, searchFragment.payloads.get(0).getOldRelativeFullName());
                        str17 = str45;
                        intent.putExtra("father_markedByBlo", searchFragment.payloads.get(0).getMarkedByBlo());
                        intent.putExtra(str13, searchFragment.payloads.get(0).getAge());
                        intent.putExtra("isselected2003", searchFragment.Is2003Selected);
                    } else {
                        str33 = str41;
                        str15 = str21;
                        str14 = str23;
                        str34 = str22;
                        str19 = str20;
                        str16 = str40;
                        str17 = str12;
                    }
                } else {
                    str33 = str41;
                    str15 = str21;
                    str14 = str23;
                    str34 = str22;
                    str19 = str20;
                    str16 = str40;
                    str17 = str12;
                    if (searchFragment.erollPayloads.size() > 0) {
                        intent.putExtra("father_epicNumber", searchFragment.erollPayloads.get(0).getEpicNumber());
                        intent.putExtra("father_oldPartNumber", searchFragment.erollPayloads.get(0).getPartNo());
                        intent.putExtra("father_oldPartName", searchFragment.erollPayloads.get(0).getPartName());
                        intent.putExtra("father_oldPartSerialNo", searchFragment.erollPayloads.get(0).getSerialNo());
                        intent.putExtra(str2, searchFragment.erollPayloads.get(0).getAcName());
                        intent.putExtra(str3, searchFragment.erollPayloads.get(0).getAcNo());
                        intent.putExtra(str4, searchFragment.erollPayloads.get(0).getDistrictName());
                        intent.putExtra(str5, searchFragment.erollPayloads.get(0).getDistrictNo());
                        intent.putExtra(str6, searchFragment.erollPayloads.get(0).getStateName());
                        intent.putExtra(str14, searchFragment.erollPayloads.get(0).getStateCd());
                        intent.putExtra(str15, searchFragment.erollPayloads.get(0).getRelationType());
                        intent.putExtra(str16, searchFragment.erollPayloads.get(0).getFullName());
                        intent.putExtra(str17, searchFragment.erollPayloads.get(0).getFullRelativeName());
                        intent.putExtra(str13, searchFragment.erollPayloads.get(0).getAge());
                        intent.putExtra("isselected2003", searchFragment.Is2003Selected);
                    }
                }
            } else {
                str14 = str;
                str15 = str11;
                str16 = str40;
                str17 = str12;
                String str46 = str36;
                str18 = str37;
                str19 = str46;
            }
            String str47 = str19;
            String str48 = str16;
            if (activeTab.equalsIgnoreCase("SearchByLocation")) {
                String str49 = str15;
                String str50 = str33;
                if (mappingtype.equalsIgnoreCase("progeny")) {
                    intent.putExtra(str32, str50);
                    if (!TextUtils.isEmpty(searchFragment.Is2003Selected) && searchFragment.Is2003Selected.equalsIgnoreCase(str47)) {
                        intent.putExtra(str34, str18);
                    } else {
                        intent.putExtra(str34, str50);
                    }
                    if (searchFragment.newbloMappedList.size() > 0) {
                        for (MappingList mappingList2 : searchFragment.newbloMappedList) {
                            if (mappingList2.isSelected()) {
                                intent.putExtra("father_epicNumber", mappingList2.getOldEpicNumber());
                                intent.putExtra("father_oldPartNumber", mappingList2.getOldPartNumber());
                                intent.putExtra("father_oldPartName", mappingList2.getOldPartName());
                                intent.putExtra("father_oldPartSerialNo", mappingList2.getOldPartSerialNo());
                                intent.putExtra(str2, mappingList2.getOldAcName());
                                intent.putExtra(str3, mappingList2.getOldAcNo());
                                intent.putExtra(str4, mappingList2.getOldDistName());
                                intent.putExtra(str5, mappingList2.getOldDistNo());
                                intent.putExtra(str6, mappingList2.getOldStateName());
                                intent.putExtra(str14, mappingList2.getOldStateCd());
                                intent.putExtra(str49, mappingList2.getRelationType());
                                intent.putExtra(str48, mappingList2.getOldFullName());
                                intent.putExtra(str17, mappingList2.getOldRelativeFullName());
                                intent.putExtra(str13, mappingList2.getAge());
                                break;
                            }
                            str13 = str13;
                        }
                    }
                }
            }
            intent.putExtra("submittedForRecommendation", str47);
            intent.putExtra("self_categoryType", searchFragment.categoryType);
            intent.putExtra(BooleanUtils.NO, no);
        }
        intent.putExtra("list_epicId", searchFragment.sharedViewModel.getEpicId());
        intent.putExtra("list_epicNo", searchFragment.sharedViewModel.getEpicNumber());
        intent.putExtra("mappingType", "Search");
        intent.putExtra("blo_stCode", searchFragment.state);
        intent.putExtra("blo_acNo", searchFragment.acNo);
        intent.putExtra("blo_partNo", searchFragment.partNo);
        intent.putExtra("list_partSerialNo", searchFragment.sharedViewModel.getSerial());
        intent.putExtra("list_epicName", searchFragment.sharedViewModel.getElectorname());
        intent.putExtra("from", searchFragment.sharedViewModel.getFrom());
        intent.putExtra("list_relationname", searchFragment.sharedViewModel.getRelativeName());
        intent.putExtra("list_relation_type", searchFragment.sharedViewModel.getRelationType());
        requireActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selecttab(MaterialButton selected, MaterialButton other) {
        selected.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.new_tab_color));
        selected.setTextColor(ContextCompat.getColor(getContext(), R.color.blo_white));
        other.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), android.R.color.transparent));
        other.setTextColor(ContextCompat.getColor(getContext(), R.color.blo_black));
        other.setStrokeWidth(2);
        other.setStrokeColor(ContextCompat.getColorStateList(getContext(), R.color.blo_light_grey));
    }

    public void getAllDistrict(final String oldState) {
        this.commomUtility.getSirDistrict(oldState, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda1
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllDistrict$14(oldState, i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllDistrict$14(final String str, int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda4
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$getAllDistrict$13(str, i2, str2, str3);
                }
            });
            return;
        }
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.blo_spinner_dropdown_new, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldDistrictSpinner.setAdapter(this.districtadapter);
        this.binding.oldDistrictSpinner.setThreshold(1);
        this.binding.efDistrictSpinner.setAdapter(this.districtadapter);
        this.binding.efDistrictSpinner.setThreshold(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllDistrict$13(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda12
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getAllDistrict$11(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        this.refreshToken = str3;
        SharedPref.getInstance(requireContext()).setRefreshToken(str3);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        this.commomUtility.getSirDistrict(str, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda13
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllDistrict$12(i2, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllDistrict$11(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllDistrict$12(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.blo_spinner_dropdown_new, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldDistrictSpinner.setAdapter(this.districtadapter);
        this.binding.oldDistrictSpinner.setThreshold(1);
        this.binding.efDistrictSpinner.setAdapter(this.districtadapter);
    }

    public void getAllAC(String oldstate) {
        this.commomUtility.getAllAC(oldstate, requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.30
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    SearchFragment.this.ACNameList.clear();
                    SearchFragment.this.ACList.clear();
                    SearchFragment.this.ACList = acList;
                    SearchFragment.this.ACNameList = acNameList;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) SearchFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) SearchFragment.this.ACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    SearchFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                    SearchFragment.this.binding.oldAcNo.setThreshold(1);
                    SearchFragment.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                    SearchFragment.this.binding.efAcSpinner.setThreshold(1);
                }
            }
        });
    }

    public void getACByDistrict(int oldDistrict, String oldState) {
        this.commomUtility.getAssmblyByDist(requireActivity(), oldDistrict, oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.31
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    SearchFragment.this.ACNameList.clear();
                    SearchFragment.this.ACList.clear();
                    SearchFragment.this.ACList = acList;
                    SearchFragment.this.ACNameList = acNameList;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) SearchFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) SearchFragment.this.ACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    SearchFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                    SearchFragment.this.binding.oldAcNo.setThreshold(1);
                    SearchFragment.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                    SearchFragment.this.binding.efAcSpinner.setThreshold(1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPartByAc() {
        this.commomUtility.getPartByAc(requireActivity(), Integer.parseInt(this.oldAc), this.oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.32
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    SearchFragment.this.partList.clear();
                    SearchFragment.this.partNameList.clear();
                    SearchFragment.this.partList = acList;
                    SearchFragment.this.partNameList = acNameList;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) SearchFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) SearchFragment.this.partNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    SearchFragment.this.binding.oldPartNo.setAdapter(arrayAdapter);
                    SearchFragment.this.binding.oldPartNo.setThreshold(1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPartByEfAc() {
        this.commomUtility.getPartByAc(requireActivity(), Integer.parseInt(this.efAc), this.efState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.33
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    SearchFragment.this.partList.clear();
                    SearchFragment.this.partNameList.clear();
                    SearchFragment.this.partList = acList;
                    SearchFragment.this.partNameList = acNameList;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) SearchFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) SearchFragment.this.partNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    SearchFragment.this.binding.efPartSpinner.setAdapter(arrayAdapter);
                    SearchFragment.this.binding.efPartSpinner.setThreshold(1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$15(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$15(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchDetails() {
        this.commomUtility.callVerifyRelativeApi(requireActivity(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), this.oldState, this.oldAc, this.OldPart, this.binding.oldPslNo.getText().toString().trim(), new SearchByAcPartCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.34
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback
            public void onCallBack(int code, List<Payload> datalist, String message) {
                if (code == 200) {
                    if (datalist != null && datalist.size() > 0) {
                        SearchFragment.this.payloads = datalist;
                        if (datalist.size() > 1) {
                            SearchFragment.this.showDialog1("Alert", "Multiple record found!!");
                            return;
                        }
                        Payload payload = datalist.get(0);
                        SearchFragment.this.binding.includeElectorDetails.tvStateName.setText(payload.getOldStateName());
                        SearchFragment.this.binding.includeElectorDetails.tvAcName.setText(String.valueOf(payload.getOldAcNo()) + " - " + (TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName()));
                        SearchFragment.this.binding.includeElectorDetails.tvPartName.setText(String.valueOf(payload.getOldPartNumber()) + " - " + (TextUtils.isEmpty(payload.getOldPartName()) ? "" : payload.getOldPartName()));
                        SearchFragment.this.binding.includeElectorDetails.tvDistrictName.setText(String.valueOf(payload.getOldDistNo()) + " - " + (TextUtils.isEmpty(payload.getOldDistName()) ? "" : payload.getOldDistName()));
                        SearchFragment.this.binding.includeElectorDetails.tvSerialName.setText(String.valueOf(payload.getOldPartSerialNo()));
                        SearchFragment.this.binding.includeElectorDetails.tvOldAge.setText(String.valueOf(payload.getAge()));
                        SearchFragment.this.binding.includeElectorDetails.tvOldEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                        if (!TextUtils.isEmpty(payload.getRelationType())) {
                            String relationType = payload.getRelationType();
                            if (relationType.equalsIgnoreCase("F") || relationType.equalsIgnoreCase("FATHER") || relationType.equalsIgnoreCase("FTHR")) {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Father");
                            } else if (relationType.equalsIgnoreCase("M") || relationType.equalsIgnoreCase("MOTHER") || relationType.equalsIgnoreCase("MTHR")) {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Mother");
                            } else if (relationType.equalsIgnoreCase("H") || relationType.equalsIgnoreCase("HUSBAND") || relationType.equalsIgnoreCase("HSBN")) {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Husband");
                            } else if (relationType.equalsIgnoreCase("W") || relationType.equalsIgnoreCase("WIFE")) {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Wife");
                            } else if (relationType.equalsIgnoreCase("L") || relationType.equalsIgnoreCase("OTHER") || relationType.equalsIgnoreCase("O")) {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Other");
                            } else if (relationType.equalsIgnoreCase("GMTH")) {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Grand Mother");
                            } else if (relationType.equalsIgnoreCase("GFTH")) {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Grand Father");
                            } else {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText(relationType);
                            }
                        }
                        SearchFragment.this.binding.lvVerifyDetails.setVisibility(0);
                        SearchFragment.this.binding.layoutVerifyButton.setVisibility(0);
                        SearchFragment.this.binding.includeElectorDetails.icon.setVisibility(8);
                        if (TextUtils.isEmpty(payload.getOldFullName()) && !TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            SearchFragment.this.binding.includeElectorDetails.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                            SearchFragment.this.binding.includeElectorDetails.lvVernacularName.setVisibility(8);
                        } else if (TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            SearchFragment.this.binding.includeElectorDetails.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            SearchFragment.this.binding.includeElectorDetails.lvVernacularName.setVisibility(8);
                        } else if (payload.getOldFullName().equalsIgnoreCase(payload.getOldFullNameL1())) {
                            SearchFragment.this.binding.includeElectorDetails.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            SearchFragment.this.binding.includeElectorDetails.lvVernacularName.setVisibility(8);
                        } else {
                            SearchFragment.this.binding.includeElectorDetails.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            SearchFragment.this.binding.includeElectorDetails.tvElectorNamev1.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                        }
                        if (SearchFragment.this.binding.wasElector2003RB.isChecked() && !TextUtils.isEmpty(payload.getOldFullName()) && !TextUtils.isEmpty(SearchFragment.this.sharedViewModel.getElectorname())) {
                            SearchFragment.this.binding.includeElectorDetails.matchingLayout.setVisibility(0);
                            SearchFragment.this.showResult(NameMatcher.getMatchResult(SearchFragment.this.sharedViewModel.getElectorname(), TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName()));
                            SearchFragment.this.binding.includeElectorDetails.tvLeftName.setText(SearchFragment.this.sharedViewModel.getElectorname());
                            SearchFragment.this.binding.includeElectorDetails.tvRightName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                        }
                        if (TextUtils.isEmpty(payload.getOldRelativeFullName()) && !TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            SearchFragment.this.binding.includeElectorDetails.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            SearchFragment.this.binding.includeElectorDetails.relativeNameV1.setVisibility(8);
                        } else if (TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            SearchFragment.this.binding.includeElectorDetails.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            SearchFragment.this.binding.includeElectorDetails.relativeNameV1.setVisibility(8);
                        } else if (payload.getOldRelativeFullName().equalsIgnoreCase(payload.getOldRelativeFullNameL1())) {
                            SearchFragment.this.binding.includeElectorDetails.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            SearchFragment.this.binding.includeElectorDetails.relativeNameV1.setVisibility(8);
                        } else {
                            SearchFragment.this.binding.includeElectorDetails.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            SearchFragment.this.binding.includeElectorDetails.tvRelativeNamev1.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                        }
                        SearchFragment.this.binding.includeElectorDetails.tvSectionName.setText("");
                        return;
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    SearchFragment.this.showDialog1("Alert", message);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                SearchFragment.this.showDialog1("Alert", message);
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment$37, reason: invalid class name */
    static /* synthetic */ class AnonymousClass37 {
        static final /* synthetic */ int[] $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType;

        static {
            int[] iArr = new int[NameMatcher.MatchType.values().length];
            $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType = iArr;
            try {
                iArr[NameMatcher.MatchType.EXACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[NameMatcher.MatchType.TOKEN_MATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[NameMatcher.MatchType.PARTIAL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[NameMatcher.MatchType.PARTIAL_WEAK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[NameMatcher.MatchType.NO_MATCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showResult(NameMatcher.MatchResult result) {
        int color;
        int i = AnonymousClass37.$SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[result.type.ordinal()];
        if (i == 1) {
            color = Color.parseColor("#2E7D32");
        } else if (i == 2) {
            color = Color.parseColor("#43A047");
        } else if (i == 3) {
            color = Color.parseColor("#FBC02D");
        } else if (i == 4) {
            color = Color.parseColor("#FB8C00");
        } else {
            color = Color.parseColor("#D32F2F");
        }
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.binding.includeElectorDetails.progressBar, "progress", this.binding.includeElectorDetails.progressBar.getProgress(), result.score);
        objectAnimatorOfInt.setDuration(800L);
        objectAnimatorOfInt.start();
        this.binding.includeElectorDetails.progressBar.setProgressTintList(ColorStateList.valueOf(color));
        this.binding.includeElectorDetails.progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(color));
    }

    private int adjustAlpha(int color, float factor) {
        return Color.argb(Math.round(Color.alpha(color) * factor), Color.red(color), Color.green(color), Color.blue(color));
    }

    public void clearLocationVariables() {
        this.binding.selfName.setText("");
        this.binding.parentName.setText("");
        this.binding.grandparentName.setText("");
        this.binding.rvMapping.setVisibility(8);
        this.binding.tvRecordCount.setVisibility(8);
        if (!this.binding.neitherElector2003RB.isChecked()) {
            this.binding.lvVerifyDetails.setVisibility(8);
        }
        this.efState = null;
        this.efDistrict = null;
        this.efAc = null;
        this.efPart = null;
        this.ACNameList.clear();
        this.ACList.clear();
        this.ACNameList.add(requireActivity().getResources().getString(R.string.select_assembly_constituency));
        this.ACList.add(0);
        this.partList.clear();
        this.partNameList.clear();
        this.partNameList.add(requireActivity().getResources().getString(R.string.select_part));
        this.partList.add(0);
        this.district.clear();
        this.districtcode.clear();
        this.district.add("Select District");
        this.districtcode.add("0");
        this.binding.efAcSpinner.setText("");
        this.binding.efDistrictSpinner.setText("");
        this.binding.efPartSpinner.setText("");
        this.binding.efStateSpinner.setText("");
        this.binding.efStateSpinner.setHint(requireActivity().getResources().getString(R.string.blo_select_state));
        this.binding.efAcSpinner.setHint(requireActivity().getResources().getString(R.string.select_assembly_constituency));
        this.binding.efDistrictSpinner.setHint(requireActivity().getResources().getString(R.string.blo_select_district));
        this.binding.efPartSpinner.setHint(requireActivity().getResources().getString(R.string.select_part));
    }

    public void clearACVariables() {
        this.isOldPartNoEntered = false;
        this.isOldAcNoEntered = false;
        this.isoldStateEntered = false;
        this.isOldPartSerialNoEntered = false;
        this.binding.oldPslNo.setText("");
        this.binding.rvMapping.setVisibility(8);
        this.binding.tvRecordCount.setVisibility(8);
        if (!this.binding.neitherElector2003RB.isChecked()) {
            this.binding.lvVerifyDetails.setVisibility(8);
        }
        this.oldState = null;
        this.oldAc = null;
        this.OldPart = null;
        this.oldDistrict = null;
        this.partList.clear();
        this.partNameList.clear();
        this.ACNameList.clear();
        this.ACList.clear();
        this.ACNameList.add(requireActivity().getResources().getString(R.string.select_assembly_constituency));
        this.ACList.add(0);
        this.partNameList.add(requireActivity().getResources().getString(R.string.select_part));
        this.partList.add(0);
        this.district.clear();
        this.districtcode.clear();
        this.district.add("Select District");
        this.districtcode.add("0");
        this.binding.oldStateSpinner.setText("");
        this.binding.oldAcNo.setText("");
        this.binding.oldDistrictSpinner.setText("");
        this.binding.oldPartNo.setText("");
        this.binding.oldStateSpinner.setHint(requireActivity().getResources().getString(R.string.blo_select_state));
        this.binding.oldAcNo.setHint(requireActivity().getResources().getString(R.string.select_assembly_constituency));
        this.binding.oldDistrictSpinner.setHint(requireActivity().getResources().getString(R.string.blo_select_district));
        this.binding.oldPartNo.setHint(requireActivity().getResources().getString(R.string.select_part));
        this.binding.oldPslNo.setText("");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.blo_spinner_dropdown_new, this.ACNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldAcNo.setAdapter(arrayAdapter);
        this.binding.oldAcNo.setThreshold(1);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getContext(), R.layout.blo_spinner_dropdown_new, this.district);
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldDistrictSpinner.setAdapter(arrayAdapter2);
        this.binding.oldDistrictSpinner.setThreshold(1);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(getContext(), R.layout.blo_spinner_dropdown_new, this.partNameList);
        arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldPartNo.setAdapter(arrayAdapter3);
        this.binding.oldPartNo.setThreshold(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ErollDataDetails() {
        this.commomUtility.callErollData(requireActivity(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), this.oldState, this.oldAc, this.OldPart, this.binding.oldPslNo.getText().toString().trim(), new ErollDataCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.35
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ErollDataCallback
            public void onCallBack(int code, List<PayloadNewMapping> datalist, String message) {
                String sectionNo;
                if (code == 200) {
                    if (datalist != null && datalist.size() > 0) {
                        SearchFragment.this.erollPayloads = datalist;
                        if (datalist.size() > 1) {
                            SearchFragment.this.utils.infoDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.alertMsg), SearchFragment.this.requireActivity().getResources().getString(R.string.multiple_record));
                            return;
                        }
                        PayloadNewMapping payloadNewMapping = datalist.get(0);
                        if (!TextUtils.isEmpty(payloadNewMapping.getIsActive()) && payloadNewMapping.getIsActive().equalsIgnoreCase(BooleanUtils.TRUE)) {
                            if (!TextUtils.isEmpty(payloadNewMapping.getUnderJo()) && payloadNewMapping.getUnderJo().equalsIgnoreCase("1")) {
                                SearchFragment.this.utils.infoDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.alertMsg), "The applicant is under Adjudication.");
                                return;
                            }
                            SearchFragment.this.binding.includeElectorDetails.tvStateName.setText(SearchFragment.this.oldStateName);
                            SearchFragment.this.binding.includeElectorDetails.tvDistrictName.setText(String.valueOf(payloadNewMapping.getDistrictNo()) + " - " + (TextUtils.isEmpty(payloadNewMapping.getDistrictName()) ? "" : payloadNewMapping.getDistrictName()));
                            SearchFragment.this.binding.includeElectorDetails.tvAcName.setText(String.valueOf(payloadNewMapping.getAcNo()) + "  -  " + (TextUtils.isEmpty(payloadNewMapping.getAcName()) ? "" : payloadNewMapping.getAcName()));
                            SearchFragment.this.binding.includeElectorDetails.tvPartName.setText(String.valueOf(payloadNewMapping.getPartNo()) + "  -  " + (TextUtils.isEmpty(payloadNewMapping.getPartName()) ? "" : payloadNewMapping.getPartName()));
                            SearchFragment.this.binding.includeElectorDetails.tvSerialName.setText(SearchFragment.this.binding.oldPslNo.getText().toString());
                            TextView textView = SearchFragment.this.binding.includeElectorDetails.tvSectionName;
                            if (TextUtils.isEmpty(payloadNewMapping.getSectionNo())) {
                                sectionNo = "  " + (!TextUtils.isEmpty(payloadNewMapping.getSectionName()) ? payloadNewMapping.getSectionName() : "");
                            } else {
                                sectionNo = payloadNewMapping.getSectionNo();
                            }
                            textView.setText(sectionNo);
                            SearchFragment.this.binding.includeElectorDetails.tvOldAge.setText(String.valueOf(payloadNewMapping.getAge()));
                            SearchFragment.this.binding.includeElectorDetails.tvOldEpic.setText(TextUtils.isEmpty(payloadNewMapping.getEpicNumber()) ? "" : payloadNewMapping.getEpicNumber());
                            TextUtils.isEmpty(payloadNewMapping.getEpicNumber());
                            SearchFragment.this.binding.includeElectorDetails.cardDisabled.setVisibility(0);
                            SearchFragment.this.binding.lvVerifyDetails.setVisibility(0);
                            SearchFragment.this.binding.layoutVerifyButton.setVisibility(0);
                            SearchFragment.this.binding.includeElectorDetails.icon.setVisibility(8);
                            if (!TextUtils.isEmpty(payloadNewMapping.getRelationType())) {
                                String relationType = payloadNewMapping.getRelationType();
                                if (relationType.equalsIgnoreCase("F") || relationType.equalsIgnoreCase("FATHER") || relationType.equalsIgnoreCase("FTHR")) {
                                    SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Father");
                                } else if (relationType.equalsIgnoreCase("M") || relationType.equalsIgnoreCase("MOTHER") || relationType.equalsIgnoreCase("MTHR")) {
                                    SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Mother");
                                } else if (relationType.equalsIgnoreCase("H") || relationType.equalsIgnoreCase("HUSBAND") || relationType.equalsIgnoreCase("HSBN")) {
                                    SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Husband");
                                } else if (relationType.equalsIgnoreCase("W") || relationType.equalsIgnoreCase("WIFE")) {
                                    SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Wife");
                                } else if (relationType.equalsIgnoreCase("L") || relationType.equalsIgnoreCase("OTHER") || relationType.equalsIgnoreCase("O")) {
                                    SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Other");
                                } else if (relationType.equalsIgnoreCase("GMTH")) {
                                    SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Grand Mother");
                                } else if (relationType.equalsIgnoreCase("GFTH")) {
                                    SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText("Grand Father");
                                } else {
                                    SearchFragment.this.binding.includeElectorDetails.tvRelativeType.setText(relationType);
                                }
                            }
                            if (TextUtils.isEmpty(payloadNewMapping.getFullName()) && !TextUtils.isEmpty(payloadNewMapping.getFullNameL1())) {
                                SearchFragment.this.binding.includeElectorDetails.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullNameL1()) ? "" : payloadNewMapping.getFullNameL1());
                                SearchFragment.this.binding.includeElectorDetails.lvVernacularName.setVisibility(8);
                            } else if (TextUtils.isEmpty(payloadNewMapping.getFullNameL1())) {
                                SearchFragment.this.binding.includeElectorDetails.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                SearchFragment.this.binding.includeElectorDetails.lvVernacularName.setVisibility(8);
                            } else if (payloadNewMapping.getFullName().equalsIgnoreCase(payloadNewMapping.getFullNameL1())) {
                                SearchFragment.this.binding.includeElectorDetails.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                SearchFragment.this.binding.includeElectorDetails.lvVernacularName.setVisibility(8);
                            } else {
                                SearchFragment.this.binding.includeElectorDetails.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                SearchFragment.this.binding.includeElectorDetails.tvElectorNamev1.setText(TextUtils.isEmpty(payloadNewMapping.getFullNameL1()) ? "" : payloadNewMapping.getFullNameL1());
                            }
                            if (TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) && !TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1())) {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1()) ? "" : payloadNewMapping.getFullRelativeNameL1());
                                SearchFragment.this.binding.includeElectorDetails.relativeNameV1.setVisibility(8);
                            } else if (TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1())) {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                SearchFragment.this.binding.includeElectorDetails.relativeNameV1.setVisibility(8);
                            } else if (payloadNewMapping.getFullRelativeName().equalsIgnoreCase(payloadNewMapping.getFullRelativeNameL1())) {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                SearchFragment.this.binding.includeElectorDetails.relativeNameV1.setVisibility(8);
                            } else {
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                SearchFragment.this.binding.includeElectorDetails.tvRelativeNamev1.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1()) ? "" : payloadNewMapping.getFullRelativeNameL1());
                            }
                            SearchFragment.this.binding.svView.fullScroll(130);
                            return;
                        }
                        SearchFragment.this.utils.infoDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.alertMsg), SearchFragment.this.requireActivity().getResources().getString(R.string.no_active_record));
                        return;
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    SearchFragment.this.utils.infoDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                SearchFragment.this.utils.infoDialog(SearchFragment.this.requireActivity(), SearchFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    private Bundle getBundle(String key) {
        Bundle bundle = new Bundle();
        bundle.putString("key", key);
        return bundle;
    }

    public void getAllOldAc2025(String oldState) {
        this.commomUtility.getAllAC2025(oldState, this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SearchFragment.36
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    SearchFragment.this.ACNameList.clear();
                    SearchFragment.this.ACList.clear();
                    SearchFragment.this.ACList = acList;
                    SearchFragment.this.ACNameList = acNameList;
                    if (SearchFragment.this.partNameList.size() > 0 && SearchFragment.this.partList.size() > 0) {
                        SearchFragment.this.partList.clear();
                        SearchFragment.this.partNameList.clear();
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) SearchFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) SearchFragment.this.ACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    SearchFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                    SearchFragment.this.binding.oldAcNo.setThreshold(1);
                }
            }
        });
    }
}
