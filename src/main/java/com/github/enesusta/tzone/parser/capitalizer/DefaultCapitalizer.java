package com.github.enesusta.tzone.parser.capitalizer;

import com.github.enesusta.tzone.parser.util.StringUtils;

import java.util.Arrays;

public class DefaultCapitalizer implements Capitalizer {

    @Override
    public String capitalize(String cell) {
        final StringBuilder stringBuilder = new StringBuilder();
        boolean hasSpace = false;
        boolean hasParenthesis = false;
        boolean hasDot = true;
        for (byte aByte : cell.getBytes()) if (aByte == 32) hasSpace = true;
        for (byte b : cell.getBytes()) if (b == 40) hasParenthesis = true;

        if (hasSpace) {
            String res = removeParenthesis(cell);
            String[] split = res.split("\\s");
            for (String s : split) {
                if (s.equalsIgnoreCase("MAH")) {
                    hasDot = false;
                    String capitalized = StringUtils.capitalizeWithTurkish(s);
                    stringBuilder.append(capitalized);
                    stringBuilder.append('.');
                } else {
                    stringBuilder.append(StringUtils.capitalizeWithTurkish(s));
                }
                stringBuilder.append(' ');
            }
            if (hasDot)
                stringBuilder.setCharAt(stringBuilder.length() - 1, '.');
        } else {
            stringBuilder.append(cell);
        }

        //  System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public String removeParenthesis(String cell) {
        String res = cell.replaceAll("\\(", "");
        res = res.replaceAll("\\)", "");
        return res;
    }
}
