package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityElectorsListBinding;
import in.gov.eci.bloapp.views.fragments.electors_list.ElectorsListFragment;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ElectorsListActivity extends Hilt_ElectorsListActivity {
    private BloActivityElectorsListBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityElectorsListBinding bloActivityElectorsListBindingInflate = BloActivityElectorsListBinding.inflate(getLayoutInflater());
        this.binding = bloActivityElectorsListBindingInflate;
        setContentView(bloActivityElectorsListBindingInflate.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.electorsListFrame, new ElectorsListFragment()).commitAllowingStateLoss();
        }
    }
}
