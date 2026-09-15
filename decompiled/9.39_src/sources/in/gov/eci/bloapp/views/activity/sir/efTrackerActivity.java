package in.gov.eci.bloapp.views.activity.sir;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.EfTrackerAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityEfTrackerBinding;
import in.gov.eci.bloapp.model.SIR.EfTrackerListModel;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class efTrackerActivity extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    String IsCollected;
    String IsDelivered;
    String IsUncollectable;
    private String acNo;
    EfTrackerAdapter adapter;
    ArrayAdapter<String> adapterSpinner;
    AlertDialog alertDialog;
    private String atkband;
    String barcode;
    ActivityEfTrackerBinding binding;
    List<String> efOptionList;
    String[] listArray;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    EditText search;
    UserClient service;
    private String state;
    private String token;
    int isUncollectedCount = 0;
    int isDistributedCount = 0;
    int isNotYetDistributedCount = 0;
    int isCollectedCount = 0;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    ArrayList<EfTrackerListModel> pendingList = new ArrayList<>();
    ArrayList<EfTrackerListModel> searchList = new ArrayList<>();
    private final String TAG = "efTrackerTAG";

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityEfTrackerBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.service = (UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class);
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new EfTrackerAdapter(this.searchList, this, this.token, this.state, this.atkband, this.rtkband, Integer.parseInt(this.acNo));
        this.binding.recyclerView.setAdapter(this.adapter);
        this.binding.spinner.setSelection(0);
        getAllPendingList();
        this.searchList.clear();
        this.searchList.addAll(this.pendingList);
        this.adapter.notifyDataSetChanged();
        this.binding.textView5.setText("v" + new CommomUtility().appversion);
        initClickListener();
        this.listArray = getResources().getStringArray(R.array.ef_options);
        this.efOptionList = new ArrayList(Arrays.asList(this.listArray));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, android.R.layout.simple_spinner_item, this.efOptionList);
        this.adapterSpinner = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.spinner.setAdapter((SpinnerAdapter) this.adapterSpinner);
        this.binding.spinner.setOnItemSelectedListener(this);
        if (this.isUncollectedCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(1));
            String string = getString(R.string.mark_uncollectedd, new Object[]{Integer.valueOf(this.isUncollectedCount)});
            this.efOptionList.add(1, string);
            this.efOptionList.set(1, string);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.isCollectedCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(3));
            String string2 = getString(R.string.mark_collected, new Object[]{Integer.valueOf(this.isCollectedCount)});
            this.efOptionList.add(3, string2);
            this.efOptionList.set(3, string2);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.isNotYetDistributedCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(2));
            this.efOptionList.add(2, getString(R.string.not_yet_distt, new Object[]{Integer.valueOf(this.isNotYetDistributedCount)}));
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.isDistributedCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(4));
            this.efOptionList.add(4, getString(R.string.mark_dist, new Object[]{Integer.valueOf(this.isDistributedCount)}));
            this.adapterSpinner.notifyDataSetChanged();
        }
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
        this.binding.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                efTrackerActivity.this.cameraPermission();
            }
        });
        this.binding.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                efTrackerActivity.this.adapter.getcountCardView().split(",");
                View viewInflate = LayoutInflater.from(efTrackerActivity.this).inflate(R.layout.ef_custom_modal, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.note3);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.note6);
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.note4);
                TextView textView4 = (TextView) viewInflate.findViewById(R.id.note5);
                TextView textView5 = (TextView) viewInflate.findViewById(R.id.noteTotal);
                textView.setText(efTrackerActivity.this.getString(R.string.mark_uncollected));
                textView2.setText(efTrackerActivity.this.getString(R.string.not_yet_dist));
                textView3.setText(efTrackerActivity.this.getString(R.string.collected));
                textView4.setText(efTrackerActivity.this.getString(R.string.distributed));
                textView5.setText("");
                new AlertDialog.Builder(efTrackerActivity.this).setTitle(efTrackerActivity.this.getString(R.string.ef_tracker_status)).setView(viewInflate).setPositiveButton(efTrackerActivity.this.getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create().show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void cameraPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.CAMERA") == 0) {
            initScanner();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, REQUEST_CODE_CAMERA_PORTRAIT);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initScanner() {
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(CaptureActivityPortrait.class);
        intentIntegrator.initiateScan();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult activityResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (activityResult == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (activityResult.getContents() == null) {
            Toast.makeText((Context) this, (CharSequence) "Scanning cancelled!", 1).show();
            return;
        }
        String contents = activityResult.getContents();
        try {
            this.barcode = new JSONObject(AESDecryptor.decrypt(contents)).getString("epic_no");
            Log.d("efTrackerTAG", "encrypted" + this.barcode);
        } catch (Exception unused) {
            this.barcode = contents;
            Log.d("efTrackerTAG", "Plain" + this.barcode);
        }
        this.barcode = this.barcode.replace(" ", "");
        Log.d("efTrackerTAG", "last" + this.barcode);
        this.binding.search.setText(this.barcode);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            showToast("Camera permission cancelled!");
        } else if (requestCode == REQUEST_CODE_CAMERA_PORTRAIT) {
            initScanner();
        }
    }

    private void getAllPendingList() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", Integer.valueOf(this.acNo));
        map2.put("partNo", Integer.valueOf(this.partNo));
        Call<JsonObject> efFlagSIR = this.service.getEfFlagSIR(this.state.toLowerCase(), map, Integer.valueOf(this.acNo), Integer.valueOf(this.partNo));
        this.alertDialog.show();
        efFlagSIR.enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.efTrackerActivity$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.efTrackerActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    JSONArray jSONArray = new JSONArray(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                    Log.d("Epic Number= ", Integer.toString(jSONArray.length()));
                    efTrackerActivity.this.pendingList.clear();
                    efTrackerActivity.this.searchList.clear();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        efTrackerActivity.this.pendingList.add(new EfTrackerListModel(jSONObject.optString("name", ""), jSONObject.optString("epicNo", ""), jSONObject.optString("epicId", ""), jSONObject.optString("partSerialNo", "0"), jSONObject.optString("isCollected", ""), jSONObject.optString("isDelivered", ""), jSONObject.optString("isUncollectable", ""), jSONObject.optInt("epicMatch", 0)));
                    }
                } catch (JSONException e) {
                    Logger.d("efTrackerActivity", e.toString());
                }
                efTrackerActivity.this.searchList.addAll(efTrackerActivity.this.pendingList);
                new ArrayList();
                for (EfTrackerListModel efTrackerListModel : efTrackerActivity.this.pendingList) {
                    if (efTrackerListModel.getIsDelivered().equalsIgnoreCase("Y") && efTrackerListModel.getIsCollected().equalsIgnoreCase("N") && efTrackerListModel.getIsUncollectable().equalsIgnoreCase("Y")) {
                        efTrackerActivity.this.isUncollectedCount++;
                        efTrackerActivity.this.efOptionList.remove(efTrackerActivity.this.adapterSpinner.getItem(1));
                        efTrackerActivity eftrackeractivity = efTrackerActivity.this;
                        String string = eftrackeractivity.getString(R.string.mark_uncollectedd, new Object[]{Integer.valueOf(eftrackeractivity.isUncollectedCount)});
                        efTrackerActivity.this.efOptionList.add(1, string);
                        efTrackerActivity.this.efOptionList.set(1, string);
                        efTrackerActivity.this.adapterSpinner.notifyDataSetChanged();
                    } else if (efTrackerListModel.getIsDelivered().equalsIgnoreCase("N") && efTrackerListModel.getIsUncollectable().equalsIgnoreCase("N") && efTrackerListModel.getIsCollected().equalsIgnoreCase("N")) {
                        efTrackerActivity.this.isNotYetDistributedCount++;
                        Log.d("efTrackerTAG", String.valueOf(efTrackerActivity.this.isNotYetDistributedCount));
                        efTrackerActivity.this.efOptionList.remove(efTrackerActivity.this.adapterSpinner.getItem(2));
                        List<String> list = efTrackerActivity.this.efOptionList;
                        efTrackerActivity eftrackeractivity2 = efTrackerActivity.this;
                        list.add(2, eftrackeractivity2.getString(R.string.not_yet_distt, new Object[]{Integer.valueOf(eftrackeractivity2.isNotYetDistributedCount)}));
                        efTrackerActivity.this.adapterSpinner.notifyDataSetChanged();
                    } else if ((efTrackerListModel.getIsDelivered().equalsIgnoreCase("Y") || efTrackerListModel.getIsDelivered().equalsIgnoreCase("N")) && efTrackerListModel.getIsCollected().equalsIgnoreCase("Y") && efTrackerListModel.getIsUncollectable().equalsIgnoreCase("N")) {
                        efTrackerActivity.this.isCollectedCount++;
                        efTrackerActivity.this.efOptionList.remove(efTrackerActivity.this.adapterSpinner.getItem(3));
                        efTrackerActivity eftrackeractivity3 = efTrackerActivity.this;
                        String string2 = eftrackeractivity3.getString(R.string.mark_collected, new Object[]{Integer.valueOf(eftrackeractivity3.isCollectedCount)});
                        efTrackerActivity.this.efOptionList.add(3, string2);
                        efTrackerActivity.this.efOptionList.set(3, string2);
                        efTrackerActivity.this.adapterSpinner.notifyDataSetChanged();
                    } else if (efTrackerListModel.getIsDelivered().equalsIgnoreCase("Y") && efTrackerListModel.getIsCollected().equalsIgnoreCase("N") && efTrackerListModel.getIsUncollectable().equalsIgnoreCase("N")) {
                        efTrackerActivity.this.isDistributedCount++;
                        efTrackerActivity.this.efOptionList.remove(efTrackerActivity.this.adapterSpinner.getItem(4));
                        List<String> list2 = efTrackerActivity.this.efOptionList;
                        efTrackerActivity eftrackeractivity4 = efTrackerActivity.this;
                        list2.add(4, eftrackeractivity4.getString(R.string.mark_dist, new Object[]{Integer.valueOf(eftrackeractivity4.isDistributedCount)}));
                        efTrackerActivity.this.adapterSpinner.notifyDataSetChanged();
                    }
                }
                efTrackerActivity.this.binding.recyclerView.setAdapter(efTrackerActivity.this.adapter);
                Log.d("searchList", String.valueOf(efTrackerActivity.this.searchList.size()));
                efTrackerActivity.this.alertDialog.dismiss();
                efTrackerActivity.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerActivity.3.1
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i2, int i1, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        String string3 = editable.toString();
                        ArrayList<EfTrackerListModel> arrayList = new ArrayList<>();
                        for (EfTrackerListModel efTrackerListModel2 : efTrackerActivity.this.pendingList) {
                            efTrackerActivity.this.IsDelivered = efTrackerListModel2.getIsDelivered();
                            efTrackerActivity.this.IsUncollectable = efTrackerListModel2.getIsUncollectable();
                            efTrackerActivity.this.IsCollected = efTrackerListModel2.getIsCollected();
                            if (!TextUtils.isEmpty(efTrackerListModel2.getSerialNo()) && efTrackerListModel2.getSerialNo().toLowerCase().equals(string3.toLowerCase())) {
                                if (arrayList.size() > 0) {
                                    arrayList.clear();
                                }
                                arrayList.add(efTrackerListModel2);
                                break;
                            } else if ((!TextUtils.isEmpty(efTrackerListModel2.getEpicNo()) && efTrackerListModel2.getEpicNo().toLowerCase().contains(string3.toLowerCase())) || ((!TextUtils.isEmpty(efTrackerListModel2.getName()) && efTrackerListModel2.getName().toLowerCase().contains(string3.toLowerCase())) || (!TextUtils.isEmpty(efTrackerListModel2.getSerialNo()) && efTrackerListModel2.getSerialNo().toLowerCase().contains(string3.toLowerCase())))) {
                                arrayList.add(efTrackerListModel2);
                            }
                        }
                        efTrackerActivity.this.adapter.fun(arrayList);
                        efTrackerActivity.this.binding.spinner.setSelection(0);
                    }
                });
                return;
            }
            if (response.code() == 400 || response.code() == 401) {
                if (efTrackerActivity.this.alertDialog != null) {
                    efTrackerActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = efTrackerActivity.this.commomUtility;
                ?? r2 = efTrackerActivity.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.efTrackerActivity$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            try {
                if (efTrackerActivity.this.alertDialog != null) {
                    efTrackerActivity.this.alertDialog.dismiss();
                }
                Logger.e("efTrackerTAG", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (efTrackerActivity.this.alertDialog != null) {
                    efTrackerActivity.this.alertDialog.dismiss();
                }
                Logger.e("efTrackerTAG", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(efTrackerActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(efTrackerActivity.this.getApplicationContext()).setLocaleBool(false);
            efTrackerActivity.this.startActivity(new Intent(efTrackerActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (efTrackerActivity.this.alertDialog != null) {
                efTrackerActivity.this.alertDialog.dismiss();
            }
            Logger.e("efTracker", t.getMessage());
        }
    }

    private void searchList(String query) {
        this.searchList.clear();
        for (EfTrackerListModel efTrackerListModel : this.pendingList) {
            try {
                if (efTrackerListModel.getEpicNo().toLowerCase().contains(query.toLowerCase())) {
                    this.searchList.add(efTrackerListModel);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Logger.d("search", "queryResult count" + this.searchList.size());
        this.adapter.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            this.adapter = new EfTrackerAdapter(this.searchList, this, this.token, this.state, this.atkband, this.rtkband, Integer.parseInt(this.acNo));
            this.binding.recyclerView.setAdapter(this.adapter);
        }
        if (position == 1) {
            ArrayList<EfTrackerListModel> arrayList = new ArrayList<>();
            for (EfTrackerListModel efTrackerListModel : this.pendingList) {
                if (efTrackerListModel.getIsDelivered().equalsIgnoreCase("Y") && efTrackerListModel.getIsCollected().equalsIgnoreCase("N") && efTrackerListModel.getIsUncollectable().equalsIgnoreCase("Y")) {
                    arrayList.add(efTrackerListModel);
                }
            }
            EfTrackerAdapter efTrackerAdapter = this.adapter;
            if (efTrackerAdapter != null) {
                efTrackerAdapter.fun(arrayList);
            }
        }
        if (position == 2) {
            ArrayList<EfTrackerListModel> arrayList2 = new ArrayList<>();
            for (EfTrackerListModel efTrackerListModel2 : this.pendingList) {
                if (efTrackerListModel2.getIsDelivered().equalsIgnoreCase("N") && efTrackerListModel2.getIsUncollectable().equalsIgnoreCase("N") && efTrackerListModel2.getIsCollected().equalsIgnoreCase("N")) {
                    arrayList2.add(efTrackerListModel2);
                }
            }
            EfTrackerAdapter efTrackerAdapter2 = this.adapter;
            if (efTrackerAdapter2 != null) {
                efTrackerAdapter2.fun(arrayList2);
            }
        }
        if (position == 3) {
            ArrayList<EfTrackerListModel> arrayList3 = new ArrayList<>();
            for (EfTrackerListModel efTrackerListModel3 : this.pendingList) {
                if (efTrackerListModel3.getIsDelivered().equalsIgnoreCase("Y") || efTrackerListModel3.getIsDelivered().equalsIgnoreCase("N")) {
                    if (efTrackerListModel3.getIsCollected().equalsIgnoreCase("Y") && efTrackerListModel3.getIsUncollectable().equalsIgnoreCase("N")) {
                        arrayList3.add(efTrackerListModel3);
                    }
                }
            }
            EfTrackerAdapter efTrackerAdapter3 = this.adapter;
            if (efTrackerAdapter3 != null) {
                efTrackerAdapter3.fun(arrayList3);
            }
        }
        if (position == 4) {
            ArrayList<EfTrackerListModel> arrayList4 = new ArrayList<>();
            for (EfTrackerListModel efTrackerListModel4 : this.pendingList) {
                if (efTrackerListModel4.getIsDelivered().equalsIgnoreCase("Y") && efTrackerListModel4.getIsCollected().equalsIgnoreCase("N") && efTrackerListModel4.getIsUncollectable().equalsIgnoreCase("N")) {
                    arrayList4.add(efTrackerListModel4);
                }
            }
            EfTrackerAdapter efTrackerAdapter4 = this.adapter;
            if (efTrackerAdapter4 != null) {
                efTrackerAdapter4.fun(arrayList4);
            }
        }
    }
}
