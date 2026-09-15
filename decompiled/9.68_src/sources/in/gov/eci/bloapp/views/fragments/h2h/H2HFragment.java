package in.gov.eci.bloapp.views.fragments.h2h;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter;
import in.gov.eci.bloapp.databinding.BloFragmentTrackStatusMainBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.views.activity.MainActivity;
import java.util.Objects;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class H2HFragment extends Hilt_H2HFragment {
    private GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface adapterInterface;
    BloFragmentTrackStatusMainBinding binding;
    private String[] tabs;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentTrackStatusMainBinding.inflate(getLayoutInflater());
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HFragment.1
            public void handleOnBackPressed() {
                Intent intent = new Intent((Context) H2HFragment.this.getActivity(), (Class<?>) MainActivity.class);
                Constants.h2hflag = 0;
                H2HFragment.this.startActivity(intent);
            }
        });
        this.tabs = new String[]{"NOT VERIFIED", "VERIFIED"};
        initClickListener();
        setUpViewPager();
        initViewPagerAndTagLayout();
        return this.binding.getRoot();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        Constants.h2hflag = 0;
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    private void setUpViewPager() {
        this.adapterInterface = new GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HFragment.2
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public int getCount() {
                return 2;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public Fragment getItem(int position) {
                ((TabLayout.Tab) Objects.requireNonNull(H2HFragment.this.binding.tabLayout.getTabAt(0))).setIcon(R.drawable.blo_allhouses);
                ((TabLayout.Tab) Objects.requireNonNull(H2HFragment.this.binding.tabLayout.getTabAt(1))).setIcon(R.drawable.blo_verified);
                if (position == 0) {
                    ((TabLayout.Tab) Objects.requireNonNull(H2HFragment.this.binding.tabLayout.getTabAt(0))).setIcon(R.drawable.blo_allhouses);
                    ((TabLayout.Tab) Objects.requireNonNull(H2HFragment.this.binding.tabLayout.getTabAt(1))).setIcon(R.drawable.blo_verified);
                    return new AllHousesFragment();
                }
                ((TabLayout.Tab) Objects.requireNonNull(H2HFragment.this.binding.tabLayout.getTabAt(0))).setIcon(R.drawable.blo_allhouses);
                ((TabLayout.Tab) Objects.requireNonNull(H2HFragment.this.binding.tabLayout.getTabAt(1))).setIcon(R.drawable.blo_verified);
                return new VerifiedFragment();
            }
        };
    }

    private void initViewPagerAndTagLayout() {
        this.binding.viewPager.setAdapter(new GenericFragmentPagerAdapter(getChildFragmentManager(), getLifecycle(), this.adapterInterface));
        new TabLayoutMediator(this.binding.tabLayout, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.gov.eci.bloapp.views.fragments.h2h.H2HFragment$$ExternalSyntheticLambda1
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                this.f$0.lambda$initViewPagerAndTagLayout$1(tab, i);
            }
        }).attach();
        ((TabLayout.Tab) Objects.requireNonNull(this.binding.tabLayout.getTabAt(0))).setIcon(R.drawable.blo_allhouses);
        ((TabLayout.Tab) Objects.requireNonNull(this.binding.tabLayout.getTabAt(1))).setIcon(R.drawable.blo_verified);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViewPagerAndTagLayout$1(TabLayout.Tab tab, int i) {
        tab.setText(this.tabs[i]);
    }
}
