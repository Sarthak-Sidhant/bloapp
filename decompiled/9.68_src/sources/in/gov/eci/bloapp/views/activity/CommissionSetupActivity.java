package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import in.gov.eci.bloapp.databinding.BloActivityCommissionSetupBinding;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CommissionSetupActivity extends BaseActivity {
    BloActivityCommissionSetupBinding activityCommissionSetupBinding;
    WebView webview;

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityCommissionSetupBinding bloActivityCommissionSetupBindingInflate = BloActivityCommissionSetupBinding.inflate(getLayoutInflater());
        this.activityCommissionSetupBinding = bloActivityCommissionSetupBindingInflate;
        setContentView(bloActivityCommissionSetupBindingInflate.getRoot());
        this.activityCommissionSetupBinding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.CommissionSetupActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        WebView webView = this.activityCommissionSetupBinding.commissionSetupWebview;
        this.webview = webView;
        webView.setHorizontalScrollBarEnabled(false);
        this.webview.loadUrl("file:///android_asset/blo_about_commission.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }
}
