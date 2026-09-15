package in.gov.eci.bloapp;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public ViewBinding binding;

    public RecyclerViewHolder(ViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
