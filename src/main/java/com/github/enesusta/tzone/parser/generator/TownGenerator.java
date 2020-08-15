package com.github.enesusta.tzone.parser.generator;

import com.github.enesusta.tzone.parser.cell.TemporaryCell;
import com.github.enesusta.tzone.parser.util.CellUtilityFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TownGenerator extends Generator {

    @Override
    public void generate() throws IOException {

        Cell province = TemporaryCell.of();

        try (PrintStream printStream = new PrintStream(new FileOutputStream("towns.txt"))) {

            for (Row row : parser.parse()) {

                List<Cell> cells = StreamSupport
                    .stream(row.spliterator(), false)
                    .collect(Collectors.toList());

                if (!province.getStringCellValue().equalsIgnoreCase(cells.get(2).getStringCellValue())) {
                    String provinceName = CellUtilityFactory.cellToString(cells.get(0));
                    String countyName = CellUtilityFactory.cellToString(cells.get(1));
                    String townName = CellUtilityFactory.cellToString(cells.get(2));

                   printStream.printf("%s#%s#%s\n", provinceName, countyName, townName);
                }

                province = cells.get(2);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
