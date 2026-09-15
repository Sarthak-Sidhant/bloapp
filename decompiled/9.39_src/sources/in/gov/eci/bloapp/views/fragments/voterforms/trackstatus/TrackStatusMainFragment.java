package in.gov.eci.bloapp.views.fragments.voterforms.trackstatus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter;
import in.gov.eci.bloapp.databinding.BloFragmentTrackStatusMain2Binding;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class TrackStatusMainFragment extends Hilt_TrackStatusMainFragment {
    private GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface adapterInterface;
    private BloFragmentTrackStatusMain2Binding binding;
    private final String[] tabs = {"TRACK STATUS", "SUBMITTED", "REJECTED"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BloFragmentTrackStatusMain2Binding bloFragmentTrackStatusMain2BindingInflate = BloFragmentTrackStatusMain2Binding.inflate(getLayoutInflater());
        this.binding = bloFragmentTrackStatusMain2BindingInflate;
        bloFragmentTrackStatusMain2BindingInflate.backBtnIv.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusMainFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$onCreateView$0(view, motionEvent);
            }
        });
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusMainFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        setUpViewPager();
        initViewPagerAndTagLayout();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreateView$0(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        openFragment(new VoterFormsFragment(), "VoterFormsFragment");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    private void setUpViewPager() {
        this.adapterInterface = new GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusMainFragment.1
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public int getCount() {
                return 3;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new TrackStatusFragment();
                }
                if (position == 1) {
                    return new TrackSubmittedStatusFragment();
                }
                return new TrackRejectedFragment();
            }
        };
    }

    private void initViewPagerAndTagLayout() {
        this.binding.viewPager.setAdapter(new GenericFragmentPagerAdapter(getChildFragmentManager(), getLifecycle(), this.adapterInterface));
        new TabLayoutMediator(this.binding.tabLayout, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusMainFragment$$ExternalSyntheticLambda0
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                this.f$0.lambda$initViewPagerAndTagLayout$2(tab, i);
            }
        }).attach();
        getResources();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViewPagerAndTagLayout$2(TabLayout.Tab tab, int i) {
        tab.setText(this.tabs[i]);
    }

    private void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }
}
