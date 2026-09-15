package in.gov.eci.bloapp.api;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ApiFactory {
    private static final String TAG = "API_MAPPING";

    public static <T> T createClientApi(Context context, Class<T> cls) {
        Log.d(TAG, "Using getClient (baseurl) for: " + cls.getSimpleName());
        return (T) ApiClient.getClient(context).create(cls);
    }

    public static <T> T createClient2Api(Context context, Class<T> cls) {
        Log.d(TAG, "Using getClient2 (baseurl2) for: " + cls.getSimpleName());
        return (T) ApiClient.getClient2(context).create(cls);
    }

    public static <T> T createClient1Api(Context context, Class<T> cls) {
        Log.d(TAG, "Using getClient1 for: " + cls.getSimpleName());
        return (T) ApiClient.getClient1(context).create(cls);
    }
}
