package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityDseForm7Binding implements ViewBinding {
    public final TextView ageEd2;
    public final TextView agelable;
    public final ImageView backBtnIv;
    public final ConstraintLayout bottomPreviousSaveLayout;
    public final CardView cardView;
    public final TextView constituencyEd;
    public final TextView constituencyTv;
    public final TextView constituencynoEd;
    public final ConstraintLayout constraintLayout;
    public final LinearLayout deletionObjectionFormLayout;
    public final TextView districtTv;
    public final TextView epicEd2;
    public final ImageView homeBtnIv;
    public final TextView issueDateEd;
    public final TextView nameEd;
    public final TextView optionRb3;
    public final TextView placeEd;
    public final RadioGroup rejectionOptionsRg;
    public final TextView relationnameEd2;
    public final TextView relationtypeEd2;
    public final TextView releationnamelable;
    public final TextView releationtypelable;
    private final ConstraintLayout rootView;
    public final TextView stateTv;
    public final TextView submitTv;
    public final TextView surnameEd2;
    public final TextView textView1;
    public final TextView textView10;
    public final TextView textView17;
    public final TextView textView18;
    public final TextView textView19;
    public final TextView textView2;
    public final TextView textView3;
    public final TextView textView30;
    public final TextView textView31;
    public final TextView textView32;
    public final TextView textView7;

    private BloActivityDseForm7Binding(ConstraintLayout rootView, TextView ageEd2, TextView agelable, ImageView backBtnIv, ConstraintLayout bottomPreviousSaveLayout, CardView cardView, TextView constituencyEd, TextView constituencyTv, TextView constituencynoEd, ConstraintLayout constraintLayout, LinearLayout deletionObjectionFormLayout, TextView districtTv, TextView epicEd2, ImageView homeBtnIv, TextView issueDateEd, TextView nameEd, TextView optionRb3, TextView placeEd, RadioGroup rejectionOptionsRg, TextView relationnameEd2, TextView relationtypeEd2, TextView releationnamelable, TextView releationtypelable, TextView stateTv, TextView submitTv, TextView surnameEd2, TextView textView1, TextView textView10, TextView textView17, TextView textView18, TextView textView19, TextView textView2, TextView textView3, TextView textView30, TextView textView31, TextView textView32, TextView textView7) {
        this.rootView = rootView;
        this.ageEd2 = ageEd2;
        this.agelable = agelable;
        this.backBtnIv = backBtnIv;
        this.bottomPreviousSaveLayout = bottomPreviousSaveLayout;
        this.cardView = cardView;
        this.constituencyEd = constituencyEd;
        this.constituencyTv = constituencyTv;
        this.constituencynoEd = constituencynoEd;
        this.constraintLayout = constraintLayout;
        this.deletionObjectionFormLayout = deletionObjectionFormLayout;
        this.districtTv = districtTv;
        this.epicEd2 = epicEd2;
        this.homeBtnIv = homeBtnIv;
        this.issueDateEd = issueDateEd;
        this.nameEd = nameEd;
        this.optionRb3 = optionRb3;
        this.placeEd = placeEd;
        this.rejectionOptionsRg = rejectionOptionsRg;
        this.relationnameEd2 = relationnameEd2;
        this.relationtypeEd2 = relationtypeEd2;
        this.releationnamelable = releationnamelable;
        this.releationtypelable = releationtypelable;
        this.stateTv = stateTv;
        this.submitTv = submitTv;
        this.surnameEd2 = surnameEd2;
        this.textView1 = textView1;
        this.textView10 = textView10;
        this.textView17 = textView17;
        this.textView18 = textView18;
        this.textView19 = textView19;
        this.textView2 = textView2;
        this.textView3 = textView3;
        this.textView30 = textView30;
        this.textView31 = textView31;
        this.textView32 = textView32;
        this.textView7 = textView7;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityDseForm7Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityDseForm7Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_dse_form7, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityDseForm7Binding bind(View rootView) {
        int i = R.id.age_ed2;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_ed2);
        if (textView != null) {
            i = R.id.agelable;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.agelable);
            if (textView2 != null) {
                i = R.id.back_btn_iv;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                if (imageView != null) {
                    i = R.id.bottom_previous_save_layout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_previous_save_layout);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.cardView;
                        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
                        if (cardViewFindChildViewById != null) {
                            i = R.id.constituency_ed;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.constituency_ed);
                            if (textView3 != null) {
                                i = R.id.constituency_tv;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.constituency_tv);
                                if (textView4 != null) {
                                    i = R.id.constituencyno_ed;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.constituencyno_ed);
                                    if (textView5 != null) {
                                        i = R.id.constraintLayout;
                                        ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                                        if (constraintLayoutFindChildViewById2 != null) {
                                            i = R.id.deletion_objection_form_layout;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.deletion_objection_form_layout);
                                            if (linearLayout != null) {
                                                i = R.id.district_tv;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_tv);
                                                if (textView6 != null) {
                                                    i = R.id.epic_ed2;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_ed2);
                                                    if (textView7 != null) {
                                                        i = R.id.home_btn_iv;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                                        if (imageView2 != null) {
                                                            i = R.id.issueDateEd;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.issueDateEd);
                                                            if (textView8 != null) {
                                                                i = R.id.name_ed;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_ed);
                                                                if (textView9 != null) {
                                                                    i = R.id.option_rb3;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.option_rb3);
                                                                    if (textView10 != null) {
                                                                        i = R.id.place_ed;
                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.place_ed);
                                                                        if (textView11 != null) {
                                                                            i = R.id.rejection_options_rg;
                                                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.rejection_options_rg);
                                                                            if (radioGroup != null) {
                                                                                i = R.id.relationname_ed2;
                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationname_ed2);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.relationtype_ed2;
                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationtype_ed2);
                                                                                    if (textView13 != null) {
                                                                                        i = R.id.releationnamelable;
                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.releationnamelable);
                                                                                        if (textView14 != null) {
                                                                                            i = R.id.releationtypelable;
                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.releationtypelable);
                                                                                            if (textView15 != null) {
                                                                                                i = R.id.state_tv;
                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                                                                if (textView16 != null) {
                                                                                                    i = R.id.submit_tv;
                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submit_tv);
                                                                                                    if (textView17 != null) {
                                                                                                        i = R.id.surname_ed2;
                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.surname_ed2);
                                                                                                        if (textView18 != null) {
                                                                                                            i = R.id.textView1;
                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView1);
                                                                                                            if (textView19 != null) {
                                                                                                                i = R.id.textView10;
                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView10);
                                                                                                                if (textView20 != null) {
                                                                                                                    i = R.id.textView17;
                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView17);
                                                                                                                    if (textView21 != null) {
                                                                                                                        i = R.id.textView18;
                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView18);
                                                                                                                        if (textView22 != null) {
                                                                                                                            i = R.id.textView19;
                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                                                                                                            if (textView23 != null) {
                                                                                                                                i = R.id.textView2;
                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView2);
                                                                                                                                if (textView24 != null) {
                                                                                                                                    i = R.id.textView3;
                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                    if (textView25 != null) {
                                                                                                                                        i = R.id.textView30;
                                                                                                                                        TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView30);
                                                                                                                                        if (textView26 != null) {
                                                                                                                                            i = R.id.textView31;
                                                                                                                                            TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView31);
                                                                                                                                            if (textView27 != null) {
                                                                                                                                                i = R.id.textView32;
                                                                                                                                                TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView32);
                                                                                                                                                if (textView28 != null) {
                                                                                                                                                    i = R.id.textView7;
                                                                                                                                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView7);
                                                                                                                                                    if (textView29 != null) {
                                                                                                                                                        return new BloActivityDseForm7Binding((ConstraintLayout) rootView, textView, textView2, imageView, constraintLayoutFindChildViewById, cardViewFindChildViewById, textView3, textView4, textView5, constraintLayoutFindChildViewById2, linearLayout, textView6, textView7, imageView2, textView8, textView9, textView10, textView11, radioGroup, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29);
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
