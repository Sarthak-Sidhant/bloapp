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
import in.gov.eci.bloapp.model.SIR.RollbackNewModel;
import in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRoldBH;
import in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SentbackNewFormAdapterBH extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    ArrayList<RollbackNewModel> datalist;
    ArrayList<RollbackNewModel> filteredAl;

    public SentbackNewFormAdapterBH(ArrayList<RollbackNewModel> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
        this.filteredAl = new ArrayList<>(datalist);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        TextView fillEF;
        TextView remarks;
        TextView serialText;
        TextView uncollectable;

        public ViewHolder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_pending_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_pending_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_pending_sir);
            this.remarks = (TextView) itemView.findViewById(R.id.remarks);
            this.fillEF = (TextView) itemView.findViewById(R.id.fill_pending_sir);
            this.uncollectable = (TextView) itemView.findViewById(R.id.uncollectable_pending_sir);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sentback_new_item_list, parent, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final RollbackNewModel rollbackNewModel = this.datalist.get(i);
        viewHolder.EpicText.setText(rollbackNewModel.getEpicNo());
        viewHolder.serialText.setText(rollbackNewModel.getSerialNo());
        viewHolder.NameText.setText(rollbackNewModel.getName());
        viewHolder.remarks.setText(rollbackNewModel.getRemarks());
        Log.d("Adapter", "Binding" + rollbackNewModel.getEpicNo());
        viewHolder.fillEF.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.SentbackNewFormAdapterBH.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(SentbackNewFormAdapterBH.this.context, (Class<?>) specialRevisionActivityBH.class);
                intent.putExtra("epic", rollbackNewModel.getEpicNo());
                SentbackNewFormAdapterBH.this.context.startActivity(intent);
            }
        });
        viewHolder.uncollectable.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.SentbackNewFormAdapterBH.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(SentbackNewFormAdapterBH.this.context, (Class<?>) UncollectableSIRoldBH.class);
                intent.putExtra("epic", rollbackNewModel.getEpicNo());
                intent.putExtra("psl", rollbackNewModel.getSerialNo());
                intent.putExtra("flag", "GN");
                intent.putExtra("photoUrl1", rollbackNewModel.getEfFrontUrl());
                intent.putExtra("photoUrl2", rollbackNewModel.getEfBackUrl());
                intent.putExtra("photoUrl3", rollbackNewModel.getSuppDoc1Url());
                intent.putExtra("photoUrl4", rollbackNewModel.getSuppDoc2Url());
                intent.putExtra("reason", rollbackNewModel.getUncollectableReason());
                intent.putExtra("enrolledEpicNo", rollbackNewModel.getEnrolledEpicNo());
                SentbackNewFormAdapterBH.this.context.startActivity(intent);
            }
        });
    }

    public void fun(ArrayList<RollbackNewModel> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.datalist.size();
    }
}
