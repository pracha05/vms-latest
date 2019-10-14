package com.vms.customer.utils;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Bhupi on 19-Feb-19.
 */

public class HideKeyboard {
    public static void hideSoftKeyboard(Activity activity) {
            InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }
