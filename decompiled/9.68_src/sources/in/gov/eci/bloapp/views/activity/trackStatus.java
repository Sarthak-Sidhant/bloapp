package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityTrackStatusBinding;
import in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusMainFragment;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class trackStatus extends Hilt_trackStatus {
    public String selectedFragmentTag = "VOTER_FORMS";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(BloActivityTrackStatusBinding.inflate(getLayoutInflater()).getRoot());
        AppCompatDelegate.setDefaultNightMode(1);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_voter_forms, new TrackStatusMainFragment(), this.selectedFragmentTag).commitAllowingStateLoss();
        }
    }
}
