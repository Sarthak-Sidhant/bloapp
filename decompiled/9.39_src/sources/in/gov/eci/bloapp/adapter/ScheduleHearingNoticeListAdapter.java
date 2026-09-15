package in.gov.eci.bloapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.views.activity.newsir.model.HearingPayload;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityUploadReceipt;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ScheduleHearingNoticeListAdapter extends RecyclerView.Adapter<ViewHolder> {
    int acNo;
    private String atkband;
    private Context context;
    ArrayList<HearingPayload> datalist;
    private String rtkband;
    ArrayList<HearingPayload> searchList;
    UserClient service;
    private String state;
    private String token;

    public ScheduleHearingNoticeListAdapter(ArrayList<HearingPayload> datalist, Context context, String token, String state, String atkband, String rtkband, int acNo) {
        this.datalist = datalist;
        this.context = context;
        this.searchList = new ArrayList<>(datalist);
        this.token = token;
        this.state = state;
        this.atkband = atkband;
        this.rtkband = rtkband;
        this.acNo = acNo;
        this.service = (UserClient) ApiClient.getClient(context).create(UserClient.class);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        LinearLayout cardView;
        TextView serialText;
        TextView uploadReceipt;

        public ViewHolder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_pending_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_pending_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_pending_sir);
            this.uploadReceipt = (TextView) itemView.findViewById(R.id.upload_receipt);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_hearing_list_item, parent, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final HearingPayload hearingPayload = this.datalist.get(i);
        viewHolder.EpicText.setText(hearingPayload.getEpicNo());
        viewHolder.serialText.setText(String.valueOf(hearingPayload.getPartSerialNo()));
        viewHolder.NameText.setText(hearingPayload.getName());
        viewHolder.uploadReceipt.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ScheduleHearingNoticeListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleHearingNoticeListAdapter.this.context, (Class<?>) ActivityUploadReceipt.class);
                intent.putExtra("acNo", ScheduleHearingNoticeListAdapter.this.acNo);
                intent.putExtra("partSerialNo", String.valueOf(hearingPayload.getPartSerialNo()));
                intent.putExtra("epicNo", hearingPayload.getEpicNo());
                intent.putExtra("partNo", hearingPayload.getPartNo());
                intent.putExtra("epicid", hearingPayload.getEpicId());
                ScheduleHearingNoticeListAdapter.this.context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.datalist.size();
    }

    public void fun(ArrayList<HearingPayload> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }
}
