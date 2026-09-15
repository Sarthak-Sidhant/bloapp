package in.gov.eci.bloapp.views.activity.newsir.callback;

import in.gov.eci.bloapp.views.activity.newsir.model.UncollectableDetailsPayload;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface UnCollectableCallback {
    void onCallBack(int code, List<UncollectableDetailsPayload> formlist, String message);
}
