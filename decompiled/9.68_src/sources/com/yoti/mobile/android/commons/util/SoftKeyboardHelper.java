package com.yoti.mobile.android.commons.util;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SoftKeyboardHelper {
    public static void forceDisplaySoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(2, 1);
        }
    }

    public static void hideSoftKeyboard(Activity activity, View view) {
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showSoftKeyboard(Activity activity, View view) {
        if (view.requestFocus()) {
            ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(view, 1);
        }
    }
}
