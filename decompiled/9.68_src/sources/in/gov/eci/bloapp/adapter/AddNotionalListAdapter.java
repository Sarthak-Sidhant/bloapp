package in.gov.eci.bloapp.adapter;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.views.activity.newsir.callback.AddNotinalItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.AddNotionalPayload;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.compress.archivers.tar.TarConstants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AddNotionalListAdapter extends RecyclerView.Adapter<ViewHolder> {
    int acNo;
    private String atkband;
    private Context context;
    ArrayList<AddNotionalPayload> datalist;
    AddNotinalItemClickCallback markVipItemClickCallback;
    int partNo;
    private String rtkband;
    ArrayList<AddNotionalPayload> searchList;
    UserClient service;
    private String state;
    private String token;

    public AddNotionalListAdapter(ArrayList<AddNotionalPayload> datalist, Context context, String token, String state, String atkband, String rtkband, int acNo, int partNo, AddNotinalItemClickCallback markVipItemClickCallback) {
        this.datalist = datalist;
        this.context = context;
        this.searchList = new ArrayList<>(datalist);
        this.token = token;
        this.state = state;
        this.atkband = atkband;
        this.rtkband = rtkband;
        this.acNo = acNo;
        this.partNo = partNo;
        this.markVipItemClickCallback = markVipItemClickCallback;
        this.service = (UserClient) ApiClient.getClient1(context).create(UserClient.class);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        LinearLayout cardView;
        TextView gender;
        TextView hNo;
        TextView notionalHno;
        TextView relationName;
        TextView serialText;
        TextView updateAddNotional;

        public ViewHolder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_pending_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_pending_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_pending_sir);
            this.updateAddNotional = (TextView) itemView.findViewById(R.id.updateAddNotional);
            this.relationName = (TextView) itemView.findViewById(R.id.relationName_pending_sir);
            this.gender = (TextView) itemView.findViewById(R.id.gender_pending_sir);
            this.hNo = (TextView) itemView.findViewById(R.id.houseNo_addNotional);
            this.notionalHno = (TextView) itemView.findViewById(R.id.notionalHNo);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.add_notional_list_item, parent, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final AddNotionalPayload addNotionalPayload = this.datalist.get(i);
        viewHolder.EpicText.setText(addNotionalPayload.getEpicNo());
        viewHolder.serialText.setText(String.valueOf(addNotionalPayload.getPartSerialNumber()));
        viewHolder.NameText.setText(addNotionalPayload.getName());
        viewHolder.relationName.setText(addNotionalPayload.getRelationName());
        viewHolder.hNo.setText(addNotionalPayload.getHouseNumber());
        if (TextUtils.isEmpty(addNotionalPayload.getNotionalHNo())) {
            viewHolder.notionalHno.setText("");
        } else {
            viewHolder.notionalHno.setText("N" + addNotionalPayload.getNotionalHNo());
        }
        if (addNotionalPayload.getGender().equals("M")) {
            viewHolder.gender.setText("Male");
        } else if (addNotionalPayload.getGender().equals("F")) {
            viewHolder.gender.setText("Female");
        } else if (addNotionalPayload.getGender().equals("T")) {
            viewHolder.gender.setText("Other");
        }
        viewHolder.updateAddNotional.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.AddNotionalListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AddNotionalListAdapter.this.showDialogUpdateNotional(addNotionalPayload);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogUpdateNotional(final AddNotionalPayload item) {
        final Dialog dialog = new Dialog(this.context);
        dialog.setContentView(R.layout.view_notional_house);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        final EditText editText = (EditText) dialog.findViewById(R.id.tv_notional_hNo);
        if (!TextUtils.isEmpty(item.getNotionalHNo())) {
            editText.setText(item.getNotionalHNo());
        }
        ((Button) dialog.findViewById(R.id.btncancel)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.AddNotionalListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        ((Button) dialog.findViewById(R.id.btnUpdate)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.AddNotionalListAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText.getText().toString())) {
                    if (editText.getText().toString().equals("0") || editText.getText().toString().equals(TarConstants.VERSION_POSIX) || editText.getText().toString().equals("000") || editText.getText().toString().equals("0000")) {
                        Toast.makeText(AddNotionalListAdapter.this.context, "Please enter valid notional house number", 1).show();
                        return;
                    } else {
                        AddNotionalListAdapter.this.updateNotionalHNo(item, editText.getText().toString(), dialog);
                        return;
                    }
                }
                Toast.makeText(AddNotionalListAdapter.this.context, "Please enter notional house number", 1).show();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNotionalHNo(final AddNotionalPayload item, String notionalNo, final Dialog dialog) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("notionalHNo", Integer.valueOf(notionalNo));
        map2.put("epicNo", item.getEpicNo());
        map2.put("partSerialNumber", Integer.valueOf(item.getPartSerialNumber()));
        map2.put("partNo", Integer.valueOf(this.partNo));
        map2.put("acNo", Integer.valueOf(this.acNo));
        this.service.updateNotionalHNo(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.adapter.AddNotionalListAdapter.4
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    Toast.makeText(AddNotionalListAdapter.this.context, "Notional house no updated successfully", 1).show();
                    AddNotionalListAdapter.this.markVipItemClickCallback.onClicked(item, "success");
                    dialog.dismiss();
                    return;
                }
                Toast.makeText(AddNotionalListAdapter.this.context, Constants.somethingWentWrong, 0).show();
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.e("AddNotionalListadapter", t.getMessage());
            }
        });
    }

    public int getItemCount() {
        return this.datalist.size();
    }

    public void fun(ArrayList<AddNotionalPayload> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }
}
