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
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.sir.ReportAnomalyActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AdditionalCommentListAdapter extends RecyclerView.Adapter<holder> {
    List<VerifyPayload> al;
    private Context context;
    List<VerifyPayload> filteredAl;

    public AdditionalCommentListAdapter(List<VerifyPayload> al, Context context) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_additional_data, viewGroup, false));
    }

    public void onBindViewHolder(holder holder2, final int i) {
        holder2.epic.setText(this.al.get(i).getEpicNo());
        holder2.serialNo.setText(String.valueOf(this.al.get(i).getPartSerialNo()));
        holder2.electorName.setText(this.al.get(i).getEpicName());
        holder2.reportAnomaly.setVisibility(0);
        if (!TextUtils.isEmpty(this.al.get(i).getCategoryType()) && this.al.get(i).getCategoryType().equalsIgnoreCase("NA")) {
            holder2.category_type_label.setText(this.context.getResources().getString(R.string.neither_text));
        } else {
            holder2.category_type_label.setText(TextUtils.isEmpty(this.al.get(i).getCategoryType()) ? "" : this.al.get(i).getCategoryType());
        }
        holder2.reportAnomaly.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.AdditionalCommentListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(AdditionalCommentListAdapter.this.context, (Class<?>) ReportAnomalyActivity.class);
                intent.putExtra("epic", AdditionalCommentListAdapter.this.al.get(i).getEpicNo());
                intent.putExtra("psl", AdditionalCommentListAdapter.this.al.get(i).getPartSerialNo());
                intent.putExtra("epicId", AdditionalCommentListAdapter.this.al.get(i).getEpicId());
                intent.putExtra("flag", "reverifym");
                AdditionalCommentListAdapter.this.context.startActivity(intent);
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
        TextView partNo;
        TextView reportAnomaly;
        TextView serialNo;
        TextView state;
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
            this.reportAnomaly = (TextView) itemView.findViewById(R.id.reportAnomaly);
            this.cardViewLL = (LinearLayout) itemView.findViewById(R.id.cardViewLL);
        }
    }

    public void fun(ArrayList<VerifyPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
