package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityVoterFormsBinding;
import in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class VoterForms extends Hilt_VoterForms {
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        String stringExtra2;
        super.onCreate(savedInstanceState);
        setContentView((View) BloActivityVoterFormsBinding.inflate(getLayoutInflater()).getRoot());
        AppCompatDelegate.setDefaultNightMode(1);
        if (savedInstanceState == null) {
            if (getIntent() == null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_voter_forms, new VoterFormsFragment(), "VOTER_FORMS").commitAllowingStateLoss();
                return;
            }
            String stringExtra3 = getIntent().getStringExtra("flag");
            String stringExtra4 = getIntent().getStringExtra("category");
            String stringExtra5 = getIntent().getStringExtra("epic");
            int longExtra = (int) getIntent().getLongExtra("epicId", 0L);
            if (!TextUtils.isEmpty(stringExtra3) && stringExtra3.equalsIgnoreCase("selectPhoto")) {
                stringExtra = getIntent().getStringExtra("efPhoto");
                stringExtra2 = getIntent().getStringExtra("efbase64image");
            } else {
                stringExtra = "";
                stringExtra2 = "";
            }
            VoterFormsFragment voterFormsFragment = new VoterFormsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("flag", stringExtra3);
            bundle.putString("epic", stringExtra5);
            bundle.putString("epicId", String.valueOf(longExtra));
            bundle.putString("efPhoto", stringExtra);
            bundle.putString("efbase64image", stringExtra2);
            bundle.putString("category", stringExtra4);
            voterFormsFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_voter_forms, voterFormsFragment, "VOTER_FORMS").commitAllowingStateLoss();
        }
    }
}
