package in.gov.eci.bloapp.views.fragments.pse.pseidentified;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter;
import in.gov.eci.bloapp.databinding.BloFragmentPseIdentifiedBinding;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.pse.PseMainFragment;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class PseIdentifiedFragment extends Fragment {
    private GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface adapterInterface;
    BloFragmentPseIdentifiedBinding binding;
    Retrofit.Builder builder;
    Retrofit retrofit;
    private final String[] tabs = {"PSE within Part", "PSE across Part"};
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public PseIdentifiedFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentPseIdentifiedBinding.inflate(getLayoutInflater());
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setView(viewInflate);
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.PseIdentifiedFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        initClickListener();
        setUpViewPager();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.PseIdentifiedFragment$$ExternalSyntheticLambda0
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

    private void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    private void setUpViewPager() {
        this.adapterInterface = new GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.PseIdentifiedFragment.1
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public int getCount() {
                return 2;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericFragmentPagerAdapter.GenericFragmentPagerAdapterInterface
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new PseWithinPartFragment();
                }
                return new PseAcrossPartFragment();
            }
        };
        initViewPagerAndTagLayout();
    }

    private void initViewPagerAndTagLayout() {
        this.binding.viewPager.setAdapter(new GenericFragmentPagerAdapter(getChildFragmentManager(), getLifecycle(), this.adapterInterface));
        new TabLayoutMediator(this.binding.tabLayout, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: in.gov.eci.bloapp.views.fragments.pse.pseidentified.PseIdentifiedFragment$$ExternalSyntheticLambda2
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

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
