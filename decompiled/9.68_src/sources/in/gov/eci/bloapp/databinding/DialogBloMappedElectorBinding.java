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
public final class DialogBloMappedElectorBinding implements ViewBinding {
    public final Button btnNo;
    public final Button btnYes;
    public final LinearLayout linearBLOName;
    public final LinearLayout linearBLoPhone;
    public final LinearLayout linearButtons;
    public final LinearLayout linearEpic;
    public final LinearLayout linearName;
    public final LinearLayout linearRealtionType;
    public final LinearLayout linearRelative;
    private final LinearLayout rootView;
    public final TextView txName;
    public final TextView txtAc;
    public final TextView txtBLOName;
    public final TextView txtBLoDetails;
    public final TextView txtDummyEpic;
    public final TextView txtDummyName;
    public final TextView txtDummyRelative;
    public final TextView txtDummyTypeRelation;
    public final TextView txtDummyphone;
    public final TextView txtEpic;
    public final TextView txtPart;
    public final TextView txtState;
    public final TextView txtSure;
    public final TextView txtbloPhone;

    private DialogBloMappedElectorBinding(LinearLayout rootView, Button btnNo, Button btnYes, LinearLayout linearBLOName, LinearLayout linearBLoPhone, LinearLayout linearButtons, LinearLayout linearEpic, LinearLayout linearName, LinearLayout linearRealtionType, LinearLayout linearRelative, TextView txName, TextView txtAc, TextView txtBLOName, TextView txtBLoDetails, TextView txtDummyEpic, TextView txtDummyName, TextView txtDummyRelative, TextView txtDummyTypeRelation, TextView txtDummyphone, TextView txtEpic, TextView txtPart, TextView txtState, TextView txtSure, TextView txtbloPhone) {
        this.rootView = rootView;
        this.btnNo = btnNo;
        this.btnYes = btnYes;
        this.linearBLOName = linearBLOName;
        this.linearBLoPhone = linearBLoPhone;
        this.linearButtons = linearButtons;
        this.linearEpic = linearEpic;
        this.linearName = linearName;
        this.linearRealtionType = linearRealtionType;
        this.linearRelative = linearRelative;
        this.txName = txName;
        this.txtAc = txtAc;
        this.txtBLOName = txtBLOName;
        this.txtBLoDetails = txtBLoDetails;
        this.txtDummyEpic = txtDummyEpic;
        this.txtDummyName = txtDummyName;
        this.txtDummyRelative = txtDummyRelative;
        this.txtDummyTypeRelation = txtDummyTypeRelation;
        this.txtDummyphone = txtDummyphone;
        this.txtEpic = txtEpic;
        this.txtPart = txtPart;
        this.txtState = txtState;
        this.txtSure = txtSure;
        this.txtbloPhone = txtbloPhone;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogBloMappedElectorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogBloMappedElectorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_blo_mapped_elector, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogBloMappedElectorBinding bind(View rootView) {
        int i = R.id.btnNo;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnNo);
        if (button != null) {
            i = R.id.btnYes;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnYes);
            if (button2 != null) {
                i = R.id.linearBLOName;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearBLOName);
                if (linearLayout != null) {
                    i = R.id.linearBLoPhone;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearBLoPhone);
                    if (linearLayout2 != null) {
                        i = R.id.linearButtons;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearButtons);
                        if (linearLayout3 != null) {
                            i = R.id.linearEpic;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearEpic);
                            if (linearLayout4 != null) {
                                i = R.id.linearName;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearName);
                                if (linearLayout5 != null) {
                                    i = R.id.linearRealtionType;
                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRealtionType);
                                    if (linearLayout6 != null) {
                                        i = R.id.linearRelative;
                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearRelative);
                                        if (linearLayout7 != null) {
                                            i = R.id.txName;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.txName);
                                            if (textView != null) {
                                                i = R.id.txtAc;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtAc);
                                                if (textView2 != null) {
                                                    i = R.id.txtBLOName;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtBLOName);
                                                    if (textView3 != null) {
                                                        i = R.id.txtBLoDetails;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtBLoDetails);
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
                                                                            i = R.id.txtDummyphone;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDummyphone);
                                                                            if (textView9 != null) {
                                                                                i = R.id.txtEpic;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtEpic);
                                                                                if (textView10 != null) {
                                                                                    i = R.id.txtPart;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtPart);
                                                                                    if (textView11 != null) {
                                                                                        i = R.id.txtState;
                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtState);
                                                                                        if (textView12 != null) {
                                                                                            i = R.id.txtSure;
                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtSure);
                                                                                            if (textView13 != null) {
                                                                                                i = R.id.txtbloPhone;
                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtbloPhone);
                                                                                                if (textView14 != null) {
                                                                                                    return new DialogBloMappedElectorBinding((LinearLayout) rootView, button, button2, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
