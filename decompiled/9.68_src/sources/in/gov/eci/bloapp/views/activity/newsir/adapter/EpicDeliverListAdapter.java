package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallbackEpic;
import in.gov.eci.bloapp.views.activity.newsir.model.VoterDataPayload;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class EpicDeliverListAdapter extends RecyclerView.Adapter<holder> {
    List<VoterDataPayload> al;
    private Context context;
    List<VoterDataPayload> filteredAl;
    ItemClickCallbackEpic itemClickCallback;

    public EpicDeliverListAdapter(List<VoterDataPayload> al, Context context, ItemClickCallbackEpic itemClickCallback) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.itemClickCallback = itemClickCallback;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.epic_deliver_item, viewGroup, false));
    }

    public void onBindViewHolder(final holder holder2, int i) {
        holder2.epic.setText(this.al.get(i).getEpicNumber());
        holder2.serialNo.setText(String.valueOf(this.al.get(i).getPartSerialNo()));
        holder2.electorName.setText(this.al.get(i).getApplicantName());
        holder2.srNo.setText(String.valueOf(i + 1));
        holder2.refId.setText(this.al.get(i).getReferenceNumber());
        holder2.markDelivered.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.EpicDeliverListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EpicDeliverListAdapter.this.itemClickCallback.onClicked(EpicDeliverListAdapter.this.al.get(holder2.getAdapterPosition()), "");
            }
        });
        holder2.assign_ero.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.EpicDeliverListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EpicDeliverListAdapter.this.itemClickCallback.onClicked(EpicDeliverListAdapter.this.al.get(holder2.getAdapterPosition()), "return");
            }
        });
    }

    public int getItemCount() {
        return this.al.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView assign_ero;
        LinearLayout cardViewLL;
        TextView electorName;
        TextView epic;
        TextView markDelivered;
        TextView refId;
        TextView serialNo;
        TextView srNo;

        public holder(View itemView) {
            super(itemView);
            this.electorName = (TextView) itemView.findViewById(R.id.epicElectorName);
            this.epic = (TextView) itemView.findViewById(R.id.epic_no_deliver);
            this.srNo = (TextView) itemView.findViewById(R.id.tv_srNo);
            this.serialNo = (TextView) itemView.findViewById(R.id.partSerialNo);
            this.refId = (TextView) itemView.findViewById(R.id.refID);
            this.markDelivered = (TextView) itemView.findViewById(R.id.epic_mark_deliver);
            this.assign_ero = (TextView) itemView.findViewById(R.id.assign_ero);
            this.cardViewLL = (LinearLayout) itemView.findViewById(R.id.cardViewLL);
        }
    }

    public void fun(ArrayList<VoterDataPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
