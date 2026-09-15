package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import in.gov.eci.bloapp.databinding.BloActivityPasswordChangeSuccessfullyBinding;
import in.gov.eci.bloapp.utils.SharedPref;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PasswordChangeSuccessfully extends BaseActivity {
    private BloActivityPasswordChangeSuccessfullyBinding binding1;

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityPasswordChangeSuccessfullyBinding bloActivityPasswordChangeSuccessfullyBindingInflate = BloActivityPasswordChangeSuccessfullyBinding.inflate(getLayoutInflater());
        this.binding1 = bloActivityPasswordChangeSuccessfullyBindingInflate;
        setContentView((View) bloActivityPasswordChangeSuccessfullyBindingInflate.getRoot());
        this.binding1.login.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.PasswordChangeSuccessfully$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.activity.PasswordChangeSuccessfully.1
            public void handleOnBackPressed() {
                SharedPref.getInstance(PasswordChangeSuccessfully.this).setIsLoggedIn(false);
                PasswordChangeSuccessfully.this.startActivity(new Intent((Context) PasswordChangeSuccessfully.this, (Class<?>) LoginActivity.class));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        SharedPref.getInstance(this).setIsLoggedIn(false);
        startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
    }
}
