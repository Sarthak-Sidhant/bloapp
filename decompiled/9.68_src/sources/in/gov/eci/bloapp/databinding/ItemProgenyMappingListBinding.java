package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ItemProgenyMappingListBinding implements ViewBinding {
    public final CardView cardDisabled;
    public final TextView electorNameCardDisable;
    public final TextView electorNameCardDisablev1;
    public final ImageView icon;
    public final TextView lableState;
    public final LinearLayout lvVernacularName;
    public final LinearLayout matchingLayout;
    public final ProgressBar progressBar;
    public final LinearLayout relativeNameV1;
    private final LinearLayout rootView;
    public final TextView tvAcName;
    public final TextView tvDistrictName;
    public final TextView tvElectorName;
    public final TextView tvElectorNamev1;
    public final TextView tvLeftName;
    public final TextView tvOldAge;
    public final TextView tvOldEpic;
    public final TextView tvPartName;
    public final TextView tvRelativeName;
    public final TextView tvRelativeNamev1;
    public final TextView tvRelativeType;
    public final TextView tvRightName;
    public final TextView tvSectionName;
    public final TextView tvSerialName;
    public final TextView tvStateName;

    private ItemProgenyMappingListBinding(LinearLayout rootView, CardView cardDisabled, TextView electorNameCardDisable, TextView electorNameCardDisablev1, ImageView icon, TextView lableState, LinearLayout lvVernacularName, LinearLayout matchingLayout, ProgressBar progressBar, LinearLayout relativeNameV1, TextView tvAcName, TextView tvDistrictName, TextView tvElectorName, TextView tvElectorNamev1, TextView tvLeftName, TextView tvOldAge, TextView tvOldEpic, TextView tvPartName, TextView tvRelativeName, TextView tvRelativeNamev1, TextView tvRelativeType, TextView tvRightName, TextView tvSectionName, TextView tvSerialName, TextView tvStateName) {
        this.rootView = rootView;
        this.cardDisabled = cardDisabled;
        this.electorNameCardDisable = electorNameCardDisable;
        this.electorNameCardDisablev1 = electorNameCardDisablev1;
        this.icon = icon;
        this.lableState = lableState;
        this.lvVernacularName = lvVernacularName;
        this.matchingLayout = matchingLayout;
        this.progressBar = progressBar;
        this.relativeNameV1 = relativeNameV1;
        this.tvAcName = tvAcName;
        this.tvDistrictName = tvDistrictName;
        this.tvElectorName = tvElectorName;
        this.tvElectorNamev1 = tvElectorNamev1;
        this.tvLeftName = tvLeftName;
        this.tvOldAge = tvOldAge;
        this.tvOldEpic = tvOldEpic;
        this.tvPartName = tvPartName;
        this.tvRelativeName = tvRelativeName;
        this.tvRelativeNamev1 = tvRelativeNamev1;
        this.tvRelativeType = tvRelativeType;
        this.tvRightName = tvRightName;
        this.tvSectionName = tvSectionName;
        this.tvSerialName = tvSerialName;
        this.tvStateName = tvStateName;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemProgenyMappingListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemProgenyMappingListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_progeny_mapping_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemProgenyMappingListBinding bind(View rootView) {
        int i = R.id.card_disabled;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.card_disabled);
        if (cardViewFindChildViewById != null) {
            i = R.id.electorNameCardDisable;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorNameCardDisable);
            if (textView != null) {
                i = R.id.electorNameCardDisablev1;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorNameCardDisablev1);
                if (textView2 != null) {
                    i = 2131364251;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131364251);
                    if (imageView != null) {
                        i = R.id.lable_state;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lable_state);
                        if (textView3 != null) {
                            i = R.id.lvVernacularName;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lvVernacularName);
                            if (linearLayout != null) {
                                i = R.id.matchingLayout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.matchingLayout);
                                if (linearLayout2 != null) {
                                    i = R.id.progressBar;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                    if (progressBar != null) {
                                        i = R.id.relativeNameV1;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.relativeNameV1);
                                        if (linearLayout3 != null) {
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
                                                            i = R.id.tvLeftName;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvLeftName);
                                                            if (textView8 != null) {
                                                                i = R.id.tv_old_age;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_old_age);
                                                                if (textView9 != null) {
                                                                    i = R.id.tv_old_epic;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_old_epic);
                                                                    if (textView10 != null) {
                                                                        i = R.id.tv_part_name;
                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_part_name);
                                                                        if (textView11 != null) {
                                                                            i = R.id.tv_relative_name;
                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_name);
                                                                            if (textView12 != null) {
                                                                                i = R.id.tv_relative_namev1;
                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_namev1);
                                                                                if (textView13 != null) {
                                                                                    i = R.id.tv_relative_type;
                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_type);
                                                                                    if (textView14 != null) {
                                                                                        i = R.id.tvRightName;
                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvRightName);
                                                                                        if (textView15 != null) {
                                                                                            i = R.id.tv_section_name;
                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_section_name);
                                                                                            if (textView16 != null) {
                                                                                                i = R.id.tv_serial_name;
                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_serial_name);
                                                                                                if (textView17 != null) {
                                                                                                    i = R.id.tv_state_name;
                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_state_name);
                                                                                                    if (textView18 != null) {
                                                                                                        return new ItemProgenyMappingListBinding((LinearLayout) rootView, cardViewFindChildViewById, textView, textView2, imageView, textView3, linearLayout, linearLayout2, progressBar, linearLayout3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18);
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
