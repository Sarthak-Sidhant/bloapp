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
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloActivityStatement6Binding implements ViewBinding {
    public final ImageView back;
    public final ImageView backPreview;
    public final TextView etElectorPopulationRatioAtTimeOfCurrentRevision;
    public final TextView etElectorPopulationRatioAtTimeOfCurrentRevisionPreview;
    public final TextView etElectorPopulationRationAtTimeOfPreviousRevision;
    public final TextView etElectorPopulationRationAtTimeOfPreviousRevisionPreview;
    public final TextView etIncreaseDecreaseInElectorPopulationRatio;
    public final TextView etIncreaseDecreaseInElectorPopulationRatioPreview;
    public final TextView etIncreaseDecreaseInTotalPopulationOfPartVillage;
    public final TextView etIncreaseDecreaseInTotalPopulationOfPartVillagePreview;
    public final EditText etNumberOfNewlyConstructedBuildings;
    public final TextView etNumberOfNewlyConstructedBuildingsPreview;
    public final EditText etNumberOfNewlyConstructedHouses;
    public final TextView etNumberOfNewlyConstructedHousesPreview;
    public final EditText etNumberOfNewlyConstructedSocieties;
    public final TextView etNumberOfNewlyConstructedSocietiesPreview;
    public final ImageView homeBtnIv;
    public final ImageView homePreviewBtnIv;
    public final TextView keepEditingButton;
    public final TextView previewButton;
    public final TextView resetButton;
    private final ConstraintLayout rootView;
    public final NestedScrollView scrollview;
    public final LinearLayout statement6CardView;
    public final CardView statement6FooterCardView;
    public final LinearLayout statement6PreviewCardView;
    public final CardView statement6PreviewFooterCardView;
    public final TextView submitButton;
    public final TextView title;
    public final ConstraintLayout titleBar;
    public final ConstraintLayout titleBarPreview;
    public final TextView titlePreview;

    private BloActivityStatement6Binding(ConstraintLayout rootView, ImageView back, ImageView backPreview, TextView etElectorPopulationRatioAtTimeOfCurrentRevision, TextView etElectorPopulationRatioAtTimeOfCurrentRevisionPreview, TextView etElectorPopulationRationAtTimeOfPreviousRevision, TextView etElectorPopulationRationAtTimeOfPreviousRevisionPreview, TextView etIncreaseDecreaseInElectorPopulationRatio, TextView etIncreaseDecreaseInElectorPopulationRatioPreview, TextView etIncreaseDecreaseInTotalPopulationOfPartVillage, TextView etIncreaseDecreaseInTotalPopulationOfPartVillagePreview, EditText etNumberOfNewlyConstructedBuildings, TextView etNumberOfNewlyConstructedBuildingsPreview, EditText etNumberOfNewlyConstructedHouses, TextView etNumberOfNewlyConstructedHousesPreview, EditText etNumberOfNewlyConstructedSocieties, TextView etNumberOfNewlyConstructedSocietiesPreview, ImageView homeBtnIv, ImageView homePreviewBtnIv, TextView keepEditingButton, TextView previewButton, TextView resetButton, NestedScrollView scrollview, LinearLayout statement6CardView, CardView statement6FooterCardView, LinearLayout statement6PreviewCardView, CardView statement6PreviewFooterCardView, TextView submitButton, TextView title, ConstraintLayout titleBar, ConstraintLayout titleBarPreview, TextView titlePreview) {
        this.rootView = rootView;
        this.back = back;
        this.backPreview = backPreview;
        this.etElectorPopulationRatioAtTimeOfCurrentRevision = etElectorPopulationRatioAtTimeOfCurrentRevision;
        this.etElectorPopulationRatioAtTimeOfCurrentRevisionPreview = etElectorPopulationRatioAtTimeOfCurrentRevisionPreview;
        this.etElectorPopulationRationAtTimeOfPreviousRevision = etElectorPopulationRationAtTimeOfPreviousRevision;
        this.etElectorPopulationRationAtTimeOfPreviousRevisionPreview = etElectorPopulationRationAtTimeOfPreviousRevisionPreview;
        this.etIncreaseDecreaseInElectorPopulationRatio = etIncreaseDecreaseInElectorPopulationRatio;
        this.etIncreaseDecreaseInElectorPopulationRatioPreview = etIncreaseDecreaseInElectorPopulationRatioPreview;
        this.etIncreaseDecreaseInTotalPopulationOfPartVillage = etIncreaseDecreaseInTotalPopulationOfPartVillage;
        this.etIncreaseDecreaseInTotalPopulationOfPartVillagePreview = etIncreaseDecreaseInTotalPopulationOfPartVillagePreview;
        this.etNumberOfNewlyConstructedBuildings = etNumberOfNewlyConstructedBuildings;
        this.etNumberOfNewlyConstructedBuildingsPreview = etNumberOfNewlyConstructedBuildingsPreview;
        this.etNumberOfNewlyConstructedHouses = etNumberOfNewlyConstructedHouses;
        this.etNumberOfNewlyConstructedHousesPreview = etNumberOfNewlyConstructedHousesPreview;
        this.etNumberOfNewlyConstructedSocieties = etNumberOfNewlyConstructedSocieties;
        this.etNumberOfNewlyConstructedSocietiesPreview = etNumberOfNewlyConstructedSocietiesPreview;
        this.homeBtnIv = homeBtnIv;
        this.homePreviewBtnIv = homePreviewBtnIv;
        this.keepEditingButton = keepEditingButton;
        this.previewButton = previewButton;
        this.resetButton = resetButton;
        this.scrollview = scrollview;
        this.statement6CardView = statement6CardView;
        this.statement6FooterCardView = statement6FooterCardView;
        this.statement6PreviewCardView = statement6PreviewCardView;
        this.statement6PreviewFooterCardView = statement6PreviewFooterCardView;
        this.submitButton = submitButton;
        this.title = title;
        this.titleBar = titleBar;
        this.titleBarPreview = titleBarPreview;
        this.titlePreview = titlePreview;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityStatement6Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityStatement6Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_statement6, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityStatement6Binding bind(View rootView) {
        int i = 2131362452;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131362452);
        if (imageView != null) {
            i = R.id.backPreview;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backPreview);
            if (imageView2 != null) {
                i = R.id.et_elector_population_ratio_at_time_of_Current_Revision;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_elector_population_ratio_at_time_of_Current_Revision);
                if (textView != null) {
                    i = R.id.et_elector_population_ratio_at_time_of_Current_Revision_preview;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_elector_population_ratio_at_time_of_Current_Revision_preview);
                    if (textView2 != null) {
                        i = R.id.et_elector_population_ration_at_time_of_Previous_Revision;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_elector_population_ration_at_time_of_Previous_Revision);
                        if (textView3 != null) {
                            i = R.id.et_elector_population_ration_at_time_of_Previous_Revision_preview;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_elector_population_ration_at_time_of_Previous_Revision_preview);
                            if (textView4 != null) {
                                i = R.id.et_increase_Decrease_in_Elector_population_ratio;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_increase_Decrease_in_Elector_population_ratio);
                                if (textView5 != null) {
                                    i = R.id.et_increase_Decrease_in_Elector_population_ratio_preview;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_increase_Decrease_in_Elector_population_ratio_preview);
                                    if (textView6 != null) {
                                        i = R.id.et_increase_Decrease_in_Total_population_of_part_village;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_increase_Decrease_in_Total_population_of_part_village);
                                        if (textView7 != null) {
                                            i = R.id.et_increase_Decrease_in_Total_population_of_part_village_preview;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_increase_Decrease_in_Total_population_of_part_village_preview);
                                            if (textView8 != null) {
                                                i = R.id.et_number_of_newly_constructed_buildings;
                                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_number_of_newly_constructed_buildings);
                                                if (editText != null) {
                                                    i = R.id.et_number_of_newly_constructed_buildings_preview;
                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_number_of_newly_constructed_buildings_preview);
                                                    if (textView9 != null) {
                                                        i = R.id.et_number_of_newly_constructed_houses;
                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_number_of_newly_constructed_houses);
                                                        if (editText2 != null) {
                                                            i = R.id.et_number_of_newly_constructed_houses_preview;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_number_of_newly_constructed_houses_preview);
                                                            if (textView10 != null) {
                                                                i = R.id.et_number_of_newly_constructed_societies;
                                                                EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_number_of_newly_constructed_societies);
                                                                if (editText3 != null) {
                                                                    i = R.id.et_number_of_newly_constructed_societies_preview;
                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_number_of_newly_constructed_societies_preview);
                                                                    if (textView11 != null) {
                                                                        i = R.id.home_btn_iv;
                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                                                        if (imageView3 != null) {
                                                                            i = R.id.home_preview_btn_iv;
                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_preview_btn_iv);
                                                                            if (imageView4 != null) {
                                                                                i = R.id.keepEditingButton;
                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.keepEditingButton);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.previewButton;
                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.previewButton);
                                                                                    if (textView13 != null) {
                                                                                        i = R.id.resetButton;
                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resetButton);
                                                                                        if (textView14 != null) {
                                                                                            i = R.id.scrollview;
                                                                                            NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.scrollview);
                                                                                            if (nestedScrollViewFindChildViewById != null) {
                                                                                                i = R.id.statement6_cardView;
                                                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.statement6_cardView);
                                                                                                if (linearLayout != null) {
                                                                                                    i = R.id.statement6_footer_cardView;
                                                                                                    CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.statement6_footer_cardView);
                                                                                                    if (cardViewFindChildViewById != null) {
                                                                                                        i = R.id.statement6_preview_cardView;
                                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.statement6_preview_cardView);
                                                                                                        if (linearLayout2 != null) {
                                                                                                            i = R.id.statement6_preview_footer_cardView;
                                                                                                            CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.statement6_preview_footer_cardView);
                                                                                                            if (cardViewFindChildViewById2 != null) {
                                                                                                                i = R.id.submitButton;
                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submitButton);
                                                                                                                if (textView15 != null) {
                                                                                                                    i = 2131366197;
                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, 2131366197);
                                                                                                                    if (textView16 != null) {
                                                                                                                        i = R.id.titleBar;
                                                                                                                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.titleBar);
                                                                                                                        if (constraintLayoutFindChildViewById != null) {
                                                                                                                            i = R.id.titleBarPreview;
                                                                                                                            ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.titleBarPreview);
                                                                                                                            if (constraintLayoutFindChildViewById2 != null) {
                                                                                                                                i = R.id.titlePreview;
                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.titlePreview);
                                                                                                                                if (textView17 != null) {
                                                                                                                                    return new BloActivityStatement6Binding((ConstraintLayout) rootView, imageView, imageView2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, editText, textView9, editText2, textView10, editText3, textView11, imageView3, imageView4, textView12, textView13, textView14, nestedScrollViewFindChildViewById, linearLayout, cardViewFindChildViewById, linearLayout2, cardViewFindChildViewById2, textView15, textView16, constraintLayoutFindChildViewById, constraintLayoutFindChildViewById2, textView17);
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
