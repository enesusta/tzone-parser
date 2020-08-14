package com.github.enesusta.tzone.parser.generator;

import com.github.enesusta.tzone.parser.cell.TemporaryCell;
import com.github.enesusta.tzone.parser.util.CellUtilityFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CountyGenerator extends Generator {

    @Override
    public void generate() throws IOException {

        Iterator<Row> iterator = parser.parse().iterator();
        Cell county = TemporaryCell.of();

        try (PrintStream printStream =
                 new PrintStream(new FileOutputStream("county.txt"))) {

            while (iterator.hasNext()) {

                List<Cell> cells = StreamSupport
                    .stream(iterator.next().spliterator(), false)
                    .collect(Collectors.toList());

                if (!county.getStringCellValue().equalsIgnoreCase(cells.get(1).getStringCellValue())) {
                    String provinceName = CellUtilityFactory.cellToString(cells.get(0));
                    String countyName = CellUtilityFactory.cellToString(cells.get(1));
                    printStream.printf("%s#%s\n", provinceName, countyName);
                }

                county = cells.get(1);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
