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
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateMobileActivity;
import in.gov.eci.bloapp.views.activity.newsir.model.UpdateMobilePayload;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UpdateMobileListAdapter extends RecyclerView.Adapter<holder> {
    List<UpdateMobilePayload> al;
    private Context context;
    List<UpdateMobilePayload> filteredAl;

    public UpdateMobileListAdapter(List<UpdateMobilePayload> al, Context context) {
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
        holder2.lv_category_type.setVisibility(8);
        if (!TextUtils.isEmpty(this.al.get(i).getUpdatedEpic())) {
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#C3F3C0"));
            holder2.viewDetails.setVisibility(8);
            holder2.llAddress.setVisibility(0);
            holder2.tv_lable_address.setText("Phone No:");
            holder2.address.setText(this.al.get(i).getMobileNo());
        } else {
            holder2.cardViewLL.setBackgroundColor(Color.parseColor("#F2EFFC"));
            holder2.viewDetails.setVisibility(0);
            holder2.llAddress.setVisibility(8);
        }
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.UpdateMobileListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(UpdateMobileListAdapter.this.context, (Class<?>) UpdateMobileActivity.class);
                intent.putExtra("data", UpdateMobileListAdapter.this.al.get(i));
                intent.putExtra("from", "photo");
                UpdateMobileListAdapter.this.context.startActivity(intent);
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
        LinearLayout llAddress;
        LinearLayout lv_category_type;
        TextView serialNo;
        TextView tv_lable_address;
        TextView uncollectable_pending_sir;
        TextView viewDetails;

        public holder(View itemView) {
            super(itemView);
            this.electorName = (TextView) itemView.findViewById(R.id.electorName);
            this.epic = (TextView) itemView.findViewById(R.id.epic);
            this.serialNo = (TextView) itemView.findViewById(R.id.serialNo);
            this.acName = (TextView) itemView.findViewById(R.id.acName);
            this.category_type_label = (TextView) itemView.findViewById(R.id.category_type_label);
            this.uncollectable_pending_sir = (TextView) itemView.findViewById(R.id.uncollectable_pending_sir);
            this.viewDetails = (TextView) itemView.findViewById(R.id.viewDetails);
            this.cardViewLL = (LinearLayout) itemView.findViewById(R.id.cardViewLL);
            this.lv_category_type = (LinearLayout) itemView.findViewById(R.id.lv_category_type);
            this.llAddress = (LinearLayout) itemView.findViewById(R.id.llAddress);
            this.tv_lable_address = (TextView) itemView.findViewById(R.id.tv_lable_address);
            this.address = (TextView) itemView.findViewById(R.id.address);
        }
    }

    public void fun(ArrayList<UpdateMobilePayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
