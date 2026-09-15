package in.gov.eci.bloapp.views.activity.sir;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import in.gov.eci.bloapp.databinding.ActivityRollBackFromAeroBinding;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroFormsListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroUncollectableListActivity;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class RollBackFromAERO extends SuperBaseActivity {
    ActivityRollBackFromAeroBinding binding;

    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRollBackFromAeroBinding activityRollBackFromAeroBindingInflate = ActivityRollBackFromAeroBinding.inflate(getLayoutInflater());
        this.binding = activityRollBackFromAeroBindingInflate;
        setContentView(activityRollBackFromAeroBindingInflate.getRoot());
        this.binding.rollbackNewLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.RollBackFromAERO$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.rollbackEditLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.RollBackFromAERO$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.RollBackFromAERO.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RollBackFromAERO.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent((Context) this, (Class<?>) SentBackEroUncollectableListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        startActivity(new Intent((Context) this, (Class<?>) SentBackEroFormsListActivity.class));
    }
}
