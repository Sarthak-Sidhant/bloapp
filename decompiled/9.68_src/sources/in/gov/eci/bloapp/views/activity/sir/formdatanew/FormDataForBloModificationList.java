package in.gov.eci.bloapp.views.activity.sir.formdatanew;

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
import in.gov.eci.bloapp.adapter.FormDataFoBloModificationAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.entity.FormDataForBloModificationVariables;
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
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FormDataForBloModificationList extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    List<String> FOrmDataOptionList;
    private String acNo;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<FormDataForBloModificationVariables> al;
    AlertDialog alertDialog;
    private String atkband;
    private ImageView back_btn_iv;
    String barcode;
    FormDataFoBloModificationAdapter formAdapter;
    String[] listArray;
    TextView note1;
    TextView note2;
    TextView note3;
    TextView note4;
    TextView noteOpen;
    private String partNo;
    RecyclerView recyclerView;
    private String refreshToken;
    private String rtkband;
    Button scanCode;
    EditText search;
    Spinner spinner;
    private String state;
    private String token;
    String alertText = "";
    String SESSION = "";
    String TAG = "FormDataForBloModificationList";
    CommomUtility commomUtility = new CommomUtility();
    String base64element1 = "";
    String comingTag = "coming in onFailure";
    String messageString = "message";
    String objectStorageString = "objectstorage";
    int cat1WithoutOldDetails = 0;
    int cat1WithOldDetails = 0;
    int catNot1WithDocFlagY = 0;
    int catNot1WithDocFlagN = 0;
    int catNot1WithDocFlagD = 0;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_data_for_blo_modification_list);
        this.alertText = getString(R.string.alertMsg);
        this.SESSION = getString(R.string.sessionMsg);
        this.recyclerView = findViewById(R.id.recyclerView);
        this.search = (EditText) findViewById(R.id.search);
        this.scanCode = (Button) findViewById(R.id.btScanCode);
        this.noteOpen = (TextView) findViewById(R.id.noteOpen);
        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.back_btn_iv = (ImageView) findViewById(R.id.back_btn_iv);
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
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        makeApiCall();
        this.alertDialog.show();
        this.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View viewInflate2 = LayoutInflater.from(FormDataForBloModificationList.this).inflate(R.layout.custom_modal, (ViewGroup) null);
                TextView textView = (TextView) viewInflate2.findViewById(R.id.note3);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.note4);
                TextView textView3 = (TextView) viewInflate2.findViewById(R.id.note5);
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.noteTotal);
                textView.setText(FormDataForBloModificationList.this.getString(R.string.custom_modal_note3) + FormDataForBloModificationList.this.catNot1WithDocFlagY);
                textView2.setText(FormDataForBloModificationList.this.getString(R.string.custom_modal_note5) + FormDataForBloModificationList.this.catNot1WithDocFlagN);
                textView3.setText(FormDataForBloModificationList.this.getString(R.string.custom_modal_note4) + FormDataForBloModificationList.this.catNot1WithDocFlagD);
                textView4.setText(FormDataForBloModificationList.this.getString(R.string.total_document_upload_count) + (FormDataForBloModificationList.this.catNot1WithDocFlagY + FormDataForBloModificationList.this.catNot1WithDocFlagD + FormDataForBloModificationList.this.catNot1WithDocFlagN));
                new AlertDialog.Builder(FormDataForBloModificationList.this).setTitle(FormDataForBloModificationList.this.getString(R.string.noteInfo)).setView(viewInflate2).setPositiveButton(FormDataForBloModificationList.this.getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create().show();
            }
        });
        this.listArray = getResources().getStringArray(R.array.options);
        this.FOrmDataOptionList = new ArrayList(Arrays.asList(this.listArray));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, android.R.layout.simple_spinner_item, this.FOrmDataOptionList);
        this.adapterSpinner = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter((SpinnerAdapter) this.adapterSpinner);
        this.spinner.setOnItemSelectedListener(this);
        if (this.catNot1WithDocFlagY == 0) {
            this.FOrmDataOptionList.remove(this.adapterSpinner.getItem(1));
            String string = getString(R.string.full_doc_uploaded, new Object[]{Integer.valueOf(this.catNot1WithDocFlagY)});
            this.FOrmDataOptionList.add(1, string);
            this.FOrmDataOptionList.set(1, string);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.catNot1WithDocFlagN == 0) {
            this.FOrmDataOptionList.remove(this.adapterSpinner.getItem(2));
            String string2 = getString(R.string.no_doc_uploaded, new Object[]{Integer.valueOf(this.catNot1WithDocFlagN)});
            this.FOrmDataOptionList.add(2, string2);
            this.FOrmDataOptionList.set(2, string2);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.catNot1WithDocFlagD == 0) {
            this.FOrmDataOptionList.remove(this.adapterSpinner.getItem(3));
            String string3 = getString(R.string.partial_doc_uploaded, new Object[]{Integer.valueOf(this.catNot1WithDocFlagD)});
            this.FOrmDataOptionList.add(3, string3);
            this.FOrmDataOptionList.set(3, string3);
            this.adapterSpinner.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList$$ExternalSyntheticLambda0
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
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
        this.scanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormDataForBloModificationList.this.cameraPermission();
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
        map2.put("key", "A");
        ((UserClient) ApiClient.getClient(this).create(UserClient.class)).getAllFormDataSIR(map, map2).enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v22, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList] */
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
                Log.d("response.code()= ", "" + response.code());
                if (response.code() == 200) {
                    if (!response.isSuccessful()) {
                        String string = new JSONObject(response.errorBody().string()).getString("message");
                        FormDataForBloModificationList formDataForBloModificationList = FormDataForBloModificationList.this;
                        formDataForBloModificationList.showDialog2(formDataForBloModificationList.alertText, string);
                    } else if (response.isSuccessful() && response.body() != null) {
                        JSONArray jSONArray = new JSONArray(new Gson().toJson(((JsonObject) response.body()).get("payload")));
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            int i2 = jSONObject.getInt("id");
                            String strOptString = jSONObject.optString("epicNo", null);
                            Long lValueOf = Long.valueOf(jSONObject.optLong("epicId"));
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
                            FormDataForBloModificationList.this.al.add(new FormDataForBloModificationVariables(i2, "", strOptString, lValueOf, strOptString4, strOptString2, "", "", strOptString5, strOptString6, strOptString3, "", strOptString47, "", "", strOptString15, strOptString16, strOptString18, strOptString48, jSONObject.optString("surveyChannel", null), strOptString32, "", strOptString35, strOptString38, strOptString41, strOptString26, strOptString29, strOptString22, strOptString33, "", strOptString36, strOptString39, strOptString42, strOptString27, strOptString30, strOptString7, strOptString8, strOptString9, strOptString10, strOptString11, strOptString12, strOptString13, strOptString14, strOptString50, strOptString23, strOptString24, "", strOptString45, strOptString46, strOptString17, strOptString19, strOptString20, strOptString21, strOptString49, strOptString34, "", strOptString37, strOptString40, strOptString43, strOptString44, strOptString28, strOptString31, strOptString25, "", "", "", jSONObject.optString("moldAcNo", null), jSONObject.optString("moldPartNo", null), jSONObject.optString("moldPslNo", null), jSONObject.optString("foldAcNo", null), jSONObject.optString("foldPartNo", null), jSONObject.optString("foldPslNo", null), strOptString51, jSONObject.optString("bloOverridenFlg", null), jSONObject.optString("relationProofDocUrlPg1", null), jSONObject.optString("relationProofDocUrlPg2", null), jSONObject.optString("relationType", null), jSONObject.optString("relationOldAcNo", null), jSONObject.optString("relationOldPartNo", null), jSONObject.optString("relationOldPslNo", null), jSONObject.optString("relationDocType", null), jSONObject.optString("relationDocUrlPg1", null), jSONObject.optString("relationDocUrlPg2", null), jSONObject.optString("isRelativePreVoterFlg", null), jSONObject.optString("relationEpicNo", null), jSONObject.optString("isThisYou", null), jSONObject.optString("isThisYouRel", null), jSONObject.optString("relationOldStateCd", null), jSONObject.optString("oldStateCd", null), jSONObject.optString("erollAge", null)));
                        }
                        FormDataForBloModificationList.this.formAdapter = new FormDataFoBloModificationAdapter(FormDataForBloModificationList.this.al, FormDataForBloModificationList.this);
                        FormDataForBloModificationList.this.recyclerView.setAdapter(FormDataForBloModificationList.this.formAdapter);
                        if (FormDataForBloModificationList.this.spinner != null) {
                            FormDataForBloModificationList.this.spinner.setSelection(0);
                        }
                        for (int i3 = 0; i3 < FormDataForBloModificationList.this.al.size(); i3++) {
                            if (FormDataForBloModificationList.this.al.get(i3).getDocumentUploadedFlg().equals("Y")) {
                                FormDataForBloModificationList.this.catNot1WithDocFlagY++;
                                FormDataForBloModificationList.this.FOrmDataOptionList.remove(FormDataForBloModificationList.this.adapterSpinner.getItem(1));
                                FormDataForBloModificationList formDataForBloModificationList2 = FormDataForBloModificationList.this;
                                String string2 = formDataForBloModificationList2.getString(R.string.full_doc_uploaded, new Object[]{Integer.valueOf(formDataForBloModificationList2.catNot1WithDocFlagY)});
                                FormDataForBloModificationList.this.FOrmDataOptionList.add(1, string2);
                                FormDataForBloModificationList.this.FOrmDataOptionList.set(1, string2);
                                FormDataForBloModificationList.this.adapterSpinner.notifyDataSetChanged();
                            } else if (FormDataForBloModificationList.this.al.get(i3).getDocumentUploadedFlg().equals("N")) {
                                FormDataForBloModificationList.this.catNot1WithDocFlagN++;
                                FormDataForBloModificationList.this.FOrmDataOptionList.remove(FormDataForBloModificationList.this.adapterSpinner.getItem(2));
                                FormDataForBloModificationList formDataForBloModificationList3 = FormDataForBloModificationList.this;
                                String string3 = formDataForBloModificationList3.getString(R.string.no_doc_uploaded, new Object[]{Integer.valueOf(formDataForBloModificationList3.catNot1WithDocFlagN)});
                                FormDataForBloModificationList.this.FOrmDataOptionList.add(2, string3);
                                FormDataForBloModificationList.this.FOrmDataOptionList.set(2, string3);
                                FormDataForBloModificationList.this.adapterSpinner.notifyDataSetChanged();
                            } else if (FormDataForBloModificationList.this.al.get(i3).getDocumentUploadedFlg().equals("D")) {
                                FormDataForBloModificationList.this.catNot1WithDocFlagD++;
                                FormDataForBloModificationList.this.FOrmDataOptionList.remove(FormDataForBloModificationList.this.adapterSpinner.getItem(3));
                                FormDataForBloModificationList formDataForBloModificationList4 = FormDataForBloModificationList.this;
                                String string4 = formDataForBloModificationList4.getString(R.string.partial_doc_uploaded, new Object[]{Integer.valueOf(formDataForBloModificationList4.catNot1WithDocFlagD)});
                                FormDataForBloModificationList.this.FOrmDataOptionList.add(3, string4);
                                FormDataForBloModificationList.this.FOrmDataOptionList.set(3, string4);
                                FormDataForBloModificationList.this.adapterSpinner.notifyDataSetChanged();
                            }
                        }
                        FormDataForBloModificationList.this.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList.3.1
                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i4, int i1, int i5) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i4, int i1, int i5) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                String string5 = editable.toString();
                                ArrayList<FormDataForBloModificationVariables> arrayList = new ArrayList<>();
                                for (FormDataForBloModificationVariables formDataForBloModificationVariables : FormDataForBloModificationList.this.al) {
                                    if (!TextUtils.isEmpty(formDataForBloModificationVariables.getPartSerialNo()) && formDataForBloModificationVariables.getPartSerialNo().toLowerCase().equals(string5.toLowerCase())) {
                                        if (arrayList.size() > 0) {
                                            arrayList.clear();
                                        }
                                        arrayList.add(formDataForBloModificationVariables);
                                        break;
                                    } else if ((!TextUtils.isEmpty(formDataForBloModificationVariables.getEpicNo()) && formDataForBloModificationVariables.getEpicNo().toLowerCase().contains(string5.toLowerCase())) || ((!TextUtils.isEmpty(formDataForBloModificationVariables.getHouseNo()) && formDataForBloModificationVariables.getHouseNo().toLowerCase().contains(string5.toLowerCase())) || ((!TextUtils.isEmpty(formDataForBloModificationVariables.getPartNo()) && formDataForBloModificationVariables.getPartNo().toLowerCase().contains(string5.toLowerCase())) || ((!TextUtils.isEmpty(formDataForBloModificationVariables.getPartSerialNo()) && formDataForBloModificationVariables.getPartSerialNo().toLowerCase().contains(string5.toLowerCase())) || ((!TextUtils.isEmpty(formDataForBloModificationVariables.getElectorName()) && formDataForBloModificationVariables.getElectorName().toLowerCase().contains(string5.toLowerCase())) || (!TextUtils.isEmpty(formDataForBloModificationVariables.getAcNo()) && formDataForBloModificationVariables.getAcNo().toLowerCase().contains(string5.toLowerCase()))))))) {
                                        arrayList.add(formDataForBloModificationVariables);
                                    }
                                }
                                FormDataForBloModificationList.this.formAdapter.fun(arrayList);
                                FormDataForBloModificationList.this.spinner.setSelection(0);
                            }
                        });
                    }
                } else if (response.code() == 401) {
                    try {
                        CommomUtility commomUtility = FormDataForBloModificationList.this.commomUtility;
                        ?? r2 = FormDataForBloModificationList.this;
                        commomUtility.getRefreshToken(r2, ((FormDataForBloModificationList) r2).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList$3$$ExternalSyntheticLambda0
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i4, String str, String str2) {
                                this.f$0.lambda$onResponse$1(i4, str, str2);
                            }
                        });
                    } catch (Exception e) {
                        Logger.e(FormDataForBloModificationList.this.TAG, e.toString());
                    }
                } else {
                    try {
                        if (FormDataForBloModificationList.this.alertDialog != null) {
                            FormDataForBloModificationList.this.alertDialog.dismiss();
                        }
                        JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                        Logger.e(FormDataForBloModificationList.this.TAG, jSONObject2.optString("message"));
                        FormDataForBloModificationList formDataForBloModificationList5 = FormDataForBloModificationList.this;
                        formDataForBloModificationList5.showDialog3(formDataForBloModificationList5.getString(R.string.alertMsg), jSONObject2.optString("message"));
                    } catch (IOException | JSONException e2) {
                        if (FormDataForBloModificationList.this.alertDialog != null) {
                            FormDataForBloModificationList.this.alertDialog.dismiss();
                        }
                        Logger.e(FormDataForBloModificationList.this.TAG, e2.getMessage());
                    }
                }
                FormDataForBloModificationList.this.alertDialog.dismiss();
            } catch (Exception e3) {
                Log.d("Here", "Inside catch" + e3.getMessage());
                Logger.d("ReverifyList", e3.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$2();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList] */
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
            FormDataForBloModificationList.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormDataForBloModificationList.this.commomUtility;
                ?? r5 = FormDataForBloModificationList.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList$3$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormDataForBloModificationList.this.token = "Bearer " + str;
                SharedPref.getInstance(FormDataForBloModificationList.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(FormDataForBloModificationList.this.getApplicationContext()).setToken("Bearer " + str);
                FormDataForBloModificationList.this.makeApiCall();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormDataForBloModificationList.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormDataForBloModificationList.this.getApplicationContext()).setLocaleBool(false);
            FormDataForBloModificationList.this.startActivity(new Intent(FormDataForBloModificationList.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            FormDataForBloModificationList.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (FormDataForBloModificationList.this.alertDialog != null) {
                FormDataForBloModificationList.this.alertDialog.dismiss();
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList$$ExternalSyntheticLambda2
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList$$ExternalSyntheticLambda3
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
        Intent intent = new Intent((Context) this, (Class<?>) FormTypes.class);
        intent.setFlags(603979776);
        intent.putExtra("restart", true);
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            FormDataFoBloModificationAdapter formDataFoBloModificationAdapter = new FormDataFoBloModificationAdapter(this.al, this);
            this.formAdapter = formDataFoBloModificationAdapter;
            this.recyclerView.setAdapter(formDataFoBloModificationAdapter);
        }
        if (position == 1) {
            ArrayList<FormDataForBloModificationVariables> arrayList = new ArrayList<>();
            for (FormDataForBloModificationVariables formDataForBloModificationVariables : this.al) {
                if (formDataForBloModificationVariables.getDocumentUploadedFlg().equals("Y")) {
                    arrayList.add(formDataForBloModificationVariables);
                }
            }
            FormDataFoBloModificationAdapter formDataFoBloModificationAdapter2 = this.formAdapter;
            if (formDataFoBloModificationAdapter2 != null) {
                formDataFoBloModificationAdapter2.fun(arrayList);
                return;
            }
            return;
        }
        if (position == 2) {
            ArrayList<FormDataForBloModificationVariables> arrayList2 = new ArrayList<>();
            for (FormDataForBloModificationVariables formDataForBloModificationVariables2 : this.al) {
                if (formDataForBloModificationVariables2.getDocumentUploadedFlg().equals("D")) {
                    arrayList2.add(formDataForBloModificationVariables2);
                }
            }
            FormDataFoBloModificationAdapter formDataFoBloModificationAdapter3 = this.formAdapter;
            if (formDataFoBloModificationAdapter3 != null) {
                formDataFoBloModificationAdapter3.fun(arrayList2);
                return;
            }
            return;
        }
        if (position == 3) {
            ArrayList<FormDataForBloModificationVariables> arrayList3 = new ArrayList<>();
            for (FormDataForBloModificationVariables formDataForBloModificationVariables3 : this.al) {
                if (formDataForBloModificationVariables3.getDocumentUploadedFlg().equals("N")) {
                    arrayList3.add(formDataForBloModificationVariables3);
                }
            }
            FormDataFoBloModificationAdapter formDataFoBloModificationAdapter4 = this.formAdapter;
            if (formDataFoBloModificationAdapter4 != null) {
                formDataFoBloModificationAdapter4.fun(arrayList3);
            }
        }
    }
}
