package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityStatement4Binding implements ViewBinding {
    public final ImageView back;
    public final EditText etTotalFemaleInTheHouse;
    public final EditText etTotalFemalePwDInTheHouse;
    public final EditText etTotalMaleInTheHouse;
    public final EditText etTotalMalePwDInTheHouse;
    public final TextView etTotalPersonsLivingInTheHouse;
    public final TextView etTotalPwDLivingInTheHouse;
    public final EditText etTotalThirdGInTheHouse;
    public final EditText etTotalThirdGPwDInTheHouse;
    public final ImageView homeBtnIv;
    public final TextView resetButton;
    private final ConstraintLayout rootView;
    public final NestedScrollView scrollview;
    public final LinearLayout statement4CardView;
    public final CardView statement4FooterCardView;
    public final TextView statement4PartNoName;
    public final TextView submitButton;
    public final TextView title;
    public final ConstraintLayout titleBar;

    private BloActivityStatement4Binding(ConstraintLayout rootView, ImageView back, EditText etTotalFemaleInTheHouse, EditText etTotalFemalePwDInTheHouse, EditText etTotalMaleInTheHouse, EditText etTotalMalePwDInTheHouse, TextView etTotalPersonsLivingInTheHouse, TextView etTotalPwDLivingInTheHouse, EditText etTotalThirdGInTheHouse, EditText etTotalThirdGPwDInTheHouse, ImageView homeBtnIv, TextView resetButton, NestedScrollView scrollview, LinearLayout statement4CardView, CardView statement4FooterCardView, TextView statement4PartNoName, TextView submitButton, TextView title, ConstraintLayout titleBar) {
        this.rootView = rootView;
        this.back = back;
        this.etTotalFemaleInTheHouse = etTotalFemaleInTheHouse;
        this.etTotalFemalePwDInTheHouse = etTotalFemalePwDInTheHouse;
        this.etTotalMaleInTheHouse = etTotalMaleInTheHouse;
        this.etTotalMalePwDInTheHouse = etTotalMalePwDInTheHouse;
        this.etTotalPersonsLivingInTheHouse = etTotalPersonsLivingInTheHouse;
        this.etTotalPwDLivingInTheHouse = etTotalPwDLivingInTheHouse;
        this.etTotalThirdGInTheHouse = etTotalThirdGInTheHouse;
        this.etTotalThirdGPwDInTheHouse = etTotalThirdGPwDInTheHouse;
        this.homeBtnIv = homeBtnIv;
        this.resetButton = resetButton;
        this.scrollview = scrollview;
        this.statement4CardView = statement4CardView;
        this.statement4FooterCardView = statement4FooterCardView;
        this.statement4PartNoName = statement4PartNoName;
        this.submitButton = submitButton;
        this.title = title;
        this.titleBar = titleBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityStatement4Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityStatement4Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_statement4, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityStatement4Binding bind(View rootView) {
        int i = 2131362484;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131362484);
        if (imageView != null) {
            i = R.id.et_total_female_in_the_house;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_total_female_in_the_house);
            if (editText != null) {
                i = R.id.et_total_female_PwD_in_the_house;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_total_female_PwD_in_the_house);
                if (editText2 != null) {
                    i = R.id.et_total_male_in_the_house;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_total_male_in_the_house);
                    if (editText3 != null) {
                        i = R.id.et_total_male_PwD_in_the_house;
                        EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_total_male_PwD_in_the_house);
                        if (editText4 != null) {
                            i = R.id.et_total_persons_living_in_the_house;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_total_persons_living_in_the_house);
                            if (textView != null) {
                                i = R.id.et_total_PwD_living_in_the_house;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.et_total_PwD_living_in_the_house);
                                if (textView2 != null) {
                                    i = R.id.et_total_third_G_in_the_house;
                                    EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_total_third_G_in_the_house);
                                    if (editText5 != null) {
                                        i = R.id.et_total_third_G_PwD_in_the_house;
                                        EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_total_third_G_PwD_in_the_house);
                                        if (editText6 != null) {
                                            i = R.id.home_btn_iv;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                            if (imageView2 != null) {
                                                i = R.id.resetButton;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resetButton);
                                                if (textView3 != null) {
                                                    i = R.id.scrollview;
                                                    NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.scrollview);
                                                    if (nestedScrollViewFindChildViewById != null) {
                                                        i = R.id.statement4_cardView;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.statement4_cardView);
                                                        if (linearLayout != null) {
                                                            i = R.id.statement4_footer_cardView;
                                                            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.statement4_footer_cardView);
                                                            if (cardViewFindChildViewById != null) {
                                                                i = R.id.statement4PartNoName;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.statement4PartNoName);
                                                                if (textView4 != null) {
                                                                    i = R.id.submitButton;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submitButton);
                                                                    if (textView5 != null) {
                                                                        i = 2131366420;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, 2131366420);
                                                                        if (textView6 != null) {
                                                                            i = R.id.titleBar;
                                                                            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.titleBar);
                                                                            if (constraintLayoutFindChildViewById != null) {
                                                                                return new BloActivityStatement4Binding((ConstraintLayout) rootView, imageView, editText, editText2, editText3, editText4, textView, textView2, editText5, editText6, imageView2, textView3, nestedScrollViewFindChildViewById, linearLayout, cardViewFindChildViewById, textView4, textView5, textView6, constraintLayoutFindChildViewById);
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
