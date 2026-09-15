package in.gov.eci.bloapp.adapter.generic_adapter;

import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.RecyclerViewHolder;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FilterableRecyclerView extends RecyclerView.Adapter<RecyclerViewHolder> implements Filterable {
    private final FilterGenericRecyclerAdapterInterface filterGenericRecyclerAdapterInterface;

    public interface FilterGenericRecyclerAdapterInterface {
        Filter getFilter();

        int getItemCount();

        int getItemViewType(int position);

        void onBindViewHolder(RecyclerViewHolder holder, int position);

        RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType);
    }

    public FilterableRecyclerView(FilterGenericRecyclerAdapterInterface filterGenericRecyclerAdapterInterface) {
        this.filterGenericRecyclerAdapterInterface = filterGenericRecyclerAdapterInterface;
    }

    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return this.filterGenericRecyclerAdapterInterface.onCreateViewHolder(parent, viewType);
    }

    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        this.filterGenericRecyclerAdapterInterface.onBindViewHolder(holder, position);
    }

    public int getItemCount() {
        return this.filterGenericRecyclerAdapterInterface.getItemCount();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return this.filterGenericRecyclerAdapterInterface.getFilter();
    }
}
