package in.gov.eci.bloapp.views.activity.newsir.callback;

import in.gov.eci.bloapp.views.activity.newsir.model.FormverificationPayload;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface VerifyCitizenListCallback {
    void onCallBack(int code, List<FormverificationPayload> formlist, String message);
}
