package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentAboutECIBinding implements ViewBinding {
    public final LinearLayout aboutEci;
    private final LinearLayout rootView;
    public final TextView textViewAboutHonbleCommission;
    public final CardView textViewAboutHonbleCommissionRoot;
    public final TextView textViewCommissionSetup;
    public final CardView textViewCommissionSetupRoot;
    public final TextView textViewContactDetailsOfCEOs;
    public final CardView textViewContactDetailsOfCEOsRoot;
    public final TextView textViewOfficialsContactDetails;
    public final CardView textViewOfficialsContactDetailsRoot;

    private BloFragmentAboutECIBinding(LinearLayout rootView, LinearLayout aboutEci, TextView textViewAboutHonbleCommission, CardView textViewAboutHonbleCommissionRoot, TextView textViewCommissionSetup, CardView textViewCommissionSetupRoot, TextView textViewContactDetailsOfCEOs, CardView textViewContactDetailsOfCEOsRoot, TextView textViewOfficialsContactDetails, CardView textViewOfficialsContactDetailsRoot) {
        this.rootView = rootView;
        this.aboutEci = aboutEci;
        this.textViewAboutHonbleCommission = textViewAboutHonbleCommission;
        this.textViewAboutHonbleCommissionRoot = textViewAboutHonbleCommissionRoot;
        this.textViewCommissionSetup = textViewCommissionSetup;
        this.textViewCommissionSetupRoot = textViewCommissionSetupRoot;
        this.textViewContactDetailsOfCEOs = textViewContactDetailsOfCEOs;
        this.textViewContactDetailsOfCEOsRoot = textViewContactDetailsOfCEOsRoot;
        this.textViewOfficialsContactDetails = textViewOfficialsContactDetails;
        this.textViewOfficialsContactDetailsRoot = textViewOfficialsContactDetailsRoot;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentAboutECIBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentAboutECIBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_about_e_c_i, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentAboutECIBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.textView_about_Honble_Commission;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_about_Honble_Commission);
        if (textView != null) {
            i = R.id.textView_about_Honble_Commission_root;
            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.textView_about_Honble_Commission_root);
            if (cardViewFindChildViewById != null) {
                i = R.id.textView_commission_Setup;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_commission_Setup);
                if (textView2 != null) {
                    i = R.id.textView_commission_Setup_root;
                    CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.textView_commission_Setup_root);
                    if (cardViewFindChildViewById2 != null) {
                        i = R.id.textView_contact_Details_of_CEOs;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_contact_Details_of_CEOs);
                        if (textView3 != null) {
                            i = R.id.textView_contact_Details_of_CEOs_root;
                            CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.textView_contact_Details_of_CEOs_root);
                            if (cardViewFindChildViewById3 != null) {
                                i = R.id.textView_officials_Contact_Details;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_officials_Contact_Details);
                                if (textView4 != null) {
                                    i = R.id.textView_officials_Contact_Details_root;
                                    CardView cardViewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.textView_officials_Contact_Details_root);
                                    if (cardViewFindChildViewById4 != null) {
                                        return new BloFragmentAboutECIBinding(linearLayout, linearLayout, textView, cardViewFindChildViewById, textView2, cardViewFindChildViewById2, textView3, cardViewFindChildViewById3, textView4, cardViewFindChildViewById4);
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
