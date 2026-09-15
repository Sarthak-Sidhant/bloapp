package in.gov.eci.bloapp.views.activity.SIRBH.UncollectedEF;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.SIRBH.UncollectableSIRBH;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class UncollectedEFAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    ArrayList<UncollectedEFModel> datalist;
    ArrayList<UncollectedEFModel> searchList;

    public UncollectedEFAdapter(ArrayList<UncollectedEFModel> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView EpicText;
        TextView NameText;
        TextView serialText;
        TextView uncollectedefDoc;

        public ViewHolder(View itemView) {
            super(itemView);
            this.EpicText = (TextView) itemView.findViewById(R.id.epic_pending_sir);
            this.serialText = (TextView) itemView.findViewById(R.id.serialNo_pending_sir);
            this.NameText = (TextView) itemView.findViewById(R.id.electorName_pending_sir);
            this.uncollectedefDoc = (TextView) itemView.findViewById(R.id.uncollectabledef_doc);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.uncollectedef_list_sir_items, parent, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final UncollectedEFModel uncollectedEFModel = this.datalist.get(i);
        viewHolder.EpicText.setText(TextUtils.isEmpty(uncollectedEFModel.getEpicNo()) ? "NA" : uncollectedEFModel.getEpicNo());
        viewHolder.serialText.setText(uncollectedEFModel.getPartSerialNo());
        viewHolder.NameText.setText(uncollectedEFModel.getElectorName());
        Log.d("Adapter", "Binding" + uncollectedEFModel.getEpicNo());
        viewHolder.uncollectedefDoc.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.UncollectedEF.UncollectedEFAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(UncollectedEFAdapter.this.context, (Class<?>) UncollectableSIRBH.class);
                intent.putExtra("epic", uncollectedEFModel.getEpicNo());
                intent.putExtra("psl", uncollectedEFModel.getPartSerialNo());
                intent.putExtra("flag", "UN");
                intent.putExtra("reason", uncollectedEFModel.getUncollectableReason());
                intent.putExtra("enrolledEpic", uncollectedEFModel.getEnrolledEpicNo());
                UncollectedEFAdapter.this.context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.datalist.size();
    }
}
