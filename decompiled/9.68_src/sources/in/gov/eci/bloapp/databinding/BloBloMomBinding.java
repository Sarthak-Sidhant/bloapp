package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloBloMomBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final TextView chooseFile;
    public final LinearLayout deathCerti;
    public final ImageView delete;
    public final LinearLayout main;
    public final ImageView photo;
    public final TextView photoname;
    private final LinearLayout rootView;
    public final TextView size;
    public final Button submitSIR1;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;

    private BloBloMomBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, TextView chooseFile, LinearLayout deathCerti, ImageView delete, LinearLayout main, ImageView photo, TextView photoname, TextView size, Button submitSIR1, TextView textView3, TextView textView5, ImageView toolbarButton) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.chooseFile = chooseFile;
        this.deathCerti = deathCerti;
        this.delete = delete;
        this.main = main;
        this.photo = photo;
        this.photoname = photoname;
        this.size = size;
        this.submitSIR1 = submitSIR1;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloBloMomBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloBloMomBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_blo_mom, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloBloMomBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.choose_file;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file);
                if (textView != null) {
                    i = R.id.death_certi;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.death_certi);
                    if (linearLayout != null) {
                        i = R.id.delete;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.delete);
                        if (imageView2 != null) {
                            LinearLayout linearLayout2 = (LinearLayout) rootView;
                            i = R.id.photo;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo);
                            if (imageView3 != null) {
                                i = R.id.photoname;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photoname);
                                if (textView2 != null) {
                                    i = R.id.size;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.size);
                                    if (textView3 != null) {
                                        i = R.id.submitSIR1;
                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitSIR1);
                                        if (button != null) {
                                            i = R.id.textView3;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                            if (textView4 != null) {
                                                i = R.id.textView5;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                if (textView5 != null) {
                                                    i = R.id.toolbar_button;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                    if (imageView4 != null) {
                                                        return new BloBloMomBinding(linearLayout2, imageView, constraintLayoutFindChildViewById, textView, linearLayout, imageView2, linearLayout2, imageView3, textView2, textView3, button, textView4, textView5, imageView4);
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
