package in.gov.eci.bloapp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import in.gov.eci.bloapp.views.activity.newsir.callback.MarkVipItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.MarkVipPayload;
import java.util.ArrayList;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class MarkVIpListAdapter extends RecyclerView.Adapter<ViewHolder> {
    int acNo;
    private String atkband;
    private Context context;
    ArrayList<MarkVipPayload> datalist;
    MarkVipItemClickCallback markVipItemClickCallback;
    private String rtkband;
    ArrayList<MarkVipPayload> searchList;
    UserClient service;
    private String state;
    private String token;

    public MarkVIpListAdapter(ArrayList<MarkVipPayload> datalist, Context context, String token, String state, String atkband, String rtkband, int acNo, MarkVipItemClickCallback markVipItemClickCallback) {
        this.datalist = datalist;
        this.context = context;
        this.searchList = new ArrayList<>(datalist);
        this.token = token;
        this.state = state;
        this.atkband = atkband;
        this.rtkband = rtkband;
        this.acNo = acNo;
        this.markVipItemClickCallback = markVipItemClickCallback;
        this.service = (UserClient) ApiClient.getClient1(context).create(UserClient.class);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        LinearLayout cardView;
        TextView gender;
        TextView markVipButton;
        TextView relationName;
        TextView serialText;

        public ViewHolder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_pending_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_pending_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_pending_sir);
            this.markVipButton = (TextView) itemView.findViewById(R.id.mark_vip);
            this.relationName = (TextView) itemView.findViewById(R.id.relationName_pending_sir);
            this.gender = (TextView) itemView.findViewById(R.id.gender_pending_sir);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mark_vip_list_item, parent, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final MarkVipPayload markVipPayload = this.datalist.get(i);
        viewHolder.EpicText.setText(markVipPayload.getEpicNumber());
        viewHolder.serialText.setText(String.valueOf(markVipPayload.getPartSerialNumber()));
        viewHolder.NameText.setText(markVipPayload.getElectorName());
        viewHolder.relationName.setText(markVipPayload.getRelationName());
        if (markVipPayload.getGender().equals("M")) {
            viewHolder.gender.setText("Male");
        } else if (markVipPayload.getGender().equals("F")) {
            viewHolder.gender.setText("Female");
        } else if (markVipPayload.getGender().equals("T")) {
            viewHolder.gender.setText("Other");
        }
        if (TextUtils.isEmpty(markVipPayload.recommendationStatus)) {
            viewHolder.markVipButton.setVisibility(0);
        } else {
            viewHolder.markVipButton.setVisibility(8);
        }
        viewHolder.markVipButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.MarkVIpListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MarkVIpListAdapter.this.submitVip(markVipPayload);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitVip(final MarkVipPayload item) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("recommendationStatus", "Y");
        map2.put("isActive", "Y");
        map2.put("electorName", item.getElectorName());
        map2.put("epicNumber", item.getEpicNumber());
        map2.put("partSerialNo", Integer.valueOf(item.getPartSerialNumber()));
        map2.put("partNo", Integer.valueOf(item.getPartNumber()));
        map2.put("acNo", Integer.valueOf(item.getAssemblyNo()));
        map2.put("stateCd", this.state);
        map2.put("epicId", Integer.valueOf(item.getEpicId()));
        map2.put("gender", item.getGender());
        map2.put("relationName", item.getRelationName());
        map2.put("createdBy", "blo");
        this.service.submitBloVipRecommended(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.adapter.MarkVIpListAdapter.2
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    Toast.makeText(MarkVIpListAdapter.this.context, "VIP marked successfully", 1).show();
                    MarkVIpListAdapter.this.markVipItemClickCallback.onClicked(item, "success");
                } else {
                    Toast.makeText(MarkVIpListAdapter.this.context, Constants.somethingWentWrong, 0).show();
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.e("MarkVipAdapter", t.getMessage());
            }
        });
    }

    public int getItemCount() {
        return this.datalist.size();
    }

    public void fun(ArrayList<MarkVipPayload> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }
}
