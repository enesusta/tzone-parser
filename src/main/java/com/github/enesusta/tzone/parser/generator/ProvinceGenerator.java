package com.github.enesusta.tzone.parser.generator;

import com.github.enesusta.tzone.parser.cell.TemporaryCell;
import com.github.enesusta.tzone.parser.modal.Province;
import com.github.enesusta.tzone.parser.util.CellUtilityFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProvinceGenerator extends Generator {

    @Override
    public void generate() throws IOException {

        List<Province> list = new ArrayList<>();

        Iterator<Row> iterator = parser.parse().iterator();

        Cell temp = TemporaryCell.of();
        Cell province = TemporaryCell.of();

        try (PrintStream printStream = new PrintStream(new FileOutputStream("city.txt"))) {

            while (iterator.hasNext()) {

                List<Cell> cells = StreamSupport
                    .stream(iterator.next().spliterator(), false)
                    .collect(Collectors.toList());

                if (!temp.getStringCellValue().equalsIgnoreCase(cells.get(1).getStringCellValue())) {
                    printStream.printf("%s#%s\n", CellUtilityFactory.cellToString(cells.get(0)), CellUtilityFactory.cellToString((cells.get(1))));
 //                   boolean provinceCondition = !province.getStringCellValue().equalsIgnoreCase(cells.get(0).getStringCellValue());
                }

                temp = cells.get(1);
                province = cells.get(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        objectMapper.writeValue(new File("province.json"), list);
    }
}
