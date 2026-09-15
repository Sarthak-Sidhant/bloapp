package in.gov.eci.bloapp.views.fragments.about_eci;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import in.gov.eci.bloapp.databinding.BloFragmentAboutECIBinding;
import in.gov.eci.bloapp.views.activity.AboutHonbleCommissionActivity;
import in.gov.eci.bloapp.views.activity.CommissionSetupActivity;
import in.gov.eci.bloapp.views.activity.ContactDetailsofCEOsActivity;
import in.gov.eci.bloapp.views.activity.OfficialsContactDetailsActivity;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class AboutEciFragment extends Fragment {
    BloFragmentAboutECIBinding BloFragmentAboutECIBinding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BloFragmentAboutECIBinding bloFragmentAboutECIBindingInflate = BloFragmentAboutECIBinding.inflate(inflater);
        this.BloFragmentAboutECIBinding = bloFragmentAboutECIBindingInflate;
        bloFragmentAboutECIBindingInflate.textViewAboutHonbleCommissionRoot.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.about_eci.AboutEciFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.BloFragmentAboutECIBinding.textViewCommissionSetupRoot.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.about_eci.AboutEciFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.BloFragmentAboutECIBinding.textViewOfficialsContactDetailsRoot.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.about_eci.AboutEciFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        this.BloFragmentAboutECIBinding.textViewContactDetailsOfCEOsRoot.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.about_eci.AboutEciFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        return this.BloFragmentAboutECIBinding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent(getContext(), (Class<?>) AboutHonbleCommissionActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        startActivity(new Intent(getContext(), (Class<?>) CommissionSetupActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        startActivity(new Intent(getContext(), (Class<?>) OfficialsContactDetailsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        startActivity(new Intent(getContext(), (Class<?>) ContactDetailsofCEOsActivity.class));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.BloFragmentAboutECIBinding = null;
    }
}
