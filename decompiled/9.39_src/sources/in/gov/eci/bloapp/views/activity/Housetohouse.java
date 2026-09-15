package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import android.view.View;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityHouseToHouseBinding;
import in.gov.eci.bloapp.views.fragments.h2h.H2HFragment;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Housetohouse extends Hilt_Housetohouse {
    private BloActivityHouseToHouseBinding binding;

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityHouseToHouseBinding bloActivityHouseToHouseBindingInflate = BloActivityHouseToHouseBinding.inflate(getLayoutInflater());
        this.binding = bloActivityHouseToHouseBindingInflate;
        setContentView((View) bloActivityHouseToHouseBindingInflate.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new H2HFragment()).commitAllowingStateLoss();
        }
    }
}
