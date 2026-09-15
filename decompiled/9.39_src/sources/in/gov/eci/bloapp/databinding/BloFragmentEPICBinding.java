package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentEPICBinding implements ViewBinding {
    public final TextView add;
    public final TextView add1;
    public final TextView address;
    public final TextView address1;
    public final TextView datetv;
    public final TextView dob;
    public final TextView electorname;
    public final TextView electorname1;
    public final TextView email;
    public final TextView epicDistrict;
    public final TextView epicDistrict1;
    public final TextView fatherName1;
    public final TextView fatherhed;
    public final TextView fatherhedhin;
    public final TextView fathername;
    public final TextView gender;
    public final ImageView img;
    public final ImageView img1;
    public final ImageView imgeci;
    public final ImageView lang;
    public final LinearLayout linear;
    public final RelativeLayout linear1;
    public final View mainDivider;
    public final ImageView profile;
    private final NestedScrollView rootView;
    public final TextView subdate;
    public final ImageView tele;
    public final TextView textview1;
    public final TextView textview2;
    public final TextView textview3;

    private BloFragmentEPICBinding(NestedScrollView rootView, TextView add, TextView add1, TextView address, TextView address1, TextView datetv, TextView dob, TextView electorname, TextView electorname1, TextView email, TextView epicDistrict, TextView epicDistrict1, TextView fatherName1, TextView fatherhed, TextView fatherhedhin, TextView fathername, TextView gender, ImageView img, ImageView img1, ImageView imgeci, ImageView lang, LinearLayout linear, RelativeLayout linear1, View mainDivider, ImageView profile, TextView subdate, ImageView tele, TextView textview1, TextView textview2, TextView textview3) {
        this.rootView = rootView;
        this.add = add;
        this.add1 = add1;
        this.address = address;
        this.address1 = address1;
        this.datetv = datetv;
        this.dob = dob;
        this.electorname = electorname;
        this.electorname1 = electorname1;
        this.email = email;
        this.epicDistrict = epicDistrict;
        this.epicDistrict1 = epicDistrict1;
        this.fatherName1 = fatherName1;
        this.fatherhed = fatherhed;
        this.fatherhedhin = fatherhedhin;
        this.fathername = fathername;
        this.gender = gender;
        this.img = img;
        this.img1 = img1;
        this.imgeci = imgeci;
        this.lang = lang;
        this.linear = linear;
        this.linear1 = linear1;
        this.mainDivider = mainDivider;
        this.profile = profile;
        this.subdate = subdate;
        this.tele = tele;
        this.textview1 = textview1;
        this.textview2 = textview2;
        this.textview3 = textview3;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static BloFragmentEPICBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentEPICBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_e_p_i_c, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentEPICBinding bind(View rootView) {
        int i = 2131362190;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, 2131362190);
        if (textView != null) {
            i = R.id.add1;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add1);
            if (textView2 != null) {
                i = R.id.address;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address);
                if (textView3 != null) {
                    i = R.id.address1;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address1);
                    if (textView4 != null) {
                        i = R.id.datetv;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.datetv);
                        if (textView5 != null) {
                            i = R.id.dob;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dob);
                            if (textView6 != null) {
                                i = R.id.electorname;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorname);
                                if (textView7 != null) {
                                    i = R.id.electorname1;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorname1);
                                    if (textView8 != null) {
                                        i = R.id.email;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.email);
                                        if (textView9 != null) {
                                            i = R.id.epicDistrict;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epicDistrict);
                                            if (textView10 != null) {
                                                i = R.id.epicDistrict1;
                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epicDistrict1);
                                                if (textView11 != null) {
                                                    i = R.id.fatherName1;
                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fatherName1);
                                                    if (textView12 != null) {
                                                        i = R.id.fatherhed;
                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fatherhed);
                                                        if (textView13 != null) {
                                                            i = R.id.fatherhedhin;
                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fatherhedhin);
                                                            if (textView14 != null) {
                                                                i = R.id.fathername;
                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fathername);
                                                                if (textView15 != null) {
                                                                    i = R.id.gender;
                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender);
                                                                    if (textView16 != null) {
                                                                        i = R.id.img;
                                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img);
                                                                        if (imageView != null) {
                                                                            i = R.id.img1;
                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img1);
                                                                            if (imageView2 != null) {
                                                                                i = R.id.imgeci;
                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imgeci);
                                                                                if (imageView3 != null) {
                                                                                    i = R.id.lang;
                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.lang);
                                                                                    if (imageView4 != null) {
                                                                                        i = 2131364341;
                                                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, 2131364341);
                                                                                        if (linearLayout != null) {
                                                                                            i = R.id.linear1;
                                                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.linear1);
                                                                                            if (relativeLayout != null) {
                                                                                                i = R.id.main_divider;
                                                                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.main_divider);
                                                                                                if (viewFindChildViewById != null) {
                                                                                                    i = R.id.profile;
                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profile);
                                                                                                    if (imageView5 != null) {
                                                                                                        i = R.id.subdate;
                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subdate);
                                                                                                        if (textView17 != null) {
                                                                                                            i = R.id.tele;
                                                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tele);
                                                                                                            if (imageView6 != null) {
                                                                                                                i = R.id.textview1;
                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textview1);
                                                                                                                if (textView18 != null) {
                                                                                                                    i = R.id.textview2;
                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textview2);
                                                                                                                    if (textView19 != null) {
                                                                                                                        i = R.id.textview3;
                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textview3);
                                                                                                                        if (textView20 != null) {
                                                                                                                            return new BloFragmentEPICBinding((NestedScrollView) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, imageView, imageView2, imageView3, imageView4, linearLayout, relativeLayout, viewFindChildViewById, imageView5, textView17, imageView6, textView18, textView19, textView20);
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
