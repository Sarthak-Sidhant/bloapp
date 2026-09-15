package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import in.gov.eci.bloapp.databinding.BloActivityOfficialsContactDetailsBinding;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class OfficialsContactDetailsActivity extends BaseActivity {
    BloActivityOfficialsContactDetailsBinding BloActivityOfficialsContactDetailsBinding;
    WebView webview;

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityOfficialsContactDetailsBinding bloActivityOfficialsContactDetailsBindingInflate = BloActivityOfficialsContactDetailsBinding.inflate(getLayoutInflater());
        this.BloActivityOfficialsContactDetailsBinding = bloActivityOfficialsContactDetailsBindingInflate;
        setContentView(bloActivityOfficialsContactDetailsBindingInflate.getRoot());
        this.BloActivityOfficialsContactDetailsBinding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.OfficialsContactDetailsActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        WebView webView = this.BloActivityOfficialsContactDetailsBinding.officialsContactDetailsWebview;
        this.webview = webView;
        webView.setHorizontalScrollBarEnabled(false);
        WebSettings settings = this.webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        this.webview.setWebViewClient(new WebViewClient());
        this.webview.loadUrl("https://www.eci.gov.in/officers-directory");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }
}
