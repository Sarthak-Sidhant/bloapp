package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import android.view.View;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityMyAccountBinding;
import in.gov.eci.bloapp.views.fragments.my_account.MyAccount;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ActivityMyAccount extends Hilt_ActivityMyAccount {
    BloActivityMyAccountBinding binding;
    boolean setFlag = false;

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        this.binding = BloActivityMyAccountBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView((View) this.binding.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main, new MyAccount()).commitAllowingStateLoss();
        }
    }
}
