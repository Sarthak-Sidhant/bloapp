package in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.model.EpicIssuedPayload;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class EpicIssuedAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    private List<EpicIssuedPayload> items;
    private OnItemSelectedListener listener;

    public interface OnItemSelectedListener {
        void onItemSelected();
    }

    public EpicIssuedAdapter(Context context, List<EpicIssuedPayload> items, OnItemSelectedListener listener) {
        this.items = items;
        this.listener = listener;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView tvAcName;
        TextView tvElectorName;
        TextView tvRelativeName;
        TextView tvRelativeType;
        TextView tvStateName;
        TextView tv_dob;
        TextView tv_gender;
        TextView tv_reference;

        public ViewHolder(View itemView) {
            super(itemView);
            this.icon = (ImageView) itemView.findViewById(2131364119);
            this.tvElectorName = (TextView) itemView.findViewById(R.id.tv_elector_name);
            this.tvStateName = (TextView) itemView.findViewById(R.id.tv_state_name);
            this.tvAcName = (TextView) itemView.findViewById(R.id.tv_ac_name);
            this.tv_reference = (TextView) itemView.findViewById(R.id.tv_reference);
            this.tv_dob = (TextView) itemView.findViewById(R.id.tv_dob);
            this.tvRelativeName = (TextView) itemView.findViewById(R.id.tv_relative_name);
            this.tvRelativeType = (TextView) itemView.findViewById(R.id.tv_relative_type);
            this.tv_gender = (TextView) itemView.findViewById(R.id.tv_gender);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.EpicIssuedAdapter$ViewHolder$$ExternalSyntheticLambda0
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
                if (i >= EpicIssuedAdapter.this.items.size()) {
                    i = -1;
                    break;
                } else {
                    if (((EpicIssuedPayload) EpicIssuedAdapter.this.items.get(i)).isSelected()) {
                        ((EpicIssuedPayload) EpicIssuedAdapter.this.items.get(i)).setSelected(false);
                        break;
                    }
                    i++;
                }
            }
            ((EpicIssuedPayload) EpicIssuedAdapter.this.items.get(getAdapterPosition())).setSelected(true);
            if (i != -1) {
                EpicIssuedAdapter.this.notifyItemChanged(i);
            }
            EpicIssuedAdapter.this.notifyItemChanged(getAdapterPosition());
            EpicIssuedAdapter.this.listener.onItemSelected();
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.epic_issued_item, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        EpicIssuedPayload epicIssuedPayload = this.items.get(position);
        holder.tvStateName.setText(!TextUtils.isEmpty(epicIssuedPayload.getStateName()) ? epicIssuedPayload.getStateName() : "");
        holder.tvAcName.setText(!TextUtils.isEmpty(epicIssuedPayload.getAsmblyName()) ? epicIssuedPayload.getAsmblyName() : "");
        holder.tv_reference.setText(!TextUtils.isEmpty(epicIssuedPayload.getEpicNumber()) ? epicIssuedPayload.getEpicNumber() : "");
        holder.tvElectorName.setText(!TextUtils.isEmpty(epicIssuedPayload.getFullName()) ? epicIssuedPayload.getFullName() : "");
        holder.tv_dob.setText(!TextUtils.isEmpty(epicIssuedPayload.getDob()) ? epicIssuedPayload.getDob() : "");
        if (!TextUtils.isEmpty(epicIssuedPayload.getGender())) {
            if (epicIssuedPayload.getGender().equalsIgnoreCase("M")) {
                holder.tv_gender.setText("Male");
            } else if (epicIssuedPayload.getGender().equalsIgnoreCase("F")) {
                holder.tv_gender.setText("Female");
            } else {
                holder.tv_gender.setText("Other");
            }
        }
        if (!TextUtils.isEmpty(epicIssuedPayload.getRelationType())) {
            String relationType = epicIssuedPayload.getRelationType();
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
        holder.tvRelativeName.setText(TextUtils.isEmpty(epicIssuedPayload.getRelativeFullName()) ? "" : epicIssuedPayload.getRelativeFullName());
        holder.icon.setImageResource(epicIssuedPayload.isSelected() ? R.drawable.inactive_radio : R.drawable.active_radio);
    }

    public int getItemCount() {
        return this.items.size();
    }
}
