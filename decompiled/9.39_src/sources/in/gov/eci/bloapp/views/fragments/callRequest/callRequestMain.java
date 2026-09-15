package in.gov.eci.bloapp.views.fragments.callRequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter;
import in.gov.eci.bloapp.databinding.FragmentCallRequestMainBinding;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.BaseActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import java.util.Objects;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class callRequestMain extends BaseActivity {
    private GenericFragmentPagerAdapter adapter;
    private GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface adapterInterface;
    FragmentCallRequestMainBinding binding;
    public String stateCode;
    public String token = "";
    private final String[] tabs = {"PENDING", "ACKNOWLEDGED"};
    final int[] ICONS_CHECKLIST = {R.drawable.blo_outline_non_verified, R.drawable.blo_outline_verified};

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref.getInstance(getApplicationContext()).getToken();
        SharedPref.getInstance(getApplicationContext()).getStateCode();
        FragmentCallRequestMainBinding fragmentCallRequestMainBindingInflate = FragmentCallRequestMainBinding.inflate(getLayoutInflater());
        this.binding = fragmentCallRequestMainBindingInflate;
        setContentView((View) fragmentCallRequestMainBindingInflate.getRoot());
        setUpViewPager();
        initViewPagerAndTagLayout();
        ((TabLayout.Tab) Objects.requireNonNull(this.binding.tabLayout.getTabAt(0))).setIcon(this.ICONS_CHECKLIST[0]);
        ((TabLayout.Tab) Objects.requireNonNull(this.binding.tabLayout.getTabAt(1))).setIcon(this.ICONS_CHECKLIST[1]);
        initClickListener();
    }

    private void setUpViewPager() {
        this.adapterInterface = new GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestMain.1
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public int getCount() {
                return 2;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new callRequestPending();
                }
                return new callRequestCompleted();
            }
        };
    }

    private void initViewPagerAndTagLayout() {
        this.adapter = new GenericFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle(), this.adapterInterface);
        this.binding.viewPager.setAdapter(this.adapter);
        new TabLayoutMediator(this.binding.tabLayout, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestMain$$ExternalSyntheticLambda1
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                this.f$0.lambda$initViewPagerAndTagLayout$0(tab, i);
            }
        }).attach();
        getResources().getColor(R.color.blo_black);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViewPagerAndTagLayout$0(TabLayout.Tab tab, int i) {
        tab.setText(this.tabs[i]);
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestMain$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) MainActivity.class));
    }
}
