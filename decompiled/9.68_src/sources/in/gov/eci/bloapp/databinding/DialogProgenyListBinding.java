package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DialogProgenyListBinding implements ViewBinding {
    public final ImageView ivCancel;
    public final LinearLayout layoutVerifyButton;
    public final LinearLayout mainLayout;
    private final LinearLayout rootView;
    public final RecyclerView rvMapping;
    public final CardView searchByLocationCv;
    public final LinearLayout searchByLocationDetailsLl;
    public final TextView tvRecordCount;
    public final TextView txtVerifyContinueButton;

    private DialogProgenyListBinding(LinearLayout rootView, ImageView ivCancel, LinearLayout layoutVerifyButton, LinearLayout mainLayout, RecyclerView rvMapping, CardView searchByLocationCv, LinearLayout searchByLocationDetailsLl, TextView tvRecordCount, TextView txtVerifyContinueButton) {
        this.rootView = rootView;
        this.ivCancel = ivCancel;
        this.layoutVerifyButton = layoutVerifyButton;
        this.mainLayout = mainLayout;
        this.rvMapping = rvMapping;
        this.searchByLocationCv = searchByLocationCv;
        this.searchByLocationDetailsLl = searchByLocationDetailsLl;
        this.tvRecordCount = tvRecordCount;
        this.txtVerifyContinueButton = txtVerifyContinueButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogProgenyListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogProgenyListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_progeny_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogProgenyListBinding bind(View rootView) {
        int i = R.id.iv_cancel;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_cancel);
        if (imageView != null) {
            i = R.id.layoutVerifyButton;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutVerifyButton);
            if (linearLayout != null) {
                i = R.id.mainLayout;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainLayout);
                if (linearLayout2 != null) {
                    i = R.id.rv_mapping;
                    RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.rv_mapping);
                    if (recyclerViewFindChildViewById != null) {
                        i = R.id.search_by_location_cv;
                        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.search_by_location_cv);
                        if (cardViewFindChildViewById != null) {
                            i = R.id.search_by_location_details_ll;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.search_by_location_details_ll);
                            if (linearLayout3 != null) {
                                i = R.id.tv_record_count;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_record_count);
                                if (textView != null) {
                                    i = R.id.txtVerifyContinueButton;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtVerifyContinueButton);
                                    if (textView2 != null) {
                                        return new DialogProgenyListBinding((LinearLayout) rootView, imageView, linearLayout, linearLayout2, recyclerViewFindChildViewById, cardViewFindChildViewById, linearLayout3, textView, textView2);
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
