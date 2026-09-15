package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.callback.AnomalyDetailsClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.AnomalyDetailsPayload;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class AnomalyDetailsListAdapter extends RecyclerView.Adapter<holder> {
    private String acNo;
    List<AnomalyDetailsPayload> al;
    private String atkband;
    CommomUtility commonUtilClass = new CommomUtility();
    private Context context;
    private String encodedImage;
    List<AnomalyDetailsPayload> filteredAl;
    AnomalyDetailsClickCallback itemClickCallback;
    private String partNo;
    private String rtkband;
    private String token;

    public AnomalyDetailsListAdapter(List<AnomalyDetailsPayload> al, Context context, AnomalyDetailsClickCallback itemClickCallback) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.itemClickCallback = itemClickCallback;
        this.token = SharedPref.getInstance(context).getToken();
        this.atkband = SharedPref.getInstance(context).getAtknBnd();
        this.rtkband = SharedPref.getInstance(context).getRtknBnd();
        this.acNo = SharedPref.getInstance(context).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(context).getPartNumber();
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.anomaly_details_items, viewGroup, false));
    }

    public void onBindViewHolder(holder holder2, final int i) {
        final AnomalyDetailsPayload anomalyDetailsPayload = this.al.get(i);
        if (!TextUtils.isEmpty(anomalyDetailsPayload.getWrongCate()) && anomalyDetailsPayload.getWrongCate().equalsIgnoreCase("N")) {
            holder2.lv_wrongCate.setVisibility(8);
        } else {
            holder2.lv_wrongCate.setVisibility(0);
            holder2.tv_wrongCate.setText(anomalyDetailsPayload.getWrongCate());
        }
        if (!TextUtils.isEmpty(anomalyDetailsPayload.getMappedMultiGender()) && anomalyDetailsPayload.getMappedMultiGender().equalsIgnoreCase("N")) {
            holder2.lv_mappedMultiGender.setVisibility(8);
        } else {
            holder2.lv_mappedMultiGender.setVisibility(0);
            holder2.tv_mappedMultiGender.setText(anomalyDetailsPayload.getMappedMultiGender());
        }
        if (!TextUtils.isEmpty(anomalyDetailsPayload.getRelativeAgeIssue()) && anomalyDetailsPayload.getRelativeAgeIssue().equalsIgnoreCase("N")) {
            holder2.lv_relativeAgeIssue.setVisibility(8);
        } else {
            holder2.lv_relativeAgeIssue.setVisibility(0);
            holder2.tv_relativeAgeIssue.setText(anomalyDetailsPayload.getRelativeAgeIssue());
        }
        if (!TextUtils.isEmpty(anomalyDetailsPayload.getParentNameMismatch()) && anomalyDetailsPayload.getParentNameMismatch().equalsIgnoreCase("N")) {
            holder2.lv_parentNameMismatch.setVisibility(8);
        } else {
            holder2.lv_parentNameMismatch.setVisibility(0);
            holder2.tv_parentNameMismatch.setText(anomalyDetailsPayload.getParentNameMismatch());
        }
        if (!TextUtils.isEmpty(anomalyDetailsPayload.getProgLimitExceed()) && anomalyDetailsPayload.getProgLimitExceed().equalsIgnoreCase("N")) {
            holder2.call.setVisibility(8);
        } else {
            holder2.call.setVisibility(0);
        }
        holder2.call.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.AnomalyDetailsListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnomalyDetailsListAdapter.this.itemClickCallback.onClicked(anomalyDetailsPayload, "View progeny", i);
            }
        });
        holder2.uncollectable_pending_sir.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.AnomalyDetailsListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnomalyDetailsListAdapter.this.itemClickCallback.onClicked(anomalyDetailsPayload, "edit details", i);
            }
        });
        holder2.fill_pending_sir.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.AnomalyDetailsListAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnomalyDetailsListAdapter.this.itemClickCallback.onClicked(anomalyDetailsPayload, "No Action", i);
            }
        });
    }

    public int getItemCount() {
        return this.al.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView call;
        TextView fill_pending_sir;
        LinearLayout lv_mappedMultiGender;
        LinearLayout lv_parentNameMismatch;
        LinearLayout lv_relativeAgeIssue;
        LinearLayout lv_wrongCate;
        TextView tv_mappedMultiGender;
        TextView tv_parentNameMismatch;
        TextView tv_relativeAgeIssue;
        TextView tv_wrongCate;
        TextView uncollectable_pending_sir;

        public holder(View itemView) {
            super(itemView);
            this.uncollectable_pending_sir = (TextView) itemView.findViewById(R.id.uncollectable_pending_sir);
            this.fill_pending_sir = (TextView) itemView.findViewById(R.id.fill_pending_sir);
            this.call = (TextView) itemView.findViewById(R.id.call);
            this.tv_wrongCate = (TextView) itemView.findViewById(R.id.tv_wrongCate);
            this.tv_parentNameMismatch = (TextView) itemView.findViewById(R.id.tv_parentNameMismatch);
            this.tv_relativeAgeIssue = (TextView) itemView.findViewById(R.id.tv_relativeAgeIssue);
            this.tv_mappedMultiGender = (TextView) itemView.findViewById(R.id.tv_mappedMultiGender);
            this.lv_wrongCate = (LinearLayout) itemView.findViewById(R.id.lv_wrongCate);
            this.lv_parentNameMismatch = (LinearLayout) itemView.findViewById(R.id.lv_parentNameMismatch);
            this.lv_relativeAgeIssue = (LinearLayout) itemView.findViewById(R.id.lv_relativeAgeIssue);
            this.lv_mappedMultiGender = (LinearLayout) itemView.findViewById(R.id.lv_mappedMultiGender);
        }
    }

    public void fun(ArrayList<AnomalyDetailsPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
