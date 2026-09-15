package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class NotificationItemRowBinding implements ViewBinding {
    public final TextView btnToggle;
    public final LinearLayout container;
    public final RelativeLayout containerNew;
    private final CardView rootView;
    public final TextView tvDate;
    public final TextView tvMessage;
    public final TextView tvText;
    public final TextView tvTitle;

    private NotificationItemRowBinding(CardView rootView, TextView btnToggle, LinearLayout container, RelativeLayout containerNew, TextView tvDate, TextView tvMessage, TextView tvText, TextView tvTitle) {
        this.rootView = rootView;
        this.btnToggle = btnToggle;
        this.container = container;
        this.containerNew = containerNew;
        this.tvDate = tvDate;
        this.tvMessage = tvMessage;
        this.tvText = tvText;
        this.tvTitle = tvTitle;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static NotificationItemRowBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NotificationItemRowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.notification_item_row, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NotificationItemRowBinding bind(View rootView) {
        int i = R.id.btnToggle;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.btnToggle);
        if (textView != null) {
            i = R.id.container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.container);
            if (linearLayout != null) {
                i = R.id.container_new;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.container_new);
                if (relativeLayout != null) {
                    i = R.id.tvDate;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvDate);
                    if (textView2 != null) {
                        i = R.id.tvMessage;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvMessage);
                        if (textView3 != null) {
                            i = R.id.tvText;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvText);
                            if (textView4 != null) {
                                i = R.id.tvTitle;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvTitle);
                                if (textView5 != null) {
                                    return new NotificationItemRowBinding((CardView) rootView, textView, linearLayout, relativeLayout, textView2, textView3, textView4, textView5);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
