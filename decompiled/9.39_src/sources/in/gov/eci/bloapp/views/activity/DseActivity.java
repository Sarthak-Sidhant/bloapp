package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityDseBinding;
import in.gov.eci.bloapp.views.fragments.dse.DseMainFragment;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DseActivity extends Hilt_DseActivity {
    private BloActivityDseBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityDseBinding bloActivityDseBindingInflate = BloActivityDseBinding.inflate(getLayoutInflater());
        this.binding = bloActivityDseBindingInflate;
        setContentView(bloActivityDseBindingInflate.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new DseMainFragment()).commitAllowingStateLoss();
        }
    }
}
