package in.gov.eci.bloapp.views.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import in.gov.eci.bloapp.databinding.BloActivityContactDetailsofCeosBinding;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ContactDetailsofCEOsActivity extends BaseActivity {
    BloActivityContactDetailsofCeosBinding activityContactDetailsofCeosBinding;
    WebView webview;

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityContactDetailsofCeosBinding bloActivityContactDetailsofCeosBindingInflate = BloActivityContactDetailsofCeosBinding.inflate(getLayoutInflater());
        this.activityContactDetailsofCeosBinding = bloActivityContactDetailsofCeosBindingInflate;
        setContentView(bloActivityContactDetailsofCeosBindingInflate.getRoot());
        this.activityContactDetailsofCeosBinding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ContactDetailsofCEOsActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        WebView webView = this.activityContactDetailsofCeosBinding.contactDetailsOfCEOsWebview;
        this.webview = webView;
        webView.setHorizontalScrollBarEnabled(false);
        WebSettings settings = this.webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        this.webview.setWebViewClient(new WebViewClient());
        this.webview.loadUrl("https://www.eci.gov.in/ceo-contact-details");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }
}
