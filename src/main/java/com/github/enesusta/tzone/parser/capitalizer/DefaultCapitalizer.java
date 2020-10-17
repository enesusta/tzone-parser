package com.github.enesusta.tzone.parser.capitalizer;

import com.github.enesusta.tzone.parser.util.StringUtils;


public class DefaultCapitalizer implements Capitalizer {

    @Override
    public String capitalize(String cell) {
        final StringBuilder stringBuilder = new StringBuilder();
        boolean hasSpace = false;
        for (byte aByte : cell.getBytes()) if (aByte == 32) hasSpace = true;

        if (hasSpace) {
            String res = removeParenthesis(cell);
            String[] split = res.split("\\s");
            for (String s : split) {
                if (s.equalsIgnoreCase("MAH")) {
                    String capitalized = StringUtils.capitalizeWithTurkish(s);
                    stringBuilder.append(capitalized);
                    stringBuilder.append("allesi");
                } else {
                    stringBuilder.append(StringUtils.capitalizeWithTurkish(s));
                }
                stringBuilder.append(' ');
            }
            stringBuilder.setCharAt(stringBuilder.length() - 1, '.');
        } else {
            stringBuilder.append(cell);
        }

        return stringBuilder.toString();
    }

    public String removeParenthesis(String cell) {
        String res = cell.replaceAll("\\(", "");
        res = res.replaceAll("\\)", "");
        return res;
    }
}
