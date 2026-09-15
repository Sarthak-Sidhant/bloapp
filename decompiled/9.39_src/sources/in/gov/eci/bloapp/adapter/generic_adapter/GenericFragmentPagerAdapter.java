package in.gov.eci.bloapp.adapter.generic_adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class GenericFragmentPagerAdapter extends FragmentStateAdapter {
    private final GenericFragmentPagerAdapterInterface genericFragmentPagerAdapterInterface;

    public interface GenericFragmentPagerAdapterInterface {
        int getCount();

        Fragment getItem(int position);
    }

    public GenericFragmentPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, GenericFragmentPagerAdapterInterface genericFragmentPagerAdapterInterface) {
        super(fragmentManager, lifecycle);
        this.genericFragmentPagerAdapterInterface = genericFragmentPagerAdapterInterface;
    }

    public Fragment createFragment(int position) {
        return this.genericFragmentPagerAdapterInterface.getItem(position);
    }

    public int getItemCount() {
        return this.genericFragmentPagerAdapterInterface.getCount();
    }
}
