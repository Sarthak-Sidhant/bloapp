package in.gov.eci.bloapp.languagetransliteration;

import android.R;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.TransliterationCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FormsMethod {
    static TransliterationCallback transliterationCallback;
    static ArrayList<String> drop = new ArrayList<>();
    static String english = "en_in";
    static String translationApi = "https://gateway-blo.eci.gov.in/CDAC-EnhanceTransliterationAPI/Transliteration.aspx?itext=";
    static String translation = "&transliteration=";
    static String locale = "&locale=";
    static String transrev = "&transRev=false";
    static String bangali = "bn_in";
    static String hindi = "hi_in";
    private static final String TAG = "FormsMethod";
    static String application = "application/x-www-form-urlencoded";
    static String errorMessage = "errorMessage";

    public static void translitration(String str, EditText editText, String str2, String str3) throws IOException {
        if (str.equals("") || str == null) {
            return;
        }
        if (str2.equals(english)) {
            editText.setText(str);
        } else {
            goToServer(translationApi + str.trim() + translation + str3 + locale + str2 + transrev, editText);
        }
    }

    public static void translitrationAutoCompleteTextView(Context context, String str, AutoCompleteTextView editText, String str2, String str3) {
        if (str.equals("") || str == null) {
            return;
        }
        if (str2.equals(english)) {
            editText.setText(str);
        } else {
            goToServer2(context, translationApi + str.trim() + translation + str3 + locale + str2 + transrev, editText);
        }
    }

    public static void translitrationForString(Context context, String code, String str, String str2, String str3, TransliterationCallback transliterationCallback2) {
        if (str.equals("") || str == null) {
            return;
        }
        goToServer1(context, code, translationApi + str.trim() + translation + str3 + locale + str2 + transrev, transliterationCallback2);
    }

    static void goToServer(String str, EditText editText) {
        translitration(str, editText);
    }

    static void goToServer2(Context context, String str, AutoCompleteTextView editText) {
        translitrationAutoCompleteTextView(context, str, editText);
    }

    static void goToServer1(Context context, String code, String str, TransliterationCallback transliterationCallback2) {
        translitrationForString(context, code, str, transliterationCallback2);
    }

    public static String getLocale(String str) {
        HashMap map = new HashMap();
        map.put("S01", "tl_in");
        map.put("S02", hindi);
        map.put("S03", "as_in");
        map.put("S04", hindi);
        map.put("S05", hindi);
        map.put("S06", "gj_in");
        map.put("S07", hindi);
        map.put("S08", hindi);
        map.put("S10", "kn_in");
        map.put("S11", "ml_in");
        map.put("S12", hindi);
        map.put("S13", "mr_in");
        map.put("S14", bangali);
        map.put("S15", hindi);
        map.put("S16", hindi);
        map.put("S17", english);
        map.put("S18", "or_in");
        map.put("S19", "pn_in");
        map.put("S20", hindi);
        map.put("S21", hindi);
        map.put("S22", "tm_in");
        map.put("S23", bangali);
        map.put("S24", hindi);
        map.put("S25", bangali);
        map.put("S26", hindi);
        map.put("S27", hindi);
        map.put("S28", hindi);
        map.put("S29", "tl_in");
        map.put("U01", hindi);
        map.put("U02", hindi);
        map.put("U03", hindi);
        map.put("U04", "gj_in");
        map.put("U05", hindi);
        map.put("U06", "ml_in");
        map.put("U07", "tm_in");
        map.put("U08", "ur_in");
        map.put("U09", "ur_in");
        return (String) map.get(str);
    }

    private static void translitration(String str, final EditText editText) {
        final ProgressDialog progressDialog = new ProgressDialog(editText.getContext());
        ((RestClient) ApiClient.getTransliterationClient().create(RestClient.class)).transliteration(str.replaceAll("\\s+", "%20"), application).enqueue(new Callback<String>() { // from class: in.gov.eci.bloapp.languagetransliteration.FormsMethod.1
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    if (response.body() != null) {
                        String str2 = (String) response.body();
                        try {
                            ProgressDialog progressDialog2 = progressDialog;
                            if (progressDialog2 != null && progressDialog2.isShowing()) {
                                progressDialog.dismiss();
                            }
                        } catch (Exception e) {
                            Logger.d("", e.getMessage());
                        }
                        if (str2 != null) {
                            try {
                                String str3 = "";
                                for (String str4 : str2.replace(RegexMatcher.JSON_STRING_REGEX, "").split("\\;")) {
                                    str3 = str3 + str4.split("\\^")[0] + StringUtils.SPACE;
                                }
                                EditText editText2 = editText;
                                if (editText2 != null) {
                                    editText2.setText(str3.trim().replace(RegexMatcher.JSON_STRING_REGEX, ""));
                                    return;
                                }
                                return;
                            } catch (Exception e2) {
                                Logger.d("", e2.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    Logger.e(FormsMethod.TAG, new JSONObject(response.errorBody().string()).optString(FormsMethod.errorMessage));
                } catch (IOException | JSONException e3) {
                    Logger.d("", e3.getMessage());
                }
            }

            public void onFailure(Call<String> call, Throwable t) {
                Logger.d("", t.getMessage());
            }
        });
    }

    private static void translitrationAutoCompleteTextView(final Context context, String str, final AutoCompleteTextView editText) {
        final ProgressDialog progressDialog = new ProgressDialog(editText.getContext());
        ((RestClient) ApiClient.getTransliterationClient().create(RestClient.class)).transliteration(str.replaceAll("\\s+", "%20"), application).enqueue(new Callback<String>() { // from class: in.gov.eci.bloapp.languagetransliteration.FormsMethod.2
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    if (response.body() != null) {
                        String str2 = (String) response.body();
                        try {
                            ProgressDialog progressDialog2 = progressDialog;
                            if (progressDialog2 != null && progressDialog2.isShowing()) {
                                progressDialog.dismiss();
                            }
                        } catch (Exception e) {
                            Logger.d("", e.getMessage());
                        }
                        if (str2 != null) {
                            try {
                                String[] strArrSplit = str2.replace(RegexMatcher.JSON_STRING_REGEX, "").split("\\;");
                                ArrayList[] arrayListArr = new ArrayList[strArrSplit.length];
                                for (int i = 0; i < strArrSplit.length; i++) {
                                    arrayListArr[i] = new ArrayList();
                                    for (String str3 : strArrSplit[i].split("\\^")) {
                                        arrayListArr[i].add(str3);
                                    }
                                }
                                FormsMethod.drop.clear();
                                FormsMethod.combinations(arrayListArr, 0, 0, "");
                                editText.setAdapter(new ArrayAdapter(context, R.layout.simple_spinner_dropdown_item, FormsMethod.drop));
                                editText.setThreshold(-1);
                                editText.showDropDown();
                                return;
                            } catch (Exception e2) {
                                Logger.d("", e2.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    Logger.e(FormsMethod.TAG, new JSONObject(response.errorBody().string()).optString(FormsMethod.errorMessage));
                } catch (IOException | JSONException e3) {
                    Logger.d("", e3.getMessage());
                }
            }

            public void onFailure(Call<String> call, Throwable t) {
                Logger.d("", t.getMessage());
            }
        });
    }

    private static void translitrationForString(final Context context, final String code, String str, final TransliterationCallback transliterationCallback2) {
        transliterationCallback = transliterationCallback2;
        ((RestClient) ApiClient.getTransliterationClient().create(RestClient.class)).transliteration(str.replaceAll("\\s+", "%20"), application).enqueue(new Callback<String>() { // from class: in.gov.eci.bloapp.languagetransliteration.FormsMethod.3
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    if (response.body() != null) {
                        String str2 = (String) response.body();
                        if (str2 != null) {
                            try {
                                String str3 = "";
                                for (String str4 : str2.split("\\;")) {
                                    str3 = str3 + str4.split("\\^")[0] + StringUtils.SPACE;
                                    if (code.equals("assembly")) {
                                        SharedPref.getInstance(context).setRegionalAssemblyName(str3.replace(RegexMatcher.JSON_STRING_REGEX, ""));
                                    } else if (code.equals("state")) {
                                        SharedPref.getInstance(context).setRegionalStateName(str3.replace(RegexMatcher.JSON_STRING_REGEX, ""));
                                    } else if (code.equals("district")) {
                                        SharedPref.getInstance(context).setRegionalDistrictName(str3.replace(RegexMatcher.JSON_STRING_REGEX, ""));
                                    } else if (code.equals("currentDistrict")) {
                                        SharedPref.getInstance(context).setRegionalDistrictName(str3.replace(RegexMatcher.JSON_STRING_REGEX, ""));
                                    }
                                }
                                transliterationCallback2.onSuccessCallBack("Translated");
                                return;
                            } catch (Exception e) {
                                Logger.d("", e.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    transliterationCallback2.onSuccessCallBack("NotTranslated");
                    Logger.e(FormsMethod.TAG, new JSONObject(response.errorBody().string()).optString(FormsMethod.errorMessage));
                } catch (IOException | JSONException e2) {
                    Logger.d("", e2.getMessage());
                }
            }

            public void onFailure(Call<String> call, Throwable t) {
                try {
                    transliterationCallback2.onSuccessCallBack("NotTranslated");
                } catch (IOException e) {
                    Logger.d("", e.getMessage());
                }
            }
        });
    }

    public static void combinations(ArrayList<String>[] combList, int listIndex, int itemIndex, String result) {
        if (listIndex < combList.length) {
            if (itemIndex < combList[listIndex].size()) {
                combinations(combList, listIndex + 1, 0, result + combList[listIndex].get(itemIndex) + StringUtils.SPACE);
                combinations(combList, listIndex, itemIndex + 1, result);
                return;
            } else {
                if (combList[listIndex].isEmpty()) {
                    combinations(combList, listIndex + 1, 0, result);
                    return;
                }
                return;
            }
        }
        drop.add(result);
    }
}
