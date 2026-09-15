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
import in.gov.eci.bloapp.databinding.DialogReusableNewDeclartionFormBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.SearchLocationAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.ErollDataCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback;
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
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DeclarationFormUpdateDialogFragment extends DialogFragment {
    private String acNo;
    SearchLocationAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    private DialogReusableNewDeclartionFormBinding binding;
    int currentAc;
    int currentAge;
    String currentEpic;
    String currentName;
    int currentPart;
    String currentRelativeName;
    String currentRelativeType;
    int currentSerialNo;
    String currentStateCode;
    private ArrayAdapter<String> districtadapter;
    String is2003Selected;
    boolean isOldAcNoEntered;
    boolean isOldPartNoEntered;
    boolean isOldPartSerialNoEntered;
    boolean isoldStateEntered;
    String key;
    private OnDataReceivedListener listener;
    List<MappingList> newbloMappedList;
    private String partNo;
    private String refreshToken;
    private String rtkband;
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
        this.binding = DialogReusableNewDeclartionFormBinding.inflate(getLayoutInflater());
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
            this.is2003Selected = getArguments().getString("is2003selected");
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

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$1, reason: invalid class name */
    class AnonymousClass1 implements AdapterView.OnItemClickListener {
        AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            DeclarationFormUpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
            DeclarationFormUpdateDialogFragment.this.binding.tvRecordCount.setVisibility(8);
            DeclarationFormUpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select State")) {
                DeclarationFormUpdateDialogFragment.this.efState = null;
                DeclarationFormUpdateDialogFragment.this.efDistrict = null;
                DeclarationFormUpdateDialogFragment.this.efAc = null;
                DeclarationFormUpdateDialogFragment.this.OldPart = null;
                DeclarationFormUpdateDialogFragment.this.EfACNameList.clear();
                DeclarationFormUpdateDialogFragment.this.EfACList.clear();
                DeclarationFormUpdateDialogFragment.this.EfACNameList.add(DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                DeclarationFormUpdateDialogFragment.this.EfACList.add(0);
                DeclarationFormUpdateDialogFragment.this.district.clear();
                DeclarationFormUpdateDialogFragment.this.districtcode.clear();
                DeclarationFormUpdateDialogFragment.this.district.add("Select District");
                DeclarationFormUpdateDialogFragment.this.districtcode.add("0");
                DeclarationFormUpdateDialogFragment.this.binding.efDistrictSpinner.setText("");
                DeclarationFormUpdateDialogFragment.this.partList.clear();
                DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                DeclarationFormUpdateDialogFragment.this.partNameList.add(DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                DeclarationFormUpdateDialogFragment.this.partList.add(0);
                DeclarationFormUpdateDialogFragment.this.binding.efAcSpinner.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.efOldPartNo.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.oldStateSpinner.setText("");
                return;
            }
            String string = parent.getItemAtPosition(i).toString();
            DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
            declarationFormUpdateDialogFragment.efState = declarationFormUpdateDialogFragment.StateList.get(DeclarationFormUpdateDialogFragment.this.StateNameList.indexOf(string));
            DeclarationFormUpdateDialogFragment.this.binding.efAcSpinner.setText("");
            DeclarationFormUpdateDialogFragment.this.binding.efOldPartNo.setText("");
            DeclarationFormUpdateDialogFragment.this.binding.efDistrictSpinner.setText("");
            DeclarationFormUpdateDialogFragment.this.binding.oldStateSpinner.setText("");
            DeclarationFormUpdateDialogFragment.this.binding.selfName.setText("");
            DeclarationFormUpdateDialogFragment.this.binding.parentName.setText("");
            DeclarationFormUpdateDialogFragment.this.binding.grandparentName.setText("");
            DeclarationFormUpdateDialogFragment.this.efDistrict = null;
            DeclarationFormUpdateDialogFragment.this.efAc = null;
            DeclarationFormUpdateDialogFragment.this.OldPart = null;
            DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment2 = DeclarationFormUpdateDialogFragment.this;
            declarationFormUpdateDialogFragment2.getAllDistrict(declarationFormUpdateDialogFragment2.efState);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
            declarationFormUpdateDialogFragment.getallEFAc(declarationFormUpdateDialogFragment.efState);
        }
    }

    private void handleSearchByFamilySpinnerSelection() {
        this.binding.efStateSpinner.setOnItemClickListener(new AnonymousClass1());
        this.binding.efDistrictSpinner.setOnItemClickListener(new AnonymousClass2());
        this.binding.efAcSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                DeclarationFormUpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
                DeclarationFormUpdateDialogFragment.this.binding.tvRecordCount.setVisibility(8);
                DeclarationFormUpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Assembly Constituency")) {
                    DeclarationFormUpdateDialogFragment.this.efAc = null;
                    DeclarationFormUpdateDialogFragment.this.OldPart = null;
                    DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                    DeclarationFormUpdateDialogFragment.this.partList.clear();
                    DeclarationFormUpdateDialogFragment.this.partNameList.add(DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    DeclarationFormUpdateDialogFragment.this.partList.add(0);
                    DeclarationFormUpdateDialogFragment.this.binding.efOldPartNo.setText("");
                    return;
                }
                DeclarationFormUpdateDialogFragment.this.OldPart = null;
                String string = parent.getItemAtPosition(i).toString();
                DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
                declarationFormUpdateDialogFragment.efAc = String.valueOf(declarationFormUpdateDialogFragment.EfACList.get(DeclarationFormUpdateDialogFragment.this.EfACNameList.indexOf(string)));
                DeclarationFormUpdateDialogFragment.this.binding.selfName.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.parentName.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.grandparentName.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.efOldPartNo.setText("");
                DeclarationFormUpdateDialogFragment.this.commomUtility.getPartByAc(DeclarationFormUpdateDialogFragment.this.requireActivity(), Integer.parseInt(DeclarationFormUpdateDialogFragment.this.efAc), DeclarationFormUpdateDialogFragment.this.efState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.3.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                    public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                        if (code == 200) {
                            DeclarationFormUpdateDialogFragment.this.partList.clear();
                            DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                            DeclarationFormUpdateDialogFragment.this.partList = acList;
                            DeclarationFormUpdateDialogFragment.this.partNameList = acNameList;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) DeclarationFormUpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) DeclarationFormUpdateDialogFragment.this.partNameList);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            DeclarationFormUpdateDialogFragment.this.binding.efOldPartNo.setAdapter(arrayAdapter);
                            DeclarationFormUpdateDialogFragment.this.binding.efOldPartNo.setThreshold(1);
                        }
                    }
                });
            }
        });
        this.binding.efOldPartNo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                DeclarationFormUpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
                DeclarationFormUpdateDialogFragment.this.binding.tvRecordCount.setVisibility(8);
                DeclarationFormUpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Part")) {
                    DeclarationFormUpdateDialogFragment.this.OldPart = null;
                    return;
                }
                String string = parent.getItemAtPosition(i).toString();
                DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
                declarationFormUpdateDialogFragment.OldPart = String.valueOf(declarationFormUpdateDialogFragment.partList.get(DeclarationFormUpdateDialogFragment.this.partNameList.indexOf(string)));
            }
        });
        this.binding.selfName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                DeclarationFormUpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
                DeclarationFormUpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            }
        });
        this.binding.parentName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                DeclarationFormUpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
                DeclarationFormUpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$2, reason: invalid class name */
    class AnonymousClass2 implements AdapterView.OnItemClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            DeclarationFormUpdateDialogFragment.this.binding.rvMapping.setVisibility(8);
            DeclarationFormUpdateDialogFragment.this.binding.tvRecordCount.setVisibility(8);
            DeclarationFormUpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(8);
            if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select District")) {
                DeclarationFormUpdateDialogFragment.this.efDistrict = null;
                DeclarationFormUpdateDialogFragment.this.efAc = null;
                DeclarationFormUpdateDialogFragment.this.binding.efAcSpinner.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.efOldPartNo.setText("");
                if (DeclarationFormUpdateDialogFragment.this.EfACList.size() > 0) {
                    DeclarationFormUpdateDialogFragment.this.EfACNameList.clear();
                    DeclarationFormUpdateDialogFragment.this.EfACList.clear();
                }
                DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
                declarationFormUpdateDialogFragment.getallEFAc(declarationFormUpdateDialogFragment.efState);
                return;
            }
            DeclarationFormUpdateDialogFragment.this.efAc = null;
            DeclarationFormUpdateDialogFragment.this.OldPart = null;
            String str = (String) DeclarationFormUpdateDialogFragment.this.district.get(DeclarationFormUpdateDialogFragment.this.district.indexOf(parent.getItemAtPosition(i).toString()));
            int iIndexOf = DeclarationFormUpdateDialogFragment.this.district.indexOf(str);
            Log.d("CheckEffff : ", iIndexOf + " " + str);
            DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment2 = DeclarationFormUpdateDialogFragment.this;
            declarationFormUpdateDialogFragment2.efDistrict = (String) declarationFormUpdateDialogFragment2.districtcode.get(iIndexOf);
            DeclarationFormUpdateDialogFragment.this.binding.efAcSpinner.setText("");
            DeclarationFormUpdateDialogFragment.this.binding.efOldPartNo.setText("");
            DeclarationFormUpdateDialogFragment.this.binding.selfName.setText("");
            DeclarationFormUpdateDialogFragment.this.binding.parentName.setText("");
            DeclarationFormUpdateDialogFragment.this.binding.grandparentName.setText("");
            if (DeclarationFormUpdateDialogFragment.this.partList.size() > 0 && DeclarationFormUpdateDialogFragment.this.partNameList.size() > 0) {
                DeclarationFormUpdateDialogFragment.this.partList.clear();
                DeclarationFormUpdateDialogFragment.this.partNameList.clear();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            DeclarationFormUpdateDialogFragment.this.commomUtility.getAssmblyByDist(DeclarationFormUpdateDialogFragment.this.requireActivity(), Integer.parseInt(DeclarationFormUpdateDialogFragment.this.efDistrict), DeclarationFormUpdateDialogFragment.this.efState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.2.1
                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                    if (code == 200) {
                        DeclarationFormUpdateDialogFragment.this.EfACNameList.clear();
                        DeclarationFormUpdateDialogFragment.this.EfACList.clear();
                        DeclarationFormUpdateDialogFragment.this.EfACList = acList;
                        DeclarationFormUpdateDialogFragment.this.EfACNameList = acNameList;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) DeclarationFormUpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) DeclarationFormUpdateDialogFragment.this.EfACNameList);
                        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        DeclarationFormUpdateDialogFragment.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                        DeclarationFormUpdateDialogFragment.this.binding.efAcSpinner.setThreshold(1);
                    }
                }
            });
        }
    }

    private void handleSearchByACSpinnerSelection() {
        this.binding.oldStateSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                DeclarationFormUpdateDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select State")) {
                    DeclarationFormUpdateDialogFragment.this.isoldStateEntered = false;
                    DeclarationFormUpdateDialogFragment.this.oldState = null;
                    DeclarationFormUpdateDialogFragment.this.oldAc = null;
                    DeclarationFormUpdateDialogFragment.this.OldPart = null;
                    DeclarationFormUpdateDialogFragment.this.oldDistrict = null;
                    DeclarationFormUpdateDialogFragment.this.partList.clear();
                    DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                    DeclarationFormUpdateDialogFragment.this.ACNameList.clear();
                    DeclarationFormUpdateDialogFragment.this.ACList.clear();
                    DeclarationFormUpdateDialogFragment.this.ACNameList.add(DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    DeclarationFormUpdateDialogFragment.this.ACList.add(0);
                    DeclarationFormUpdateDialogFragment.this.partNameList.add(DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    DeclarationFormUpdateDialogFragment.this.partList.add(0);
                    DeclarationFormUpdateDialogFragment.this.binding.oldAcNo.setText("");
                    DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setText("");
                    DeclarationFormUpdateDialogFragment.this.binding.oldDistrictSpinner.setText("");
                    DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.setText("");
                    DeclarationFormUpdateDialogFragment.this.isUserSelected = false;
                    DeclarationFormUpdateDialogFragment.this.district.clear();
                    DeclarationFormUpdateDialogFragment.this.districtcode.clear();
                    DeclarationFormUpdateDialogFragment.this.district.add("Select District");
                    DeclarationFormUpdateDialogFragment.this.districtcode.add("0");
                    DeclarationFormUpdateDialogFragment.this.binding.oldDistrictSpinner.setText("");
                    return;
                }
                DeclarationFormUpdateDialogFragment.this.oldAc = null;
                DeclarationFormUpdateDialogFragment.this.OldPart = null;
                DeclarationFormUpdateDialogFragment.this.oldDistrict = null;
                DeclarationFormUpdateDialogFragment.this.isoldStateEntered = true;
                DeclarationFormUpdateDialogFragment.this.binding.oldAcNo.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.oldDistrictSpinner.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.setText("");
                String string = parent.getItemAtPosition(i).toString();
                DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
                declarationFormUpdateDialogFragment.oldState = declarationFormUpdateDialogFragment.StateList.get(DeclarationFormUpdateDialogFragment.this.StateNameList.indexOf(string));
                DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment2 = DeclarationFormUpdateDialogFragment.this;
                declarationFormUpdateDialogFragment2.oldStateName = declarationFormUpdateDialogFragment2.StateNameList.get(DeclarationFormUpdateDialogFragment.this.StateNameList.indexOf(string));
                if (DeclarationFormUpdateDialogFragment.this.isUserSelected) {
                    DeclarationFormUpdateDialogFragment.this.isUserSelected = false;
                    DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setText("");
                    DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.setText("");
                }
                DeclarationFormUpdateDialogFragment.this.district.clear();
                DeclarationFormUpdateDialogFragment.this.districtcode.clear();
                DeclarationFormUpdateDialogFragment.this.ACNameList.clear();
                DeclarationFormUpdateDialogFragment.this.ACList.clear();
                DeclarationFormUpdateDialogFragment.this.partList.clear();
                DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment3 = DeclarationFormUpdateDialogFragment.this;
                declarationFormUpdateDialogFragment3.getAllDistrict(declarationFormUpdateDialogFragment3.oldState);
                if (!TextUtils.isEmpty(DeclarationFormUpdateDialogFragment.this.is2003Selected) && DeclarationFormUpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                    DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment4 = DeclarationFormUpdateDialogFragment.this;
                    declarationFormUpdateDialogFragment4.getAllOldAc2025(declarationFormUpdateDialogFragment4.oldState);
                } else {
                    DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment5 = DeclarationFormUpdateDialogFragment.this;
                    declarationFormUpdateDialogFragment5.getAllOldAc(declarationFormUpdateDialogFragment5.oldState);
                }
            }
        });
        this.binding.oldDistrictSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                DeclarationFormUpdateDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select District")) {
                    DeclarationFormUpdateDialogFragment.this.oldAc = null;
                    DeclarationFormUpdateDialogFragment.this.OldPart = null;
                    DeclarationFormUpdateDialogFragment.this.oldDistrict = null;
                    DeclarationFormUpdateDialogFragment.this.partList.clear();
                    DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                    DeclarationFormUpdateDialogFragment.this.ACNameList.clear();
                    DeclarationFormUpdateDialogFragment.this.ACList.clear();
                    DeclarationFormUpdateDialogFragment.this.ACNameList.add(DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_assembly_constituency));
                    DeclarationFormUpdateDialogFragment.this.ACList.add(0);
                    DeclarationFormUpdateDialogFragment.this.partNameList.add(DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    DeclarationFormUpdateDialogFragment.this.partList.add(0);
                    DeclarationFormUpdateDialogFragment.this.binding.oldAcNo.setText("");
                    DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setText("");
                    DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.setText("");
                    if (DeclarationFormUpdateDialogFragment.this.ACList.size() > 0) {
                        DeclarationFormUpdateDialogFragment.this.ACList.clear();
                        DeclarationFormUpdateDialogFragment.this.ACNameList.clear();
                    }
                    if (!TextUtils.isEmpty(DeclarationFormUpdateDialogFragment.this.is2003Selected) && DeclarationFormUpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                        DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
                        declarationFormUpdateDialogFragment.getAllOldAc2025(declarationFormUpdateDialogFragment.oldState);
                        return;
                    } else {
                        DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment2 = DeclarationFormUpdateDialogFragment.this;
                        declarationFormUpdateDialogFragment2.getAllOldAc(declarationFormUpdateDialogFragment2.oldState);
                        return;
                    }
                }
                DeclarationFormUpdateDialogFragment.this.oldAc = null;
                DeclarationFormUpdateDialogFragment.this.OldPart = null;
                DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.setText("");
                int iIndexOf = DeclarationFormUpdateDialogFragment.this.district.indexOf((String) DeclarationFormUpdateDialogFragment.this.district.get(DeclarationFormUpdateDialogFragment.this.district.indexOf(parent.getItemAtPosition(i).toString())));
                DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment3 = DeclarationFormUpdateDialogFragment.this;
                declarationFormUpdateDialogFragment3.oldDistrict = (String) declarationFormUpdateDialogFragment3.district.get(iIndexOf);
                int i2 = Integer.parseInt((String) DeclarationFormUpdateDialogFragment.this.districtcode.get(iIndexOf));
                DeclarationFormUpdateDialogFragment.this.binding.oldAcNo.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.setText("");
                if (TextUtils.isEmpty(DeclarationFormUpdateDialogFragment.this.is2003Selected) || !DeclarationFormUpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                    DeclarationFormUpdateDialogFragment.this.commomUtility.getAssmblyByDist(DeclarationFormUpdateDialogFragment.this.requireActivity(), i2, DeclarationFormUpdateDialogFragment.this.oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.8.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                        public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                            if (code == 200) {
                                DeclarationFormUpdateDialogFragment.this.ACNameList.clear();
                                DeclarationFormUpdateDialogFragment.this.ACList.clear();
                                DeclarationFormUpdateDialogFragment.this.ACList = acList;
                                DeclarationFormUpdateDialogFragment.this.ACNameList = acNameList;
                                if (DeclarationFormUpdateDialogFragment.this.partNameList.size() > 0 && DeclarationFormUpdateDialogFragment.this.partList.size() > 0) {
                                    DeclarationFormUpdateDialogFragment.this.partList.clear();
                                    DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                                }
                                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) DeclarationFormUpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) DeclarationFormUpdateDialogFragment.this.ACNameList);
                                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                                DeclarationFormUpdateDialogFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                                DeclarationFormUpdateDialogFragment.this.binding.oldAcNo.setThreshold(1);
                            }
                        }
                    });
                }
            }
        });
        this.binding.oldAcNo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                DeclarationFormUpdateDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Assembly Constituency")) {
                    DeclarationFormUpdateDialogFragment.this.isOldAcNoEntered = false;
                    DeclarationFormUpdateDialogFragment.this.oldAc = null;
                    DeclarationFormUpdateDialogFragment.this.OldPart = null;
                    DeclarationFormUpdateDialogFragment.this.partList.clear();
                    DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                    DeclarationFormUpdateDialogFragment.this.partNameList.add(DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.select_part));
                    DeclarationFormUpdateDialogFragment.this.partList.add(0);
                    DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setText("");
                    DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setText("");
                    DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.setText("");
                    DeclarationFormUpdateDialogFragment.this.isUserSelected = false;
                    return;
                }
                DeclarationFormUpdateDialogFragment.this.OldPart = null;
                DeclarationFormUpdateDialogFragment.this.isOldAcNoEntered = true;
                DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setText("");
                DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.setText("");
                String string = parent.getItemAtPosition(i).toString();
                DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
                declarationFormUpdateDialogFragment.oldAc = String.valueOf(declarationFormUpdateDialogFragment.ACList.get(DeclarationFormUpdateDialogFragment.this.ACNameList.indexOf(string)));
                if (!TextUtils.isEmpty(DeclarationFormUpdateDialogFragment.this.is2003Selected) && DeclarationFormUpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                    DeclarationFormUpdateDialogFragment.this.commomUtility.getPartByAc2025(DeclarationFormUpdateDialogFragment.this.requireActivity(), Integer.parseInt(DeclarationFormUpdateDialogFragment.this.oldAc), DeclarationFormUpdateDialogFragment.this.oldState, DeclarationFormUpdateDialogFragment.this.token, DeclarationFormUpdateDialogFragment.this.atkband, DeclarationFormUpdateDialogFragment.this.rtkband, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.9.1
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                        public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                            if (code == 200) {
                                DeclarationFormUpdateDialogFragment.this.partList.clear();
                                DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                                DeclarationFormUpdateDialogFragment.this.partList = acList;
                                DeclarationFormUpdateDialogFragment.this.partNameList = acNameList;
                                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) DeclarationFormUpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) DeclarationFormUpdateDialogFragment.this.partNameList);
                                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                                DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setAdapter(arrayAdapter);
                                DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setThreshold(1);
                            }
                        }
                    });
                } else {
                    DeclarationFormUpdateDialogFragment.this.commomUtility.getPartByAc(DeclarationFormUpdateDialogFragment.this.requireActivity(), Integer.parseInt(DeclarationFormUpdateDialogFragment.this.oldAc), DeclarationFormUpdateDialogFragment.this.oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.9.2
                        @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
                        public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                            if (code == 200) {
                                DeclarationFormUpdateDialogFragment.this.partList.clear();
                                DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                                DeclarationFormUpdateDialogFragment.this.partList = acList;
                                DeclarationFormUpdateDialogFragment.this.partNameList = acNameList;
                                ArrayAdapter arrayAdapter = new ArrayAdapter((Context) DeclarationFormUpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) DeclarationFormUpdateDialogFragment.this.partNameList);
                                arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                                DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setAdapter(arrayAdapter);
                                DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.setThreshold(1);
                            }
                        }
                    });
                }
                if (DeclarationFormUpdateDialogFragment.this.isUserSelected) {
                    DeclarationFormUpdateDialogFragment.this.isUserSelected = false;
                }
            }
        });
        this.binding.oldPartNo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                DeclarationFormUpdateDialogFragment.this.binding.cardDisabled.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Part")) {
                    DeclarationFormUpdateDialogFragment.this.isOldPartNoEntered = false;
                    DeclarationFormUpdateDialogFragment.this.OldPart = null;
                    DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.setText("");
                    DeclarationFormUpdateDialogFragment.this.isUserSelected = false;
                    return;
                }
                DeclarationFormUpdateDialogFragment.this.isOldPartNoEntered = true;
                String string = parent.getItemAtPosition(i).toString();
                DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
                declarationFormUpdateDialogFragment.OldPart = String.valueOf(declarationFormUpdateDialogFragment.partList.get(DeclarationFormUpdateDialogFragment.this.partNameList.indexOf(string)));
                if (DeclarationFormUpdateDialogFragment.this.isUserSelected) {
                    DeclarationFormUpdateDialogFragment.this.isUserSelected = false;
                }
            }
        });
        this.binding.oldPslNo.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.11
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                DeclarationFormUpdateDialogFragment.this.binding.cardDisabled.setVisibility(8);
            }
        });
    }

    private void handleButtonClicks() {
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DeclarationFormUpdateDialogFragment.this.utils.validateState_Ac_Part_Serial(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.oldState, DeclarationFormUpdateDialogFragment.this.oldDistrict, DeclarationFormUpdateDialogFragment.this.oldAc, DeclarationFormUpdateDialogFragment.this.OldPart, DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.getText().toString().trim(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.12.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                    public void onResult(boolean isValidate) {
                        if (!TextUtils.isEmpty(DeclarationFormUpdateDialogFragment.this.is2003Selected) && DeclarationFormUpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("Y")) {
                            if (DeclarationFormUpdateDialogFragment.this.payloads.size() > 0) {
                                DeclarationFormUpdateDialogFragment.this.payloads.clear();
                            }
                            DeclarationFormUpdateDialogFragment.this.searchDetails();
                        } else {
                            if (TextUtils.isEmpty(DeclarationFormUpdateDialogFragment.this.is2003Selected) || !DeclarationFormUpdateDialogFragment.this.is2003Selected.equalsIgnoreCase("N")) {
                                return;
                            }
                            if (DeclarationFormUpdateDialogFragment.this.erollPayloads.size() > 0) {
                                DeclarationFormUpdateDialogFragment.this.erollPayloads.clear();
                            }
                            DeclarationFormUpdateDialogFragment.this.ErollDataDetails();
                        }
                    }
                });
            }
        });
        this.binding.submitButtonBlo.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleButtonClicks$0(view);
            }
        });
        this.binding.speakSerial.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DeclarationFormUpdateDialogFragment.this.utils.showVoicePopup(DeclarationFormUpdateDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.15.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.setText(result);
                    }
                });
            }
        });
        this.binding.speakSelf.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DeclarationFormUpdateDialogFragment.this.utils.showVoicePopup(DeclarationFormUpdateDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.16.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        DeclarationFormUpdateDialogFragment.this.binding.selfName.setText(result);
                    }
                });
            }
        });
        this.binding.speakParent.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DeclarationFormUpdateDialogFragment.this.utils.showVoicePopup(DeclarationFormUpdateDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.17.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        DeclarationFormUpdateDialogFragment.this.binding.parentName.setText(result);
                    }
                });
            }
        });
        this.binding.speakGrandparent.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DeclarationFormUpdateDialogFragment.this.utils.showVoicePopup(DeclarationFormUpdateDialogFragment.this.requireActivity(), new SpeechtoTextCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.18.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback
                    public void onCallBack(String result) {
                        DeclarationFormUpdateDialogFragment.this.binding.grandparentName.setText(result);
                    }
                });
            }
        });
        this.binding.searchButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleButtonClicks$1(view);
            }
        });
        this.binding.ivCancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
                declarationFormUpdateDialogFragment.sentselfSearchData(null, null, declarationFormUpdateDialogFragment.key);
            }
        });
        this.binding.layoutVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                for (final MappingList mappingList : DeclarationFormUpdateDialogFragment.this.newbloMappedList) {
                    if (mappingList.isSelected()) {
                        String oldStateCd = mappingList.getOldStateCd();
                        String strValueOf = String.valueOf(mappingList.getOldAcNo());
                        String strValueOf2 = String.valueOf(mappingList.getOldPartNumber());
                        String strValueOf3 = String.valueOf(mappingList.getOldPartSerialNo());
                        int age = mappingList.getAge();
                        if (DeclarationFormUpdateDialogFragment.this.key.equalsIgnoreCase("progeny")) {
                            DeclarationFormUpdateDialogFragment.this.utils.validateProgenyDetailsnew(DeclarationFormUpdateDialogFragment.this.requireActivity(), oldStateCd, strValueOf, strValueOf2, strValueOf3, DeclarationFormUpdateDialogFragment.this.currentName, String.valueOf(DeclarationFormUpdateDialogFragment.this.currentAc), String.valueOf(DeclarationFormUpdateDialogFragment.this.currentPart), DeclarationFormUpdateDialogFragment.this.currentStateCode, new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.21.1
                                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                                public void onResult(boolean isValidate) {
                                    if (isValidate) {
                                        DeclarationFormUpdateDialogFragment.this.sentselfSearchData(null, mappingList, DeclarationFormUpdateDialogFragment.this.key);
                                    }
                                }
                            });
                            return;
                        } else {
                            if (DeclarationFormUpdateDialogFragment.this.key.equalsIgnoreCase("self")) {
                                DeclarationFormUpdateDialogFragment.this.commomUtility.validateSirMapping(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.token, DeclarationFormUpdateDialogFragment.this.state, DeclarationFormUpdateDialogFragment.this.atkband, DeclarationFormUpdateDialogFragment.this.rtkband, oldStateCd, strValueOf, strValueOf2, strValueOf3, DeclarationFormUpdateDialogFragment.this.acNo, DeclarationFormUpdateDialogFragment.this.partNo, DeclarationFormUpdateDialogFragment.this.currentStateCode, DeclarationFormUpdateDialogFragment.this.currentAge, age, new ValidateMapCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.21.2
                                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback
                                    public void onCallBack(String statusCode, String message, String bloNumber, String bloName) {
                                        if (statusCode.equalsIgnoreCase("200")) {
                                            DeclarationFormUpdateDialogFragment.this.sentselfSearchData(null, mappingList, DeclarationFormUpdateDialogFragment.this.key);
                                            return;
                                        }
                                        if (statusCode.equalsIgnoreCase("409")) {
                                            if (!TextUtils.isEmpty(bloNumber)) {
                                                bloNumber.equalsIgnoreCase("null");
                                            }
                                            if (!TextUtils.isEmpty(bloName)) {
                                                bloName.equalsIgnoreCase("null");
                                            }
                                            DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                                            return;
                                        }
                                        if (statusCode.equalsIgnoreCase("0")) {
                                            DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                                        } else {
                                            DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                        }
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
        String str4;
        int age;
        if (!TextUtils.isEmpty(this.is2003Selected) && this.is2003Selected.equalsIgnoreCase("N")) {
            PayloadNewMapping payloadNewMapping = this.erollPayloads.get(0);
            Payload payload = new Payload();
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
            sentselfSearchData(payload, null, this.key);
            return;
        }
        if (this.payloads.size() > 0) {
            String oldStateCd = this.payloads.get(0).getOldStateCd();
            String strValueOf = String.valueOf(this.payloads.get(0).getOldAcNo());
            String strValueOf2 = String.valueOf(this.payloads.get(0).getOldPartNumber());
            String strValueOf3 = String.valueOf(this.payloads.get(0).getOldPartSerialNo());
            str2 = strValueOf;
            str = oldStateCd;
            age = this.payloads.get(0).getAge();
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
            this.utils.validateProgenyDetailsnew(requireActivity(), str, str2, str3, str4, this.currentName, String.valueOf(this.currentAc), String.valueOf(this.currentPart), this.currentStateCode, new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.13
                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                public void onResult(boolean isValidate) {
                    if (isValidate) {
                        DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
                        declarationFormUpdateDialogFragment.sentselfSearchData(declarationFormUpdateDialogFragment.payloads.get(0), null, DeclarationFormUpdateDialogFragment.this.key);
                    }
                }
            });
        } else if (this.key.equalsIgnoreCase("self")) {
            this.commomUtility.validateSirMapping(requireActivity(), this.token, this.state, this.atkband, this.rtkband, str, str2, str3, str4, this.acNo, this.partNo, this.currentStateCode, this.currentAge, age, new ValidateMapCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.14
                @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback
                public void onCallBack(String statusCode, String message, String bloNumber, String bloName) {
                    if (statusCode.equalsIgnoreCase("200")) {
                        DeclarationFormUpdateDialogFragment declarationFormUpdateDialogFragment = DeclarationFormUpdateDialogFragment.this;
                        declarationFormUpdateDialogFragment.sentselfSearchData(declarationFormUpdateDialogFragment.payloads.get(0), null, DeclarationFormUpdateDialogFragment.this.key);
                        return;
                    }
                    if (statusCode.equalsIgnoreCase("409")) {
                        if (!TextUtils.isEmpty(bloNumber)) {
                            bloNumber.equalsIgnoreCase("null");
                        }
                        if (!TextUtils.isEmpty(bloName)) {
                            bloName.equalsIgnoreCase("null");
                        }
                        DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                        return;
                    }
                    if (statusCode.equalsIgnoreCase("0")) {
                        DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    } else {
                        DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleButtonClicks$1(View view) {
        this.utils.validateState_Ac_Family(requireActivity(), this.efState, this.efAc, this.binding.selfName.getText().toString().trim(), this.binding.parentName.getText().toString().trim(), this.binding.grandparentName.getText().toString().trim(), this.efDistrict, this.OldPart, this.key, new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.19
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
            public void onResult(boolean isValidate) {
                if (isValidate) {
                    DeclarationFormUpdateDialogFragment.this.callLocationApi();
                }
            }
        });
    }

    private void handleSearchTabClcicks() {
        this.binding.searchAcPartPslMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$3(view);
            }
        });
        this.binding.searchLocationMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$5(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$3(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda4
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
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda6
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

    private void setAdapter() {
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
            this.StateNameList.removeIf(new Predicate() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda7
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DeclarationFormUpdateDialogFragment.lambda$setAdapter$6(arrayList, (String) obj);
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
            this.StateList.removeIf(new Predicate() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda8
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return DeclarationFormUpdateDialogFragment.lambda$setAdapter$7(arrayList2, (String) obj);
                }
            });
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
    public void sentselfSearchData(Payload serchModel, MappingList mappingList, String key) {
        if (this.listener != null) {
            dismiss();
            this.listener.onDataReceived(serchModel, mappingList, key);
        }
    }

    private void selecttab(MaterialButton selected, MaterialButton other) {
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
        this.binding.oldStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                DeclarationFormUpdateDialogFragment.this.binding.oldStateSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.23
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                DeclarationFormUpdateDialogFragment.this.binding.efStateSpinner.showDropDown();
                return false;
            }
        });
        this.binding.oldDistrictSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.24
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                DeclarationFormUpdateDialogFragment.this.binding.oldDistrictSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efDistrictSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.25
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                DeclarationFormUpdateDialogFragment.this.binding.efDistrictSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efAcSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.26
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                DeclarationFormUpdateDialogFragment.this.binding.efAcSpinner.showDropDown();
                return false;
            }
        });
        this.binding.oldAcNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.27
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                DeclarationFormUpdateDialogFragment.this.binding.oldAcNo.showDropDown();
                return false;
            }
        });
        this.binding.oldPartNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                DeclarationFormUpdateDialogFragment.this.binding.oldPartNo.showDropDown();
                return false;
            }
        });
        this.binding.efOldPartNo.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                DeclarationFormUpdateDialogFragment.this.binding.efOldPartNo.showDropDown();
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
        searchLocationFamily.enqueue(new AnonymousClass30());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$30, reason: invalid class name */
    class AnonymousClass30 implements Callback<LocationRoot> {
        AnonymousClass30() {
        }

        public void onResponse(Call<LocationRoot> call, Response<LocationRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    DeclarationFormUpdateDialogFragment.this.newbloMappedList = ((LocationRoot) response.body()).payload.mappingList;
                    if (DeclarationFormUpdateDialogFragment.this.newbloMappedList.size() > 0) {
                        Logger.d("blo list size", "" + DeclarationFormUpdateDialogFragment.this.newbloMappedList.size());
                        DeclarationFormUpdateDialogFragment.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(DeclarationFormUpdateDialogFragment.this.requireActivity()));
                        if (DeclarationFormUpdateDialogFragment.this.newbloMappedList != null && !DeclarationFormUpdateDialogFragment.this.newbloMappedList.isEmpty()) {
                            DeclarationFormUpdateDialogFragment.this.binding.rvMapping.setVisibility(0);
                            DeclarationFormUpdateDialogFragment.this.binding.tvRecordCount.setVisibility(0);
                            DeclarationFormUpdateDialogFragment.this.binding.tvRecordCount.setText(DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.total_record) + " " + DeclarationFormUpdateDialogFragment.this.newbloMappedList.size());
                            DeclarationFormUpdateDialogFragment.this.adapter = new SearchLocationAdapter(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.newbloMappedList, new SearchLocationAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$30$$ExternalSyntheticLambda0
                                @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.SearchLocationAdapter.OnItemSelectedListener
                                public final void onItemSelected() {
                                    this.f$0.lambda$onResponse$0();
                                }
                            });
                            DeclarationFormUpdateDialogFragment.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(DeclarationFormUpdateDialogFragment.this.getContext()));
                            DeclarationFormUpdateDialogFragment.this.binding.rvMapping.setNestedScrollingEnabled(false);
                            DeclarationFormUpdateDialogFragment.this.binding.rvMapping.setAdapter(DeclarationFormUpdateDialogFragment.this.adapter);
                        }
                    } else {
                        new Utils().infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.no_data_found));
                    }
                } catch (Exception unused) {
                }
                DeclarationFormUpdateDialogFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                if (DeclarationFormUpdateDialogFragment.this.alertDialog != null) {
                    DeclarationFormUpdateDialogFragment.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            try {
                if (DeclarationFormUpdateDialogFragment.this.alertDialog != null) {
                    DeclarationFormUpdateDialogFragment.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                if (TextUtils.isEmpty(strOptString)) {
                    DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), jSONObject.optString("error"));
                } else {
                    DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), strOptString);
                }
                Logger.e("TAG", strOptString);
                if (DeclarationFormUpdateDialogFragment.this.alertDialog != null) {
                    DeclarationFormUpdateDialogFragment.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (DeclarationFormUpdateDialogFragment.this.alertDialog != null) {
                    DeclarationFormUpdateDialogFragment.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            DeclarationFormUpdateDialogFragment.this.binding.layoutVerifyButton.setVisibility(0);
        }

        public void onFailure(Call<LocationRoot> call, Throwable t) {
            if (DeclarationFormUpdateDialogFragment.this.alertDialog != null) {
                DeclarationFormUpdateDialogFragment.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchDetails() {
        this.commomUtility.callVerifyRelativeApi(requireActivity(), this.token, this.atkband, this.rtkband, this.oldState, this.oldAc, this.OldPart, this.binding.oldPslNo.getText().toString().trim(), new SearchByAcPartCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.31
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback
            public void onCallBack(int code, List<Payload> datalist, String message) {
                if (code == 200) {
                    if (datalist != null && datalist.size() > 0) {
                        DeclarationFormUpdateDialogFragment.this.payloads = datalist;
                        if (datalist.size() > 1) {
                            DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.multiple_record));
                            return;
                        }
                        Payload payload = datalist.get(0);
                        DeclarationFormUpdateDialogFragment.this.binding.tvStateName.setText(DeclarationFormUpdateDialogFragment.this.oldStateName);
                        DeclarationFormUpdateDialogFragment.this.binding.tvDistrictName.setText(String.valueOf(payload.getOldDistNo()) + " - " + (TextUtils.isEmpty(payload.getOldDistName()) ? "" : payload.getOldDistName()));
                        DeclarationFormUpdateDialogFragment.this.binding.tvAcName.setText(String.valueOf(payload.getOldAcNo()) + "  -  " + (TextUtils.isEmpty(payload.getOldAcName()) ? "" : payload.getOldAcName()));
                        DeclarationFormUpdateDialogFragment.this.binding.tvPartName.setText(String.valueOf(payload.getOldPartNumber()) + "  -  " + (TextUtils.isEmpty(payload.getOldPartName()) ? "" : payload.getOldPartName()));
                        DeclarationFormUpdateDialogFragment.this.binding.tvSerialName.setText(DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.getText().toString());
                        DeclarationFormUpdateDialogFragment.this.binding.tvSectionNo.setText("");
                        DeclarationFormUpdateDialogFragment.this.binding.tvOldAge.setText(String.valueOf(payload.getAge()));
                        DeclarationFormUpdateDialogFragment.this.binding.tvOldEpic.setText(TextUtils.isEmpty(payload.getEpicNumber()) ? "" : payload.getEpicNumber());
                        TextUtils.isEmpty(payload.getEpicNumber());
                        DeclarationFormUpdateDialogFragment.this.binding.cardDisabled.setVisibility(0);
                        if (!TextUtils.isEmpty(payload.getRelationType())) {
                            String relationType = payload.getRelationType();
                            if (relationType.equalsIgnoreCase("F") || relationType.equalsIgnoreCase("FATHER") || relationType.equalsIgnoreCase("FTHR")) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Father");
                            } else if (relationType.equalsIgnoreCase("M") || relationType.equalsIgnoreCase("MOTHER") || relationType.equalsIgnoreCase("MTHR")) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Mother");
                            } else if (relationType.equalsIgnoreCase("H") || relationType.equalsIgnoreCase("HUSBAND") || relationType.equalsIgnoreCase("HSBN")) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Husband");
                            } else if (relationType.equalsIgnoreCase("W") || relationType.equalsIgnoreCase("WIFE")) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Wife");
                            } else if (relationType.equalsIgnoreCase("L") || relationType.equalsIgnoreCase("OTHER") || relationType.equalsIgnoreCase("O")) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Other");
                            } else if (relationType.equalsIgnoreCase("GMTH")) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Grand Mother");
                            } else if (relationType.equalsIgnoreCase("GFTH")) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Grand Father");
                            } else {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText(relationType);
                            }
                        }
                        if (TextUtils.isEmpty(payload.getOldFullName()) && !TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            DeclarationFormUpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                            DeclarationFormUpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                        } else if (TextUtils.isEmpty(payload.getOldFullNameL1())) {
                            DeclarationFormUpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            DeclarationFormUpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                        } else if (payload.getOldFullName().equalsIgnoreCase(payload.getOldFullNameL1())) {
                            DeclarationFormUpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            DeclarationFormUpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                        } else {
                            DeclarationFormUpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payload.getOldFullName()) ? "" : payload.getOldFullName());
                            DeclarationFormUpdateDialogFragment.this.binding.tvElectorNamev1.setText(TextUtils.isEmpty(payload.getOldFullNameL1()) ? "" : payload.getOldFullNameL1());
                        }
                        if (TextUtils.isEmpty(payload.getOldRelativeFullName()) && !TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            DeclarationFormUpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            DeclarationFormUpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else if (TextUtils.isEmpty(payload.getOldRelativeFullNameL1())) {
                            DeclarationFormUpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            DeclarationFormUpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else if (payload.getOldRelativeFullName().equalsIgnoreCase(payload.getOldRelativeFullNameL1())) {
                            DeclarationFormUpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            DeclarationFormUpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                            return;
                        } else {
                            DeclarationFormUpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payload.getOldRelativeFullName()) ? "" : payload.getOldRelativeFullName());
                            DeclarationFormUpdateDialogFragment.this.binding.tvRelativeNamev1.setText(TextUtils.isEmpty(payload.getOldRelativeFullNameL1()) ? "" : payload.getOldRelativeFullNameL1());
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ErollDataDetails() {
        this.commomUtility.callErollData(requireActivity(), this.token, this.atkband, this.rtkband, this.oldState, this.oldAc, this.OldPart, this.binding.oldPslNo.getText().toString().trim(), new ErollDataCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.32
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ErollDataCallback
            public void onCallBack(int code, List<PayloadNewMapping> datalist, String message) {
                if (code == 200) {
                    if (datalist != null && datalist.size() > 0) {
                        DeclarationFormUpdateDialogFragment.this.erollPayloads = datalist;
                        if (datalist.size() > 1) {
                            DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.multiple_record));
                            return;
                        }
                        PayloadNewMapping payloadNewMapping = datalist.get(0);
                        if (!TextUtils.isEmpty(payloadNewMapping.getIsActive()) && payloadNewMapping.getIsActive().equalsIgnoreCase("true")) {
                            if (!TextUtils.isEmpty(payloadNewMapping.getUnderJo()) && payloadNewMapping.getUnderJo().equalsIgnoreCase("1")) {
                                DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), "The applicant is under Adjudication.");
                                return;
                            }
                            DeclarationFormUpdateDialogFragment.this.binding.tvStateName.setText(DeclarationFormUpdateDialogFragment.this.oldStateName);
                            DeclarationFormUpdateDialogFragment.this.binding.tvDistrictName.setText(String.valueOf(payloadNewMapping.getDistrictNo()) + " - " + (TextUtils.isEmpty(payloadNewMapping.getDistrictNo()) ? "" : payloadNewMapping.getDistrictName()));
                            DeclarationFormUpdateDialogFragment.this.binding.tvAcName.setText(String.valueOf(payloadNewMapping.getAcNo()) + "  -  " + (TextUtils.isEmpty(payloadNewMapping.getAcName()) ? "" : payloadNewMapping.getAcName()));
                            DeclarationFormUpdateDialogFragment.this.binding.tvPartName.setText(String.valueOf(payloadNewMapping.getPartNo()) + "  -  " + (TextUtils.isEmpty(payloadNewMapping.getPartName()) ? "" : payloadNewMapping.getPartName()));
                            DeclarationFormUpdateDialogFragment.this.binding.tvSerialName.setText(DeclarationFormUpdateDialogFragment.this.binding.oldPslNo.getText().toString());
                            DeclarationFormUpdateDialogFragment.this.binding.tvSectionNo.setText("");
                            DeclarationFormUpdateDialogFragment.this.binding.tvOldAge.setText(String.valueOf(payloadNewMapping.getAge()));
                            DeclarationFormUpdateDialogFragment.this.binding.tvOldEpic.setText(TextUtils.isEmpty(payloadNewMapping.getEpicNumber()) ? "" : payloadNewMapping.getEpicNumber());
                            TextUtils.isEmpty(payloadNewMapping.getEpicNumber());
                            DeclarationFormUpdateDialogFragment.this.binding.cardDisabled.setVisibility(0);
                            if (!TextUtils.isEmpty(payloadNewMapping.getRelationType())) {
                                String relationType = payloadNewMapping.getRelationType();
                                if (relationType.equalsIgnoreCase("F") || relationType.equalsIgnoreCase("FATHER") || relationType.equalsIgnoreCase("FTHR")) {
                                    DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Father");
                                } else if (relationType.equalsIgnoreCase("M") || relationType.equalsIgnoreCase("MOTHER") || relationType.equalsIgnoreCase("MTHR")) {
                                    DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Mother");
                                } else if (relationType.equalsIgnoreCase("H") || relationType.equalsIgnoreCase("HUSBAND") || relationType.equalsIgnoreCase("HSBN")) {
                                    DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Husband");
                                } else if (relationType.equalsIgnoreCase("W") || relationType.equalsIgnoreCase("WIFE")) {
                                    DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Wife");
                                } else if (relationType.equalsIgnoreCase("L") || relationType.equalsIgnoreCase("OTHER") || relationType.equalsIgnoreCase("O")) {
                                    DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Other");
                                } else if (relationType.equalsIgnoreCase("GMTH")) {
                                    DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Grand Mother");
                                } else if (relationType.equalsIgnoreCase("GFTH")) {
                                    DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText("Grand Father");
                                } else {
                                    DeclarationFormUpdateDialogFragment.this.binding.tvRelativeType.setText(relationType);
                                }
                            }
                            if (TextUtils.isEmpty(payloadNewMapping.getFullName()) && !TextUtils.isEmpty(payloadNewMapping.getFullNameL1())) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullNameL1()) ? "" : payloadNewMapping.getFullNameL1());
                                DeclarationFormUpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                            } else if (TextUtils.isEmpty(payloadNewMapping.getFullNameL1())) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                DeclarationFormUpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                            } else if (payloadNewMapping.getFullName().equalsIgnoreCase(payloadNewMapping.getFullNameL1())) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                DeclarationFormUpdateDialogFragment.this.binding.lvVernacularName.setVisibility(8);
                            } else {
                                DeclarationFormUpdateDialogFragment.this.binding.tvElectorName.setText(TextUtils.isEmpty(payloadNewMapping.getFullName()) ? "" : payloadNewMapping.getFullName());
                                DeclarationFormUpdateDialogFragment.this.binding.tvElectorNamev1.setText(TextUtils.isEmpty(payloadNewMapping.getFullNameL1()) ? "" : payloadNewMapping.getFullNameL1());
                            }
                            if (TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) && !TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1())) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1()) ? "" : payloadNewMapping.getFullRelativeNameL1());
                                DeclarationFormUpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                                return;
                            } else if (TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1())) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                DeclarationFormUpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                                return;
                            } else if (payloadNewMapping.getFullRelativeName().equalsIgnoreCase(payloadNewMapping.getFullRelativeNameL1())) {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                DeclarationFormUpdateDialogFragment.this.binding.relativeNameV1.setVisibility(8);
                                return;
                            } else {
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeName.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeName()) ? "" : payloadNewMapping.getFullRelativeName());
                                DeclarationFormUpdateDialogFragment.this.binding.tvRelativeNamev1.setText(TextUtils.isEmpty(payloadNewMapping.getFullRelativeNameL1()) ? "" : payloadNewMapping.getFullRelativeNameL1());
                                return;
                            }
                        }
                        DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.no_active_record));
                        return;
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
                    return;
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                DeclarationFormUpdateDialogFragment.this.utils.infoDialog(DeclarationFormUpdateDialogFragment.this.requireActivity(), DeclarationFormUpdateDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    public void getAllDistrict(final String oldState) {
        this.commomUtility.getSirDistrict(oldState, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda5
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllDistrict$11(oldState, i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllDistrict$11(final String str, int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda11
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
        System.out.println("zxnbchdbvfhvb12 " + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda0
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
        this.commomUtility.getDistrict(str, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment$$ExternalSyntheticLambda3
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
        this.commomUtility.getAllAC(oldState, requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.33
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    DeclarationFormUpdateDialogFragment.this.ACNameList.clear();
                    DeclarationFormUpdateDialogFragment.this.ACList.clear();
                    DeclarationFormUpdateDialogFragment.this.ACList = acList;
                    DeclarationFormUpdateDialogFragment.this.ACNameList = acNameList;
                    if (DeclarationFormUpdateDialogFragment.this.partNameList.size() > 0 && DeclarationFormUpdateDialogFragment.this.partList.size() > 0) {
                        DeclarationFormUpdateDialogFragment.this.partList.clear();
                        DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) DeclarationFormUpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) DeclarationFormUpdateDialogFragment.this.ACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    DeclarationFormUpdateDialogFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                    DeclarationFormUpdateDialogFragment.this.binding.oldAcNo.setThreshold(1);
                }
            }
        });
    }

    public void getallEFAc(String efState) {
        this.commomUtility.getAllAC(efState, requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.34
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    DeclarationFormUpdateDialogFragment.this.EfACNameList.clear();
                    DeclarationFormUpdateDialogFragment.this.EfACList.clear();
                    DeclarationFormUpdateDialogFragment.this.EfACList = acList;
                    DeclarationFormUpdateDialogFragment.this.EfACNameList = acNameList;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) DeclarationFormUpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) DeclarationFormUpdateDialogFragment.this.EfACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    DeclarationFormUpdateDialogFragment.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                    DeclarationFormUpdateDialogFragment.this.binding.efAcSpinner.setThreshold(1);
                }
            }
        });
    }

    public void getAllOldAc2025(String oldState) {
        this.commomUtility.getAllAC2025(oldState, this.token, this.atkband, this.rtkband, requireActivity(), new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.DeclarationFormUpdateDialogFragment.35
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    DeclarationFormUpdateDialogFragment.this.ACNameList.clear();
                    DeclarationFormUpdateDialogFragment.this.ACList.clear();
                    DeclarationFormUpdateDialogFragment.this.ACList = acList;
                    DeclarationFormUpdateDialogFragment.this.ACNameList = acNameList;
                    if (DeclarationFormUpdateDialogFragment.this.partNameList.size() > 0 && DeclarationFormUpdateDialogFragment.this.partList.size() > 0) {
                        DeclarationFormUpdateDialogFragment.this.partList.clear();
                        DeclarationFormUpdateDialogFragment.this.partNameList.clear();
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) DeclarationFormUpdateDialogFragment.this.requireActivity(), R.layout.blo_spinner_dropdown_new, (List) DeclarationFormUpdateDialogFragment.this.ACNameList);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    DeclarationFormUpdateDialogFragment.this.binding.oldAcNo.setAdapter(arrayAdapter);
                    DeclarationFormUpdateDialogFragment.this.binding.oldAcNo.setThreshold(1);
                }
            }
        });
    }
}
