package in.gov.eci.bloapp.views.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.SharedPref;
import java.util.Locale;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BaseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
        SQLiteDatabase.loadLibs(getApplicationContext());
    }

    public static boolean isNetworkAvailable(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void showToast(String message) {
        Toast.makeText((Context) this, (CharSequence) message, 0).show();
    }

    protected void visibleGoneView(View view, Boolean isVisible) {
        if (Boolean.TRUE.equals(isVisible)) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        applyWindowInsets();
    }

    private void applyWindowInsets() {
        View viewFindViewById = findViewById(R.id.content);
        if (viewFindViewById != null) {
            ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, new OnApplyWindowInsetsListener() { // from class: in.gov.eci.bloapp.views.activity.BaseActivity$$ExternalSyntheticLambda0
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return BaseActivity.lambda$applyWindowInsets$0(view, windowInsetsCompat);
                }
            });
        }
    }

    static /* synthetic */ WindowInsetsCompat lambda$applyWindowInsets$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.statusBars());
        view.setPadding(insets.left, insets.top, insets.right, windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom);
        return windowInsetsCompat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLocale(Activity activity, String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        if (SharedPref.getInstance(this).getLocaleBool()) {
            return;
        }
        SharedPref.getInstance(this).setLocaleBool(true);
        recreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public Context setLocale(Context activity, String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Configuration configuration = activity.getResources().getConfiguration();
        configuration.setLocale(locale);
        return activity.createConfigurationContext(configuration);
    }

    protected void attachBaseContext(Context newBase) {
        Log.d("default Lang Bas", SharedPref.getInstance(newBase).getSIRLangCode());
        super.attachBaseContext(setLocale(newBase, Constants.COUNTRYNAME2_LANG));
    }
}
