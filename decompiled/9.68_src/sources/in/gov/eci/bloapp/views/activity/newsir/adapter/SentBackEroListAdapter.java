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
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyEditActivity;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.sir.UncollectableSIR;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SentBackEroListAdapter extends RecyclerView.Adapter<holder> {
    List<VerifyPayload> al;
    private Context context;
    List<VerifyPayload> filteredAl;

    public SentBackEroListAdapter(List<VerifyPayload> al, Context context) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_rollback_form, viewGroup, false));
    }

    public void onBindViewHolder(holder holder2, final int i) {
        holder2.epic.setText(this.al.get(i).getEpicNo());
        holder2.serialNo.setText(String.valueOf(this.al.get(i).getPartSerialNo()));
        holder2.electorName.setText(this.al.get(i).getEpicName());
        holder2.remarks.setText(TextUtils.isEmpty(this.al.get(i).getBackToBloRemarks()) ? "" : this.al.get(i).getBackToBloRemarks());
        if (TextUtils.isEmpty(this.al.get(i).getCategoryType())) {
            holder2.lv_category.setVisibility(8);
        } else {
            holder2.lv_category.setVisibility(0);
            if (!TextUtils.isEmpty(this.al.get(i).getCategoryType()) && this.al.get(i).getCategoryType().equalsIgnoreCase("NA")) {
                holder2.category_type_label.setText(this.context.getResources().getString(R.string.neither_text));
            } else {
                holder2.category_type_label.setText(TextUtils.isEmpty(this.al.get(i).getCategoryType()) ? "" : this.al.get(i).getCategoryType());
            }
        }
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.SentBackEroListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(SentBackEroListAdapter.this.context, (Class<?>) VerifyEditActivity.class);
                intent.putExtra("data", SentBackEroListAdapter.this.al.get(i));
                intent.putExtra("from", "sentbyero");
                SentBackEroListAdapter.this.context.startActivity(intent);
            }
        });
        if (SharedPref.getInstance(this.context.getApplicationContext()).getAlreadyFilledFormSentBackMarkUnButton().equalsIgnoreCase("Y")) {
            holder2.markUncollectable.setVisibility(0);
        } else {
            holder2.markUncollectable.setVisibility(8);
        }
        holder2.markUncollectable.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.SentBackEroListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(SentBackEroListAdapter.this.context, (Class<?>) UncollectableSIR.class);
                intent.putExtra("epic", SentBackEroListAdapter.this.al.get(i).getEpicNo());
                intent.putExtra("psl", SentBackEroListAdapter.this.al.get(i).getPartSerialNo());
                intent.putExtra("flag", "RE");
                intent.putExtra("epicId", SentBackEroListAdapter.this.al.get(i).getEpicId());
                SentBackEroListAdapter.this.context.startActivity(intent);
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
        LinearLayout lv_category;
        TextView markUncollectable;
        TextView partNo;
        TextView remarks;
        TextView serialNo;
        TextView state;
        TextView viewDetails;

        public holder(View itemView) {
            super(itemView);
            this.electorName = (TextView) itemView.findViewById(R.id.electorName);
            this.epic = (TextView) itemView.findViewById(R.id.epic);
            this.serialNo = (TextView) itemView.findViewById(R.id.partNo);
            this.viewDetails = (TextView) itemView.findViewById(R.id.viewDetails);
            this.cardViewLL = (LinearLayout) itemView.findViewById(R.id.cardViewLL);
            this.lv_category = (LinearLayout) itemView.findViewById(R.id.lv_category);
            this.markUncollectable = (TextView) itemView.findViewById(R.id.markUncollectable);
            this.remarks = (TextView) itemView.findViewById(R.id.remarks);
            this.category_type_label = (TextView) itemView.findViewById(R.id.category_type_label);
        }
    }

    public void fun(ArrayList<VerifyPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
