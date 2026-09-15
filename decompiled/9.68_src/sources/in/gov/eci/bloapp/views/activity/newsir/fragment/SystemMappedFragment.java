package in.gov.eci.bloapp.views.activity.newsir.fragment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.LazyLoadable;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.FragmentTabTwoBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.NameMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.SharedViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.SystemMappedAdapter;
import in.gov.eci.bloapp.views.activity.newsir.adapter.SystemProgenyListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.OkCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingList;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.Payload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SystemMappedFragment extends Fragment implements LazyLoadable {
    private String acNo;
    SystemMappedAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    private FragmentTabTwoBinding binding;
    List<MappingList> grandParentList;
    String grandParentName;
    String id;
    boolean isOldAcNoEntered;
    boolean isOldPartNoEntered;
    boolean isOldPartSerialNoEntered;
    boolean isoldStateEntered;
    MappingRoot mappingModel;
    private String partNo;
    private String refreshToken;
    String relativeType;
    private String rtkband;
    SharedViewModel sharedViewModel;
    private String state;
    List<MappingList> systemMappedList;
    SystemProgenyListAdapter systemProgenyListAdapter;
    private String token;
    UserClient userClient;
    Utils utils;
    private boolean hasLoaded = false;
    boolean isUserSelected = false;
    List<Integer> ACList = new ArrayList();
    List<String> ACNameList = new ArrayList();
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    ArrayList<String> grandParentNameList = new ArrayList<>();
    ArrayList<String> grandParentCodeList = new ArrayList<>();
    List<String> partNameList = new ArrayList();
    List<Integer> partList = new ArrayList();
    String oldAc = null;
    String OldPart = null;
    String oldState = null;
    String oldStateName = null;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    Gson gson = new GsonBuilder().setLenient().create();
    boolean isSelf = false;
    boolean isProgeny = false;
    List<MappingList> selectedItemData = new ArrayList();
    List<Payload> payloads = new ArrayList();

    @Override // in.gov.eci.bloapp.LazyLoadable
    public void onVisible(Context context) {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentTabTwoBinding.inflate(getLayoutInflater());
        SharedViewModel sharedViewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        this.sharedViewModel = sharedViewModel;
        this.systemMappedList = sharedViewModel.getMappingModel().getPayload().getAlgoMapping().getMappingList();
        this.utils = new Utils();
        this.atkband = SharedPref.getInstance(requireActivity()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(requireActivity()).getRtknBnd();
        this.token = SharedPref.getInstance(requireActivity()).getToken();
        this.state = SharedPref.getInstance(requireActivity()).getStateCode();
        this.acNo = SharedPref.getInstance(requireActivity()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireActivity()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireActivity()).getRefreshToken();
        this.userClient = (UserClient) ApiClient.getClient2(requireActivity()).create(UserClient.class);
        initializeSpinnerTouch();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.StateList = SharedPref.getInstance(requireActivity()).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateNameList = SharedPref.getInstance(requireActivity()).getAcListName(Constants.STATE_LIST_NAME);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), R.layout.blo_spinner_dropdown, (List) this.StateNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.includeEdit.oldStateSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.grandParentNameList = SharedPref.getInstance(getContext()).getGrandParentName(Constants.GRANDPARENT_MAPPING_LIST_NAME);
        this.grandParentCodeList = SharedPref.getInstance(getContext()).getGrandParentCode(Constants.GRANDPARENT_MAPPING_LIST_CODE);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getContext(), R.layout.blo_spinner_dropdown, this.grandParentNameList);
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.spElectorRelative.setAdapter((SpinnerAdapter) arrayAdapter2);
        this.binding.includeCurrentDetails.electorNamePendingSir.setText(this.sharedViewModel.getElectorname());
        this.binding.includeCurrentDetails.serialNoPendingSir.setText(this.sharedViewModel.getSerial());
        this.binding.includeCurrentDetails.epicPendingSir.setText(this.sharedViewModel.getEpicNumber());
        this.binding.includeCurrentDetails.agePendingSir.setText(String.valueOf(this.sharedViewModel.getAge()));
        this.binding.includeCurrentDetails.relativeNamePendingSir.setText(this.sharedViewModel.getRelativeName());
        this.binding.includeCurrentDetails.relativeTypePendingSir.setText(this.sharedViewModel.getRelationType());
        if (this.sharedViewModel.getMappingModel().getPayload().algoApplicantCategory.equalsIgnoreCase("self")) {
            this.isSelf = true;
        } else if (this.sharedViewModel.getMappingModel().getPayload().algoApplicantCategory.equalsIgnoreCase("progeny")) {
            this.isProgeny = true;
        }
        if (this.isProgeny) {
            this.binding.lvProgenyDetails.setVisibility(0);
            this.binding.editableItem.setVisibility(8);
            this.binding.tvRelationtypetitle.setText(String.format(getResources().getString(R.string.relativeTypeEfsir), SharedPref.getInstance(getContext()).getlastSIRYear()));
            this.binding.txtDummyRelative.setText(String.format(getResources().getString(R.string.grandparentEfsir), SharedPref.getInstance(getContext()).getlastSIRYear()));
        } else if (this.isSelf) {
            this.binding.lvProgenyDetails.setVisibility(8);
            if (this.systemMappedList.size() == 1) {
                setPreSelectedData(this.systemMappedList.get(0));
                this.binding.includeEdit.headerTitle.setText(getContext().getResources().getString(R.string.indian_citizen_by, SharedPref.getInstance(getContext()).getlastSIRYear()));
                this.binding.includeEdit.headertitleaedit.setText(getContext().getResources().getString(R.string.indian_citizen_by, SharedPref.getInstance(getContext()).getlastSIRYear()));
                this.binding.editableItem.setVisibility(0);
                this.binding.includeEdit.lvCurrentDetails.setVisibility(8);
                this.binding.includeEdit.tvDisclamierSir.setVisibility(8);
                this.binding.includeEdit.tvStateName.setText(this.systemMappedList.get(0).getOldStateName());
                this.binding.includeEdit.tvDistrictName.setText(String.valueOf(this.systemMappedList.get(0).getOldDistNo()) + " - " + (TextUtils.isEmpty(this.systemMappedList.get(0).getOldDistName()) ? "" : this.systemMappedList.get(0).getOldDistName()));
                this.binding.includeEdit.tvAcName.setText(String.valueOf(this.systemMappedList.get(0).getOldAcNo()) + " - " + (TextUtils.isEmpty(this.systemMappedList.get(0).getOldAcName()) ? "" : this.systemMappedList.get(0).getOldAcName()));
                this.binding.includeEdit.tvPartName.setText(String.valueOf(this.systemMappedList.get(0).getOldPartNumber()) + " - " + (TextUtils.isEmpty(this.systemMappedList.get(0).getOldPartName()) ? "" : this.systemMappedList.get(0).getOldPartName()));
                this.binding.includeEdit.tvSerialName.setText(String.valueOf(this.systemMappedList.get(0).getOldPartSerialNo()));
                this.binding.includeEdit.tvSectionNo.setText(String.valueOf(TextUtils.isEmpty(this.systemMappedList.get(0).getSectionNo()) ? "" : this.systemMappedList.get(0).getSectionNo()));
                this.binding.includeEdit.tvOldAge.setText(String.valueOf(this.systemMappedList.get(0).getAge()));
                this.binding.includeEdit.tvOldEpic.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldEpicNumber()) ? "" : this.systemMappedList.get(0).getOldEpicNumber());
                if (!TextUtils.isEmpty(this.systemMappedList.get(0).getRelationType())) {
                    setRelativeType(this.systemMappedList.get(0).getRelationType());
                }
                if (!TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullName()) && !TextUtils.isEmpty(this.sharedViewModel.getElectorname())) {
                    this.binding.includeEdit.matchingLayout.setVisibility(0);
                    showResult(NameMatcher.getMatchResult(this.sharedViewModel.getElectorname(), TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullName()) ? "" : this.systemMappedList.get(0).getOldFullName()));
                    this.binding.includeEdit.tvLeftName.setText(this.sharedViewModel.getElectorname());
                    this.binding.includeEdit.tvRightName.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullName()) ? "" : this.systemMappedList.get(0).getOldFullName());
                } else {
                    this.binding.includeEdit.matchingLayout.setVisibility(8);
                }
                if (TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullName()) && !TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullNameL1())) {
                    this.binding.includeEdit.tvElectorName.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullNameL1()) ? "" : this.systemMappedList.get(0).getOldFullNameL1());
                    this.binding.includeEdit.tvElectorNameEdit.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullNameL1()) ? "" : this.systemMappedList.get(0).getOldFullNameL1());
                    this.binding.includeEdit.lvVernacularName.setVisibility(8);
                    this.binding.includeEdit.electorNameEditv1.setVisibility(8);
                } else if (TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullNameL1())) {
                    this.binding.includeEdit.tvElectorName.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullName()) ? "" : this.systemMappedList.get(0).getOldFullName());
                    this.binding.includeEdit.tvElectorNameEdit.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullName()) ? "" : this.systemMappedList.get(0).getOldFullName());
                    this.binding.includeEdit.lvVernacularName.setVisibility(8);
                    this.binding.includeEdit.electorNameEditv1.setVisibility(8);
                } else if (this.systemMappedList.get(0).getOldFullName().equalsIgnoreCase(this.systemMappedList.get(0).getOldFullNameL1())) {
                    this.binding.includeEdit.tvElectorName.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullName()) ? "" : this.systemMappedList.get(0).getOldFullName());
                    this.binding.includeEdit.tvElectorNameEdit.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullName()) ? "" : this.systemMappedList.get(0).getOldFullName());
                    this.binding.includeEdit.lvVernacularName.setVisibility(8);
                    this.binding.includeEdit.electorNameEditv1.setVisibility(8);
                } else {
                    this.binding.includeEdit.tvElectorName.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullName()) ? "" : this.systemMappedList.get(0).getOldFullName());
                    this.binding.includeEdit.tvElectorNameEdit.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullName()) ? "" : this.systemMappedList.get(0).getOldFullName());
                    this.binding.includeEdit.tvElectorNamev1.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullNameL1()) ? "" : this.systemMappedList.get(0).getOldFullNameL1());
                    this.binding.includeEdit.tvElectorNameEditv1.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldFullNameL1()) ? "" : this.systemMappedList.get(0).getOldFullNameL1());
                }
                if (TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullName()) && !TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullNameL1())) {
                    this.binding.includeEdit.tvRelativeName.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullNameL1()) ? "" : this.systemMappedList.get(0).getOldRelativeFullNameL1());
                    this.binding.includeEdit.tvReleativeNameEdit.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullNameL1()) ? "" : this.systemMappedList.get(0).getOldRelativeFullNameL1());
                    this.binding.includeEdit.relativeNameV1.setVisibility(8);
                    this.binding.includeEdit.releativeNameEditv1.setVisibility(8);
                } else if (TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullNameL1())) {
                    this.binding.includeEdit.tvRelativeName.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullName()) ? "" : this.systemMappedList.get(0).getOldRelativeFullName());
                    this.binding.includeEdit.tvReleativeNameEdit.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullName()) ? "" : this.systemMappedList.get(0).getOldRelativeFullName());
                    this.binding.includeEdit.relativeNameV1.setVisibility(8);
                    this.binding.includeEdit.releativeNameEditv1.setVisibility(8);
                } else if (this.systemMappedList.get(0).getOldRelativeFullName().equalsIgnoreCase(this.systemMappedList.get(0).getOldRelativeFullNameL1())) {
                    this.binding.includeEdit.tvRelativeName.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullName()) ? "" : this.systemMappedList.get(0).getOldRelativeFullName());
                    this.binding.includeEdit.tvReleativeNameEdit.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullName()) ? "" : this.systemMappedList.get(0).getOldRelativeFullName());
                    this.binding.includeEdit.relativeNameV1.setVisibility(8);
                    this.binding.includeEdit.releativeNameEditv1.setVisibility(8);
                } else {
                    this.binding.includeEdit.tvRelativeName.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullName()) ? "" : this.systemMappedList.get(0).getOldRelativeFullName());
                    this.binding.includeEdit.tvReleativeNameEdit.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullName()) ? "" : this.systemMappedList.get(0).getOldRelativeFullName());
                    this.binding.includeEdit.tvRelativeNamev1.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullNameL1()) ? "" : this.systemMappedList.get(0).getOldRelativeFullNameL1());
                    this.binding.includeEdit.tvReleativeNameEditv1.setText(TextUtils.isEmpty(this.systemMappedList.get(0).getOldRelativeFullNameL1()) ? "" : this.systemMappedList.get(0).getOldRelativeFullNameL1());
                }
            } else if (this.systemMappedList.size() > 1) {
                this.binding.editableItem.setVisibility(8);
                try {
                    this.binding.tvRecordCount.setVisibility(0);
                    this.binding.tvRecordCount.setText(requireActivity().getResources().getString(R.string.total_record) + StringUtils.SPACE + this.systemMappedList.size());
                    this.systemProgenyListAdapter = new SystemProgenyListAdapter(requireActivity(), this.systemMappedList, new SystemProgenyListAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$$ExternalSyntheticLambda2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.SystemProgenyListAdapter.OnItemSelectedListener
                        public final void onItemSelected() {
                            this.f$0.lambda$onCreateView$0();
                        }
                    });
                    this.binding.selfMapping.setLayoutManager(new LinearLayoutManager(requireActivity()));
                    this.binding.selfMapping.setAdapter(this.systemProgenyListAdapter);
                    this.binding.selfMapping.setVisibility(0);
                } catch (Exception e) {
                    Log.d("recyclerView", e.toString());
                }
            }
        }
        this.binding.spElectorRelative.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                SystemMappedFragment.this.binding.selfMapping.setVisibility(8);
                SystemMappedFragment.this.binding.submitButton.setVisibility(8);
                if (i == 0) {
                    SystemMappedFragment.this.relativeType = null;
                    return;
                }
                if (SystemMappedFragment.this.grandParentList != null && SystemMappedFragment.this.grandParentList.size() > 0) {
                    SystemMappedFragment.this.grandParentList.clear();
                }
                SystemMappedFragment systemMappedFragment = SystemMappedFragment.this;
                systemMappedFragment.relativeType = systemMappedFragment.grandParentCodeList.get(i);
            }
        });
        this.binding.txtRelativeName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SystemMappedFragment.this.binding.selfMapping.setVisibility(8);
                SystemMappedFragment.this.binding.submitButton.setVisibility(8);
                if (SystemMappedFragment.this.grandParentList == null || SystemMappedFragment.this.grandParentList.size() <= 0) {
                    return;
                }
                SystemMappedFragment.this.grandParentList.clear();
            }
        });
        this.binding.btnSearch.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.binding.speakGrandparent.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SystemMappedFragment.this.utils.showVoicePopup(SystemMappedFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.3.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        SystemMappedFragment.this.binding.txtRelativeName.setText(result);
                    }
                });
            }
        });
        this.binding.submitButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        this.binding.includeEdit.submitButtonBlo.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.includeEdit.ivEdit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SystemMappedFragment.this.binding.includeEdit.cardDisabled.setVisibility(8);
                SystemMappedFragment.this.binding.includeEdit.cardEnabled.setVisibility(0);
                SystemMappedFragment.this.binding.includeEdit.electorNameEnable.setText(SystemMappedFragment.this.requireActivity().getResources().getString(R.string.elector_name_2003, SharedPref.getInstance(SystemMappedFragment.this.getContext()).getlastSIRYear()));
                SystemMappedFragment.this.binding.includeEdit.submitButtonBlo.setVisibility(8);
            }
        });
        this.binding.includeEdit.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TextUtils.isEmpty(SystemMappedFragment.this.oldState)) {
                    SystemMappedFragment.this.showDialog1("Alert", "Please select State");
                    return;
                }
                if (TextUtils.isEmpty(SystemMappedFragment.this.oldAc)) {
                    SystemMappedFragment.this.showDialog1("Alert", "Please select Assembly");
                    return;
                }
                if (TextUtils.isEmpty(SystemMappedFragment.this.OldPart)) {
                    SystemMappedFragment.this.showDialog1("Alert", "Please select Part");
                } else {
                    if (TextUtils.isEmpty(SystemMappedFragment.this.binding.includeEdit.oldPslNo.getText().toString().trim())) {
                        SystemMappedFragment.this.showDialog1("Alert", "Please enter part serial number");
                        return;
                    }
                    if (SystemMappedFragment.this.payloads.size() > 0) {
                        SystemMappedFragment.this.payloads.clear();
                    }
                    SystemMappedFragment.this.searchDetails();
                }
            }
        });
        this.binding.includeEdit.speak.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SystemMappedFragment.this.utils.showVoicePopup(SystemMappedFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.9.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        SystemMappedFragment.this.binding.includeEdit.oldPslNo.setText(result);
                    }
                });
            }
        });
        this.binding.includeEdit.oldStateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    SystemMappedFragment.this.isoldStateEntered = false;
                    if (SystemMappedFragment.this.isUserSelected) {
                        SystemMappedFragment.this.oldState = null;
                        SystemMappedFragment.this.oldAc = null;
                        SystemMappedFragment.this.OldPart = null;
                        SystemMappedFragment.this.partList.clear();
                        SystemMappedFragment.this.partNameList.clear();
                        SystemMappedFragment.this.ACNameList.clear();
                        SystemMappedFragment.this.ACList.clear();
                        SystemMappedFragment.this.ACNameList.add(SystemMappedFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                        SystemMappedFragment.this.ACList.add(0);
                        SystemMappedFragment.this.partNameList.add(SystemMappedFragment.this.requireActivity().getResources().getString(R.string.select_part));
                        SystemMappedFragment.this.partList.add(0);
                        SystemMappedFragment.this.binding.includeEdit.oldAcNo.setSelection(0);
                        SystemMappedFragment.this.binding.includeEdit.oldPartNo.setSelection(0);
                        SystemMappedFragment.this.binding.includeEdit.oldPslNo.setText("");
                        SystemMappedFragment.this.isUserSelected = false;
                        return;
                    }
                    return;
                }
                SystemMappedFragment.this.oldAc = null;
                SystemMappedFragment.this.OldPart = null;
                SystemMappedFragment.this.isoldStateEntered = true;
                SystemMappedFragment systemMappedFragment = SystemMappedFragment.this;
                systemMappedFragment.oldState = systemMappedFragment.StateList.get(i);
                SystemMappedFragment systemMappedFragment2 = SystemMappedFragment.this;
                systemMappedFragment2.oldStateName = systemMappedFragment2.StateNameList.get(i);
                if (SystemMappedFragment.this.isUserSelected) {
                    SystemMappedFragment.this.isUserSelected = false;
                    SystemMappedFragment.this.binding.includeEdit.oldPartNo.setSelection(0);
                    SystemMappedFragment.this.binding.includeEdit.oldPslNo.setText("");
                }
                SystemMappedFragment.this.commomUtility.getAllAC(SystemMappedFragment.this.oldState, SystemMappedFragment.this.requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.10.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                    public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                        if (code == 200) {
                            SystemMappedFragment.this.ACNameList.clear();
                            SystemMappedFragment.this.ACList.clear();
                            SystemMappedFragment.this.ACList = acList;
                            SystemMappedFragment.this.ACNameList = acNameList;
                            if (SystemMappedFragment.this.partNameList.size() > 0 && SystemMappedFragment.this.partList.size() > 0) {
                                SystemMappedFragment.this.partList.clear();
                                SystemMappedFragment.this.partNameList.clear();
                            }
                            ArrayAdapter arrayAdapter3 = new ArrayAdapter((Context) SystemMappedFragment.this.requireActivity(), R.layout.blo_spinner_dropdown, (List) SystemMappedFragment.this.ACNameList);
                            arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SystemMappedFragment.this.binding.includeEdit.oldAcNo.setAdapter((SpinnerAdapter) arrayAdapter3);
                            SystemMappedFragment.this.binding.includeEdit.oldAcNo.setSelection(SystemMappedFragment.this.ACList.indexOf(Integer.valueOf(SystemMappedFragment.this.systemMappedList.get(0).oldAcNo)));
                        }
                    }
                });
            }
        });
        this.binding.includeEdit.oldAcNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.11
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    SystemMappedFragment.this.isOldAcNoEntered = false;
                    if (SystemMappedFragment.this.isUserSelected) {
                        SystemMappedFragment.this.oldAc = null;
                        SystemMappedFragment.this.OldPart = null;
                        SystemMappedFragment.this.partList.clear();
                        SystemMappedFragment.this.partNameList.clear();
                        SystemMappedFragment.this.partNameList.add(SystemMappedFragment.this.requireActivity().getResources().getString(R.string.select_part));
                        SystemMappedFragment.this.partList.add(0);
                        SystemMappedFragment.this.binding.includeEdit.oldPartNo.setSelection(0);
                        SystemMappedFragment.this.binding.includeEdit.oldPslNo.setText("");
                        SystemMappedFragment.this.isUserSelected = false;
                        return;
                    }
                    return;
                }
                SystemMappedFragment.this.OldPart = null;
                SystemMappedFragment.this.isOldAcNoEntered = true;
                SystemMappedFragment.this.binding.includeEdit.oldPartNo.setSelection(0);
                SystemMappedFragment systemMappedFragment = SystemMappedFragment.this;
                systemMappedFragment.oldAc = systemMappedFragment.ACList.get(i).toString();
                SystemMappedFragment.this.ACList.get(i).intValue();
                SystemMappedFragment.this.commomUtility.getPartByAc(SystemMappedFragment.this.requireActivity(), Integer.parseInt(SystemMappedFragment.this.oldAc), SystemMappedFragment.this.oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.11.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                    public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                        if (code == 200) {
                            SystemMappedFragment.this.partList.clear();
                            SystemMappedFragment.this.partNameList.clear();
                            SystemMappedFragment.this.partList = acList;
                            SystemMappedFragment.this.partNameList = acNameList;
                            ArrayAdapter arrayAdapter3 = new ArrayAdapter((Context) SystemMappedFragment.this.requireActivity(), R.layout.blo_spinner_dropdown, (List) SystemMappedFragment.this.partNameList);
                            arrayAdapter3.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            SystemMappedFragment.this.binding.includeEdit.oldPartNo.setAdapter((SpinnerAdapter) arrayAdapter3);
                            SystemMappedFragment.this.binding.includeEdit.oldPartNo.setSelection(SystemMappedFragment.this.partList.indexOf(Integer.valueOf(SystemMappedFragment.this.systemMappedList.get(0).oldPartNumber)));
                        }
                    }
                });
                if (SystemMappedFragment.this.isUserSelected) {
                    SystemMappedFragment.this.isUserSelected = false;
                }
            }
        });
        this.binding.includeEdit.oldPartNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.12
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    SystemMappedFragment.this.isOldPartNoEntered = false;
                    if (SystemMappedFragment.this.isUserSelected) {
                        SystemMappedFragment.this.OldPart = null;
                        SystemMappedFragment.this.binding.includeEdit.oldPslNo.setText("");
                        SystemMappedFragment.this.isUserSelected = false;
                        return;
                    }
                    return;
                }
                SystemMappedFragment.this.isOldPartNoEntered = true;
                SystemMappedFragment systemMappedFragment = SystemMappedFragment.this;
                systemMappedFragment.OldPart = systemMappedFragment.partList.get(i).toString();
                if (SystemMappedFragment.this.isUserSelected) {
                    SystemMappedFragment.this.isUserSelected = false;
                }
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0() {
        this.binding.submitButton.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        String string = this.binding.txtRelativeName.getText().toString();
        this.grandParentName = string;
        if (TextUtils.isEmpty(string)) {
            showDialog1("Alert", "Please enter Grand Parent Name");
        } else if (this.binding.spElectorRelative.getSelectedItemPosition() <= 0) {
            showDialog1("Alert", "Please select Grand Parent Type");
        } else {
            searchGrandParentMapping();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        List<MappingList> list = this.selectedItemData;
        if (list != null) {
            list.clear();
        }
        if (this.isSelf) {
            for (MappingList mappingList : this.systemMappedList) {
                if (mappingList.isSelected()) {
                    this.selectedItemData.add(mappingList);
                    String oldStateCd = this.selectedItemData.get(0).getOldStateCd();
                    String strValueOf = String.valueOf(this.selectedItemData.get(0).getOldAcNo());
                    String strValueOf2 = String.valueOf(this.selectedItemData.get(0).getOldPartNumber());
                    String strValueOf3 = String.valueOf(this.selectedItemData.get(0).getOldPartSerialNo());
                    this.commomUtility.validateSirMapping(requireActivity(), this.token, this.state, this.atkband, this.rtkband, oldStateCd, strValueOf, strValueOf2, strValueOf3, this.acNo, this.partNo, this.sharedViewModel.getState(), this.sharedViewModel.getAge(), this.selectedItemData.get(0).getAge(), new AnonymousClass4(oldStateCd, strValueOf, strValueOf2, strValueOf3));
                    return;
                }
            }
            return;
        }
        for (MappingList mappingList2 : this.grandParentList) {
            if (mappingList2.isSelected()) {
                this.selectedItemData.add(mappingList2);
                this.utils.validateProgenyDetails(requireActivity(), this.selectedItemData.get(0).getOldStateCd(), String.valueOf(this.selectedItemData.get(0).getOldAcNo()), String.valueOf(this.selectedItemData.get(0).getOldPartNumber()), String.valueOf(this.selectedItemData.get(0).getOldPartSerialNo()), this.sharedViewModel.getElectorname(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.5
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                    public void onResult(boolean isValidate) {
                        if (isValidate) {
                            SystemMappedFragment.this.sendDataToNext(null, null, "", null);
                        }
                    }
                });
                return;
            }
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$4, reason: invalid class name */
    class AnonymousClass4 implements ValidateMapCallback {
        final /* synthetic */ String val$finalOldAC;
        final /* synthetic */ String val$finalOldPart;
        final /* synthetic */ String val$finalOldSerial;
        final /* synthetic */ String val$finalOldState;

        AnonymousClass4(final String val$finalOldState, final String val$finalOldAC, final String val$finalOldPart, final String val$finalOldSerial) {
            this.val$finalOldState = val$finalOldState;
            this.val$finalOldAC = val$finalOldAC;
            this.val$finalOldPart = val$finalOldPart;
            this.val$finalOldSerial = val$finalOldSerial;
        }

        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback
        public void onCallBack(String statusCode, String message, final String bloNumber, final String bloName) {
            if (statusCode.equalsIgnoreCase("200")) {
                SystemMappedFragment systemMappedFragment = SystemMappedFragment.this;
                systemMappedFragment.showDialog2(systemMappedFragment.requireActivity().getResources().getString(R.string.alertMsg), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.alert_message_relative));
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
                SystemMappedFragment.this.utils.decisionDialog(SystemMappedFragment.this.requireActivity(), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message, SystemMappedFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), "Ok", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.4.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onNegativeButtonClicked() {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onPositiveButtonClicked() {
                        SystemMappedFragment.this.utils.infoDialog(SystemMappedFragment.this.requireActivity(), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping_des), new OkCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.4.1.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.OkCallback
                            public void onPositiveButtonClicked() {
                                SystemMappedFragment.this.commomUtility.checkSelfMappingConflict(SystemMappedFragment.this.requireActivity(), SystemMappedFragment.this.token, SystemMappedFragment.this.state, SharedPref.getInstance(SystemMappedFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(SystemMappedFragment.this.getContext()).getRtknBnd(), AnonymousClass4.this.val$finalOldState, AnonymousClass4.this.val$finalOldAC, AnonymousClass4.this.val$finalOldPart, AnonymousClass4.this.val$finalOldSerial, SystemMappedFragment.this.acNo, SystemMappedFragment.this.partNo, SystemMappedFragment.this.sharedViewModel.getState(), SystemMappedFragment.this.sharedViewModel.getAge(), 0, SystemMappedFragment.this.sharedViewModel.getEpicNumber(), String.valueOf(SystemMappedFragment.this.sharedViewModel.getEpicId()), bloName, bloNumber, strTrim, SystemMappedFragment.this.sharedViewModel.getSerial());
                            }
                        });
                    }
                });
                return;
            }
            if (statusCode.equalsIgnoreCase("0")) {
                SystemMappedFragment.this.utils.infoDialog(SystemMappedFragment.this.requireActivity(), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            } else {
                SystemMappedFragment.this.utils.infoDialog(SystemMappedFragment.this.requireActivity(), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        String oldStateCd;
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        int age;
        if (this.sharedViewModel.getMappingModel().getPayload().getAlgoApplicantCategory().equalsIgnoreCase("self")) {
            if (this.payloads.size() > 0) {
                oldStateCd = this.payloads.get(0).getOldStateCd();
                strValueOf = String.valueOf(this.payloads.get(0).getOldAcNo());
                strValueOf2 = String.valueOf(this.payloads.get(0).getOldPartNumber());
                strValueOf3 = String.valueOf(this.payloads.get(0).getOldPartSerialNo());
                age = this.payloads.get(0).getAge();
            } else {
                oldStateCd = this.systemMappedList.get(0).getOldStateCd();
                strValueOf = String.valueOf(this.systemMappedList.get(0).getOldAcNo());
                strValueOf2 = String.valueOf(this.systemMappedList.get(0).getOldPartNumber());
                strValueOf3 = String.valueOf(this.systemMappedList.get(0).getOldPartSerialNo());
                age = this.systemMappedList.get(0).getAge();
            }
            String str = oldStateCd;
            String str2 = strValueOf;
            String str3 = strValueOf2;
            String str4 = strValueOf3;
            this.commomUtility.validateSirMapping(requireActivity(), this.token, this.state, this.atkband, this.rtkband, str, str2, str3, str4, this.acNo, this.partNo, this.sharedViewModel.getState(), this.sharedViewModel.getAge(), age, new AnonymousClass6(str, str2, str3, str4));
            return;
        }
        nextAction();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$6, reason: invalid class name */
    class AnonymousClass6 implements ValidateMapCallback {
        final /* synthetic */ String val$finalOldAC;
        final /* synthetic */ String val$finalOldPart;
        final /* synthetic */ String val$finalOldSerial;
        final /* synthetic */ String val$finalOldState;

        AnonymousClass6(final String val$finalOldState, final String val$finalOldAC, final String val$finalOldPart, final String val$finalOldSerial) {
            this.val$finalOldState = val$finalOldState;
            this.val$finalOldAC = val$finalOldAC;
            this.val$finalOldPart = val$finalOldPart;
            this.val$finalOldSerial = val$finalOldSerial;
        }

        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback
        public void onCallBack(String statusCode, String message, final String bloNumber, final String bloName) {
            if (statusCode.equalsIgnoreCase("200")) {
                SystemMappedFragment.this.nextAction();
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
                SystemMappedFragment.this.utils.decisionDialog(SystemMappedFragment.this.requireActivity(), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message, SystemMappedFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), "Ok", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.6.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onNegativeButtonClicked() {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onPositiveButtonClicked() {
                        SystemMappedFragment.this.utils.infoDialog(SystemMappedFragment.this.requireActivity(), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping_des), new OkCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.6.1.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.OkCallback
                            public void onPositiveButtonClicked() {
                                SystemMappedFragment.this.commomUtility.checkSelfMappingConflict(SystemMappedFragment.this.requireActivity(), SystemMappedFragment.this.token, SystemMappedFragment.this.state, SharedPref.getInstance(SystemMappedFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(SystemMappedFragment.this.getContext()).getRtknBnd(), AnonymousClass6.this.val$finalOldState, AnonymousClass6.this.val$finalOldAC, AnonymousClass6.this.val$finalOldPart, AnonymousClass6.this.val$finalOldSerial, SystemMappedFragment.this.acNo, SystemMappedFragment.this.partNo, SystemMappedFragment.this.sharedViewModel.getState(), SystemMappedFragment.this.sharedViewModel.getAge(), 0, SystemMappedFragment.this.sharedViewModel.getEpicNumber(), String.valueOf(SystemMappedFragment.this.sharedViewModel.getEpicId()), bloName, bloNumber, strTrim, SystemMappedFragment.this.sharedViewModel.getSerial());
                            }
                        });
                    }
                });
                return;
            }
            if (statusCode.equalsIgnoreCase("0")) {
                SystemMappedFragment.this.utils.infoDialog(SystemMappedFragment.this.requireActivity(), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            } else {
                SystemMappedFragment.this.utils.infoDialog(SystemMappedFragment.this.requireActivity(), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextAction() {
        showDialog2(requireActivity().getResources().getString(R.string.alertMsg), requireActivity().getResources().getString(R.string.alert_message_relative));
    }

    private void searchGrandParentMapping() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("epicNumber", this.sharedViewModel.getEpicNumber());
        map2.put("applicantName", this.sharedViewModel.getElectorname());
        map2.put("relativeName", this.sharedViewModel.getRelativeName());
        map2.put("relationType", this.sharedViewModel.getRelationType());
        map2.put("stateCd", this.sharedViewModel.getState());
        map2.put("age", Integer.valueOf(this.sharedViewModel.getAge()));
        map2.put("gender", this.sharedViewModel.getGender());
        map2.put("grandParentName", this.grandParentName);
        map2.put("grandParentRelationType", this.relativeType);
        Call<MappingRoot> mappingdetails = ((UserClient) ApiClient.getClient2(getContext()).create(UserClient.class)).getMappingdetails(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        mappingdetails.enqueue(new AnonymousClass13());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$13, reason: invalid class name */
    class AnonymousClass13 implements Callback<MappingRoot> {
        AnonymousClass13() {
        }

        public void onResponse(Call<MappingRoot> call, Response<MappingRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    SystemMappedFragment.this.mappingModel = (MappingRoot) response.body();
                    if (SystemMappedFragment.this.mappingModel.getPayload().getAlgoMapping().getMappingList().size() > 0) {
                        SystemMappedFragment systemMappedFragment = SystemMappedFragment.this;
                        systemMappedFragment.grandParentList = systemMappedFragment.mappingModel.getPayload().getAlgoMapping().getMappingList();
                        SystemMappedFragment.this.systemProgenyListAdapter = new SystemProgenyListAdapter(SystemMappedFragment.this.getContext(), SystemMappedFragment.this.grandParentList, new SystemProgenyListAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$13$$ExternalSyntheticLambda0
                            @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.SystemProgenyListAdapter.OnItemSelectedListener
                            public final void onItemSelected() {
                                this.f$0.lambda$onResponse$0();
                            }
                        });
                        SystemMappedFragment.this.binding.selfMapping.setLayoutManager(new LinearLayoutManager(SystemMappedFragment.this.getContext()));
                        SystemMappedFragment.this.binding.selfMapping.setAdapter(SystemMappedFragment.this.systemProgenyListAdapter);
                        SystemMappedFragment.this.binding.selfMapping.setVisibility(0);
                        SystemMappedFragment.this.binding.tvRecordCount.setVisibility(0);
                        SystemMappedFragment.this.binding.tvRecordCount.setText(SystemMappedFragment.this.requireActivity().getResources().getString(R.string.total_record) + StringUtils.SPACE + SystemMappedFragment.this.grandParentList.size());
                    } else {
                        new Utils().infoDialog(SystemMappedFragment.this.requireActivity(), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), SystemMappedFragment.this.requireActivity().getResources().getString(R.string.no_data_found));
                    }
                } catch (Exception unused) {
                }
                SystemMappedFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (SystemMappedFragment.this.alertDialog != null) {
                    SystemMappedFragment.this.alertDialog.dismiss();
                }
                SystemMappedFragment.this.commomUtility.showMessageOK(SystemMappedFragment.this.getActivity(), SystemMappedFragment.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$13$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (SystemMappedFragment.this.alertDialog != null) {
                    SystemMappedFragment.this.alertDialog.dismiss();
                }
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                Toast.makeText((Context) SystemMappedFragment.this.getActivity(), (CharSequence) strOptString, 1).show();
                Logger.e("TAG", strOptString);
                if (SystemMappedFragment.this.alertDialog != null) {
                    SystemMappedFragment.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (SystemMappedFragment.this.alertDialog != null) {
                    SystemMappedFragment.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            SystemMappedFragment.this.binding.submitButton.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SystemMappedFragment.this.getActivity()).setIsLoggedIn(false);
            SharedPref.getInstance(SystemMappedFragment.this.getActivity()).setLocaleBool(false);
            SystemMappedFragment.this.startActivity(new Intent((Context) SystemMappedFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<MappingRoot> call, Throwable t) {
            if (SystemMappedFragment.this.alertDialog != null) {
                SystemMappedFragment.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectorsSystemMapped", t.getMessage());
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void fetchDataFromApi(Context context) {
        Toast.makeText(context, "Tab 2 API called", 0).show();
    }

    private void initializeSpinnerTouch() {
        this.binding.includeEdit.oldStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SystemMappedFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.includeEdit.oldAcNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SystemMappedFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.includeEdit.oldPartNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SystemMappedFragment.this.isUserSelected = true;
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog1(String alertText, String message) {
        if (requireActivity().isFinishing() || requireActivity().isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(requireActivity()).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$4(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$4(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(requireActivity()).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(requireActivity().getResources().getString(R.string.blo_yes), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$6(dialogInterface, i);
            }
        }).setNegativeButton(requireActivity().getResources().getString(R.string.blo_No), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$7(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$6(DialogInterface dialogInterface, int i) {
        CentralDialogFragment centralDialogFragment = new CentralDialogFragment();
        centralDialogFragment.setOnDataReceivedListener(new CentralDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$$ExternalSyntheticLambda7
            @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.OnDataReceivedListener
            public final void onDataReceived(Payload payload, MappingList mappingList, String str) {
                this.f$0.lambda$showDialog2$5(payload, mappingList, str);
            }
        });
        centralDialogFragment.show(getParentFragmentManager(), "CentralDialog");
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$5(Payload payload, MappingList mappingList, String str) {
        Log.d("FragmentA", "Results: " + payload + ", " + mappingList + ", " + str);
        sendDataToNext(payload, mappingList, (payload == null && mappingList == null) ? "N" : "", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$7(DialogInterface dialogInterface, int i) {
        sendDataToNext(null, null, "N", null);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDataToNext(Payload searchModel, MappingList mappingList, String No, String is2003Selected) {
        Intent intent = new Intent((Context) requireActivity(), (Class<?>) EnumrationFormActivity.class);
        intent.putExtra("dob", this.sharedViewModel.getDob());
        if (this.isSelf) {
            intent.putExtra("sirYearSelf", Constants.SIR_YEAR_SELF);
            if (!TextUtils.isEmpty(is2003Selected) && is2003Selected.equalsIgnoreCase("Y")) {
                intent.putExtra("sirYearProgeny", Constants.SIR_YEAR_SELF);
            } else if (!TextUtils.isEmpty(is2003Selected) && is2003Selected.equalsIgnoreCase("N")) {
                intent.putExtra("sirYearProgeny", Constants.SIR_YEAR_PROGENY);
            } else {
                intent.putExtra("sirYearProgeny", "");
            }
        }
        if (this.isProgeny) {
            intent.putExtra("sirYearSelf", "");
            intent.putExtra("sirYearProgeny", Constants.SIR_YEAR_SELF);
        }
        if (searchModel != null) {
            intent.putExtra("father_epicNumber", searchModel.getEpicNumber());
            intent.putExtra("father_oldPartNumber", searchModel.getOldPartNumber());
            intent.putExtra("father_oldPartName", searchModel.getOldPartName());
            intent.putExtra("father_oldPartSerialNo", searchModel.getOldPartSerialNo());
            intent.putExtra("father_oldAcName", searchModel.getOldAcName());
            intent.putExtra("father_oldAcNo", searchModel.getOldAcNo());
            intent.putExtra("father_oldDistName", searchModel.getOldDistName());
            intent.putExtra("father_oldDistNo", searchModel.getOldDistNo());
            intent.putExtra("father_oldStateName", searchModel.getOldStateName());
            intent.putExtra("father_oldStateCd", searchModel.getOldStateCd());
            intent.putExtra("father_relationType", searchModel.getRelationType());
            intent.putExtra("father_oldFullName", searchModel.getOldFullName());
            intent.putExtra("father_oldRelativeFullName", searchModel.getOldRelativeFullName());
            intent.putExtra("father_markedByBlo", searchModel.getMarkedByBlo());
            intent.putExtra("rlnprgnyoldage", searchModel.getAge());
        }
        if (mappingList != null) {
            intent.putExtra("father_epicNumber", mappingList.getOldEpicNumber());
            intent.putExtra("father_oldPartNumber", mappingList.getOldPartNumber());
            intent.putExtra("father_oldPartName", mappingList.getOldPartName());
            intent.putExtra("father_oldPartSerialNo", mappingList.getOldPartSerialNo());
            intent.putExtra("father_oldAcName", mappingList.getOldAcName());
            intent.putExtra("father_oldAcNo", mappingList.getOldAcNo());
            intent.putExtra("father_oldDistName", mappingList.getOldDistName());
            intent.putExtra("father_oldDistNo", mappingList.getOldDistNo());
            intent.putExtra("father_oldStateName", mappingList.getOldStateName());
            intent.putExtra("father_oldStateCd", mappingList.getOldStateCd());
            intent.putExtra("father_relationType", mappingList.getRelationType());
            intent.putExtra("father_oldFullName", mappingList.getOldFullName());
            intent.putExtra("father_oldRelativeFullName", mappingList.getOldRelativeFullName());
            intent.putExtra("rlnprgnyoldage", mappingList.getAge());
        }
        intent.putExtra("list_epicId", this.sharedViewModel.getEpicId());
        intent.putExtra("list_epicNo", this.sharedViewModel.getEpicNumber());
        intent.putExtra("blo_stCode", this.state);
        intent.putExtra("blo_acNo", this.acNo);
        intent.putExtra("blo_partNo", this.partNo);
        intent.putExtra("mappingType", "SystemMapped");
        intent.putExtra("list_partSerialNo", this.sharedViewModel.getSerial());
        intent.putExtra("list_epicName", this.sharedViewModel.getElectorname());
        intent.putExtra("dob", this.sharedViewModel.getDob());
        intent.putExtra("submittedForRecommendation", "Y");
        intent.putExtra(BooleanUtils.NO, No);
        intent.putExtra("from", this.sharedViewModel.getFrom());
        intent.putExtra("list_relationname", this.sharedViewModel.getRelativeName());
        intent.putExtra("list_relation_type", this.sharedViewModel.getRelationType());
        if (!this.payloads.isEmpty() && this.isSelf) {
            intent.putExtra("self_selfOldName", this.payloads.get(0).getOldFullName());
            intent.putExtra("self_selfOldEpic", this.payloads.get(0).getEpicNumber());
            intent.putExtra("self_selfOldRlnName", this.payloads.get(0).getOldRelativeFullName());
            intent.putExtra("self_selfOldRlnType", this.payloads.get(0).getRelationType());
            intent.putExtra("self_categoryType", "Self");
            intent.putExtra("self_OldStateCd", this.payloads.get(0).getOldStateCd());
            intent.putExtra("self_oldStateName", this.payloads.get(0).getOldStateName());
            intent.putExtra("self_oldStateName", this.payloads.get(0).getOldStateName());
            intent.putExtra("self_oldAcName", this.payloads.get(0).getOldAcName());
            intent.putExtra("self_oldAcNo", this.payloads.get(0).getOldAcNo());
            intent.putExtra("self_oldPartNumber", this.payloads.get(0).getOldPartNumber());
            intent.putExtra("self_oldPartName", this.payloads.get(0).getOldPartName());
            intent.putExtra("self_oldPartSerialNo", this.payloads.get(0).getOldPartSerialNo());
            intent.putExtra("selfoldage", this.payloads.get(0).getAge());
        } else if (this.systemMappedList.size() > 0 && this.isSelf) {
            intent.putExtra("self_selfOldName", this.systemMappedList.get(0).getOldFullName());
            intent.putExtra("self_selfOldEpic", this.systemMappedList.get(0).getOldEpicNumber());
            intent.putExtra("self_selfOldRlnName", this.systemMappedList.get(0).getOldRelativeFullName());
            intent.putExtra("self_selfOldRlnType", this.systemMappedList.get(0).getRelationType());
            intent.putExtra("self_categoryType", "self");
            intent.putExtra("self_OldStateCd", this.systemMappedList.get(0).getOldStateCd());
            intent.putExtra("self_oldStateName", this.systemMappedList.get(0).getOldStateName());
            intent.putExtra("self_oldStateName", this.systemMappedList.get(0).getOldStateName());
            intent.putExtra("self_oldAcName", this.systemMappedList.get(0).getOldAcName());
            intent.putExtra("self_oldAcNo", this.systemMappedList.get(0).getOldAcNo());
            intent.putExtra("self_oldPartNumber", this.systemMappedList.get(0).getOldPartNumber());
            intent.putExtra("self_oldPartName", this.systemMappedList.get(0).getOldPartName());
            intent.putExtra("self_oldPartSerialNo", this.systemMappedList.get(0).getOldPartSerialNo());
            intent.putExtra("selfoldage", this.systemMappedList.get(0).getAge());
        }
        if (!this.selectedItemData.isEmpty() && this.isSelf) {
            intent.putExtra("self_selfOldName", this.selectedItemData.get(0).getOldFullName());
            intent.putExtra("self_selfOldEpic", this.selectedItemData.get(0).getOldEpicNumber());
            intent.putExtra("self_selfOldRlnName", this.selectedItemData.get(0).getOldRelativeFullName());
            intent.putExtra("self_selfOldRlnType", this.selectedItemData.get(0).getRelationType());
            intent.putExtra("self_categoryType", "self");
            intent.putExtra("self_OldStateCd", this.selectedItemData.get(0).getOldStateCd());
            intent.putExtra("self_oldStateName", this.selectedItemData.get(0).getOldStateName());
            intent.putExtra("self_oldStateName", this.selectedItemData.get(0).getOldStateName());
            intent.putExtra("self_oldAcName", this.selectedItemData.get(0).getOldAcName());
            intent.putExtra("self_oldAcNo", this.selectedItemData.get(0).getOldAcNo());
            intent.putExtra("self_oldPartNumber", this.selectedItemData.get(0).getOldPartNumber());
            intent.putExtra("self_oldPartName", this.selectedItemData.get(0).getOldPartName());
            intent.putExtra("self_oldPartSerialNo", this.selectedItemData.get(0).getOldPartSerialNo());
            intent.putExtra("selfoldage", this.selectedItemData.get(0).getAge());
        } else if (!this.selectedItemData.isEmpty() && this.isProgeny) {
            intent.putExtra("father_oldFullName", this.selectedItemData.get(0).getOldFullName());
            intent.putExtra("father_epicNumber", this.selectedItemData.get(0).getOldEpicNumber());
            intent.putExtra("father_oldRelativeFullName", this.selectedItemData.get(0).getOldRelativeFullName());
            intent.putExtra("father_relationType", this.selectedItemData.get(0).getRelationType());
            intent.putExtra("self_categoryType", "Progeny");
            intent.putExtra("father_oldStateCd", this.selectedItemData.get(0).getOldStateCd());
            intent.putExtra("father_oldStateName", this.selectedItemData.get(0).getOldStateName());
            intent.putExtra("father_oldAcName", this.selectedItemData.get(0).getOldAcName());
            intent.putExtra("father_oldAcNo", this.selectedItemData.get(0).getOldAcNo());
            intent.putExtra("father_oldPartNumber", this.selectedItemData.get(0).getOldPartNumber());
            intent.putExtra("father_oldPartName", this.selectedItemData.get(0).getOldPartName());
            intent.putExtra("father_oldPartSerialNo", this.selectedItemData.get(0).getOldPartSerialNo());
            intent.putExtra("rlnprgnyoldage", this.selectedItemData.get(0).getAge());
        }
        requireActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchDetails() {
        this.commomUtility.callVerifyRelativeApi(requireActivity(), this.token, this.atkband, this.rtkband, this.oldState, this.oldAc, this.OldPart, this.binding.includeEdit.oldPslNo.getText().toString().trim(), new SearchByAcPartCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment.17
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback
            public void onCallBack(int code, List<Payload> datalist, String message) {
                if (code == 200) {
                    if (datalist != null && datalist.size() > 0) {
                        if (datalist.size() > 1) {
                            SystemMappedFragment.this.showDialog1("Alert", "Multiple record found!!");
                            SystemMappedFragment.this.binding.includeEdit.cardDisabled.setVisibility(0);
                            SystemMappedFragment.this.binding.includeEdit.submitButtonBlo.setVisibility(0);
                            SystemMappedFragment.this.binding.includeEdit.cardEnabled.setVisibility(8);
                            return;
                        }
                        SystemMappedFragment.this.payloads = datalist;
                        Payload payload = datalist.get(0);
                        SystemMappedFragment.this.binding.includeEdit.tvStateName.setText(SystemMappedFragment.this.oldStateName);
                        SystemMappedFragment.this.binding.includeEdit.tvSerialName.setText(SystemMappedFragment.this.binding.includeEdit.oldPslNo.getText().toString().trim());
                        SystemMappedFragment.this.binding.includeEdit.tvSectionNo.setText("");
                        SystemMappedFragment.this.binding.includeEdit.tvAcName.setText(SystemMappedFragment.this.oldAc + "  -  " + (TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName()));
                        SystemMappedFragment.this.binding.includeEdit.tvPartName.setText(SystemMappedFragment.this.OldPart + "  -  " + (TextUtils.isEmpty(payload.getOldPartName()) ? "" : payload.getOldPartName()));
                        SystemMappedFragment.this.binding.includeEdit.tvOldAge.setText(String.valueOf(payload.getAge()));
                        SystemMappedFragment.this.binding.includeEdit.tvDistrictName.setText(String.valueOf(payload.getOldDistNo()) + " - " + (TextUtils.isEmpty(payload.getOldDistName()) ? "" : payload.getOldDistName()));
                        TextUtils.isEmpty(payload.getEpicNumber());
                        SystemMappedFragment.this.binding.includeEdit.tvOldEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                        if (!TextUtils.isEmpty(payload.getRelationType())) {
                            SystemMappedFragment.this.setRelativeType(payload.getRelationType());
                        }
                        SystemMappedFragment.this.binding.includeEdit.cardDisabled.setVisibility(0);
                        SystemMappedFragment.this.binding.includeEdit.cardEnabled.setVisibility(8);
                        SystemMappedFragment.this.binding.includeEdit.submitButtonBlo.setVisibility(0);
                        if (SystemMappedFragment.this.isSelf && !TextUtils.isEmpty(payload.getOldFullName()) && !TextUtils.isEmpty(SystemMappedFragment.this.sharedViewModel.getElectorname())) {
                            SystemMappedFragment.this.binding.includeEdit.matchingLayout.setVisibility(0);
                            SystemMappedFragment.this.showResult(NameMatcher.getMatchResult(SystemMappedFragment.this.sharedViewModel.getElectorname(), TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName()));
                            SystemMappedFragment.this.binding.includeEdit.tvLeftName.setText(SystemMappedFragment.this.sharedViewModel.getElectorname());
                            SystemMappedFragment.this.binding.includeEdit.tvRightName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                        } else {
                            SystemMappedFragment.this.binding.includeEdit.matchingLayout.setVisibility(8);
                        }
                        if (TextUtils.isEmpty(payload.getOldFullName()) && !TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            SystemMappedFragment.this.binding.includeEdit.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                            SystemMappedFragment.this.binding.includeEdit.tvElectorNameEdit.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                            SystemMappedFragment.this.binding.includeEdit.lvVernacularName.setVisibility(8);
                            SystemMappedFragment.this.binding.includeEdit.electorNameEditv1.setVisibility(8);
                        } else if (TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            SystemMappedFragment.this.binding.includeEdit.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            SystemMappedFragment.this.binding.includeEdit.tvElectorNameEdit.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            SystemMappedFragment.this.binding.includeEdit.lvVernacularName.setVisibility(8);
                            SystemMappedFragment.this.binding.includeEdit.electorNameEditv1.setVisibility(8);
                        } else if (payload.getOldFullName().equalsIgnoreCase(payload.getOldFullNameL1())) {
                            SystemMappedFragment.this.binding.includeEdit.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            SystemMappedFragment.this.binding.includeEdit.tvElectorNameEdit.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            SystemMappedFragment.this.binding.includeEdit.lvVernacularName.setVisibility(8);
                            SystemMappedFragment.this.binding.includeEdit.electorNameEditv1.setVisibility(8);
                        } else {
                            SystemMappedFragment.this.binding.includeEdit.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            SystemMappedFragment.this.binding.includeEdit.tvElectorNameEdit.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            SystemMappedFragment.this.binding.includeEdit.tvElectorNamev1.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                            SystemMappedFragment.this.binding.includeEdit.tvElectorNameEditv1.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                        }
                        if (TextUtils.isEmpty(payload.getOldRelativeFullName()) && !TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            SystemMappedFragment.this.binding.includeEdit.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            SystemMappedFragment.this.binding.includeEdit.tvReleativeNameEdit.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            SystemMappedFragment.this.binding.includeEdit.relativeNameV1.setVisibility(8);
                            SystemMappedFragment.this.binding.includeEdit.releativeNameEditv1.setVisibility(8);
                            return;
                        }
                        if (TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            SystemMappedFragment.this.binding.includeEdit.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            SystemMappedFragment.this.binding.includeEdit.tvReleativeNameEdit.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            SystemMappedFragment.this.binding.includeEdit.relativeNameV1.setVisibility(8);
                            SystemMappedFragment.this.binding.includeEdit.releativeNameEditv1.setVisibility(8);
                            return;
                        }
                        if (payload.getOldRelativeFullName().equalsIgnoreCase(payload.getOldRelativeFullNameL1())) {
                            SystemMappedFragment.this.binding.includeEdit.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            SystemMappedFragment.this.binding.includeEdit.tvReleativeNameEdit.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            SystemMappedFragment.this.binding.includeEdit.relativeNameV1.setVisibility(8);
                            SystemMappedFragment.this.binding.includeEdit.releativeNameEditv1.setVisibility(8);
                            return;
                        }
                        SystemMappedFragment.this.binding.includeEdit.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                        SystemMappedFragment.this.binding.includeEdit.tvReleativeNameEdit.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                        SystemMappedFragment.this.binding.includeEdit.tvRelativeNamev1.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                        SystemMappedFragment.this.binding.includeEdit.tvReleativeNameEditv1.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                        return;
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    SystemMappedFragment.this.showDialog1("Alert", message);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                SystemMappedFragment.this.showDialog1("Alert", message);
            }
        });
    }

    private void setPreSelectedData(MappingList selfMappingList) {
        if (this.StateList.size() > 0 && this.StateNameList.size() > 0) {
            this.binding.includeEdit.oldStateSpinner.setSelection(this.StateList.indexOf(selfMappingList.getOldStateCd()));
        }
        setRelativeType(selfMappingList.getRelationType());
        this.binding.includeEdit.oldPslNo.setText(String.valueOf(selfMappingList.getOldPartSerialNo()));
    }

    public void setRelativeType(String relativeType) {
        if (TextUtils.isEmpty(relativeType)) {
            return;
        }
        if (relativeType.equals("GMTH")) {
            this.binding.includeEdit.tvRelativeType.setText("Grand Mother");
            this.binding.includeEdit.tvReleativeTypeEdit.setText("Grand Mother");
            return;
        }
        if (relativeType.equals("GFTH")) {
            this.binding.includeEdit.tvRelativeType.setText("Grand Father");
            this.binding.includeEdit.tvReleativeTypeEdit.setText("Grand Father");
            return;
        }
        if (relativeType.equals("MTHR") || relativeType.equalsIgnoreCase("Mother") || relativeType.equalsIgnoreCase("M")) {
            this.binding.includeEdit.tvRelativeType.setText("Mother");
            this.binding.includeEdit.tvReleativeTypeEdit.setText("Mother");
            return;
        }
        if (relativeType.equals("FTHR") || relativeType.equals("F") || relativeType.equalsIgnoreCase("Father")) {
            this.binding.includeEdit.tvRelativeType.setText("Father");
            this.binding.includeEdit.tvReleativeTypeEdit.setText("Father");
            return;
        }
        if (relativeType.equals("HSBN") || relativeType.equals("H") || relativeType.equalsIgnoreCase("Husband")) {
            this.binding.includeEdit.tvRelativeType.setText("Husband");
            this.binding.includeEdit.tvReleativeTypeEdit.setText("Husband");
            return;
        }
        if (relativeType.equals("OTHR") || relativeType.equalsIgnoreCase("O") || relativeType.equalsIgnoreCase("Other")) {
            this.binding.includeEdit.tvRelativeType.setText("Other");
            this.binding.includeEdit.tvReleativeTypeEdit.setText("Other");
        } else if (TextUtils.isEmpty(relativeType)) {
            this.binding.includeEdit.tvRelativeType.setText("");
            this.binding.includeEdit.tvReleativeTypeEdit.setText("");
        } else {
            this.binding.includeEdit.tvRelativeType.setText(relativeType);
            this.binding.includeEdit.tvReleativeTypeEdit.setText(relativeType);
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.SystemMappedFragment$18, reason: invalid class name */
    static /* synthetic */ class AnonymousClass18 {
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
        int i = AnonymousClass18.$SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[result.type.ordinal()];
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
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.binding.includeEdit.progressBar, "progress", this.binding.includeEdit.progressBar.getProgress(), result.score);
        objectAnimatorOfInt.setDuration(800L);
        objectAnimatorOfInt.start();
        this.binding.includeEdit.progressBar.setProgressTintList(ColorStateList.valueOf(color));
        this.binding.includeEdit.progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(color));
    }
}
