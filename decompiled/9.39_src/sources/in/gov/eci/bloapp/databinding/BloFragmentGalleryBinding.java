package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentGalleryBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TabLayout tabLayout;
    public final ViewPager2 viewPager;

    private BloFragmentGalleryBinding(ConstraintLayout rootView, TabLayout tabLayout, ViewPager2 viewPager) {
        this.rootView = rootView;
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentGalleryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentGalleryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_gallery, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentGalleryBinding bind(View rootView) {
        int i = R.id.tabLayout;
        TabLayout tabLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.tabLayout);
        if (tabLayoutFindChildViewById != null) {
            i = R.id.view_pager;
            ViewPager2 viewPager2FindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_pager);
            if (viewPager2FindChildViewById != null) {
                return new BloFragmentGalleryBinding((ConstraintLayout) rootView, tabLayoutFindChildViewById, viewPager2FindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
