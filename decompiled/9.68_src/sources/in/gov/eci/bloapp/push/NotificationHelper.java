package in.gov.eci.bloapp.push;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.BloNotifiy;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class NotificationHelper {
    public static final String CHANNEL_GENERAL = "general_notifications";

    private NotificationHelper() {
    }

    public static void ensureChannels(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_GENERAL, "General", 3);
        notificationChannel.setDescription("General app notifications");
        notificationManager.createNotificationChannel(notificationChannel);
    }

    private static PendingIntent createContentIntent(Context context) {
        Intent intentAddFlags = new Intent(context, (Class<?>) BloNotifiy.class).addFlags(603979776);
        TaskStackBuilder taskStackBuilderCreate = TaskStackBuilder.create(context);
        taskStackBuilderCreate.addNextIntentWithParentStack(intentAddFlags);
        return taskStackBuilderCreate.getPendingIntent((int) (System.currentTimeMillis() & 268435455), 201326592);
    }

    public static void showNotification(Context context, String title, String body, String channelId, String unusedDeepLink, String unusedImageUrl, Integer notificationId, String groupKey) {
        ensureChannels(context);
        int iIntValue = notificationId != null ? notificationId.intValue() : (int) (System.currentTimeMillis() & 268435455);
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(context, channelId).setSmallIcon(R.drawable.blo_noti);
        if (title == null) {
            title = context.getString(R.string.app_name);
        }
        NotificationCompat.Builder contentText = smallIcon.setContentTitle(title).setContentText(body != null ? body : "");
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        if (body == null) {
            body = "";
        }
        NotificationCompat.Builder priority = contentText.setStyle(bigTextStyle.bigText(body)).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2)).setColor(ContextCompat.getColor(context, R.color.blo_app_theme)).setContentIntent(createContentIntent(context)).setPriority(0);
        if (groupKey != null && !groupKey.trim().isEmpty()) {
            priority.setGroup(groupKey);
        }
        ((NotificationManager) context.getSystemService("notification")).notify(iIntValue, priority.build());
    }
}
