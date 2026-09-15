package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class CommonViewBinding implements ViewBinding {
    public final CardView cardDisabled;
    public final TextView electorNameTitle;
    public final TextView electorNameTitlev1;
    public final TextView lableState;
    private final LinearLayout rootView;
    public final TextView tvAcName;
    public final TextView tvDistrictName;
    public final TextView tvElectorName;
    public final TextView tvElectorNamev1;
    public final TextView tvOldAge;
    public final TextView tvOldEpic;
    public final TextView tvPartName;
    public final TextView tvRelativeName;
    public final TextView tvRelativeNamev1;
    public final TextView tvRelativeType;
    public final TextView tvSectionNo;
    public final TextView tvSerialName;
    public final TextView tvStateName;

    private CommonViewBinding(LinearLayout rootView, CardView cardDisabled, TextView electorNameTitle, TextView electorNameTitlev1, TextView lableState, TextView tvAcName, TextView tvDistrictName, TextView tvElectorName, TextView tvElectorNamev1, TextView tvOldAge, TextView tvOldEpic, TextView tvPartName, TextView tvRelativeName, TextView tvRelativeNamev1, TextView tvRelativeType, TextView tvSectionNo, TextView tvSerialName, TextView tvStateName) {
        this.rootView = rootView;
        this.cardDisabled = cardDisabled;
        this.electorNameTitle = electorNameTitle;
        this.electorNameTitlev1 = electorNameTitlev1;
        this.lableState = lableState;
        this.tvAcName = tvAcName;
        this.tvDistrictName = tvDistrictName;
        this.tvElectorName = tvElectorName;
        this.tvElectorNamev1 = tvElectorNamev1;
        this.tvOldAge = tvOldAge;
        this.tvOldEpic = tvOldEpic;
        this.tvPartName = tvPartName;
        this.tvRelativeName = tvRelativeName;
        this.tvRelativeNamev1 = tvRelativeNamev1;
        this.tvRelativeType = tvRelativeType;
        this.tvSectionNo = tvSectionNo;
        this.tvSerialName = tvSerialName;
        this.tvStateName = tvStateName;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CommonViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CommonViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.common_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CommonViewBinding bind(View rootView) {
        int i = R.id.card_disabled;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.card_disabled);
        if (cardViewFindChildViewById != null) {
            i = R.id.electorNameTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorNameTitle);
            if (textView != null) {
                i = R.id.electorNameTitlev1;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorNameTitlev1);
                if (textView2 != null) {
                    i = R.id.lable_state;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lable_state);
                    if (textView3 != null) {
                        i = R.id.tv_ac_name;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_ac_name);
                        if (textView4 != null) {
                            i = R.id.tv_district_name;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_district_name);
                            if (textView5 != null) {
                                i = R.id.tv_elector_name;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_name);
                                if (textView6 != null) {
                                    i = R.id.tv_elector_namev1;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_namev1);
                                    if (textView7 != null) {
                                        i = R.id.tv_old_age;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_old_age);
                                        if (textView8 != null) {
                                            i = R.id.tv_old_epic;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_old_epic);
                                            if (textView9 != null) {
                                                i = R.id.tv_part_name;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_part_name);
                                                if (textView10 != null) {
                                                    i = R.id.tv_relative_name;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_name);
                                                    if (textView11 != null) {
                                                        i = R.id.tv_relative_namev1;
                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_namev1);
                                                        if (textView12 != null) {
                                                            i = R.id.tv_relative_type;
                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_type);
                                                            if (textView13 != null) {
                                                                i = R.id.tv_section_no;
                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_section_no);
                                                                if (textView14 != null) {
                                                                    i = R.id.tv_serial_name;
                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_serial_name);
                                                                    if (textView15 != null) {
                                                                        i = R.id.tv_state_name;
                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_state_name);
                                                                        if (textView16 != null) {
                                                                            return new CommonViewBinding((LinearLayout) rootView, cardViewFindChildViewById, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
