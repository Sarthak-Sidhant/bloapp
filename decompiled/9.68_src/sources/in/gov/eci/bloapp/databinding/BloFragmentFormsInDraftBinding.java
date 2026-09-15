package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentFormsInDraftBinding implements ViewBinding {
    public final RelativeLayout aadhaarAuthLayout;
    public final RelativeLayout aadhaarAuthLayout2;
    public final RecyclerView aadhaarAuthRecycler;
    public final LinearLayout addharAuth;
    public final ImageView backBtnIv;
    public final RelativeLayout constraintLayout;
    public final RelativeLayout constraintLayout1;
    public final TextView delObjTv;
    public final LinearLayout deletionObjection;
    public final RecyclerView deletionObjectionRecycler;
    public final RelativeLayout deo;
    public final TextView fillForm7;
    public final TextView formsDraft;
    public final TextView formsDraft1;
    public final ImageView homeBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final LinearLayout newVotReg;
    public final RecyclerView newVoterRecycler;
    public final LinearLayout overseasElectorVoter;
    public final RecyclerView overseasElectorVoterRecycler;
    private final ConstraintLayout rootView;
    public final TextView shiftingCorr;
    public final LinearLayout shiftingCorrectness;
    public final RecyclerView shiftingCorrectnessRecycler;
    public final TextView shiftingWithinTv1;
    public final TextView textView1;
    public final TextView textView2;
    public final TextView textView3;
    public final TextView textViewdraft;
    public final TextView textViewdraft1;
    public final ImageView vector1;
    public final ImageView vector2;
    public final ImageView vector3;
    public final ImageView vector4;
    public final ImageView vector5;

    private BloFragmentFormsInDraftBinding(ConstraintLayout rootView, RelativeLayout aadhaarAuthLayout, RelativeLayout aadhaarAuthLayout2, RecyclerView aadhaarAuthRecycler, LinearLayout addharAuth, ImageView backBtnIv, RelativeLayout constraintLayout, RelativeLayout constraintLayout1, TextView delObjTv, LinearLayout deletionObjection, RecyclerView deletionObjectionRecycler, RelativeLayout deo, TextView fillForm7, TextView formsDraft, TextView formsDraft1, ImageView homeBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, LinearLayout newVotReg, RecyclerView newVoterRecycler, LinearLayout overseasElectorVoter, RecyclerView overseasElectorVoterRecycler, TextView shiftingCorr, LinearLayout shiftingCorrectness, RecyclerView shiftingCorrectnessRecycler, TextView shiftingWithinTv1, TextView textView1, TextView textView2, TextView textView3, TextView textViewdraft, TextView textViewdraft1, ImageView vector1, ImageView vector2, ImageView vector3, ImageView vector4, ImageView vector5) {
        this.rootView = rootView;
        this.aadhaarAuthLayout = aadhaarAuthLayout;
        this.aadhaarAuthLayout2 = aadhaarAuthLayout2;
        this.aadhaarAuthRecycler = aadhaarAuthRecycler;
        this.addharAuth = addharAuth;
        this.backBtnIv = backBtnIv;
        this.constraintLayout = constraintLayout;
        this.constraintLayout1 = constraintLayout1;
        this.delObjTv = delObjTv;
        this.deletionObjection = deletionObjection;
        this.deletionObjectionRecycler = deletionObjectionRecycler;
        this.deo = deo;
        this.fillForm7 = fillForm7;
        this.formsDraft = formsDraft;
        this.formsDraft1 = formsDraft1;
        this.homeBtnIv = homeBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.newVotReg = newVotReg;
        this.newVoterRecycler = newVoterRecycler;
        this.overseasElectorVoter = overseasElectorVoter;
        this.overseasElectorVoterRecycler = overseasElectorVoterRecycler;
        this.shiftingCorr = shiftingCorr;
        this.shiftingCorrectness = shiftingCorrectness;
        this.shiftingCorrectnessRecycler = shiftingCorrectnessRecycler;
        this.shiftingWithinTv1 = shiftingWithinTv1;
        this.textView1 = textView1;
        this.textView2 = textView2;
        this.textView3 = textView3;
        this.textViewdraft = textViewdraft;
        this.textViewdraft1 = textViewdraft1;
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.vector3 = vector3;
        this.vector4 = vector4;
        this.vector5 = vector5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentFormsInDraftBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentFormsInDraftBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_forms_in_draft, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentFormsInDraftBinding bind(View rootView) {
        int i = R.id.aadhaar_auth_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.aadhaar_auth_layout);
        if (relativeLayout != null) {
            i = R.id.aadhaar_auth_layout2;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.aadhaar_auth_layout2);
            if (relativeLayout2 != null) {
                i = R.id.aadhaar_auth_recycler;
                RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.aadhaar_auth_recycler);
                if (recyclerViewFindChildViewById != null) {
                    i = R.id.addhar_auth;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.addhar_auth);
                    if (linearLayout != null) {
                        i = R.id.back_btn_iv;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                        if (imageView != null) {
                            i = R.id.constraintLayout;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                            if (relativeLayout3 != null) {
                                i = R.id.constraintLayout1;
                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.constraintLayout1);
                                if (relativeLayout4 != null) {
                                    i = R.id.del_obj_tv;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.del_obj_tv);
                                    if (textView != null) {
                                        i = R.id.deletion_Objection;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.deletion_Objection);
                                        if (linearLayout2 != null) {
                                            i = R.id.deletion_Objection_recycler;
                                            RecyclerView recyclerViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.deletion_Objection_recycler);
                                            if (recyclerViewFindChildViewById2 != null) {
                                                i = R.id.deo;
                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.deo);
                                                if (relativeLayout5 != null) {
                                                    i = R.id.fill_form_7;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fill_form_7);
                                                    if (textView2 != null) {
                                                        i = R.id.forms_draft;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.forms_draft);
                                                        if (textView3 != null) {
                                                            i = R.id.forms_draft1;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.forms_draft1);
                                                            if (textView4 != null) {
                                                                i = R.id.home_btn_iv;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                                                if (imageView2 != null) {
                                                                    i = R.id.home_fragment_top_constraint_layout;
                                                                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                                                                    if (constraintLayoutFindChildViewById != null) {
                                                                        i = R.id.new_vot_reg;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.new_vot_reg);
                                                                        if (linearLayout3 != null) {
                                                                            i = R.id.new_voter_recycler;
                                                                            RecyclerView recyclerViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.new_voter_recycler);
                                                                            if (recyclerViewFindChildViewById3 != null) {
                                                                                i = R.id.overseas_Elector_Voter;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.overseas_Elector_Voter);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.overseas_Elector_Voter_recycler;
                                                                                    RecyclerView recyclerViewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.overseas_Elector_Voter_recycler);
                                                                                    if (recyclerViewFindChildViewById4 != null) {
                                                                                        i = R.id.shifting_corr;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.shifting_corr);
                                                                                        if (textView5 != null) {
                                                                                            i = R.id.shifting_correctness;
                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.shifting_correctness);
                                                                                            if (linearLayout5 != null) {
                                                                                                i = R.id.shifting_correctness_recycler;
                                                                                                RecyclerView recyclerViewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.shifting_correctness_recycler);
                                                                                                if (recyclerViewFindChildViewById5 != null) {
                                                                                                    i = R.id.shifting_within_tv1;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.shifting_within_tv1);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.textView1;
                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView1);
                                                                                                        if (textView7 != null) {
                                                                                                            i = R.id.textView2;
                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView2);
                                                                                                            if (textView8 != null) {
                                                                                                                i = R.id.textView3;
                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                if (textView9 != null) {
                                                                                                                    i = R.id.textViewdraft;
                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textViewdraft);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i = R.id.textViewdraft1;
                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textViewdraft1);
                                                                                                                        if (textView11 != null) {
                                                                                                                            i = R.id.vector1;
                                                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.vector1);
                                                                                                                            if (imageView3 != null) {
                                                                                                                                i = R.id.vector2;
                                                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.vector2);
                                                                                                                                if (imageView4 != null) {
                                                                                                                                    i = R.id.vector3;
                                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.vector3);
                                                                                                                                    if (imageView5 != null) {
                                                                                                                                        i = R.id.vector4;
                                                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.vector4);
                                                                                                                                        if (imageView6 != null) {
                                                                                                                                            i = R.id.vector5;
                                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.vector5);
                                                                                                                                            if (imageView7 != null) {
                                                                                                                                                return new BloFragmentFormsInDraftBinding((ConstraintLayout) rootView, relativeLayout, relativeLayout2, recyclerViewFindChildViewById, linearLayout, imageView, relativeLayout3, relativeLayout4, textView, linearLayout2, recyclerViewFindChildViewById2, relativeLayout5, textView2, textView3, textView4, imageView2, constraintLayoutFindChildViewById, linearLayout3, recyclerViewFindChildViewById3, linearLayout4, recyclerViewFindChildViewById4, textView5, linearLayout5, recyclerViewFindChildViewById5, textView6, textView7, textView8, textView9, textView10, textView11, imageView3, imageView4, imageView5, imageView6, imageView7);
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
