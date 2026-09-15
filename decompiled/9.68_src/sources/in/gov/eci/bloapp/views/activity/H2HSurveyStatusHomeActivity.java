package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import in.gov.eci.bloapp.databinding.BloActivityH2HsurveyStatusHomeBinding;
import in.gov.eci.bloapp.utils.Logger;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class H2HSurveyStatusHomeActivity extends AppCompatActivity {
    BloActivityH2HsurveyStatusHomeBinding BloActivityH2HsurveyStatusHomeBinding;
    String logTag = "H2HSurveyStatusHomeActivity";
    String formTypeText = "Form Type";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityH2HsurveyStatusHomeBinding bloActivityH2HsurveyStatusHomeBindingInflate = BloActivityH2HsurveyStatusHomeBinding.inflate(getLayoutInflater());
        this.BloActivityH2HsurveyStatusHomeBinding = bloActivityH2HsurveyStatusHomeBindingInflate;
        setContentView(bloActivityH2HsurveyStatusHomeBindingInflate.getRoot());
        this.BloActivityH2HsurveyStatusHomeBinding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusHomeActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.BloActivityH2HsurveyStatusHomeBinding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusHomeActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.BloActivityH2HsurveyStatusHomeBinding.Form7StatusLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusHomeActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.BloActivityH2HsurveyStatusHomeBinding.Form8StatusLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusHomeActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        Intent intent = new Intent((Context) this, (Class<?>) H2HSurveyStatusActivity.class);
        intent.putExtra(this.formTypeText, "form7");
        Logger.d(this.logTag, "Bundle for h2hSurveyStatus : " + intent);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        Intent intent = new Intent((Context) this, (Class<?>) H2HSurveyStatusActivity.class);
        intent.putExtra(this.formTypeText, "form8");
        Logger.d(this.logTag, "Bundle for h2hSurveyStatus : " + intent);
        startActivity(intent);
    }
}
