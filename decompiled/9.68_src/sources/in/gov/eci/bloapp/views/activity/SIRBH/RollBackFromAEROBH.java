package in.gov.eci.bloapp.views.activity.SIRBH;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import in.gov.eci.bloapp.databinding.ActivityRollBackFromAeroBhBinding;
import in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH;
import in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.RollbackFormsListBH;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class RollBackFromAEROBH extends SuperBaseActivity {
    ActivityRollBackFromAeroBhBinding binding;

    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRollBackFromAeroBhBinding activityRollBackFromAeroBhBindingInflate = ActivityRollBackFromAeroBhBinding.inflate(getLayoutInflater());
        this.binding = activityRollBackFromAeroBhBindingInflate;
        setContentView(activityRollBackFromAeroBhBindingInflate.getRoot());
        this.binding.rollbackNewLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.RollBackFromAEROBH$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.rollbackEditLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.RollBackFromAEROBH$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.backBtnIv.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.RollBackFromAEROBH$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$onCreate$2(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent((Context) this, (Class<?>) RollBAckNewFormsEroBH.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        startActivity(new Intent((Context) this, (Class<?>) RollbackFormsListBH.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean lambda$onCreate$2(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        startActivity(new Intent((Context) this, (Class<?>) FormTypesBH.class));
        return true;
    }
}
