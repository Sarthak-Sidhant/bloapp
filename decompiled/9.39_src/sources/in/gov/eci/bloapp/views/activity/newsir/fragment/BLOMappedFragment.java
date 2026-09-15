package in.gov.eci.bloapp.views.activity.newsir.fragment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.LazyLoadable;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.FragmentTabOneBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.NameMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.SharedViewModel;
import in.gov.eci.bloapp.views.activity.newsir.activity.EnumrationFormActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.ProgenyListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingList;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingModel;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.Payload;
import in.gov.eci.bloapp.views.activity.newsir.model.SelfMappingList;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class BLOMappedFragment extends Fragment implements LazyLoadable {
    private String acNo;
    AlertDialog alertDialog;
    private String atkband;
    private FragmentTabOneBinding binding;
    List<MappingModel> bloMappedList;
    String id;
    boolean isOldAcNoEntered;
    boolean isOldPartNoEntered;
    boolean isOldPartSerialNoEntered;
    boolean isRelativedialogShouldShow;
    boolean isoldStateEntered;
    String lastSIRYear;
    MappingRoot mappingModel;
    private String partNo;
    ProgenyListAdapter progenyListAdapter;
    private String refreshToken;
    private String rtkband;
    SharedViewModel sharedViewModel;
    private String state;
    private String token;
    UserClient userClient;
    Utils utils;
    boolean isUserSelected = false;
    List<Integer> ACList = new ArrayList();
    List<String> ACNameList = new ArrayList();
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    List<String> partNameList = new ArrayList();
    List<Integer> partList = new ArrayList();
    String oldAc = null;
    String OldPart = null;
    String oldState = null;
    String oldStateName = null;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    Gson gson = new GsonBuilder().setLenient().create();
    List<Payload> payloads = new ArrayList();
    String mappingtype = "";

    @Override // in.gov.eci.bloapp.LazyLoadable
    public void onVisible(Context context) {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentTabOneBinding.inflate(getLayoutInflater());
        getSessionValue();
        init();
        initializeSpinnerTouch();
        initalizeAlert();
        setStateAdapter();
        handleClicks();
        setValues();
        handleSpinnerItemSelction();
        return this.binding.getRoot();
    }

    private void handleSpinnerItemSelction() {
        this.binding.oldStateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    BLOMappedFragment.this.isoldStateEntered = false;
                    if (BLOMappedFragment.this.isUserSelected) {
                        BLOMappedFragment.this.oldState = null;
                        BLOMappedFragment.this.oldAc = null;
                        BLOMappedFragment.this.OldPart = null;
                        BLOMappedFragment.this.partList.clear();
                        BLOMappedFragment.this.partNameList.clear();
                        BLOMappedFragment.this.ACNameList.clear();
                        BLOMappedFragment.this.ACList.clear();
                        BLOMappedFragment.this.ACNameList.add(BLOMappedFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                        BLOMappedFragment.this.ACList.add(0);
                        BLOMappedFragment.this.partNameList.add(BLOMappedFragment.this.requireActivity().getResources().getString(R.string.select_part));
                        BLOMappedFragment.this.partList.add(0);
                        BLOMappedFragment.this.binding.oldAcNo.setSelection(0);
                        BLOMappedFragment.this.binding.oldPartNo.setSelection(0);
                        BLOMappedFragment.this.binding.oldPslNo.setText("");
                        BLOMappedFragment.this.isUserSelected = false;
                        return;
                    }
                    return;
                }
                BLOMappedFragment.this.oldAc = null;
                BLOMappedFragment.this.OldPart = null;
                BLOMappedFragment.this.isoldStateEntered = true;
                BLOMappedFragment bLOMappedFragment = BLOMappedFragment.this;
                bLOMappedFragment.oldState = bLOMappedFragment.StateList.get(i);
                BLOMappedFragment bLOMappedFragment2 = BLOMappedFragment.this;
                bLOMappedFragment2.oldStateName = bLOMappedFragment2.StateNameList.get(i);
                if (BLOMappedFragment.this.isUserSelected) {
                    BLOMappedFragment.this.isUserSelected = false;
                    BLOMappedFragment.this.binding.oldPartNo.setSelection(0);
                    BLOMappedFragment.this.binding.oldPslNo.setText("");
                }
                BLOMappedFragment.this.commomUtility.getAllAC(BLOMappedFragment.this.oldState, BLOMappedFragment.this.requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.1.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                    public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                        if (code == 200) {
                            BLOMappedFragment.this.ACNameList.clear();
                            BLOMappedFragment.this.ACList.clear();
                            BLOMappedFragment.this.ACList = acList;
                            BLOMappedFragment.this.ACNameList = acNameList;
                            if (BLOMappedFragment.this.partNameList.size() > 0 && BLOMappedFragment.this.partList.size() > 0) {
                                BLOMappedFragment.this.partList.clear();
                                BLOMappedFragment.this.partNameList.clear();
                            }
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) BLOMappedFragment.this.requireActivity(), R.layout.blo_spinner_dropdown, (List) BLOMappedFragment.this.ACNameList);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            BLOMappedFragment.this.binding.oldAcNo.setAdapter((SpinnerAdapter) arrayAdapter);
                            if (BLOMappedFragment.this.isBLOMappingDataAvailable()) {
                                if (BLOMappedFragment.this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0).getOldAcNo() != 0) {
                                    BLOMappedFragment.this.binding.oldAcNo.setSelection(BLOMappedFragment.this.ACList.indexOf(Integer.valueOf(BLOMappedFragment.this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0).getOldAcNo())));
                                }
                            } else if (BLOMappedFragment.this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().get(0).getOldAcNo() != 0) {
                                BLOMappedFragment.this.binding.oldAcNo.setSelection(BLOMappedFragment.this.ACList.indexOf(Integer.valueOf(BLOMappedFragment.this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().get(0).getOldAcNo())));
                            }
                        }
                    }
                });
            }
        });
        this.binding.oldAcNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    BLOMappedFragment.this.isOldAcNoEntered = false;
                    if (BLOMappedFragment.this.isUserSelected) {
                        BLOMappedFragment.this.oldAc = null;
                        BLOMappedFragment.this.OldPart = null;
                        BLOMappedFragment.this.partList.clear();
                        BLOMappedFragment.this.partNameList.clear();
                        BLOMappedFragment.this.partNameList.add(BLOMappedFragment.this.requireActivity().getResources().getString(R.string.select_part));
                        BLOMappedFragment.this.partList.add(0);
                        BLOMappedFragment.this.binding.oldPartNo.setSelection(0);
                        BLOMappedFragment.this.binding.oldPslNo.setText("");
                        BLOMappedFragment.this.isUserSelected = false;
                        return;
                    }
                    return;
                }
                BLOMappedFragment.this.OldPart = null;
                BLOMappedFragment.this.isOldAcNoEntered = true;
                BLOMappedFragment.this.binding.oldPartNo.setSelection(0);
                BLOMappedFragment bLOMappedFragment = BLOMappedFragment.this;
                bLOMappedFragment.oldAc = bLOMappedFragment.ACList.get(i).toString();
                BLOMappedFragment.this.ACList.get(i).intValue();
                BLOMappedFragment.this.commomUtility.getPartByAc(BLOMappedFragment.this.requireActivity(), Integer.parseInt(BLOMappedFragment.this.oldAc), BLOMappedFragment.this.oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.2.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                    public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                        if (code == 200) {
                            BLOMappedFragment.this.partList.clear();
                            BLOMappedFragment.this.partNameList.clear();
                            BLOMappedFragment.this.partList = acList;
                            BLOMappedFragment.this.partNameList = acNameList;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) BLOMappedFragment.this.requireActivity(), R.layout.blo_spinner_dropdown, (List) BLOMappedFragment.this.partNameList);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            BLOMappedFragment.this.binding.oldPartNo.setAdapter((SpinnerAdapter) arrayAdapter);
                            if (BLOMappedFragment.this.isBLOMappingDataAvailable()) {
                                if (BLOMappedFragment.this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0).getOldPartNumber() != 0) {
                                    BLOMappedFragment.this.binding.oldPartNo.setSelection(BLOMappedFragment.this.partList.indexOf(Integer.valueOf(BLOMappedFragment.this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0).getOldPartNumber())));
                                }
                            } else if (BLOMappedFragment.this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().get(0).getOldPartNumber() != 0) {
                                BLOMappedFragment.this.binding.oldPartNo.setSelection(BLOMappedFragment.this.partList.indexOf(Integer.valueOf(BLOMappedFragment.this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().get(0).getOldPartNumber())));
                            }
                        }
                    }
                });
                if (BLOMappedFragment.this.isUserSelected) {
                    BLOMappedFragment.this.isUserSelected = false;
                }
            }
        });
        this.binding.oldPartNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    BLOMappedFragment.this.isOldPartNoEntered = false;
                    if (BLOMappedFragment.this.isUserSelected) {
                        BLOMappedFragment.this.OldPart = null;
                        BLOMappedFragment.this.binding.oldPslNo.setText("");
                        BLOMappedFragment.this.isUserSelected = false;
                        return;
                    }
                    return;
                }
                BLOMappedFragment.this.isOldPartNoEntered = true;
                BLOMappedFragment bLOMappedFragment = BLOMappedFragment.this;
                bLOMappedFragment.OldPart = bLOMappedFragment.partList.get(i).toString();
                if (BLOMappedFragment.this.isUserSelected) {
                    BLOMappedFragment.this.isUserSelected = false;
                }
            }
        });
    }

    private void handleClicks() {
        this.binding.submitButtonBlo.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleClicks$0(view);
            }
        });
        this.binding.ivEdit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BLOMappedFragment.this.binding.cardDisabled.setVisibility(8);
                BLOMappedFragment.this.binding.cardEnabled.setVisibility(0);
                BLOMappedFragment.this.binding.submitButtonBlo.setVisibility(8);
            }
        });
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BLOMappedFragment.this.utils.validateState_Ac_Part_Serial(BLOMappedFragment.this.requireActivity(), BLOMappedFragment.this.oldState, BLOMappedFragment.this.oldAc, BLOMappedFragment.this.OldPart, BLOMappedFragment.this.binding.oldPslNo.getText().toString().trim(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.6.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                    public void onResult(boolean isValidate) {
                        if (BLOMappedFragment.this.payloads.size() > 0) {
                            BLOMappedFragment.this.payloads.clear();
                        }
                        BLOMappedFragment.this.searchDetails();
                    }
                });
            }
        });
        this.binding.speak.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BLOMappedFragment.this.utils.showVoicePopup(BLOMappedFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.7.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        BLOMappedFragment.this.binding.oldPslNo.setText(result);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClicks$0(View view) {
        String oldStateCd;
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        int age;
        if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().size() > 0) {
            if (this.payloads.size() > 0) {
                oldStateCd = this.payloads.get(0).getOldStateCd();
                strValueOf = String.valueOf(this.payloads.get(0).getOldAcNo());
                strValueOf2 = String.valueOf(this.payloads.get(0).getOldPartNumber());
                strValueOf3 = String.valueOf(this.payloads.get(0).getOldPartSerialNo());
                age = this.payloads.get(0).getAge();
            } else {
                oldStateCd = this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0).getOldStateCd();
                strValueOf = String.valueOf(this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0).getOldAcNo());
                strValueOf2 = String.valueOf(this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0).getOldPartNumber());
                strValueOf3 = String.valueOf(this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0).getOldPartSerialNo());
                age = this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0).getAge();
            }
            CommomUtility commomUtility = this.commomUtility;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            String str = this.token;
            String str2 = this.state;
            String str3 = this.atkband;
            String str4 = this.rtkband;
            commomUtility.validateSirMapping(fragmentActivityRequireActivity, str, str2, str3, str4, oldStateCd, strValueOf, strValueOf2, strValueOf3, this.acNo, this.partNo, this.sharedViewModel.getState(), this.sharedViewModel.getAge(), age, new ValidateMapCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.4
                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback
                public void onCallBack(String statusCode, String message, String bloNumber, String bloName) {
                    if (statusCode.equalsIgnoreCase("200")) {
                        BLOMappedFragment.this.nextAction();
                        return;
                    }
                    if (statusCode.equalsIgnoreCase("409")) {
                        if (!TextUtils.isEmpty(bloNumber)) {
                            bloNumber.equalsIgnoreCase("null");
                        }
                        if (!TextUtils.isEmpty(bloName)) {
                            bloName.equalsIgnoreCase("null");
                        }
                        BLOMappedFragment.this.utils.infoDialog(BLOMappedFragment.this.requireActivity(), BLOMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                        return;
                    }
                    if (statusCode.equalsIgnoreCase("0")) {
                        BLOMappedFragment.this.utils.infoDialog(BLOMappedFragment.this.requireActivity(), BLOMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    } else {
                        BLOMappedFragment.this.utils.infoDialog(BLOMappedFragment.this.requireActivity(), BLOMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    }
                }
            });
            return;
        }
        nextAction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextAction() {
        if (!this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty() && this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size() > 0) {
            displayAddProgenyDialog();
            return;
        }
        if (!this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty() && this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().isEmpty()) {
            askforrelativeDetails(requireActivity().getResources().getString(R.string.option_both));
            return;
        }
        if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty() && this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size() == 1) {
            SelfMappingList selfMappingList = this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().get(0);
            this.utils.validateProgenyDetails(requireActivity(), selfMappingList.getOldStateCd(), String.valueOf(selfMappingList.getOldAcNo()), String.valueOf(selfMappingList.getOldPartNumber()), String.valueOf(selfMappingList.getOldPartSerialNo()), this.sharedViewModel.getElectorname(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.8
                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                public void onResult(boolean isValidate) {
                    if (isValidate) {
                        BLOMappedFragment.this.sendDataToNextwithProgneyList(null, null, false);
                    }
                }
            });
            return;
        }
        if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty() && this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size() > 0) {
            for (SelfMappingList selfMappingList2 : this.mappingModel.getPayload().getBloMapping().getProgenyMappingList()) {
                if (selfMappingList2.isSelected()) {
                    this.utils.validateProgenyDetails(requireActivity(), selfMappingList2.getOldStateCd(), String.valueOf(selfMappingList2.getOldAcNo()), String.valueOf(selfMappingList2.getOldPartNumber()), String.valueOf(selfMappingList2.getOldPartSerialNo()), this.sharedViewModel.getElectorname(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.9
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                        public void onResult(boolean isValidate) {
                            if (isValidate) {
                                BLOMappedFragment.this.sendDataToNextwithProgneyList(null, null, false);
                            }
                        }
                    });
                    return;
                }
            }
            return;
        }
        sendDataToNextwithProgneyList(null, null, false);
    }

    private void displayAddProgenyDialog() {
        ProgenyListDialogFragment progenyListDialogFragment = new ProgenyListDialogFragment();
        progenyListDialogFragment.setOnDataReceivedListener(new ProgenyListDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment$$ExternalSyntheticLambda2
            @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.ProgenyListDialogFragment.OnDataReceivedListener
            public final void onDataReceived(SelfMappingList selfMappingList, String str, String str2) {
                this.f$0.lambda$displayAddProgenyDialog$1(selfMappingList, str, str2);
            }
        });
        progenyListDialogFragment.show(getParentFragmentManager(), "CentralDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$displayAddProgenyDialog$1(SelfMappingList selfMappingList, String str, String str2) {
        sendDataToNextwithProgneyList(selfMappingList, selfMappingList != null ? "" : "N", true);
    }

    private void askforrelativeDetails(String whichOption) {
        this.utils.decisionDialog(requireActivity(), requireActivity().getResources().getString(R.string.alertMsg), requireActivity().getResources().getString(R.string.alert_message_relative), requireActivity().getResources().getString(R.string.blo_yes), requireActivity().getResources().getString(R.string.blo_No), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.10
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
            public void onPositiveButtonClicked() {
                BLOMappedFragment.this.callRelativeDialog();
            }

            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
            public void onNegativeButtonClicked() {
                BLOMappedFragment.this.sendDataToNext(null, null, "N", null);
            }
        });
    }

    private void setStateAdapter() {
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), R.layout.blo_spinner_dropdown, (List) this.StateNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldStateSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    private void initalizeAlert() {
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
    }

    private void setValues() {
        this.binding.includeCurrentDetails.electorNamePendingSir.setText(this.sharedViewModel.getElectorname());
        this.binding.includeCurrentDetails.serialNoPendingSir.setText(this.sharedViewModel.getSerial());
        this.binding.includeCurrentDetails.epicPendingSir.setText(this.sharedViewModel.getEpicNumber());
        this.binding.includeCurrentDetails.agePendingSir.setText(String.valueOf(this.sharedViewModel.getAge()));
        this.binding.includeCurrentDetails.relativeNamePendingSir.setText(this.sharedViewModel.getRelativeName());
        this.binding.includeCurrentDetails.relativeTypePendingSir.setText(this.sharedViewModel.getRelationType());
        if (!this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty()) {
            this.mappingtype = "Self";
            this.isRelativedialogShouldShow = true;
            this.binding.detailName.setVisibility(0);
            this.binding.tvDetails.setText("Self Details");
            this.binding.cardDisabled.setVisibility(0);
            setBloSelfData(this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0));
            setPreSelectedData(this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0));
            return;
        }
        if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty() && this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size() == 1) {
            this.mappingtype = "Progeny";
            this.binding.detailName.setVisibility(0);
            this.binding.tvDetails.setText("Progeny Details");
            this.isRelativedialogShouldShow = false;
            this.binding.cardDisabled.setVisibility(0);
            setBloSelfData(this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().get(0));
            setPreSelectedData(this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().get(0));
            return;
        }
        if (!this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty() || this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size() <= 1) {
            return;
        }
        this.binding.detailName.setVisibility(0);
        this.binding.tvDetails.setText("Progeny Details");
        this.mappingtype = "Progeny";
        this.isRelativedialogShouldShow = false;
        this.binding.cardDisabled.setVisibility(8);
        this.binding.submitButtonBlo.setVisibility(8);
        this.binding.rvMapping.setVisibility(0);
        this.binding.tvRecordCount.setVisibility(0);
        this.binding.tvRecordCount.setText(requireActivity().getResources().getString(R.string.total_record) + " " + this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size());
        this.progenyListAdapter = new ProgenyListAdapter(getContext(), this.mappingModel.getPayload().getBloMapping().getProgenyMappingList(), new ProgenyListAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment$$ExternalSyntheticLambda3
            @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.ProgenyListAdapter.OnItemSelectedListener
            public final void onItemSelected() {
                this.f$0.lambda$setValues$2();
            }
        });
        this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(getContext()));
        this.binding.rvMapping.setAdapter(this.progenyListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setValues$2() {
        this.binding.submitButtonBlo.setVisibility(0);
    }

    private void setPreSelectedData(SelfMappingList selfMappingList) {
        if (this.StateList.size() > 0 && this.StateNameList.size() > 0) {
            this.binding.oldStateSpinner.setSelection(this.StateList.indexOf(selfMappingList.getOldStateCd()));
        }
        setRelativeType(selfMappingList.getRelationType());
        this.binding.oldPslNo.setText(String.valueOf(selfMappingList.getOldPartSerialNo()));
    }

    private void setBloSelfData(SelfMappingList selfMappingList) {
        setDetails(selfMappingList.getOldStateName(), selfMappingList.getOldFullName(), selfMappingList.getOldAcNo(), selfMappingList.getOldPartNumber(), selfMappingList.getOldPartSerialNo(), selfMappingList.getOldRelativeFullName(), selfMappingList.getRelationType(), selfMappingList.getOldAcName(), selfMappingList.getOldPartName(), selfMappingList.getOldDistNo(), selfMappingList.getOldDistName(), selfMappingList.getAge(), selfMappingList.getOldEpicNumber(), selfMappingList.getSectionNo(), selfMappingList.getOldFullNameL1(), selfMappingList.getOldRelativeFullNameL1());
    }

    private void setDetails(String oldStateName, String oldFullName, int oldAcNo, int oldPartNumber, int oldPartSerialNo, String oldRelativeFullName, String relativetype, String oldAcName, String oldPartName, int oldDistNo, String oldDistName, int oldAge, String oldEpic, String sectionNo, String fullnamel1, String relativefullnamel1) {
        this.binding.headerTitle.setText(getContext().getResources().getString(R.string.indian_citizen_by) + "  " + this.lastSIRYear);
        this.binding.headertitleaedit.setText(getContext().getResources().getString(R.string.indian_citizen_by) + "  " + this.lastSIRYear);
        if (this.mappingtype.equalsIgnoreCase("self") && !TextUtils.isEmpty(oldFullName) && !TextUtils.isEmpty(this.sharedViewModel.getElectorname())) {
            this.binding.matchingLayout.setVisibility(0);
            showResult(NameMatcher.getMatchResult(this.sharedViewModel.getElectorname(), TextUtils.isEmpty(oldFullName) ? "" : oldFullName));
            this.binding.tvLeftName.setText(this.sharedViewModel.getElectorname());
            this.binding.tvRightName.setText(TextUtils.isEmpty(oldFullName) ? "" : oldFullName);
        } else {
            this.binding.matchingLayout.setVisibility(8);
        }
        this.binding.tvStateName.setText(oldStateName);
        this.binding.tvDistrictName.setText(String.valueOf(oldDistNo) + " - " + (TextUtils.isEmpty(oldDistName) ? "" : oldDistName));
        this.binding.tvAcName.setText(String.valueOf(oldAcNo) + "  -  " + (TextUtils.isEmpty(oldAcName) ? "" : oldAcName));
        this.binding.tvPartName.setText(String.valueOf(oldPartNumber) + "  -  " + (TextUtils.isEmpty(oldPartName) ? "" : oldPartName));
        this.binding.tvSerialName.setText(String.valueOf(oldPartSerialNo));
        this.binding.tvSectionNo.setText(TextUtils.isEmpty(sectionNo) ? "" : sectionNo);
        if (TextUtils.isEmpty(oldFullName) && !TextUtils.isEmpty(fullnamel1)) {
            this.binding.tvElectorName.setText(TextUtils.isEmpty(fullnamel1) ? "" : fullnamel1);
            this.binding.tvElectorNameEdit.setText(TextUtils.isEmpty(fullnamel1) ? "" : fullnamel1);
            this.binding.lvVernacularName.setVisibility(8);
            this.binding.electorNameEditv1.setVisibility(8);
        } else if (TextUtils.isEmpty(fullnamel1)) {
            this.binding.tvElectorName.setText(TextUtils.isEmpty(oldFullName) ? "" : oldFullName);
            this.binding.tvElectorNameEdit.setText(TextUtils.isEmpty(oldFullName) ? "" : oldFullName);
            this.binding.lvVernacularName.setVisibility(8);
            this.binding.electorNameEditv1.setVisibility(8);
        } else {
            String str = oldFullName;
            String str2 = fullnamel1;
            if (oldFullName.equalsIgnoreCase(str2)) {
                this.binding.tvElectorName.setText(TextUtils.isEmpty(oldFullName) ? "" : str);
                TextView textView = this.binding.tvElectorNameEdit;
                if (TextUtils.isEmpty(oldFullName)) {
                    str = "";
                }
                textView.setText(str);
                this.binding.lvVernacularName.setVisibility(8);
                this.binding.electorNameEditv1.setVisibility(8);
            } else {
                this.binding.tvElectorName.setText(TextUtils.isEmpty(oldFullName) ? "" : str);
                TextView textView2 = this.binding.tvElectorNameEdit;
                if (TextUtils.isEmpty(oldFullName)) {
                    str = "";
                }
                textView2.setText(str);
                this.binding.tvElectorNamev1.setText(TextUtils.isEmpty(fullnamel1) ? "" : str2);
                TextView textView3 = this.binding.tvElectorNameEditv1;
                if (TextUtils.isEmpty(fullnamel1)) {
                    str2 = "";
                }
                textView3.setText(str2);
            }
        }
        if (TextUtils.isEmpty(oldRelativeFullName) && !TextUtils.isEmpty(relativefullnamel1)) {
            this.binding.tvRelativeName.setText(TextUtils.isEmpty(relativefullnamel1) ? "" : relativefullnamel1);
            this.binding.tvReleativeNameEdit.setText(TextUtils.isEmpty(relativefullnamel1) ? "" : relativefullnamel1);
            this.binding.relativeNameV1.setVisibility(8);
            this.binding.releativeNameEditv1.setVisibility(8);
        } else if (TextUtils.isEmpty(relativefullnamel1)) {
            this.binding.tvRelativeName.setText(TextUtils.isEmpty(oldRelativeFullName) ? "" : oldRelativeFullName);
            this.binding.tvReleativeNameEdit.setText(TextUtils.isEmpty(oldRelativeFullName) ? "" : oldRelativeFullName);
            this.binding.relativeNameV1.setVisibility(8);
            this.binding.releativeNameEditv1.setVisibility(8);
        } else {
            String str3 = oldRelativeFullName;
            String str4 = relativefullnamel1;
            if (oldRelativeFullName.equalsIgnoreCase(str4)) {
                this.binding.tvRelativeName.setText(TextUtils.isEmpty(oldRelativeFullName) ? "" : str3);
                TextView textView4 = this.binding.tvReleativeNameEdit;
                if (TextUtils.isEmpty(oldRelativeFullName)) {
                    str3 = "";
                }
                textView4.setText(str3);
                this.binding.relativeNameV1.setVisibility(8);
                this.binding.releativeNameEditv1.setVisibility(8);
            } else {
                this.binding.tvRelativeName.setText(TextUtils.isEmpty(oldRelativeFullName) ? "" : str3);
                TextView textView5 = this.binding.tvReleativeNameEdit;
                if (TextUtils.isEmpty(oldRelativeFullName)) {
                    str3 = "";
                }
                textView5.setText(str3);
                this.binding.tvRelativeNamev1.setText(TextUtils.isEmpty(relativefullnamel1) ? "" : str4);
                TextView textView6 = this.binding.tvReleativeNameEditv1;
                if (TextUtils.isEmpty(relativefullnamel1)) {
                    str4 = "";
                }
                textView6.setText(str4);
            }
        }
        this.binding.tvOldAge.setText(String.valueOf(oldAge));
        this.binding.tvOldEpic.setText(TextUtils.isEmpty(oldEpic) ? "" : oldEpic);
        setRelativeType(relativetype);
    }

    private void init() {
        SharedViewModel sharedViewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        this.sharedViewModel = sharedViewModel;
        this.mappingModel = sharedViewModel.getMappingModel();
        this.userClient = (UserClient) ApiClient.getClient2(requireActivity()).create(UserClient.class);
        this.lastSIRYear = SharedPref.getInstance(getContext()).getlastSIRYear();
        this.utils = new Utils();
        this.isRelativedialogShouldShow = true;
    }

    private void getSessionValue() {
        this.atkband = SharedPref.getInstance(requireActivity()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(requireActivity()).getRtknBnd();
        this.token = SharedPref.getInstance(requireActivity()).getToken();
        this.state = SharedPref.getInstance(requireActivity()).getStateCode();
        this.acNo = SharedPref.getInstance(requireActivity()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireActivity()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireActivity()).getRefreshToken();
        this.StateList = SharedPref.getInstance(requireActivity()).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateNameList = SharedPref.getInstance(requireActivity()).getAcListName(Constants.STATE_LIST_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchDetails() {
        this.commomUtility.callVerifyRelativeApi(requireActivity(), this.token, this.atkband, this.rtkband, this.oldState, this.oldAc, this.OldPart, this.binding.oldPslNo.getText().toString().trim(), new SearchByAcPartCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.11
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback
            public void onCallBack(int code, List<Payload> datalist, String message) {
                if (code == 200) {
                    if (datalist != null && datalist.size() > 0) {
                        if (datalist.size() > 1) {
                            BLOMappedFragment.this.utils.infoDialog(BLOMappedFragment.this.requireActivity(), BLOMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), BLOMappedFragment.this.requireActivity().getResources().getString(R.string.multiple_record));
                            BLOMappedFragment.this.binding.cardDisabled.setVisibility(0);
                            BLOMappedFragment.this.binding.submitButtonBlo.setVisibility(0);
                            BLOMappedFragment.this.binding.cardEnabled.setVisibility(8);
                            return;
                        }
                        BLOMappedFragment.this.payloads = datalist;
                        Payload payload = datalist.get(0);
                        BLOMappedFragment.this.binding.tvStateName.setText(BLOMappedFragment.this.oldStateName);
                        BLOMappedFragment.this.binding.tvAcName.setText(BLOMappedFragment.this.oldAc + "  -  " + (TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName()));
                        BLOMappedFragment.this.binding.tvPartName.setText(BLOMappedFragment.this.OldPart + "  -  " + (TextUtils.isEmpty(payload.getOldPartName()) ? "" : payload.getOldPartName()));
                        BLOMappedFragment.this.binding.tvSerialName.setText(BLOMappedFragment.this.binding.oldPslNo.getText().toString().trim());
                        BLOMappedFragment.this.binding.tvSectionNo.setText("");
                        BLOMappedFragment.this.binding.tvOldAge.setText(String.valueOf(payload.getAge()));
                        TextUtils.isEmpty(payload.getEpicNumber());
                        BLOMappedFragment.this.binding.tvOldEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                        if (!TextUtils.isEmpty(payload.getRelationType())) {
                            String relationType = payload.getRelationType();
                            if (relationType.equals("GMTH")) {
                                BLOMappedFragment.this.binding.tvRelativeType.setText("Grand Mother");
                                BLOMappedFragment.this.binding.tvReleativeTypeEdit.setText("Grand Mother");
                            } else if (relationType.equals("GFTH")) {
                                BLOMappedFragment.this.binding.tvRelativeType.setText("Grand Father");
                                BLOMappedFragment.this.binding.tvReleativeTypeEdit.setText("Grand Father");
                            } else if (relationType.equalsIgnoreCase("M") || relationType.equalsIgnoreCase("MOTHER") || relationType.equalsIgnoreCase("MTHR")) {
                                BLOMappedFragment.this.binding.tvRelativeType.setText("Mother");
                                BLOMappedFragment.this.binding.tvReleativeTypeEdit.setText("Mother");
                            } else if (relationType.equalsIgnoreCase("F") || relationType.equalsIgnoreCase("FATHER") || relationType.equalsIgnoreCase("FTHR")) {
                                BLOMappedFragment.this.binding.tvRelativeType.setText("Father");
                                BLOMappedFragment.this.binding.tvReleativeTypeEdit.setText("Father");
                            } else if (relationType.equalsIgnoreCase("H") || relationType.equalsIgnoreCase("HUSBAND") || relationType.equalsIgnoreCase("HSBN")) {
                                BLOMappedFragment.this.binding.tvRelativeType.setText("Husband");
                                BLOMappedFragment.this.binding.tvReleativeTypeEdit.setText("Husband");
                            } else if (relationType.equalsIgnoreCase("W") || relationType.equalsIgnoreCase("WIFE")) {
                                BLOMappedFragment.this.binding.tvRelativeType.setText("Wife");
                            } else if (relationType.equalsIgnoreCase("L") || relationType.equalsIgnoreCase("OTHER") || relationType.equalsIgnoreCase("O")) {
                                BLOMappedFragment.this.binding.tvRelativeType.setText("Other");
                                BLOMappedFragment.this.binding.tvReleativeTypeEdit.setText("Other");
                            } else if (TextUtils.isEmpty(relationType)) {
                                BLOMappedFragment.this.binding.tvRelativeType.setText("");
                                BLOMappedFragment.this.binding.tvReleativeTypeEdit.setText("");
                            } else {
                                BLOMappedFragment.this.binding.tvRelativeType.setText(relationType);
                                BLOMappedFragment.this.binding.tvReleativeTypeEdit.setText(relationType);
                            }
                        }
                        BLOMappedFragment.this.binding.cardDisabled.setVisibility(0);
                        BLOMappedFragment.this.binding.cardEnabled.setVisibility(8);
                        BLOMappedFragment.this.binding.submitButtonBlo.setVisibility(0);
                        BLOMappedFragment.this.binding.tvDistrictName.setText(String.valueOf(payload.getOldDistNo()) + " - " + (TextUtils.isEmpty(payload.getOldDistName()) ? "" : payload.getOldDistName()));
                        if (BLOMappedFragment.this.mappingtype.equalsIgnoreCase("self") && !TextUtils.isEmpty(payload.getOldFullName()) && !TextUtils.isEmpty(BLOMappedFragment.this.sharedViewModel.getElectorname())) {
                            BLOMappedFragment.this.binding.matchingLayout.setVisibility(0);
                            BLOMappedFragment.this.showResult(NameMatcher.getMatchResult(BLOMappedFragment.this.sharedViewModel.getElectorname(), TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName()));
                            BLOMappedFragment.this.binding.tvLeftName.setText(BLOMappedFragment.this.sharedViewModel.getElectorname());
                            BLOMappedFragment.this.binding.tvRightName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                        } else {
                            BLOMappedFragment.this.binding.matchingLayout.setVisibility(8);
                        }
                        if (TextUtils.isEmpty(payload.getOldFullName()) && !TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            BLOMappedFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                            BLOMappedFragment.this.binding.tvElectorNameEdit.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                            BLOMappedFragment.this.binding.lvVernacularName.setVisibility(8);
                            BLOMappedFragment.this.binding.electorNameEditv1.setVisibility(8);
                        } else if (TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            BLOMappedFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            BLOMappedFragment.this.binding.tvElectorNameEdit.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            BLOMappedFragment.this.binding.lvVernacularName.setVisibility(8);
                            BLOMappedFragment.this.binding.electorNameEditv1.setVisibility(8);
                        } else if (payload.getOldFullName().equalsIgnoreCase(payload.getOldFullNameL1())) {
                            BLOMappedFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            BLOMappedFragment.this.binding.tvElectorNameEdit.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            BLOMappedFragment.this.binding.lvVernacularName.setVisibility(8);
                            BLOMappedFragment.this.binding.electorNameEditv1.setVisibility(8);
                        } else {
                            BLOMappedFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            BLOMappedFragment.this.binding.tvElectorNameEdit.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            BLOMappedFragment.this.binding.tvElectorNamev1.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                            BLOMappedFragment.this.binding.tvElectorNameEditv1.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                        }
                        if (TextUtils.isEmpty(payload.getOldRelativeFullName()) && !TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            BLOMappedFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            BLOMappedFragment.this.binding.tvReleativeNameEdit.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            BLOMappedFragment.this.binding.relativeNameV1.setVisibility(8);
                            BLOMappedFragment.this.binding.releativeNameEditv1.setVisibility(8);
                            return;
                        }
                        if (TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            BLOMappedFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            BLOMappedFragment.this.binding.tvReleativeNameEdit.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            BLOMappedFragment.this.binding.relativeNameV1.setVisibility(8);
                            BLOMappedFragment.this.binding.releativeNameEditv1.setVisibility(8);
                            return;
                        }
                        if (payload.getOldRelativeFullName().equalsIgnoreCase(payload.getOldRelativeFullNameL1())) {
                            BLOMappedFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            BLOMappedFragment.this.binding.tvReleativeNameEdit.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            BLOMappedFragment.this.binding.relativeNameV1.setVisibility(8);
                            BLOMappedFragment.this.binding.releativeNameEditv1.setVisibility(8);
                            return;
                        }
                        BLOMappedFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                        BLOMappedFragment.this.binding.tvReleativeNameEdit.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                        BLOMappedFragment.this.binding.tvRelativeNamev1.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                        BLOMappedFragment.this.binding.tvReleativeNameEditv1.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                        return;
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    BLOMappedFragment.this.utils.infoDialog(BLOMappedFragment.this.requireActivity(), BLOMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                BLOMappedFragment.this.utils.infoDialog(BLOMappedFragment.this.requireActivity(), BLOMappedFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initializeSpinnerTouch() {
        this.binding.oldStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                BLOMappedFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.oldAcNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                BLOMappedFragment.this.isUserSelected = true;
                return false;
            }
        });
        this.binding.oldPartNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                BLOMappedFragment.this.isUserSelected = true;
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDataToNext(Payload searchModel, MappingList mappingList, String isRelativeAdded, String is2003Selected) {
        Intent intent = new Intent((Context) requireActivity(), (Class<?>) EnumrationFormActivity.class);
        if (!this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty()) {
            intent.putExtra("sirYearSelf", Constants.SIR_YEAR_SELF);
            if (!TextUtils.isEmpty(is2003Selected) && is2003Selected.equalsIgnoreCase("Y")) {
                intent.putExtra("sirYearProgeny", Constants.SIR_YEAR_SELF);
            } else if (!TextUtils.isEmpty(is2003Selected) && is2003Selected.equalsIgnoreCase("N")) {
                intent.putExtra("sirYearProgeny", Constants.SIR_YEAR_PROGENY);
            } else {
                intent.putExtra("sirYearProgeny", "");
            }
        } else {
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
        intent.putExtra("mappingType", "BLOMapped");
        intent.putExtra("blo_stCode", this.state);
        intent.putExtra("blo_acNo", this.acNo);
        intent.putExtra("blo_partNo", this.partNo);
        intent.putExtra("list_partSerialNo", this.sharedViewModel.getSerial());
        intent.putExtra("list_epicName", this.sharedViewModel.getElectorname());
        intent.putExtra("submittedForRecommendation", "Y");
        intent.putExtra("self_categoryType", this.mappingtype);
        intent.putExtra("no", isRelativeAdded);
        intent.putExtra("dob", this.sharedViewModel.getDob());
        intent.putExtra("from", this.sharedViewModel.getFrom());
        intent.putExtra("list_relationname", this.sharedViewModel.getRelativeName());
        intent.putExtra("list_relation_type", this.sharedViewModel.getRelationType());
        if (!this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty()) {
            if (this.payloads.size() > 0) {
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
            } else if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().size() > 0) {
                SelfMappingList selfMappingList = this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0);
                intent.putExtra("self_selfOldName", selfMappingList.getOldFullName());
                intent.putExtra("self_selfOldEpic", selfMappingList.getOldEpicNumber());
                intent.putExtra("self_selfOldRlnName", selfMappingList.getOldRelativeFullName());
                intent.putExtra("self_selfOldRlnType", selfMappingList.getRelationType());
                intent.putExtra("self_OldStateCd", selfMappingList.getOldStateCd());
                intent.putExtra("self_oldStateName", selfMappingList.getOldStateName());
                intent.putExtra("self_oldStateName", selfMappingList.getOldStateName());
                intent.putExtra("self_oldAcName", selfMappingList.getOldAcName());
                intent.putExtra("self_oldAcNo", selfMappingList.getOldAcNo());
                intent.putExtra("self_oldPartNumber", selfMappingList.getOldPartNumber());
                intent.putExtra("self_oldPartName", selfMappingList.getOldPartName());
                intent.putExtra("self_oldPartSerialNo", selfMappingList.getOldPartSerialNo());
                intent.putExtra("selfoldage", selfMappingList.getAge());
            }
        } else {
            if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty() && this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size() == 1) {
                if (this.payloads.size() > 0) {
                    intent.putExtra("father_epicNumber", this.payloads.get(0).getEpicNumber());
                    intent.putExtra("father_oldPartNumber", this.payloads.get(0).getOldPartNumber());
                    intent.putExtra("father_oldPartName", this.payloads.get(0).getOldPartName());
                    intent.putExtra("father_oldPartSerialNo", this.payloads.get(0).getOldPartSerialNo());
                    intent.putExtra("father_oldAcName", this.payloads.get(0).getOldAcName());
                    intent.putExtra("father_oldAcNo", this.payloads.get(0).getOldAcNo());
                    intent.putExtra("father_oldDistName", this.payloads.get(0).getOldDistName());
                    intent.putExtra("father_oldDistNo", this.payloads.get(0).getOldDistNo());
                    intent.putExtra("father_oldStateName", this.payloads.get(0).getOldStateName());
                    intent.putExtra("father_oldStateCd", this.payloads.get(0).getOldStateCd());
                    intent.putExtra("father_relationType", this.payloads.get(0).getRelationType());
                    intent.putExtra("father_oldFullName", this.payloads.get(0).getOldFullName());
                    intent.putExtra("father_oldRelativeFullName", this.payloads.get(0).getOldRelativeFullName());
                    intent.putExtra("rlnprgnyoldage", this.payloads.get(0).getAge());
                } else if (this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size() > 0) {
                    SelfMappingList selfMappingList2 = this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().get(0);
                    intent.putExtra("father_epicNumber", selfMappingList2.getOldEpicNumber());
                    intent.putExtra("father_oldPartNumber", selfMappingList2.getOldPartNumber());
                    intent.putExtra("father_oldPartName", selfMappingList2.getOldPartName());
                    intent.putExtra("father_oldPartSerialNo", selfMappingList2.getOldPartSerialNo());
                    intent.putExtra("father_oldAcName", selfMappingList2.getOldAcName());
                    intent.putExtra("father_oldAcNo", selfMappingList2.getOldAcNo());
                    intent.putExtra("father_oldDistName", selfMappingList2.getOldDistName());
                    intent.putExtra("father_oldDistNo", selfMappingList2.getOldDistNo());
                    intent.putExtra("father_oldStateName", selfMappingList2.getOldStateName());
                    intent.putExtra("father_oldStateCd", selfMappingList2.getOldStateCd());
                    intent.putExtra("father_relationType", selfMappingList2.getRelationType());
                    intent.putExtra("father_oldFullName", selfMappingList2.getOldFullName());
                    intent.putExtra("father_oldRelativeFullName", selfMappingList2.getOldRelativeFullName());
                    intent.putExtra("rlnprgnyoldage", selfMappingList2.getAge());
                }
            } else if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty() && this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size() > 1) {
                for (SelfMappingList selfMappingList3 : this.mappingModel.getPayload().getBloMapping().getProgenyMappingList()) {
                    if (selfMappingList3.isSelected()) {
                        intent.putExtra("father_epicNumber", selfMappingList3.getOldEpicNumber());
                        intent.putExtra("father_oldPartNumber", selfMappingList3.getOldPartNumber());
                        intent.putExtra("father_oldPartName", selfMappingList3.getOldPartName());
                        intent.putExtra("father_oldPartSerialNo", selfMappingList3.getOldPartSerialNo());
                        intent.putExtra("father_oldAcName", selfMappingList3.getOldAcName());
                        intent.putExtra("father_oldAcNo", selfMappingList3.getOldAcNo());
                        intent.putExtra("father_oldDistName", selfMappingList3.getOldDistName());
                        intent.putExtra("father_oldDistNo", selfMappingList3.getOldDistNo());
                        intent.putExtra("father_oldStateName", selfMappingList3.getOldStateName());
                        intent.putExtra("father_oldStateCd", selfMappingList3.getOldStateCd());
                        intent.putExtra("father_relationType", selfMappingList3.getRelationType());
                        intent.putExtra("father_oldFullName", selfMappingList3.getOldFullName());
                        intent.putExtra("father_oldRelativeFullName", selfMappingList3.getOldRelativeFullName());
                        intent.putExtra("rlnprgnyoldage", selfMappingList3.getAge());
                        break;
                    }
                }
            }
            requireActivity().startActivity(intent);
        }
        requireActivity().startActivity(intent);
    }

    public void callRelativeDialog() {
        CentralDialogFragment centralDialogFragment = new CentralDialogFragment();
        centralDialogFragment.setOnDataReceivedListener(new CentralDialogFragment.OnDataReceivedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment$$ExternalSyntheticLambda1
            @Override // in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.OnDataReceivedListener
            public final void onDataReceived(Payload payload, MappingList mappingList, String str) {
                this.f$0.lambda$callRelativeDialog$3(payload, mappingList, str);
            }
        });
        centralDialogFragment.show(getParentFragmentManager(), "CentralDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callRelativeDialog$3(Payload payload, MappingList mappingList, String str) {
        sendDataToNext(payload, mappingList, (payload == null && mappingList == null) ? "N" : "", str);
    }

    public void setRelativeType(String relativeType) {
        if (TextUtils.isEmpty(relativeType)) {
            return;
        }
        if (relativeType.equals("GMTH")) {
            this.binding.tvRelativeType.setText("Grand Mother");
            this.binding.tvReleativeTypeEdit.setText("Grand Mother");
            return;
        }
        if (relativeType.equals("GFTH")) {
            this.binding.tvRelativeType.setText("Grand Father");
            this.binding.tvReleativeTypeEdit.setText("Grand Father");
            return;
        }
        if (relativeType.equals("MTHR") || relativeType.equalsIgnoreCase("Mother") || relativeType.equalsIgnoreCase("M")) {
            this.binding.tvRelativeType.setText("Mother");
            this.binding.tvReleativeTypeEdit.setText("Mother");
            return;
        }
        if (relativeType.equals("FTHR") || relativeType.equals("F") || relativeType.equalsIgnoreCase("Father")) {
            this.binding.tvRelativeType.setText("Father");
            this.binding.tvReleativeTypeEdit.setText("Father");
            return;
        }
        if (relativeType.equals("HSBN") || relativeType.equals("H") || relativeType.equalsIgnoreCase("Husband")) {
            this.binding.tvRelativeType.setText("Husband");
            this.binding.tvReleativeTypeEdit.setText("Husband");
            return;
        }
        if (relativeType.equals("OTHR") || relativeType.equalsIgnoreCase("O") || relativeType.equalsIgnoreCase("Other")) {
            this.binding.tvRelativeType.setText("Other");
            this.binding.tvReleativeTypeEdit.setText("Other");
        } else if (TextUtils.isEmpty(relativeType)) {
            this.binding.tvRelativeType.setText("");
            this.binding.tvReleativeTypeEdit.setText("");
        } else {
            this.binding.tvRelativeType.setText(relativeType);
            this.binding.tvReleativeTypeEdit.setText(relativeType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDataToNextwithProgneyList(SelfMappingList searchModel, String isRelativeAdded, Boolean flag) {
        Intent intent = new Intent((Context) requireActivity(), (Class<?>) EnumrationFormActivity.class);
        intent.putExtra("self_categoryType", this.mappingtype);
        intent.putExtra("from", this.sharedViewModel.getFrom());
        intent.putExtra("sirYearProgeny", Constants.SIR_YEAR_SELF);
        if (flag.booleanValue()) {
            intent.putExtra("sirYearSelf", Constants.SIR_YEAR_SELF);
        } else {
            intent.putExtra("sirYearSelf", "");
        }
        if (searchModel != null) {
            intent.putExtra("father_epicNumber", searchModel.getOldEpicNumber());
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
            intent.putExtra("rlnprgnyoldage", searchModel.getAge());
        }
        intent.putExtra("list_epicId", this.sharedViewModel.getEpicId());
        intent.putExtra("list_epicNo", this.sharedViewModel.getEpicNumber());
        intent.putExtra("mappingType", "BLOMapped");
        intent.putExtra("blo_stCode", this.state);
        intent.putExtra("blo_acNo", this.acNo);
        intent.putExtra("blo_partNo", this.partNo);
        intent.putExtra("list_partSerialNo", this.sharedViewModel.getSerial());
        intent.putExtra("list_epicName", this.sharedViewModel.getElectorname());
        intent.putExtra("submittedForRecommendation", "Y");
        intent.putExtra("no", isRelativeAdded);
        intent.putExtra("dob", this.sharedViewModel.getDob());
        if (!this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty()) {
            if (this.payloads.size() > 0) {
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
            } else if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().size() > 0) {
                SelfMappingList selfMappingList = this.mappingModel.getPayload().getBloMapping().getSelfMappingList().get(0);
                intent.putExtra("self_selfOldName", selfMappingList.getOldFullName());
                intent.putExtra("self_selfOldEpic", selfMappingList.getOldEpicNumber());
                intent.putExtra("self_selfOldRlnName", selfMappingList.getOldRelativeFullName());
                intent.putExtra("self_selfOldRlnType", selfMappingList.getRelationType());
                intent.putExtra("self_OldStateCd", selfMappingList.getOldStateCd());
                intent.putExtra("self_oldStateName", selfMappingList.getOldStateName());
                intent.putExtra("self_oldStateName", selfMappingList.getOldStateName());
                intent.putExtra("self_oldAcName", selfMappingList.getOldAcName());
                intent.putExtra("self_oldAcNo", selfMappingList.getOldAcNo());
                intent.putExtra("self_oldPartNumber", selfMappingList.getOldPartNumber());
                intent.putExtra("self_oldPartName", selfMappingList.getOldPartName());
                intent.putExtra("self_oldPartSerialNo", selfMappingList.getOldPartSerialNo());
                intent.putExtra("selfoldage", selfMappingList.getAge());
            }
        } else {
            if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty() && this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size() == 1) {
                if (this.payloads.size() > 0) {
                    intent.putExtra("father_epicNumber", this.payloads.get(0).getEpicNumber());
                    intent.putExtra("father_oldPartNumber", this.payloads.get(0).getOldPartNumber());
                    intent.putExtra("father_oldPartName", this.payloads.get(0).getOldPartName());
                    intent.putExtra("father_oldPartSerialNo", this.payloads.get(0).getOldPartSerialNo());
                    intent.putExtra("father_oldAcName", this.payloads.get(0).getOldAcName());
                    intent.putExtra("father_oldAcNo", this.payloads.get(0).getOldAcNo());
                    intent.putExtra("father_oldDistName", this.payloads.get(0).getOldDistName());
                    intent.putExtra("father_oldDistNo", this.payloads.get(0).getOldDistNo());
                    intent.putExtra("father_oldStateName", this.payloads.get(0).getOldStateName());
                    intent.putExtra("father_oldStateCd", this.payloads.get(0).getOldStateCd());
                    intent.putExtra("father_relationType", this.payloads.get(0).getRelationType());
                    intent.putExtra("father_oldFullName", this.payloads.get(0).getOldFullName());
                    intent.putExtra("father_oldRelativeFullName", this.payloads.get(0).getOldRelativeFullName());
                    intent.putExtra("rlnprgnyoldage", this.payloads.get(0).getAge());
                } else if (this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size() > 0) {
                    SelfMappingList selfMappingList2 = this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().get(0);
                    intent.putExtra("father_epicNumber", selfMappingList2.getOldEpicNumber());
                    intent.putExtra("father_oldPartNumber", selfMappingList2.getOldPartNumber());
                    intent.putExtra("father_oldPartName", selfMappingList2.getOldPartName());
                    intent.putExtra("father_oldPartSerialNo", selfMappingList2.getOldPartSerialNo());
                    intent.putExtra("father_oldAcName", selfMappingList2.getOldAcName());
                    intent.putExtra("father_oldAcNo", selfMappingList2.getOldAcNo());
                    intent.putExtra("father_oldDistName", selfMappingList2.getOldDistName());
                    intent.putExtra("father_oldDistNo", selfMappingList2.getOldDistNo());
                    intent.putExtra("father_oldStateName", selfMappingList2.getOldStateName());
                    intent.putExtra("father_oldStateCd", selfMappingList2.getOldStateCd());
                    intent.putExtra("father_relationType", selfMappingList2.getRelationType());
                    intent.putExtra("father_oldFullName", selfMappingList2.getOldFullName());
                    intent.putExtra("father_oldRelativeFullName", selfMappingList2.getOldRelativeFullName());
                    intent.putExtra("rlnprgnyoldage", selfMappingList2.getAge());
                }
            } else if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty() && this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size() > 1) {
                for (SelfMappingList selfMappingList3 : this.mappingModel.getPayload().getBloMapping().getProgenyMappingList()) {
                    if (selfMappingList3.isSelected()) {
                        intent.putExtra("father_epicNumber", selfMappingList3.getOldEpicNumber());
                        intent.putExtra("father_oldPartNumber", selfMappingList3.getOldPartNumber());
                        intent.putExtra("father_oldPartName", selfMappingList3.getOldPartName());
                        intent.putExtra("father_oldPartSerialNo", selfMappingList3.getOldPartSerialNo());
                        intent.putExtra("father_oldAcName", selfMappingList3.getOldAcName());
                        intent.putExtra("father_oldAcNo", selfMappingList3.getOldAcNo());
                        intent.putExtra("father_oldDistName", selfMappingList3.getOldDistName());
                        intent.putExtra("father_oldDistNo", selfMappingList3.getOldDistNo());
                        intent.putExtra("father_oldStateName", selfMappingList3.getOldStateName());
                        intent.putExtra("father_oldStateCd", selfMappingList3.getOldStateCd());
                        intent.putExtra("father_relationType", selfMappingList3.getRelationType());
                        intent.putExtra("father_oldFullName", selfMappingList3.getOldFullName());
                        intent.putExtra("father_oldRelativeFullName", selfMappingList3.getOldRelativeFullName());
                        intent.putExtra("rlnprgnyoldage", selfMappingList3.getAge());
                        break;
                    }
                }
            }
            requireActivity().startActivity(intent);
        }
        requireActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBLOMappingDataAvailable() {
        if (!this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty()) {
            return true;
        }
        if (this.mappingModel.getPayload().getBloMapping().getSelfMappingList().isEmpty()) {
            this.mappingModel.getPayload().getBloMapping().getProgenyMappingList().size();
        }
        return false;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.BLOMappedFragment$15, reason: invalid class name */
    static /* synthetic */ class AnonymousClass15 {
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
        int i = AnonymousClass15.$SwitchMap$in$gov$eci$bloapp$utils$NameMatcher$MatchType[result.type.ordinal()];
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
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.binding.progressBar, "progress", this.binding.progressBar.getProgress(), result.score);
        objectAnimatorOfInt.setDuration(800L);
        objectAnimatorOfInt.start();
        this.binding.progressBar.setProgressTintList(ColorStateList.valueOf(color));
        this.binding.progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(color));
    }
}
