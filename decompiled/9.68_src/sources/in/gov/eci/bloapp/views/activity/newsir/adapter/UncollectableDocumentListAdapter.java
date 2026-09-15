package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickUnCollectedDocumentCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.UncollectedDocumentPayload;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UncollectableDocumentListAdapter extends RecyclerView.Adapter<holder> {
    ItemClickUnCollectedDocumentCallback callback;
    private Context context;
    ArrayList<UncollectedDocumentPayload> datalist;
    ArrayList<UncollectedDocumentPayload> searchList;

    public UncollectableDocumentListAdapter(ArrayList<UncollectedDocumentPayload> datalist, Context context, ItemClickUnCollectedDocumentCallback callback) {
        this.datalist = datalist;
        this.context = context;
        this.searchList = new ArrayList<>(datalist);
        this.callback = callback;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.uncollected_document_item, viewGroup, false));
    }

    public void onBindViewHolder(holder viewHolder, int i) {
        final UncollectedDocumentPayload uncollectedDocumentPayload = this.datalist.get(i);
        viewHolder.EpicText.setText(uncollectedDocumentPayload.getEpicNo());
        viewHolder.serialText.setText(String.valueOf(uncollectedDocumentPayload.getPartSerialNo()));
        viewHolder.NameText.setText(uncollectedDocumentPayload.getName());
        viewHolder.fillEF.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.UncollectableDocumentListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        viewHolder.uncollectable.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.UncollectableDocumentListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(uncollectedDocumentPayload, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(UncollectedDocumentPayload uncollectedDocumentPayload, View view) {
        this.callback.onClicked(uncollectedDocumentPayload, "editDetais");
    }

    public int getItemCount() {
        return this.datalist.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        LinearLayout epicMatchLL;
        TextView fillEF;
        LinearLayout pendingLL;
        TextView serialText;
        TextView uncollectable;

        public holder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_pending_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_pending_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_pending_sir);
            this.fillEF = (TextView) itemView.findViewById(R.id.fill_pending_sir);
            this.uncollectable = (TextView) itemView.findViewById(R.id.uncollectable_pending_sir);
        }
    }

    public void fun(ArrayList<UncollectedDocumentPayload> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }
}
