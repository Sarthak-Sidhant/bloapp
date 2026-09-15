package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DialogVerifyElectorBinding implements ViewBinding {
    public final Button btnNo;
    public final Button btnYes;
    public final LinearLayout linearButtons;
    public final LinearLayout linearEpic;
    public final LinearLayout linearName;
    public final LinearLayout linearNameEpic;
    public final LinearLayout linearNameNew;
    public final LinearLayout linearNameNewRelative;
    public final LinearLayout linearNameTrans;
    public final LinearLayout linearRealtionType;
    public final LinearLayout linearRelative;
    public final LinearLayout linearRelativeTrans;
    private final LinearLayout rootView;
    public final TextView txtCurrentEpic;
    public final TextView txtCurrentName;
    public final TextView txtCurrentRelativeName;
    public final TextView txtDummyEpic;
    public final TextView txtDummyName;
    public final TextView txtDummyNameNew;
    public final TextView txtDummyRelative;
    public final TextView txtDummyTypeRelation;
    public final TextView txtEpic;
    public final TextView txtHeading;
    public final TextView txtName;
    public final TextView txtNameTrans;
    public final TextView txtRelativeName;
    public final TextView txtRelativeNameTrans;
    public final TextView txtSure;
    public final TextView txtSureNew;
    public final TextView txtTypeRelation;
    public final View viewLine;

    private DialogVerifyElectorBinding(LinearLayout rootView, Button btnNo, Button btnYes, LinearLayout linearButtons, LinearLayout linearEpic, LinearLayout linearName, LinearLayout linearNameEpic, LinearLayout linearNameNew, LinearLayout linearNameNewRelative, LinearLayout linearNameTrans, LinearLayout linearRealtionType, LinearLayout linearRelative, LinearLayout linearRelativeTrans, TextView txtCurrentEpic, TextView txtCurrentName, TextView txtCurrentRelativeName, TextView txtDummyEpic, TextView txtDummyName, TextView txtDummyNameNew, TextView txtDummyRelative, TextView txtDummyTypeRelation, TextView txtEpic, TextView txtHeading, TextView txtName, TextView txtNameTrans, TextView txtRelativeName, TextView txtRelativeNameTrans, TextView txtSure, TextView txtSureNew, TextView txtTypeRelation, View viewLine) {
        this.rootView = rootView;
        this.btnNo = btnNo;
        this.btnYes = btnYes;
        this.linearButtons = linearButtons;
        this.linearEpic = linearEpic;
        this.linearName = linearName;
        this.linearNameEpic = linearNameEpic;
        this.linearNameNew = linearNameNew;
        this.linearNameNewRelative = linearNameNewRelative;
        this.linearNameTrans = linearNameTrans;
        this.linearRealtionType = linearRealtionType;
        this.linearRelative = linearRelative;
        this.linearRelativeTrans = linearRelativeTrans;
        this.txtCurrentEpic = txtCurrentEpic;
        this.txtCurrentName = txtCurrentName;
        this.txtCurrentRelativeName = txtCurrentRelativeName;
        this.txtDummyEpic = txtDummyEpic;
        this.txtDummyName = txtDummyName;
        this.txtDummyNameNew = txtDummyNameNew;
        this.txtDummyRelative = txtDummyRelative;
        this.txtDummyTypeRelation = txtDummyTypeRelation;
        this.txtEpic = txtEpic;
        this.txtHeading = txtHeading;
        this.txtName = txtName;
        this.txtNameTrans = txtNameTrans;
        this.txtRelativeName = txtRelativeName;
        this.txtRelativeNameTrans = txtRelativeNameTrans;
        this.txtSure = txtSure;
        this.txtSureNew = txtSureNew;
        this.txtTypeRelation = txtTypeRelation;
        this.viewLine = viewLine;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogVerifyElectorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogVerifyElectorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_verify_elector, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogVerifyElectorBinding bind(View rootView) {
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
                            i = R.id.linearNameEpic;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearNameEpic);
                            if (linearLayout4 != null) {
                                i = R.id.linearNameNew;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearNameNew);
                                if (linearLayout5 != null) {
                                    i = R.id.linearNameNewRelative;
                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearNameNewRelative);
                                    if (linearLayout6 != null) {
                                        i = R.id.linearNameTrans;
                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearNameTrans);
                                        if (linearLayout7 != null) {
                                            i = R.id.linearRealtionType;
                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRealtionType);
                                            if (linearLayout8 != null) {
                                                i = R.id.linearRelative;
                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRelative);
                                                if (linearLayout9 != null) {
                                                    i = R.id.linearRelativeTrans;
                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRelativeTrans);
                                                    if (linearLayout10 != null) {
                                                        i = R.id.txtCurrentEpic;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtCurrentEpic);
                                                        if (textView != null) {
                                                            i = R.id.txtCurrentName;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtCurrentName);
                                                            if (textView2 != null) {
                                                                i = R.id.txtCurrentRelativeName;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtCurrentRelativeName);
                                                                if (textView3 != null) {
                                                                    i = R.id.txtDummyEpic;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyEpic);
                                                                    if (textView4 != null) {
                                                                        i = R.id.txtDummyName;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyName);
                                                                        if (textView5 != null) {
                                                                            i = R.id.txtDummyNameNew;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyNameNew);
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
                                                                                            i = R.id.txtHeading;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtHeading);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.txtName;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtName);
                                                                                                if (textView11 != null) {
                                                                                                    i = R.id.txtNameTrans;
                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtNameTrans);
                                                                                                    if (textView12 != null) {
                                                                                                        i = R.id.txtRelativeName;
                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtRelativeName);
                                                                                                        if (textView13 != null) {
                                                                                                            i = R.id.txtRelativeNameTrans;
                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtRelativeNameTrans);
                                                                                                            if (textView14 != null) {
                                                                                                                i = R.id.txtSure;
                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtSure);
                                                                                                                if (textView15 != null) {
                                                                                                                    i = R.id.txtSureNew;
                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtSureNew);
                                                                                                                    if (textView16 != null) {
                                                                                                                        i = R.id.txtTypeRelation;
                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTypeRelation);
                                                                                                                        if (textView17 != null) {
                                                                                                                            i = R.id.viewLine;
                                                                                                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewLine);
                                                                                                                            if (viewFindChildViewById != null) {
                                                                                                                                return new DialogVerifyElectorBinding((LinearLayout) rootView, button, button2, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, viewFindChildViewById);
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
