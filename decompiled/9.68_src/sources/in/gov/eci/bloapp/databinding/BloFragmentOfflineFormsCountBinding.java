package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentOfflineFormsCountBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final CardView cardViewLayout;
    public final ConstraintLayout constraintLayout;
    public final EditText edtCount;
    public final FrameLayout frame;
    public final ImageView homeBtnIv;
    public final LinearLayout linearCount;
    public final LinearLayout linearDate;
    public final LinearLayout linearFormType;
    private final ConstraintLayout rootView;
    public final LinearLayout submit;
    public final TextView textView11;
    public final TextView textView2;
    public final TextView textView3;
    public final TextView textView31;
    public final TextView txtDate;
    public final TextView txtErrorMsg;
    public final TextView txtForm6;

    private BloFragmentOfflineFormsCountBinding(ConstraintLayout rootView, ImageView backBtnIv, CardView cardViewLayout, ConstraintLayout constraintLayout, EditText edtCount, FrameLayout frame, ImageView homeBtnIv, LinearLayout linearCount, LinearLayout linearDate, LinearLayout linearFormType, LinearLayout submit, TextView textView11, TextView textView2, TextView textView3, TextView textView31, TextView txtDate, TextView txtErrorMsg, TextView txtForm6) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.cardViewLayout = cardViewLayout;
        this.constraintLayout = constraintLayout;
        this.edtCount = edtCount;
        this.frame = frame;
        this.homeBtnIv = homeBtnIv;
        this.linearCount = linearCount;
        this.linearDate = linearDate;
        this.linearFormType = linearFormType;
        this.submit = submit;
        this.textView11 = textView11;
        this.textView2 = textView2;
        this.textView3 = textView3;
        this.textView31 = textView31;
        this.txtDate = txtDate;
        this.txtErrorMsg = txtErrorMsg;
        this.txtForm6 = txtForm6;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentOfflineFormsCountBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentOfflineFormsCountBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_offline_forms_count, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentOfflineFormsCountBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.cardView_Layout;
            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView_Layout);
            if (cardViewFindChildViewById != null) {
                i = R.id.constraintLayout;
                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                if (constraintLayoutFindChildViewById != null) {
                    i = R.id.edtCount;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.edtCount);
                    if (editText != null) {
                        i = R.id.frame;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame);
                        if (frameLayout != null) {
                            i = R.id.home_btn_iv;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                            if (imageView2 != null) {
                                i = R.id.linearCount;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearCount);
                                if (linearLayout != null) {
                                    i = R.id.linearDate;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearDate);
                                    if (linearLayout2 != null) {
                                        i = R.id.linearFormType;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearFormType);
                                        if (linearLayout3 != null) {
                                            i = R.id.submit;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.submit);
                                            if (linearLayout4 != null) {
                                                i = R.id.textView11;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView11);
                                                if (textView != null) {
                                                    i = R.id.textView2;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView2);
                                                    if (textView2 != null) {
                                                        i = R.id.textView3;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                        if (textView3 != null) {
                                                            i = R.id.textView31;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView31);
                                                            if (textView4 != null) {
                                                                i = R.id.txtDate;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDate);
                                                                if (textView5 != null) {
                                                                    i = R.id.txtErrorMsg;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtErrorMsg);
                                                                    if (textView6 != null) {
                                                                        i = R.id.txtForm6;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtForm6);
                                                                        if (textView7 != null) {
                                                                            return new BloFragmentOfflineFormsCountBinding((ConstraintLayout) rootView, imageView, cardViewFindChildViewById, constraintLayoutFindChildViewById, editText, frameLayout, imageView2, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
