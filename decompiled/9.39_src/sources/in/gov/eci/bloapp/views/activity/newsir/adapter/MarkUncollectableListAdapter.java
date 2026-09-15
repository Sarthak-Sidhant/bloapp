package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class MarkUncollectableListAdapter extends RecyclerView.Adapter<holder> {
    ItemClickCallback callback;
    private Context context;
    ArrayList<VerifyPayload> datalist;
    ArrayList<VerifyPayload> searchList;

    public MarkUncollectableListAdapter(ArrayList<VerifyPayload> datalist, Context context, ItemClickCallback callback) {
        this.datalist = datalist;
        this.context = context;
        this.searchList = new ArrayList<>(datalist);
        this.callback = callback;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sentback_ero_list_sir_items, viewGroup, false));
    }

    public void onBindViewHolder(holder viewHolder, int i) {
        final VerifyPayload verifyPayload = this.datalist.get(i);
        viewHolder.EpicText.setText(verifyPayload.getEpicNo());
        viewHolder.serialText.setText(String.valueOf(verifyPayload.getPartSerialNo()));
        viewHolder.NameText.setText(verifyPayload.getEpicName());
        viewHolder.remark.setText(TextUtils.isEmpty(verifyPayload.getBackToBloRemarks()) ? "" : verifyPayload.getBackToBloRemarks());
        viewHolder.pendingLL.setBackgroundColor(Color.parseColor("#F2EFFC"));
        viewHolder.fillEF.setVisibility(0);
        viewHolder.uncollectable.setVisibility(0);
        viewHolder.uncollectable.setText(this.context.getText(R.string.blo_Edit_details));
        viewHolder.epicMatchLL.setVisibility(8);
        if (SharedPref.getInstance(this.context.getApplicationContext()).getPendingElectors().equalsIgnoreCase("Y")) {
            viewHolder.fillEF.setVisibility(0);
        } else {
            viewHolder.fillEF.setVisibility(8);
        }
        viewHolder.fillEF.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.MarkUncollectableListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MarkUncollectableListAdapter.this.callback.onClicked(verifyPayload, "filForm");
            }
        });
        viewHolder.uncollectable.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.MarkUncollectableListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(verifyPayload, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(VerifyPayload verifyPayload, View view) {
        this.callback.onClicked(verifyPayload, "editDetais");
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
        TextView remark;
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
            this.remark = (TextView) itemView.findViewById(R.id.remark);
        }
    }

    public void fun(ArrayList<VerifyPayload> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }
}
