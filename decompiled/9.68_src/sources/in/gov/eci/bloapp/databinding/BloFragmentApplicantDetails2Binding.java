package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentApplicantDetails2Binding implements ViewBinding {
    public final RecyclerView applicantDetails2;
    private final FrameLayout rootView;

    private BloFragmentApplicantDetails2Binding(FrameLayout rootView, RecyclerView applicantDetails2) {
        this.rootView = rootView;
        this.applicantDetails2 = applicantDetails2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentApplicantDetails2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentApplicantDetails2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_applicant_details2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentApplicantDetails2Binding bind(View rootView) {
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.applicantDetails2);
        if (recyclerViewFindChildViewById != null) {
            return new BloFragmentApplicantDetails2Binding((FrameLayout) rootView, recyclerViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.applicantDetails2)));
    }
}
