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
public final class DialogUnmappedSelfElectorBinding implements ViewBinding {
    public final TextView CurrentEpic;
    public final TextView CurrentName;
    public final Button btnNo;
    public final Button btnVerify;
    public final Button btnYes;
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

    private DialogUnmappedSelfElectorBinding(LinearLayout rootView, TextView CurrentEpic, TextView CurrentName, Button btnNo, Button btnVerify, Button btnYes, TextView currentSerial, LinearLayout linearButtons, TextView txtConfirm, TextView txtCurrentRelativeName, TextView txtEpic, TextView txtHeading, TextView txtName, TextView txtOldAc, TextView txtOldPart, TextView txtPsl, TextView txtRelativeName) {
        this.rootView = rootView;
        this.CurrentEpic = CurrentEpic;
        this.CurrentName = CurrentName;
        this.btnNo = btnNo;
        this.btnVerify = btnVerify;
        this.btnYes = btnYes;
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

    public static DialogUnmappedSelfElectorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogUnmappedSelfElectorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_unmapped_self_elector, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogUnmappedSelfElectorBinding bind(View rootView) {
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
                            i = R.id.currentSerial;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.currentSerial);
                            if (textView3 != null) {
                                i = R.id.linearButtons;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearButtons);
                                if (linearLayout != null) {
                                    i = R.id.txtConfirm;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtConfirm);
                                    if (textView4 != null) {
                                        i = R.id.txtCurrentRelativeName;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtCurrentRelativeName);
                                        if (textView5 != null) {
                                            i = R.id.txtEpic;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtEpic);
                                            if (textView6 != null) {
                                                i = R.id.txtHeading;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtHeading);
                                                if (textView7 != null) {
                                                    i = R.id.txtName;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtName);
                                                    if (textView8 != null) {
                                                        i = R.id.txtOldAc;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtOldAc);
                                                        if (textView9 != null) {
                                                            i = R.id.txtOldPart;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtOldPart);
                                                            if (textView10 != null) {
                                                                i = R.id.txtPsl;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtPsl);
                                                                if (textView11 != null) {
                                                                    i = R.id.txtRelativeName;
                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtRelativeName);
                                                                    if (textView12 != null) {
                                                                        return new DialogUnmappedSelfElectorBinding((LinearLayout) rootView, textView, textView2, button, button2, button3, textView3, linearLayout, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
