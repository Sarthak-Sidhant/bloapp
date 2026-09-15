package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import java.util.Locale;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class LocaleHelper {
    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";

    public static Context setLocale(Context context, String language) {
        persist(context, language);
        return updateResources(context, language);
    }

    private static void persist(Context context, String language) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString(SELECTED_LANGUAGE, language);
        editorEdit.apply();
    }

    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        return context.createConfigurationContext(configuration);
    }

    private static Context updateResourcesLegacy(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        configuration.setLayoutDirection(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
