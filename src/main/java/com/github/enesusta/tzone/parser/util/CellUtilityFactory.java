package com.github.enesusta.tzone.parser.util;

import org.apache.poi.ss.usermodel.Cell;

public class CellUtilityFactory {

    public static String cellToString(Cell cell) {
        return StringUtils.capitalizeWithTurkish(cell.getStringCellValue().trim());
    }
}
