package in.gov.eci.bloapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.newsir.callback.ItemClickCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AnomalyListValueAdapter extends RecyclerView.Adapter<holder> {
    List<String> al;
    private Context context;
    List<String> filteredAl;
    ItemClickCallback itemClickCallback;

    public AnomalyListValueAdapter(List<String> al, Context context, ItemClickCallback itemClickCallback) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.itemClickCallback = itemClickCallback;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.anomaly_value, viewGroup, false));
    }

    public void onBindViewHolder(holder holder2, int i) {
        holder2.tv_parentNameMisMatch.setText(this.al.get(i));
    }

    public int getItemCount() {
        return this.al.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView tv_parentNameMisMatch;

        public holder(View itemView) {
            super(itemView);
            this.tv_parentNameMisMatch = (TextView) itemView.findViewById(R.id.tv_parentNameMisMatch);
        }
    }

    public void fun(ArrayList<String> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
