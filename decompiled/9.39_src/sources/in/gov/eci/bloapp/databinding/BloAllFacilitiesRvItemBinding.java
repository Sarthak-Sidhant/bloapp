package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloAllFacilitiesRvItemBinding implements ViewBinding {
    public final View divider;
    public final EditText editTextFacilityRemark;
    public final Button facilityAvailableButton;
    public final LinearLayout facilityAvailableStatus;
    public final LinearLayout facilityButtons;
    public final ImageView facilityEditButton;
    public final LinearLayout facilityHeader;
    public final ImageView facilityImage;
    public final LinearLayout facilityItemsLayout;
    public final Button facilityNotAvailableButton;
    public final ImageView facilityRefreshButton;
    public final LinearLayout facilityStatusAverage;
    public final ImageView facilityStatusAverageImage;
    public final LinearLayout facilityStatusGood;
    public final ImageView facilityStatusGoodImage;
    public final LinearLayout facilityStatusPoor;
    public final ImageView facilityStatusPoorImage;
    public final LinearLayout layout;
    private final LinearLayout rootView;
    public final TextView textViewAmfEmfFacility;
    public final TextView textViewFacility;
    public final TextView textViewFacilityStatusAverage;
    public final TextView textViewFacilityStatusGood;
    public final TextView textViewFacilityStatusPoor;

    private BloAllFacilitiesRvItemBinding(LinearLayout rootView, View divider, EditText editTextFacilityRemark, Button facilityAvailableButton, LinearLayout facilityAvailableStatus, LinearLayout facilityButtons, ImageView facilityEditButton, LinearLayout facilityHeader, ImageView facilityImage, LinearLayout facilityItemsLayout, Button facilityNotAvailableButton, ImageView facilityRefreshButton, LinearLayout facilityStatusAverage, ImageView facilityStatusAverageImage, LinearLayout facilityStatusGood, ImageView facilityStatusGoodImage, LinearLayout facilityStatusPoor, ImageView facilityStatusPoorImage, LinearLayout layout, TextView textViewAmfEmfFacility, TextView textViewFacility, TextView textViewFacilityStatusAverage, TextView textViewFacilityStatusGood, TextView textViewFacilityStatusPoor) {
        this.rootView = rootView;
        this.divider = divider;
        this.editTextFacilityRemark = editTextFacilityRemark;
        this.facilityAvailableButton = facilityAvailableButton;
        this.facilityAvailableStatus = facilityAvailableStatus;
        this.facilityButtons = facilityButtons;
        this.facilityEditButton = facilityEditButton;
        this.facilityHeader = facilityHeader;
        this.facilityImage = facilityImage;
        this.facilityItemsLayout = facilityItemsLayout;
        this.facilityNotAvailableButton = facilityNotAvailableButton;
        this.facilityRefreshButton = facilityRefreshButton;
        this.facilityStatusAverage = facilityStatusAverage;
        this.facilityStatusAverageImage = facilityStatusAverageImage;
        this.facilityStatusGood = facilityStatusGood;
        this.facilityStatusGoodImage = facilityStatusGoodImage;
        this.facilityStatusPoor = facilityStatusPoor;
        this.facilityStatusPoorImage = facilityStatusPoorImage;
        this.layout = layout;
        this.textViewAmfEmfFacility = textViewAmfEmfFacility;
        this.textViewFacility = textViewFacility;
        this.textViewFacilityStatusAverage = textViewFacilityStatusAverage;
        this.textViewFacilityStatusGood = textViewFacilityStatusGood;
        this.textViewFacilityStatusPoor = textViewFacilityStatusPoor;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloAllFacilitiesRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloAllFacilitiesRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_all_facilities_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloAllFacilitiesRvItemBinding bind(View rootView) {
        int i = R.id.divider;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider);
        if (viewFindChildViewById != null) {
            i = R.id.editText_facility_remark;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.editText_facility_remark);
            if (editText != null) {
                i = R.id.facility_available_Button;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.facility_available_Button);
                if (button != null) {
                    i = R.id.facility_available_status;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.facility_available_status);
                    if (linearLayout != null) {
                        i = R.id.facility_buttons;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.facility_buttons);
                        if (linearLayout2 != null) {
                            i = R.id.facility_edit_Button;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.facility_edit_Button);
                            if (imageView != null) {
                                i = R.id.facility_header;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.facility_header);
                                if (linearLayout3 != null) {
                                    i = R.id.facility_image;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.facility_image);
                                    if (imageView2 != null) {
                                        i = R.id.facility_items_layout;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.facility_items_layout);
                                        if (linearLayout4 != null) {
                                            i = R.id.facility_not_available_Button;
                                            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.facility_not_available_Button);
                                            if (button2 != null) {
                                                i = R.id.facility_refresh_Button;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.facility_refresh_Button);
                                                if (imageView3 != null) {
                                                    i = R.id.facility_status_average;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.facility_status_average);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.facility_status_average_image;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.facility_status_average_image);
                                                        if (imageView4 != null) {
                                                            i = R.id.facility_status_good;
                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.facility_status_good);
                                                            if (linearLayout6 != null) {
                                                                i = R.id.facility_status_good_image;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.facility_status_good_image);
                                                                if (imageView5 != null) {
                                                                    i = R.id.facility_status_poor;
                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.facility_status_poor);
                                                                    if (linearLayout7 != null) {
                                                                        i = R.id.facility_status_poor_image;
                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.facility_status_poor_image);
                                                                        if (imageView6 != null) {
                                                                            i = 2131364291;
                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, 2131364291);
                                                                            if (linearLayout8 != null) {
                                                                                i = R.id.textView_amf_emf_facility;
                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_amf_emf_facility);
                                                                                if (textView != null) {
                                                                                    i = R.id.textView_facility;
                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_facility);
                                                                                    if (textView2 != null) {
                                                                                        i = R.id.textView_facility_status_average;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_facility_status_average);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.textView_facility_status_good;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_facility_status_good);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.textView_facility_status_poor;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_facility_status_poor);
                                                                                                if (textView5 != null) {
                                                                                                    return new BloAllFacilitiesRvItemBinding((LinearLayout) rootView, viewFindChildViewById, editText, button, linearLayout, linearLayout2, imageView, linearLayout3, imageView2, linearLayout4, button2, imageView3, linearLayout5, imageView4, linearLayout6, imageView5, linearLayout7, imageView6, linearLayout8, textView, textView2, textView3, textView4, textView5);
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
