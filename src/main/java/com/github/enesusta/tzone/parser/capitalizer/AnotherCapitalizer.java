package com.github.enesusta.tzone.parser.capitalizer;

public class AnotherCapitalizer implements Capitalizer {

    // [HAYAT, MAH, (ELVANPAZARCIK, KÖYÜ)]

    @Override
    public String capitalize(String cell) {
        final StringBuilder stringBuilder = new StringBuilder();
        boolean hasParenthesis = false;
        for (byte b : cell.getBytes()) if (b == 40) hasParenthesis = true;

        if (hasParenthesis) {
            String variable = removeParenthesis(cell);


        }

        return null;
    }

    public String removeParenthesis(String cell) {
        String res = cell.replaceAll("\\(", "");
        res = res.replaceAll("\\)", "");
        return res;
    }
}
