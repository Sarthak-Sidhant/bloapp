package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityElectorMappingMainLayoutBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final LinearLayout llMapPrevious;
    public final LinearLayout llMapSelf;
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final TextView textView3;
    public final TextView tvMapPrevious;
    public final TextView tvMapSelf;
    public final TextView tvMappedCount;
    public final TextView tvMappedSelfCount;
    public final TextView tvUnmappedCount;
    public final TextView tvUnmappedSelfCount;

    private ActivityElectorMappingMainLayoutBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, LinearLayout llMapPrevious, LinearLayout llMapSelf, LinearLayout main, TextView textView3, TextView tvMapPrevious, TextView tvMapSelf, TextView tvMappedCount, TextView tvMappedSelfCount, TextView tvUnmappedCount, TextView tvUnmappedSelfCount) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.llMapPrevious = llMapPrevious;
        this.llMapSelf = llMapSelf;
        this.main = main;
        this.textView3 = textView3;
        this.tvMapPrevious = tvMapPrevious;
        this.tvMapSelf = tvMapSelf;
        this.tvMappedCount = tvMappedCount;
        this.tvMappedSelfCount = tvMappedSelfCount;
        this.tvUnmappedCount = tvUnmappedCount;
        this.tvUnmappedSelfCount = tvUnmappedSelfCount;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityElectorMappingMainLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityElectorMappingMainLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_elector_mapping_main_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityElectorMappingMainLayoutBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.ll_map_previous;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_map_previous);
                if (linearLayout != null) {
                    i = R.id.ll_map_self;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_map_self);
                    if (linearLayout2 != null) {
                        LinearLayout linearLayout3 = (LinearLayout) rootView;
                        i = R.id.textView3;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                        if (textView != null) {
                            i = R.id.tv_map_previous;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_map_previous);
                            if (textView2 != null) {
                                i = R.id.tv_map_self;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_map_self);
                                if (textView3 != null) {
                                    i = R.id.tv_mapped_count;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_mapped_count);
                                    if (textView4 != null) {
                                        i = R.id.tv_mapped_self_count;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_mapped_self_count);
                                        if (textView5 != null) {
                                            i = R.id.tv_unmapped_count;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_unmapped_count);
                                            if (textView6 != null) {
                                                i = R.id.tv_unmapped_self_count;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_unmapped_self_count);
                                                if (textView7 != null) {
                                                    return new ActivityElectorMappingMainLayoutBinding(linearLayout3, imageView, constraintLayoutFindChildViewById, linearLayout, linearLayout2, linearLayout3, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
