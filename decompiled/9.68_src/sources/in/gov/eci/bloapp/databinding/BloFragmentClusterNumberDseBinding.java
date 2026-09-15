package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentClusterNumberDseBinding implements ViewBinding {
    public final TextView age12;
    public final ImageView backBtnIv;
    public final TextView electorName;
    public final TextView gender;
    public final TextView headTitle;
    public final TextView headerText;
    public final ImageView homeBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final RecyclerView houseDetailsRv;
    public final RelativeLayout layout;
    public final LinearLayout layoutFrame1;
    public final LinearLayout layoutFrame2;
    public final TextView relativeName;
    public final TextView relativeType;
    private final LinearLayout rootView;
    public final TextView textView24;
    public final View viewLine;

    private BloFragmentClusterNumberDseBinding(LinearLayout rootView, TextView age12, ImageView backBtnIv, TextView electorName, TextView gender, TextView headTitle, TextView headerText, ImageView homeBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, RecyclerView houseDetailsRv, RelativeLayout layout, LinearLayout layoutFrame1, LinearLayout layoutFrame2, TextView relativeName, TextView relativeType, TextView textView24, View viewLine) {
        this.rootView = rootView;
        this.age12 = age12;
        this.backBtnIv = backBtnIv;
        this.electorName = electorName;
        this.gender = gender;
        this.headTitle = headTitle;
        this.headerText = headerText;
        this.homeBtnIv = homeBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.houseDetailsRv = houseDetailsRv;
        this.layout = layout;
        this.layoutFrame1 = layoutFrame1;
        this.layoutFrame2 = layoutFrame2;
        this.relativeName = relativeName;
        this.relativeType = relativeType;
        this.textView24 = textView24;
        this.viewLine = viewLine;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentClusterNumberDseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentClusterNumberDseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_cluster_number_dse, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentClusterNumberDseBinding bind(View rootView) {
        int i = R.id.age12;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.age12);
        if (textView != null) {
            i = R.id.back_btn_iv;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
            if (imageView != null) {
                i = R.id.elector_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.elector_name);
                if (textView2 != null) {
                    i = R.id.gender;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender);
                    if (textView3 != null) {
                        i = R.id.head_title;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.head_title);
                        if (textView4 != null) {
                            i = R.id.header_text;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.header_text);
                            if (textView5 != null) {
                                i = R.id.home_btn_iv;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                if (imageView2 != null) {
                                    i = R.id.home_fragment_top_constraint_layout;
                                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                                    if (constraintLayoutFindChildViewById != null) {
                                        i = R.id.house_details_rv;
                                        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.house_details_rv);
                                        if (recyclerViewFindChildViewById != null) {
                                            i = 2131364428;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, 2131364428);
                                            if (relativeLayout != null) {
                                                i = R.id.layout_frame1;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_frame1);
                                                if (linearLayout != null) {
                                                    i = R.id.layout_frame2;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_frame2);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.relative_name;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_name);
                                                        if (textView6 != null) {
                                                            i = R.id.relative_type;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_type);
                                                            if (textView7 != null) {
                                                                i = R.id.textView24;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView24);
                                                                if (textView8 != null) {
                                                                    i = R.id.view_line;
                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_line);
                                                                    if (viewFindChildViewById != null) {
                                                                        return new BloFragmentClusterNumberDseBinding((LinearLayout) rootView, textView, imageView, textView2, textView3, textView4, textView5, imageView2, constraintLayoutFindChildViewById, recyclerViewFindChildViewById, relativeLayout, linearLayout, linearLayout2, textView6, textView7, textView8, viewFindChildViewById);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
