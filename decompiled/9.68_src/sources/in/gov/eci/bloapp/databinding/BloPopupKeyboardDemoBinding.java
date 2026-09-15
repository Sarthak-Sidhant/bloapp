package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloPopupKeyboardDemoBinding implements ViewBinding {
    public final LinearLayout SliderDots;
    private final LinearLayout rootView;
    public final ViewPager viewPager;

    private BloPopupKeyboardDemoBinding(LinearLayout rootView, LinearLayout SliderDots, ViewPager viewPager) {
        this.rootView = rootView;
        this.SliderDots = SliderDots;
        this.viewPager = viewPager;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloPopupKeyboardDemoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloPopupKeyboardDemoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_popup_keyboard_demo, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloPopupKeyboardDemoBinding bind(View rootView) {
        int i = R.id.SliderDots;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.SliderDots);
        if (linearLayout != null) {
            i = R.id.viewPager;
            ViewPager viewPagerFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewPager);
            if (viewPagerFindChildViewById != null) {
                return new BloPopupKeyboardDemoBinding((LinearLayout) rootView, linearLayout, viewPagerFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
