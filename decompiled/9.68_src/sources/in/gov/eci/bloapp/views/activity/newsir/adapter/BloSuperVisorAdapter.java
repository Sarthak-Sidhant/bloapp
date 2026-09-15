package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.newsir.model.BLOSupervisorModel;
import in.gov.eci.bloapp.views.activity.sir.Language.SIRLanguageSelection;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BloSuperVisorAdapter extends RecyclerView.Adapter<holder> {
    List<BLOSupervisorModel> al;
    private Context context;
    List<BLOSupervisorModel> filteredAl;
    private OnItemMobileListener listener;

    public interface OnItemMobileListener {
        void onItemMobile(String mobileNumber);
    }

    public BloSuperVisorAdapter(List<BLOSupervisorModel> al, Context context, OnItemMobileListener listener) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.listener = listener;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.blo_supervisor_row, viewGroup, false));
    }

    public void onBindViewHolder(final holder holder2, int i) {
        holder2.epic.setText(this.al.get(i).getPartNo() + " - " + this.al.get(i).getPartName());
        holder2.electorName.setText(this.al.get(i).getName());
        holder2.category_type_label.setText(this.al.get(i).getMobileNumber());
        holder2.callIcon.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.BloSuperVisorAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(holder2, view);
            }
        });
        holder2.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.BloSuperVisorAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BloSuperVisorAdapter.this.context.startActivity(new Intent(BloSuperVisorAdapter.this.context, (Class<?>) SIRLanguageSelection.class));
            }
        });
        holder2.uncollectable_pending_sir.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(holder holderVar, View view) {
        this.listener.onItemMobile(this.al.get(holderVar.getAdapterPosition()).getMobileNumber());
    }

    public int getItemCount() {
        return this.al.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView acName;
        TextView address;
        RelativeLayout callIcon;
        LinearLayout cardViewLL;
        TextView category_type_label;
        TextView electorName;
        TextView epic;
        LinearLayout lv_category_type;
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
            this.lv_category_type = (LinearLayout) itemView.findViewById(R.id.lv_category_type);
            this.callIcon = (RelativeLayout) itemView.findViewById(R.id.callIcon);
        }
    }

    public void fun(ArrayList<BLOSupervisorModel> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
