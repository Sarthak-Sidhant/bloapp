package in.gov.eci.bloapp.push;

import android.content.Context;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import in.gov.eci.bloapp.utils.Constants;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FcmMessagingService extends FirebaseMessagingService {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private void sendTokenToServer(String token) {
    }

    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.d("FCM", "New token: " + token);
        sendTokenToServer(token);
    }

    public void onMessageReceived(RemoteMessage message) {
        super.onMessageReceived(message);
        final Context applicationContext = getApplicationContext();
        Map data = message.getData();
        final String title = (String) data.get(Constants.TITLE);
        final String body = (String) data.get("body");
        if (title == null && message.getNotification() != null) {
            title = message.getNotification().getTitle();
        }
        if (body == null && message.getNotification() != null) {
            body = message.getNotification().getBody();
        }
        this.executor.execute(new Runnable() { // from class: in.gov.eci.bloapp.push.FcmMessagingService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NotificationHelper.showNotification(applicationContext, title, body, NotificationHelper.CHANNEL_GENERAL, null, null, null, null);
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        this.executor.shutdown();
    }
}
