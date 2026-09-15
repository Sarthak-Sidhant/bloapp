package in.gov.eci.bloapp.utils;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DeviceUtils {
    private String getDeviceIdd(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }
}
