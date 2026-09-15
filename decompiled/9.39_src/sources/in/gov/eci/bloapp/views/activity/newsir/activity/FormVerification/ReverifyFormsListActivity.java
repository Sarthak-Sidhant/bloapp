package in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification;

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
import in.gov.eci.bloapp.entity.FormDataVariables;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.adapter.ReverifyListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallbackNew;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ReverifyFormsListActivity extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
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
    List<String> efOptionList;
    List<VerifyPayload> formlist;
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
    ReverifyListAdapter verifyCitizenListAdapter;
    String alertText = "";
    String TAG = "FormDataNewTAG";
    CommomUtility commomUtility = new CommomUtility();
    int selfCount = 0;
    int progenyCount = 0;
    int neitherCount = 0;

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
        this.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View viewInflate2 = LayoutInflater.from(ReverifyFormsListActivity.this).inflate(R.layout.category_count_dialog_layout, (ViewGroup) null);
                TextView textView = (TextView) viewInflate2.findViewById(R.id.txtSelfCount);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.txtProgeny);
                TextView textView3 = (TextView) viewInflate2.findViewById(R.id.txtNeither);
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.noteTotal);
                textView.setText(ReverifyFormsListActivity.this.getString(R.string.self_text) + " - " + ReverifyFormsListActivity.this.selfCount);
                textView2.setText(ReverifyFormsListActivity.this.getString(R.string.progeny_text) + " - " + ReverifyFormsListActivity.this.progenyCount);
                textView3.setText(ReverifyFormsListActivity.this.getString(R.string.neither_text) + " -  " + ReverifyFormsListActivity.this.neitherCount);
                textView4.setText(ReverifyFormsListActivity.this.getString(R.string.total_document_upload_count) + " " + (ReverifyFormsListActivity.this.selfCount + ReverifyFormsListActivity.this.progenyCount + ReverifyFormsListActivity.this.neitherCount));
                new AlertDialog.Builder(ReverifyFormsListActivity.this).setTitle(ReverifyFormsListActivity.this.getString(R.string.category_count)).setView(viewInflate2).setPositiveButton(ReverifyFormsListActivity.this.getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });
        this.textView5.setText("v" + this.commomUtility.appversion);
        this.textView3.setText(getResources().getString(R.string.form_type_reverify_ef));
        this.listArray = getResources().getStringArray(R.array.category_options);
        this.efOptionList = new ArrayList(Arrays.asList(this.listArray));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, android.R.layout.simple_spinner_item, this.efOptionList);
        this.adapterSpinner = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter((SpinnerAdapter) this.adapterSpinner);
        this.spinner.setSelection(0);
        this.spinner.setOnItemSelectedListener(this);
        if (this.selfCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(1));
            String str = getString(R.string.self_text_dash) + " " + this.selfCount;
            this.efOptionList.add(1, str);
            this.efOptionList.set(1, str);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.progenyCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(2));
            this.efOptionList.add(2, getString(R.string.progeny_text_dash) + " " + this.progenyCount);
            this.adapterSpinner.notifyDataSetChanged();
        }
        if (this.neitherCount == 0) {
            this.efOptionList.remove(this.adapterSpinner.getItem(3));
            String str2 = getString(R.string.neither_text_dash) + " " + this.neitherCount;
            this.efOptionList.add(3, str2);
            this.efOptionList.set(3, str2);
            this.adapterSpinner.notifyDataSetChanged();
        }
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

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity$$ExternalSyntheticLambda0
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
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
        this.scanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ReverifyFormsListActivity.this.cameraPermission();
            }
        });
        this.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ReverifyFormsListActivity.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getVerifyCitizenFormList() {
        this.commomUtility.getSpecialRevisionFormsPanIndia(this, this.token, this.atkband, this.rtkband, this.state, this.acNo, this.partNo, "A", new VerifyCitizenListCallbackNew() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity.4
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity] */
            /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity] */
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
                    ReverifyFormsListActivity.this.alertDialog.dismiss();
                    if (datalist != null && datalist.size() > 0) {
                        ReverifyFormsListActivity.this.formlist = datalist;
                        ReverifyFormsListActivity.this.verifyCitizenListAdapter = new ReverifyListAdapter(datalist, ReverifyFormsListActivity.this);
                        ReverifyFormsListActivity.this.recyclerView.setAdapter(ReverifyFormsListActivity.this.verifyCitizenListAdapter);
                        for (VerifyPayload verifyPayload : ReverifyFormsListActivity.this.formlist) {
                            if (!TextUtils.isEmpty(verifyPayload.getCategoryType()) && verifyPayload.getCategoryType().equalsIgnoreCase("self")) {
                                ReverifyFormsListActivity.this.selfCount++;
                                ReverifyFormsListActivity.this.efOptionList.remove(ReverifyFormsListActivity.this.adapterSpinner.getItem(1));
                                String str = ReverifyFormsListActivity.this.getString(R.string.self_text_dash) + " " + ReverifyFormsListActivity.this.selfCount;
                                ReverifyFormsListActivity.this.efOptionList.add(1, str);
                                ReverifyFormsListActivity.this.efOptionList.set(1, str);
                                ReverifyFormsListActivity.this.adapterSpinner.notifyDataSetChanged();
                            } else if (!TextUtils.isEmpty(verifyPayload.getCategoryType()) && verifyPayload.getCategoryType().equalsIgnoreCase("progeny")) {
                                ReverifyFormsListActivity.this.progenyCount++;
                                Log.d(ReverifyFormsListActivity.this.TAG, String.valueOf(ReverifyFormsListActivity.this.progenyCount));
                                ReverifyFormsListActivity.this.efOptionList.remove(ReverifyFormsListActivity.this.adapterSpinner.getItem(2));
                                ReverifyFormsListActivity.this.efOptionList.add(2, ReverifyFormsListActivity.this.getString(R.string.progeny_text_dash) + " " + ReverifyFormsListActivity.this.progenyCount);
                                ReverifyFormsListActivity.this.adapterSpinner.notifyDataSetChanged();
                            } else if (!TextUtils.isEmpty(verifyPayload.getCategoryType()) && verifyPayload.getCategoryType().equalsIgnoreCase("na")) {
                                ReverifyFormsListActivity.this.neitherCount++;
                                ReverifyFormsListActivity.this.efOptionList.remove(ReverifyFormsListActivity.this.adapterSpinner.getItem(3));
                                String str2 = ReverifyFormsListActivity.this.getString(R.string.neither_text_dash) + " " + ReverifyFormsListActivity.this.neitherCount;
                                ReverifyFormsListActivity.this.efOptionList.add(3, str2);
                                ReverifyFormsListActivity.this.efOptionList.set(3, str2);
                                ReverifyFormsListActivity.this.adapterSpinner.notifyDataSetChanged();
                            }
                        }
                        ReverifyFormsListActivity.this.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity.4.1
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
                                for (VerifyPayload verifyPayload2 : ReverifyFormsListActivity.this.formlist) {
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
                                ReverifyFormsListActivity.this.verifyCitizenListAdapter.fun(arrayList);
                            }
                        });
                        return;
                    }
                    ReverifyFormsListActivity.this.alertDialog.dismiss();
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    Utils utils = ReverifyFormsListActivity.this.utils;
                    ?? r5 = ReverifyFormsListActivity.this;
                    utils.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
                    return;
                }
                ReverifyFormsListActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = ReverifyFormsListActivity.this.utils;
                ?? r6 = ReverifyFormsListActivity.this;
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
    private void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity$$ExternalSyntheticLambda3
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

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity$$ExternalSyntheticLambda2
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
        List<VerifyPayload> list;
        if (position == 0) {
            if (this.verifyCitizenListAdapter != null && (list = this.formlist) != null && list.size() > 0) {
                this.verifyCitizenListAdapter.fun((ArrayList) this.formlist);
                this.recyclerView.setAdapter(this.verifyCitizenListAdapter);
            } else if (this.formlist != null) {
                ReverifyListAdapter reverifyListAdapter = new ReverifyListAdapter(this.formlist, this);
                this.verifyCitizenListAdapter = reverifyListAdapter;
                this.recyclerView.setAdapter(reverifyListAdapter);
            }
        }
        if (position == 1) {
            ArrayList<VerifyPayload> arrayList = new ArrayList<>();
            for (VerifyPayload verifyPayload : this.formlist) {
                if (!TextUtils.isEmpty(verifyPayload.getCategoryType()) && verifyPayload.getCategoryType().equalsIgnoreCase("self")) {
                    arrayList.add(verifyPayload);
                }
            }
            ReverifyListAdapter reverifyListAdapter2 = this.verifyCitizenListAdapter;
            if (reverifyListAdapter2 != null) {
                reverifyListAdapter2.fun(arrayList);
            }
        }
        if (position == 2) {
            ArrayList<VerifyPayload> arrayList2 = new ArrayList<>();
            for (VerifyPayload verifyPayload2 : this.formlist) {
                if (!TextUtils.isEmpty(verifyPayload2.getCategoryType()) && verifyPayload2.getCategoryType().equalsIgnoreCase("progeny")) {
                    arrayList2.add(verifyPayload2);
                }
            }
            ReverifyListAdapter reverifyListAdapter3 = this.verifyCitizenListAdapter;
            if (reverifyListAdapter3 != null) {
                reverifyListAdapter3.fun(arrayList2);
            }
        }
        if (position == 3) {
            ArrayList<VerifyPayload> arrayList3 = new ArrayList<>();
            for (VerifyPayload verifyPayload3 : this.formlist) {
                if (!TextUtils.isEmpty(verifyPayload3.getCategoryType()) && verifyPayload3.getCategoryType().equalsIgnoreCase("NA")) {
                    arrayList3.add(verifyPayload3);
                }
            }
            ReverifyListAdapter reverifyListAdapter4 = this.verifyCitizenListAdapter;
            if (reverifyListAdapter4 != null) {
                reverifyListAdapter4.fun(arrayList3);
            }
        }
    }

    void getCategoryCount() {
        for (VerifyPayload verifyPayload : this.formlist) {
            if (!TextUtils.isEmpty(verifyPayload.getCategoryType()) && verifyPayload.getCategoryType().equalsIgnoreCase("self")) {
                this.selfCount++;
            } else if (!TextUtils.isEmpty(verifyPayload.getCategoryType()) && verifyPayload.getCategoryType().equalsIgnoreCase("progeny")) {
                this.progenyCount++;
            } else if (!TextUtils.isEmpty(verifyPayload.getCategoryType()) && verifyPayload.getCategoryType().equalsIgnoreCase("na")) {
                this.neitherCount++;
            }
        }
    }
}
