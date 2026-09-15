package in.gov.eci.bloapp.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.model.app_model.NotificationItem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class NotificationAdapter extends RecyclerView.Adapter<VH> {
    private static final int PAYLOAD_EXPAND = 1;
    private static final int PAYLOAD_READ = 2;
    private List<NotificationItem> data;
    private final Listener listener;
    private final Set<String> expandedIds = new HashSet();
    private final Map<String, Integer> idToPosition = new HashMap();
    private final String[][] colorsmap = {new String[]{"#E2DBFF", "#B39DDB"}, new String[]{"#F2CFED", "#CE93D8"}, new String[]{"#FFECBA", "#FFD54F"}, new String[]{"#C3F3C0", "#81C784"}, new String[]{"#CAEFFC", "#4FC3F7"}, new String[]{"#E2DBFF", "#B39DDB"}};

    public interface Listener {
        void onItemClicked(NotificationItem item, int position);

        void onReadMoreClicked(NotificationItem item, boolean willExpand);
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
        onBindViewHolder((VH) holder, position, (List<Object>) payloads);
    }

    public NotificationAdapter(List<NotificationItem> data, Listener listener) {
        this.data = data == null ? Collections.emptyList() : data;
        this.listener = listener;
        setHasStableIds(true);
        rebuildIndex();
    }

    public long getItemId(int position) {
        return this.data.get(position).getId().hashCode();
    }

    static class VH extends RecyclerView.ViewHolder {
        final TextView btnToggle;
        final View container;
        final View newContainer;
        final TextView tvDate;
        final TextView tvMessage;
        final TextView tvText;
        final TextView tvTitle;

        VH(View itemView) {
            super(itemView);
            this.container = itemView.findViewById(R.id.container);
            this.newContainer = itemView.findViewById(R.id.container_new);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            this.tvMessage = (TextView) itemView.findViewById(R.id.tvMessage);
            this.btnToggle = (TextView) itemView.findViewById(R.id.btnToggle);
            this.tvText = (TextView) itemView.findViewById(R.id.tvText);
        }
    }

    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        final VH vh = new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item_row, parent, false));
        vh.btnToggle.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.NotificationAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateViewHolder$0(vh, view);
            }
        });
        vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.NotificationAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateViewHolder$1(vh, view);
            }
        });
        return vh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateViewHolder$0(VH vh, View view) {
        int adapterPosition = vh.getAdapterPosition();
        if (adapterPosition == -1) {
            return;
        }
        NotificationItem notificationItem = this.data.get(adapterPosition);
        String id = notificationItem.getId();
        boolean z = !this.expandedIds.contains(id);
        Listener listener = this.listener;
        if (listener != null) {
            listener.onReadMoreClicked(notificationItem, z);
        }
        if (z) {
            this.expandedIds.add(id);
        } else {
            this.expandedIds.remove(id);
        }
        notifyItemChanged(adapterPosition, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateViewHolder$1(VH vh, View view) {
        int adapterPosition = vh.getAdapterPosition();
        if (adapterPosition == -1) {
            return;
        }
        NotificationItem notificationItem = this.data.get(adapterPosition);
        Listener listener = this.listener;
        if (listener != null) {
            listener.onItemClicked(notificationItem, adapterPosition);
        }
    }

    public void onBindViewHolder(VH holder, int position) {
        bindFull(holder, this.data.get(position), position);
    }

    public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
        if (payloads.isEmpty()) {
            bindFull(holder, this.data.get(position), position);
            return;
        }
        NotificationItem notificationItem = this.data.get(position);
        for (Object obj : payloads) {
            if (obj instanceof Integer) {
                int iIntValue = ((Integer) obj).intValue();
                if (iIntValue == 1) {
                    applyExpandState(holder, this.expandedIds.contains(notificationItem.getId()));
                } else if (iIntValue == 2) {
                    applyReadBackground(holder, "Y".equalsIgnoreCase(notificationItem.isSeen()), position);
                }
            }
        }
    }

    private void bindFull(VH holder, NotificationItem item, int position) {
        holder.tvTitle.setText(item.getTitle());
        holder.tvMessage.setText(item.getMessage());
        holder.tvDate.setText(getDate(item.getCreatedDate()));
        holder.tvText.setText(String.valueOf(!TextUtils.isEmpty(item.getTitle()) ? Character.valueOf(item.getTitle().charAt(0)) : "").toUpperCase());
        String[][] strArr = this.colorsmap;
        holder.tvText.setBackgroundColor(Color.parseColor(strArr[position % strArr.length][1]));
        applyReadBackground(holder, "Y".equalsIgnoreCase(item.isSeen()), position);
        boolean zContains = this.expandedIds.contains(item.getId());
        applyExpandState(holder, zContains);
        setToggleText(holder, zContains);
    }

    private void setToggleText(VH holder, boolean expanded) {
        holder.btnToggle.setText(expanded ? "Read less" : "Read more");
    }

    private void applyExpandState(VH holder, boolean expanded) {
        if (expanded) {
            holder.tvMessage.setMaxLines(Integer.MAX_VALUE);
            holder.tvMessage.setEllipsize(null);
        } else {
            holder.tvMessage.setMaxLines(1);
            holder.tvMessage.setEllipsize(TextUtils.TruncateAt.END);
        }
        setToggleText(holder, expanded);
    }

    private void applyReadBackground(VH holder, boolean isSeen, int position) {
        String[][] strArr = this.colorsmap;
        holder.newContainer.setBackgroundColor(Color.parseColor(strArr[position % strArr.length][0]));
        holder.tvTitle.setAlpha(isSeen ? 0.9f : 1.0f);
    }

    public int getItemCount() {
        List<NotificationItem> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setItems(List<NotificationItem> newItems) {
        if (newItems == null) {
            newItems = Collections.emptyList();
        }
        this.data = newItems;
        rebuildIndex();
        notifyDataSetChanged();
        pruneExpandedIds();
    }

    public void markSeen(String id) {
        Integer numValueOf = this.idToPosition.get(id);
        if (numValueOf == null) {
            for (int i = 0; i < this.data.size(); i++) {
                if (id.equals(this.data.get(i).getId())) {
                    numValueOf = Integer.valueOf(i);
                    break;
                }
            }
        }
        if (numValueOf == null || numValueOf.intValue() < 0 || numValueOf.intValue() >= this.data.size()) {
            return;
        }
        NotificationItem notificationItem = this.data.get(numValueOf.intValue());
        if ("Y".equalsIgnoreCase(notificationItem.isSeen())) {
            return;
        }
        notificationItem.setSeen("Y");
        notifyItemChanged(numValueOf.intValue(), 2);
    }

    public void setExpanded(String id, boolean expanded) {
        Integer num = this.idToPosition.get(id);
        if (num == null || num.intValue() < 0 || num.intValue() >= this.data.size() || this.expandedIds.contains(id) == expanded) {
            return;
        }
        if (expanded) {
            this.expandedIds.add(id);
        } else {
            this.expandedIds.remove(id);
        }
        notifyItemChanged(num.intValue(), 1);
    }

    private void rebuildIndex() {
        this.idToPosition.clear();
        for (int i = 0; i < this.data.size(); i++) {
            this.idToPosition.put(this.data.get(i).getId(), Integer.valueOf(i));
        }
    }

    private void pruneExpandedIds() {
        if (this.expandedIds.isEmpty()) {
            return;
        }
        final HashSet hashSet = new HashSet(this.idToPosition.keySet());
        this.expandedIds.removeIf(new Predicate() { // from class: in.gov.eci.bloapp.adapter.NotificationAdapter$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return NotificationAdapter.lambda$pruneExpandedIds$2(hashSet, (String) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$pruneExpandedIds$2(Set set, String str) {
        return !set.contains(str);
    }

    private String getDate(String input) {
        try {
            return LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy, hh:mm a"));
        } catch (Exception unused) {
            return "";
        }
    }
}
