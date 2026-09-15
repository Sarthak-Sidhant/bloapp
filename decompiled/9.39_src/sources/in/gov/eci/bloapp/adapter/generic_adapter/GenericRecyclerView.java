package in.gov.eci.bloapp.adapter.generic_adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.RecyclerViewHolder;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class GenericRecyclerView extends RecyclerView.Adapter<RecyclerViewHolder> {
    private final GenericRecyclerViewInterface genericRecyclerViewInterface;

    public interface GenericRecyclerViewInterface {
        int getItemCount();

        int getItemViewType(int position);

        void onBindViewHolder(RecyclerViewHolder holder, int position);

        RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType);
    }

    public GenericRecyclerView(GenericRecyclerViewInterface genericRecyclerViewInterface) {
        this.genericRecyclerViewInterface = genericRecyclerViewInterface;
    }

    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return this.genericRecyclerViewInterface.onCreateViewHolder(parent, viewType);
    }

    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        this.genericRecyclerViewInterface.onBindViewHolder(holder, position);
    }

    public int getItemCount() {
        return this.genericRecyclerViewInterface.getItemCount();
    }

    public int getItemViewType(int position) {
        return this.genericRecyclerViewInterface.getItemViewType(position);
    }
}
