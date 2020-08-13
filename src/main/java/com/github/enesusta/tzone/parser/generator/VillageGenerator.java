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

public class VillageGenerator extends Generator {

    @Override
    public void generate() throws IOException {

        Cell town = TemporaryCell.of();

        try (PrintStream printStream =
                 new PrintStream(new FileOutputStream("village.txt"))) {

            for (Row row : parser.parse()) {

                List<Cell> cells = StreamSupport
                    .stream(row.spliterator(), false)
                    .collect(Collectors.toList());

                if (!town.getStringCellValue().equalsIgnoreCase(cells.get(3).getStringCellValue())) {
                    String provinceName = CellUtilityFactory.cellToString(cells.get(0));
                    String countyName = CellUtilityFactory.cellToString(cells.get(1));
                    String townName = CellUtilityFactory.cellToString(cells.get(2));
                    String villageName = CellUtilityFactory.cellToString(cells.get(3));
                    int zipCode = Integer.parseInt(cells.get(4).getStringCellValue());

                    printStream.printf("%s#%s#%s#%s#%d\n", provinceName, countyName, townName, villageName, zipCode);
                }

                town = cells.get(3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
