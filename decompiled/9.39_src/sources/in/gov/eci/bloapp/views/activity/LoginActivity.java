package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import android.view.View;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityLoginBinding;
import in.gov.eci.bloapp.views.fragments.login.LoginFragment;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class LoginActivity extends Hilt_LoginActivity {
    public String selectedFragmentTag = "Login_Fragment";

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((View) BloActivityLoginBinding.inflate(getLayoutInflater()).getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new LoginFragment(), this.selectedFragmentTag).commitAllowingStateLoss();
        }
    }
}
