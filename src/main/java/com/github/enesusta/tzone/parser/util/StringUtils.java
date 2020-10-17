package com.github.enesusta.tzone.parser.util;

import java.util.Locale;

public class StringUtils {
    private static final Locale LOCALE = Locale.forLanguageTag("tr-TR");

    public static String capitalizeWithTurkish(String string) {
        if (string.length() == 1 || string.isBlank() || string.isEmpty()) return string;

        final StringBuilder stringBuilder = new StringBuilder();
        String temp = string.toLowerCase(LOCALE);
        String first = temp.substring(0, 1).toUpperCase(LOCALE);
        stringBuilder.append(first).append(temp.substring(1));
        return stringBuilder.toString();
    }

}
