package in.gov.eci.bloapp.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityFacilityBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.views.fragments.facilities.Facilities;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class facility extends Hilt_facility {
    BloActivityFacilityBinding binding;
    String latLongText = "latitude and longitude";
    String addressText = "address";

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityFacilityBinding bloActivityFacilityBindingInflate = BloActivityFacilityBinding.inflate(getLayoutInflater());
        this.binding = bloActivityFacilityBindingInflate;
        setContentView((View) bloActivityFacilityBindingInflate.getRoot());
        openFragment(new Facilities());
    }

    private void openFragment(Facilities fragment) {
        Intent intent = getIntent();
        if (intent.getStringExtra(this.latLongText) != null) {
            Logger.d("", this.latLongText + intent.getStringExtra(this.latLongText));
            Bundle bundle = new Bundle();
            String str = this.addressText;
            bundle.putString(str, intent.getStringExtra(str));
            fragment.setArguments(bundle);
            String str2 = this.latLongText;
            bundle.putString(str2, intent.getStringExtra(str2));
            fragment.setArguments(bundle);
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame1, fragment);
        fragmentTransactionBeginTransaction.setTransition(4097);
        fragmentTransactionBeginTransaction.commit();
    }
}
