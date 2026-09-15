package in.gov.eci.bloapp.views.activity.newsir.callback;

import in.gov.eci.bloapp.views.activity.newsir.model.PayloadNewMapping;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface ErollDataCallback {
    void onCallBack(int code, List<PayloadNewMapping> datalist, String message);
}
