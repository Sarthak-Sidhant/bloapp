package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import android.view.View;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityAboutEciactivityBinding;
import in.gov.eci.bloapp.views.fragments.about_eci.AboutEciFragment;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AboutECIActivity extends Hilt_AboutECIActivity {
    BloActivityAboutEciactivityBinding binding;

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityAboutEciactivityBinding bloActivityAboutEciactivityBindingInflate = BloActivityAboutEciactivityBinding.inflate(getLayoutInflater());
        this.binding = bloActivityAboutEciactivityBindingInflate;
        setContentView((View) bloActivityAboutEciactivityBindingInflate.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.aboutEci, new AboutEciFragment()).commitAllowingStateLoss();
        }
    }
}
