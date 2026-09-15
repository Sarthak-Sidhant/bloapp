package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ItemSystemMappedBinding implements ViewBinding {
    public final ImageView icon;
    private final LinearLayout rootView;
    public final TextView titleTv;
    public final TextView tvAc;
    public final TextView tvAc1;
    public final TextView tvEpic;
    public final TextView tvEpic1;
    public final TextView tvName;
    public final TextView tvName1;
    public final TextView tvPart;
    public final TextView tvPart1;

    private ItemSystemMappedBinding(LinearLayout rootView, ImageView icon, TextView titleTv, TextView tvAc, TextView tvAc1, TextView tvEpic, TextView tvEpic1, TextView tvName, TextView tvName1, TextView tvPart, TextView tvPart1) {
        this.rootView = rootView;
        this.icon = icon;
        this.titleTv = titleTv;
        this.tvAc = tvAc;
        this.tvAc1 = tvAc1;
        this.tvEpic = tvEpic;
        this.tvEpic1 = tvEpic1;
        this.tvName = tvName;
        this.tvName1 = tvName1;
        this.tvPart = tvPart;
        this.tvPart1 = tvPart1;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemSystemMappedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemSystemMappedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_system_mapped, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemSystemMappedBinding bind(View rootView) {
        int i = 2131364251;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131364251);
        if (imageView != null) {
            i = R.id.title_tv;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.title_tv);
            if (textView != null) {
                i = R.id.tv_ac;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_ac);
                if (textView2 != null) {
                    i = R.id.tv_ac1;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_ac1);
                    if (textView3 != null) {
                        i = R.id.tv_epic;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_epic);
                        if (textView4 != null) {
                            i = R.id.tv_epic1;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_epic1);
                            if (textView5 != null) {
                                i = R.id.tv_name;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_name);
                                if (textView6 != null) {
                                    i = R.id.tv_name1;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_name1);
                                    if (textView7 != null) {
                                        i = R.id.tv_part;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_part);
                                        if (textView8 != null) {
                                            i = R.id.tv_part1;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_part1);
                                            if (textView9 != null) {
                                                return new ItemSystemMappedBinding((LinearLayout) rootView, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
                                            }
                                        }
                                    }
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
