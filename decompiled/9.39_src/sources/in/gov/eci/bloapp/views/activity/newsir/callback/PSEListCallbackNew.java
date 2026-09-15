package in.gov.eci.bloapp.views.activity.newsir.callback;

import in.gov.eci.bloapp.views.activity.newsir.model.PSEPayload;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface PSEListCallbackNew {
    void onCallBack(int code, List<PSEPayload> formlist, String message);
}
