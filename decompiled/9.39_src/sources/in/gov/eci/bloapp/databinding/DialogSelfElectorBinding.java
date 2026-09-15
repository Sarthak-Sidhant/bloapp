package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class DialogSelfElectorBinding implements ViewBinding {
    public final Button btnNo;
    public final Button btnYes;
    public final LinearLayout linearButtons;
    public final LinearLayout linearEpic;
    public final LinearLayout linearName;
    public final LinearLayout linearNameTrans;
    public final LinearLayout linearRealtionType;
    public final LinearLayout linearRelative;
    public final LinearLayout linearRelativeTrans;
    public final LinearLayout lvVerifyDetails;
    private final LinearLayout rootView;
    public final Spinner spElectorRelative;
    public final TextView txtDummyEpic;
    public final TextView txtDummyName;
    public final TextView txtDummyRelative;
    public final TextView txtDummyTypeRelation;
    public final TextView txtEpic;
    public final TextView txtHeading;
    public final TextView txtName;
    public final TextView txtNameTrans;
    public final TextView txtRelativeName;
    public final TextView txtRelativeNameTrans;
    public final TextView txtTypeRelation;

    private DialogSelfElectorBinding(LinearLayout rootView, Button btnNo, Button btnYes, LinearLayout linearButtons, LinearLayout linearEpic, LinearLayout linearName, LinearLayout linearNameTrans, LinearLayout linearRealtionType, LinearLayout linearRelative, LinearLayout linearRelativeTrans, LinearLayout lvVerifyDetails, Spinner spElectorRelative, TextView txtDummyEpic, TextView txtDummyName, TextView txtDummyRelative, TextView txtDummyTypeRelation, TextView txtEpic, TextView txtHeading, TextView txtName, TextView txtNameTrans, TextView txtRelativeName, TextView txtRelativeNameTrans, TextView txtTypeRelation) {
        this.rootView = rootView;
        this.btnNo = btnNo;
        this.btnYes = btnYes;
        this.linearButtons = linearButtons;
        this.linearEpic = linearEpic;
        this.linearName = linearName;
        this.linearNameTrans = linearNameTrans;
        this.linearRealtionType = linearRealtionType;
        this.linearRelative = linearRelative;
        this.linearRelativeTrans = linearRelativeTrans;
        this.lvVerifyDetails = lvVerifyDetails;
        this.spElectorRelative = spElectorRelative;
        this.txtDummyEpic = txtDummyEpic;
        this.txtDummyName = txtDummyName;
        this.txtDummyRelative = txtDummyRelative;
        this.txtDummyTypeRelation = txtDummyTypeRelation;
        this.txtEpic = txtEpic;
        this.txtHeading = txtHeading;
        this.txtName = txtName;
        this.txtNameTrans = txtNameTrans;
        this.txtRelativeName = txtRelativeName;
        this.txtRelativeNameTrans = txtRelativeNameTrans;
        this.txtTypeRelation = txtTypeRelation;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogSelfElectorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogSelfElectorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_self_elector, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogSelfElectorBinding bind(View rootView) {
        int i = R.id.btnNo;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnNo);
        if (button != null) {
            i = R.id.btnYes;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnYes);
            if (button2 != null) {
                i = R.id.linearButtons;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearButtons);
                if (linearLayout != null) {
                    i = R.id.linearEpic;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearEpic);
                    if (linearLayout2 != null) {
                        i = R.id.linearName;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearName);
                        if (linearLayout3 != null) {
                            i = R.id.linearNameTrans;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearNameTrans);
                            if (linearLayout4 != null) {
                                i = R.id.linearRealtionType;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRealtionType);
                                if (linearLayout5 != null) {
                                    i = R.id.linearRelative;
                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRelative);
                                    if (linearLayout6 != null) {
                                        i = R.id.linearRelativeTrans;
                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRelativeTrans);
                                        if (linearLayout7 != null) {
                                            i = R.id.lv_verify_details;
                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_verify_details);
                                            if (linearLayout8 != null) {
                                                i = R.id.sp_elector_relative;
                                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.sp_elector_relative);
                                                if (spinner != null) {
                                                    i = R.id.txtDummyEpic;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyEpic);
                                                    if (textView != null) {
                                                        i = R.id.txtDummyName;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyName);
                                                        if (textView2 != null) {
                                                            i = R.id.txtDummyRelative;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyRelative);
                                                            if (textView3 != null) {
                                                                i = R.id.txtDummyTypeRelation;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyTypeRelation);
                                                                if (textView4 != null) {
                                                                    i = R.id.txtEpic;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtEpic);
                                                                    if (textView5 != null) {
                                                                        i = R.id.txtHeading;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtHeading);
                                                                        if (textView6 != null) {
                                                                            i = R.id.txtName;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtName);
                                                                            if (textView7 != null) {
                                                                                i = R.id.txtNameTrans;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtNameTrans);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.txtRelativeName;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtRelativeName);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.txtRelativeNameTrans;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtRelativeNameTrans);
                                                                                        if (textView10 != null) {
                                                                                            i = R.id.txtTypeRelation;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTypeRelation);
                                                                                            if (textView11 != null) {
                                                                                                return new DialogSelfElectorBinding((LinearLayout) rootView, button, button2, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, spinner, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
