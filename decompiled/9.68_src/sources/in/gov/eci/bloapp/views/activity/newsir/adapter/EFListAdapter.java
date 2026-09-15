package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.newsir.callback.fillEFCallBack;
import in.gov.eci.bloapp.views.activity.newsir.model.EFPayload;
import in.gov.eci.bloapp.views.activity.sir.UncollectableSIR;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class EFListAdapter extends RecyclerView.Adapter<holder> {
    fillEFCallBack callback;
    private Context context;
    ArrayList<EFPayload> datalist;
    ArrayList<EFPayload> searchList;

    public EFListAdapter(ArrayList<EFPayload> datalist, Context context, fillEFCallBack callback) {
        this.datalist = datalist;
        this.context = context;
        this.searchList = new ArrayList<>(datalist);
        this.callback = callback;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pending_list_sir_items, viewGroup, false));
    }

    public void onBindViewHolder(holder viewHolder, int i) {
        final EFPayload eFPayload = this.datalist.get(i);
        viewHolder.EpicText.setText(eFPayload.getEpicNo());
        viewHolder.serialText.setText(String.valueOf(eFPayload.getPartSerialNo()));
        viewHolder.NameText.setText(eFPayload.getName());
        viewHolder.pendingLL.setBackgroundColor(Color.parseColor("#F2EFFC"));
        viewHolder.fillEF.setVisibility(0);
        viewHolder.uncollectable.setVisibility(0);
        if (eFPayload.getEpicMatch() == 1) {
            viewHolder.epicMatchLL.setVisibility(0);
        } else {
            viewHolder.epicMatchLL.setVisibility(8);
        }
        viewHolder.fillEF.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.EFListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EFListAdapter.this.callback.onFillEFClicked(eFPayload, "fill");
            }
        });
        viewHolder.uncollectable.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.EFListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(eFPayload, view);
            }
        });
        viewHolder.call.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.EFListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EFListAdapter.this.callback.onFillEFClicked(eFPayload, "call");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(EFPayload eFPayload, View view) {
        Intent intent = new Intent(this.context, (Class<?>) UncollectableSIR.class);
        intent.putExtra("epic", eFPayload.getEpicNo());
        intent.putExtra("psl", eFPayload.getPartSerialNo());
        intent.putExtra("epicId", eFPayload.getEpicId());
        intent.putExtra("flag", "PL");
        intent.putExtra("from", "pendingelector");
        this.context.startActivity(intent);
    }

    public int getItemCount() {
        return this.datalist.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        TextView call;
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
            this.pendingLL = (LinearLayout) itemView.findViewById(R.id.pendingLL);
            this.epicMatchLL = (LinearLayout) itemView.findViewById(R.id.epicMatchedPending);
            this.call = (TextView) itemView.findViewById(R.id.call);
        }
    }

    public void fun(ArrayList<EFPayload> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }
}
