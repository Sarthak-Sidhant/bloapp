package in.gov.eci.bloapp.views.fragments.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import in.gov.eci.bloapp.databinding.BloFragmentSlideshowBinding;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class SlideshowFragment extends Fragment {
    private BloFragmentSlideshowBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BloFragmentSlideshowBinding bloFragmentSlideshowBindingInflate = BloFragmentSlideshowBinding.inflate(getLayoutInflater());
        this.binding = bloFragmentSlideshowBindingInflate;
        return bloFragmentSlideshowBindingInflate.getRoot();
    }
}
