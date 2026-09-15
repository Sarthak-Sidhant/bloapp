package in.gov.eci.bloapp.views.fragments.dse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloFragmentDseMainBinding;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.dse.generateform8.DseIdentifiedFragment;
import in.gov.eci.bloapp.views.fragments.dse.requestformata.FormatAFragment;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class DseMainFragment extends Fragment {
    BloFragmentDseMainBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentDseMainBinding.inflate(getLayoutInflater());
        initClickListener();
        this.binding.ChecklistSubmission.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.DseMainFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.RequestFormat.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.DseMainFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.binding.DseIdentified.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.DseMainFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        openFragment(new DseFragment(), "dseFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        openFragment(new FormatAFragment(), "FormatAFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        openFragment(new DseIdentifiedFragment(), "DseIdentifiedFragment");
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.DseMainFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$3(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    private void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    private boolean isBiharState() {
        return SharedPref.getInstance(requireContext()).getStateCode().equalsIgnoreCase("S04");
    }
}
