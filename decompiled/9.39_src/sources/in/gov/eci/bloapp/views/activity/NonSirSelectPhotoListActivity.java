package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.NonSirSelectPhotoListAdapter;
import in.gov.eci.bloapp.entity.FormDataVariables;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallbackNew;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class NonSirSelectPhotoListActivity extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private static String SESSION = "";
    private String acNo;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<FormDataVariables> al;
    AlertDialog alertDialog;
    private String atkband;
    private ImageView back_btn_iv;
    String barcode;
    Button btScanCode;
    TextView count_text;
    List<String> efOptionList;
    String[] listArray;
    TextView noteOpen;
    private String partNo;
    RecyclerView recyclerView;
    private String refreshToken;
    private String rtkband;
    ConstraintLayout scanCode;
    EditText search;
    Spinner spinner;
    private String state;
    TextView textView3;
    TextView textView5;
    private String token;
    Utils utils;
    NonSirSelectPhotoListAdapter verifyCitizenListAdapter;
    String alertText = "";
    String TAG = "FormDataNewTAG";
    CommomUtility commomUtility = new CommomUtility();
    int erollupdated = 0;
    int filledform8 = 0;
    int noactiontaken = 0;
    int notupdated = 0;
    List<VerifyPayload> formlist = new ArrayList();

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
        this.count_text = (TextView) findViewById(R.id.count_text);
        this.back_btn_iv = (ImageView) findViewById(R.id.back_btn_iv);
        this.textView5 = (TextView) findViewById(R.id.textView5);
        this.scanCode = findViewById(R.id.scanCode);
        this.btScanCode = (Button) findViewById(R.id.btScanCode);
        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.textView3 = (TextView) findViewById(R.id.textView3);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.al = new ArrayList<>();
        this.alertText = getString(R.string.alertMsg);
        this.utils = new Utils();
        initClickListener();
        this.textView3.setText(getResources().getString(R.string.select_photo));
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
        this.textView5.setText("v" + this.commomUtility.appversion);
        this.noteOpen.setVisibility(0);
        this.count_text.setVisibility(8);
        this.spinner.setVisibility(0);
        this.listArray = getResources().getStringArray(R.array.select_photo_options);
        this.efOptionList = new ArrayList(Arrays.asList(this.listArray));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, android.R.layout.simple_spinner_item, this.efOptionList);
        this.adapterSpinner = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter((SpinnerAdapter) this.adapterSpinner);
        this.spinner.setSelection(0);
        this.spinner.setOnItemSelectedListener(this);
        if (this.erollupdated == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(1));
            String str = getString(R.string.eroll_updated) + " - " + this.erollupdated;
            this.efOptionList.add(1, str);
            this.efOptionList.set(1, str);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.filledform8 == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(2));
            this.efOptionList.add(2, getString(R.string.filled_form8) + " -" + this.filledform8);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.noactiontaken == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(3));
            this.efOptionList.add(3, getString(R.string.no_action_taken) + " -" + this.noactiontaken);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.notupdated == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(4));
            this.efOptionList.add(4, getString(R.string.not_updated) + " -" + this.notupdated);
            this.adapterSpinner.notifyDataSetChanged();
        }
        getElectorEfList();
        this.alertDialog.show();
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
            String strReplace = this.barcode.replace(" ", "");
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

    private void initClickListener() {
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.NonSirSelectPhotoListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
        this.scanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.NonSirSelectPhotoListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                NonSirSelectPhotoListActivity.this.cameraPermission();
            }
        });
        this.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.NonSirSelectPhotoListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                NonSirSelectPhotoListActivity.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getElectorEfList() {
        this.commomUtility.getSelectPhotoList1(this, this.token, this.atkband, this.rtkband, this.state, this.acNo, this.partNo, "", new VerifyCitizenListCallbackNew() { // from class: in.gov.eci.bloapp.views.activity.NonSirSelectPhotoListActivity.3
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.NonSirSelectPhotoListActivity] */
            /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.NonSirSelectPhotoListActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallbackNew
            public void onCallBack(int code, List<VerifyPayload> datalist, String message) {
                if (code == 200) {
                    if (NonSirSelectPhotoListActivity.this.alertDialog != null) {
                        NonSirSelectPhotoListActivity.this.alertDialog.dismiss();
                    }
                    if (datalist != null && datalist.size() > 0) {
                        NonSirSelectPhotoListActivity.this.noteOpen.setText("Total Records - " + datalist.size());
                        NonSirSelectPhotoListActivity.this.formlist = datalist;
                        NonSirSelectPhotoListActivity.this.verifyCitizenListAdapter = new NonSirSelectPhotoListAdapter(datalist, NonSirSelectPhotoListActivity.this);
                        NonSirSelectPhotoListActivity.this.recyclerView.setAdapter(NonSirSelectPhotoListActivity.this.verifyCitizenListAdapter);
                        for (VerifyPayload verifyPayload : NonSirSelectPhotoListActivity.this.formlist) {
                            if (!TextUtils.isEmpty(verifyPayload.getFlag()) && verifyPayload.getFlag().equalsIgnoreCase("E")) {
                                NonSirSelectPhotoListActivity.this.erollupdated++;
                                NonSirSelectPhotoListActivity.this.efOptionList.remove(NonSirSelectPhotoListActivity.this.adapterSpinner.getItem(1));
                                String str = NonSirSelectPhotoListActivity.this.getString(R.string.eroll_updated) + " -" + NonSirSelectPhotoListActivity.this.erollupdated;
                                NonSirSelectPhotoListActivity.this.efOptionList.add(1, str);
                                NonSirSelectPhotoListActivity.this.efOptionList.set(1, str);
                                NonSirSelectPhotoListActivity.this.adapterSpinner.notifyDataSetChanged();
                            } else if (!TextUtils.isEmpty(verifyPayload.getFlag()) && verifyPayload.getFlag().equalsIgnoreCase("F")) {
                                NonSirSelectPhotoListActivity.this.filledform8++;
                                NonSirSelectPhotoListActivity.this.efOptionList.remove(NonSirSelectPhotoListActivity.this.adapterSpinner.getItem(2));
                                NonSirSelectPhotoListActivity.this.efOptionList.add(2, NonSirSelectPhotoListActivity.this.getString(R.string.filled_form8) + " -" + NonSirSelectPhotoListActivity.this.filledform8);
                                NonSirSelectPhotoListActivity.this.adapterSpinner.notifyDataSetChanged();
                            } else if (!TextUtils.isEmpty(verifyPayload.getFlag()) && verifyPayload.getFlag().equalsIgnoreCase("N")) {
                                NonSirSelectPhotoListActivity.this.noactiontaken++;
                                NonSirSelectPhotoListActivity.this.efOptionList.remove(NonSirSelectPhotoListActivity.this.adapterSpinner.getItem(3));
                                NonSirSelectPhotoListActivity.this.efOptionList.add(3, NonSirSelectPhotoListActivity.this.getString(R.string.no_action_taken) + " -" + NonSirSelectPhotoListActivity.this.noactiontaken);
                                NonSirSelectPhotoListActivity.this.adapterSpinner.notifyDataSetChanged();
                            } else if (TextUtils.isEmpty(verifyPayload.getFlag())) {
                                NonSirSelectPhotoListActivity.this.notupdated++;
                                NonSirSelectPhotoListActivity.this.efOptionList.remove(NonSirSelectPhotoListActivity.this.adapterSpinner.getItem(4));
                                NonSirSelectPhotoListActivity.this.efOptionList.add(4, NonSirSelectPhotoListActivity.this.getString(R.string.not_updated) + " -" + NonSirSelectPhotoListActivity.this.notupdated);
                                NonSirSelectPhotoListActivity.this.adapterSpinner.notifyDataSetChanged();
                            }
                        }
                        NonSirSelectPhotoListActivity.this.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.NonSirSelectPhotoListActivity.3.1
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
                                for (VerifyPayload verifyPayload2 : NonSirSelectPhotoListActivity.this.formlist) {
                                    if (!TextUtils.isEmpty(String.valueOf(verifyPayload2.getPartSerialNo())) && String.valueOf(verifyPayload2.getPartSerialNo()).toLowerCase().equals(string.toLowerCase())) {
                                        if (arrayList.size() > 0) {
                                            arrayList.clear();
                                        }
                                        arrayList.add(verifyPayload2);
                                        break;
                                    } else if ((!TextUtils.isEmpty(verifyPayload2.getEpicNo()) && verifyPayload2.getEpicNo().toLowerCase().contains(string.toLowerCase())) || ((!TextUtils.isEmpty(String.valueOf(verifyPayload2.getPartSerialNo())) && String.valueOf(verifyPayload2.getPartSerialNo()).toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(verifyPayload2.getEpicName())) && String.valueOf(verifyPayload2.getEpicName()).toLowerCase().contains(string.toLowerCase())))) {
                                        arrayList.add(verifyPayload2);
                                    }
                                }
                                NonSirSelectPhotoListActivity.this.verifyCitizenListAdapter.fun(arrayList);
                            }
                        });
                        return;
                    }
                    if (NonSirSelectPhotoListActivity.this.alertDialog != null) {
                        NonSirSelectPhotoListActivity.this.alertDialog.dismiss();
                    }
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    Utils utils = NonSirSelectPhotoListActivity.this.utils;
                    ?? r5 = NonSirSelectPhotoListActivity.this;
                    utils.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
                    return;
                }
                if (NonSirSelectPhotoListActivity.this.alertDialog != null) {
                    NonSirSelectPhotoListActivity.this.alertDialog.dismiss();
                }
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = NonSirSelectPhotoListActivity.this.utils;
                ?? r6 = NonSirSelectPhotoListActivity.this;
                utils2.infoDialog(r6, r6.getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("restart", false)) {
            recreate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        List<VerifyPayload> list;
        if (position == 0) {
            if (this.verifyCitizenListAdapter != null && (list = this.formlist) != null && list.size() > 0) {
                this.verifyCitizenListAdapter.fun((ArrayList) this.formlist);
                this.recyclerView.setAdapter(this.verifyCitizenListAdapter);
            } else if (this.formlist != null) {
                NonSirSelectPhotoListAdapter nonSirSelectPhotoListAdapter = new NonSirSelectPhotoListAdapter(this.formlist, this);
                this.verifyCitizenListAdapter = nonSirSelectPhotoListAdapter;
                this.recyclerView.setAdapter(nonSirSelectPhotoListAdapter);
            }
        }
        if (position == 1) {
            ArrayList<VerifyPayload> arrayList = new ArrayList<>();
            for (VerifyPayload verifyPayload : this.formlist) {
                if (!TextUtils.isEmpty(verifyPayload.getFlag()) && verifyPayload.getFlag().equalsIgnoreCase("E")) {
                    arrayList.add(verifyPayload);
                }
            }
            NonSirSelectPhotoListAdapter nonSirSelectPhotoListAdapter2 = this.verifyCitizenListAdapter;
            if (nonSirSelectPhotoListAdapter2 != null) {
                nonSirSelectPhotoListAdapter2.fun(arrayList);
            }
        }
        if (position == 2) {
            ArrayList<VerifyPayload> arrayList2 = new ArrayList<>();
            for (VerifyPayload verifyPayload2 : this.formlist) {
                if (!TextUtils.isEmpty(verifyPayload2.getFlag()) && verifyPayload2.getFlag().equalsIgnoreCase("F")) {
                    arrayList2.add(verifyPayload2);
                }
            }
            NonSirSelectPhotoListAdapter nonSirSelectPhotoListAdapter3 = this.verifyCitizenListAdapter;
            if (nonSirSelectPhotoListAdapter3 != null) {
                nonSirSelectPhotoListAdapter3.fun(arrayList2);
            }
        }
        if (position == 3) {
            ArrayList<VerifyPayload> arrayList3 = new ArrayList<>();
            for (VerifyPayload verifyPayload3 : this.formlist) {
                if (!TextUtils.isEmpty(verifyPayload3.getFlag()) && verifyPayload3.getFlag().equalsIgnoreCase("N")) {
                    arrayList3.add(verifyPayload3);
                }
            }
            NonSirSelectPhotoListAdapter nonSirSelectPhotoListAdapter4 = this.verifyCitizenListAdapter;
            if (nonSirSelectPhotoListAdapter4 != null) {
                nonSirSelectPhotoListAdapter4.fun(arrayList3);
            }
        }
        if (position == 4) {
            ArrayList<VerifyPayload> arrayList4 = new ArrayList<>();
            for (VerifyPayload verifyPayload4 : this.formlist) {
                if (TextUtils.isEmpty(verifyPayload4.getFlag())) {
                    arrayList4.add(verifyPayload4);
                }
            }
            NonSirSelectPhotoListAdapter nonSirSelectPhotoListAdapter5 = this.verifyCitizenListAdapter;
            if (nonSirSelectPhotoListAdapter5 != null) {
                nonSirSelectPhotoListAdapter5.fun(arrayList4);
            }
        }
    }
}
