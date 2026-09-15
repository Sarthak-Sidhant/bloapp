package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceActivity;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UploadAttendenceListAdapter extends RecyclerView.Adapter<holder> {
    List<VerifyPayload> al;
    private Context context;
    List<VerifyPayload> filteredAl;

    public UploadAttendenceListAdapter(List<VerifyPayload> al, Context context) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_form_data, viewGroup, false));
    }

    public void onBindViewHolder(holder holder2, final int i) {
        holder2.epic.setText(this.al.get(i).getEpicNo());
        holder2.serialNo.setText(String.valueOf(this.al.get(i).getPartSerialNo()));
        holder2.electorName.setText(this.al.get(i).getEpicName());
        holder2.lv_category_type.setVisibility(0);
        holder2.category_type_label.setAllCaps(false);
        if (!TextUtils.isEmpty(this.al.get(i).getCategoryType()) && this.al.get(i).getCategoryType().equalsIgnoreCase("noMapping")) {
            holder2.category_type_label.setText(this.context.getResources().getString(R.string.no_mapping_info));
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#DAF0F7"));
        } else if (!TextUtils.isEmpty(this.al.get(i).getCategoryType()) && this.al.get(i).getCategoryType().equalsIgnoreCase("logicaldiscrepancy")) {
            holder2.category_type_label.setText(this.context.getResources().getString(R.string.descripancy_in_mapping));
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#F2CFED"));
        } else if (!TextUtils.isEmpty(this.al.get(i).getCategoryType()) && this.al.get(i).getCategoryType().equalsIgnoreCase("other")) {
            holder2.category_type_label.setText(this.context.getResources().getString(R.string.blo_other));
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        } else {
            holder2.category_type_label.setText(TextUtils.isEmpty(this.al.get(i).getCategoryType()) ? "" : this.al.get(i).getCategoryType());
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#F2EFFC"));
        }
        holder2.viewDetails.setText("Upload Documents");
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.UploadAttendenceListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(UploadAttendenceListAdapter.this.context, (Class<?>) UploadAttendenceActivity.class);
                intent.putExtra("data", UploadAttendenceListAdapter.this.al.get(i));
                intent.putExtra("from", "nomapping");
                UploadAttendenceListAdapter.this.context.startActivity(intent);
            }
        });
        holder2.uncollectable_pending_sir.setVisibility(8);
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
        LinearLayout lv_category_type;
        TextView partNo;
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
            this.viewDetails = (TextView) itemView.findViewById(R.id.viewDetails);
            this.cardViewLL = (LinearLayout) itemView.findViewById(R.id.cardViewLL);
            this.lv_category_type = (LinearLayout) itemView.findViewById(R.id.lv_category_type);
            this.uncollectable_pending_sir = (TextView) itemView.findViewById(R.id.uncollectable_pending_sir);
        }
    }

    public void fun(ArrayList<VerifyPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
