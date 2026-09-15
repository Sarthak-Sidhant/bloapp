package in.gov.eci.bloapp.views.fragments.pse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter;
import in.gov.eci.bloapp.databinding.BloFragmentPseForm8RequestBinding;
import in.gov.eci.bloapp.views.activity.MainActivity;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class PseForm8RequestFragment extends Fragment {
    private GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface adapterInterface;
    BloFragmentPseForm8RequestBinding binding;
    private final String[] tabs = {"Pending", "Completed"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BloFragmentPseForm8RequestBinding bloFragmentPseForm8RequestBindingInflate = BloFragmentPseForm8RequestBinding.inflate(getLayoutInflater());
        this.binding = bloFragmentPseForm8RequestBindingInflate;
        bloFragmentPseForm8RequestBindingInflate.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        initClickListener();
        setUpViewPager();
        initViewPagerAndTagLayout();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        openFragment(new PseMainFragment(), "PseMainFragment");
    }

    private void setUpViewPager() {
        this.adapterInterface = new GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestFragment.1
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public int getCount() {
                return 2;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new PseForm8RequestPendingFragment();
                }
                return new PseForm8RequestDoneFragment();
            }
        };
    }

    private void initViewPagerAndTagLayout() {
        this.binding.viewPager.setAdapter(new GenericFragmentPagerAdapter(getChildFragmentManager(), getLifecycle(), this.adapterInterface));
        new TabLayoutMediator(this.binding.tabLayout, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestFragment$$ExternalSyntheticLambda0
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                this.f$0.lambda$initViewPagerAndTagLayout$2(tab, i);
            }
        }).attach();
        getResources().getColor(R.color.blo_black);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViewPagerAndTagLayout$2(TabLayout.Tab tab, int i) {
        tab.setText(this.tabs[i]);
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
}
