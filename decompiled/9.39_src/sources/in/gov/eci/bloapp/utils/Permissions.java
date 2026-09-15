package in.gov.eci.bloapp.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Permissions {
    public static Permissions permissions;
    private final String TAG = "Permissions";

    public static Permissions getInstance() {
        if (permissions == null) {
            permissions = new Permissions();
        }
        return permissions;
    }

    public boolean checkForPermissionInActivity(AppCompatActivity activity, int permissionType, String permission) {
        if (ContextCompat.checkSelfPermission(activity, permission) == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(activity, new String[]{permission}, permissionType);
        return false;
    }

    public boolean checkForPermissionInFragment(Fragment fragment, int permissionType, String permission) {
        if (ActivityCompat.checkSelfPermission(fragment.getContext(), permission) == 0) {
            return true;
        }
        fragment.requestPermissions(new String[]{permission}, permissionType);
        return false;
    }
}
