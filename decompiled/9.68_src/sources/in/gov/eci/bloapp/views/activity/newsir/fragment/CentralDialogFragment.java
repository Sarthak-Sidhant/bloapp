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
import androidx.lifecycle.ViewModelProvider;
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
import in.gov.eci.bloapp.databinding.DialogReusableBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.SharedViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.SearchLocationAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ErollDataCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback;
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
public class CentralDialogFragment extends DialogFragment {
    private String acNo;
    SearchLocationAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    private DialogReusableBinding binding;
    private ArrayAdapter<String> districtadapter;
    boolean isOldAcNoEntered;
    boolean isOldPartNoEntered;
    boolean isOldPartSerialNoEntered;
    boolean isoldStateEntered;
    private OnDataReceivedListener listener;
    List<MappingList> newbloMappedList;
    private String partNo;
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
    String is2003Selected = "Y";
    List<PayloadNewMapping> erollPayloads = new ArrayList();

    public interface OnDataReceivedListener {
        void onDataReceived(Payload searchModel, MappingList mappingList, String result3);
    }

    public void setOnDataReceivedListener(OnDataReceivedListener listener) {
        this.listener = listener;
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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        return dialogOnCreateDialog;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = DialogReusableBinding.inflate(getLayoutInflater());
        this.newbloMappedList = new ArrayList();
        if (getArguments() != null) {
            this.is2003Selected = getArguments().getString("key");
        }
        getSessionValue();
        init();
        initializeSpinnerTouch();
        setAdapter();
        if (!TextUtils.isEmpty(this.is2003Selected) && this.is2003Selected.equalsIgnoreCase("N")) {
            this.binding.searchLocationMB.setVisibility(8);
        } else {
            this.binding.searchLocationMB.setVisibility(0);
        }
        selecttab(this.binding.searchAcPartPslMB, this.binding.searchLocationMB);
        handleSearchTabClcicks();
        handleButtonClicks();
        handleSearchByACSpinnerSelection();
        handleSearchByFamilySpinnerSelection();
        return this.binding.getRoot();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$1, reason: invalid class name */
    class AnonymousClass1 implements AdapterView.OnItemClickListener {
        AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            CentralDialogFragment.this.binding.rvMapping.setVisibility(8);
            CentralDialogFragment.this.binding.tvRecordCount.setVisibility(8);
            CentralDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select State")) {
                CentralDialogFragment.this.efState = null;
                CentralDialogFragment.this.efDistrict = null;
                CentralDialogFragment.this.efAc = null;
                CentralDialogFragment.this.OldPart = null;
                CentralDialogFragment.this.EfACNameList.clear();
                CentralDialogFragment.this.EfACList.clear();
                CentralDialogFragment.this.EfACNameList.add(CentralDialogFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                CentralDialogFragment.this.EfACList.add(0);
                CentralDialogFragment.this.district.clear();
                CentralDialogFragment.this.districtcode.clear();
                CentralDialogFragment.this.district.add("Select District");
                CentralDialogFragment.this.districtcode.add("0");
                CentralDialogFragment.this.binding.efDistrictSpinner.setText("");
                CentralDialogFragment.this.partList.clear();
                CentralDialogFragment.this.partNameList.clear();
                CentralDialogFragment.this.partNameList.add(CentralDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                CentralDialogFragment.this.partList.add(0);
                CentralDialogFragment.this.binding.efAcSpinner.setText("");
                CentralDialogFragment.this.binding.efOldPartNo.setText("");
                CentralDialogFragment.this.binding.oldStateSpinner.setText("");
                return;
            }
            String string = parent.getItemAtPosition(i).toString();
            CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
            centralDialogFragment.efState = centralDialogFragment.StateList.get(CentralDialogFragment.this.StateNameList.indexOf(string));
            CentralDialogFragment.this.binding.efAcSpinner.setText("");
            CentralDialogFragment.this.binding.efOldPartNo.setText("");
            CentralDialogFragment.this.binding.efDistrictSpinner.setText("");
            CentralDialogFragment.this.binding.oldStateSpinner.setText("");
            CentralDialogFragment.this.binding.selfName.setText("");
            CentralDialogFragment.this.binding.parentName.setText("");
            CentralDialogFragment.this.binding.grandparentName.setText("");
            CentralDialogFragment.this.efDistrict = null;
            CentralDialogFragment.this.efAc = null;
            CentralDialogFragment.this.OldPart = null;
            CentralDialogFragment centralDialogFragment2 = CentralDialogFragment.this;
            centralDialogFragment2.getAllDistrict(centralDialogFragment2.efState);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
            centralDialogFragment.getallEFAc(centralDialogFragment.efState);
        }
    }

    private void handleSearchByFamilySpinnerSelection() {
        this.binding.efStateSpinner.setOnItemClickListener(new AnonymousClass1());
        this.binding.efDistrictSpinner.setOnItemClickListener(new AnonymousClass2());
        this.binding.efAcSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                CentralDialogFragment.this.binding.rvMapping.setVisibility(8);
                CentralDialogFragment.this.binding.tvRecordCount.setVisibility(8);
                CentralDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Assembly Constituency")) {
                    CentralDialogFragment.this.efAc = null;
                    CentralDialogFragment.this.OldPart = null;
                    CentralDialogFragment.this.partNameList.clear();
                    CentralDialogFragment.this.partList.clear();
                    CentralDialogFragment.this.partNameList.add(CentralDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    CentralDialogFragment.this.partList.add(0);
                    CentralDialogFragment.this.binding.efOldPartNo.setText("");
                    return;
                }
                CentralDialogFragment.this.OldPart = null;
                String string = parent.getItemAtPosition(i).toString();
                CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
                centralDialogFragment.efAc = String.valueOf(centralDialogFragment.EfACList.get(CentralDialogFragment.this.EfACNameList.indexOf(string)));
                CentralDialogFragment.this.binding.selfName.setText("");
                CentralDialogFragment.this.binding.parentName.setText("");
                CentralDialogFragment.this.binding.grandparentName.setText("");
                CentralDialogFragment.this.commomUtility.getPartByAc(CentralDialogFragment.this.requireActivity(), Integer.parseInt(CentralDialogFragment.this.efAc), CentralDialogFragment.this.efState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.3.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                    public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                        if (code == 200) {
                            CentralDialogFragment.this.partList.clear();
                            CentralDialogFragment.this.partNameList.clear();
                            CentralDialogFragment.this.partList = acList;
                            CentralDialogFragment.this.partNameList = acNameList;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) CentralDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) CentralDialogFragment.this.partNameList);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            CentralDialogFragment.this.binding.efOldPartNo.setAdapter(arrayAdapter);
                            CentralDialogFragment.this.binding.efOldPartNo.setThreshold(1);
                        }
                    }
                });
            }
        });
        this.binding.efOldPartNo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                CentralDialogFragment.this.binding.rvMapping.setVisibility(8);
                CentralDialogFragment.this.binding.tvRecordCount.setVisibility(8);
                CentralDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Part")) {
                    CentralDialogFragment.this.OldPart = null;
                    return;
                }
                String string = parent.getItemAtPosition(i).toString();
                CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
                centralDialogFragment.OldPart = String.valueOf(centralDialogFragment.partList.get(CentralDialogFragment.this.partNameList.indexOf(string)));
            }
        });
        this.binding.selfName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                CentralDialogFragment.this.binding.rvMapping.setVisibility(8);
                CentralDialogFragment.this.binding.tvRecordCount.setVisibility(8);
                CentralDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            }
        });
        this.binding.parentName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                CentralDialogFragment.this.binding.rvMapping.setVisibility(8);
                CentralDialogFragment.this.binding.tvRecordCount.setVisibility(8);
                CentralDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$2, reason: invalid class name */
    class AnonymousClass2 implements AdapterView.OnItemClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            CentralDialogFragment.this.binding.rvMapping.setVisibility(8);
            CentralDialogFragment.this.binding.tvRecordCount.setVisibility(8);
            CentralDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select District")) {
                CentralDialogFragment.this.efDistrict = null;
                CentralDialogFragment.this.efAc = null;
                CentralDialogFragment.this.binding.efAcSpinner.setText("");
                CentralDialogFragment.this.binding.efOldPartNo.setText("");
                if (CentralDialogFragment.this.EfACList.size() > 0) {
                    CentralDialogFragment.this.EfACNameList.clear();
                    CentralDialogFragment.this.EfACList.clear();
                }
                CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
                centralDialogFragment.getallEFAc(centralDialogFragment.efState);
                return;
            }
            CentralDialogFragment.this.efAc = null;
            CentralDialogFragment.this.OldPart = null;
            if (!TextUtils.isEmpty(CentralDialogFragment.this.efState) && CentralDialogFragment.this.efState.equalsIgnoreCase("S02")) {
                CentralDialogFragment centralDialogFragment2 = CentralDialogFragment.this;
                centralDialogFragment2.efDistrict = (String) centralDialogFragment2.districtcode.get(i);
            } else {
                String str = (String) CentralDialogFragment.this.district.get(CentralDialogFragment.this.district.indexOf(parent.getItemAtPosition(i).toString()));
                int iIndexOf = CentralDialogFragment.this.district.indexOf(str);
                Log.d("CheckEffff : ", iIndexOf + StringUtils.SPACE + str);
                CentralDialogFragment centralDialogFragment3 = CentralDialogFragment.this;
                centralDialogFragment3.efDistrict = (String) centralDialogFragment3.districtcode.get(iIndexOf);
            }
            CentralDialogFragment.this.binding.efAcSpinner.setText("");
            CentralDialogFragment.this.binding.efOldPartNo.setText("");
            CentralDialogFragment.this.binding.selfName.setText("");
            CentralDialogFragment.this.binding.parentName.setText("");
            CentralDialogFragment.this.binding.grandparentName.setText("");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            CentralDialogFragment.this.commomUtility.getAssmblyByDist(CentralDialogFragment.this.requireActivity(), Integer.parseInt(CentralDialogFragment.this.efDistrict), CentralDialogFragment.this.efState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.2.1
                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                    if (code == 200) {
                        if (CentralDialogFragment.this.partList.size() > 0 && CentralDialogFragment.this.partNameList.size() > 0) {
                            CentralDialogFragment.this.partList.clear();
                            CentralDialogFragment.this.partNameList.clear();
                        }
                        CentralDialogFragment.this.EfACNameList.clear();
                        CentralDialogFragment.this.EfACList.clear();
                        CentralDialogFragment.this.EfACList = acList;
                        CentralDialogFragment.this.EfACNameList = acNameList;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) CentralDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) CentralDialogFragment.this.EfACNameList);
                        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        CentralDialogFragment.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                        CentralDialogFragment.this.binding.efAcSpinner.setThreshold(1);
                    }
                }
            });
        }
    }

    private void handleSearchByACSpinnerSelection() {
        this.binding.oldStateSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                CentralDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select State")) {
                    CentralDialogFragment.this.isoldStateEntered = false;
                    CentralDialogFragment.this.oldState = null;
                    CentralDialogFragment.this.oldAc = null;
                    CentralDialogFragment.this.OldPart = null;
                    CentralDialogFragment.this.oldDistrict = null;
                    CentralDialogFragment.this.partList.clear();
                    CentralDialogFragment.this.partNameList.clear();
                    CentralDialogFragment.this.ACNameList.clear();
                    CentralDialogFragment.this.ACList.clear();
                    CentralDialogFragment.this.ACNameList.add(CentralDialogFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    CentralDialogFragment.this.ACList.add(0);
                    CentralDialogFragment.this.partNameList.add(CentralDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    CentralDialogFragment.this.partList.add(0);
                    CentralDialogFragment.this.binding.oldAcNo.setText("");
                    CentralDialogFragment.this.binding.oldPartNo.setText("");
                    CentralDialogFragment.this.binding.oldDistrictSpinner.setText("");
                    CentralDialogFragment.this.binding.oldPslNo.setText("");
                    CentralDialogFragment.this.isUserSelected = false;
                    CentralDialogFragment.this.district.clear();
                    CentralDialogFragment.this.districtcode.clear();
                    CentralDialogFragment.this.district.add("Select District");
                    CentralDialogFragment.this.districtcode.add("0");
                    CentralDialogFragment.this.binding.oldDistrictSpinner.setText("");
                    return;
                }
                CentralDialogFragment.this.oldAc = null;
                CentralDialogFragment.this.OldPart = null;
                CentralDialogFragment.this.oldDistrict = null;
                CentralDialogFragment.this.isoldStateEntered = true;
                CentralDialogFragment.this.binding.oldAcNo.setText("");
                CentralDialogFragment.this.binding.oldPartNo.setText("");
                CentralDialogFragment.this.binding.oldDistrictSpinner.setText("");
                CentralDialogFragment.this.binding.oldPslNo.setText("");
                String string = parent.getItemAtPosition(i).toString();
                CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
                centralDialogFragment.oldState = centralDialogFragment.StateList.get(CentralDialogFragment.this.StateNameList.indexOf(string));
                CentralDialogFragment centralDialogFragment2 = CentralDialogFragment.this;
                centralDialogFragment2.oldStateName = centralDialogFragment2.StateNameList.get(CentralDialogFragment.this.StateNameList.indexOf(string));
                if (CentralDialogFragment.this.isUserSelected) {
                    CentralDialogFragment.this.isUserSelected = false;
                    CentralDialogFragment.this.binding.oldPartNo.setText("");
                    CentralDialogFragment.this.binding.oldPslNo.setText("");
                }
                CentralDialogFragment centralDialogFragment3 = CentralDialogFragment.this;
                centralDialogFragment3.getAllDistrict(centralDialogFragment3.oldState);
                if (!TextUtils.isEmpty(CentralDialogFragment.this.is2003Selected) && CentralDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                    CentralDialogFragment centralDialogFragment4 = CentralDialogFragment.this;
                    centralDialogFragment4.getAllOldAc2025(centralDialogFragment4.oldState);
                } else {
                    CentralDialogFragment centralDialogFragment5 = CentralDialogFragment.this;
                    centralDialogFragment5.getAllOldAc(centralDialogFragment5.oldState);
                }
            }
        });
        this.binding.oldDistrictSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                int i2;
                CentralDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select District")) {
                    CentralDialogFragment.this.oldAc = null;
                    CentralDialogFragment.this.OldPart = null;
                    CentralDialogFragment.this.oldDistrict = null;
                    CentralDialogFragment.this.partList.clear();
                    CentralDialogFragment.this.partNameList.clear();
                    CentralDialogFragment.this.ACNameList.clear();
                    CentralDialogFragment.this.ACList.clear();
                    CentralDialogFragment.this.ACNameList.add(CentralDialogFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    CentralDialogFragment.this.ACList.add(0);
                    CentralDialogFragment.this.partNameList.add(CentralDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    CentralDialogFragment.this.partList.add(0);
                    CentralDialogFragment.this.binding.oldAcNo.setText("");
                    CentralDialogFragment.this.binding.oldPartNo.setText("");
                    CentralDialogFragment.this.binding.oldPslNo.setText("");
                    if (CentralDialogFragment.this.ACList.size() > 0) {
                        CentralDialogFragment.this.ACList.clear();
                        CentralDialogFragment.this.ACNameList.clear();
                    }
                    if (!TextUtils.isEmpty(CentralDialogFragment.this.is2003Selected) && CentralDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                        CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
                        centralDialogFragment.getAllOldAc2025(centralDialogFragment.oldState);
                        return;
                    } else {
                        CentralDialogFragment centralDialogFragment2 = CentralDialogFragment.this;
                        centralDialogFragment2.getAllOldAc(centralDialogFragment2.oldState);
                        return;
                    }
                }
                CentralDialogFragment.this.oldAc = null;
                CentralDialogFragment.this.OldPart = null;
                CentralDialogFragment.this.binding.oldPslNo.setText("");
                if (!TextUtils.isEmpty(CentralDialogFragment.this.oldState) && CentralDialogFragment.this.oldState.equalsIgnoreCase("S02")) {
                    CentralDialogFragment centralDialogFragment3 = CentralDialogFragment.this;
                    centralDialogFragment3.oldDistrict = (String) centralDialogFragment3.district.get(i);
                    i2 = Integer.parseInt((String) CentralDialogFragment.this.districtcode.get(i));
                } else {
                    int iIndexOf = CentralDialogFragment.this.district.indexOf((String) CentralDialogFragment.this.district.get(CentralDialogFragment.this.district.indexOf(parent.getItemAtPosition(i).toString())));
                    CentralDialogFragment centralDialogFragment4 = CentralDialogFragment.this;
                    centralDialogFragment4.oldDistrict = (String) centralDialogFragment4.district.get(iIndexOf);
                    i2 = Integer.parseInt((String) CentralDialogFragment.this.districtcode.get(iIndexOf));
                }
                CentralDialogFragment.this.binding.oldAcNo.setText("");
                CentralDialogFragment.this.binding.oldPartNo.setText("");
                CentralDialogFragment.this.binding.oldPslNo.setText("");
                if (TextUtils.isEmpty(CentralDialogFragment.this.is2003Selected) || !CentralDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                    CentralDialogFragment.this.commomUtility.getAssmblyByDist(CentralDialogFragment.this.requireActivity(), i2, CentralDialogFragment.this.oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.8.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                        public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                            if (code == 200) {
                                CentralDialogFragment.this.ACNameList.clear();
                                CentralDialogFragment.this.ACList.clear();
                                CentralDialogFragment.this.ACList = acList;
                                CentralDialogFragment.this.ACNameList = acNameList;
                                if (CentralDialogFragment.this.partNameList.size() > 0 && CentralDialogFragment.this.partList.size() > 0) {
                                    CentralDialogFragment.this.partList.clear();
                                    CentralDialogFragment.this.partNameList.clear();
                                }
                                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) CentralDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) CentralDialogFragment.this.ACNameList);
                                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                                CentralDialogFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                                CentralDialogFragment.this.binding.oldAcNo.setThreshold(1);
                            }
                        }
                    });
                }
            }
        });
        this.binding.oldAcNo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                CentralDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Assembly Constituency")) {
                    CentralDialogFragment.this.isOldAcNoEntered = false;
                    CentralDialogFragment.this.oldAc = null;
                    CentralDialogFragment.this.OldPart = null;
                    CentralDialogFragment.this.partList.clear();
                    CentralDialogFragment.this.partNameList.clear();
                    CentralDialogFragment.this.partNameList.add(CentralDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    CentralDialogFragment.this.partList.add(0);
                    CentralDialogFragment.this.binding.oldPartNo.setText("");
                    CentralDialogFragment.this.binding.oldPartNo.setText("");
                    CentralDialogFragment.this.binding.oldPslNo.setText("");
                    CentralDialogFragment.this.isUserSelected = false;
                    return;
                }
                CentralDialogFragment.this.OldPart = null;
                CentralDialogFragment.this.isOldAcNoEntered = true;
                CentralDialogFragment.this.binding.oldPartNo.setText("");
                CentralDialogFragment.this.binding.oldPslNo.setText("");
                String string = parent.getItemAtPosition(i).toString();
                CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
                centralDialogFragment.oldAc = String.valueOf(centralDialogFragment.ACList.get(CentralDialogFragment.this.ACNameList.indexOf(string)));
                if (!TextUtils.isEmpty(CentralDialogFragment.this.is2003Selected) && CentralDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                    CentralDialogFragment.this.commomUtility.getPartByAc2025(CentralDialogFragment.this.requireActivity(), Integer.parseInt(CentralDialogFragment.this.oldAc), CentralDialogFragment.this.oldState, CentralDialogFragment.this.token, CentralDialogFragment.this.atkband, CentralDialogFragment.this.rtkband, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.9.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                        public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                            if (code == 200) {
                                CentralDialogFragment.this.partList.clear();
                                CentralDialogFragment.this.partNameList.clear();
                                CentralDialogFragment.this.partList = acList;
                                CentralDialogFragment.this.partNameList = acNameList;
                                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) CentralDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) CentralDialogFragment.this.partNameList);
                                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                                CentralDialogFragment.this.binding.oldPartNo.setAdapter(arrayAdapter);
                                CentralDialogFragment.this.binding.oldPartNo.setThreshold(1);
                            }
                        }
                    });
                } else {
                    CentralDialogFragment.this.commomUtility.getPartByAc(CentralDialogFragment.this.requireActivity(), Integer.parseInt(CentralDialogFragment.this.oldAc), CentralDialogFragment.this.oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.9.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                        public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                            if (code == 200) {
                                CentralDialogFragment.this.partList.clear();
                                CentralDialogFragment.this.partNameList.clear();
                                CentralDialogFragment.this.partList = acList;
                                CentralDialogFragment.this.partNameList = acNameList;
                                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) CentralDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) CentralDialogFragment.this.partNameList);
                                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                                CentralDialogFragment.this.binding.oldPartNo.setAdapter(arrayAdapter);
                                CentralDialogFragment.this.binding.oldPartNo.setThreshold(1);
                            }
                        }
                    });
                }
                if (CentralDialogFragment.this.isUserSelected) {
                    CentralDialogFragment.this.isUserSelected = false;
                }
            }
        });
        this.binding.oldPartNo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                CentralDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Part")) {
                    CentralDialogFragment.this.isOldPartNoEntered = false;
                    CentralDialogFragment.this.OldPart = null;
                    CentralDialogFragment.this.binding.oldPslNo.setText("");
                    CentralDialogFragment.this.isUserSelected = false;
                    return;
                }
                CentralDialogFragment.this.isOldPartNoEntered = true;
                String string = parent.getItemAtPosition(i).toString();
                CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
                centralDialogFragment.OldPart = String.valueOf(centralDialogFragment.partList.get(CentralDialogFragment.this.partNameList.indexOf(string)));
                if (CentralDialogFragment.this.isUserSelected) {
                    CentralDialogFragment.this.isUserSelected = false;
                }
            }
        });
        this.binding.oldPslNo.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.11
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                CentralDialogFragment.this.binding.cardDisabled.setVisibility(8);
            }
        });
    }

    private void handleButtonClicks() {
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CentralDialogFragment.this.utils.validateState_Ac_Part_Serial(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.oldState, CentralDialogFragment.this.oldDistrict, CentralDialogFragment.this.oldAc, CentralDialogFragment.this.OldPart, CentralDialogFragment.this.binding.oldPslNo.getText().toString().trim(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.12.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                    public void onResult(boolean isValidate) {
                        if (!TextUtils.isEmpty(CentralDialogFragment.this.is2003Selected) && CentralDialogFragment.this.is2003Selected.equalsIgnoreCase("Y")) {
                            if (CentralDialogFragment.this.payloads.size() > 0) {
                                CentralDialogFragment.this.payloads.clear();
                            }
                            CentralDialogFragment.this.searchDetails();
                        } else {
                            if (TextUtils.isEmpty(CentralDialogFragment.this.is2003Selected) || !CentralDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                                return;
                            }
                            if (CentralDialogFragment.this.erollPayloads.size() > 0) {
                                CentralDialogFragment.this.erollPayloads.clear();
                            }
                            CentralDialogFragment.this.ErollDataDetails();
                        }
                    }
                });
            }
        });
        this.binding.submitButtonBlo.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleButtonClicks$0(view);
            }
        });
        this.binding.speakSerial.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CentralDialogFragment.this.utils.showVoicePopup(CentralDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.15.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        CentralDialogFragment.this.binding.oldPslNo.setText(result);
                    }
                });
            }
        });
        this.binding.speakSelf.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CentralDialogFragment.this.utils.showVoicePopup(CentralDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.16.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        CentralDialogFragment.this.binding.selfName.setText(result);
                    }
                });
            }
        });
        this.binding.speakParent.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CentralDialogFragment.this.utils.showVoicePopup(CentralDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.17.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        CentralDialogFragment.this.binding.parentName.setText(result);
                    }
                });
            }
        });
        this.binding.speakGrandparent.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CentralDialogFragment.this.utils.showVoicePopup(CentralDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.18.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        CentralDialogFragment.this.binding.grandparentName.setText(result);
                    }
                });
            }
        });
        this.binding.searchButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleButtonClicks$1(view);
            }
        });
        this.binding.ivCancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CentralDialogFragment.this.utils.decisionDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.confirm_to_close), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.blo_yes), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.blo_No), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.20.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onNegativeButtonClicked() {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onPositiveButtonClicked() {
                        CentralDialogFragment.this.sentselfSearchData(null, null, null);
                    }
                });
            }
        });
        this.binding.layoutVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                for (final MappingList mappingList : CentralDialogFragment.this.newbloMappedList) {
                    if (mappingList.isSelected()) {
                        CentralDialogFragment.this.utils.validateProgenyDetails(CentralDialogFragment.this.requireActivity(), mappingList.getOldStateCd(), String.valueOf(mappingList.getOldAcNo()), String.valueOf(mappingList.getOldPartNumber()), String.valueOf(mappingList.getOldPartSerialNo()), CentralDialogFragment.this.sharedViewModel.getElectorname(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.21.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                            public void onResult(boolean isValidate) {
                                if (isValidate) {
                                    CentralDialogFragment.this.sentselfSearchData(null, mappingList, CentralDialogFragment.this.is2003Selected);
                                }
                            }
                        });
                        return;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleButtonClicks$0(View view) {
        String str;
        String str2;
        String str3;
        String strValueOf;
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
            this.utils.validateProgenyDetails(requireActivity(), payloadNewMapping.getStateCd(), String.valueOf(payloadNewMapping.getAcNo()), String.valueOf(payloadNewMapping.getPartNo()), String.valueOf(payloadNewMapping.getSerialNo()), this.sharedViewModel.getElectorname(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.13
                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                public void onResult(boolean isValidate) {
                    if (isValidate) {
                        CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
                        centralDialogFragment.sentselfSearchData(payload, null, centralDialogFragment.is2003Selected);
                    }
                }
            });
            return;
        }
        if (this.payloads.size() > 0) {
            String oldStateCd = this.payloads.get(0).getOldStateCd();
            String strValueOf2 = String.valueOf(this.payloads.get(0).getOldAcNo());
            String strValueOf3 = String.valueOf(this.payloads.get(0).getOldPartNumber());
            strValueOf = String.valueOf(this.payloads.get(0).getOldPartSerialNo());
            str2 = strValueOf2;
            str3 = strValueOf3;
            str = oldStateCd;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            strValueOf = null;
        }
        this.utils.validateProgenyDetails(requireActivity(), str, str2, str3, strValueOf, this.sharedViewModel.getElectorname(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.14
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
            public void onResult(boolean isValidate) {
                if (isValidate) {
                    CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
                    centralDialogFragment.sentselfSearchData(centralDialogFragment.payloads.get(0), null, CentralDialogFragment.this.is2003Selected);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleButtonClicks$1(View view) {
        this.utils.validateState_Ac_Family(requireActivity(), this.efState, this.efAc, this.binding.selfName.getText().toString().trim(), this.binding.parentName.getText().toString().trim(), this.binding.grandparentName.getText().toString().trim(), this.efDistrict, this.OldPart, "", new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.19
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
            public void onResult(boolean isValidate) {
                if (isValidate) {
                    CentralDialogFragment.this.callLocationApi();
                }
            }
        });
    }

    private void handleSearchTabClcicks() {
        this.binding.searchAcPartPslMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$3(view);
            }
        });
        this.binding.searchLocationMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$5(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$3(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda4
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
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda7
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
            this.StateNameList.removeIf(new Predicate() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CentralDialogFragment.lambda$setAdapter$6(arrayList, (String) obj);
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
            this.StateList.removeIf(new Predicate() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CentralDialogFragment.lambda$setAdapter$7(arrayList2, (String) obj);
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
        this.binding.oldStateSpinner.setThreshold(1);
        this.binding.efStateSpinner.setThreshold(1);
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
        this.sharedViewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.searchCV.setVisibility(8);
        this.binding.searchAcCV.setVisibility(8);
        this.binding.searchByLocationCv.setVisibility(8);
        this.binding.chooseRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.22
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (CentralDialogFragment.this.binding.rb2003.isChecked()) {
                    CentralDialogFragment.this.is2003Selected = "Y";
                    CentralDialogFragment.this.clearACVariables();
                    CentralDialogFragment.this.setAdapter();
                    CentralDialogFragment.this.binding.searchByLocationDetailsLl.setVisibility(0);
                    CentralDialogFragment.this.binding.searchLocationMB.setVisibility(0);
                    CentralDialogFragment centralDialogFragment = CentralDialogFragment.this;
                    centralDialogFragment.selecttab(centralDialogFragment.binding.searchAcPartPslMB, CentralDialogFragment.this.binding.searchLocationMB);
                    CentralDialogFragment.this.binding.searchCV.setVisibility(0);
                    CentralDialogFragment.this.binding.searchAcCV.setVisibility(0);
                    CentralDialogFragment.this.binding.searchByLocationCv.setVisibility(8);
                    CentralDialogFragment.this.binding.searchByAcDetailsLl.setVisibility(0);
                }
                if (CentralDialogFragment.this.binding.rb2025.isChecked()) {
                    CentralDialogFragment.this.is2003Selected = "N";
                    CentralDialogFragment.this.clearACVariables();
                    CentralDialogFragment.this.setAdapter();
                    CentralDialogFragment.this.binding.searchByLocationDetailsLl.setVisibility(8);
                    CentralDialogFragment.this.binding.searchLocationMB.setVisibility(8);
                    CentralDialogFragment centralDialogFragment2 = CentralDialogFragment.this;
                    centralDialogFragment2.selecttab(centralDialogFragment2.binding.searchAcPartPslMB, CentralDialogFragment.this.binding.searchLocationMB);
                    CentralDialogFragment.this.binding.searchCV.setVisibility(0);
                    CentralDialogFragment.this.binding.searchAcCV.setVisibility(0);
                    CentralDialogFragment.this.binding.searchByLocationCv.setVisibility(8);
                    CentralDialogFragment.this.binding.searchByAcDetailsLl.setVisibility(0);
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
    public void sentselfSearchData(Payload serchModel, MappingList mappingList, String is2003Selected) {
        if (this.listener != null) {
            dismiss();
            this.listener.onDataReceived(serchModel, mappingList, is2003Selected);
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
    }

    private void initializeSpinnerTouch() {
        this.binding.oldStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.23
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                CentralDialogFragment.this.binding.oldStateSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.24
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                CentralDialogFragment.this.binding.efStateSpinner.showDropDown();
                return false;
            }
        });
        this.binding.oldDistrictSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                CentralDialogFragment.this.binding.oldDistrictSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efDistrictSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.26
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                CentralDialogFragment.this.binding.efDistrictSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efAcSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.27
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                CentralDialogFragment.this.binding.efAcSpinner.showDropDown();
                return false;
            }
        });
        this.binding.oldAcNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                CentralDialogFragment.this.binding.oldAcNo.showDropDown();
                return false;
            }
        });
        this.binding.oldPartNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                CentralDialogFragment.this.binding.oldPartNo.showDropDown();
                return false;
            }
        });
        this.binding.efOldPartNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.30
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                CentralDialogFragment.this.binding.efOldPartNo.showDropDown();
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
        map2.put("relativeName", this.binding.parentName.getText().toString());
        map2.put("grandParentName", this.binding.grandparentName.getText().toString());
        map2.put("stateCd", this.efState);
        map2.put("mappingType", "progeny");
        map2.put("districtNo", this.efDistrict);
        map2.put("acNo", this.efAc);
        map2.put("partNo", this.OldPart);
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
        searchLocationFamily.enqueue(new AnonymousClass31());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$31, reason: invalid class name */
    class AnonymousClass31 implements Callback<LocationRoot> {
        AnonymousClass31() {
        }

        public void onResponse(Call<LocationRoot> call, Response<LocationRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    CentralDialogFragment.this.newbloMappedList = ((LocationRoot) response.body()).payload.mappingList;
                    if (CentralDialogFragment.this.newbloMappedList.size() > 0) {
                        Logger.d("blo list size", "" + CentralDialogFragment.this.newbloMappedList.size());
                        CentralDialogFragment.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(CentralDialogFragment.this.requireActivity()));
                        if (CentralDialogFragment.this.newbloMappedList != null && !CentralDialogFragment.this.newbloMappedList.isEmpty()) {
                            CentralDialogFragment.this.binding.rvMapping.setVisibility(0);
                            CentralDialogFragment.this.binding.tvRecordCount.setVisibility(0);
                            CentralDialogFragment.this.binding.tvRecordCount.setText(CentralDialogFragment.this.requireActivity().getResources().getString(R.string.total_record) + StringUtils.SPACE + CentralDialogFragment.this.newbloMappedList.size());
                            CentralDialogFragment.this.adapter = new SearchLocationAdapter(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.newbloMappedList, new SearchLocationAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$31$$ExternalSyntheticLambda0
                                @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.SearchLocationAdapter.OnItemSelectedListener
                                public final void onItemSelected() {
                                    this.f$0.lambda$onResponse$0();
                                }
                            });
                            CentralDialogFragment.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(CentralDialogFragment.this.getContext()));
                            CentralDialogFragment.this.binding.rvMapping.setNestedScrollingEnabled(false);
                            CentralDialogFragment.this.binding.rvMapping.setAdapter(CentralDialogFragment.this.adapter);
                        }
                    } else {
                        new Utils().infoDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.no_data_found));
                    }
                } catch (Exception unused) {
                }
                CentralDialogFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                if (CentralDialogFragment.this.alertDialog != null) {
                    CentralDialogFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            try {
                if (CentralDialogFragment.this.alertDialog != null) {
                    CentralDialogFragment.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                if (TextUtils.isEmpty(strOptString)) {
                    CentralDialogFragment.this.utils.infoDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), jSONObject.optString("error"));
                } else {
                    CentralDialogFragment.this.utils.infoDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), strOptString);
                }
                Logger.e("TAG", strOptString);
                if (CentralDialogFragment.this.alertDialog != null) {
                    CentralDialogFragment.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (CentralDialogFragment.this.alertDialog != null) {
                    CentralDialogFragment.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            CentralDialogFragment.this.binding.layoutVerifyButton.setVisibility(0);
        }

        public void onFailure(Call<LocationRoot> call, Throwable t) {
            if (CentralDialogFragment.this.alertDialog != null) {
                CentralDialogFragment.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchDetails() {
        this.commomUtility.callVerifyRelativeApi(requireActivity(), this.token, this.atkband, this.rtkband, this.oldState, this.oldAc, this.OldPart, this.binding.oldPslNo.getText().toString().trim(), new SearchByAcPartCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.32
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback
            public void onCallBack(int code, List<Payload> datalist, String message) {
                if (code == 200) {
                    if (datalist != null && datalist.size() > 0) {
                        CentralDialogFragment.this.payloads = datalist;
                        if (datalist.size() > 1) {
                            CentralDialogFragment.this.utils.infoDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.multiple_record));
                            return;
                        }
                        Payload payload = datalist.get(0);
                        CentralDialogFragment.this.binding.tvStateName.setText(CentralDialogFragment.this.oldStateName);
                        CentralDialogFragment.this.binding.tvDistrictName.setText(String.valueOf(payload.getOldDistNo()) + " - " + (TextUtils.isEmpty(payload.getOldDistName()) ? "" : payload.getOldDistName()));
                        CentralDialogFragment.this.binding.tvAcName.setText(String.valueOf(payload.getOldAcNo()) + "  -  " + (TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName()));
                        CentralDialogFragment.this.binding.tvPartName.setText(String.valueOf(payload.getOldPartNumber()) + "  -  " + (TextUtils.isEmpty(payload.getOldPartName()) ? "" : payload.getOldPartName()));
                        CentralDialogFragment.this.binding.tvSerialName.setText(CentralDialogFragment.this.binding.oldPslNo.getText().toString());
                        CentralDialogFragment.this.binding.tvSectionNo.setText("");
                        CentralDialogFragment.this.binding.tvOldAge.setText(String.valueOf(payload.getAge()));
                        CentralDialogFragment.this.binding.tvOldEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                        TextUtils.isEmpty(payload.getEpicNumber());
                        CentralDialogFragment.this.binding.cardDisabled.setVisibility(0);
                        if (!TextUtils.isEmpty(payload.getRelationType())) {
                            String relationType = payload.getRelationType();
                            if (relationType.equalsIgnoreCase("F") || relationType.equalsIgnoreCase("FATHER") || relationType.equalsIgnoreCase("FTHR")) {
                                CentralDialogFragment.this.binding.tvRelativeType.setText("Father");
                            } else if (relationType.equalsIgnoreCase("M") || relationType.equalsIgnoreCase("MOTHER") || relationType.equalsIgnoreCase("MTHR")) {
                                CentralDialogFragment.this.binding.tvRelativeType.setText("Mother");
                            } else if (relationType.equalsIgnoreCase("H") || relationType.equalsIgnoreCase("HUSBAND") || relationType.equalsIgnoreCase("HSBN")) {
                                CentralDialogFragment.this.binding.tvRelativeType.setText("Husband");
                            } else if (relationType.equalsIgnoreCase("W") || relationType.equalsIgnoreCase("WIFE")) {
                                CentralDialogFragment.this.binding.tvRelativeType.setText("Wife");
                            } else if (relationType.equalsIgnoreCase("L") || relationType.equalsIgnoreCase("OTHER") || relationType.equalsIgnoreCase("O")) {
                                CentralDialogFragment.this.binding.tvRelativeType.setText("Other");
                            } else if (relationType.equalsIgnoreCase("GMTH")) {
                                CentralDialogFragment.this.binding.tvRelativeType.setText("Grand Mother");
                            } else if (relationType.equalsIgnoreCase("GFTH")) {
                                CentralDialogFragment.this.binding.tvRelativeType.setText("Grand Father");
                            } else {
                                CentralDialogFragment.this.binding.tvRelativeType.setText(relationType);
                            }
                        }
                        if (TextUtils.isEmpty(payload.getOldFullName()) && !TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            CentralDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                            CentralDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                        } else if (TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            CentralDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            CentralDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                        } else if (payload.getOldFullName().equalsIgnoreCase(payload.getOldFullNameL1())) {
                            CentralDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            CentralDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                        } else {
                            CentralDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            CentralDialogFragment.this.binding.tvElectorNamev1.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                        }
                        if (TextUtils.isEmpty(payload.getOldRelativeFullName()) && !TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            CentralDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            CentralDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else if (TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            CentralDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            CentralDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else if (payload.getOldRelativeFullName().equalsIgnoreCase(payload.getOldRelativeFullNameL1())) {
                            CentralDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            CentralDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else {
                            CentralDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            CentralDialogFragment.this.binding.tvRelativeNamev1.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    CentralDialogFragment.this.utils.infoDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                CentralDialogFragment.this.utils.infoDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    public void getAllDistrict(final String oldState) {
        this.commomUtility.getSirDistrict(oldState, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda11
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllDistrict$11(oldState, i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllDistrict$11(final String str, int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda8
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
        this.binding.oldDistrictSpinner.setThreshold(1);
        this.binding.efDistrictSpinner.setAdapter(this.districtadapter);
        this.binding.efDistrictSpinner.setThreshold(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllDistrict$10(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda0
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
        this.commomUtility.getSirDistrict(str, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment$$ExternalSyntheticLambda3
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
        this.binding.oldDistrictSpinner.setThreshold(1);
        this.binding.efDistrictSpinner.setAdapter(this.districtadapter);
        this.binding.efDistrictSpinner.setThreshold(1);
    }

    public void getAllOldAc(String oldState) {
        this.commomUtility.getAllAC(oldState, requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.33
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    CentralDialogFragment.this.ACNameList.clear();
                    CentralDialogFragment.this.ACList.clear();
                    CentralDialogFragment.this.ACList = acList;
                    CentralDialogFragment.this.ACNameList = acNameList;
                    if (CentralDialogFragment.this.partNameList.size() > 0 && CentralDialogFragment.this.partList.size() > 0) {
                        CentralDialogFragment.this.partList.clear();
                        CentralDialogFragment.this.partNameList.clear();
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) CentralDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) CentralDialogFragment.this.ACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    CentralDialogFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                    CentralDialogFragment.this.binding.oldAcNo.setThreshold(1);
                }
            }
        });
    }

    public void getallEFAc(String efState) {
        this.commomUtility.getAllAC(efState, requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.34
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    CentralDialogFragment.this.EfACNameList.clear();
                    CentralDialogFragment.this.EfACList.clear();
                    CentralDialogFragment.this.EfACList = acList;
                    CentralDialogFragment.this.EfACNameList = acNameList;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) CentralDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) CentralDialogFragment.this.EfACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    CentralDialogFragment.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                    CentralDialogFragment.this.binding.efAcSpinner.setThreshold(1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ErollDataDetails() {
        this.commomUtility.callErollData(requireActivity(), this.token, this.atkband, this.rtkband, this.oldState, this.oldAc, this.OldPart, this.binding.oldPslNo.getText().toString().trim(), new ErollDataCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.35
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ErollDataCallback
            public void onCallBack(int code, List<PayloadNewMapping> datalist, String message) {
                if (code == 200) {
                    if (datalist != null && datalist.size() > 0) {
                        CentralDialogFragment.this.erollPayloads = datalist;
                        if (datalist.size() > 1) {
                            CentralDialogFragment.this.utils.infoDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.multiple_record));
                            return;
                        }
                        PayloadNewMapping payloadNewMapping = datalist.get(0);
                        if (!TextUtils.isEmpty(payloadNewMapping.getIsActive()) && payloadNewMapping.getIsActive().equalsIgnoreCase(BooleanUtils.TRUE)) {
                            if (!TextUtils.isEmpty(payloadNewMapping.getUnderJo()) && payloadNewMapping.getUnderJo().equalsIgnoreCase("1")) {
                                CentralDialogFragment.this.utils.infoDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), "The applicant is under Adjudication.");
                                return;
                            }
                            CentralDialogFragment.this.binding.tvStateName.setText(CentralDialogFragment.this.oldStateName);
                            CentralDialogFragment.this.binding.tvDistrictName.setText(String.valueOf(payloadNewMapping.getDistrictNo()) + " - " + (TextUtils.isEmpty(payloadNewMapping.getDistrictNo()) ? "" : payloadNewMapping.getDistrictName()));
                            CentralDialogFragment.this.binding.tvAcName.setText(String.valueOf(payloadNewMapping.getAcNo()) + "  -  " + (TextUtils.isEmpty(payloadNewMapping.getAcName()) ? "" : payloadNewMapping.getAcName()));
                            CentralDialogFragment.this.binding.tvPartName.setText(String.valueOf(payloadNewMapping.getPartNo()) + "  -  " + (TextUtils.isEmpty(payloadNewMapping.getPartName()) ? "" : payloadNewMapping.getPartName()));
                            CentralDialogFragment.this.binding.tvSerialName.setText(CentralDialogFragment.this.binding.oldPslNo.getText().toString());
                            CentralDialogFragment.this.binding.tvSectionNo.setText("");
                            CentralDialogFragment.this.binding.tvOldAge.setText(String.valueOf(payloadNewMapping.getAge()));
                            CentralDialogFragment.this.binding.tvOldEpic.setText(TextUtils.isEmpty(payloadNewMapping.getEpicNumber()) ? "" : payloadNewMapping.getEpicNumber());
                            TextUtils.isEmpty(payloadNewMapping.getEpicNumber());
                            CentralDialogFragment.this.binding.cardDisabled.setVisibility(0);
                            if (!TextUtils.isEmpty(payloadNewMapping.getRelationType())) {
                                String relationType = payloadNewMapping.getRelationType();
                                if (relationType.equalsIgnoreCase("F") || relationType.equalsIgnoreCase("FATHER") || relationType.equalsIgnoreCase("FTHR")) {
                                    CentralDialogFragment.this.binding.tvRelativeType.setText("Father");
                                } else if (relationType.equalsIgnoreCase("M") || relationType.equalsIgnoreCase("MOTHER") || relationType.equalsIgnoreCase("MTHR")) {
                                    CentralDialogFragment.this.binding.tvRelativeType.setText("Mother");
                                } else if (relationType.equalsIgnoreCase("H") || relationType.equalsIgnoreCase("HUSBAND") || relationType.equalsIgnoreCase("HSBN")) {
                                    CentralDialogFragment.this.binding.tvRelativeType.setText("Husband");
                                } else if (relationType.equalsIgnoreCase("W") || relationType.equalsIgnoreCase("WIFE")) {
                                    CentralDialogFragment.this.binding.tvRelativeType.setText("Wife");
                                } else if (relationType.equalsIgnoreCase("L") || relationType.equalsIgnoreCase("OTHER") || relationType.equalsIgnoreCase("O")) {
                                    CentralDialogFragment.this.binding.tvRelativeType.setText("Other");
                                } else if (relationType.equalsIgnoreCase("GMTH")) {
                                    CentralDialogFragment.this.binding.tvRelativeType.setText("Grand Mother");
                                } else if (relationType.equalsIgnoreCase("GFTH")) {
                                    CentralDialogFragment.this.binding.tvRelativeType.setText("Grand Father");
                                } else {
                                    CentralDialogFragment.this.binding.tvRelativeType.setText(relationType);
                                }
                            }
                            if (TextUtils.isEmpty(payloadNewMapping.getFullName()) && !TextUtils.isEmpty(payloadNewMapping.getFullNameL1())) {
                                CentralDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullNameL1()) ? "" : payloadNewMapping.getFullNameL1());
                                CentralDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                            } else if (TextUtils.isEmpty(payloadNewMapping.getFullNameL1())) {
                                CentralDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                CentralDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                            } else if (payloadNewMapping.getFullName().equalsIgnoreCase(payloadNewMapping.getFullNameL1())) {
                                CentralDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                CentralDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                            } else {
                                CentralDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                CentralDialogFragment.this.binding.tvElectorNamev1.setText(TextUtils.isEmpty(payloadNewMapping.getFullNameL1()) ? "" : payloadNewMapping.getFullNameL1());
                            }
                            if (TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) && !TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1())) {
                                CentralDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1()) ? "" : payloadNewMapping.getFullRelativeNameL1());
                                CentralDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                                return;
                            } else if (TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1())) {
                                CentralDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                CentralDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                                return;
                            } else if (payloadNewMapping.getFullRelativeName().equalsIgnoreCase(payloadNewMapping.getFullRelativeNameL1())) {
                                CentralDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                CentralDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                                return;
                            } else {
                                CentralDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                CentralDialogFragment.this.binding.tvRelativeNamev1.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1()) ? "" : payloadNewMapping.getFullRelativeNameL1());
                                return;
                            }
                        }
                        CentralDialogFragment.this.utils.infoDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.no_active_record));
                        return;
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    CentralDialogFragment.this.utils.infoDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                CentralDialogFragment.this.utils.infoDialog(CentralDialogFragment.this.requireActivity(), CentralDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    public void getAllOldAc2025(String oldState) {
        this.commomUtility.getAllAC2025(oldState, this.token, this.atkband, this.rtkband, requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.CentralDialogFragment.36
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    CentralDialogFragment.this.ACNameList.clear();
                    CentralDialogFragment.this.ACList.clear();
                    CentralDialogFragment.this.ACList = acList;
                    CentralDialogFragment.this.ACNameList = acNameList;
                    if (CentralDialogFragment.this.partNameList.size() > 0 && CentralDialogFragment.this.partList.size() > 0) {
                        CentralDialogFragment.this.partList.clear();
                        CentralDialogFragment.this.partNameList.clear();
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) CentralDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) CentralDialogFragment.this.ACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    CentralDialogFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                    CentralDialogFragment.this.binding.oldAcNo.setThreshold(1);
                }
            }
        });
    }

    public void clearACVariables() {
        this.isOldPartNoEntered = false;
        this.isOldAcNoEntered = false;
        this.isoldStateEntered = false;
        this.isOldPartSerialNoEntered = false;
        this.binding.oldPslNo.setText("");
        this.binding.rvMapping.setVisibility(8);
        this.binding.tvRecordCount.setVisibility(8);
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
}
