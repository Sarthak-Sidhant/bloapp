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
public final class DialogUnmappedElectorBinding implements ViewBinding {
    public final TextView CurrentEpic;
    public final TextView CurrentName;
    public final Button btnNo;
    public final Button btnVerify;
    public final Button btnYes;
    public final TextView currentAC;
    public final TextView currentPart;
    public final TextView currentSerial;
    public final LinearLayout linearButtons;
    private final LinearLayout rootView;
    public final TextView txtConfirm;
    public final TextView txtCurrentRelativeName;
    public final TextView txtEpic;
    public final TextView txtHeading;
    public final TextView txtName;
    public final TextView txtOldAc;
    public final TextView txtOldPart;
    public final TextView txtPsl;
    public final TextView txtRelativeName;

    private DialogUnmappedElectorBinding(LinearLayout rootView, TextView CurrentEpic, TextView CurrentName, Button btnNo, Button btnVerify, Button btnYes, TextView currentAC, TextView currentPart, TextView currentSerial, LinearLayout linearButtons, TextView txtConfirm, TextView txtCurrentRelativeName, TextView txtEpic, TextView txtHeading, TextView txtName, TextView txtOldAc, TextView txtOldPart, TextView txtPsl, TextView txtRelativeName) {
        this.rootView = rootView;
        this.CurrentEpic = CurrentEpic;
        this.CurrentName = CurrentName;
        this.btnNo = btnNo;
        this.btnVerify = btnVerify;
        this.btnYes = btnYes;
        this.currentAC = currentAC;
        this.currentPart = currentPart;
        this.currentSerial = currentSerial;
        this.linearButtons = linearButtons;
        this.txtConfirm = txtConfirm;
        this.txtCurrentRelativeName = txtCurrentRelativeName;
        this.txtEpic = txtEpic;
        this.txtHeading = txtHeading;
        this.txtName = txtName;
        this.txtOldAc = txtOldAc;
        this.txtOldPart = txtOldPart;
        this.txtPsl = txtPsl;
        this.txtRelativeName = txtRelativeName;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogUnmappedElectorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogUnmappedElectorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_unmapped_elector, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogUnmappedElectorBinding bind(View rootView) {
        int i = R.id.CurrentEpic;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.CurrentEpic);
        if (textView != null) {
            i = R.id.CurrentName;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.CurrentName);
            if (textView2 != null) {
                i = R.id.btnNo;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnNo);
                if (button != null) {
                    i = R.id.btnVerify;
                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnVerify);
                    if (button2 != null) {
                        i = R.id.btnYes;
                        Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnYes);
                        if (button3 != null) {
                            i = R.id.currentAC;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.currentAC);
                            if (textView3 != null) {
                                i = R.id.currentPart;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.currentPart);
                                if (textView4 != null) {
                                    i = R.id.currentSerial;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.currentSerial);
                                    if (textView5 != null) {
                                        i = R.id.linearButtons;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearButtons);
                                        if (linearLayout != null) {
                                            i = R.id.txtConfirm;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtConfirm);
                                            if (textView6 != null) {
                                                i = R.id.txtCurrentRelativeName;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtCurrentRelativeName);
                                                if (textView7 != null) {
                                                    i = R.id.txtEpic;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtEpic);
                                                    if (textView8 != null) {
                                                        i = R.id.txtHeading;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtHeading);
                                                        if (textView9 != null) {
                                                            i = R.id.txtName;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtName);
                                                            if (textView10 != null) {
                                                                i = R.id.txtOldAc;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtOldAc);
                                                                if (textView11 != null) {
                                                                    i = R.id.txtOldPart;
                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtOldPart);
                                                                    if (textView12 != null) {
                                                                        i = R.id.txtPsl;
                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtPsl);
                                                                        if (textView13 != null) {
                                                                            i = R.id.txtRelativeName;
                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtRelativeName);
                                                                            if (textView14 != null) {
                                                                                return new DialogUnmappedElectorBinding((LinearLayout) rootView, textView, textView2, button, button2, button3, textView3, textView4, textView5, linearLayout, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
