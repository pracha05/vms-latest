package com.vms.customer.utils;

import android.content.Context;
import android.text.TextUtils;

import com.vms.customer.R;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * check is valid email
     *
     * @param email
     * @return boolean
     */
    public static boolean isValidEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String capitalize(String input, String splitter) {
        String[] tokens = input.split(splitter);
        input = "";

        for (int i = 0; i < tokens.length; i++) {
            char capLetter = Character.toUpperCase(tokens[i].charAt(0));
            input += " " + capLetter + tokens[i].substring(1, tokens[i].length());
        }

        return input.trim();
    }


    /**
     * <p>Case insensitive check if a String starts with a specified prefix.</p>
     * <p>
     * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
     * references are considered to be equal. The comparison is case insensitive.</p>
     * <p>
     * <pre>
     * StringUtils.startsWithIgnoreCase(null, null)      = true
     * StringUtils.startsWithIgnoreCase(null, "abcdef")  = false
     * StringUtils.startsWithIgnoreCase("abc", null)     = false
     * StringUtils.startsWithIgnoreCase("abc", "abcdef") = true
     * StringUtils.startsWithIgnoreCase("abc", "ABCDEF") = true
     * </pre>
     *
     * @param str    the String to check, may be null
     * @param prefix the prefix to find, may be null
     * @return <code>true</code> if the String starts with the prefix, case insensitive, or
     * both <code>null</code>
     * @see String#startsWith(String)
     * @since 2.4
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        return startsWith(str, prefix, true);
    }

    /**
     * <p>Check if a String starts with a specified prefix (optionally case insensitive).</p>
     *
     * @param str        the String to check, may be null
     * @param prefix     the prefix to find, may be null
     * @param ignoreCase inidicates whether the compare should ignore case
     *                   (case insensitive) or not.
     * @return <code>true</code> if the String starts with the prefix or
     * both <code>null</code>
     * @see String#startsWith(String)
     */
    private static boolean startsWith(String str, String prefix, boolean ignoreCase) {
        if (str == null || prefix == null) {
            return (str == null && prefix == null);
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return str.regionMatches(ignoreCase, 0, prefix, 0, prefix.length());
    }

    // Empty checks
    //-----------------------------------------------------------------------

    /**
     * <p>Checks if a String is empty ("") or null.</p>
     * <p>
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     * <p>
     * <p>NOTE: This method changed in Lang version 2.0.
     * It no longer trims the String.
     * That functionality is available in isBlank().</p>
     *
     * @param str the String to check, may be null
     * @return <code>true</code> if the String is empty or null
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String[] capitalize(String[] inputArray, String splitter) {
        String[] outputArray = new String[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            outputArray[i] = capitalize(inputArray[i], splitter);
        }
        return outputArray;
    }

    public static String[] capitalizeAndAppendAdditionalStrings(String[] inputArray, String splitter, String... toBeAppended) {
        String[] outputArray = new String[inputArray.length + toBeAppended.length];
        for (int i = 0; i < inputArray.length; i++) {
            outputArray[i] = capitalize(inputArray[i], splitter);
        }

        for (int i = 0; i < toBeAppended.length; i++) {
            outputArray[inputArray.length + i] = capitalize(toBeAppended[i], splitter);
        }

        return outputArray;
    }

    /**
     * Return abbrevaited form of supplied input string
     *
     * @param input
     * @return
     */
    public static String getAbbreviatedForm(String input, int maxLen) {

        StringBuilder builder = new StringBuilder();

        if (input == null || input.trim().length() == 0) {
            return builder.toString();
        }

        // Trim down unnecessary spaces and capitalize the string
        input = input.trim().toUpperCase(Locale.getDefault());

        // Split on space char.
        String[] r = input.split("\\s");
        for (String x : r) {
            builder.append(x.substring(0, 1));
            if (builder.length() == maxLen) break;
        }

        return builder.toString();

    }


    /**
     * get color on the basis of custom categorization of basis of
     * the first character of supplied input string.
     */
    public static int getColor(Context context, String input) {
        char a = Character.toUpperCase(input.toCharArray()[0]);

        if (a >= 'A' && a < 'G') {
            return context.getResources().getColor(R.color.cyan_blue);
        } else if (a >= 'G' && a < 'M') {
            return context.getResources().getColor(R.color.red_shade);
        } else if (a >= 'M' && a < 'S') {
            return context.getResources().getColor(R.color.orange_shade);
        } else {
            return context.getResources().getColor(R.color.green_shade);
        }
    }

    /**
     * Make first letter capital and other small.
     */
    public static String capitalizeFirstLatterOnly(String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1).toLowerCase();
    }

    /*
     * Remove the front and end double quote from the string
     * if present.
     */
    public static String removeQuotesIfPresent(String input) {
        if (isNotEmpty(input) && input.startsWith("\"") && input.endsWith("\"")) {
            input = input.substring(1, input.length() - 1);
        }
        return input;
    }

    /**
     * Add quotes to string if not already present.
     *
     * @param string
     * @return
     */
    public static String convertToQuotedString(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }

        final int lastPos = string.length() - 1;
        if (lastPos > 0
                && (string.charAt(0) == '"' && string.charAt(lastPos) == '"')) {
            return string;
        }

        return "\"" + string + "\"";
    }

    public static String convertStringArrayToString(String[] data) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            strBuilder.append(data[i]);
        }
        return strBuilder.toString();
    }

    public static boolean isWhiteSpaces(String s) {
        return s != null && s.matches("\\s+");
    }
}
