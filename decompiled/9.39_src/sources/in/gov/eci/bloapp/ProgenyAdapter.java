package in.gov.eci.bloapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.adapter.AnomalyListValueAdapter;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.MappingAnomalyDetailsDialogBinding;
import in.gov.eci.bloapp.databinding.MappingAnomalyDetailsValueDialogBinding;
import in.gov.eci.bloapp.model.SIR.SelfProgenyModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingAnomalyDetailsPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ProgenyAdapter extends RecyclerView.Adapter<ViewHolder> {
    String acNo;
    private String atkband;
    MappingAnomalyDetailsDialogBinding binding;
    MappingAnomalyDetailsValueDialogBinding bindingvalue;
    MultipleString callback;
    private Context context;
    ArrayList<SelfProgenyModel> datalist;
    Dialog dialog;
    private boolean isDeleted;
    String partNo;
    private String rtkband;
    ArrayList<SelfProgenyModel> searchList;
    UserClient service;
    private String state;
    private String token;
    CommomUtility commomUtility = new CommomUtility();
    ArrayList<MappingAnomalyDetailsPayload> anomalydetailsList = new ArrayList<>();
    ArrayList<String> anomalydetailsListvalue = new ArrayList<>();
    Gson gson = new GsonBuilder().setLenient().create();

    public ProgenyAdapter(ArrayList<SelfProgenyModel> datalist, Context context, String token, String state, String atkband, String rtkband, MultipleString callback) {
        this.datalist = datalist;
        this.context = context;
        this.token = token;
        this.state = state;
        this.atkband = atkband;
        this.rtkband = rtkband;
        this.service = (UserClient) ApiClient.getClient(context).create(UserClient.class);
        this.callback = callback;
        this.acNo = SharedPref.getInstance(context).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(context).getPartNumber();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        TextView deleteBtn;
        LinearLayout electorMAppingLL;
        LinearLayout lv_remark;
        TextView serialText;
        TextView tv_remark;
        TextView txt_age;
        TextView txt_self_elector;
        TextView txt_view_anomaly;

        public ViewHolder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_elector_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_elector_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_elector_sir);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.txtDeleteElector);
            this.txt_self_elector = (TextView) itemView.findViewById(R.id.txt_self_elector);
            this.electorMAppingLL = (LinearLayout) itemView.findViewById(R.id.electorMapingLL);
            this.txt_age = (TextView) itemView.findViewById(R.id.age_elector_sir);
            this.txt_view_anomaly = (TextView) itemView.findViewById(R.id.txt_view_anomaly);
            this.tv_remark = (TextView) itemView.findViewById(R.id.tv_remark);
            this.lv_remark = (LinearLayout) itemView.findViewById(R.id.lv_remark);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.self_progney_list_item, parent, false));
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        final SelfProgenyModel selfProgenyModel = this.datalist.get(i);
        viewHolder.EpicText.setText(selfProgenyModel.getEpicNo());
        viewHolder.serialText.setText(String.valueOf(selfProgenyModel.getPartSerialNo()));
        viewHolder.NameText.setText(selfProgenyModel.getElectorName());
        viewHolder.txt_age.setText(String.valueOf(selfProgenyModel.getAge()));
        if (!TextUtils.isEmpty(selfProgenyModel.getProgenyEpicNo()) && !TextUtils.isEmpty(selfProgenyModel.getCurrentEpic())) {
            if (!selfProgenyModel.getProgenyEpicNo().equalsIgnoreCase(selfProgenyModel.getCurrentEpic())) {
                viewHolder.deleteBtn.setVisibility(0);
            } else {
                viewHolder.deleteBtn.setVisibility(8);
            }
            viewHolder.txt_self_elector.setVisibility(8);
            viewHolder.electorMAppingLL.setBackground(this.context.getDrawable(R.color.color_mapping));
            if (selfProgenyModel.getDiscrepancyFlag().equalsIgnoreCase("Y")) {
                viewHolder.txt_view_anomaly.setVisibility(0);
                if (!TextUtils.isEmpty(selfProgenyModel.getRemark())) {
                    viewHolder.lv_remark.setVisibility(0);
                    viewHolder.tv_remark.setText(selfProgenyModel.getRemark());
                } else {
                    viewHolder.lv_remark.setVisibility(8);
                }
            } else {
                viewHolder.txt_view_anomaly.setVisibility(8);
                viewHolder.lv_remark.setVisibility(8);
            }
        } else if (!TextUtils.isEmpty(selfProgenyModel.getProgenyEpicNo()) && TextUtils.isEmpty(selfProgenyModel.getCurrentEpic())) {
            viewHolder.deleteBtn.setVisibility(0);
            viewHolder.txt_self_elector.setVisibility(8);
            viewHolder.electorMAppingLL.setBackground(this.context.getDrawable(R.color.color_mapping));
            if (selfProgenyModel.getDiscrepancyFlag().equalsIgnoreCase("Y")) {
                viewHolder.txt_view_anomaly.setVisibility(0);
                if (!TextUtils.isEmpty(selfProgenyModel.getRemark())) {
                    viewHolder.lv_remark.setVisibility(0);
                    viewHolder.tv_remark.setText(selfProgenyModel.getRemark());
                } else {
                    viewHolder.lv_remark.setVisibility(8);
                }
            } else {
                viewHolder.txt_view_anomaly.setVisibility(8);
                viewHolder.lv_remark.setVisibility(8);
            }
        } else {
            viewHolder.deleteBtn.setVisibility(8);
            viewHolder.txt_self_elector.setVisibility(0);
            viewHolder.electorMAppingLL.setBackground(this.context.getDrawable(R.color.cardview_light_background));
        }
        viewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                selfProgenyModel.getElectorName();
                ProgenyAdapter progenyAdapter = ProgenyAdapter.this;
                progenyAdapter.showAlertDialog("", progenyAdapter.context.getString(R.string.untag_text), selfProgenyModel.getId(), selfProgenyModel.getProgenyEpicNo(), i, selfProgenyModel);
            }
        });
        viewHolder.txt_self_elector.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(ProgenyAdapter.this.context, (Class<?>) ElectorMapSelfDetails.class);
                intent.putExtra("epic", selfProgenyModel.getEpicNo());
                intent.putExtra("name", selfProgenyModel.getElectorName());
                intent.putExtra("relativeName", selfProgenyModel.getRelativeName());
                intent.putExtra("psl", String.valueOf(selfProgenyModel.getPartSerialNo()));
                intent.putExtra("id", String.valueOf(selfProgenyModel.getId()));
                intent.putExtra("ac", String.valueOf(selfProgenyModel.getAc()));
                intent.putExtra("part", String.valueOf(selfProgenyModel.getPart()));
                ProgenyAdapter.this.context.startActivity(intent);
            }
        });
        viewHolder.txt_view_anomaly.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ProgenyAdapter.this.getAnomalyDetails(selfProgenyModel, viewHolder.getAdapterPosition());
            }
        });
    }

    private void showDialogDeleteProgny(int id, String progenyEpic, final int pos, SelfProgenyModel selfprogeymodel) {
        Call<JsonObject> callDeleteSelfProgeny;
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("ccode", Integer.valueOf(id));
        map2.put("progenyEpicNo", progenyEpic);
        String progenyEpicNo = selfprogeymodel.getProgenyEpicNo();
        String currentEpic = selfprogeymodel.getCurrentEpic();
        if (!TextUtils.isEmpty(progenyEpicNo) && !TextUtils.isEmpty(currentEpic) && !progenyEpicNo.equalsIgnoreCase(currentEpic)) {
            map2.put("currentState", this.datalist.get(pos).getCurrentstate());
            callDeleteSelfProgeny = this.service.deleteFromProgeny(map, map2);
        } else {
            callDeleteSelfProgeny = this.service.deleteSelfProgeny(map, map2);
        }
        callDeleteSelfProgeny.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.ProgenyAdapter.4
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ProgenyAdapter.this.callback.onCallBack("", "");
                    Toast.makeText(ProgenyAdapter.this.context, String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                    ProgenyAdapter.this.datalist.get(pos).setProgenyEpicNo(null);
                    return;
                }
                try {
                    if (response.errorBody() != null) {
                        Toast.makeText(ProgenyAdapter.this.context, new JSONObject(response.errorBody().string()).optString("message"), 1).show();
                    }
                } catch (Exception e) {
                    Logger.d("Elector Mapping Self adapter", e.toString());
                }
            }
        });
    }

    public int getItemCount() {
        return this.datalist.size();
    }

    public void fun(ArrayList<SelfProgenyModel> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertDialog(String alertText, String message, final int id, final String epic, final int pos, final SelfProgenyModel selfprogeymodel) {
        new AlertDialog.Builder(this.context).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(this.context.getResources().getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyAdapter$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showAlertDialog$0(id, epic, pos, selfprogeymodel, dialogInterface, i);
            }
        }).setNegativeButton(this.context.getResources().getString(R.string.noCancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyAdapter$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAlertDialog$0(int i, String str, int i2, SelfProgenyModel selfProgenyModel, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        showDialogDeleteProgny(i, str, i2, selfProgenyModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String alertText, String message) {
        new AlertDialog.Builder(this.context).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyAdapter$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAnomalyDetails(SelfProgenyModel item, int pos) {
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
        this.state.toLowerCase();
        this.service.getBloMappingAnomalyDetailsByEpicNoValue(map, map2).enqueue(new AnonymousClass5(item, pos));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.ProgenyAdapter$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ SelfProgenyModel val$item;
        final /* synthetic */ int val$pos;

        AnonymousClass5(final SelfProgenyModel val$item, final int val$pos) {
            this.val$item = val$item;
            this.val$pos = val$pos;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            String asString;
            if (response.isSuccessful() && response.body() != null) {
                try {
                    if (ProgenyAdapter.this.anomalydetailsListvalue != null && ProgenyAdapter.this.anomalydetailsListvalue.size() > 0) {
                        ProgenyAdapter.this.anomalydetailsListvalue.clear();
                    }
                    JsonArray asJsonArray = ProgenyAdapter.this.gson.toJsonTree(((JsonObject) response.body()).get("payload")).getAsJsonArray();
                    if (asJsonArray == null || asJsonArray.isEmpty()) {
                        return;
                    }
                    Iterator it = asJsonArray.get(0).getAsJsonObject().entrySet().iterator();
                    while (true) {
                        asString = "";
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (!((JsonElement) entry.getValue()).isJsonNull()) {
                            asString = ((JsonElement) entry.getValue()).getAsString();
                        }
                        if (!TextUtils.isEmpty(asString) && !asString.equalsIgnoreCase("N")) {
                            ProgenyAdapter.this.anomalydetailsListvalue.add(asString);
                        }
                    }
                    if (!((JsonObject) response.body()).get("remark").isJsonNull()) {
                        asString = ((JsonObject) response.body()).get("remark").getAsString();
                    }
                    ProgenyAdapter progenyAdapter = ProgenyAdapter.this;
                    progenyAdapter.AnomalyDetailsDialogvalue(progenyAdapter.anomalydetailsListvalue, asString, this.val$item, this.val$pos);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            if (response.code() == 401) {
                ProgenyAdapter.this.commomUtility.showMessageOK(ProgenyAdapter.this.context, "SESSION", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyAdapter$5$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                ProgenyAdapter.this.showDialog("Alert", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e) {
                Logger.e("Progeny dialog", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ProgenyAdapter.this.context).setIsLoggedIn(false);
            SharedPref.getInstance(ProgenyAdapter.this.context).setLocaleBool(false);
            ProgenyAdapter.this.context.startActivity(new Intent(ProgenyAdapter.this.context, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitRemark(SelfProgenyModel item, String remark, int pos) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("state", item.getCurrentstate());
        map2.put("epicNo", item.getCurrentEpicNo());
        map2.put("category", "PROGENY");
        map2.put("remarks", remark);
        this.service.setBloRemark(map, map2).enqueue(new AnonymousClass6(item, pos));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.ProgenyAdapter$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        final /* synthetic */ SelfProgenyModel val$item;
        final /* synthetic */ int val$pos;

        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass6(final SelfProgenyModel val$item, final int val$pos) {
            this.val$item = val$item;
            this.val$pos = val$pos;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.isSuccessful() && response.body() != null) {
                this.val$item.setRemark("Yes");
                ProgenyAdapter.this.notifyItemChanged(this.val$pos);
                ProgenyAdapter.this.dialog.dismiss();
            } else {
                if (response.code() == 401) {
                    ProgenyAdapter.this.commomUtility.showMessageOK(ProgenyAdapter.this.context, "SESSION", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyAdapter$6$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                    return;
                }
                try {
                    ProgenyAdapter.this.showDialog("Alert", new JSONObject(response.errorBody().string()).optString("message"));
                } catch (IOException | JSONException e) {
                    Logger.e("Progeny dialog", e.getMessage());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ProgenyAdapter.this.context).setIsLoggedIn(false);
            SharedPref.getInstance(ProgenyAdapter.this.context).setLocaleBool(false);
            ProgenyAdapter.this.context.startActivity(new Intent(ProgenyAdapter.this.context, (Class<?>) LoginActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AnomalyDetailsDialogvalue(ArrayList<String> clusterDetails, String remark, final SelfProgenyModel item, final int pos) {
        this.bindingvalue = MappingAnomalyDetailsValueDialogBinding.inflate(LayoutInflater.from(this.context));
        Dialog dialog = new Dialog(this.context);
        this.dialog = dialog;
        dialog.setContentView(this.bindingvalue.getRoot());
        this.dialog.getWindow().setLayout(-1, -2);
        this.dialog.setCancelable(false);
        this.bindingvalue.recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        this.bindingvalue.recyclerView.setAdapter(new AnomalyListValueAdapter(clusterDetails, this.context, new ItemClickCallback() { // from class: in.gov.eci.bloapp.ProgenyAdapter.7
            @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback
            public void onClicked(VerifyPayload formverificationPayload, String type) {
            }
        }));
        if (!TextUtils.isEmpty(remark)) {
            this.bindingvalue.noremark.setText(remark);
        }
        this.bindingvalue.txtSubmit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyAdapter.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ProgenyAdapter.this.bindingvalue.noremark.getText().toString().isEmpty()) {
                    ProgenyAdapter.this.showDialog("ALERT", "Please enter Remark");
                } else {
                    ProgenyAdapter progenyAdapter = ProgenyAdapter.this;
                    progenyAdapter.submitRemark(item, progenyAdapter.bindingvalue.noremark.getText().toString(), pos);
                }
            }
        });
        this.bindingvalue.ivCancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyAdapter.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ProgenyAdapter.this.dialog.dismiss();
            }
        });
        this.dialog.show();
    }
}
