package in.gov.eci.bloapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.model.SIR.pendingListModel;
import in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH;
import in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class jsonAdapterBH extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    ArrayList<pendingListModel> datalist;
    ArrayList<pendingListModel> searchList;

    public jsonAdapterBH(ArrayList<pendingListModel> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
        this.searchList = new ArrayList<>(datalist);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        TextView fillEF;
        TextView serialText;
        TextView uncollectable;

        public ViewHolder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_pending_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_pending_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_pending_sir);
            this.fillEF = (TextView) itemView.findViewById(R.id.fill_pending_sir);
            this.uncollectable = (TextView) itemView.findViewById(R.id.uncollectable_pending_sir);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_list_sir_items_bh, parent, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final pendingListModel pendinglistmodel = this.datalist.get(i);
        viewHolder.EpicText.setText(pendinglistmodel.getEpicNo());
        viewHolder.serialText.setText(pendinglistmodel.getSerialNo());
        viewHolder.NameText.setText(pendinglistmodel.getName());
        Log.d("Adapter", "Binding" + pendinglistmodel.getEpicNo());
        viewHolder.fillEF.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.jsonAdapterBH.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(jsonAdapterBH.this.context, (Class<?>) specialRevisionActivityBH.class);
                intent.putExtra("epic", pendinglistmodel.getEpicNo());
                jsonAdapterBH.this.context.startActivity(intent);
            }
        });
        viewHolder.uncollectable.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.jsonAdapterBH.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(jsonAdapterBH.this.context, (Class<?>) UncollectableSIRBH.class);
                intent.putExtra("epic", pendinglistmodel.getEpicNo());
                intent.putExtra("psl", pendinglistmodel.getSerialNo());
                intent.putExtra("flag", "PL");
                jsonAdapterBH.this.context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.datalist.size();
    }

    public void fun(ArrayList<pendingListModel> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }
}
