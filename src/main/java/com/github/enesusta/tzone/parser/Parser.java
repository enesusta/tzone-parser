package com.github.enesusta.tzone.parser;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Parser {

    public List<Row> parse() {

        List<Row> list = null;

        try (InputStream inputStream = new FileInputStream("a.xlsx")) {

            final XSSFWorkbook book = new XSSFWorkbook(inputStream);
            final XSSFSheet sheet = book.getSheetAt(0);

            list = StreamSupport
                .stream(sheet.spliterator(), false)
                .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
