package in.gov.eci.bloapp.views.activity.SIRBH.formdatanew;

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
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.RollbackFormAdapterBH;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.entity.RollbackFormVariables;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class RollbackFormsListBH extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private String acNo;
    ArrayList<RollbackFormVariables> al;
    AlertDialog alertDialog;
    private String atkband;
    private ImageView back_btn_iv;
    String barcode;
    RollbackFormAdapterBH formAdapter;
    TextView noteOpen;
    private String partNo;
    RecyclerView recyclerView;
    private String refreshToken;
    private String rtkband;
    Button scanCode;
    EditText search;
    Spinner spinner;
    private String state;
    TextView textView3;
    private String token;
    String alertText = "";
    String SESSION = "";
    String TAG = "RollbackFormsListBH";
    CommomUtility commomUtility = new CommomUtility();
    String base64element1 = "";
    String comingTag = "coming in onFailure";
    String messageString = "message";
    String objectStorageString = "objectstorage";
    int catNot1WithDocFlagY = 0;
    int catNot1WithDocFlagN = 0;
    int catNot1WithDocFlagD = 0;
    int totalDocuments = 0;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rollback_forms_list_bh);
        this.alertText = getString(R.string.alertMsg);
        this.SESSION = getString(R.string.sessionMsg);
        this.recyclerView = findViewById(R.id.recyclerView);
        this.search = (EditText) findViewById(R.id.search);
        this.back_btn_iv = (ImageView) findViewById(R.id.back_btn_iv);
        this.textView3 = (TextView) findViewById(R.id.textView3);
        this.noteOpen = (TextView) findViewById(R.id.noteOpen);
        this.scanCode = (Button) findViewById(R.id.scanCode);
        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.al = new ArrayList<>();
        initClickListener();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.textView3.setSelected(true);
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        makeApiCall();
        this.alertDialog.show();
        this.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View viewInflate2 = LayoutInflater.from(RollbackFormsListBH.this).inflate(R.layout.custom_modal, (ViewGroup) null);
                TextView textView = (TextView) viewInflate2.findViewById(R.id.note3);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.note4);
                TextView textView3 = (TextView) viewInflate2.findViewById(R.id.note5);
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.noteTotal);
                textView.setText(RollbackFormsListBH.this.getString(R.string.custom_modal_note3) + RollbackFormsListBH.this.catNot1WithDocFlagY);
                textView2.setText(RollbackFormsListBH.this.getString(R.string.custom_modal_note5) + RollbackFormsListBH.this.catNot1WithDocFlagN);
                textView3.setText(RollbackFormsListBH.this.getString(R.string.custom_modal_note4) + RollbackFormsListBH.this.catNot1WithDocFlagD);
                textView4.setText(RollbackFormsListBH.this.getString(R.string.total_document_upload_count) + (RollbackFormsListBH.this.catNot1WithDocFlagY + RollbackFormsListBH.this.catNot1WithDocFlagD + RollbackFormsListBH.this.catNot1WithDocFlagN));
                new AlertDialog.Builder(RollbackFormsListBH.this).setTitle(RollbackFormsListBH.this.getString(R.string.noteInfo)).setView(viewInflate2).setPositiveButton(RollbackFormsListBH.this.getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create().show();
            }
        });
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.options, R.layout.spinner_dropdown_list_item_sir);
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        this.spinner.setOnItemSelectedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH$$ExternalSyntheticLambda2
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
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
        this.scanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RollbackFormsListBH.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        onBackPressed();
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
        if (activityResult != null) {
            if (activityResult.getContents() == null) {
                Toast.makeText((Context) this, (CharSequence) "Scanning cancelled!", 1).show();
                return;
            }
            String contents = activityResult.getContents();
            try {
                this.barcode = new JSONObject(AESDecryptor.decrypt(contents)).getString("epic_no");
            } catch (Exception unused) {
                this.barcode = contents;
            }
            String strReplace = this.barcode.replace(StringUtils.SPACE, "");
            this.barcode = strReplace;
            this.search.setText(strReplace);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
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
    public void makeApiCall() {
        Log.d("Here", "Inside the funcTion");
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        HashMap map2 = new HashMap();
        map2.put("acNo", this.acNo);
        map2.put("partNo", this.partNo);
        map2.put("stCode", this.state);
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getRollbackForms(map, map2).enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v19, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH] */
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
            try {
                if (response.code() == 200) {
                    if (!response.isSuccessful()) {
                        String string = new JSONObject(response.errorBody().string()).getString("message");
                        RollbackFormsListBH rollbackFormsListBH = RollbackFormsListBH.this;
                        rollbackFormsListBH.showDialog2(rollbackFormsListBH.alertText, string);
                    } else if (response.isSuccessful() && response.body() != null) {
                        JSONArray jSONArray = new JSONArray(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            int i2 = jSONObject.getInt("id");
                            String strOptString = jSONObject.optString("epicNo", null);
                            String strOptString2 = jSONObject.optString("dobVerified", null);
                            String strOptString3 = jSONObject.optString("partSerialNo", null);
                            String strOptString4 = jSONObject.optString("houseNo", null);
                            String strOptString5 = jSONObject.optString("acNo", null);
                            String strOptString6 = jSONObject.optString("partNo", null);
                            String strOptString7 = jSONObject.optString("aadharNo", null);
                            String strOptString8 = jSONObject.optString("mobileNo", null);
                            String strOptString9 = jSONObject.optString("fathersOrGuardianName", null);
                            String strOptString10 = jSONObject.optString("fathersOrGuardianEpicNo", null);
                            String strOptString11 = jSONObject.optString("mothersName", null);
                            String strOptString12 = jSONObject.optString("mothersEpicNo", null);
                            String strOptString13 = jSONObject.optString("spouseName", null);
                            String strOptString14 = jSONObject.optString("spouseEpicNo", null);
                            String strOptString15 = jSONObject.optString("photoUrl", null);
                            String strOptString16 = jSONObject.optString("srFormPage1Url", "");
                            String strOptString17 = jSONObject.optString("srFormPage2Url", "");
                            String strOptString18 = jSONObject.optString("citizenshipType", null);
                            String strOptString19 = jSONObject.optString("oldAcNo", null);
                            String strOptString20 = jSONObject.optString("oldPartNo", null);
                            String strOptString21 = jSONObject.optString("oldPslNo", null);
                            String strOptString22 = jSONObject.optString("list8Doc", null);
                            String strOptString23 = jSONObject.optString("preRevisionVoterFlg", null);
                            String strOptString24 = jSONObject.optString("preRevisionVoterDocUrl", null);
                            String strOptString25 = jSONObject.optString("preRevisionVoterDocUrlPg2", null);
                            String strOptString26 = jSONObject.optString("list6Doc", null);
                            String strOptString27 = jSONObject.optString("list6DocUrl", null);
                            String strOptString28 = jSONObject.optString("list6docUrlPg2", null);
                            String strOptString29 = jSONObject.optString("list7Doc", null);
                            String strOptString30 = jSONObject.optString("list7DocUrl", null);
                            String strOptString31 = jSONObject.optString("list7docUrlPg2", null);
                            String strOptString32 = jSONObject.optString("list1Doc", null);
                            String strOptString33 = jSONObject.optString("list1DocUrl", null);
                            String strOptString34 = jSONObject.optString("list1docUrlPg2", null);
                            String strOptString35 = jSONObject.optString("list3Doc", null);
                            String strOptString36 = jSONObject.optString("list3DocUrl", null);
                            String strOptString37 = jSONObject.optString("list3docUrlPg2", null);
                            String strOptString38 = jSONObject.optString("list4Doc", null);
                            String strOptString39 = jSONObject.optString("list4DocUrl", null);
                            String strOptString40 = jSONObject.optString("list4docUrlPg2", null);
                            String strOptString41 = jSONObject.optString("list5Doc", null);
                            String strOptString42 = jSONObject.optString("list5DocUrl", null);
                            String strOptString43 = jSONObject.optString("list5docUrlPg2", null);
                            String strOptString44 = jSONObject.optString("list5docUrlPg3", null);
                            String strOptString45 = jSONObject.optString("fathersNationality", null);
                            String strOptString46 = jSONObject.optString("mothersNationality", null);
                            String strOptString47 = jSONObject.optString("createdBy", "");
                            String strOptString48 = jSONObject.optString("citizenshipTypeCat", "");
                            String strOptString49 = jSONObject.optString("documentUploadedFlg", "");
                            String strOptString50 = jSONObject.optString("annexureCUrl", null);
                            String strOptString51 = jSONObject.optString("electorName", null);
                            String strOptString52 = jSONObject.optString("surveyChannel", null);
                            String strOptString53 = jSONObject.optString("bloOverridenFlg", null);
                            RollbackFormsListBH.this.al.add(new RollbackFormVariables(i2, "", strOptString, 0L, strOptString4, strOptString2, "", "", strOptString5, strOptString6, strOptString3, "", strOptString47, "", "", strOptString15, strOptString16, strOptString18, strOptString48, strOptString52, strOptString32, "", strOptString35, strOptString38, strOptString41, strOptString26, strOptString29, strOptString22, strOptString33, "", strOptString36, strOptString39, strOptString42, strOptString27, strOptString30, strOptString7, strOptString8, strOptString9, strOptString10, strOptString11, strOptString12, strOptString13, strOptString14, strOptString50, strOptString23, strOptString24, "", strOptString45, strOptString46, strOptString17, strOptString19, strOptString20, strOptString21, strOptString49, strOptString34, "", strOptString37, strOptString40, strOptString43, strOptString44, strOptString28, strOptString31, strOptString25, "", "", "", jSONObject.optString("moldAcNo", null), jSONObject.optString("moldPartNo", null), jSONObject.optString("moldPslNo", null), jSONObject.optString("foldAcNo", null), jSONObject.optString("foldPartNo", null), jSONObject.optString("foldPslNo", null), strOptString51, strOptString53, jSONObject.optString("backToBlo", null), jSONObject.optString("backToBloRemarks", null), jSONObject.optString("relationProofDocUrlPg1", null), jSONObject.optString("relationProofDocUrlPg2", null), jSONObject.optString("relationType", null), jSONObject.optString("relationOldAcNo", null), jSONObject.optString("relationOldPartNo", null), jSONObject.optString("relationOldPslNo", null), jSONObject.optString("relationDocType", null), jSONObject.optString("relationDocUrlPg1", null), jSONObject.optString("relationDocUrlPg2", null), jSONObject.optString("isRelativePreVoterFlg", null), jSONObject.optString("relationEpicNo", null), null, null, null, null, jSONObject.optString("erollAge", null)));
                        }
                        RollbackFormsListBH.this.formAdapter = new RollbackFormAdapterBH(RollbackFormsListBH.this.al, RollbackFormsListBH.this);
                        RollbackFormsListBH.this.recyclerView.setAdapter(RollbackFormsListBH.this.formAdapter);
                        if (RollbackFormsListBH.this.spinner != null) {
                            RollbackFormsListBH.this.spinner.setSelection(0);
                        }
                        for (int i3 = 0; i3 < RollbackFormsListBH.this.al.size(); i3++) {
                            if (RollbackFormsListBH.this.al.get(i3).getDocumentUploadedFlg().equals("Y")) {
                                RollbackFormsListBH.this.catNot1WithDocFlagY++;
                            } else if (RollbackFormsListBH.this.al.get(i3).getDocumentUploadedFlg().equals("N")) {
                                RollbackFormsListBH.this.catNot1WithDocFlagN++;
                            } else if (RollbackFormsListBH.this.al.get(i3).getDocumentUploadedFlg().equals("D")) {
                                RollbackFormsListBH.this.catNot1WithDocFlagD++;
                            }
                        }
                        RollbackFormsListBH.this.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH.3.1
                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i4, int i1, int i5) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i4, int i1, int i5) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                String string2 = editable.toString();
                                ArrayList<RollbackFormVariables> arrayList = new ArrayList<>();
                                for (RollbackFormVariables rollbackFormVariables : RollbackFormsListBH.this.al) {
                                    if ((!TextUtils.isEmpty(rollbackFormVariables.getEpicNo()) && rollbackFormVariables.getEpicNo().toLowerCase().contains(string2.toLowerCase())) || ((!TextUtils.isEmpty(rollbackFormVariables.getHouseNo()) && rollbackFormVariables.getHouseNo().toLowerCase().contains(string2.toLowerCase())) || ((!TextUtils.isEmpty(rollbackFormVariables.getPartNo()) && rollbackFormVariables.getPartNo().toLowerCase().contains(string2.toLowerCase())) || ((!TextUtils.isEmpty(rollbackFormVariables.getPartSerialNo()) && rollbackFormVariables.getPartSerialNo().toLowerCase().contains(string2.toLowerCase())) || ((!TextUtils.isEmpty(rollbackFormVariables.getElectorName()) && rollbackFormVariables.getElectorName().toLowerCase().contains(string2.toLowerCase())) || (!TextUtils.isEmpty(rollbackFormVariables.getAcNo()) && rollbackFormVariables.getAcNo().toLowerCase().contains(string2.toLowerCase()))))))) {
                                        arrayList.add(rollbackFormVariables);
                                    }
                                }
                                RollbackFormsListBH.this.formAdapter.fun(arrayList);
                            }
                        });
                    }
                } else if (response.code() == 401) {
                    try {
                        CommomUtility commomUtility = RollbackFormsListBH.this.commomUtility;
                        ?? r2 = RollbackFormsListBH.this;
                        commomUtility.getRefreshToken(r2, ((RollbackFormsListBH) r2).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH$3$$ExternalSyntheticLambda1
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i4, String str, String str2) {
                                this.f$0.lambda$onResponse$1(i4, str, str2);
                            }
                        });
                    } catch (Exception e) {
                        Logger.e(RollbackFormsListBH.this.TAG, e.toString());
                    }
                } else {
                    try {
                        if (RollbackFormsListBH.this.alertDialog != null) {
                            RollbackFormsListBH.this.alertDialog.dismiss();
                        }
                        JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                        Logger.e(RollbackFormsListBH.this.TAG, jSONObject2.optString("message"));
                        RollbackFormsListBH rollbackFormsListBH2 = RollbackFormsListBH.this;
                        rollbackFormsListBH2.showDialog3(rollbackFormsListBH2.getString(R.string.alertMsg), jSONObject2.optString("message"));
                    } catch (IOException | JSONException e2) {
                        if (RollbackFormsListBH.this.alertDialog != null) {
                            RollbackFormsListBH.this.alertDialog.dismiss();
                        }
                        Logger.e(RollbackFormsListBH.this.TAG, e2.getMessage());
                    }
                }
                RollbackFormsListBH.this.alertDialog.dismiss();
            } catch (Exception e3) {
                Log.d("Here", "Inside catch" + e3.getMessage());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH$3$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$2();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH] */
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
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            RollbackFormsListBH.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = RollbackFormsListBH.this.commomUtility;
                ?? r5 = RollbackFormsListBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                RollbackFormsListBH.this.token = "Bearer " + str;
                SharedPref.getInstance(RollbackFormsListBH.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(RollbackFormsListBH.this.getApplicationContext()).setToken("Bearer " + str);
                RollbackFormsListBH.this.makeApiCall();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(RollbackFormsListBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(RollbackFormsListBH.this.getApplicationContext()).setLocaleBool(false);
            RollbackFormsListBH.this.startActivity(new Intent(RollbackFormsListBH.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            RollbackFormsListBH.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (RollbackFormsListBH.this.alertDialog != null) {
                RollbackFormsListBH.this.alertDialog.dismiss();
            }
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("restart", false)) {
            recreate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$2(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$2(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$3(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$3(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) FormTypesBH.class);
        intent.setFlags(603979776);
        intent.putExtra("restart", true);
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            RollbackFormAdapterBH rollbackFormAdapterBH = new RollbackFormAdapterBH(this.al, this);
            this.formAdapter = rollbackFormAdapterBH;
            this.recyclerView.setAdapter(rollbackFormAdapterBH);
        }
        if (position == 1) {
            ArrayList<RollbackFormVariables> arrayList = new ArrayList<>();
            for (RollbackFormVariables rollbackFormVariables : this.al) {
                if (rollbackFormVariables.getDocumentUploadedFlg().equals("Y")) {
                    arrayList.add(rollbackFormVariables);
                }
            }
            RollbackFormAdapterBH rollbackFormAdapterBH2 = this.formAdapter;
            if (rollbackFormAdapterBH2 != null) {
                rollbackFormAdapterBH2.fun(arrayList);
                return;
            }
            return;
        }
        if (position == 3) {
            ArrayList<RollbackFormVariables> arrayList2 = new ArrayList<>();
            for (RollbackFormVariables rollbackFormVariables2 : this.al) {
                if (rollbackFormVariables2.getDocumentUploadedFlg().equals("N")) {
                    arrayList2.add(rollbackFormVariables2);
                }
            }
            RollbackFormAdapterBH rollbackFormAdapterBH3 = this.formAdapter;
            if (rollbackFormAdapterBH3 != null) {
                rollbackFormAdapterBH3.fun(arrayList2);
                return;
            }
            return;
        }
        if (position == 2) {
            ArrayList<RollbackFormVariables> arrayList3 = new ArrayList<>();
            for (RollbackFormVariables rollbackFormVariables3 : this.al) {
                if (rollbackFormVariables3.getDocumentUploadedFlg().equals("D")) {
                    arrayList3.add(rollbackFormVariables3);
                }
            }
            RollbackFormAdapterBH rollbackFormAdapterBH4 = this.formAdapter;
            if (rollbackFormAdapterBH4 != null) {
                rollbackFormAdapterBH4.fun(arrayList3);
            }
        }
    }
}
