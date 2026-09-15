package in.gov.eci.bloapp.views.fragments.faq;

import android.content.Context;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloItemLayoutViewBinding;
import in.gov.eci.bloapp.model.app_model.ExpandModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ExpandAdapter extends RecyclerView.Adapter<ExpandViewHolder> {
    private final Context context;
    private final List<ExpandModel> results = new ArrayList();
    BloItemLayoutViewBinding statisticLayoutRowBinding;

    public ExpandAdapter(Context context) {
        this.context = context;
    }

    public void setResults(List<ExpandModel> results) {
        this.results.addAll(results);
        notifyDataSetChanged();
    }

    public ExpandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.statisticLayoutRowBinding = BloItemLayoutViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ExpandViewHolder(this.statisticLayoutRowBinding);
    }

    public void onBindViewHolder(final ExpandViewHolder holder, int position) {
        Resources resources;
        int i;
        ExpandModel expandModel = this.results.get(position);
        Boolean isExpandable = expandModel.getIsExpandable();
        holder.binding.textViewMediaForms.setText(expandModel.getTitle());
        holder.binding.newTextForms.setText(expandModel.getItem());
        holder.binding.newTextForms.setMovementMethod(LinkMovementMethod.getInstance());
        holder.binding.newTextForms.setLinkTextColor(-16776961);
        holder.binding.textViewMediaFormsNew.setVisibility(isExpandable.booleanValue() ? 0 : 8);
        holder.binding.newTextFormsBuilder.setVisibility(expandModel.builder == null ? 8 : 0);
        holder.binding.newTextFormsBuilder.setText(expandModel.builder);
        TextView textView = holder.binding.textViewMediaForms;
        if (isExpandable.booleanValue()) {
            resources = this.context.getResources();
            i = R.color.blo_blue;
        } else {
            resources = this.context.getResources();
            i = R.color.blo_black;
        }
        textView.setTextColor(resources.getColor(i));
        holder.binding.rootLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.faq.ExpandAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ExpandModel expandModel2 = (ExpandModel) ExpandAdapter.this.results.get(holder.getAdapterPosition());
                expandModel2.setIsExpandable(Boolean.valueOf(!expandModel2.getIsExpandable().booleanValue()));
                ExpandAdapter.this.notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    public int getItemCount() {
        return this.results.size();
    }

    public static class ExpandViewHolder extends RecyclerView.ViewHolder {
        private final BloItemLayoutViewBinding binding;

        public ExpandViewHolder(BloItemLayoutViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
