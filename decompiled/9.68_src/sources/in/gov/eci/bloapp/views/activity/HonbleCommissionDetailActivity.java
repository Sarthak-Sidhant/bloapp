package in.gov.eci.bloapp.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bumptech.glide.Glide;
import in.gov.eci.bloapp.databinding.BloActivityHonbleCommissionDetailBinding;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class HonbleCommissionDetailActivity extends BaseActivity {
    BloActivityHonbleCommissionDetailBinding BloActivityHonbleCommissionDetailBinding;
    String name = "";
    String details = "";
    String image = "";

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityHonbleCommissionDetailBinding bloActivityHonbleCommissionDetailBindingInflate = BloActivityHonbleCommissionDetailBinding.inflate(getLayoutInflater());
        this.BloActivityHonbleCommissionDetailBinding = bloActivityHonbleCommissionDetailBindingInflate;
        setContentView(bloActivityHonbleCommissionDetailBindingInflate.getRoot());
        this.BloActivityHonbleCommissionDetailBinding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.HonbleCommissionDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            this.name = extras.getString("name");
            this.details = extras.getString("details");
            this.image = extras.getString("image");
        }
        if (this.image != null) {
            Glide.with(this).load(this.image).into(this.BloActivityHonbleCommissionDetailBinding.commissionImage);
        }
        this.BloActivityHonbleCommissionDetailBinding.textViewCommissionName.setText(this.name);
        this.BloActivityHonbleCommissionDetailBinding.textViewCommissionDescription.setText(this.details);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }
}
