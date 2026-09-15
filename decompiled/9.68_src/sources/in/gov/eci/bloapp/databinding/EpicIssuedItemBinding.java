package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class EpicIssuedItemBinding implements ViewBinding {
    public final CardView cardDisabled;
    public final TextView electorNameCardDisable;
    public final ImageView icon;
    private final LinearLayout rootView;
    public final TextView tvAcName;
    public final TextView tvDob;
    public final TextView tvElectorName;
    public final TextView tvGender;
    public final TextView tvReference;
    public final TextView tvRelativeName;
    public final TextView tvRelativeType;
    public final TextView tvStateName;

    private EpicIssuedItemBinding(LinearLayout rootView, CardView cardDisabled, TextView electorNameCardDisable, ImageView icon, TextView tvAcName, TextView tvDob, TextView tvElectorName, TextView tvGender, TextView tvReference, TextView tvRelativeName, TextView tvRelativeType, TextView tvStateName) {
        this.rootView = rootView;
        this.cardDisabled = cardDisabled;
        this.electorNameCardDisable = electorNameCardDisable;
        this.icon = icon;
        this.tvAcName = tvAcName;
        this.tvDob = tvDob;
        this.tvElectorName = tvElectorName;
        this.tvGender = tvGender;
        this.tvReference = tvReference;
        this.tvRelativeName = tvRelativeName;
        this.tvRelativeType = tvRelativeType;
        this.tvStateName = tvStateName;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EpicIssuedItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EpicIssuedItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.epic_issued_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EpicIssuedItemBinding bind(View rootView) {
        int i = R.id.card_disabled;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.card_disabled);
        if (cardViewFindChildViewById != null) {
            i = R.id.electorNameCardDisable;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorNameCardDisable);
            if (textView != null) {
                i = 2131364251;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131364251);
                if (imageView != null) {
                    i = R.id.tv_ac_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_ac_name);
                    if (textView2 != null) {
                        i = R.id.tv_dob;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_dob);
                        if (textView3 != null) {
                            i = R.id.tv_elector_name;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_name);
                            if (textView4 != null) {
                                i = R.id.tv_gender;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_gender);
                                if (textView5 != null) {
                                    i = R.id.tv_reference;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_reference);
                                    if (textView6 != null) {
                                        i = R.id.tv_relative_name;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_name);
                                        if (textView7 != null) {
                                            i = R.id.tv_relative_type;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_type);
                                            if (textView8 != null) {
                                                i = R.id.tv_state_name;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_state_name);
                                                if (textView9 != null) {
                                                    return new EpicIssuedItemBinding((LinearLayout) rootView, cardViewFindChildViewById, textView, imageView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
