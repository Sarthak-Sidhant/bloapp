package in.gov.eci.bloapp.views.activity.newsir.callback;

import in.gov.eci.bloapp.views.activity.newsir.model.UpdateMobilePayload;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface UpdateMobileCallback {
    void onCallBack(int code, List<UpdateMobilePayload> formlist, String message);
}
