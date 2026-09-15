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
import android.widget.Spinner;
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
import in.gov.eci.bloapp.databinding.ActivityElecotrMapSelfDetailsBinding;
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
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ElectorMapSelfDetails extends BaseActivity {
    private String acNo;
    SearchLocationAdapter adapter;
    AlertDialog alertDialog;
    private String atkband;
    ActivityElecotrMapSelfDetailsBinding binding;
    String currentAge;
    String currentEpic;
    String currentName;
    String currentRelativeName;
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
    private String rtkband;
    private String state;
    private String token;
    UserClient userClient;
    Utils utils;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    private final String TAG = "ElectorMappingSelfTAG";
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();
    String oldState = null;
    String oldAc = null;
    String OldPart = null;
    ArrayList<String> ACList = new ArrayList<>();
    ArrayList<String> ACNameList = new ArrayList<>();
    ArrayList<String> partNameList = new ArrayList<>();
    ArrayList<Integer> partList = new ArrayList<>();
    boolean isThisYou = false;
    String releationCode = "";
    Gson gson = new GsonBuilder().setLenient().create();
    ArrayList<String> relationNameList = new ArrayList<>();
    ArrayList<String> relationCodeList = new ArrayList<>();
    String selectRelationType = "Select Relation Type";
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
        ActivityElecotrMapSelfDetailsBinding activityElecotrMapSelfDetailsBindingInflate = ActivityElecotrMapSelfDetailsBinding.inflate(getLayoutInflater());
        this.binding = activityElecotrMapSelfDetailsBindingInflate;
        setContentView(activityElecotrMapSelfDetailsBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        if (getIntent() != null) {
            this.currentName = getIntent().getStringExtra("name");
            this.currentEpic = getIntent().getStringExtra("epic");
            this.currentRelativeName = getIntent().getStringExtra("relativeName");
            this.currentAge = getIntent().getStringExtra("age");
        }
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.userClient = (UserClient) ApiClient.getClient(this).create(UserClient.class);
        this.relationNameList = SharedPref.getInstance(getApplicationContext()).getRelativeListCode(Constants.RELATIVE_MAPPING_LIST_NAME);
        this.relationCodeList = SharedPref.getInstance(getApplicationContext()).getRelativeListName(Constants.RELATIVE_MAPPING_LIST_CODE);
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
        this.binding.oldStateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                ElectorMapSelfDetails.this.isoldStateEntered = true;
                ElectorMapSelfDetails electorMapSelfDetails = ElectorMapSelfDetails.this;
                electorMapSelfDetails.oldState = electorMapSelfDetails.StateList.get(i);
                Log.d("ElectorMappingSelfTAG", "AClist " + ElectorMapSelfDetails.this.StateList);
                Log.d("ElectorMappingSelfTAG", "Spinner value " + ElectorMapSelfDetails.this.oldState);
                ElectorMapSelfDetails electorMapSelfDetails2 = ElectorMapSelfDetails.this;
                electorMapSelfDetails2.getAllAC(electorMapSelfDetails2.oldState);
            }
        });
        this.binding.oldAcNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                ElectorMapSelfDetails.this.isOldAcNoEntered = true;
                ElectorMapSelfDetails.this.binding.oldPartNo.setSelection(0);
                ElectorMapSelfDetails electorMapSelfDetails = ElectorMapSelfDetails.this;
                electorMapSelfDetails.oldAc = electorMapSelfDetails.ACList.get(i);
                ElectorMapSelfDetails.this.binding.oldPslNo.setText("");
                Log.d("ElectorMappingSelfTAG", "AClist " + ElectorMapSelfDetails.this.ACList);
                Log.d("ElectorMappingSelfTAG", "Spinner value " + ElectorMapSelfDetails.this.oldAc);
                int i2 = Integer.parseInt(ElectorMapSelfDetails.this.ACList.get(i));
                Log.d("ElectorMappingSelfTAG", "acForPart " + i2);
                ElectorMapSelfDetails.this.getPartByAc(i2, "case1");
            }
        });
        this.binding.oldPartNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    return;
                }
                ElectorMapSelfDetails.this.isOldPartNoEntered = true;
                ElectorMapSelfDetails.this.binding.oldPslNo.setText("");
                ElectorMapSelfDetails electorMapSelfDetails = ElectorMapSelfDetails.this;
                electorMapSelfDetails.OldPart = electorMapSelfDetails.partList.get(i - 1).toString();
            }
        });
        this.binding.txtVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ElectorMapSelfDetails.this.binding.oldStateSpinner.getSelectedItemPosition() == 0 || ElectorMapSelfDetails.this.binding.oldAcNo.getSelectedItemPosition() == 0 || ElectorMapSelfDetails.this.binding.oldPartNo.getSelectedItemPosition() == 0 || ElectorMapSelfDetails.this.binding.oldPslNo.getText().toString().trim().length() <= 0) {
                    return;
                }
                ElectorMapSelfDetails electorMapSelfDetails = ElectorMapSelfDetails.this;
                electorMapSelfDetails.callVerifyRelativeApi(electorMapSelfDetails.oldState, ElectorMapSelfDetails.this.oldAc, ElectorMapSelfDetails.this.OldPart, ElectorMapSelfDetails.this.binding.oldPslNo.getText().toString().trim());
            }
        });
        initSearchByLocationValues();
    }

    public void getAllAC(String oldstate) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", oldstate);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getAllAssmbly(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.5
            /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                    ElectorMapSelfDetails.this.ACNameList.clear();
                    ElectorMapSelfDetails.this.ACList.clear();
                    ElectorMapSelfDetails.this.ACNameList.add("Select Assembly Constituency");
                    ElectorMapSelfDetails.this.ACList.add("");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = ElectorMapSelfDetails.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        ElectorMapSelfDetails.this.ACNameList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, "") + " - " + String.valueOf(asJsonObject.get("acName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        ElectorMapSelfDetails.this.ACList.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        ?? r3 = ElectorMapSelfDetails.this;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.ACNameList);
                        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                        ElectorMapSelfDetails.this.binding.oldAcNo.setAdapter((SpinnerAdapter) arrayAdapter);
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
        Log.d("ElectorMappingSelfTAG", "getpartbyac " + ac);
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getPartByAc(ac, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.6
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails] */
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    Log.d("StatusCodePart", String.valueOf(jsonObject.get("statusCode").getAsInt()));
                    ElectorMapSelfDetails.this.partNameList.clear();
                    ElectorMapSelfDetails.this.partList.clear();
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    if (ElectorMapSelfDetails.this.partNameList.isEmpty()) {
                        ElectorMapSelfDetails.this.partNameList.add(0, ElectorMapSelfDetails.this.getString(R.string.select_part));
                    }
                    Iterator it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        JsonObject asJsonObject = ((JsonElement) it.next()).getAsJsonObject();
                        int asInt = asJsonObject.get("partNumber").getAsInt();
                        String asString = asJsonObject.get("partName").getAsString();
                        if (partCase.equalsIgnoreCase("case1")) {
                            ElectorMapSelfDetails.this.partNameList.add(asInt + " - " + asString);
                            ElectorMapSelfDetails.this.partList.add(Integer.valueOf(asInt));
                            ?? r0 = ElectorMapSelfDetails.this;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r0, R.layout.blo_spinner_dropdown, r0.partNameList);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            ElectorMapSelfDetails.this.binding.oldPartNo.setAdapter((SpinnerAdapter) arrayAdapter);
                        }
                    }
                    return;
                }
                Logger.e("Part List error", String.valueOf(response.code()));
                Toast.makeText((Context) ElectorMapSelfDetails.this, (CharSequence) "Failed to get Part List", 1).show();
            }
        });
    }

    void callVerifyRelativeApi(final String oldStateNew, String oldAcNew, String oldPartNew, String oldPslNew) {
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
        map2.put("currentEpic", null);
        map2.put("currentAge", null);
        this.alertDialog.show();
        Logger.d("ElectorMappingSelfTAG", "oldstate " + this.oldState);
        this.userClient.checkMapping(map2, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.7
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ElectorMapSelfDetails.this.alertDialog.dismiss();
                    try {
                        JSONObject jSONObject = new JSONArray(ElectorMapSelfDetails.this.gson.toJson(((JsonObject) response.body()).get("payload"))).getJSONObject(0);
                        ElectorMapSelfDetails.this.id = jSONObject.optInt("id", 0);
                        String strOptString = jSONObject.optString("epic", null);
                        String strOptString2 = jSONObject.optString(Constants.FIRST_NAME, null);
                        String strOptString3 = jSONObject.optString(Constants.LAST_NAME, null);
                        String strOptString4 = jSONObject.optString("firstNameTrans", null);
                        String strOptString5 = jSONObject.optString("lastNameTrans", null);
                        String strOptString6 = jSONObject.optString("relativeFName", null);
                        String strOptString7 = jSONObject.optString("relativeLName", null);
                        String strOptString8 = jSONObject.optString("relativeFnameTrans", null);
                        String strOptString9 = jSONObject.optString("relativeLnameTrans", null);
                        String strOptString10 = jSONObject.optString("relationType", null);
                        String str = TextUtils.isEmpty(strOptString) ? "" : strOptString;
                        if (TextUtils.isEmpty(strOptString2)) {
                            strOptString2 = "";
                        }
                        if (TextUtils.isEmpty(strOptString3)) {
                            strOptString3 = "";
                        }
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
                        ElectorMapSelfDetails.this.showVerifyDetailsDialog(strOptString2 + StringUtils.SPACE + strOptString3, strOptString6 + StringUtils.SPACE + strOptString7, strOptString4 + StringUtils.SPACE + strOptString5, strOptString8 + StringUtils.SPACE + strOptString9, TextUtils.isEmpty(strOptString10) ? "" : strOptString10, str, oldStateNew);
                        return;
                    } catch (JSONException e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText((Context) ElectorMapSelfDetails.this, (CharSequence) "Something went wrong", 1).show();
                        return;
                    }
                }
                ElectorMapSelfDetails.this.isThisYou = false;
                try {
                    ElectorMapSelfDetails.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).getString("message"));
                    ElectorMapSelfDetails.this.alertDialog.dismiss();
                } catch (Exception e2) {
                    Logger.d("ElectorMappingSelfTAG", e2.toString());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                ElectorMapSelfDetails.this.alertDialog.dismiss();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    void showVerifyDetailsDialog(String name, String relativeName, String nameTrans, String relativeNameTrans, String typeRelation, String epic, final String oldStateNew) {
        Button button;
        int i;
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_self_elector);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(true);
        Button button2 = (Button) dialog.findViewById(R.id.btnYes);
        Button button3 = (Button) dialog.findViewById(R.id.btnNo);
        TextView textView = (TextView) dialog.findViewById(R.id.txtName);
        TextView textView2 = (TextView) dialog.findViewById(R.id.txtNameTrans);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.linearRelativeTrans);
        LinearLayout linearLayout2 = (LinearLayout) dialog.findViewById(R.id.linearNameTrans);
        TextView textView3 = (TextView) dialog.findViewById(R.id.txtRelativeName);
        TextView textView4 = (TextView) dialog.findViewById(R.id.txtRelativeNameTrans);
        TextView textView5 = (TextView) dialog.findViewById(R.id.txtTypeRelation);
        TextView textView6 = (TextView) dialog.findViewById(R.id.txtEpic);
        final Spinner spinner = (Spinner) dialog.findViewById(R.id.sp_elector_relative);
        if (TextUtils.isEmpty(nameTrans)) {
            button = button3;
            i = 1;
        } else {
            button = button3;
            i = 1;
            if (nameTrans.length() == 1) {
                linearLayout2.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(relativeNameTrans) && relativeNameTrans.length() == i) {
            linearLayout.setVisibility(8);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.blo_spinner_dropdown, this.relationNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ElectorMapSelfDetails electorMapSelfDetails = ElectorMapSelfDetails.this;
                electorMapSelfDetails.releationCode = electorMapSelfDetails.relationCodeList.get(position);
            }
        });
        textView.setText(name);
        textView2.setText(nameTrans);
        textView3.setText(relativeName);
        textView4.setText(relativeNameTrans);
        if (!TextUtils.isEmpty(typeRelation)) {
            if (typeRelation.equals("GMTH")) {
                textView5.setText("Grand Mother");
            } else if (typeRelation.equals("GFTH")) {
                textView5.setText("Grand Father");
            } else if (typeRelation.equals("MTHR")) {
                textView5.setText("Mother");
            } else if (typeRelation.equals("FTHR") || typeRelation.equals("F")) {
                textView5.setText("Father");
            } else if (typeRelation.equals("HSBN") || typeRelation.equals("H")) {
                textView5.setText("Husband");
            } else if (typeRelation.equals("OTHR")) {
                textView5.setText("Other");
            } else if (TextUtils.isEmpty(typeRelation)) {
                textView5.setText("");
            } else {
                textView5.setText(typeRelation);
            }
        }
        textView6.setText(epic);
        button2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (spinner.getSelectedItem().toString().equalsIgnoreCase(ElectorMapSelfDetails.this.selectRelationType)) {
                    Toast.makeText(ElectorMapSelfDetails.this.getApplicationContext(), "Please select relation Type", 0).show();
                } else if (TextUtils.isEmpty(ElectorMapSelfDetails.this.releationCode)) {
                    Toast.makeText(ElectorMapSelfDetails.this.getApplicationContext(), "Please select relation Type", 0).show();
                } else {
                    dialog.dismiss();
                    ElectorMapSelfDetails.this.validateMapping(oldStateNew);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElectorMapSelfDetails.this.isThisYou = false;
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$0(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog1$0(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        Intent intent = new Intent((Context) this, (Class<?>) ElectorProgenyActivity.class);
        intent.setFlags(603979776);
        intent.putExtra("restart", true);
        startActivity(intent);
        dialogInterface.dismiss();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateMapping(String oldStatenew) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        this.alertDialog.show();
        HashMap map2 = new HashMap();
        map2.put("ccode", Integer.valueOf(this.id));
        map2.put("progenyEpicNo", this.currentEpic);
        map2.put("progenyRelationType", this.releationCode);
        map2.put("oldStateCd", oldStatenew);
        Log.d("ElectorMappingSelfTAG", map2.toString());
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).addSelfProgeny(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.11
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        ElectorMapSelfDetails.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).getString("message"));
                        return;
                    }
                    Logger.d("ElectorMappingSelfTAG", String.valueOf(response.body()));
                    ElectorMapSelfDetails.this.showDialog1("", String.valueOf(((JsonObject) response.body()).get("message")));
                    if (ElectorMapSelfDetails.this.alertDialog != null) {
                        ElectorMapSelfDetails.this.alertDialog.dismiss();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (ElectorMapSelfDetails.this.alertDialog != null) {
                    ElectorMapSelfDetails.this.alertDialog.dismiss();
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
        map2.put("relativeName", this.binding.parentName.getText().toString());
        map2.put("grandParentName", this.binding.grandparentName.getText().toString());
        map2.put("stateCd", this.efState);
        map2.put("mappingType", "progeny");
        map2.put("districtNo", this.efDistrict);
        map2.put("acNo", this.efAc);
        map2.put("partNo", this.efPart);
        map2.put("efEpicNumber", this.currentEpic);
        map2.put("efApplicantName", this.currentName);
        map2.put("efRelativeName", this.currentRelativeName);
        map2.put("efStateCd", this.state);
        map2.put("efAge", this.currentAge);
        map2.put("efAcNo", this.acNo);
        map2.put("efPartNo", this.partNo);
        map2.put("efPartSerialNo", Integer.valueOf(Integer.parseInt(getIntent().getStringExtra("psl"))));
        Call<LocationRoot> searchLocationFamily = ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getSearchLocationFamily(this.state.toLowerCase(), map, map2);
        this.alertDialog.show();
        searchLocationFamily.enqueue(new AnonymousClass12());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$12, reason: invalid class name */
    class AnonymousClass12 implements Callback<LocationRoot> {
        AnonymousClass12() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v17, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails] */
        /* JADX WARN: Type inference failed for: r1v3, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails] */
        /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails] */
        /* JADX WARN: Type inference failed for: r7v16, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails] */
        public void onResponse(Call<LocationRoot> call, Response<LocationRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    ElectorMapSelfDetails.this.newbloMappedList = ((LocationRoot) response.body()).payload.mappingList;
                    if (ElectorMapSelfDetails.this.newbloMappedList == null || ElectorMapSelfDetails.this.newbloMappedList.size() <= 0) {
                        ElectorMapSelfDetails.this.binding.tvRecordCount.setVisibility(8);
                        Utils utils = new Utils();
                        ?? r7 = ElectorMapSelfDetails.this;
                        utils.infoDialog(r7, r7.getResources().getString(R.string.alertMsg), ElectorMapSelfDetails.this.getResources().getString(R.string.no_data_found));
                    } else {
                        Logger.d("blo list size", "" + ElectorMapSelfDetails.this.newbloMappedList.size());
                        ElectorMapSelfDetails.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(ElectorMapSelfDetails.this));
                        if (ElectorMapSelfDetails.this.newbloMappedList != null && !ElectorMapSelfDetails.this.newbloMappedList.isEmpty()) {
                            ElectorMapSelfDetails.this.binding.rvMapping.setVisibility(0);
                            ElectorMapSelfDetails.this.binding.tvRecordCount.setVisibility(0);
                            ElectorMapSelfDetails.this.binding.tvRecordCount.setText(ElectorMapSelfDetails.this.getResources().getString(R.string.total_record) + StringUtils.SPACE + ElectorMapSelfDetails.this.newbloMappedList.size());
                            ElectorMapSelfDetails electorMapSelfDetails = ElectorMapSelfDetails.this;
                            ?? r1 = ElectorMapSelfDetails.this;
                            electorMapSelfDetails.adapter = new SearchLocationAdapter(r1, r1.newbloMappedList, new SearchLocationAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$12$$ExternalSyntheticLambda0
                                @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.SearchLocationAdapter.OnItemSelectedListener
                                public final void onItemSelected() {
                                    this.f$0.lambda$onResponse$0();
                                }
                            });
                            ElectorMapSelfDetails.this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(ElectorMapSelfDetails.this));
                            ElectorMapSelfDetails.this.binding.rvMapping.setNestedScrollingEnabled(false);
                            ElectorMapSelfDetails.this.binding.rvMapping.setAdapter(ElectorMapSelfDetails.this.adapter);
                        }
                    }
                } catch (Exception unused) {
                }
                ElectorMapSelfDetails.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                if (ElectorMapSelfDetails.this.alertDialog != null) {
                    ElectorMapSelfDetails.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            try {
                if (ElectorMapSelfDetails.this.alertDialog != null) {
                    ElectorMapSelfDetails.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                if (TextUtils.isEmpty(strOptString)) {
                    String strOptString2 = jSONObject.optString("error");
                    Utils utils2 = new Utils();
                    ?? r3 = ElectorMapSelfDetails.this;
                    utils2.infoDialog(r3, r3.getResources().getString(R.string.alertMsg), strOptString2);
                } else {
                    Utils utils3 = new Utils();
                    ?? r2 = ElectorMapSelfDetails.this;
                    utils3.infoDialog(r2, r2.getResources().getString(R.string.alertMsg), strOptString);
                }
                Logger.e("TAG", strOptString);
                if (ElectorMapSelfDetails.this.alertDialog != null) {
                    ElectorMapSelfDetails.this.alertDialog.dismiss();
                }
            } catch (IOException | JSONException e) {
                if (ElectorMapSelfDetails.this.alertDialog != null) {
                    ElectorMapSelfDetails.this.alertDialog.dismiss();
                }
                Logger.e("TAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            ElectorMapSelfDetails.this.binding.layoutVerifyButton.setVisibility(0);
        }

        public void onFailure(Call<LocationRoot> call, Throwable t) {
            if (ElectorMapSelfDetails.this.alertDialog != null) {
                ElectorMapSelfDetails.this.alertDialog.dismiss();
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
        this.commomUtility.getSirDistrict(oldState, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), this, new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda10
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllDistrict$5(oldState, i, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getAllDistrict$5(final String str, int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(this, this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda2
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$getAllDistrict$4(str, i2, str2, str3);
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
    public /* synthetic */ void lambda$getAllDistrict$4(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(this, this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda11
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getAllDistrict$2(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        this.refreshToken = str3;
        SharedPref.getInstance(this).setRefreshToken(str3);
        SharedPref.getInstance(this).setToken("Bearer " + str2);
        this.commomUtility.getSirDistrict(str, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), this, new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda1
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i2, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$getAllDistrict$3(i2, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getAllDistrict$2(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(this).setIsLoggedIn(false);
        SharedPref.getInstance(this).setLocaleBool(false);
        startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getAllDistrict$3(int i, ArrayList arrayList, ArrayList arrayList2) {
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
        this.commomUtility.getAllAC(oldstate, this, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.13
            /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails] */
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    ElectorMapSelfDetails.this.ACNameListef.clear();
                    ElectorMapSelfDetails.this.ACListef.clear();
                    ElectorMapSelfDetails.this.ACListef = acList;
                    ElectorMapSelfDetails.this.ACNameListef = acNameList;
                    ?? r3 = ElectorMapSelfDetails.this;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown_new, r3.ACNameListef);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    ElectorMapSelfDetails.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                    ElectorMapSelfDetails.this.binding.efAcSpinner.setThreshold(1);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getACByDistrict(int oldDistrict, String oldState) {
        this.commomUtility.getAssmblyByDist(this, oldDistrict, oldState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.14
            /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails] */
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    ElectorMapSelfDetails.this.ACNameListef.clear();
                    ElectorMapSelfDetails.this.ACListef.clear();
                    ElectorMapSelfDetails.this.ACListef = acList;
                    ElectorMapSelfDetails.this.ACNameListef = acNameList;
                    ?? r3 = ElectorMapSelfDetails.this;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown_new, r3.ACNameListef);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    ElectorMapSelfDetails.this.binding.efAcSpinner.setAdapter(arrayAdapter);
                    ElectorMapSelfDetails.this.binding.efAcSpinner.setThreshold(1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getPartByEfAc() {
        this.commomUtility.getPartByAc(this, Integer.parseInt(this.efAc), this.efState, new IAcPartListCallback() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.15
            /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails] */
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback
            public void onCallBack(int code, List<Integer> acList, List<String> acNameList) {
                if (code == 200) {
                    ElectorMapSelfDetails.this.partListef.clear();
                    ElectorMapSelfDetails.this.partNameListef.clear();
                    ElectorMapSelfDetails.this.partListef = acList;
                    ElectorMapSelfDetails.this.partNameListef = acNameList;
                    ?? r3 = ElectorMapSelfDetails.this;
                    ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown_new, r3.partNameListef);
                    arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                    ElectorMapSelfDetails.this.binding.efPartSpinner.setAdapter(arrayAdapter);
                    ElectorMapSelfDetails.this.binding.efPartSpinner.setThreshold(1);
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

    /* JADX WARN: Multi-variable type inference failed */
    private void initSearchByLocationValues() {
        this.utils = new Utils();
        selecttab(this.binding.searchAcPartPslMB, this.binding.searchLocationMB);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown_new, (List) this.StateNameList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.efStateSpinner.setAdapter(arrayAdapter);
        this.binding.efStateSpinner.setThreshold(1);
        this.binding.efStateSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                ElectorMapSelfDetails.this.binding.efStateSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efDistrictSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                ElectorMapSelfDetails.this.binding.efDistrictSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efAcSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                ElectorMapSelfDetails.this.binding.efAcSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efPartSpinner.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                ElectorMapSelfDetails.this.binding.efPartSpinner.showDropDown();
                return false;
            }
        });
        this.binding.efPartSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.20
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                ElectorMapSelfDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapSelfDetails.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Part")) {
                    ElectorMapSelfDetails.this.efPart = null;
                    ElectorMapSelfDetails.this.binding.efPartSpinner.setText("");
                    ElectorMapSelfDetails.this.binding.efPartSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_part));
                } else {
                    String string = parent.getItemAtPosition(i).toString();
                    ElectorMapSelfDetails electorMapSelfDetails = ElectorMapSelfDetails.this;
                    electorMapSelfDetails.efPart = String.valueOf(electorMapSelfDetails.partListef.get(ElectorMapSelfDetails.this.partNameListef.indexOf(string)));
                }
            }
        });
        this.binding.efStateSpinner.setOnItemClickListener(new AnonymousClass21());
        this.binding.efDistrictSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.22
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                ElectorMapSelfDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapSelfDetails.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select District")) {
                    ElectorMapSelfDetails.this.efDistrict = null;
                    ElectorMapSelfDetails.this.efAc = null;
                    ElectorMapSelfDetails.this.partListef.clear();
                    ElectorMapSelfDetails.this.partNameListef.clear();
                    ElectorMapSelfDetails.this.partNameListef.add(ElectorMapSelfDetails.this.getResources().getString(R.string.select_part));
                    ElectorMapSelfDetails.this.partListef.add(0);
                    ElectorMapSelfDetails.this.binding.efAcSpinner.setText("");
                    ElectorMapSelfDetails.this.binding.efPartSpinner.setText("");
                    ElectorMapSelfDetails.this.binding.efDistrictSpinner.setText("");
                    ElectorMapSelfDetails.this.binding.efAcSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_assembly_constituency));
                    ElectorMapSelfDetails.this.binding.efPartSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_part));
                    ElectorMapSelfDetails.this.binding.efDistrictSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.blo_select_district));
                    if (ElectorMapSelfDetails.this.ACListef.size() > 0) {
                        ElectorMapSelfDetails.this.ACListef.clear();
                        ElectorMapSelfDetails.this.ACNameListef.clear();
                    }
                    ElectorMapSelfDetails electorMapSelfDetails = ElectorMapSelfDetails.this;
                    electorMapSelfDetails.getAllACEf(electorMapSelfDetails.efState);
                    return;
                }
                ElectorMapSelfDetails.this.efAc = null;
                ElectorMapSelfDetails.this.efPart = null;
                if (!TextUtils.isEmpty(ElectorMapSelfDetails.this.efState) && ElectorMapSelfDetails.this.efState.equalsIgnoreCase("S02")) {
                    ElectorMapSelfDetails electorMapSelfDetails2 = ElectorMapSelfDetails.this;
                    electorMapSelfDetails2.efDistrict = (String) electorMapSelfDetails2.districtcode.get(i);
                } else {
                    String str = (String) ElectorMapSelfDetails.this.district.get(ElectorMapSelfDetails.this.district.indexOf(parent.getItemAtPosition(i).toString()));
                    int iIndexOf = ElectorMapSelfDetails.this.district.indexOf(str);
                    Log.d("CheckEffff : ", iIndexOf + StringUtils.SPACE + str);
                    ElectorMapSelfDetails electorMapSelfDetails3 = ElectorMapSelfDetails.this;
                    electorMapSelfDetails3.efDistrict = (String) electorMapSelfDetails3.districtcode.get(iIndexOf);
                    Log.d("efDistrict : ", ElectorMapSelfDetails.this.efDistrict);
                }
                ElectorMapSelfDetails electorMapSelfDetails4 = ElectorMapSelfDetails.this;
                electorMapSelfDetails4.getACByDistrict(Integer.parseInt(electorMapSelfDetails4.efDistrict), ElectorMapSelfDetails.this.efState);
                ElectorMapSelfDetails.this.binding.efAcSpinner.setText("");
                ElectorMapSelfDetails.this.binding.efPartSpinner.setText("");
                ElectorMapSelfDetails.this.binding.efAcSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_assembly_constituency));
                ElectorMapSelfDetails.this.binding.efPartSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_part));
                ElectorMapSelfDetails.this.binding.selfName.setText("");
                ElectorMapSelfDetails.this.binding.parentName.setText("");
                ElectorMapSelfDetails.this.binding.grandparentName.setText("");
                if (ElectorMapSelfDetails.this.partListef.size() <= 0 || ElectorMapSelfDetails.this.partNameListef.size() <= 0) {
                    return;
                }
                ElectorMapSelfDetails.this.partListef.clear();
                ElectorMapSelfDetails.this.partNameListef.clear();
            }
        });
        this.binding.efAcSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.23
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                ElectorMapSelfDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapSelfDetails.this.binding.layoutVerifyButton.setVisibility(8);
                if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select Assembly Constituency")) {
                    ElectorMapSelfDetails.this.efAc = null;
                    ElectorMapSelfDetails.this.efPart = null;
                    ElectorMapSelfDetails.this.partListef.clear();
                    ElectorMapSelfDetails.this.partNameListef.clear();
                    ElectorMapSelfDetails.this.partNameListef.add(ElectorMapSelfDetails.this.getResources().getString(R.string.select_part));
                    ElectorMapSelfDetails.this.partListef.add(0);
                    ElectorMapSelfDetails.this.binding.efAcSpinner.setText("");
                    ElectorMapSelfDetails.this.binding.efPartSpinner.setText("");
                    ElectorMapSelfDetails.this.binding.selfName.setText("");
                    ElectorMapSelfDetails.this.binding.parentName.setText("");
                    ElectorMapSelfDetails.this.binding.grandparentName.setText("");
                    ElectorMapSelfDetails.this.binding.efPartSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_part));
                    ElectorMapSelfDetails.this.binding.efAcSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_assembly_constituency));
                    return;
                }
                ElectorMapSelfDetails.this.efPart = null;
                String string = parent.getItemAtPosition(i).toString();
                ElectorMapSelfDetails electorMapSelfDetails = ElectorMapSelfDetails.this;
                electorMapSelfDetails.efAc = String.valueOf(electorMapSelfDetails.ACListef.get(ElectorMapSelfDetails.this.ACNameListef.indexOf(string)));
                Log.d("OldAC : ", ElectorMapSelfDetails.this.oldAc + "  " + ElectorMapSelfDetails.this.ACListef.get(i).toString());
                ElectorMapSelfDetails.this.binding.efPartSpinner.setText("");
                ElectorMapSelfDetails.this.binding.efPartSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_part));
                ElectorMapSelfDetails.this.binding.selfName.setText("");
                ElectorMapSelfDetails.this.binding.parentName.setText("");
                ElectorMapSelfDetails.this.binding.grandparentName.setText("");
                ElectorMapSelfDetails.this.getPartByEfAc();
            }
        });
        this.binding.searchAcPartPslMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initSearchByLocationValues$7(view);
            }
        });
        this.binding.searchLocationMB.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initSearchByLocationValues$9(view);
            }
        });
        this.binding.searchButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initSearchByLocationValues$10(view);
            }
        });
        this.binding.txtVerifyContinueButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initSearchByLocationValues$11(view);
            }
        });
        this.binding.selfName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.24
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ElectorMapSelfDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapSelfDetails.this.binding.layoutVerifyButton.setVisibility(8);
                ElectorMapSelfDetails.this.binding.tvRecordCount.setVisibility(8);
            }
        });
        this.binding.parentName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.25
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ElectorMapSelfDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapSelfDetails.this.binding.tvRecordCount.setVisibility(8);
                ElectorMapSelfDetails.this.binding.layoutVerifyButton.setVisibility(8);
            }
        });
        this.binding.grandparentName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.26
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ElectorMapSelfDetails.this.binding.rvMapping.setVisibility(8);
                ElectorMapSelfDetails.this.binding.tvRecordCount.setVisibility(8);
                ElectorMapSelfDetails.this.binding.layoutVerifyButton.setVisibility(8);
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$21, reason: invalid class name */
    class AnonymousClass21 implements AdapterView.OnItemClickListener {
        AnonymousClass21() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            ElectorMapSelfDetails.this.binding.rvMapping.setVisibility(8);
            ElectorMapSelfDetails.this.binding.layoutVerifyButton.setVisibility(8);
            if (parent.getItemAtPosition(i).toString().equalsIgnoreCase("Select State")) {
                ElectorMapSelfDetails.this.efState = null;
                ElectorMapSelfDetails.this.efDistrict = null;
                ElectorMapSelfDetails.this.efAc = null;
                ElectorMapSelfDetails.this.efPart = null;
                ElectorMapSelfDetails.this.ACNameListef.clear();
                ElectorMapSelfDetails.this.ACListef.clear();
                ElectorMapSelfDetails.this.ACNameListef.add(ElectorMapSelfDetails.this.getResources().getString(R.string.select_assembly_constituency));
                ElectorMapSelfDetails.this.ACListef.add(0);
                ElectorMapSelfDetails.this.partListef.clear();
                ElectorMapSelfDetails.this.partNameListef.clear();
                ElectorMapSelfDetails.this.partNameListef.add(ElectorMapSelfDetails.this.getResources().getString(R.string.select_part));
                ElectorMapSelfDetails.this.partListef.add(0);
                ElectorMapSelfDetails.this.district.clear();
                ElectorMapSelfDetails.this.districtcode.clear();
                ElectorMapSelfDetails.this.district.add("Select District");
                ElectorMapSelfDetails.this.districtcode.add("0");
                ElectorMapSelfDetails.this.binding.efAcSpinner.setText("");
                ElectorMapSelfDetails.this.binding.efDistrictSpinner.setText("");
                ElectorMapSelfDetails.this.binding.efPartSpinner.setText("");
                ElectorMapSelfDetails.this.binding.efStateSpinner.setText("");
                ElectorMapSelfDetails.this.binding.efStateSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.blo_select_state));
                ElectorMapSelfDetails.this.binding.efAcSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_assembly_constituency));
                ElectorMapSelfDetails.this.binding.efDistrictSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.blo_select_district));
                ElectorMapSelfDetails.this.binding.efPartSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_part));
                return;
            }
            ElectorMapSelfDetails.this.efDistrict = null;
            ElectorMapSelfDetails.this.efAc = null;
            ElectorMapSelfDetails.this.efPart = null;
            ElectorMapSelfDetails.this.binding.efAcSpinner.setText("");
            ElectorMapSelfDetails.this.binding.efDistrictSpinner.setText("");
            ElectorMapSelfDetails.this.binding.efPartSpinner.setText("");
            ElectorMapSelfDetails.this.binding.efAcSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_assembly_constituency));
            ElectorMapSelfDetails.this.binding.efDistrictSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.blo_select_district));
            ElectorMapSelfDetails.this.binding.efPartSpinner.setHint(ElectorMapSelfDetails.this.getResources().getString(R.string.select_part));
            String string = parent.getItemAtPosition(i).toString();
            ElectorMapSelfDetails electorMapSelfDetails = ElectorMapSelfDetails.this;
            electorMapSelfDetails.efState = electorMapSelfDetails.StateList.get(ElectorMapSelfDetails.this.StateNameList.indexOf(string));
            Log.d("efState : ", ElectorMapSelfDetails.this.efState);
            ElectorMapSelfDetails.this.binding.selfName.setText("");
            ElectorMapSelfDetails.this.binding.parentName.setText("");
            ElectorMapSelfDetails.this.binding.grandparentName.setText("");
            ElectorMapSelfDetails electorMapSelfDetails2 = ElectorMapSelfDetails.this;
            electorMapSelfDetails2.getAllDistrict(electorMapSelfDetails2.efState);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$21$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            ElectorMapSelfDetails electorMapSelfDetails = ElectorMapSelfDetails.this;
            electorMapSelfDetails.getAllACEf(electorMapSelfDetails.efState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchByLocationValues$7(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initSearchByLocationValues$6();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchByLocationValues$6() {
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
    public /* synthetic */ void lambda$initSearchByLocationValues$9(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initSearchByLocationValues$8();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchByLocationValues$8() {
        this.binding.searchTabLayout.setVisibility(0);
        selecttab(this.binding.searchLocationMB, this.binding.searchAcPartPslMB);
        this.binding.searchByLocationDetailsLl.setVisibility(0);
        this.binding.electorNameLayout.setVisibility(8);
        this.binding.grandparentNameLayout.setVisibility(0);
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
    public /* synthetic */ void lambda$initSearchByLocationValues$10(View view) {
        if (TextUtils.isEmpty(this.efState)) {
            showDialog1("Alert", "Please select State");
            return;
        }
        if (TextUtils.isEmpty(this.binding.parentName.getText().toString())) {
            showDialog1("Alert", "Please enter parent name");
        } else if (TextUtils.isEmpty(this.binding.grandparentName.getText().toString())) {
            showDialog1("Alert", "Please enter parent relative's name");
        } else {
            callLocationApi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchByLocationValues$11(View view) {
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
                    mappingList.getOldFullName();
                    mappingList.getOldRelativeFullName();
                    mappingList.getOldEpicNumber();
                    mappingList.getOldFullNameL1();
                    mappingList.getOldRelativeFullNameL1();
                    mappingList.getRelationType();
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
        this.alertDialog.show();
        callVerifyRelativeApi(oldStateCd, strValueOf, strValueOf2, strValueOf3);
    }

    private void validateMappingef(String oldState, String oldAC, String oldPart, String oldSerial, String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        this.alertDialog.show();
        HashMap map2 = new HashMap();
        map2.put("ccode", id);
        map2.put("progenyEpicNo", this.currentEpic);
        map2.put("progenyRelationType", this.releationCode);
        map2.put("oldStateCd", oldState);
        Log.d("ElectorMappingSelfTAG", map2.toString());
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).addSelfProgeny(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails.27
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        ElectorMapSelfDetails.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).getString("message"));
                        return;
                    }
                    Logger.d("ElectorMappingSelfTAG", String.valueOf(response.body()));
                    ElectorMapSelfDetails.this.showDialog1("", String.valueOf(((JsonObject) response.body()).get("message")));
                    if (ElectorMapSelfDetails.this.alertDialog != null) {
                        ElectorMapSelfDetails.this.alertDialog.dismiss();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (ElectorMapSelfDetails.this.alertDialog != null) {
                    ElectorMapSelfDetails.this.alertDialog.dismiss();
                }
            }
        });
    }
}
