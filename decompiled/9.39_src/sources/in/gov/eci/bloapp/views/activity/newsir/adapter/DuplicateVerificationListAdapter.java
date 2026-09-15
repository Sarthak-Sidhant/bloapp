package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.sir.UncollectableSIR;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DuplicateVerificationListAdapter extends RecyclerView.Adapter<holder> {
    List<VerifyPayload> al;
    private Context context;
    List<VerifyPayload> filteredAl;
    ItemClickCallback itemClickCallback;

    public DuplicateVerificationListAdapter(List<VerifyPayload> al, Context context, ItemClickCallback itemClickCallback) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.itemClickCallback = itemClickCallback;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.duplicate_verification_item, viewGroup, false));
    }

    public void onBindViewHolder(final holder holder2, int i) {
        holder2.epic.setText(this.al.get(i).getEpicNo());
        holder2.serialNo.setText(String.valueOf(this.al.get(i).getPartSerialNo()));
        holder2.electorName.setText(this.al.get(i).getEpicName());
        if (this.al.get(i).getDseType() == 1) {
            holder2.lv_cluster.setVisibility(0);
            holder2.tv_clusterid.setText(this.al.get(i).getDseClusterId());
        } else {
            holder2.lv_cluster.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.al.get(i).getPse()) && this.al.get(i).getPse().equalsIgnoreCase("Y")) {
            holder2.lv_asd.setVisibility(0);
        } else {
            holder2.lv_asd.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.al.get(i).getDse()) && this.al.get(i).getDse().equalsIgnoreCase("Y")) {
            holder2.lv_eightfive.setVisibility(0);
        } else {
            holder2.lv_eightfive.setVisibility(8);
        }
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.DuplicateVerificationListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = holder2.getAdapterPosition();
                DuplicateVerificationListAdapter.this.itemClickCallback.onClicked(DuplicateVerificationListAdapter.this.al.get(adapterPosition), adapterPosition + "");
            }
        });
        holder2.view_details_elector.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.DuplicateVerificationListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DuplicateVerificationListAdapter.this.itemClickCallback.onClicked(DuplicateVerificationListAdapter.this.al.get(holder2.getAdapterPosition()), "viewdetails");
            }
        });
        holder2.uncollectable_pending_sir.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.DuplicateVerificationListAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int adapterPosition = holder2.getAdapterPosition();
                Intent intent = new Intent(DuplicateVerificationListAdapter.this.context, (Class<?>) UncollectableSIR.class);
                intent.putExtra("epic", DuplicateVerificationListAdapter.this.al.get(adapterPosition).getEpicNo());
                intent.putExtra("psl", DuplicateVerificationListAdapter.this.al.get(adapterPosition).getPartSerialNo());
                intent.putExtra("epicId", DuplicateVerificationListAdapter.this.al.get(adapterPosition).getEpicId());
                intent.putExtra("flag", "duplicateverify");
                intent.putExtra("from", "duplicateverify");
                DuplicateVerificationListAdapter.this.context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.al.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView acName;
        TextView address;
        LinearLayout cardViewLL;
        TextView category_type_label;
        TextView electorName;
        TextView epic;
        LinearLayout ll_deceased;
        LinearLayout ll_eightyfive;
        LinearLayout lv_asd;
        LinearLayout lv_cluster;
        LinearLayout lv_eightfive;
        TextView partNo;
        TextView serialNo;
        TextView state;
        TextView tv_asd;
        TextView tv_clusterid;
        TextView uncollectable_pending_sir;
        TextView viewDetails;
        TextView view_details_elector;

        public holder(View itemView) {
            super(itemView);
            this.electorName = (TextView) itemView.findViewById(R.id.electorName);
            this.epic = (TextView) itemView.findViewById(R.id.epic);
            this.address = (TextView) itemView.findViewById(R.id.address);
            this.serialNo = (TextView) itemView.findViewById(R.id.serialNo);
            this.partNo = (TextView) itemView.findViewById(R.id.partNo);
            this.acName = (TextView) itemView.findViewById(R.id.acName);
            this.state = (TextView) itemView.findViewById(R.id.state);
            this.category_type_label = (TextView) itemView.findViewById(R.id.category_type_label);
            this.tv_asd = (TextView) itemView.findViewById(R.id.tv_asd);
            this.viewDetails = (TextView) itemView.findViewById(R.id.viewDetails);
            this.tv_clusterid = (TextView) itemView.findViewById(R.id.tv_clusterid);
            this.view_details_elector = (TextView) itemView.findViewById(R.id.view_details_elector);
            this.cardViewLL = (LinearLayout) itemView.findViewById(R.id.cardViewLL);
            this.ll_deceased = (LinearLayout) itemView.findViewById(R.id.ll_deceased);
            this.lv_asd = (LinearLayout) itemView.findViewById(R.id.lv_asd);
            this.lv_eightfive = (LinearLayout) itemView.findViewById(R.id.lv_eightfive);
            this.lv_cluster = (LinearLayout) itemView.findViewById(R.id.lv_cluster);
            this.uncollectable_pending_sir = (TextView) itemView.findViewById(R.id.uncollectable_pending_sir);
        }
    }

    public void fun(ArrayList<VerifyPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
