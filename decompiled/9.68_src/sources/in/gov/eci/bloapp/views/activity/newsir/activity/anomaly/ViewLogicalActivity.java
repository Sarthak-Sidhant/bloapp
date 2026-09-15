package in.gov.eci.bloapp.views.activity.newsir.activity.anomaly;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.AnomalyListValueAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.MappingAnomalyDetailsValueDialogBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.ViewLogicalAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.AnomalyItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.AnomalyListCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.AnomalyListPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ViewLogicalActivity extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private static String SESSION = "";
    private String acNo;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<AnomalyListPayload> al;
    AlertDialog alertDialog;
    private String atkband;
    private ImageView back_btn_iv;
    String barcode;
    Button btScanCode;
    List<String> efOptionList;
    String epic;
    List<VerifyPayload> formlist;
    String[] listArray;
    TextView noteOpen;
    private String partNo;
    RecyclerView recyclerView;
    private String refreshToken;
    private String rtkband;
    ConstraintLayout scanCode;
    EditText search;
    UserClient service;
    Spinner spinner;
    private String state;
    TextView textView3;
    TextView textView5;
    private String token;
    Utils utils;
    ViewLogicalAdapter verifyCitizenListAdapter;
    String alertText = "";
    String TAG = "FormDataNewTAG";
    ArrayList<String> anomalydetailsListvalue = new ArrayList<>();
    CommomUtility commomUtility = new CommomUtility();
    Gson gson = new GsonBuilder().setLenient().create();
    int deceasedCount = 0;
    int eightyFivePlusCount = 0;
    String cancel = "";

    public interface DownloadCallback {
        void onError(String message, Throwable cause);

        void onSuccess(File pdfFile);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_data_new);
        SESSION = getString(R.string.sessionMsg);
        this.recyclerView = findViewById(R.id.recyclerView);
        this.search = (EditText) findViewById(R.id.search);
        this.noteOpen = (TextView) findViewById(R.id.noteOpen);
        this.back_btn_iv = (ImageView) findViewById(R.id.back_btn_iv);
        this.textView5 = (TextView) findViewById(R.id.textView5);
        this.textView3 = (TextView) findViewById(R.id.textView3);
        this.scanCode = findViewById(R.id.scanCode);
        this.btScanCode = (Button) findViewById(R.id.btScanCode);
        this.noteOpen = (TextView) findViewById(R.id.noteOpen);
        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.al = new ArrayList<>();
        this.alertText = getString(R.string.alertMsg);
        this.utils = new Utils();
        initClickListener();
        this.service = (UserClient) ApiClient.getClient2(getApplicationContext()).create(UserClient.class);
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        getVerifyCitizenFormList();
        this.alertDialog.show();
        this.noteOpen.setVisibility(8);
        this.spinner.setVisibility(8);
        this.noteOpen.setText("Click here to view ASD/85+ count ");
        this.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View viewInflate2 = LayoutInflater.from(ViewLogicalActivity.this).inflate(R.layout.category_count_dialog_layout, (ViewGroup) null);
                TextView textView = (TextView) viewInflate2.findViewById(R.id.txtSelfCount);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.txtProgeny);
                TextView textView3 = (TextView) viewInflate2.findViewById(R.id.txtNeither);
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.noteTotal);
                textView.setText(ViewLogicalActivity.this.getString(R.string.deceased) + " - " + ViewLogicalActivity.this.deceasedCount);
                textView2.setText(ViewLogicalActivity.this.getString(R.string.eightyFivePlus) + " - " + ViewLogicalActivity.this.eightyFivePlusCount);
                textView3.setVisibility(8);
                textView4.setText(ViewLogicalActivity.this.getString(R.string.total_document_upload_count) + StringUtils.SPACE + (ViewLogicalActivity.this.deceasedCount + ViewLogicalActivity.this.eightyFivePlusCount));
                new AlertDialog.Builder(ViewLogicalActivity.this).setTitle(ViewLogicalActivity.this.getString(R.string.asd_count)).setView(viewInflate2).setPositiveButton(ViewLogicalActivity.this.getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });
        this.textView5.setText("v" + this.commomUtility.appversion);
        this.textView3.setText(getResources().getString(R.string.post_anomaly));
        this.listArray = getResources().getStringArray(R.array.asd_options);
        this.efOptionList = new ArrayList(Arrays.asList(this.listArray));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, android.R.layout.simple_spinner_item, this.efOptionList);
        this.adapterSpinner = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter((SpinnerAdapter) this.adapterSpinner);
        this.spinner.setSelection(0);
        this.spinner.setOnItemSelectedListener(this);
        if (this.deceasedCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(1));
            String str = getString(R.string.deceased) + " - " + this.deceasedCount;
            this.efOptionList.add(1, str);
            this.efOptionList.set(1, str);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.eightyFivePlusCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(2));
            this.efOptionList.add(2, getString(R.string.eightyFivePlus) + " -" + this.eightyFivePlusCount);
            this.adapterSpinner.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAnomalyDetailsNew(VerifyPayload item, int pos) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("acNo", this.acNo);
        map2.put("partNo", this.partNo);
        map2.put("state", this.state);
        map2.put("epicNo", item.getEpicNo());
        map2.put("epicId", item.getEpicId());
        this.service.getAnomalyByEpicIdV2New(this.state.toLowerCase(), map, map2).enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        AnonymousClass2() {
        }

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
                    if (ViewLogicalActivity.this.anomalydetailsListvalue != null && ViewLogicalActivity.this.anomalydetailsListvalue.size() > 0) {
                        ViewLogicalActivity.this.anomalydetailsListvalue.clear();
                    }
                    JsonArray asJsonArray = ViewLogicalActivity.this.gson.toJsonTree(((JsonObject) response.body()).get("payload")).getAsJsonArray();
                    if (asJsonArray == null || asJsonArray.isEmpty()) {
                        return;
                    }
                    for (Map.Entry entry : asJsonArray.get(0).getAsJsonObject().entrySet()) {
                        String asString = ((JsonElement) entry.getValue()).isJsonNull() ? "" : ((JsonElement) entry.getValue()).getAsString();
                        if (!TextUtils.isEmpty(asString) && !asString.equalsIgnoreCase("N")) {
                            ViewLogicalActivity.this.anomalydetailsListvalue.add(asString);
                        }
                    }
                    ViewLogicalActivity viewLogicalActivity = ViewLogicalActivity.this;
                    viewLogicalActivity.AnomalyDetailsDialogvalue(viewLogicalActivity.anomalydetailsListvalue);
                    return;
                } catch (IOException | JSONException | Exception unused) {
                    return;
                }
            }
            if (response.code() == 401) {
                ViewLogicalActivity.this.commomUtility.showMessageOK(ViewLogicalActivity.this, "SESSION", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
            } else {
                new JSONObject(response.errorBody().string()).optString("message");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewLogicalActivity.this).setIsLoggedIn(false);
            SharedPref.getInstance(ViewLogicalActivity.this).setLocaleBool(false);
            ViewLogicalActivity.this.startActivity(new Intent((Context) ViewLogicalActivity.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void AnomalyDetailsDialogvalue(ArrayList<String> clusterDetails) {
        MappingAnomalyDetailsValueDialogBinding mappingAnomalyDetailsValueDialogBindingInflate = MappingAnomalyDetailsValueDialogBinding.inflate(LayoutInflater.from(this));
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(mappingAnomalyDetailsValueDialogBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        mappingAnomalyDetailsValueDialogBindingInflate.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mappingAnomalyDetailsValueDialogBindingInflate.recyclerView.setAdapter(new AnomalyListValueAdapter(clusterDetails, this, new ItemClickCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity.3
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback
            public void onClicked(VerifyPayload formverificationPayload, String type) {
            }
        }));
        mappingAnomalyDetailsValueDialogBindingInflate.noremark.setVisibility(8);
        mappingAnomalyDetailsValueDialogBindingInflate.txtSubmit.setVisibility(8);
        mappingAnomalyDetailsValueDialogBindingInflate.ivCancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
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

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            showToast("Camera permission cancelled!");
        } else if (requestCode == REQUEST_CODE_CAMERA_PORTRAIT) {
            initScanner();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$0(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$0(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    private void initClickListener() {
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
        this.scanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ViewLogicalActivity.this.cameraPermission();
            }
        });
        this.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ViewLogicalActivity.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getVerifyCitizenFormList() {
        this.commomUtility.getAnomalyListNew(this, this.token, this.atkband, this.rtkband, this.state, this.acNo, this.partNo, "", new AnomalyListCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity.7
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.AnomalyListCallback
            public void onCallBack(int code, List<VerifyPayload> datalist, String message) {
                if (code == 200) {
                    ViewLogicalActivity.this.alertDialog.dismiss();
                    if (datalist != null && datalist.size() > 0) {
                        if (ViewLogicalActivity.this.formlist != null && ViewLogicalActivity.this.formlist.size() > 0) {
                            ViewLogicalActivity.this.formlist.clear();
                        }
                        ViewLogicalActivity.this.formlist = datalist;
                        ViewLogicalActivity.this.verifyCitizenListAdapter = new ViewLogicalAdapter(ViewLogicalActivity.this.formlist, ViewLogicalActivity.this, new AnomalyItemClickCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity.7.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.AnomalyItemClickCallback
                            public void onClicked(VerifyPayload formverificationPayload, String type) {
                                ViewLogicalActivity.this.getAnomalyDetailsNew(formverificationPayload, Integer.parseInt(type));
                            }
                        });
                        ViewLogicalActivity.this.recyclerView.setAdapter(ViewLogicalActivity.this.verifyCitizenListAdapter);
                        ViewLogicalActivity.this.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.ViewLogicalActivity.7.2
                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                String string = editable.toString();
                                ArrayList<VerifyPayload> arrayList = new ArrayList<>();
                                for (VerifyPayload verifyPayload : ViewLogicalActivity.this.formlist) {
                                    if (!TextUtils.isEmpty(String.valueOf(verifyPayload.getPartSerialNo())) && String.valueOf(verifyPayload.getPartSerialNo()).toLowerCase().equals(string.toLowerCase())) {
                                        if (arrayList.size() > 0) {
                                            arrayList.clear();
                                        }
                                        arrayList.add(verifyPayload);
                                        break;
                                    } else if ((!TextUtils.isEmpty(verifyPayload.getEpicNo()) && verifyPayload.getEpicNo().toLowerCase().contains(string.toLowerCase())) || ((!TextUtils.isEmpty(String.valueOf(verifyPayload.getPartSerialNo())) && String.valueOf(verifyPayload.getPartSerialNo()).toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(verifyPayload.getEpicName())) && String.valueOf(verifyPayload.getEpicName()).toLowerCase().contains(string.toLowerCase())))) {
                                        arrayList.add(verifyPayload);
                                    }
                                }
                                ViewLogicalActivity.this.verifyCitizenListAdapter.fun(arrayList);
                            }
                        });
                        return;
                    }
                    ViewLogicalActivity.this.alertDialog.dismiss();
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    Utils utils = ViewLogicalActivity.this.utils;
                    ?? r4 = ViewLogicalActivity.this;
                    utils.infoDialog(r4, r4.getResources().getString(R.string.alertMsg), message);
                    return;
                }
                ViewLogicalActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = ViewLogicalActivity.this.utils;
                ?? r5 = ViewLogicalActivity.this;
                utils2.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("restart", false)) {
            recreate();
        }
    }
}
