package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import in.gov.eci.bloapp.databinding.BloActivitySendForApprovalBinding;
import in.gov.eci.bloapp.utils.Logger;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ActivitySendForApproval extends Hilt_ActivitySendForApproval {
    BloActivitySendForApprovalBinding binding;
    String sendForApproval = "Note : Your request has been sent for approval. Post ERO approval, you are required to relogin in BLOAPP.";

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        this.binding = BloActivitySendForApprovalBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView((View) this.binding.getRoot());
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("oldPhoneNumber");
        String stringExtra2 = intent.getStringExtra("newPhoneNumber");
        Logger.d("", stringExtra);
        Logger.d("", stringExtra2);
        if (!stringExtra.equals(stringExtra2)) {
            this.binding.sentApprovalHeader2.setText(this.sendForApproval);
        } else {
            this.binding.sentApprovalHeader2.setText(this.sendForApproval);
        }
        this.binding.home.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ActivitySendForApproval$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        ActivityEditMyAccount activityEditMyAccount = new ActivityEditMyAccount();
        activityEditMyAccount.getDate();
        this.binding.dateToday.setText("as on " + activityEditMyAccount.getDate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
        finish();
    }
}
