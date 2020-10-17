package com.github.enesusta.tzone.parser.capitalizer;

import com.github.enesusta.edevat.util.StringUtils;

public class DefaultCapitalizer implements Capitalizer {

    @Override
    public String capitalize(String cell) {
        final StringBuilder stringBuilder = new StringBuilder();
        boolean hasSpace = false;
        for (byte aByte : cell.getBytes()) if (aByte == 32) hasSpace = true;

        if (hasSpace) {
            String[] split = cell.split("\\s");
            for (String s : split) {
                stringBuilder.append(StringUtils.capitalizeWithTurkish(s));
                stringBuilder.append(' ');
            }
        } else {
            stringBuilder.append(cell);
        }

        return stringBuilder.toString();
    }
}
