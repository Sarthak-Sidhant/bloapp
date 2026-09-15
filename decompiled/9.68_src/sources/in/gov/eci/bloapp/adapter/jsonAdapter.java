package in.gov.eci.bloapp.adapter;

import android.app.Activity;
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
import in.gov.eci.bloapp.model.SIR.pendingListModel;
import in.gov.eci.bloapp.views.activity.newsir.activity.EFTabActivity;
import in.gov.eci.bloapp.views.activity.sir.UncollectableSIR;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class jsonAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    ArrayList<pendingListModel> datalist;
    private List<String> savedEPicNo = new ArrayList();
    ArrayList<pendingListModel> searchList;

    public jsonAdapter(ArrayList<pendingListModel> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
        this.searchList = new ArrayList<>(datalist);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        LinearLayout epicMatchLL;
        TextView fillEF;
        LinearLayout pendingLL;
        TextView serialText;
        TextView uncollectable;

        public ViewHolder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_pending_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_pending_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_pending_sir);
            this.fillEF = (TextView) itemView.findViewById(R.id.fill_pending_sir);
            this.uncollectable = (TextView) itemView.findViewById(R.id.uncollectable_pending_sir);
            this.pendingLL = (LinearLayout) itemView.findViewById(R.id.pendingLL);
            this.epicMatchLL = (LinearLayout) itemView.findViewById(R.id.epicMatchedPending);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_list_sir_items, parent, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final pendingListModel pendinglistmodel = this.datalist.get(i);
        viewHolder.EpicText.setText(pendinglistmodel.getEpicNo());
        viewHolder.serialText.setText(pendinglistmodel.getSerialNo());
        viewHolder.NameText.setText(pendinglistmodel.getName());
        viewHolder.pendingLL.setBackgroundColor(Color.parseColor("#F2EFFC"));
        viewHolder.fillEF.setVisibility(0);
        viewHolder.uncollectable.setVisibility(0);
        if (pendinglistmodel.getEpicMatch() == 1) {
            viewHolder.epicMatchLL.setVisibility(0);
        } else {
            viewHolder.epicMatchLL.setVisibility(8);
        }
        viewHolder.fillEF.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.jsonAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(jsonAdapter.this.context, (Class<?>) EFTabActivity.class);
                intent.putExtra("epic", pendinglistmodel.getEpicNo());
                intent.putExtra("psl", pendinglistmodel.getSerialNo());
                intent.putExtra("epicId", pendinglistmodel.getEpicId());
                intent.putExtra("electorname", pendinglistmodel.getName());
                intent.putExtra("relativefullname", pendinglistmodel.getRelativeFullName());
                intent.putExtra("relatiiontype", pendinglistmodel.getRelationType());
                intent.putExtra("age", pendinglistmodel.getAge());
                intent.putExtra("ac", pendinglistmodel.getAcNo());
                intent.putExtra("part", pendinglistmodel.getPartNo());
                intent.putExtra("gender", pendinglistmodel.getGender());
                intent.putExtra("dob", pendinglistmodel.getDob());
                intent.putExtra("state", pendinglistmodel.getState());
                intent.putExtra("ac", pendinglistmodel.getAcNo());
                intent.putExtra("part", pendinglistmodel.getPartNo());
                intent.putExtra("from", "pendingelector");
                jsonAdapter.this.context.startActivity(intent);
            }
        });
        viewHolder.uncollectable.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.jsonAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(pendinglistmodel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(pendingListModel pendinglistmodel, View view) {
        Intent intent = new Intent(this.context, (Class<?>) UncollectableSIR.class);
        intent.putExtra("epic", pendinglistmodel.getEpicNo());
        intent.putExtra("psl", pendinglistmodel.getSerialNo());
        intent.putExtra("epicId", pendinglistmodel.getEpicId());
        intent.putExtra("flag", "PL");
        intent.putExtra("from", "pendingelector");
        this.context.startActivity(intent);
        ((Activity) this.context).finish();
    }

    public void setEpicList(List<String> savedEpic) {
        this.savedEPicNo = savedEpic;
    }

    public int getItemCount() {
        return this.datalist.size();
    }

    public void fun(ArrayList<pendingListModel> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }
}
