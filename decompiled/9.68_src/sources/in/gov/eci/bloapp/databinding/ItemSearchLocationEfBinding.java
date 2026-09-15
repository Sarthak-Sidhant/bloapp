package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ItemSearchLocationEfBinding implements ViewBinding {
    public final ImageView icon;
    public final LinearLayout linearEpic;
    public final LinearLayout linearEpicOld;
    public final LinearLayout linearName;
    public final LinearLayout linearNamev1;
    public final LinearLayout linearRealtionType;
    public final LinearLayout linearRelative;
    public final LinearLayout linearRelativev1;
    public final LinearLayout lvVerifyDetails;
    private final LinearLayout rootView;
    public final TextView txtDummyEpic;
    public final TextView txtDummyEpicold;
    public final TextView txtDummyName;
    public final TextView txtDummyNamev1;
    public final TextView txtDummyRelative;
    public final TextView txtDummyRelativev1;
    public final TextView txtDummyTypeRelation;
    public final TextView txtEpic;
    public final TextView txtEpicold;
    public final TextView txtName;
    public final TextView txtNamev1;
    public final TextView txtRelativeName;
    public final TextView txtRelativeNamev1;
    public final TextView txtTypeRelation;

    private ItemSearchLocationEfBinding(LinearLayout rootView, ImageView icon, LinearLayout linearEpic, LinearLayout linearEpicOld, LinearLayout linearName, LinearLayout linearNamev1, LinearLayout linearRealtionType, LinearLayout linearRelative, LinearLayout linearRelativev1, LinearLayout lvVerifyDetails, TextView txtDummyEpic, TextView txtDummyEpicold, TextView txtDummyName, TextView txtDummyNamev1, TextView txtDummyRelative, TextView txtDummyRelativev1, TextView txtDummyTypeRelation, TextView txtEpic, TextView txtEpicold, TextView txtName, TextView txtNamev1, TextView txtRelativeName, TextView txtRelativeNamev1, TextView txtTypeRelation) {
        this.rootView = rootView;
        this.icon = icon;
        this.linearEpic = linearEpic;
        this.linearEpicOld = linearEpicOld;
        this.linearName = linearName;
        this.linearNamev1 = linearNamev1;
        this.linearRealtionType = linearRealtionType;
        this.linearRelative = linearRelative;
        this.linearRelativev1 = linearRelativev1;
        this.lvVerifyDetails = lvVerifyDetails;
        this.txtDummyEpic = txtDummyEpic;
        this.txtDummyEpicold = txtDummyEpicold;
        this.txtDummyName = txtDummyName;
        this.txtDummyNamev1 = txtDummyNamev1;
        this.txtDummyRelative = txtDummyRelative;
        this.txtDummyRelativev1 = txtDummyRelativev1;
        this.txtDummyTypeRelation = txtDummyTypeRelation;
        this.txtEpic = txtEpic;
        this.txtEpicold = txtEpicold;
        this.txtName = txtName;
        this.txtNamev1 = txtNamev1;
        this.txtRelativeName = txtRelativeName;
        this.txtRelativeNamev1 = txtRelativeNamev1;
        this.txtTypeRelation = txtTypeRelation;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemSearchLocationEfBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemSearchLocationEfBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_search_location_ef, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemSearchLocationEfBinding bind(View rootView) {
        int i = 2131364251;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131364251);
        if (imageView != null) {
            i = R.id.linearEpic;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearEpic);
            if (linearLayout != null) {
                i = R.id.linearEpic_old;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearEpic_old);
                if (linearLayout2 != null) {
                    i = R.id.linearName;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearName);
                    if (linearLayout3 != null) {
                        i = R.id.linearNamev1;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearNamev1);
                        if (linearLayout4 != null) {
                            i = R.id.linearRealtionType;
                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRealtionType);
                            if (linearLayout5 != null) {
                                i = R.id.linearRelative;
                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRelative);
                                if (linearLayout6 != null) {
                                    i = R.id.linearRelativev1;
                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRelativev1);
                                    if (linearLayout7 != null) {
                                        i = R.id.lv_verify_details;
                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_verify_details);
                                        if (linearLayout8 != null) {
                                            i = R.id.txtDummyEpic;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyEpic);
                                            if (textView != null) {
                                                i = R.id.txtDummyEpicold;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyEpicold);
                                                if (textView2 != null) {
                                                    i = R.id.txtDummyName;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyName);
                                                    if (textView3 != null) {
                                                        i = R.id.txtDummyNamev1;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyNamev1);
                                                        if (textView4 != null) {
                                                            i = R.id.txtDummyRelative;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyRelative);
                                                            if (textView5 != null) {
                                                                i = R.id.txtDummyRelativev1;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyRelativev1);
                                                                if (textView6 != null) {
                                                                    i = R.id.txtDummyTypeRelation;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyTypeRelation);
                                                                    if (textView7 != null) {
                                                                        i = R.id.txtEpic;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtEpic);
                                                                        if (textView8 != null) {
                                                                            i = R.id.txtEpicold;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtEpicold);
                                                                            if (textView9 != null) {
                                                                                i = R.id.txtName;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtName);
                                                                                if (textView10 != null) {
                                                                                    i = R.id.txtNamev1;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtNamev1);
                                                                                    if (textView11 != null) {
                                                                                        i = R.id.txtRelativeName;
                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtRelativeName);
                                                                                        if (textView12 != null) {
                                                                                            i = R.id.txtRelativeNamev1;
                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtRelativeNamev1);
                                                                                            if (textView13 != null) {
                                                                                                i = R.id.txtTypeRelation;
                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTypeRelation);
                                                                                                if (textView14 != null) {
                                                                                                    return new ItemSearchLocationEfBinding((LinearLayout) rootView, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
