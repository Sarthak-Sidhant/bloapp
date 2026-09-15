package in.gov.eci.bloapp.utils;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.google.android.material.snackbar.Snackbar;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class NetworkReceiver extends BroadcastReceiver {
    private final Activity activity;

    public NetworkReceiver(Activity activity) {
        this.activity = activity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!isNetworkAvailable(context)) {
            showMessage("No Internet Connection");
        } else if (isInternetSlow(context)) {
            showMessage("Internet is slow.");
        }
    }

    private boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private boolean isInternetSlow(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.getLinkDownstreamBandwidthKbps() < 150;
    }

    private void showMessage(String message) {
        Snackbar.make(this.activity.findViewById(R.id.content), message, 0).show();
    }
}
