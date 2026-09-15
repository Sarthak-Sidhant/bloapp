package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.FomatC7DetailsActivity;
import in.gov.eci.bloapp.views.activity.FomatCDetailsActivity;
import in.gov.eci.bloapp.views.activity.newsir.model.formatc.Content;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormatCListAdapter extends RecyclerView.Adapter<holder> {
    List<Content> al;
    private Context context;
    List<Content> filteredAl;
    String selectedtab;

    public FormatCListAdapter(List<Content> al, Context context, String selectedtab) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.selectedtab = selectedtab;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.blo_formatc_rv_item, viewGroup, false));
    }

    public void onBindViewHolder(final holder holder2, int i) {
        holder2.serial_no_tv.setText("S.No: " + String.valueOf(this.al.get(i).getId()));
        holder2.ref_no_tv2.setText(!TextUtils.isEmpty(this.al.get(i).getFormRefNo()) ? this.al.get(i).getFormRefNo() : "");
        holder2.name_tv.setText(TextUtils.isEmpty(this.al.get(i).getElectorName()) ? "" : this.al.get(i).getElectorName());
        if (!TextUtils.isEmpty(this.al.get(i).getFormType())) {
            if (this.al.get(i).getFormType().equalsIgnoreCase("F8S")) {
                holder2.form_tv.setText("Form 8 (Shifting)");
            } else if (this.al.get(i).getFormType().equalsIgnoreCase("F8C")) {
                holder2.form_tv.setText("Form 8 (Correction) ");
            } else if (this.al.get(i).getFormType().equalsIgnoreCase("F7")) {
                holder2.form_tv.setText("Form 7");
            }
        }
        holder2.existing_elector_tv.setVisibility(8);
        holder2.existing_elector_tv2.setVisibility(8);
        if (!TextUtils.isEmpty(this.al.get(i).getCreatedDTTM())) {
            holder2.dateTv.setText(OffsetDateTime.parse(this.al.get(i).getCreatedDTTM()).format(DateTimeFormatter.ofPattern("dd/MM/yy")));
        }
        holder2.layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.FormatCListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!TextUtils.isEmpty(FormatCListAdapter.this.al.get(holder2.getAdapterPosition()).getFormType()) && FormatCListAdapter.this.al.get(holder2.getAdapterPosition()).getFormType().equalsIgnoreCase("F7")) {
                    Intent intent = new Intent(FormatCListAdapter.this.context, (Class<?>) FomatC7DetailsActivity.class);
                    intent.putExtra("item", FormatCListAdapter.this.al.get(holder2.getAdapterPosition()));
                    intent.putExtra("tab", FormatCListAdapter.this.selectedtab);
                    FormatCListAdapter.this.context.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(FormatCListAdapter.this.context, (Class<?>) FomatCDetailsActivity.class);
                intent2.putExtra("item", FormatCListAdapter.this.al.get(holder2.getAdapterPosition()));
                intent2.putExtra("tab", FormatCListAdapter.this.selectedtab);
                FormatCListAdapter.this.context.startActivity(intent2);
            }
        });
    }

    public int getItemCount() {
        return this.al.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView dateTv;
        TextView existing_elector_tv;
        TextView existing_elector_tv2;
        TextView form_tv;
        ConstraintLayout layout;
        TextView name_tv;
        TextView ref_no_tv2;
        TextView serial_no_tv;

        public holder(View itemView) {
            super(itemView);
            this.serial_no_tv = (TextView) itemView.findViewById(R.id.serial_no_tv);
            this.name_tv = (TextView) itemView.findViewById(R.id.name_tv);
            this.dateTv = (TextView) itemView.findViewById(R.id.date_tv);
            this.form_tv = (TextView) itemView.findViewById(R.id.form_tv);
            this.ref_no_tv2 = (TextView) itemView.findViewById(R.id.ref_no_tv2);
            this.existing_elector_tv2 = (TextView) itemView.findViewById(R.id.existing_elector_tv2);
            this.existing_elector_tv = (TextView) itemView.findViewById(R.id.existing_elector_tv);
            this.layout = itemView.findViewById(2131364291);
        }
    }

    public void fun(ArrayList<Content> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
