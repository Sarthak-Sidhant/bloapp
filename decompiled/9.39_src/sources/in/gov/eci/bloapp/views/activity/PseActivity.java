package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityPseBinding;
import in.gov.eci.bloapp.views.fragments.pse.PseMainFragment;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class PseActivity extends Hilt_PseActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(BloActivityPseBinding.inflate(getLayoutInflater()).getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new PseMainFragment()).commitAllowingStateLoss();
        }
    }
}
