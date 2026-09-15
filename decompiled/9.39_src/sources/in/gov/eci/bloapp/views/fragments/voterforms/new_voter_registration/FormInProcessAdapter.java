package in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.model.FormInProcessPayload;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormInProcessAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    private List<FormInProcessPayload> items;
    private OnItemSelectedListener listener;

    public interface OnItemSelectedListener {
        void onItemSelected();
    }

    public FormInProcessAdapter(Context context, List<FormInProcessPayload> items, OnItemSelectedListener listener) {
        this.items = items;
        this.listener = listener;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
            this.tvElectorName = (TextView) itemView.findViewById(R.id.tv_elector_name);
            this.tvStateName = (TextView) itemView.findViewById(R.id.tv_state_name);
            this.tvAcName = (TextView) itemView.findViewById(R.id.tv_ac_name);
            this.tv_reference = (TextView) itemView.findViewById(R.id.tv_reference);
            this.tv_dob = (TextView) itemView.findViewById(R.id.tv_dob);
            this.tvRelativeName = (TextView) itemView.findViewById(R.id.tv_relative_name);
            this.tvRelativeType = (TextView) itemView.findViewById(R.id.tv_relative_type);
            this.tv_gender = (TextView) itemView.findViewById(R.id.tv_gender);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.form_in_process_item, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        FormInProcessPayload formInProcessPayload = this.items.get(position);
        holder.tvStateName.setText(!TextUtils.isEmpty(formInProcessPayload.getStateName()) ? formInProcessPayload.getStateName() : "");
        holder.tvAcName.setText(!TextUtils.isEmpty(formInProcessPayload.getAcName()) ? formInProcessPayload.getAcName() : "");
        holder.tv_reference.setText(!TextUtils.isEmpty(formInProcessPayload.getFormRefNumber()) ? formInProcessPayload.getFormRefNumber() : "");
        holder.tvElectorName.setText(!TextUtils.isEmpty(formInProcessPayload.getFullName()) ? formInProcessPayload.getFullName() : "");
        holder.tv_dob.setText(!TextUtils.isEmpty(formInProcessPayload.getDob()) ? formInProcessPayload.getDob() : "");
        if (!TextUtils.isEmpty(formInProcessPayload.getGender())) {
            if (formInProcessPayload.getGender().equalsIgnoreCase("M")) {
                holder.tv_gender.setText("Male");
            } else if (formInProcessPayload.getGender().equalsIgnoreCase("F")) {
                holder.tv_gender.setText("Female");
            } else {
                holder.tv_gender.setText("Other");
            }
        }
        if (!TextUtils.isEmpty(formInProcessPayload.getRelationType())) {
            String relationType = formInProcessPayload.getRelationType();
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
        holder.tvRelativeName.setText(TextUtils.isEmpty(formInProcessPayload.getFullRelationName()) ? "" : formInProcessPayload.getFullRelationName());
    }

    public int getItemCount() {
        return this.items.size();
    }
}
