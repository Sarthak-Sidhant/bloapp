package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityDashFormsDetailsBinding implements ViewBinding {
    public final LinearLayout SpinnersLayout;
    public final ImageView backBtnIv;
    public final LinearLayout container;
    public final LinearLayout daysLayout;
    public final RecyclerView formDataListRv;
    public final LinearLayout formsTypesLayout;
    public final NoDefaultSpinner formsTypesSpinner;
    public final ImageView homeBtnIv;
    public final LinearLayout homeFragmentTop;
    public final NoDefaultSpinner moreLessDaysSpinner;
    private final LinearLayout rootView;
    public final TextView textView3;
    public final TextView totalCount;
    public final View viewFormsTypeSpinner;
    public final View viewMorelessdaysSpinner;

    private BloActivityDashFormsDetailsBinding(LinearLayout rootView, LinearLayout SpinnersLayout, ImageView backBtnIv, LinearLayout container, LinearLayout daysLayout, RecyclerView formDataListRv, LinearLayout formsTypesLayout, NoDefaultSpinner formsTypesSpinner, ImageView homeBtnIv, LinearLayout homeFragmentTop, NoDefaultSpinner moreLessDaysSpinner, TextView textView3, TextView totalCount, View viewFormsTypeSpinner, View viewMorelessdaysSpinner) {
        this.rootView = rootView;
        this.SpinnersLayout = SpinnersLayout;
        this.backBtnIv = backBtnIv;
        this.container = container;
        this.daysLayout = daysLayout;
        this.formDataListRv = formDataListRv;
        this.formsTypesLayout = formsTypesLayout;
        this.formsTypesSpinner = formsTypesSpinner;
        this.homeBtnIv = homeBtnIv;
        this.homeFragmentTop = homeFragmentTop;
        this.moreLessDaysSpinner = moreLessDaysSpinner;
        this.textView3 = textView3;
        this.totalCount = totalCount;
        this.viewFormsTypeSpinner = viewFormsTypeSpinner;
        this.viewMorelessdaysSpinner = viewMorelessdaysSpinner;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityDashFormsDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityDashFormsDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_dash_forms_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityDashFormsDetailsBinding bind(View rootView) {
        int i = R.id.SpinnersLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.SpinnersLayout);
        if (linearLayout != null) {
            i = R.id.back_btn_iv;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
            if (imageView != null) {
                LinearLayout linearLayout2 = (LinearLayout) rootView;
                i = R.id.days_layout;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.days_layout);
                if (linearLayout3 != null) {
                    i = R.id.formDataList_rv;
                    RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.formDataList_rv);
                    if (recyclerViewFindChildViewById != null) {
                        i = R.id.formsTypes_layout;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.formsTypes_layout);
                        if (linearLayout4 != null) {
                            i = R.id.forms_types_spinner;
                            NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.forms_types_spinner);
                            if (noDefaultSpinner != null) {
                                i = R.id.home_btn_iv;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                if (imageView2 != null) {
                                    i = R.id.home_fragment_top;
                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.home_fragment_top);
                                    if (linearLayout5 != null) {
                                        i = R.id.more_less_days_spinner;
                                        NoDefaultSpinner noDefaultSpinner2 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.more_less_days_spinner);
                                        if (noDefaultSpinner2 != null) {
                                            i = R.id.textView3;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                            if (textView != null) {
                                                i = R.id.total_count;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.total_count);
                                                if (textView2 != null) {
                                                    i = R.id.view_formsType_spinner;
                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_formsType_spinner);
                                                    if (viewFindChildViewById != null) {
                                                        i = R.id.view_morelessdays_spinner;
                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_morelessdays_spinner);
                                                        if (viewFindChildViewById2 != null) {
                                                            return new BloActivityDashFormsDetailsBinding(linearLayout2, linearLayout, imageView, linearLayout2, linearLayout3, recyclerViewFindChildViewById, linearLayout4, noDefaultSpinner, imageView2, linearLayout5, noDefaultSpinner2, textView, textView2, viewFindChildViewById, viewFindChildViewById2);
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
