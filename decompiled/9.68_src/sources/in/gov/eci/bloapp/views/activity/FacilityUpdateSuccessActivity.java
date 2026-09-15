package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import in.gov.eci.bloapp.databinding.BloActivityFacilityUpdateSuccessBinding;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FacilityUpdateSuccessActivity extends BaseActivity {
    BloActivityFacilityUpdateSuccessBinding facilityUpdateSuccessBinding;

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityFacilityUpdateSuccessBinding bloActivityFacilityUpdateSuccessBindingInflate = BloActivityFacilityUpdateSuccessBinding.inflate(getLayoutInflater());
        this.facilityUpdateSuccessBinding = bloActivityFacilityUpdateSuccessBindingInflate;
        setContentView((View) bloActivityFacilityUpdateSuccessBindingInflate.getRoot());
        this.facilityUpdateSuccessBinding.imageButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FacilityUpdateSuccessActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.facilityUpdateSuccessBinding.homeButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.FacilityUpdateSuccessActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent((Context) this, (Class<?>) facility.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
        finish();
    }
}
