package in.gov.eci.bloapp.languagetransliteration;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PreferenceHelper {
    public static final String PREF_NAME = "in.gov.eci.bloapp.languagetransliteration.PreferenceHelper";
    private static SharedPreferences preferences;

    public static void setBooleanPreference(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        preferences = sharedPreferences;
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(key, value);
        editorEdit.commit();
    }

    public static boolean getBooleanPreference(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        preferences = sharedPreferences;
        return sharedPreferences.getBoolean(key, false);
    }

    public static void clearAllPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        preferences = sharedPreferences;
        sharedPreferences.edit().clear().commit();
    }
}
