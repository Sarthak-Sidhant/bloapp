package in.gov.eci.bloapp.views.fragments.about_eci;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import in.gov.eci.bloapp.databinding.AboutHonbleCommissionRvItemsBinding;
import in.gov.eci.bloapp.model.app_model.HonbleCommissionModel;
import in.gov.eci.bloapp.views.activity.HonbleCommissionDetailActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class HonbleCommissionAdapter extends RecyclerView.Adapter<HonbleCommissionViewHolder> {
    AboutHonbleCommissionRvItemsBinding aboutHonbleCommissionRvItemsBinding;
    FragmentActivity context;
    List<HonbleCommissionModel.Result> results = new ArrayList();

    public void setResults(List<HonbleCommissionModel.Result> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    public HonbleCommissionAdapter(FragmentActivity context) {
        this.context = context;
    }

    public HonbleCommissionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.aboutHonbleCommissionRvItemsBinding = AboutHonbleCommissionRvItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HonbleCommissionViewHolder(this.aboutHonbleCommissionRvItemsBinding);
    }

    public void onBindViewHolder(HonbleCommissionViewHolder holder, int position) {
        final HonbleCommissionModel.Result result = this.results.get(position);
        if (!result.getImage().isEmpty()) {
            Glide.with(holder.itemView).load(result.getImage()).into(holder.aboutHonbleCommissionRvItemsBinding.commissionImage);
        }
        holder.aboutHonbleCommissionRvItemsBinding.textViewName.setText(result.getTitle());
        holder.aboutHonbleCommissionRvItemsBinding.textViewDesignation.setText(fromHtml(result.getDescription()));
        holder.aboutHonbleCommissionRvItemsBinding.commissionRvRoot.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.about_eci.HonbleCommissionAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(result, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(HonbleCommissionModel.Result result, View view) {
        Intent intent = new Intent((Context) this.context, (Class<?>) HonbleCommissionDetailActivity.class);
        String title = result.getTitle();
        String strValueOf = String.valueOf(fromHtml(result.getDescription()));
        String image = result.getImage();
        intent.putExtra("name", title);
        intent.putExtra("details", strValueOf);
        intent.putExtra("image", image);
        this.context.startActivity(intent);
    }

    public static Spanned fromHtml(String html) {
        return Html.fromHtml(html, 0);
    }

    public int getItemCount() {
        return this.results.size();
    }

    public static class HonbleCommissionViewHolder extends RecyclerView.ViewHolder {
        private final AboutHonbleCommissionRvItemsBinding aboutHonbleCommissionRvItemsBinding;

        public HonbleCommissionViewHolder(AboutHonbleCommissionRvItemsBinding binding) {
            super(binding.getRoot());
            this.aboutHonbleCommissionRvItemsBinding = binding;
        }
    }
}
