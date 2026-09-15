package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentVoterFormsBinding implements ViewBinding {
    public final LinearLayout aadhaarAuthLayout;
    public final ImageView backBtnIv;
    public final LinearLayout constraintLayout;
    public final LinearLayout correction;
    public final TextView correctionEntriesTv;
    public final LinearLayout deletionLayout;
    public final TextView deletionTv;
    public final LinearLayout formOverseasLayout;
    public final TextView formsDraft;
    public final TextView formsOfflineCountTv;
    public final TextView formsOfflineTv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final LinearLayout linearOfflineForms;
    public final NestedScrollView nested;
    public final LinearLayout newVoterRegistrationLayout;
    public final TextView newVoterTv;
    private final ConstraintLayout rootView;
    public final TextView servicesTv;
    public final TextView shiftingOutTv;
    public final TextView shiftingWithinTv;
    public final TextView textView10;
    public final TextView textView3;
    public final TextView textView5;
    public final TextView textView6;
    public final TextView textView7;
    public final TextView textView8;
    public final TextView textViewdraft;
    public final LinearLayout trackApplicationLayout;
    public final TextView trackapplication;

    private BloFragmentVoterFormsBinding(ConstraintLayout rootView, LinearLayout aadhaarAuthLayout, ImageView backBtnIv, LinearLayout constraintLayout, LinearLayout correction, TextView correctionEntriesTv, LinearLayout deletionLayout, TextView deletionTv, LinearLayout formOverseasLayout, TextView formsDraft, TextView formsOfflineCountTv, TextView formsOfflineTv, ConstraintLayout homeFragmentTopConstraintLayout, LinearLayout linearOfflineForms, NestedScrollView nested, LinearLayout newVoterRegistrationLayout, TextView newVoterTv, TextView servicesTv, TextView shiftingOutTv, TextView shiftingWithinTv, TextView textView10, TextView textView3, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textViewdraft, LinearLayout trackApplicationLayout, TextView trackapplication) {
        this.rootView = rootView;
        this.aadhaarAuthLayout = aadhaarAuthLayout;
        this.backBtnIv = backBtnIv;
        this.constraintLayout = constraintLayout;
        this.correction = correction;
        this.correctionEntriesTv = correctionEntriesTv;
        this.deletionLayout = deletionLayout;
        this.deletionTv = deletionTv;
        this.formOverseasLayout = formOverseasLayout;
        this.formsDraft = formsDraft;
        this.formsOfflineCountTv = formsOfflineCountTv;
        this.formsOfflineTv = formsOfflineTv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.linearOfflineForms = linearOfflineForms;
        this.nested = nested;
        this.newVoterRegistrationLayout = newVoterRegistrationLayout;
        this.newVoterTv = newVoterTv;
        this.servicesTv = servicesTv;
        this.shiftingOutTv = shiftingOutTv;
        this.shiftingWithinTv = shiftingWithinTv;
        this.textView10 = textView10;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.textView6 = textView6;
        this.textView7 = textView7;
        this.textView8 = textView8;
        this.textViewdraft = textViewdraft;
        this.trackApplicationLayout = trackApplicationLayout;
        this.trackapplication = trackapplication;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentVoterFormsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentVoterFormsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_voter_forms, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentVoterFormsBinding bind(View rootView) {
        int i = R.id.aadhaar_auth_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.aadhaar_auth_layout);
        if (linearLayout != null) {
            i = R.id.back_btn_iv;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
            if (imageView != null) {
                i = R.id.constraintLayout;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                if (linearLayout2 != null) {
                    i = R.id.correction;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.correction);
                    if (linearLayout3 != null) {
                        i = R.id.correction_entries_tv;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.correction_entries_tv);
                        if (textView != null) {
                            i = R.id.deletion_layout;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.deletion_layout);
                            if (linearLayout4 != null) {
                                i = R.id.deletion_tv;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.deletion_tv);
                                if (textView2 != null) {
                                    i = R.id.form_overseas_layout;
                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.form_overseas_layout);
                                    if (linearLayout5 != null) {
                                        i = R.id.forms_draft;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.forms_draft);
                                        if (textView3 != null) {
                                            i = R.id.forms_offline_count_tv;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.forms_offline_count_tv);
                                            if (textView4 != null) {
                                                i = R.id.forms_offline_tv;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.forms_offline_tv);
                                                if (textView5 != null) {
                                                    i = R.id.home_fragment_top_constraint_layout;
                                                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                                                    if (constraintLayoutFindChildViewById != null) {
                                                        i = R.id.linearOfflineForms;
                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearOfflineForms);
                                                        if (linearLayout6 != null) {
                                                            i = R.id.nested;
                                                            NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.nested);
                                                            if (nestedScrollViewFindChildViewById != null) {
                                                                i = R.id.new_voter_registration_layout;
                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.new_voter_registration_layout);
                                                                if (linearLayout7 != null) {
                                                                    i = R.id.new_voter_tv;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.new_voter_tv);
                                                                    if (textView6 != null) {
                                                                        i = R.id.services_tv;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.services_tv);
                                                                        if (textView7 != null) {
                                                                            i = R.id.shifting_out_tv;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.shifting_out_tv);
                                                                            if (textView8 != null) {
                                                                                i = R.id.shifting_within_tv;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.shifting_within_tv);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.textView10;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView10);
                                                                                    if (textView10 != null) {
                                                                                        i = R.id.textView3;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                        if (textView11 != null) {
                                                                                            i = R.id.textView5;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                                                            if (textView12 != null) {
                                                                                                i = R.id.textView6;
                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView6);
                                                                                                if (textView13 != null) {
                                                                                                    i = R.id.textView7;
                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView7);
                                                                                                    if (textView14 != null) {
                                                                                                        i = R.id.textView8;
                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView8);
                                                                                                        if (textView15 != null) {
                                                                                                            i = R.id.textViewdraft;
                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textViewdraft);
                                                                                                            if (textView16 != null) {
                                                                                                                i = R.id.track_application_Layout;
                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.track_application_Layout);
                                                                                                                if (linearLayout8 != null) {
                                                                                                                    i = R.id.trackapplication;
                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.trackapplication);
                                                                                                                    if (textView17 != null) {
                                                                                                                        return new BloFragmentVoterFormsBinding((ConstraintLayout) rootView, linearLayout, imageView, linearLayout2, linearLayout3, textView, linearLayout4, textView2, linearLayout5, textView3, textView4, textView5, constraintLayoutFindChildViewById, linearLayout6, nestedScrollViewFindChildViewById, linearLayout7, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, linearLayout8, textView17);
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
