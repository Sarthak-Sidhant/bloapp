package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SystemMappedAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    List<MappingList> items;
    private OnItemSelectedListener listener;

    public interface OnItemSelectedListener {
        void onItemSelected();
    }

    public SystemMappedAdapter(Context context, List<MappingList> items, OnItemSelectedListener listener) {
        this.items = items;
        this.listener = listener;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fatherAc;
        TextView fatherEpic;
        TextView fatherName;
        TextView fatherPart;
        TextView grandparentAc;
        TextView grandparentEpic;
        TextView grandparentName;
        TextView grandparentPart;
        ImageView icon;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            this.icon = (ImageView) itemView.findViewById(2131364119);
            this.fatherName = (TextView) itemView.findViewById(R.id.tv_name);
            this.fatherEpic = (TextView) itemView.findViewById(R.id.tv_epic);
            this.fatherAc = (TextView) itemView.findViewById(R.id.tv_ac);
            this.fatherPart = (TextView) itemView.findViewById(R.id.tv_part);
            this.grandparentName = (TextView) itemView.findViewById(R.id.tv_name1);
            this.grandparentEpic = (TextView) itemView.findViewById(R.id.tv_epic1);
            this.grandparentAc = (TextView) itemView.findViewById(R.id.tv_ac1);
            this.grandparentPart = (TextView) itemView.findViewById(R.id.tv_part1);
            this.title = (TextView) itemView.findViewById(R.id.title_tv);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.SystemMappedAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            int i = 0;
            while (true) {
                if (i >= SystemMappedAdapter.this.items.size()) {
                    i = -1;
                    break;
                } else {
                    if (SystemMappedAdapter.this.items.get(i).isSelected()) {
                        SystemMappedAdapter.this.items.get(i).setSelected(false);
                        break;
                    }
                    i++;
                }
            }
            SystemMappedAdapter.this.items.get(getAdapterPosition()).setSelected(true);
            if (i != -1) {
                SystemMappedAdapter.this.notifyItemChanged(i);
            }
            SystemMappedAdapter.this.notifyItemChanged(getAdapterPosition());
            SystemMappedAdapter.this.listener.onItemSelected();
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_system_mapped, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        MappingList mappingList = this.items.get(position);
        holder.fatherName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
        holder.fatherEpic.setText(TextUtils.isEmpty(mappingList.getOldEpicNumber()) ? "" : mappingList.getOldEpicNumber());
        holder.fatherAc.setText(mappingList.getOldAcName());
        holder.fatherPart.setText(mappingList.getOldPartName());
        holder.grandparentName.setText(mappingList.getOldRelativeFullName());
        holder.title.setText(this.context.getString(R.string.progeny_2003) + SharedPref.getInstance(this.context).getlastSIRYear());
        holder.icon.setImageResource(mappingList.isSelected() ? R.drawable.inactive_radio : R.drawable.active_radio);
    }

    public int getItemCount() {
        return this.items.size();
    }
}
