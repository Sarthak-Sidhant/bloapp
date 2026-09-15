package in.gov.eci.bloapp.views.activity.newsir.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class CallUtils {
    private CallUtils() {
    }

    public static void openDialer(Context context, String phoneNumber) {
        String strSanitize = sanitize(phoneNumber);
        if (strSanitize.isEmpty()) {
            Toast.makeText(context, "Invalid phone number", 0).show();
            return;
        }
        try {
            context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + strSanitize)));
        } catch (Exception unused) {
            Toast.makeText(context, "No dialer app found on this device", 0).show();
        }
    }

    public static void callNowOrDial(Activity activity, String phoneNumber) {
        String strSanitize = sanitize(phoneNumber);
        if (strSanitize.isEmpty()) {
            Toast.makeText(activity, "Invalid phone number", 0).show();
        } else {
            if (ContextCompat.checkSelfPermission(activity, "android.permission.CALL_PHONE") == 0) {
                try {
                    activity.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + strSanitize)));
                    return;
                } catch (Exception unused) {
                    openDialer(activity, strSanitize);
                    return;
                }
            }
            openDialer(activity, strSanitize);
        }
    }

    private static String sanitize(String number) {
        return number == null ? "" : number.trim().replace(StringUtils.SPACE, "");
    }
}
