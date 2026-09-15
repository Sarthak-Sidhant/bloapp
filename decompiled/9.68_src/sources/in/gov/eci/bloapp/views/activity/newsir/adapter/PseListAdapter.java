package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.VoterForms;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallbackPse;
import in.gov.eci.bloapp.views.activity.newsir.model.PseVerifyPayload;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PseListAdapter extends RecyclerView.Adapter<holder> {
    List<PseVerifyPayload> al;
    private Context context;
    List<PseVerifyPayload> filteredAl;
    FragmentManager fragmentManager;
    ItemClickCallbackPse itemClickCallback;

    public PseListAdapter(List<PseVerifyPayload> al, Context context, FragmentManager fragmentManager, ItemClickCallbackPse itemClickCallback) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.itemClickCallback = itemClickCallback;
        this.fragmentManager = fragmentManager;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dse_verification_item, viewGroup, false));
    }

    public void onBindViewHolder(final holder holder2, int i) {
        holder2.epic.setText(this.al.get(i).getEpicNo());
        holder2.serialNo.setText(String.valueOf(this.al.get(i).getPartSerialNo()));
        holder2.electorName.setText(this.al.get(i).getEpicName());
        holder2.tv_clusterid.setText(String.valueOf(this.al.get(i).getPseClusterId()));
        holder2.noAction.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.PseListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = holder2.getAdapterPosition();
                PseListAdapter.this.itemClickCallback.onClicked(PseListAdapter.this.al.get(adapterPosition), adapterPosition + "");
            }
        });
        holder2.view_details_elector.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.PseListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PseListAdapter.this.itemClickCallback.onClicked(PseListAdapter.this.al.get(holder2.getAdapterPosition()), "viewdetails");
            }
        });
        holder2.fill_form_dseVerified.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.PseListAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int adapterPosition = holder2.getAdapterPosition();
                Intent intent = new Intent(PseListAdapter.this.context, (Class<?>) VoterForms.class);
                intent.putExtra("flag", "PseVerified");
                intent.putExtra("epic", PseListAdapter.this.al.get(adapterPosition).getEpicNo());
                intent.putExtra("epicId", PseListAdapter.this.al.get(adapterPosition).getPseId());
                PseListAdapter.this.context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.al.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView acName;
        TextView address;
        LinearLayout cardViewLL;
        TextView category_type_label;
        TextView electorName;
        TextView epic;
        TextView fill_form_dseVerified;
        LinearLayout ll_deceased;
        LinearLayout ll_eightyfive;
        LinearLayout lv_asd;
        LinearLayout lv_cluster;
        LinearLayout lv_eightfive;
        TextView noAction;
        TextView partNo;
        TextView serialNo;
        TextView state;
        TextView tv_asd;
        TextView tv_clusterid;
        TextView view_details_elector;

        public holder(View itemView) {
            super(itemView);
            this.electorName = (TextView) itemView.findViewById(R.id.electorName);
            this.epic = (TextView) itemView.findViewById(R.id.epic);
            this.address = (TextView) itemView.findViewById(R.id.address);
            this.serialNo = (TextView) itemView.findViewById(R.id.serialNo);
            this.partNo = (TextView) itemView.findViewById(R.id.partNo);
            this.acName = (TextView) itemView.findViewById(R.id.acName);
            this.state = (TextView) itemView.findViewById(R.id.state);
            this.category_type_label = (TextView) itemView.findViewById(R.id.category_type_label);
            this.tv_asd = (TextView) itemView.findViewById(R.id.tv_asd);
            this.noAction = (TextView) itemView.findViewById(R.id.noAction);
            this.tv_clusterid = (TextView) itemView.findViewById(R.id.tv_clusterid);
            this.view_details_elector = (TextView) itemView.findViewById(R.id.view_details_elector);
            this.cardViewLL = (LinearLayout) itemView.findViewById(R.id.cardViewLL);
            this.ll_deceased = (LinearLayout) itemView.findViewById(R.id.ll_deceased);
            this.lv_asd = (LinearLayout) itemView.findViewById(R.id.lv_asd);
            this.lv_eightfive = (LinearLayout) itemView.findViewById(R.id.lv_eightfive);
            this.lv_cluster = (LinearLayout) itemView.findViewById(R.id.lv_cluster);
            this.fill_form_dseVerified = (TextView) itemView.findViewById(R.id.fill_form_dseVerified);
        }
    }

    public void fun(ArrayList<PseVerifyPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }

    private void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = this.fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
