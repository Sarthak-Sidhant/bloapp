package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import in.gov.eci.bloapp.utils.SharedPref;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SuperBaseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        setLocaleChanges();
        super.onCreate(savedInstanceState);
        SQLiteDatabase.loadLibs(getApplicationContext());
    }

    public static boolean isNetworkAvailable(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void showToast(String message) {
        Toast.makeText((Context) this, (CharSequence) message, 0).show();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLocaleChanges() {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(SharedPref.getInstance(this).getSIRLangCode()));
    }
}
