package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityH2HdashBoardBinding;
import in.gov.eci.bloapp.views.fragments.h2h_dashboard.H2HDashboardFragment;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class H2HDashBoard extends AppCompatActivity {
    BloActivityH2HdashBoardBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityH2HdashBoardBinding bloActivityH2HdashBoardBindingInflate = BloActivityH2HdashBoardBinding.inflate(getLayoutInflater());
        this.binding = bloActivityH2HdashBoardBindingInflate;
        setContentView(bloActivityH2HdashBoardBindingInflate.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new H2HDashboardFragment()).commitAllowingStateLoss();
        }
    }
}
