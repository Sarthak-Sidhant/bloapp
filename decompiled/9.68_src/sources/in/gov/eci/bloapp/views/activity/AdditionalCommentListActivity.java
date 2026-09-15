package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.entity.FormDataVariables;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.adapter.AdditionalCommentListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallbackNew;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AdditionalCommentListActivity extends SuperBaseActivity implements AdapterView.OnItemSelectedListener {
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
    LinearLayout totalLL;
    TextView totalTv;
    Utils utils;
    AdditionalCommentListAdapter verifyCitizenListAdapter;
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
        setContentView(R.layout.activity_additional_comment);
        SESSION = getString(R.string.sessionMsg);
        this.recyclerView = findViewById(R.id.recyclerViewAdditional);
        this.back_btn_iv = (ImageView) findViewById(R.id.back_btn_iv);
        this.textView5 = (TextView) findViewById(R.id.textView5);
        this.textView3 = (TextView) findViewById(R.id.textView3);
        this.search = (EditText) findViewById(R.id.searchAdditional);
        this.totalLL = (LinearLayout) findViewById(R.id.totalLL);
        this.totalTv = (TextView) findViewById(R.id.totalTv);
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
        this.textView5.setText("v" + this.commomUtility.appversion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.AdditionalCommentListActivity$$ExternalSyntheticLambda1
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
        this.back_btn_iv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.AdditionalCommentListActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getVerifyCitizenFormList() {
        this.commomUtility.getSpecialRevisionFormsPanIndia(this, this.token, this.atkband, this.rtkband, this.state, this.acNo, this.partNo, "A", new VerifyCitizenListCallbackNew() { // from class: in.gov.eci.bloapp.views.activity.AdditionalCommentListActivity.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.AdditionalCommentListActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.AdditionalCommentListActivity] */
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
                    AdditionalCommentListActivity.this.alertDialog.dismiss();
                    if (datalist != null && datalist.size() > 0) {
                        AdditionalCommentListActivity.this.formlist = datalist;
                        AdditionalCommentListActivity.this.verifyCitizenListAdapter = new AdditionalCommentListAdapter(datalist, AdditionalCommentListActivity.this);
                        AdditionalCommentListActivity.this.recyclerView.setAdapter(AdditionalCommentListActivity.this.verifyCitizenListAdapter);
                        AdditionalCommentListActivity.this.getCategoryCount();
                        AdditionalCommentListActivity.this.totalTv.setText(String.valueOf(AdditionalCommentListActivity.this.formlist.size()));
                        AdditionalCommentListActivity.this.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.AdditionalCommentListActivity.1.1
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
                                for (VerifyPayload verifyPayload : AdditionalCommentListActivity.this.formlist) {
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
                                AdditionalCommentListActivity.this.verifyCitizenListAdapter.fun(arrayList);
                            }
                        });
                        return;
                    }
                    AdditionalCommentListActivity.this.alertDialog.dismiss();
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    Utils utils = AdditionalCommentListActivity.this.utils;
                    ?? r4 = AdditionalCommentListActivity.this;
                    utils.infoDialog(r4, r4.getResources().getString(R.string.alertMsg), message);
                    return;
                }
                AdditionalCommentListActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = AdditionalCommentListActivity.this.utils;
                ?? r5 = AdditionalCommentListActivity.this;
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

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.AdditionalCommentListActivity$$ExternalSyntheticLambda3
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.AdditionalCommentListActivity$$ExternalSyntheticLambda0
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
                AdditionalCommentListAdapter additionalCommentListAdapter = new AdditionalCommentListAdapter(this.formlist, this);
                this.verifyCitizenListAdapter = additionalCommentListAdapter;
                this.recyclerView.setAdapter(additionalCommentListAdapter);
            }
        }
        if (position == 1) {
            ArrayList<VerifyPayload> arrayList = new ArrayList<>();
            for (VerifyPayload verifyPayload : this.formlist) {
                if (!TextUtils.isEmpty(verifyPayload.getCategoryType()) && verifyPayload.getCategoryType().equalsIgnoreCase("self")) {
                    arrayList.add(verifyPayload);
                }
            }
            AdditionalCommentListAdapter additionalCommentListAdapter2 = this.verifyCitizenListAdapter;
            if (additionalCommentListAdapter2 != null) {
                additionalCommentListAdapter2.fun(arrayList);
            }
        }
        if (position == 2) {
            ArrayList<VerifyPayload> arrayList2 = new ArrayList<>();
            for (VerifyPayload verifyPayload2 : this.formlist) {
                if (!TextUtils.isEmpty(verifyPayload2.getCategoryType()) && verifyPayload2.getCategoryType().equalsIgnoreCase("progeny")) {
                    arrayList2.add(verifyPayload2);
                }
            }
            AdditionalCommentListAdapter additionalCommentListAdapter3 = this.verifyCitizenListAdapter;
            if (additionalCommentListAdapter3 != null) {
                additionalCommentListAdapter3.fun(arrayList2);
            }
        }
        if (position == 3) {
            ArrayList<VerifyPayload> arrayList3 = new ArrayList<>();
            for (VerifyPayload verifyPayload3 : this.formlist) {
                if (!TextUtils.isEmpty(verifyPayload3.getCategoryType()) && verifyPayload3.getCategoryType().equalsIgnoreCase("NA")) {
                    arrayList3.add(verifyPayload3);
                }
            }
            AdditionalCommentListAdapter additionalCommentListAdapter4 = this.verifyCitizenListAdapter;
            if (additionalCommentListAdapter4 != null) {
                additionalCommentListAdapter4.fun(arrayList3);
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
