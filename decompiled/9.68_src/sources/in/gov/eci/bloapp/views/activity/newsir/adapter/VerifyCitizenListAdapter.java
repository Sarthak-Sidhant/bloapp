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
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.FormVerificationActivity;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.sir.UncollectableSIR;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class VerifyCitizenListAdapter extends RecyclerView.Adapter<holder> {
    List<VerifyPayload> al;
    private Context context;
    List<VerifyPayload> filteredAl;

    public VerifyCitizenListAdapter(List<VerifyPayload> al, Context context) {
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
        if (!TextUtils.isEmpty(this.al.get(i).getCategoryType()) && this.al.get(i).getCategoryType().equalsIgnoreCase("NA")) {
            holder2.category_type_label.setText(this.context.getResources().getString(R.string.neither_text));
        } else {
            holder2.category_type_label.setText(TextUtils.isEmpty(this.al.get(i).getCategoryType()) ? "" : this.al.get(i).getCategoryType());
        }
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.VerifyCitizenListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(VerifyCitizenListAdapter.this.context, (Class<?>) FormVerificationActivity.class);
                intent.putExtra("data", VerifyCitizenListAdapter.this.al.get(i));
                intent.putExtra("from", "verify");
                VerifyCitizenListAdapter.this.context.startActivity(intent);
            }
        });
        if (SharedPref.getInstance(this.context.getApplicationContext()).getverifyMarkUncollectable().equalsIgnoreCase("Y")) {
            holder2.uncollectable_pending_sir.setVisibility(0);
        } else {
            holder2.uncollectable_pending_sir.setVisibility(8);
        }
        holder2.uncollectable_pending_sir.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.VerifyCitizenListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(VerifyCitizenListAdapter.this.context, (Class<?>) UncollectableSIR.class);
                intent.putExtra("epic", VerifyCitizenListAdapter.this.al.get(i).getEpicNo());
                intent.putExtra("psl", VerifyCitizenListAdapter.this.al.get(i).getPartSerialNo());
                intent.putExtra("epicId", VerifyCitizenListAdapter.this.al.get(i).getEpicId());
                intent.putExtra("flag", "verifym");
                intent.putExtra("from", "verifym");
                VerifyCitizenListAdapter.this.context.startActivity(intent);
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
        TextView serialNo;
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
        }
    }

    public void fun(ArrayList<VerifyPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
