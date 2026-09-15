package in.gov.eci.bloapp.views.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityEpicDeliveryListBinding;
import in.gov.eci.bloapp.entity.FormDataVariables;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.adapter.EpicDeliverListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.EpicDeliverCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallbackEpic;
import in.gov.eci.bloapp.views.activity.newsir.model.VoterDataPayload;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class EpicDeliveryListActivity extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    String SESSION;
    private String acNo;
    private Call<JsonObject> activeCall;
    ArrayList<FormDataVariables> al;
    AlertDialog alertDialog;
    private String atkband;
    ActivityEpicDeliveryListBinding binding;
    CommomUtility commonUtilClass;
    List<VoterDataPayload> formlist;
    private String partNo;
    private String refreshToken;
    String remark;
    private String rtkband;
    UserClient service;
    private String state;
    String status;
    private String token;
    Utils utils;
    EpicDeliverListAdapter verifyCitizenListAdapter;
    String alertText = "";
    CommomUtility commomUtility = new CommomUtility();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityEpicDeliveryListBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.service = (UserClient) ApiClient.getClient1(getApplicationContext()).create(UserClient.class);
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.al = new ArrayList<>();
        this.alertText = getString(R.string.alertMsg);
        this.utils = new Utils();
        initClickListener();
        this.binding.noteOpen.setVisibility(8);
        this.binding.spinner.setVisibility(8);
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
        getEpicDeliveryList();
        this.alertDialog.show();
        this.commonUtilClass = new CommomUtility();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getEpicDeliveryList() {
        this.commomUtility.getEpicDeliverStatus(this, this.token, this.atkband, this.rtkband, this.state, this.acNo, this.partNo, "", new EpicDeliverCallback() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity] */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity] */
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
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.EpicDeliverCallback
            public void onCallBack(int code, List<VoterDataPayload> datalist, String message) {
                if (code == 200) {
                    EpicDeliveryListActivity.this.alertDialog.dismiss();
                    if (datalist != null && datalist.size() > 0) {
                        if (EpicDeliveryListActivity.this.formlist != null && EpicDeliveryListActivity.this.formlist.size() > 0) {
                            EpicDeliveryListActivity.this.formlist.clear();
                        }
                        EpicDeliveryListActivity.this.formlist = datalist;
                        EpicDeliveryListActivity.this.verifyCitizenListAdapter = new EpicDeliverListAdapter(EpicDeliveryListActivity.this.formlist, EpicDeliveryListActivity.this, new ItemClickCallbackEpic() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity.1.1
                            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallbackEpic
                            public void onClicked(VoterDataPayload formverificationPayload, String type) {
                                if (type.equalsIgnoreCase("return")) {
                                    EpicDeliveryListActivity.this.status = "RETURN_TO_ERO";
                                    EpicDeliveryListActivity.this.showDialog2("Alert", EpicDeliveryListActivity.this.getString(R.string.returnEROMessage), formverificationPayload, "return");
                                } else if (type.equalsIgnoreCase("")) {
                                    EpicDeliveryListActivity.this.status = "DELIVERED";
                                    EpicDeliveryListActivity.this.remark = "delivered";
                                    EpicDeliveryListActivity.this.showDialog2("Alert", "Are you sure you want to submit", formverificationPayload, "");
                                }
                            }
                        });
                        EpicDeliveryListActivity.this.binding.recyclerView.setAdapter(EpicDeliveryListActivity.this.verifyCitizenListAdapter);
                        return;
                    }
                    EpicDeliveryListActivity.this.alertDialog.dismiss();
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    Utils utils = EpicDeliveryListActivity.this.utils;
                    ?? r4 = EpicDeliveryListActivity.this;
                    utils.infoDialog(r4, r4.getResources().getString(R.string.alertMsg), message);
                    return;
                }
                EpicDeliveryListActivity.this.alertDialog.dismiss();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Utils utils2 = EpicDeliveryListActivity.this.utils;
                ?? r5 = EpicDeliveryListActivity.this;
                utils2.infoDialog(r5, r5.getResources().getString(R.string.alertMsg), message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message, String api) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$1(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message, final VoterDataPayload verifyPayload, final String button) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$2(button, verifyPayload, dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.cancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$3(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$2(String str, VoterDataPayload voterDataPayload, DialogInterface dialogInterface, int i) {
        if (str.equals("")) {
            Submit(voterDataPayload);
        } else if (str.equals("return")) {
            assignToEroDialog(voterDataPayload);
        }
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$3(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog3(String alertText, String message, String module) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$4(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog3$4(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        getEpicDeliveryList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void assignToEroDialog(final VoterDataPayload verifyPayload) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.epic_assign_to_ero);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        final TextView textView = (TextView) dialog.findViewById(R.id.reasonText);
        TextView textView2 = (TextView) dialog.findViewById(R.id.epic_submit);
        TextView textView3 = (TextView) dialog.findViewById(R.id.cancel_epic);
        final Spinner spinner = (Spinner) dialog.findViewById(R.id.epic_reason);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.iv_cancel);
        final TextView textView4 = (TextView) dialog.findViewById(R.id.shifted_undertaking);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, R.array.epic_reason_options, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String string = parent.getItemAtPosition(position).toString();
                if (string.equals("Others")) {
                    textView.setVisibility(0);
                    textView4.setVisibility(8);
                } else if (string.equals("Shifted")) {
                    EpicDeliveryListActivity.this.remark = string;
                    textView4.setVisibility(0);
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(8);
                    textView.setText("");
                    EpicDeliveryListActivity.this.remark = string;
                    textView4.setVisibility(8);
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                spinner.setSelection(0);
                textView.setText("");
                dialog.dismiss();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (spinner.getSelectedItemPosition() == 0) {
                    EpicDeliveryListActivity.this.showDialog1("Alert", "Please select reason", "");
                    return;
                }
                if (spinner.getSelectedItem().toString().equals("Others")) {
                    if (textView.getText().toString().isEmpty()) {
                        EpicDeliveryListActivity.this.showDialog1("Alert", "Please enter reason", "");
                        return;
                    }
                    EpicDeliveryListActivity.this.remark = textView.getText().toString();
                    EpicDeliveryListActivity.this.Submit(verifyPayload);
                    dialog.dismiss();
                    return;
                }
                EpicDeliveryListActivity.this.Submit(verifyPayload);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void Submit(VoterDataPayload formList) {
        this.alertDialog.show();
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(formList.getPartNumber()));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.valueOf(formList.getReferenceNumber()));
        map2.put("acNo", Integer.valueOf(formList.getAcNo()));
        map2.put("partNo", arrayList);
        map2.put("stateCd", this.state);
        map2.put("formRefNo", arrayList2);
        map2.put("remarks", this.remark);
        map2.put("status", this.status);
        Log.d("undelivered epic body", map2.toString());
        Call<JsonObject> callActionForReturnEpic = this.service.actionForReturnEpic(map, map2);
        this.activeCall = callActionForReturnEpic;
        callActionForReturnEpic.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.EpicDeliveryListActivity.6
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    if (EpicDeliveryListActivity.this.alertDialog != null) {
                        EpicDeliveryListActivity.this.alertDialog.dismiss();
                    }
                    if (EpicDeliveryListActivity.this.status.equals("RETURN_TO_ERO")) {
                        EpicDeliveryListActivity.this.showDialog3("", "Returned to ERO successfully", "");
                        return;
                    } else {
                        if (EpicDeliveryListActivity.this.status.equals("DELIVERED")) {
                            EpicDeliveryListActivity.this.showDialog3("", "Marked Delivered successfully", "");
                            return;
                        }
                        return;
                    }
                }
                try {
                    if (EpicDeliveryListActivity.this.alertDialog != null) {
                        EpicDeliveryListActivity.this.alertDialog.dismiss();
                    }
                    EpicDeliveryListActivity.this.showDialog1("Alert", new JSONObject(response.errorBody().string()).optString("message"), "API");
                } catch (IOException | JSONException unused) {
                    if (EpicDeliveryListActivity.this.alertDialog != null) {
                        EpicDeliveryListActivity.this.alertDialog.dismiss();
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (EpicDeliveryListActivity.this.alertDialog != null) {
                    EpicDeliveryListActivity.this.alertDialog.dismiss();
                }
                Logger.e("epicDeliveryFailure", t.getMessage());
            }
        });
    }
}
