package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class EfTrackerMatchEpicAlertBinding implements ViewBinding {
    public final LinearLayout acPSL;
    public final LinearLayout acPartSerialName;
    public final LinearLayout acPartSerialNumber;
    public final LinearLayout acPartStateName;
    public final ConstraintLayout cl1;
    public final ImageView cross;
    public final LinearLayout linearEpic;
    public final LinearLayout linearName;
    public final LinearLayout linearPartName;
    public final LinearLayout linearPartNumber;
    public final LinearLayout linearRealtionType;
    public final LinearLayout linearRelative;
    private final LinearLayout rootView;
    public final TextView tvAddPhoto;
    public final TextView txtAcPartSerialName;
    public final TextView txtAcPartSerialNumber;
    public final TextView txtAcPartStateName;
    public final TextView txtDummyEpic;
    public final TextView txtDummyName;
    public final TextView txtDummyRelative;
    public final TextView txtDummyTypeRelation;
    public final TextView txtEpic;
    public final TextView txtName;
    public final TextView txtPartName;
    public final TextView txtPartNumber;
    public final TextView txtPsl;
    public final TextView txtRelativeName;
    public final TextView txtTypeRelation;

    private EfTrackerMatchEpicAlertBinding(LinearLayout rootView, LinearLayout acPSL, LinearLayout acPartSerialName, LinearLayout acPartSerialNumber, LinearLayout acPartStateName, ConstraintLayout cl1, ImageView cross, LinearLayout linearEpic, LinearLayout linearName, LinearLayout linearPartName, LinearLayout linearPartNumber, LinearLayout linearRealtionType, LinearLayout linearRelative, TextView tvAddPhoto, TextView txtAcPartSerialName, TextView txtAcPartSerialNumber, TextView txtAcPartStateName, TextView txtDummyEpic, TextView txtDummyName, TextView txtDummyRelative, TextView txtDummyTypeRelation, TextView txtEpic, TextView txtName, TextView txtPartName, TextView txtPartNumber, TextView txtPsl, TextView txtRelativeName, TextView txtTypeRelation) {
        this.rootView = rootView;
        this.acPSL = acPSL;
        this.acPartSerialName = acPartSerialName;
        this.acPartSerialNumber = acPartSerialNumber;
        this.acPartStateName = acPartStateName;
        this.cl1 = cl1;
        this.cross = cross;
        this.linearEpic = linearEpic;
        this.linearName = linearName;
        this.linearPartName = linearPartName;
        this.linearPartNumber = linearPartNumber;
        this.linearRealtionType = linearRealtionType;
        this.linearRelative = linearRelative;
        this.tvAddPhoto = tvAddPhoto;
        this.txtAcPartSerialName = txtAcPartSerialName;
        this.txtAcPartSerialNumber = txtAcPartSerialNumber;
        this.txtAcPartStateName = txtAcPartStateName;
        this.txtDummyEpic = txtDummyEpic;
        this.txtDummyName = txtDummyName;
        this.txtDummyRelative = txtDummyRelative;
        this.txtDummyTypeRelation = txtDummyTypeRelation;
        this.txtEpic = txtEpic;
        this.txtName = txtName;
        this.txtPartName = txtPartName;
        this.txtPartNumber = txtPartNumber;
        this.txtPsl = txtPsl;
        this.txtRelativeName = txtRelativeName;
        this.txtTypeRelation = txtTypeRelation;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EfTrackerMatchEpicAlertBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EfTrackerMatchEpicAlertBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ef_tracker_match_epic_alert, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EfTrackerMatchEpicAlertBinding bind(View rootView) {
        int i = R.id.acPSL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.acPSL);
        if (linearLayout != null) {
            i = R.id.acPartSerialName;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.acPartSerialName);
            if (linearLayout2 != null) {
                i = R.id.acPartSerialNumber;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.acPartSerialNumber);
                if (linearLayout3 != null) {
                    i = R.id.acPartStateName;
                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.acPartStateName);
                    if (linearLayout4 != null) {
                        i = R.id.cl1;
                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cl1);
                        if (constraintLayoutFindChildViewById != null) {
                            i = R.id.cross;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross);
                            if (imageView != null) {
                                i = R.id.linearEpic;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearEpic);
                                if (linearLayout5 != null) {
                                    i = R.id.linearName;
                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearName);
                                    if (linearLayout6 != null) {
                                        i = R.id.linearPartName;
                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearPartName);
                                        if (linearLayout7 != null) {
                                            i = R.id.linearPartNumber;
                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearPartNumber);
                                            if (linearLayout8 != null) {
                                                i = R.id.linearRealtionType;
                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRealtionType);
                                                if (linearLayout9 != null) {
                                                    i = R.id.linearRelative;
                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRelative);
                                                    if (linearLayout10 != null) {
                                                        i = R.id.tv_add_photo;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_add_photo);
                                                        if (textView != null) {
                                                            i = R.id.txtAcPartSerialName;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtAcPartSerialName);
                                                            if (textView2 != null) {
                                                                i = R.id.txtAcPartSerialNumber;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtAcPartSerialNumber);
                                                                if (textView3 != null) {
                                                                    i = R.id.txtAcPartStateName;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtAcPartStateName);
                                                                    if (textView4 != null) {
                                                                        i = R.id.txtDummyEpic;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyEpic);
                                                                        if (textView5 != null) {
                                                                            i = R.id.txtDummyName;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyName);
                                                                            if (textView6 != null) {
                                                                                i = R.id.txtDummyRelative;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyRelative);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.txtDummyTypeRelation;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyTypeRelation);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.txtEpic;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtEpic);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.txtName;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtName);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.txtPartName;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtPartName);
                                                                                                if (textView11 != null) {
                                                                                                    i = R.id.txtPartNumber;
                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtPartNumber);
                                                                                                    if (textView12 != null) {
                                                                                                        i = R.id.txtPsl;
                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtPsl);
                                                                                                        if (textView13 != null) {
                                                                                                            i = R.id.txtRelativeName;
                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtRelativeName);
                                                                                                            if (textView14 != null) {
                                                                                                                i = R.id.txtTypeRelation;
                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTypeRelation);
                                                                                                                if (textView15 != null) {
                                                                                                                    return new EfTrackerMatchEpicAlertBinding((LinearLayout) rootView, linearLayout, linearLayout2, linearLayout3, linearLayout4, constraintLayoutFindChildViewById, imageView, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15);
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
