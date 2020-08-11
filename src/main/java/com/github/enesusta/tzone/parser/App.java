package com.github.enesusta.tzone.parser;

import com.github.enesusta.tzone.parser.cell.TemporaryCell;
import com.github.enesusta.tzone.parser.modal.County;
import com.github.enesusta.tzone.parser.modal.Province;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class App {

    public static void main(String[] args) {

        try (InputStream inputStream =
                 new FileInputStream("a.xlsx")) {

            XSSFWorkbook book = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = book.getSheetAt(0);

            Iterator<Row> itr = sheet.iterator();

            Cell temp = TemporaryCell.of();
            Cell provinceNameTemp = TemporaryCell.of();

            itr.next();

            Province province = new Province();
            province.setProvinceName("ADANA");

            while (itr.hasNext()) {

                Row row = itr.next();

                List<Cell> cells = StreamSupport
                    .stream(row.spliterator(), false)
                    .collect(Collectors.toList());


                if (!temp.getStringCellValue().equalsIgnoreCase(cells.get(1).getStringCellValue())) {
                    System.out.printf("Il %s : Ilce %s\n", cells.get(0), cells.get(1));
                    if (!provinceNameTemp.getStringCellValue().equalsIgnoreCase(cells.get(0).getStringCellValue())) {
                        province.setProvinceName(cells.get(0).getStringCellValue());
                    }
                }

                temp = cells.get(1);
                provinceNameTemp = cells.get(0);

                /**
                 if (!temp.getStringCellValue().equalsIgnoreCase(cells.get(2).getStringCellValue())) {
                 temp = cells.get(2);
                 System.out.printf("Il %s : Ilce %s : Belde %s\n", cells.get(0), cells.get(1), cells.get(2));
                 }*/


                /**               Iterator<Cell> cellIterator = row.cellIterator();
                 while (cellIterator.hasNext()) {

                 Cell cell = cellIterator.next();
                 System.out.println(cell.getStringCellValue());
                 }
                 */
                Thread.sleep(20);

            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
