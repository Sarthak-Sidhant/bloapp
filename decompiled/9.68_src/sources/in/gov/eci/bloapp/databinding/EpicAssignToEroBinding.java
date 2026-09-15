package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class EpicAssignToEroBinding implements ViewBinding {
    public final TextView cancelEpic;
    public final LinearLayout cardViewLL;
    public final Spinner epicReason;
    public final TextView epicSubmit;
    public final ImageView ivCancel;
    public final EditText reasonText;
    private final LinearLayout rootView;
    public final TextView shiftedUndertaking;

    private EpicAssignToEroBinding(LinearLayout rootView, TextView cancelEpic, LinearLayout cardViewLL, Spinner epicReason, TextView epicSubmit, ImageView ivCancel, EditText reasonText, TextView shiftedUndertaking) {
        this.rootView = rootView;
        this.cancelEpic = cancelEpic;
        this.cardViewLL = cardViewLL;
        this.epicReason = epicReason;
        this.epicSubmit = epicSubmit;
        this.ivCancel = ivCancel;
        this.reasonText = reasonText;
        this.shiftedUndertaking = shiftedUndertaking;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EpicAssignToEroBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EpicAssignToEroBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.epic_assign_to_ero, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EpicAssignToEroBinding bind(View rootView) {
        int i = R.id.cancel_epic;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cancel_epic);
        if (textView != null) {
            i = R.id.cardViewLL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cardViewLL);
            if (linearLayout != null) {
                i = R.id.epic_reason;
                Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.epic_reason);
                if (spinner != null) {
                    i = R.id.epic_submit;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_submit);
                    if (textView2 != null) {
                        i = R.id.iv_cancel;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_cancel);
                        if (imageView != null) {
                            i = R.id.reasonText;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.reasonText);
                            if (editText != null) {
                                i = R.id.shifted_undertaking;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.shifted_undertaking);
                                if (textView3 != null) {
                                    return new EpicAssignToEroBinding((LinearLayout) rootView, textView, linearLayout, spinner, textView2, imageView, editText, textView3);
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
