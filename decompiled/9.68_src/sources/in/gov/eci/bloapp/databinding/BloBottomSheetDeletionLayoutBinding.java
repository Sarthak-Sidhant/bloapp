package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloBottomSheetDeletionLayoutBinding implements ViewBinding {
    public final EditText bottomSheetEpicEd;
    public final EditText bottomSheetEpicEd2;
    public final LinearLayout bottomSheetEpicLayout;
    public final LinearLayout bottomSheetEpicLayout2;
    public final EditText bottomSheetFirstnameEd;
    public final EditText bottomSheetLastnameEd;
    public final LinearLayout bottomSheetNameLayout;
    public final RadioGroup bottomSheetRg;
    public final RadioGroup bottomSheetRg2;
    public final TextView btnProceed;
    public final TextView doc1Tv;
    public final ImageView dotTv;
    public final TextView firstNameTv;
    public final TextView formNameTv;
    public final ImageView imageView;
    public final RadioButton objectRb;
    public final RadioButton otherElectorRb;
    public final RadioButton prefilledEpicRb;
    public final RadioButton prefilledNameRb;
    public final TextView requiredDccTv;
    private final ConstraintLayout rootView;
    public final RadioButton sameEpicRb;
    public final TextView searchByTv;

    private BloBottomSheetDeletionLayoutBinding(ConstraintLayout rootView, EditText bottomSheetEpicEd, EditText bottomSheetEpicEd2, LinearLayout bottomSheetEpicLayout, LinearLayout bottomSheetEpicLayout2, EditText bottomSheetFirstnameEd, EditText bottomSheetLastnameEd, LinearLayout bottomSheetNameLayout, RadioGroup bottomSheetRg, RadioGroup bottomSheetRg2, TextView btnProceed, TextView doc1Tv, ImageView dotTv, TextView firstNameTv, TextView formNameTv, ImageView imageView, RadioButton objectRb, RadioButton otherElectorRb, RadioButton prefilledEpicRb, RadioButton prefilledNameRb, TextView requiredDccTv, RadioButton sameEpicRb, TextView searchByTv) {
        this.rootView = rootView;
        this.bottomSheetEpicEd = bottomSheetEpicEd;
        this.bottomSheetEpicEd2 = bottomSheetEpicEd2;
        this.bottomSheetEpicLayout = bottomSheetEpicLayout;
        this.bottomSheetEpicLayout2 = bottomSheetEpicLayout2;
        this.bottomSheetFirstnameEd = bottomSheetFirstnameEd;
        this.bottomSheetLastnameEd = bottomSheetLastnameEd;
        this.bottomSheetNameLayout = bottomSheetNameLayout;
        this.bottomSheetRg = bottomSheetRg;
        this.bottomSheetRg2 = bottomSheetRg2;
        this.btnProceed = btnProceed;
        this.doc1Tv = doc1Tv;
        this.dotTv = dotTv;
        this.firstNameTv = firstNameTv;
        this.formNameTv = formNameTv;
        this.imageView = imageView;
        this.objectRb = objectRb;
        this.otherElectorRb = otherElectorRb;
        this.prefilledEpicRb = prefilledEpicRb;
        this.prefilledNameRb = prefilledNameRb;
        this.requiredDccTv = requiredDccTv;
        this.sameEpicRb = sameEpicRb;
        this.searchByTv = searchByTv;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloBottomSheetDeletionLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloBottomSheetDeletionLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_bottom_sheet_deletion_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloBottomSheetDeletionLayoutBinding bind(View rootView) {
        int i = R.id.bottom_sheet_epic_ed;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.bottom_sheet_epic_ed);
        if (editText != null) {
            i = R.id.bottom_sheet_epic_ed2;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.bottom_sheet_epic_ed2);
            if (editText2 != null) {
                i = R.id.bottom_sheet_epic_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottom_sheet_epic_layout);
                if (linearLayout != null) {
                    i = R.id.bottom_sheet_epic_layout2;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottom_sheet_epic_layout2);
                    if (linearLayout2 != null) {
                        i = R.id.bottom_sheet_firstname_ed;
                        EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.bottom_sheet_firstname_ed);
                        if (editText3 != null) {
                            i = R.id.bottom_sheet_lastname_ed;
                            EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.bottom_sheet_lastname_ed);
                            if (editText4 != null) {
                                i = R.id.bottom_sheet_name_layout;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottom_sheet_name_layout);
                                if (linearLayout3 != null) {
                                    i = R.id.bottom_sheet_rg;
                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.bottom_sheet_rg);
                                    if (radioGroup != null) {
                                        i = R.id.bottom_sheet_rg2;
                                        RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.bottom_sheet_rg2);
                                        if (radioGroup2 != null) {
                                            i = R.id.btn_Proceed;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.btn_Proceed);
                                            if (textView != null) {
                                                i = R.id.doc1_tv;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc1_tv);
                                                if (textView2 != null) {
                                                    i = R.id.dot_tv;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dot_tv);
                                                    if (imageView != null) {
                                                        i = R.id.first_name_tv;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_tv);
                                                        if (textView3 != null) {
                                                            i = R.id.form_name_tv;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_name_tv);
                                                            if (textView4 != null) {
                                                                i = R.id.imageView;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                                                                if (imageView2 != null) {
                                                                    i = R.id.object_rb;
                                                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.object_rb);
                                                                    if (radioButton != null) {
                                                                        i = R.id.other_elector_rb;
                                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.other_elector_rb);
                                                                        if (radioButton2 != null) {
                                                                            i = R.id.prefilled_epic_rb;
                                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.prefilled_epic_rb);
                                                                            if (radioButton3 != null) {
                                                                                i = R.id.prefilled_name_rb;
                                                                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.prefilled_name_rb);
                                                                                if (radioButton4 != null) {
                                                                                    i = R.id.required_dcc_tv;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.required_dcc_tv);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.same_epic_rb;
                                                                                        RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.same_epic_rb);
                                                                                        if (radioButton5 != null) {
                                                                                            i = R.id.search_by_tv;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.search_by_tv);
                                                                                            if (textView6 != null) {
                                                                                                return new BloBottomSheetDeletionLayoutBinding((ConstraintLayout) rootView, editText, editText2, linearLayout, linearLayout2, editText3, editText4, linearLayout3, radioGroup, radioGroup2, textView, textView2, imageView, textView3, textView4, imageView2, radioButton, radioButton2, radioButton3, radioButton4, textView5, radioButton5, textView6);
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
