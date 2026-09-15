package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class MappingAnomalyDetailsDialogBinding implements ViewBinding {
    public final ImageView ivCancel;
    public final LinearLayout lvDiffrelativeNameCurrentAndPrevious;
    public final LinearLayout lvParentNameMisMatch;
    public final LinearLayout lvRelMappingMisMatch;
    public final LinearLayout lvRelationDiffCurrentAndPrevious;
    public final LinearLayout lvRelativeAgeReason;
    public final LinearLayout lvSelfAgeVariation;
    public final LinearLayout lvSelfFNameAnomaly;
    public final LinearLayout lvSelfNameMismatch;
    public final LinearLayout lvSelfRelMappingMisMatch;
    public final EditText noremark;
    public final LinearLayout pendingLL;
    private final LinearLayout rootView;
    public final TextView tvDiffrelativeNameCurrentAndPrevious;
    public final TextView tvParentNameMisMatch;
    public final TextView tvRelMappingMisMatch;
    public final TextView tvRelationDiffCurrentAndPrevious;
    public final TextView tvRelativeAgeReason;
    public final TextView tvSelfAgeVariation;
    public final TextView tvSelfFNameAnomaly;
    public final TextView tvSelfNameMismatch;
    public final TextView tvSelfRelMappingMisMatch;
    public final TextView txtSubmit;

    private MappingAnomalyDetailsDialogBinding(LinearLayout rootView, ImageView ivCancel, LinearLayout lvDiffrelativeNameCurrentAndPrevious, LinearLayout lvParentNameMisMatch, LinearLayout lvRelMappingMisMatch, LinearLayout lvRelationDiffCurrentAndPrevious, LinearLayout lvRelativeAgeReason, LinearLayout lvSelfAgeVariation, LinearLayout lvSelfFNameAnomaly, LinearLayout lvSelfNameMismatch, LinearLayout lvSelfRelMappingMisMatch, EditText noremark, LinearLayout pendingLL, TextView tvDiffrelativeNameCurrentAndPrevious, TextView tvParentNameMisMatch, TextView tvRelMappingMisMatch, TextView tvRelationDiffCurrentAndPrevious, TextView tvRelativeAgeReason, TextView tvSelfAgeVariation, TextView tvSelfFNameAnomaly, TextView tvSelfNameMismatch, TextView tvSelfRelMappingMisMatch, TextView txtSubmit) {
        this.rootView = rootView;
        this.ivCancel = ivCancel;
        this.lvDiffrelativeNameCurrentAndPrevious = lvDiffrelativeNameCurrentAndPrevious;
        this.lvParentNameMisMatch = lvParentNameMisMatch;
        this.lvRelMappingMisMatch = lvRelMappingMisMatch;
        this.lvRelationDiffCurrentAndPrevious = lvRelationDiffCurrentAndPrevious;
        this.lvRelativeAgeReason = lvRelativeAgeReason;
        this.lvSelfAgeVariation = lvSelfAgeVariation;
        this.lvSelfFNameAnomaly = lvSelfFNameAnomaly;
        this.lvSelfNameMismatch = lvSelfNameMismatch;
        this.lvSelfRelMappingMisMatch = lvSelfRelMappingMisMatch;
        this.noremark = noremark;
        this.pendingLL = pendingLL;
        this.tvDiffrelativeNameCurrentAndPrevious = tvDiffrelativeNameCurrentAndPrevious;
        this.tvParentNameMisMatch = tvParentNameMisMatch;
        this.tvRelMappingMisMatch = tvRelMappingMisMatch;
        this.tvRelationDiffCurrentAndPrevious = tvRelationDiffCurrentAndPrevious;
        this.tvRelativeAgeReason = tvRelativeAgeReason;
        this.tvSelfAgeVariation = tvSelfAgeVariation;
        this.tvSelfFNameAnomaly = tvSelfFNameAnomaly;
        this.tvSelfNameMismatch = tvSelfNameMismatch;
        this.tvSelfRelMappingMisMatch = tvSelfRelMappingMisMatch;
        this.txtSubmit = txtSubmit;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MappingAnomalyDetailsDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MappingAnomalyDetailsDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.mapping_anomaly_details_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MappingAnomalyDetailsDialogBinding bind(View rootView) {
        int i = R.id.iv_cancel;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_cancel);
        if (imageView != null) {
            i = R.id.lv_diffrelativeNameCurrentAndPrevious;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_diffrelativeNameCurrentAndPrevious);
            if (linearLayout != null) {
                i = R.id.lv_parentNameMisMatch;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_parentNameMisMatch);
                if (linearLayout2 != null) {
                    i = R.id.lv_relMappingMisMatch;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_relMappingMisMatch);
                    if (linearLayout3 != null) {
                        i = R.id.lv_relationDiffCurrentAndPrevious;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_relationDiffCurrentAndPrevious);
                        if (linearLayout4 != null) {
                            i = R.id.lv_relativeAgeReason;
                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_relativeAgeReason);
                            if (linearLayout5 != null) {
                                i = R.id.lv_selfAgeVariation;
                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_selfAgeVariation);
                                if (linearLayout6 != null) {
                                    i = R.id.lv_selfFNameAnomaly;
                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_selfFNameAnomaly);
                                    if (linearLayout7 != null) {
                                        i = R.id.lv_selfNameMismatch;
                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_selfNameMismatch);
                                        if (linearLayout8 != null) {
                                            i = R.id.lv_selfRelMappingMisMatch;
                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_selfRelMappingMisMatch);
                                            if (linearLayout9 != null) {
                                                i = R.id.noremark;
                                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.noremark);
                                                if (editText != null) {
                                                    i = R.id.pendingLL;
                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pendingLL);
                                                    if (linearLayout10 != null) {
                                                        i = R.id.tv_diffrelativeNameCurrentAndPrevious;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_diffrelativeNameCurrentAndPrevious);
                                                        if (textView != null) {
                                                            i = R.id.tv_parentNameMisMatch;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_parentNameMisMatch);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_relMappingMisMatch;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relMappingMisMatch);
                                                                if (textView3 != null) {
                                                                    i = R.id.tv_relationDiffCurrentAndPrevious;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relationDiffCurrentAndPrevious);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_relativeAgeReason;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relativeAgeReason);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tv_selfAgeVariation;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_selfAgeVariation);
                                                                            if (textView6 != null) {
                                                                                i = R.id.tv_selfFNameAnomaly;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_selfFNameAnomaly);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.tv_selfNameMismatch;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_selfNameMismatch);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.tv_selfRelMappingMisMatch;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_selfRelMappingMisMatch);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.txt_submit;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_submit);
                                                                                            if (textView10 != null) {
                                                                                                return new MappingAnomalyDetailsDialogBinding((LinearLayout) rootView, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, editText, linearLayout10, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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
