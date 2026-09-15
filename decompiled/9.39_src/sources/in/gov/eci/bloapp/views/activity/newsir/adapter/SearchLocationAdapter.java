package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SearchLocationAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    private List<MappingList> items;
    private OnItemSelectedListener listener;

    public interface OnItemSelectedListener {
        void onItemSelected();
    }

    public SearchLocationAdapter(Context context, List<MappingList> items, OnItemSelectedListener listener) {
        this.items = items;
        this.listener = listener;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView electorNameTitle;
        TextView electorNameTitlev1;
        ImageView icon;
        LinearLayout lvVernacularName;
        LinearLayout relativeNameV1;
        TextView tvAcName;
        TextView tvDistrictName;
        TextView tvElectorName;
        TextView tvElectorNamev1;
        TextView tvOldAge;
        TextView tvPartName;
        TextView tvRelativeName;
        TextView tvRelativeNamev1;
        TextView tvRelativeType;
        TextView tvSerialName;
        TextView tvStateName;
        TextView tv_old_epic;
        TextView tv_section_name;

        public ViewHolder(View itemView) {
            super(itemView);
            this.icon = (ImageView) itemView.findViewById(2131364119);
            this.tvElectorName = (TextView) itemView.findViewById(R.id.tv_elector_name);
            this.tvStateName = (TextView) itemView.findViewById(R.id.tv_state_name);
            this.tvAcName = (TextView) itemView.findViewById(R.id.tv_ac_name);
            this.tvPartName = (TextView) itemView.findViewById(R.id.tv_part_name);
            this.tvSerialName = (TextView) itemView.findViewById(R.id.tv_serial_name);
            this.tvRelativeName = (TextView) itemView.findViewById(R.id.tv_relative_name);
            this.tvRelativeType = (TextView) itemView.findViewById(R.id.tv_relative_type);
            this.electorNameTitle = (TextView) itemView.findViewById(R.id.electorNameCardDisable);
            this.tvDistrictName = (TextView) itemView.findViewById(R.id.tv_district_name);
            this.tvOldAge = (TextView) itemView.findViewById(R.id.tv_old_age);
            this.tv_old_epic = (TextView) itemView.findViewById(R.id.tv_old_epic);
            this.electorNameTitlev1 = (TextView) itemView.findViewById(R.id.electorNameCardDisablev1);
            this.tvRelativeNamev1 = (TextView) itemView.findViewById(R.id.tv_relative_namev1);
            this.tvElectorNamev1 = (TextView) itemView.findViewById(R.id.tv_elector_namev1);
            this.tv_section_name = (TextView) itemView.findViewById(R.id.tv_section_name);
            this.lvVernacularName = (LinearLayout) itemView.findViewById(R.id.lvVernacularName);
            this.relativeNameV1 = (LinearLayout) itemView.findViewById(R.id.relativeNameV1);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.SearchLocationAdapter$ViewHolder$$ExternalSyntheticLambda0
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
                if (i >= SearchLocationAdapter.this.items.size()) {
                    i = -1;
                    break;
                } else {
                    if (((MappingList) SearchLocationAdapter.this.items.get(i)).isSelected()) {
                        ((MappingList) SearchLocationAdapter.this.items.get(i)).setSelected(false);
                        break;
                    }
                    i++;
                }
            }
            ((MappingList) SearchLocationAdapter.this.items.get(getAdapterPosition())).setSelected(true);
            if (i != -1) {
                SearchLocationAdapter.this.notifyItemChanged(i);
            }
            SearchLocationAdapter.this.notifyItemChanged(getAdapterPosition());
            SearchLocationAdapter.this.listener.onItemSelected();
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progeny_mapping_list, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        MappingList mappingList = this.items.get(position);
        holder.tvStateName.setText(mappingList.getOldStateName());
        holder.tvAcName.setText(String.valueOf(mappingList.getOldAcNo()) + " - " + (TextUtils.isEmpty(mappingList.getOldAcName()) ? "" : mappingList.getOldAcName()));
        holder.tvPartName.setText(String.valueOf(mappingList.getOldPartNumber()) + " - " + (TextUtils.isEmpty(mappingList.getOldPartName()) ? "" : mappingList.getOldPartName()));
        holder.tvDistrictName.setText(String.valueOf(mappingList.getOldDistNo()) + " - " + (TextUtils.isEmpty(mappingList.getOldDistName()) ? "" : mappingList.getOldDistName()));
        holder.tvSerialName.setText(String.valueOf(mappingList.getOldPartSerialNo()));
        holder.tvOldAge.setText(String.valueOf(mappingList.getAge()));
        holder.tv_old_epic.setText(TextUtils.isEmpty(mappingList.getOldEpicNumber()) ? "" : mappingList.getOldEpicNumber());
        if (!TextUtils.isEmpty(mappingList.getRelationType())) {
            String relationType = mappingList.getRelationType();
            if (relationType.equalsIgnoreCase("F") || relationType.equalsIgnoreCase("FATHER") || relationType.equalsIgnoreCase("FTHR")) {
                holder.tvRelativeType.setText("Father");
            } else if (relationType.equalsIgnoreCase("M") || relationType.equalsIgnoreCase("MOTHER") || relationType.equalsIgnoreCase("MTHR")) {
                holder.tvRelativeType.setText("Mother");
            } else if (relationType.equalsIgnoreCase("H") || relationType.equalsIgnoreCase("HUSBAND") || relationType.equalsIgnoreCase("HSBN")) {
                holder.tvRelativeType.setText("Husband");
            } else if (relationType.equalsIgnoreCase("W") || relationType.equalsIgnoreCase("WIFE")) {
                holder.tvRelativeType.setText("Wife");
            } else if (relationType.equalsIgnoreCase("L") || relationType.equalsIgnoreCase("OTHER") || relationType.equalsIgnoreCase("O")) {
                holder.tvRelativeType.setText("Other");
            } else if (relationType.equalsIgnoreCase("GMTH")) {
                holder.tvRelativeType.setText("Grand Mother");
            } else if (relationType.equalsIgnoreCase("GFTH")) {
                holder.tvRelativeType.setText("Grand Father");
            } else {
                holder.tvRelativeType.setText(relationType);
            }
        }
        holder.icon.setImageResource(mappingList.isSelected() ? R.drawable.inactive_radio : R.drawable.active_radio);
        if (TextUtils.isEmpty(mappingList.getOldFullName()) && !TextUtils.isEmpty(mappingList.getOldFullNameL1())) {
            holder.tvElectorName.setText(TextUtils.isEmpty(mappingList.getOldFullNameL1()) ? "" : mappingList.getOldFullNameL1());
            holder.lvVernacularName.setVisibility(8);
        } else if (TextUtils.isEmpty(mappingList.getOldFullNameL1())) {
            holder.tvElectorName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
            holder.lvVernacularName.setVisibility(8);
        } else if (mappingList.getOldFullName().equalsIgnoreCase(mappingList.getOldFullNameL1())) {
            holder.tvElectorName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
            holder.lvVernacularName.setVisibility(8);
        } else {
            holder.tvElectorName.setText(TextUtils.isEmpty(mappingList.getOldFullName()) ? "" : mappingList.getOldFullName());
            holder.tvElectorNamev1.setText(TextUtils.isEmpty(mappingList.getOldFullNameL1()) ? "" : mappingList.getOldFullNameL1());
        }
        if (TextUtils.isEmpty(mappingList.getOldRelativeFullName()) && !TextUtils.isEmpty(mappingList.getOldRelativeFullNameL1())) {
            holder.tvRelativeName.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullNameL1()) ? "" : mappingList.getOldRelativeFullNameL1());
            holder.relativeNameV1.setVisibility(8);
        } else if (TextUtils.isEmpty(mappingList.getOldRelativeFullNameL1())) {
            holder.tvRelativeName.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullName()) ? "" : mappingList.getOldRelativeFullName());
            holder.relativeNameV1.setVisibility(8);
        } else if (mappingList.getOldRelativeFullName().equalsIgnoreCase(mappingList.getOldRelativeFullNameL1())) {
            holder.tvRelativeName.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullName()) ? "" : mappingList.getOldRelativeFullName());
            holder.relativeNameV1.setVisibility(8);
        } else {
            holder.tvRelativeName.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullName()) ? "" : mappingList.getOldRelativeFullName());
            holder.tvRelativeNamev1.setText(TextUtils.isEmpty(mappingList.getOldRelativeFullNameL1()) ? "" : mappingList.getOldRelativeFullNameL1());
        }
        holder.tv_section_name.setText(TextUtils.isEmpty(mappingList.getSectionNo()) ? "" : mappingList.getSectionNo());
    }

    public int getItemCount() {
        return this.items.size();
    }
}
