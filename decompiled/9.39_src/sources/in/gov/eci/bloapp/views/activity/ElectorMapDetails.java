package in.gov.eci.bloapp.views.activity;

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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.ArraylistReturn;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityElectorMapDetailsBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.adapter.SearchLocationAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.LocationRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingList;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ElectorMapDetails extends BaseActivity {
    private String acNo;
    SearchLocationAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    ActivityElectorMapDetailsBinding binding;
    int currentAge;
    String currentEpic;
    String currentName;
    String currentRelativeName;
    String discrepancyFlag;
    private ArrayAdapter<String> districtadapter;
    String epic;
    int id;
    boolean isOldAcNoEntered;
    boolean isOldPartNoEntered;
    boolean isOldPartSerialNoEntered;
    boolean isoldStateEntered;
    String markedByBlo;
    List<MappingList> newbloMappedList;
    private String partNo;
    private String refreshToken;
    String relativetype;
    private String rtkband;
    private String state;
    private String token;
    UserClient userClient;
    Utils utils;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    private final String TAG = "ElectorMappingTAG";
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    ArrayList<String> ACList = new ArrayList<>();
    ArrayList<String> ACNameList = new ArrayList<>();
    ArrayList<String> partNameList = new ArrayList<>();
    ArrayList<Integer> partList = new ArrayList<>();
    String oldState = null;
    String oldAc = null;
    String OldPart = null;
    boolean isThisYou = false;
    Gson gson = new GsonBuilder().setLenient().create();
    String efState = null;
    String efPart = null;
    String efAc = null;
    String efDistrict = null;
    List<Integer> ACListef = new ArrayList();
    List<String> ACNameListef = new ArrayList();
    List<String> partNameListef = new ArrayList();
    List<Integer> partListef = new ArrayList();
    private ArrayList<String> district = new ArrayList<>();
    private ArrayList<String> districtcode = new ArrayList<>();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityElectorMapDetailsBinding activityElectorMapDetailsBindingInflate = ActivityElectorMapDetailsBinding.inflate(getLayoutInflater());
        this.binding = activityElectorMapDetailsBindingInflate;
        setContentView(activityElectorMapDetailsBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        if (getIntent() != null) {
            this.currentName = getIntent().getStringExtra("name");
            this.currentEpic = getIntent().getStringExtra("epic");
            this.currentRelativeName = getIntent().getStringExtra("relativeName");
            this.relativetype = getIntent().getStringExtra("relativetype");
            this.currentAge = getIntent().getIntExtra("currentAge", 0);
        }
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.userClient = (UserClient) ApiClient.getClient(this).create(UserClient.class);
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.StateList = SharedPref.getInstance(getApplicationContext()).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateNameList = SharedPref.getInstance(getApplicationContext()).getAcListName(Constants.STATE_LIST_NAME);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.StateNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.oldStateSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.binding.oldStateSpinner.setSelection(this.StateList.indexOf(this.state));
        this.binding.oldStateSpinner.setEnabled(true);
        initClickListener();
        this.binding.oldStateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                ElectorMapDetails.this.isoldStateEntered = true;
                ElectorMapDetails electorMapDetails = ElectorMapDetails.this;
                electorMapDetails.oldState = electorMapDetails.StateList.get(i);
                Log.d("ElectorMappingTAG", "AClist " + ElectorMapDetails.this.StateList);
                Log.d("ElectorMappingTAG", "Spinner value " + ElectorMapDetails.this.oldState);
                ElectorMapDetails electorMapDetails2 = ElectorMapDetails.this;
                electorMapDetails2.getAllAC(electorMapDetails2.oldState);
            }
        });
        this.binding.oldAcNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                ElectorMapDetails.this.isOldAcNoEntered = true;
                ElectorMapDetails.this.binding.oldPartNo.setSelection(0);
                ElectorMapDetails electorMapDetails = ElectorMapDetails.this;
                electorMapDetails.oldAc = electorMapDetails.ACList.get(i);
                ElectorMapDetails.this.binding.oldPslNo.setText("");
                Log.d("ElectorMappingTAG", "AClist " + ElectorMapDetails.this.ACList);
                Log.d("ElectorMappingTAG", "Spinner value " + ElectorMapDetails.this.oldAc);
                int i2 = Integer.parseInt(ElectorMapDetails.this.ACList.get(i));
                Log.d("ElectorMappingTAG", "acForPart " + i2);
                ElectorMapDetails.this.getPartByAc(i2, "case1");
            }
        });
        this.binding.oldPartNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                ElectorMapDetails.this.isOldPartNoEntered = true;
                ElectorMapDetails.this.binding.oldPslNo.setText("");
                ElectorMapDetails electorMapDetails = ElectorMapDetails.this;
                electorMapDetails.OldPart = electorMapDetails.partList.get(i - 1).toString();
            }
        });
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ElectorMapDetails.this.binding.oldStateSpinner.getSelectedItemPosition() == 0 || ElectorMapDetails.this.binding.oldAcNo.getSelectedItemPosition() == 0 || ElectorMapDetails.this.binding.oldPartNo.getSelectedItemPosition() == 0 || ElectorMapDetails.this.binding.oldPslNo.getText().toString().trim().length() <= 0) {
                    return;
                }
                ElectorMapDetails electorMapDetails = ElectorMapDetails.this;
                electorMapDetails.callVerifyRelativeApi(electorMapDetails.oldState, ElectorMapDetails.this.oldAc, ElectorMapDetails.this.OldPart, ElectorMapDetails.this.binding.oldPslNo.getText().toString().trim());
            }
        });
        initSearchByLocationValues();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initSearchByLocationValues() {
        this.utils = new Utils();
        selecttab(this.binding.searchAcPartPslMB, this.binding.searchLocationMB);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown_new, (List) this.StateNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.efStateSpinner.setAdapter(arrayAdapter);
        this.binding.efStateSpinner.setThreshold(1);
        this.binding.efStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                ElectorMapDetails.this.binding.efStateSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efDistrictSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                ElectorMapDetails.this.binding.efDistrictSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efAcSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                ElectorMapDetails.this.binding.efAcSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efPartSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                ElectorMapDetails.this.binding.efPartSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efPartSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                ElectorMapDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapDetails.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Part")) {
                    ElectorMapDetails.this.efPart = null;
                    ElectorMapDetails.this.binding.efPartSpinner.setText("");
                    ElectorMapDetails.this.binding.efPartSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_part));
                } else {
                    String string = parent.getItemAtPosition(i).toString();
                    ElectorMapDetails electorMapDetails = ElectorMapDetails.this;
                    electorMapDetails.efPart = String.valueOf(electorMapDetails.partListef.get(ElectorMapDetails.this.partNameListef.indexOf(string)));
                }
            }
        });
        this.binding.efStateSpinner.setOnItemClickListener(new AnonymousClass10());
        this.binding.efDistrictSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                ElectorMapDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapDetails.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select District")) {
                    ElectorMapDetails.this.efDistrict = null;
                    ElectorMapDetails.this.efAc = null;
                    ElectorMapDetails.this.partListef.clear();
                    ElectorMapDetails.this.partNameListef.clear();
                    ElectorMapDetails.this.partNameListef.add(ElectorMapDetails.this.getResources().getString(R.string.select_part));
                    ElectorMapDetails.this.partListef.add(0);
                    ElectorMapDetails.this.binding.efAcSpinner.setText("");
                    ElectorMapDetails.this.binding.efPartSpinner.setText("");
                    ElectorMapDetails.this.binding.efDistrictSpinner.setText("");
                    ElectorMapDetails.this.binding.efAcSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_assembly_constituency));
                    ElectorMapDetails.this.binding.efPartSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_part));
                    ElectorMapDetails.this.binding.efDistrictSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.blo_select_district));
                    if (ElectorMapDetails.this.ACListef.size() > 0) {
                        ElectorMapDetails.this.ACListef.clear();
                        ElectorMapDetails.this.ACNameListef.clear();
                    }
                    ElectorMapDetails electorMapDetails = ElectorMapDetails.this;
                    electorMapDetails.getAllACEf(electorMapDetails.efState);
                    return;
                }
                ElectorMapDetails.this.efAc = null;
                ElectorMapDetails.this.efPart = null;
                String str = (String) ElectorMapDetails.this.district.get(ElectorMapDetails.this.district.indexOf(parent.getItemAtPosition(i).toString()));
                int iIndexOf = ElectorMapDetails.this.district.indexOf(str);
                Log.d("CheckEffff : ", iIndexOf + " " + str);
                ElectorMapDetails electorMapDetails2 = ElectorMapDetails.this;
                electorMapDetails2.efDistrict = (String) electorMapDetails2.districtcode.get(iIndexOf);
                Log.d("efDistrict : ", ElectorMapDetails.this.efDistrict);
                ElectorMapDetails electorMapDetails3 = ElectorMapDetails.this;
                electorMapDetails3.getACByDistrict(Integer.parseInt(electorMapDetails3.efDistrict), ElectorMapDetails.this.efState);
                ElectorMapDetails.this.binding.efAcSpinner.setText("");
                ElectorMapDetails.this.binding.efPartSpinner.setText("");
                ElectorMapDetails.this.binding.efAcSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_assembly_constituency));
                ElectorMapDetails.this.binding.efPartSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_part));
                ElectorMapDetails.this.binding.selfName.setText("");
                ElectorMapDetails.this.binding.parentName.setText("");
                ElectorMapDetails.this.binding.grandparentName.setText("");
                if (ElectorMapDetails.this.partListef.size() <= 0 || ElectorMapDetails.this.partNameListef.size() <= 0) {
                    return;
                }
                ElectorMapDetails.this.partListef.clear();
                ElectorMapDetails.this.partNameListef.clear();
            }
        });
        this.binding.efAcSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                ElectorMapDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapDetails.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Assembly Constituency")) {
                    ElectorMapDetails.this.efAc = null;
                    ElectorMapDetails.this.efPart = null;
                    ElectorMapDetails.this.partListef.clear();
                    ElectorMapDetails.this.partNameListef.clear();
                    ElectorMapDetails.this.partNameListef.add(ElectorMapDetails.this.getResources().getString(R.string.select_part));
                    ElectorMapDetails.this.partListef.add(0);
                    ElectorMapDetails.this.binding.efAcSpinner.setText("");
                    ElectorMapDetails.this.binding.efPartSpinner.setText("");
                    ElectorMapDetails.this.binding.selfName.setText("");
                    ElectorMapDetails.this.binding.parentName.setText("");
                    ElectorMapDetails.this.binding.grandparentName.setText("");
                    ElectorMapDetails.this.binding.efPartSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_part));
                    ElectorMapDetails.this.binding.efAcSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_assembly_constituency));
                    return;
                }
                ElectorMapDetails.this.efPart = null;
                String string = parent.getItemAtPosition(i).toString();
                ElectorMapDetails electorMapDetails = ElectorMapDetails.this;
                electorMapDetails.efAc = String.valueOf(electorMapDetails.ACListef.get(ElectorMapDetails.this.ACNameListef.indexOf(string)));
                Log.d("OldAC : ", ElectorMapDetails.this.oldAc + "  " + ElectorMapDetails.this.ACListef.get(i).toString());
                ElectorMapDetails.this.binding.efPartSpinner.setText("");
                ElectorMapDetails.this.binding.efPartSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_part));
                ElectorMapDetails.this.binding.selfName.setText("");
                ElectorMapDetails.this.binding.parentName.setText("");
                ElectorMapDetails.this.binding.grandparentName.setText("");
                ElectorMapDetails.this.getPartByEfAc();
            }
        });
        this.binding.searchAcPartPslMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initSearchByLocationValues$1(view);
            }
        });
        this.binding.searchLocationMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initSearchByLocationValues$3(view);
            }
        });
        this.binding.searchButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initSearchByLocationValues$4(view);
            }
        });
        this.binding.txtVerifyContinueButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initSearchByLocationValues$5(view);
            }
        });
        this.binding.selfName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.13
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ElectorMapDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapDetails.this.binding.layoutVerifyButton.setVisibility(8);
                ElectorMapDetails.this.binding.tvRecordCount.setVisibility(8);
            }
        });
        this.binding.parentName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.14
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ElectorMapDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapDetails.this.binding.tvRecordCount.setVisibility(8);
                ElectorMapDetails.this.binding.layoutVerifyButton.setVisibility(8);
            }
        });
        this.binding.grandparentName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.15
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ElectorMapDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapDetails.this.binding.tvRecordCount.setVisibility(8);
                ElectorMapDetails.this.binding.layoutVerifyButton.setVisibility(8);
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.ElectorMapDetails$10, reason: invalid class name */
    class AnonymousClass10 implements AdapterView.OnItemClickListener {
        AnonymousClass10() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            ElectorMapDetails.this.binding.rvMapping.setVisibility(8);
            ElectorMapDetails.this.binding.layoutVerifyButton.setVisibility(8);
            if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select State")) {
                ElectorMapDetails.this.efState = null;
                ElectorMapDetails.this.efDistrict = null;
                ElectorMapDetails.this.efAc = null;
                ElectorMapDetails.this.efPart = null;
                ElectorMapDetails.this.ACNameListef.clear();
                ElectorMapDetails.this.ACListef.clear();
                ElectorMapDetails.this.ACNameListef.add(ElectorMapDetails.this.getResources().getString(R.string.select_assembly_constituency));
                ElectorMapDetails.this.ACListef.add(0);
                ElectorMapDetails.this.partListef.clear();
                ElectorMapDetails.this.partNameListef.clear();
                ElectorMapDetails.this.partNameListef.add(ElectorMapDetails.this.getResources().getString(R.string.select_part));
                ElectorMapDetails.this.partListef.add(0);
                ElectorMapDetails.this.district.clear();
                ElectorMapDetails.this.districtcode.clear();
                ElectorMapDetails.this.district.add("Select District");
                ElectorMapDetails.this.districtcode.add("0");
                ElectorMapDetails.this.binding.efAcSpinner.setText("");
                ElectorMapDetails.this.binding.efDistrictSpinner.setText("");
                ElectorMapDetails.this.binding.efPartSpinner.setText("");
                ElectorMapDetails.this.binding.efStateSpinner.setText("");
                ElectorMapDetails.this.binding.efStateSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.blo_select_state));
                ElectorMapDetails.this.binding.efAcSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_assembly_constituency));
                ElectorMapDetails.this.binding.efDistrictSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.blo_select_district));
                ElectorMapDetails.this.binding.efPartSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_part));
                return;
            }
            ElectorMapDetails.this.efDistrict = null;
            ElectorMapDetails.this.efAc = null;
            ElectorMapDetails.this.efPart = null;
            ElectorMapDetails.this.binding.efAcSpinner.setText("");
            ElectorMapDetails.this.binding.efDistrictSpinner.setText("");
            ElectorMapDetails.this.binding.efPartSpinner.setText("");
            ElectorMapDetails.this.binding.efAcSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_assembly_constituency));
            ElectorMapDetails.this.binding.efDistrictSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.blo_select_district));
            ElectorMapDetails.this.binding.efPartSpinner.setHint(ElectorMapDetails.this.getResources().getString(R.string.select_part));
            String string = parent.getItemAtPosition(i).toString();
            ElectorMapDetails electorMapDetails = ElectorMapDetails.this;
            electorMapDetails.efState = electorMapDetails.StateList.get(ElectorMapDetails.this.StateNameList.indexOf(string));
            Log.d("efState : ", ElectorMapDetails.this.efState);
            ElectorMapDetails.this.binding.selfName.setText("");
            ElectorMapDetails.this.binding.parentName.setText("");
            ElectorMapDetails.this.binding.grandparentName.setText("");
            ElectorMapDetails electorMapDetails2 = ElectorMapDetails.this;
            electorMapDetails2.getAllDistrict(electorMapDetails2.efState);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$10$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            ElectorMapDetails electorMapDetails = ElectorMapDetails.this;
            electorMapDetails.getAllACEf(electorMapDetails.efState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchByLocationValues$1(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initSearchByLocationValues$0();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchByLocationValues$0() {
        this.binding.searchTabLayout.setVisibility(0);
        this.binding.searchAcPart.setVisibility(0);
        this.binding.searchByLocationDetailsLl.setVisibility(8);
        this.binding.efStateSpinner.setText("");
        this.binding.efStateSpinner.setHint(getResources().getString(R.string.blo_select_state));
        if (this.ACListef.size() > 0 && this.ACNameListef.size() > 0) {
            this.binding.efAcSpinner.setText("");
            this.binding.efAcSpinner.setHint(getResources().getString(R.string.select_assembly_constituency));
        }
        if (this.district.size() > 0 && this.districtcode.size() > 0) {
            this.binding.efDistrictSpinner.setText("");
            this.binding.efDistrictSpinner.setHint(getResources().getString(R.string.blo_select_district));
        }
        if (this.partListef.size() > 0 && this.partNameListef.size() > 0) {
            this.binding.efPartSpinner.setText("");
            this.binding.efPartSpinner.setHint(getResources().getString(R.string.select_part));
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
    public /* synthetic */ void lambda$initSearchByLocationValues$3(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initSearchByLocationValues$2();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchByLocationValues$2() {
        this.binding.searchTabLayout.setVisibility(0);
        selecttab(this.binding.searchLocationMB, this.binding.searchAcPartPslMB);
        this.binding.searchByLocationDetailsLl.setVisibility(0);
        this.binding.grandparentNameLayout.setVisibility(8);
        this.binding.electorNameLayout.setVisibility(0);
        this.binding.parentNameLayout.setVisibility(0);
        this.binding.oldStateSpinner.setSelection(0);
        if (this.ACList.size() > 0 && this.ACNameList.size() > 0) {
            this.binding.oldAcNo.setSelection(0);
        }
        if (this.partList.size() > 0 && this.partNameList.size() > 0) {
            this.binding.oldPartNo.setSelection(0);
        }
        this.binding.oldPslNo.setText("");
        this.binding.searchAcPart.setVisibility(8);
        this.binding.layoutVerifyButton.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchByLocationValues$4(View view) {
        if (TextUtils.isEmpty(this.efState)) {
            showDialog1("Alert", "Please select State");
            return;
        }
        if (TextUtils.isEmpty(this.binding.selfName.getText().toString())) {
            showDialog1("Alert", "Please enter elector name ");
        } else if (TextUtils.isEmpty(this.binding.parentName.getText().toString())) {
            showDialog1("Alert", "Please enter relative name ");
        } else {
            callLocationApi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchByLocationValues$5(View view) {
        String oldStateCd;
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        if (this.newbloMappedList.size() > 0) {
            for (MappingList mappingList : this.newbloMappedList) {
                if (mappingList.isSelected()) {
                    oldStateCd = mappingList.getOldStateCd();
                    strValueOf = String.valueOf(mappingList.getOldAcNo());
                    strValueOf2 = String.valueOf(mappingList.getOldPartNumber());
                    strValueOf3 = String.valueOf(mappingList.getOldPartSerialNo());
                    mappingList.getAge();
                    mappingList.getId();
                }
            }
            oldStateCd = null;
            strValueOf = null;
            strValueOf2 = null;
            strValueOf3 = null;
        } else {
            oldStateCd = null;
            strValueOf = null;
            strValueOf2 = null;
            strValueOf3 = null;
        }
        this.isThisYou = true;
        this.alertDialog.show();
        callVerifyRelativeApi(oldStateCd, strValueOf, strValueOf2, strValueOf3);
    }

    public void getAllAC(String oldstate) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", oldstate);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getAllAssmbly(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.16
            /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapDetails] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                    ElectorMapDetails.this.ACNameList.clear();
                    ElectorMapDetails.this.ACList.clear();
                    ElectorMapDetails.this.ACNameList.add("Select Assembly Constituency");
                    ElectorMapDetails.this.ACList.add("");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = ElectorMapDetails.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        ElectorMapDetails.this.ACNameList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, "") + " - " + String.valueOf(asJsonObject.get("acName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        ElectorMapDetails.this.ACList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        ?? r3 = ElectorMapDetails.this;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.ACNameList);
                        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        ElectorMapDetails.this.binding.oldAcNo.setAdapter((SpinnerAdapter) arrayAdapter);
                    }
                    return;
                }
                Logger.e("AC List error", String.valueOf(response.code()));
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.e("AC List", t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getPartByAc(int ac, final String partCase) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", this.oldState);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        Log.d("ElectorMappingTAG", "getpartbyac " + ac);
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getPartByAc(ac, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.17
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapDetails] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    Log.d("StatusCodePart", String.valueOf(jsonObject.get("statusCode").getAsInt()));
                    ElectorMapDetails.this.partNameList.clear();
                    ElectorMapDetails.this.partList.clear();
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    if (ElectorMapDetails.this.partNameList.isEmpty()) {
                        ElectorMapDetails.this.partNameList.add(0, ElectorMapDetails.this.getString(R.string.select_part));
                    }
                    Iterator it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        JsonObject asJsonObject = ((JsonElement) it.next()).getAsJsonObject();
                        int asInt = asJsonObject.get("partNumber").getAsInt();
                        String asString = asJsonObject.get("partName").getAsString();
                        if (partCase.equalsIgnoreCase("case1")) {
                            ElectorMapDetails.this.partNameList.add(asInt + " - " + asString);
                            ElectorMapDetails.this.partList.add(Integer.valueOf(asInt));
                            ?? r0 = ElectorMapDetails.this;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r0, R.layout.blo_spinner_dropdown, r0.partNameList);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            ElectorMapDetails.this.binding.oldPartNo.setAdapter((SpinnerAdapter) arrayAdapter);
                        }
                    }
                    return;
                }
                Logger.e("Part List error", String.valueOf(response.code()));
                Toast.makeText((Context) ElectorMapDetails.this, (CharSequence) "Failed to get Part List", 1).show();
            }
        });
    }

    void callVerifyRelativeApi(final String oldStateNew, final String oldAcNew, final String oldPartNew, final String oldPslNew) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", oldStateNew);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("acNo", Integer.valueOf(Integer.parseInt(oldAcNew)));
        map2.put("partNo", Integer.valueOf(Integer.parseInt(oldPartNew)));
        map2.put("serialNo", Integer.valueOf(Integer.parseInt(oldPslNew)));
        map2.put("currentEpic", this.currentEpic);
        map2.put("currentAge", Integer.valueOf(this.currentAge));
        this.alertDialog.show();
        Logger.d("ElectorMappingTAG", "oldstate " + this.oldState);
        this.userClient.checkMapping(map2, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.18
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                String strOptString;
                String strOptString2;
                JSONObject jSONObject;
                if (response.isSuccessful() && response.body() != null) {
                    ElectorMapDetails.this.alertDialog.dismiss();
                    try {
                        JSONObject jSONObject2 = new JSONArray(ElectorMapDetails.this.gson.toJson(((JsonObject) response.body()).get("payload"))).getJSONObject(0);
                        ElectorMapDetails.this.id = jSONObject2.optInt("id", 0);
                        String strOptString3 = jSONObject2.optString("epic", null);
                        String strOptString4 = jSONObject2.optString(Constants.FIRST_NAME, null);
                        String strOptString5 = jSONObject2.optString(Constants.LAST_NAME, null);
                        String strOptString6 = jSONObject2.optString("firstNameTrans", null);
                        String strOptString7 = jSONObject2.optString("lastNameTrans", null);
                        String strOptString8 = jSONObject2.optString("relativeFName", null);
                        String strOptString9 = jSONObject2.optString("relativeLName", null);
                        String strOptString10 = jSONObject2.optString("relativeFnameTrans", null);
                        String strOptString11 = jSONObject2.optString("relativeLnameTrans", null);
                        String strOptString12 = jSONObject2.optString("relationType", null);
                        ElectorMapDetails.this.markedByBlo = jSONObject2.optString("markedByBlo", null);
                        String strOptString13 = jSONObject2.optString("bloMappedStateCode", null);
                        String strOptString14 = jSONObject2.optString("bloMappedAcNo", null);
                        String strOptString15 = jSONObject2.optString("bloMappedPartNo", null);
                        String strOptString16 = jSONObject2.optString("bloMappedEpicNo", null);
                        String json = ElectorMapDetails.this.gson.toJson(((JsonObject) response.body()).get("data"));
                        if (json.contains("null") || (jSONObject = new JSONArray(json).getJSONObject(0)) == null) {
                            strOptString = "";
                            strOptString2 = strOptString;
                        } else {
                            strOptString = jSONObject.optString("name", null);
                            strOptString2 = jSONObject.optString("mobileNumber", null);
                        }
                        String str = TextUtils.isEmpty(strOptString3) ? "" : strOptString3;
                        if (TextUtils.isEmpty(strOptString4)) {
                            strOptString4 = "";
                        }
                        if (TextUtils.isEmpty(strOptString5)) {
                            strOptString5 = "";
                        }
                        if (TextUtils.isEmpty(strOptString6)) {
                            strOptString6 = "";
                        }
                        if (TextUtils.isEmpty(strOptString7)) {
                            strOptString7 = "";
                        }
                        if (TextUtils.isEmpty(strOptString8)) {
                            strOptString8 = "";
                        }
                        if (TextUtils.isEmpty(strOptString9)) {
                            strOptString9 = "";
                        }
                        if (TextUtils.isEmpty(strOptString10)) {
                            strOptString10 = "";
                        }
                        if (TextUtils.isEmpty(strOptString11)) {
                            strOptString11 = "";
                        }
                        String str2 = TextUtils.isEmpty(strOptString12) ? "" : strOptString12;
                        if (!TextUtils.isEmpty(ElectorMapDetails.this.markedByBlo) && ElectorMapDetails.this.markedByBlo.equalsIgnoreCase("Y")) {
                            ElectorMapDetails.this.showMAppedBloDialog(strOptString13, strOptString14, strOptString15, strOptString16, strOptString, strOptString2);
                            return;
                        }
                        ElectorMapDetails.this.showVerifyDetailsDialog(strOptString4 + " " + strOptString5, strOptString8 + " " + strOptString9, strOptString6 + " " + strOptString7, strOptString10 + " " + strOptString11, str2, str, oldStateNew, oldAcNew, oldPartNew, oldPslNew);
                        return;
                    } catch (JSONException e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText((Context) ElectorMapDetails.this, (CharSequence) "Something went wrong", 1).show();
                        return;
                    }
                }
                if (response.code() == 404) {
                    ElectorMapDetails.this.alertDialog.dismiss();
                    ElectorMapDetails.this.isThisYou = false;
                    ElectorMapDetails.this.showDialog1("Alert", "No record found");
                } else {
                    ElectorMapDetails.this.isThisYou = false;
                    try {
                        ElectorMapDetails.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).getString("message"));
                        ElectorMapDetails.this.alertDialog.dismiss();
                    } catch (Exception e2) {
                        Logger.d("ElectorMappingTAG", e2.toString());
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                ElectorMapDetails.this.alertDialog.dismiss();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    void showVerifyDetailsDialog(String name, String relativeName, String nameTrans, String relativeNameTrans, String typeRelation, String epic, final String oldStateNew, final String oldAcNew, final String oldPartNew, final String oldPslNew) {
        Dialog dialog;
        Button button;
        int i;
        Dialog dialog2 = new Dialog(this);
        dialog2.setContentView(R.layout.dialog_verify_elector);
        dialog2.getWindow().setLayout(-1, -2);
        dialog2.setCancelable(true);
        Button button2 = (Button) dialog2.findViewById(R.id.btnYes);
        Button button3 = (Button) dialog2.findViewById(R.id.btnNo);
        TextView textView = (TextView) dialog2.findViewById(R.id.txtName);
        LinearLayout linearLayout = (LinearLayout) dialog2.findViewById(R.id.linearRelativeTrans);
        LinearLayout linearLayout2 = (LinearLayout) dialog2.findViewById(R.id.linearNameTrans);
        TextView textView2 = (TextView) dialog2.findViewById(R.id.txtNameTrans);
        TextView textView3 = (TextView) dialog2.findViewById(R.id.txtCurrentName);
        TextView textView4 = (TextView) dialog2.findViewById(R.id.txtCurrentRelativeName);
        TextView textView5 = (TextView) dialog2.findViewById(R.id.txtCurrentEpic);
        TextView textView6 = (TextView) dialog2.findViewById(R.id.txtRelativeName);
        TextView textView7 = (TextView) dialog2.findViewById(R.id.txtRelativeNameTrans);
        TextView textView8 = (TextView) dialog2.findViewById(R.id.txtTypeRelation);
        TextView textView9 = (TextView) dialog2.findViewById(R.id.txtEpic);
        if (TextUtils.isEmpty(nameTrans)) {
            dialog = dialog2;
            button = button2;
            i = 1;
        } else {
            button = button2;
            dialog = dialog2;
            i = 1;
            if (nameTrans.length() == 1) {
                linearLayout2.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(relativeNameTrans) && relativeNameTrans.length() == i) {
            linearLayout.setVisibility(8);
        }
        textView.setText(name);
        textView2.setText(nameTrans);
        textView6.setText(relativeName);
        textView7.setText(relativeNameTrans);
        if (!TextUtils.isEmpty(this.currentName)) {
            textView3.setText(this.currentName);
        }
        if (!TextUtils.isEmpty(this.currentEpic)) {
            textView5.setText(this.currentEpic);
        }
        if (!TextUtils.isEmpty(this.currentRelativeName)) {
            textView4.setText(this.currentRelativeName);
        }
        if (!TextUtils.isEmpty(typeRelation)) {
            if (typeRelation.equals("GMTH")) {
                textView8.setText("Grand Mother");
            } else if (typeRelation.equals("GFTH")) {
                textView8.setText("Grand Father");
            } else if (typeRelation.equals("MTHR")) {
                textView8.setText("Mother");
            } else if (typeRelation.equals("FTHR") || typeRelation.equals("F")) {
                textView8.setText("Father");
            } else if (typeRelation.equals("HSBN") || typeRelation.equals("H")) {
                textView8.setText("Husband");
            } else if (typeRelation.equals("OTHR")) {
                textView8.setText("Other");
            } else if (TextUtils.isEmpty(typeRelation)) {
                textView8.setText("");
            } else {
                textView8.setText(typeRelation);
            }
        }
        textView9.setText(epic);
        final Dialog dialog3 = dialog;
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorMapDetails.this.isThisYou = true;
                ElectorMapDetails.this.validateMapping(oldStateNew, oldAcNew, oldPartNew, oldPslNew);
                dialog3.dismiss();
            }
        });
        final Dialog dialog4 = dialog;
        button3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorMapDetails.this.isThisYou = false;
                dialog4.dismiss();
            }
        });
        dialog4.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void showMAppedBloDialog(String state, String Ac, String part, String epic, String bloNAme, String Blophone) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_blo_mapped_elector);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(true);
        Button button = (Button) dialog.findViewById(R.id.btnYes);
        Button button2 = (Button) dialog.findViewById(R.id.btnNo);
        TextView textView = (TextView) dialog.findViewById(R.id.txtState);
        TextView textView2 = (TextView) dialog.findViewById(R.id.txtAc);
        TextView textView3 = (TextView) dialog.findViewById(R.id.txtPart);
        TextView textView4 = (TextView) dialog.findViewById(R.id.txtEpic);
        TextView textView5 = (TextView) dialog.findViewById(R.id.txtBLOName);
        TextView textView6 = (TextView) dialog.findViewById(R.id.txtbloPhone);
        TextView textView7 = (TextView) dialog.findViewById(R.id.txtBLoDetails);
        textView.setText(state);
        textView2.setText(Ac);
        textView3.setText(part);
        textView4.setText(epic);
        if (TextUtils.isEmpty(bloNAme) && TextUtils.isEmpty(Blophone)) {
            textView6.setVisibility(8);
            textView5.setVisibility(8);
            textView7.setVisibility(8);
        } else {
            textView5.setText(bloNAme);
            textView6.setText(Blophone);
            textView6.setVisibility(0);
            textView5.setVisibility(0);
            textView7.setVisibility(0);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorMapDetails.this.isThisYou = true;
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorMapDetails.this.isThisYou = false;
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$6(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog1$6(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        Intent intent = new Intent((Context) this, (Class<?>) ElectorMappingActivity.class);
        intent.setFlags(603979776);
        intent.putExtra("restart", true);
        startActivity(intent);
        dialogInterface.dismiss();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$7(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$7(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateMapping(String oldStateNew, String oldAcNew, String oldPartNew, String oldPslNew) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("Content-Type", "application/json");
        this.alertDialog.show();
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("oldAcNo", Integer.valueOf(Integer.parseInt(oldAcNew)));
        map2.put("oldPartNo", Integer.valueOf(Integer.parseInt(oldPartNew)));
        map2.put("oldSerialNo", Integer.valueOf(Integer.parseInt(oldPslNew)));
        map2.put("epicNo", getIntent().getStringExtra("epic"));
        map2.put("id", Integer.valueOf(this.id));
        map2.put("acNo", Integer.valueOf(Integer.parseInt(getIntent().getStringExtra("ac"))));
        map2.put("partNo", Integer.valueOf(Integer.parseInt(getIntent().getStringExtra("part"))));
        map2.put("serialNo", Integer.valueOf(Integer.parseInt(getIntent().getStringExtra("psl"))));
        map2.put("stateCd", this.state);
        map2.put("oldStateCd", oldStateNew);
        Log.d("ElectorMappingTAG", map2.toString());
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).updateErollData(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.23
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        ElectorMapDetails.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).getString("message"));
                        return;
                    }
                    Logger.d("ElectorMappingTAG", String.valueOf(response.body()));
                    ElectorMapDetails.this.showDialog1("", String.valueOf(((JsonObject) response.body()).get("message")));
                    if (ElectorMapDetails.this.alertDialog != null) {
                        ElectorMapDetails.this.alertDialog.dismiss();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (ElectorMapDetails.this.alertDialog != null) {
                    ElectorMapDetails.this.alertDialog.dismiss();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void callLocationApi() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("applicantName", this.binding.selfName.getText().toString());
        map2.put("relativeName", this.binding.parentName.getText().toString());
        map2.put("stateCd", this.efState);
        map2.put("mappingType", "self");
        map2.put("districtNo", this.efDistrict);
        map2.put("acNo", this.efAc);
        map2.put("partNo", this.efPart);
        map2.put("efEpicNumber", this.currentEpic);
        map2.put("efApplicantName", this.currentName);
        map2.put("efRelativeName", this.currentRelativeName);
        map2.put("efStateCd", this.state);
        map2.put("efRelationType", this.relativetype);
        map2.put("efAge", Integer.valueOf(this.currentAge));
        map2.put("efAcNo", this.acNo);
        map2.put("efPartNo", this.partNo);
        map2.put("efPartSerialNo", Integer.valueOf(Integer.parseInt(getIntent().getStringExtra("psl"))));
        Call<LocationRoot> searchLocationFamily = ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getSearchLocationFamily(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        searchLocationFamily.enqueue(new AnonymousClass24());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.ElectorMapDetails$24, reason: invalid class name */
    class AnonymousClass24 implements Callback<LocationRoot> {
        AnonymousClass24() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v17, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapDetails] */
        /* JADX WARN: Type inference failed for: r1v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapDetails] */
        /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapDetails] */
        /* JADX WARN: Type inference failed for: r7v16, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapDetails] */
        public void onResponse(Call<LocationRoot> call, Response<LocationRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    ElectorMapDetails.this.newbloMappedList = ((LocationRoot) response.body()).payload.mappingList;
                    if (ElectorMapDetails.this.newbloMappedList == null || ElectorMapDetails.this.newbloMappedList.size() <= 0) {
                        ElectorMapDetails.this.binding.tvRecordCount.setVisibility(8);
                        Utils utils = new Utils();
                        ?? r7 = ElectorMapDetails.this;
                        utils.infoDialog(r7, r7.getResources().getString(R.string.alertMsg), ElectorMapDetails.this.getResources().getString(R.string.no_data_found));
                    } else {
                        Logger.d("blo list size", "" + ElectorMapDetails.this.newbloMappedList.size());
                        ElectorMapDetails.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(ElectorMapDetails.this));
                        if (ElectorMapDetails.this.newbloMappedList != null && !ElectorMapDetails.this.newbloMappedList.isEmpty()) {
                            ElectorMapDetails.this.binding.rvMapping.setVisibility(0);
                            ElectorMapDetails.this.binding.tvRecordCount.setVisibility(0);
                            ElectorMapDetails.this.binding.tvRecordCount.setText(ElectorMapDetails.this.getResources().getString(R.string.total_record) + " " + ElectorMapDetails.this.newbloMappedList.size());
                            ElectorMapDetails electorMapDetails = ElectorMapDetails.this;
                            ?? r1 = ElectorMapDetails.this;
                            electorMapDetails.adapter = new SearchLocationAdapter(r1, r1.newbloMappedList, new SearchLocationAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$24$$ExternalSyntheticLambda0
                                @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.SearchLocationAdapter.OnItemSelectedListener
                                public final void onItemSelected() {
                                    this.f$0.lambda$onResponse$0();
                                }
                            });
                            ElectorMapDetails.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(ElectorMapDetails.this));
                            ElectorMapDetails.this.binding.rvMapping.setNestedScrollingEnabled(false);
                            ElectorMapDetails.this.binding.rvMapping.setAdapter(ElectorMapDetails.this.adapter);
                        }
                    }
                } catch (Exception unused) {
                }
                ElectorMapDetails.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                if (ElectorMapDetails.this.alertDialog != null) {
                    ElectorMapDetails.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            try {
                if (ElectorMapDetails.this.alertDialog != null) {
                    ElectorMapDetails.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                if (TextUtils.isEmpty(strOptString)) {
                    String strOptString2 = jSONObject.optString("error");
                    Utils utils2 = new Utils();
                    ?? r3 = ElectorMapDetails.this;
                    utils2.infoDialog(r3, r3.getResources().getString(R.string.alertMsg), strOptString2);
                } else {
                    Utils utils3 = new Utils();
                    ?? r2 = ElectorMapDetails.this;
                    utils3.infoDialog(r2, r2.getResources().getString(R.string.alertMsg), strOptString);
                }
                Logger.e("TAG", strOptString);
                if (ElectorMapDetails.this.alertDialog != null) {
                    ElectorMapDetails.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (ElectorMapDetails.this.alertDialog != null) {
                    ElectorMapDetails.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            ElectorMapDetails.this.binding.layoutVerifyButton.setVisibility(0);
        }

        public void onFailure(Call<LocationRoot> call, Throwable t) {
            if (ElectorMapDetails.this.alertDialog != null) {
                ElectorMapDetails.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void selecttab(MaterialButton selected, MaterialButton other) {
        selected.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.new_tab_color));
        selected.setTextColor(ContextCompat.getColor(this, R.color.blo_white));
        other.setBackgroundTintList(ContextCompat.getColorStateList(this, android.R.color.transparent));
        other.setTextColor(ContextCompat.getColor(this, R.color.blo_black));
        other.setStrokeWidth(2);
        other.setStrokeColor(ContextCompat.getColorStateList(this, R.color.blo_light_grey));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getAllDistrict(final String oldState) {
        this.commomUtility.getSirDistrict(oldState, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), this, new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda6
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllDistrict$11(oldState, i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getAllDistrict$11(final String str, int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(this, this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda8
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$getAllDistrict$10(str, i2, str2, str3);
                }
            });
            return;
        }
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, R.layout.blo_spinner_dropdown_new, (List<String>) this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.efDistrictSpinner.setAdapter(this.districtadapter);
        this.binding.efDistrictSpinner.setThreshold(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getAllDistrict$10(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb12 " + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(this, this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getAllDistrict$8(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        this.refreshToken = str3;
        SharedPref.getInstance(this).setRefreshToken(str3);
        SharedPref.getInstance(this).setToken("Bearer " + str2);
        this.commomUtility.getSirDistrict(str, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), this, new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails$$ExternalSyntheticLambda2
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllDistrict$9(i2, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getAllDistrict$8(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(this).setIsLoggedIn(false);
        SharedPref.getInstance(this).setLocaleBool(false);
        startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getAllDistrict$9(int i, ArrayList arrayList, ArrayList arrayList2) {
        this.district = arrayList;
        this.districtcode = arrayList2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, R.layout.blo_spinner_dropdown_new, (List<String>) this.district);
        this.districtadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.efDistrictSpinner.setThreshold(1);
        this.binding.efDistrictSpinner.setAdapter(this.districtadapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getAllACEf(String oldstate) {
        this.commomUtility.getAllAC(oldstate, this, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.25
            /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapDetails] */
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    ElectorMapDetails.this.ACNameListef.clear();
                    ElectorMapDetails.this.ACListef.clear();
                    ElectorMapDetails.this.ACListef = acList;
                    ElectorMapDetails.this.ACNameListef = acNameList;
                    ?? r3 = ElectorMapDetails.this;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown_new, r3.ACNameListef);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    ElectorMapDetails.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                    ElectorMapDetails.this.binding.efAcSpinner.setThreshold(1);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getACByDistrict(int oldDistrict, String oldState) {
        this.commomUtility.getAssmblyByDist(this, oldDistrict, oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.26
            /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapDetails] */
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    ElectorMapDetails.this.ACNameListef.clear();
                    ElectorMapDetails.this.ACListef.clear();
                    ElectorMapDetails.this.ACListef = acList;
                    ElectorMapDetails.this.ACNameListef = acNameList;
                    ?? r3 = ElectorMapDetails.this;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown_new, r3.ACNameListef);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    ElectorMapDetails.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                    ElectorMapDetails.this.binding.efAcSpinner.setThreshold(1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getPartByEfAc() {
        this.commomUtility.getPartByAc(this, Integer.parseInt(this.efAc), this.efState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.27
            /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapDetails] */
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    ElectorMapDetails.this.partListef.clear();
                    ElectorMapDetails.this.partNameListef.clear();
                    ElectorMapDetails.this.partListef = acList;
                    ElectorMapDetails.this.partNameListef = acNameList;
                    ?? r3 = ElectorMapDetails.this;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown_new, r3.partNameListef);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    ElectorMapDetails.this.binding.efPartSpinner.setAdapter(arrayAdapter);
                    ElectorMapDetails.this.binding.efPartSpinner.setThreshold(1);
                }
            }
        });
    }

    public void clearLocationVariables() {
        this.efState = null;
        this.efAc = null;
        this.efDistrict = null;
        this.efPart = null;
        if (this.ACListef.size() > 0) {
            this.ACNameListef.size();
        }
        if (this.district.size() > 0) {
            this.districtcode.size();
        }
        if (this.partListef.size() > 0) {
            this.partNameListef.size();
        }
        this.binding.selfName.setText("");
        this.binding.parentName.setText("");
        this.binding.grandparentName.setText("");
        this.binding.rvMapping.setVisibility(8);
        this.binding.tvRecordCount.setVisibility(8);
    }

    private void validateMappingef(String oldState, String oldAC, String oldPart, String oldSerial, String iditem) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("Content-Type", "application/json");
        this.alertDialog.show();
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("oldAcNo", Integer.valueOf(Integer.parseInt(oldAC)));
        map2.put("oldPartNo", Integer.valueOf(Integer.parseInt(oldPart)));
        map2.put("oldSerialNo", Integer.valueOf(Integer.parseInt(oldSerial)));
        map2.put("epicNo", getIntent().getStringExtra("epic"));
        map2.put("id", iditem);
        map2.put("acNo", Integer.valueOf(Integer.parseInt(getIntent().getStringExtra("ac"))));
        map2.put("partNo", Integer.valueOf(Integer.parseInt(getIntent().getStringExtra("part"))));
        map2.put("serialNo", Integer.valueOf(Integer.parseInt(getIntent().getStringExtra("psl"))));
        map2.put("stateCd", this.state);
        map2.put("oldStateCd", oldState);
        Log.d("ElectorMappingTAG", map2.toString());
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).updateErollData(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapDetails.28
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        ElectorMapDetails.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).getString("message"));
                        return;
                    }
                    Logger.d("ElectorMappingTAG", String.valueOf(response.body()));
                    ElectorMapDetails.this.showDialog1("", String.valueOf(((JsonObject) response.body()).get("message")));
                    if (ElectorMapDetails.this.alertDialog != null) {
                        ElectorMapDetails.this.alertDialog.dismiss();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (ElectorMapDetails.this.alertDialog != null) {
                    ElectorMapDetails.this.alertDialog.dismiss();
                }
            }
        });
    }
}
