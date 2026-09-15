package in.gov.eci.bloapp.views.activity.newsir.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import in.gov.eci.bloapp.ArraylistReturn;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.DialogReusableNewBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
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
import in.gov.eci.bloapp.views.activity.newsir.model.Payload;
import in.gov.eci.bloapp.views.activity.newsir.model.PayloadNewMapping;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class UpdateDialogFragment extends DialogFragment {
    private String acNo;
    SearchLocationAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    private DialogReusableNewBinding binding;
    int currentAc;
    int currentAge;
    String currentEpic;
    String currentEpicId;
    String currentName;
    int currentPart;
    String currentRelativeName;
    String currentRelativeType;
    int currentSerialNo;
    String currentStateCode;
    private ArrayAdapter<String> districtadapter;
    boolean isOldAcNoEntered;
    boolean isOldPartNoEntered;
    boolean isOldPartSerialNoEntered;
    boolean isoldStateEntered;
    String key;
    private OnDataReceivedListener listener;
    String mappingtype;
    List<MappingList> newbloMappedList;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    String sirYearProgeny;
    private String state;
    private String token;
    UserClient userClient;
    Utils utils;
    boolean isUserSelected = false;
    List<Integer> ACList = new ArrayList();
    List<String> ACNameList = new ArrayList();
    private ArrayList<String> district = new ArrayList<>();
    private ArrayList<String> districtcode = new ArrayList<>();
    List<Integer> EfACList = new ArrayList();
    List<String> EfACNameList = new ArrayList();
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    List<String> partNameList = new ArrayList();
    List<Integer> partList = new ArrayList();
    String oldAc = null;
    String OldPart = null;
    String oldState = null;
    String oldStateName = null;
    String oldDistrict = null;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "Your session has expired or your account was accessed from another device. Please sign in again to continue.";
    String efState = null;
    String efAc = null;
    String efDistrict = null;
    Gson gson = new GsonBuilder().setLenient().create();
    List<Payload> payloads = new ArrayList();
    String is2003Selected = "";
    List<PayloadNewMapping> erollPayloads = new ArrayList();

    public interface OnDataReceivedListener {
        void onDataReceived(Payload searchModel, MappingList mappingList, String result3, String isSelected2003);
    }

    public void setOnDataReceivedListener(OnDataReceivedListener listener) {
        this.listener = listener;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        return dialogOnCreateDialog;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setGravity(17);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = DialogReusableNewBinding.inflate(getLayoutInflater());
        this.newbloMappedList = new ArrayList();
        if (getArguments() != null) {
            this.key = getArguments().getString("key");
            this.currentName = getArguments().getString("currentName");
            this.currentRelativeType = getArguments().getString("currentRelativeType");
            this.currentRelativeName = getArguments().getString("currentRelativeName");
            this.currentEpic = getArguments().getString("currentEpic");
            this.currentAc = getArguments().getInt("currentAc");
            this.currentPart = getArguments().getInt("currentPart");
            this.currentStateCode = getArguments().getString("currentState");
            this.currentAge = getArguments().getInt("currentAge");
            this.currentSerialNo = getArguments().getInt("currentSerialNo");
            this.sirYearProgeny = getArguments().getString("sirYearProgeny");
            this.mappingtype = getArguments().getString("mappingtype");
            this.currentEpicId = getArguments().getString("currentEpicId");
        }
        getSessionValue();
        init();
        initializeSpinnerTouch();
        setAdapter();
        selecttab(this.binding.searchAcPartPslMB, this.binding.searchLocationMB);
        handleSearchTabClcicks();
        handleButtonClicks();
        handleSearchByACSpinnerSelection();
        handleSearchByFamilySpinnerSelection();
        return this.binding.getRoot();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$1, reason: invalid class name */
    class AnonymousClass1 implements AdapterView.OnItemClickListener {
        AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            UpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
            UpdateDialogFragment.this.binding.tvRecordCount.setVisibility(8);
            UpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select State")) {
                UpdateDialogFragment.this.efState = null;
                UpdateDialogFragment.this.efDistrict = null;
                UpdateDialogFragment.this.efAc = null;
                UpdateDialogFragment.this.OldPart = null;
                UpdateDialogFragment.this.EfACNameList.clear();
                UpdateDialogFragment.this.EfACList.clear();
                UpdateDialogFragment.this.EfACNameList.add(UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                UpdateDialogFragment.this.EfACList.add(0);
                UpdateDialogFragment.this.district.clear();
                UpdateDialogFragment.this.districtcode.clear();
                UpdateDialogFragment.this.district.add("Select District");
                UpdateDialogFragment.this.districtcode.add("0");
                UpdateDialogFragment.this.binding.efDistrictSpinner.setText("");
                UpdateDialogFragment.this.partList.clear();
                UpdateDialogFragment.this.partNameList.clear();
                UpdateDialogFragment.this.partNameList.add(UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                UpdateDialogFragment.this.partList.add(0);
                UpdateDialogFragment.this.binding.efAcSpinner.setText("");
                UpdateDialogFragment.this.binding.efOldPartNo.setText("");
                UpdateDialogFragment.this.binding.oldStateSpinner.setText("");
                return;
            }
            String string = parent.getItemAtPosition(i).toString();
            UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
            updateDialogFragment.efState = updateDialogFragment.StateList.get(UpdateDialogFragment.this.StateNameList.indexOf(string));
            UpdateDialogFragment.this.binding.efAcSpinner.setText("");
            UpdateDialogFragment.this.binding.efOldPartNo.setText("");
            UpdateDialogFragment.this.binding.efDistrictSpinner.setText("");
            UpdateDialogFragment.this.binding.oldStateSpinner.setText("");
            UpdateDialogFragment.this.binding.selfName.setText("");
            UpdateDialogFragment.this.binding.parentName.setText("");
            UpdateDialogFragment.this.binding.grandparentName.setText("");
            UpdateDialogFragment.this.efDistrict = null;
            UpdateDialogFragment.this.efAc = null;
            UpdateDialogFragment.this.OldPart = null;
            UpdateDialogFragment updateDialogFragment2 = UpdateDialogFragment.this;
            updateDialogFragment2.getAllDistrict(updateDialogFragment2.efState);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
            updateDialogFragment.getallEFAc(updateDialogFragment.efState);
        }
    }

    private void handleSearchByFamilySpinnerSelection() {
        this.binding.efStateSpinner.setOnItemClickListener(new AnonymousClass1());
        this.binding.efDistrictSpinner.setOnItemClickListener(new AnonymousClass2());
        this.binding.efAcSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                UpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
                UpdateDialogFragment.this.binding.tvRecordCount.setVisibility(8);
                UpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Assembly Constituency")) {
                    UpdateDialogFragment.this.efAc = null;
                    UpdateDialogFragment.this.OldPart = null;
                    UpdateDialogFragment.this.partNameList.clear();
                    UpdateDialogFragment.this.partList.clear();
                    UpdateDialogFragment.this.partNameList.add(UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    UpdateDialogFragment.this.partList.add(0);
                    UpdateDialogFragment.this.binding.efOldPartNo.setText("");
                    return;
                }
                UpdateDialogFragment.this.OldPart = null;
                String string = parent.getItemAtPosition(i).toString();
                UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                updateDialogFragment.efAc = String.valueOf(updateDialogFragment.EfACList.get(UpdateDialogFragment.this.EfACNameList.indexOf(string)));
                UpdateDialogFragment.this.binding.selfName.setText("");
                UpdateDialogFragment.this.binding.parentName.setText("");
                UpdateDialogFragment.this.binding.grandparentName.setText("");
                UpdateDialogFragment.this.binding.efOldPartNo.setText("");
                UpdateDialogFragment.this.commomUtility.getPartByAc(UpdateDialogFragment.this.requireActivity(), Integer.parseInt(UpdateDialogFragment.this.efAc), UpdateDialogFragment.this.efState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.3.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                    public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                        if (code == 200) {
                            UpdateDialogFragment.this.partList.clear();
                            UpdateDialogFragment.this.partNameList.clear();
                            UpdateDialogFragment.this.partList = acList;
                            UpdateDialogFragment.this.partNameList = acNameList;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) UpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) UpdateDialogFragment.this.partNameList);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            UpdateDialogFragment.this.binding.efOldPartNo.setAdapter(arrayAdapter);
                            UpdateDialogFragment.this.binding.efOldPartNo.setThreshold(1);
                        }
                    }
                });
            }
        });
        this.binding.efOldPartNo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                UpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
                UpdateDialogFragment.this.binding.tvRecordCount.setVisibility(8);
                UpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Part")) {
                    UpdateDialogFragment.this.OldPart = null;
                    return;
                }
                String string = parent.getItemAtPosition(i).toString();
                UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                updateDialogFragment.OldPart = String.valueOf(updateDialogFragment.partList.get(UpdateDialogFragment.this.partNameList.indexOf(string)));
            }
        });
        this.binding.selfName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                UpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
                UpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            }
        });
        this.binding.parentName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                UpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
                UpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$2, reason: invalid class name */
    class AnonymousClass2 implements AdapterView.OnItemClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            UpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
            UpdateDialogFragment.this.binding.tvRecordCount.setVisibility(8);
            UpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select District")) {
                UpdateDialogFragment.this.efDistrict = null;
                UpdateDialogFragment.this.efAc = null;
                UpdateDialogFragment.this.binding.efAcSpinner.setText("");
                UpdateDialogFragment.this.binding.efOldPartNo.setText("");
                if (UpdateDialogFragment.this.EfACList.size() > 0) {
                    UpdateDialogFragment.this.EfACNameList.clear();
                    UpdateDialogFragment.this.EfACList.clear();
                }
                UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                updateDialogFragment.getallEFAc(updateDialogFragment.efState);
                return;
            }
            UpdateDialogFragment.this.efAc = null;
            UpdateDialogFragment.this.OldPart = null;
            if (!TextUtils.isEmpty(UpdateDialogFragment.this.efState) && UpdateDialogFragment.this.efState.equalsIgnoreCase("S02")) {
                UpdateDialogFragment updateDialogFragment2 = UpdateDialogFragment.this;
                updateDialogFragment2.efDistrict = (String) updateDialogFragment2.districtcode.get(i);
            } else {
                String str = (String) UpdateDialogFragment.this.district.get(UpdateDialogFragment.this.district.indexOf(parent.getItemAtPosition(i).toString()));
                int iIndexOf = UpdateDialogFragment.this.district.indexOf(str);
                Log.d("CheckEffff : ", iIndexOf + StringUtils.SPACE + str);
                UpdateDialogFragment updateDialogFragment3 = UpdateDialogFragment.this;
                updateDialogFragment3.efDistrict = (String) updateDialogFragment3.districtcode.get(iIndexOf);
            }
            UpdateDialogFragment.this.binding.efAcSpinner.setText("");
            UpdateDialogFragment.this.binding.efOldPartNo.setText("");
            UpdateDialogFragment.this.binding.selfName.setText("");
            UpdateDialogFragment.this.binding.parentName.setText("");
            UpdateDialogFragment.this.binding.grandparentName.setText("");
            if (UpdateDialogFragment.this.partList.size() > 0 && UpdateDialogFragment.this.partNameList.size() > 0) {
                UpdateDialogFragment.this.partList.clear();
                UpdateDialogFragment.this.partNameList.clear();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            UpdateDialogFragment.this.commomUtility.getAssmblyByDist(UpdateDialogFragment.this.requireActivity(), Integer.parseInt(UpdateDialogFragment.this.efDistrict), UpdateDialogFragment.this.efState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.2.1
                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                    if (code == 200) {
                        UpdateDialogFragment.this.EfACNameList.clear();
                        UpdateDialogFragment.this.EfACList.clear();
                        UpdateDialogFragment.this.EfACList = acList;
                        UpdateDialogFragment.this.EfACNameList = acNameList;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) UpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) UpdateDialogFragment.this.EfACNameList);
                        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        UpdateDialogFragment.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                        UpdateDialogFragment.this.binding.efAcSpinner.setThreshold(1);
                    }
                }
            });
        }
    }

    private void handleSearchByACSpinnerSelection() {
        this.binding.oldStateSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                UpdateDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select State")) {
                    UpdateDialogFragment.this.isoldStateEntered = false;
                    UpdateDialogFragment.this.oldState = null;
                    UpdateDialogFragment.this.oldAc = null;
                    UpdateDialogFragment.this.OldPart = null;
                    UpdateDialogFragment.this.oldDistrict = null;
                    UpdateDialogFragment.this.partList.clear();
                    UpdateDialogFragment.this.partNameList.clear();
                    UpdateDialogFragment.this.ACNameList.clear();
                    UpdateDialogFragment.this.ACList.clear();
                    UpdateDialogFragment.this.ACNameList.add(UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    UpdateDialogFragment.this.ACList.add(0);
                    UpdateDialogFragment.this.partNameList.add(UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    UpdateDialogFragment.this.partList.add(0);
                    UpdateDialogFragment.this.binding.oldAcNo.setText("");
                    UpdateDialogFragment.this.binding.oldPartNo.setText("");
                    UpdateDialogFragment.this.binding.oldDistrictSpinner.setText("");
                    UpdateDialogFragment.this.binding.oldPslNo.setText("");
                    UpdateDialogFragment.this.isUserSelected = false;
                    UpdateDialogFragment.this.district.clear();
                    UpdateDialogFragment.this.districtcode.clear();
                    UpdateDialogFragment.this.district.add("Select District");
                    UpdateDialogFragment.this.districtcode.add("0");
                    UpdateDialogFragment.this.binding.oldDistrictSpinner.setText("");
                    return;
                }
                UpdateDialogFragment.this.oldAc = null;
                UpdateDialogFragment.this.OldPart = null;
                UpdateDialogFragment.this.oldDistrict = null;
                UpdateDialogFragment.this.isoldStateEntered = true;
                UpdateDialogFragment.this.binding.oldAcNo.setText("");
                UpdateDialogFragment.this.binding.oldPartNo.setText("");
                UpdateDialogFragment.this.binding.oldDistrictSpinner.setText("");
                UpdateDialogFragment.this.binding.oldPslNo.setText("");
                String string = parent.getItemAtPosition(i).toString();
                UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                updateDialogFragment.oldState = updateDialogFragment.StateList.get(UpdateDialogFragment.this.StateNameList.indexOf(string));
                UpdateDialogFragment updateDialogFragment2 = UpdateDialogFragment.this;
                updateDialogFragment2.oldStateName = updateDialogFragment2.StateNameList.get(UpdateDialogFragment.this.StateNameList.indexOf(string));
                if (UpdateDialogFragment.this.isUserSelected) {
                    UpdateDialogFragment.this.isUserSelected = false;
                    UpdateDialogFragment.this.binding.oldPartNo.setText("");
                    UpdateDialogFragment.this.binding.oldPslNo.setText("");
                }
                UpdateDialogFragment updateDialogFragment3 = UpdateDialogFragment.this;
                updateDialogFragment3.getAllDistrict(updateDialogFragment3.oldState);
                if (!TextUtils.isEmpty(UpdateDialogFragment.this.is2003Selected) && UpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                    UpdateDialogFragment updateDialogFragment4 = UpdateDialogFragment.this;
                    updateDialogFragment4.getAllOldAc2025(updateDialogFragment4.oldState);
                } else {
                    UpdateDialogFragment updateDialogFragment5 = UpdateDialogFragment.this;
                    updateDialogFragment5.getAllOldAc(updateDialogFragment5.oldState);
                }
            }
        });
        this.binding.oldDistrictSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                int i2;
                UpdateDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select District")) {
                    UpdateDialogFragment.this.oldAc = null;
                    UpdateDialogFragment.this.OldPart = null;
                    UpdateDialogFragment.this.oldDistrict = null;
                    UpdateDialogFragment.this.partList.clear();
                    UpdateDialogFragment.this.partNameList.clear();
                    UpdateDialogFragment.this.ACNameList.clear();
                    UpdateDialogFragment.this.ACList.clear();
                    UpdateDialogFragment.this.ACNameList.add(UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    UpdateDialogFragment.this.ACList.add(0);
                    UpdateDialogFragment.this.partNameList.add(UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    UpdateDialogFragment.this.partList.add(0);
                    UpdateDialogFragment.this.binding.oldAcNo.setText("");
                    UpdateDialogFragment.this.binding.oldPartNo.setText("");
                    UpdateDialogFragment.this.binding.oldPslNo.setText("");
                    if (UpdateDialogFragment.this.ACList.size() > 0) {
                        UpdateDialogFragment.this.ACList.clear();
                        UpdateDialogFragment.this.ACNameList.clear();
                    }
                    if (!TextUtils.isEmpty(UpdateDialogFragment.this.is2003Selected) && UpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                        UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                        updateDialogFragment.getAllOldAc2025(updateDialogFragment.oldState);
                        return;
                    } else {
                        UpdateDialogFragment updateDialogFragment2 = UpdateDialogFragment.this;
                        updateDialogFragment2.getAllOldAc(updateDialogFragment2.oldState);
                        return;
                    }
                }
                UpdateDialogFragment.this.oldAc = null;
                UpdateDialogFragment.this.OldPart = null;
                UpdateDialogFragment.this.binding.oldPslNo.setText("");
                if (!TextUtils.isEmpty(UpdateDialogFragment.this.oldState) && UpdateDialogFragment.this.oldState.equalsIgnoreCase("S02")) {
                    UpdateDialogFragment updateDialogFragment3 = UpdateDialogFragment.this;
                    updateDialogFragment3.oldDistrict = (String) updateDialogFragment3.district.get(i);
                    i2 = Integer.parseInt((String) UpdateDialogFragment.this.districtcode.get(i));
                } else {
                    int iIndexOf = UpdateDialogFragment.this.district.indexOf((String) UpdateDialogFragment.this.district.get(UpdateDialogFragment.this.district.indexOf(parent.getItemAtPosition(i).toString())));
                    UpdateDialogFragment updateDialogFragment4 = UpdateDialogFragment.this;
                    updateDialogFragment4.oldDistrict = (String) updateDialogFragment4.district.get(iIndexOf);
                    i2 = Integer.parseInt((String) UpdateDialogFragment.this.districtcode.get(iIndexOf));
                }
                UpdateDialogFragment.this.binding.oldAcNo.setText("");
                UpdateDialogFragment.this.binding.oldPartNo.setText("");
                UpdateDialogFragment.this.binding.oldPslNo.setText("");
                if (TextUtils.isEmpty(UpdateDialogFragment.this.is2003Selected) || !UpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                    UpdateDialogFragment.this.commomUtility.getAssmblyByDist(UpdateDialogFragment.this.requireActivity(), i2, UpdateDialogFragment.this.oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.8.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                        public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                            if (code == 200) {
                                UpdateDialogFragment.this.ACNameList.clear();
                                UpdateDialogFragment.this.ACList.clear();
                                UpdateDialogFragment.this.ACList = acList;
                                UpdateDialogFragment.this.ACNameList = acNameList;
                                if (UpdateDialogFragment.this.partNameList.size() > 0 && UpdateDialogFragment.this.partList.size() > 0) {
                                    UpdateDialogFragment.this.partList.clear();
                                    UpdateDialogFragment.this.partNameList.clear();
                                }
                                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) UpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) UpdateDialogFragment.this.ACNameList);
                                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                                UpdateDialogFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                                UpdateDialogFragment.this.binding.oldAcNo.setThreshold(1);
                            }
                        }
                    });
                }
            }
        });
        this.binding.oldAcNo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                UpdateDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Assembly Constituency")) {
                    UpdateDialogFragment.this.isOldAcNoEntered = false;
                    UpdateDialogFragment.this.oldAc = null;
                    UpdateDialogFragment.this.OldPart = null;
                    UpdateDialogFragment.this.partList.clear();
                    UpdateDialogFragment.this.partNameList.clear();
                    UpdateDialogFragment.this.partNameList.add(UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    UpdateDialogFragment.this.partList.add(0);
                    UpdateDialogFragment.this.binding.oldPartNo.setText("");
                    UpdateDialogFragment.this.binding.oldPartNo.setText("");
                    UpdateDialogFragment.this.binding.oldPslNo.setText("");
                    UpdateDialogFragment.this.isUserSelected = false;
                    return;
                }
                UpdateDialogFragment.this.OldPart = null;
                UpdateDialogFragment.this.isOldAcNoEntered = true;
                UpdateDialogFragment.this.binding.oldPartNo.setText("");
                UpdateDialogFragment.this.binding.oldPslNo.setText("");
                String string = parent.getItemAtPosition(i).toString();
                UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                updateDialogFragment.oldAc = String.valueOf(updateDialogFragment.ACList.get(UpdateDialogFragment.this.ACNameList.indexOf(string)));
                if (!TextUtils.isEmpty(UpdateDialogFragment.this.is2003Selected) && UpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                    UpdateDialogFragment.this.commomUtility.getPartByAc2025(UpdateDialogFragment.this.requireActivity(), Integer.parseInt(UpdateDialogFragment.this.oldAc), UpdateDialogFragment.this.oldState, UpdateDialogFragment.this.token, UpdateDialogFragment.this.atkband, UpdateDialogFragment.this.rtkband, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.9.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                        public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                            if (code == 200) {
                                UpdateDialogFragment.this.partList.clear();
                                UpdateDialogFragment.this.partNameList.clear();
                                UpdateDialogFragment.this.partList = acList;
                                UpdateDialogFragment.this.partNameList = acNameList;
                                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) UpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) UpdateDialogFragment.this.partNameList);
                                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                                UpdateDialogFragment.this.binding.oldPartNo.setAdapter(arrayAdapter);
                                UpdateDialogFragment.this.binding.oldPartNo.setThreshold(1);
                            }
                        }
                    });
                } else {
                    UpdateDialogFragment.this.commomUtility.getPartByAc(UpdateDialogFragment.this.requireActivity(), Integer.parseInt(UpdateDialogFragment.this.oldAc), UpdateDialogFragment.this.oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.9.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                        public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                            if (code == 200) {
                                UpdateDialogFragment.this.partList.clear();
                                UpdateDialogFragment.this.partNameList.clear();
                                UpdateDialogFragment.this.partList = acList;
                                UpdateDialogFragment.this.partNameList = acNameList;
                                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) UpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) UpdateDialogFragment.this.partNameList);
                                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                                UpdateDialogFragment.this.binding.oldPartNo.setAdapter(arrayAdapter);
                                UpdateDialogFragment.this.binding.oldPartNo.setThreshold(1);
                            }
                        }
                    });
                }
                if (UpdateDialogFragment.this.isUserSelected) {
                    UpdateDialogFragment.this.isUserSelected = false;
                }
            }
        });
        this.binding.oldPartNo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                UpdateDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Part")) {
                    UpdateDialogFragment.this.isOldPartNoEntered = false;
                    UpdateDialogFragment.this.OldPart = null;
                    UpdateDialogFragment.this.binding.oldPslNo.setText("");
                    UpdateDialogFragment.this.isUserSelected = false;
                    return;
                }
                UpdateDialogFragment.this.isOldPartNoEntered = true;
                String string = parent.getItemAtPosition(i).toString();
                UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                updateDialogFragment.OldPart = String.valueOf(updateDialogFragment.partList.get(UpdateDialogFragment.this.partNameList.indexOf(string)));
                if (UpdateDialogFragment.this.isUserSelected) {
                    UpdateDialogFragment.this.isUserSelected = false;
                }
            }
        });
        this.binding.oldPslNo.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.11
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                UpdateDialogFragment.this.binding.cardDisabled.setVisibility(8);
            }
        });
    }

    private void handleButtonClicks() {
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateDialogFragment.this.utils.validateState_Ac_Part_Serial(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.oldState, UpdateDialogFragment.this.oldDistrict, UpdateDialogFragment.this.oldAc, UpdateDialogFragment.this.OldPart, UpdateDialogFragment.this.binding.oldPslNo.getText().toString().trim(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.12.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                    public void onResult(boolean isValidate) {
                        if (!TextUtils.isEmpty(UpdateDialogFragment.this.is2003Selected) && UpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("Y")) {
                            if (UpdateDialogFragment.this.payloads.size() > 0) {
                                UpdateDialogFragment.this.payloads.clear();
                            }
                            UpdateDialogFragment.this.searchDetails();
                        } else {
                            if (TextUtils.isEmpty(UpdateDialogFragment.this.is2003Selected) || !UpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                                return;
                            }
                            if (UpdateDialogFragment.this.erollPayloads.size() > 0) {
                                UpdateDialogFragment.this.erollPayloads.clear();
                            }
                            UpdateDialogFragment.this.ErollDataDetails();
                        }
                    }
                });
            }
        });
        this.binding.submitButtonBlo.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleButtonClicks$0(view);
            }
        });
        this.binding.speakSerial.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateDialogFragment.this.utils.showVoicePopup(UpdateDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.17.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        UpdateDialogFragment.this.binding.oldPslNo.setText(result);
                    }
                });
            }
        });
        this.binding.speakSelf.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateDialogFragment.this.utils.showVoicePopup(UpdateDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.18.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        UpdateDialogFragment.this.binding.selfName.setText(result);
                    }
                });
            }
        });
        this.binding.speakParent.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateDialogFragment.this.utils.showVoicePopup(UpdateDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.19.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        UpdateDialogFragment.this.binding.parentName.setText(result);
                    }
                });
            }
        });
        this.binding.speakGrandparent.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateDialogFragment.this.utils.showVoicePopup(UpdateDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.20.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        UpdateDialogFragment.this.binding.grandparentName.setText(result);
                    }
                });
            }
        });
        this.binding.searchButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleButtonClicks$1(view);
            }
        });
        this.binding.ivCancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                updateDialogFragment.sentselfSearchData(null, null, updateDialogFragment.key, null);
            }
        });
        this.binding.layoutVerifyButton.setOnClickListener(new AnonymousClass23());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleButtonClicks$0(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        int age;
        if (!TextUtils.isEmpty(this.is2003Selected) && this.is2003Selected.equalsIgnoreCase("N")) {
            PayloadNewMapping payloadNewMapping = this.erollPayloads.get(0);
            final Payload payload = new Payload();
            payload.setId(payloadNewMapping.getId());
            payload.setEpicNumber(payloadNewMapping.getEpicNumber());
            payload.setOldFullName(payloadNewMapping.getFullName());
            payload.setOldRelativeFullName(payloadNewMapping.getFullRelativeName());
            payload.setRelationType(payloadNewMapping.getRelationType());
            payload.setOldStateName(payloadNewMapping.getStateName());
            payload.setOldStateCd(payloadNewMapping.getStateCd());
            payload.setOldAcNo(payloadNewMapping.getAcNo());
            payload.setOldAcName(payloadNewMapping.getAcName());
            payload.setOldPartNumber(payloadNewMapping.getPartNo());
            payload.setOldPartName(payloadNewMapping.getPartName());
            payload.setOldPartSerialNo(payloadNewMapping.getSerialNo());
            payload.setAge(payloadNewMapping.getAge());
            payload.setOldDistNo(TextUtils.isEmpty(payloadNewMapping.getDistrictNo()) ? 0 : Integer.parseInt(payloadNewMapping.getDistrictNo()));
            if (this.key.equalsIgnoreCase("progeny")) {
                this.utils.validateProgenyDetails(requireActivity(), payloadNewMapping.getStateCd(), String.valueOf(payloadNewMapping.getAcNo()), String.valueOf(payloadNewMapping.getPartNo()), String.valueOf(payloadNewMapping.getSerialNo()), this.currentName, new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.13
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                    public void onResult(boolean isValidate) {
                        if (isValidate) {
                            UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                            updateDialogFragment.sentselfSearchData(payload, null, updateDialogFragment.key, UpdateDialogFragment.this.is2003Selected);
                        }
                    }
                });
                return;
            } else {
                if (this.key.equalsIgnoreCase("self")) {
                    this.commomUtility.validateSirMapping(requireActivity(), this.token, this.state, this.atkband, this.rtkband, payloadNewMapping.getStateCd(), String.valueOf(payloadNewMapping.getAcNo()), String.valueOf(payloadNewMapping.getPartNo()), String.valueOf(payloadNewMapping.getSerialNo()), this.acNo, this.partNo, this.currentStateCode, this.currentAge, payloadNewMapping.getAge(), new AnonymousClass14(payload, payloadNewMapping));
                    return;
                }
                return;
            }
        }
        if (this.payloads.size() > 0) {
            String oldStateCd = this.payloads.get(0).getOldStateCd();
            String strValueOf = String.valueOf(this.payloads.get(0).getOldAcNo());
            String strValueOf2 = String.valueOf(this.payloads.get(0).getOldPartNumber());
            String strValueOf3 = String.valueOf(this.payloads.get(0).getOldPartSerialNo());
            str = oldStateCd;
            age = this.payloads.get(0).getAge();
            str2 = strValueOf;
            str3 = strValueOf2;
            str4 = strValueOf3;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            age = 0;
        }
        if (this.key.equalsIgnoreCase("progeny")) {
            this.utils.validateProgenyDetails(requireActivity(), str, str2, str3, str4, this.currentName, new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.15
                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                public void onResult(boolean isValidate) {
                    if (isValidate) {
                        UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                        updateDialogFragment.sentselfSearchData(updateDialogFragment.payloads.get(0), null, UpdateDialogFragment.this.key, UpdateDialogFragment.this.is2003Selected);
                    }
                }
            });
        } else if (this.key.equalsIgnoreCase("self")) {
            this.commomUtility.validateSirMapping(requireActivity(), this.token, this.state, this.atkband, this.rtkband, str, str2, str3, str4, this.acNo, this.partNo, this.currentStateCode, this.currentAge, age, new AnonymousClass16(str, str2, str3, str4, age));
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$14, reason: invalid class name */
    class AnonymousClass14 implements ValidateMapCallback {
        final /* synthetic */ Payload val$erollpayload;
        final /* synthetic */ PayloadNewMapping val$payloadNewMapping;

        AnonymousClass14(final Payload val$erollpayload, final PayloadNewMapping val$payloadNewMapping) {
            this.val$erollpayload = val$erollpayload;
            this.val$payloadNewMapping = val$payloadNewMapping;
        }

        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback
        public void onCallBack(String statusCode, String message, final String bloNumber, final String bloName) {
            if (statusCode.equalsIgnoreCase("200")) {
                UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                updateDialogFragment.sentselfSearchData(this.val$erollpayload, null, updateDialogFragment.key, UpdateDialogFragment.this.is2003Selected);
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
                UpdateDialogFragment.this.utils.decisionDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message, UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), "Ok", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.14.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onNegativeButtonClicked() {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onPositiveButtonClicked() {
                        UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping_des), new OkCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.14.1.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.OkCallback
                            public void onPositiveButtonClicked() {
                                UpdateDialogFragment.this.commomUtility.checkSelfMappingConflict(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.token, UpdateDialogFragment.this.state, UpdateDialogFragment.this.atkband, UpdateDialogFragment.this.rtkband, AnonymousClass14.this.val$payloadNewMapping.getStateCd(), String.valueOf(AnonymousClass14.this.val$payloadNewMapping.getAcNo()), String.valueOf(AnonymousClass14.this.val$payloadNewMapping.getPartNo()), String.valueOf(AnonymousClass14.this.val$payloadNewMapping.getSerialNo()), UpdateDialogFragment.this.acNo, UpdateDialogFragment.this.partNo, UpdateDialogFragment.this.currentStateCode, UpdateDialogFragment.this.currentAge, AnonymousClass14.this.val$payloadNewMapping.getAge(), UpdateDialogFragment.this.currentEpic, UpdateDialogFragment.this.currentEpicId, bloName, bloNumber, strTrim, String.valueOf(UpdateDialogFragment.this.currentSerialNo));
                            }
                        });
                    }
                });
                return;
            }
            if (statusCode.equalsIgnoreCase("0")) {
                UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            } else {
                UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$16, reason: invalid class name */
    class AnonymousClass16 implements ValidateMapCallback {
        final /* synthetic */ String val$finalOldAC;
        final /* synthetic */ int val$finalOldAge;
        final /* synthetic */ String val$finalOldPart;
        final /* synthetic */ String val$finalOldSerial;
        final /* synthetic */ String val$finalOldState;

        AnonymousClass16(final String val$finalOldState, final String val$finalOldAC, final String val$finalOldPart, final String val$finalOldSerial, final int val$finalOldAge) {
            this.val$finalOldState = val$finalOldState;
            this.val$finalOldAC = val$finalOldAC;
            this.val$finalOldPart = val$finalOldPart;
            this.val$finalOldSerial = val$finalOldSerial;
            this.val$finalOldAge = val$finalOldAge;
        }

        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback
        public void onCallBack(String statusCode, String message, final String bloNumber, final String bloName) {
            if (statusCode.equalsIgnoreCase("200")) {
                UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                updateDialogFragment.sentselfSearchData(updateDialogFragment.payloads.get(0), null, UpdateDialogFragment.this.key, UpdateDialogFragment.this.is2003Selected);
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
                UpdateDialogFragment.this.utils.decisionDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message, UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), "Ok", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.16.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onNegativeButtonClicked() {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onPositiveButtonClicked() {
                        UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping_des), new OkCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.16.1.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.OkCallback
                            public void onPositiveButtonClicked() {
                                UpdateDialogFragment.this.commomUtility.checkSelfMappingConflict(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.token, UpdateDialogFragment.this.state, UpdateDialogFragment.this.atkband, UpdateDialogFragment.this.rtkband, AnonymousClass16.this.val$finalOldState, AnonymousClass16.this.val$finalOldAC, AnonymousClass16.this.val$finalOldPart, AnonymousClass16.this.val$finalOldSerial, UpdateDialogFragment.this.acNo, UpdateDialogFragment.this.partNo, UpdateDialogFragment.this.currentStateCode, UpdateDialogFragment.this.currentAge, AnonymousClass16.this.val$finalOldAge, UpdateDialogFragment.this.currentEpic, UpdateDialogFragment.this.currentEpicId, bloName, bloNumber, strTrim, String.valueOf(UpdateDialogFragment.this.currentSerialNo));
                            }
                        });
                    }
                });
                return;
            }
            if (statusCode.equalsIgnoreCase("0")) {
                UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            } else {
                UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleButtonClicks$1(View view) {
        this.utils.validateState_Ac_Family(requireActivity(), this.efState, this.efAc, this.binding.selfName.getText().toString().trim(), this.binding.parentName.getText().toString().trim(), this.binding.grandparentName.getText().toString().trim(), this.efDistrict, this.OldPart, this.key, new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.21
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
            public void onResult(boolean isValidate) {
                if (isValidate) {
                    UpdateDialogFragment.this.callLocationApi();
                }
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$23, reason: invalid class name */
    class AnonymousClass23 implements View.OnClickListener {
        AnonymousClass23() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            for (final MappingList mappingList : UpdateDialogFragment.this.newbloMappedList) {
                if (mappingList.isSelected()) {
                    String oldStateCd = mappingList.getOldStateCd();
                    String strValueOf = String.valueOf(mappingList.getOldAcNo());
                    String strValueOf2 = String.valueOf(mappingList.getOldPartNumber());
                    String strValueOf3 = String.valueOf(mappingList.getOldPartSerialNo());
                    int age = mappingList.getAge();
                    if (UpdateDialogFragment.this.key.equalsIgnoreCase("progeny")) {
                        UpdateDialogFragment.this.utils.validateProgenyDetails(UpdateDialogFragment.this.requireActivity(), oldStateCd, strValueOf, strValueOf2, strValueOf3, UpdateDialogFragment.this.currentName, new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.23.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                            public void onResult(boolean isValidate) {
                                if (isValidate) {
                                    UpdateDialogFragment.this.sentselfSearchData(null, mappingList, UpdateDialogFragment.this.key, UpdateDialogFragment.this.is2003Selected);
                                }
                            }
                        });
                        return;
                    } else {
                        if (UpdateDialogFragment.this.key.equalsIgnoreCase("self")) {
                            UpdateDialogFragment.this.commomUtility.validateSirMapping(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.token, UpdateDialogFragment.this.state, UpdateDialogFragment.this.atkband, UpdateDialogFragment.this.rtkband, oldStateCd, strValueOf, strValueOf2, strValueOf3, UpdateDialogFragment.this.acNo, UpdateDialogFragment.this.partNo, UpdateDialogFragment.this.currentStateCode, UpdateDialogFragment.this.currentAge, age, new AnonymousClass2(mappingList, oldStateCd, strValueOf, strValueOf2, strValueOf3, age));
                            return;
                        }
                        return;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$23$2, reason: invalid class name */
        class AnonymousClass2 implements ValidateMapCallback {
            final /* synthetic */ String val$finalOldAC;
            final /* synthetic */ int val$finalOldAge;
            final /* synthetic */ String val$finalOldPart;
            final /* synthetic */ String val$finalOldSerial;
            final /* synthetic */ String val$finalOldState;
            final /* synthetic */ MappingList val$item;

            AnonymousClass2(final MappingList val$item, final String val$finalOldState, final String val$finalOldAC, final String val$finalOldPart, final String val$finalOldSerial, final int val$finalOldAge) {
                this.val$item = val$item;
                this.val$finalOldState = val$finalOldState;
                this.val$finalOldAC = val$finalOldAC;
                this.val$finalOldPart = val$finalOldPart;
                this.val$finalOldSerial = val$finalOldSerial;
                this.val$finalOldAge = val$finalOldAge;
            }

            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback
            public void onCallBack(String statusCode, String message, final String bloNumber, final String bloName) {
                if (statusCode.equalsIgnoreCase("200")) {
                    UpdateDialogFragment.this.sentselfSearchData(null, this.val$item, UpdateDialogFragment.this.key, UpdateDialogFragment.this.is2003Selected);
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
                    UpdateDialogFragment.this.utils.decisionDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message, UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), "Ok", new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.23.2.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onNegativeButtonClicked() {
                        }

                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                        public void onPositiveButtonClicked() {
                            UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.flag_incorrect_mapping_des), new OkCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.23.2.1.1
                                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.OkCallback
                                public void onPositiveButtonClicked() {
                                    UpdateDialogFragment.this.commomUtility.checkSelfMappingConflict(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.token, UpdateDialogFragment.this.state, UpdateDialogFragment.this.atkband, UpdateDialogFragment.this.rtkband, AnonymousClass2.this.val$finalOldState, AnonymousClass2.this.val$finalOldAC, AnonymousClass2.this.val$finalOldPart, AnonymousClass2.this.val$finalOldSerial, UpdateDialogFragment.this.acNo, UpdateDialogFragment.this.partNo, UpdateDialogFragment.this.currentStateCode, UpdateDialogFragment.this.currentAge, AnonymousClass2.this.val$finalOldAge, UpdateDialogFragment.this.currentEpic, UpdateDialogFragment.this.currentEpicId, bloName, bloNumber, strTrim, String.valueOf(UpdateDialogFragment.this.currentSerialNo));
                                }
                            });
                        }
                    });
                    return;
                }
                if (statusCode.equalsIgnoreCase("0")) {
                    UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                } else {
                    UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                }
            }
        }
    }

    private void handleSearchTabClcicks() {
        this.binding.searchAcPartPslMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$3(view);
            }
        });
        this.binding.searchLocationMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$5(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$3(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleSearchTabClcicks$2();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$2() {
        this.binding.searchTabLayout.setVisibility(0);
        this.binding.searchByAcDetailsLl.setVisibility(0);
        this.binding.searchByLocationDetailsLl.setVisibility(8);
        selecttab(this.binding.searchAcPartPslMB, this.binding.searchLocationMB);
        this.efAc = null;
        this.efDistrict = null;
        this.efState = null;
        this.OldPart = null;
        this.binding.parentName.setText("");
        this.binding.efStateSpinner.setText("");
        this.binding.oldStateSpinner.setText("");
        this.binding.grandparentName.setText("");
        if (this.EfACList.size() > 0 && this.EfACNameList.size() > 0) {
            this.binding.efAcSpinner.setText("");
        }
        if (this.partList.size() > 0 && this.partNameList.size() > 0) {
            this.binding.efOldPartNo.setText("");
        }
        if (this.district.size() <= 0 || this.districtcode.size() <= 0) {
            return;
        }
        this.binding.efDistrictSpinner.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$5(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleSearchTabClcicks$4();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$4() {
        this.binding.electorNameLayout.setVisibility(8);
        this.binding.efStateSpinner.setText("");
        this.binding.oldStateSpinner.setText("");
        this.binding.searchByLocationCv.setVisibility(0);
        this.binding.searchTabLayout.setVisibility(0);
        selecttab(this.binding.searchLocationMB, this.binding.searchAcPartPslMB);
        this.binding.searchByLocationDetailsLl.setVisibility(0);
        this.binding.searchByAcDetailsLl.setVisibility(8);
        this.binding.oldPslNo.setText("");
        this.binding.cardDisabled.setVisibility(8);
        this.oldState = null;
        this.oldAc = null;
        this.OldPart = null;
        this.binding.oldPslNo.setText("");
        this.oldDistrict = null;
        if (this.ACList.size() > 0 && this.ACNameList.size() > 0) {
            this.binding.oldAcNo.setText("");
        }
        if (this.partList.size() > 0 && this.partNameList.size() > 0) {
            this.binding.oldPartNo.setText("");
        }
        if (this.district.size() <= 0 || this.districtcode.size() <= 0) {
            return;
        }
        this.binding.oldDistrictSpinner.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdapter() {
        if (!TextUtils.isEmpty(this.is2003Selected) && this.is2003Selected.equalsIgnoreCase("N")) {
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
            this.StateNameList.removeIf(new Predicate() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return UpdateDialogFragment.lambda$setAdapter$6(arrayList, (String) obj);
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
            this.StateList.removeIf(new Predicate() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda4
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return UpdateDialogFragment.lambda$setAdapter$7(arrayList2, (String) obj);
                }
            });
        } else {
            if (this.StateList.size() > 0) {
                this.StateList.clear();
                this.StateNameList.clear();
            }
            this.StateList = SharedPref.getInstance(requireActivity()).getAcListCode(Constants.STATE_LIST_CODE);
            this.StateNameList = SharedPref.getInstance(requireActivity()).getAcListName(Constants.STATE_LIST_NAME);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), R.layout.blo_spinner_dropdown_new, (List) this.StateNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldStateSpinner.setAdapter(arrayAdapter);
        this.binding.efStateSpinner.setAdapter(arrayAdapter);
    }

    static /* synthetic */ boolean lambda$setAdapter$6(ArrayList arrayList, String str) {
        return !arrayList.contains(str);
    }

    static /* synthetic */ boolean lambda$setAdapter$7(ArrayList arrayList, String str) {
        return !arrayList.contains(str);
    }

    private void init() {
        this.userClient = (UserClient) ApiClient.getClient2(requireActivity()).create(UserClient.class);
        this.utils = new Utils();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        if (this.mappingtype.equalsIgnoreCase("self")) {
            if (this.key.equalsIgnoreCase("self")) {
                this.is2003Selected = "Y";
                this.binding.radiochooseCardView.setVisibility(8);
            } else if (this.key.equalsIgnoreCase("progeny")) {
                this.binding.radiochooseCardView.setVisibility(0);
                this.binding.searchCV.setVisibility(8);
                this.binding.searchAcCV.setVisibility(8);
                this.binding.searchByLocationCv.setVisibility(8);
                if (!TextUtils.isEmpty(this.sirYearProgeny) && this.sirYearProgeny.equalsIgnoreCase(Constants.SIR_YEAR_PROGENY)) {
                    this.binding.rb2025.setChecked(true);
                    this.is2003Selected = "N";
                    setAdapter();
                    this.binding.searchByLocationDetailsLl.setVisibility(8);
                    this.binding.searchLocationMB.setVisibility(8);
                    selecttab(this.binding.searchAcPartPslMB, this.binding.searchLocationMB);
                    this.binding.searchCV.setVisibility(0);
                    this.binding.searchAcCV.setVisibility(0);
                    this.binding.searchByLocationCv.setVisibility(8);
                    this.binding.searchByAcDetailsLl.setVisibility(0);
                }
                if (!TextUtils.isEmpty(this.sirYearProgeny) && this.sirYearProgeny.equalsIgnoreCase(Constants.SIR_YEAR_SELF)) {
                    this.binding.rb2003.setChecked(true);
                    this.is2003Selected = "Y";
                    setAdapter();
                    this.binding.searchByLocationDetailsLl.setVisibility(0);
                    this.binding.searchLocationMB.setVisibility(0);
                    selecttab(this.binding.searchAcPartPslMB, this.binding.searchLocationMB);
                    this.binding.searchCV.setVisibility(0);
                    this.binding.searchAcCV.setVisibility(0);
                    this.binding.searchByLocationCv.setVisibility(8);
                    this.binding.searchByAcDetailsLl.setVisibility(0);
                }
            }
        }
        if (this.mappingtype.equalsIgnoreCase("progeny")) {
            this.is2003Selected = "Y";
            this.binding.radiochooseCardView.setVisibility(8);
        }
        if (this.mappingtype.equalsIgnoreCase("progney2026")) {
            this.is2003Selected = "N";
            this.binding.radiochooseCardView.setVisibility(8);
            setAdapter();
            this.binding.searchByLocationDetailsLl.setVisibility(8);
            this.binding.searchLocationMB.setVisibility(8);
            selecttab(this.binding.searchAcPartPslMB, this.binding.searchLocationMB);
            this.binding.searchCV.setVisibility(0);
            this.binding.searchAcCV.setVisibility(0);
        }
        this.binding.chooseRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.24
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (UpdateDialogFragment.this.binding.rb2003.isChecked()) {
                    UpdateDialogFragment.this.is2003Selected = "Y";
                    UpdateDialogFragment.this.setAdapter();
                    UpdateDialogFragment.this.binding.searchByLocationDetailsLl.setVisibility(0);
                    UpdateDialogFragment.this.binding.searchLocationMB.setVisibility(0);
                    UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                    updateDialogFragment.selecttab(updateDialogFragment.binding.searchAcPartPslMB, UpdateDialogFragment.this.binding.searchLocationMB);
                    UpdateDialogFragment.this.binding.searchCV.setVisibility(0);
                    UpdateDialogFragment.this.binding.searchAcCV.setVisibility(0);
                    UpdateDialogFragment.this.binding.searchByLocationCv.setVisibility(8);
                    UpdateDialogFragment.this.binding.searchByAcDetailsLl.setVisibility(0);
                }
                if (UpdateDialogFragment.this.binding.rb2025.isChecked()) {
                    UpdateDialogFragment.this.is2003Selected = "N";
                    UpdateDialogFragment.this.setAdapter();
                    UpdateDialogFragment.this.binding.searchByLocationDetailsLl.setVisibility(8);
                    UpdateDialogFragment.this.binding.searchLocationMB.setVisibility(8);
                    UpdateDialogFragment updateDialogFragment2 = UpdateDialogFragment.this;
                    updateDialogFragment2.selecttab(updateDialogFragment2.binding.searchAcPartPslMB, UpdateDialogFragment.this.binding.searchLocationMB);
                    UpdateDialogFragment.this.binding.searchCV.setVisibility(0);
                    UpdateDialogFragment.this.binding.searchAcCV.setVisibility(0);
                    UpdateDialogFragment.this.binding.searchByLocationCv.setVisibility(8);
                    UpdateDialogFragment.this.binding.searchByAcDetailsLl.setVisibility(0);
                }
            }
        });
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
    public void sentselfSearchData(Payload serchModel, MappingList mappingList, String key, String isSelected2003) {
        if (this.listener != null) {
            dismiss();
            this.listener.onDataReceived(serchModel, mappingList, key, isSelected2003);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selecttab(MaterialButton selected, MaterialButton other) {
        selected.setBackgroundTintList(ContextCompat.getColorStateList(requireActivity(), R.color.new_tab_color));
        selected.setTextColor(ContextCompat.getColor(requireActivity(), R.color.blo_white));
        other.setBackgroundTintList(ContextCompat.getColorStateList(requireActivity(), android.R.color.transparent));
        other.setTextColor(ContextCompat.getColor(requireActivity(), R.color.blo_black));
        other.setStrokeWidth(2);
        other.setStrokeColor(ContextCompat.getColorStateList(requireActivity(), R.color.blo_light_grey));
        if (TextUtils.isEmpty(this.key)) {
            return;
        }
        if (this.key.equalsIgnoreCase("self")) {
            this.binding.grandparentNameLayout.setVisibility(8);
            this.binding.electorNameLayout.setVisibility(0);
            this.binding.parentNameLayout.setVisibility(0);
            this.binding.titleParentname.setText(requireActivity().getResources().getString(R.string.blo_Relative_Name));
        }
        if (this.key.equalsIgnoreCase("progeny")) {
            this.binding.electorNameLayout.setVisibility(8);
            this.binding.grandparentNameLayout.setVisibility(0);
            this.binding.parentNameLayout.setVisibility(0);
            this.binding.titleParentname.setText(requireActivity().getResources().getString(R.string.parent_name));
        }
    }

    private void initializeSpinnerTouch() {
        this.binding.oldStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UpdateDialogFragment.this.binding.oldStateSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.26
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UpdateDialogFragment.this.binding.efStateSpinner.showDropDown();
                return false;
            }
        });
        this.binding.oldDistrictSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.27
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UpdateDialogFragment.this.binding.oldDistrictSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efDistrictSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UpdateDialogFragment.this.binding.efDistrictSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efAcSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UpdateDialogFragment.this.binding.efAcSpinner.showDropDown();
                return false;
            }
        });
        this.binding.oldAcNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.30
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UpdateDialogFragment.this.binding.oldAcNo.showDropDown();
                return false;
            }
        });
        this.binding.oldPartNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.31
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UpdateDialogFragment.this.binding.oldPartNo.showDropDown();
                return false;
            }
        });
        this.binding.efOldPartNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.32
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                UpdateDialogFragment.this.binding.efOldPartNo.showDropDown();
                return false;
            }
        });
    }

    public void callLocationApi() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        if (this.key.equalsIgnoreCase("self")) {
            map2.put("applicantName", this.binding.selfName.getText().toString());
            map2.put("relativeName", this.binding.parentName.getText().toString());
        }
        if (this.key.equalsIgnoreCase("progeny")) {
            map2.put("relativeName", this.binding.parentName.getText().toString());
            map2.put("grandParentName", this.binding.grandparentName.getText().toString());
        }
        map2.put("stateCd", this.efState);
        map2.put("mappingType", this.key);
        map2.put("districtNo", this.efDistrict);
        map2.put("acNo", this.efAc);
        map2.put("partNo", this.OldPart);
        map2.put("efEpicNumber", this.currentEpic);
        map2.put("efApplicantName", this.currentName);
        map2.put("efRelativeName", this.currentRelativeName);
        map2.put("efStateCd", this.currentStateCode);
        map2.put("efRelationType", this.currentRelativeType);
        map2.put("efAge", Integer.valueOf(this.currentAge));
        map2.put("efAcNo", Integer.valueOf(this.currentAc));
        map2.put("efPartNo", Integer.valueOf(this.currentPart));
        map2.put("efPartSerialNo", Integer.valueOf(this.currentSerialNo));
        Call<LocationRoot> searchLocationFamily = ((UserClient) ApiClient.getClient2(requireContext()).create(UserClient.class)).getSearchLocationFamily(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        searchLocationFamily.enqueue(new AnonymousClass33());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$33, reason: invalid class name */
    class AnonymousClass33 implements Callback<LocationRoot> {
        AnonymousClass33() {
        }

        public void onResponse(Call<LocationRoot> call, Response<LocationRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    UpdateDialogFragment.this.newbloMappedList = ((LocationRoot) response.body()).payload.mappingList;
                    if (UpdateDialogFragment.this.newbloMappedList.size() > 0) {
                        Logger.d("blo list size", "" + UpdateDialogFragment.this.newbloMappedList.size());
                        UpdateDialogFragment.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(UpdateDialogFragment.this.requireActivity()));
                        if (UpdateDialogFragment.this.newbloMappedList != null && !UpdateDialogFragment.this.newbloMappedList.isEmpty()) {
                            UpdateDialogFragment.this.binding.rvMapping.setVisibility(0);
                            UpdateDialogFragment.this.binding.tvRecordCount.setVisibility(0);
                            UpdateDialogFragment.this.binding.tvRecordCount.setText(UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.total_record) + StringUtils.SPACE + UpdateDialogFragment.this.newbloMappedList.size());
                            UpdateDialogFragment.this.adapter = new SearchLocationAdapter(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.newbloMappedList, new SearchLocationAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$33$$ExternalSyntheticLambda0
                                @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.SearchLocationAdapter.OnItemSelectedListener
                                public final void onItemSelected() {
                                    this.f$0.lambda$onResponse$0();
                                }
                            });
                            UpdateDialogFragment.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(UpdateDialogFragment.this.getContext()));
                            UpdateDialogFragment.this.binding.rvMapping.setNestedScrollingEnabled(false);
                            UpdateDialogFragment.this.binding.rvMapping.setAdapter(UpdateDialogFragment.this.adapter);
                        }
                    } else {
                        new Utils().infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.no_data_found));
                    }
                } catch (Exception unused) {
                }
                UpdateDialogFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                if (UpdateDialogFragment.this.alertDialog != null) {
                    UpdateDialogFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            try {
                if (UpdateDialogFragment.this.alertDialog != null) {
                    UpdateDialogFragment.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                if (TextUtils.isEmpty(strOptString)) {
                    UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), jSONObject.optString("error"));
                } else {
                    UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), strOptString);
                }
                Logger.e("TAG", strOptString);
                if (UpdateDialogFragment.this.alertDialog != null) {
                    UpdateDialogFragment.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (UpdateDialogFragment.this.alertDialog != null) {
                    UpdateDialogFragment.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            UpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(0);
        }

        public void onFailure(Call<LocationRoot> call, Throwable t) {
            if (UpdateDialogFragment.this.alertDialog != null) {
                UpdateDialogFragment.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchDetails() {
        this.commomUtility.callVerifyRelativeApi(requireActivity(), this.token, this.atkband, this.rtkband, this.oldState, this.oldAc, this.OldPart, this.binding.oldPslNo.getText().toString().trim(), new SearchByAcPartCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.34
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback
            public void onCallBack(int code, List<Payload> datalist, String message) {
                if (code == 200) {
                    if (datalist != null && datalist.size() > 0) {
                        UpdateDialogFragment.this.payloads = datalist;
                        if (datalist.size() > 1) {
                            UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.multiple_record));
                            return;
                        }
                        Payload payload = datalist.get(0);
                        UpdateDialogFragment.this.binding.tvStateName.setText(UpdateDialogFragment.this.oldStateName);
                        UpdateDialogFragment.this.binding.tvDistrictName.setText(String.valueOf(payload.getOldDistNo()) + " - " + (TextUtils.isEmpty(payload.getOldDistName()) ? "" : payload.getOldDistName()));
                        UpdateDialogFragment.this.binding.tvAcName.setText(String.valueOf(payload.getOldAcNo()) + "  -  " + (TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName()));
                        UpdateDialogFragment.this.binding.tvPartName.setText(String.valueOf(payload.getOldPartNumber()) + "  -  " + (TextUtils.isEmpty(payload.getOldPartName()) ? "" : payload.getOldPartName()));
                        UpdateDialogFragment.this.binding.tvSerialName.setText(UpdateDialogFragment.this.binding.oldPslNo.getText().toString());
                        UpdateDialogFragment.this.binding.tvSectionNo.setText("");
                        UpdateDialogFragment.this.binding.tvOldAge.setText(String.valueOf(payload.getAge()));
                        UpdateDialogFragment.this.binding.tvOldEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                        TextUtils.isEmpty(payload.getEpicNumber());
                        UpdateDialogFragment.this.binding.cardDisabled.setVisibility(0);
                        if (!TextUtils.isEmpty(payload.getRelationType())) {
                            String relationType = payload.getRelationType();
                            if (relationType.equalsIgnoreCase("F") || relationType.equalsIgnoreCase("FATHER") || relationType.equalsIgnoreCase("FTHR")) {
                                UpdateDialogFragment.this.binding.tvRelativeType.setText("Father");
                            } else if (relationType.equalsIgnoreCase("M") || relationType.equalsIgnoreCase("MOTHER") || relationType.equalsIgnoreCase("MTHR")) {
                                UpdateDialogFragment.this.binding.tvRelativeType.setText("Mother");
                            } else if (relationType.equalsIgnoreCase("H") || relationType.equalsIgnoreCase("HUSBAND") || relationType.equalsIgnoreCase("HSBN")) {
                                UpdateDialogFragment.this.binding.tvRelativeType.setText("Husband");
                            } else if (relationType.equalsIgnoreCase("W") || relationType.equalsIgnoreCase("WIFE")) {
                                UpdateDialogFragment.this.binding.tvRelativeType.setText("Wife");
                            } else if (relationType.equalsIgnoreCase("L") || relationType.equalsIgnoreCase("OTHER") || relationType.equalsIgnoreCase("O")) {
                                UpdateDialogFragment.this.binding.tvRelativeType.setText("Other");
                            } else if (relationType.equalsIgnoreCase("GMTH")) {
                                UpdateDialogFragment.this.binding.tvRelativeType.setText("Grand Mother");
                            } else if (relationType.equalsIgnoreCase("GFTH")) {
                                UpdateDialogFragment.this.binding.tvRelativeType.setText("Grand Father");
                            } else {
                                UpdateDialogFragment.this.binding.tvRelativeType.setText(relationType);
                            }
                        }
                        if (TextUtils.isEmpty(payload.getOldFullName()) && !TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            UpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                            UpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                        } else if (TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            UpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            UpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                        } else if (payload.getOldFullName().equalsIgnoreCase(payload.getOldFullNameL1())) {
                            UpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            UpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                        } else {
                            UpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            UpdateDialogFragment.this.binding.tvElectorNamev1.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                        }
                        if (TextUtils.isEmpty(payload.getOldRelativeFullName()) && !TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            UpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            UpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else if (TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            UpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            UpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else if (payload.getOldRelativeFullName().equalsIgnoreCase(payload.getOldRelativeFullNameL1())) {
                            UpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            UpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else {
                            UpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            UpdateDialogFragment.this.binding.tvRelativeNamev1.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    public void getAllDistrict(final String oldState) {
        this.commomUtility.getSirDistrict(oldState, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda0
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllDistrict$11(oldState, i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllDistrict$11(final String str, int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda2
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$getAllDistrict$10(str, i2, str2, str3);
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
        this.binding.oldDistrictSpinner.setSelection(0);
        this.binding.efDistrictSpinner.setAdapter(this.districtadapter);
        this.binding.efDistrictSpinner.setSelection(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllDistrict$10(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda8
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getAllDistrict$8(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        this.refreshToken = str3;
        SharedPref.getInstance(requireContext()).setRefreshToken(str3);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        this.commomUtility.getDistrict(str, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment$$ExternalSyntheticLambda9
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllDistrict$9(i2, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllDistrict$8(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllDistrict$9(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.blo_spinner_dropdown_new, this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldDistrictSpinner.setAdapter(this.districtadapter);
        this.binding.oldDistrictSpinner.setSelection(0);
        this.binding.efDistrictSpinner.setAdapter(this.districtadapter);
        this.binding.efDistrictSpinner.setSelection(0);
    }

    public void getAllOldAc(String oldState) {
        this.commomUtility.getAllAC(oldState, requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.35
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    UpdateDialogFragment.this.ACNameList.clear();
                    UpdateDialogFragment.this.ACList.clear();
                    UpdateDialogFragment.this.ACList = acList;
                    UpdateDialogFragment.this.ACNameList = acNameList;
                    if (UpdateDialogFragment.this.partNameList.size() > 0 && UpdateDialogFragment.this.partList.size() > 0) {
                        UpdateDialogFragment.this.partList.clear();
                        UpdateDialogFragment.this.partNameList.clear();
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) UpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) UpdateDialogFragment.this.ACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    UpdateDialogFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                    UpdateDialogFragment.this.binding.oldAcNo.setThreshold(1);
                }
            }
        });
    }

    public void getallEFAc(String efState) {
        this.commomUtility.getAllAC(efState, requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.36
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    UpdateDialogFragment.this.EfACNameList.clear();
                    UpdateDialogFragment.this.EfACList.clear();
                    UpdateDialogFragment.this.EfACList = acList;
                    UpdateDialogFragment.this.EfACNameList = acNameList;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) UpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) UpdateDialogFragment.this.EfACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    UpdateDialogFragment.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                    UpdateDialogFragment.this.binding.efAcSpinner.setThreshold(1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ErollDataDetails() {
        this.commomUtility.callErollData(requireActivity(), this.token, this.atkband, this.rtkband, this.oldState, this.oldAc, this.OldPart, this.binding.oldPslNo.getText().toString().trim(), new ErollDataCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.37
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ErollDataCallback
            public void onCallBack(int code, List<PayloadNewMapping> datalist, String message) {
                if (code == 200) {
                    if (datalist != null && datalist.size() > 0) {
                        UpdateDialogFragment.this.erollPayloads = datalist;
                        if (datalist.size() > 1) {
                            UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.multiple_record));
                            return;
                        }
                        PayloadNewMapping payloadNewMapping = datalist.get(0);
                        if (!TextUtils.isEmpty(payloadNewMapping.getIsActive()) && payloadNewMapping.getIsActive().equalsIgnoreCase(BooleanUtils.TRUE)) {
                            if (!TextUtils.isEmpty(payloadNewMapping.getUnderJo()) && payloadNewMapping.getUnderJo().equalsIgnoreCase("1")) {
                                UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), "The applicant is under Adjudication.");
                                return;
                            }
                            UpdateDialogFragment.this.binding.tvStateName.setText(UpdateDialogFragment.this.oldStateName);
                            UpdateDialogFragment.this.binding.tvDistrictName.setText(String.valueOf(payloadNewMapping.getDistrictNo()) + " - " + (TextUtils.isEmpty(payloadNewMapping.getDistrictNo()) ? "" : payloadNewMapping.getDistrictName()));
                            UpdateDialogFragment.this.binding.tvAcName.setText(String.valueOf(payloadNewMapping.getAcNo()) + "  -  " + (TextUtils.isEmpty(payloadNewMapping.getAcName()) ? "" : payloadNewMapping.getAcName()));
                            UpdateDialogFragment.this.binding.tvPartName.setText(String.valueOf(payloadNewMapping.getPartNo()) + "  -  " + (TextUtils.isEmpty(payloadNewMapping.getPartName()) ? "" : payloadNewMapping.getPartName()));
                            UpdateDialogFragment.this.binding.tvSerialName.setText(UpdateDialogFragment.this.binding.oldPslNo.getText().toString());
                            UpdateDialogFragment.this.binding.tvSectionNo.setText("");
                            UpdateDialogFragment.this.binding.tvOldAge.setText(String.valueOf(payloadNewMapping.getAge()));
                            UpdateDialogFragment.this.binding.tvOldEpic.setText(TextUtils.isEmpty(payloadNewMapping.getEpicNumber()) ? "" : payloadNewMapping.getEpicNumber());
                            TextUtils.isEmpty(payloadNewMapping.getEpicNumber());
                            UpdateDialogFragment.this.binding.cardDisabled.setVisibility(0);
                            if (!TextUtils.isEmpty(payloadNewMapping.getRelationType())) {
                                String relationType = payloadNewMapping.getRelationType();
                                if (relationType.equalsIgnoreCase("F") || relationType.equalsIgnoreCase("FATHER") || relationType.equalsIgnoreCase("FTHR")) {
                                    UpdateDialogFragment.this.binding.tvRelativeType.setText("Father");
                                } else if (relationType.equalsIgnoreCase("M") || relationType.equalsIgnoreCase("MOTHER") || relationType.equalsIgnoreCase("MTHR")) {
                                    UpdateDialogFragment.this.binding.tvRelativeType.setText("Mother");
                                } else if (relationType.equalsIgnoreCase("H") || relationType.equalsIgnoreCase("HUSBAND") || relationType.equalsIgnoreCase("HSBN")) {
                                    UpdateDialogFragment.this.binding.tvRelativeType.setText("Husband");
                                } else if (relationType.equalsIgnoreCase("W") || relationType.equalsIgnoreCase("WIFE")) {
                                    UpdateDialogFragment.this.binding.tvRelativeType.setText("Wife");
                                } else if (relationType.equalsIgnoreCase("L") || relationType.equalsIgnoreCase("OTHER") || relationType.equalsIgnoreCase("O")) {
                                    UpdateDialogFragment.this.binding.tvRelativeType.setText("Other");
                                } else if (relationType.equalsIgnoreCase("GMTH")) {
                                    UpdateDialogFragment.this.binding.tvRelativeType.setText("Grand Mother");
                                } else if (relationType.equalsIgnoreCase("GFTH")) {
                                    UpdateDialogFragment.this.binding.tvRelativeType.setText("Grand Father");
                                } else {
                                    UpdateDialogFragment.this.binding.tvRelativeType.setText(relationType);
                                }
                            }
                            if (TextUtils.isEmpty(payloadNewMapping.getFullName()) && !TextUtils.isEmpty(payloadNewMapping.getFullNameL1())) {
                                UpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullNameL1()) ? "" : payloadNewMapping.getFullNameL1());
                                UpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                            } else if (TextUtils.isEmpty(payloadNewMapping.getFullNameL1())) {
                                UpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                UpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                            } else if (payloadNewMapping.getFullName().equalsIgnoreCase(payloadNewMapping.getFullNameL1())) {
                                UpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                UpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                            } else {
                                UpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                UpdateDialogFragment.this.binding.tvElectorNamev1.setText(TextUtils.isEmpty(payloadNewMapping.getFullNameL1()) ? "" : payloadNewMapping.getFullNameL1());
                            }
                            if (TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) && !TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1())) {
                                UpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1()) ? "" : payloadNewMapping.getFullRelativeNameL1());
                                UpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                                return;
                            } else if (TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1())) {
                                UpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                UpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                                return;
                            } else if (payloadNewMapping.getFullRelativeName().equalsIgnoreCase(payloadNewMapping.getFullRelativeNameL1())) {
                                UpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                UpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                                return;
                            } else {
                                UpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                UpdateDialogFragment.this.binding.tvRelativeNamev1.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1()) ? "" : payloadNewMapping.getFullRelativeNameL1());
                                return;
                            }
                        }
                        UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.no_active_record));
                        return;
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                UpdateDialogFragment.this.utils.infoDialog(UpdateDialogFragment.this.requireActivity(), UpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    public void getAllOldAc2025(String oldState) {
        this.commomUtility.getAllAC2025(oldState, this.token, this.atkband, this.rtkband, requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.UpdateDialogFragment.38
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    UpdateDialogFragment.this.ACNameList.clear();
                    UpdateDialogFragment.this.ACList.clear();
                    UpdateDialogFragment.this.ACList = acList;
                    UpdateDialogFragment.this.ACNameList = acNameList;
                    if (UpdateDialogFragment.this.partNameList.size() > 0 && UpdateDialogFragment.this.partList.size() > 0) {
                        UpdateDialogFragment.this.partList.clear();
                        UpdateDialogFragment.this.partNameList.clear();
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) UpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) UpdateDialogFragment.this.ACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    UpdateDialogFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                    UpdateDialogFragment.this.binding.oldAcNo.setThreshold(1);
                }
            }
        });
    }
}
