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
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity;
import in.gov.eci.bloapp.views.activity.newsir.callback.AnomalyItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class AnomalyListAdapter extends RecyclerView.Adapter<holder> {
    List<VerifyPayload> al;
    private Context context;
    List<VerifyPayload> filteredAl;
    AnomalyItemClickCallback itemClickCallback;

    public AnomalyListAdapter(List<VerifyPayload> al, Context context, AnomalyItemClickCallback itemClickCallback) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.itemClickCallback = itemClickCallback;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.anomaly_item, viewGroup, false));
    }

    public void onBindViewHolder(final holder holder2, int i) {
        holder2.epic.setText(this.al.get(i).getEpicNo());
        holder2.serialNo.setText(String.valueOf(this.al.get(i).getPartSerialNo()));
        holder2.electorName.setText(this.al.get(i).getEpicName());
        holder2.lv_asd.setVisibility(8);
        holder2.lv_eightfive.setVisibility(8);
        holder2.uncollectable_pending_sir.setVisibility(0);
        holder2.viewDetails.setText("View Logical Discrepancies");
        holder2.uncollectable_pending_sir.setText(this.context.getResources().getString(R.string.view_details_aero));
        if (!TextUtils.isEmpty(this.al.get(i).getCategoryType())) {
            holder2.lv_category.setVisibility(0);
            holder2.category.setText(this.al.get(i).getCategoryType());
        } else {
            holder2.lv_category.setVisibility(8);
        }
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.AnomalyListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = holder2.getAdapterPosition();
                AnomalyListAdapter.this.itemClickCallback.onClicked(AnomalyListAdapter.this.al.get(adapterPosition), adapterPosition + "");
            }
        });
        if (!TextUtils.isEmpty(this.al.get(i).getAnomalyNoActionRequired()) && this.al.get(i).getAnomalyNoActionRequired().equalsIgnoreCase("D")) {
            holder2.viewDetails.setVisibility(8);
            holder2.cardViewLL.setBackgroundColor(this.context.getResources().getColor(R.color.ef_green));
        } else {
            holder2.viewDetails.setVisibility(0);
            holder2.cardViewLL.setBackgroundColor(this.context.getResources().getColor(R.color.new_list_color));
        }
        holder2.uncollectable_pending_sir.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.AnomalyListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int adapterPosition = holder2.getAdapterPosition();
                Intent intent = new Intent(AnomalyListAdapter.this.context, (Class<?>) FormVerificationActivity.class);
                intent.putExtra("data", AnomalyListAdapter.this.al.get(adapterPosition));
                intent.putExtra("from", "anomaly");
                AnomalyListAdapter.this.context.startActivity(intent);
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
        TextView category;
        TextView category_type_label;
        TextView electorName;
        TextView epic;
        LinearLayout ll_deceased;
        LinearLayout ll_eightyfive;
        LinearLayout lv_asd;
        LinearLayout lv_category;
        LinearLayout lv_eightfive;
        TextView partNo;
        TextView serialNo;
        TextView state;
        TextView tv_asd;
        TextView uncollectable_pending_sir;
        TextView viewDetails;

        public holder(View itemView) {
            super(itemView);
            this.electorName = (TextView) itemView.findViewById(R.id.electorName);
            this.category = (TextView) itemView.findViewById(R.id.category);
            this.epic = (TextView) itemView.findViewById(R.id.epic);
            this.address = (TextView) itemView.findViewById(R.id.address);
            this.serialNo = (TextView) itemView.findViewById(R.id.serialNo);
            this.partNo = (TextView) itemView.findViewById(R.id.partNo);
            this.acName = (TextView) itemView.findViewById(R.id.acName);
            this.state = (TextView) itemView.findViewById(R.id.state);
            this.category_type_label = (TextView) itemView.findViewById(R.id.category_type_label);
            this.tv_asd = (TextView) itemView.findViewById(R.id.tv_asd);
            this.viewDetails = (TextView) itemView.findViewById(R.id.viewDetails);
            this.cardViewLL = (LinearLayout) itemView.findViewById(R.id.cardViewLL);
            this.ll_deceased = (LinearLayout) itemView.findViewById(R.id.ll_deceased);
            this.lv_asd = (LinearLayout) itemView.findViewById(R.id.lv_asd);
            this.lv_eightfive = (LinearLayout) itemView.findViewById(R.id.lv_eightfive);
            this.lv_category = (LinearLayout) itemView.findViewById(R.id.lv_category);
            this.uncollectable_pending_sir = (TextView) itemView.findViewById(R.id.uncollectable_pending_sir);
        }
    }

    public void fun(ArrayList<VerifyPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
