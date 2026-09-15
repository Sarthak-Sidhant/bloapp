package in.gov.eci.bloapp;

import android.app.AlertDialog;
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
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.model.SIR.SelfProgenyModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.views.activity.ElectorMapSelfDetails;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ProgenyunmappedAdapter extends RecyclerView.Adapter<ViewHolder> {
    private String atkband;
    private Context context;
    ArrayList<SelfProgenyModel> datalist;
    Gson gson = new GsonBuilder().setLenient().create();
    private boolean isDeleted;
    private String rtkband;
    ArrayList<SelfProgenyModel> searchList;
    UserClient service;
    private String state;
    private String token;

    public ProgenyunmappedAdapter(ArrayList<SelfProgenyModel> datalist, Context context, String token, String state, String atkband, String rtkband) {
        this.datalist = datalist;
        this.context = context;
        this.token = token;
        this.state = state;
        this.atkband = atkband;
        this.rtkband = rtkband;
        this.service = (UserClient) ApiClient.getClient(context).create(UserClient.class);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        TextView deleteBtn;
        LinearLayout electorMAppingLL;
        TextView serialText;
        TextView txt_age;
        TextView txt_self_elector;

        public ViewHolder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_elector_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_elector_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_elector_sir);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.txtDeleteElector);
            this.txt_self_elector = (TextView) itemView.findViewById(R.id.txt_self_elector);
            this.electorMAppingLL = (LinearLayout) itemView.findViewById(R.id.electorMapingLL);
            this.txt_age = (TextView) itemView.findViewById(R.id.age_elector_sir);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.self_progney_list_item, parent, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        final SelfProgenyModel selfProgenyModel = this.datalist.get(i);
        viewHolder.EpicText.setText(selfProgenyModel.getEpicNo());
        viewHolder.serialText.setText(String.valueOf(selfProgenyModel.getPartSerialNo()));
        viewHolder.NameText.setText(selfProgenyModel.getElectorName());
        viewHolder.txt_age.setText(String.valueOf(selfProgenyModel.getAge()));
        if (!TextUtils.isEmpty(selfProgenyModel.getProgenyEpicNo()) && !TextUtils.isEmpty(selfProgenyModel.getCurrentEpicNo())) {
            viewHolder.deleteBtn.setVisibility(8);
            viewHolder.txt_self_elector.setVisibility(8);
            viewHolder.electorMAppingLL.setBackground(this.context.getDrawable(R.color.color_mapping));
        } else if (!TextUtils.isEmpty(selfProgenyModel.getProgenyEpicNo()) && TextUtils.isEmpty(selfProgenyModel.getCurrentEpicNo())) {
            viewHolder.deleteBtn.setVisibility(0);
            viewHolder.txt_self_elector.setVisibility(8);
            viewHolder.electorMAppingLL.setBackground(this.context.getDrawable(R.color.color_mapping));
        } else {
            viewHolder.deleteBtn.setVisibility(8);
            viewHolder.txt_self_elector.setVisibility(0);
            viewHolder.electorMAppingLL.setBackground(this.context.getDrawable(R.color.cardview_light_background));
        }
        viewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyunmappedAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                selfProgenyModel.getElectorName();
                ProgenyunmappedAdapter progenyunmappedAdapter = ProgenyunmappedAdapter.this;
                progenyunmappedAdapter.showAlertDialog("", progenyunmappedAdapter.context.getString(R.string.untag_text), selfProgenyModel.getId(), selfProgenyModel.getProgenyEpicNo(), i);
            }
        });
        viewHolder.txt_self_elector.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyunmappedAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(ProgenyunmappedAdapter.this.context, (Class<?>) ElectorMapSelfDetails.class);
                intent.putExtra("epic", selfProgenyModel.getEpicNo());
                intent.putExtra("name", selfProgenyModel.getElectorName());
                intent.putExtra("relativeName", selfProgenyModel.getRelativeName());
                intent.putExtra("psl", String.valueOf(selfProgenyModel.getPartSerialNo()));
                intent.putExtra("id", String.valueOf(selfProgenyModel.getId()));
                intent.putExtra("ac", String.valueOf(selfProgenyModel.getAc()));
                intent.putExtra("part", String.valueOf(selfProgenyModel.getPart()));
                intent.putExtra("age", String.valueOf(selfProgenyModel.getAge()));
                ProgenyunmappedAdapter.this.context.startActivity(intent);
            }
        });
    }

    private void showDialogDeleteProgny(int id, String progenyEpic, final int pos) {
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
        this.service.deleteSelfProgeny(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.ProgenyunmappedAdapter.3
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ProgenyunmappedAdapter.this.notifyItemChanged(pos);
                    Toast.makeText(ProgenyunmappedAdapter.this.context, String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                    ProgenyunmappedAdapter.this.datalist.get(pos).setProgenyEpicNo(null);
                    return;
                }
                try {
                    if (response.errorBody() != null) {
                        Toast.makeText(ProgenyunmappedAdapter.this.context, new JSONObject(response.errorBody().string()).optString("message"), 1).show();
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
    public void showAlertDialog(String alertText, String message, final int id, final String epic, final int pos) {
        new AlertDialog.Builder(this.context).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(this.context.getResources().getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyunmappedAdapter$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showAlertDialog$0(id, epic, pos, dialogInterface, i);
            }
        }).setNegativeButton(this.context.getResources().getString(R.string.noCancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.ProgenyunmappedAdapter$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAlertDialog$0(int i, String str, int i2, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        showDialogDeleteProgny(i, str, i2);
    }
}
