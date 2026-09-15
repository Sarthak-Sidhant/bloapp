package in.gov.eci.bloapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.views.activity.newsir.model.ATPayload;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.ActivityNoticeUploadReceipt;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ATListAdapter extends RecyclerView.Adapter<ViewHolder> {
    int acNo;
    private String atkband;
    private Context context;
    ArrayList<ATPayload> datalist;
    private String rtkband;
    ArrayList<ATPayload> searchList;
    UserClient service;
    private String state;
    private String token;

    public ATListAdapter(ArrayList<ATPayload> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
        this.searchList = new ArrayList<>(datalist);
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
        final ATPayload aTPayload = this.datalist.get(i);
        viewHolder.EpicText.setText(aTPayload.getUserEpic());
        viewHolder.serialText.setText(String.valueOf(aTPayload.getPartSerialNo()));
        viewHolder.NameText.setText(aTPayload.getComplainantName());
        if (TextUtils.isEmpty(this.datalist.get(i).getBloNoticeDelivered())) {
            viewHolder.uploadReceipt.setText(R.string.notice_mark_delievered);
        } else if (this.datalist.get(i).getBloNoticeDelivered().equalsIgnoreCase("1")) {
            viewHolder.uploadReceipt.setText(R.string.viewDetailsSingleRow);
        }
        viewHolder.uploadReceipt.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.ATListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(ATListAdapter.this.context, (Class<?>) ActivityNoticeUploadReceipt.class);
                intent.putExtra("acNo", ATListAdapter.this.acNo);
                intent.putExtra("partNo", aTPayload.getPartNo());
                intent.putExtra("partSerialNo", String.valueOf(aTPayload.getPartSerialNo()));
                intent.putExtra("epicNo", aTPayload.getUserEpic());
                intent.putExtra("complaintId", aTPayload.getComplaintId());
                intent.putExtra("bloNoticeDeliveredReceipDoc", aTPayload.getBloNoticeDeliveredReceiptDoc());
                intent.putExtra("noticeGeneratedDoc", aTPayload.getNoticeGeneratedDoc());
                intent.putExtra("noticeDelivered", aTPayload.getBloNoticeDelivered());
                ATListAdapter.this.context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.datalist.size();
    }

    public void fun(ArrayList<ATPayload> filteredAl) {
        this.datalist = filteredAl;
        notifyDataSetChanged();
    }
}
