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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AsdListAdapter extends RecyclerView.Adapter<holder> {
    List<VerifyPayload> al;
    private Context context;
    List<VerifyPayload> filteredAl;
    ItemClickCallback itemClickCallback;

    public AsdListAdapter(List<VerifyPayload> al, Context context, ItemClickCallback itemClickCallback) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.itemClickCallback = itemClickCallback;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.asd_item, viewGroup, false));
    }

    public void onBindViewHolder(final holder holder2, int i) {
        holder2.epic.setText(this.al.get(i).getEpicNo());
        holder2.serialNo.setText(String.valueOf(this.al.get(i).getPartSerialNo()));
        holder2.electorName.setText(this.al.get(i).getEpicName());
        if (!TextUtils.isEmpty(this.al.get(i).getDeceased()) && this.al.get(i).getDeceased().equalsIgnoreCase("Y")) {
            holder2.lv_asd.setVisibility(0);
        } else {
            holder2.lv_asd.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.al.get(i).getEightyFivePlus()) && this.al.get(i).getEightyFivePlus().equalsIgnoreCase("Y")) {
            holder2.lv_eightfive.setVisibility(0);
        } else {
            holder2.lv_eightfive.setVisibility(8);
        }
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.AsdListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = holder2.getAdapterPosition();
                AsdListAdapter.this.itemClickCallback.onClicked(AsdListAdapter.this.al.get(adapterPosition), adapterPosition + "");
            }
        });
        holder2.uncollectable_pending_sir.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.AsdListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int adapterPosition = holder2.getAdapterPosition();
                Intent intent = new Intent(AsdListAdapter.this.context, (Class<?>) UncollectableSIR.class);
                intent.putExtra("epic", AsdListAdapter.this.al.get(adapterPosition).getEpicNo());
                intent.putExtra("psl", AsdListAdapter.this.al.get(adapterPosition).getPartSerialNo());
                intent.putExtra("epicId", AsdListAdapter.this.al.get(adapterPosition).getEpicId());
                intent.putExtra("flag", "asdlist");
                intent.putExtra("from", "asdlist");
                AsdListAdapter.this.context.startActivity(intent);
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
            this.uncollectable_pending_sir = (TextView) itemView.findViewById(R.id.uncollectable_pending_sir);
        }
    }

    public void fun(ArrayList<VerifyPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
