package com.github.enesusta.tzone.parser.generator;

import com.github.enesusta.tzone.parser.capitalizer.Capitalizer;
import com.github.enesusta.tzone.parser.cell.TemporaryCell;
import com.github.enesusta.tzone.parser.util.CellUtilityFactory;
import com.github.enesusta.tzone.parser.util.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class VillageGenerator extends Generator {

    private final Capitalizer capitalizer;

    public VillageGenerator(Capitalizer capitalizer) {
        this.capitalizer = capitalizer;
    }

    @Override
    public void generate() throws IOException {

        Cell town = TemporaryCell.of();

        try (PrintStream printStream =
                 new PrintStream(new FileOutputStream("village.txt"))) {

            Iterator<Row> iterator = parser.parse().iterator();
            iterator.next();

            while (iterator.hasNext()) {

                Row row = iterator.next();

                List<Cell> cells = StreamSupport
                    .stream(row.spliterator(), false)
                    .collect(Collectors.toList());

                if (!town.getStringCellValue().equalsIgnoreCase(cells.get(3).getStringCellValue())) {
                    String provinceName = CellUtilityFactory.cellToString(cells.get(0));
                    String countyName = CellUtilityFactory.cellToString(cells.get(1));
                    String townName = CellUtilityFactory.cellToString(cells.get(2));
                    //                   String villageName = CellUtilityFactory.cellToString(cells.get(3));
                   String villageName = capitalizer.capitalize(cells.get(3).getStringCellValue());

                    int zipCode = Integer.parseInt(cells.get(4).getStringCellValue());

                    System.out.println(row.getRowNum());
                    System.out.println("villageName = " + villageName);
 //                   System.out.println(cells.get(3).getStringCellValue());


                    printStream.printf("%s#%s#%s#%s#%d\n", provinceName, countyName, townName, null, 10);
                }

                town = cells.get(3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
