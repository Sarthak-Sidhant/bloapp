package in.gov.eci.bloapp.views.activity;

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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.button.MaterialButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.ActivityFormatCBinding;
import in.gov.eci.bloapp.entity.FormDataVariables;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.callback.FormatCListCallback;
import in.gov.eci.bloapp.views.activity.newsir.adapter.FormatCListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.model.formatc.Content;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FomatCListActivity extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private static String SESSION = "";
    private String acNo;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<FormDataVariables> al;
    AlertDialog alertDialog;
    private String atkband;
    String barcode;
    ActivityFormatCBinding binding;
    List<String> efOptionList;
    String[] listArray;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    private String state;
    private String token;
    Utils utils;
    FormatCListAdapter verifyCitizenListAdapter;
    String alertText = "";
    String TAG = "FormDataNewTAG";
    CommomUtility commomUtility = new CommomUtility();
    int selfCount = 0;
    int progenyCount = 0;
    int neitherCount = 0;
    private ArrayList<Content> dataList = new ArrayList<>();
    String selectedTab = "fvrpending";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityFormatCBinding activityFormatCBindingInflate = ActivityFormatCBinding.inflate(getLayoutInflater());
        this.binding = activityFormatCBindingInflate;
        setContentView(activityFormatCBindingInflate.getRoot());
        SESSION = getString(R.string.sessionMsg);
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.textView3.setText(getResources().getString(R.string.format_c));
        this.binding.textView3.setTextSize(15.0f);
        selecttab(this.binding.fvrpending, this.binding.submitform);
        handleSearchTabClcicks();
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
            this.barcode = this.barcode.replace(" ", "");
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
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCListActivity$$ExternalSyntheticLambda3
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
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCListActivity$$ExternalSyntheticLambda4
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
    public void getListOfNaCategory(int statusid) {
        this.alertDialog.show();
        this.commomUtility.getFVRPending(this, this.token, this.atkband, this.rtkband, this.state, this.acNo, this.partNo, statusid, new FormatCListCallback() { // from class: in.gov.eci.bloapp.views.activity.FomatCListActivity.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v7, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatCListActivity] */
            /* JADX WARN: Type inference failed for: r6v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatCListActivity] */
            /* JADX WARN: Type inference failed for: r6v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.FomatCListActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.callback.FormatCListCallback
            public void onCallBack(int code, List<Content> formlist, String message) {
                if (code == 200) {
                    FomatCListActivity.this.dataList.clear();
                    FomatCListActivity.this.alertDialog.dismiss();
                    if (formlist != null && formlist.size() > 0) {
                        FomatCListActivity.this.dataList.addAll(formlist);
                        FomatCListActivity fomatCListActivity = FomatCListActivity.this;
                        ArrayList arrayList = FomatCListActivity.this.dataList;
                        ?? r0 = FomatCListActivity.this;
                        fomatCListActivity.verifyCitizenListAdapter = new FormatCListAdapter(arrayList, r0, r0.selectedTab);
                        FomatCListActivity.this.binding.recyclerView.setAdapter(FomatCListActivity.this.verifyCitizenListAdapter);
                        FomatCListActivity.this.binding.search.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.activity.FomatCListActivity.1.1
                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                String string = editable.toString();
                                ArrayList<Content> arrayList2 = new ArrayList<>();
                                for (Content content : FomatCListActivity.this.dataList) {
                                    if ((!TextUtils.isEmpty(content.getFormRefNo()) && content.getFormRefNo().toLowerCase().contains(string.toLowerCase())) || ((!TextUtils.isEmpty(String.valueOf(content.getCorrectedName())) && String.valueOf(content.getCorrectedName()).toLowerCase().contains(string.toLowerCase())) || (!TextUtils.isEmpty(String.valueOf(content.getFormType())) && String.valueOf(content.getFormType()).toLowerCase().contains(string.toLowerCase())))) {
                                        arrayList2.add(content);
                                    }
                                }
                                FomatCListActivity.this.verifyCitizenListAdapter.fun(arrayList2);
                            }
                        });
                        return;
                    }
                    FomatCListActivity.this.alertDialog.dismiss();
                    FomatCListActivity.this.verifyCitizenListAdapter = new FormatCListAdapter(FomatCListActivity.this.dataList, FomatCListActivity.this, "");
                    FomatCListActivity.this.binding.recyclerView.setAdapter(FomatCListActivity.this.verifyCitizenListAdapter);
                    FomatCListActivity.this.binding.noteOpen.setText("Total Records - 0");
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    Utils utils = FomatCListActivity.this.utils;
                    ?? r6 = FomatCListActivity.this;
                    utils.infoDialog(r6, r6.getResources().getString(R.string.alertMsg), message);
                    return;
                }
                FomatCListActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = FomatCListActivity.this.utils;
                ?? r7 = FomatCListActivity.this;
                utils2.infoDialog(r7, r7.getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("restart", false)) {
            recreate();
            return;
        }
        if (this.selectedTab.equalsIgnoreCase("submitform")) {
            this.binding.search.setText("");
            selecttab(this.binding.submitform, this.binding.fvrpending);
            getListOfNaCategory(4);
            this.selectedTab = "submitform";
            return;
        }
        this.binding.search.setText("");
        selecttab(this.binding.fvrpending, this.binding.submitform);
        getListOfNaCategory(1);
        this.selectedTab = "fvrpending";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCListActivity$$ExternalSyntheticLambda2
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
    private void selecttab(MaterialButton selected, MaterialButton other) {
        selected.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.new_tab_color));
        selected.setTextColor(ContextCompat.getColor(this, R.color.blo_white));
        other.setBackgroundTintList(ContextCompat.getColorStateList(this, android.R.color.transparent));
        other.setTextColor(ContextCompat.getColor(this, R.color.blo_black));
        other.setStrokeWidth(2);
        other.setStrokeColor(ContextCompat.getColorStateList(this, R.color.blo_light_grey));
    }

    private void handleSearchTabClcicks() {
        this.binding.fvrpending.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCListActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$4(view);
            }
        });
        this.binding.submitform.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FomatCListActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleSearchTabClcicks$6(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$4(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.FomatCListActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleSearchTabClcicks$3();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$3() {
        this.binding.search.setText("");
        selecttab(this.binding.fvrpending, this.binding.submitform);
        getListOfNaCategory(1);
        this.selectedTab = "fvrpending";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$6(View view) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.FomatCListActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleSearchTabClcicks$5();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSearchTabClcicks$5() {
        this.binding.search.setText("");
        selecttab(this.binding.submitform, this.binding.fvrpending);
        getListOfNaCategory(4);
        this.selectedTab = "submitform";
    }

    protected void onResume() {
        super.onResume();
        if (this.selectedTab.equalsIgnoreCase("submitform")) {
            this.binding.search.setText("");
            getListOfNaCategory(4);
            this.selectedTab = "submitform";
        } else {
            getListOfNaCategory(1);
            this.selectedTab = "fvrpending";
        }
    }
}
