package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityH2HsurveyStatusBinding implements ViewBinding {
    public final RecyclerView allStatusRv;
    public final ImageView back;
    public final CardView detailsLayout;
    public final TextView download;
    public final EditText fromDateEd;
    public final ImageView homeBtnIv;
    public final LinearLayout mainLayout;
    public final TextView resultHeader;
    private final ConstraintLayout rootView;
    public final CardView searchLayout;
    public final EditText serialNumberEd;
    public final TextView showResults;
    public final TextView title;
    public final ConstraintLayout titleBar;
    public final EditText toDateEd;

    private BloActivityH2HsurveyStatusBinding(ConstraintLayout rootView, RecyclerView allStatusRv, ImageView back, CardView detailsLayout, TextView download, EditText fromDateEd, ImageView homeBtnIv, LinearLayout mainLayout, TextView resultHeader, CardView searchLayout, EditText serialNumberEd, TextView showResults, TextView title, ConstraintLayout titleBar, EditText toDateEd) {
        this.rootView = rootView;
        this.allStatusRv = allStatusRv;
        this.back = back;
        this.detailsLayout = detailsLayout;
        this.download = download;
        this.fromDateEd = fromDateEd;
        this.homeBtnIv = homeBtnIv;
        this.mainLayout = mainLayout;
        this.resultHeader = resultHeader;
        this.searchLayout = searchLayout;
        this.serialNumberEd = serialNumberEd;
        this.showResults = showResults;
        this.title = title;
        this.titleBar = titleBar;
        this.toDateEd = toDateEd;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityH2HsurveyStatusBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityH2HsurveyStatusBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_h2_hsurvey_status, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityH2HsurveyStatusBinding bind(View rootView) {
        int i = R.id.all_status_rv;
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.all_status_rv);
        if (recyclerViewFindChildViewById != null) {
            i = 2131362484;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131362484);
            if (imageView != null) {
                i = R.id.detailsLayout;
                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.detailsLayout);
                if (cardViewFindChildViewById != null) {
                    i = R.id.download;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.download);
                    if (textView != null) {
                        i = R.id.from_Date_ed;
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.from_Date_ed);
                        if (editText != null) {
                            i = R.id.home_btn_iv;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                            if (imageView2 != null) {
                                i = R.id.mainLayout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainLayout);
                                if (linearLayout != null) {
                                    i = R.id.resultHeader;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultHeader);
                                    if (textView2 != null) {
                                        i = R.id.searchLayout;
                                        CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.searchLayout);
                                        if (cardViewFindChildViewById2 != null) {
                                            i = R.id.serial_Number_ed;
                                            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.serial_Number_ed);
                                            if (editText2 != null) {
                                                i = R.id.show_Results;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.show_Results);
                                                if (textView3 != null) {
                                                    i = 2131366420;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, 2131366420);
                                                    if (textView4 != null) {
                                                        i = R.id.titleBar;
                                                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.titleBar);
                                                        if (constraintLayoutFindChildViewById != null) {
                                                            i = R.id.to_Date_ed;
                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.to_Date_ed);
                                                            if (editText3 != null) {
                                                                return new BloActivityH2HsurveyStatusBinding((ConstraintLayout) rootView, recyclerViewFindChildViewById, imageView, cardViewFindChildViewById, textView, editText, imageView2, linearLayout, textView2, cardViewFindChildViewById2, editText2, textView3, textView4, constraintLayoutFindChildViewById, editText3);
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
