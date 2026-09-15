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
public final class BloFragmentMigrationPreviewEpicBinding implements ViewBinding {
    public final TextView add;
    public final TextView add1;
    public final TextView address;
    public final TextView address1;
    public final TextView beforeReg;
    public final TextView datetv;
    public final TextView district;
    public final TextView district1;
    public final TextView dob;
    public final TextView dobReg;
    public final TextView electionCommissionHindi;
    public final TextView electorPhotoCard;
    public final TextView electorname;
    public final TextView electorname1;
    public final TextView email;
    public final TextView fatherName1;
    public final TextView fatherhed;
    public final TextView fatherhedhin;
    public final TextView fathername;
    public final TextView gender;
    public final TextView genderReg;
    public final ImageView img;
    public final ImageView img1;
    public final ImageView imgeci;
    public final ImageView lang;
    public final LinearLayout linear;
    public final RelativeLayout linear1;
    public final View mainDivider;
    public final LinearLayout maindata;
    public final TextView nameReg;
    public final TextView note;
    public final ImageView profile;
    private final NestedScrollView rootView;
    public final TextView subdate;
    public final ImageView tele;
    public final TextView textview1;
    public final TextView textview2;
    public final TextView textview3;
    public final TextView thisCard;

    private BloFragmentMigrationPreviewEpicBinding(NestedScrollView rootView, TextView add, TextView add1, TextView address, TextView address1, TextView beforeReg, TextView datetv, TextView district, TextView district1, TextView dob, TextView dobReg, TextView electionCommissionHindi, TextView electorPhotoCard, TextView electorname, TextView electorname1, TextView email, TextView fatherName1, TextView fatherhed, TextView fatherhedhin, TextView fathername, TextView gender, TextView genderReg, ImageView img, ImageView img1, ImageView imgeci, ImageView lang, LinearLayout linear, RelativeLayout linear1, View mainDivider, LinearLayout maindata, TextView nameReg, TextView note, ImageView profile, TextView subdate, ImageView tele, TextView textview1, TextView textview2, TextView textview3, TextView thisCard) {
        this.rootView = rootView;
        this.add = add;
        this.add1 = add1;
        this.address = address;
        this.address1 = address1;
        this.beforeReg = beforeReg;
        this.datetv = datetv;
        this.district = district;
        this.district1 = district1;
        this.dob = dob;
        this.dobReg = dobReg;
        this.electionCommissionHindi = electionCommissionHindi;
        this.electorPhotoCard = electorPhotoCard;
        this.electorname = electorname;
        this.electorname1 = electorname1;
        this.email = email;
        this.fatherName1 = fatherName1;
        this.fatherhed = fatherhed;
        this.fatherhedhin = fatherhedhin;
        this.fathername = fathername;
        this.gender = gender;
        this.genderReg = genderReg;
        this.img = img;
        this.img1 = img1;
        this.imgeci = imgeci;
        this.lang = lang;
        this.linear = linear;
        this.linear1 = linear1;
        this.mainDivider = mainDivider;
        this.maindata = maindata;
        this.nameReg = nameReg;
        this.note = note;
        this.profile = profile;
        this.subdate = subdate;
        this.tele = tele;
        this.textview1 = textview1;
        this.textview2 = textview2;
        this.textview3 = textview3;
        this.thisCard = thisCard;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static BloFragmentMigrationPreviewEpicBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentMigrationPreviewEpicBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_migration_preview__epic, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentMigrationPreviewEpicBinding bind(View rootView) {
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
                        i = R.id.before_reg;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.before_reg);
                        if (textView5 != null) {
                            i = R.id.datetv;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.datetv);
                            if (textView6 != null) {
                                i = R.id.district;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district);
                                if (textView7 != null) {
                                    i = R.id.district1;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district1);
                                    if (textView8 != null) {
                                        i = R.id.dob;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dob);
                                        if (textView9 != null) {
                                            i = R.id.dob_reg;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dob_reg);
                                            if (textView10 != null) {
                                                i = R.id.election_commission_hindi;
                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.election_commission_hindi);
                                                if (textView11 != null) {
                                                    i = R.id.elector_photo_card;
                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.elector_photo_card);
                                                    if (textView12 != null) {
                                                        i = R.id.electorname;
                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorname);
                                                        if (textView13 != null) {
                                                            i = R.id.electorname1;
                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorname1);
                                                            if (textView14 != null) {
                                                                i = R.id.email;
                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.email);
                                                                if (textView15 != null) {
                                                                    i = R.id.fatherName1;
                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fatherName1);
                                                                    if (textView16 != null) {
                                                                        i = R.id.fatherhed;
                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fatherhed);
                                                                        if (textView17 != null) {
                                                                            i = R.id.fatherhedhin;
                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fatherhedhin);
                                                                            if (textView18 != null) {
                                                                                i = R.id.fathername;
                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fathername);
                                                                                if (textView19 != null) {
                                                                                    i = R.id.gender;
                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender);
                                                                                    if (textView20 != null) {
                                                                                        i = R.id.gender_reg;
                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender_reg);
                                                                                        if (textView21 != null) {
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
                                                                                                                        i = R.id.maindata;
                                                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.maindata);
                                                                                                                        if (linearLayout2 != null) {
                                                                                                                            i = R.id.name_reg;
                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_reg);
                                                                                                                            if (textView22 != null) {
                                                                                                                                i = R.id.note;
                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.note);
                                                                                                                                if (textView23 != null) {
                                                                                                                                    i = R.id.profile;
                                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profile);
                                                                                                                                    if (imageView5 != null) {
                                                                                                                                        i = R.id.subdate;
                                                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subdate);
                                                                                                                                        if (textView24 != null) {
                                                                                                                                            i = R.id.tele;
                                                                                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tele);
                                                                                                                                            if (imageView6 != null) {
                                                                                                                                                i = R.id.textview1;
                                                                                                                                                TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textview1);
                                                                                                                                                if (textView25 != null) {
                                                                                                                                                    i = R.id.textview2;
                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textview2);
                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                        i = R.id.textview3;
                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textview3);
                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                            i = R.id.this_Card;
                                                                                                                                                            TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.this_Card);
                                                                                                                                                            if (textView28 != null) {
                                                                                                                                                                return new BloFragmentMigrationPreviewEpicBinding((NestedScrollView) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, imageView, imageView2, imageView3, imageView4, linearLayout, relativeLayout, viewFindChildViewById, linearLayout2, textView22, textView23, imageView5, textView24, imageView6, textView25, textView26, textView27, textView28);
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
